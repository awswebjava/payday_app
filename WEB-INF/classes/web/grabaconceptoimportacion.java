package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaconceptoimportacion extends GXProcedure
{
   public grabaconceptoimportacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaconceptoimportacion.class ), "" );
   }

   public grabaconceptoimportacion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 )
   {
      grabaconceptoimportacion.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        String aP17 ,
                        String aP18 ,
                        String aP19 ,
                        String aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 ,
                             String[] aP21 )
   {
      grabaconceptoimportacion.this.AV28CliCod = aP0;
      grabaconceptoimportacion.this.AV27EmpCod = aP1;
      grabaconceptoimportacion.this.AV29ImpLiqSec = aP2;
      grabaconceptoimportacion.this.AV26ImpLiqConExtCod = aP3;
      grabaconceptoimportacion.this.AV25ImpLiqConExtDescrip = aP4;
      grabaconceptoimportacion.this.AV23ImpLiqConAfipCod = aP5;
      grabaconceptoimportacion.this.AV8ImpLiqRegEspApo = aP6;
      grabaconceptoimportacion.this.AV9ImpLiqRegDifApo = aP7;
      grabaconceptoimportacion.this.AV14ImpLiqRenateaApo = aP8;
      grabaconceptoimportacion.this.AV16ImpLiqFonSolRedApo = aP9;
      grabaconceptoimportacion.this.AV18ImpLiqObraSocApo = aP10;
      grabaconceptoimportacion.this.AV20ImpLiqINSSJyPApo = aP11;
      grabaconceptoimportacion.this.AV22ImpLiqSIPAApo = aP12;
      grabaconceptoimportacion.this.AV10ImpLiqLeyRieTrabCont = aP13;
      grabaconceptoimportacion.this.AV11ImpLiqFonNacEmpCont = aP14;
      grabaconceptoimportacion.this.AV12ImpLiqAsigFamCont = aP15;
      grabaconceptoimportacion.this.AV13ImpLiqRenateaCont = aP16;
      grabaconceptoimportacion.this.AV15ImpLiqFonSolRedCont = aP17;
      grabaconceptoimportacion.this.AV17ImpLiqObraSocCont = aP18;
      grabaconceptoimportacion.this.AV19ImpLiqINSSJyPCont = aP19;
      grabaconceptoimportacion.this.AV21ImpLiqSIPACont = aP20;
      grabaconceptoimportacion.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE importacion_conceptos

      */
      A3CliCod = AV28CliCod ;
      A1EmpCod = AV27EmpCod ;
      A88ImpLiqSec = AV29ImpLiqSec ;
      A89ImpLiqConExtCod = GXutil.trim( AV26ImpLiqConExtCod) ;
      A640ImpLiqConExtDescrip = AV25ImpLiqConExtDescrip ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "hola &ImpLiqConExtDescrip ", "")+GXutil.trim( AV25ImpLiqConExtDescrip)) ;
      GXt_char1 = A2186ImpLiqConExtDesSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( GXutil.trim( AV25ImpLiqConExtDescrip), GXv_char2) ;
      grabaconceptoimportacion.this.GXt_char1 = GXv_char2[0] ;
      A2186ImpLiqConExtDesSinAc = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "sin ac ", "")+GXutil.trim( A2186ImpLiqConExtDesSinAc)) ;
      A701ImpLiqConExtCodYDescrip = GXutil.trim( A89ImpLiqConExtCod) + " - " + GXutil.trim( A640ImpLiqConExtDescrip) ;
      A641ImpLiqConSisCod = "" ;
      A642ImpLiqConAfipCod = AV23ImpLiqConAfipCod ;
      if ( ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() >= 110000 ) && ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() <= 499999 ) )
      {
         A911ImpLiqTipoConCod = "REM_ARG" ;
      }
      else if ( ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() >= 510000 ) && ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() <= 799999 ) )
      {
         A911ImpLiqTipoConCod = "NRE_ARG" ;
      }
      else if ( ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() >= 810000 ) && ( CommonUtil.decimalVal( AV23ImpLiqConAfipCod, ".").doubleValue() <= 829999 ) )
      {
         A911ImpLiqTipoConCod = "DES_ARG" ;
      }
      else
      {
         A911ImpLiqTipoConCod = "CAL_ARG" ;
      }
      /* Execute user subroutine: 'GET CODIGO Y DESC' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      A912ImpLiqAfipCodMasDesc = AV31ImpLiqAfipCodMasDesc ;
      A643ImpLiqSIPAApo = AV22ImpLiqSIPAApo ;
      A644ImpLiqSIPACont = AV21ImpLiqSIPACont ;
      A645ImpLiqINSSJyPApo = AV20ImpLiqINSSJyPApo ;
      A646ImpLiqINSSJyPCont = AV19ImpLiqINSSJyPCont ;
      A647ImpLiqObraSocApo = AV18ImpLiqObraSocApo ;
      A648ImpLiqObraSocCont = AV17ImpLiqObraSocCont ;
      A649ImpLiqFonSolRedApo = AV16ImpLiqFonSolRedApo ;
      A650ImpLiqFonSolRedCont = AV15ImpLiqFonSolRedCont ;
      A651ImpLiqRenateaApo = AV14ImpLiqRenateaApo ;
      A652ImpLiqRenateaCont = AV13ImpLiqRenateaCont ;
      A653ImpLiqAsigFamCont = AV12ImpLiqAsigFamCont ;
      A654ImpLiqFonNacEmpCont = AV11ImpLiqFonNacEmpCont ;
      A655ImpLiqLeyRieTrabCont = AV10ImpLiqLeyRieTrabCont ;
      A656ImpLiqRegDifApo = AV9ImpLiqRegDifApo ;
      A657ImpLiqRegEspApo = AV8ImpLiqRegEspApo ;
      /* Using cursor P00N62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod, A640ImpLiqConExtDescrip, A641ImpLiqConSisCod, A642ImpLiqConAfipCod, A643ImpLiqSIPAApo, A644ImpLiqSIPACont, A645ImpLiqINSSJyPApo, A646ImpLiqINSSJyPCont, A647ImpLiqObraSocApo, A648ImpLiqObraSocCont, A649ImpLiqFonSolRedApo, A650ImpLiqFonSolRedCont, A651ImpLiqRenateaApo, A652ImpLiqRenateaCont, A653ImpLiqAsigFamCont, A654ImpLiqFonNacEmpCont, A655ImpLiqLeyRieTrabCont, A656ImpLiqRegDifApo, A657ImpLiqRegEspApo, A701ImpLiqConExtCodYDescrip, A911ImpLiqTipoConCod, A912ImpLiqAfipCodMasDesc, A2186ImpLiqConExtDesSinAc});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /* Using cursor P00N63 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV28CliCod), Short.valueOf(AV27EmpCod), Short.valueOf(AV29ImpLiqSec), AV26ImpLiqConExtCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A89ImpLiqConExtCod = P00N63_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P00N63_A88ImpLiqSec[0] ;
         A1EmpCod = P00N63_A1EmpCod[0] ;
         A3CliCod = P00N63_A3CliCod[0] ;
         A2186ImpLiqConExtDesSinAc = P00N63_A2186ImpLiqConExtDesSinAc[0] ;
         A641ImpLiqConSisCod = P00N63_A641ImpLiqConSisCod[0] ;
         A659ImpLiqConError = P00N63_A659ImpLiqConError[0] ;
         A702ImpLiqConSisCodYDescrip = P00N63_A702ImpLiqConSisCodYDescrip[0] ;
         A660ImpLiqConWarning = P00N63_A660ImpLiqConWarning[0] ;
         GXv_char2[0] = AV35AfipConTipoConCod ;
         new web.getafipconceptotipo(remoteHandle, context).execute( AV23ImpLiqConAfipCod, GXv_char2) ;
         grabaconceptoimportacion.this.AV35AfipConTipoConCod = GXv_char2[0] ;
         AV37ImpLiqConExtDesSinAc = GXutil.trim( A2186ImpLiqConExtDesSinAc) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "&ImpLiqConExtDesSinAc ", "")+AV37ImpLiqConExtDesSinAc) ;
         if ( GXutil.strSearch( GXutil.upper( AV37ImpLiqConExtDesSinAc), httpContext.getMessage( "DESC.", ""), 1) != 0 )
         {
            AV37ImpLiqConExtDesSinAc = GXutil.strReplace( AV37ImpLiqConExtDesSinAc, httpContext.getMessage( "DESC.", ""), httpContext.getMessage( "DESCUENTO", "")) ;
            AV37ImpLiqConExtDesSinAc += httpContext.getMessage( " DESCUENTO", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "tiene desc., queda ", "")+AV37ImpLiqConExtDesSinAc) ;
         }
         else
         {
            if ( GXutil.strSearch( GXutil.upper( AV37ImpLiqConExtDesSinAc), httpContext.getMessage( "S.A.C.", ""), 1) != 0 )
            {
               AV37ImpLiqConExtDesSinAc = GXutil.strReplace( AV37ImpLiqConExtDesSinAc, httpContext.getMessage( "S.A.C.", ""), httpContext.getMessage( "SUELDO ANUAL COMPLEMENTARIO", "")) ;
            }
         }
         AV37ImpLiqConExtDesSinAc = GXutil.strReplace( AV37ImpLiqConExtDesSinAc, "-", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "leo de la base ImpLiqConExtDesSinAc! ", "")+AV37ImpLiqConExtDesSinAc) ;
         GXv_char2[0] = AV24ImpLiqConSisCod ;
         GXv_boolean3[0] = AV34matchExactoEs ;
         GXv_char4[0] = AV36ImpLiqConWarning ;
         new web.getconceptopropioporafip(remoteHandle, context).execute( AV28CliCod, AV23ImpLiqConAfipCod, AV37ImpLiqConExtDesSinAc, AV35AfipConTipoConCod, GXv_char2, GXv_boolean3, GXv_char4) ;
         grabaconceptoimportacion.this.AV24ImpLiqConSisCod = GXv_char2[0] ;
         grabaconceptoimportacion.this.AV34matchExactoEs = GXv_boolean3[0] ;
         grabaconceptoimportacion.this.AV36ImpLiqConWarning = GXv_char4[0] ;
         A641ImpLiqConSisCod = AV24ImpLiqConSisCod ;
         if ( (GXutil.strcmp("", AV24ImpLiqConSisCod)==0) )
         {
            A659ImpLiqConError = httpContext.getMessage( "No se pudo relacionar a un concepto el código \"", "") + GXutil.trim( AV26ImpLiqConExtCod) + httpContext.getMessage( "\", por favor seleccione uno de los disponibles", "") ;
         }
         if ( ! (GXutil.strcmp("", AV24ImpLiqConSisCod)==0) )
         {
            GXt_char1 = AV30ConDescrip ;
            GXv_char4[0] = GXt_char1 ;
            new web.conceptogetdescri(remoteHandle, context).execute( AV28CliCod, AV24ImpLiqConSisCod, GXv_char4) ;
            grabaconceptoimportacion.this.GXt_char1 = GXv_char4[0] ;
            AV30ConDescrip = GXt_char1 ;
            A702ImpLiqConSisCodYDescrip = GXutil.trim( AV24ImpLiqConSisCod) + " - " + GXutil.trim( AV30ConDescrip) ;
         }
         A660ImpLiqConWarning = AV36ImpLiqConWarning ;
         /* Using cursor P00N64 */
         pr_default.execute(2, new Object[] {A641ImpLiqConSisCod, A659ImpLiqConError, A702ImpLiqConSisCodYDescrip, A660ImpLiqConWarning, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "&ImpLiqConSisCod ", "")+AV24ImpLiqConSisCod) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GET CODIGO Y DESC' Routine */
      returnInSub = false ;
      AV42GXLvl109 = (byte)(0) ;
      /* Using cursor P00N65 */
      pr_default.execute(3, new Object[] {AV23ImpLiqConAfipCod});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A72AFIPConCod = P00N65_A72AFIPConCod[0] ;
         A385AfipConCodMasDesc = P00N65_A385AfipConCodMasDesc[0] ;
         AV42GXLvl109 = (byte)(1) ;
         AV31ImpLiqAfipCodMasDesc = A385AfipConCodMasDesc ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      if ( AV42GXLvl109 == 0 )
      {
         AV32ImpLiqConAfipCodNum = (int)(GXutil.lval( AV23ImpLiqConAfipCod)) ;
         /* Using cursor P00N66 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV32ImpLiqConAfipCodNum), Integer.valueOf(AV32ImpLiqConAfipCodNum)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A376SubTRangoHasta = P00N66_A376SubTRangoHasta[0] ;
            A375SubTRangoDesde = P00N66_A375SubTRangoDesde[0] ;
            A371SubTipoConDes1 = P00N66_A371SubTipoConDes1[0] ;
            A37TipoConCod = P00N66_A37TipoConCod[0] ;
            A38SubTipoConCod1 = P00N66_A38SubTipoConCod1[0] ;
            AV31ImpLiqAfipCodMasDesc = GXutil.trim( AV23ImpLiqConAfipCod) + " (" + GXutil.trim( GXutil.str( A375SubTRangoDesde, 8, 0)) + "/" + GXutil.trim( GXutil.str( A376SubTRangoHasta, 8, 0)) + " " + GXutil.trim( A371SubTipoConDes1) + ")" ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(4);
         }
         pr_default.close(4);
      }
      if ( GXutil.strSearch( GXutil.upper( AV31ImpLiqAfipCodMasDesc), httpContext.getMessage( "GENERAL", ""), 1) != 0 )
      {
         /* Using cursor P00N67 */
         pr_default.execute(5, new Object[] {AV23ImpLiqConAfipCod});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A37TipoConCod = P00N67_A37TipoConCod[0] ;
            A38SubTipoConCod1 = P00N67_A38SubTipoConCod1[0] ;
            A39SubTipoConCod2 = P00N67_A39SubTipoConCod2[0] ;
            A372SubTipoConDes2 = P00N67_A372SubTipoConDes2[0] ;
            A371SubTipoConDes1 = P00N67_A371SubTipoConDes1[0] ;
            A371SubTipoConDes1 = P00N67_A371SubTipoConDes1[0] ;
            AV31ImpLiqAfipCodMasDesc = GXutil.trim( AV23ImpLiqConAfipCod) + " - " + GXutil.trim( A371SubTipoConDes1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(5);
         }
         pr_default.close(5);
      }
      if ( (GXutil.strcmp("", AV31ImpLiqAfipCodMasDesc)==0) )
      {
         AV31ImpLiqAfipCodMasDesc = GXutil.trim( AV23ImpLiqConAfipCod) ;
      }
   }

   protected void cleanup( )
   {
      this.aP21[0] = grabaconceptoimportacion.this.AV24ImpLiqConSisCod;
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaconceptoimportacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24ImpLiqConSisCod = "" ;
      A89ImpLiqConExtCod = "" ;
      A640ImpLiqConExtDescrip = "" ;
      AV40Pgmname = "" ;
      A2186ImpLiqConExtDesSinAc = "" ;
      A701ImpLiqConExtCodYDescrip = "" ;
      A641ImpLiqConSisCod = "" ;
      A642ImpLiqConAfipCod = "" ;
      A911ImpLiqTipoConCod = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      AV31ImpLiqAfipCodMasDesc = "" ;
      A643ImpLiqSIPAApo = "" ;
      A644ImpLiqSIPACont = "" ;
      A645ImpLiqINSSJyPApo = "" ;
      A646ImpLiqINSSJyPCont = "" ;
      A647ImpLiqObraSocApo = "" ;
      A648ImpLiqObraSocCont = "" ;
      A649ImpLiqFonSolRedApo = "" ;
      A650ImpLiqFonSolRedCont = "" ;
      A651ImpLiqRenateaApo = "" ;
      A652ImpLiqRenateaCont = "" ;
      A653ImpLiqAsigFamCont = "" ;
      A654ImpLiqFonNacEmpCont = "" ;
      A655ImpLiqLeyRieTrabCont = "" ;
      A656ImpLiqRegDifApo = "" ;
      A657ImpLiqRegEspApo = "" ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P00N63_A89ImpLiqConExtCod = new String[] {""} ;
      P00N63_A88ImpLiqSec = new short[1] ;
      P00N63_A1EmpCod = new short[1] ;
      P00N63_A3CliCod = new int[1] ;
      P00N63_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      P00N63_A641ImpLiqConSisCod = new String[] {""} ;
      P00N63_A659ImpLiqConError = new String[] {""} ;
      P00N63_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00N63_A660ImpLiqConWarning = new String[] {""} ;
      A659ImpLiqConError = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A660ImpLiqConWarning = "" ;
      AV35AfipConTipoConCod = "" ;
      AV37ImpLiqConExtDesSinAc = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV36ImpLiqConWarning = "" ;
      AV30ConDescrip = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      A385AfipConCodMasDesc = "" ;
      P00N65_A72AFIPConCod = new String[] {""} ;
      P00N65_A385AfipConCodMasDesc = new String[] {""} ;
      A72AFIPConCod = "" ;
      P00N66_A376SubTRangoHasta = new int[1] ;
      P00N66_A375SubTRangoDesde = new int[1] ;
      P00N66_A371SubTipoConDes1 = new String[] {""} ;
      P00N66_A37TipoConCod = new String[] {""} ;
      P00N66_A38SubTipoConCod1 = new String[] {""} ;
      A371SubTipoConDes1 = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      P00N67_A37TipoConCod = new String[] {""} ;
      P00N67_A38SubTipoConCod1 = new String[] {""} ;
      P00N67_A39SubTipoConCod2 = new String[] {""} ;
      P00N67_A372SubTipoConDes2 = new String[] {""} ;
      P00N67_A371SubTipoConDes1 = new String[] {""} ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaconceptoimportacion__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P00N63_A89ImpLiqConExtCod, P00N63_A88ImpLiqSec, P00N63_A1EmpCod, P00N63_A3CliCod, P00N63_A2186ImpLiqConExtDesSinAc, P00N63_A641ImpLiqConSisCod, P00N63_A659ImpLiqConError, P00N63_A702ImpLiqConSisCodYDescrip, P00N63_A660ImpLiqConWarning
            }
            , new Object[] {
            }
            , new Object[] {
            P00N65_A72AFIPConCod, P00N65_A385AfipConCodMasDesc
            }
            , new Object[] {
            P00N66_A376SubTRangoHasta, P00N66_A375SubTRangoDesde, P00N66_A371SubTipoConDes1, P00N66_A37TipoConCod, P00N66_A38SubTipoConCod1
            }
            , new Object[] {
            P00N67_A37TipoConCod, P00N67_A38SubTipoConCod1, P00N67_A39SubTipoConCod2, P00N67_A372SubTipoConDes2, P00N67_A371SubTipoConDes1
            }
         }
      );
      AV40Pgmname = "grabaConceptoImportacion" ;
      /* GeneXus formulas. */
      AV40Pgmname = "grabaConceptoImportacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV42GXLvl109 ;
   private short AV27EmpCod ;
   private short AV29ImpLiqSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short Gx_err ;
   private int AV28CliCod ;
   private int GX_INS77 ;
   private int A3CliCod ;
   private int AV32ImpLiqConAfipCodNum ;
   private int A376SubTRangoHasta ;
   private int A375SubTRangoDesde ;
   private String AV26ImpLiqConExtCod ;
   private String AV23ImpLiqConAfipCod ;
   private String AV8ImpLiqRegEspApo ;
   private String AV9ImpLiqRegDifApo ;
   private String AV14ImpLiqRenateaApo ;
   private String AV16ImpLiqFonSolRedApo ;
   private String AV18ImpLiqObraSocApo ;
   private String AV20ImpLiqINSSJyPApo ;
   private String AV22ImpLiqSIPAApo ;
   private String AV10ImpLiqLeyRieTrabCont ;
   private String AV11ImpLiqFonNacEmpCont ;
   private String AV12ImpLiqAsigFamCont ;
   private String AV13ImpLiqRenateaCont ;
   private String AV15ImpLiqFonSolRedCont ;
   private String AV17ImpLiqObraSocCont ;
   private String AV19ImpLiqINSSJyPCont ;
   private String AV21ImpLiqSIPACont ;
   private String AV24ImpLiqConSisCod ;
   private String A89ImpLiqConExtCod ;
   private String AV40Pgmname ;
   private String A641ImpLiqConSisCod ;
   private String A642ImpLiqConAfipCod ;
   private String A911ImpLiqTipoConCod ;
   private String A643ImpLiqSIPAApo ;
   private String A644ImpLiqSIPACont ;
   private String A645ImpLiqINSSJyPApo ;
   private String A646ImpLiqINSSJyPCont ;
   private String A647ImpLiqObraSocApo ;
   private String A648ImpLiqObraSocCont ;
   private String A649ImpLiqFonSolRedApo ;
   private String A650ImpLiqFonSolRedCont ;
   private String A651ImpLiqRenateaApo ;
   private String A652ImpLiqRenateaCont ;
   private String A653ImpLiqAsigFamCont ;
   private String A654ImpLiqFonNacEmpCont ;
   private String A655ImpLiqLeyRieTrabCont ;
   private String A656ImpLiqRegDifApo ;
   private String A657ImpLiqRegEspApo ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private String AV35AfipConTipoConCod ;
   private String GXv_char2[] ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String A72AFIPConCod ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private boolean returnInSub ;
   private boolean AV34matchExactoEs ;
   private boolean GXv_boolean3[] ;
   private String AV25ImpLiqConExtDescrip ;
   private String A640ImpLiqConExtDescrip ;
   private String A2186ImpLiqConExtDesSinAc ;
   private String A701ImpLiqConExtCodYDescrip ;
   private String A912ImpLiqAfipCodMasDesc ;
   private String AV31ImpLiqAfipCodMasDesc ;
   private String A659ImpLiqConError ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String A660ImpLiqConWarning ;
   private String AV37ImpLiqConExtDesSinAc ;
   private String AV36ImpLiqConWarning ;
   private String AV30ConDescrip ;
   private String A385AfipConCodMasDesc ;
   private String A371SubTipoConDes1 ;
   private String A372SubTipoConDes2 ;
   private String[] aP21 ;
   private IDataStoreProvider pr_default ;
   private String[] P00N63_A89ImpLiqConExtCod ;
   private short[] P00N63_A88ImpLiqSec ;
   private short[] P00N63_A1EmpCod ;
   private int[] P00N63_A3CliCod ;
   private String[] P00N63_A2186ImpLiqConExtDesSinAc ;
   private String[] P00N63_A641ImpLiqConSisCod ;
   private String[] P00N63_A659ImpLiqConError ;
   private String[] P00N63_A702ImpLiqConSisCodYDescrip ;
   private String[] P00N63_A660ImpLiqConWarning ;
   private String[] P00N65_A72AFIPConCod ;
   private String[] P00N65_A385AfipConCodMasDesc ;
   private int[] P00N66_A376SubTRangoHasta ;
   private int[] P00N66_A375SubTRangoDesde ;
   private String[] P00N66_A371SubTipoConDes1 ;
   private String[] P00N66_A37TipoConCod ;
   private String[] P00N66_A38SubTipoConCod1 ;
   private String[] P00N67_A37TipoConCod ;
   private String[] P00N67_A38SubTipoConCod1 ;
   private String[] P00N67_A39SubTipoConCod2 ;
   private String[] P00N67_A372SubTipoConDes2 ;
   private String[] P00N67_A371SubTipoConDes1 ;
}

