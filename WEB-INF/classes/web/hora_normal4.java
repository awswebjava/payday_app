package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hora_normal4 extends GXProcedure
{
   public hora_normal4( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hora_normal4.class ), "" );
   }

   public hora_normal4( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 )
   {
      hora_normal4.this.aP16 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        java.math.BigDecimal aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String aP12 ,
                        java.math.BigDecimal[] aP13 ,
                        byte[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             java.math.BigDecimal[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      hora_normal4.this.AV21CliCod = aP0;
      hora_normal4.this.AV39EmpCod = aP1;
      hora_normal4.this.AV59LiqNro = aP2;
      hora_normal4.this.AV88LiqRelNro = aP3;
      hora_normal4.this.AV64PaiCod = aP4;
      hora_normal4.this.AV54LegNumero = aP5;
      hora_normal4.this.AV60LiqPeriodo = aP6;
      hora_normal4.this.AV52LegClase = aP7;
      hora_normal4.this.AV90tipo_tarifa = aP8;
      hora_normal4.this.AV9AgeCanti = aP9;
      hora_normal4.this.AV67ProcesoLiquidacion = aP10;
      hora_normal4.this.AV84llamador = aP11;
      hora_normal4.this.AV74TLiqCod = aP12;
      hora_normal4.this.aP13 = aP13;
      hora_normal4.this.aP14 = aP14;
      hora_normal4.this.aP15 = aP15;
      hora_normal4.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV55LiqDCalculado = (byte)(1) ;
      if ( ! (0==AV59LiqNro) )
      {
         AV85palabra = "[hora_normal]" ;
         GXv_char1[0] = AV86LiqDOpeLog ;
         GXv_decimal2[0] = AV87LiqdOpeRes ;
         GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean4[0] = AV45existe ;
         new web.getliquidacioncalculo(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV54LegNumero, AV85palabra, GXv_char1, GXv_decimal2, GXv_decimal3, GXv_boolean4) ;
         hora_normal4.this.AV86LiqDOpeLog = GXv_char1[0] ;
         hora_normal4.this.AV87LiqdOpeRes = GXv_decimal2[0] ;
         hora_normal4.this.AV45existe = GXv_boolean4[0] ;
         if ( AV45existe )
         {
            AV51Importes = AV87LiqdOpeRes ;
            AV58LiqDLog = AV86LiqDOpeLog ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV81desde_LiqPeriodo = localUtil.ymdtod( GXutil.year( AV60LiqPeriodo), 1, 1) ;
      GXv_char1[0] = AV83ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV21CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      hora_normal4.this.AV83ParmValue = GXv_char1[0] ;
      AV82proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV83ParmValue, ".") ;
      if ( ! (0==AV59LiqNro) )
      {
         GXv_decimal3[0] = AV15baseDeCalculoImportes ;
         GXv_decimal2[0] = AV49horasBasicasLiquidacion ;
         GXv_int5[0] = AV13auxLiqDCalculado ;
         GXv_char1[0] = AV12auxError ;
         GXv_char6[0] = AV14auxLiqDLog ;
         new web.base_calculo_pres_ant(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV88LiqRelNro, AV54LegNumero, AV60LiqPeriodo, AV90tipo_tarifa, httpContext.getMessage( "HORAS EXTRAS", ""), AV84llamador, AV81desde_LiqPeriodo, AV82proporcionHabitualPorUnaje, AV67ProcesoLiquidacion, GXv_decimal3, GXv_decimal2, GXv_int5, GXv_char1, GXv_char6) ;
         hora_normal4.this.AV15baseDeCalculoImportes = GXv_decimal3[0] ;
         hora_normal4.this.AV49horasBasicasLiquidacion = GXv_decimal2[0] ;
         hora_normal4.this.AV13auxLiqDCalculado = GXv_int5[0] ;
         hora_normal4.this.AV12auxError = GXv_char1[0] ;
         hora_normal4.this.AV14auxLiqDLog = GXv_char6[0] ;
         if ( AV13auxLiqDCalculado == 0 )
         {
            AV55LiqDCalculado = (byte)(0) ;
            AV44error = AV12auxError ;
            AV58LiqDLog = AV44error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV58LiqDLog += AV14auxLiqDLog ;
      }
      else
      {
         AV93GXLvl31 = (byte)(0) ;
         /* Using cursor P01NR2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV21CliCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1622ConBaseHorExt = P01NR2_A1622ConBaseHorExt[0] ;
            A159ConVariable = P01NR2_A159ConVariable[0] ;
            A3CliCod = P01NR2_A3CliCod[0] ;
            A26ConCodigo = P01NR2_A26ConCodigo[0] ;
            AV93GXLvl31 = (byte)(1) ;
            AV10agregar = false ;
            if ( A1622ConBaseHorExt == 1 )
            {
               AV10agregar = true ;
            }
            else
            {
               if ( ( A1622ConBaseHorExt == 4 ) && ( AV46habitualEs ) )
               {
                  AV10agregar = true ;
               }
               else
               {
                  if ( ( A1622ConBaseHorExt == 2 ) && ( GXutil.strcmp(AV90tipo_tarifa, "H") == 0 ) )
                  {
                     AV10agregar = true ;
                  }
                  else
                  {
                     if ( ( A1622ConBaseHorExt == 3 ) && ( GXutil.strcmp(AV90tipo_tarifa, "P") == 0 ) )
                     {
                        AV10agregar = true ;
                     }
                     else
                     {
                        if ( ( A1622ConBaseHorExt == 5 ) && ( GXutil.strcmp(AV90tipo_tarifa, "H") == 0 ) && ( AV46habitualEs ) )
                        {
                           AV10agregar = true ;
                        }
                        else
                        {
                           if ( ( A1622ConBaseHorExt == 6 ) && ( GXutil.strcmp(AV90tipo_tarifa, "P") == 0 ) && ( AV46habitualEs ) )
                           {
                              AV10agregar = true ;
                           }
                        }
                     }
                  }
               }
            }
            if ( AV10agregar )
            {
               AV25ConCodigo = A26ConCodigo ;
               /* Execute user subroutine: 'PROCESAR CONCEPTO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV93GXLvl31 == 0 )
         {
            AV58LiqDLog += httpContext.getMessage( " (No existen conceptos variables para base de cálculo de hora extra)", "") ;
         }
      }
      GXv_char6[0] = AV53LegConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV54LegNumero, GXv_char6) ;
      hora_normal4.this.AV53LegConveCodigo = GXv_char6[0] ;
      GXv_int7[0] = AV19CantProm1 ;
      GXv_int8[0] = AV20CantProm2 ;
      GXv_char6[0] = AV38duracionProm ;
      GXv_objcol_Sdtbase_promedio_base_promedioItem9[0] = AV79base_promedio ;
      new web.getcantmesesodiaspromediar(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV54LegNumero, AV52LegClase, "horaNormal", "", "", GXv_int7, GXv_int8, GXv_char6, GXv_objcol_Sdtbase_promedio_base_promedioItem9) ;
      hora_normal4.this.AV19CantProm1 = GXv_int7[0] ;
      hora_normal4.this.AV20CantProm2 = GXv_int8[0] ;
      hora_normal4.this.AV38duracionProm = GXv_char6[0] ;
      AV79base_promedio = GXv_objcol_Sdtbase_promedio_base_promedioItem9[0] ;
      if ( (0==AV20CantProm2) )
      {
         if ( ! (0==AV19CantProm1) )
         {
            AV66posibilidades = (short)(1) ;
         }
      }
      else
      {
         if ( ! (0==AV19CantProm1) )
         {
            AV66posibilidades = (short)(2) ;
         }
      }
      if ( AV66posibilidades > 0 )
      {
         GXt_char10 = AV61mensualTLiqCod ;
         GXt_char11 = AV61mensualTLiqCod ;
         GXv_char6[0] = GXt_char11 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         hora_normal4.this.GXt_char11 = GXv_char6[0] ;
         GXv_char1[0] = GXt_char10 ;
         new web.getparametro(remoteHandle, context).execute( AV21CliCod, GXt_char11, GXv_char1) ;
         hora_normal4.this.GXt_char10 = GXv_char1[0] ;
         AV61mensualTLiqCod = GXt_char10 ;
         GXv_int8[0] = AV8diasMes ;
         new web.diasmes(remoteHandle, context).execute( AV21CliCod, AV60LiqPeriodo, GXv_int8) ;
         hora_normal4.this.AV8diasMes = (byte)((byte)(GXv_int8[0])) ;
         if ( GXutil.strcmp(AV90tipo_tarifa, "H") == 0 )
         {
            GXv_decimal3[0] = AV17cantHorasDia ;
            new web.gethorasdiaparavacacionesjornal(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV54LegNumero, DecimalUtil.doubleToDec(0), GXv_decimal3) ;
            hora_normal4.this.AV17cantHorasDia = GXv_decimal3[0] ;
         }
         GXv_decimal3[0] = AV80auxLiqDImpCalcu ;
         GXv_char6[0] = AV14auxLiqDLog ;
         GXv_char1[0] = AV12auxError ;
         new web.recorrerpromedios(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV88LiqRelNro, AV54LegNumero, AV60LiqPeriodo, "horaNormal", AV74TLiqCod, AV61mensualTLiqCod, AV52LegClase, AV90tipo_tarifa, AV66posibilidades, AV19CantProm1, AV20CantProm2, AV38duracionProm, AV8diasMes, AV17cantHorasDia, true, GXv_decimal3, GXv_char6, GXv_char1) ;
         hora_normal4.this.AV80auxLiqDImpCalcu = GXv_decimal3[0] ;
         hora_normal4.this.AV14auxLiqDLog = GXv_char6[0] ;
         hora_normal4.this.AV12auxError = GXv_char1[0] ;
         if ( ! (GXutil.strcmp("", AV12auxError)==0) )
         {
            AV55LiqDCalculado = (byte)(0) ;
            AV44error = GXutil.trim( AV12auxError) ;
            AV58LiqDLog = GXutil.trim( AV44error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV15baseDeCalculoImportes = AV15baseDeCalculoImportes.add(AV80auxLiqDImpCalcu) ;
         AV58LiqDLog += AV14auxLiqDLog ;
      }
      if ( ( AV52LegClase == 1 ) && ( GXutil.strcmp(AV90tipo_tarifa, "P") == 0 ) )
      {
         GXv_decimal3[0] = AV62mesCantHoras ;
         GXv_char6[0] = AV14auxLiqDLog ;
         GXv_char1[0] = AV12auxError ;
         new web.horasmes(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV54LegNumero, AV60LiqPeriodo, GXv_decimal3, GXv_char6, GXv_char1) ;
         hora_normal4.this.AV62mesCantHoras = GXv_decimal3[0] ;
         hora_normal4.this.AV14auxLiqDLog = GXv_char6[0] ;
         hora_normal4.this.AV12auxError = GXv_char1[0] ;
         if ( ! (GXutil.strcmp("", AV12auxError)==0) )
         {
            AV44error = AV12auxError ;
            AV58LiqDLog = AV44error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV58LiqDLog += ". " + AV14auxLiqDLog ;
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62mesCantHoras)==0) )
         {
            AV44error = httpContext.getMessage( "No se pudo calcular horas del mes", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "&error ", "")+AV44error) ;
            AV55LiqDCalculado = (byte)(0) ;
            AV58LiqDLog += ". " + GXutil.trim( AV44error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV51Importes = AV15baseDeCalculoImportes.divide(AV62mesCantHoras, 18, java.math.RoundingMode.DOWN) ;
            AV58LiqDLog += httpContext.getMessage( ". Se divide ", "") + GXutil.trim( GXutil.str( AV15baseDeCalculoImportes, 14, 2)) + httpContext.getMessage( " entre ", "") + GXutil.trim( GXutil.str( AV62mesCantHoras, 5, 1)) + httpContext.getMessage( " horas", "") ;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "horasbasicas ", "")+GXutil.trim( GXutil.str( AV49horasBasicasLiquidacion, 9, 2))) ;
         if ( AV49horasBasicasLiquidacion.doubleValue() == 0 )
         {
            AV44error = httpContext.getMessage( "No se pudo calcular horas básicas", "") ;
            AV55LiqDCalculado = (byte)(0) ;
            AV58LiqDLog += ". " + GXutil.trim( AV44error) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "&error ", "")+AV44error+httpContext.getMessage( " &LiqDLog ", "")+AV58LiqDLog) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV51Importes = AV15baseDeCalculoImportes.divide(AV49horasBasicasLiquidacion, 18, java.math.RoundingMode.DOWN) ;
            AV58LiqDLog += httpContext.getMessage( ". Se divide ", "") + GXutil.trim( GXutil.str( AV15baseDeCalculoImportes, 14, 2)) + httpContext.getMessage( " entre ", "") + GXutil.trim( GXutil.str( AV49horasBasicasLiquidacion, 9, 2)) + httpContext.getMessage( " horas", "") ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "&LiqDLog! ", "")+GXutil.trim( AV58LiqDLog)+httpContext.getMessage( " importes ", "")+GXutil.trim( GXutil.str( AV51Importes, 14, 2))) ;
      if ( ! (0==AV59LiqNro) )
      {
         new web.newliquidacioncalculo(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV54LegNumero, AV85palabra, AV58LiqDLog, AV51Importes, DecimalUtil.doubleToDec(0)) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'PROCESAR CONCEPTO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "procesando concepto ", "")+GXutil.trim( AV25ConCodigo)) ;
      GXv_decimal3[0] = AV15baseDeCalculoImportes ;
      GXv_char6[0] = AV58LiqDLog ;
      GXv_decimal2[0] = AV9AgeCanti ;
      GXv_char1[0] = AV12auxError ;
      GXv_int5[0] = AV13auxLiqDCalculado ;
      GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
      new web.previsualizarconceptopararemulicferhor(remoteHandle, context).execute( AV21CliCod, AV39EmpCod, AV59LiqNro, AV54LegNumero, AV25ConCodigo, AV60LiqPeriodo, AV90tipo_tarifa, AV67ProcesoLiquidacion, true, GXv_decimal3, GXv_char6, GXv_decimal2, GXv_char1, GXv_int5, GXv_decimal12, GXv_decimal13) ;
      hora_normal4.this.AV15baseDeCalculoImportes = GXv_decimal3[0] ;
      hora_normal4.this.AV58LiqDLog = GXv_char6[0] ;
      hora_normal4.this.AV9AgeCanti = GXv_decimal2[0] ;
      hora_normal4.this.AV12auxError = GXv_char1[0] ;
      hora_normal4.this.AV13auxLiqDCalculado = GXv_int5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "&auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV13auxLiqDCalculado, 1, 0))) ;
      if ( AV13auxLiqDCalculado == 0 )
      {
         AV55LiqDCalculado = (byte)(0) ;
         AV44error = AV12auxError ;
         AV58LiqDLog = AV44error ;
         returnInSub = true;
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "&AgeCanti ", "")+GXutil.trim( GXutil.str( AV9AgeCanti, 9, 2))+httpContext.getMessage( " &ConCodigo ", "")+AV25ConCodigo+httpContext.getMessage( " &baseDeCalculoImportes ", "")+GXutil.trim( GXutil.str( AV15baseDeCalculoImportes, 14, 2))) ;
      if ( ( GXutil.strcmp(AV90tipo_tarifa, "H") == 0 ) && ( GXutil.strcmp(AV25ConCodigo, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV21CliCod, AV39EmpCod, AV54LegNumero)) == 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV49horasBasicasLiquidacion = AV9AgeCanti ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV94Pgmname, httpContext.getMessage( "asigna", "")) ;
      }
   }

   public void S121( )
   {
      /* 'DESDE HASTA' Routine */
      returnInSub = false ;
      AV71resta = (short)(AV18cantidad*-1) ;
      if ( GXutil.strcmp(AV37duracion_tipo, "meses") == 0 )
      {
         AV47hastaFecha = GXutil.addmth( AV60LiqPeriodo, (short)(-1)) ;
         AV35desdeFecha = GXutil.addmth( AV47hastaFecha, AV71resta) ;
      }
      else
      {
         AV47hastaFecha = GXutil.dadd( AV60LiqPeriodo, (-1)) ;
         AV35desdeFecha = GXutil.dadd( AV47hastaFecha, (AV71resta)) ;
      }
   }

   protected void cleanup( )
   {
      this.aP13[0] = hora_normal4.this.AV51Importes;
      this.aP14[0] = hora_normal4.this.AV55LiqDCalculado;
      this.aP15[0] = hora_normal4.this.AV44error;
      this.aP16[0] = hora_normal4.this.AV58LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV51Importes = DecimalUtil.ZERO ;
      AV44error = "" ;
      AV58LiqDLog = "" ;
      AV85palabra = "" ;
      AV86LiqDOpeLog = "" ;
      AV87LiqdOpeRes = DecimalUtil.ZERO ;
      GXv_boolean4 = new boolean[1] ;
      AV81desde_LiqPeriodo = GXutil.nullDate() ;
      AV83ParmValue = "" ;
      AV82proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      AV15baseDeCalculoImportes = DecimalUtil.ZERO ;
      AV49horasBasicasLiquidacion = DecimalUtil.ZERO ;
      AV12auxError = "" ;
      AV14auxLiqDLog = "" ;
      scmdbuf = "" ;
      P01NR2_A1622ConBaseHorExt = new byte[1] ;
      P01NR2_A159ConVariable = new boolean[] {false} ;
      P01NR2_A3CliCod = new int[1] ;
      P01NR2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      AV25ConCodigo = "" ;
      AV53LegConveCodigo = "" ;
      GXv_int7 = new short[1] ;
      AV38duracionProm = "" ;
      AV79base_promedio = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>(web.Sdtbase_promedio_base_promedioItem.class, "base_promedioItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtbase_promedio_base_promedioItem9 = new GXBaseCollection[1] ;
      AV61mensualTLiqCod = "" ;
      GXt_char10 = "" ;
      GXt_char11 = "" ;
      GXv_int8 = new short[1] ;
      AV17cantHorasDia = DecimalUtil.ZERO ;
      AV80auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV62mesCantHoras = DecimalUtil.ZERO ;
      AV94Pgmname = "" ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_char6 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_char1 = new String[1] ;
      GXv_int5 = new byte[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      AV37duracion_tipo = "" ;
      AV47hastaFecha = GXutil.nullDate() ;
      AV35desdeFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hora_normal4__default(),
         new Object[] {
             new Object[] {
            P01NR2_A1622ConBaseHorExt, P01NR2_A159ConVariable, P01NR2_A3CliCod, P01NR2_A26ConCodigo
            }
         }
      );
      AV94Pgmname = "hora_normal4" ;
      /* GeneXus formulas. */
      AV94Pgmname = "hora_normal4" ;
      Gx_err = (short)(0) ;
   }

   private byte AV52LegClase ;
   private byte AV55LiqDCalculado ;
   private byte AV13auxLiqDCalculado ;
   private byte AV93GXLvl31 ;
   private byte A1622ConBaseHorExt ;
   private byte AV8diasMes ;
   private byte GXv_int5[] ;
   private short AV39EmpCod ;
   private short AV64PaiCod ;
   private short AV19CantProm1 ;
   private short GXv_int7[] ;
   private short AV20CantProm2 ;
   private short AV66posibilidades ;
   private short GXv_int8[] ;
   private short AV71resta ;
   private short AV18cantidad ;
   private short Gx_err ;
   private int AV21CliCod ;
   private int AV59LiqNro ;
   private int AV88LiqRelNro ;
   private int AV54LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV9AgeCanti ;
   private java.math.BigDecimal AV51Importes ;
   private java.math.BigDecimal AV87LiqdOpeRes ;
   private java.math.BigDecimal AV82proporcionHabitualPorUnaje ;
   private java.math.BigDecimal AV15baseDeCalculoImportes ;
   private java.math.BigDecimal AV49horasBasicasLiquidacion ;
   private java.math.BigDecimal AV17cantHorasDia ;
   private java.math.BigDecimal AV80auxLiqDImpCalcu ;
   private java.math.BigDecimal AV62mesCantHoras ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String AV90tipo_tarifa ;
   private String AV67ProcesoLiquidacion ;
   private String AV84llamador ;
   private String AV74TLiqCod ;
   private String AV85palabra ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV25ConCodigo ;
   private String AV53LegConveCodigo ;
   private String AV38duracionProm ;
   private String AV61mensualTLiqCod ;
   private String GXt_char10 ;
   private String GXt_char11 ;
   private String AV94Pgmname ;
   private String GXv_char6[] ;
   private String GXv_char1[] ;
   private String AV37duracion_tipo ;
   private java.util.Date AV60LiqPeriodo ;
   private java.util.Date AV81desde_LiqPeriodo ;
   private java.util.Date AV47hastaFecha ;
   private java.util.Date AV35desdeFecha ;
   private boolean AV45existe ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A159ConVariable ;
   private boolean AV10agregar ;
   private boolean AV46habitualEs ;
   private boolean Cond_result ;
   private String AV58LiqDLog ;
   private String AV86LiqDOpeLog ;
   private String AV83ParmValue ;
   private String AV14auxLiqDLog ;
   private String AV44error ;
   private String AV12auxError ;
   private String[] aP16 ;
   private java.math.BigDecimal[] aP13 ;
   private byte[] aP14 ;
   private String[] aP15 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01NR2_A1622ConBaseHorExt ;
   private boolean[] P01NR2_A159ConVariable ;
   private int[] P01NR2_A3CliCod ;
   private String[] P01NR2_A26ConCodigo ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> AV79base_promedio ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> GXv_objcol_Sdtbase_promedio_base_promedioItem9[] ;
}

final  class hora_normal4__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NR2", "SELECT ConBaseHorExt, ConVariable, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (ConBaseHorExt > 0) AND (ConVariable = FALSE) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

