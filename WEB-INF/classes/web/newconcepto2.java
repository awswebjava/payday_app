package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconcepto2 extends GXProcedure
{
   public newconcepto2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconcepto2.class ), "" );
   }

   public newconcepto2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        boolean aP4 ,
                        byte aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        int aP17 ,
                        boolean aP18 ,
                        short aP19 ,
                        boolean aP20 ,
                        boolean aP21 ,
                        boolean aP22 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             boolean aP4 ,
                             byte aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             int aP17 ,
                             boolean aP18 ,
                             short aP19 ,
                             boolean aP20 ,
                             boolean aP21 ,
                             boolean aP22 )
   {
      newconcepto2.this.AV28CliCod = aP0;
      newconcepto2.this.AV22ConCodigo = aP1;
      newconcepto2.this.AV8ConDescrip = aP2;
      newconcepto2.this.AV9ConTipo = aP3;
      newconcepto2.this.AV10ConValUni = aP4;
      newconcepto2.this.AV11ConVigencia = aP5;
      newconcepto2.this.AV12ConImporte = aP6;
      newconcepto2.this.AV13ConFormula = aP7;
      newconcepto2.this.AV14ConValorGen = aP8;
      newconcepto2.this.AV15ConObservacion = aP9;
      newconcepto2.this.AV16ConVariable = aP10;
      newconcepto2.this.AV17ConForExportar = aP11;
      newconcepto2.this.AV18TipoConCod = aP12;
      newconcepto2.this.AV19SubTipoConCod1 = aP13;
      newconcepto2.this.AV20SubTipoConCod2 = aP14;
      newconcepto2.this.AV21ConCodOld = aP15;
      newconcepto2.this.AV23ConCodYDesc = aP16;
      newconcepto2.this.AV24ConOrden = aP17;
      newconcepto2.this.AV25ConForEditable = aP18;
      newconcepto2.this.AV32AplIIGG = aP19;
      newconcepto2.this.AV27ConCanti = aP20;
      newconcepto2.this.AV29ConRecalcular = aP21;
      newconcepto2.this.AV30exclusivoMensualEs = aP22;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV28CliCod, 6, 0))+httpContext.getMessage( " cod ", "")+AV22ConCodigo+httpContext.getMessage( " desc ", "")+AV8ConDescrip+httpContext.getMessage( " &ConVariable ", "")+GXutil.trim( GXutil.booltostr( AV16ConVariable))) ;
      /*
         INSERT RECORD ON TABLE Concepto

      */
      A3CliCod = AV28CliCod ;
      A41ConDescrip = AV8ConDescrip ;
      GXt_char1 = A2185ConDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( AV8ConDescrip, GXv_char2) ;
      newconcepto2.this.GXt_char1 = GXv_char2[0] ;
      A2185ConDescripSinAc = GXt_char1 ;
      A150ConHabilitado = true ;
      if ( ! (0==AV9ConTipo) )
      {
         A154ConTipo = AV9ConTipo ;
      }
      A953ConCondicion = "" ;
      n953ConCondicion = false ;
      n953ConCondicion = true ;
      A143ConCanti = AV27ConCanti ;
      A158ConValUni = AV10ConValUni ;
      A152ConImporte = AV12ConImporte ;
      A162ConVigencia = AV11ConVigencia ;
      A148ConFormula = AV13ConFormula ;
      n148ConFormula = false ;
      A157ConValorGen = AV14ConValorGen ;
      n157ConValorGen = false ;
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      n1112AplIIGG = true ;
      A153ConObservacion = AV15ConObservacion ;
      A159ConVariable = AV16ConVariable ;
      A151ConHisFormula = "" ;
      n151ConHisFormula = false ;
      A156ConUsuModFor = httpContext.getMessage( "DEFAULT", "") ;
      n156ConUsuModFor = false ;
      A145ConFchModFor = GXutil.serverNow( context, remoteHandle, pr_default) ;
      n145ConFchModFor = false ;
      A37TipoConCod = AV18TipoConCod ;
      if ( ( GXutil.strcmp(AV18TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(AV18TipoConCod, "NRE_ARG") == 0 ) )
      {
         A1539ConSacDeven = (byte)(1) ;
      }
      else
      {
         A1539ConSacDeven = (byte)(0) ;
      }
      if ( ! (GXutil.strcmp("", AV19SubTipoConCod1)==0) )
      {
         A38SubTipoConCod1 = AV19SubTipoConCod1 ;
         n38SubTipoConCod1 = false ;
      }
      else
      {
         A38SubTipoConCod1 = "" ;
         n38SubTipoConCod1 = false ;
         n38SubTipoConCod1 = true ;
      }
      if ( ! (GXutil.strcmp("", AV20SubTipoConCod2)==0) )
      {
         A39SubTipoConCod2 = AV20SubTipoConCod2 ;
         n39SubTipoConCod2 = false ;
      }
      else
      {
         A39SubTipoConCod2 = "" ;
         n39SubTipoConCod2 = false ;
         n39SubTipoConCod2 = true ;
      }
      A469ConCodOld = AV21ConCodOld ;
      A26ConCodigo = AV22ConCodigo ;
      A42ConCodYDesc = AV23ConCodYDesc ;
      n42ConCodYDesc = false ;
      if ( ! (0==AV24ConOrden) )
      {
         A40ConOrden = AV24ConOrden ;
      }
      else
      {
         GXv_int3[0] = AV34auxConOrden ;
         GXv_int4[0] = AV35auxConOrdEjec ;
         new web.defaultordenconcepto(remoteHandle, context).execute( AV28CliCod, AV18TipoConCod, GXv_int3, GXv_int4) ;
         newconcepto2.this.AV34auxConOrden = GXv_int3[0] ;
         newconcepto2.this.AV35auxConOrdEjec = GXv_int4[0] ;
         A510ConOrdEjec = AV35auxConOrdEjec ;
         A40ConOrden = AV34auxConOrden ;
      }
      if ( GXutil.strcmp(AV18TipoConCod, "REM_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(1) ;
      }
      else if ( GXutil.strcmp(AV18TipoConCod, "NRE_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(2) ;
      }
      else if ( GXutil.strcmp(AV18TipoConCod, "DES_ARG") == 0 )
      {
         A895ConTipoOrden = (short)(3) ;
      }
      else
      {
         A895ConTipoOrden = (short)(4) ;
      }
      A762ConRecalcular = AV29ConRecalcular ;
      if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "RETENCION BRUTA - GANANCIAS", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&con rec ", "")+GXutil.trim( GXutil.booltostr( AV29ConRecalcular))) ;
      }
      if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "COMPENSACION GASTOS TELETRABAJO", "")) == 0 )
      {
         A1018ConRangoCant = "[1]" ;
      }
      else
      {
         A1018ConRangoCant = "" ;
      }
      A1644ConceptoPais = (short)(0) ;
      n1644ConceptoPais = false ;
      n1644ConceptoPais = true ;
      A1645ConceptoConveCodigo = "" ;
      n1645ConceptoConveCodigo = false ;
      n1645ConceptoConveCodigo = true ;
      AV33palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A41ConDescrip," ")) ;
      A1769ConCntPa = (byte)(AV33palabras.size()) ;
      A1822CliPadre = 0 ;
      n1822CliPadre = false ;
      n1822CliPadre = true ;
      A921ConPadre = "" ;
      n921ConPadre = false ;
      n921ConPadre = true ;
      A1826ConPueNov = false ;
      A1827ConBaseOSDif = (byte)(2) ;
      A1801ConBaseAnt = (byte)(1) ;
      A1800ConBasePres = (byte)(1) ;
      if ( AV16ConVariable )
      {
         A1621ConBaseFer = (byte)(0) ;
         A1798ConBaseFerProm = (byte)(1) ;
         A1622ConBaseHorExt = (byte)(0) ;
         A1799ConBaseHorExtProm = (byte)(1) ;
         A1620ConBaseLic = (byte)(0) ;
         A1797ConBaseLicProm = (byte)(1) ;
      }
      else
      {
         A1621ConBaseFer = (byte)(0) ;
         A1798ConBaseFerProm = (byte)(0) ;
         A1622ConBaseHorExt = (byte)(0) ;
         A1799ConBaseHorExtProm = (byte)(0) ;
         A1620ConBaseLic = (byte)(0) ;
         A1797ConBaseLicProm = (byte)(0) ;
      }
      A2191ConBaseAus = (byte)(0) ;
      A2192ConBaseAusProm = (byte)(0) ;
      A1974ConOldValues = "" ;
      A2013ConRelRef = "" ;
      /* Using cursor P00XU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Byte.valueOf(A162ConVigencia), Boolean.valueOf(n148ConFormula), A148ConFormula, Boolean.valueOf(n157ConValorGen), A157ConValorGen, A153ConObservacion, Boolean.valueOf(A159ConVariable), Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Byte.valueOf(A154ConTipo), A469ConCodOld, Long.valueOf(A510ConOrdEjec), Boolean.valueOf(A762ConRecalcular), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(n953ConCondicion), A953ConCondicion, A1018ConRangoCant, Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1622ConBaseHorExt), Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Byte.valueOf(A1769ConCntPa), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre, Byte.valueOf(A1827ConBaseOSDif), Boolean.valueOf(A1826ConPueNov), A1974ConOldValues, A2013ConRelRef, Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A2185ConDescripSinAc});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         new web.msgdebug3(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "duplicate", "")) ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      new web.newconctipoliq(remoteHandle, context).execute( AV28CliCod, AV22ConCodigo, AV19SubTipoConCod1, AV30exclusivoMensualEs) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV28CliCod, AV22ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconcepto2");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV38Pgmname = "" ;
      A41ConDescrip = "" ;
      A2185ConDescripSinAc = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A953ConCondicion = "" ;
      A148ConFormula = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A153ConObservacion = "" ;
      A151ConHisFormula = "" ;
      A156ConUsuModFor = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A469ConCodOld = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      GXv_int3 = new int[1] ;
      GXv_int4 = new long[1] ;
      A1018ConRangoCant = "" ;
      A1645ConceptoConveCodigo = "" ;
      AV33palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      A921ConPadre = "" ;
      A1974ConOldValues = "" ;
      A2013ConRelRef = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconcepto2__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV38Pgmname = "newConcepto2" ;
      /* GeneXus formulas. */
      AV38Pgmname = "newConcepto2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9ConTipo ;
   private byte AV11ConVigencia ;
   private byte A154ConTipo ;
   private byte A162ConVigencia ;
   private byte A1539ConSacDeven ;
   private byte A1769ConCntPa ;
   private byte A1827ConBaseOSDif ;
   private byte A1801ConBaseAnt ;
   private byte A1800ConBasePres ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A2191ConBaseAus ;
   private byte A2192ConBaseAusProm ;
   private short AV32AplIIGG ;
   private short A1112AplIIGG ;
   private short A895ConTipoOrden ;
   private short A1644ConceptoPais ;
   private short Gx_err ;
   private int AV28CliCod ;
   private int AV24ConOrden ;
   private int GX_INS7 ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private int AV34auxConOrden ;
   private int GXv_int3[] ;
   private int A1822CliPadre ;
   private long AV35auxConOrdEjec ;
   private long GXv_int4[] ;
   private long A510ConOrdEjec ;
   private java.math.BigDecimal AV14ConValorGen ;
   private java.math.BigDecimal A157ConValorGen ;
   private String AV22ConCodigo ;
   private String AV18TipoConCod ;
   private String AV19SubTipoConCod1 ;
   private String AV20SubTipoConCod2 ;
   private String AV21ConCodOld ;
   private String AV38Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A953ConCondicion ;
   private String A156ConUsuModFor ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A469ConCodOld ;
   private String A26ConCodigo ;
   private String A1645ConceptoConveCodigo ;
   private String A921ConPadre ;
   private String Gx_emsg ;
   private java.util.Date A145ConFchModFor ;
   private boolean AV10ConValUni ;
   private boolean AV12ConImporte ;
   private boolean AV16ConVariable ;
   private boolean AV17ConForExportar ;
   private boolean AV25ConForEditable ;
   private boolean AV27ConCanti ;
   private boolean AV29ConRecalcular ;
   private boolean AV30exclusivoMensualEs ;
   private boolean A150ConHabilitado ;
   private boolean n953ConCondicion ;
   private boolean A143ConCanti ;
   private boolean A158ConValUni ;
   private boolean A152ConImporte ;
   private boolean n148ConFormula ;
   private boolean n157ConValorGen ;
   private boolean n1112AplIIGG ;
   private boolean A159ConVariable ;
   private boolean n151ConHisFormula ;
   private boolean n156ConUsuModFor ;
   private boolean n145ConFchModFor ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n42ConCodYDesc ;
   private boolean A762ConRecalcular ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1822CliPadre ;
   private boolean n921ConPadre ;
   private boolean A1826ConPueNov ;
   private String AV13ConFormula ;
   private String AV15ConObservacion ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A151ConHisFormula ;
   private String A1974ConOldValues ;
   private String AV8ConDescrip ;
   private String AV23ConCodYDesc ;
   private String A41ConDescrip ;
   private String A2185ConDescripSinAc ;
   private String A42ConCodYDesc ;
   private String A1018ConRangoCant ;
   private String A2013ConRelRef ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV33palabras ;
}

