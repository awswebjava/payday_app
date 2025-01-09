package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recorrerpromedios extends GXProcedure
{
   public recorrerpromedios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recorrerpromedios.class ), "" );
   }

   public recorrerpromedios( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             byte aP9 ,
                             String aP10 ,
                             short aP11 ,
                             short aP12 ,
                             short aP13 ,
                             String aP14 ,
                             byte aP15 ,
                             java.math.BigDecimal aP16 ,
                             boolean aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 )
   {
      recorrerpromedios.this.aP20 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
      return aP20[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        byte aP9 ,
                        String aP10 ,
                        short aP11 ,
                        short aP12 ,
                        short aP13 ,
                        String aP14 ,
                        byte aP15 ,
                        java.math.BigDecimal aP16 ,
                        boolean aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        String[] aP19 ,
                        String[] aP20 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             byte aP9 ,
                             String aP10 ,
                             short aP11 ,
                             short aP12 ,
                             short aP13 ,
                             String aP14 ,
                             byte aP15 ,
                             java.math.BigDecimal aP16 ,
                             boolean aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 ,
                             String[] aP20 )
   {
      recorrerpromedios.this.AV28CliCod = aP0;
      recorrerpromedios.this.AV29EmpCod = aP1;
      recorrerpromedios.this.AV82LiqNro = aP2;
      recorrerpromedios.this.AV94LiqRelNro = aP3;
      recorrerpromedios.this.AV30LegNumero = aP4;
      recorrerpromedios.this.AV9LiqPeriodo = aP5;
      recorrerpromedios.this.AV35EmpBaseTipo = aP6;
      recorrerpromedios.this.AV10TLiqCod = aP7;
      recorrerpromedios.this.AV11mensualTLiqCod = aP8;
      recorrerpromedios.this.AV12LegClase = aP9;
      recorrerpromedios.this.AV99tipo_tarifa = aP10;
      recorrerpromedios.this.AV14posibilidades = aP11;
      recorrerpromedios.this.AV52CantProm1 = aP12;
      recorrerpromedios.this.AV51CantProm2 = aP13;
      recorrerpromedios.this.AV18duracionProm = aP14;
      recorrerpromedios.this.AV46diasMes = aP15;
      recorrerpromedios.this.AV74horasDia = aP16;
      recorrerpromedios.this.AV96remuneradoEs = aP17;
      recorrerpromedios.this.aP18 = aP18;
      recorrerpromedios.this.aP19 = aP19;
      recorrerpromedios.this.aP20 = aP20;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "1 &posibilidades ", "")+GXutil.trim( GXutil.str( AV14posibilidades, 4, 0))+httpContext.getMessage( " &EmpBaseTipo ", "")+GXutil.trim( AV35EmpBaseTipo)+httpContext.getMessage( " &LegClase ", "")+GXutil.trim( GXutil.str( AV12LegClase, 1, 0))) ;
      GXv_char1[0] = AV64EmpPromDesde ;
      new web.getemppromdesde(remoteHandle, context).execute( AV28CliCod, AV29EmpCod, GXv_char1) ;
      recorrerpromedios.this.AV64EmpPromDesde = GXv_char1[0] ;
      if ( GXutil.strcmp(AV64EmpPromDesde, "anterior") == 0 )
      {
         AV8hasta_LiqPeriodo = GXutil.addmth( AV9LiqPeriodo, (short)(-1)) ;
      }
      else
      {
         AV8hasta_LiqPeriodo = AV9LiqPeriodo ;
      }
      AV8hasta_LiqPeriodo = GXutil.eomdate( AV8hasta_LiqPeriodo) ;
      if ( ( GXutil.strcmp(AV10TLiqCod, AV11mensualTLiqCod) == 0 ) && ( AV12LegClase == 2 ) )
      {
      }
      GXv_char1[0] = AV60ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV28CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      recorrerpromedios.this.AV60ParmValue = GXv_char1[0] ;
      AV59proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV60ParmValue, ".") ;
      GXt_char2 = AV60ParmValue ;
      GXt_char3 = AV60ParmValue ;
      GXv_char1[0] = GXt_char3 ;
      new web.forzados_habitual_param(remoteHandle, context).execute( GXv_char1) ;
      recorrerpromedios.this.GXt_char3 = GXv_char1[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV28CliCod, GXt_char3, GXv_char4) ;
      recorrerpromedios.this.GXt_char2 = GXv_char4[0] ;
      AV60ParmValue = GXt_char2 ;
      AV62forzadosHabConCodigo.fromJSonString(AV60ParmValue, null);
      AV13i = (short)(1) ;
      while ( AV13i <= AV14posibilidades )
      {
         AV38conceptos_variables.clear();
         new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, "2") ;
         /* Execute user subroutine: 'AUX PERIODO' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV13i == 1 )
         {
            AV16menosCantidad = (short)(AV52CantProm1*-1) ;
            if ( GXutil.strcmp(AV64EmpPromDesde, "actual") == 0 )
            {
               AV16menosCantidad = (short)(AV16menosCantidad+1) ;
            }
            if ( GXutil.strcmp(AV18duracionProm, "meses") == 0 )
            {
               AV19duracionPromTxt = httpContext.getMessage( "meses", "") ;
               AV20desde1_LiqPeriodo = GXutil.addmth( AV15AuxLiqPeriodo, AV16menosCantidad) ;
               AV21desde_LiqPeriodo = GXutil.addmth( AV15AuxLiqPeriodo, AV16menosCantidad) ;
            }
            else
            {
               AV19duracionPromTxt = httpContext.getMessage( "días", "") ;
               AV20desde1_LiqPeriodo = GXutil.dadd( AV15AuxLiqPeriodo, (AV16menosCantidad)) ;
               AV21desde_LiqPeriodo = GXutil.dadd( AV15AuxLiqPeriodo, (AV16menosCantidad)) ;
            }
         }
         else
         {
            AV16menosCantidad = (short)(AV51CantProm2*-1) ;
            if ( GXutil.strcmp(AV64EmpPromDesde, "actual") == 0 )
            {
               AV16menosCantidad = (short)(AV16menosCantidad+1) ;
            }
            if ( GXutil.strcmp(AV18duracionProm, "meses") == 0 )
            {
               AV19duracionPromTxt = httpContext.getMessage( "meses", "") ;
               AV22desde2_LiqPeriodo = GXutil.addmth( AV15AuxLiqPeriodo, AV16menosCantidad) ;
               AV21desde_LiqPeriodo = GXutil.addmth( AV15AuxLiqPeriodo, AV16menosCantidad) ;
            }
            else
            {
               AV19duracionPromTxt = httpContext.getMessage( "días", "") ;
               AV22desde2_LiqPeriodo = GXutil.dadd( AV15AuxLiqPeriodo, (AV16menosCantidad)) ;
               AV21desde_LiqPeriodo = GXutil.dadd( AV15AuxLiqPeriodo, (AV16menosCantidad)) ;
            }
         }
         AV23tot_paraProm_LiqDImpCalcu = DecimalUtil.ZERO ;
         AV25mesesReales = (short)(0) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&desde_LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV21desde_LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &hasta_LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV8hasta_LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " i ", "")+GXutil.trim( GXutil.str( AV13i, 4, 0))) ;
         AV76masTempranoLiqPeriodo = GXutil.addmth( AV8hasta_LiqPeriodo, (short)(1)) ;
         if ( GXutil.strcmp(AV99tipo_tarifa, "H") == 0 )
         {
            AV73horasAPromediar = DecimalUtil.doubleToDec(0) ;
            AV85horasNormales = DecimalUtil.doubleToDec(0) ;
            AV87conceptoAutomaticoHay = true ;
            GXt_char3 = AV81horasNormalesConCodigo ;
            GXt_char2 = AV81horasNormalesConCodigo ;
            GXv_char4[0] = GXt_char2 ;
            new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            recorrerpromedios.this.GXt_char2 = GXv_char4[0] ;
            GXv_char1[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV28CliCod, GXt_char2, GXv_char1) ;
            recorrerpromedios.this.GXt_char3 = GXv_char1[0] ;
            AV81horasNormalesConCodigo = GXt_char3 ;
            AV103GXLvl83 = (byte)(0) ;
            /* Using cursor P01L52 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV29EmpCod), Integer.valueOf(AV30LegNumero), AV81horasNormalesConCodigo, AV21desde_LiqPeriodo, Integer.valueOf(AV94LiqRelNro), AV8hasta_LiqPeriodo});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A2112LiqRelNro = P01L52_A2112LiqRelNro[0] ;
               n2112LiqRelNro = P01L52_n2112LiqRelNro[0] ;
               A394DConCodigo = P01L52_A394DConCodigo[0] ;
               A397DLiqPeriodo = P01L52_A397DLiqPeriodo[0] ;
               A6LegNumero = P01L52_A6LegNumero[0] ;
               A1EmpCod = P01L52_A1EmpCod[0] ;
               A3CliCod = P01L52_A3CliCod[0] ;
               A31LiqNro = P01L52_A31LiqNro[0] ;
               A507LiqDCalculado = P01L52_A507LiqDCalculado[0] ;
               A763LiqDRecalculado = P01L52_A763LiqDRecalculado[0] ;
               A269LiqDCanti = P01L52_A269LiqDCanti[0] ;
               n269LiqDCanti = P01L52_n269LiqDCanti[0] ;
               A81LiqDSecuencial = P01L52_A81LiqDSecuencial[0] ;
               A2112LiqRelNro = P01L52_A2112LiqRelNro[0] ;
               n2112LiqRelNro = P01L52_n2112LiqRelNro[0] ;
               AV103GXLvl83 = (byte)(1) ;
               if ( A31LiqNro == AV82LiqNro )
               {
                  GXv_int5[0] = AV83auxLiqDCalculado ;
                  new web.dependenciaresuelta2(remoteHandle, context).execute( AV28CliCod, A394DConCodigo, "Calculo", A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
                  recorrerpromedios.this.AV83auxLiqDCalculado = GXv_int5[0] ;
                  if ( AV83auxLiqDCalculado == 0 )
                  {
                     AV84error = httpContext.getMessage( "Falta calcular horas normales en liquidación actual", "") ;
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               if ( DecimalUtil.compareTo(A269LiqDCanti, AV74horasDia) < 0 )
               {
                  AV85horasNormales = AV85horasNormales.add(AV74horasDia) ;
               }
               else
               {
                  AV85horasNormales = AV85horasNormales.add(A269LiqDCanti) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " &horasNormales", "")+GXutil.trim( GXutil.str( AV85horasNormales, 9, 2))) ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV103GXLvl83 == 0 )
            {
            }
         }
         /* Using cursor P01L53 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV29EmpCod), Integer.valueOf(AV30LegNumero), AV21desde_LiqPeriodo, AV8hasta_LiqPeriodo, Integer.valueOf(AV94LiqRelNro)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            brk1L53 = false ;
            A31LiqNro = P01L53_A31LiqNro[0] ;
            A764LiqDImpReCalcu = P01L53_A764LiqDImpReCalcu[0] ;
            A269LiqDCanti = P01L53_A269LiqDCanti[0] ;
            n269LiqDCanti = P01L53_n269LiqDCanti[0] ;
            A397DLiqPeriodo = P01L53_A397DLiqPeriodo[0] ;
            A394DConCodigo = P01L53_A394DConCodigo[0] ;
            A6LegNumero = P01L53_A6LegNumero[0] ;
            A1EmpCod = P01L53_A1EmpCod[0] ;
            A3CliCod = P01L53_A3CliCod[0] ;
            A2112LiqRelNro = P01L53_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01L53_n2112LiqRelNro[0] ;
            A466DConVariable = P01L53_A466DConVariable[0] ;
            A468DSubTipoConCod1 = P01L53_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P01L53_n468DSubTipoConCod1[0] ;
            A81LiqDSecuencial = P01L53_A81LiqDSecuencial[0] ;
            A2112LiqRelNro = P01L53_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01L53_n2112LiqRelNro[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, "3") ;
            AV91LiqDCanti = DecimalUtil.ZERO ;
            AV58cantidadDeVecesLiquidado = (short)(0) ;
            AV61auxLiqDImpReCalcu = DecimalUtil.ZERO ;
            GXv_int5[0] = AV97ConBaseLic ;
            new web.getconceptobaseconfprom(remoteHandle, context).execute( AV28CliCod, A394DConCodigo, AV35EmpBaseTipo, AV96remuneradoEs, GXv_int5) ;
            recorrerpromedios.this.AV97ConBaseLic = GXv_int5[0] ;
            GXv_int5[0] = AV34ConSacDeven ;
            new web.getconceptodeveng(remoteHandle, context).execute( AV28CliCod, A394DConCodigo, GXv_int5) ;
            recorrerpromedios.this.AV34ConSacDeven = GXv_int5[0] ;
            while ( (pr_default.getStatus(1) != 101) && ( P01L53_A3CliCod[0] == A3CliCod ) && ( P01L53_A1EmpCod[0] == A1EmpCod ) && ( P01L53_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01L53_A394DConCodigo[0], A394DConCodigo) == 0 ) )
            {
               brk1L53 = false ;
               A31LiqNro = P01L53_A31LiqNro[0] ;
               A764LiqDImpReCalcu = P01L53_A764LiqDImpReCalcu[0] ;
               A269LiqDCanti = P01L53_A269LiqDCanti[0] ;
               n269LiqDCanti = P01L53_n269LiqDCanti[0] ;
               A397DLiqPeriodo = P01L53_A397DLiqPeriodo[0] ;
               A81LiqDSecuencial = P01L53_A81LiqDSecuencial[0] ;
               while ( (pr_default.getStatus(1) != 101) && ( P01L53_A3CliCod[0] == A3CliCod ) && ( P01L53_A1EmpCod[0] == A1EmpCod ) && ( P01L53_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01L53_A394DConCodigo[0], A394DConCodigo) == 0 ) )
               {
                  if ( ! ( GXutil.dateCompare(GXutil.resetTime(P01L53_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
                  {
                     if (true) break;
                  }
                  brk1L53 = false ;
                  A31LiqNro = P01L53_A31LiqNro[0] ;
                  A764LiqDImpReCalcu = P01L53_A764LiqDImpReCalcu[0] ;
                  A269LiqDCanti = P01L53_A269LiqDCanti[0] ;
                  n269LiqDCanti = P01L53_n269LiqDCanti[0] ;
                  A81LiqDSecuencial = P01L53_A81LiqDSecuencial[0] ;
                  AV37LiqDImpReCalcu = A764LiqDImpReCalcu ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &ConSacDeven ", "")+GXutil.trim( GXutil.str( AV34ConSacDeven, 2, 0))) ;
                  if ( AV34ConSacDeven > 1 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "divide &LiqDImpReCalcu entre ", "")+GXutil.trim( GXutil.str( AV34ConSacDeven, 2, 0))) ;
                     AV37LiqDImpReCalcu = AV37LiqDImpReCalcu.divide(DecimalUtil.doubleToDec(AV34ConSacDeven), 18, java.math.RoundingMode.DOWN) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "queda &LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( AV37LiqDImpReCalcu, 14, 2))) ;
                  }
                  AV61auxLiqDImpReCalcu = AV61auxLiqDImpReCalcu.add(AV37LiqDImpReCalcu) ;
                  AV91LiqDCanti = AV91LiqDCanti.add(A269LiqDCanti) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( AV37LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &auxLiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( AV61auxLiqDImpReCalcu, 14, 2))) ;
                  if ( GXutil.resetTime(A397DLiqPeriodo).before( GXutil.resetTime( AV76masTempranoLiqPeriodo )) )
                  {
                     AV76masTempranoLiqPeriodo = A397DLiqPeriodo ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "es menor asigna ", "")+GXutil.trim( localUtil.dtoc( AV76masTempranoLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  }
                  brk1L53 = true ;
                  pr_default.readNext(1);
               }
               AV58cantidadDeVecesLiquidado = (short)(AV58cantidadDeVecesLiquidado+1) ;
               if ( ! brk1L53 )
               {
                  brk1L53 = true ;
                  pr_default.readNext(1);
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, "4") ;
            if ( (AV62forzadosHabConCodigo.indexof(GXutil.rtrim( A394DConCodigo))>0) )
            {
               AV27habitualEs = true ;
            }
            else
            {
               if ( AV58cantidadDeVecesLiquidado > (DecimalUtil.doubleToDec(GXutil.month( AV8hasta_LiqPeriodo)).multiply(AV59proporcionHabitualPorUnaje)).doubleValue() )
               {
                  AV27habitualEs = true ;
               }
               else
               {
                  AV27habitualEs = false ;
               }
            }
            GXv_boolean6[0] = AV36agregar ;
            new web.validar_concepto_base_2(remoteHandle, context).execute( AV97ConBaseLic, AV99tipo_tarifa, AV27habitualEs, GXv_boolean6) ;
            recorrerpromedios.this.AV36agregar = GXv_boolean6[0] ;
            if ( AV36agregar )
            {
               if ( GXutil.strcmp(AV99tipo_tarifa, "H") == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " vigencia ", "")+GXutil.trim( GXutil.str( AV86ConVigencia, 1, 0))) ;
                  if ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV73horasAPromediar = AV73horasAPromediar.add(AV91LiqDCanti) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "suma LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " &horasAPromediar ", "")+GXutil.trim( GXutil.str( AV73horasAPromediar, 9, 2))) ;
                  }
                  else
                  {
                     AV87conceptoAutomaticoHay = true ;
                  }
               }
               AV23tot_paraProm_LiqDImpCalcu = AV23tot_paraProm_LiqDImpCalcu.add(AV61auxLiqDImpReCalcu) ;
               AV38conceptos_variables.add(A394DConCodigo, 0);
            }
            if ( ! brk1L53 )
            {
               brk1L53 = true ;
               pr_default.readNext(1);
            }
         }
         pr_default.close(1);
         GXv_int7[0] = AV17MesesApromediar ;
         new web.diferenciameses(remoteHandle, context).execute( AV28CliCod, AV76masTempranoLiqPeriodo, AV8hasta_LiqPeriodo, (short)(99), GXv_int7) ;
         recorrerpromedios.this.AV17MesesApromediar = GXv_int7[0] ;
         AV17MesesApromediar = (short)(AV17MesesApromediar+1) ;
         if ( ( AV12LegClase == 1 ) && ( GXutil.strcmp(AV99tipo_tarifa, "P") == 0 ) )
         {
            if ( AV17MesesApromediar > 0 )
            {
               AV39promedioRemu = AV23tot_paraProm_LiqDImpCalcu.divide(DecimalUtil.doubleToDec(AV17MesesApromediar), 18, java.math.RoundingMode.DOWN) ;
            }
            else
            {
               AV84error = httpContext.getMessage( "No se pudo calcular meses a promediar", "") ;
               AV53LiqDLog = GXutil.trim( AV84error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&conceptoAutomaticoHay  ", "")+GXutil.trim( GXutil.booltostr( AV87conceptoAutomaticoHay))) ;
            if ( AV87conceptoAutomaticoHay )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "antes &horasAPromediar ", "")+GXutil.trim( GXutil.str( AV73horasAPromediar, 9, 2))) ;
               AV73horasAPromediar = AV73horasAPromediar.add(AV85horasNormales) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "despues &horasAPromediar ", "")+GXutil.trim( GXutil.str( AV73horasAPromediar, 9, 2))+httpContext.getMessage( " &horasNormales ", "")+GXutil.trim( GXutil.str( AV85horasNormales, 9, 2))) ;
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73horasAPromediar)==0) )
            {
               AV73horasAPromediar = AV74horasDia ;
            }
            if ( AV73horasAPromediar.doubleValue() > 0 )
            {
               AV39promedioRemu = AV23tot_paraProm_LiqDImpCalcu.divide(AV73horasAPromediar, 18, java.math.RoundingMode.DOWN) ;
            }
            else
            {
               AV84error = httpContext.getMessage( "No se pudo calcular horas a promediar", "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&error ", "")+GXutil.trim( AV84error)) ;
               AV53LiqDLog = GXutil.trim( AV84error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( AV13i == 1 )
         {
            AV40promedioRemu1 = AV39promedioRemu ;
            AV41tot_paraProm_LiqDImpCalcu1 = AV23tot_paraProm_LiqDImpCalcu ;
            AV57meseAPromediar1 = AV17MesesApromediar ;
            AV42promedioRemu1Total = AV42promedioRemu1Total.add(AV40promedioRemu1) ;
            AV68desdeFecha1 = AV76masTempranoLiqPeriodo ;
            AV88horasAPromediar1 = AV73horasAPromediar ;
         }
         else
         {
            AV43promedioRemu2 = AV39promedioRemu ;
            AV44tot_paraProm_LiqDImpCalcu2 = AV23tot_paraProm_LiqDImpCalcu ;
            AV107Meseapromediar2 = AV17MesesApromediar ;
            AV45promedioRemu2Total = AV45promedioRemu2Total.add(AV43promedioRemu2) ;
            AV69desdeFecha2 = AV76masTempranoLiqPeriodo ;
            AV89horasAPromediar2 = AV73horasAPromediar ;
         }
         AV13i = (short)(AV13i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&duracionProm ", "")+GXutil.trim( AV18duracionProm)+httpContext.getMessage( " &MesesApromediar ", "")+GXutil.trim( GXutil.str( AV17MesesApromediar, 4, 0))+httpContext.getMessage( " diasmes ", "")+GXutil.trim( GXutil.str( AV46diasMes, 2, 0))) ;
      AV77promediioVarPorFraccion1 = AV40promedioRemu1 ;
      AV79promediioVarPorFraccion2 = AV43promedioRemu2 ;
      if ( DecimalUtil.compareTo(AV42promedioRemu1Total, AV45promedioRemu2Total) > 0 )
      {
         AV54mesesLog = AV57meseAPromediar1 ;
         AV65promedioRemuTotal = AV42promedioRemu1Total ;
         AV66promedioRemuAux = AV40promedioRemu1 ;
         AV90horasAPromLog = AV88horasAPromediar1 ;
         AV92tot_paraProm_Log = AV41tot_paraProm_LiqDImpCalcu1 ;
      }
      else
      {
         AV54mesesLog = AV107Meseapromediar2 ;
         AV65promedioRemuTotal = AV45promedioRemu2Total ;
         AV66promedioRemuAux = AV43promedioRemu2 ;
         AV90horasAPromLog = AV89horasAPromediar2 ;
         AV92tot_paraProm_Log = AV44tot_paraProm_LiqDImpCalcu2 ;
      }
      if ( ( GXutil.strcmp(AV18duracionProm, "meses") == 0 ) || ( AV54mesesLog > AV46diasMes ) )
      {
         if ( ( AV12LegClase == 1 ) && ( GXutil.strcmp(AV99tipo_tarifa, "P") == 0 ) )
         {
            AV77promediioVarPorFraccion1 = AV77promediioVarPorFraccion1.divide(DecimalUtil.doubleToDec(AV46diasMes), 18, java.math.RoundingMode.DOWN) ;
            AV79promediioVarPorFraccion2 = AV79promediioVarPorFraccion2.divide(DecimalUtil.doubleToDec(AV46diasMes), 18, java.math.RoundingMode.DOWN) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "divideeee entre ", "")+GXutil.trim( GXutil.str( AV46diasMes, 2, 0))+httpContext.getMessage( "queda &promediioVarPorFraccion1 ", "")+GXutil.trim( GXutil.str( AV77promediioVarPorFraccion1, 14, 2))+httpContext.getMessage( " &promediioVarPorFraccion2 ", "")+GXutil.trim( GXutil.str( AV79promediioVarPorFraccion2, 14, 2))) ;
         }
         else
         {
            AV77promediioVarPorFraccion1 = AV77promediioVarPorFraccion1.multiply(AV74horasDia) ;
            AV79promediioVarPorFraccion2 = AV79promediioVarPorFraccion2.multiply(AV74horasDia) ;
         }
      }
      AV78promediioVarPorFraccion1Total = AV78promediioVarPorFraccion1Total.add(AV77promediioVarPorFraccion1) ;
      AV80promediioVarPorFraccion2Total = AV80promediioVarPorFraccion2Total.add(AV79promediioVarPorFraccion2) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&promedioRemu1Total ", "")+GXutil.trim( GXutil.str( AV42promedioRemu1Total, 14, 2))+httpContext.getMessage( " &promedioRemu2Total ", "")+GXutil.trim( GXutil.str( AV45promedioRemu2Total, 14, 2))) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42promedioRemu1Total)==0) || ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45promedioRemu2Total)==0) )
      {
         AV53LiqDLog = httpContext.getMessage( ", más el valor proporcional a un día ", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "a1", "")) ;
         if ( DecimalUtil.compareTo(AV42promedioRemu1Total, AV45promedioRemu2Total) > 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "a2 &&promediioVarPorFraccion1Total ", "")+GXutil.trim( GXutil.str( AV78promediioVarPorFraccion1Total, 14, 2))) ;
            AV55desdeLog_LiqPeriodo = AV68desdeFecha1 ;
            AV56Importes = AV56Importes.add(AV78promediioVarPorFraccion1Total) ;
            AV53LiqDLog += GXutil.trim( GXutil.str( AV78promediioVarPorFraccion1Total, 14, 2)) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "a3 &promediioVarPorFraccion2Total ", "")+GXutil.trim( GXutil.str( AV80promediioVarPorFraccion2Total, 14, 2))) ;
            AV55desdeLog_LiqPeriodo = AV69desdeFecha2 ;
            AV56Importes = AV56Importes.add(AV80promediioVarPorFraccion2Total) ;
            AV53LiqDLog += GXutil.trim( GXutil.str( AV80promediioVarPorFraccion2Total, 14, 2)) ;
         }
         /* Execute user subroutine: 'LOG ULTIMOS MESES' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "&Importes ", "")+GXutil.trim( GXutil.str( AV56Importes, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV102Pgmname, httpContext.getMessage( "liqdlog ", "")+AV53LiqDLog) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'AUX PERIODO' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV10TLiqCod, AV11mensualTLiqCod) == 0 ) && ( AV12LegClase == 2 ) )
      {
         AV15AuxLiqPeriodo = localUtil.ymdtod( GXutil.year( AV9LiqPeriodo), GXutil.month( AV9LiqPeriodo), 16) ;
      }
      else
      {
         AV15AuxLiqPeriodo = AV9LiqPeriodo ;
      }
   }

   public void S121( )
   {
      /* 'LOG ULTIMOS MESES' Routine */
      returnInSub = false ;
      AV53LiqDLog += httpContext.getMessage( " correspondiente al promedio ", "") + GXutil.trim( GXutil.str( AV66promedioRemuAux, 14, 2)) ;
      AV53LiqDLog += httpContext.getMessage( " de los últimos ", "") + GXutil.trim( GXutil.str( AV54mesesLog, 4, 0)) + " " + GXutil.trim( AV19duracionPromTxt) ;
      AV53LiqDLog += " " + GXutil.trim( GXutil.str( AV92tot_paraProm_Log, 14, 2)) ;
      if ( true )
      {
         AV53LiqDLog += httpContext.getMessage( " en el periodo desde el ", "") + GXutil.trim( localUtil.dtoc( AV55desdeLog_LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV8hasta_LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      AV108Y = (byte)(1) ;
      if ( AV38conceptos_variables.size() == 1 )
      {
         AV53LiqDLog += httpContext.getMessage( " de concepto ", "") ;
      }
      else
      {
         AV53LiqDLog += httpContext.getMessage( " de conceptos ", "") ;
      }
      while ( AV108Y <= AV38conceptos_variables.size() )
      {
         AV53LiqDLog += GXutil.trim( (String)AV38conceptos_variables.elementAt(-1+AV108Y)) + ", " ;
         AV108Y = (byte)(AV108Y+1) ;
      }
      if ( GXutil.strcmp(AV99tipo_tarifa, "H") == 0 )
      {
         AV53LiqDLog += httpContext.getMessage( ", tomando ", "") + GXutil.trim( GXutil.str( AV90horasAPromLog, 9, 2)) + httpContext.getMessage( " horas totales para el promedio de la hora variable y multiplicado por ", "") + GXutil.trim( GXutil.str( AV74horasDia, 9, 2)) + httpContext.getMessage( " horas para obtener el cálculo por día", "") ;
      }
   }

   protected void cleanup( )
   {
      this.aP18[0] = recorrerpromedios.this.AV56Importes;
      this.aP19[0] = recorrerpromedios.this.AV53LiqDLog;
      this.aP20[0] = recorrerpromedios.this.AV84error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV56Importes = DecimalUtil.ZERO ;
      AV53LiqDLog = "" ;
      AV84error = "" ;
      AV102Pgmname = "" ;
      AV64EmpPromDesde = "" ;
      AV8hasta_LiqPeriodo = GXutil.nullDate() ;
      AV60ParmValue = "" ;
      AV59proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      AV62forzadosHabConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38conceptos_variables = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19duracionPromTxt = "" ;
      AV20desde1_LiqPeriodo = GXutil.nullDate() ;
      AV15AuxLiqPeriodo = GXutil.nullDate() ;
      AV21desde_LiqPeriodo = GXutil.nullDate() ;
      AV22desde2_LiqPeriodo = GXutil.nullDate() ;
      AV23tot_paraProm_LiqDImpCalcu = DecimalUtil.ZERO ;
      AV76masTempranoLiqPeriodo = GXutil.nullDate() ;
      AV73horasAPromediar = DecimalUtil.ZERO ;
      AV85horasNormales = DecimalUtil.ZERO ;
      AV81horasNormalesConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char1 = new String[1] ;
      scmdbuf = "" ;
      P01L52_A2112LiqRelNro = new int[1] ;
      P01L52_n2112LiqRelNro = new boolean[] {false} ;
      P01L52_A394DConCodigo = new String[] {""} ;
      P01L52_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01L52_A6LegNumero = new int[1] ;
      P01L52_A1EmpCod = new short[1] ;
      P01L52_A3CliCod = new int[1] ;
      P01L52_A31LiqNro = new int[1] ;
      P01L52_A507LiqDCalculado = new byte[1] ;
      P01L52_A763LiqDRecalculado = new short[1] ;
      P01L52_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01L52_n269LiqDCanti = new boolean[] {false} ;
      P01L52_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      P01L53_A31LiqNro = new int[1] ;
      P01L53_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01L53_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01L53_n269LiqDCanti = new boolean[] {false} ;
      P01L53_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01L53_A394DConCodigo = new String[] {""} ;
      P01L53_A6LegNumero = new int[1] ;
      P01L53_A1EmpCod = new short[1] ;
      P01L53_A3CliCod = new int[1] ;
      P01L53_A2112LiqRelNro = new int[1] ;
      P01L53_n2112LiqRelNro = new boolean[] {false} ;
      P01L53_A466DConVariable = new boolean[] {false} ;
      P01L53_A468DSubTipoConCod1 = new String[] {""} ;
      P01L53_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01L53_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A468DSubTipoConCod1 = "" ;
      AV91LiqDCanti = DecimalUtil.ZERO ;
      AV61auxLiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_int5 = new byte[1] ;
      AV37LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new short[1] ;
      AV39promedioRemu = DecimalUtil.ZERO ;
      AV40promedioRemu1 = DecimalUtil.ZERO ;
      AV41tot_paraProm_LiqDImpCalcu1 = DecimalUtil.ZERO ;
      AV42promedioRemu1Total = DecimalUtil.ZERO ;
      AV68desdeFecha1 = GXutil.nullDate() ;
      AV88horasAPromediar1 = DecimalUtil.ZERO ;
      AV43promedioRemu2 = DecimalUtil.ZERO ;
      AV44tot_paraProm_LiqDImpCalcu2 = DecimalUtil.ZERO ;
      AV45promedioRemu2Total = DecimalUtil.ZERO ;
      AV69desdeFecha2 = GXutil.nullDate() ;
      AV89horasAPromediar2 = DecimalUtil.ZERO ;
      AV77promediioVarPorFraccion1 = DecimalUtil.ZERO ;
      AV79promediioVarPorFraccion2 = DecimalUtil.ZERO ;
      AV65promedioRemuTotal = DecimalUtil.ZERO ;
      AV66promedioRemuAux = DecimalUtil.ZERO ;
      AV90horasAPromLog = DecimalUtil.ZERO ;
      AV92tot_paraProm_Log = DecimalUtil.ZERO ;
      AV78promediioVarPorFraccion1Total = DecimalUtil.ZERO ;
      AV80promediioVarPorFraccion2Total = DecimalUtil.ZERO ;
      AV55desdeLog_LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.recorrerpromedios__default(),
         new Object[] {
             new Object[] {
            P01L52_A2112LiqRelNro, P01L52_n2112LiqRelNro, P01L52_A394DConCodigo, P01L52_A397DLiqPeriodo, P01L52_A6LegNumero, P01L52_A1EmpCod, P01L52_A3CliCod, P01L52_A31LiqNro, P01L52_A507LiqDCalculado, P01L52_A763LiqDRecalculado,
            P01L52_A269LiqDCanti, P01L52_n269LiqDCanti, P01L52_A81LiqDSecuencial
            }
            , new Object[] {
            P01L53_A31LiqNro, P01L53_A764LiqDImpReCalcu, P01L53_A269LiqDCanti, P01L53_n269LiqDCanti, P01L53_A397DLiqPeriodo, P01L53_A394DConCodigo, P01L53_A6LegNumero, P01L53_A1EmpCod, P01L53_A3CliCod, P01L53_A2112LiqRelNro,
            P01L53_n2112LiqRelNro, P01L53_A466DConVariable, P01L53_A468DSubTipoConCod1, P01L53_n468DSubTipoConCod1, P01L53_A81LiqDSecuencial
            }
         }
      );
      AV102Pgmname = "recorrerPromedios" ;
      /* GeneXus formulas. */
      AV102Pgmname = "recorrerPromedios" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12LegClase ;
   private byte AV46diasMes ;
   private byte AV103GXLvl83 ;
   private byte A507LiqDCalculado ;
   private byte AV83auxLiqDCalculado ;
   private byte AV97ConBaseLic ;
   private byte AV34ConSacDeven ;
   private byte GXv_int5[] ;
   private byte AV86ConVigencia ;
   private byte AV108Y ;
   private short AV29EmpCod ;
   private short AV14posibilidades ;
   private short AV52CantProm1 ;
   private short AV51CantProm2 ;
   private short AV13i ;
   private short AV16menosCantidad ;
   private short AV25mesesReales ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV58cantidadDeVecesLiquidado ;
   private short AV17MesesApromediar ;
   private short GXv_int7[] ;
   private short AV57meseAPromediar1 ;
   private short AV107Meseapromediar2 ;
   private short AV54mesesLog ;
   private short Gx_err ;
   private int AV28CliCod ;
   private int AV82LiqNro ;
   private int AV94LiqRelNro ;
   private int AV30LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV74horasDia ;
   private java.math.BigDecimal AV56Importes ;
   private java.math.BigDecimal AV59proporcionHabitualPorUnaje ;
   private java.math.BigDecimal AV23tot_paraProm_LiqDImpCalcu ;
   private java.math.BigDecimal AV73horasAPromediar ;
   private java.math.BigDecimal AV85horasNormales ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV91LiqDCanti ;
   private java.math.BigDecimal AV61auxLiqDImpReCalcu ;
   private java.math.BigDecimal AV37LiqDImpReCalcu ;
   private java.math.BigDecimal AV39promedioRemu ;
   private java.math.BigDecimal AV40promedioRemu1 ;
   private java.math.BigDecimal AV41tot_paraProm_LiqDImpCalcu1 ;
   private java.math.BigDecimal AV42promedioRemu1Total ;
   private java.math.BigDecimal AV88horasAPromediar1 ;
   private java.math.BigDecimal AV43promedioRemu2 ;
   private java.math.BigDecimal AV44tot_paraProm_LiqDImpCalcu2 ;
   private java.math.BigDecimal AV45promedioRemu2Total ;
   private java.math.BigDecimal AV89horasAPromediar2 ;
   private java.math.BigDecimal AV77promediioVarPorFraccion1 ;
   private java.math.BigDecimal AV79promediioVarPorFraccion2 ;
   private java.math.BigDecimal AV65promedioRemuTotal ;
   private java.math.BigDecimal AV66promedioRemuAux ;
   private java.math.BigDecimal AV90horasAPromLog ;
   private java.math.BigDecimal AV92tot_paraProm_Log ;
   private java.math.BigDecimal AV78promediioVarPorFraccion1Total ;
   private java.math.BigDecimal AV80promediioVarPorFraccion2Total ;
   private String AV35EmpBaseTipo ;
   private String AV10TLiqCod ;
   private String AV11mensualTLiqCod ;
   private String AV99tipo_tarifa ;
   private String AV18duracionProm ;
   private String AV102Pgmname ;
   private String AV64EmpPromDesde ;
   private String AV19duracionPromTxt ;
   private String AV81horasNormalesConCodigo ;
   private String GXt_char3 ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A468DSubTipoConCod1 ;
   private java.util.Date AV9LiqPeriodo ;
   private java.util.Date AV8hasta_LiqPeriodo ;
   private java.util.Date AV20desde1_LiqPeriodo ;
   private java.util.Date AV15AuxLiqPeriodo ;
   private java.util.Date AV21desde_LiqPeriodo ;
   private java.util.Date AV22desde2_LiqPeriodo ;
   private java.util.Date AV76masTempranoLiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date AV68desdeFecha1 ;
   private java.util.Date AV69desdeFecha2 ;
   private java.util.Date AV55desdeLog_LiqPeriodo ;
   private boolean AV96remuneradoEs ;
   private boolean returnInSub ;
   private boolean AV87conceptoAutomaticoHay ;
   private boolean n2112LiqRelNro ;
   private boolean n269LiqDCanti ;
   private boolean brk1L53 ;
   private boolean A466DConVariable ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV27habitualEs ;
   private boolean AV36agregar ;
   private boolean GXv_boolean6[] ;
   private boolean Cond_result ;
   private String AV53LiqDLog ;
   private String AV60ParmValue ;
   private String AV84error ;
   private String[] aP20 ;
   private java.math.BigDecimal[] aP18 ;
   private String[] aP19 ;
   private IDataStoreProvider pr_default ;
   private int[] P01L52_A2112LiqRelNro ;
   private boolean[] P01L52_n2112LiqRelNro ;
   private String[] P01L52_A394DConCodigo ;
   private java.util.Date[] P01L52_A397DLiqPeriodo ;
   private int[] P01L52_A6LegNumero ;
   private short[] P01L52_A1EmpCod ;
   private int[] P01L52_A3CliCod ;
   private int[] P01L52_A31LiqNro ;
   private byte[] P01L52_A507LiqDCalculado ;
   private short[] P01L52_A763LiqDRecalculado ;
   private java.math.BigDecimal[] P01L52_A269LiqDCanti ;
   private boolean[] P01L52_n269LiqDCanti ;
   private int[] P01L52_A81LiqDSecuencial ;
   private int[] P01L53_A31LiqNro ;
   private java.math.BigDecimal[] P01L53_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01L53_A269LiqDCanti ;
   private boolean[] P01L53_n269LiqDCanti ;
   private java.util.Date[] P01L53_A397DLiqPeriodo ;
   private String[] P01L53_A394DConCodigo ;
   private int[] P01L53_A6LegNumero ;
   private short[] P01L53_A1EmpCod ;
   private int[] P01L53_A3CliCod ;
   private int[] P01L53_A2112LiqRelNro ;
   private boolean[] P01L53_n2112LiqRelNro ;
   private boolean[] P01L53_A466DConVariable ;
   private String[] P01L53_A468DSubTipoConCod1 ;
   private boolean[] P01L53_n468DSubTipoConCod1 ;
   private int[] P01L53_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV62forzadosHabConCodigo ;
   private GXSimpleCollection<String> AV38conceptos_variables ;
}

final  class recorrerpromedios__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01L52", "SELECT T2.LiqRelNro, T1.DConCodigo, T1.DLiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqNro, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqDCanti, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DLiqPeriodo <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01L53", "SELECT T1.LiqNro, T1.LiqDImpReCalcu, T1.LiqDCanti, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LiqRelNro, T1.DConVariable, T1.DSubTipoConCod1, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T1.DLiqPeriodo >= ?) AND (T1.DLiqPeriodo <= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DConVariable = TRUE) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(12);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

