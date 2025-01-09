package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genconcepsegundoplano_sincommit extends GXProcedure
{
   public genconcepsegundoplano_sincommit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genconcepsegundoplano_sincommit.class ), "" );
   }

   public genconcepsegundoplano_sincommit( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              int aP4 ,
                              boolean aP5 ,
                              java.util.Date aP6 ,
                              int aP7 ,
                              boolean aP8 ,
                              String aP9 ,
                              String[] aP10 ,
                              boolean[] aP11 ,
                              GXSimpleCollection<String>[] aP12 ,
                              int[] aP13 )
   {
      genconcepsegundoplano_sincommit.this.aP14 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        int aP4 ,
                        boolean aP5 ,
                        java.util.Date aP6 ,
                        int aP7 ,
                        boolean aP8 ,
                        String aP9 ,
                        String[] aP10 ,
                        boolean[] aP11 ,
                        GXSimpleCollection<String>[] aP12 ,
                        int[] aP13 ,
                        boolean[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             int aP4 ,
                             boolean aP5 ,
                             java.util.Date aP6 ,
                             int aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             boolean[] aP11 ,
                             GXSimpleCollection<String>[] aP12 ,
                             int[] aP13 ,
                             boolean[] aP14 )
   {
      genconcepsegundoplano_sincommit.this.AV32CliCod = aP0;
      genconcepsegundoplano_sincommit.this.AV60EmpCod = aP1;
      genconcepsegundoplano_sincommit.this.AV96LiqNro = aP2;
      genconcepsegundoplano_sincommit.this.AV142TLiqCod = aP3;
      genconcepsegundoplano_sincommit.this.AV85LegNumero = aP4;
      genconcepsegundoplano_sincommit.this.AV31chequearExistencia = aP5;
      genconcepsegundoplano_sincommit.this.AV98LiqPeriodo = aP6;
      genconcepsegundoplano_sincommit.this.AV144ultimoLiqDSecuencial = aP7;
      genconcepsegundoplano_sincommit.this.AV118resolver = aP8;
      genconcepsegundoplano_sincommit.this.AV149criterioPalabra = aP9;
      genconcepsegundoplano_sincommit.this.aP10 = aP10;
      genconcepsegundoplano_sincommit.this.aP11 = aP11;
      genconcepsegundoplano_sincommit.this.aP12 = aP12;
      genconcepsegundoplano_sincommit.this.aP13 = aP13;
      genconcepsegundoplano_sincommit.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( " inicio clicod ", "")+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV60EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV85LegNumero, 8, 0))+httpContext.getMessage( " &LiqFecha ", "")+GXutil.trim( localUtil.dtoc( AV93LiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_char1 = AV59egresoTLiqCod ;
      GXt_char2 = AV59egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char2, GXv_char4) ;
      genconcepsegundoplano_sincommit.this.GXt_char1 = GXv_char4[0] ;
      AV59egresoTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV142TLiqCod, AV59egresoTLiqCod) == 0 )
      {
         GXv_char4[0] = AV103MegCodigo ;
         GXv_date5[0] = AV82LegFecEgreso ;
         new web.empleadogetegreso(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV85LegNumero, GXv_char4, GXv_date5) ;
         genconcepsegundoplano_sincommit.this.AV103MegCodigo = GXv_char4[0] ;
         genconcepsegundoplano_sincommit.this.AV82LegFecEgreso = GXv_date5[0] ;
      }
      GXt_dtime6 = AV35comienzo3 ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV32CliCod, GXv_dtime7) ;
      genconcepsegundoplano_sincommit.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV35comienzo3 = GXt_dtime6 ;
      GXt_char2 = AV19alcanzaGananciasConCodigo ;
      GXt_char1 = AV19alcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      genconcepsegundoplano_sincommit.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char3) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char3[0] ;
      AV19alcanzaGananciasConCodigo = GXt_char2 ;
      AV92LiqDSecuencial = AV144ultimoLiqDSecuencial ;
      AV40conceptosOK = true ;
      AV112pendientesIndispensablesHay = false ;
      GXv_char4[0] = AV9ConveCodigo ;
      GXv_boolean8[0] = AV79LegAgenReten ;
      GXv_int9[0] = AV10LegClase ;
      GXv_char3[0] = AV152LegModTra ;
      GXv_char10[0] = "" ;
      GXv_char11[0] = "" ;
      GXv_char12[0] = AV153tipo_tarifa ;
      new web.getdatoslegparaliq(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV96LiqNro, AV85LegNumero, GXv_char4, GXv_boolean8, GXv_int9, GXv_char3, GXv_char10, GXv_char11, GXv_char12) ;
      genconcepsegundoplano_sincommit.this.AV9ConveCodigo = GXv_char4[0] ;
      genconcepsegundoplano_sincommit.this.AV79LegAgenReten = GXv_boolean8[0] ;
      genconcepsegundoplano_sincommit.this.AV10LegClase = GXv_int9[0] ;
      genconcepsegundoplano_sincommit.this.AV152LegModTra = GXv_char3[0] ;
      genconcepsegundoplano_sincommit.this.AV153tipo_tarifa = GXv_char12[0] ;
      AV91LiqDLote = (byte)(1) ;
      AV105Mostrarconcepto = (byte)(0) ;
      AV63excluirConCodigo.clear();
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "carga novedades &ultimoDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV143ultimoDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &primerDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV113primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_dtime6 = AV36comienzo4 ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV32CliCod, GXv_dtime7) ;
      genconcepsegundoplano_sincommit.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV36comienzo4 = GXt_dtime6 ;
      GXt_dtime6 = AV17ahora ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV32CliCod, GXv_dtime7) ;
      genconcepsegundoplano_sincommit.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV17ahora = GXt_dtime6 ;
      AV128segundos3 = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV17ahora, AV36comienzo4)) ;
      AV94LiqLog += httpContext.getMessage( ". Agenda ", "") + GXutil.trim( GXutil.str( AV128segundos3, 6, 4)) ;
      GXt_char2 = AV117redondeo ;
      GXv_char12[0] = "x" ;
      GXv_char11[0] = GXt_char2 ;
      new web.conceptoredondeo(remoteHandle, context).execute( AV32CliCod, GXv_char12, GXv_char11) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char11[0] ;
      AV117redondeo = GXt_char2 ;
      GXt_char2 = AV133sobregiro ;
      GXv_char12[0] = "x" ;
      GXv_char11[0] = GXt_char2 ;
      new web.conceptosobregiro(remoteHandle, context).execute( AV32CliCod, GXv_char12, GXv_char11) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char11[0] ;
      AV133sobregiro = GXt_char2 ;
      GXv_int13[0] = AV111paicod ;
      new web.clientegetpais(remoteHandle, context).execute( AV32CliCod, GXv_int13) ;
      genconcepsegundoplano_sincommit.this.AV111paicod = GXv_int13[0] ;
      GXv_boolean8[0] = AV26calcularSAC ;
      new web.calcularsac(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV96LiqNro, AV85LegNumero, AV142TLiqCod, AV98LiqPeriodo, "", AV114ProcesoLiquidacion, GXv_boolean8) ;
      genconcepsegundoplano_sincommit.this.AV26calcularSAC = GXv_boolean8[0] ;
      AV27calculos_TipoConCod = "CAL_ARG" ;
      AV51desde_CONTLSegPla = (byte)(1) ;
      AV72hasta_CONTLSegPla = (byte)(3) ;
      GXt_char2 = AV148baseImpSubTipoConCod1 ;
      GXv_char12[0] = GXt_char2 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char12) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char12[0] ;
      AV148baseImpSubTipoConCod1 = GXt_char2 ;
      GXt_char2 = AV150contribucionesSubTipoConCod1 ;
      GXv_char12[0] = GXt_char2 ;
      new web.subtipocontribucion(remoteHandle, context).execute( GXv_char12) ;
      genconcepsegundoplano_sincommit.this.GXt_char2 = GXv_char12[0] ;
      AV150contribucionesSubTipoConCod1 = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "&baseImpSubTipoConCod1 ", "")+GXutil.trim( AV148baseImpSubTipoConCod1)+httpContext.getMessage( " &contribucionesSubTipoConCod1 ", "")+GXutil.trim( AV150contribucionesSubTipoConCod1)+httpContext.getMessage( " &criterioPalabra ", "")+AV149criterioPalabra) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV149criterioPalabra ,
                                           A38SubTipoConCod1 ,
                                           AV148baseImpSubTipoConCod1 ,
                                           AV150contribucionesSubTipoConCod1 ,
                                           A1645ConceptoConveCodigo ,
                                           AV9ConveCodigo ,
                                           Byte.valueOf(A1789CONTLSegPla) ,
                                           Byte.valueOf(AV51desde_CONTLSegPla) ,
                                           Byte.valueOf(AV72hasta_CONTLSegPla) ,
                                           Byte.valueOf(A1470ConTLConHab) ,
                                           Integer.valueOf(AV32CliCod) ,
                                           AV142TLiqCod ,
                                           AV27calculos_TipoConCod ,
                                           Integer.valueOf(A3CliCod) ,
                                           A32TLiqCod ,
                                           Byte.valueOf(A1409ConTLVigencia) ,
                                           A1788ConTLTipoCon } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P02EJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), AV142TLiqCod, AV27calculos_TipoConCod, AV9ConveCodigo, Byte.valueOf(AV51desde_CONTLSegPla), Byte.valueOf(AV72hasta_CONTLSegPla), AV148baseImpSubTipoConCod1, AV150contribucionesSubTipoConCod1, AV148baseImpSubTipoConCod1, AV148baseImpSubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P02EJ2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P02EJ2_n38SubTipoConCod1[0] ;
         A1789CONTLSegPla = P02EJ2_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = P02EJ2_n1789CONTLSegPla[0] ;
         A1645ConceptoConveCodigo = P02EJ2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P02EJ2_n1645ConceptoConveCodigo[0] ;
         A1788ConTLTipoCon = P02EJ2_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P02EJ2_n1788ConTLTipoCon[0] ;
         A1409ConTLVigencia = P02EJ2_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = P02EJ2_n1409ConTLVigencia[0] ;
         A1470ConTLConHab = P02EJ2_A1470ConTLConHab[0] ;
         A32TLiqCod = P02EJ2_A32TLiqCod[0] ;
         A3CliCod = P02EJ2_A3CliCod[0] ;
         A26ConCodigo = P02EJ2_A26ConCodigo[0] ;
         A950ConTLTipEgr = P02EJ2_A950ConTLTipEgr[0] ;
         A1410ConTLCondicion = P02EJ2_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P02EJ2_n1410ConTLCondicion[0] ;
         A39SubTipoConCod2 = P02EJ2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P02EJ2_n39SubTipoConCod2[0] ;
         A148ConFormula = P02EJ2_A148ConFormula[0] ;
         n148ConFormula = P02EJ2_n148ConFormula[0] ;
         A41ConDescrip = P02EJ2_A41ConDescrip[0] ;
         A1406ConTLOrdejec = P02EJ2_A1406ConTLOrdejec[0] ;
         A38SubTipoConCod1 = P02EJ2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P02EJ2_n38SubTipoConCod1[0] ;
         A1645ConceptoConveCodigo = P02EJ2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P02EJ2_n1645ConceptoConveCodigo[0] ;
         A39SubTipoConCod2 = P02EJ2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P02EJ2_n39SubTipoConCod2[0] ;
         A148ConFormula = P02EJ2_A148ConFormula[0] ;
         n148ConFormula = P02EJ2_n148ConFormula[0] ;
         A41ConDescrip = P02EJ2_A41ConDescrip[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)) ;
         if ( GXutil.strcmp(AV142TLiqCod, AV59egresoTLiqCod) == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "&ConTLTipEgr ", "")+GXutil.trim( AV8ConTLTipEgr)+httpContext.getMessage( " &MegCodigo ", "")+GXutil.trim( AV103MegCodigo)) ;
            if ( ! (GXutil.strcmp("", A950ConTLTipEgr)==0) && ( GXutil.strcmp(A950ConTLTipEgr, AV103MegCodigo) != 0 ) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "no aplica", "")) ;
               AV97LiqOK = false ;
            }
            else
            {
               AV97LiqOK = true ;
            }
         }
         else
         {
            AV97LiqOK = true ;
         }
         if ( AV97LiqOK )
         {
            AV125segundoPlanoEs = false ;
            if ( A1789CONTLSegPla == 1 )
            {
               AV125segundoPlanoEs = true ;
            }
            else
            {
               if ( A1789CONTLSegPla == 2 )
               {
                  AV125segundoPlanoEs = AV79LegAgenReten ;
               }
               else
               {
                  if ( ( AV79LegAgenReten ) || ( AV26calcularSAC ) )
                  {
                     AV125segundoPlanoEs = true ;
                  }
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "&LegAgenReten ", "")+GXutil.trim( GXutil.booltostr( AV79LegAgenReten))+httpContext.getMessage( " &calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV26calcularSAC))+httpContext.getMessage( " &segundoPlanoEs ", "")+GXutil.trim( GXutil.booltostr( AV125segundoPlanoEs))) ;
            if ( AV125segundoPlanoEs )
            {
               AV16agregarConcepto = true ;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, "1") ;
               if ( GXutil.strcmp(A1410ConTLCondicion, "A0") == 0 )
               {
                  AV16agregarConcepto = true ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, "2") ;
               }
               else
               {
                  GXv_boolean8[0] = AV16agregarConcepto ;
                  GXv_boolean14[0] = false ;
                  GXv_char12[0] = AV44ConCondicion ;
                  GXv_char11[0] = "" ;
                  new web.validarconcepto2(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV96LiqNro, AV85LegNumero, AV98LiqPeriodo, false, A38SubTipoConCod1, A39SubTipoConCod2, AV26calcularSAC, A26ConCodigo, false, A148ConFormula, A41ConDescrip, "", AV102liquidaSAConcodigo, AV19alcanzaGananciasConCodigo, false, "Calculo", true, GXv_boolean8, GXv_boolean14, GXv_char12, GXv_char11) ;
                  genconcepsegundoplano_sincommit.this.AV16agregarConcepto = GXv_boolean8[0] ;
                  genconcepsegundoplano_sincommit.this.AV44ConCondicion = GXv_char12[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "3 &agregarConcepto ", "")+GXutil.trim( GXutil.booltostr( AV16agregarConcepto))) ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "4 &agregarConcepto ", "")+GXutil.trim( GXutil.booltostr( AV16agregarConcepto))) ;
            if ( AV16agregarConcepto )
            {
               AV42ConCodigo = A26ConCodigo ;
               /* Execute user subroutine: 'DETALLE' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'DETALLE' Routine */
      returnInSub = false ;
      AV92LiqDSecuencial = (int)(AV92LiqDSecuencial+1) ;
      if ( AV31chequearExistencia )
      {
         GXv_boolean14[0] = AV64existe ;
         GXv_int9[0] = AV65existeLiqDCalculado ;
         new web.existedetalleliquidacion2(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV96LiqNro, AV85LegNumero, AV42ConCodigo, GXv_boolean14, GXv_int9) ;
         genconcepsegundoplano_sincommit.this.AV64existe = GXv_boolean14[0] ;
         genconcepsegundoplano_sincommit.this.AV65existeLiqDCalculado = GXv_int9[0] ;
      }
      else
      {
         AV64existe = false ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "detalle &concodigo ", "")+GXutil.trim( AV42ConCodigo)+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV64existe))+httpContext.getMessage( " &existeLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV65existeLiqDCalculado, 1, 0))) ;
      if ( ! AV64existe )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "&auxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV23auxLiqDImpCalcu, 14, 2))) ;
         GXv_decimal15[0] = AV90LiqDImpCalcu ;
         GXv_boolean14[0] = AV50dependenciasResueltas ;
         GXv_char12[0] = AV45ConFormula ;
         GXv_char11[0] = AV61error ;
         new web.newliquidaciondetalle3(remoteHandle, context).execute( AV32CliCod, AV60EmpCod, AV96LiqNro, 0, AV85LegNumero, AV42ConCodigo, AV118resolver, AV92LiqDSecuencial, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), AV49date, AV49date, AV23auxLiqDImpCalcu, AV68forzarCero, AV105Mostrarconcepto, AV98LiqPeriodo, AV142TLiqCod, false, AV91LiqDLote, false, "", GXv_decimal15, GXv_boolean14, GXv_char12, GXv_char11) ;
         genconcepsegundoplano_sincommit.this.AV90LiqDImpCalcu = GXv_decimal15[0] ;
         genconcepsegundoplano_sincommit.this.AV50dependenciasResueltas = GXv_boolean14[0] ;
         genconcepsegundoplano_sincommit.this.AV45ConFormula = GXv_char12[0] ;
         genconcepsegundoplano_sincommit.this.AV61error = GXv_char11[0] ;
         if ( ! (GXutil.strcmp("", AV61error)==0) && ( AV50dependenciasResueltas ) )
         {
            AV40conceptosOK = false ;
            returnInSub = true;
            if (true) return;
         }
         if ( ! AV112pendientesIndispensablesHay && ! (GXutil.strcmp("", AV45ConFormula)==0) )
         {
            if ( ! AV50dependenciasResueltas )
            {
               AV112pendientesIndispensablesHay = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "&pendientesIndispensablesHay .&. ", "")+AV42ConCodigo) ;
            }
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "existe 1", "")) ;
         if ( AV65existeLiqDCalculado != 1 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "existe 2 &ConFormula ", "")+GXutil.trim( AV45ConFormula)+httpContext.getMessage( " &pendientesIndispensablesHay ", "")+GXutil.trim( GXutil.booltostr( AV112pendientesIndispensablesHay))) ;
            if ( ! AV112pendientesIndispensablesHay )
            {
               AV112pendientesIndispensablesHay = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV156Pgmname, httpContext.getMessage( "existe 3 &pendientesIndispensablesHay .&. ", "")+AV42ConCodigo) ;
            }
         }
      }
   }

   public void S121( )
   {
      /* 'SETEAR HAY PENDIENTES' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP10[0] = genconcepsegundoplano_sincommit.this.AV94LiqLog;
      this.aP11[0] = genconcepsegundoplano_sincommit.this.AV112pendientesIndispensablesHay;
      this.aP12[0] = genconcepsegundoplano_sincommit.this.AV124segundo_plano;
      this.aP13[0] = genconcepsegundoplano_sincommit.this.AV92LiqDSecuencial;
      this.aP14[0] = genconcepsegundoplano_sincommit.this.AV40conceptosOK;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV94LiqLog = "" ;
      AV124segundo_plano = new GXSimpleCollection<String>(String.class, "internal", "");
      AV156Pgmname = "" ;
      AV93LiqFecha = GXutil.nullDate() ;
      AV59egresoTLiqCod = "" ;
      AV103MegCodigo = "" ;
      AV82LegFecEgreso = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV35comienzo3 = GXutil.resetTime( GXutil.nullDate() );
      AV19alcanzaGananciasConCodigo = "" ;
      GXt_char1 = "" ;
      AV9ConveCodigo = "" ;
      GXv_char4 = new String[1] ;
      AV152LegModTra = "" ;
      GXv_char3 = new String[1] ;
      GXv_char10 = new String[1] ;
      AV153tipo_tarifa = "" ;
      AV63excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV143ultimoDiaPeriodo = GXutil.nullDate() ;
      AV113primerDiaPeriodo = GXutil.nullDate() ;
      AV36comienzo4 = GXutil.resetTime( GXutil.nullDate() );
      AV17ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime7 = new java.util.Date[1] ;
      AV128segundos3 = DecimalUtil.ZERO ;
      AV117redondeo = "" ;
      AV133sobregiro = "" ;
      GXv_int13 = new short[1] ;
      AV114ProcesoLiquidacion = "" ;
      AV27calculos_TipoConCod = "" ;
      AV148baseImpSubTipoConCod1 = "" ;
      AV150contribucionesSubTipoConCod1 = "" ;
      GXt_char2 = "" ;
      scmdbuf = "" ;
      A38SubTipoConCod1 = "" ;
      A1645ConceptoConveCodigo = "" ;
      A32TLiqCod = "" ;
      A1788ConTLTipoCon = "" ;
      P02EJ2_A38SubTipoConCod1 = new String[] {""} ;
      P02EJ2_n38SubTipoConCod1 = new boolean[] {false} ;
      P02EJ2_A1789CONTLSegPla = new byte[1] ;
      P02EJ2_n1789CONTLSegPla = new boolean[] {false} ;
      P02EJ2_A1645ConceptoConveCodigo = new String[] {""} ;
      P02EJ2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P02EJ2_A1788ConTLTipoCon = new String[] {""} ;
      P02EJ2_n1788ConTLTipoCon = new boolean[] {false} ;
      P02EJ2_A1409ConTLVigencia = new byte[1] ;
      P02EJ2_n1409ConTLVigencia = new boolean[] {false} ;
      P02EJ2_A1470ConTLConHab = new byte[1] ;
      P02EJ2_A32TLiqCod = new String[] {""} ;
      P02EJ2_A3CliCod = new int[1] ;
      P02EJ2_A26ConCodigo = new String[] {""} ;
      P02EJ2_A950ConTLTipEgr = new String[] {""} ;
      P02EJ2_A1410ConTLCondicion = new String[] {""} ;
      P02EJ2_n1410ConTLCondicion = new boolean[] {false} ;
      P02EJ2_A39SubTipoConCod2 = new String[] {""} ;
      P02EJ2_n39SubTipoConCod2 = new boolean[] {false} ;
      P02EJ2_A148ConFormula = new String[] {""} ;
      P02EJ2_n148ConFormula = new boolean[] {false} ;
      P02EJ2_A41ConDescrip = new String[] {""} ;
      P02EJ2_A1406ConTLOrdejec = new long[1] ;
      A26ConCodigo = "" ;
      A950ConTLTipEgr = "" ;
      A1410ConTLCondicion = "" ;
      A39SubTipoConCod2 = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      AV8ConTLTipEgr = "" ;
      AV102liquidaSAConcodigo = "" ;
      GXv_boolean8 = new boolean[1] ;
      AV44ConCondicion = "" ;
      AV42ConCodigo = "" ;
      GXv_int9 = new byte[1] ;
      AV23auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV49date = GXutil.nullDate() ;
      AV90LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV45ConFormula = "" ;
      GXv_char12 = new String[1] ;
      AV61error = "" ;
      GXv_char11 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genconcepsegundoplano_sincommit__default(),
         new Object[] {
             new Object[] {
            P02EJ2_A38SubTipoConCod1, P02EJ2_n38SubTipoConCod1, P02EJ2_A1789CONTLSegPla, P02EJ2_n1789CONTLSegPla, P02EJ2_A1645ConceptoConveCodigo, P02EJ2_n1645ConceptoConveCodigo, P02EJ2_A1788ConTLTipoCon, P02EJ2_n1788ConTLTipoCon, P02EJ2_A1409ConTLVigencia, P02EJ2_n1409ConTLVigencia,
            P02EJ2_A1470ConTLConHab, P02EJ2_A32TLiqCod, P02EJ2_A3CliCod, P02EJ2_A26ConCodigo, P02EJ2_A950ConTLTipEgr, P02EJ2_A1410ConTLCondicion, P02EJ2_n1410ConTLCondicion, P02EJ2_A39SubTipoConCod2, P02EJ2_n39SubTipoConCod2, P02EJ2_A148ConFormula,
            P02EJ2_n148ConFormula, P02EJ2_A41ConDescrip, P02EJ2_A1406ConTLOrdejec
            }
         }
      );
      AV156Pgmname = "GenConcepSegundoPlano_sinCommit" ;
      /* GeneXus formulas. */
      AV156Pgmname = "GenConcepSegundoPlano_sinCommit" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LegClase ;
   private byte AV91LiqDLote ;
   private byte AV105Mostrarconcepto ;
   private byte AV51desde_CONTLSegPla ;
   private byte AV72hasta_CONTLSegPla ;
   private byte A1789CONTLSegPla ;
   private byte A1470ConTLConHab ;
   private byte A1409ConTLVigencia ;
   private byte AV65existeLiqDCalculado ;
   private byte GXv_int9[] ;
   private short AV60EmpCod ;
   private short AV111paicod ;
   private short GXv_int13[] ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int AV96LiqNro ;
   private int AV85LegNumero ;
   private int AV144ultimoLiqDSecuencial ;
   private int AV92LiqDSecuencial ;
   private int A3CliCod ;
   private long A1406ConTLOrdejec ;
   private java.math.BigDecimal AV128segundos3 ;
   private java.math.BigDecimal AV23auxLiqDImpCalcu ;
   private java.math.BigDecimal AV90LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String AV142TLiqCod ;
   private String AV149criterioPalabra ;
   private String AV156Pgmname ;
   private String AV59egresoTLiqCod ;
   private String AV103MegCodigo ;
   private String AV19alcanzaGananciasConCodigo ;
   private String GXt_char1 ;
   private String AV9ConveCodigo ;
   private String GXv_char4[] ;
   private String AV152LegModTra ;
   private String GXv_char3[] ;
   private String GXv_char10[] ;
   private String AV153tipo_tarifa ;
   private String AV117redondeo ;
   private String AV133sobregiro ;
   private String AV114ProcesoLiquidacion ;
   private String AV27calculos_TipoConCod ;
   private String AV148baseImpSubTipoConCod1 ;
   private String AV150contribucionesSubTipoConCod1 ;
   private String GXt_char2 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A1645ConceptoConveCodigo ;
   private String A32TLiqCod ;
   private String A1788ConTLTipoCon ;
   private String A26ConCodigo ;
   private String A950ConTLTipEgr ;
   private String A1410ConTLCondicion ;
   private String A39SubTipoConCod2 ;
   private String AV8ConTLTipEgr ;
   private String AV102liquidaSAConcodigo ;
   private String AV44ConCondicion ;
   private String AV42ConCodigo ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private java.util.Date AV35comienzo3 ;
   private java.util.Date AV36comienzo4 ;
   private java.util.Date AV17ahora ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date GXv_dtime7[] ;
   private java.util.Date AV98LiqPeriodo ;
   private java.util.Date AV93LiqFecha ;
   private java.util.Date AV82LegFecEgreso ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV143ultimoDiaPeriodo ;
   private java.util.Date AV113primerDiaPeriodo ;
   private java.util.Date AV49date ;
   private boolean AV31chequearExistencia ;
   private boolean AV118resolver ;
   private boolean AV112pendientesIndispensablesHay ;
   private boolean AV40conceptosOK ;
   private boolean AV79LegAgenReten ;
   private boolean AV26calcularSAC ;
   private boolean n38SubTipoConCod1 ;
   private boolean n1789CONTLSegPla ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n39SubTipoConCod2 ;
   private boolean n148ConFormula ;
   private boolean AV97LiqOK ;
   private boolean AV125segundoPlanoEs ;
   private boolean AV16agregarConcepto ;
   private boolean GXv_boolean8[] ;
   private boolean returnInSub ;
   private boolean AV64existe ;
   private boolean AV68forzarCero ;
   private boolean AV50dependenciasResueltas ;
   private boolean GXv_boolean14[] ;
   private String AV94LiqLog ;
   private String A148ConFormula ;
   private String AV45ConFormula ;
   private String A41ConDescrip ;
   private String AV61error ;
   private boolean[] aP14 ;
   private String[] aP10 ;
   private boolean[] aP11 ;
   private GXSimpleCollection<String>[] aP12 ;
   private int[] aP13 ;
   private IDataStoreProvider pr_default ;
   private String[] P02EJ2_A38SubTipoConCod1 ;
   private boolean[] P02EJ2_n38SubTipoConCod1 ;
   private byte[] P02EJ2_A1789CONTLSegPla ;
   private boolean[] P02EJ2_n1789CONTLSegPla ;
   private String[] P02EJ2_A1645ConceptoConveCodigo ;
   private boolean[] P02EJ2_n1645ConceptoConveCodigo ;
   private String[] P02EJ2_A1788ConTLTipoCon ;
   private boolean[] P02EJ2_n1788ConTLTipoCon ;
   private byte[] P02EJ2_A1409ConTLVigencia ;
   private boolean[] P02EJ2_n1409ConTLVigencia ;
   private byte[] P02EJ2_A1470ConTLConHab ;
   private String[] P02EJ2_A32TLiqCod ;
   private int[] P02EJ2_A3CliCod ;
   private String[] P02EJ2_A26ConCodigo ;
   private String[] P02EJ2_A950ConTLTipEgr ;
   private String[] P02EJ2_A1410ConTLCondicion ;
   private boolean[] P02EJ2_n1410ConTLCondicion ;
   private String[] P02EJ2_A39SubTipoConCod2 ;
   private boolean[] P02EJ2_n39SubTipoConCod2 ;
   private String[] P02EJ2_A148ConFormula ;
   private boolean[] P02EJ2_n148ConFormula ;
   private String[] P02EJ2_A41ConDescrip ;
   private long[] P02EJ2_A1406ConTLOrdejec ;
   private GXSimpleCollection<String> AV124segundo_plano ;
   private GXSimpleCollection<String> AV63excluirConCodigo ;
}