final  class newconcepto2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00XU2", "SAVEPOINT gxupdate;INSERT INTO Concepto(CliCod, ConCodigo, ConDescrip, ConHabilitado, ConOrden, ConCanti, ConValUni, ConImporte, ConVigencia, ConFormula, ConValorGen, ConObservacion, ConVariable, ConHisFormula, ConUsuModFor, ConFchModFor, ConCodYDesc, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConTipo, ConCodOld, ConOrdEjec, ConRecalcular, ConTipoOrden, ConCondicion, ConRangoCant, AplIIGG, ConSacDeven, ConBaseLic, ConBaseFer, ConBaseHorExt, ConceptoPais, ConceptoConveCodigo, ConCntPa, ConBaseLicProm, ConBaseFerProm, ConBaseHorExtProm, ConBasePres, ConBaseAnt, CliPadre, ConPadre, ConBaseOSDif, ConPueNov, ConOldValues, ConRelRef, ConBaseAus, ConBaseAusProm, ConDescripSinAc, ConTipoLiqGanancias, ConForEditable, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConFormulaExpl, ConFormulaObs2, ConFormulaPreResuelta, ConRetGanPropor, ConAplicGan, ConImportado, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConConveAux, ConClasifAux, ConEdiEnRec, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConLiqBasica, ConCodAfip, ConErrorSiCero, ConRelSec, ConRelSecCli, ConOblPalabra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', FALSE, '', '', '', '', '', '', FALSE, 0, FALSE, FALSE, FALSE, FALSE, '', '', '', FALSE, '', FALSE, 0, FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', FALSE, 0, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[10]);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[12], 4);
               }
               stmt.setNLongVarchar(12, (String)parms[13], false);
               stmt.setBoolean(13, ((Boolean) parms[14]).booleanValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(14, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[18], 20);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(16, (java.util.Date)parms[20], false);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(17, (String)parms[22], 400);
               }
               stmt.setString(18, (String)parms[23], 20);
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(19, (String)parms[25], 20);
               }
               if ( ((Boolean) parms[26]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[27], 20);
               }
               stmt.setByte(21, ((Number) parms[28]).byteValue());
               stmt.setString(22, (String)parms[29], 10);
               stmt.setLong(23, ((Number) parms[30]).longValue());
               stmt.setBoolean(24, ((Boolean) parms[31]).booleanValue());
               stmt.setShort(25, ((Number) parms[32]).shortValue());
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(26, (String)parms[34], 20);
               }
               stmt.setVarchar(27, (String)parms[35], 400, false);
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(28, ((Number) parms[37]).shortValue());
               }
               stmt.setByte(29, ((Number) parms[38]).byteValue());
               stmt.setByte(30, ((Number) parms[39]).byteValue());
               stmt.setByte(31, ((Number) parms[40]).byteValue());
               stmt.setByte(32, ((Number) parms[41]).byteValue());
               if ( ((Boolean) parms[42]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(33, ((Number) parms[43]).shortValue());
               }
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(34, (String)parms[45], 20);
               }
               stmt.setByte(35, ((Number) parms[46]).byteValue());
               stmt.setByte(36, ((Number) parms[47]).byteValue());
               stmt.setByte(37, ((Number) parms[48]).byteValue());
               stmt.setByte(38, ((Number) parms[49]).byteValue());
               stmt.setByte(39, ((Number) parms[50]).byteValue());
               stmt.setByte(40, ((Number) parms[51]).byteValue());
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 41 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(41, ((Number) parms[53]).intValue());
               }
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[55], 10);
               }
               stmt.setByte(43, ((Number) parms[56]).byteValue());
               stmt.setBoolean(44, ((Boolean) parms[57]).booleanValue());
               stmt.setNLongVarchar(45, (String)parms[58], false);
               stmt.setVarchar(46, (String)parms[59], 40, false);
               stmt.setByte(47, ((Number) parms[60]).byteValue());
               stmt.setByte(48, ((Number) parms[61]).byteValue());
               stmt.setVarchar(49, (String)parms[62], 400, false);
               return;
      }
   }

}