final  class grabaconceptoimportacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00N62", "SAVEPOINT gxupdate;INSERT INTO importacion_conceptos(CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod, ImpLiqConExtDescrip, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConExtCodYDescrip, ImpLiqTipoConCod, ImpLiqAfipCodMasDesc, ImpLiqConExtDesSinAc, ImpLiqConError, ImpLiqConWarning, ImpLiqConSisCodYDescrip) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00N63", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConError, ImpLiqConSisCodYDescrip, ImpLiqConWarning FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod  FOR UPDATE OF importacion_conceptos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00N64", "SAVEPOINT gxupdate;UPDATE importacion_conceptos SET ImpLiqConSisCod=?, ImpLiqConError=?, ImpLiqConSisCodYDescrip=?, ImpLiqConWarning=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00N65", "SELECT AFIPConCod, AfipConCodMasDesc FROM AFIPConcepto WHERE AFIPConCod = ( ?) ORDER BY AFIPConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00N66", "SELECT SubTRangoHasta, SubTRangoDesde, SubTipoConDes1, TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE (SubTRangoDesde <= ?) AND (SubTRangoHasta >= ?) ORDER BY TipoConCod, SubTipoConCod1  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00N67", "SELECT T1.TipoConCod, T1.SubTipoConCod1, T1.SubTipoConCod2, T1.SubTipoConDes2, T2.SubTipoConDes1 FROM (tipo_concepto_subtipo2 T1 INNER JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) WHERE T1.SubTipoConCod2 = ( ?) ORDER BY T1.TipoConCod, T1.SubTipoConCod1, T1.SubTipoConCod2  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setString(19, (String)parms[18], 1);
               stmt.setString(20, (String)parms[19], 1);
               stmt.setString(21, (String)parms[20], 1);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setString(24, (String)parms[23], 20);
               stmt.setVarchar(25, (String)parms[24], 200, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