final  class genconcepsegundoplano_sincommit__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02EJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV149criterioPalabra ,
                                          String A38SubTipoConCod1 ,
                                          String AV148baseImpSubTipoConCod1 ,
                                          String AV150contribucionesSubTipoConCod1 ,
                                          String A1645ConceptoConveCodigo ,
                                          String AV9ConveCodigo ,
                                          byte A1789CONTLSegPla ,
                                          byte AV51desde_CONTLSegPla ,
                                          byte AV72hasta_CONTLSegPla ,
                                          byte A1470ConTLConHab ,
                                          int AV32CliCod ,
                                          String AV142TLiqCod ,
                                          String AV27calculos_TipoConCod ,
                                          int A3CliCod ,
                                          String A32TLiqCod ,
                                          byte A1409ConTLVigencia ,
                                          String A1788ConTLTipoCon )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[10];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T2.SubTipoConCod1, T1.CONTLSegPla, T2.ConceptoConveCodigo, T1.ConTLTipoCon, T1.ConTLVigencia, T1.ConTLConHab, T1.TLiqCod, T1.CliCod, T1.ConCodigo, T1.ConTLTipEgr," ;
      scmdbuf += " T1.ConTLCondicion, T2.SubTipoConCod2, T2.ConFormula, T2.ConDescrip, T1.ConTLOrdejec FROM (ConceptoTipoLiquidacion T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.TLiqCod = ( ?) and T1.ConTLVigencia = 0 and T1.ConTLTipoCon = ( ?))");
      addWhere(sWhereString, "(T2.ConceptoConveCodigo IS NULL or T2.ConceptoConveCodigo = ( ?))");
      addWhere(sWhereString, "(T1.CONTLSegPla >= ?)");
      addWhere(sWhereString, "(T1.CONTLSegPla <= ?)");
      addWhere(sWhereString, "(T1.ConTLConHab = 1)");
      if ( GXutil.strcmp(AV149criterioPalabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
      {
         addWhere(sWhereString, "(T2.SubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int16[6] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV149criterioPalabra, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
      {
         addWhere(sWhereString, "(T2.SubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int16[7] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV149criterioPalabra, httpContext.getMessage( "OTROS", "")) == 0 )
      {
         addWhere(sWhereString, "(T2.SubTipoConCod1 <> ( ?) and T2.SubTipoConCod1 <> ( ?))");
      }
      else
      {
         GXv_int16[8] = (byte)(1) ;
         GXv_int16[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.TLiqCod, T1.ConTLVigencia, T1.ConTLTipoCon, T1.ConTLOrdejec" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02EJ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , (String)dynConstraints[16] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(6);
               ((String[]) buf[11])[0] = rslt.getString(7, 20);
               ((int[]) buf[12])[0] = rslt.getInt(8);
               ((String[]) buf[13])[0] = rslt.getString(9, 10);
               ((String[]) buf[14])[0] = rslt.getString(10, 20);
               ((String[]) buf[15])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(14);
               ((long[]) buf[22])[0] = rslt.getLong(15);
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               return;
      }
   }

}

