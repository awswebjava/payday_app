package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptos2 extends GXProcedure
{
   public getconceptos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptos2.class ), "" );
   }

   public getconceptos2( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem>[] aP2 ,
                        boolean aP3 ,
                        short aP4 ,
                        String aP5 ,
                        int aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem>[] aP2 ,
                             boolean aP3 ,
                             short aP4 ,
                             String aP5 ,
                             int aP6 )
   {
      getconceptos2.this.AV21padre_CliCod = aP0;
      getconceptos2.this.AV23propioCliCod = aP1;
      getconceptos2.this.aP2 = aP2;
      getconceptos2.this.AV12clienteConvenioEs = aP3;
      getconceptos2.this.AV27versionador_CliPaiConve = aP4;
      getconceptos2.this.AV26versionador_CliConvenio = aP5;
      getconceptos2.this.AV33CliRelSec = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&&CliConveCod ", "")+GXutil.trim( GXutil.booltostr( AV12clienteConvenioEs))) ;
      GXv_int1[0] = AV29PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV23propioCliCod, GXv_int1) ;
      getconceptos2.this.AV29PaiCod = GXv_int1[0] ;
      GXv_int2[0] = AV11cliente_sistema_CliCod ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV29PaiCod, GXv_int2) ;
      getconceptos2.this.AV11cliente_sistema_CliCod = GXv_int2[0] ;
      GXv_boolean3[0] = AV22padreEsVersionador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV21padre_CliCod, GXv_boolean3) ;
      getconceptos2.this.AV22padreEsVersionador = GXv_boolean3[0] ;
      if ( ! AV22padreEsVersionador )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&padreEsVersionador = false &padre_CliCod ", "")+GXutil.trim( GXutil.str( AV21padre_CliCod, 6, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV16ConCodigo)+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV33CliRelSec, 6, 0))) ;
         AV37GXLvl14 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV16ConCodigo ,
                                              Integer.valueOf(AV33CliRelSec) ,
                                              A26ConCodigo ,
                                              Integer.valueOf(A1886ConRelSec) ,
                                              Integer.valueOf(AV21padre_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01PC2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV21padre_CliCod), AV16ConCodigo, Integer.valueOf(AV33CliRelSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1822CliPadre = P01PC2_A1822CliPadre[0] ;
            n1822CliPadre = P01PC2_n1822CliPadre[0] ;
            A26ConCodigo = P01PC2_A26ConCodigo[0] ;
            A3CliCod = P01PC2_A3CliCod[0] ;
            A1886ConRelSec = P01PC2_A1886ConRelSec[0] ;
            A1645ConceptoConveCodigo = P01PC2_A1645ConceptoConveCodigo[0] ;
            n1645ConceptoConveCodigo = P01PC2_n1645ConceptoConveCodigo[0] ;
            A1644ConceptoPais = P01PC2_A1644ConceptoPais[0] ;
            n1644ConceptoPais = P01PC2_n1644ConceptoPais[0] ;
            A1648ConCodAfip = P01PC2_A1648ConCodAfip[0] ;
            A1472ConSIPAApo = P01PC2_A1472ConSIPAApo[0] ;
            A1473ConSIPACont = P01PC2_A1473ConSIPACont[0] ;
            A1474ConINSSJyPApo = P01PC2_A1474ConINSSJyPApo[0] ;
            A1475ConINSSJyPCont = P01PC2_A1475ConINSSJyPCont[0] ;
            A1476ConObraSocApo = P01PC2_A1476ConObraSocApo[0] ;
            A1477ConObraSocCont = P01PC2_A1477ConObraSocCont[0] ;
            A1478ConFonSolRedApo = P01PC2_A1478ConFonSolRedApo[0] ;
            A1479ConFonSolRedCont = P01PC2_A1479ConFonSolRedCont[0] ;
            A1480ConRenateaApo = P01PC2_A1480ConRenateaApo[0] ;
            A1481ConRenateaCont = P01PC2_A1481ConRenateaCont[0] ;
            A1482ConAsigFamCont = P01PC2_A1482ConAsigFamCont[0] ;
            A1483ConFonNacEmpCont = P01PC2_A1483ConFonNacEmpCont[0] ;
            A1484ConLeyRieTrabCont = P01PC2_A1484ConLeyRieTrabCont[0] ;
            A1485ConRegDifApo = P01PC2_A1485ConRegDifApo[0] ;
            A1486ConRegEspApo = P01PC2_A1486ConRegEspApo[0] ;
            A1471ConNumero = P01PC2_A1471ConNumero[0] ;
            A1018ConRangoCant = P01PC2_A1018ConRangoCant[0] ;
            A1077ConAdelDescu = P01PC2_A1077ConAdelDescu[0] ;
            n1077ConAdelDescu = P01PC2_n1077ConAdelDescu[0] ;
            A1068ConMostrarPos = P01PC2_A1068ConMostrarPos[0] ;
            A1821ConErrorSiCero = P01PC2_A1821ConErrorSiCero[0] ;
            A953ConCondicion = P01PC2_A953ConCondicion[0] ;
            n953ConCondicion = P01PC2_n953ConCondicion[0] ;
            A954ConCondCodigo = P01PC2_A954ConCondCodigo[0] ;
            A951ConObliga = P01PC2_A951ConObliga[0] ;
            n951ConObliga = P01PC2_n951ConObliga[0] ;
            A952ConObligaSiSac = P01PC2_A952ConObligaSiSac[0] ;
            n952ConObligaSiSac = P01PC2_n952ConObligaSiSac[0] ;
            A922ConUsado = P01PC2_A922ConUsado[0] ;
            A41ConDescrip = P01PC2_A41ConDescrip[0] ;
            A150ConHabilitado = P01PC2_A150ConHabilitado[0] ;
            A154ConTipo = P01PC2_A154ConTipo[0] ;
            A40ConOrden = P01PC2_A40ConOrden[0] ;
            A510ConOrdEjec = P01PC2_A510ConOrdEjec[0] ;
            A143ConCanti = P01PC2_A143ConCanti[0] ;
            A158ConValUni = P01PC2_A158ConValUni[0] ;
            A152ConImporte = P01PC2_A152ConImporte[0] ;
            A162ConVigencia = P01PC2_A162ConVigencia[0] ;
            A148ConFormula = P01PC2_A148ConFormula[0] ;
            n148ConFormula = P01PC2_n148ConFormula[0] ;
            A157ConValorGen = P01PC2_A157ConValorGen[0] ;
            n157ConValorGen = P01PC2_n157ConValorGen[0] ;
            A155ConTipoLiqGanancias = P01PC2_A155ConTipoLiqGanancias[0] ;
            n155ConTipoLiqGanancias = P01PC2_n155ConTipoLiqGanancias[0] ;
            A153ConObservacion = P01PC2_A153ConObservacion[0] ;
            A159ConVariable = P01PC2_A159ConVariable[0] ;
            A37TipoConCod = P01PC2_A37TipoConCod[0] ;
            A38SubTipoConCod1 = P01PC2_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P01PC2_n38SubTipoConCod1[0] ;
            A39SubTipoConCod2 = P01PC2_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = P01PC2_n39SubTipoConCod2[0] ;
            A569ConFormulaExpl = P01PC2_A569ConFormulaExpl[0] ;
            A762ConRecalcular = P01PC2_A762ConRecalcular[0] ;
            A734ConRetGanPropor = P01PC2_A734ConRetGanPropor[0] ;
            A1112AplIIGG = P01PC2_A1112AplIIGG[0] ;
            n1112AplIIGG = P01PC2_n1112AplIIGG[0] ;
            A895ConTipoOrden = P01PC2_A895ConTipoOrden[0] ;
            A1066ConPreReq = P01PC2_A1066ConPreReq[0] ;
            n1066ConPreReq = P01PC2_n1066ConPreReq[0] ;
            A1194ConSegunPla = P01PC2_A1194ConSegunPla[0] ;
            A1539ConSacDeven = P01PC2_A1539ConSacDeven[0] ;
            A1621ConBaseFer = P01PC2_A1621ConBaseFer[0] ;
            A1622ConBaseHorExt = P01PC2_A1622ConBaseHorExt[0] ;
            A1620ConBaseLic = P01PC2_A1620ConBaseLic[0] ;
            A2191ConBaseAus = P01PC2_A2191ConBaseAus[0] ;
            A2192ConBaseAusProm = P01PC2_A2192ConBaseAusProm[0] ;
            A1798ConBaseFerProm = P01PC2_A1798ConBaseFerProm[0] ;
            A1799ConBaseHorExtProm = P01PC2_A1799ConBaseHorExtProm[0] ;
            A1797ConBaseLicProm = P01PC2_A1797ConBaseLicProm[0] ;
            A1800ConBasePres = P01PC2_A1800ConBasePres[0] ;
            A1801ConBaseAnt = P01PC2_A1801ConBaseAnt[0] ;
            A1827ConBaseOSDif = P01PC2_A1827ConBaseOSDif[0] ;
            A1826ConPueNov = P01PC2_A1826ConPueNov[0] ;
            AV37GXLvl14 = (byte)(1) ;
            AV17esGral = true ;
            AV14conceptoConvenio = A1645ConceptoConveCodigo ;
            AV15conceptoConvePais = A1644ConceptoPais ;
            if ( ! (GXutil.strcmp("", AV14conceptoConvenio)==0) )
            {
               AV17esGral = false ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " esgral ", "")+GXutil.trim( GXutil.booltostr( AV17esGral))+httpContext.getMessage( " &conceptoConvenio ", "")+GXutil.trim( AV14conceptoConvenio)) ;
            GXv_boolean3[0] = AV25tieneEseConvenio ;
            new web.clientetieneconvenio(remoteHandle, context).execute( AV23propioCliCod, AV15conceptoConvePais, AV14conceptoConvenio, GXv_boolean3) ;
            getconceptos2.this.AV25tieneEseConvenio = GXv_boolean3[0] ;
            if ( ( AV17esGral ) || ( ( AV12clienteConvenioEs ) && ( AV25tieneEseConvenio ) ) )
            {
               AV18itemConcepto = (web.Sdtsdt_concepto_sdt_conceptoItem)new web.Sdtsdt_concepto_sdt_conceptoItem(remoteHandle, context);
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod( A3CliCod );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec( A1886ConRelSec );
               new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&itemConcepto.CliCod ", "")+GXutil.trim( GXutil.str( AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(), 6, 0))) ;
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo( AV14conceptoConvenio );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais( AV15conceptoConvePais );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip( A1648ConCodAfip );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo( A1472ConSIPAApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont( A1473ConSIPACont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo( A1474ConINSSJyPApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont( A1475ConINSSJyPCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo( A1476ConObraSocApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont( A1477ConObraSocCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo( A1478ConFonSolRedApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont( A1479ConFonSolRedCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo( A1480ConRenateaApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont( A1481ConRenateaCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont( A1482ConAsigFamCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont( A1483ConFonNacEmpCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont( A1484ConLeyRieTrabCont );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo( A1485ConRegDifApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo( A1486ConRegEspApo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero( A1471ConNumero );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant( A1018ConRangoCant );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu( A1077ConAdelDescu );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos( A1068ConMostrarPos );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero( A1821ConErrorSiCero );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion( A953ConCondicion );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo( A954ConCondCodigo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga( A951ConObliga );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac( A952ConObligaSiSac );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo( A26ConCodigo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado( A922ConUsado );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip( GXutil.trim( A41ConDescrip) );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado( A150ConHabilitado );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo( A154ConTipo );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden( A40ConOrden );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec( A510ConOrdEjec );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti( A143ConCanti );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni( A158ConValUni );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte( A152ConImporte );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia( A162ConVigencia );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula( A148ConFormula );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen( A157ConValorGen );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias( A155ConTipoLiqGanancias );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion( A153ConObservacion );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable( A159ConVariable );
               if ( ( AV12clienteConvenioEs ) && ( AV25tieneEseConvenio ) && ( AV21padre_CliCod == AV11cliente_sistema_CliCod ) && ! AV17esGral )
               {
                  AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable( true );
               }
               else
               {
                  AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable( false );
               }
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod( A37TipoConCod );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1( A38SubTipoConCod1 );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2( A39SubTipoConCod2 );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl( A569ConFormulaExpl );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular( A762ConRecalcular );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor( A734ConRetGanPropor );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg( A1112AplIIGG );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden( A895ConTipoOrden );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq( A1066ConPreReq );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla( A1194ConSegunPla );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven( A1539ConSacDeven );
               AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().clear();
               AV30auxConCodigo = A26ConCodigo ;
               AV31auxCliCod = A3CliCod ;
               /* Execute user subroutine: 'TIPOS LIQ' */
               S125 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Using cursor P01PC3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1534ConMegDura = P01PC3_A1534ConMegDura[0] ;
                  A1530ConMegMeses = P01PC3_A1530ConMegMeses[0] ;
                  A1529ConMegPropor = P01PC3_A1529ConMegPropor[0] ;
                  A11MegCodigo = P01PC3_A11MegCodigo[0] ;
                  A1532MegPreaTipo = P01PC3_A1532MegPreaTipo[0] ;
                  A2077ConMegSec = P01PC3_A2077ConMegSec[0] ;
                  AV32itemMotEgr = (web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem)new web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem(remoteHandle, context);
                  AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura( A1534ConMegDura );
                  AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses( A1530ConMegMeses );
                  AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor( A1529ConMegPropor );
                  AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo( A11MegCodigo );
                  AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo( A1532MegPreaTipo );
                  AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso().add(AV32itemMotEgr, 0);
                  pr_default.readNext(1);
               }
               pr_default.close(1);
               AV14conceptoConvenio = A1645ConceptoConveCodigo ;
               if ( ! (GXutil.strcmp("", AV14conceptoConvenio)==0) )
               {
                  AV17esGral = false ;
               }
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer( A1621ConBaseFer );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext( A1622ConBaseHorExt );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic( A1620ConBaseLic );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus( A2191ConBaseAus );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom( A2192ConBaseAusProm );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom( A1798ConBaseFerProm );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom( A1799ConBaseHorExtProm );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom( A1797ConBaseLicProm );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres( A1800ConBasePres );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant( A1801ConBaseAnt );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif( A1827ConBaseOSDif );
               AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov( A1826ConPueNov );
               AV24sdt_concepto.add(AV18itemConcepto, 0);
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV37GXLvl14 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      if ( ! AV12clienteConvenioEs )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&propioCliCod ", "")+GXutil.trim( GXutil.str( AV23propioCliCod, 6, 0))) ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              Boolean.valueOf(AV22padreEsVersionador) ,
                                              Short.valueOf(AV27versionador_CliPaiConve) ,
                                              AV26versionador_CliConvenio ,
                                              Integer.valueOf(A1566CliConveVer) ,
                                              Integer.valueOf(AV21padre_CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              A1565CliConvenio ,
                                              Integer.valueOf(AV23propioCliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01PC4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV23propioCliCod), Integer.valueOf(AV21padre_CliCod), Short.valueOf(AV27versionador_CliPaiConve), AV26versionador_CliConvenio});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A1565CliConvenio = P01PC4_A1565CliConvenio[0] ;
            A1564CliPaiConve = P01PC4_A1564CliPaiConve[0] ;
            A1566CliConveVer = P01PC4_A1566CliConveVer[0] ;
            n1566CliConveVer = P01PC4_n1566CliConveVer[0] ;
            A3CliCod = P01PC4_A3CliCod[0] ;
            AV10CliConveVer = A1566CliConveVer ;
            AV13CliPaiConve = A1564CliPaiConve ;
            AV9CliConvenio = A1565CliConvenio ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&CliConveVer ", "")+GXutil.trim( GXutil.str( AV10CliConveVer, 6, 0))) ;
            GXv_boolean3[0] = AV28CliConveHab ;
            new web.getclienteconveniohab(remoteHandle, context).execute( AV10CliConveVer, AV13CliPaiConve, AV9CliConvenio, GXv_boolean3) ;
            getconceptos2.this.AV28CliConveHab = GXv_boolean3[0] ;
            if ( AV28CliConveHab )
            {
               /* Execute user subroutine: 'CONCEPTOS DE CONVENIO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(2);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CONCEPTOS DE CONVENIO' Routine */
      returnInSub = false ;
      AV40GXLvl183 = (byte)(0) ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           AV16ConCodigo ,
                                           Integer.valueOf(AV33CliRelSec) ,
                                           A26ConCodigo ,
                                           Integer.valueOf(A1886ConRelSec) ,
                                           Integer.valueOf(AV10CliConveVer) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01PC5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV10CliConveVer), AV16ConCodigo, Integer.valueOf(AV33CliRelSec)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A1822CliPadre = P01PC5_A1822CliPadre[0] ;
         n1822CliPadre = P01PC5_n1822CliPadre[0] ;
         A26ConCodigo = P01PC5_A26ConCodigo[0] ;
         A3CliCod = P01PC5_A3CliCod[0] ;
         A1886ConRelSec = P01PC5_A1886ConRelSec[0] ;
         A1648ConCodAfip = P01PC5_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P01PC5_A1539ConSacDeven[0] ;
         A1472ConSIPAApo = P01PC5_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = P01PC5_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = P01PC5_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = P01PC5_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = P01PC5_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = P01PC5_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = P01PC5_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = P01PC5_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = P01PC5_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = P01PC5_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = P01PC5_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = P01PC5_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = P01PC5_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = P01PC5_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = P01PC5_A1486ConRegEspApo[0] ;
         A1471ConNumero = P01PC5_A1471ConNumero[0] ;
         A1018ConRangoCant = P01PC5_A1018ConRangoCant[0] ;
         A1077ConAdelDescu = P01PC5_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = P01PC5_n1077ConAdelDescu[0] ;
         A1068ConMostrarPos = P01PC5_A1068ConMostrarPos[0] ;
         A1821ConErrorSiCero = P01PC5_A1821ConErrorSiCero[0] ;
         A953ConCondicion = P01PC5_A953ConCondicion[0] ;
         n953ConCondicion = P01PC5_n953ConCondicion[0] ;
         A954ConCondCodigo = P01PC5_A954ConCondCodigo[0] ;
         A951ConObliga = P01PC5_A951ConObliga[0] ;
         n951ConObliga = P01PC5_n951ConObliga[0] ;
         A952ConObligaSiSac = P01PC5_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = P01PC5_n952ConObligaSiSac[0] ;
         A922ConUsado = P01PC5_A922ConUsado[0] ;
         A41ConDescrip = P01PC5_A41ConDescrip[0] ;
         A150ConHabilitado = P01PC5_A150ConHabilitado[0] ;
         A154ConTipo = P01PC5_A154ConTipo[0] ;
         A40ConOrden = P01PC5_A40ConOrden[0] ;
         A510ConOrdEjec = P01PC5_A510ConOrdEjec[0] ;
         A143ConCanti = P01PC5_A143ConCanti[0] ;
         A158ConValUni = P01PC5_A158ConValUni[0] ;
         A152ConImporte = P01PC5_A152ConImporte[0] ;
         A162ConVigencia = P01PC5_A162ConVigencia[0] ;
         A148ConFormula = P01PC5_A148ConFormula[0] ;
         n148ConFormula = P01PC5_n148ConFormula[0] ;
         A157ConValorGen = P01PC5_A157ConValorGen[0] ;
         n157ConValorGen = P01PC5_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = P01PC5_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = P01PC5_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = P01PC5_A153ConObservacion[0] ;
         A159ConVariable = P01PC5_A159ConVariable[0] ;
         A37TipoConCod = P01PC5_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P01PC5_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P01PC5_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = P01PC5_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P01PC5_n39SubTipoConCod2[0] ;
         A569ConFormulaExpl = P01PC5_A569ConFormulaExpl[0] ;
         A762ConRecalcular = P01PC5_A762ConRecalcular[0] ;
         A734ConRetGanPropor = P01PC5_A734ConRetGanPropor[0] ;
         A1112AplIIGG = P01PC5_A1112AplIIGG[0] ;
         n1112AplIIGG = P01PC5_n1112AplIIGG[0] ;
         A895ConTipoOrden = P01PC5_A895ConTipoOrden[0] ;
         A1066ConPreReq = P01PC5_A1066ConPreReq[0] ;
         n1066ConPreReq = P01PC5_n1066ConPreReq[0] ;
         A1194ConSegunPla = P01PC5_A1194ConSegunPla[0] ;
         A1645ConceptoConveCodigo = P01PC5_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01PC5_n1645ConceptoConveCodigo[0] ;
         A1644ConceptoPais = P01PC5_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P01PC5_n1644ConceptoPais[0] ;
         A1621ConBaseFer = P01PC5_A1621ConBaseFer[0] ;
         A1622ConBaseHorExt = P01PC5_A1622ConBaseHorExt[0] ;
         A1620ConBaseLic = P01PC5_A1620ConBaseLic[0] ;
         A2191ConBaseAus = P01PC5_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = P01PC5_A2192ConBaseAusProm[0] ;
         A1798ConBaseFerProm = P01PC5_A1798ConBaseFerProm[0] ;
         A1799ConBaseHorExtProm = P01PC5_A1799ConBaseHorExtProm[0] ;
         A1797ConBaseLicProm = P01PC5_A1797ConBaseLicProm[0] ;
         A1800ConBasePres = P01PC5_A1800ConBasePres[0] ;
         A1801ConBaseAnt = P01PC5_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = P01PC5_A1827ConBaseOSDif[0] ;
         A1826ConPueNov = P01PC5_A1826ConPueNov[0] ;
         AV40GXLvl183 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "add de convenio", "")) ;
         AV18itemConcepto = (web.Sdtsdt_concepto_sdt_conceptoItem)new web.Sdtsdt_concepto_sdt_conceptoItem(remoteHandle, context);
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "2&itemConcepto.CliCod ", "")+GXutil.trim( GXutil.str( AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(), 6, 0))) ;
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod( A3CliCod );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec( A1886ConRelSec );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo( AV9CliConvenio );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais( AV13CliPaiConve );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip( A1648ConCodAfip );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven( A1539ConSacDeven );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo( A1472ConSIPAApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont( A1473ConSIPACont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo( A1474ConINSSJyPApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont( A1475ConINSSJyPCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo( A1476ConObraSocApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont( A1477ConObraSocCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo( A1478ConFonSolRedApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont( A1479ConFonSolRedCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo( A1480ConRenateaApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont( A1481ConRenateaCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont( A1482ConAsigFamCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont( A1483ConFonNacEmpCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont( A1484ConLeyRieTrabCont );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo( A1485ConRegDifApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo( A1486ConRegEspApo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero( A1471ConNumero );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant( A1018ConRangoCant );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu( A1077ConAdelDescu );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos( A1068ConMostrarPos );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero( A1821ConErrorSiCero );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion( A953ConCondicion );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo( A954ConCondCodigo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga( A951ConObliga );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac( A952ConObligaSiSac );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo( A26ConCodigo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado( A922ConUsado );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip( GXutil.trim( A41ConDescrip) );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado( A150ConHabilitado );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo( A154ConTipo );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden( A40ConOrden );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec( A510ConOrdEjec );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti( A143ConCanti );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni( A158ConValUni );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte( A152ConImporte );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia( A162ConVigencia );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula( A148ConFormula );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen( A157ConValorGen );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias( A155ConTipoLiqGanancias );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion( A153ConObservacion );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable( A159ConVariable );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable( false );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod( A37TipoConCod );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1( A38SubTipoConCod1 );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2( A39SubTipoConCod2 );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl( A569ConFormulaExpl );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular( A762ConRecalcular );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor( A734ConRetGanPropor );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg( A1112AplIIGG );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden( A895ConTipoOrden );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq( A1066ConPreReq );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla( A1194ConSegunPla );
         AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().clear();
         AV30auxConCodigo = A26ConCodigo ;
         AV31auxCliCod = A3CliCod ;
         /* Execute user subroutine: 'TIPOS LIQ' */
         S125 ();
         if ( returnInSub )
         {
            pr_default.close(3);
            returnInSub = true;
            if (true) return;
         }
         /* Using cursor P01PC6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A1534ConMegDura = P01PC6_A1534ConMegDura[0] ;
            A1530ConMegMeses = P01PC6_A1530ConMegMeses[0] ;
            A1529ConMegPropor = P01PC6_A1529ConMegPropor[0] ;
            A11MegCodigo = P01PC6_A11MegCodigo[0] ;
            A1532MegPreaTipo = P01PC6_A1532MegPreaTipo[0] ;
            A2077ConMegSec = P01PC6_A2077ConMegSec[0] ;
            AV32itemMotEgr = (web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem)new web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem(remoteHandle, context);
            AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura( A1534ConMegDura );
            AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses( A1530ConMegMeses );
            AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor( A1529ConMegPropor );
            AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo( A11MegCodigo );
            AV32itemMotEgr.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo( A1532MegPreaTipo );
            AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso().add(AV32itemMotEgr, 0);
            pr_default.readNext(4);
         }
         pr_default.close(4);
         AV14conceptoConvenio = A1645ConceptoConveCodigo ;
         AV15conceptoConvePais = A1644ConceptoPais ;
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer( A1621ConBaseFer );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext( A1622ConBaseHorExt );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic( A1620ConBaseLic );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus( A2191ConBaseAus );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom( A2192ConBaseAusProm );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom( A1798ConBaseFerProm );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom( A1799ConBaseHorExtProm );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom( A1797ConBaseLicProm );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres( A1800ConBasePres );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant( A1801ConBaseAnt );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif( A1827ConBaseOSDif );
         AV18itemConcepto.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov( A1826ConPueNov );
         if ( ( AV15conceptoConvePais == AV13CliPaiConve ) && ( GXutil.strcmp(AV14conceptoConvenio, AV9CliConvenio) == 0 ) )
         {
            AV24sdt_concepto.add(AV18itemConcepto, 0);
         }
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV40GXLvl183 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "none2", "")) ;
      }
   }

   public void S125( )
   {
      /* 'TIPOS LIQ' Routine */
      returnInSub = false ;
      /* Using cursor P01PC7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV31auxCliCod), AV30auxConCodigo});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A26ConCodigo = P01PC7_A26ConCodigo[0] ;
         A3CliCod = P01PC7_A3CliCod[0] ;
         A32TLiqCod = P01PC7_A32TLiqCod[0] ;
         A950ConTLTipEgr = P01PC7_A950ConTLTipEgr[0] ;
         AV20itemTipoLiq = (web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)new web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem(remoteHandle, context);
         AV20itemTipoLiq.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod( A32TLiqCod );
         AV20itemTipoLiq.setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr( A950ConTLTipEgr );
         AV18itemConcepto.getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().add(AV20itemTipoLiq, 0);
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptos2.this.AV24sdt_concepto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24sdt_concepto = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem>(web.Sdtsdt_concepto_sdt_conceptoItem.class, "sdt_conceptoItem", "PayDay", remoteHandle);
      AV36Pgmname = "" ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new int[1] ;
      AV16ConCodigo = "" ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      P01PC2_A1822CliPadre = new int[1] ;
      P01PC2_n1822CliPadre = new boolean[] {false} ;
      P01PC2_A26ConCodigo = new String[] {""} ;
      P01PC2_A3CliCod = new int[1] ;
      P01PC2_A1886ConRelSec = new int[1] ;
      P01PC2_A1645ConceptoConveCodigo = new String[] {""} ;
      P01PC2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01PC2_A1644ConceptoPais = new short[1] ;
      P01PC2_n1644ConceptoPais = new boolean[] {false} ;
      P01PC2_A1648ConCodAfip = new String[] {""} ;
      P01PC2_A1472ConSIPAApo = new byte[1] ;
      P01PC2_A1473ConSIPACont = new byte[1] ;
      P01PC2_A1474ConINSSJyPApo = new byte[1] ;
      P01PC2_A1475ConINSSJyPCont = new byte[1] ;
      P01PC2_A1476ConObraSocApo = new byte[1] ;
      P01PC2_A1477ConObraSocCont = new byte[1] ;
      P01PC2_A1478ConFonSolRedApo = new byte[1] ;
      P01PC2_A1479ConFonSolRedCont = new byte[1] ;
      P01PC2_A1480ConRenateaApo = new byte[1] ;
      P01PC2_A1481ConRenateaCont = new byte[1] ;
      P01PC2_A1482ConAsigFamCont = new byte[1] ;
      P01PC2_A1483ConFonNacEmpCont = new byte[1] ;
      P01PC2_A1484ConLeyRieTrabCont = new byte[1] ;
      P01PC2_A1485ConRegDifApo = new byte[1] ;
      P01PC2_A1486ConRegEspApo = new byte[1] ;
      P01PC2_A1471ConNumero = new byte[1] ;
      P01PC2_A1018ConRangoCant = new String[] {""} ;
      P01PC2_A1077ConAdelDescu = new byte[1] ;
      P01PC2_n1077ConAdelDescu = new boolean[] {false} ;
      P01PC2_A1068ConMostrarPos = new boolean[] {false} ;
      P01PC2_A1821ConErrorSiCero = new boolean[] {false} ;
      P01PC2_A953ConCondicion = new String[] {""} ;
      P01PC2_n953ConCondicion = new boolean[] {false} ;
      P01PC2_A954ConCondCodigo = new String[] {""} ;
      P01PC2_A951ConObliga = new boolean[] {false} ;
      P01PC2_n951ConObliga = new boolean[] {false} ;
      P01PC2_A952ConObligaSiSac = new boolean[] {false} ;
      P01PC2_n952ConObligaSiSac = new boolean[] {false} ;
      P01PC2_A922ConUsado = new boolean[] {false} ;
      P01PC2_A41ConDescrip = new String[] {""} ;
      P01PC2_A150ConHabilitado = new boolean[] {false} ;
      P01PC2_A154ConTipo = new byte[1] ;
      P01PC2_A40ConOrden = new int[1] ;
      P01PC2_A510ConOrdEjec = new long[1] ;
      P01PC2_A143ConCanti = new boolean[] {false} ;
      P01PC2_A158ConValUni = new boolean[] {false} ;
      P01PC2_A152ConImporte = new boolean[] {false} ;
      P01PC2_A162ConVigencia = new byte[1] ;
      P01PC2_A148ConFormula = new String[] {""} ;
      P01PC2_n148ConFormula = new boolean[] {false} ;
      P01PC2_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PC2_n157ConValorGen = new boolean[] {false} ;
      P01PC2_A155ConTipoLiqGanancias = new String[] {""} ;
      P01PC2_n155ConTipoLiqGanancias = new boolean[] {false} ;
      P01PC2_A153ConObservacion = new String[] {""} ;
      P01PC2_A159ConVariable = new boolean[] {false} ;
      P01PC2_A37TipoConCod = new String[] {""} ;
      P01PC2_A38SubTipoConCod1 = new String[] {""} ;
      P01PC2_n38SubTipoConCod1 = new boolean[] {false} ;
      P01PC2_A39SubTipoConCod2 = new String[] {""} ;
      P01PC2_n39SubTipoConCod2 = new boolean[] {false} ;
      P01PC2_A569ConFormulaExpl = new String[] {""} ;
      P01PC2_A762ConRecalcular = new boolean[] {false} ;
      P01PC2_A734ConRetGanPropor = new boolean[] {false} ;
      P01PC2_A1112AplIIGG = new short[1] ;
      P01PC2_n1112AplIIGG = new boolean[] {false} ;
      P01PC2_A895ConTipoOrden = new short[1] ;
      P01PC2_A1066ConPreReq = new String[] {""} ;
      P01PC2_n1066ConPreReq = new boolean[] {false} ;
      P01PC2_A1194ConSegunPla = new boolean[] {false} ;
      P01PC2_A1539ConSacDeven = new byte[1] ;
      P01PC2_A1621ConBaseFer = new byte[1] ;
      P01PC2_A1622ConBaseHorExt = new byte[1] ;
      P01PC2_A1620ConBaseLic = new byte[1] ;
      P01PC2_A2191ConBaseAus = new byte[1] ;
      P01PC2_A2192ConBaseAusProm = new byte[1] ;
      P01PC2_A1798ConBaseFerProm = new byte[1] ;
      P01PC2_A1799ConBaseHorExtProm = new byte[1] ;
      P01PC2_A1797ConBaseLicProm = new byte[1] ;
      P01PC2_A1800ConBasePres = new byte[1] ;
      P01PC2_A1801ConBaseAnt = new byte[1] ;
      P01PC2_A1827ConBaseOSDif = new byte[1] ;
      P01PC2_A1826ConPueNov = new boolean[] {false} ;
      A1645ConceptoConveCodigo = "" ;
      A1648ConCodAfip = "" ;
      A1018ConRangoCant = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      A41ConDescrip = "" ;
      A148ConFormula = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A155ConTipoLiqGanancias = "" ;
      A153ConObservacion = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A569ConFormulaExpl = "" ;
      A1066ConPreReq = "" ;
      AV14conceptoConvenio = "" ;
      AV18itemConcepto = new web.Sdtsdt_concepto_sdt_conceptoItem(remoteHandle, context);
      AV30auxConCodigo = "" ;
      P01PC3_A3CliCod = new int[1] ;
      P01PC3_A26ConCodigo = new String[] {""} ;
      P01PC3_A1534ConMegDura = new String[] {""} ;
      P01PC3_A1530ConMegMeses = new byte[1] ;
      P01PC3_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PC3_A11MegCodigo = new String[] {""} ;
      P01PC3_A1532MegPreaTipo = new String[] {""} ;
      P01PC3_A2077ConMegSec = new short[1] ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      A11MegCodigo = "" ;
      A1532MegPreaTipo = "" ;
      AV32itemMotEgr = new web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem(remoteHandle, context);
      A1565CliConvenio = "" ;
      P01PC4_A1565CliConvenio = new String[] {""} ;
      P01PC4_A1564CliPaiConve = new short[1] ;
      P01PC4_A1566CliConveVer = new int[1] ;
      P01PC4_n1566CliConveVer = new boolean[] {false} ;
      P01PC4_A3CliCod = new int[1] ;
      AV9CliConvenio = "" ;
      GXv_boolean3 = new boolean[1] ;
      P01PC5_A1822CliPadre = new int[1] ;
      P01PC5_n1822CliPadre = new boolean[] {false} ;
      P01PC5_A26ConCodigo = new String[] {""} ;
      P01PC5_A3CliCod = new int[1] ;
      P01PC5_A1886ConRelSec = new int[1] ;
      P01PC5_A1648ConCodAfip = new String[] {""} ;
      P01PC5_A1539ConSacDeven = new byte[1] ;
      P01PC5_A1472ConSIPAApo = new byte[1] ;
      P01PC5_A1473ConSIPACont = new byte[1] ;
      P01PC5_A1474ConINSSJyPApo = new byte[1] ;
      P01PC5_A1475ConINSSJyPCont = new byte[1] ;
      P01PC5_A1476ConObraSocApo = new byte[1] ;
      P01PC5_A1477ConObraSocCont = new byte[1] ;
      P01PC5_A1478ConFonSolRedApo = new byte[1] ;
      P01PC5_A1479ConFonSolRedCont = new byte[1] ;
      P01PC5_A1480ConRenateaApo = new byte[1] ;
      P01PC5_A1481ConRenateaCont = new byte[1] ;
      P01PC5_A1482ConAsigFamCont = new byte[1] ;
      P01PC5_A1483ConFonNacEmpCont = new byte[1] ;
      P01PC5_A1484ConLeyRieTrabCont = new byte[1] ;
      P01PC5_A1485ConRegDifApo = new byte[1] ;
      P01PC5_A1486ConRegEspApo = new byte[1] ;
      P01PC5_A1471ConNumero = new byte[1] ;
      P01PC5_A1018ConRangoCant = new String[] {""} ;
      P01PC5_A1077ConAdelDescu = new byte[1] ;
      P01PC5_n1077ConAdelDescu = new boolean[] {false} ;
      P01PC5_A1068ConMostrarPos = new boolean[] {false} ;
      P01PC5_A1821ConErrorSiCero = new boolean[] {false} ;
      P01PC5_A953ConCondicion = new String[] {""} ;
      P01PC5_n953ConCondicion = new boolean[] {false} ;
      P01PC5_A954ConCondCodigo = new String[] {""} ;
      P01PC5_A951ConObliga = new boolean[] {false} ;
      P01PC5_n951ConObliga = new boolean[] {false} ;
      P01PC5_A952ConObligaSiSac = new boolean[] {false} ;
      P01PC5_n952ConObligaSiSac = new boolean[] {false} ;
      P01PC5_A922ConUsado = new boolean[] {false} ;
      P01PC5_A41ConDescrip = new String[] {""} ;
      P01PC5_A150ConHabilitado = new boolean[] {false} ;
      P01PC5_A154ConTipo = new byte[1] ;
      P01PC5_A40ConOrden = new int[1] ;
      P01PC5_A510ConOrdEjec = new long[1] ;
      P01PC5_A143ConCanti = new boolean[] {false} ;
      P01PC5_A158ConValUni = new boolean[] {false} ;
      P01PC5_A152ConImporte = new boolean[] {false} ;
      P01PC5_A162ConVigencia = new byte[1] ;
      P01PC5_A148ConFormula = new String[] {""} ;
      P01PC5_n148ConFormula = new boolean[] {false} ;
      P01PC5_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PC5_n157ConValorGen = new boolean[] {false} ;
      P01PC5_A155ConTipoLiqGanancias = new String[] {""} ;
      P01PC5_n155ConTipoLiqGanancias = new boolean[] {false} ;
      P01PC5_A153ConObservacion = new String[] {""} ;
      P01PC5_A159ConVariable = new boolean[] {false} ;
      P01PC5_A37TipoConCod = new String[] {""} ;
      P01PC5_A38SubTipoConCod1 = new String[] {""} ;
      P01PC5_n38SubTipoConCod1 = new boolean[] {false} ;
      P01PC5_A39SubTipoConCod2 = new String[] {""} ;
      P01PC5_n39SubTipoConCod2 = new boolean[] {false} ;
      P01PC5_A569ConFormulaExpl = new String[] {""} ;
      P01PC5_A762ConRecalcular = new boolean[] {false} ;
      P01PC5_A734ConRetGanPropor = new boolean[] {false} ;
      P01PC5_A1112AplIIGG = new short[1] ;
      P01PC5_n1112AplIIGG = new boolean[] {false} ;
      P01PC5_A895ConTipoOrden = new short[1] ;
      P01PC5_A1066ConPreReq = new String[] {""} ;
      P01PC5_n1066ConPreReq = new boolean[] {false} ;
      P01PC5_A1194ConSegunPla = new boolean[] {false} ;
      P01PC5_A1645ConceptoConveCodigo = new String[] {""} ;
      P01PC5_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01PC5_A1644ConceptoPais = new short[1] ;
      P01PC5_n1644ConceptoPais = new boolean[] {false} ;
      P01PC5_A1621ConBaseFer = new byte[1] ;
      P01PC5_A1622ConBaseHorExt = new byte[1] ;
      P01PC5_A1620ConBaseLic = new byte[1] ;
      P01PC5_A2191ConBaseAus = new byte[1] ;
      P01PC5_A2192ConBaseAusProm = new byte[1] ;
      P01PC5_A1798ConBaseFerProm = new byte[1] ;
      P01PC5_A1799ConBaseHorExtProm = new byte[1] ;
      P01PC5_A1797ConBaseLicProm = new byte[1] ;
      P01PC5_A1800ConBasePres = new byte[1] ;
      P01PC5_A1801ConBaseAnt = new byte[1] ;
      P01PC5_A1827ConBaseOSDif = new byte[1] ;
      P01PC5_A1826ConPueNov = new boolean[] {false} ;
      P01PC6_A3CliCod = new int[1] ;
      P01PC6_A26ConCodigo = new String[] {""} ;
      P01PC6_A1534ConMegDura = new String[] {""} ;
      P01PC6_A1530ConMegMeses = new byte[1] ;
      P01PC6_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PC6_A11MegCodigo = new String[] {""} ;
      P01PC6_A1532MegPreaTipo = new String[] {""} ;
      P01PC6_A2077ConMegSec = new short[1] ;
      P01PC7_A26ConCodigo = new String[] {""} ;
      P01PC7_A3CliCod = new int[1] ;
      P01PC7_A32TLiqCod = new String[] {""} ;
      P01PC7_A950ConTLTipEgr = new String[] {""} ;
      A32TLiqCod = "" ;
      A950ConTLTipEgr = "" ;
      AV20itemTipoLiq = new web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptos2__default(),
         new Object[] {
             new Object[] {
            P01PC2_A1822CliPadre, P01PC2_n1822CliPadre, P01PC2_A26ConCodigo, P01PC2_A3CliCod, P01PC2_A1886ConRelSec, P01PC2_A1645ConceptoConveCodigo, P01PC2_n1645ConceptoConveCodigo, P01PC2_A1644ConceptoPais, P01PC2_n1644ConceptoPais, P01PC2_A1648ConCodAfip,
            P01PC2_A1472ConSIPAApo, P01PC2_A1473ConSIPACont, P01PC2_A1474ConINSSJyPApo, P01PC2_A1475ConINSSJyPCont, P01PC2_A1476ConObraSocApo, P01PC2_A1477ConObraSocCont, P01PC2_A1478ConFonSolRedApo, P01PC2_A1479ConFonSolRedCont, P01PC2_A1480ConRenateaApo, P01PC2_A1481ConRenateaCont,
            P01PC2_A1482ConAsigFamCont, P01PC2_A1483ConFonNacEmpCont, P01PC2_A1484ConLeyRieTrabCont, P01PC2_A1485ConRegDifApo, P01PC2_A1486ConRegEspApo, P01PC2_A1471ConNumero, P01PC2_A1018ConRangoCant, P01PC2_A1077ConAdelDescu, P01PC2_n1077ConAdelDescu, P01PC2_A1068ConMostrarPos,
            P01PC2_A1821ConErrorSiCero, P01PC2_A953ConCondicion, P01PC2_n953ConCondicion, P01PC2_A954ConCondCodigo, P01PC2_A951ConObliga, P01PC2_n951ConObliga, P01PC2_A952ConObligaSiSac, P01PC2_n952ConObligaSiSac, P01PC2_A922ConUsado, P01PC2_A41ConDescrip,
            P01PC2_A150ConHabilitado, P01PC2_A154ConTipo, P01PC2_A40ConOrden, P01PC2_A510ConOrdEjec, P01PC2_A143ConCanti, P01PC2_A158ConValUni, P01PC2_A152ConImporte, P01PC2_A162ConVigencia, P01PC2_A148ConFormula, P01PC2_n148ConFormula,
            P01PC2_A157ConValorGen, P01PC2_n157ConValorGen, P01PC2_A155ConTipoLiqGanancias, P01PC2_n155ConTipoLiqGanancias, P01PC2_A153ConObservacion, P01PC2_A159ConVariable, P01PC2_A37TipoConCod, P01PC2_A38SubTipoConCod1, P01PC2_n38SubTipoConCod1, P01PC2_A39SubTipoConCod2,
            P01PC2_n39SubTipoConCod2, P01PC2_A569ConFormulaExpl, P01PC2_A762ConRecalcular, P01PC2_A734ConRetGanPropor, P01PC2_A1112AplIIGG, P01PC2_n1112AplIIGG, P01PC2_A895ConTipoOrden, P01PC2_A1066ConPreReq, P01PC2_n1066ConPreReq, P01PC2_A1194ConSegunPla,
            P01PC2_A1539ConSacDeven, P01PC2_A1621ConBaseFer, P01PC2_A1622ConBaseHorExt, P01PC2_A1620ConBaseLic, P01PC2_A2191ConBaseAus, P01PC2_A2192ConBaseAusProm, P01PC2_A1798ConBaseFerProm, P01PC2_A1799ConBaseHorExtProm, P01PC2_A1797ConBaseLicProm, P01PC2_A1800ConBasePres,
            P01PC2_A1801ConBaseAnt, P01PC2_A1827ConBaseOSDif, P01PC2_A1826ConPueNov
            }
            , new Object[] {
            P01PC3_A3CliCod, P01PC3_A26ConCodigo, P01PC3_A1534ConMegDura, P01PC3_A1530ConMegMeses, P01PC3_A1529ConMegPropor, P01PC3_A11MegCodigo, P01PC3_A1532MegPreaTipo, P01PC3_A2077ConMegSec
            }
            , new Object[] {
            P01PC4_A1565CliConvenio, P01PC4_A1564CliPaiConve, P01PC4_A1566CliConveVer, P01PC4_n1566CliConveVer, P01PC4_A3CliCod
            }
            , new Object[] {
            P01PC5_A1822CliPadre, P01PC5_n1822CliPadre, P01PC5_A26ConCodigo, P01PC5_A3CliCod, P01PC5_A1886ConRelSec, P01PC5_A1648ConCodAfip, P01PC5_A1539ConSacDeven, P01PC5_A1472ConSIPAApo, P01PC5_A1473ConSIPACont, P01PC5_A1474ConINSSJyPApo,
            P01PC5_A1475ConINSSJyPCont, P01PC5_A1476ConObraSocApo, P01PC5_A1477ConObraSocCont, P01PC5_A1478ConFonSolRedApo, P01PC5_A1479ConFonSolRedCont, P01PC5_A1480ConRenateaApo, P01PC5_A1481ConRenateaCont, P01PC5_A1482ConAsigFamCont, P01PC5_A1483ConFonNacEmpCont, P01PC5_A1484ConLeyRieTrabCont,
            P01PC5_A1485ConRegDifApo, P01PC5_A1486ConRegEspApo, P01PC5_A1471ConNumero, P01PC5_A1018ConRangoCant, P01PC5_A1077ConAdelDescu, P01PC5_n1077ConAdelDescu, P01PC5_A1068ConMostrarPos, P01PC5_A1821ConErrorSiCero, P01PC5_A953ConCondicion, P01PC5_n953ConCondicion,
            P01PC5_A954ConCondCodigo, P01PC5_A951ConObliga, P01PC5_n951ConObliga, P01PC5_A952ConObligaSiSac, P01PC5_n952ConObligaSiSac, P01PC5_A922ConUsado, P01PC5_A41ConDescrip, P01PC5_A150ConHabilitado, P01PC5_A154ConTipo, P01PC5_A40ConOrden,
            P01PC5_A510ConOrdEjec, P01PC5_A143ConCanti, P01PC5_A158ConValUni, P01PC5_A152ConImporte, P01PC5_A162ConVigencia, P01PC5_A148ConFormula, P01PC5_n148ConFormula, P01PC5_A157ConValorGen, P01PC5_n157ConValorGen, P01PC5_A155ConTipoLiqGanancias,
            P01PC5_n155ConTipoLiqGanancias, P01PC5_A153ConObservacion, P01PC5_A159ConVariable, P01PC5_A37TipoConCod, P01PC5_A38SubTipoConCod1, P01PC5_n38SubTipoConCod1, P01PC5_A39SubTipoConCod2, P01PC5_n39SubTipoConCod2, P01PC5_A569ConFormulaExpl, P01PC5_A762ConRecalcular,
            P01PC5_A734ConRetGanPropor, P01PC5_A1112AplIIGG, P01PC5_n1112AplIIGG, P01PC5_A895ConTipoOrden, P01PC5_A1066ConPreReq, P01PC5_n1066ConPreReq, P01PC5_A1194ConSegunPla, P01PC5_A1645ConceptoConveCodigo, P01PC5_n1645ConceptoConveCodigo, P01PC5_A1644ConceptoPais,
            P01PC5_n1644ConceptoPais, P01PC5_A1621ConBaseFer, P01PC5_A1622ConBaseHorExt, P01PC5_A1620ConBaseLic, P01PC5_A2191ConBaseAus, P01PC5_A2192ConBaseAusProm, P01PC5_A1798ConBaseFerProm, P01PC5_A1799ConBaseHorExtProm, P01PC5_A1797ConBaseLicProm, P01PC5_A1800ConBasePres,
            P01PC5_A1801ConBaseAnt, P01PC5_A1827ConBaseOSDif, P01PC5_A1826ConPueNov
            }
            , new Object[] {
            P01PC6_A3CliCod, P01PC6_A26ConCodigo, P01PC6_A1534ConMegDura, P01PC6_A1530ConMegMeses, P01PC6_A1529ConMegPropor, P01PC6_A11MegCodigo, P01PC6_A1532MegPreaTipo, P01PC6_A2077ConMegSec
            }
            , new Object[] {
            P01PC7_A26ConCodigo, P01PC7_A3CliCod, P01PC7_A32TLiqCod, P01PC7_A950ConTLTipEgr
            }
         }
      );
      AV36Pgmname = "GetConceptos2" ;
      /* GeneXus formulas. */
      AV36Pgmname = "GetConceptos2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37GXLvl14 ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private byte A1471ConNumero ;
   private byte A1077ConAdelDescu ;
   private byte A154ConTipo ;
   private byte A162ConVigencia ;
   private byte A1539ConSacDeven ;
   private byte A1621ConBaseFer ;
   private byte A1622ConBaseHorExt ;
   private byte A1620ConBaseLic ;
   private byte A2191ConBaseAus ;
   private byte A2192ConBaseAusProm ;
   private byte A1798ConBaseFerProm ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1797ConBaseLicProm ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1827ConBaseOSDif ;
   private byte A1530ConMegMeses ;
   private byte AV40GXLvl183 ;
   private short AV27versionador_CliPaiConve ;
   private short AV29PaiCod ;
   private short GXv_int1[] ;
   private short A1644ConceptoPais ;
   private short A1112AplIIGG ;
   private short A895ConTipoOrden ;
   private short AV15conceptoConvePais ;
   private short A2077ConMegSec ;
   private short A1564CliPaiConve ;
   private short AV13CliPaiConve ;
   private short Gx_err ;
   private int AV21padre_CliCod ;
   private int AV23propioCliCod ;
   private int AV33CliRelSec ;
   private int AV11cliente_sistema_CliCod ;
   private int GXv_int2[] ;
   private int A1886ConRelSec ;
   private int A3CliCod ;
   private int A1822CliPadre ;
   private int A40ConOrden ;
   private int AV31auxCliCod ;
   private int A1566CliConveVer ;
   private int AV10CliConveVer ;
   private long A510ConOrdEjec ;
   private java.math.BigDecimal A157ConValorGen ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String AV26versionador_CliConvenio ;
   private String AV36Pgmname ;
   private String AV16ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1645ConceptoConveCodigo ;
   private String A1648ConCodAfip ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String A155ConTipoLiqGanancias ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A1066ConPreReq ;
   private String AV14conceptoConvenio ;
   private String AV30auxConCodigo ;
   private String A1534ConMegDura ;
   private String A11MegCodigo ;
   private String A1532MegPreaTipo ;
   private String A1565CliConvenio ;
   private String AV9CliConvenio ;
   private String A32TLiqCod ;
   private String A950ConTLTipEgr ;
   private boolean AV12clienteConvenioEs ;
   private boolean AV22padreEsVersionador ;
   private boolean n1822CliPadre ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1644ConceptoPais ;
   private boolean n1077ConAdelDescu ;
   private boolean A1068ConMostrarPos ;
   private boolean A1821ConErrorSiCero ;
   private boolean n953ConCondicion ;
   private boolean A951ConObliga ;
   private boolean n951ConObliga ;
   private boolean A952ConObligaSiSac ;
   private boolean n952ConObligaSiSac ;
   private boolean A922ConUsado ;
   private boolean A150ConHabilitado ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean n148ConFormula ;
   private boolean n157ConValorGen ;
   private boolean n155ConTipoLiqGanancias ;
   private boolean A159ConVariable ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean A762ConRecalcular ;
   private boolean A734ConRetGanPropor ;
   private boolean n1112AplIIGG ;
   private boolean n1066ConPreReq ;
   private boolean A1194ConSegunPla ;
   private boolean A1826ConPueNov ;
   private boolean AV17esGral ;
   private boolean AV25tieneEseConvenio ;
   private boolean returnInSub ;
   private boolean n1566CliConveVer ;
   private boolean AV28CliConveHab ;
   private boolean GXv_boolean3[] ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A569ConFormulaExpl ;
   private String A1018ConRangoCant ;
   private String A41ConDescrip ;
   private GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01PC2_A1822CliPadre ;
   private boolean[] P01PC2_n1822CliPadre ;
   private String[] P01PC2_A26ConCodigo ;
   private int[] P01PC2_A3CliCod ;
   private int[] P01PC2_A1886ConRelSec ;
   private String[] P01PC2_A1645ConceptoConveCodigo ;
   private boolean[] P01PC2_n1645ConceptoConveCodigo ;
   private short[] P01PC2_A1644ConceptoPais ;
   private boolean[] P01PC2_n1644ConceptoPais ;
   private String[] P01PC2_A1648ConCodAfip ;
   private byte[] P01PC2_A1472ConSIPAApo ;
   private byte[] P01PC2_A1473ConSIPACont ;
   private byte[] P01PC2_A1474ConINSSJyPApo ;
   private byte[] P01PC2_A1475ConINSSJyPCont ;
   private byte[] P01PC2_A1476ConObraSocApo ;
   private byte[] P01PC2_A1477ConObraSocCont ;
   private byte[] P01PC2_A1478ConFonSolRedApo ;
   private byte[] P01PC2_A1479ConFonSolRedCont ;
   private byte[] P01PC2_A1480ConRenateaApo ;
   private byte[] P01PC2_A1481ConRenateaCont ;
   private byte[] P01PC2_A1482ConAsigFamCont ;
   private byte[] P01PC2_A1483ConFonNacEmpCont ;
   private byte[] P01PC2_A1484ConLeyRieTrabCont ;
   private byte[] P01PC2_A1485ConRegDifApo ;
   private byte[] P01PC2_A1486ConRegEspApo ;
   private byte[] P01PC2_A1471ConNumero ;
   private String[] P01PC2_A1018ConRangoCant ;
   private byte[] P01PC2_A1077ConAdelDescu ;
   private boolean[] P01PC2_n1077ConAdelDescu ;
   private boolean[] P01PC2_A1068ConMostrarPos ;
   private boolean[] P01PC2_A1821ConErrorSiCero ;
   private String[] P01PC2_A953ConCondicion ;
   private boolean[] P01PC2_n953ConCondicion ;
   private String[] P01PC2_A954ConCondCodigo ;
   private boolean[] P01PC2_A951ConObliga ;
   private boolean[] P01PC2_n951ConObliga ;
   private boolean[] P01PC2_A952ConObligaSiSac ;
   private boolean[] P01PC2_n952ConObligaSiSac ;
   private boolean[] P01PC2_A922ConUsado ;
   private String[] P01PC2_A41ConDescrip ;
   private boolean[] P01PC2_A150ConHabilitado ;
   private byte[] P01PC2_A154ConTipo ;
   private int[] P01PC2_A40ConOrden ;
   private long[] P01PC2_A510ConOrdEjec ;
   private boolean[] P01PC2_A143ConCanti ;
   private boolean[] P01PC2_A158ConValUni ;
   private boolean[] P01PC2_A152ConImporte ;
   private byte[] P01PC2_A162ConVigencia ;
   private String[] P01PC2_A148ConFormula ;
   private boolean[] P01PC2_n148ConFormula ;
   private java.math.BigDecimal[] P01PC2_A157ConValorGen ;
   private boolean[] P01PC2_n157ConValorGen ;
   private String[] P01PC2_A155ConTipoLiqGanancias ;
   private boolean[] P01PC2_n155ConTipoLiqGanancias ;
   private String[] P01PC2_A153ConObservacion ;
   private boolean[] P01PC2_A159ConVariable ;
   private String[] P01PC2_A37TipoConCod ;
   private String[] P01PC2_A38SubTipoConCod1 ;
   private boolean[] P01PC2_n38SubTipoConCod1 ;
   private String[] P01PC2_A39SubTipoConCod2 ;
   private boolean[] P01PC2_n39SubTipoConCod2 ;
   private String[] P01PC2_A569ConFormulaExpl ;
   private boolean[] P01PC2_A762ConRecalcular ;
   private boolean[] P01PC2_A734ConRetGanPropor ;
   private short[] P01PC2_A1112AplIIGG ;
   private boolean[] P01PC2_n1112AplIIGG ;
   private short[] P01PC2_A895ConTipoOrden ;
   private String[] P01PC2_A1066ConPreReq ;
   private boolean[] P01PC2_n1066ConPreReq ;
   private boolean[] P01PC2_A1194ConSegunPla ;
   private byte[] P01PC2_A1539ConSacDeven ;
   private byte[] P01PC2_A1621ConBaseFer ;
   private byte[] P01PC2_A1622ConBaseHorExt ;
   private byte[] P01PC2_A1620ConBaseLic ;
   private byte[] P01PC2_A2191ConBaseAus ;
   private byte[] P01PC2_A2192ConBaseAusProm ;
   private byte[] P01PC2_A1798ConBaseFerProm ;
   private byte[] P01PC2_A1799ConBaseHorExtProm ;
   private byte[] P01PC2_A1797ConBaseLicProm ;
   private byte[] P01PC2_A1800ConBasePres ;
   private byte[] P01PC2_A1801ConBaseAnt ;
   private byte[] P01PC2_A1827ConBaseOSDif ;
   private boolean[] P01PC2_A1826ConPueNov ;
   private int[] P01PC3_A3CliCod ;
   private String[] P01PC3_A26ConCodigo ;
   private String[] P01PC3_A1534ConMegDura ;
   private byte[] P01PC3_A1530ConMegMeses ;
   private java.math.BigDecimal[] P01PC3_A1529ConMegPropor ;
   private String[] P01PC3_A11MegCodigo ;
   private String[] P01PC3_A1532MegPreaTipo ;
   private short[] P01PC3_A2077ConMegSec ;
   private String[] P01PC4_A1565CliConvenio ;
   private short[] P01PC4_A1564CliPaiConve ;
   private int[] P01PC4_A1566CliConveVer ;
   private boolean[] P01PC4_n1566CliConveVer ;
   private int[] P01PC4_A3CliCod ;
   private int[] P01PC5_A1822CliPadre ;
   private boolean[] P01PC5_n1822CliPadre ;
   private String[] P01PC5_A26ConCodigo ;
   private int[] P01PC5_A3CliCod ;
   private int[] P01PC5_A1886ConRelSec ;
   private String[] P01PC5_A1648ConCodAfip ;
   private byte[] P01PC5_A1539ConSacDeven ;
   private byte[] P01PC5_A1472ConSIPAApo ;
   private byte[] P01PC5_A1473ConSIPACont ;
   private byte[] P01PC5_A1474ConINSSJyPApo ;
   private byte[] P01PC5_A1475ConINSSJyPCont ;
   private byte[] P01PC5_A1476ConObraSocApo ;
   private byte[] P01PC5_A1477ConObraSocCont ;
   private byte[] P01PC5_A1478ConFonSolRedApo ;
   private byte[] P01PC5_A1479ConFonSolRedCont ;
   private byte[] P01PC5_A1480ConRenateaApo ;
   private byte[] P01PC5_A1481ConRenateaCont ;
   private byte[] P01PC5_A1482ConAsigFamCont ;
   private byte[] P01PC5_A1483ConFonNacEmpCont ;
   private byte[] P01PC5_A1484ConLeyRieTrabCont ;
   private byte[] P01PC5_A1485ConRegDifApo ;
   private byte[] P01PC5_A1486ConRegEspApo ;
   private byte[] P01PC5_A1471ConNumero ;
   private String[] P01PC5_A1018ConRangoCant ;
   private byte[] P01PC5_A1077ConAdelDescu ;
   private boolean[] P01PC5_n1077ConAdelDescu ;
   private boolean[] P01PC5_A1068ConMostrarPos ;
   private boolean[] P01PC5_A1821ConErrorSiCero ;
   private String[] P01PC5_A953ConCondicion ;
   private boolean[] P01PC5_n953ConCondicion ;
   private String[] P01PC5_A954ConCondCodigo ;
   private boolean[] P01PC5_A951ConObliga ;
   private boolean[] P01PC5_n951ConObliga ;
   private boolean[] P01PC5_A952ConObligaSiSac ;
   private boolean[] P01PC5_n952ConObligaSiSac ;
   private boolean[] P01PC5_A922ConUsado ;
   private String[] P01PC5_A41ConDescrip ;
   private boolean[] P01PC5_A150ConHabilitado ;
   private byte[] P01PC5_A154ConTipo ;
   private int[] P01PC5_A40ConOrden ;
   private long[] P01PC5_A510ConOrdEjec ;
   private boolean[] P01PC5_A143ConCanti ;
   private boolean[] P01PC5_A158ConValUni ;
   private boolean[] P01PC5_A152ConImporte ;
   private byte[] P01PC5_A162ConVigencia ;
   private String[] P01PC5_A148ConFormula ;
   private boolean[] P01PC5_n148ConFormula ;
   private java.math.BigDecimal[] P01PC5_A157ConValorGen ;
   private boolean[] P01PC5_n157ConValorGen ;
   private String[] P01PC5_A155ConTipoLiqGanancias ;
   private boolean[] P01PC5_n155ConTipoLiqGanancias ;
   private String[] P01PC5_A153ConObservacion ;
   private boolean[] P01PC5_A159ConVariable ;
   private String[] P01PC5_A37TipoConCod ;
   private String[] P01PC5_A38SubTipoConCod1 ;
   private boolean[] P01PC5_n38SubTipoConCod1 ;
   private String[] P01PC5_A39SubTipoConCod2 ;
   private boolean[] P01PC5_n39SubTipoConCod2 ;
   private String[] P01PC5_A569ConFormulaExpl ;
   private boolean[] P01PC5_A762ConRecalcular ;
   private boolean[] P01PC5_A734ConRetGanPropor ;
   private short[] P01PC5_A1112AplIIGG ;
   private boolean[] P01PC5_n1112AplIIGG ;
   private short[] P01PC5_A895ConTipoOrden ;
   private String[] P01PC5_A1066ConPreReq ;
   private boolean[] P01PC5_n1066ConPreReq ;
   private boolean[] P01PC5_A1194ConSegunPla ;
   private String[] P01PC5_A1645ConceptoConveCodigo ;
   private boolean[] P01PC5_n1645ConceptoConveCodigo ;
   private short[] P01PC5_A1644ConceptoPais ;
   private boolean[] P01PC5_n1644ConceptoPais ;
   private byte[] P01PC5_A1621ConBaseFer ;
   private byte[] P01PC5_A1622ConBaseHorExt ;
   private byte[] P01PC5_A1620ConBaseLic ;
   private byte[] P01PC5_A2191ConBaseAus ;
   private byte[] P01PC5_A2192ConBaseAusProm ;
   private byte[] P01PC5_A1798ConBaseFerProm ;
   private byte[] P01PC5_A1799ConBaseHorExtProm ;
   private byte[] P01PC5_A1797ConBaseLicProm ;
   private byte[] P01PC5_A1800ConBasePres ;
   private byte[] P01PC5_A1801ConBaseAnt ;
   private byte[] P01PC5_A1827ConBaseOSDif ;
   private boolean[] P01PC5_A1826ConPueNov ;
   private int[] P01PC6_A3CliCod ;
   private String[] P01PC6_A26ConCodigo ;
   private String[] P01PC6_A1534ConMegDura ;
   private byte[] P01PC6_A1530ConMegMeses ;
   private java.math.BigDecimal[] P01PC6_A1529ConMegPropor ;
   private String[] P01PC6_A11MegCodigo ;
   private String[] P01PC6_A1532MegPreaTipo ;
   private short[] P01PC6_A2077ConMegSec ;
   private String[] P01PC7_A26ConCodigo ;
   private int[] P01PC7_A3CliCod ;
   private String[] P01PC7_A32TLiqCod ;
   private String[] P01PC7_A950ConTLTipEgr ;
   private GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem> AV24sdt_concepto ;
   private web.Sdtsdt_concepto_sdt_conceptoItem AV18itemConcepto ;
   private web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem AV32itemMotEgr ;
   private web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem AV20itemTipoLiq ;
}

final  class getconceptos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16ConCodigo ,
                                          int AV33CliRelSec ,
                                          String A26ConCodigo ,
                                          int A1886ConRelSec ,
                                          int AV21padre_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[3];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliPadre, ConCodigo, CliCod, ConRelSec, ConceptoConveCodigo, ConceptoPais, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo," ;
      scmdbuf += " ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo," ;
      scmdbuf += " ConNumero, ConRangoCant, ConAdelDescu, ConMostrarPos, ConErrorSiCero, ConCondicion, ConCondCodigo, ConObliga, ConObligaSiSac, ConUsado, ConDescrip, ConHabilitado," ;
      scmdbuf += " ConTipo, ConOrden, ConOrdEjec, ConCanti, ConValUni, ConImporte, ConVigencia, ConFormula, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConVariable, TipoConCod," ;
      scmdbuf += " SubTipoConCod1, SubTipoConCod2, ConFormulaExpl, ConRecalcular, ConRetGanPropor, AplIIGG, ConTipoOrden, ConPreReq, ConSegunPla, ConSacDeven, ConBaseFer, ConBaseHorExt," ;
      scmdbuf += " ConBaseLic, ConBaseAus, ConBaseAusProm, ConBaseFerProm, ConBaseHorExtProm, ConBaseLicProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConPueNov FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV16ConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( ! (0==AV33CliRelSec) )
      {
         addWhere(sWhereString, "(ConRelSec = ?)");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01PC4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV22padreEsVersionador ,
                                          short AV27versionador_CliPaiConve ,
                                          String AV26versionador_CliConvenio ,
                                          int A1566CliConveVer ,
                                          int AV21padre_CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          int AV23propioCliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[4];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliConveVer, CliCod FROM ClienteConvenios" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV22padreEsVersionador )
      {
         addWhere(sWhereString, "(CliConveVer = ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      if ( ( AV22padreEsVersionador ) && ! (0==AV27versionador_CliPaiConve) )
      {
         addWhere(sWhereString, "(CliPaiConve = ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      if ( ( AV22padreEsVersionador ) && ! (GXutil.strcmp("", AV26versionador_CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01PC5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16ConCodigo ,
                                          int AV33CliRelSec ,
                                          String A26ConCodigo ,
                                          int A1886ConRelSec ,
                                          int AV10CliConveVer ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliPadre, ConCodigo, CliCod, ConRelSec, ConCodAfip, ConSacDeven, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo," ;
      scmdbuf += " ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConNumero, ConRangoCant, ConAdelDescu," ;
      scmdbuf += " ConMostrarPos, ConErrorSiCero, ConCondicion, ConCondCodigo, ConObliga, ConObligaSiSac, ConUsado, ConDescrip, ConHabilitado, ConTipo, ConOrden, ConOrdEjec, ConCanti," ;
      scmdbuf += " ConValUni, ConImporte, ConVigencia, ConFormula, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConVariable, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConFormulaExpl," ;
      scmdbuf += " ConRecalcular, ConRetGanPropor, AplIIGG, ConTipoOrden, ConPreReq, ConSegunPla, ConceptoConveCodigo, ConceptoPais, ConBaseFer, ConBaseHorExt, ConBaseLic, ConBaseAus," ;
      scmdbuf += " ConBaseAusProm, ConBaseFerProm, ConBaseHorExtProm, ConBaseLicProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConPueNov FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV16ConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV33CliRelSec) )
      {
         addWhere(sWhereString, "(ConRelSec = ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01PC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
            case 2 :
                  return conditional_P01PC4(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , ((Number) dynConstraints[1]).shortValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() );
            case 3 :
                  return conditional_P01PC5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PC3", "SELECT CliCod, ConCodigo, ConMegDura, ConMegMeses, ConMegPropor, MegCodigo, MegPreaTipo, ConMegSec FROM ConceptoMotivosEgreso WHERE (CliCod = ? and ConCodigo = ( ?)) AND (? = ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PC4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PC5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PC6", "SELECT CliCod, ConCodigo, ConMegDura, ConMegMeses, ConMegPropor, MegCodigo, MegPreaTipo, ConMegSec FROM ConceptoMotivosEgreso WHERE (CliCod = ? and ConCodigo = ( ?)) AND (? = ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PC7", "SELECT ConCodigo, CliCod, TLiqCod, ConTLTipEgr FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 6);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((byte[]) buf[18])[0] = rslt.getByte(16);
               ((byte[]) buf[19])[0] = rslt.getByte(17);
               ((byte[]) buf[20])[0] = rslt.getByte(18);
               ((byte[]) buf[21])[0] = rslt.getByte(19);
               ((byte[]) buf[22])[0] = rslt.getByte(20);
               ((byte[]) buf[23])[0] = rslt.getByte(21);
               ((byte[]) buf[24])[0] = rslt.getByte(22);
               ((byte[]) buf[25])[0] = rslt.getByte(23);
               ((String[]) buf[26])[0] = rslt.getVarchar(24);
               ((byte[]) buf[27])[0] = rslt.getByte(25);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((boolean[]) buf[29])[0] = rslt.getBoolean(26);
               ((boolean[]) buf[30])[0] = rslt.getBoolean(27);
               ((String[]) buf[31])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(30);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((boolean[]) buf[36])[0] = rslt.getBoolean(31);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((boolean[]) buf[38])[0] = rslt.getBoolean(32);
               ((String[]) buf[39])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[40])[0] = rslt.getBoolean(34);
               ((byte[]) buf[41])[0] = rslt.getByte(35);
               ((int[]) buf[42])[0] = rslt.getInt(36);
               ((long[]) buf[43])[0] = rslt.getLong(37);
               ((boolean[]) buf[44])[0] = rslt.getBoolean(38);
               ((boolean[]) buf[45])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(40);
               ((byte[]) buf[47])[0] = rslt.getByte(41);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(42);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[50])[0] = rslt.getBigDecimal(43,4);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(44, 1);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getLongVarchar(45);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(46);
               ((String[]) buf[56])[0] = rslt.getString(47, 20);
               ((String[]) buf[57])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((String[]) buf[61])[0] = rslt.getLongVarchar(50);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[63])[0] = rslt.getBoolean(52);
               ((short[]) buf[64])[0] = rslt.getShort(53);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((short[]) buf[66])[0] = rslt.getShort(54);
               ((String[]) buf[67])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((boolean[]) buf[69])[0] = rslt.getBoolean(56);
               ((byte[]) buf[70])[0] = rslt.getByte(57);
               ((byte[]) buf[71])[0] = rslt.getByte(58);
               ((byte[]) buf[72])[0] = rslt.getByte(59);
               ((byte[]) buf[73])[0] = rslt.getByte(60);
               ((byte[]) buf[74])[0] = rslt.getByte(61);
               ((byte[]) buf[75])[0] = rslt.getByte(62);
               ((byte[]) buf[76])[0] = rslt.getByte(63);
               ((byte[]) buf[77])[0] = rslt.getByte(64);
               ((byte[]) buf[78])[0] = rslt.getByte(65);
               ((byte[]) buf[79])[0] = rslt.getByte(66);
               ((byte[]) buf[80])[0] = rslt.getByte(67);
               ((byte[]) buf[81])[0] = rslt.getByte(68);
               ((boolean[]) buf[82])[0] = rslt.getBoolean(69);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 6);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((byte[]) buf[14])[0] = rslt.getByte(14);
               ((byte[]) buf[15])[0] = rslt.getByte(15);
               ((byte[]) buf[16])[0] = rslt.getByte(16);
               ((byte[]) buf[17])[0] = rslt.getByte(17);
               ((byte[]) buf[18])[0] = rslt.getByte(18);
               ((byte[]) buf[19])[0] = rslt.getByte(19);
               ((byte[]) buf[20])[0] = rslt.getByte(20);
               ((byte[]) buf[21])[0] = rslt.getByte(21);
               ((byte[]) buf[22])[0] = rslt.getByte(22);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((byte[]) buf[24])[0] = rslt.getByte(24);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((boolean[]) buf[26])[0] = rslt.getBoolean(25);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(26);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[31])[0] = rslt.getBoolean(29);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((boolean[]) buf[33])[0] = rslt.getBoolean(30);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((boolean[]) buf[35])[0] = rslt.getBoolean(31);
               ((String[]) buf[36])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[37])[0] = rslt.getBoolean(33);
               ((byte[]) buf[38])[0] = rslt.getByte(34);
               ((int[]) buf[39])[0] = rslt.getInt(35);
               ((long[]) buf[40])[0] = rslt.getLong(36);
               ((boolean[]) buf[41])[0] = rslt.getBoolean(37);
               ((boolean[]) buf[42])[0] = rslt.getBoolean(38);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(39);
               ((byte[]) buf[44])[0] = rslt.getByte(40);
               ((String[]) buf[45])[0] = rslt.getLongVarchar(41);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[47])[0] = rslt.getBigDecimal(42,4);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((String[]) buf[49])[0] = rslt.getString(43, 1);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getLongVarchar(44);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(45);
               ((String[]) buf[53])[0] = rslt.getString(46, 20);
               ((String[]) buf[54])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getLongVarchar(49);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(50);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(51);
               ((short[]) buf[61])[0] = rslt.getShort(52);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((short[]) buf[63])[0] = rslt.getShort(53);
               ((String[]) buf[64])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((boolean[]) buf[66])[0] = rslt.getBoolean(55);
               ((String[]) buf[67])[0] = rslt.getString(56, 20);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((short[]) buf[69])[0] = rslt.getShort(57);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((byte[]) buf[71])[0] = rslt.getByte(58);
               ((byte[]) buf[72])[0] = rslt.getByte(59);
               ((byte[]) buf[73])[0] = rslt.getByte(60);
               ((byte[]) buf[74])[0] = rslt.getByte(61);
               ((byte[]) buf[75])[0] = rslt.getByte(62);
               ((byte[]) buf[76])[0] = rslt.getByte(63);
               ((byte[]) buf[77])[0] = rslt.getByte(64);
               ((byte[]) buf[78])[0] = rslt.getByte(65);
               ((byte[]) buf[79])[0] = rslt.getByte(66);
               ((byte[]) buf[80])[0] = rslt.getByte(67);
               ((byte[]) buf[81])[0] = rslt.getByte(68);
               ((boolean[]) buf[82])[0] = rslt.getBoolean(69);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[5]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[5]).intValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

