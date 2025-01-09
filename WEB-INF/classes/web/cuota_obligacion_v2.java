package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cuota_obligacion_v2 extends GXProcedure
{
   public cuota_obligacion_v2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cuota_obligacion_v2.class ), "" );
   }

   public cuota_obligacion_v2( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           short aP4 ,
                           java.util.Date aP5 ,
                           String aP6 ,
                           short aP7 ,
                           String aP8 ,
                           boolean aP9 ,
                           java.math.BigDecimal[] aP10 ,
                           String[] aP11 ,
                           String[] aP12 )
   {
      cuota_obligacion_v2.this.aP13 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        short aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        byte[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             short aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 )
   {
      cuota_obligacion_v2.this.AV10CliCod = aP0;
      cuota_obligacion_v2.this.AV11EmpCod = aP1;
      cuota_obligacion_v2.this.AV12LiqNro = aP2;
      cuota_obligacion_v2.this.AV18LegNumero = aP3;
      cuota_obligacion_v2.this.AV30TipoOblSec = aP4;
      cuota_obligacion_v2.this.AV15LiqPeriodo = aP5;
      cuota_obligacion_v2.this.AV34ConCodigo = aP6;
      cuota_obligacion_v2.this.AV35PaiCod = aP7;
      cuota_obligacion_v2.this.AV26ProcesoLiquidacion = aP8;
      cuota_obligacion_v2.this.AV27insertandoConceptos = aP9;
      cuota_obligacion_v2.this.aP10 = aP10;
      cuota_obligacion_v2.this.aP11 = aP11;
      cuota_obligacion_v2.this.aP12 = aP12;
      cuota_obligacion_v2.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "1") ;
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9TLiqCod ;
      GXv_char2[0] = GXt_char1 ;
      new web.gettipoliq(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, GXv_char2) ;
      cuota_obligacion_v2.this.GXt_char1 = GXv_char2[0] ;
      AV9TLiqCod = GXt_char1 ;
      GXt_char1 = AV13egresoTLiqCod ;
      GXt_char3 = AV13egresoTLiqCod ;
      GXv_char2[0] = GXt_char3 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      cuota_obligacion_v2.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char3, GXv_char4) ;
      cuota_obligacion_v2.this.GXt_char1 = GXv_char4[0] ;
      AV13egresoTLiqCod = GXt_char1 ;
      GXt_char3 = AV14mensualTLiqCod ;
      GXt_char1 = AV14mensualTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      cuota_obligacion_v2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char2) ;
      cuota_obligacion_v2.this.GXt_char3 = GXv_char2[0] ;
      AV14mensualTLiqCod = GXt_char3 ;
      AV60GXLvl8 = (byte)(0) ;
      /* Using cursor P01A02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV18LegNumero), Short.valueOf(AV30TipoOblSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1173OblEstado = P01A02_A1173OblEstado[0] ;
         A1163TipoOblSec = P01A02_A1163TipoOblSec[0] ;
         A6LegNumero = P01A02_A6LegNumero[0] ;
         A1EmpCod = P01A02_A1EmpCod[0] ;
         A3CliCod = P01A02_A3CliCod[0] ;
         A1172OblSecuencial = P01A02_A1172OblSecuencial[0] ;
         AV60GXLvl8 = (byte)(1) ;
         AV29abiertos_OblSecuencial.add((short)(A1172OblSecuencial), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV60GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "none 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "2") ;
      if ( AV29abiertos_OblSecuencial.size() == 0 )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         AV31primer_OblSecuencial = ((Number) AV29abiertos_OblSecuencial.elementAt(-1+1)).shortValue() ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "3") ;
      AV61GXLvl26 = (byte)(0) ;
      /* Using cursor P01A03 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV18LegNumero), Integer.valueOf(AV12LiqNro), Short.valueOf(AV31primer_OblSecuencial)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P01A03_A3CliCod[0] ;
         A1EmpCod = P01A03_A1EmpCod[0] ;
         A1172OblSecuencial = P01A03_A1172OblSecuencial[0] ;
         A6LegNumero = P01A03_A6LegNumero[0] ;
         A1185LiqOblNuevaNro = P01A03_A1185LiqOblNuevaNro[0] ;
         A1184LiqOblAltaNro = P01A03_A1184LiqOblAltaNro[0] ;
         AV61GXLvl26 = (byte)(1) ;
         AV20anteriorLiqNro = A1185LiqOblNuevaNro ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV61GXLvl26 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "none ", "")) ;
      }
      AV48llevaSaldo = (short)((byte)((true)?1:0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "4") ;
      if ( (0==AV20anteriorLiqNro) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "5") ;
         AV39i = (short)(1) ;
         while ( AV39i <= AV29abiertos_OblSecuencial.size() )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "6") ;
            AV40OblSecuencial = ((Number) AV29abiertos_OblSecuencial.elementAt(-1+AV39i)).shortValue() ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "8") ;
            GXv_int5[0] = AV49EmbargaSec ;
            GXv_decimal6[0] = AV44OblTotal ;
            GXv_int7[0] = AV41OblCanCuo ;
            GXv_decimal8[0] = AV42OblImpFij ;
            GXv_decimal9[0] = AV43OblPorc ;
            GXv_char4[0] = AV55OblConcepto ;
            GXv_char2[0] = AV56OblTipoMov ;
            GXv_char10[0] = AV46oblImpError ;
            GXv_int11[0] = AV47oblImpLiqDCalculado ;
            new web.getobligacionimportes(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV18LegNumero, AV40OblSecuencial, GXv_int5, GXv_decimal6, GXv_int7, GXv_decimal8, GXv_decimal9, GXv_char4, GXv_char2, GXv_char10, GXv_int11) ;
            cuota_obligacion_v2.this.AV49EmbargaSec = GXv_int5[0] ;
            cuota_obligacion_v2.this.AV44OblTotal = GXv_decimal6[0] ;
            cuota_obligacion_v2.this.AV41OblCanCuo = GXv_int7[0] ;
            cuota_obligacion_v2.this.AV42OblImpFij = GXv_decimal8[0] ;
            cuota_obligacion_v2.this.AV43OblPorc = GXv_decimal9[0] ;
            cuota_obligacion_v2.this.AV55OblConcepto = GXv_char4[0] ;
            cuota_obligacion_v2.this.AV56OblTipoMov = GXv_char2[0] ;
            cuota_obligacion_v2.this.AV46oblImpError = GXv_char10[0] ;
            cuota_obligacion_v2.this.AV47oblImpLiqDCalculado = GXv_int11[0] ;
            if ( AV47oblImpLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               AV38error = AV46oblImpError ;
               AV19LiqDLog += AV38error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "9") ;
            GXv_decimal9[0] = AV51LiqOblCuota ;
            GXv_decimal8[0] = AV53nuevo_LiqOblSaldo ;
            GXv_char10[0] = AV36nuevoError ;
            GXv_int11[0] = AV37nuevoLiqDCalculado ;
            GXv_char4[0] = AV22nuevoLiqDLog ;
            new web.calcularcuotaobligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV18LegNumero, AV15LiqPeriodo, AV34ConCodigo, AV35PaiCod, AV40OblSecuencial, AV49EmbargaSec, AV44OblTotal, AV41OblCanCuo, AV42OblImpFij, AV43OblPorc, AV41OblCanCuo, AV26ProcesoLiquidacion, AV27insertandoConceptos, GXv_decimal9, GXv_decimal8, GXv_char10, GXv_int11, GXv_char4) ;
            cuota_obligacion_v2.this.AV51LiqOblCuota = GXv_decimal9[0] ;
            cuota_obligacion_v2.this.AV53nuevo_LiqOblSaldo = GXv_decimal8[0] ;
            cuota_obligacion_v2.this.AV36nuevoError = GXv_char10[0] ;
            cuota_obligacion_v2.this.AV37nuevoLiqDCalculado = GXv_int11[0] ;
            cuota_obligacion_v2.this.AV22nuevoLiqDLog = GXv_char4[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "10 &LiqOblCuota ", "")+GXutil.trim( GXutil.str( AV51LiqOblCuota, 14, 2))+httpContext.getMessage( " &nuevo_LiqOblSaldo ", "")+GXutil.trim( GXutil.str( AV53nuevo_LiqOblSaldo, 14, 2))) ;
            if ( AV37nuevoLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               AV38error = httpContext.getMessage( "Error al calcular primer cuota: ", "") + GXutil.trim( AV36nuevoError) ;
               AV19LiqDLog += AV38error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV19LiqDLog = AV22nuevoLiqDLog ;
            AV62GXLvl73 = (byte)(0) ;
            /* Using cursor P01A04 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV18LegNumero), Short.valueOf(AV40OblSecuencial), Integer.valueOf(AV12LiqNro), Integer.valueOf(AV12LiqNro)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1186LiqOblPrimera = P01A04_A1186LiqOblPrimera[0] ;
               A1185LiqOblNuevaNro = P01A04_A1185LiqOblNuevaNro[0] ;
               A1184LiqOblAltaNro = P01A04_A1184LiqOblAltaNro[0] ;
               A1172OblSecuencial = P01A04_A1172OblSecuencial[0] ;
               A6LegNumero = P01A04_A6LegNumero[0] ;
               A1EmpCod = P01A04_A1EmpCod[0] ;
               A3CliCod = P01A04_A3CliCod[0] ;
               A1197LiqOblSaldo = P01A04_A1197LiqOblSaldo[0] ;
               A1188LiqOblCuota = P01A04_A1188LiqOblCuota[0] ;
               A1190LiqOblTotRecal = P01A04_A1190LiqOblTotRecal[0] ;
               A1187LiqOblLog = P01A04_A1187LiqOblLog[0] ;
               A1189LiqOblTotal = P01A04_A1189LiqOblTotal[0] ;
               AV62GXLvl73 = (byte)(1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "7 &ProcesoLiquidacion ", "")+GXutil.trim( AV26ProcesoLiquidacion)) ;
               if ( ( DecimalUtil.compareTo(A1188LiqOblCuota, AV51LiqOblCuota) != 0 ) || ( DecimalUtil.compareTo(A1197LiqOblSaldo, AV53nuevo_LiqOblSaldo) != 0 ) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "7b", "")) ;
                  if ( GXutil.strcmp(AV26ProcesoLiquidacion, "Recalculo") == 0 )
                  {
                     A1190LiqOblTotRecal = AV51LiqOblCuota.add(AV53nuevo_LiqOblSaldo) ;
                     A1187LiqOblLog += httpContext.getMessage( ". Actualiza total recalculado con ", "") + GXutil.trim( GXutil.str( A1190LiqOblTotRecal, 14, 2)) ;
                  }
                  else
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, httpContext.getMessage( "7c", "")) ;
                     A1188LiqOblCuota = AV51LiqOblCuota ;
                     A1197LiqOblSaldo = AV53nuevo_LiqOblSaldo ;
                     A1189LiqOblTotal = AV51LiqOblCuota.add(AV53nuevo_LiqOblSaldo) ;
                     A1187LiqOblLog += httpContext.getMessage( ". Actualiza cuota con ", "") + GXutil.trim( GXutil.str( AV51LiqOblCuota, 14, 2)) + httpContext.getMessage( ", saldo con ", "") + GXutil.trim( GXutil.str( AV53nuevo_LiqOblSaldo, 14, 2)) + httpContext.getMessage( " total con ", "") + GXutil.trim( GXutil.str( A1189LiqOblTotal, 14, 2)) ;
                  }
               }
               /* Using cursor P01A05 */
               pr_default.execute(3, new Object[] {A1197LiqOblSaldo, A1188LiqOblCuota, A1190LiqOblTotRecal, A1187LiqOblLog, A1189LiqOblTotal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
            if ( AV62GXLvl73 == 0 )
            {
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44OblTotal)==0) )
               {
                  new web.newcuentaobligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV18LegNumero, AV40OblSecuencial, AV12LiqNro, AV12LiqNro, true, AV51LiqOblCuota, AV53nuevo_LiqOblSaldo, AV15LiqPeriodo, AV26ProcesoLiquidacion, AV27insertandoConceptos) ;
               }
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44OblTotal)==0) )
            {
               AV48llevaSaldo = (short)((byte)((false)?1:0)) ;
            }
            AV39i = (short)(AV39i+1) ;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "11") ;
         pr_default.dynParam(4, new Object[]{ new Object[]{
                                              Short.valueOf(A1172OblSecuencial) ,
                                              AV29abiertos_OblSecuencial ,
                                              Integer.valueOf(AV10CliCod) ,
                                              Short.valueOf(AV11EmpCod) ,
                                              Integer.valueOf(AV20anteriorLiqNro) ,
                                              Integer.valueOf(AV18LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A1185LiqOblNuevaNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01A06 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV20anteriorLiqNro), Integer.valueOf(AV18LegNumero)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A1163TipoOblSec = P01A06_A1163TipoOblSec[0] ;
            A1172OblSecuencial = P01A06_A1172OblSecuencial[0] ;
            A1185LiqOblNuevaNro = P01A06_A1185LiqOblNuevaNro[0] ;
            A6LegNumero = P01A06_A6LegNumero[0] ;
            A1EmpCod = P01A06_A1EmpCod[0] ;
            A3CliCod = P01A06_A3CliCod[0] ;
            A1184LiqOblAltaNro = P01A06_A1184LiqOblAltaNro[0] ;
            A1177OblCanCuo = P01A06_A1177OblCanCuo[0] ;
            A1161EmbargaSec = P01A06_A1161EmbargaSec[0] ;
            n1161EmbargaSec = P01A06_n1161EmbargaSec[0] ;
            A1178OblImpFij = P01A06_A1178OblImpFij[0] ;
            A1179OblPorc = P01A06_A1179OblPorc[0] ;
            A1163TipoOblSec = P01A06_A1163TipoOblSec[0] ;
            A1177OblCanCuo = P01A06_A1177OblCanCuo[0] ;
            A1178OblImpFij = P01A06_A1178OblImpFij[0] ;
            A1179OblPorc = P01A06_A1179OblPorc[0] ;
            A1161EmbargaSec = P01A06_A1161EmbargaSec[0] ;
            n1161EmbargaSec = P01A06_n1161EmbargaSec[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "12") ;
            GXv_decimal9[0] = AV25LiqLegConSaldo ;
            GXv_int7[0] = AV32cantLiquidadas ;
            GXv_char10[0] = AV24calculoLiqDLog ;
            new web.calcularsaldoinicialobligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV18LegNumero, A1172OblSecuencial, A1184LiqOblAltaNro, A1185LiqOblNuevaNro, GXv_decimal9, GXv_int7, GXv_char10) ;
            cuota_obligacion_v2.this.AV25LiqLegConSaldo = GXv_decimal9[0] ;
            cuota_obligacion_v2.this.AV32cantLiquidadas = GXv_int7[0] ;
            cuota_obligacion_v2.this.AV24calculoLiqDLog = GXv_char10[0] ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25LiqLegConSaldo)==0) )
            {
               AV19LiqDLog = httpContext.getMessage( "Sin saldo pendiente", "") ;
               pr_default.close(4);
               pr_default.close(4);
               pr_default.close(4);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV19LiqDLog += httpContext.getMessage( ". Saldo inicial: ", "") + GXutil.trim( GXutil.str( AV25LiqLegConSaldo, 14, 2)) + " (" + GXutil.trim( AV24calculoLiqDLog) + ")" ;
            if ( A1177OblCanCuo > 0 )
            {
               AV33mesesQueFaltan = (short)(A1177OblCanCuo-AV32cantLiquidadas) ;
            }
            else
            {
               AV33mesesQueFaltan = (short)(0) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV59Pgmname, "13") ;
            GXv_decimal9[0] = AV51LiqOblCuota ;
            GXv_decimal8[0] = AV53nuevo_LiqOblSaldo ;
            GXv_char10[0] = AV36nuevoError ;
            GXv_int11[0] = AV37nuevoLiqDCalculado ;
            GXv_char4[0] = AV22nuevoLiqDLog ;
            new web.calcularcuotaobligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV18LegNumero, AV15LiqPeriodo, AV34ConCodigo, AV35PaiCod, A1172OblSecuencial, A1161EmbargaSec, AV25LiqLegConSaldo, A1177OblCanCuo, A1178OblImpFij, A1179OblPorc, AV33mesesQueFaltan, AV26ProcesoLiquidacion, AV27insertandoConceptos, GXv_decimal9, GXv_decimal8, GXv_char10, GXv_int11, GXv_char4) ;
            cuota_obligacion_v2.this.AV51LiqOblCuota = GXv_decimal9[0] ;
            cuota_obligacion_v2.this.AV53nuevo_LiqOblSaldo = GXv_decimal8[0] ;
            cuota_obligacion_v2.this.AV36nuevoError = GXv_char10[0] ;
            cuota_obligacion_v2.this.AV37nuevoLiqDCalculado = GXv_int11[0] ;
            cuota_obligacion_v2.this.AV22nuevoLiqDLog = GXv_char4[0] ;
            if ( AV37nuevoLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               AV38error = httpContext.getMessage( "Error al calcular cuota: ", "") + GXutil.trim( AV36nuevoError) ;
               AV19LiqDLog += AV38error ;
               pr_default.close(4);
               pr_default.close(4);
               pr_default.close(4);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV19LiqDLog += AV22nuevoLiqDLog ;
            new web.newcuentaobligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV18LegNumero, A1172OblSecuencial, A1184LiqOblAltaNro, AV12LiqNro, false, AV51LiqOblCuota, AV53nuevo_LiqOblSaldo, AV15LiqPeriodo, AV26ProcesoLiquidacion, AV27insertandoConceptos) ;
            AV19LiqDLog += httpContext.getMessage( ". Crea registro de nueva cuota ", "") + GXutil.trim( GXutil.str( AV51LiqOblCuota, 14, 2)) ;
            pr_default.readNext(4);
         }
         pr_default.close(4);
      }
      if ( ( AV48llevaSaldo == ( 1 )) )
      {
         if ( GXutil.strcmp(AV9TLiqCod, AV13egresoTLiqCod) == 0 )
         {
            AV19LiqDLog += httpContext.getMessage( ". Suma los saldos pendientes", "") ;
            pr_default.dynParam(5, new Object[]{ new Object[]{
                                                 Short.valueOf(A1172OblSecuencial) ,
                                                 AV29abiertos_OblSecuencial ,
                                                 Integer.valueOf(AV10CliCod) ,
                                                 Short.valueOf(AV11EmpCod) ,
                                                 Integer.valueOf(AV20anteriorLiqNro) ,
                                                 Integer.valueOf(AV18LegNumero) ,
                                                 Integer.valueOf(A3CliCod) ,
                                                 Short.valueOf(A1EmpCod) ,
                                                 Integer.valueOf(A1185LiqOblNuevaNro) ,
                                                 Integer.valueOf(A6LegNumero) } ,
                                                 new int[]{
                                                 TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                                 }
            });
            /* Using cursor P01A07 */
            pr_default.execute(5, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV20anteriorLiqNro), Integer.valueOf(AV18LegNumero)});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A1172OblSecuencial = P01A07_A1172OblSecuencial[0] ;
               A1185LiqOblNuevaNro = P01A07_A1185LiqOblNuevaNro[0] ;
               A6LegNumero = P01A07_A6LegNumero[0] ;
               A1EmpCod = P01A07_A1EmpCod[0] ;
               A3CliCod = P01A07_A3CliCod[0] ;
               A2343OblConcepto = P01A07_A2343OblConcepto[0] ;
               A2345OblTipoMov = P01A07_A2345OblTipoMov[0] ;
               A1197LiqOblSaldo = P01A07_A1197LiqOblSaldo[0] ;
               A1184LiqOblAltaNro = P01A07_A1184LiqOblAltaNro[0] ;
               A2343OblConcepto = P01A07_A2343OblConcepto[0] ;
               A2345OblTipoMov = P01A07_A2345OblTipoMov[0] ;
               GXv_char10[0] = AV54TipoConCod ;
               new web.conceptogettipo(remoteHandle, context).execute( AV10CliCod, A2343OblConcepto, GXv_char10) ;
               cuota_obligacion_v2.this.AV54TipoConCod = GXv_char10[0] ;
               if ( GXutil.strcmp(A2345OblTipoMov, "Descuento") == 0 )
               {
                  if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
                  {
                     AV16Importes = AV16Importes.add(A1197LiqOblSaldo) ;
                     AV19LiqDLog += " +" + GXutil.trim( GXutil.str( A1197LiqOblSaldo, 14, 2)) ;
                  }
                  else
                  {
                     AV16Importes = AV16Importes.subtract(A1197LiqOblSaldo) ;
                     AV19LiqDLog += " -" + GXutil.trim( GXutil.str( A1197LiqOblSaldo, 14, 2)) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
                  {
                     AV16Importes = AV16Importes.subtract(A1197LiqOblSaldo) ;
                     AV19LiqDLog += " -" + GXutil.trim( GXutil.str( A1197LiqOblSaldo, 14, 2)) ;
                  }
                  else
                  {
                     AV16Importes = AV16Importes.add(A1197LiqOblSaldo) ;
                     AV19LiqDLog += " +" + GXutil.trim( GXutil.str( A1197LiqOblSaldo, 14, 2)) ;
                  }
               }
               pr_default.readNext(5);
            }
            pr_default.close(5);
         }
         else
         {
            AV19LiqDLog += httpContext.getMessage( ". Suma cuotas de Liq. nro. ", "") + GXutil.trim( GXutil.str( AV12LiqNro, 8, 0)) ;
            pr_default.dynParam(6, new Object[]{ new Object[]{
                                                 Short.valueOf(A1172OblSecuencial) ,
                                                 AV29abiertos_OblSecuencial ,
                                                 A1199LiqOblPeriodo ,
                                                 AV15LiqPeriodo ,
                                                 Integer.valueOf(AV10CliCod) ,
                                                 Short.valueOf(AV11EmpCod) ,
                                                 Integer.valueOf(AV12LiqNro) ,
                                                 Integer.valueOf(AV18LegNumero) ,
                                                 Integer.valueOf(A3CliCod) ,
                                                 Short.valueOf(A1EmpCod) ,
                                                 Integer.valueOf(A1185LiqOblNuevaNro) ,
                                                 Integer.valueOf(A6LegNumero) } ,
                                                 new int[]{
                                                 TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                                 TypeConstants.INT
                                                 }
            });
            /* Using cursor P01A08 */
            pr_default.execute(6, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LiqNro), Integer.valueOf(AV18LegNumero), AV15LiqPeriodo});
            while ( (pr_default.getStatus(6) != 101) )
            {
               A1172OblSecuencial = P01A08_A1172OblSecuencial[0] ;
               A1185LiqOblNuevaNro = P01A08_A1185LiqOblNuevaNro[0] ;
               A1199LiqOblPeriodo = P01A08_A1199LiqOblPeriodo[0] ;
               A6LegNumero = P01A08_A6LegNumero[0] ;
               A1EmpCod = P01A08_A1EmpCod[0] ;
               A3CliCod = P01A08_A3CliCod[0] ;
               A2343OblConcepto = P01A08_A2343OblConcepto[0] ;
               A2345OblTipoMov = P01A08_A2345OblTipoMov[0] ;
               A1188LiqOblCuota = P01A08_A1188LiqOblCuota[0] ;
               A1184LiqOblAltaNro = P01A08_A1184LiqOblAltaNro[0] ;
               A2343OblConcepto = P01A08_A2343OblConcepto[0] ;
               A2345OblTipoMov = P01A08_A2345OblTipoMov[0] ;
               GXv_char10[0] = AV54TipoConCod ;
               new web.conceptogettipo(remoteHandle, context).execute( AV10CliCod, A2343OblConcepto, GXv_char10) ;
               cuota_obligacion_v2.this.AV54TipoConCod = GXv_char10[0] ;
               if ( GXutil.strcmp(A2345OblTipoMov, "Descuento") == 0 )
               {
                  if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
                  {
                     AV16Importes = AV16Importes.add(A1188LiqOblCuota) ;
                     AV19LiqDLog += " +" + GXutil.trim( GXutil.str( A1188LiqOblCuota, 14, 2)) ;
                  }
                  else
                  {
                     AV16Importes = AV16Importes.subtract(A1188LiqOblCuota) ;
                     AV19LiqDLog += " -" + GXutil.trim( GXutil.str( A1188LiqOblCuota, 14, 2)) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
                  {
                     AV16Importes = AV16Importes.subtract(A1188LiqOblCuota) ;
                     AV19LiqDLog += " -" + GXutil.trim( GXutil.str( A1188LiqOblCuota, 14, 2)) ;
                  }
                  else
                  {
                     AV16Importes = AV16Importes.add(A1188LiqOblCuota) ;
                     AV19LiqDLog += " +" + GXutil.trim( GXutil.str( A1188LiqOblCuota, 14, 2)) ;
                  }
               }
               pr_default.readNext(6);
            }
            pr_default.close(6);
         }
      }
      else
      {
         GXv_char10[0] = AV54TipoConCod ;
         new web.conceptogettipo(remoteHandle, context).execute( AV10CliCod, AV55OblConcepto, GXv_char10) ;
         cuota_obligacion_v2.this.AV54TipoConCod = GXv_char10[0] ;
         if ( GXutil.strcmp(AV56OblTipoMov, "Descuento") == 0 )
         {
            if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
            {
               AV16Importes = AV51LiqOblCuota ;
            }
            else
            {
               AV16Importes = AV51LiqOblCuota.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
         }
         else
         {
            if ( GXutil.strcmp(AV54TipoConCod, "DES_ARG") == 0 )
            {
               AV16Importes = AV51LiqOblCuota.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
            else
            {
               AV16Importes = AV51LiqOblCuota ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = cuota_obligacion_v2.this.AV16Importes;
      this.aP11[0] = cuota_obligacion_v2.this.AV19LiqDLog;
      this.aP12[0] = cuota_obligacion_v2.this.AV38error;
      this.aP13[0] = cuota_obligacion_v2.this.AV8LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Importes = DecimalUtil.ZERO ;
      AV19LiqDLog = "" ;
      AV38error = "" ;
      AV59Pgmname = "" ;
      AV9TLiqCod = "" ;
      AV13egresoTLiqCod = "" ;
      AV14mensualTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      scmdbuf = "" ;
      P01A02_A1173OblEstado = new byte[1] ;
      P01A02_A1163TipoOblSec = new short[1] ;
      P01A02_A6LegNumero = new int[1] ;
      P01A02_A1EmpCod = new short[1] ;
      P01A02_A3CliCod = new int[1] ;
      P01A02_A1172OblSecuencial = new short[1] ;
      AV29abiertos_OblSecuencial = new GXSimpleCollection<Short>(Short.class, "internal", "");
      P01A03_A3CliCod = new int[1] ;
      P01A03_A1EmpCod = new short[1] ;
      P01A03_A1172OblSecuencial = new short[1] ;
      P01A03_A6LegNumero = new int[1] ;
      P01A03_A1185LiqOblNuevaNro = new int[1] ;
      P01A03_A1184LiqOblAltaNro = new int[1] ;
      GXv_int5 = new short[1] ;
      AV44OblTotal = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV42OblImpFij = DecimalUtil.ZERO ;
      AV43OblPorc = DecimalUtil.ZERO ;
      AV55OblConcepto = "" ;
      AV56OblTipoMov = "" ;
      GXv_char2 = new String[1] ;
      AV46oblImpError = "" ;
      AV51LiqOblCuota = DecimalUtil.ZERO ;
      AV53nuevo_LiqOblSaldo = DecimalUtil.ZERO ;
      AV36nuevoError = "" ;
      AV22nuevoLiqDLog = "" ;
      P01A04_A1186LiqOblPrimera = new boolean[] {false} ;
      P01A04_A1185LiqOblNuevaNro = new int[1] ;
      P01A04_A1184LiqOblAltaNro = new int[1] ;
      P01A04_A1172OblSecuencial = new short[1] ;
      P01A04_A6LegNumero = new int[1] ;
      P01A04_A1EmpCod = new short[1] ;
      P01A04_A3CliCod = new int[1] ;
      P01A04_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A04_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A04_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A04_A1187LiqOblLog = new String[] {""} ;
      P01A04_A1189LiqOblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1197LiqOblSaldo = DecimalUtil.ZERO ;
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      A1187LiqOblLog = "" ;
      A1189LiqOblTotal = DecimalUtil.ZERO ;
      P01A06_A1163TipoOblSec = new short[1] ;
      P01A06_A1172OblSecuencial = new short[1] ;
      P01A06_A1185LiqOblNuevaNro = new int[1] ;
      P01A06_A6LegNumero = new int[1] ;
      P01A06_A1EmpCod = new short[1] ;
      P01A06_A3CliCod = new int[1] ;
      P01A06_A1184LiqOblAltaNro = new int[1] ;
      P01A06_A1177OblCanCuo = new short[1] ;
      P01A06_A1161EmbargaSec = new short[1] ;
      P01A06_n1161EmbargaSec = new boolean[] {false} ;
      P01A06_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A06_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      AV25LiqLegConSaldo = DecimalUtil.ZERO ;
      GXv_int7 = new short[1] ;
      AV24calculoLiqDLog = "" ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_int11 = new byte[1] ;
      GXv_char4 = new String[1] ;
      P01A07_A1172OblSecuencial = new short[1] ;
      P01A07_A1185LiqOblNuevaNro = new int[1] ;
      P01A07_A6LegNumero = new int[1] ;
      P01A07_A1EmpCod = new short[1] ;
      P01A07_A3CliCod = new int[1] ;
      P01A07_A2343OblConcepto = new String[] {""} ;
      P01A07_A2345OblTipoMov = new String[] {""} ;
      P01A07_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A07_A1184LiqOblAltaNro = new int[1] ;
      A2343OblConcepto = "" ;
      A2345OblTipoMov = "" ;
      AV54TipoConCod = "" ;
      A1199LiqOblPeriodo = GXutil.nullDate() ;
      P01A08_A1172OblSecuencial = new short[1] ;
      P01A08_A1185LiqOblNuevaNro = new int[1] ;
      P01A08_A1199LiqOblPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01A08_A6LegNumero = new int[1] ;
      P01A08_A1EmpCod = new short[1] ;
      P01A08_A3CliCod = new int[1] ;
      P01A08_A2343OblConcepto = new String[] {""} ;
      P01A08_A2345OblTipoMov = new String[] {""} ;
      P01A08_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A08_A1184LiqOblAltaNro = new int[1] ;
      GXv_char10 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cuota_obligacion_v2__default(),
         new Object[] {
             new Object[] {
            P01A02_A1173OblEstado, P01A02_A1163TipoOblSec, P01A02_A6LegNumero, P01A02_A1EmpCod, P01A02_A3CliCod, P01A02_A1172OblSecuencial
            }
            , new Object[] {
            P01A03_A3CliCod, P01A03_A1EmpCod, P01A03_A1172OblSecuencial, P01A03_A6LegNumero, P01A03_A1185LiqOblNuevaNro, P01A03_A1184LiqOblAltaNro
            }
            , new Object[] {
            P01A04_A1186LiqOblPrimera, P01A04_A1185LiqOblNuevaNro, P01A04_A1184LiqOblAltaNro, P01A04_A1172OblSecuencial, P01A04_A6LegNumero, P01A04_A1EmpCod, P01A04_A3CliCod, P01A04_A1197LiqOblSaldo, P01A04_A1188LiqOblCuota, P01A04_A1190LiqOblTotRecal,
            P01A04_A1187LiqOblLog, P01A04_A1189LiqOblTotal
            }
            , new Object[] {
            }
            , new Object[] {
            P01A06_A1163TipoOblSec, P01A06_A1172OblSecuencial, P01A06_A1185LiqOblNuevaNro, P01A06_A6LegNumero, P01A06_A1EmpCod, P01A06_A3CliCod, P01A06_A1184LiqOblAltaNro, P01A06_A1177OblCanCuo, P01A06_A1161EmbargaSec, P01A06_n1161EmbargaSec,
            P01A06_A1178OblImpFij, P01A06_A1179OblPorc
            }
            , new Object[] {
            P01A07_A1172OblSecuencial, P01A07_A1185LiqOblNuevaNro, P01A07_A6LegNumero, P01A07_A1EmpCod, P01A07_A3CliCod, P01A07_A2343OblConcepto, P01A07_A2345OblTipoMov, P01A07_A1197LiqOblSaldo, P01A07_A1184LiqOblAltaNro
            }
            , new Object[] {
            P01A08_A1172OblSecuencial, P01A08_A1185LiqOblNuevaNro, P01A08_A1199LiqOblPeriodo, P01A08_A6LegNumero, P01A08_A1EmpCod, P01A08_A3CliCod, P01A08_A2343OblConcepto, P01A08_A2345OblTipoMov, P01A08_A1188LiqOblCuota, P01A08_A1184LiqOblAltaNro
            }
         }
      );
      AV59Pgmname = "cuota_obligacion_v2" ;
      /* GeneXus formulas. */
      AV59Pgmname = "cuota_obligacion_v2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV60GXLvl8 ;
   private byte A1173OblEstado ;
   private byte AV61GXLvl26 ;
   private byte AV47oblImpLiqDCalculado ;
   private byte AV37nuevoLiqDCalculado ;
   private byte AV62GXLvl73 ;
   private byte GXv_int11[] ;
   private short AV11EmpCod ;
   private short AV30TipoOblSec ;
   private short AV35PaiCod ;
   private short A1163TipoOblSec ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short AV31primer_OblSecuencial ;
   private short AV48llevaSaldo ;
   private short AV39i ;
   private short AV40OblSecuencial ;
   private short AV49EmbargaSec ;
   private short GXv_int5[] ;
   private short AV41OblCanCuo ;
   private short A1177OblCanCuo ;
   private short A1161EmbargaSec ;
   private short AV32cantLiquidadas ;
   private short GXv_int7[] ;
   private short AV33mesesQueFaltan ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV18LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1185LiqOblNuevaNro ;
   private int A1184LiqOblAltaNro ;
   private int AV20anteriorLiqNro ;
   private java.math.BigDecimal AV16Importes ;
   private java.math.BigDecimal AV44OblTotal ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV42OblImpFij ;
   private java.math.BigDecimal AV43OblPorc ;
   private java.math.BigDecimal AV51LiqOblCuota ;
   private java.math.BigDecimal AV53nuevo_LiqOblSaldo ;
   private java.math.BigDecimal A1197LiqOblSaldo ;
   private java.math.BigDecimal A1188LiqOblCuota ;
   private java.math.BigDecimal A1190LiqOblTotRecal ;
   private java.math.BigDecimal A1189LiqOblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private java.math.BigDecimal AV25LiqLegConSaldo ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV34ConCodigo ;
   private String AV26ProcesoLiquidacion ;
   private String AV59Pgmname ;
   private String AV9TLiqCod ;
   private String AV13egresoTLiqCod ;
   private String AV14mensualTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String AV55OblConcepto ;
   private String AV56OblTipoMov ;
   private String GXv_char2[] ;
   private String GXv_char4[] ;
   private String A2343OblConcepto ;
   private String A2345OblTipoMov ;
   private String AV54TipoConCod ;
   private String GXv_char10[] ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date A1199LiqOblPeriodo ;
   private boolean AV27insertandoConceptos ;
   private boolean returnInSub ;
   private boolean A1186LiqOblPrimera ;
   private boolean n1161EmbargaSec ;
   private String AV19LiqDLog ;
   private String AV22nuevoLiqDLog ;
   private String AV24calculoLiqDLog ;
   private String AV38error ;
   private String AV46oblImpError ;
   private String AV36nuevoError ;
   private String A1187LiqOblLog ;
   private GXSimpleCollection<Short> AV29abiertos_OblSecuencial ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01A02_A1173OblEstado ;
   private short[] P01A02_A1163TipoOblSec ;
   private int[] P01A02_A6LegNumero ;
   private short[] P01A02_A1EmpCod ;
   private int[] P01A02_A3CliCod ;
   private short[] P01A02_A1172OblSecuencial ;
   private int[] P01A03_A3CliCod ;
   private short[] P01A03_A1EmpCod ;
   private short[] P01A03_A1172OblSecuencial ;
   private int[] P01A03_A6LegNumero ;
   private int[] P01A03_A1185LiqOblNuevaNro ;
   private int[] P01A03_A1184LiqOblAltaNro ;
   private boolean[] P01A04_A1186LiqOblPrimera ;
   private int[] P01A04_A1185LiqOblNuevaNro ;
   private int[] P01A04_A1184LiqOblAltaNro ;
   private short[] P01A04_A1172OblSecuencial ;
   private int[] P01A04_A6LegNumero ;
   private short[] P01A04_A1EmpCod ;
   private int[] P01A04_A3CliCod ;
   private java.math.BigDecimal[] P01A04_A1197LiqOblSaldo ;
   private java.math.BigDecimal[] P01A04_A1188LiqOblCuota ;
   private java.math.BigDecimal[] P01A04_A1190LiqOblTotRecal ;
   private String[] P01A04_A1187LiqOblLog ;
   private java.math.BigDecimal[] P01A04_A1189LiqOblTotal ;
   private short[] P01A06_A1163TipoOblSec ;
   private short[] P01A06_A1172OblSecuencial ;
   private int[] P01A06_A1185LiqOblNuevaNro ;
   private int[] P01A06_A6LegNumero ;
   private short[] P01A06_A1EmpCod ;
   private int[] P01A06_A3CliCod ;
   private int[] P01A06_A1184LiqOblAltaNro ;
   private short[] P01A06_A1177OblCanCuo ;
   private short[] P01A06_A1161EmbargaSec ;
   private boolean[] P01A06_n1161EmbargaSec ;
   private java.math.BigDecimal[] P01A06_A1178OblImpFij ;
   private java.math.BigDecimal[] P01A06_A1179OblPorc ;
   private short[] P01A07_A1172OblSecuencial ;
   private int[] P01A07_A1185LiqOblNuevaNro ;
   private int[] P01A07_A6LegNumero ;
   private short[] P01A07_A1EmpCod ;
   private int[] P01A07_A3CliCod ;
   private String[] P01A07_A2343OblConcepto ;
   private String[] P01A07_A2345OblTipoMov ;
   private java.math.BigDecimal[] P01A07_A1197LiqOblSaldo ;
   private int[] P01A07_A1184LiqOblAltaNro ;
   private short[] P01A08_A1172OblSecuencial ;
   private int[] P01A08_A1185LiqOblNuevaNro ;
   private java.util.Date[] P01A08_A1199LiqOblPeriodo ;
   private int[] P01A08_A6LegNumero ;
   private short[] P01A08_A1EmpCod ;
   private int[] P01A08_A3CliCod ;
   private String[] P01A08_A2343OblConcepto ;
   private String[] P01A08_A2345OblTipoMov ;
   private java.math.BigDecimal[] P01A08_A1188LiqOblCuota ;
   private int[] P01A08_A1184LiqOblAltaNro ;
}

final  class cuota_obligacion_v2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01A06( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1172OblSecuencial ,
                                          GXSimpleCollection<Short> AV29abiertos_OblSecuencial ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int AV20anteriorLiqNro ,
                                          int AV18LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1185LiqOblNuevaNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[4];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T2.TipoOblSec, T1.OblSecuencial, T1.LiqOblNuevaNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqOblAltaNro, T2.OblCanCuo, T3.EmbargaSec, T2.OblImpFij, T2.OblPorc" ;
      scmdbuf += " FROM ((LiqLegObligacionCuenta T1 INNER JOIN Obligacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero AND T2.OblSecuencial" ;
      scmdbuf += " = T1.OblSecuencial) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T2.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqOblNuevaNro = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29abiertos_OblSecuencial, "T1.OblSecuencial IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqOblNuevaNro, T1.LegNumero" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P01A07( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1172OblSecuencial ,
                                          GXSimpleCollection<Short> AV29abiertos_OblSecuencial ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int AV20anteriorLiqNro ,
                                          int AV18LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1185LiqOblNuevaNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[4];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT T1.OblSecuencial, T1.LiqOblNuevaNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.OblConcepto, T2.OblTipoMov, T1.LiqOblSaldo, T1.LiqOblAltaNro FROM (LiqLegObligacionCuenta" ;
      scmdbuf += " T1 INNER JOIN Obligacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero AND T2.OblSecuencial = T1.OblSecuencial)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqOblNuevaNro = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29abiertos_OblSecuencial, "T1.OblSecuencial IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqOblNuevaNro, T1.LegNumero" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_P01A08( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1172OblSecuencial ,
                                          GXSimpleCollection<Short> AV29abiertos_OblSecuencial ,
                                          java.util.Date A1199LiqOblPeriodo ,
                                          java.util.Date AV15LiqPeriodo ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int AV12LiqNro ,
                                          int AV18LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1185LiqOblNuevaNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[5];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT T1.OblSecuencial, T1.LiqOblNuevaNro, T1.LiqOblPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.OblConcepto, T2.OblTipoMov, T1.LiqOblCuota, T1.LiqOblAltaNro" ;
      scmdbuf += " FROM (LiqLegObligacionCuenta T1 INNER JOIN Obligacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero AND T2.OblSecuencial" ;
      scmdbuf += " = T1.OblSecuencial)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqOblNuevaNro = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29abiertos_OblSecuencial, "T1.OblSecuencial IN (", ")")+")");
      addWhere(sWhereString, "(T1.LiqOblPeriodo = ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqOblNuevaNro, T1.LegNumero" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 4 :
                  return conditional_P01A06(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
            case 5 :
                  return conditional_P01A07(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
            case 6 :
                  return conditional_P01A08(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01A02", "SELECT OblEstado, TipoOblSec, LegNumero, EmpCod, CliCod, OblSecuencial FROM Obligacion WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and TipoOblSec = ?) AND (OblEstado = 1) ORDER BY CliCod, EmpCod, LegNumero, TipoOblSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01A03", "SELECT CliCod, EmpCod, OblSecuencial, LegNumero, LiqOblNuevaNro, LiqOblAltaNro FROM LiqLegObligacionCuenta WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LiqOblNuevaNro < ?) AND (OblSecuencial = ?) ORDER BY CliCod, EmpCod, LegNumero, LiqOblNuevaNro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01A04", "SELECT LiqOblPrimera, LiqOblNuevaNro, LiqOblAltaNro, OblSecuencial, LegNumero, EmpCod, CliCod, LiqOblSaldo, LiqOblCuota, LiqOblTotRecal, LiqOblLog, LiqOblTotal FROM LiqLegObligacionCuenta WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? and LiqOblAltaNro = ? and LiqOblNuevaNro = ?) AND (LiqOblPrimera = TRUE) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro  FOR UPDATE OF LiqLegObligacionCuenta",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01A05", "SAVEPOINT gxupdate;UPDATE LiqLegObligacionCuenta SET LiqOblSaldo=?, LiqOblCuota=?, LiqOblTotRecal=?, LiqOblLog=?, LiqOblTotal=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01A06", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01A07", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01A08", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,4);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 3 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setVarchar(4, (String)parms[3], 1000, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               return;
      }
   }

}

