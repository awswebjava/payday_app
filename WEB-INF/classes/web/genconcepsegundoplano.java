package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genconcepsegundoplano extends GXProcedure
{
   public genconcepsegundoplano( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genconcepsegundoplano.class ), "" );
   }

   public genconcepsegundoplano( int remoteHandle ,
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
      genconcepsegundoplano.this.aP14 = new boolean[] {false};
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
      genconcepsegundoplano.this.AV19CliCod = aP0;
      genconcepsegundoplano.this.AV37EmpCod = aP1;
      genconcepsegundoplano.this.AV55LiqNro = aP2;
      genconcepsegundoplano.this.AV82TLiqCod = aP3;
      genconcepsegundoplano.this.AV47LegNumero = aP4;
      genconcepsegundoplano.this.AV122chequearExistencia = aP5;
      genconcepsegundoplano.this.AV57LiqPeriodo = aP6;
      genconcepsegundoplano.this.AV123ultimoLiqDSecuencial = aP7;
      genconcepsegundoplano.this.AV97resolver = aP8;
      genconcepsegundoplano.this.AV152criterioPalabra = aP9;
      genconcepsegundoplano.this.aP10 = aP10;
      genconcepsegundoplano.this.aP11 = aP11;
      genconcepsegundoplano.this.aP12 = aP12;
      genconcepsegundoplano.this.aP13 = aP13;
      genconcepsegundoplano.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( " inicio clicod ", "")+GXutil.trim( GXutil.str( AV19CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV37EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV47LegNumero, 8, 0))+httpContext.getMessage( " &LiqFecha ", "")+GXutil.trim( localUtil.dtoc( AV54LiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_char1 = AV143egresoTLiqCod ;
      GXt_char2 = AV143egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char2, GXv_char4) ;
      genconcepsegundoplano.this.GXt_char1 = GXv_char4[0] ;
      AV143egresoTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV82TLiqCod, AV143egresoTLiqCod) == 0 )
      {
         GXv_char4[0] = AV145MegCodigo ;
         GXv_date5[0] = AV144LegFecEgreso ;
         new web.empleadogetegreso(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV47LegNumero, GXv_char4, GXv_date5) ;
         genconcepsegundoplano.this.AV145MegCodigo = GXv_char4[0] ;
         genconcepsegundoplano.this.AV144LegFecEgreso = GXv_date5[0] ;
      }
      GXt_dtime6 = AV137comienzo3 ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV19CliCod, GXv_dtime7) ;
      genconcepsegundoplano.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV137comienzo3 = GXt_dtime6 ;
      GXt_char2 = AV14alcanzaGananciasConCodigo ;
      GXt_char1 = AV14alcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      genconcepsegundoplano.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char3) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char3[0] ;
      AV14alcanzaGananciasConCodigo = GXt_char2 ;
      AV53LiqDSecuencial = AV123ultimoLiqDSecuencial ;
      AV117conceptosOK = true ;
      AV115pendientesIndispensablesHay = false ;
      GXv_char4[0] = AV8ConveCodigo ;
      GXv_boolean8[0] = AV44LegAgenReten ;
      GXv_int9[0] = AV9LegClase ;
      GXv_char3[0] = AV155LegModTra ;
      GXv_char10[0] = "" ;
      GXv_char11[0] = "" ;
      GXv_char12[0] = AV156tipo_tarifa ;
      new web.getdatoslegparaliq(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV55LiqNro, AV47LegNumero, GXv_char4, GXv_boolean8, GXv_int9, GXv_char3, GXv_char10, GXv_char11, GXv_char12) ;
      genconcepsegundoplano.this.AV8ConveCodigo = GXv_char4[0] ;
      genconcepsegundoplano.this.AV44LegAgenReten = GXv_boolean8[0] ;
      genconcepsegundoplano.this.AV9LegClase = GXv_int9[0] ;
      genconcepsegundoplano.this.AV155LegModTra = GXv_char3[0] ;
      genconcepsegundoplano.this.AV156tipo_tarifa = GXv_char12[0] ;
      AV116LiqDLote = (byte)(1) ;
      AV61Mostrarconcepto = (byte)(0) ;
      AV64excluirConCodigo.clear();
      new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "carga novedades &ultimoDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV83ultimoDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &primerDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV66primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_dtime6 = AV141comienzo4 ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV19CliCod, GXv_dtime7) ;
      genconcepsegundoplano.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV141comienzo4 = GXt_dtime6 ;
      GXt_dtime6 = AV133ahora ;
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV19CliCod, GXv_dtime7) ;
      genconcepsegundoplano.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV133ahora = GXt_dtime6 ;
      AV140segundos3 = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV133ahora, AV141comienzo4)) ;
      AV92LiqLog += httpContext.getMessage( ". Agenda ", "") + GXutil.trim( GXutil.str( AV140segundos3, 6, 4)) ;
      GXt_char2 = AV68redondeo ;
      GXv_char12[0] = "x" ;
      GXv_char11[0] = GXt_char2 ;
      new web.conceptoredondeo(remoteHandle, context).execute( AV19CliCod, GXv_char12, GXv_char11) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char11[0] ;
      AV68redondeo = GXt_char2 ;
      GXt_char2 = AV76sobregiro ;
      GXv_char12[0] = "x" ;
      GXv_char11[0] = GXt_char2 ;
      new web.conceptosobregiro(remoteHandle, context).execute( AV19CliCod, GXv_char12, GXv_char11) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char11[0] ;
      AV76sobregiro = GXt_char2 ;
      GXv_int13[0] = AV142paicod ;
      new web.clientegetpais(remoteHandle, context).execute( AV19CliCod, GXv_int13) ;
      genconcepsegundoplano.this.AV142paicod = GXv_int13[0] ;
      GXv_boolean8[0] = AV16calcularSAC ;
      new web.calcularsac(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV55LiqNro, AV47LegNumero, AV82TLiqCod, AV57LiqPeriodo, "", AV93ProcesoLiquidacion, GXv_boolean8) ;
      genconcepsegundoplano.this.AV16calcularSAC = GXv_boolean8[0] ;
      AV148calculos_TipoConCod = "CAL_ARG" ;
      AV149desde_CONTLSegPla = (byte)(1) ;
      AV150hasta_CONTLSegPla = (byte)(3) ;
      GXt_char2 = AV151baseImpSubTipoConCod1 ;
      GXv_char12[0] = GXt_char2 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char12) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char12[0] ;
      AV151baseImpSubTipoConCod1 = GXt_char2 ;
      GXt_char2 = AV153contribucionesSubTipoConCod1 ;
      GXv_char12[0] = GXt_char2 ;
      new web.subtipocontribucion(remoteHandle, context).execute( GXv_char12) ;
      genconcepsegundoplano.this.GXt_char2 = GXv_char12[0] ;
      AV153contribucionesSubTipoConCod1 = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "&baseImpSubTipoConCod1 ", "")+GXutil.trim( AV151baseImpSubTipoConCod1)+httpContext.getMessage( " &contribucionesSubTipoConCod1 ", "")+GXutil.trim( AV153contribucionesSubTipoConCod1)+httpContext.getMessage( " &criterioPalabra ", "")+AV152criterioPalabra) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV152criterioPalabra ,
                                           A38SubTipoConCod1 ,
                                           AV151baseImpSubTipoConCod1 ,
                                           AV153contribucionesSubTipoConCod1 ,
                                           A1645ConceptoConveCodigo ,
                                           AV8ConveCodigo ,
                                           Byte.valueOf(A1789CONTLSegPla) ,
                                           Byte.valueOf(AV149desde_CONTLSegPla) ,
                                           Byte.valueOf(AV150hasta_CONTLSegPla) ,
                                           Byte.valueOf(A1470ConTLConHab) ,
                                           Integer.valueOf(AV19CliCod) ,
                                           AV82TLiqCod ,
                                           AV148calculos_TipoConCod ,
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
      /* Using cursor P01ES2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod), AV82TLiqCod, AV148calculos_TipoConCod, AV8ConveCodigo, Byte.valueOf(AV149desde_CONTLSegPla), Byte.valueOf(AV150hasta_CONTLSegPla), AV151baseImpSubTipoConCod1, AV153contribucionesSubTipoConCod1, AV151baseImpSubTipoConCod1, AV151baseImpSubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P01ES2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P01ES2_n38SubTipoConCod1[0] ;
         A1789CONTLSegPla = P01ES2_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = P01ES2_n1789CONTLSegPla[0] ;
         A1645ConceptoConveCodigo = P01ES2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01ES2_n1645ConceptoConveCodigo[0] ;
         A1788ConTLTipoCon = P01ES2_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01ES2_n1788ConTLTipoCon[0] ;
         A1409ConTLVigencia = P01ES2_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = P01ES2_n1409ConTLVigencia[0] ;
         A1470ConTLConHab = P01ES2_A1470ConTLConHab[0] ;
         A32TLiqCod = P01ES2_A32TLiqCod[0] ;
         A3CliCod = P01ES2_A3CliCod[0] ;
         A26ConCodigo = P01ES2_A26ConCodigo[0] ;
         A950ConTLTipEgr = P01ES2_A950ConTLTipEgr[0] ;
         A1410ConTLCondicion = P01ES2_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01ES2_n1410ConTLCondicion[0] ;
         A39SubTipoConCod2 = P01ES2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P01ES2_n39SubTipoConCod2[0] ;
         A148ConFormula = P01ES2_A148ConFormula[0] ;
         n148ConFormula = P01ES2_n148ConFormula[0] ;
         A41ConDescrip = P01ES2_A41ConDescrip[0] ;
         A1406ConTLOrdejec = P01ES2_A1406ConTLOrdejec[0] ;
         A38SubTipoConCod1 = P01ES2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P01ES2_n38SubTipoConCod1[0] ;
         A1645ConceptoConveCodigo = P01ES2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01ES2_n1645ConceptoConveCodigo[0] ;
         A39SubTipoConCod2 = P01ES2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P01ES2_n39SubTipoConCod2[0] ;
         A148ConFormula = P01ES2_A148ConFormula[0] ;
         n148ConFormula = P01ES2_n148ConFormula[0] ;
         A41ConDescrip = P01ES2_A41ConDescrip[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)) ;
         if ( GXutil.strcmp(AV82TLiqCod, AV143egresoTLiqCod) == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "&ConTLTipEgr ", "")+GXutil.trim( AV146ConTLTipEgr)+httpContext.getMessage( " &MegCodigo ", "")+GXutil.trim( AV145MegCodigo)) ;
            if ( ! (GXutil.strcmp("", A950ConTLTipEgr)==0) && ( GXutil.strcmp(A950ConTLTipEgr, AV145MegCodigo) != 0 ) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "no aplica", "")) ;
               AV56LiqOK = false ;
            }
            else
            {
               AV56LiqOK = true ;
            }
         }
         else
         {
            AV56LiqOK = true ;
         }
         if ( AV56LiqOK )
         {
            AV99segundoPlanoEs = false ;
            if ( A1789CONTLSegPla == 1 )
            {
               AV99segundoPlanoEs = true ;
            }
            else
            {
               if ( A1789CONTLSegPla == 2 )
               {
                  AV99segundoPlanoEs = AV44LegAgenReten ;
               }
               else
               {
                  if ( ( AV44LegAgenReten ) || ( AV16calcularSAC ) )
                  {
                     AV99segundoPlanoEs = true ;
                  }
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "&LegAgenReten ", "")+GXutil.trim( GXutil.booltostr( AV44LegAgenReten))+httpContext.getMessage( " &calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV16calcularSAC))+httpContext.getMessage( " &segundoPlanoEs ", "")+GXutil.trim( GXutil.booltostr( AV99segundoPlanoEs))) ;
            if ( AV99segundoPlanoEs )
            {
               AV12agregarConcepto = true ;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, "1") ;
               if ( GXutil.strcmp(A1410ConTLCondicion, "A0") == 0 )
               {
                  AV12agregarConcepto = true ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, "2") ;
               }
               else
               {
                  GXv_boolean8[0] = AV12agregarConcepto ;
                  GXv_boolean14[0] = false ;
                  GXv_char12[0] = AV86ConCondicion ;
                  GXv_char11[0] = "" ;
                  new web.validarconcepto2(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV55LiqNro, AV47LegNumero, AV57LiqPeriodo, false, A38SubTipoConCod1, A39SubTipoConCod2, AV16calcularSAC, A26ConCodigo, false, A148ConFormula, A41ConDescrip, "", AV60liquidaSAConcodigo, AV14alcanzaGananciasConCodigo, false, "Calculo", true, GXv_boolean8, GXv_boolean14, GXv_char12, GXv_char11) ;
                  genconcepsegundoplano.this.AV12agregarConcepto = GXv_boolean8[0] ;
                  genconcepsegundoplano.this.AV86ConCondicion = GXv_char12[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "3 &agregarConcepto ", "")+GXutil.trim( GXutil.booltostr( AV12agregarConcepto))) ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "4 &agregarConcepto ", "")+GXutil.trim( GXutil.booltostr( AV12agregarConcepto))) ;
            if ( AV12agregarConcepto )
            {
               AV24ConCodigo = A26ConCodigo ;
               AV154insert_ConCodigo.add(AV24ConCodigo, 0);
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV105i = (short)(1) ;
      while ( AV105i <= AV154insert_ConCodigo.size() )
      {
         AV24ConCodigo = (String)AV154insert_ConCodigo.elementAt(-1+AV105i) ;
         /* Execute user subroutine: 'DETALLE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "genconcepsegundoplano");
         AV105i = (short)(AV105i+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'DETALLE' Routine */
      returnInSub = false ;
      AV53LiqDSecuencial = (int)(AV53LiqDSecuencial+1) ;
      if ( AV122chequearExistencia )
      {
         GXv_boolean14[0] = AV38existe ;
         GXv_int9[0] = AV147existeLiqDCalculado ;
         new web.existedetalleliquidacion2(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV55LiqNro, AV47LegNumero, AV24ConCodigo, GXv_boolean14, GXv_int9) ;
         genconcepsegundoplano.this.AV38existe = GXv_boolean14[0] ;
         genconcepsegundoplano.this.AV147existeLiqDCalculado = GXv_int9[0] ;
      }
      else
      {
         AV38existe = false ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "detalle &concodigo ", "")+GXutil.trim( AV24ConCodigo)+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV38existe))+httpContext.getMessage( " &existeLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV147existeLiqDCalculado, 1, 0))) ;
      if ( ! AV38existe )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "&auxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV126auxLiqDImpCalcu, 14, 2))) ;
         GXv_decimal15[0] = AV52LiqDImpCalcu ;
         GXv_boolean14[0] = AV31dependenciasResueltas ;
         GXv_char12[0] = AV25ConFormula ;
         GXv_char11[0] = AV118error ;
         new web.newliquidaciondetalle3(remoteHandle, context).execute( AV19CliCod, AV37EmpCod, AV55LiqNro, 0, AV47LegNumero, AV24ConCodigo, AV97resolver, AV53LiqDSecuencial, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), AV30date, AV30date, AV126auxLiqDImpCalcu, AV40forzarCero, AV61Mostrarconcepto, AV57LiqPeriodo, AV82TLiqCod, false, AV116LiqDLote, false, "", GXv_decimal15, GXv_boolean14, GXv_char12, GXv_char11) ;
         genconcepsegundoplano.this.AV52LiqDImpCalcu = GXv_decimal15[0] ;
         genconcepsegundoplano.this.AV31dependenciasResueltas = GXv_boolean14[0] ;
         genconcepsegundoplano.this.AV25ConFormula = GXv_char12[0] ;
         genconcepsegundoplano.this.AV118error = GXv_char11[0] ;
         if ( ! (GXutil.strcmp("", AV118error)==0) && ( AV31dependenciasResueltas ) )
         {
            AV117conceptosOK = false ;
            returnInSub = true;
            if (true) return;
         }
         if ( ! AV115pendientesIndispensablesHay && ! (GXutil.strcmp("", AV25ConFormula)==0) )
         {
            if ( ! AV31dependenciasResueltas )
            {
               AV115pendientesIndispensablesHay = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "&pendientesIndispensablesHay .&. ", "")+AV24ConCodigo) ;
            }
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "existe 1", "")) ;
         if ( AV147existeLiqDCalculado != 1 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "existe 2 &ConFormula ", "")+GXutil.trim( AV25ConFormula)+httpContext.getMessage( " &pendientesIndispensablesHay ", "")+GXutil.trim( GXutil.booltostr( AV115pendientesIndispensablesHay))) ;
            if ( ! AV115pendientesIndispensablesHay )
            {
               AV115pendientesIndispensablesHay = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV19CliCod, AV159Pgmname, httpContext.getMessage( "existe 3 &pendientesIndispensablesHay .&. ", "")+AV24ConCodigo) ;
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
      this.aP10[0] = genconcepsegundoplano.this.AV92LiqLog;
      this.aP11[0] = genconcepsegundoplano.this.AV115pendientesIndispensablesHay;
      this.aP12[0] = genconcepsegundoplano.this.AV98segundo_plano;
      this.aP13[0] = genconcepsegundoplano.this.AV53LiqDSecuencial;
      this.aP14[0] = genconcepsegundoplano.this.AV117conceptosOK;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV92LiqLog = "" ;
      AV98segundo_plano = new GXSimpleCollection<String>(String.class, "internal", "");
      AV159Pgmname = "" ;
      AV54LiqFecha = GXutil.nullDate() ;
      AV143egresoTLiqCod = "" ;
      AV145MegCodigo = "" ;
      AV144LegFecEgreso = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV137comienzo3 = GXutil.resetTime( GXutil.nullDate() );
      AV14alcanzaGananciasConCodigo = "" ;
      GXt_char1 = "" ;
      AV8ConveCodigo = "" ;
      GXv_char4 = new String[1] ;
      AV155LegModTra = "" ;
      GXv_char3 = new String[1] ;
      GXv_char10 = new String[1] ;
      AV156tipo_tarifa = "" ;
      AV64excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV83ultimoDiaPeriodo = GXutil.nullDate() ;
      AV66primerDiaPeriodo = GXutil.nullDate() ;
      AV141comienzo4 = GXutil.resetTime( GXutil.nullDate() );
      AV133ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime7 = new java.util.Date[1] ;
      AV140segundos3 = DecimalUtil.ZERO ;
      AV68redondeo = "" ;
      AV76sobregiro = "" ;
      GXv_int13 = new short[1] ;
      AV93ProcesoLiquidacion = "" ;
      AV148calculos_TipoConCod = "" ;
      AV151baseImpSubTipoConCod1 = "" ;
      AV153contribucionesSubTipoConCod1 = "" ;
      GXt_char2 = "" ;
      scmdbuf = "" ;
      A38SubTipoConCod1 = "" ;
      A1645ConceptoConveCodigo = "" ;
      A32TLiqCod = "" ;
      A1788ConTLTipoCon = "" ;
      P01ES2_A38SubTipoConCod1 = new String[] {""} ;
      P01ES2_n38SubTipoConCod1 = new boolean[] {false} ;
      P01ES2_A1789CONTLSegPla = new byte[1] ;
      P01ES2_n1789CONTLSegPla = new boolean[] {false} ;
      P01ES2_A1645ConceptoConveCodigo = new String[] {""} ;
      P01ES2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01ES2_A1788ConTLTipoCon = new String[] {""} ;
      P01ES2_n1788ConTLTipoCon = new boolean[] {false} ;
      P01ES2_A1409ConTLVigencia = new byte[1] ;
      P01ES2_n1409ConTLVigencia = new boolean[] {false} ;
      P01ES2_A1470ConTLConHab = new byte[1] ;
      P01ES2_A32TLiqCod = new String[] {""} ;
      P01ES2_A3CliCod = new int[1] ;
      P01ES2_A26ConCodigo = new String[] {""} ;
      P01ES2_A950ConTLTipEgr = new String[] {""} ;
      P01ES2_A1410ConTLCondicion = new String[] {""} ;
      P01ES2_n1410ConTLCondicion = new boolean[] {false} ;
      P01ES2_A39SubTipoConCod2 = new String[] {""} ;
      P01ES2_n39SubTipoConCod2 = new boolean[] {false} ;
      P01ES2_A148ConFormula = new String[] {""} ;
      P01ES2_n148ConFormula = new boolean[] {false} ;
      P01ES2_A41ConDescrip = new String[] {""} ;
      P01ES2_A1406ConTLOrdejec = new long[1] ;
      A26ConCodigo = "" ;
      A950ConTLTipEgr = "" ;
      A1410ConTLCondicion = "" ;
      A39SubTipoConCod2 = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      AV146ConTLTipEgr = "" ;
      AV60liquidaSAConcodigo = "" ;
      GXv_boolean8 = new boolean[1] ;
      AV86ConCondicion = "" ;
      AV24ConCodigo = "" ;
      AV154insert_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int9 = new byte[1] ;
      AV126auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV30date = GXutil.nullDate() ;
      AV52LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV25ConFormula = "" ;
      GXv_char12 = new String[1] ;
      AV118error = "" ;
      GXv_char11 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genconcepsegundoplano__default(),
         new Object[] {
             new Object[] {
            P01ES2_A38SubTipoConCod1, P01ES2_n38SubTipoConCod1, P01ES2_A1789CONTLSegPla, P01ES2_n1789CONTLSegPla, P01ES2_A1645ConceptoConveCodigo, P01ES2_n1645ConceptoConveCodigo, P01ES2_A1788ConTLTipoCon, P01ES2_n1788ConTLTipoCon, P01ES2_A1409ConTLVigencia, P01ES2_n1409ConTLVigencia,
            P01ES2_A1470ConTLConHab, P01ES2_A32TLiqCod, P01ES2_A3CliCod, P01ES2_A26ConCodigo, P01ES2_A950ConTLTipEgr, P01ES2_A1410ConTLCondicion, P01ES2_n1410ConTLCondicion, P01ES2_A39SubTipoConCod2, P01ES2_n39SubTipoConCod2, P01ES2_A148ConFormula,
            P01ES2_n148ConFormula, P01ES2_A41ConDescrip, P01ES2_A1406ConTLOrdejec
            }
         }
      );
      AV159Pgmname = "GenConcepSegundoPlano" ;
      /* GeneXus formulas. */
      AV159Pgmname = "GenConcepSegundoPlano" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LegClase ;
   private byte AV116LiqDLote ;
   private byte AV61Mostrarconcepto ;
   private byte AV149desde_CONTLSegPla ;
   private byte AV150hasta_CONTLSegPla ;
   private byte A1789CONTLSegPla ;
   private byte A1470ConTLConHab ;
   private byte A1409ConTLVigencia ;
   private byte AV147existeLiqDCalculado ;
   private byte GXv_int9[] ;
   private short AV37EmpCod ;
   private short AV142paicod ;
   private short GXv_int13[] ;
   private short AV105i ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV55LiqNro ;
   private int AV47LegNumero ;
   private int AV123ultimoLiqDSecuencial ;
   private int AV53LiqDSecuencial ;
   private int A3CliCod ;
   private long A1406ConTLOrdejec ;
   private java.math.BigDecimal AV140segundos3 ;
   private java.math.BigDecimal AV126auxLiqDImpCalcu ;
   private java.math.BigDecimal AV52LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String AV82TLiqCod ;
   private String AV152criterioPalabra ;
   private String AV159Pgmname ;
   private String AV143egresoTLiqCod ;
   private String AV145MegCodigo ;
   private String AV14alcanzaGananciasConCodigo ;
   private String GXt_char1 ;
   private String AV8ConveCodigo ;
   private String GXv_char4[] ;
   private String AV155LegModTra ;
   private String GXv_char3[] ;
   private String GXv_char10[] ;
   private String AV156tipo_tarifa ;
   private String AV68redondeo ;
   private String AV76sobregiro ;
   private String AV93ProcesoLiquidacion ;
   private String AV148calculos_TipoConCod ;
   private String AV151baseImpSubTipoConCod1 ;
   private String AV153contribucionesSubTipoConCod1 ;
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
   private String AV146ConTLTipEgr ;
   private String AV60liquidaSAConcodigo ;
   private String AV86ConCondicion ;
   private String AV24ConCodigo ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private java.util.Date AV137comienzo3 ;
   private java.util.Date AV141comienzo4 ;
   private java.util.Date AV133ahora ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date GXv_dtime7[] ;
   private java.util.Date AV57LiqPeriodo ;
   private java.util.Date AV54LiqFecha ;
   private java.util.Date AV144LegFecEgreso ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV83ultimoDiaPeriodo ;
   private java.util.Date AV66primerDiaPeriodo ;
   private java.util.Date AV30date ;
   private boolean AV122chequearExistencia ;
   private boolean AV97resolver ;
   private boolean AV115pendientesIndispensablesHay ;
   private boolean AV117conceptosOK ;
   private boolean AV44LegAgenReten ;
   private boolean AV16calcularSAC ;
   private boolean n38SubTipoConCod1 ;
   private boolean n1789CONTLSegPla ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n39SubTipoConCod2 ;
   private boolean n148ConFormula ;
   private boolean AV56LiqOK ;
   private boolean AV99segundoPlanoEs ;
   private boolean AV12agregarConcepto ;
   private boolean GXv_boolean8[] ;
   private boolean returnInSub ;
   private boolean AV38existe ;
   private boolean AV40forzarCero ;
   private boolean AV31dependenciasResueltas ;
   private boolean GXv_boolean14[] ;
   private String AV92LiqLog ;
   private String A148ConFormula ;
   private String AV25ConFormula ;
   private String A41ConDescrip ;
   private String AV118error ;
   private boolean[] aP14 ;
   private String[] aP10 ;
   private boolean[] aP11 ;
   private GXSimpleCollection<String>[] aP12 ;
   private int[] aP13 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ES2_A38SubTipoConCod1 ;
   private boolean[] P01ES2_n38SubTipoConCod1 ;
   private byte[] P01ES2_A1789CONTLSegPla ;
   private boolean[] P01ES2_n1789CONTLSegPla ;
   private String[] P01ES2_A1645ConceptoConveCodigo ;
   private boolean[] P01ES2_n1645ConceptoConveCodigo ;
   private String[] P01ES2_A1788ConTLTipoCon ;
   private boolean[] P01ES2_n1788ConTLTipoCon ;
   private byte[] P01ES2_A1409ConTLVigencia ;
   private boolean[] P01ES2_n1409ConTLVigencia ;
   private byte[] P01ES2_A1470ConTLConHab ;
   private String[] P01ES2_A32TLiqCod ;
   private int[] P01ES2_A3CliCod ;
   private String[] P01ES2_A26ConCodigo ;
   private String[] P01ES2_A950ConTLTipEgr ;
   private String[] P01ES2_A1410ConTLCondicion ;
   private boolean[] P01ES2_n1410ConTLCondicion ;
   private String[] P01ES2_A39SubTipoConCod2 ;
   private boolean[] P01ES2_n39SubTipoConCod2 ;
   private String[] P01ES2_A148ConFormula ;
   private boolean[] P01ES2_n148ConFormula ;
   private String[] P01ES2_A41ConDescrip ;
   private long[] P01ES2_A1406ConTLOrdejec ;
   private GXSimpleCollection<String> AV98segundo_plano ;
   private GXSimpleCollection<String> AV64excluirConCodigo ;
   private GXSimpleCollection<String> AV154insert_ConCodigo ;
}

final  class genconcepsegundoplano__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ES2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV152criterioPalabra ,
                                          String A38SubTipoConCod1 ,
                                          String AV151baseImpSubTipoConCod1 ,
                                          String AV153contribucionesSubTipoConCod1 ,
                                          String A1645ConceptoConveCodigo ,
                                          String AV8ConveCodigo ,
                                          byte A1789CONTLSegPla ,
                                          byte AV149desde_CONTLSegPla ,
                                          byte AV150hasta_CONTLSegPla ,
                                          byte A1470ConTLConHab ,
                                          int AV19CliCod ,
                                          String AV82TLiqCod ,
                                          String AV148calculos_TipoConCod ,
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
      if ( GXutil.strcmp(AV152criterioPalabra, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
      {
         addWhere(sWhereString, "(T2.SubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int16[6] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV152criterioPalabra, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
      {
         addWhere(sWhereString, "(T2.SubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int16[7] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV152criterioPalabra, httpContext.getMessage( "OTROS", "")) == 0 )
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
                  return conditional_P01ES2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , (String)dynConstraints[16] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ES2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

