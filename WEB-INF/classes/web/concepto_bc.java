package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class concepto_bc extends GXWebPanel implements IGxSilentTrn
{
   public concepto_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public concepto_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( concepto_bc.class ));
   }

   public concepto_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0A7( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0A7( ) ;
      standaloneModal( ) ;
      addRow0A7( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z26ConCodigo = A26ConCodigo ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0A0( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0A7( ) ;
         }
         else
         {
            checkExtendedTable0A7( ) ;
            if ( AnyError == 0 )
            {
               zm0A7( 61) ;
               zm0A7( 62) ;
               zm0A7( 63) ;
               zm0A7( 64) ;
               zm0A7( 65) ;
               zm0A7( 66) ;
               zm0A7( 67) ;
               zm0A7( 68) ;
            }
            closeExtendedTableCursors0A7( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode7 = Gx_mode ;
         confirm_0A8( ) ;
         if ( AnyError == 0 )
         {
            confirm_0A261( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode7 ;
               IsConfirmed = (short)(1) ;
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode7 ;
      }
   }

   public void confirm_0A261( )
   {
      nGXsfl_261_idx = 0 ;
      while ( nGXsfl_261_idx < bcConcepto.getgxTv_SdtConcepto_Motivosegreso().size() )
      {
         readRow0A261( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound261 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_261 != 0 ) )
         {
            getKey0A261( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound261 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0A261( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0A261( 73) ;
                     }
                     closeExtendedTableCursors0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound261 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0A261( ) ;
                     load0A261( ) ;
                     beforeValidate0A261( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0A261( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_261 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0A261( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0A261( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0A261( 73) ;
                           }
                           closeExtendedTableCursors0A261( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow261( ((web.SdtConcepto_MotivosEgreso)bcConcepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+nGXsfl_261_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0A8( )
   {
      nGXsfl_8_idx = 0 ;
      while ( nGXsfl_8_idx < bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().size() )
      {
         readRow0A8( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound8 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_8 != 0 ) )
         {
            getKey0A8( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound8 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0A8( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0A8( 70) ;
                     }
                     closeExtendedTableCursors0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound8 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0A8( ) ;
                     load0A8( ) ;
                     beforeValidate0A8( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0A8( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_8 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0A8( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0A8( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0A8( 70) ;
                           }
                           closeExtendedTableCursors0A8( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow8( ((web.SdtConcepto_TipoLiquidacion)bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+nGXsfl_8_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e120A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV22WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV22WWPContext = GXv_SdtWWPContext1[0] ;
      AV15IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Insert", GXv_boolean3) ;
         concepto_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Update", GXv_boolean3) ;
         concepto_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto_Delete", GXv_boolean3) ;
         concepto_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV15IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV37Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(15);
         pr_default.close(14);
         pr_default.close(13);
         pr_default.close(12);
         pr_default.close(11);
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(7);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV20TrnContext.fromxml(AV21WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV20TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV37Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV38GXV1 = 1 ;
         while ( AV38GXV1 <= AV20TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV26TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV20TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV38GXV1));
            if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoConCod") == 0 )
            {
               AV23Insert_TipoConCod = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod1") == 0 )
            {
               AV24Insert_SubTipoConCod1 = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod2") == 0 )
            {
               AV25Insert_SubTipoConCod2 = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCondicion") == 0 )
            {
               AV34Insert_ConCondicion = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGG") == 0 )
            {
               AV30Insert_AplIIGG = (short)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoPais") == 0 )
            {
               AV32Insert_ConceptoPais = (short)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoConveCodigo") == 0 )
            {
               AV33Insert_ConceptoConveCodigo = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliPadre") == 0 )
            {
               AV35Insert_CliPadre = (int)(GXutil.lval( AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConPadre") == 0 )
            {
               AV29Insert_ConPadre = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV38GXV1 = (int)(AV38GXV1+1) ;
         }
      }
      GXt_int4 = AV7CliCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
      concepto_bc.this.GXt_int4 = GXv_int5[0] ;
      AV7CliCod = GXt_int4 ;
      GXt_boolean2 = AV14esSistemaConceptosDefault ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean3) ;
      concepto_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14esSistemaConceptosDefault = GXt_boolean2 ;
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
         AV17permiteModificacion = true ;
      }
      else
      {
         GXt_boolean2 = AV17permiteModificacion ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.permitemodificacionformula(remoteHandle, context).execute( AV7CliCod, AV11ConCodigo, GXv_boolean3) ;
         concepto_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV17permiteModificacion = GXt_boolean2 ;
      }
      if ( AV14esSistemaConceptosDefault )
      {
         AV16mostrarEditable = true ;
      }
      else
      {
         AV16mostrarEditable = (boolean)(((GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", ""))!=0))) ;
      }
      GXt_int6 = AV13EmpCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int7) ;
      concepto_bc.this.GXt_int6 = GXv_int7[0] ;
      AV13EmpCod = GXt_int6 ;
      AV27defaultConCodigo = httpContext.getMessage( "CALXXX", "") ;
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
      }
   }

   public void e110A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm0A7( int GX_JID )
   {
      if ( ( GX_JID == 60 ) || ( GX_JID == 0 ) )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z145ConFchModFor = A145ConFchModFor ;
         Z156ConUsuModFor = A156ConUsuModFor ;
         Z143ConCanti = A143ConCanti ;
         Z158ConValUni = A158ConValUni ;
         Z152ConImporte = A152ConImporte ;
         Z159ConVariable = A159ConVariable ;
         Z1905ConRelSecCli = A1905ConRelSecCli ;
         Z41ConDescrip = A41ConDescrip ;
         Z150ConHabilitado = A150ConHabilitado ;
         Z40ConOrden = A40ConOrden ;
         Z162ConVigencia = A162ConVigencia ;
         Z1488ConLiqBasica = A1488ConLiqBasica ;
         Z157ConValorGen = A157ConValorGen ;
         Z155ConTipoLiqGanancias = A155ConTipoLiqGanancias ;
         Z154ConTipo = A154ConTipo ;
         Z469ConCodOld = A469ConCodOld ;
         Z487ConCuenDebe = A487ConCuenDebe ;
         Z488ConCuenHaber = A488ConCuenHaber ;
         Z503ConTipoLiqAux = A503ConTipoLiqAux ;
         Z969ConConveAux = A969ConConveAux ;
         Z970ConClasifAux = A970ConClasifAux ;
         Z510ConOrdEjec = A510ConOrdEjec ;
         Z734ConRetGanPropor = A734ConRetGanPropor ;
         Z735ConAplicGan = A735ConAplicGan ;
         Z762ConRecalcular = A762ConRecalcular ;
         Z894ConImportado = A894ConImportado ;
         Z895ConTipoOrden = A895ConTipoOrden ;
         Z1017ConEdiEnRec = A1017ConEdiEnRec ;
         Z1018ConRangoCant = A1018ConRangoCant ;
         Z922ConUsado = A922ConUsado ;
         Z951ConObliga = A951ConObliga ;
         Z952ConObligaSiSac = A952ConObligaSiSac ;
         Z954ConCondCodigo = A954ConCondCodigo ;
         Z1066ConPreReq = A1066ConPreReq ;
         Z1068ConMostrarPos = A1068ConMostrarPos ;
         Z1077ConAdelDescu = A1077ConAdelDescu ;
         Z1194ConSegunPla = A1194ConSegunPla ;
         Z1471ConNumero = A1471ConNumero ;
         Z1472ConSIPAApo = A1472ConSIPAApo ;
         Z1473ConSIPACont = A1473ConSIPACont ;
         Z1474ConINSSJyPApo = A1474ConINSSJyPApo ;
         Z1475ConINSSJyPCont = A1475ConINSSJyPCont ;
         Z1476ConObraSocApo = A1476ConObraSocApo ;
         Z1477ConObraSocCont = A1477ConObraSocCont ;
         Z1478ConFonSolRedApo = A1478ConFonSolRedApo ;
         Z1479ConFonSolRedCont = A1479ConFonSolRedCont ;
         Z1480ConRenateaApo = A1480ConRenateaApo ;
         Z1481ConRenateaCont = A1481ConRenateaCont ;
         Z1482ConAsigFamCont = A1482ConAsigFamCont ;
         Z1483ConFonNacEmpCont = A1483ConFonNacEmpCont ;
         Z1484ConLeyRieTrabCont = A1484ConLeyRieTrabCont ;
         Z1485ConRegDifApo = A1485ConRegDifApo ;
         Z1486ConRegEspApo = A1486ConRegEspApo ;
         Z1539ConSacDeven = A1539ConSacDeven ;
         Z1620ConBaseLic = A1620ConBaseLic ;
         Z1797ConBaseLicProm = A1797ConBaseLicProm ;
         Z1621ConBaseFer = A1621ConBaseFer ;
         Z1798ConBaseFerProm = A1798ConBaseFerProm ;
         Z1622ConBaseHorExt = A1622ConBaseHorExt ;
         Z1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         Z1800ConBasePres = A1800ConBasePres ;
         Z1801ConBaseAnt = A1801ConBaseAnt ;
         Z1827ConBaseOSDif = A1827ConBaseOSDif ;
         Z2191ConBaseAus = A2191ConBaseAus ;
         Z2192ConBaseAusProm = A2192ConBaseAusProm ;
         Z1648ConCodAfip = A1648ConCodAfip ;
         Z1769ConCntPa = A1769ConCntPa ;
         Z1821ConErrorSiCero = A1821ConErrorSiCero ;
         Z1826ConPueNov = A1826ConPueNov ;
         Z1886ConRelSec = A1886ConRelSec ;
         Z2013ConRelRef = A2013ConRelRef ;
         Z2185ConDescripSinAc = A2185ConDescripSinAc ;
         Z2187ConOblPalabra = A2187ConOblPalabra ;
         Z1822CliPadre = A1822CliPadre ;
         Z1112AplIIGG = A1112AplIIGG ;
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z39SubTipoConCod2 = A39SubTipoConCod2 ;
         Z953ConCondicion = A953ConCondicion ;
         Z1644ConceptoPais = A1644ConceptoPais ;
         Z1645ConceptoConveCodigo = A1645ConceptoConveCodigo ;
         Z921ConPadre = A921ConPadre ;
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 61 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 62 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 63 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 64 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 65 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 66 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 67 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( ( GX_JID == 68 ) || ( GX_JID == 0 ) )
      {
         Z149ConFormulaAbr = A149ConFormulaAbr ;
      }
      if ( GX_JID == -60 )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z26ConCodigo = A26ConCodigo ;
         Z145ConFchModFor = A145ConFchModFor ;
         Z156ConUsuModFor = A156ConUsuModFor ;
         Z143ConCanti = A143ConCanti ;
         Z158ConValUni = A158ConValUni ;
         Z152ConImporte = A152ConImporte ;
         Z159ConVariable = A159ConVariable ;
         Z1905ConRelSecCli = A1905ConRelSecCli ;
         Z1974ConOldValues = A1974ConOldValues ;
         Z41ConDescrip = A41ConDescrip ;
         Z150ConHabilitado = A150ConHabilitado ;
         Z40ConOrden = A40ConOrden ;
         Z162ConVigencia = A162ConVigencia ;
         Z1488ConLiqBasica = A1488ConLiqBasica ;
         Z148ConFormula = A148ConFormula ;
         Z729ConFormulaPreResuelta = A729ConFormulaPreResuelta ;
         Z157ConValorGen = A157ConValorGen ;
         Z155ConTipoLiqGanancias = A155ConTipoLiqGanancias ;
         Z153ConObservacion = A153ConObservacion ;
         Z151ConHisFormula = A151ConHisFormula ;
         Z154ConTipo = A154ConTipo ;
         Z469ConCodOld = A469ConCodOld ;
         Z487ConCuenDebe = A487ConCuenDebe ;
         Z488ConCuenHaber = A488ConCuenHaber ;
         Z503ConTipoLiqAux = A503ConTipoLiqAux ;
         Z969ConConveAux = A969ConConveAux ;
         Z970ConClasifAux = A970ConClasifAux ;
         Z510ConOrdEjec = A510ConOrdEjec ;
         Z569ConFormulaExpl = A569ConFormulaExpl ;
         Z720ConFormulaObs2 = A720ConFormulaObs2 ;
         Z734ConRetGanPropor = A734ConRetGanPropor ;
         Z735ConAplicGan = A735ConAplicGan ;
         Z762ConRecalcular = A762ConRecalcular ;
         Z894ConImportado = A894ConImportado ;
         Z895ConTipoOrden = A895ConTipoOrden ;
         Z1017ConEdiEnRec = A1017ConEdiEnRec ;
         Z1018ConRangoCant = A1018ConRangoCant ;
         Z922ConUsado = A922ConUsado ;
         Z951ConObliga = A951ConObliga ;
         Z952ConObligaSiSac = A952ConObligaSiSac ;
         Z954ConCondCodigo = A954ConCondCodigo ;
         Z1066ConPreReq = A1066ConPreReq ;
         Z1068ConMostrarPos = A1068ConMostrarPos ;
         Z1077ConAdelDescu = A1077ConAdelDescu ;
         Z1194ConSegunPla = A1194ConSegunPla ;
         Z1471ConNumero = A1471ConNumero ;
         Z1472ConSIPAApo = A1472ConSIPAApo ;
         Z1473ConSIPACont = A1473ConSIPACont ;
         Z1474ConINSSJyPApo = A1474ConINSSJyPApo ;
         Z1475ConINSSJyPCont = A1475ConINSSJyPCont ;
         Z1476ConObraSocApo = A1476ConObraSocApo ;
         Z1477ConObraSocCont = A1477ConObraSocCont ;
         Z1478ConFonSolRedApo = A1478ConFonSolRedApo ;
         Z1479ConFonSolRedCont = A1479ConFonSolRedCont ;
         Z1480ConRenateaApo = A1480ConRenateaApo ;
         Z1481ConRenateaCont = A1481ConRenateaCont ;
         Z1482ConAsigFamCont = A1482ConAsigFamCont ;
         Z1483ConFonNacEmpCont = A1483ConFonNacEmpCont ;
         Z1484ConLeyRieTrabCont = A1484ConLeyRieTrabCont ;
         Z1485ConRegDifApo = A1485ConRegDifApo ;
         Z1486ConRegEspApo = A1486ConRegEspApo ;
         Z1539ConSacDeven = A1539ConSacDeven ;
         Z1620ConBaseLic = A1620ConBaseLic ;
         Z1797ConBaseLicProm = A1797ConBaseLicProm ;
         Z1621ConBaseFer = A1621ConBaseFer ;
         Z1798ConBaseFerProm = A1798ConBaseFerProm ;
         Z1622ConBaseHorExt = A1622ConBaseHorExt ;
         Z1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         Z1800ConBasePres = A1800ConBasePres ;
         Z1801ConBaseAnt = A1801ConBaseAnt ;
         Z1827ConBaseOSDif = A1827ConBaseOSDif ;
         Z2191ConBaseAus = A2191ConBaseAus ;
         Z2192ConBaseAusProm = A2192ConBaseAusProm ;
         Z1648ConCodAfip = A1648ConCodAfip ;
         Z1769ConCntPa = A1769ConCntPa ;
         Z1821ConErrorSiCero = A1821ConErrorSiCero ;
         Z1826ConPueNov = A1826ConPueNov ;
         Z1886ConRelSec = A1886ConRelSec ;
         Z2013ConRelRef = A2013ConRelRef ;
         Z2185ConDescripSinAc = A2185ConDescripSinAc ;
         Z2187ConOblPalabra = A2187ConOblPalabra ;
         Z1822CliPadre = A1822CliPadre ;
         Z3CliCod = A3CliCod ;
         Z1112AplIIGG = A1112AplIIGG ;
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z39SubTipoConCod2 = A39SubTipoConCod2 ;
         Z953ConCondicion = A953ConCondicion ;
         Z1644ConceptoPais = A1644ConceptoPais ;
         Z1645ConceptoConveCodigo = A1645ConceptoConveCodigo ;
         Z921ConPadre = A921ConPadre ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         concepto_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      A149ConFormulaAbr = "" ;
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A143ConCanti = true ;
      }
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A158ConValUni = true ;
      }
      if ( ! AV14esSistemaConceptosDefault && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) )
      {
         A152ConImporte = true ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         A1905ConRelSecCli = AV7CliCod ;
      }
      if ( isIns( )  && (false==A150ConHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A150ConHabilitado = true ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A155ConTipoLiqGanancias)==0) && ( Gx_BScreen == 0 ) )
      {
         A155ConTipoLiqGanancias = "N" ;
         n155ConTipoLiqGanancias = false ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV37Pgmname = "Concepto_BC" ;
      }
   }

   public void load0A7( )
   {
      /* Using cursor BC000A18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = BC000A18_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000A18_n42ConCodYDesc[0] ;
         A145ConFchModFor = BC000A18_A145ConFchModFor[0] ;
         n145ConFchModFor = BC000A18_n145ConFchModFor[0] ;
         A156ConUsuModFor = BC000A18_A156ConUsuModFor[0] ;
         n156ConUsuModFor = BC000A18_n156ConUsuModFor[0] ;
         A143ConCanti = BC000A18_A143ConCanti[0] ;
         A158ConValUni = BC000A18_A158ConValUni[0] ;
         A152ConImporte = BC000A18_A152ConImporte[0] ;
         A159ConVariable = BC000A18_A159ConVariable[0] ;
         A1905ConRelSecCli = BC000A18_A1905ConRelSecCli[0] ;
         A1974ConOldValues = BC000A18_A1974ConOldValues[0] ;
         A41ConDescrip = BC000A18_A41ConDescrip[0] ;
         A150ConHabilitado = BC000A18_A150ConHabilitado[0] ;
         A40ConOrden = BC000A18_A40ConOrden[0] ;
         A162ConVigencia = BC000A18_A162ConVigencia[0] ;
         A1488ConLiqBasica = BC000A18_A1488ConLiqBasica[0] ;
         A148ConFormula = BC000A18_A148ConFormula[0] ;
         n148ConFormula = BC000A18_n148ConFormula[0] ;
         A729ConFormulaPreResuelta = BC000A18_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = BC000A18_A157ConValorGen[0] ;
         n157ConValorGen = BC000A18_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = BC000A18_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = BC000A18_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = BC000A18_A153ConObservacion[0] ;
         A151ConHisFormula = BC000A18_A151ConHisFormula[0] ;
         n151ConHisFormula = BC000A18_n151ConHisFormula[0] ;
         A154ConTipo = BC000A18_A154ConTipo[0] ;
         A469ConCodOld = BC000A18_A469ConCodOld[0] ;
         A487ConCuenDebe = BC000A18_A487ConCuenDebe[0] ;
         n487ConCuenDebe = BC000A18_n487ConCuenDebe[0] ;
         A488ConCuenHaber = BC000A18_A488ConCuenHaber[0] ;
         n488ConCuenHaber = BC000A18_n488ConCuenHaber[0] ;
         A503ConTipoLiqAux = BC000A18_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = BC000A18_n503ConTipoLiqAux[0] ;
         A969ConConveAux = BC000A18_A969ConConveAux[0] ;
         n969ConConveAux = BC000A18_n969ConConveAux[0] ;
         A970ConClasifAux = BC000A18_A970ConClasifAux[0] ;
         n970ConClasifAux = BC000A18_n970ConClasifAux[0] ;
         A510ConOrdEjec = BC000A18_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = BC000A18_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = BC000A18_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = BC000A18_A734ConRetGanPropor[0] ;
         A735ConAplicGan = BC000A18_A735ConAplicGan[0] ;
         n735ConAplicGan = BC000A18_n735ConAplicGan[0] ;
         A762ConRecalcular = BC000A18_A762ConRecalcular[0] ;
         A894ConImportado = BC000A18_A894ConImportado[0] ;
         A895ConTipoOrden = BC000A18_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = BC000A18_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = BC000A18_A1018ConRangoCant[0] ;
         A922ConUsado = BC000A18_A922ConUsado[0] ;
         A951ConObliga = BC000A18_A951ConObliga[0] ;
         n951ConObliga = BC000A18_n951ConObliga[0] ;
         A952ConObligaSiSac = BC000A18_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = BC000A18_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = BC000A18_A954ConCondCodigo[0] ;
         A1066ConPreReq = BC000A18_A1066ConPreReq[0] ;
         n1066ConPreReq = BC000A18_n1066ConPreReq[0] ;
         A1068ConMostrarPos = BC000A18_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = BC000A18_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = BC000A18_n1077ConAdelDescu[0] ;
         A1194ConSegunPla = BC000A18_A1194ConSegunPla[0] ;
         A1471ConNumero = BC000A18_A1471ConNumero[0] ;
         A1472ConSIPAApo = BC000A18_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = BC000A18_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = BC000A18_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = BC000A18_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = BC000A18_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = BC000A18_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = BC000A18_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = BC000A18_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = BC000A18_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = BC000A18_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = BC000A18_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = BC000A18_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = BC000A18_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = BC000A18_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = BC000A18_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = BC000A18_A1539ConSacDeven[0] ;
         A1620ConBaseLic = BC000A18_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = BC000A18_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = BC000A18_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = BC000A18_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = BC000A18_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = BC000A18_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = BC000A18_A1800ConBasePres[0] ;
         A1801ConBaseAnt = BC000A18_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = BC000A18_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = BC000A18_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = BC000A18_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = BC000A18_A1648ConCodAfip[0] ;
         A1769ConCntPa = BC000A18_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = BC000A18_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = BC000A18_A1826ConPueNov[0] ;
         A1886ConRelSec = BC000A18_A1886ConRelSec[0] ;
         A2013ConRelRef = BC000A18_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = BC000A18_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = BC000A18_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = BC000A18_n2187ConOblPalabra[0] ;
         A1822CliPadre = BC000A18_A1822CliPadre[0] ;
         n1822CliPadre = BC000A18_n1822CliPadre[0] ;
         A1112AplIIGG = BC000A18_A1112AplIIGG[0] ;
         n1112AplIIGG = BC000A18_n1112AplIIGG[0] ;
         A37TipoConCod = BC000A18_A37TipoConCod[0] ;
         A38SubTipoConCod1 = BC000A18_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = BC000A18_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = BC000A18_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = BC000A18_n39SubTipoConCod2[0] ;
         A953ConCondicion = BC000A18_A953ConCondicion[0] ;
         n953ConCondicion = BC000A18_n953ConCondicion[0] ;
         A1644ConceptoPais = BC000A18_A1644ConceptoPais[0] ;
         n1644ConceptoPais = BC000A18_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = BC000A18_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = BC000A18_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = BC000A18_A921ConPadre[0] ;
         n921ConPadre = BC000A18_n921ConPadre[0] ;
         zm0A7( -60) ;
      }
      pr_default.close(16);
      onLoadActions0A7( ) ;
   }

   public void onLoadActions0A7( )
   {
      AV37Pgmname = "Concepto_BC" ;
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      if ( isUpd( )  )
      {
         GXt_char8 = A1974ConOldValues ;
         GXv_char9[0] = GXt_char8 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char9) ;
         concepto_bc.this.GXt_char8 = GXv_char9[0] ;
         A1974ConOldValues = GXt_char8 ;
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
      {
         A159ConVariable = false ;
      }
   }

   public void checkExtendedTable0A7( )
   {
      nIsDirty_7 = (short)(0) ;
      standaloneModal( ) ;
      AV37Pgmname = "Concepto_BC" ;
      /* Using cursor BC000A19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(17);
      nIsDirty_7 = (short)(1) ;
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      if ( (GXutil.strcmp("", A26ConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( isUpd( )  )
      {
         nIsDirty_7 = (short)(1) ;
         GXt_char8 = A1974ConOldValues ;
         GXv_char9[0] = GXt_char8 ;
         new web.conceptosetold(remoteHandle, context).execute( O1620ConBaseLic, O1797ConBaseLicProm, O1621ConBaseFer, O1798ConBaseFerProm, O1622ConBaseHorExt, O1799ConBaseHorExtProm, O1800ConBasePres, O1801ConBaseAnt, O1827ConBaseOSDif, O2191ConBaseAus, O2192ConBaseAusProm, O41ConDescrip, GXv_char9) ;
         concepto_bc.this.GXt_char8 = GXv_char9[0] ;
         A1974ConOldValues = GXt_char8 ;
      }
      if ( (GXutil.strcmp("", A41ConDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A162ConVigencia == 0 ) || ( A162ConVigencia == 1 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Vigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A155ConTipoLiqGanancias, "B") == 0 ) || ( GXutil.strcmp(A155ConTipoLiqGanancias, "D") == 0 ) || ( GXutil.strcmp(A155ConTipoLiqGanancias, "S") == 0 ) || ( GXutil.strcmp(A155ConTipoLiqGanancias, "N") == 0 ) || (GXutil.strcmp("", A155ConTipoLiqGanancias)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo Concepto para Liquidacion Ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000A20 */
      pr_default.execute(18, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(18);
      /* Using cursor BC000A21 */
      pr_default.execute(19, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(19);
      /* Using cursor BC000A22 */
      pr_default.execute(20, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(20);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ( GXutil.strcmp(A37TipoConCod, "REM_ARG") != 0 ) )
      {
         nIsDirty_7 = (short)(1) ;
         A159ConVariable = false ;
      }
      if ( (GXutil.strcmp("", A37TipoConCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A38SubTipoConCod1)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Clasificación", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A154ConTipo == 0 ) || ( A154ConTipo == 1 ) || ( A154ConTipo == 2 ) || ( A154ConTipo == 3 ) || ( A154ConTipo == 4 ) || ( A154ConTipo == 5 ) || ( A154ConTipo == 6 ) || ( A154ConTipo == 7 ) || ( A154ConTipo == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A735ConAplicGan == 1 ) || ( A735ConAplicGan == 2 ) || ( A735ConAplicGan == 4 ) || ( A735ConAplicGan == 5 ) || ( A735ConAplicGan == 6 ) || ( A735ConAplicGan == 7 ) || ( A735ConAplicGan == 8 ) || ( A735ConAplicGan == 9 ) || (0==A735ConAplicGan) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Sujeto a Ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000A23 */
      pr_default.execute(21, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(21) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(21);
      if ( ! ( ( GXutil.strcmp(A953ConCondicion, "A0") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A8") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B2") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B6") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B7") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B15") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "N01") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B16") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B19") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B22") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B23") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B24") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "VP") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "AI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "R1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "MI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "H1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "LA") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "GU") == 0 ) || (GXutil.strcmp("", A953ConCondicion)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Condición para liquidación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1066ConPreReq, "APO_SIPA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_SIPA_NoSacNiVac") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_INSSJyP") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_OS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_DIF") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "APO_ESP") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_SIPA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_OS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_FNE") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "CON_LRT") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "BRUTA") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "REM") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "NRE") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "REMNOSAC") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "EXENTOS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "LICENCIAS") == 0 ) || ( GXutil.strcmp(A1066ConPreReq, "FIJAS") == 0 ) || (GXutil.strcmp("", A1066ConPreReq)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Prerequisito para cálculo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1077ConAdelDescu == 1 ) || ( A1077ConAdelDescu == 2 ) || (0==A1077ConAdelDescu) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Adelanto/Descuento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000A24 */
      pr_default.execute(22, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(22);
      if ( ! ( ( A1539ConSacDeven == 0 ) || ( A1539ConSacDeven == 1 ) || ( A1539ConSacDeven == 3 ) || ( A1539ConSacDeven == 4 ) || ( A1539ConSacDeven == 6 ) || ( A1539ConSacDeven == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo devengamiento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1620ConBaseLic == 0 ) || ( A1620ConBaseLic == 1 ) || ( A1620ConBaseLic == 2 ) || ( A1620ConBaseLic == 3 ) || ( A1620ConBaseLic == 4 ) || ( A1620ConBaseLic == 5 ) || ( A1620ConBaseLic == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1797ConBaseLicProm == 0 ) || ( A1797ConBaseLicProm == 1 ) || ( A1797ConBaseLicProm == 2 ) || ( A1797ConBaseLicProm == 3 ) || ( A1797ConBaseLicProm == 4 ) || ( A1797ConBaseLicProm == 5 ) || ( A1797ConBaseLicProm == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1621ConBaseFer == 0 ) || ( A1621ConBaseFer == 1 ) || ( A1621ConBaseFer == 2 ) || ( A1621ConBaseFer == 3 ) || ( A1621ConBaseFer == 4 ) || ( A1621ConBaseFer == 5 ) || ( A1621ConBaseFer == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1798ConBaseFerProm == 0 ) || ( A1798ConBaseFerProm == 1 ) || ( A1798ConBaseFerProm == 2 ) || ( A1798ConBaseFerProm == 3 ) || ( A1798ConBaseFerProm == 4 ) || ( A1798ConBaseFerProm == 5 ) || ( A1798ConBaseFerProm == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1622ConBaseHorExt == 0 ) || ( A1622ConBaseHorExt == 1 ) || ( A1622ConBaseHorExt == 2 ) || ( A1622ConBaseHorExt == 3 ) || ( A1622ConBaseHorExt == 4 ) || ( A1622ConBaseHorExt == 5 ) || ( A1622ConBaseHorExt == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1799ConBaseHorExtProm == 0 ) || ( A1799ConBaseHorExtProm == 1 ) || ( A1799ConBaseHorExtProm == 2 ) || ( A1799ConBaseHorExtProm == 3 ) || ( A1799ConBaseHorExtProm == 4 ) || ( A1799ConBaseHorExtProm == 5 ) || ( A1799ConBaseHorExtProm == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1800ConBasePres == 0 ) || ( A1800ConBasePres == 1 ) || ( A1800ConBasePres == 2 ) || ( A1800ConBasePres == 3 ) || ( A1800ConBasePres == 4 ) || ( A1800ConBasePres == 5 ) || ( A1800ConBasePres == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para presentismo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1801ConBaseAnt == 0 ) || ( A1801ConBaseAnt == 1 ) || ( A1801ConBaseAnt == 2 ) || ( A1801ConBaseAnt == 3 ) || ( A1801ConBaseAnt == 4 ) || ( A1801ConBaseAnt == 5 ) || ( A1801ConBaseAnt == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para antiguedad", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1827ConBaseOSDif == 0 ) || ( A1827ConBaseOSDif == 1 ) || ( A1827ConBaseOSDif == 2 ) || ( A1827ConBaseOSDif == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para obra social diferencial", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2191ConBaseAus == 0 ) || ( A2191ConBaseAus == 1 ) || ( A2191ConBaseAus == 2 ) || ( A2191ConBaseAus == 3 ) || ( A2191ConBaseAus == 4 ) || ( A2191ConBaseAus == 5 ) || ( A2191ConBaseAus == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para ausencias/licencias sin goce de sueldo de remuneración fija", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2192ConBaseAusProm == 0 ) || ( A2192ConBaseAusProm == 1 ) || ( A2192ConBaseAusProm == 2 ) || ( A2192ConBaseAusProm == 3 ) || ( A2192ConBaseAusProm == 4 ) || ( A2192ConBaseAusProm == 5 ) || ( A2192ConBaseAusProm == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para ausencias/licencias sin goce de remuneración promedio variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000A25 */
      pr_default.execute(23, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(23);
      /* Using cursor BC000A26 */
      pr_default.execute(24, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre});
      if ( (pr_default.getStatus(24) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (GXutil.strcmp("", A921ConPadre)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto Padre Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONPADRE");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(24);
   }

   public void closeExtendedTableCursors0A7( )
   {
      pr_default.close(17);
      pr_default.close(18);
      pr_default.close(19);
      pr_default.close(20);
      pr_default.close(21);
      pr_default.close(22);
      pr_default.close(23);
      pr_default.close(24);
   }

   public void enableDisable( )
   {
   }

   public void getKey0A7( )
   {
      /* Using cursor BC000A27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000A28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(26) != 101) )
      {
         zm0A7( 60) ;
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = BC000A28_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000A28_n42ConCodYDesc[0] ;
         A26ConCodigo = BC000A28_A26ConCodigo[0] ;
         A145ConFchModFor = BC000A28_A145ConFchModFor[0] ;
         n145ConFchModFor = BC000A28_n145ConFchModFor[0] ;
         A156ConUsuModFor = BC000A28_A156ConUsuModFor[0] ;
         n156ConUsuModFor = BC000A28_n156ConUsuModFor[0] ;
         A143ConCanti = BC000A28_A143ConCanti[0] ;
         A158ConValUni = BC000A28_A158ConValUni[0] ;
         A152ConImporte = BC000A28_A152ConImporte[0] ;
         A159ConVariable = BC000A28_A159ConVariable[0] ;
         A1905ConRelSecCli = BC000A28_A1905ConRelSecCli[0] ;
         A1974ConOldValues = BC000A28_A1974ConOldValues[0] ;
         A41ConDescrip = BC000A28_A41ConDescrip[0] ;
         A150ConHabilitado = BC000A28_A150ConHabilitado[0] ;
         A40ConOrden = BC000A28_A40ConOrden[0] ;
         A162ConVigencia = BC000A28_A162ConVigencia[0] ;
         A1488ConLiqBasica = BC000A28_A1488ConLiqBasica[0] ;
         A148ConFormula = BC000A28_A148ConFormula[0] ;
         n148ConFormula = BC000A28_n148ConFormula[0] ;
         A729ConFormulaPreResuelta = BC000A28_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = BC000A28_A157ConValorGen[0] ;
         n157ConValorGen = BC000A28_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = BC000A28_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = BC000A28_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = BC000A28_A153ConObservacion[0] ;
         A151ConHisFormula = BC000A28_A151ConHisFormula[0] ;
         n151ConHisFormula = BC000A28_n151ConHisFormula[0] ;
         A154ConTipo = BC000A28_A154ConTipo[0] ;
         A469ConCodOld = BC000A28_A469ConCodOld[0] ;
         A487ConCuenDebe = BC000A28_A487ConCuenDebe[0] ;
         n487ConCuenDebe = BC000A28_n487ConCuenDebe[0] ;
         A488ConCuenHaber = BC000A28_A488ConCuenHaber[0] ;
         n488ConCuenHaber = BC000A28_n488ConCuenHaber[0] ;
         A503ConTipoLiqAux = BC000A28_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = BC000A28_n503ConTipoLiqAux[0] ;
         A969ConConveAux = BC000A28_A969ConConveAux[0] ;
         n969ConConveAux = BC000A28_n969ConConveAux[0] ;
         A970ConClasifAux = BC000A28_A970ConClasifAux[0] ;
         n970ConClasifAux = BC000A28_n970ConClasifAux[0] ;
         A510ConOrdEjec = BC000A28_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = BC000A28_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = BC000A28_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = BC000A28_A734ConRetGanPropor[0] ;
         A735ConAplicGan = BC000A28_A735ConAplicGan[0] ;
         n735ConAplicGan = BC000A28_n735ConAplicGan[0] ;
         A762ConRecalcular = BC000A28_A762ConRecalcular[0] ;
         A894ConImportado = BC000A28_A894ConImportado[0] ;
         A895ConTipoOrden = BC000A28_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = BC000A28_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = BC000A28_A1018ConRangoCant[0] ;
         A922ConUsado = BC000A28_A922ConUsado[0] ;
         A951ConObliga = BC000A28_A951ConObliga[0] ;
         n951ConObliga = BC000A28_n951ConObliga[0] ;
         A952ConObligaSiSac = BC000A28_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = BC000A28_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = BC000A28_A954ConCondCodigo[0] ;
         A1066ConPreReq = BC000A28_A1066ConPreReq[0] ;
         n1066ConPreReq = BC000A28_n1066ConPreReq[0] ;
         A1068ConMostrarPos = BC000A28_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = BC000A28_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = BC000A28_n1077ConAdelDescu[0] ;
         A1194ConSegunPla = BC000A28_A1194ConSegunPla[0] ;
         A1471ConNumero = BC000A28_A1471ConNumero[0] ;
         A1472ConSIPAApo = BC000A28_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = BC000A28_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = BC000A28_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = BC000A28_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = BC000A28_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = BC000A28_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = BC000A28_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = BC000A28_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = BC000A28_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = BC000A28_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = BC000A28_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = BC000A28_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = BC000A28_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = BC000A28_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = BC000A28_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = BC000A28_A1539ConSacDeven[0] ;
         A1620ConBaseLic = BC000A28_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = BC000A28_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = BC000A28_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = BC000A28_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = BC000A28_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = BC000A28_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = BC000A28_A1800ConBasePres[0] ;
         A1801ConBaseAnt = BC000A28_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = BC000A28_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = BC000A28_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = BC000A28_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = BC000A28_A1648ConCodAfip[0] ;
         A1769ConCntPa = BC000A28_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = BC000A28_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = BC000A28_A1826ConPueNov[0] ;
         A1886ConRelSec = BC000A28_A1886ConRelSec[0] ;
         A2013ConRelRef = BC000A28_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = BC000A28_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = BC000A28_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = BC000A28_n2187ConOblPalabra[0] ;
         A1822CliPadre = BC000A28_A1822CliPadre[0] ;
         n1822CliPadre = BC000A28_n1822CliPadre[0] ;
         A3CliCod = BC000A28_A3CliCod[0] ;
         A1112AplIIGG = BC000A28_A1112AplIIGG[0] ;
         n1112AplIIGG = BC000A28_n1112AplIIGG[0] ;
         A37TipoConCod = BC000A28_A37TipoConCod[0] ;
         A38SubTipoConCod1 = BC000A28_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = BC000A28_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = BC000A28_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = BC000A28_n39SubTipoConCod2[0] ;
         A953ConCondicion = BC000A28_A953ConCondicion[0] ;
         n953ConCondicion = BC000A28_n953ConCondicion[0] ;
         A1644ConceptoPais = BC000A28_A1644ConceptoPais[0] ;
         n1644ConceptoPais = BC000A28_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = BC000A28_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = BC000A28_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = BC000A28_A921ConPadre[0] ;
         n921ConPadre = BC000A28_n921ConPadre[0] ;
         O41ConDescrip = A41ConDescrip ;
         O2192ConBaseAusProm = A2192ConBaseAusProm ;
         O2191ConBaseAus = A2191ConBaseAus ;
         O1827ConBaseOSDif = A1827ConBaseOSDif ;
         O1801ConBaseAnt = A1801ConBaseAnt ;
         O1800ConBasePres = A1800ConBasePres ;
         O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         O1622ConBaseHorExt = A1622ConBaseHorExt ;
         O1798ConBaseFerProm = A1798ConBaseFerProm ;
         O1621ConBaseFer = A1621ConBaseFer ;
         O1797ConBaseLicProm = A1797ConBaseLicProm ;
         O1620ConBaseLic = A1620ConBaseLic ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0A7( ) ;
         if ( AnyError == 1 )
         {
            RcdFound7 = (short)(0) ;
            initializeNonKey0A7( ) ;
         }
         Gx_mode = sMode7 ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey0A7( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode7 ;
      }
      pr_default.close(26);
   }

   public void getEqualNoModal( )
   {
      getKey0A7( ) ;
      if ( RcdFound7 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0A0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0A7( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000A29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(27) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(27) == 101) || ( GXutil.strcmp(Z42ConCodYDesc, BC000A29_A42ConCodYDesc[0]) != 0 ) || !( GXutil.dateCompare(Z145ConFchModFor, BC000A29_A145ConFchModFor[0]) ) || ( GXutil.strcmp(Z156ConUsuModFor, BC000A29_A156ConUsuModFor[0]) != 0 ) || ( Z143ConCanti != BC000A29_A143ConCanti[0] ) || ( Z158ConValUni != BC000A29_A158ConValUni[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z152ConImporte != BC000A29_A152ConImporte[0] ) || ( Z159ConVariable != BC000A29_A159ConVariable[0] ) || ( Z1905ConRelSecCli != BC000A29_A1905ConRelSecCli[0] ) || ( GXutil.strcmp(Z41ConDescrip, BC000A29_A41ConDescrip[0]) != 0 ) || ( Z150ConHabilitado != BC000A29_A150ConHabilitado[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z40ConOrden != BC000A29_A40ConOrden[0] ) || ( Z162ConVigencia != BC000A29_A162ConVigencia[0] ) || ( Z1488ConLiqBasica != BC000A29_A1488ConLiqBasica[0] ) || ( DecimalUtil.compareTo(Z157ConValorGen, BC000A29_A157ConValorGen[0]) != 0 ) || ( GXutil.strcmp(Z155ConTipoLiqGanancias, BC000A29_A155ConTipoLiqGanancias[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z154ConTipo != BC000A29_A154ConTipo[0] ) || ( GXutil.strcmp(Z469ConCodOld, BC000A29_A469ConCodOld[0]) != 0 ) || ( GXutil.strcmp(Z487ConCuenDebe, BC000A29_A487ConCuenDebe[0]) != 0 ) || ( GXutil.strcmp(Z488ConCuenHaber, BC000A29_A488ConCuenHaber[0]) != 0 ) || ( GXutil.strcmp(Z503ConTipoLiqAux, BC000A29_A503ConTipoLiqAux[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z969ConConveAux, BC000A29_A969ConConveAux[0]) != 0 ) || ( GXutil.strcmp(Z970ConClasifAux, BC000A29_A970ConClasifAux[0]) != 0 ) || ( Z510ConOrdEjec != BC000A29_A510ConOrdEjec[0] ) || ( Z734ConRetGanPropor != BC000A29_A734ConRetGanPropor[0] ) || ( Z735ConAplicGan != BC000A29_A735ConAplicGan[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z762ConRecalcular != BC000A29_A762ConRecalcular[0] ) || ( Z894ConImportado != BC000A29_A894ConImportado[0] ) || ( Z895ConTipoOrden != BC000A29_A895ConTipoOrden[0] ) || ( Z1017ConEdiEnRec != BC000A29_A1017ConEdiEnRec[0] ) || ( GXutil.strcmp(Z1018ConRangoCant, BC000A29_A1018ConRangoCant[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z922ConUsado != BC000A29_A922ConUsado[0] ) || ( Z951ConObliga != BC000A29_A951ConObliga[0] ) || ( Z952ConObligaSiSac != BC000A29_A952ConObligaSiSac[0] ) || ( GXutil.strcmp(Z954ConCondCodigo, BC000A29_A954ConCondCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1066ConPreReq, BC000A29_A1066ConPreReq[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1068ConMostrarPos != BC000A29_A1068ConMostrarPos[0] ) || ( Z1077ConAdelDescu != BC000A29_A1077ConAdelDescu[0] ) || ( Z1194ConSegunPla != BC000A29_A1194ConSegunPla[0] ) || ( Z1471ConNumero != BC000A29_A1471ConNumero[0] ) || ( Z1472ConSIPAApo != BC000A29_A1472ConSIPAApo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1473ConSIPACont != BC000A29_A1473ConSIPACont[0] ) || ( Z1474ConINSSJyPApo != BC000A29_A1474ConINSSJyPApo[0] ) || ( Z1475ConINSSJyPCont != BC000A29_A1475ConINSSJyPCont[0] ) || ( Z1476ConObraSocApo != BC000A29_A1476ConObraSocApo[0] ) || ( Z1477ConObraSocCont != BC000A29_A1477ConObraSocCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1478ConFonSolRedApo != BC000A29_A1478ConFonSolRedApo[0] ) || ( Z1479ConFonSolRedCont != BC000A29_A1479ConFonSolRedCont[0] ) || ( Z1480ConRenateaApo != BC000A29_A1480ConRenateaApo[0] ) || ( Z1481ConRenateaCont != BC000A29_A1481ConRenateaCont[0] ) || ( Z1482ConAsigFamCont != BC000A29_A1482ConAsigFamCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1483ConFonNacEmpCont != BC000A29_A1483ConFonNacEmpCont[0] ) || ( Z1484ConLeyRieTrabCont != BC000A29_A1484ConLeyRieTrabCont[0] ) || ( Z1485ConRegDifApo != BC000A29_A1485ConRegDifApo[0] ) || ( Z1486ConRegEspApo != BC000A29_A1486ConRegEspApo[0] ) || ( Z1539ConSacDeven != BC000A29_A1539ConSacDeven[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1620ConBaseLic != BC000A29_A1620ConBaseLic[0] ) || ( Z1797ConBaseLicProm != BC000A29_A1797ConBaseLicProm[0] ) || ( Z1621ConBaseFer != BC000A29_A1621ConBaseFer[0] ) || ( Z1798ConBaseFerProm != BC000A29_A1798ConBaseFerProm[0] ) || ( Z1622ConBaseHorExt != BC000A29_A1622ConBaseHorExt[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1799ConBaseHorExtProm != BC000A29_A1799ConBaseHorExtProm[0] ) || ( Z1800ConBasePres != BC000A29_A1800ConBasePres[0] ) || ( Z1801ConBaseAnt != BC000A29_A1801ConBaseAnt[0] ) || ( Z1827ConBaseOSDif != BC000A29_A1827ConBaseOSDif[0] ) || ( Z2191ConBaseAus != BC000A29_A2191ConBaseAus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2192ConBaseAusProm != BC000A29_A2192ConBaseAusProm[0] ) || ( GXutil.strcmp(Z1648ConCodAfip, BC000A29_A1648ConCodAfip[0]) != 0 ) || ( Z1769ConCntPa != BC000A29_A1769ConCntPa[0] ) || ( Z1821ConErrorSiCero != BC000A29_A1821ConErrorSiCero[0] ) || ( Z1826ConPueNov != BC000A29_A1826ConPueNov[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1886ConRelSec != BC000A29_A1886ConRelSec[0] ) || ( GXutil.strcmp(Z2013ConRelRef, BC000A29_A2013ConRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2185ConDescripSinAc, BC000A29_A2185ConDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z2187ConOblPalabra, BC000A29_A2187ConOblPalabra[0]) != 0 ) || ( Z1822CliPadre != BC000A29_A1822CliPadre[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1112AplIIGG != BC000A29_A1112AplIIGG[0] ) || ( GXutil.strcmp(Z37TipoConCod, BC000A29_A37TipoConCod[0]) != 0 ) || ( GXutil.strcmp(Z38SubTipoConCod1, BC000A29_A38SubTipoConCod1[0]) != 0 ) || ( GXutil.strcmp(Z39SubTipoConCod2, BC000A29_A39SubTipoConCod2[0]) != 0 ) || ( GXutil.strcmp(Z953ConCondicion, BC000A29_A953ConCondicion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1644ConceptoPais != BC000A29_A1644ConceptoPais[0] ) || ( GXutil.strcmp(Z1645ConceptoConveCodigo, BC000A29_A1645ConceptoConveCodigo[0]) != 0 ) || ( GXutil.strcmp(Z921ConPadre, BC000A29_A921ConPadre[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Concepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A7( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A7( 0) ;
         checkOptimisticConcurrency0A7( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A7( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A7( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A30 */
                  pr_default.execute(28, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A26ConCodigo, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Boolean.valueOf(A159ConVariable), Integer.valueOf(A1905ConRelSecCli), A1974ConOldValues, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A729ConFormulaPreResuelta, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Boolean.valueOf(n155ConTipoLiqGanancias), A155ConTipoLiqGanancias, A153ConObservacion, Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Byte.valueOf(A154ConTipo), A469ConCodOld, Boolean.valueOf(n487ConCuenDebe), A487ConCuenDebe, Boolean.valueOf(n488ConCuenHaber), A488ConCuenHaber, Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n969ConConveAux), A969ConConveAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, A720ConFormulaObs2, Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(n735ConAplicGan), Byte.valueOf(A735ConAplicGan), Boolean.valueOf(A762ConRecalcular), Boolean.valueOf(A894ConImportado), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(A922ConUsado), Boolean.valueOf(n951ConObliga), Boolean.valueOf(A951ConObliga), Boolean.valueOf(n952ConObligaSiSac), Boolean.valueOf(A952ConObligaSiSac), A954ConCondCodigo, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A1648ConCodAfip, Byte.valueOf(A1769ConCntPa), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Integer.valueOf(A1886ConRelSec), A2013ConRelRef, A2185ConDescripSinAc, Boolean.valueOf(n2187ConOblPalabra), A2187ConOblPalabra, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(28) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0A7( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0A7( ) ;
         }
         endLevel0A7( ) ;
      }
      closeExtendedTableCursors0A7( ) ;
   }

   public void update0A7( )
   {
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A7( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A7( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A7( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A31 */
                  pr_default.execute(29, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, Boolean.valueOf(n145ConFchModFor), A145ConFchModFor, Boolean.valueOf(n156ConUsuModFor), A156ConUsuModFor, Boolean.valueOf(A143ConCanti), Boolean.valueOf(A158ConValUni), Boolean.valueOf(A152ConImporte), Boolean.valueOf(A159ConVariable), Integer.valueOf(A1905ConRelSecCli), A1974ConOldValues, A41ConDescrip, Boolean.valueOf(A150ConHabilitado), Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A729ConFormulaPreResuelta, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Boolean.valueOf(n155ConTipoLiqGanancias), A155ConTipoLiqGanancias, A153ConObservacion, Boolean.valueOf(n151ConHisFormula), A151ConHisFormula, Byte.valueOf(A154ConTipo), A469ConCodOld, Boolean.valueOf(n487ConCuenDebe), A487ConCuenDebe, Boolean.valueOf(n488ConCuenHaber), A488ConCuenHaber, Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n969ConConveAux), A969ConConveAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, A720ConFormulaObs2, Boolean.valueOf(A734ConRetGanPropor), Boolean.valueOf(n735ConAplicGan), Byte.valueOf(A735ConAplicGan), Boolean.valueOf(A762ConRecalcular), Boolean.valueOf(A894ConImportado), Short.valueOf(A895ConTipoOrden), Boolean.valueOf(A1017ConEdiEnRec), A1018ConRangoCant, Boolean.valueOf(A922ConUsado), Boolean.valueOf(n951ConObliga), Boolean.valueOf(A951ConObliga), Boolean.valueOf(n952ConObligaSiSac), Boolean.valueOf(A952ConObligaSiSac), A954ConCondCodigo, Boolean.valueOf(n1066ConPreReq), A1066ConPreReq, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Byte.valueOf(A2191ConBaseAus), Byte.valueOf(A2192ConBaseAusProm), A1648ConCodAfip, Byte.valueOf(A1769ConCntPa), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Integer.valueOf(A1886ConRelSec), A2013ConRelRef, A2185ConDescripSinAc, Boolean.valueOf(n2187ConOblPalabra), A2187ConOblPalabra, Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre, Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(29) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A7( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0A7( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0A7( ) ;
      }
      closeExtendedTableCursors0A7( ) ;
   }

   public void deferredUpdate0A7( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0A7( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A7( ) ;
         afterConfirm0A7( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A7( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0A261( ) ;
               while ( RcdFound261 != 0 )
               {
                  getByPrimaryKey0A261( ) ;
                  delete0A261( ) ;
                  scanKeyNext0A261( ) ;
               }
               scanKeyEnd0A261( ) ;
               scanKeyStart0A8( ) ;
               while ( RcdFound8 != 0 )
               {
                  getByPrimaryKey0A8( ) ;
                  delete0A8( ) ;
                  scanKeyNext0A8( ) ;
               }
               scanKeyEnd0A8( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A32 */
                  pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0A7( ) ;
      Gx_mode = sMode7 ;
   }

   public void onDeleteControls0A7( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV37Pgmname = "Concepto_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000A33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor BC000A34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos remuneración actual", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor BC000A35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor BC000A36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor BC000A37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo_sueldosConceptos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor BC000A38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "concepto_operandos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor BC000A39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor BC000A40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_horasextras_por Dia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor BC000A41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor BC000A42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor BC000A43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor BC000A44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor BC000A45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Excepciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor BC000A46 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obligacion Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor BC000A47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obl Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor BC000A48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor BC000A49 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGOtros Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor BC000A50 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGCon Exen Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor BC000A51 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Tipo Apl IIGGConc Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor BC000A52 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "condicion_exencion_iigg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor BC000A53 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "siradig_codigos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor BC000A54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor BC000A55 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_dedducciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor BC000A56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formula Historico", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor BC000A57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
      }
   }

   public void processNestedLevel0A8( )
   {
      nGXsfl_8_idx = 0 ;
      while ( nGXsfl_8_idx < bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().size() )
      {
         readRow0A8( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound8 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_8 != 0 ) )
         {
            standaloneNotModal0A8( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0A8( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0A8( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0A8( ) ;
               }
            }
         }
         KeyVarsToRow8( ((web.SdtConcepto_TipoLiquidacion)bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+nGXsfl_8_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_8_idx = 0 ;
         while ( nGXsfl_8_idx < bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().size() )
         {
            readRow0A8( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound8 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().removeElement(nGXsfl_8_idx);
               nGXsfl_8_idx = (int)(nGXsfl_8_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0A8( ) ;
               VarsToRow8( ((web.SdtConcepto_TipoLiquidacion)bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+nGXsfl_8_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0A8( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_8 = (short)(0) ;
      nIsMod_8 = (short)(0) ;
      Gxremove8 = (byte)(0) ;
   }

   public void processNestedLevel0A261( )
   {
      nGXsfl_261_idx = 0 ;
      while ( nGXsfl_261_idx < bcConcepto.getgxTv_SdtConcepto_Motivosegreso().size() )
      {
         readRow0A261( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound261 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_261 != 0 ) )
         {
            standaloneNotModal0A261( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0A261( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0A261( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0A261( ) ;
               }
            }
         }
         KeyVarsToRow261( ((web.SdtConcepto_MotivosEgreso)bcConcepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+nGXsfl_261_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_261_idx = 0 ;
         while ( nGXsfl_261_idx < bcConcepto.getgxTv_SdtConcepto_Motivosegreso().size() )
         {
            readRow0A261( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound261 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcConcepto.getgxTv_SdtConcepto_Motivosegreso().removeElement(nGXsfl_261_idx);
               nGXsfl_261_idx = (int)(nGXsfl_261_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0A261( ) ;
               VarsToRow261( ((web.SdtConcepto_MotivosEgreso)bcConcepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+nGXsfl_261_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0A261( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_261 = (short)(0) ;
      nIsMod_261 = (short)(0) ;
      Gxremove261 = (byte)(0) ;
   }

   public void processLevel0A7( )
   {
      /* Save parent mode. */
      sMode7 = Gx_mode ;
      processNestedLevel0A8( ) ;
      processNestedLevel0A261( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode7 ;
      /* ' Update level parameters */
   }

   public void endLevel0A7( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(27);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0A7( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0A7( )
   {
      /* Scan By routine */
      /* Using cursor BC000A58 */
      pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = BC000A58_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000A58_n42ConCodYDesc[0] ;
         A26ConCodigo = BC000A58_A26ConCodigo[0] ;
         A145ConFchModFor = BC000A58_A145ConFchModFor[0] ;
         n145ConFchModFor = BC000A58_n145ConFchModFor[0] ;
         A156ConUsuModFor = BC000A58_A156ConUsuModFor[0] ;
         n156ConUsuModFor = BC000A58_n156ConUsuModFor[0] ;
         A143ConCanti = BC000A58_A143ConCanti[0] ;
         A158ConValUni = BC000A58_A158ConValUni[0] ;
         A152ConImporte = BC000A58_A152ConImporte[0] ;
         A159ConVariable = BC000A58_A159ConVariable[0] ;
         A1905ConRelSecCli = BC000A58_A1905ConRelSecCli[0] ;
         A1974ConOldValues = BC000A58_A1974ConOldValues[0] ;
         A41ConDescrip = BC000A58_A41ConDescrip[0] ;
         A150ConHabilitado = BC000A58_A150ConHabilitado[0] ;
         A40ConOrden = BC000A58_A40ConOrden[0] ;
         A162ConVigencia = BC000A58_A162ConVigencia[0] ;
         A1488ConLiqBasica = BC000A58_A1488ConLiqBasica[0] ;
         A148ConFormula = BC000A58_A148ConFormula[0] ;
         n148ConFormula = BC000A58_n148ConFormula[0] ;
         A729ConFormulaPreResuelta = BC000A58_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = BC000A58_A157ConValorGen[0] ;
         n157ConValorGen = BC000A58_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = BC000A58_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = BC000A58_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = BC000A58_A153ConObservacion[0] ;
         A151ConHisFormula = BC000A58_A151ConHisFormula[0] ;
         n151ConHisFormula = BC000A58_n151ConHisFormula[0] ;
         A154ConTipo = BC000A58_A154ConTipo[0] ;
         A469ConCodOld = BC000A58_A469ConCodOld[0] ;
         A487ConCuenDebe = BC000A58_A487ConCuenDebe[0] ;
         n487ConCuenDebe = BC000A58_n487ConCuenDebe[0] ;
         A488ConCuenHaber = BC000A58_A488ConCuenHaber[0] ;
         n488ConCuenHaber = BC000A58_n488ConCuenHaber[0] ;
         A503ConTipoLiqAux = BC000A58_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = BC000A58_n503ConTipoLiqAux[0] ;
         A969ConConveAux = BC000A58_A969ConConveAux[0] ;
         n969ConConveAux = BC000A58_n969ConConveAux[0] ;
         A970ConClasifAux = BC000A58_A970ConClasifAux[0] ;
         n970ConClasifAux = BC000A58_n970ConClasifAux[0] ;
         A510ConOrdEjec = BC000A58_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = BC000A58_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = BC000A58_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = BC000A58_A734ConRetGanPropor[0] ;
         A735ConAplicGan = BC000A58_A735ConAplicGan[0] ;
         n735ConAplicGan = BC000A58_n735ConAplicGan[0] ;
         A762ConRecalcular = BC000A58_A762ConRecalcular[0] ;
         A894ConImportado = BC000A58_A894ConImportado[0] ;
         A895ConTipoOrden = BC000A58_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = BC000A58_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = BC000A58_A1018ConRangoCant[0] ;
         A922ConUsado = BC000A58_A922ConUsado[0] ;
         A951ConObliga = BC000A58_A951ConObliga[0] ;
         n951ConObliga = BC000A58_n951ConObliga[0] ;
         A952ConObligaSiSac = BC000A58_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = BC000A58_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = BC000A58_A954ConCondCodigo[0] ;
         A1066ConPreReq = BC000A58_A1066ConPreReq[0] ;
         n1066ConPreReq = BC000A58_n1066ConPreReq[0] ;
         A1068ConMostrarPos = BC000A58_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = BC000A58_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = BC000A58_n1077ConAdelDescu[0] ;
         A1194ConSegunPla = BC000A58_A1194ConSegunPla[0] ;
         A1471ConNumero = BC000A58_A1471ConNumero[0] ;
         A1472ConSIPAApo = BC000A58_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = BC000A58_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = BC000A58_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = BC000A58_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = BC000A58_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = BC000A58_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = BC000A58_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = BC000A58_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = BC000A58_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = BC000A58_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = BC000A58_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = BC000A58_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = BC000A58_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = BC000A58_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = BC000A58_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = BC000A58_A1539ConSacDeven[0] ;
         A1620ConBaseLic = BC000A58_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = BC000A58_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = BC000A58_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = BC000A58_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = BC000A58_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = BC000A58_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = BC000A58_A1800ConBasePres[0] ;
         A1801ConBaseAnt = BC000A58_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = BC000A58_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = BC000A58_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = BC000A58_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = BC000A58_A1648ConCodAfip[0] ;
         A1769ConCntPa = BC000A58_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = BC000A58_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = BC000A58_A1826ConPueNov[0] ;
         A1886ConRelSec = BC000A58_A1886ConRelSec[0] ;
         A2013ConRelRef = BC000A58_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = BC000A58_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = BC000A58_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = BC000A58_n2187ConOblPalabra[0] ;
         A1822CliPadre = BC000A58_A1822CliPadre[0] ;
         n1822CliPadre = BC000A58_n1822CliPadre[0] ;
         A3CliCod = BC000A58_A3CliCod[0] ;
         A1112AplIIGG = BC000A58_A1112AplIIGG[0] ;
         n1112AplIIGG = BC000A58_n1112AplIIGG[0] ;
         A37TipoConCod = BC000A58_A37TipoConCod[0] ;
         A38SubTipoConCod1 = BC000A58_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = BC000A58_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = BC000A58_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = BC000A58_n39SubTipoConCod2[0] ;
         A953ConCondicion = BC000A58_A953ConCondicion[0] ;
         n953ConCondicion = BC000A58_n953ConCondicion[0] ;
         A1644ConceptoPais = BC000A58_A1644ConceptoPais[0] ;
         n1644ConceptoPais = BC000A58_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = BC000A58_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = BC000A58_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = BC000A58_A921ConPadre[0] ;
         n921ConPadre = BC000A58_n921ConPadre[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0A7( )
   {
      /* Scan next routine */
      pr_default.readNext(56);
      RcdFound7 = (short)(0) ;
      scanKeyLoad0A7( ) ;
   }

   public void scanKeyLoad0A7( )
   {
      sMode7 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = BC000A58_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000A58_n42ConCodYDesc[0] ;
         A26ConCodigo = BC000A58_A26ConCodigo[0] ;
         A145ConFchModFor = BC000A58_A145ConFchModFor[0] ;
         n145ConFchModFor = BC000A58_n145ConFchModFor[0] ;
         A156ConUsuModFor = BC000A58_A156ConUsuModFor[0] ;
         n156ConUsuModFor = BC000A58_n156ConUsuModFor[0] ;
         A143ConCanti = BC000A58_A143ConCanti[0] ;
         A158ConValUni = BC000A58_A158ConValUni[0] ;
         A152ConImporte = BC000A58_A152ConImporte[0] ;
         A159ConVariable = BC000A58_A159ConVariable[0] ;
         A1905ConRelSecCli = BC000A58_A1905ConRelSecCli[0] ;
         A1974ConOldValues = BC000A58_A1974ConOldValues[0] ;
         A41ConDescrip = BC000A58_A41ConDescrip[0] ;
         A150ConHabilitado = BC000A58_A150ConHabilitado[0] ;
         A40ConOrden = BC000A58_A40ConOrden[0] ;
         A162ConVigencia = BC000A58_A162ConVigencia[0] ;
         A1488ConLiqBasica = BC000A58_A1488ConLiqBasica[0] ;
         A148ConFormula = BC000A58_A148ConFormula[0] ;
         n148ConFormula = BC000A58_n148ConFormula[0] ;
         A729ConFormulaPreResuelta = BC000A58_A729ConFormulaPreResuelta[0] ;
         A157ConValorGen = BC000A58_A157ConValorGen[0] ;
         n157ConValorGen = BC000A58_n157ConValorGen[0] ;
         A155ConTipoLiqGanancias = BC000A58_A155ConTipoLiqGanancias[0] ;
         n155ConTipoLiqGanancias = BC000A58_n155ConTipoLiqGanancias[0] ;
         A153ConObservacion = BC000A58_A153ConObservacion[0] ;
         A151ConHisFormula = BC000A58_A151ConHisFormula[0] ;
         n151ConHisFormula = BC000A58_n151ConHisFormula[0] ;
         A154ConTipo = BC000A58_A154ConTipo[0] ;
         A469ConCodOld = BC000A58_A469ConCodOld[0] ;
         A487ConCuenDebe = BC000A58_A487ConCuenDebe[0] ;
         n487ConCuenDebe = BC000A58_n487ConCuenDebe[0] ;
         A488ConCuenHaber = BC000A58_A488ConCuenHaber[0] ;
         n488ConCuenHaber = BC000A58_n488ConCuenHaber[0] ;
         A503ConTipoLiqAux = BC000A58_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = BC000A58_n503ConTipoLiqAux[0] ;
         A969ConConveAux = BC000A58_A969ConConveAux[0] ;
         n969ConConveAux = BC000A58_n969ConConveAux[0] ;
         A970ConClasifAux = BC000A58_A970ConClasifAux[0] ;
         n970ConClasifAux = BC000A58_n970ConClasifAux[0] ;
         A510ConOrdEjec = BC000A58_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = BC000A58_A569ConFormulaExpl[0] ;
         A720ConFormulaObs2 = BC000A58_A720ConFormulaObs2[0] ;
         A734ConRetGanPropor = BC000A58_A734ConRetGanPropor[0] ;
         A735ConAplicGan = BC000A58_A735ConAplicGan[0] ;
         n735ConAplicGan = BC000A58_n735ConAplicGan[0] ;
         A762ConRecalcular = BC000A58_A762ConRecalcular[0] ;
         A894ConImportado = BC000A58_A894ConImportado[0] ;
         A895ConTipoOrden = BC000A58_A895ConTipoOrden[0] ;
         A1017ConEdiEnRec = BC000A58_A1017ConEdiEnRec[0] ;
         A1018ConRangoCant = BC000A58_A1018ConRangoCant[0] ;
         A922ConUsado = BC000A58_A922ConUsado[0] ;
         A951ConObliga = BC000A58_A951ConObliga[0] ;
         n951ConObliga = BC000A58_n951ConObliga[0] ;
         A952ConObligaSiSac = BC000A58_A952ConObligaSiSac[0] ;
         n952ConObligaSiSac = BC000A58_n952ConObligaSiSac[0] ;
         A954ConCondCodigo = BC000A58_A954ConCondCodigo[0] ;
         A1066ConPreReq = BC000A58_A1066ConPreReq[0] ;
         n1066ConPreReq = BC000A58_n1066ConPreReq[0] ;
         A1068ConMostrarPos = BC000A58_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = BC000A58_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = BC000A58_n1077ConAdelDescu[0] ;
         A1194ConSegunPla = BC000A58_A1194ConSegunPla[0] ;
         A1471ConNumero = BC000A58_A1471ConNumero[0] ;
         A1472ConSIPAApo = BC000A58_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = BC000A58_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = BC000A58_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = BC000A58_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = BC000A58_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = BC000A58_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = BC000A58_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = BC000A58_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = BC000A58_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = BC000A58_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = BC000A58_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = BC000A58_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = BC000A58_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = BC000A58_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = BC000A58_A1486ConRegEspApo[0] ;
         A1539ConSacDeven = BC000A58_A1539ConSacDeven[0] ;
         A1620ConBaseLic = BC000A58_A1620ConBaseLic[0] ;
         A1797ConBaseLicProm = BC000A58_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = BC000A58_A1621ConBaseFer[0] ;
         A1798ConBaseFerProm = BC000A58_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = BC000A58_A1622ConBaseHorExt[0] ;
         A1799ConBaseHorExtProm = BC000A58_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = BC000A58_A1800ConBasePres[0] ;
         A1801ConBaseAnt = BC000A58_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = BC000A58_A1827ConBaseOSDif[0] ;
         A2191ConBaseAus = BC000A58_A2191ConBaseAus[0] ;
         A2192ConBaseAusProm = BC000A58_A2192ConBaseAusProm[0] ;
         A1648ConCodAfip = BC000A58_A1648ConCodAfip[0] ;
         A1769ConCntPa = BC000A58_A1769ConCntPa[0] ;
         A1821ConErrorSiCero = BC000A58_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = BC000A58_A1826ConPueNov[0] ;
         A1886ConRelSec = BC000A58_A1886ConRelSec[0] ;
         A2013ConRelRef = BC000A58_A2013ConRelRef[0] ;
         A2185ConDescripSinAc = BC000A58_A2185ConDescripSinAc[0] ;
         A2187ConOblPalabra = BC000A58_A2187ConOblPalabra[0] ;
         n2187ConOblPalabra = BC000A58_n2187ConOblPalabra[0] ;
         A1822CliPadre = BC000A58_A1822CliPadre[0] ;
         n1822CliPadre = BC000A58_n1822CliPadre[0] ;
         A3CliCod = BC000A58_A3CliCod[0] ;
         A1112AplIIGG = BC000A58_A1112AplIIGG[0] ;
         n1112AplIIGG = BC000A58_n1112AplIIGG[0] ;
         A37TipoConCod = BC000A58_A37TipoConCod[0] ;
         A38SubTipoConCod1 = BC000A58_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = BC000A58_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = BC000A58_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = BC000A58_n39SubTipoConCod2[0] ;
         A953ConCondicion = BC000A58_A953ConCondicion[0] ;
         n953ConCondicion = BC000A58_n953ConCondicion[0] ;
         A1644ConceptoPais = BC000A58_A1644ConceptoPais[0] ;
         n1644ConceptoPais = BC000A58_n1644ConceptoPais[0] ;
         A1645ConceptoConveCodigo = BC000A58_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = BC000A58_n1645ConceptoConveCodigo[0] ;
         A921ConPadre = BC000A58_A921ConPadre[0] ;
         n921ConPadre = BC000A58_n921ConPadre[0] ;
      }
      Gx_mode = sMode7 ;
   }

   public void scanKeyEnd0A7( )
   {
      pr_default.close(56);
   }

   public void afterConfirm0A7( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A7( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A7( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A7( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A7( )
   {
      /* Before Complete Rules */
      GXt_char8 = A156ConUsuModFor ;
      GXv_char9[0] = GXt_char8 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char9) ;
      concepto_bc.this.GXt_char8 = GXv_char9[0] ;
      A156ConUsuModFor = GXt_char8 ;
      n156ConUsuModFor = false ;
      GXt_dtime10 = A145ConFchModFor ;
      GXv_dtime11[0] = GXt_dtime10 ;
      new web.getahora(remoteHandle, context).execute( AV7CliCod, GXv_dtime11) ;
      concepto_bc.this.GXt_dtime10 = GXv_dtime11[0] ;
      A145ConFchModFor = GXutil.resetMillis(GXt_dtime10) ;
      n145ConFchModFor = false ;
   }

   public void beforeValidate0A7( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A7( )
   {
   }

   public void zm0A8( int GX_JID )
   {
      if ( ( GX_JID == 69 ) || ( GX_JID == 0 ) )
      {
         Z925ConTLiqSinCausa = A925ConTLiqSinCausa ;
         Z926ConTLiqSinPre = A926ConTLiqSinPre ;
         Z950ConTLTipEgr = A950ConTLTipEgr ;
         Z1406ConTLOrdejec = A1406ConTLOrdejec ;
         Z1407ConTLConOrd = A1407ConTLConOrd ;
         Z1409ConTLVigencia = A1409ConTLVigencia ;
         Z1410ConTLCondicion = A1410ConTLCondicion ;
         Z1470ConTLConHab = A1470ConTLConHab ;
         Z1788ConTLTipoCon = A1788ConTLTipoCon ;
         Z1789CONTLSegPla = A1789CONTLSegPla ;
      }
      if ( ( GX_JID == 70 ) || ( GX_JID == 0 ) )
      {
         Z340TliqDesc = A340TliqDesc ;
      }
      if ( GX_JID == -69 )
      {
         Z26ConCodigo = A26ConCodigo ;
         Z925ConTLiqSinCausa = A925ConTLiqSinCausa ;
         Z926ConTLiqSinPre = A926ConTLiqSinPre ;
         Z950ConTLTipEgr = A950ConTLTipEgr ;
         Z1406ConTLOrdejec = A1406ConTLOrdejec ;
         Z1407ConTLConOrd = A1407ConTLConOrd ;
         Z1409ConTLVigencia = A1409ConTLVigencia ;
         Z1410ConTLCondicion = A1410ConTLCondicion ;
         Z1470ConTLConHab = A1470ConTLConHab ;
         Z1788ConTLTipoCon = A1788ConTLTipoCon ;
         Z1789CONTLSegPla = A1789CONTLSegPla ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z340TliqDesc = A340TliqDesc ;
      }
   }

   public void standaloneNotModal0A8( )
   {
   }

   public void standaloneModal0A8( )
   {
   }

   public void load0A8( )
   {
      /* Using cursor BC000A59 */
      pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(57) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A340TliqDesc = BC000A59_A340TliqDesc[0] ;
         A925ConTLiqSinCausa = BC000A59_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = BC000A59_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = BC000A59_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = BC000A59_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = BC000A59_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = BC000A59_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = BC000A59_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = BC000A59_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = BC000A59_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = BC000A59_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = BC000A59_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = BC000A59_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = BC000A59_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = BC000A59_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = BC000A59_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = BC000A59_n1789CONTLSegPla[0] ;
         zm0A8( -69) ;
      }
      pr_default.close(57);
      onLoadActions0A8( ) ;
   }

   public void onLoadActions0A8( )
   {
   }

   public void checkExtendedTable0A8( )
   {
      nIsDirty_8 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0A8( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000A60 */
      pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
      if ( (pr_default.getStatus(58) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
         AnyError = (short)(1) ;
      }
      A340TliqDesc = BC000A60_A340TliqDesc[0] ;
      pr_default.close(58);
      if ( ! ( ( GXutil.strcmp(A950ConTLTipEgr, "") == 0 ) || ( GXutil.strcmp(A950ConTLTipEgr, "SINCAUSA") == 0 ) || ( GXutil.strcmp(A950ConTLTipEgr, "SINPREAVISO") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Motivo de egreso", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1409ConTLVigencia == 0 ) || ( A1409ConTLVigencia == 1 ) || (0==A1409ConTLVigencia) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con TLVigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1410ConTLCondicion, "A0") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A3") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A4") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A5") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A8") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A9") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A10") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A11") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A12") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A13") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "A14") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B2") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B3") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B4") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B5") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B6") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B7") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B9") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B10") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B11") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B12") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B13") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B14") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B15") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "N01") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B16") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B19") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B20") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B21") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B22") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B23") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "B24") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "VP") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "AI") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "R1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "MI") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "H1") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "LA") == 0 ) || ( GXutil.strcmp(A1410ConTLCondicion, "GU") == 0 ) || (GXutil.strcmp("", A1410ConTLCondicion)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con TLCondicion", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1788ConTLTipoCon, "REM_ARG") == 0 ) || ( GXutil.strcmp(A1788ConTLTipoCon, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A1788ConTLTipoCon, "DES_ARG") == 0 ) || ( GXutil.strcmp(A1788ConTLTipoCon, "CAL_ARG") == 0 ) || (GXutil.strcmp("", A1788ConTLTipoCon)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con TLTipo Con", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1789CONTLSegPla == 0 ) || ( A1789CONTLSegPla == 1 ) || ( A1789CONTLSegPla == 2 ) || ( A1789CONTLSegPla == 3 ) || (0==A1789CONTLSegPla) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "CONTLSeg Pla", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0A8( )
   {
      pr_default.close(58);
   }

   public void enableDisable0A8( )
   {
   }

   public void getKey0A8( )
   {
      /* Using cursor BC000A61 */
      pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(59) != 101) )
      {
         RcdFound8 = (short)(1) ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
      }
      pr_default.close(59);
   }

   public void getByPrimaryKey0A8( )
   {
      /* Using cursor BC000A62 */
      pr_default.execute(60, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      if ( (pr_default.getStatus(60) != 101) )
      {
         zm0A8( 69) ;
         RcdFound8 = (short)(1) ;
         initializeNonKey0A8( ) ;
         A925ConTLiqSinCausa = BC000A62_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = BC000A62_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = BC000A62_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = BC000A62_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = BC000A62_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = BC000A62_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = BC000A62_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = BC000A62_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = BC000A62_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = BC000A62_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = BC000A62_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = BC000A62_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = BC000A62_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = BC000A62_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = BC000A62_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = BC000A62_n1789CONTLSegPla[0] ;
         A32TLiqCod = BC000A62_A32TLiqCod[0] ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z32TLiqCod = A32TLiqCod ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0A8( ) ;
         Gx_mode = sMode8 ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
         initializeNonKey0A8( ) ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0A8( ) ;
         Gx_mode = sMode8 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0A8( ) ;
      }
      pr_default.close(60);
   }

   public void checkOptimisticConcurrency0A8( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000A63 */
         pr_default.execute(61, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         if ( (pr_default.getStatus(61) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(61) == 101) || ( Z925ConTLiqSinCausa != BC000A63_A925ConTLiqSinCausa[0] ) || ( Z926ConTLiqSinPre != BC000A63_A926ConTLiqSinPre[0] ) || ( GXutil.strcmp(Z950ConTLTipEgr, BC000A63_A950ConTLTipEgr[0]) != 0 ) || ( Z1406ConTLOrdejec != BC000A63_A1406ConTLOrdejec[0] ) || ( Z1407ConTLConOrd != BC000A63_A1407ConTLConOrd[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1409ConTLVigencia != BC000A63_A1409ConTLVigencia[0] ) || ( GXutil.strcmp(Z1410ConTLCondicion, BC000A63_A1410ConTLCondicion[0]) != 0 ) || ( Z1470ConTLConHab != BC000A63_A1470ConTLConHab[0] ) || ( GXutil.strcmp(Z1788ConTLTipoCon, BC000A63_A1788ConTLTipoCon[0]) != 0 ) || ( Z1789CONTLSegPla != BC000A63_A1789CONTLSegPla[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoTipoLiquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A8( )
   {
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A8( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A8( 0) ;
         checkOptimisticConcurrency0A8( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A8( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A8( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A64 */
                  pr_default.execute(62, new Object[] {A26ConCodigo, Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(62) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0A8( ) ;
         }
         endLevel0A8( ) ;
      }
      closeExtendedTableCursors0A8( ) ;
   }

   public void update0A8( )
   {
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A8( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A8( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A8( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A8( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A65 */
                  pr_default.execute(63, new Object[] {Boolean.valueOf(n925ConTLiqSinCausa), Boolean.valueOf(A925ConTLiqSinCausa), Boolean.valueOf(n926ConTLiqSinPre), Boolean.valueOf(A926ConTLiqSinPre), A950ConTLTipEgr, Long.valueOf(A1406ConTLOrdejec), Short.valueOf(A1407ConTLConOrd), Boolean.valueOf(n1409ConTLVigencia), Byte.valueOf(A1409ConTLVigencia), Boolean.valueOf(n1410ConTLCondicion), A1410ConTLCondicion, Byte.valueOf(A1470ConTLConHab), Boolean.valueOf(n1788ConTLTipoCon), A1788ConTLTipoCon, Boolean.valueOf(n1789CONTLSegPla), Byte.valueOf(A1789CONTLSegPla), Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
                  if ( (pr_default.getStatus(63) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoTipoLiquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A8( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0A8( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0A8( ) ;
      }
      closeExtendedTableCursors0A8( ) ;
   }

   public void deferredUpdate0A8( )
   {
   }

   public void delete0A8( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0A8( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A8( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A8( ) ;
         afterConfirm0A8( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A8( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000A66 */
               pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode8 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0A8( ) ;
      Gx_mode = sMode8 ;
   }

   public void onDeleteControls0A8( )
   {
      standaloneModal0A8( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000A67 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), A32TLiqCod});
         A340TliqDesc = BC000A67_A340TliqDesc[0] ;
         pr_default.close(65);
      }
   }

   public void endLevel0A8( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(61);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0A8( )
   {
      /* Scan By routine */
      /* Using cursor BC000A68 */
      pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(66) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A340TliqDesc = BC000A68_A340TliqDesc[0] ;
         A925ConTLiqSinCausa = BC000A68_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = BC000A68_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = BC000A68_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = BC000A68_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = BC000A68_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = BC000A68_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = BC000A68_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = BC000A68_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = BC000A68_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = BC000A68_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = BC000A68_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = BC000A68_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = BC000A68_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = BC000A68_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = BC000A68_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = BC000A68_n1789CONTLSegPla[0] ;
         A32TLiqCod = BC000A68_A32TLiqCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0A8( )
   {
      /* Scan next routine */
      pr_default.readNext(66);
      RcdFound8 = (short)(0) ;
      scanKeyLoad0A8( ) ;
   }

   public void scanKeyLoad0A8( )
   {
      sMode8 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(66) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A340TliqDesc = BC000A68_A340TliqDesc[0] ;
         A925ConTLiqSinCausa = BC000A68_A925ConTLiqSinCausa[0] ;
         n925ConTLiqSinCausa = BC000A68_n925ConTLiqSinCausa[0] ;
         A926ConTLiqSinPre = BC000A68_A926ConTLiqSinPre[0] ;
         n926ConTLiqSinPre = BC000A68_n926ConTLiqSinPre[0] ;
         A950ConTLTipEgr = BC000A68_A950ConTLTipEgr[0] ;
         A1406ConTLOrdejec = BC000A68_A1406ConTLOrdejec[0] ;
         A1407ConTLConOrd = BC000A68_A1407ConTLConOrd[0] ;
         A1409ConTLVigencia = BC000A68_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = BC000A68_n1409ConTLVigencia[0] ;
         A1410ConTLCondicion = BC000A68_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = BC000A68_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = BC000A68_A1470ConTLConHab[0] ;
         A1788ConTLTipoCon = BC000A68_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = BC000A68_n1788ConTLTipoCon[0] ;
         A1789CONTLSegPla = BC000A68_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = BC000A68_n1789CONTLSegPla[0] ;
         A32TLiqCod = BC000A68_A32TLiqCod[0] ;
      }
      Gx_mode = sMode8 ;
   }

   public void scanKeyEnd0A8( )
   {
      pr_default.close(66);
   }

   public void afterConfirm0A8( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A8( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A8( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A8( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A8( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A8( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A8( )
   {
   }

   public void send_integrity_lvl_hashes0A8( )
   {
   }

   public void zm0A261( int GX_JID )
   {
      if ( ( GX_JID == 71 ) || ( GX_JID == 0 ) )
      {
         Z1532MegPreaTipo = A1532MegPreaTipo ;
         Z1530ConMegMeses = A1530ConMegMeses ;
         Z1534ConMegDura = A1534ConMegDura ;
         Z1529ConMegPropor = A1529ConMegPropor ;
      }
      if ( ( GX_JID == 73 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -71 )
      {
         Z26ConCodigo = A26ConCodigo ;
         Z2077ConMegSec = A2077ConMegSec ;
         Z1532MegPreaTipo = A1532MegPreaTipo ;
         Z1530ConMegMeses = A1530ConMegMeses ;
         Z1534ConMegDura = A1534ConMegDura ;
         Z1529ConMegPropor = A1529ConMegPropor ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
      }
   }

   public void standaloneNotModal0A261( )
   {
   }

   public void standaloneModal0A261( )
   {
   }

   public void load0A261( )
   {
      /* Using cursor BC000A69 */
      pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(67) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A1532MegPreaTipo = BC000A69_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = BC000A69_A1530ConMegMeses[0] ;
         A1534ConMegDura = BC000A69_A1534ConMegDura[0] ;
         A1529ConMegPropor = BC000A69_A1529ConMegPropor[0] ;
         zm0A261( -71) ;
      }
      pr_default.close(67);
      onLoadActions0A261( ) ;
   }

   public void onLoadActions0A261( )
   {
   }

   public void checkExtendedTable0A261( )
   {
      nIsDirty_261 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0A261( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000A70 */
      pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(68) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(68);
      /* Using cursor BC000A71 */
      pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(69) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Código", "")+","+httpContext.getMessage( "Motivo Egreso", "")+","+httpContext.getMessage( "Preaviso", "")+","+httpContext.getMessage( "Con antiguedad mayor a", "")+","+httpContext.getMessage( "meses o años", "")}), 1, "");
         AnyError = (short)(1) ;
      }
      pr_default.close(69);
      if ( ! ( ( GXutil.strcmp(A1532MegPreaTipo, "CON") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "SIN") == 0 ) || ( GXutil.strcmp(A1532MegPreaTipo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Preaviso", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1534ConMegDura, "años") == 0 ) || ( GXutil.strcmp(A1534ConMegDura, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "meses o años", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0A261( )
   {
      pr_default.close(68);
   }

   public void enableDisable0A261( )
   {
   }

   public void getKey0A261( )
   {
      /* Using cursor BC000A72 */
      pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(70) != 101) )
      {
         RcdFound261 = (short)(1) ;
      }
      else
      {
         RcdFound261 = (short)(0) ;
      }
      pr_default.close(70);
   }

   public void getByPrimaryKey0A261( )
   {
      /* Using cursor BC000A73 */
      pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
      if ( (pr_default.getStatus(71) != 101) )
      {
         zm0A261( 71) ;
         RcdFound261 = (short)(1) ;
         initializeNonKey0A261( ) ;
         A2077ConMegSec = BC000A73_A2077ConMegSec[0] ;
         A1532MegPreaTipo = BC000A73_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = BC000A73_A1530ConMegMeses[0] ;
         A1534ConMegDura = BC000A73_A1534ConMegDura[0] ;
         A1529ConMegPropor = BC000A73_A1529ConMegPropor[0] ;
         A11MegCodigo = BC000A73_A11MegCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z11MegCodigo = A11MegCodigo ;
         Z2077ConMegSec = A2077ConMegSec ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0A261( ) ;
         Gx_mode = sMode261 ;
      }
      else
      {
         RcdFound261 = (short)(0) ;
         initializeNonKey0A261( ) ;
         sMode261 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0A261( ) ;
         Gx_mode = sMode261 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0A261( ) ;
      }
      pr_default.close(71);
   }

   public void checkOptimisticConcurrency0A261( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000A74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
         if ( (pr_default.getStatus(72) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(72) == 101) || ( GXutil.strcmp(Z1532MegPreaTipo, BC000A74_A1532MegPreaTipo[0]) != 0 ) || ( Z1530ConMegMeses != BC000A74_A1530ConMegMeses[0] ) || ( GXutil.strcmp(Z1534ConMegDura, BC000A74_A1534ConMegDura[0]) != 0 ) || ( DecimalUtil.compareTo(Z1529ConMegPropor, BC000A74_A1529ConMegPropor[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoMotivosEgreso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A261( )
   {
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A261( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A261( 0) ;
         checkOptimisticConcurrency0A261( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A261( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A261( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A75 */
                  pr_default.execute(73, new Object[] {A26ConCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                  if ( (pr_default.getStatus(73) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0A261( ) ;
         }
         endLevel0A261( ) ;
      }
      closeExtendedTableCursors0A261( ) ;
   }

   public void update0A261( )
   {
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A261( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A261( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A261( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A261( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A76 */
                  pr_default.execute(74, new Object[] {A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor, Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
                  if ( (pr_default.getStatus(74) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoMotivosEgreso"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A261( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0A261( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0A261( ) ;
      }
      closeExtendedTableCursors0A261( ) ;
   }

   public void deferredUpdate0A261( )
   {
   }

   public void delete0A261( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0A261( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A261( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A261( ) ;
         afterConfirm0A261( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A261( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000A77 */
               pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode261 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0A261( ) ;
      Gx_mode = sMode261 ;
   }

   public void onDeleteControls0A261( )
   {
      standaloneModal0A261( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0A261( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(72);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0A261( )
   {
      /* Scan By routine */
      /* Using cursor BC000A78 */
      pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      RcdFound261 = (short)(0) ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A2077ConMegSec = BC000A78_A2077ConMegSec[0] ;
         A1532MegPreaTipo = BC000A78_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = BC000A78_A1530ConMegMeses[0] ;
         A1534ConMegDura = BC000A78_A1534ConMegDura[0] ;
         A1529ConMegPropor = BC000A78_A1529ConMegPropor[0] ;
         A11MegCodigo = BC000A78_A11MegCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0A261( )
   {
      /* Scan next routine */
      pr_default.readNext(76);
      RcdFound261 = (short)(0) ;
      scanKeyLoad0A261( ) ;
   }

   public void scanKeyLoad0A261( )
   {
      sMode261 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound261 = (short)(1) ;
         A2077ConMegSec = BC000A78_A2077ConMegSec[0] ;
         A1532MegPreaTipo = BC000A78_A1532MegPreaTipo[0] ;
         A1530ConMegMeses = BC000A78_A1530ConMegMeses[0] ;
         A1534ConMegDura = BC000A78_A1534ConMegDura[0] ;
         A1529ConMegPropor = BC000A78_A1529ConMegPropor[0] ;
         A11MegCodigo = BC000A78_A11MegCodigo[0] ;
      }
      Gx_mode = sMode261 ;
   }

   public void scanKeyEnd0A261( )
   {
      pr_default.close(76);
   }

   public void afterConfirm0A261( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A261( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A261( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A261( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A261( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A261( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A261( )
   {
   }

   public void send_integrity_lvl_hashes0A261( )
   {
   }

   public void send_integrity_lvl_hashes0A7( )
   {
   }

   public void addRow0A7( )
   {
      VarsToRow7( bcConcepto) ;
   }

   public void readRow0A7( )
   {
      RowToVars7( bcConcepto, 1) ;
   }

   public void addRow0A8( )
   {
      web.SdtConcepto_TipoLiquidacion obj8;
      obj8 = new web.SdtConcepto_TipoLiquidacion(remoteHandle);
      VarsToRow8( obj8) ;
      bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().add(obj8, 0);
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Mode( "UPD" );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Modified( (short)(0) );
   }

   public void readRow0A8( )
   {
      nGXsfl_8_idx = (int)(nGXsfl_8_idx+1) ;
      RowToVars8( ((web.SdtConcepto_TipoLiquidacion)bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+nGXsfl_8_idx)), 1) ;
   }

   public void addRow0A261( )
   {
      web.SdtConcepto_MotivosEgreso obj261;
      obj261 = new web.SdtConcepto_MotivosEgreso(remoteHandle);
      VarsToRow261( obj261) ;
      bcConcepto.getgxTv_SdtConcepto_Motivosegreso().add(obj261, 0);
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Mode( "UPD" );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Modified( (short)(0) );
   }

   public void readRow0A261( )
   {
      nGXsfl_261_idx = (int)(nGXsfl_261_idx+1) ;
      RowToVars261( ((web.SdtConcepto_MotivosEgreso)bcConcepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+nGXsfl_261_idx)), 1) ;
   }

   public void initializeNonKey0A7( )
   {
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      n145ConFchModFor = false ;
      A156ConUsuModFor = "" ;
      n156ConUsuModFor = false ;
      A143ConCanti = false ;
      A158ConValUni = false ;
      A152ConImporte = false ;
      A159ConVariable = false ;
      A1905ConRelSecCli = 0 ;
      A1974ConOldValues = "" ;
      A149ConFormulaAbr = "" ;
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      A41ConDescrip = "" ;
      A40ConOrden = 0 ;
      A162ConVigencia = (byte)(0) ;
      A1488ConLiqBasica = (byte)(0) ;
      A148ConFormula = "" ;
      n148ConFormula = false ;
      A729ConFormulaPreResuelta = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      n157ConValorGen = false ;
      A153ConObservacion = "" ;
      A151ConHisFormula = "" ;
      n151ConHisFormula = false ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      n38SubTipoConCod1 = false ;
      A39SubTipoConCod2 = "" ;
      n39SubTipoConCod2 = false ;
      A154ConTipo = (byte)(0) ;
      A469ConCodOld = "" ;
      A487ConCuenDebe = "" ;
      n487ConCuenDebe = false ;
      A488ConCuenHaber = "" ;
      n488ConCuenHaber = false ;
      A503ConTipoLiqAux = "" ;
      n503ConTipoLiqAux = false ;
      A969ConConveAux = "" ;
      n969ConConveAux = false ;
      A970ConClasifAux = "" ;
      n970ConClasifAux = false ;
      A510ConOrdEjec = 0 ;
      A569ConFormulaExpl = "" ;
      A720ConFormulaObs2 = "" ;
      A734ConRetGanPropor = false ;
      A735ConAplicGan = (byte)(0) ;
      n735ConAplicGan = false ;
      A762ConRecalcular = false ;
      A894ConImportado = false ;
      A895ConTipoOrden = (short)(0) ;
      A1017ConEdiEnRec = false ;
      A1018ConRangoCant = "" ;
      A922ConUsado = false ;
      A951ConObliga = false ;
      n951ConObliga = false ;
      A952ConObligaSiSac = false ;
      n952ConObligaSiSac = false ;
      A953ConCondicion = "" ;
      n953ConCondicion = false ;
      A954ConCondCodigo = "" ;
      A1066ConPreReq = "" ;
      n1066ConPreReq = false ;
      A1068ConMostrarPos = false ;
      A1077ConAdelDescu = (byte)(0) ;
      n1077ConAdelDescu = false ;
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      A1194ConSegunPla = false ;
      A1471ConNumero = (byte)(0) ;
      A1472ConSIPAApo = (byte)(0) ;
      A1473ConSIPACont = (byte)(0) ;
      A1474ConINSSJyPApo = (byte)(0) ;
      A1475ConINSSJyPCont = (byte)(0) ;
      A1476ConObraSocApo = (byte)(0) ;
      A1477ConObraSocCont = (byte)(0) ;
      A1478ConFonSolRedApo = (byte)(0) ;
      A1479ConFonSolRedCont = (byte)(0) ;
      A1480ConRenateaApo = (byte)(0) ;
      A1481ConRenateaCont = (byte)(0) ;
      A1482ConAsigFamCont = (byte)(0) ;
      A1483ConFonNacEmpCont = (byte)(0) ;
      A1484ConLeyRieTrabCont = (byte)(0) ;
      A1485ConRegDifApo = (byte)(0) ;
      A1486ConRegEspApo = (byte)(0) ;
      A1539ConSacDeven = (byte)(0) ;
      A1620ConBaseLic = (byte)(0) ;
      A1797ConBaseLicProm = (byte)(0) ;
      A1621ConBaseFer = (byte)(0) ;
      A1798ConBaseFerProm = (byte)(0) ;
      A1622ConBaseHorExt = (byte)(0) ;
      A1799ConBaseHorExtProm = (byte)(0) ;
      A1800ConBasePres = (byte)(0) ;
      A1801ConBaseAnt = (byte)(0) ;
      A1827ConBaseOSDif = (byte)(0) ;
      A2191ConBaseAus = (byte)(0) ;
      A2192ConBaseAusProm = (byte)(0) ;
      A1644ConceptoPais = (short)(0) ;
      n1644ConceptoPais = false ;
      A1645ConceptoConveCodigo = "" ;
      n1645ConceptoConveCodigo = false ;
      A1648ConCodAfip = "" ;
      A1769ConCntPa = (byte)(0) ;
      A1821ConErrorSiCero = false ;
      A1822CliPadre = 0 ;
      n1822CliPadre = false ;
      A921ConPadre = "" ;
      n921ConPadre = false ;
      A1826ConPueNov = false ;
      A1886ConRelSec = 0 ;
      A2013ConRelRef = "" ;
      A2185ConDescripSinAc = "" ;
      A2187ConOblPalabra = "" ;
      n2187ConOblPalabra = false ;
      A150ConHabilitado = true ;
      A155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      O41ConDescrip = A41ConDescrip ;
      O2192ConBaseAusProm = A2192ConBaseAusProm ;
      O2191ConBaseAus = A2191ConBaseAus ;
      O1827ConBaseOSDif = A1827ConBaseOSDif ;
      O1801ConBaseAnt = A1801ConBaseAnt ;
      O1800ConBasePres = A1800ConBasePres ;
      O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
      O1622ConBaseHorExt = A1622ConBaseHorExt ;
      O1798ConBaseFerProm = A1798ConBaseFerProm ;
      O1621ConBaseFer = A1621ConBaseFer ;
      O1797ConBaseLicProm = A1797ConBaseLicProm ;
      O1620ConBaseLic = A1620ConBaseLic ;
      Z42ConCodYDesc = "" ;
      Z145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      Z156ConUsuModFor = "" ;
      Z143ConCanti = false ;
      Z158ConValUni = false ;
      Z152ConImporte = false ;
      Z159ConVariable = false ;
      Z1905ConRelSecCli = 0 ;
      Z41ConDescrip = "" ;
      Z150ConHabilitado = false ;
      Z40ConOrden = 0 ;
      Z162ConVigencia = (byte)(0) ;
      Z1488ConLiqBasica = (byte)(0) ;
      Z157ConValorGen = DecimalUtil.ZERO ;
      Z155ConTipoLiqGanancias = "" ;
      Z154ConTipo = (byte)(0) ;
      Z469ConCodOld = "" ;
      Z487ConCuenDebe = "" ;
      Z488ConCuenHaber = "" ;
      Z503ConTipoLiqAux = "" ;
      Z969ConConveAux = "" ;
      Z970ConClasifAux = "" ;
      Z510ConOrdEjec = 0 ;
      Z734ConRetGanPropor = false ;
      Z735ConAplicGan = (byte)(0) ;
      Z762ConRecalcular = false ;
      Z894ConImportado = false ;
      Z895ConTipoOrden = (short)(0) ;
      Z1017ConEdiEnRec = false ;
      Z1018ConRangoCant = "" ;
      Z922ConUsado = false ;
      Z951ConObliga = false ;
      Z952ConObligaSiSac = false ;
      Z954ConCondCodigo = "" ;
      Z1066ConPreReq = "" ;
      Z1068ConMostrarPos = false ;
      Z1077ConAdelDescu = (byte)(0) ;
      Z1194ConSegunPla = false ;
      Z1471ConNumero = (byte)(0) ;
      Z1472ConSIPAApo = (byte)(0) ;
      Z1473ConSIPACont = (byte)(0) ;
      Z1474ConINSSJyPApo = (byte)(0) ;
      Z1475ConINSSJyPCont = (byte)(0) ;
      Z1476ConObraSocApo = (byte)(0) ;
      Z1477ConObraSocCont = (byte)(0) ;
      Z1478ConFonSolRedApo = (byte)(0) ;
      Z1479ConFonSolRedCont = (byte)(0) ;
      Z1480ConRenateaApo = (byte)(0) ;
      Z1481ConRenateaCont = (byte)(0) ;
      Z1482ConAsigFamCont = (byte)(0) ;
      Z1483ConFonNacEmpCont = (byte)(0) ;
      Z1484ConLeyRieTrabCont = (byte)(0) ;
      Z1485ConRegDifApo = (byte)(0) ;
      Z1486ConRegEspApo = (byte)(0) ;
      Z1539ConSacDeven = (byte)(0) ;
      Z1620ConBaseLic = (byte)(0) ;
      Z1797ConBaseLicProm = (byte)(0) ;
      Z1621ConBaseFer = (byte)(0) ;
      Z1798ConBaseFerProm = (byte)(0) ;
      Z1622ConBaseHorExt = (byte)(0) ;
      Z1799ConBaseHorExtProm = (byte)(0) ;
      Z1800ConBasePres = (byte)(0) ;
      Z1801ConBaseAnt = (byte)(0) ;
      Z1827ConBaseOSDif = (byte)(0) ;
      Z2191ConBaseAus = (byte)(0) ;
      Z2192ConBaseAusProm = (byte)(0) ;
      Z1648ConCodAfip = "" ;
      Z1769ConCntPa = (byte)(0) ;
      Z1821ConErrorSiCero = false ;
      Z1826ConPueNov = false ;
      Z1886ConRelSec = 0 ;
      Z2013ConRelRef = "" ;
      Z2185ConDescripSinAc = "" ;
      Z2187ConOblPalabra = "" ;
      Z1822CliPadre = 0 ;
      Z1112AplIIGG = (short)(0) ;
      Z37TipoConCod = "" ;
      Z38SubTipoConCod1 = "" ;
      Z39SubTipoConCod2 = "" ;
      Z953ConCondicion = "" ;
      Z1644ConceptoPais = (short)(0) ;
      Z1645ConceptoConveCodigo = "" ;
      Z921ConPadre = "" ;
   }

   public void initAll0A7( )
   {
      A3CliCod = 0 ;
      A26ConCodigo = "" ;
      initializeNonKey0A7( ) ;
   }

   public void standaloneModalInsert( )
   {
      A149ConFormulaAbr = i149ConFormulaAbr ;
      A1905ConRelSecCli = i1905ConRelSecCli ;
      A150ConHabilitado = i150ConHabilitado ;
      A155ConTipoLiqGanancias = i155ConTipoLiqGanancias ;
      n155ConTipoLiqGanancias = false ;
   }

   public void initializeNonKey0A8( )
   {
      A340TliqDesc = "" ;
      A925ConTLiqSinCausa = false ;
      n925ConTLiqSinCausa = false ;
      A926ConTLiqSinPre = false ;
      n926ConTLiqSinPre = false ;
      A950ConTLTipEgr = "" ;
      A1406ConTLOrdejec = 0 ;
      A1407ConTLConOrd = (short)(0) ;
      A1409ConTLVigencia = (byte)(0) ;
      n1409ConTLVigencia = false ;
      A1410ConTLCondicion = "" ;
      n1410ConTLCondicion = false ;
      A1470ConTLConHab = (byte)(0) ;
      A1788ConTLTipoCon = "" ;
      n1788ConTLTipoCon = false ;
      A1789CONTLSegPla = (byte)(0) ;
      n1789CONTLSegPla = false ;
      Z925ConTLiqSinCausa = false ;
      Z926ConTLiqSinPre = false ;
      Z950ConTLTipEgr = "" ;
      Z1406ConTLOrdejec = 0 ;
      Z1407ConTLConOrd = (short)(0) ;
      Z1409ConTLVigencia = (byte)(0) ;
      Z1410ConTLCondicion = "" ;
      Z1470ConTLConHab = (byte)(0) ;
      Z1788ConTLTipoCon = "" ;
      Z1789CONTLSegPla = (byte)(0) ;
   }

   public void initAll0A8( )
   {
      A32TLiqCod = "" ;
      initializeNonKey0A8( ) ;
   }

   public void standaloneModalInsert0A8( )
   {
   }

   public void initializeNonKey0A261( )
   {
      A1532MegPreaTipo = "" ;
      A1530ConMegMeses = (byte)(0) ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      Z1532MegPreaTipo = "" ;
      Z1530ConMegMeses = (byte)(0) ;
      Z1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
   }

   public void initAll0A261( )
   {
      A11MegCodigo = "" ;
      A2077ConMegSec = (short)(0) ;
      initializeNonKey0A261( ) ;
   }

   public void standaloneModalInsert0A261( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow7( web.SdtConcepto obj7 )
   {
      obj7.setgxTv_SdtConcepto_Mode( Gx_mode );
      obj7.setgxTv_SdtConcepto_Confchmodfor( A145ConFchModFor );
      obj7.setgxTv_SdtConcepto_Conusumodfor( A156ConUsuModFor );
      obj7.setgxTv_SdtConcepto_Concanti( A143ConCanti );
      obj7.setgxTv_SdtConcepto_Convaluni( A158ConValUni );
      obj7.setgxTv_SdtConcepto_Conimporte( A152ConImporte );
      obj7.setgxTv_SdtConcepto_Convariable( A159ConVariable );
      obj7.setgxTv_SdtConcepto_Conrelseccli( A1905ConRelSecCli );
      obj7.setgxTv_SdtConcepto_Conoldvalues( A1974ConOldValues );
      obj7.setgxTv_SdtConcepto_Conformulaabr( A149ConFormulaAbr );
      obj7.setgxTv_SdtConcepto_Concodydesc( A42ConCodYDesc );
      obj7.setgxTv_SdtConcepto_Condescrip( A41ConDescrip );
      obj7.setgxTv_SdtConcepto_Conorden( A40ConOrden );
      obj7.setgxTv_SdtConcepto_Convigencia( A162ConVigencia );
      obj7.setgxTv_SdtConcepto_Conliqbasica( A1488ConLiqBasica );
      obj7.setgxTv_SdtConcepto_Conformula( A148ConFormula );
      obj7.setgxTv_SdtConcepto_Conformulapreresuelta( A729ConFormulaPreResuelta );
      obj7.setgxTv_SdtConcepto_Convalorgen( A157ConValorGen );
      obj7.setgxTv_SdtConcepto_Conobservacion( A153ConObservacion );
      obj7.setgxTv_SdtConcepto_Conhisformula( A151ConHisFormula );
      obj7.setgxTv_SdtConcepto_Tipoconcod( A37TipoConCod );
      obj7.setgxTv_SdtConcepto_Subtipoconcod1( A38SubTipoConCod1 );
      obj7.setgxTv_SdtConcepto_Subtipoconcod2( A39SubTipoConCod2 );
      obj7.setgxTv_SdtConcepto_Contipo( A154ConTipo );
      obj7.setgxTv_SdtConcepto_Concodold( A469ConCodOld );
      obj7.setgxTv_SdtConcepto_Concuendebe( A487ConCuenDebe );
      obj7.setgxTv_SdtConcepto_Concuenhaber( A488ConCuenHaber );
      obj7.setgxTv_SdtConcepto_Contipoliqaux( A503ConTipoLiqAux );
      obj7.setgxTv_SdtConcepto_Conconveaux( A969ConConveAux );
      obj7.setgxTv_SdtConcepto_Conclasifaux( A970ConClasifAux );
      obj7.setgxTv_SdtConcepto_Conordejec( A510ConOrdEjec );
      obj7.setgxTv_SdtConcepto_Conformulaexpl( A569ConFormulaExpl );
      obj7.setgxTv_SdtConcepto_Conformulaobs2( A720ConFormulaObs2 );
      obj7.setgxTv_SdtConcepto_Conretganpropor( A734ConRetGanPropor );
      obj7.setgxTv_SdtConcepto_Conaplicgan( A735ConAplicGan );
      obj7.setgxTv_SdtConcepto_Conrecalcular( A762ConRecalcular );
      obj7.setgxTv_SdtConcepto_Conimportado( A894ConImportado );
      obj7.setgxTv_SdtConcepto_Contipoorden( A895ConTipoOrden );
      obj7.setgxTv_SdtConcepto_Conedienrec( A1017ConEdiEnRec );
      obj7.setgxTv_SdtConcepto_Conrangocant( A1018ConRangoCant );
      obj7.setgxTv_SdtConcepto_Conusado( A922ConUsado );
      obj7.setgxTv_SdtConcepto_Conobliga( A951ConObliga );
      obj7.setgxTv_SdtConcepto_Conobligasisac( A952ConObligaSiSac );
      obj7.setgxTv_SdtConcepto_Concondicion( A953ConCondicion );
      obj7.setgxTv_SdtConcepto_Concondcodigo( A954ConCondCodigo );
      obj7.setgxTv_SdtConcepto_Conprereq( A1066ConPreReq );
      obj7.setgxTv_SdtConcepto_Conmostrarpos( A1068ConMostrarPos );
      obj7.setgxTv_SdtConcepto_Conadeldescu( A1077ConAdelDescu );
      obj7.setgxTv_SdtConcepto_Apliigg( A1112AplIIGG );
      obj7.setgxTv_SdtConcepto_Consegunpla( A1194ConSegunPla );
      obj7.setgxTv_SdtConcepto_Connumero( A1471ConNumero );
      obj7.setgxTv_SdtConcepto_Consipaapo( A1472ConSIPAApo );
      obj7.setgxTv_SdtConcepto_Consipacont( A1473ConSIPACont );
      obj7.setgxTv_SdtConcepto_Coninssjypapo( A1474ConINSSJyPApo );
      obj7.setgxTv_SdtConcepto_Coninssjypcont( A1475ConINSSJyPCont );
      obj7.setgxTv_SdtConcepto_Conobrasocapo( A1476ConObraSocApo );
      obj7.setgxTv_SdtConcepto_Conobrasoccont( A1477ConObraSocCont );
      obj7.setgxTv_SdtConcepto_Confonsolredapo( A1478ConFonSolRedApo );
      obj7.setgxTv_SdtConcepto_Confonsolredcont( A1479ConFonSolRedCont );
      obj7.setgxTv_SdtConcepto_Conrenateaapo( A1480ConRenateaApo );
      obj7.setgxTv_SdtConcepto_Conrenateacont( A1481ConRenateaCont );
      obj7.setgxTv_SdtConcepto_Conasigfamcont( A1482ConAsigFamCont );
      obj7.setgxTv_SdtConcepto_Confonnacempcont( A1483ConFonNacEmpCont );
      obj7.setgxTv_SdtConcepto_Conleyrietrabcont( A1484ConLeyRieTrabCont );
      obj7.setgxTv_SdtConcepto_Conregdifapo( A1485ConRegDifApo );
      obj7.setgxTv_SdtConcepto_Conregespapo( A1486ConRegEspApo );
      obj7.setgxTv_SdtConcepto_Consacdeven( A1539ConSacDeven );
      obj7.setgxTv_SdtConcepto_Conbaselic( A1620ConBaseLic );
      obj7.setgxTv_SdtConcepto_Conbaselicprom( A1797ConBaseLicProm );
      obj7.setgxTv_SdtConcepto_Conbasefer( A1621ConBaseFer );
      obj7.setgxTv_SdtConcepto_Conbaseferprom( A1798ConBaseFerProm );
      obj7.setgxTv_SdtConcepto_Conbasehorext( A1622ConBaseHorExt );
      obj7.setgxTv_SdtConcepto_Conbasehorextprom( A1799ConBaseHorExtProm );
      obj7.setgxTv_SdtConcepto_Conbasepres( A1800ConBasePres );
      obj7.setgxTv_SdtConcepto_Conbaseant( A1801ConBaseAnt );
      obj7.setgxTv_SdtConcepto_Conbaseosdif( A1827ConBaseOSDif );
      obj7.setgxTv_SdtConcepto_Conbaseaus( A2191ConBaseAus );
      obj7.setgxTv_SdtConcepto_Conbaseausprom( A2192ConBaseAusProm );
      obj7.setgxTv_SdtConcepto_Conceptopais( A1644ConceptoPais );
      obj7.setgxTv_SdtConcepto_Conceptoconvecodigo( A1645ConceptoConveCodigo );
      obj7.setgxTv_SdtConcepto_Concodafip( A1648ConCodAfip );
      obj7.setgxTv_SdtConcepto_Concntpa( A1769ConCntPa );
      obj7.setgxTv_SdtConcepto_Conerrorsicero( A1821ConErrorSiCero );
      obj7.setgxTv_SdtConcepto_Clipadre( A1822CliPadre );
      obj7.setgxTv_SdtConcepto_Conpadre( A921ConPadre );
      obj7.setgxTv_SdtConcepto_Conpuenov( A1826ConPueNov );
      obj7.setgxTv_SdtConcepto_Conrelsec( A1886ConRelSec );
      obj7.setgxTv_SdtConcepto_Conrelref( A2013ConRelRef );
      obj7.setgxTv_SdtConcepto_Condescripsinac( A2185ConDescripSinAc );
      obj7.setgxTv_SdtConcepto_Conoblpalabra( A2187ConOblPalabra );
      obj7.setgxTv_SdtConcepto_Conhabilitado( A150ConHabilitado );
      obj7.setgxTv_SdtConcepto_Contipoliqganancias( A155ConTipoLiqGanancias );
      obj7.setgxTv_SdtConcepto_Clicod( A3CliCod );
      obj7.setgxTv_SdtConcepto_Concodigo( A26ConCodigo );
      obj7.setgxTv_SdtConcepto_Clicod_Z( Z3CliCod );
      obj7.setgxTv_SdtConcepto_Concodigo_Z( Z26ConCodigo );
      obj7.setgxTv_SdtConcepto_Condescrip_Z( Z41ConDescrip );
      obj7.setgxTv_SdtConcepto_Conhabilitado_Z( Z150ConHabilitado );
      obj7.setgxTv_SdtConcepto_Conorden_Z( Z40ConOrden );
      obj7.setgxTv_SdtConcepto_Concanti_Z( Z143ConCanti );
      obj7.setgxTv_SdtConcepto_Convaluni_Z( Z158ConValUni );
      obj7.setgxTv_SdtConcepto_Conimporte_Z( Z152ConImporte );
      obj7.setgxTv_SdtConcepto_Convigencia_Z( Z162ConVigencia );
      obj7.setgxTv_SdtConcepto_Conliqbasica_Z( Z1488ConLiqBasica );
      obj7.setgxTv_SdtConcepto_Convalorgen_Z( Z157ConValorGen );
      obj7.setgxTv_SdtConcepto_Contipoliqganancias_Z( Z155ConTipoLiqGanancias );
      obj7.setgxTv_SdtConcepto_Convariable_Z( Z159ConVariable );
      obj7.setgxTv_SdtConcepto_Conusumodfor_Z( Z156ConUsuModFor );
      obj7.setgxTv_SdtConcepto_Confchmodfor_Z( Z145ConFchModFor );
      obj7.setgxTv_SdtConcepto_Conformulaabr_Z( Z149ConFormulaAbr );
      obj7.setgxTv_SdtConcepto_Concodydesc_Z( Z42ConCodYDesc );
      obj7.setgxTv_SdtConcepto_Tipoconcod_Z( Z37TipoConCod );
      obj7.setgxTv_SdtConcepto_Subtipoconcod1_Z( Z38SubTipoConCod1 );
      obj7.setgxTv_SdtConcepto_Subtipoconcod2_Z( Z39SubTipoConCod2 );
      obj7.setgxTv_SdtConcepto_Contipo_Z( Z154ConTipo );
      obj7.setgxTv_SdtConcepto_Concodold_Z( Z469ConCodOld );
      obj7.setgxTv_SdtConcepto_Concuendebe_Z( Z487ConCuenDebe );
      obj7.setgxTv_SdtConcepto_Concuenhaber_Z( Z488ConCuenHaber );
      obj7.setgxTv_SdtConcepto_Contipoliqaux_Z( Z503ConTipoLiqAux );
      obj7.setgxTv_SdtConcepto_Conconveaux_Z( Z969ConConveAux );
      obj7.setgxTv_SdtConcepto_Conclasifaux_Z( Z970ConClasifAux );
      obj7.setgxTv_SdtConcepto_Conordejec_Z( Z510ConOrdEjec );
      obj7.setgxTv_SdtConcepto_Conretganpropor_Z( Z734ConRetGanPropor );
      obj7.setgxTv_SdtConcepto_Conaplicgan_Z( Z735ConAplicGan );
      obj7.setgxTv_SdtConcepto_Conrecalcular_Z( Z762ConRecalcular );
      obj7.setgxTv_SdtConcepto_Conimportado_Z( Z894ConImportado );
      obj7.setgxTv_SdtConcepto_Contipoorden_Z( Z895ConTipoOrden );
      obj7.setgxTv_SdtConcepto_Conedienrec_Z( Z1017ConEdiEnRec );
      obj7.setgxTv_SdtConcepto_Conrangocant_Z( Z1018ConRangoCant );
      obj7.setgxTv_SdtConcepto_Conusado_Z( Z922ConUsado );
      obj7.setgxTv_SdtConcepto_Conobliga_Z( Z951ConObliga );
      obj7.setgxTv_SdtConcepto_Conobligasisac_Z( Z952ConObligaSiSac );
      obj7.setgxTv_SdtConcepto_Concondicion_Z( Z953ConCondicion );
      obj7.setgxTv_SdtConcepto_Concondcodigo_Z( Z954ConCondCodigo );
      obj7.setgxTv_SdtConcepto_Conprereq_Z( Z1066ConPreReq );
      obj7.setgxTv_SdtConcepto_Conmostrarpos_Z( Z1068ConMostrarPos );
      obj7.setgxTv_SdtConcepto_Conadeldescu_Z( Z1077ConAdelDescu );
      obj7.setgxTv_SdtConcepto_Apliigg_Z( Z1112AplIIGG );
      obj7.setgxTv_SdtConcepto_Consegunpla_Z( Z1194ConSegunPla );
      obj7.setgxTv_SdtConcepto_Connumero_Z( Z1471ConNumero );
      obj7.setgxTv_SdtConcepto_Consipaapo_Z( Z1472ConSIPAApo );
      obj7.setgxTv_SdtConcepto_Consipacont_Z( Z1473ConSIPACont );
      obj7.setgxTv_SdtConcepto_Coninssjypapo_Z( Z1474ConINSSJyPApo );
      obj7.setgxTv_SdtConcepto_Coninssjypcont_Z( Z1475ConINSSJyPCont );
      obj7.setgxTv_SdtConcepto_Conobrasocapo_Z( Z1476ConObraSocApo );
      obj7.setgxTv_SdtConcepto_Conobrasoccont_Z( Z1477ConObraSocCont );
      obj7.setgxTv_SdtConcepto_Confonsolredapo_Z( Z1478ConFonSolRedApo );
      obj7.setgxTv_SdtConcepto_Confonsolredcont_Z( Z1479ConFonSolRedCont );
      obj7.setgxTv_SdtConcepto_Conrenateaapo_Z( Z1480ConRenateaApo );
      obj7.setgxTv_SdtConcepto_Conrenateacont_Z( Z1481ConRenateaCont );
      obj7.setgxTv_SdtConcepto_Conasigfamcont_Z( Z1482ConAsigFamCont );
      obj7.setgxTv_SdtConcepto_Confonnacempcont_Z( Z1483ConFonNacEmpCont );
      obj7.setgxTv_SdtConcepto_Conleyrietrabcont_Z( Z1484ConLeyRieTrabCont );
      obj7.setgxTv_SdtConcepto_Conregdifapo_Z( Z1485ConRegDifApo );
      obj7.setgxTv_SdtConcepto_Conregespapo_Z( Z1486ConRegEspApo );
      obj7.setgxTv_SdtConcepto_Consacdeven_Z( Z1539ConSacDeven );
      obj7.setgxTv_SdtConcepto_Conbaselic_Z( Z1620ConBaseLic );
      obj7.setgxTv_SdtConcepto_Conbaselicprom_Z( Z1797ConBaseLicProm );
      obj7.setgxTv_SdtConcepto_Conbasefer_Z( Z1621ConBaseFer );
      obj7.setgxTv_SdtConcepto_Conbaseferprom_Z( Z1798ConBaseFerProm );
      obj7.setgxTv_SdtConcepto_Conbasehorext_Z( Z1622ConBaseHorExt );
      obj7.setgxTv_SdtConcepto_Conbasehorextprom_Z( Z1799ConBaseHorExtProm );
      obj7.setgxTv_SdtConcepto_Conbasepres_Z( Z1800ConBasePres );
      obj7.setgxTv_SdtConcepto_Conbaseant_Z( Z1801ConBaseAnt );
      obj7.setgxTv_SdtConcepto_Conbaseosdif_Z( Z1827ConBaseOSDif );
      obj7.setgxTv_SdtConcepto_Conbaseaus_Z( Z2191ConBaseAus );
      obj7.setgxTv_SdtConcepto_Conbaseausprom_Z( Z2192ConBaseAusProm );
      obj7.setgxTv_SdtConcepto_Conceptopais_Z( Z1644ConceptoPais );
      obj7.setgxTv_SdtConcepto_Conceptoconvecodigo_Z( Z1645ConceptoConveCodigo );
      obj7.setgxTv_SdtConcepto_Concodafip_Z( Z1648ConCodAfip );
      obj7.setgxTv_SdtConcepto_Concntpa_Z( Z1769ConCntPa );
      obj7.setgxTv_SdtConcepto_Conerrorsicero_Z( Z1821ConErrorSiCero );
      obj7.setgxTv_SdtConcepto_Clipadre_Z( Z1822CliPadre );
      obj7.setgxTv_SdtConcepto_Conpadre_Z( Z921ConPadre );
      obj7.setgxTv_SdtConcepto_Conpuenov_Z( Z1826ConPueNov );
      obj7.setgxTv_SdtConcepto_Conrelsec_Z( Z1886ConRelSec );
      obj7.setgxTv_SdtConcepto_Conrelseccli_Z( Z1905ConRelSecCli );
      obj7.setgxTv_SdtConcepto_Conrelref_Z( Z2013ConRelRef );
      obj7.setgxTv_SdtConcepto_Condescripsinac_Z( Z2185ConDescripSinAc );
      obj7.setgxTv_SdtConcepto_Conoblpalabra_Z( Z2187ConOblPalabra );
      obj7.setgxTv_SdtConcepto_Conformula_N( (byte)((byte)((n148ConFormula)?1:0)) );
      obj7.setgxTv_SdtConcepto_Convalorgen_N( (byte)((byte)((n157ConValorGen)?1:0)) );
      obj7.setgxTv_SdtConcepto_Contipoliqganancias_N( (byte)((byte)((n155ConTipoLiqGanancias)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conhisformula_N( (byte)((byte)((n151ConHisFormula)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conusumodfor_N( (byte)((byte)((n156ConUsuModFor)?1:0)) );
      obj7.setgxTv_SdtConcepto_Confchmodfor_N( (byte)((byte)((n145ConFchModFor)?1:0)) );
      obj7.setgxTv_SdtConcepto_Concodydesc_N( (byte)((byte)((n42ConCodYDesc)?1:0)) );
      obj7.setgxTv_SdtConcepto_Subtipoconcod1_N( (byte)((byte)((n38SubTipoConCod1)?1:0)) );
      obj7.setgxTv_SdtConcepto_Subtipoconcod2_N( (byte)((byte)((n39SubTipoConCod2)?1:0)) );
      obj7.setgxTv_SdtConcepto_Concuendebe_N( (byte)((byte)((n487ConCuenDebe)?1:0)) );
      obj7.setgxTv_SdtConcepto_Concuenhaber_N( (byte)((byte)((n488ConCuenHaber)?1:0)) );
      obj7.setgxTv_SdtConcepto_Contipoliqaux_N( (byte)((byte)((n503ConTipoLiqAux)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conconveaux_N( (byte)((byte)((n969ConConveAux)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conclasifaux_N( (byte)((byte)((n970ConClasifAux)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conaplicgan_N( (byte)((byte)((n735ConAplicGan)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conobliga_N( (byte)((byte)((n951ConObliga)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conobligasisac_N( (byte)((byte)((n952ConObligaSiSac)?1:0)) );
      obj7.setgxTv_SdtConcepto_Concondicion_N( (byte)((byte)((n953ConCondicion)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conprereq_N( (byte)((byte)((n1066ConPreReq)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conadeldescu_N( (byte)((byte)((n1077ConAdelDescu)?1:0)) );
      obj7.setgxTv_SdtConcepto_Apliigg_N( (byte)((byte)((n1112AplIIGG)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conceptopais_N( (byte)((byte)((n1644ConceptoPais)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conceptoconvecodigo_N( (byte)((byte)((n1645ConceptoConveCodigo)?1:0)) );
      obj7.setgxTv_SdtConcepto_Clipadre_N( (byte)((byte)((n1822CliPadre)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conpadre_N( (byte)((byte)((n921ConPadre)?1:0)) );
      obj7.setgxTv_SdtConcepto_Conoblpalabra_N( (byte)((byte)((n2187ConOblPalabra)?1:0)) );
      obj7.setgxTv_SdtConcepto_Mode( Gx_mode );
   }

   public void KeyVarsToRow7( web.SdtConcepto obj7 )
   {
      obj7.setgxTv_SdtConcepto_Clicod( A3CliCod );
      obj7.setgxTv_SdtConcepto_Concodigo( A26ConCodigo );
   }

   public void RowToVars7( web.SdtConcepto obj7 ,
                           int forceLoad )
   {
      Gx_mode = obj7.getgxTv_SdtConcepto_Mode() ;
      A145ConFchModFor = obj7.getgxTv_SdtConcepto_Confchmodfor() ;
      n145ConFchModFor = false ;
      A156ConUsuModFor = obj7.getgxTv_SdtConcepto_Conusumodfor() ;
      n156ConUsuModFor = false ;
      A143ConCanti = obj7.getgxTv_SdtConcepto_Concanti() ;
      A158ConValUni = obj7.getgxTv_SdtConcepto_Convaluni() ;
      A152ConImporte = obj7.getgxTv_SdtConcepto_Conimporte() ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A159ConVariable = obj7.getgxTv_SdtConcepto_Convariable() ;
      }
      A1905ConRelSecCli = obj7.getgxTv_SdtConcepto_Conrelseccli() ;
      A1974ConOldValues = obj7.getgxTv_SdtConcepto_Conoldvalues() ;
      A149ConFormulaAbr = obj7.getgxTv_SdtConcepto_Conformulaabr() ;
      A42ConCodYDesc = obj7.getgxTv_SdtConcepto_Concodydesc() ;
      n42ConCodYDesc = false ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A41ConDescrip = obj7.getgxTv_SdtConcepto_Condescrip() ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A40ConOrden = obj7.getgxTv_SdtConcepto_Conorden() ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A162ConVigencia = obj7.getgxTv_SdtConcepto_Convigencia() ;
      }
      A1488ConLiqBasica = obj7.getgxTv_SdtConcepto_Conliqbasica() ;
      A148ConFormula = obj7.getgxTv_SdtConcepto_Conformula() ;
      n148ConFormula = false ;
      A729ConFormulaPreResuelta = obj7.getgxTv_SdtConcepto_Conformulapreresuelta() ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A157ConValorGen = obj7.getgxTv_SdtConcepto_Convalorgen() ;
         n157ConValorGen = false ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A153ConObservacion = obj7.getgxTv_SdtConcepto_Conobservacion() ;
      }
      A151ConHisFormula = obj7.getgxTv_SdtConcepto_Conhisformula() ;
      n151ConHisFormula = false ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A37TipoConCod = obj7.getgxTv_SdtConcepto_Tipoconcod() ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A38SubTipoConCod1 = obj7.getgxTv_SdtConcepto_Subtipoconcod1() ;
         n38SubTipoConCod1 = false ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A39SubTipoConCod2 = obj7.getgxTv_SdtConcepto_Subtipoconcod2() ;
         n39SubTipoConCod2 = false ;
      }
      A154ConTipo = obj7.getgxTv_SdtConcepto_Contipo() ;
      A469ConCodOld = obj7.getgxTv_SdtConcepto_Concodold() ;
      A487ConCuenDebe = obj7.getgxTv_SdtConcepto_Concuendebe() ;
      n487ConCuenDebe = false ;
      A488ConCuenHaber = obj7.getgxTv_SdtConcepto_Concuenhaber() ;
      n488ConCuenHaber = false ;
      A503ConTipoLiqAux = obj7.getgxTv_SdtConcepto_Contipoliqaux() ;
      n503ConTipoLiqAux = false ;
      A969ConConveAux = obj7.getgxTv_SdtConcepto_Conconveaux() ;
      n969ConConveAux = false ;
      A970ConClasifAux = obj7.getgxTv_SdtConcepto_Conclasifaux() ;
      n970ConClasifAux = false ;
      A510ConOrdEjec = obj7.getgxTv_SdtConcepto_Conordejec() ;
      A569ConFormulaExpl = obj7.getgxTv_SdtConcepto_Conformulaexpl() ;
      A720ConFormulaObs2 = obj7.getgxTv_SdtConcepto_Conformulaobs2() ;
      A734ConRetGanPropor = obj7.getgxTv_SdtConcepto_Conretganpropor() ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A735ConAplicGan = obj7.getgxTv_SdtConcepto_Conaplicgan() ;
         n735ConAplicGan = false ;
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A762ConRecalcular = obj7.getgxTv_SdtConcepto_Conrecalcular() ;
      }
      A894ConImportado = obj7.getgxTv_SdtConcepto_Conimportado() ;
      A895ConTipoOrden = obj7.getgxTv_SdtConcepto_Contipoorden() ;
      A1017ConEdiEnRec = obj7.getgxTv_SdtConcepto_Conedienrec() ;
      A1018ConRangoCant = obj7.getgxTv_SdtConcepto_Conrangocant() ;
      A922ConUsado = obj7.getgxTv_SdtConcepto_Conusado() ;
      A951ConObliga = obj7.getgxTv_SdtConcepto_Conobliga() ;
      n951ConObliga = false ;
      A952ConObligaSiSac = obj7.getgxTv_SdtConcepto_Conobligasisac() ;
      n952ConObligaSiSac = false ;
      A953ConCondicion = obj7.getgxTv_SdtConcepto_Concondicion() ;
      n953ConCondicion = false ;
      A954ConCondCodigo = obj7.getgxTv_SdtConcepto_Concondcodigo() ;
      A1066ConPreReq = obj7.getgxTv_SdtConcepto_Conprereq() ;
      n1066ConPreReq = false ;
      A1068ConMostrarPos = obj7.getgxTv_SdtConcepto_Conmostrarpos() ;
      A1077ConAdelDescu = obj7.getgxTv_SdtConcepto_Conadeldescu() ;
      n1077ConAdelDescu = false ;
      A1112AplIIGG = obj7.getgxTv_SdtConcepto_Apliigg() ;
      n1112AplIIGG = false ;
      A1194ConSegunPla = obj7.getgxTv_SdtConcepto_Consegunpla() ;
      A1471ConNumero = obj7.getgxTv_SdtConcepto_Connumero() ;
      A1472ConSIPAApo = obj7.getgxTv_SdtConcepto_Consipaapo() ;
      A1473ConSIPACont = obj7.getgxTv_SdtConcepto_Consipacont() ;
      A1474ConINSSJyPApo = obj7.getgxTv_SdtConcepto_Coninssjypapo() ;
      A1475ConINSSJyPCont = obj7.getgxTv_SdtConcepto_Coninssjypcont() ;
      A1476ConObraSocApo = obj7.getgxTv_SdtConcepto_Conobrasocapo() ;
      A1477ConObraSocCont = obj7.getgxTv_SdtConcepto_Conobrasoccont() ;
      A1478ConFonSolRedApo = obj7.getgxTv_SdtConcepto_Confonsolredapo() ;
      A1479ConFonSolRedCont = obj7.getgxTv_SdtConcepto_Confonsolredcont() ;
      A1480ConRenateaApo = obj7.getgxTv_SdtConcepto_Conrenateaapo() ;
      A1481ConRenateaCont = obj7.getgxTv_SdtConcepto_Conrenateacont() ;
      A1482ConAsigFamCont = obj7.getgxTv_SdtConcepto_Conasigfamcont() ;
      A1483ConFonNacEmpCont = obj7.getgxTv_SdtConcepto_Confonnacempcont() ;
      A1484ConLeyRieTrabCont = obj7.getgxTv_SdtConcepto_Conleyrietrabcont() ;
      A1485ConRegDifApo = obj7.getgxTv_SdtConcepto_Conregdifapo() ;
      A1486ConRegEspApo = obj7.getgxTv_SdtConcepto_Conregespapo() ;
      A1539ConSacDeven = obj7.getgxTv_SdtConcepto_Consacdeven() ;
      A1620ConBaseLic = obj7.getgxTv_SdtConcepto_Conbaselic() ;
      A1797ConBaseLicProm = obj7.getgxTv_SdtConcepto_Conbaselicprom() ;
      A1621ConBaseFer = obj7.getgxTv_SdtConcepto_Conbasefer() ;
      A1798ConBaseFerProm = obj7.getgxTv_SdtConcepto_Conbaseferprom() ;
      A1622ConBaseHorExt = obj7.getgxTv_SdtConcepto_Conbasehorext() ;
      A1799ConBaseHorExtProm = obj7.getgxTv_SdtConcepto_Conbasehorextprom() ;
      A1800ConBasePres = obj7.getgxTv_SdtConcepto_Conbasepres() ;
      A1801ConBaseAnt = obj7.getgxTv_SdtConcepto_Conbaseant() ;
      A1827ConBaseOSDif = obj7.getgxTv_SdtConcepto_Conbaseosdif() ;
      A2191ConBaseAus = obj7.getgxTv_SdtConcepto_Conbaseaus() ;
      A2192ConBaseAusProm = obj7.getgxTv_SdtConcepto_Conbaseausprom() ;
      A1644ConceptoPais = obj7.getgxTv_SdtConcepto_Conceptopais() ;
      n1644ConceptoPais = false ;
      A1645ConceptoConveCodigo = obj7.getgxTv_SdtConcepto_Conceptoconvecodigo() ;
      n1645ConceptoConveCodigo = false ;
      A1648ConCodAfip = obj7.getgxTv_SdtConcepto_Concodafip() ;
      A1769ConCntPa = obj7.getgxTv_SdtConcepto_Concntpa() ;
      A1821ConErrorSiCero = obj7.getgxTv_SdtConcepto_Conerrorsicero() ;
      A1822CliPadre = obj7.getgxTv_SdtConcepto_Clipadre() ;
      n1822CliPadre = false ;
      A921ConPadre = obj7.getgxTv_SdtConcepto_Conpadre() ;
      n921ConPadre = false ;
      A1826ConPueNov = obj7.getgxTv_SdtConcepto_Conpuenov() ;
      A1886ConRelSec = obj7.getgxTv_SdtConcepto_Conrelsec() ;
      A2013ConRelRef = obj7.getgxTv_SdtConcepto_Conrelref() ;
      A2185ConDescripSinAc = obj7.getgxTv_SdtConcepto_Condescripsinac() ;
      A2187ConOblPalabra = obj7.getgxTv_SdtConcepto_Conoblpalabra() ;
      n2187ConOblPalabra = false ;
      A150ConHabilitado = obj7.getgxTv_SdtConcepto_Conhabilitado() ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A155ConTipoLiqGanancias = obj7.getgxTv_SdtConcepto_Contipoliqganancias() ;
         n155ConTipoLiqGanancias = false ;
      }
      A3CliCod = obj7.getgxTv_SdtConcepto_Clicod() ;
      A26ConCodigo = obj7.getgxTv_SdtConcepto_Concodigo() ;
      Z3CliCod = obj7.getgxTv_SdtConcepto_Clicod_Z() ;
      Z26ConCodigo = obj7.getgxTv_SdtConcepto_Concodigo_Z() ;
      Z41ConDescrip = obj7.getgxTv_SdtConcepto_Condescrip_Z() ;
      O41ConDescrip = obj7.getgxTv_SdtConcepto_Condescrip_Z() ;
      Z150ConHabilitado = obj7.getgxTv_SdtConcepto_Conhabilitado_Z() ;
      Z40ConOrden = obj7.getgxTv_SdtConcepto_Conorden_Z() ;
      Z143ConCanti = obj7.getgxTv_SdtConcepto_Concanti_Z() ;
      Z158ConValUni = obj7.getgxTv_SdtConcepto_Convaluni_Z() ;
      Z152ConImporte = obj7.getgxTv_SdtConcepto_Conimporte_Z() ;
      Z162ConVigencia = obj7.getgxTv_SdtConcepto_Convigencia_Z() ;
      Z1488ConLiqBasica = obj7.getgxTv_SdtConcepto_Conliqbasica_Z() ;
      Z157ConValorGen = obj7.getgxTv_SdtConcepto_Convalorgen_Z() ;
      Z155ConTipoLiqGanancias = obj7.getgxTv_SdtConcepto_Contipoliqganancias_Z() ;
      Z159ConVariable = obj7.getgxTv_SdtConcepto_Convariable_Z() ;
      Z156ConUsuModFor = obj7.getgxTv_SdtConcepto_Conusumodfor_Z() ;
      Z145ConFchModFor = obj7.getgxTv_SdtConcepto_Confchmodfor_Z() ;
      Z149ConFormulaAbr = obj7.getgxTv_SdtConcepto_Conformulaabr_Z() ;
      Z42ConCodYDesc = obj7.getgxTv_SdtConcepto_Concodydesc_Z() ;
      Z37TipoConCod = obj7.getgxTv_SdtConcepto_Tipoconcod_Z() ;
      Z38SubTipoConCod1 = obj7.getgxTv_SdtConcepto_Subtipoconcod1_Z() ;
      Z39SubTipoConCod2 = obj7.getgxTv_SdtConcepto_Subtipoconcod2_Z() ;
      Z154ConTipo = obj7.getgxTv_SdtConcepto_Contipo_Z() ;
      Z469ConCodOld = obj7.getgxTv_SdtConcepto_Concodold_Z() ;
      Z487ConCuenDebe = obj7.getgxTv_SdtConcepto_Concuendebe_Z() ;
      Z488ConCuenHaber = obj7.getgxTv_SdtConcepto_Concuenhaber_Z() ;
      Z503ConTipoLiqAux = obj7.getgxTv_SdtConcepto_Contipoliqaux_Z() ;
      Z969ConConveAux = obj7.getgxTv_SdtConcepto_Conconveaux_Z() ;
      Z970ConClasifAux = obj7.getgxTv_SdtConcepto_Conclasifaux_Z() ;
      Z510ConOrdEjec = obj7.getgxTv_SdtConcepto_Conordejec_Z() ;
      Z734ConRetGanPropor = obj7.getgxTv_SdtConcepto_Conretganpropor_Z() ;
      Z735ConAplicGan = obj7.getgxTv_SdtConcepto_Conaplicgan_Z() ;
      Z762ConRecalcular = obj7.getgxTv_SdtConcepto_Conrecalcular_Z() ;
      Z894ConImportado = obj7.getgxTv_SdtConcepto_Conimportado_Z() ;
      Z895ConTipoOrden = obj7.getgxTv_SdtConcepto_Contipoorden_Z() ;
      Z1017ConEdiEnRec = obj7.getgxTv_SdtConcepto_Conedienrec_Z() ;
      Z1018ConRangoCant = obj7.getgxTv_SdtConcepto_Conrangocant_Z() ;
      Z922ConUsado = obj7.getgxTv_SdtConcepto_Conusado_Z() ;
      Z951ConObliga = obj7.getgxTv_SdtConcepto_Conobliga_Z() ;
      Z952ConObligaSiSac = obj7.getgxTv_SdtConcepto_Conobligasisac_Z() ;
      Z953ConCondicion = obj7.getgxTv_SdtConcepto_Concondicion_Z() ;
      Z954ConCondCodigo = obj7.getgxTv_SdtConcepto_Concondcodigo_Z() ;
      Z1066ConPreReq = obj7.getgxTv_SdtConcepto_Conprereq_Z() ;
      Z1068ConMostrarPos = obj7.getgxTv_SdtConcepto_Conmostrarpos_Z() ;
      Z1077ConAdelDescu = obj7.getgxTv_SdtConcepto_Conadeldescu_Z() ;
      Z1112AplIIGG = obj7.getgxTv_SdtConcepto_Apliigg_Z() ;
      Z1194ConSegunPla = obj7.getgxTv_SdtConcepto_Consegunpla_Z() ;
      Z1471ConNumero = obj7.getgxTv_SdtConcepto_Connumero_Z() ;
      Z1472ConSIPAApo = obj7.getgxTv_SdtConcepto_Consipaapo_Z() ;
      Z1473ConSIPACont = obj7.getgxTv_SdtConcepto_Consipacont_Z() ;
      Z1474ConINSSJyPApo = obj7.getgxTv_SdtConcepto_Coninssjypapo_Z() ;
      Z1475ConINSSJyPCont = obj7.getgxTv_SdtConcepto_Coninssjypcont_Z() ;
      Z1476ConObraSocApo = obj7.getgxTv_SdtConcepto_Conobrasocapo_Z() ;
      Z1477ConObraSocCont = obj7.getgxTv_SdtConcepto_Conobrasoccont_Z() ;
      Z1478ConFonSolRedApo = obj7.getgxTv_SdtConcepto_Confonsolredapo_Z() ;
      Z1479ConFonSolRedCont = obj7.getgxTv_SdtConcepto_Confonsolredcont_Z() ;
      Z1480ConRenateaApo = obj7.getgxTv_SdtConcepto_Conrenateaapo_Z() ;
      Z1481ConRenateaCont = obj7.getgxTv_SdtConcepto_Conrenateacont_Z() ;
      Z1482ConAsigFamCont = obj7.getgxTv_SdtConcepto_Conasigfamcont_Z() ;
      Z1483ConFonNacEmpCont = obj7.getgxTv_SdtConcepto_Confonnacempcont_Z() ;
      Z1484ConLeyRieTrabCont = obj7.getgxTv_SdtConcepto_Conleyrietrabcont_Z() ;
      Z1485ConRegDifApo = obj7.getgxTv_SdtConcepto_Conregdifapo_Z() ;
      Z1486ConRegEspApo = obj7.getgxTv_SdtConcepto_Conregespapo_Z() ;
      Z1539ConSacDeven = obj7.getgxTv_SdtConcepto_Consacdeven_Z() ;
      Z1620ConBaseLic = obj7.getgxTv_SdtConcepto_Conbaselic_Z() ;
      O1620ConBaseLic = obj7.getgxTv_SdtConcepto_Conbaselic_Z() ;
      Z1797ConBaseLicProm = obj7.getgxTv_SdtConcepto_Conbaselicprom_Z() ;
      O1797ConBaseLicProm = obj7.getgxTv_SdtConcepto_Conbaselicprom_Z() ;
      Z1621ConBaseFer = obj7.getgxTv_SdtConcepto_Conbasefer_Z() ;
      O1621ConBaseFer = obj7.getgxTv_SdtConcepto_Conbasefer_Z() ;
      Z1798ConBaseFerProm = obj7.getgxTv_SdtConcepto_Conbaseferprom_Z() ;
      O1798ConBaseFerProm = obj7.getgxTv_SdtConcepto_Conbaseferprom_Z() ;
      Z1622ConBaseHorExt = obj7.getgxTv_SdtConcepto_Conbasehorext_Z() ;
      O1622ConBaseHorExt = obj7.getgxTv_SdtConcepto_Conbasehorext_Z() ;
      Z1799ConBaseHorExtProm = obj7.getgxTv_SdtConcepto_Conbasehorextprom_Z() ;
      O1799ConBaseHorExtProm = obj7.getgxTv_SdtConcepto_Conbasehorextprom_Z() ;
      Z1800ConBasePres = obj7.getgxTv_SdtConcepto_Conbasepres_Z() ;
      O1800ConBasePres = obj7.getgxTv_SdtConcepto_Conbasepres_Z() ;
      Z1801ConBaseAnt = obj7.getgxTv_SdtConcepto_Conbaseant_Z() ;
      O1801ConBaseAnt = obj7.getgxTv_SdtConcepto_Conbaseant_Z() ;
      Z1827ConBaseOSDif = obj7.getgxTv_SdtConcepto_Conbaseosdif_Z() ;
      O1827ConBaseOSDif = obj7.getgxTv_SdtConcepto_Conbaseosdif_Z() ;
      Z2191ConBaseAus = obj7.getgxTv_SdtConcepto_Conbaseaus_Z() ;
      O2191ConBaseAus = obj7.getgxTv_SdtConcepto_Conbaseaus_Z() ;
      Z2192ConBaseAusProm = obj7.getgxTv_SdtConcepto_Conbaseausprom_Z() ;
      O2192ConBaseAusProm = obj7.getgxTv_SdtConcepto_Conbaseausprom_Z() ;
      Z1644ConceptoPais = obj7.getgxTv_SdtConcepto_Conceptopais_Z() ;
      Z1645ConceptoConveCodigo = obj7.getgxTv_SdtConcepto_Conceptoconvecodigo_Z() ;
      Z1648ConCodAfip = obj7.getgxTv_SdtConcepto_Concodafip_Z() ;
      Z1769ConCntPa = obj7.getgxTv_SdtConcepto_Concntpa_Z() ;
      Z1821ConErrorSiCero = obj7.getgxTv_SdtConcepto_Conerrorsicero_Z() ;
      Z1822CliPadre = obj7.getgxTv_SdtConcepto_Clipadre_Z() ;
      Z921ConPadre = obj7.getgxTv_SdtConcepto_Conpadre_Z() ;
      Z1826ConPueNov = obj7.getgxTv_SdtConcepto_Conpuenov_Z() ;
      Z1886ConRelSec = obj7.getgxTv_SdtConcepto_Conrelsec_Z() ;
      Z1905ConRelSecCli = obj7.getgxTv_SdtConcepto_Conrelseccli_Z() ;
      Z2013ConRelRef = obj7.getgxTv_SdtConcepto_Conrelref_Z() ;
      Z2185ConDescripSinAc = obj7.getgxTv_SdtConcepto_Condescripsinac_Z() ;
      Z2187ConOblPalabra = obj7.getgxTv_SdtConcepto_Conoblpalabra_Z() ;
      n148ConFormula = (boolean)((obj7.getgxTv_SdtConcepto_Conformula_N()==0)?false:true) ;
      n157ConValorGen = (boolean)((obj7.getgxTv_SdtConcepto_Convalorgen_N()==0)?false:true) ;
      n155ConTipoLiqGanancias = (boolean)((obj7.getgxTv_SdtConcepto_Contipoliqganancias_N()==0)?false:true) ;
      n151ConHisFormula = (boolean)((obj7.getgxTv_SdtConcepto_Conhisformula_N()==0)?false:true) ;
      n156ConUsuModFor = (boolean)((obj7.getgxTv_SdtConcepto_Conusumodfor_N()==0)?false:true) ;
      n145ConFchModFor = (boolean)((obj7.getgxTv_SdtConcepto_Confchmodfor_N()==0)?false:true) ;
      n42ConCodYDesc = (boolean)((obj7.getgxTv_SdtConcepto_Concodydesc_N()==0)?false:true) ;
      n38SubTipoConCod1 = (boolean)((obj7.getgxTv_SdtConcepto_Subtipoconcod1_N()==0)?false:true) ;
      n39SubTipoConCod2 = (boolean)((obj7.getgxTv_SdtConcepto_Subtipoconcod2_N()==0)?false:true) ;
      n487ConCuenDebe = (boolean)((obj7.getgxTv_SdtConcepto_Concuendebe_N()==0)?false:true) ;
      n488ConCuenHaber = (boolean)((obj7.getgxTv_SdtConcepto_Concuenhaber_N()==0)?false:true) ;
      n503ConTipoLiqAux = (boolean)((obj7.getgxTv_SdtConcepto_Contipoliqaux_N()==0)?false:true) ;
      n969ConConveAux = (boolean)((obj7.getgxTv_SdtConcepto_Conconveaux_N()==0)?false:true) ;
      n970ConClasifAux = (boolean)((obj7.getgxTv_SdtConcepto_Conclasifaux_N()==0)?false:true) ;
      n735ConAplicGan = (boolean)((obj7.getgxTv_SdtConcepto_Conaplicgan_N()==0)?false:true) ;
      n951ConObliga = (boolean)((obj7.getgxTv_SdtConcepto_Conobliga_N()==0)?false:true) ;
      n952ConObligaSiSac = (boolean)((obj7.getgxTv_SdtConcepto_Conobligasisac_N()==0)?false:true) ;
      n953ConCondicion = (boolean)((obj7.getgxTv_SdtConcepto_Concondicion_N()==0)?false:true) ;
      n1066ConPreReq = (boolean)((obj7.getgxTv_SdtConcepto_Conprereq_N()==0)?false:true) ;
      n1077ConAdelDescu = (boolean)((obj7.getgxTv_SdtConcepto_Conadeldescu_N()==0)?false:true) ;
      n1112AplIIGG = (boolean)((obj7.getgxTv_SdtConcepto_Apliigg_N()==0)?false:true) ;
      n1644ConceptoPais = (boolean)((obj7.getgxTv_SdtConcepto_Conceptopais_N()==0)?false:true) ;
      n1645ConceptoConveCodigo = (boolean)((obj7.getgxTv_SdtConcepto_Conceptoconvecodigo_N()==0)?false:true) ;
      n1822CliPadre = (boolean)((obj7.getgxTv_SdtConcepto_Clipadre_N()==0)?false:true) ;
      n921ConPadre = (boolean)((obj7.getgxTv_SdtConcepto_Conpadre_N()==0)?false:true) ;
      n2187ConOblPalabra = (boolean)((obj7.getgxTv_SdtConcepto_Conoblpalabra_N()==0)?false:true) ;
      Gx_mode = obj7.getgxTv_SdtConcepto_Mode() ;
   }

   public void VarsToRow8( web.SdtConcepto_TipoLiquidacion obj8 )
   {
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Mode( Gx_mode );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc( A340TliqDesc );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa( A925ConTLiqSinCausa );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre( A926ConTLiqSinPre );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr( A950ConTLTipEgr );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec( A1406ConTLOrdejec );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlconord( A1407ConTLConOrd );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia( A1409ConTLVigencia );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( A1410ConTLCondicion );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab( A1470ConTLConHab );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon( A1788ConTLTipoCon );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla( A1789CONTLSegPla );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( A32TLiqCod );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z( Z32TLiqCod );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z( Z340TliqDesc );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z( Z925ConTLiqSinCausa );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z( Z926ConTLiqSinPre );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z( Z950ConTLTipEgr );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z( Z1406ConTLOrdejec );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z( Z1407ConTLConOrd );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z( Z1409ConTLVigencia );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z( Z1410ConTLCondicion );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z( Z1470ConTLConHab );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z( Z1788ConTLTipoCon );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z( Z1789CONTLSegPla );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N( (byte)((byte)((n925ConTLiqSinCausa)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N( (byte)((byte)((n926ConTLiqSinPre)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N( (byte)((byte)((n1409ConTLVigencia)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N( (byte)((byte)((n1410ConTLCondicion)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N( (byte)((byte)((n1788ConTLTipoCon)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N( (byte)((byte)((n1789CONTLSegPla)?1:0)) );
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Modified( nIsMod_8 );
   }

   public void KeyVarsToRow8( web.SdtConcepto_TipoLiquidacion obj8 )
   {
      obj8.setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( A32TLiqCod );
   }

   public void RowToVars8( web.SdtConcepto_TipoLiquidacion obj8 ,
                           int forceLoad )
   {
      Gx_mode = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Mode() ;
      A340TliqDesc = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc() ;
      A925ConTLiqSinCausa = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa() ;
      n925ConTLiqSinCausa = false ;
      A926ConTLiqSinPre = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre() ;
      n926ConTLiqSinPre = false ;
      A950ConTLTipEgr = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr() ;
      A1406ConTLOrdejec = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec() ;
      A1407ConTLConOrd = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlconord() ;
      A1409ConTLVigencia = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia() ;
      n1409ConTLVigencia = false ;
      A1410ConTLCondicion = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion() ;
      n1410ConTLCondicion = false ;
      A1470ConTLConHab = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab() ;
      A1788ConTLTipoCon = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon() ;
      n1788ConTLTipoCon = false ;
      A1789CONTLSegPla = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla() ;
      n1789CONTLSegPla = false ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) != 0 ) && ! AV17permiteModificacion ) || ( forceLoad == 1 ) )
      {
         A32TLiqCod = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod() ;
      }
      Z32TLiqCod = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z() ;
      Z340TliqDesc = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z() ;
      Z925ConTLiqSinCausa = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z() ;
      Z926ConTLiqSinPre = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z() ;
      Z950ConTLTipEgr = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z() ;
      Z1406ConTLOrdejec = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z() ;
      Z1407ConTLConOrd = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z() ;
      Z1409ConTLVigencia = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z() ;
      Z1410ConTLCondicion = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z() ;
      Z1470ConTLConHab = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z() ;
      Z1788ConTLTipoCon = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z() ;
      Z1789CONTLSegPla = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z() ;
      n925ConTLiqSinCausa = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N()==0)?false:true) ;
      n926ConTLiqSinPre = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N()==0)?false:true) ;
      n1409ConTLVigencia = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N()==0)?false:true) ;
      n1410ConTLCondicion = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N()==0)?false:true) ;
      n1788ConTLTipoCon = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N()==0)?false:true) ;
      n1789CONTLSegPla = (boolean)((obj8.getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N()==0)?false:true) ;
      nIsMod_8 = obj8.getgxTv_SdtConcepto_TipoLiquidacion_Modified() ;
   }

   public void VarsToRow261( web.SdtConcepto_MotivosEgreso obj261 )
   {
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Mode( Gx_mode );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo( A1532MegPreaTipo );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses( A1530ConMegMeses );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegdura( A1534ConMegDura );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor( A1529ConMegPropor );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Megcodigo( A11MegCodigo );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegsec( A2077ConMegSec );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z( Z11MegCodigo );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z( Z2077ConMegSec );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z( Z1532MegPreaTipo );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z( Z1530ConMegMeses );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z( Z1534ConMegDura );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z( Z1529ConMegPropor );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Modified( nIsMod_261 );
   }

   public void KeyVarsToRow261( web.SdtConcepto_MotivosEgreso obj261 )
   {
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Megcodigo( A11MegCodigo );
      obj261.setgxTv_SdtConcepto_MotivosEgreso_Conmegsec( A2077ConMegSec );
   }

   public void RowToVars261( web.SdtConcepto_MotivosEgreso obj261 ,
                             int forceLoad )
   {
      Gx_mode = obj261.getgxTv_SdtConcepto_MotivosEgreso_Mode() ;
      A1532MegPreaTipo = obj261.getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo() ;
      A1530ConMegMeses = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses() ;
      A1534ConMegDura = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegdura() ;
      A1529ConMegPropor = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor() ;
      A11MegCodigo = obj261.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo() ;
      A2077ConMegSec = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec() ;
      Z11MegCodigo = obj261.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z() ;
      Z2077ConMegSec = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z() ;
      Z1532MegPreaTipo = obj261.getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z() ;
      Z1530ConMegMeses = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z() ;
      Z1534ConMegDura = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z() ;
      Z1529ConMegPropor = obj261.getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z() ;
      nIsMod_261 = obj261.getgxTv_SdtConcepto_MotivosEgreso_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A26ConCodigo = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0A7( ) ;
      scanKeyStart0A7( ) ;
      if ( RcdFound7 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         O41ConDescrip = A41ConDescrip ;
         O2192ConBaseAusProm = A2192ConBaseAusProm ;
         O2191ConBaseAus = A2191ConBaseAus ;
         O1827ConBaseOSDif = A1827ConBaseOSDif ;
         O1801ConBaseAnt = A1801ConBaseAnt ;
         O1800ConBasePres = A1800ConBasePres ;
         O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         O1622ConBaseHorExt = A1622ConBaseHorExt ;
         O1798ConBaseFerProm = A1798ConBaseFerProm ;
         O1621ConBaseFer = A1621ConBaseFer ;
         O1797ConBaseLicProm = A1797ConBaseLicProm ;
         O1620ConBaseLic = A1620ConBaseLic ;
      }
      zm0A7( -60) ;
      onLoadActions0A7( ) ;
      addRow0A7( ) ;
      bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().clearCollection();
      if ( RcdFound7 == 1 )
      {
         scanKeyStart0A8( ) ;
         nGXsfl_8_idx = 1 ;
         while ( RcdFound8 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z26ConCodigo = A26ConCodigo ;
            Z32TLiqCod = A32TLiqCod ;
            zm0A8( -69) ;
            onLoadActions0A8( ) ;
            nRcdExists_8 = (short)(1) ;
            nIsMod_8 = (short)(0) ;
            addRow0A8( ) ;
            nGXsfl_8_idx = (int)(nGXsfl_8_idx+1) ;
            scanKeyNext0A8( ) ;
         }
         scanKeyEnd0A8( ) ;
      }
      bcConcepto.getgxTv_SdtConcepto_Motivosegreso().clearCollection();
      if ( RcdFound7 == 1 )
      {
         scanKeyStart0A261( ) ;
         nGXsfl_261_idx = 1 ;
         while ( RcdFound261 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z26ConCodigo = A26ConCodigo ;
            Z11MegCodigo = A11MegCodigo ;
            Z2077ConMegSec = A2077ConMegSec ;
            zm0A261( -71) ;
            onLoadActions0A261( ) ;
            nRcdExists_261 = (short)(1) ;
            nIsMod_261 = (short)(0) ;
            addRow0A261( ) ;
            nGXsfl_261_idx = (int)(nGXsfl_261_idx+1) ;
            scanKeyNext0A261( ) ;
         }
         scanKeyEnd0A261( ) ;
      }
      scanKeyEnd0A7( ) ;
      if ( RcdFound7 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars7( bcConcepto, 0) ;
      scanKeyStart0A7( ) ;
      if ( RcdFound7 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         O41ConDescrip = A41ConDescrip ;
         O2192ConBaseAusProm = A2192ConBaseAusProm ;
         O2191ConBaseAus = A2191ConBaseAus ;
         O1827ConBaseOSDif = A1827ConBaseOSDif ;
         O1801ConBaseAnt = A1801ConBaseAnt ;
         O1800ConBasePres = A1800ConBasePres ;
         O1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         O1622ConBaseHorExt = A1622ConBaseHorExt ;
         O1798ConBaseFerProm = A1798ConBaseFerProm ;
         O1621ConBaseFer = A1621ConBaseFer ;
         O1797ConBaseLicProm = A1797ConBaseLicProm ;
         O1620ConBaseLic = A1620ConBaseLic ;
      }
      zm0A7( -60) ;
      onLoadActions0A7( ) ;
      addRow0A7( ) ;
      bcConcepto.getgxTv_SdtConcepto_Tipoliquidacion().clearCollection();
      if ( RcdFound7 == 1 )
      {
         scanKeyStart0A8( ) ;
         nGXsfl_8_idx = 1 ;
         while ( RcdFound8 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z26ConCodigo = A26ConCodigo ;
            Z32TLiqCod = A32TLiqCod ;
            zm0A8( -69) ;
            onLoadActions0A8( ) ;
            nRcdExists_8 = (short)(1) ;
            nIsMod_8 = (short)(0) ;
            addRow0A8( ) ;
            nGXsfl_8_idx = (int)(nGXsfl_8_idx+1) ;
            scanKeyNext0A8( ) ;
         }
         scanKeyEnd0A8( ) ;
      }
      bcConcepto.getgxTv_SdtConcepto_Motivosegreso().clearCollection();
      if ( RcdFound7 == 1 )
      {
         scanKeyStart0A261( ) ;
         nGXsfl_261_idx = 1 ;
         while ( RcdFound261 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z26ConCodigo = A26ConCodigo ;
            Z11MegCodigo = A11MegCodigo ;
            Z2077ConMegSec = A2077ConMegSec ;
            zm0A261( -71) ;
            onLoadActions0A261( ) ;
            nRcdExists_261 = (short)(1) ;
            nIsMod_261 = (short)(0) ;
            addRow0A261( ) ;
            nGXsfl_261_idx = (int)(nGXsfl_261_idx+1) ;
            scanKeyNext0A261( ) ;
         }
         scanKeyEnd0A261( ) ;
      }
      scanKeyEnd0A7( ) ;
      if ( RcdFound7 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0A7( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0A7( ) ;
      }
      else
      {
         if ( RcdFound7 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A26ConCodigo = Z26ConCodigo ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0A7( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0A7( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0A7( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars7( bcConcepto, 1) ;
      saveImpl( ) ;
      VarsToRow7( bcConcepto) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars7( bcConcepto, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0A7( ) ;
      afterTrn( ) ;
      VarsToRow7( bcConcepto) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.SdtConcepto auxBC = new web.SdtConcepto( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A26ConCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcConcepto);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars7( bcConcepto, 1) ;
      updateImpl( ) ;
      VarsToRow7( bcConcepto) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars7( bcConcepto, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0A7( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow7( bcConcepto) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars7( bcConcepto, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0A7( ) ;
      if ( RcdFound7 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A26ConCodigo = Z26ConCodigo ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "concepto_bc");
      VarsToRow7( bcConcepto) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcConcepto.getgxTv_SdtConcepto_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcConcepto.setgxTv_SdtConcepto_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtConcepto sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcConcepto )
      {
         bcConcepto = sdt ;
         if ( GXutil.strcmp(bcConcepto.getgxTv_SdtConcepto_Mode(), "") == 0 )
         {
            bcConcepto.setgxTv_SdtConcepto_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow7( bcConcepto) ;
         }
         else
         {
            RowToVars7( bcConcepto, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcConcepto.getgxTv_SdtConcepto_Mode(), "") == 0 )
         {
            bcConcepto.setgxTv_SdtConcepto_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars7( bcConcepto, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtConcepto getConcepto_BC( )
   {
      return bcConcepto ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z26ConCodigo = "" ;
      A26ConCodigo = "" ;
      sMode7 = "" ;
      AV22WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV37Pgmname = "" ;
      AV20TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV21WebSession = httpContext.getWebSession();
      AV26TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV23Insert_TipoConCod = "" ;
      AV24Insert_SubTipoConCod1 = "" ;
      AV25Insert_SubTipoConCod2 = "" ;
      AV34Insert_ConCondicion = "" ;
      AV33Insert_ConceptoConveCodigo = "" ;
      AV29Insert_ConPadre = "" ;
      AV11ConCodigo = "" ;
      GXv_boolean3 = new boolean[1] ;
      GXv_int7 = new short[1] ;
      AV27defaultConCodigo = "" ;
      Z42ConCodYDesc = "" ;
      A42ConCodYDesc = "" ;
      Z145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      Z156ConUsuModFor = "" ;
      A156ConUsuModFor = "" ;
      Z41ConDescrip = "" ;
      A41ConDescrip = "" ;
      Z157ConValorGen = DecimalUtil.ZERO ;
      A157ConValorGen = DecimalUtil.ZERO ;
      Z155ConTipoLiqGanancias = "" ;
      A155ConTipoLiqGanancias = "" ;
      Z469ConCodOld = "" ;
      A469ConCodOld = "" ;
      Z487ConCuenDebe = "" ;
      A487ConCuenDebe = "" ;
      Z488ConCuenHaber = "" ;
      A488ConCuenHaber = "" ;
      Z503ConTipoLiqAux = "" ;
      A503ConTipoLiqAux = "" ;
      Z969ConConveAux = "" ;
      A969ConConveAux = "" ;
      Z970ConClasifAux = "" ;
      A970ConClasifAux = "" ;
      Z1018ConRangoCant = "" ;
      A1018ConRangoCant = "" ;
      Z954ConCondCodigo = "" ;
      A954ConCondCodigo = "" ;
      Z1066ConPreReq = "" ;
      A1066ConPreReq = "" ;
      Z1648ConCodAfip = "" ;
      A1648ConCodAfip = "" ;
      Z2013ConRelRef = "" ;
      A2013ConRelRef = "" ;
      Z2185ConDescripSinAc = "" ;
      A2185ConDescripSinAc = "" ;
      Z2187ConOblPalabra = "" ;
      A2187ConOblPalabra = "" ;
      Z37TipoConCod = "" ;
      A37TipoConCod = "" ;
      Z38SubTipoConCod1 = "" ;
      A38SubTipoConCod1 = "" ;
      Z39SubTipoConCod2 = "" ;
      A39SubTipoConCod2 = "" ;
      Z953ConCondicion = "" ;
      A953ConCondicion = "" ;
      Z1645ConceptoConveCodigo = "" ;
      A1645ConceptoConveCodigo = "" ;
      Z921ConPadre = "" ;
      A921ConPadre = "" ;
      Z149ConFormulaAbr = "" ;
      A149ConFormulaAbr = "" ;
      Z1974ConOldValues = "" ;
      A1974ConOldValues = "" ;
      Z148ConFormula = "" ;
      A148ConFormula = "" ;
      Z729ConFormulaPreResuelta = "" ;
      A729ConFormulaPreResuelta = "" ;
      Z153ConObservacion = "" ;
      A153ConObservacion = "" ;
      Z151ConHisFormula = "" ;
      A151ConHisFormula = "" ;
      Z569ConFormulaExpl = "" ;
      A569ConFormulaExpl = "" ;
      Z720ConFormulaObs2 = "" ;
      A720ConFormulaObs2 = "" ;
      GXv_int5 = new int[1] ;
      BC000A18_A42ConCodYDesc = new String[] {""} ;
      BC000A18_n42ConCodYDesc = new boolean[] {false} ;
      BC000A18_A26ConCodigo = new String[] {""} ;
      BC000A18_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A18_n145ConFchModFor = new boolean[] {false} ;
      BC000A18_A156ConUsuModFor = new String[] {""} ;
      BC000A18_n156ConUsuModFor = new boolean[] {false} ;
      BC000A18_A143ConCanti = new boolean[] {false} ;
      BC000A18_A158ConValUni = new boolean[] {false} ;
      BC000A18_A152ConImporte = new boolean[] {false} ;
      BC000A18_A159ConVariable = new boolean[] {false} ;
      BC000A18_A1905ConRelSecCli = new int[1] ;
      BC000A18_A1974ConOldValues = new String[] {""} ;
      BC000A18_A41ConDescrip = new String[] {""} ;
      BC000A18_A150ConHabilitado = new boolean[] {false} ;
      BC000A18_A40ConOrden = new int[1] ;
      BC000A18_A162ConVigencia = new byte[1] ;
      BC000A18_A1488ConLiqBasica = new byte[1] ;
      BC000A18_A148ConFormula = new String[] {""} ;
      BC000A18_n148ConFormula = new boolean[] {false} ;
      BC000A18_A729ConFormulaPreResuelta = new String[] {""} ;
      BC000A18_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A18_n157ConValorGen = new boolean[] {false} ;
      BC000A18_A155ConTipoLiqGanancias = new String[] {""} ;
      BC000A18_n155ConTipoLiqGanancias = new boolean[] {false} ;
      BC000A18_A153ConObservacion = new String[] {""} ;
      BC000A18_A151ConHisFormula = new String[] {""} ;
      BC000A18_n151ConHisFormula = new boolean[] {false} ;
      BC000A18_A154ConTipo = new byte[1] ;
      BC000A18_A469ConCodOld = new String[] {""} ;
      BC000A18_A487ConCuenDebe = new String[] {""} ;
      BC000A18_n487ConCuenDebe = new boolean[] {false} ;
      BC000A18_A488ConCuenHaber = new String[] {""} ;
      BC000A18_n488ConCuenHaber = new boolean[] {false} ;
      BC000A18_A503ConTipoLiqAux = new String[] {""} ;
      BC000A18_n503ConTipoLiqAux = new boolean[] {false} ;
      BC000A18_A969ConConveAux = new String[] {""} ;
      BC000A18_n969ConConveAux = new boolean[] {false} ;
      BC000A18_A970ConClasifAux = new String[] {""} ;
      BC000A18_n970ConClasifAux = new boolean[] {false} ;
      BC000A18_A510ConOrdEjec = new long[1] ;
      BC000A18_A569ConFormulaExpl = new String[] {""} ;
      BC000A18_A720ConFormulaObs2 = new String[] {""} ;
      BC000A18_A734ConRetGanPropor = new boolean[] {false} ;
      BC000A18_A735ConAplicGan = new byte[1] ;
      BC000A18_n735ConAplicGan = new boolean[] {false} ;
      BC000A18_A762ConRecalcular = new boolean[] {false} ;
      BC000A18_A894ConImportado = new boolean[] {false} ;
      BC000A18_A895ConTipoOrden = new short[1] ;
      BC000A18_A1017ConEdiEnRec = new boolean[] {false} ;
      BC000A18_A1018ConRangoCant = new String[] {""} ;
      BC000A18_A922ConUsado = new boolean[] {false} ;
      BC000A18_A951ConObliga = new boolean[] {false} ;
      BC000A18_n951ConObliga = new boolean[] {false} ;
      BC000A18_A952ConObligaSiSac = new boolean[] {false} ;
      BC000A18_n952ConObligaSiSac = new boolean[] {false} ;
      BC000A18_A954ConCondCodigo = new String[] {""} ;
      BC000A18_A1066ConPreReq = new String[] {""} ;
      BC000A18_n1066ConPreReq = new boolean[] {false} ;
      BC000A18_A1068ConMostrarPos = new boolean[] {false} ;
      BC000A18_A1077ConAdelDescu = new byte[1] ;
      BC000A18_n1077ConAdelDescu = new boolean[] {false} ;
      BC000A18_A1194ConSegunPla = new boolean[] {false} ;
      BC000A18_A1471ConNumero = new byte[1] ;
      BC000A18_A1472ConSIPAApo = new byte[1] ;
      BC000A18_A1473ConSIPACont = new byte[1] ;
      BC000A18_A1474ConINSSJyPApo = new byte[1] ;
      BC000A18_A1475ConINSSJyPCont = new byte[1] ;
      BC000A18_A1476ConObraSocApo = new byte[1] ;
      BC000A18_A1477ConObraSocCont = new byte[1] ;
      BC000A18_A1478ConFonSolRedApo = new byte[1] ;
      BC000A18_A1479ConFonSolRedCont = new byte[1] ;
      BC000A18_A1480ConRenateaApo = new byte[1] ;
      BC000A18_A1481ConRenateaCont = new byte[1] ;
      BC000A18_A1482ConAsigFamCont = new byte[1] ;
      BC000A18_A1483ConFonNacEmpCont = new byte[1] ;
      BC000A18_A1484ConLeyRieTrabCont = new byte[1] ;
      BC000A18_A1485ConRegDifApo = new byte[1] ;
      BC000A18_A1486ConRegEspApo = new byte[1] ;
      BC000A18_A1539ConSacDeven = new byte[1] ;
      BC000A18_A1620ConBaseLic = new byte[1] ;
      BC000A18_A1797ConBaseLicProm = new byte[1] ;
      BC000A18_A1621ConBaseFer = new byte[1] ;
      BC000A18_A1798ConBaseFerProm = new byte[1] ;
      BC000A18_A1622ConBaseHorExt = new byte[1] ;
      BC000A18_A1799ConBaseHorExtProm = new byte[1] ;
      BC000A18_A1800ConBasePres = new byte[1] ;
      BC000A18_A1801ConBaseAnt = new byte[1] ;
      BC000A18_A1827ConBaseOSDif = new byte[1] ;
      BC000A18_A2191ConBaseAus = new byte[1] ;
      BC000A18_A2192ConBaseAusProm = new byte[1] ;
      BC000A18_A1648ConCodAfip = new String[] {""} ;
      BC000A18_A1769ConCntPa = new byte[1] ;
      BC000A18_A1821ConErrorSiCero = new boolean[] {false} ;
      BC000A18_A1826ConPueNov = new boolean[] {false} ;
      BC000A18_A1886ConRelSec = new int[1] ;
      BC000A18_A2013ConRelRef = new String[] {""} ;
      BC000A18_A2185ConDescripSinAc = new String[] {""} ;
      BC000A18_A2187ConOblPalabra = new String[] {""} ;
      BC000A18_n2187ConOblPalabra = new boolean[] {false} ;
      BC000A18_A1822CliPadre = new int[1] ;
      BC000A18_n1822CliPadre = new boolean[] {false} ;
      BC000A18_A3CliCod = new int[1] ;
      BC000A18_A1112AplIIGG = new short[1] ;
      BC000A18_n1112AplIIGG = new boolean[] {false} ;
      BC000A18_A37TipoConCod = new String[] {""} ;
      BC000A18_A38SubTipoConCod1 = new String[] {""} ;
      BC000A18_n38SubTipoConCod1 = new boolean[] {false} ;
      BC000A18_A39SubTipoConCod2 = new String[] {""} ;
      BC000A18_n39SubTipoConCod2 = new boolean[] {false} ;
      BC000A18_A953ConCondicion = new String[] {""} ;
      BC000A18_n953ConCondicion = new boolean[] {false} ;
      BC000A18_A1644ConceptoPais = new short[1] ;
      BC000A18_n1644ConceptoPais = new boolean[] {false} ;
      BC000A18_A1645ConceptoConveCodigo = new String[] {""} ;
      BC000A18_n1645ConceptoConveCodigo = new boolean[] {false} ;
      BC000A18_A921ConPadre = new String[] {""} ;
      BC000A18_n921ConPadre = new boolean[] {false} ;
      O41ConDescrip = "" ;
      BC000A19_A3CliCod = new int[1] ;
      BC000A20_A37TipoConCod = new String[] {""} ;
      BC000A21_A37TipoConCod = new String[] {""} ;
      BC000A22_A37TipoConCod = new String[] {""} ;
      BC000A23_A953ConCondicion = new String[] {""} ;
      BC000A23_n953ConCondicion = new boolean[] {false} ;
      BC000A24_A3CliCod = new int[1] ;
      BC000A25_A1644ConceptoPais = new short[1] ;
      BC000A25_n1644ConceptoPais = new boolean[] {false} ;
      BC000A26_A1822CliPadre = new int[1] ;
      BC000A26_n1822CliPadre = new boolean[] {false} ;
      BC000A27_A3CliCod = new int[1] ;
      BC000A27_A26ConCodigo = new String[] {""} ;
      BC000A28_A42ConCodYDesc = new String[] {""} ;
      BC000A28_n42ConCodYDesc = new boolean[] {false} ;
      BC000A28_A26ConCodigo = new String[] {""} ;
      BC000A28_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A28_n145ConFchModFor = new boolean[] {false} ;
      BC000A28_A156ConUsuModFor = new String[] {""} ;
      BC000A28_n156ConUsuModFor = new boolean[] {false} ;
      BC000A28_A143ConCanti = new boolean[] {false} ;
      BC000A28_A158ConValUni = new boolean[] {false} ;
      BC000A28_A152ConImporte = new boolean[] {false} ;
      BC000A28_A159ConVariable = new boolean[] {false} ;
      BC000A28_A1905ConRelSecCli = new int[1] ;
      BC000A28_A1974ConOldValues = new String[] {""} ;
      BC000A28_A41ConDescrip = new String[] {""} ;
      BC000A28_A150ConHabilitado = new boolean[] {false} ;
      BC000A28_A40ConOrden = new int[1] ;
      BC000A28_A162ConVigencia = new byte[1] ;
      BC000A28_A1488ConLiqBasica = new byte[1] ;
      BC000A28_A148ConFormula = new String[] {""} ;
      BC000A28_n148ConFormula = new boolean[] {false} ;
      BC000A28_A729ConFormulaPreResuelta = new String[] {""} ;
      BC000A28_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A28_n157ConValorGen = new boolean[] {false} ;
      BC000A28_A155ConTipoLiqGanancias = new String[] {""} ;
      BC000A28_n155ConTipoLiqGanancias = new boolean[] {false} ;
      BC000A28_A153ConObservacion = new String[] {""} ;
      BC000A28_A151ConHisFormula = new String[] {""} ;
      BC000A28_n151ConHisFormula = new boolean[] {false} ;
      BC000A28_A154ConTipo = new byte[1] ;
      BC000A28_A469ConCodOld = new String[] {""} ;
      BC000A28_A487ConCuenDebe = new String[] {""} ;
      BC000A28_n487ConCuenDebe = new boolean[] {false} ;
      BC000A28_A488ConCuenHaber = new String[] {""} ;
      BC000A28_n488ConCuenHaber = new boolean[] {false} ;
      BC000A28_A503ConTipoLiqAux = new String[] {""} ;
      BC000A28_n503ConTipoLiqAux = new boolean[] {false} ;
      BC000A28_A969ConConveAux = new String[] {""} ;
      BC000A28_n969ConConveAux = new boolean[] {false} ;
      BC000A28_A970ConClasifAux = new String[] {""} ;
      BC000A28_n970ConClasifAux = new boolean[] {false} ;
      BC000A28_A510ConOrdEjec = new long[1] ;
      BC000A28_A569ConFormulaExpl = new String[] {""} ;
      BC000A28_A720ConFormulaObs2 = new String[] {""} ;
      BC000A28_A734ConRetGanPropor = new boolean[] {false} ;
      BC000A28_A735ConAplicGan = new byte[1] ;
      BC000A28_n735ConAplicGan = new boolean[] {false} ;
      BC000A28_A762ConRecalcular = new boolean[] {false} ;
      BC000A28_A894ConImportado = new boolean[] {false} ;
      BC000A28_A895ConTipoOrden = new short[1] ;
      BC000A28_A1017ConEdiEnRec = new boolean[] {false} ;
      BC000A28_A1018ConRangoCant = new String[] {""} ;
      BC000A28_A922ConUsado = new boolean[] {false} ;
      BC000A28_A951ConObliga = new boolean[] {false} ;
      BC000A28_n951ConObliga = new boolean[] {false} ;
      BC000A28_A952ConObligaSiSac = new boolean[] {false} ;
      BC000A28_n952ConObligaSiSac = new boolean[] {false} ;
      BC000A28_A954ConCondCodigo = new String[] {""} ;
      BC000A28_A1066ConPreReq = new String[] {""} ;
      BC000A28_n1066ConPreReq = new boolean[] {false} ;
      BC000A28_A1068ConMostrarPos = new boolean[] {false} ;
      BC000A28_A1077ConAdelDescu = new byte[1] ;
      BC000A28_n1077ConAdelDescu = new boolean[] {false} ;
      BC000A28_A1194ConSegunPla = new boolean[] {false} ;
      BC000A28_A1471ConNumero = new byte[1] ;
      BC000A28_A1472ConSIPAApo = new byte[1] ;
      BC000A28_A1473ConSIPACont = new byte[1] ;
      BC000A28_A1474ConINSSJyPApo = new byte[1] ;
      BC000A28_A1475ConINSSJyPCont = new byte[1] ;
      BC000A28_A1476ConObraSocApo = new byte[1] ;
      BC000A28_A1477ConObraSocCont = new byte[1] ;
      BC000A28_A1478ConFonSolRedApo = new byte[1] ;
      BC000A28_A1479ConFonSolRedCont = new byte[1] ;
      BC000A28_A1480ConRenateaApo = new byte[1] ;
      BC000A28_A1481ConRenateaCont = new byte[1] ;
      BC000A28_A1482ConAsigFamCont = new byte[1] ;
      BC000A28_A1483ConFonNacEmpCont = new byte[1] ;
      BC000A28_A1484ConLeyRieTrabCont = new byte[1] ;
      BC000A28_A1485ConRegDifApo = new byte[1] ;
      BC000A28_A1486ConRegEspApo = new byte[1] ;
      BC000A28_A1539ConSacDeven = new byte[1] ;
      BC000A28_A1620ConBaseLic = new byte[1] ;
      BC000A28_A1797ConBaseLicProm = new byte[1] ;
      BC000A28_A1621ConBaseFer = new byte[1] ;
      BC000A28_A1798ConBaseFerProm = new byte[1] ;
      BC000A28_A1622ConBaseHorExt = new byte[1] ;
      BC000A28_A1799ConBaseHorExtProm = new byte[1] ;
      BC000A28_A1800ConBasePres = new byte[1] ;
      BC000A28_A1801ConBaseAnt = new byte[1] ;
      BC000A28_A1827ConBaseOSDif = new byte[1] ;
      BC000A28_A2191ConBaseAus = new byte[1] ;
      BC000A28_A2192ConBaseAusProm = new byte[1] ;
      BC000A28_A1648ConCodAfip = new String[] {""} ;
      BC000A28_A1769ConCntPa = new byte[1] ;
      BC000A28_A1821ConErrorSiCero = new boolean[] {false} ;
      BC000A28_A1826ConPueNov = new boolean[] {false} ;
      BC000A28_A1886ConRelSec = new int[1] ;
      BC000A28_A2013ConRelRef = new String[] {""} ;
      BC000A28_A2185ConDescripSinAc = new String[] {""} ;
      BC000A28_A2187ConOblPalabra = new String[] {""} ;
      BC000A28_n2187ConOblPalabra = new boolean[] {false} ;
      BC000A28_A1822CliPadre = new int[1] ;
      BC000A28_n1822CliPadre = new boolean[] {false} ;
      BC000A28_A3CliCod = new int[1] ;
      BC000A28_A1112AplIIGG = new short[1] ;
      BC000A28_n1112AplIIGG = new boolean[] {false} ;
      BC000A28_A37TipoConCod = new String[] {""} ;
      BC000A28_A38SubTipoConCod1 = new String[] {""} ;
      BC000A28_n38SubTipoConCod1 = new boolean[] {false} ;
      BC000A28_A39SubTipoConCod2 = new String[] {""} ;
      BC000A28_n39SubTipoConCod2 = new boolean[] {false} ;
      BC000A28_A953ConCondicion = new String[] {""} ;
      BC000A28_n953ConCondicion = new boolean[] {false} ;
      BC000A28_A1644ConceptoPais = new short[1] ;
      BC000A28_n1644ConceptoPais = new boolean[] {false} ;
      BC000A28_A1645ConceptoConveCodigo = new String[] {""} ;
      BC000A28_n1645ConceptoConveCodigo = new boolean[] {false} ;
      BC000A28_A921ConPadre = new String[] {""} ;
      BC000A28_n921ConPadre = new boolean[] {false} ;
      BC000A29_A42ConCodYDesc = new String[] {""} ;
      BC000A29_n42ConCodYDesc = new boolean[] {false} ;
      BC000A29_A26ConCodigo = new String[] {""} ;
      BC000A29_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A29_n145ConFchModFor = new boolean[] {false} ;
      BC000A29_A156ConUsuModFor = new String[] {""} ;
      BC000A29_n156ConUsuModFor = new boolean[] {false} ;
      BC000A29_A143ConCanti = new boolean[] {false} ;
      BC000A29_A158ConValUni = new boolean[] {false} ;
      BC000A29_A152ConImporte = new boolean[] {false} ;
      BC000A29_A159ConVariable = new boolean[] {false} ;
      BC000A29_A1905ConRelSecCli = new int[1] ;
      BC000A29_A1974ConOldValues = new String[] {""} ;
      BC000A29_A41ConDescrip = new String[] {""} ;
      BC000A29_A150ConHabilitado = new boolean[] {false} ;
      BC000A29_A40ConOrden = new int[1] ;
      BC000A29_A162ConVigencia = new byte[1] ;
      BC000A29_A1488ConLiqBasica = new byte[1] ;
      BC000A29_A148ConFormula = new String[] {""} ;
      BC000A29_n148ConFormula = new boolean[] {false} ;
      BC000A29_A729ConFormulaPreResuelta = new String[] {""} ;
      BC000A29_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A29_n157ConValorGen = new boolean[] {false} ;
      BC000A29_A155ConTipoLiqGanancias = new String[] {""} ;
      BC000A29_n155ConTipoLiqGanancias = new boolean[] {false} ;
      BC000A29_A153ConObservacion = new String[] {""} ;
      BC000A29_A151ConHisFormula = new String[] {""} ;
      BC000A29_n151ConHisFormula = new boolean[] {false} ;
      BC000A29_A154ConTipo = new byte[1] ;
      BC000A29_A469ConCodOld = new String[] {""} ;
      BC000A29_A487ConCuenDebe = new String[] {""} ;
      BC000A29_n487ConCuenDebe = new boolean[] {false} ;
      BC000A29_A488ConCuenHaber = new String[] {""} ;
      BC000A29_n488ConCuenHaber = new boolean[] {false} ;
      BC000A29_A503ConTipoLiqAux = new String[] {""} ;
      BC000A29_n503ConTipoLiqAux = new boolean[] {false} ;
      BC000A29_A969ConConveAux = new String[] {""} ;
      BC000A29_n969ConConveAux = new boolean[] {false} ;
      BC000A29_A970ConClasifAux = new String[] {""} ;
      BC000A29_n970ConClasifAux = new boolean[] {false} ;
      BC000A29_A510ConOrdEjec = new long[1] ;
      BC000A29_A569ConFormulaExpl = new String[] {""} ;
      BC000A29_A720ConFormulaObs2 = new String[] {""} ;
      BC000A29_A734ConRetGanPropor = new boolean[] {false} ;
      BC000A29_A735ConAplicGan = new byte[1] ;
      BC000A29_n735ConAplicGan = new boolean[] {false} ;
      BC000A29_A762ConRecalcular = new boolean[] {false} ;
      BC000A29_A894ConImportado = new boolean[] {false} ;
      BC000A29_A895ConTipoOrden = new short[1] ;
      BC000A29_A1017ConEdiEnRec = new boolean[] {false} ;
      BC000A29_A1018ConRangoCant = new String[] {""} ;
      BC000A29_A922ConUsado = new boolean[] {false} ;
      BC000A29_A951ConObliga = new boolean[] {false} ;
      BC000A29_n951ConObliga = new boolean[] {false} ;
      BC000A29_A952ConObligaSiSac = new boolean[] {false} ;
      BC000A29_n952ConObligaSiSac = new boolean[] {false} ;
      BC000A29_A954ConCondCodigo = new String[] {""} ;
      BC000A29_A1066ConPreReq = new String[] {""} ;
      BC000A29_n1066ConPreReq = new boolean[] {false} ;
      BC000A29_A1068ConMostrarPos = new boolean[] {false} ;
      BC000A29_A1077ConAdelDescu = new byte[1] ;
      BC000A29_n1077ConAdelDescu = new boolean[] {false} ;
      BC000A29_A1194ConSegunPla = new boolean[] {false} ;
      BC000A29_A1471ConNumero = new byte[1] ;
      BC000A29_A1472ConSIPAApo = new byte[1] ;
      BC000A29_A1473ConSIPACont = new byte[1] ;
      BC000A29_A1474ConINSSJyPApo = new byte[1] ;
      BC000A29_A1475ConINSSJyPCont = new byte[1] ;
      BC000A29_A1476ConObraSocApo = new byte[1] ;
      BC000A29_A1477ConObraSocCont = new byte[1] ;
      BC000A29_A1478ConFonSolRedApo = new byte[1] ;
      BC000A29_A1479ConFonSolRedCont = new byte[1] ;
      BC000A29_A1480ConRenateaApo = new byte[1] ;
      BC000A29_A1481ConRenateaCont = new byte[1] ;
      BC000A29_A1482ConAsigFamCont = new byte[1] ;
      BC000A29_A1483ConFonNacEmpCont = new byte[1] ;
      BC000A29_A1484ConLeyRieTrabCont = new byte[1] ;
      BC000A29_A1485ConRegDifApo = new byte[1] ;
      BC000A29_A1486ConRegEspApo = new byte[1] ;
      BC000A29_A1539ConSacDeven = new byte[1] ;
      BC000A29_A1620ConBaseLic = new byte[1] ;
      BC000A29_A1797ConBaseLicProm = new byte[1] ;
      BC000A29_A1621ConBaseFer = new byte[1] ;
      BC000A29_A1798ConBaseFerProm = new byte[1] ;
      BC000A29_A1622ConBaseHorExt = new byte[1] ;
      BC000A29_A1799ConBaseHorExtProm = new byte[1] ;
      BC000A29_A1800ConBasePres = new byte[1] ;
      BC000A29_A1801ConBaseAnt = new byte[1] ;
      BC000A29_A1827ConBaseOSDif = new byte[1] ;
      BC000A29_A2191ConBaseAus = new byte[1] ;
      BC000A29_A2192ConBaseAusProm = new byte[1] ;
      BC000A29_A1648ConCodAfip = new String[] {""} ;
      BC000A29_A1769ConCntPa = new byte[1] ;
      BC000A29_A1821ConErrorSiCero = new boolean[] {false} ;
      BC000A29_A1826ConPueNov = new boolean[] {false} ;
      BC000A29_A1886ConRelSec = new int[1] ;
      BC000A29_A2013ConRelRef = new String[] {""} ;
      BC000A29_A2185ConDescripSinAc = new String[] {""} ;
      BC000A29_A2187ConOblPalabra = new String[] {""} ;
      BC000A29_n2187ConOblPalabra = new boolean[] {false} ;
      BC000A29_A1822CliPadre = new int[1] ;
      BC000A29_n1822CliPadre = new boolean[] {false} ;
      BC000A29_A3CliCod = new int[1] ;
      BC000A29_A1112AplIIGG = new short[1] ;
      BC000A29_n1112AplIIGG = new boolean[] {false} ;
      BC000A29_A37TipoConCod = new String[] {""} ;
      BC000A29_A38SubTipoConCod1 = new String[] {""} ;
      BC000A29_n38SubTipoConCod1 = new boolean[] {false} ;
      BC000A29_A39SubTipoConCod2 = new String[] {""} ;
      BC000A29_n39SubTipoConCod2 = new boolean[] {false} ;
      BC000A29_A953ConCondicion = new String[] {""} ;
      BC000A29_n953ConCondicion = new boolean[] {false} ;
      BC000A29_A1644ConceptoPais = new short[1] ;
      BC000A29_n1644ConceptoPais = new boolean[] {false} ;
      BC000A29_A1645ConceptoConveCodigo = new String[] {""} ;
      BC000A29_n1645ConceptoConveCodigo = new boolean[] {false} ;
      BC000A29_A921ConPadre = new String[] {""} ;
      BC000A29_n921ConPadre = new boolean[] {false} ;
      BC000A33_A1822CliPadre = new int[1] ;
      BC000A33_n1822CliPadre = new boolean[] {false} ;
      BC000A33_A921ConPadre = new String[] {""} ;
      BC000A33_n921ConPadre = new boolean[] {false} ;
      BC000A34_A46PaiCod = new short[1] ;
      BC000A34_A1440PaiBaseClaseLeg = new byte[1] ;
      BC000A34_A1441PaiBaseTipo = new String[] {""} ;
      BC000A34_A1442PaiBaseCod1 = new String[] {""} ;
      BC000A34_A1443PaiBaseCod2 = new String[] {""} ;
      BC000A34_A1445PaiBaseCliCod = new int[1] ;
      BC000A34_A1446PaiBaseConCodigo = new String[] {""} ;
      BC000A35_A46PaiCod = new short[1] ;
      BC000A35_A1356PaiMenCliCod = new int[1] ;
      BC000A35_A1358PaiMesConCodigo = new String[] {""} ;
      BC000A36_A46PaiCod = new short[1] ;
      BC000A36_A1354PaiJorCliCod = new int[1] ;
      BC000A36_A1355PaiJorConCodigo = new String[] {""} ;
      BC000A37_A3CliCod = new int[1] ;
      BC000A37_A1EmpCod = new short[1] ;
      BC000A37_A6LegNumero = new int[1] ;
      BC000A37_A1135LegSuelSec = new short[1] ;
      BC000A37_A2349LegSuelConcepto = new String[] {""} ;
      BC000A38_A3CliCod = new int[1] ;
      BC000A38_A26ConCodigo = new String[] {""} ;
      BC000A38_A2119ConOpeId = new String[] {""} ;
      BC000A38_A923ConOperFor = new String[] {""} ;
      BC000A39_A3CliCod = new int[1] ;
      BC000A39_A1EmpCod = new short[1] ;
      BC000A39_A6LegNumero = new int[1] ;
      BC000A39_A1829PreliqTLiqCod = new String[] {""} ;
      BC000A39_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A39_A1831PreliqConcepto = new String[] {""} ;
      BC000A40_A3CliCod = new int[1] ;
      BC000A40_A1564CliPaiConve = new short[1] ;
      BC000A40_A1565CliConvenio = new String[] {""} ;
      BC000A40_A1327ConveHsExSec = new short[1] ;
      BC000A41_A3CliCod = new int[1] ;
      BC000A41_A1564CliPaiConve = new short[1] ;
      BC000A41_A1565CliConvenio = new String[] {""} ;
      BC000A41_A1381ConveMenCliCod = new int[1] ;
      BC000A41_A1375ConveMenConCodigo = new String[] {""} ;
      BC000A42_A3CliCod = new int[1] ;
      BC000A42_A1EmpCod = new short[1] ;
      BC000A42_A31LiqNro = new int[1] ;
      BC000A42_A6LegNumero = new int[1] ;
      BC000A42_A1541LiqAjuNro = new short[1] ;
      BC000A42_A1543LiqAjuSec = new short[1] ;
      BC000A43_A3CliCod = new int[1] ;
      BC000A43_A1EmpCod = new short[1] ;
      BC000A43_A1366EmpJorConCodigo = new String[] {""} ;
      BC000A44_A3CliCod = new int[1] ;
      BC000A44_A1EmpCod = new short[1] ;
      BC000A44_A1368EmpMenConCodigo = new String[] {""} ;
      BC000A45_A3CliCod = new int[1] ;
      BC000A45_A1EmpCod = new short[1] ;
      BC000A45_A6LegNumero = new int[1] ;
      BC000A45_A1172OblSecuencial = new short[1] ;
      BC000A45_A1170OblExcConCOdigo = new String[] {""} ;
      BC000A46_A3CliCod = new int[1] ;
      BC000A46_A1EmpCod = new short[1] ;
      BC000A46_A6LegNumero = new int[1] ;
      BC000A46_A1172OblSecuencial = new short[1] ;
      BC000A47_A3CliCod = new int[1] ;
      BC000A47_A1EmpCod = new short[1] ;
      BC000A47_A6LegNumero = new int[1] ;
      BC000A47_A1172OblSecuencial = new short[1] ;
      BC000A48_A3CliCod = new int[1] ;
      BC000A48_A1EmpCod = new short[1] ;
      BC000A48_A1129LiqExAnio = new short[1] ;
      BC000A48_A31LiqNro = new int[1] ;
      BC000A48_A6LegNumero = new int[1] ;
      BC000A48_A1127LiqExenConCodigo = new String[] {""} ;
      BC000A48_A1128LiqExAplIIGG = new short[1] ;
      BC000A49_A3CliCod = new int[1] ;
      BC000A49_A1112AplIIGG = new short[1] ;
      BC000A49_n1112AplIIGG = new boolean[] {false} ;
      BC000A50_A3CliCod = new int[1] ;
      BC000A50_A1112AplIIGG = new short[1] ;
      BC000A50_n1112AplIIGG = new boolean[] {false} ;
      BC000A51_A3CliCod = new int[1] ;
      BC000A51_A1112AplIIGG = new short[1] ;
      BC000A51_n1112AplIIGG = new boolean[] {false} ;
      BC000A52_A3CliCod = new int[1] ;
      BC000A52_A1105CondExenIIGG = new String[] {""} ;
      BC000A53_A3CliCod = new int[1] ;
      BC000A53_A1101SiraTipo = new String[] {""} ;
      BC000A53_A1102SiraCodigo = new String[] {""} ;
      BC000A54_A3CliCod = new int[1] ;
      BC000A54_A1EmpCod = new short[1] ;
      BC000A54_A869LiqLegConAnio = new short[1] ;
      BC000A54_A6LegNumero = new int[1] ;
      BC000A54_A26ConCodigo = new String[] {""} ;
      BC000A54_A1097LiqAltaNro = new int[1] ;
      BC000A54_A1098LiqNuevaNro = new int[1] ;
      BC000A55_A3CliCod = new int[1] ;
      BC000A55_A1EmpCod = new short[1] ;
      BC000A55_A6LegNumero = new int[1] ;
      BC000A55_A83LegDedSec = new int[1] ;
      BC000A56_A3CliCod = new int[1] ;
      BC000A56_A26ConCodigo = new String[] {""} ;
      BC000A56_A51ForHisNum = new short[1] ;
      BC000A57_A3CliCod = new int[1] ;
      BC000A57_A1EmpCod = new short[1] ;
      BC000A57_A6LegNumero = new int[1] ;
      BC000A57_A25AgeOrden = new short[1] ;
      BC000A58_A42ConCodYDesc = new String[] {""} ;
      BC000A58_n42ConCodYDesc = new boolean[] {false} ;
      BC000A58_A26ConCodigo = new String[] {""} ;
      BC000A58_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A58_n145ConFchModFor = new boolean[] {false} ;
      BC000A58_A156ConUsuModFor = new String[] {""} ;
      BC000A58_n156ConUsuModFor = new boolean[] {false} ;
      BC000A58_A143ConCanti = new boolean[] {false} ;
      BC000A58_A158ConValUni = new boolean[] {false} ;
      BC000A58_A152ConImporte = new boolean[] {false} ;
      BC000A58_A159ConVariable = new boolean[] {false} ;
      BC000A58_A1905ConRelSecCli = new int[1] ;
      BC000A58_A1974ConOldValues = new String[] {""} ;
      BC000A58_A41ConDescrip = new String[] {""} ;
      BC000A58_A150ConHabilitado = new boolean[] {false} ;
      BC000A58_A40ConOrden = new int[1] ;
      BC000A58_A162ConVigencia = new byte[1] ;
      BC000A58_A1488ConLiqBasica = new byte[1] ;
      BC000A58_A148ConFormula = new String[] {""} ;
      BC000A58_n148ConFormula = new boolean[] {false} ;
      BC000A58_A729ConFormulaPreResuelta = new String[] {""} ;
      BC000A58_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A58_n157ConValorGen = new boolean[] {false} ;
      BC000A58_A155ConTipoLiqGanancias = new String[] {""} ;
      BC000A58_n155ConTipoLiqGanancias = new boolean[] {false} ;
      BC000A58_A153ConObservacion = new String[] {""} ;
      BC000A58_A151ConHisFormula = new String[] {""} ;
      BC000A58_n151ConHisFormula = new boolean[] {false} ;
      BC000A58_A154ConTipo = new byte[1] ;
      BC000A58_A469ConCodOld = new String[] {""} ;
      BC000A58_A487ConCuenDebe = new String[] {""} ;
      BC000A58_n487ConCuenDebe = new boolean[] {false} ;
      BC000A58_A488ConCuenHaber = new String[] {""} ;
      BC000A58_n488ConCuenHaber = new boolean[] {false} ;
      BC000A58_A503ConTipoLiqAux = new String[] {""} ;
      BC000A58_n503ConTipoLiqAux = new boolean[] {false} ;
      BC000A58_A969ConConveAux = new String[] {""} ;
      BC000A58_n969ConConveAux = new boolean[] {false} ;
      BC000A58_A970ConClasifAux = new String[] {""} ;
      BC000A58_n970ConClasifAux = new boolean[] {false} ;
      BC000A58_A510ConOrdEjec = new long[1] ;
      BC000A58_A569ConFormulaExpl = new String[] {""} ;
      BC000A58_A720ConFormulaObs2 = new String[] {""} ;
      BC000A58_A734ConRetGanPropor = new boolean[] {false} ;
      BC000A58_A735ConAplicGan = new byte[1] ;
      BC000A58_n735ConAplicGan = new boolean[] {false} ;
      BC000A58_A762ConRecalcular = new boolean[] {false} ;
      BC000A58_A894ConImportado = new boolean[] {false} ;
      BC000A58_A895ConTipoOrden = new short[1] ;
      BC000A58_A1017ConEdiEnRec = new boolean[] {false} ;
      BC000A58_A1018ConRangoCant = new String[] {""} ;
      BC000A58_A922ConUsado = new boolean[] {false} ;
      BC000A58_A951ConObliga = new boolean[] {false} ;
      BC000A58_n951ConObliga = new boolean[] {false} ;
      BC000A58_A952ConObligaSiSac = new boolean[] {false} ;
      BC000A58_n952ConObligaSiSac = new boolean[] {false} ;
      BC000A58_A954ConCondCodigo = new String[] {""} ;
      BC000A58_A1066ConPreReq = new String[] {""} ;
      BC000A58_n1066ConPreReq = new boolean[] {false} ;
      BC000A58_A1068ConMostrarPos = new boolean[] {false} ;
      BC000A58_A1077ConAdelDescu = new byte[1] ;
      BC000A58_n1077ConAdelDescu = new boolean[] {false} ;
      BC000A58_A1194ConSegunPla = new boolean[] {false} ;
      BC000A58_A1471ConNumero = new byte[1] ;
      BC000A58_A1472ConSIPAApo = new byte[1] ;
      BC000A58_A1473ConSIPACont = new byte[1] ;
      BC000A58_A1474ConINSSJyPApo = new byte[1] ;
      BC000A58_A1475ConINSSJyPCont = new byte[1] ;
      BC000A58_A1476ConObraSocApo = new byte[1] ;
      BC000A58_A1477ConObraSocCont = new byte[1] ;
      BC000A58_A1478ConFonSolRedApo = new byte[1] ;
      BC000A58_A1479ConFonSolRedCont = new byte[1] ;
      BC000A58_A1480ConRenateaApo = new byte[1] ;
      BC000A58_A1481ConRenateaCont = new byte[1] ;
      BC000A58_A1482ConAsigFamCont = new byte[1] ;
      BC000A58_A1483ConFonNacEmpCont = new byte[1] ;
      BC000A58_A1484ConLeyRieTrabCont = new byte[1] ;
      BC000A58_A1485ConRegDifApo = new byte[1] ;
      BC000A58_A1486ConRegEspApo = new byte[1] ;
      BC000A58_A1539ConSacDeven = new byte[1] ;
      BC000A58_A1620ConBaseLic = new byte[1] ;
      BC000A58_A1797ConBaseLicProm = new byte[1] ;
      BC000A58_A1621ConBaseFer = new byte[1] ;
      BC000A58_A1798ConBaseFerProm = new byte[1] ;
      BC000A58_A1622ConBaseHorExt = new byte[1] ;
      BC000A58_A1799ConBaseHorExtProm = new byte[1] ;
      BC000A58_A1800ConBasePres = new byte[1] ;
      BC000A58_A1801ConBaseAnt = new byte[1] ;
      BC000A58_A1827ConBaseOSDif = new byte[1] ;
      BC000A58_A2191ConBaseAus = new byte[1] ;
      BC000A58_A2192ConBaseAusProm = new byte[1] ;
      BC000A58_A1648ConCodAfip = new String[] {""} ;
      BC000A58_A1769ConCntPa = new byte[1] ;
      BC000A58_A1821ConErrorSiCero = new boolean[] {false} ;
      BC000A58_A1826ConPueNov = new boolean[] {false} ;
      BC000A58_A1886ConRelSec = new int[1] ;
      BC000A58_A2013ConRelRef = new String[] {""} ;
      BC000A58_A2185ConDescripSinAc = new String[] {""} ;
      BC000A58_A2187ConOblPalabra = new String[] {""} ;
      BC000A58_n2187ConOblPalabra = new boolean[] {false} ;
      BC000A58_A1822CliPadre = new int[1] ;
      BC000A58_n1822CliPadre = new boolean[] {false} ;
      BC000A58_A3CliCod = new int[1] ;
      BC000A58_A1112AplIIGG = new short[1] ;
      BC000A58_n1112AplIIGG = new boolean[] {false} ;
      BC000A58_A37TipoConCod = new String[] {""} ;
      BC000A58_A38SubTipoConCod1 = new String[] {""} ;
      BC000A58_n38SubTipoConCod1 = new boolean[] {false} ;
      BC000A58_A39SubTipoConCod2 = new String[] {""} ;
      BC000A58_n39SubTipoConCod2 = new boolean[] {false} ;
      BC000A58_A953ConCondicion = new String[] {""} ;
      BC000A58_n953ConCondicion = new boolean[] {false} ;
      BC000A58_A1644ConceptoPais = new short[1] ;
      BC000A58_n1644ConceptoPais = new boolean[] {false} ;
      BC000A58_A1645ConceptoConveCodigo = new String[] {""} ;
      BC000A58_n1645ConceptoConveCodigo = new boolean[] {false} ;
      BC000A58_A921ConPadre = new String[] {""} ;
      BC000A58_n921ConPadre = new boolean[] {false} ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXt_dtime10 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime11 = new java.util.Date[1] ;
      Z950ConTLTipEgr = "" ;
      A950ConTLTipEgr = "" ;
      Z1410ConTLCondicion = "" ;
      A1410ConTLCondicion = "" ;
      Z1788ConTLTipoCon = "" ;
      A1788ConTLTipoCon = "" ;
      Z340TliqDesc = "" ;
      A340TliqDesc = "" ;
      Z32TLiqCod = "" ;
      A32TLiqCod = "" ;
      BC000A59_A26ConCodigo = new String[] {""} ;
      BC000A59_A340TliqDesc = new String[] {""} ;
      BC000A59_A925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A59_n925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A59_A926ConTLiqSinPre = new boolean[] {false} ;
      BC000A59_n926ConTLiqSinPre = new boolean[] {false} ;
      BC000A59_A950ConTLTipEgr = new String[] {""} ;
      BC000A59_A1406ConTLOrdejec = new long[1] ;
      BC000A59_A1407ConTLConOrd = new short[1] ;
      BC000A59_A1409ConTLVigencia = new byte[1] ;
      BC000A59_n1409ConTLVigencia = new boolean[] {false} ;
      BC000A59_A1410ConTLCondicion = new String[] {""} ;
      BC000A59_n1410ConTLCondicion = new boolean[] {false} ;
      BC000A59_A1470ConTLConHab = new byte[1] ;
      BC000A59_A1788ConTLTipoCon = new String[] {""} ;
      BC000A59_n1788ConTLTipoCon = new boolean[] {false} ;
      BC000A59_A1789CONTLSegPla = new byte[1] ;
      BC000A59_n1789CONTLSegPla = new boolean[] {false} ;
      BC000A59_A3CliCod = new int[1] ;
      BC000A59_A32TLiqCod = new String[] {""} ;
      BC000A60_A340TliqDesc = new String[] {""} ;
      BC000A61_A3CliCod = new int[1] ;
      BC000A61_A26ConCodigo = new String[] {""} ;
      BC000A61_A32TLiqCod = new String[] {""} ;
      BC000A62_A26ConCodigo = new String[] {""} ;
      BC000A62_A925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A62_n925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A62_A926ConTLiqSinPre = new boolean[] {false} ;
      BC000A62_n926ConTLiqSinPre = new boolean[] {false} ;
      BC000A62_A950ConTLTipEgr = new String[] {""} ;
      BC000A62_A1406ConTLOrdejec = new long[1] ;
      BC000A62_A1407ConTLConOrd = new short[1] ;
      BC000A62_A1409ConTLVigencia = new byte[1] ;
      BC000A62_n1409ConTLVigencia = new boolean[] {false} ;
      BC000A62_A1410ConTLCondicion = new String[] {""} ;
      BC000A62_n1410ConTLCondicion = new boolean[] {false} ;
      BC000A62_A1470ConTLConHab = new byte[1] ;
      BC000A62_A1788ConTLTipoCon = new String[] {""} ;
      BC000A62_n1788ConTLTipoCon = new boolean[] {false} ;
      BC000A62_A1789CONTLSegPla = new byte[1] ;
      BC000A62_n1789CONTLSegPla = new boolean[] {false} ;
      BC000A62_A3CliCod = new int[1] ;
      BC000A62_A32TLiqCod = new String[] {""} ;
      sMode8 = "" ;
      BC000A63_A26ConCodigo = new String[] {""} ;
      BC000A63_A925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A63_n925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A63_A926ConTLiqSinPre = new boolean[] {false} ;
      BC000A63_n926ConTLiqSinPre = new boolean[] {false} ;
      BC000A63_A950ConTLTipEgr = new String[] {""} ;
      BC000A63_A1406ConTLOrdejec = new long[1] ;
      BC000A63_A1407ConTLConOrd = new short[1] ;
      BC000A63_A1409ConTLVigencia = new byte[1] ;
      BC000A63_n1409ConTLVigencia = new boolean[] {false} ;
      BC000A63_A1410ConTLCondicion = new String[] {""} ;
      BC000A63_n1410ConTLCondicion = new boolean[] {false} ;
      BC000A63_A1470ConTLConHab = new byte[1] ;
      BC000A63_A1788ConTLTipoCon = new String[] {""} ;
      BC000A63_n1788ConTLTipoCon = new boolean[] {false} ;
      BC000A63_A1789CONTLSegPla = new byte[1] ;
      BC000A63_n1789CONTLSegPla = new boolean[] {false} ;
      BC000A63_A3CliCod = new int[1] ;
      BC000A63_A32TLiqCod = new String[] {""} ;
      BC000A67_A340TliqDesc = new String[] {""} ;
      BC000A68_A26ConCodigo = new String[] {""} ;
      BC000A68_A340TliqDesc = new String[] {""} ;
      BC000A68_A925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A68_n925ConTLiqSinCausa = new boolean[] {false} ;
      BC000A68_A926ConTLiqSinPre = new boolean[] {false} ;
      BC000A68_n926ConTLiqSinPre = new boolean[] {false} ;
      BC000A68_A950ConTLTipEgr = new String[] {""} ;
      BC000A68_A1406ConTLOrdejec = new long[1] ;
      BC000A68_A1407ConTLConOrd = new short[1] ;
      BC000A68_A1409ConTLVigencia = new byte[1] ;
      BC000A68_n1409ConTLVigencia = new boolean[] {false} ;
      BC000A68_A1410ConTLCondicion = new String[] {""} ;
      BC000A68_n1410ConTLCondicion = new boolean[] {false} ;
      BC000A68_A1470ConTLConHab = new byte[1] ;
      BC000A68_A1788ConTLTipoCon = new String[] {""} ;
      BC000A68_n1788ConTLTipoCon = new boolean[] {false} ;
      BC000A68_A1789CONTLSegPla = new byte[1] ;
      BC000A68_n1789CONTLSegPla = new boolean[] {false} ;
      BC000A68_A3CliCod = new int[1] ;
      BC000A68_A32TLiqCod = new String[] {""} ;
      N32TLiqCod = "" ;
      Z1532MegPreaTipo = "" ;
      A1532MegPreaTipo = "" ;
      Z1534ConMegDura = "" ;
      A1534ConMegDura = "" ;
      Z1529ConMegPropor = DecimalUtil.ZERO ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      Z11MegCodigo = "" ;
      A11MegCodigo = "" ;
      BC000A69_A26ConCodigo = new String[] {""} ;
      BC000A69_A2077ConMegSec = new short[1] ;
      BC000A69_A1532MegPreaTipo = new String[] {""} ;
      BC000A69_A1530ConMegMeses = new byte[1] ;
      BC000A69_A1534ConMegDura = new String[] {""} ;
      BC000A69_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A69_A3CliCod = new int[1] ;
      BC000A69_A11MegCodigo = new String[] {""} ;
      BC000A70_A3CliCod = new int[1] ;
      BC000A71_A3CliCod = new int[1] ;
      BC000A72_A3CliCod = new int[1] ;
      BC000A72_A26ConCodigo = new String[] {""} ;
      BC000A72_A11MegCodigo = new String[] {""} ;
      BC000A72_A2077ConMegSec = new short[1] ;
      BC000A73_A26ConCodigo = new String[] {""} ;
      BC000A73_A2077ConMegSec = new short[1] ;
      BC000A73_A1532MegPreaTipo = new String[] {""} ;
      BC000A73_A1530ConMegMeses = new byte[1] ;
      BC000A73_A1534ConMegDura = new String[] {""} ;
      BC000A73_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A73_A3CliCod = new int[1] ;
      BC000A73_A11MegCodigo = new String[] {""} ;
      sMode261 = "" ;
      BC000A74_A26ConCodigo = new String[] {""} ;
      BC000A74_A2077ConMegSec = new short[1] ;
      BC000A74_A1532MegPreaTipo = new String[] {""} ;
      BC000A74_A1530ConMegMeses = new byte[1] ;
      BC000A74_A1534ConMegDura = new String[] {""} ;
      BC000A74_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A74_A3CliCod = new int[1] ;
      BC000A74_A11MegCodigo = new String[] {""} ;
      BC000A78_A26ConCodigo = new String[] {""} ;
      BC000A78_A2077ConMegSec = new short[1] ;
      BC000A78_A1532MegPreaTipo = new String[] {""} ;
      BC000A78_A1530ConMegMeses = new byte[1] ;
      BC000A78_A1534ConMegDura = new String[] {""} ;
      BC000A78_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A78_A3CliCod = new int[1] ;
      BC000A78_A11MegCodigo = new String[] {""} ;
      N41ConDescrip = "" ;
      N157ConValorGen = DecimalUtil.ZERO ;
      N155ConTipoLiqGanancias = "" ;
      N153ConObservacion = "" ;
      N37TipoConCod = "" ;
      N38SubTipoConCod1 = "" ;
      N39SubTipoConCod2 = "" ;
      i149ConFormulaAbr = "" ;
      i155ConTipoLiqGanancias = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.concepto_bc__default(),
         new Object[] {
             new Object[] {
            BC000A2_A26ConCodigo, BC000A2_A2077ConMegSec, BC000A2_A1532MegPreaTipo, BC000A2_A1530ConMegMeses, BC000A2_A1534ConMegDura, BC000A2_A1529ConMegPropor, BC000A2_A3CliCod, BC000A2_A11MegCodigo
            }
            , new Object[] {
            BC000A3_A26ConCodigo, BC000A3_A2077ConMegSec, BC000A3_A1532MegPreaTipo, BC000A3_A1530ConMegMeses, BC000A3_A1534ConMegDura, BC000A3_A1529ConMegPropor, BC000A3_A3CliCod, BC000A3_A11MegCodigo
            }
            , new Object[] {
            BC000A4_A3CliCod
            }
            , new Object[] {
            BC000A5_A26ConCodigo, BC000A5_A925ConTLiqSinCausa, BC000A5_n925ConTLiqSinCausa, BC000A5_A926ConTLiqSinPre, BC000A5_n926ConTLiqSinPre, BC000A5_A950ConTLTipEgr, BC000A5_A1406ConTLOrdejec, BC000A5_A1407ConTLConOrd, BC000A5_A1409ConTLVigencia, BC000A5_n1409ConTLVigencia,
            BC000A5_A1410ConTLCondicion, BC000A5_n1410ConTLCondicion, BC000A5_A1470ConTLConHab, BC000A5_A1788ConTLTipoCon, BC000A5_n1788ConTLTipoCon, BC000A5_A1789CONTLSegPla, BC000A5_n1789CONTLSegPla, BC000A5_A3CliCod, BC000A5_A32TLiqCod
            }
            , new Object[] {
            BC000A6_A26ConCodigo, BC000A6_A925ConTLiqSinCausa, BC000A6_n925ConTLiqSinCausa, BC000A6_A926ConTLiqSinPre, BC000A6_n926ConTLiqSinPre, BC000A6_A950ConTLTipEgr, BC000A6_A1406ConTLOrdejec, BC000A6_A1407ConTLConOrd, BC000A6_A1409ConTLVigencia, BC000A6_n1409ConTLVigencia,
            BC000A6_A1410ConTLCondicion, BC000A6_n1410ConTLCondicion, BC000A6_A1470ConTLConHab, BC000A6_A1788ConTLTipoCon, BC000A6_n1788ConTLTipoCon, BC000A6_A1789CONTLSegPla, BC000A6_n1789CONTLSegPla, BC000A6_A3CliCod, BC000A6_A32TLiqCod
            }
            , new Object[] {
            BC000A7_A340TliqDesc
            }
            , new Object[] {
            BC000A8_A42ConCodYDesc, BC000A8_n42ConCodYDesc, BC000A8_A26ConCodigo, BC000A8_A145ConFchModFor, BC000A8_n145ConFchModFor, BC000A8_A156ConUsuModFor, BC000A8_n156ConUsuModFor, BC000A8_A143ConCanti, BC000A8_A158ConValUni, BC000A8_A152ConImporte,
            BC000A8_A159ConVariable, BC000A8_A1905ConRelSecCli, BC000A8_A1974ConOldValues, BC000A8_A41ConDescrip, BC000A8_A150ConHabilitado, BC000A8_A40ConOrden, BC000A8_A162ConVigencia, BC000A8_A1488ConLiqBasica, BC000A8_A148ConFormula, BC000A8_n148ConFormula,
            BC000A8_A729ConFormulaPreResuelta, BC000A8_A157ConValorGen, BC000A8_n157ConValorGen, BC000A8_A155ConTipoLiqGanancias, BC000A8_n155ConTipoLiqGanancias, BC000A8_A153ConObservacion, BC000A8_A151ConHisFormula, BC000A8_n151ConHisFormula, BC000A8_A154ConTipo, BC000A8_A469ConCodOld,
            BC000A8_A487ConCuenDebe, BC000A8_n487ConCuenDebe, BC000A8_A488ConCuenHaber, BC000A8_n488ConCuenHaber, BC000A8_A503ConTipoLiqAux, BC000A8_n503ConTipoLiqAux, BC000A8_A969ConConveAux, BC000A8_n969ConConveAux, BC000A8_A970ConClasifAux, BC000A8_n970ConClasifAux,
            BC000A8_A510ConOrdEjec, BC000A8_A569ConFormulaExpl, BC000A8_A720ConFormulaObs2, BC000A8_A734ConRetGanPropor, BC000A8_A735ConAplicGan, BC000A8_n735ConAplicGan, BC000A8_A762ConRecalcular, BC000A8_A894ConImportado, BC000A8_A895ConTipoOrden, BC000A8_A1017ConEdiEnRec,
            BC000A8_A1018ConRangoCant, BC000A8_A922ConUsado, BC000A8_A951ConObliga, BC000A8_n951ConObliga, BC000A8_A952ConObligaSiSac, BC000A8_n952ConObligaSiSac, BC000A8_A954ConCondCodigo, BC000A8_A1066ConPreReq, BC000A8_n1066ConPreReq, BC000A8_A1068ConMostrarPos,
            BC000A8_A1077ConAdelDescu, BC000A8_n1077ConAdelDescu, BC000A8_A1194ConSegunPla, BC000A8_A1471ConNumero, BC000A8_A1472ConSIPAApo, BC000A8_A1473ConSIPACont, BC000A8_A1474ConINSSJyPApo, BC000A8_A1475ConINSSJyPCont, BC000A8_A1476ConObraSocApo, BC000A8_A1477ConObraSocCont,
            BC000A8_A1478ConFonSolRedApo, BC000A8_A1479ConFonSolRedCont, BC000A8_A1480ConRenateaApo, BC000A8_A1481ConRenateaCont, BC000A8_A1482ConAsigFamCont, BC000A8_A1483ConFonNacEmpCont, BC000A8_A1484ConLeyRieTrabCont, BC000A8_A1485ConRegDifApo, BC000A8_A1486ConRegEspApo, BC000A8_A1539ConSacDeven,
            BC000A8_A1620ConBaseLic, BC000A8_A1797ConBaseLicProm, BC000A8_A1621ConBaseFer, BC000A8_A1798ConBaseFerProm, BC000A8_A1622ConBaseHorExt, BC000A8_A1799ConBaseHorExtProm, BC000A8_A1800ConBasePres, BC000A8_A1801ConBaseAnt, BC000A8_A1827ConBaseOSDif, BC000A8_A2191ConBaseAus,
            BC000A8_A2192ConBaseAusProm, BC000A8_A1648ConCodAfip, BC000A8_A1769ConCntPa, BC000A8_A1821ConErrorSiCero, BC000A8_A1826ConPueNov, BC000A8_A1886ConRelSec, BC000A8_A2013ConRelRef, BC000A8_A2185ConDescripSinAc, BC000A8_A2187ConOblPalabra, BC000A8_n2187ConOblPalabra,
            BC000A8_A1822CliPadre, BC000A8_n1822CliPadre, BC000A8_A3CliCod, BC000A8_A1112AplIIGG, BC000A8_n1112AplIIGG, BC000A8_A37TipoConCod, BC000A8_A38SubTipoConCod1, BC000A8_n38SubTipoConCod1, BC000A8_A39SubTipoConCod2, BC000A8_n39SubTipoConCod2,
            BC000A8_A953ConCondicion, BC000A8_n953ConCondicion, BC000A8_A1644ConceptoPais, BC000A8_n1644ConceptoPais, BC000A8_A1645ConceptoConveCodigo, BC000A8_n1645ConceptoConveCodigo, BC000A8_A921ConPadre, BC000A8_n921ConPadre
            }
            , new Object[] {
            BC000A9_A42ConCodYDesc, BC000A9_n42ConCodYDesc, BC000A9_A26ConCodigo, BC000A9_A145ConFchModFor, BC000A9_n145ConFchModFor, BC000A9_A156ConUsuModFor, BC000A9_n156ConUsuModFor, BC000A9_A143ConCanti, BC000A9_A158ConValUni, BC000A9_A152ConImporte,
            BC000A9_A159ConVariable, BC000A9_A1905ConRelSecCli, BC000A9_A1974ConOldValues, BC000A9_A41ConDescrip, BC000A9_A150ConHabilitado, BC000A9_A40ConOrden, BC000A9_A162ConVigencia, BC000A9_A1488ConLiqBasica, BC000A9_A148ConFormula, BC000A9_n148ConFormula,
            BC000A9_A729ConFormulaPreResuelta, BC000A9_A157ConValorGen, BC000A9_n157ConValorGen, BC000A9_A155ConTipoLiqGanancias, BC000A9_n155ConTipoLiqGanancias, BC000A9_A153ConObservacion, BC000A9_A151ConHisFormula, BC000A9_n151ConHisFormula, BC000A9_A154ConTipo, BC000A9_A469ConCodOld,
            BC000A9_A487ConCuenDebe, BC000A9_n487ConCuenDebe, BC000A9_A488ConCuenHaber, BC000A9_n488ConCuenHaber, BC000A9_A503ConTipoLiqAux, BC000A9_n503ConTipoLiqAux, BC000A9_A969ConConveAux, BC000A9_n969ConConveAux, BC000A9_A970ConClasifAux, BC000A9_n970ConClasifAux,
            BC000A9_A510ConOrdEjec, BC000A9_A569ConFormulaExpl, BC000A9_A720ConFormulaObs2, BC000A9_A734ConRetGanPropor, BC000A9_A735ConAplicGan, BC000A9_n735ConAplicGan, BC000A9_A762ConRecalcular, BC000A9_A894ConImportado, BC000A9_A895ConTipoOrden, BC000A9_A1017ConEdiEnRec,
            BC000A9_A1018ConRangoCant, BC000A9_A922ConUsado, BC000A9_A951ConObliga, BC000A9_n951ConObliga, BC000A9_A952ConObligaSiSac, BC000A9_n952ConObligaSiSac, BC000A9_A954ConCondCodigo, BC000A9_A1066ConPreReq, BC000A9_n1066ConPreReq, BC000A9_A1068ConMostrarPos,
            BC000A9_A1077ConAdelDescu, BC000A9_n1077ConAdelDescu, BC000A9_A1194ConSegunPla, BC000A9_A1471ConNumero, BC000A9_A1472ConSIPAApo, BC000A9_A1473ConSIPACont, BC000A9_A1474ConINSSJyPApo, BC000A9_A1475ConINSSJyPCont, BC000A9_A1476ConObraSocApo, BC000A9_A1477ConObraSocCont,
            BC000A9_A1478ConFonSolRedApo, BC000A9_A1479ConFonSolRedCont, BC000A9_A1480ConRenateaApo, BC000A9_A1481ConRenateaCont, BC000A9_A1482ConAsigFamCont, BC000A9_A1483ConFonNacEmpCont, BC000A9_A1484ConLeyRieTrabCont, BC000A9_A1485ConRegDifApo, BC000A9_A1486ConRegEspApo, BC000A9_A1539ConSacDeven,
            BC000A9_A1620ConBaseLic, BC000A9_A1797ConBaseLicProm, BC000A9_A1621ConBaseFer, BC000A9_A1798ConBaseFerProm, BC000A9_A1622ConBaseHorExt, BC000A9_A1799ConBaseHorExtProm, BC000A9_A1800ConBasePres, BC000A9_A1801ConBaseAnt, BC000A9_A1827ConBaseOSDif, BC000A9_A2191ConBaseAus,
            BC000A9_A2192ConBaseAusProm, BC000A9_A1648ConCodAfip, BC000A9_A1769ConCntPa, BC000A9_A1821ConErrorSiCero, BC000A9_A1826ConPueNov, BC000A9_A1886ConRelSec, BC000A9_A2013ConRelRef, BC000A9_A2185ConDescripSinAc, BC000A9_A2187ConOblPalabra, BC000A9_n2187ConOblPalabra,
            BC000A9_A1822CliPadre, BC000A9_n1822CliPadre, BC000A9_A3CliCod, BC000A9_A1112AplIIGG, BC000A9_n1112AplIIGG, BC000A9_A37TipoConCod, BC000A9_A38SubTipoConCod1, BC000A9_n38SubTipoConCod1, BC000A9_A39SubTipoConCod2, BC000A9_n39SubTipoConCod2,
            BC000A9_A953ConCondicion, BC000A9_n953ConCondicion, BC000A9_A1644ConceptoPais, BC000A9_n1644ConceptoPais, BC000A9_A1645ConceptoConveCodigo, BC000A9_n1645ConceptoConveCodigo, BC000A9_A921ConPadre, BC000A9_n921ConPadre
            }
            , new Object[] {
            BC000A10_A3CliCod
            }
            , new Object[] {
            BC000A11_A3CliCod
            }
            , new Object[] {
            BC000A12_A37TipoConCod
            }
            , new Object[] {
            BC000A13_A37TipoConCod
            }
            , new Object[] {
            BC000A14_A37TipoConCod
            }
            , new Object[] {
            BC000A15_A953ConCondicion
            }
            , new Object[] {
            BC000A16_A1644ConceptoPais
            }
            , new Object[] {
            BC000A17_A1822CliPadre
            }
            , new Object[] {
            BC000A18_A42ConCodYDesc, BC000A18_n42ConCodYDesc, BC000A18_A26ConCodigo, BC000A18_A145ConFchModFor, BC000A18_n145ConFchModFor, BC000A18_A156ConUsuModFor, BC000A18_n156ConUsuModFor, BC000A18_A143ConCanti, BC000A18_A158ConValUni, BC000A18_A152ConImporte,
            BC000A18_A159ConVariable, BC000A18_A1905ConRelSecCli, BC000A18_A1974ConOldValues, BC000A18_A41ConDescrip, BC000A18_A150ConHabilitado, BC000A18_A40ConOrden, BC000A18_A162ConVigencia, BC000A18_A1488ConLiqBasica, BC000A18_A148ConFormula, BC000A18_n148ConFormula,
            BC000A18_A729ConFormulaPreResuelta, BC000A18_A157ConValorGen, BC000A18_n157ConValorGen, BC000A18_A155ConTipoLiqGanancias, BC000A18_n155ConTipoLiqGanancias, BC000A18_A153ConObservacion, BC000A18_A151ConHisFormula, BC000A18_n151ConHisFormula, BC000A18_A154ConTipo, BC000A18_A469ConCodOld,
            BC000A18_A487ConCuenDebe, BC000A18_n487ConCuenDebe, BC000A18_A488ConCuenHaber, BC000A18_n488ConCuenHaber, BC000A18_A503ConTipoLiqAux, BC000A18_n503ConTipoLiqAux, BC000A18_A969ConConveAux, BC000A18_n969ConConveAux, BC000A18_A970ConClasifAux, BC000A18_n970ConClasifAux,
            BC000A18_A510ConOrdEjec, BC000A18_A569ConFormulaExpl, BC000A18_A720ConFormulaObs2, BC000A18_A734ConRetGanPropor, BC000A18_A735ConAplicGan, BC000A18_n735ConAplicGan, BC000A18_A762ConRecalcular, BC000A18_A894ConImportado, BC000A18_A895ConTipoOrden, BC000A18_A1017ConEdiEnRec,
            BC000A18_A1018ConRangoCant, BC000A18_A922ConUsado, BC000A18_A951ConObliga, BC000A18_n951ConObliga, BC000A18_A952ConObligaSiSac, BC000A18_n952ConObligaSiSac, BC000A18_A954ConCondCodigo, BC000A18_A1066ConPreReq, BC000A18_n1066ConPreReq, BC000A18_A1068ConMostrarPos,
            BC000A18_A1077ConAdelDescu, BC000A18_n1077ConAdelDescu, BC000A18_A1194ConSegunPla, BC000A18_A1471ConNumero, BC000A18_A1472ConSIPAApo, BC000A18_A1473ConSIPACont, BC000A18_A1474ConINSSJyPApo, BC000A18_A1475ConINSSJyPCont, BC000A18_A1476ConObraSocApo, BC000A18_A1477ConObraSocCont,
            BC000A18_A1478ConFonSolRedApo, BC000A18_A1479ConFonSolRedCont, BC000A18_A1480ConRenateaApo, BC000A18_A1481ConRenateaCont, BC000A18_A1482ConAsigFamCont, BC000A18_A1483ConFonNacEmpCont, BC000A18_A1484ConLeyRieTrabCont, BC000A18_A1485ConRegDifApo, BC000A18_A1486ConRegEspApo, BC000A18_A1539ConSacDeven,
            BC000A18_A1620ConBaseLic, BC000A18_A1797ConBaseLicProm, BC000A18_A1621ConBaseFer, BC000A18_A1798ConBaseFerProm, BC000A18_A1622ConBaseHorExt, BC000A18_A1799ConBaseHorExtProm, BC000A18_A1800ConBasePres, BC000A18_A1801ConBaseAnt, BC000A18_A1827ConBaseOSDif, BC000A18_A2191ConBaseAus,
            BC000A18_A2192ConBaseAusProm, BC000A18_A1648ConCodAfip, BC000A18_A1769ConCntPa, BC000A18_A1821ConErrorSiCero, BC000A18_A1826ConPueNov, BC000A18_A1886ConRelSec, BC000A18_A2013ConRelRef, BC000A18_A2185ConDescripSinAc, BC000A18_A2187ConOblPalabra, BC000A18_n2187ConOblPalabra,
            BC000A18_A1822CliPadre, BC000A18_n1822CliPadre, BC000A18_A3CliCod, BC000A18_A1112AplIIGG, BC000A18_n1112AplIIGG, BC000A18_A37TipoConCod, BC000A18_A38SubTipoConCod1, BC000A18_n38SubTipoConCod1, BC000A18_A39SubTipoConCod2, BC000A18_n39SubTipoConCod2,
            BC000A18_A953ConCondicion, BC000A18_n953ConCondicion, BC000A18_A1644ConceptoPais, BC000A18_n1644ConceptoPais, BC000A18_A1645ConceptoConveCodigo, BC000A18_n1645ConceptoConveCodigo, BC000A18_A921ConPadre, BC000A18_n921ConPadre
            }
            , new Object[] {
            BC000A19_A3CliCod
            }
            , new Object[] {
            BC000A20_A37TipoConCod
            }
            , new Object[] {
            BC000A21_A37TipoConCod
            }
            , new Object[] {
            BC000A22_A37TipoConCod
            }
            , new Object[] {
            BC000A23_A953ConCondicion
            }
            , new Object[] {
            BC000A24_A3CliCod
            }
            , new Object[] {
            BC000A25_A1644ConceptoPais
            }
            , new Object[] {
            BC000A26_A1822CliPadre
            }
            , new Object[] {
            BC000A27_A3CliCod, BC000A27_A26ConCodigo
            }
            , new Object[] {
            BC000A28_A42ConCodYDesc, BC000A28_n42ConCodYDesc, BC000A28_A26ConCodigo, BC000A28_A145ConFchModFor, BC000A28_n145ConFchModFor, BC000A28_A156ConUsuModFor, BC000A28_n156ConUsuModFor, BC000A28_A143ConCanti, BC000A28_A158ConValUni, BC000A28_A152ConImporte,
            BC000A28_A159ConVariable, BC000A28_A1905ConRelSecCli, BC000A28_A1974ConOldValues, BC000A28_A41ConDescrip, BC000A28_A150ConHabilitado, BC000A28_A40ConOrden, BC000A28_A162ConVigencia, BC000A28_A1488ConLiqBasica, BC000A28_A148ConFormula, BC000A28_n148ConFormula,
            BC000A28_A729ConFormulaPreResuelta, BC000A28_A157ConValorGen, BC000A28_n157ConValorGen, BC000A28_A155ConTipoLiqGanancias, BC000A28_n155ConTipoLiqGanancias, BC000A28_A153ConObservacion, BC000A28_A151ConHisFormula, BC000A28_n151ConHisFormula, BC000A28_A154ConTipo, BC000A28_A469ConCodOld,
            BC000A28_A487ConCuenDebe, BC000A28_n487ConCuenDebe, BC000A28_A488ConCuenHaber, BC000A28_n488ConCuenHaber, BC000A28_A503ConTipoLiqAux, BC000A28_n503ConTipoLiqAux, BC000A28_A969ConConveAux, BC000A28_n969ConConveAux, BC000A28_A970ConClasifAux, BC000A28_n970ConClasifAux,
            BC000A28_A510ConOrdEjec, BC000A28_A569ConFormulaExpl, BC000A28_A720ConFormulaObs2, BC000A28_A734ConRetGanPropor, BC000A28_A735ConAplicGan, BC000A28_n735ConAplicGan, BC000A28_A762ConRecalcular, BC000A28_A894ConImportado, BC000A28_A895ConTipoOrden, BC000A28_A1017ConEdiEnRec,
            BC000A28_A1018ConRangoCant, BC000A28_A922ConUsado, BC000A28_A951ConObliga, BC000A28_n951ConObliga, BC000A28_A952ConObligaSiSac, BC000A28_n952ConObligaSiSac, BC000A28_A954ConCondCodigo, BC000A28_A1066ConPreReq, BC000A28_n1066ConPreReq, BC000A28_A1068ConMostrarPos,
            BC000A28_A1077ConAdelDescu, BC000A28_n1077ConAdelDescu, BC000A28_A1194ConSegunPla, BC000A28_A1471ConNumero, BC000A28_A1472ConSIPAApo, BC000A28_A1473ConSIPACont, BC000A28_A1474ConINSSJyPApo, BC000A28_A1475ConINSSJyPCont, BC000A28_A1476ConObraSocApo, BC000A28_A1477ConObraSocCont,
            BC000A28_A1478ConFonSolRedApo, BC000A28_A1479ConFonSolRedCont, BC000A28_A1480ConRenateaApo, BC000A28_A1481ConRenateaCont, BC000A28_A1482ConAsigFamCont, BC000A28_A1483ConFonNacEmpCont, BC000A28_A1484ConLeyRieTrabCont, BC000A28_A1485ConRegDifApo, BC000A28_A1486ConRegEspApo, BC000A28_A1539ConSacDeven,
            BC000A28_A1620ConBaseLic, BC000A28_A1797ConBaseLicProm, BC000A28_A1621ConBaseFer, BC000A28_A1798ConBaseFerProm, BC000A28_A1622ConBaseHorExt, BC000A28_A1799ConBaseHorExtProm, BC000A28_A1800ConBasePres, BC000A28_A1801ConBaseAnt, BC000A28_A1827ConBaseOSDif, BC000A28_A2191ConBaseAus,
            BC000A28_A2192ConBaseAusProm, BC000A28_A1648ConCodAfip, BC000A28_A1769ConCntPa, BC000A28_A1821ConErrorSiCero, BC000A28_A1826ConPueNov, BC000A28_A1886ConRelSec, BC000A28_A2013ConRelRef, BC000A28_A2185ConDescripSinAc, BC000A28_A2187ConOblPalabra, BC000A28_n2187ConOblPalabra,
            BC000A28_A1822CliPadre, BC000A28_n1822CliPadre, BC000A28_A3CliCod, BC000A28_A1112AplIIGG, BC000A28_n1112AplIIGG, BC000A28_A37TipoConCod, BC000A28_A38SubTipoConCod1, BC000A28_n38SubTipoConCod1, BC000A28_A39SubTipoConCod2, BC000A28_n39SubTipoConCod2,
            BC000A28_A953ConCondicion, BC000A28_n953ConCondicion, BC000A28_A1644ConceptoPais, BC000A28_n1644ConceptoPais, BC000A28_A1645ConceptoConveCodigo, BC000A28_n1645ConceptoConveCodigo, BC000A28_A921ConPadre, BC000A28_n921ConPadre
            }
            , new Object[] {
            BC000A29_A42ConCodYDesc, BC000A29_n42ConCodYDesc, BC000A29_A26ConCodigo, BC000A29_A145ConFchModFor, BC000A29_n145ConFchModFor, BC000A29_A156ConUsuModFor, BC000A29_n156ConUsuModFor, BC000A29_A143ConCanti, BC000A29_A158ConValUni, BC000A29_A152ConImporte,
            BC000A29_A159ConVariable, BC000A29_A1905ConRelSecCli, BC000A29_A1974ConOldValues, BC000A29_A41ConDescrip, BC000A29_A150ConHabilitado, BC000A29_A40ConOrden, BC000A29_A162ConVigencia, BC000A29_A1488ConLiqBasica, BC000A29_A148ConFormula, BC000A29_n148ConFormula,
            BC000A29_A729ConFormulaPreResuelta, BC000A29_A157ConValorGen, BC000A29_n157ConValorGen, BC000A29_A155ConTipoLiqGanancias, BC000A29_n155ConTipoLiqGanancias, BC000A29_A153ConObservacion, BC000A29_A151ConHisFormula, BC000A29_n151ConHisFormula, BC000A29_A154ConTipo, BC000A29_A469ConCodOld,
            BC000A29_A487ConCuenDebe, BC000A29_n487ConCuenDebe, BC000A29_A488ConCuenHaber, BC000A29_n488ConCuenHaber, BC000A29_A503ConTipoLiqAux, BC000A29_n503ConTipoLiqAux, BC000A29_A969ConConveAux, BC000A29_n969ConConveAux, BC000A29_A970ConClasifAux, BC000A29_n970ConClasifAux,
            BC000A29_A510ConOrdEjec, BC000A29_A569ConFormulaExpl, BC000A29_A720ConFormulaObs2, BC000A29_A734ConRetGanPropor, BC000A29_A735ConAplicGan, BC000A29_n735ConAplicGan, BC000A29_A762ConRecalcular, BC000A29_A894ConImportado, BC000A29_A895ConTipoOrden, BC000A29_A1017ConEdiEnRec,
            BC000A29_A1018ConRangoCant, BC000A29_A922ConUsado, BC000A29_A951ConObliga, BC000A29_n951ConObliga, BC000A29_A952ConObligaSiSac, BC000A29_n952ConObligaSiSac, BC000A29_A954ConCondCodigo, BC000A29_A1066ConPreReq, BC000A29_n1066ConPreReq, BC000A29_A1068ConMostrarPos,
            BC000A29_A1077ConAdelDescu, BC000A29_n1077ConAdelDescu, BC000A29_A1194ConSegunPla, BC000A29_A1471ConNumero, BC000A29_A1472ConSIPAApo, BC000A29_A1473ConSIPACont, BC000A29_A1474ConINSSJyPApo, BC000A29_A1475ConINSSJyPCont, BC000A29_A1476ConObraSocApo, BC000A29_A1477ConObraSocCont,
            BC000A29_A1478ConFonSolRedApo, BC000A29_A1479ConFonSolRedCont, BC000A29_A1480ConRenateaApo, BC000A29_A1481ConRenateaCont, BC000A29_A1482ConAsigFamCont, BC000A29_A1483ConFonNacEmpCont, BC000A29_A1484ConLeyRieTrabCont, BC000A29_A1485ConRegDifApo, BC000A29_A1486ConRegEspApo, BC000A29_A1539ConSacDeven,
            BC000A29_A1620ConBaseLic, BC000A29_A1797ConBaseLicProm, BC000A29_A1621ConBaseFer, BC000A29_A1798ConBaseFerProm, BC000A29_A1622ConBaseHorExt, BC000A29_A1799ConBaseHorExtProm, BC000A29_A1800ConBasePres, BC000A29_A1801ConBaseAnt, BC000A29_A1827ConBaseOSDif, BC000A29_A2191ConBaseAus,
            BC000A29_A2192ConBaseAusProm, BC000A29_A1648ConCodAfip, BC000A29_A1769ConCntPa, BC000A29_A1821ConErrorSiCero, BC000A29_A1826ConPueNov, BC000A29_A1886ConRelSec, BC000A29_A2013ConRelRef, BC000A29_A2185ConDescripSinAc, BC000A29_A2187ConOblPalabra, BC000A29_n2187ConOblPalabra,
            BC000A29_A1822CliPadre, BC000A29_n1822CliPadre, BC000A29_A3CliCod, BC000A29_A1112AplIIGG, BC000A29_n1112AplIIGG, BC000A29_A37TipoConCod, BC000A29_A38SubTipoConCod1, BC000A29_n38SubTipoConCod1, BC000A29_A39SubTipoConCod2, BC000A29_n39SubTipoConCod2,
            BC000A29_A953ConCondicion, BC000A29_n953ConCondicion, BC000A29_A1644ConceptoPais, BC000A29_n1644ConceptoPais, BC000A29_A1645ConceptoConveCodigo, BC000A29_n1645ConceptoConveCodigo, BC000A29_A921ConPadre, BC000A29_n921ConPadre
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000A33_A1822CliPadre, BC000A33_A921ConPadre
            }
            , new Object[] {
            BC000A34_A46PaiCod, BC000A34_A1440PaiBaseClaseLeg, BC000A34_A1441PaiBaseTipo, BC000A34_A1442PaiBaseCod1, BC000A34_A1443PaiBaseCod2, BC000A34_A1445PaiBaseCliCod, BC000A34_A1446PaiBaseConCodigo
            }
            , new Object[] {
            BC000A35_A46PaiCod, BC000A35_A1356PaiMenCliCod, BC000A35_A1358PaiMesConCodigo
            }
            , new Object[] {
            BC000A36_A46PaiCod, BC000A36_A1354PaiJorCliCod, BC000A36_A1355PaiJorConCodigo
            }
            , new Object[] {
            BC000A37_A3CliCod, BC000A37_A1EmpCod, BC000A37_A6LegNumero, BC000A37_A1135LegSuelSec, BC000A37_A2349LegSuelConcepto
            }
            , new Object[] {
            BC000A38_A3CliCod, BC000A38_A26ConCodigo, BC000A38_A2119ConOpeId, BC000A38_A923ConOperFor
            }
            , new Object[] {
            BC000A39_A3CliCod, BC000A39_A1EmpCod, BC000A39_A6LegNumero, BC000A39_A1829PreliqTLiqCod, BC000A39_A1830PreliqPeriodo, BC000A39_A1831PreliqConcepto
            }
            , new Object[] {
            BC000A40_A3CliCod, BC000A40_A1564CliPaiConve, BC000A40_A1565CliConvenio, BC000A40_A1327ConveHsExSec
            }
            , new Object[] {
            BC000A41_A3CliCod, BC000A41_A1564CliPaiConve, BC000A41_A1565CliConvenio, BC000A41_A1381ConveMenCliCod, BC000A41_A1375ConveMenConCodigo
            }
            , new Object[] {
            BC000A42_A3CliCod, BC000A42_A1EmpCod, BC000A42_A31LiqNro, BC000A42_A6LegNumero, BC000A42_A1541LiqAjuNro, BC000A42_A1543LiqAjuSec
            }
            , new Object[] {
            BC000A43_A3CliCod, BC000A43_A1EmpCod, BC000A43_A1366EmpJorConCodigo
            }
            , new Object[] {
            BC000A44_A3CliCod, BC000A44_A1EmpCod, BC000A44_A1368EmpMenConCodigo
            }
            , new Object[] {
            BC000A45_A3CliCod, BC000A45_A1EmpCod, BC000A45_A6LegNumero, BC000A45_A1172OblSecuencial, BC000A45_A1170OblExcConCOdigo
            }
            , new Object[] {
            BC000A46_A3CliCod, BC000A46_A1EmpCod, BC000A46_A6LegNumero, BC000A46_A1172OblSecuencial
            }
            , new Object[] {
            BC000A47_A3CliCod, BC000A47_A1EmpCod, BC000A47_A6LegNumero, BC000A47_A1172OblSecuencial
            }
            , new Object[] {
            BC000A48_A3CliCod, BC000A48_A1EmpCod, BC000A48_A1129LiqExAnio, BC000A48_A31LiqNro, BC000A48_A6LegNumero, BC000A48_A1127LiqExenConCodigo, BC000A48_A1128LiqExAplIIGG
            }
            , new Object[] {
            BC000A49_A3CliCod, BC000A49_A1112AplIIGG
            }
            , new Object[] {
            BC000A50_A3CliCod, BC000A50_A1112AplIIGG
            }
            , new Object[] {
            BC000A51_A3CliCod, BC000A51_A1112AplIIGG
            }
            , new Object[] {
            BC000A52_A3CliCod, BC000A52_A1105CondExenIIGG
            }
            , new Object[] {
            BC000A53_A3CliCod, BC000A53_A1101SiraTipo, BC000A53_A1102SiraCodigo
            }
            , new Object[] {
            BC000A54_A3CliCod, BC000A54_A1EmpCod, BC000A54_A869LiqLegConAnio, BC000A54_A6LegNumero, BC000A54_A26ConCodigo, BC000A54_A1097LiqAltaNro, BC000A54_A1098LiqNuevaNro
            }
            , new Object[] {
            BC000A55_A3CliCod, BC000A55_A1EmpCod, BC000A55_A6LegNumero, BC000A55_A83LegDedSec
            }
            , new Object[] {
            BC000A56_A3CliCod, BC000A56_A26ConCodigo, BC000A56_A51ForHisNum
            }
            , new Object[] {
            BC000A57_A3CliCod, BC000A57_A1EmpCod, BC000A57_A6LegNumero, BC000A57_A25AgeOrden
            }
            , new Object[] {
            BC000A58_A42ConCodYDesc, BC000A58_n42ConCodYDesc, BC000A58_A26ConCodigo, BC000A58_A145ConFchModFor, BC000A58_n145ConFchModFor, BC000A58_A156ConUsuModFor, BC000A58_n156ConUsuModFor, BC000A58_A143ConCanti, BC000A58_A158ConValUni, BC000A58_A152ConImporte,
            BC000A58_A159ConVariable, BC000A58_A1905ConRelSecCli, BC000A58_A1974ConOldValues, BC000A58_A41ConDescrip, BC000A58_A150ConHabilitado, BC000A58_A40ConOrden, BC000A58_A162ConVigencia, BC000A58_A1488ConLiqBasica, BC000A58_A148ConFormula, BC000A58_n148ConFormula,
            BC000A58_A729ConFormulaPreResuelta, BC000A58_A157ConValorGen, BC000A58_n157ConValorGen, BC000A58_A155ConTipoLiqGanancias, BC000A58_n155ConTipoLiqGanancias, BC000A58_A153ConObservacion, BC000A58_A151ConHisFormula, BC000A58_n151ConHisFormula, BC000A58_A154ConTipo, BC000A58_A469ConCodOld,
            BC000A58_A487ConCuenDebe, BC000A58_n487ConCuenDebe, BC000A58_A488ConCuenHaber, BC000A58_n488ConCuenHaber, BC000A58_A503ConTipoLiqAux, BC000A58_n503ConTipoLiqAux, BC000A58_A969ConConveAux, BC000A58_n969ConConveAux, BC000A58_A970ConClasifAux, BC000A58_n970ConClasifAux,
            BC000A58_A510ConOrdEjec, BC000A58_A569ConFormulaExpl, BC000A58_A720ConFormulaObs2, BC000A58_A734ConRetGanPropor, BC000A58_A735ConAplicGan, BC000A58_n735ConAplicGan, BC000A58_A762ConRecalcular, BC000A58_A894ConImportado, BC000A58_A895ConTipoOrden, BC000A58_A1017ConEdiEnRec,
            BC000A58_A1018ConRangoCant, BC000A58_A922ConUsado, BC000A58_A951ConObliga, BC000A58_n951ConObliga, BC000A58_A952ConObligaSiSac, BC000A58_n952ConObligaSiSac, BC000A58_A954ConCondCodigo, BC000A58_A1066ConPreReq, BC000A58_n1066ConPreReq, BC000A58_A1068ConMostrarPos,
            BC000A58_A1077ConAdelDescu, BC000A58_n1077ConAdelDescu, BC000A58_A1194ConSegunPla, BC000A58_A1471ConNumero, BC000A58_A1472ConSIPAApo, BC000A58_A1473ConSIPACont, BC000A58_A1474ConINSSJyPApo, BC000A58_A1475ConINSSJyPCont, BC000A58_A1476ConObraSocApo, BC000A58_A1477ConObraSocCont,
            BC000A58_A1478ConFonSolRedApo, BC000A58_A1479ConFonSolRedCont, BC000A58_A1480ConRenateaApo, BC000A58_A1481ConRenateaCont, BC000A58_A1482ConAsigFamCont, BC000A58_A1483ConFonNacEmpCont, BC000A58_A1484ConLeyRieTrabCont, BC000A58_A1485ConRegDifApo, BC000A58_A1486ConRegEspApo, BC000A58_A1539ConSacDeven,
            BC000A58_A1620ConBaseLic, BC000A58_A1797ConBaseLicProm, BC000A58_A1621ConBaseFer, BC000A58_A1798ConBaseFerProm, BC000A58_A1622ConBaseHorExt, BC000A58_A1799ConBaseHorExtProm, BC000A58_A1800ConBasePres, BC000A58_A1801ConBaseAnt, BC000A58_A1827ConBaseOSDif, BC000A58_A2191ConBaseAus,
            BC000A58_A2192ConBaseAusProm, BC000A58_A1648ConCodAfip, BC000A58_A1769ConCntPa, BC000A58_A1821ConErrorSiCero, BC000A58_A1826ConPueNov, BC000A58_A1886ConRelSec, BC000A58_A2013ConRelRef, BC000A58_A2185ConDescripSinAc, BC000A58_A2187ConOblPalabra, BC000A58_n2187ConOblPalabra,
            BC000A58_A1822CliPadre, BC000A58_n1822CliPadre, BC000A58_A3CliCod, BC000A58_A1112AplIIGG, BC000A58_n1112AplIIGG, BC000A58_A37TipoConCod, BC000A58_A38SubTipoConCod1, BC000A58_n38SubTipoConCod1, BC000A58_A39SubTipoConCod2, BC000A58_n39SubTipoConCod2,
            BC000A58_A953ConCondicion, BC000A58_n953ConCondicion, BC000A58_A1644ConceptoPais, BC000A58_n1644ConceptoPais, BC000A58_A1645ConceptoConveCodigo, BC000A58_n1645ConceptoConveCodigo, BC000A58_A921ConPadre, BC000A58_n921ConPadre
            }
            , new Object[] {
            BC000A59_A26ConCodigo, BC000A59_A340TliqDesc, BC000A59_A925ConTLiqSinCausa, BC000A59_n925ConTLiqSinCausa, BC000A59_A926ConTLiqSinPre, BC000A59_n926ConTLiqSinPre, BC000A59_A950ConTLTipEgr, BC000A59_A1406ConTLOrdejec, BC000A59_A1407ConTLConOrd, BC000A59_A1409ConTLVigencia,
            BC000A59_n1409ConTLVigencia, BC000A59_A1410ConTLCondicion, BC000A59_n1410ConTLCondicion, BC000A59_A1470ConTLConHab, BC000A59_A1788ConTLTipoCon, BC000A59_n1788ConTLTipoCon, BC000A59_A1789CONTLSegPla, BC000A59_n1789CONTLSegPla, BC000A59_A3CliCod, BC000A59_A32TLiqCod
            }
            , new Object[] {
            BC000A60_A340TliqDesc
            }
            , new Object[] {
            BC000A61_A3CliCod, BC000A61_A26ConCodigo, BC000A61_A32TLiqCod
            }
            , new Object[] {
            BC000A62_A26ConCodigo, BC000A62_A925ConTLiqSinCausa, BC000A62_n925ConTLiqSinCausa, BC000A62_A926ConTLiqSinPre, BC000A62_n926ConTLiqSinPre, BC000A62_A950ConTLTipEgr, BC000A62_A1406ConTLOrdejec, BC000A62_A1407ConTLConOrd, BC000A62_A1409ConTLVigencia, BC000A62_n1409ConTLVigencia,
            BC000A62_A1410ConTLCondicion, BC000A62_n1410ConTLCondicion, BC000A62_A1470ConTLConHab, BC000A62_A1788ConTLTipoCon, BC000A62_n1788ConTLTipoCon, BC000A62_A1789CONTLSegPla, BC000A62_n1789CONTLSegPla, BC000A62_A3CliCod, BC000A62_A32TLiqCod
            }
            , new Object[] {
            BC000A63_A26ConCodigo, BC000A63_A925ConTLiqSinCausa, BC000A63_n925ConTLiqSinCausa, BC000A63_A926ConTLiqSinPre, BC000A63_n926ConTLiqSinPre, BC000A63_A950ConTLTipEgr, BC000A63_A1406ConTLOrdejec, BC000A63_A1407ConTLConOrd, BC000A63_A1409ConTLVigencia, BC000A63_n1409ConTLVigencia,
            BC000A63_A1410ConTLCondicion, BC000A63_n1410ConTLCondicion, BC000A63_A1470ConTLConHab, BC000A63_A1788ConTLTipoCon, BC000A63_n1788ConTLTipoCon, BC000A63_A1789CONTLSegPla, BC000A63_n1789CONTLSegPla, BC000A63_A3CliCod, BC000A63_A32TLiqCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000A67_A340TliqDesc
            }
            , new Object[] {
            BC000A68_A26ConCodigo, BC000A68_A340TliqDesc, BC000A68_A925ConTLiqSinCausa, BC000A68_n925ConTLiqSinCausa, BC000A68_A926ConTLiqSinPre, BC000A68_n926ConTLiqSinPre, BC000A68_A950ConTLTipEgr, BC000A68_A1406ConTLOrdejec, BC000A68_A1407ConTLConOrd, BC000A68_A1409ConTLVigencia,
            BC000A68_n1409ConTLVigencia, BC000A68_A1410ConTLCondicion, BC000A68_n1410ConTLCondicion, BC000A68_A1470ConTLConHab, BC000A68_A1788ConTLTipoCon, BC000A68_n1788ConTLTipoCon, BC000A68_A1789CONTLSegPla, BC000A68_n1789CONTLSegPla, BC000A68_A3CliCod, BC000A68_A32TLiqCod
            }
            , new Object[] {
            BC000A69_A26ConCodigo, BC000A69_A2077ConMegSec, BC000A69_A1532MegPreaTipo, BC000A69_A1530ConMegMeses, BC000A69_A1534ConMegDura, BC000A69_A1529ConMegPropor, BC000A69_A3CliCod, BC000A69_A11MegCodigo
            }
            , new Object[] {
            BC000A70_A3CliCod
            }
            , new Object[] {
            BC000A71_A3CliCod
            }
            , new Object[] {
            BC000A72_A3CliCod, BC000A72_A26ConCodigo, BC000A72_A11MegCodigo, BC000A72_A2077ConMegSec
            }
            , new Object[] {
            BC000A73_A26ConCodigo, BC000A73_A2077ConMegSec, BC000A73_A1532MegPreaTipo, BC000A73_A1530ConMegMeses, BC000A73_A1534ConMegDura, BC000A73_A1529ConMegPropor, BC000A73_A3CliCod, BC000A73_A11MegCodigo
            }
            , new Object[] {
            BC000A74_A26ConCodigo, BC000A74_A2077ConMegSec, BC000A74_A1532MegPreaTipo, BC000A74_A1530ConMegMeses, BC000A74_A1534ConMegDura, BC000A74_A1529ConMegPropor, BC000A74_A3CliCod, BC000A74_A11MegCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000A78_A26ConCodigo, BC000A78_A2077ConMegSec, BC000A78_A1532MegPreaTipo, BC000A78_A1530ConMegMeses, BC000A78_A1534ConMegDura, BC000A78_A1529ConMegPropor, BC000A78_A3CliCod, BC000A78_A11MegCodigo
            }
         }
      );
      AV37Pgmname = "Concepto_BC" ;
      Z155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      A155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      N155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      i155ConTipoLiqGanancias = "N" ;
      n155ConTipoLiqGanancias = false ;
      Z150ConHabilitado = true ;
      A150ConHabilitado = true ;
      i150ConHabilitado = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120A2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z162ConVigencia ;
   private byte A162ConVigencia ;
   private byte Z1488ConLiqBasica ;
   private byte A1488ConLiqBasica ;
   private byte Z154ConTipo ;
   private byte A154ConTipo ;
   private byte Z735ConAplicGan ;
   private byte A735ConAplicGan ;
   private byte Z1077ConAdelDescu ;
   private byte A1077ConAdelDescu ;
   private byte Z1471ConNumero ;
   private byte A1471ConNumero ;
   private byte Z1472ConSIPAApo ;
   private byte A1472ConSIPAApo ;
   private byte Z1473ConSIPACont ;
   private byte A1473ConSIPACont ;
   private byte Z1474ConINSSJyPApo ;
   private byte A1474ConINSSJyPApo ;
   private byte Z1475ConINSSJyPCont ;
   private byte A1475ConINSSJyPCont ;
   private byte Z1476ConObraSocApo ;
   private byte A1476ConObraSocApo ;
   private byte Z1477ConObraSocCont ;
   private byte A1477ConObraSocCont ;
   private byte Z1478ConFonSolRedApo ;
   private byte A1478ConFonSolRedApo ;
   private byte Z1479ConFonSolRedCont ;
   private byte A1479ConFonSolRedCont ;
   private byte Z1480ConRenateaApo ;
   private byte A1480ConRenateaApo ;
   private byte Z1481ConRenateaCont ;
   private byte A1481ConRenateaCont ;
   private byte Z1482ConAsigFamCont ;
   private byte A1482ConAsigFamCont ;
   private byte Z1483ConFonNacEmpCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte Z1484ConLeyRieTrabCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte Z1485ConRegDifApo ;
   private byte A1485ConRegDifApo ;
   private byte Z1486ConRegEspApo ;
   private byte A1486ConRegEspApo ;
   private byte Z1539ConSacDeven ;
   private byte A1539ConSacDeven ;
   private byte Z1620ConBaseLic ;
   private byte A1620ConBaseLic ;
   private byte Z1797ConBaseLicProm ;
   private byte A1797ConBaseLicProm ;
   private byte Z1621ConBaseFer ;
   private byte A1621ConBaseFer ;
   private byte Z1798ConBaseFerProm ;
   private byte A1798ConBaseFerProm ;
   private byte Z1622ConBaseHorExt ;
   private byte A1622ConBaseHorExt ;
   private byte Z1799ConBaseHorExtProm ;
   private byte A1799ConBaseHorExtProm ;
   private byte Z1800ConBasePres ;
   private byte A1800ConBasePres ;
   private byte Z1801ConBaseAnt ;
   private byte A1801ConBaseAnt ;
   private byte Z1827ConBaseOSDif ;
   private byte A1827ConBaseOSDif ;
   private byte Z2191ConBaseAus ;
   private byte A2191ConBaseAus ;
   private byte Z2192ConBaseAusProm ;
   private byte A2192ConBaseAusProm ;
   private byte Z1769ConCntPa ;
   private byte A1769ConCntPa ;
   private byte Gx_BScreen ;
   private byte O1620ConBaseLic ;
   private byte O1797ConBaseLicProm ;
   private byte O1621ConBaseFer ;
   private byte O1798ConBaseFerProm ;
   private byte O1622ConBaseHorExt ;
   private byte O1799ConBaseHorExtProm ;
   private byte O1800ConBasePres ;
   private byte O1801ConBaseAnt ;
   private byte O1827ConBaseOSDif ;
   private byte O2191ConBaseAus ;
   private byte O2192ConBaseAusProm ;
   private byte Gxremove8 ;
   private byte Gxremove261 ;
   private byte Z1409ConTLVigencia ;
   private byte A1409ConTLVigencia ;
   private byte Z1470ConTLConHab ;
   private byte A1470ConTLConHab ;
   private byte Z1789CONTLSegPla ;
   private byte A1789CONTLSegPla ;
   private byte Z1530ConMegMeses ;
   private byte A1530ConMegMeses ;
   private byte N162ConVigencia ;
   private byte N735ConAplicGan ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_261 ;
   private short RcdFound261 ;
   private short nIsMod_8 ;
   private short RcdFound8 ;
   private short AV30Insert_AplIIGG ;
   private short AV32Insert_ConceptoPais ;
   private short AV13EmpCod ;
   private short GXt_int6 ;
   private short GXv_int7[] ;
   private short Z895ConTipoOrden ;
   private short A895ConTipoOrden ;
   private short Z1112AplIIGG ;
   private short A1112AplIIGG ;
   private short Z1644ConceptoPais ;
   private short A1644ConceptoPais ;
   private short RcdFound7 ;
   private short nIsDirty_7 ;
   private short nRcdExists_8 ;
   private short nRcdExists_261 ;
   private short Z1407ConTLConOrd ;
   private short A1407ConTLConOrd ;
   private short nIsDirty_8 ;
   private short Z2077ConMegSec ;
   private short A2077ConMegSec ;
   private short nIsDirty_261 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_261_idx=1 ;
   private int nGXsfl_8_idx=1 ;
   private int AV38GXV1 ;
   private int AV35Insert_CliPadre ;
   private int AV7CliCod ;
   private int GX_JID ;
   private int Z1905ConRelSecCli ;
   private int A1905ConRelSecCli ;
   private int Z40ConOrden ;
   private int A40ConOrden ;
   private int Z1886ConRelSec ;
   private int A1886ConRelSec ;
   private int Z1822CliPadre ;
   private int A1822CliPadre ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int N40ConOrden ;
   private int i1905ConRelSecCli ;
   private long Z510ConOrdEjec ;
   private long A510ConOrdEjec ;
   private long Z1406ConTLOrdejec ;
   private long A1406ConTLOrdejec ;
   private java.math.BigDecimal Z157ConValorGen ;
   private java.math.BigDecimal A157ConValorGen ;
   private java.math.BigDecimal Z1529ConMegPropor ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private java.math.BigDecimal N157ConValorGen ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z26ConCodigo ;
   private String A26ConCodigo ;
   private String sMode7 ;
   private String AV37Pgmname ;
   private String AV23Insert_TipoConCod ;
   private String AV24Insert_SubTipoConCod1 ;
   private String AV25Insert_SubTipoConCod2 ;
   private String AV34Insert_ConCondicion ;
   private String AV33Insert_ConceptoConveCodigo ;
   private String AV29Insert_ConPadre ;
   private String AV11ConCodigo ;
   private String AV27defaultConCodigo ;
   private String Z156ConUsuModFor ;
   private String A156ConUsuModFor ;
   private String Z155ConTipoLiqGanancias ;
   private String A155ConTipoLiqGanancias ;
   private String Z469ConCodOld ;
   private String A469ConCodOld ;
   private String Z487ConCuenDebe ;
   private String A487ConCuenDebe ;
   private String Z488ConCuenHaber ;
   private String A488ConCuenHaber ;
   private String Z954ConCondCodigo ;
   private String A954ConCondCodigo ;
   private String Z1066ConPreReq ;
   private String A1066ConPreReq ;
   private String Z1648ConCodAfip ;
   private String A1648ConCodAfip ;
   private String Z2187ConOblPalabra ;
   private String A2187ConOblPalabra ;
   private String Z37TipoConCod ;
   private String A37TipoConCod ;
   private String Z38SubTipoConCod1 ;
   private String A38SubTipoConCod1 ;
   private String Z39SubTipoConCod2 ;
   private String A39SubTipoConCod2 ;
   private String Z953ConCondicion ;
   private String A953ConCondicion ;
   private String Z1645ConceptoConveCodigo ;
   private String A1645ConceptoConveCodigo ;
   private String Z921ConPadre ;
   private String A921ConPadre ;
   private String Z149ConFormulaAbr ;
   private String A149ConFormulaAbr ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String Z950ConTLTipEgr ;
   private String A950ConTLTipEgr ;
   private String Z1410ConTLCondicion ;
   private String A1410ConTLCondicion ;
   private String Z1788ConTLTipoCon ;
   private String A1788ConTLTipoCon ;
   private String Z32TLiqCod ;
   private String A32TLiqCod ;
   private String sMode8 ;
   private String N32TLiqCod ;
   private String Z1532MegPreaTipo ;
   private String A1532MegPreaTipo ;
   private String Z1534ConMegDura ;
   private String A1534ConMegDura ;
   private String Z11MegCodigo ;
   private String A11MegCodigo ;
   private String sMode261 ;
   private String N155ConTipoLiqGanancias ;
   private String N37TipoConCod ;
   private String N38SubTipoConCod1 ;
   private String N39SubTipoConCod2 ;
   private String i149ConFormulaAbr ;
   private String i155ConTipoLiqGanancias ;
   private java.util.Date Z145ConFchModFor ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date GXt_dtime10 ;
   private java.util.Date GXv_dtime11[] ;
   private boolean returnInSub ;
   private boolean AV15IsAuthorized ;
   private boolean AV14esSistemaConceptosDefault ;
   private boolean AV17permiteModificacion ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean AV16mostrarEditable ;
   private boolean Z143ConCanti ;
   private boolean A143ConCanti ;
   private boolean Z158ConValUni ;
   private boolean A158ConValUni ;
   private boolean Z152ConImporte ;
   private boolean A152ConImporte ;
   private boolean Z159ConVariable ;
   private boolean A159ConVariable ;
   private boolean Z150ConHabilitado ;
   private boolean A150ConHabilitado ;
   private boolean Z734ConRetGanPropor ;
   private boolean A734ConRetGanPropor ;
   private boolean Z762ConRecalcular ;
   private boolean A762ConRecalcular ;
   private boolean Z894ConImportado ;
   private boolean A894ConImportado ;
   private boolean Z1017ConEdiEnRec ;
   private boolean A1017ConEdiEnRec ;
   private boolean Z922ConUsado ;
   private boolean A922ConUsado ;
   private boolean Z951ConObliga ;
   private boolean A951ConObliga ;
   private boolean Z952ConObligaSiSac ;
   private boolean A952ConObligaSiSac ;
   private boolean Z1068ConMostrarPos ;
   private boolean A1068ConMostrarPos ;
   private boolean Z1194ConSegunPla ;
   private boolean A1194ConSegunPla ;
   private boolean Z1821ConErrorSiCero ;
   private boolean A1821ConErrorSiCero ;
   private boolean Z1826ConPueNov ;
   private boolean A1826ConPueNov ;
   private boolean n155ConTipoLiqGanancias ;
   private boolean n42ConCodYDesc ;
   private boolean n145ConFchModFor ;
   private boolean n156ConUsuModFor ;
   private boolean n148ConFormula ;
   private boolean n157ConValorGen ;
   private boolean n151ConHisFormula ;
   private boolean n487ConCuenDebe ;
   private boolean n488ConCuenHaber ;
   private boolean n503ConTipoLiqAux ;
   private boolean n969ConConveAux ;
   private boolean n970ConClasifAux ;
   private boolean n735ConAplicGan ;
   private boolean n951ConObliga ;
   private boolean n952ConObligaSiSac ;
   private boolean n1066ConPreReq ;
   private boolean n1077ConAdelDescu ;
   private boolean n2187ConOblPalabra ;
   private boolean n1822CliPadre ;
   private boolean n1112AplIIGG ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n953ConCondicion ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n921ConPadre ;
   private boolean Gx_longc ;
   private boolean Z925ConTLiqSinCausa ;
   private boolean A925ConTLiqSinCausa ;
   private boolean Z926ConTLiqSinPre ;
   private boolean A926ConTLiqSinPre ;
   private boolean n925ConTLiqSinCausa ;
   private boolean n926ConTLiqSinPre ;
   private boolean n1409ConTLVigencia ;
   private boolean n1410ConTLCondicion ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1789CONTLSegPla ;
   private boolean N762ConRecalcular ;
   private boolean N159ConVariable ;
   private boolean i150ConHabilitado ;
   private boolean mustCommit ;
   private String Z1974ConOldValues ;
   private String A1974ConOldValues ;
   private String Z148ConFormula ;
   private String A148ConFormula ;
   private String Z729ConFormulaPreResuelta ;
   private String A729ConFormulaPreResuelta ;
   private String Z153ConObservacion ;
   private String A153ConObservacion ;
   private String Z151ConHisFormula ;
   private String A151ConHisFormula ;
   private String Z569ConFormulaExpl ;
   private String A569ConFormulaExpl ;
   private String Z720ConFormulaObs2 ;
   private String A720ConFormulaObs2 ;
   private String N153ConObservacion ;
   private String Z42ConCodYDesc ;
   private String A42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String A41ConDescrip ;
   private String Z503ConTipoLiqAux ;
   private String A503ConTipoLiqAux ;
   private String Z969ConConveAux ;
   private String A969ConConveAux ;
   private String Z970ConClasifAux ;
   private String A970ConClasifAux ;
   private String Z1018ConRangoCant ;
   private String A1018ConRangoCant ;
   private String Z2013ConRelRef ;
   private String A2013ConRelRef ;
   private String Z2185ConDescripSinAc ;
   private String A2185ConDescripSinAc ;
   private String O41ConDescrip ;
   private String Z340TliqDesc ;
   private String A340TliqDesc ;
   private String N41ConDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV21WebSession ;
   private web.SdtConcepto bcConcepto ;
   private IDataStoreProvider pr_default ;
   private String[] BC000A18_A42ConCodYDesc ;
   private boolean[] BC000A18_n42ConCodYDesc ;
   private String[] BC000A18_A26ConCodigo ;
   private java.util.Date[] BC000A18_A145ConFchModFor ;
   private boolean[] BC000A18_n145ConFchModFor ;
   private String[] BC000A18_A156ConUsuModFor ;
   private boolean[] BC000A18_n156ConUsuModFor ;
   private boolean[] BC000A18_A143ConCanti ;
   private boolean[] BC000A18_A158ConValUni ;
   private boolean[] BC000A18_A152ConImporte ;
   private boolean[] BC000A18_A159ConVariable ;
   private int[] BC000A18_A1905ConRelSecCli ;
   private String[] BC000A18_A1974ConOldValues ;
   private String[] BC000A18_A41ConDescrip ;
   private boolean[] BC000A18_A150ConHabilitado ;
   private int[] BC000A18_A40ConOrden ;
   private byte[] BC000A18_A162ConVigencia ;
   private byte[] BC000A18_A1488ConLiqBasica ;
   private String[] BC000A18_A148ConFormula ;
   private boolean[] BC000A18_n148ConFormula ;
   private String[] BC000A18_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A18_A157ConValorGen ;
   private boolean[] BC000A18_n157ConValorGen ;
   private String[] BC000A18_A155ConTipoLiqGanancias ;
   private boolean[] BC000A18_n155ConTipoLiqGanancias ;
   private String[] BC000A18_A153ConObservacion ;
   private String[] BC000A18_A151ConHisFormula ;
   private boolean[] BC000A18_n151ConHisFormula ;
   private byte[] BC000A18_A154ConTipo ;
   private String[] BC000A18_A469ConCodOld ;
   private String[] BC000A18_A487ConCuenDebe ;
   private boolean[] BC000A18_n487ConCuenDebe ;
   private String[] BC000A18_A488ConCuenHaber ;
   private boolean[] BC000A18_n488ConCuenHaber ;
   private String[] BC000A18_A503ConTipoLiqAux ;
   private boolean[] BC000A18_n503ConTipoLiqAux ;
   private String[] BC000A18_A969ConConveAux ;
   private boolean[] BC000A18_n969ConConveAux ;
   private String[] BC000A18_A970ConClasifAux ;
   private boolean[] BC000A18_n970ConClasifAux ;
   private long[] BC000A18_A510ConOrdEjec ;
   private String[] BC000A18_A569ConFormulaExpl ;
   private String[] BC000A18_A720ConFormulaObs2 ;
   private boolean[] BC000A18_A734ConRetGanPropor ;
   private byte[] BC000A18_A735ConAplicGan ;
   private boolean[] BC000A18_n735ConAplicGan ;
   private boolean[] BC000A18_A762ConRecalcular ;
   private boolean[] BC000A18_A894ConImportado ;
   private short[] BC000A18_A895ConTipoOrden ;
   private boolean[] BC000A18_A1017ConEdiEnRec ;
   private String[] BC000A18_A1018ConRangoCant ;
   private boolean[] BC000A18_A922ConUsado ;
   private boolean[] BC000A18_A951ConObliga ;
   private boolean[] BC000A18_n951ConObliga ;
   private boolean[] BC000A18_A952ConObligaSiSac ;
   private boolean[] BC000A18_n952ConObligaSiSac ;
   private String[] BC000A18_A954ConCondCodigo ;
   private String[] BC000A18_A1066ConPreReq ;
   private boolean[] BC000A18_n1066ConPreReq ;
   private boolean[] BC000A18_A1068ConMostrarPos ;
   private byte[] BC000A18_A1077ConAdelDescu ;
   private boolean[] BC000A18_n1077ConAdelDescu ;
   private boolean[] BC000A18_A1194ConSegunPla ;
   private byte[] BC000A18_A1471ConNumero ;
   private byte[] BC000A18_A1472ConSIPAApo ;
   private byte[] BC000A18_A1473ConSIPACont ;
   private byte[] BC000A18_A1474ConINSSJyPApo ;
   private byte[] BC000A18_A1475ConINSSJyPCont ;
   private byte[] BC000A18_A1476ConObraSocApo ;
   private byte[] BC000A18_A1477ConObraSocCont ;
   private byte[] BC000A18_A1478ConFonSolRedApo ;
   private byte[] BC000A18_A1479ConFonSolRedCont ;
   private byte[] BC000A18_A1480ConRenateaApo ;
   private byte[] BC000A18_A1481ConRenateaCont ;
   private byte[] BC000A18_A1482ConAsigFamCont ;
   private byte[] BC000A18_A1483ConFonNacEmpCont ;
   private byte[] BC000A18_A1484ConLeyRieTrabCont ;
   private byte[] BC000A18_A1485ConRegDifApo ;
   private byte[] BC000A18_A1486ConRegEspApo ;
   private byte[] BC000A18_A1539ConSacDeven ;
   private byte[] BC000A18_A1620ConBaseLic ;
   private byte[] BC000A18_A1797ConBaseLicProm ;
   private byte[] BC000A18_A1621ConBaseFer ;
   private byte[] BC000A18_A1798ConBaseFerProm ;
   private byte[] BC000A18_A1622ConBaseHorExt ;
   private byte[] BC000A18_A1799ConBaseHorExtProm ;
   private byte[] BC000A18_A1800ConBasePres ;
   private byte[] BC000A18_A1801ConBaseAnt ;
   private byte[] BC000A18_A1827ConBaseOSDif ;
   private byte[] BC000A18_A2191ConBaseAus ;
   private byte[] BC000A18_A2192ConBaseAusProm ;
   private String[] BC000A18_A1648ConCodAfip ;
   private byte[] BC000A18_A1769ConCntPa ;
   private boolean[] BC000A18_A1821ConErrorSiCero ;
   private boolean[] BC000A18_A1826ConPueNov ;
   private int[] BC000A18_A1886ConRelSec ;
   private String[] BC000A18_A2013ConRelRef ;
   private String[] BC000A18_A2185ConDescripSinAc ;
   private String[] BC000A18_A2187ConOblPalabra ;
   private boolean[] BC000A18_n2187ConOblPalabra ;
   private int[] BC000A18_A1822CliPadre ;
   private boolean[] BC000A18_n1822CliPadre ;
   private int[] BC000A18_A3CliCod ;
   private short[] BC000A18_A1112AplIIGG ;
   private boolean[] BC000A18_n1112AplIIGG ;
   private String[] BC000A18_A37TipoConCod ;
   private String[] BC000A18_A38SubTipoConCod1 ;
   private boolean[] BC000A18_n38SubTipoConCod1 ;
   private String[] BC000A18_A39SubTipoConCod2 ;
   private boolean[] BC000A18_n39SubTipoConCod2 ;
   private String[] BC000A18_A953ConCondicion ;
   private boolean[] BC000A18_n953ConCondicion ;
   private short[] BC000A18_A1644ConceptoPais ;
   private boolean[] BC000A18_n1644ConceptoPais ;
   private String[] BC000A18_A1645ConceptoConveCodigo ;
   private boolean[] BC000A18_n1645ConceptoConveCodigo ;
   private String[] BC000A18_A921ConPadre ;
   private boolean[] BC000A18_n921ConPadre ;
   private int[] BC000A19_A3CliCod ;
   private String[] BC000A20_A37TipoConCod ;
   private String[] BC000A21_A37TipoConCod ;
   private String[] BC000A22_A37TipoConCod ;
   private String[] BC000A23_A953ConCondicion ;
   private boolean[] BC000A23_n953ConCondicion ;
   private int[] BC000A24_A3CliCod ;
   private short[] BC000A25_A1644ConceptoPais ;
   private boolean[] BC000A25_n1644ConceptoPais ;
   private int[] BC000A26_A1822CliPadre ;
   private boolean[] BC000A26_n1822CliPadre ;
   private int[] BC000A27_A3CliCod ;
   private String[] BC000A27_A26ConCodigo ;
   private String[] BC000A28_A42ConCodYDesc ;
   private boolean[] BC000A28_n42ConCodYDesc ;
   private String[] BC000A28_A26ConCodigo ;
   private java.util.Date[] BC000A28_A145ConFchModFor ;
   private boolean[] BC000A28_n145ConFchModFor ;
   private String[] BC000A28_A156ConUsuModFor ;
   private boolean[] BC000A28_n156ConUsuModFor ;
   private boolean[] BC000A28_A143ConCanti ;
   private boolean[] BC000A28_A158ConValUni ;
   private boolean[] BC000A28_A152ConImporte ;
   private boolean[] BC000A28_A159ConVariable ;
   private int[] BC000A28_A1905ConRelSecCli ;
   private String[] BC000A28_A1974ConOldValues ;
   private String[] BC000A28_A41ConDescrip ;
   private boolean[] BC000A28_A150ConHabilitado ;
   private int[] BC000A28_A40ConOrden ;
   private byte[] BC000A28_A162ConVigencia ;
   private byte[] BC000A28_A1488ConLiqBasica ;
   private String[] BC000A28_A148ConFormula ;
   private boolean[] BC000A28_n148ConFormula ;
   private String[] BC000A28_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A28_A157ConValorGen ;
   private boolean[] BC000A28_n157ConValorGen ;
   private String[] BC000A28_A155ConTipoLiqGanancias ;
   private boolean[] BC000A28_n155ConTipoLiqGanancias ;
   private String[] BC000A28_A153ConObservacion ;
   private String[] BC000A28_A151ConHisFormula ;
   private boolean[] BC000A28_n151ConHisFormula ;
   private byte[] BC000A28_A154ConTipo ;
   private String[] BC000A28_A469ConCodOld ;
   private String[] BC000A28_A487ConCuenDebe ;
   private boolean[] BC000A28_n487ConCuenDebe ;
   private String[] BC000A28_A488ConCuenHaber ;
   private boolean[] BC000A28_n488ConCuenHaber ;
   private String[] BC000A28_A503ConTipoLiqAux ;
   private boolean[] BC000A28_n503ConTipoLiqAux ;
   private String[] BC000A28_A969ConConveAux ;
   private boolean[] BC000A28_n969ConConveAux ;
   private String[] BC000A28_A970ConClasifAux ;
   private boolean[] BC000A28_n970ConClasifAux ;
   private long[] BC000A28_A510ConOrdEjec ;
   private String[] BC000A28_A569ConFormulaExpl ;
   private String[] BC000A28_A720ConFormulaObs2 ;
   private boolean[] BC000A28_A734ConRetGanPropor ;
   private byte[] BC000A28_A735ConAplicGan ;
   private boolean[] BC000A28_n735ConAplicGan ;
   private boolean[] BC000A28_A762ConRecalcular ;
   private boolean[] BC000A28_A894ConImportado ;
   private short[] BC000A28_A895ConTipoOrden ;
   private boolean[] BC000A28_A1017ConEdiEnRec ;
   private String[] BC000A28_A1018ConRangoCant ;
   private boolean[] BC000A28_A922ConUsado ;
   private boolean[] BC000A28_A951ConObliga ;
   private boolean[] BC000A28_n951ConObliga ;
   private boolean[] BC000A28_A952ConObligaSiSac ;
   private boolean[] BC000A28_n952ConObligaSiSac ;
   private String[] BC000A28_A954ConCondCodigo ;
   private String[] BC000A28_A1066ConPreReq ;
   private boolean[] BC000A28_n1066ConPreReq ;
   private boolean[] BC000A28_A1068ConMostrarPos ;
   private byte[] BC000A28_A1077ConAdelDescu ;
   private boolean[] BC000A28_n1077ConAdelDescu ;
   private boolean[] BC000A28_A1194ConSegunPla ;
   private byte[] BC000A28_A1471ConNumero ;
   private byte[] BC000A28_A1472ConSIPAApo ;
   private byte[] BC000A28_A1473ConSIPACont ;
   private byte[] BC000A28_A1474ConINSSJyPApo ;
   private byte[] BC000A28_A1475ConINSSJyPCont ;
   private byte[] BC000A28_A1476ConObraSocApo ;
   private byte[] BC000A28_A1477ConObraSocCont ;
   private byte[] BC000A28_A1478ConFonSolRedApo ;
   private byte[] BC000A28_A1479ConFonSolRedCont ;
   private byte[] BC000A28_A1480ConRenateaApo ;
   private byte[] BC000A28_A1481ConRenateaCont ;
   private byte[] BC000A28_A1482ConAsigFamCont ;
   private byte[] BC000A28_A1483ConFonNacEmpCont ;
   private byte[] BC000A28_A1484ConLeyRieTrabCont ;
   private byte[] BC000A28_A1485ConRegDifApo ;
   private byte[] BC000A28_A1486ConRegEspApo ;
   private byte[] BC000A28_A1539ConSacDeven ;
   private byte[] BC000A28_A1620ConBaseLic ;
   private byte[] BC000A28_A1797ConBaseLicProm ;
   private byte[] BC000A28_A1621ConBaseFer ;
   private byte[] BC000A28_A1798ConBaseFerProm ;
   private byte[] BC000A28_A1622ConBaseHorExt ;
   private byte[] BC000A28_A1799ConBaseHorExtProm ;
   private byte[] BC000A28_A1800ConBasePres ;
   private byte[] BC000A28_A1801ConBaseAnt ;
   private byte[] BC000A28_A1827ConBaseOSDif ;
   private byte[] BC000A28_A2191ConBaseAus ;
   private byte[] BC000A28_A2192ConBaseAusProm ;
   private String[] BC000A28_A1648ConCodAfip ;
   private byte[] BC000A28_A1769ConCntPa ;
   private boolean[] BC000A28_A1821ConErrorSiCero ;
   private boolean[] BC000A28_A1826ConPueNov ;
   private int[] BC000A28_A1886ConRelSec ;
   private String[] BC000A28_A2013ConRelRef ;
   private String[] BC000A28_A2185ConDescripSinAc ;
   private String[] BC000A28_A2187ConOblPalabra ;
   private boolean[] BC000A28_n2187ConOblPalabra ;
   private int[] BC000A28_A1822CliPadre ;
   private boolean[] BC000A28_n1822CliPadre ;
   private int[] BC000A28_A3CliCod ;
   private short[] BC000A28_A1112AplIIGG ;
   private boolean[] BC000A28_n1112AplIIGG ;
   private String[] BC000A28_A37TipoConCod ;
   private String[] BC000A28_A38SubTipoConCod1 ;
   private boolean[] BC000A28_n38SubTipoConCod1 ;
   private String[] BC000A28_A39SubTipoConCod2 ;
   private boolean[] BC000A28_n39SubTipoConCod2 ;
   private String[] BC000A28_A953ConCondicion ;
   private boolean[] BC000A28_n953ConCondicion ;
   private short[] BC000A28_A1644ConceptoPais ;
   private boolean[] BC000A28_n1644ConceptoPais ;
   private String[] BC000A28_A1645ConceptoConveCodigo ;
   private boolean[] BC000A28_n1645ConceptoConveCodigo ;
   private String[] BC000A28_A921ConPadre ;
   private boolean[] BC000A28_n921ConPadre ;
   private String[] BC000A29_A42ConCodYDesc ;
   private boolean[] BC000A29_n42ConCodYDesc ;
   private String[] BC000A29_A26ConCodigo ;
   private java.util.Date[] BC000A29_A145ConFchModFor ;
   private boolean[] BC000A29_n145ConFchModFor ;
   private String[] BC000A29_A156ConUsuModFor ;
   private boolean[] BC000A29_n156ConUsuModFor ;
   private boolean[] BC000A29_A143ConCanti ;
   private boolean[] BC000A29_A158ConValUni ;
   private boolean[] BC000A29_A152ConImporte ;
   private boolean[] BC000A29_A159ConVariable ;
   private int[] BC000A29_A1905ConRelSecCli ;
   private String[] BC000A29_A1974ConOldValues ;
   private String[] BC000A29_A41ConDescrip ;
   private boolean[] BC000A29_A150ConHabilitado ;
   private int[] BC000A29_A40ConOrden ;
   private byte[] BC000A29_A162ConVigencia ;
   private byte[] BC000A29_A1488ConLiqBasica ;
   private String[] BC000A29_A148ConFormula ;
   private boolean[] BC000A29_n148ConFormula ;
   private String[] BC000A29_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A29_A157ConValorGen ;
   private boolean[] BC000A29_n157ConValorGen ;
   private String[] BC000A29_A155ConTipoLiqGanancias ;
   private boolean[] BC000A29_n155ConTipoLiqGanancias ;
   private String[] BC000A29_A153ConObservacion ;
   private String[] BC000A29_A151ConHisFormula ;
   private boolean[] BC000A29_n151ConHisFormula ;
   private byte[] BC000A29_A154ConTipo ;
   private String[] BC000A29_A469ConCodOld ;
   private String[] BC000A29_A487ConCuenDebe ;
   private boolean[] BC000A29_n487ConCuenDebe ;
   private String[] BC000A29_A488ConCuenHaber ;
   private boolean[] BC000A29_n488ConCuenHaber ;
   private String[] BC000A29_A503ConTipoLiqAux ;
   private boolean[] BC000A29_n503ConTipoLiqAux ;
   private String[] BC000A29_A969ConConveAux ;
   private boolean[] BC000A29_n969ConConveAux ;
   private String[] BC000A29_A970ConClasifAux ;
   private boolean[] BC000A29_n970ConClasifAux ;
   private long[] BC000A29_A510ConOrdEjec ;
   private String[] BC000A29_A569ConFormulaExpl ;
   private String[] BC000A29_A720ConFormulaObs2 ;
   private boolean[] BC000A29_A734ConRetGanPropor ;
   private byte[] BC000A29_A735ConAplicGan ;
   private boolean[] BC000A29_n735ConAplicGan ;
   private boolean[] BC000A29_A762ConRecalcular ;
   private boolean[] BC000A29_A894ConImportado ;
   private short[] BC000A29_A895ConTipoOrden ;
   private boolean[] BC000A29_A1017ConEdiEnRec ;
   private String[] BC000A29_A1018ConRangoCant ;
   private boolean[] BC000A29_A922ConUsado ;
   private boolean[] BC000A29_A951ConObliga ;
   private boolean[] BC000A29_n951ConObliga ;
   private boolean[] BC000A29_A952ConObligaSiSac ;
   private boolean[] BC000A29_n952ConObligaSiSac ;
   private String[] BC000A29_A954ConCondCodigo ;
   private String[] BC000A29_A1066ConPreReq ;
   private boolean[] BC000A29_n1066ConPreReq ;
   private boolean[] BC000A29_A1068ConMostrarPos ;
   private byte[] BC000A29_A1077ConAdelDescu ;
   private boolean[] BC000A29_n1077ConAdelDescu ;
   private boolean[] BC000A29_A1194ConSegunPla ;
   private byte[] BC000A29_A1471ConNumero ;
   private byte[] BC000A29_A1472ConSIPAApo ;
   private byte[] BC000A29_A1473ConSIPACont ;
   private byte[] BC000A29_A1474ConINSSJyPApo ;
   private byte[] BC000A29_A1475ConINSSJyPCont ;
   private byte[] BC000A29_A1476ConObraSocApo ;
   private byte[] BC000A29_A1477ConObraSocCont ;
   private byte[] BC000A29_A1478ConFonSolRedApo ;
   private byte[] BC000A29_A1479ConFonSolRedCont ;
   private byte[] BC000A29_A1480ConRenateaApo ;
   private byte[] BC000A29_A1481ConRenateaCont ;
   private byte[] BC000A29_A1482ConAsigFamCont ;
   private byte[] BC000A29_A1483ConFonNacEmpCont ;
   private byte[] BC000A29_A1484ConLeyRieTrabCont ;
   private byte[] BC000A29_A1485ConRegDifApo ;
   private byte[] BC000A29_A1486ConRegEspApo ;
   private byte[] BC000A29_A1539ConSacDeven ;
   private byte[] BC000A29_A1620ConBaseLic ;
   private byte[] BC000A29_A1797ConBaseLicProm ;
   private byte[] BC000A29_A1621ConBaseFer ;
   private byte[] BC000A29_A1798ConBaseFerProm ;
   private byte[] BC000A29_A1622ConBaseHorExt ;
   private byte[] BC000A29_A1799ConBaseHorExtProm ;
   private byte[] BC000A29_A1800ConBasePres ;
   private byte[] BC000A29_A1801ConBaseAnt ;
   private byte[] BC000A29_A1827ConBaseOSDif ;
   private byte[] BC000A29_A2191ConBaseAus ;
   private byte[] BC000A29_A2192ConBaseAusProm ;
   private String[] BC000A29_A1648ConCodAfip ;
   private byte[] BC000A29_A1769ConCntPa ;
   private boolean[] BC000A29_A1821ConErrorSiCero ;
   private boolean[] BC000A29_A1826ConPueNov ;
   private int[] BC000A29_A1886ConRelSec ;
   private String[] BC000A29_A2013ConRelRef ;
   private String[] BC000A29_A2185ConDescripSinAc ;
   private String[] BC000A29_A2187ConOblPalabra ;
   private boolean[] BC000A29_n2187ConOblPalabra ;
   private int[] BC000A29_A1822CliPadre ;
   private boolean[] BC000A29_n1822CliPadre ;
   private int[] BC000A29_A3CliCod ;
   private short[] BC000A29_A1112AplIIGG ;
   private boolean[] BC000A29_n1112AplIIGG ;
   private String[] BC000A29_A37TipoConCod ;
   private String[] BC000A29_A38SubTipoConCod1 ;
   private boolean[] BC000A29_n38SubTipoConCod1 ;
   private String[] BC000A29_A39SubTipoConCod2 ;
   private boolean[] BC000A29_n39SubTipoConCod2 ;
   private String[] BC000A29_A953ConCondicion ;
   private boolean[] BC000A29_n953ConCondicion ;
   private short[] BC000A29_A1644ConceptoPais ;
   private boolean[] BC000A29_n1644ConceptoPais ;
   private String[] BC000A29_A1645ConceptoConveCodigo ;
   private boolean[] BC000A29_n1645ConceptoConveCodigo ;
   private String[] BC000A29_A921ConPadre ;
   private boolean[] BC000A29_n921ConPadre ;
   private int[] BC000A33_A1822CliPadre ;
   private boolean[] BC000A33_n1822CliPadre ;
   private String[] BC000A33_A921ConPadre ;
   private boolean[] BC000A33_n921ConPadre ;
   private short[] BC000A34_A46PaiCod ;
   private byte[] BC000A34_A1440PaiBaseClaseLeg ;
   private String[] BC000A34_A1441PaiBaseTipo ;
   private String[] BC000A34_A1442PaiBaseCod1 ;
   private String[] BC000A34_A1443PaiBaseCod2 ;
   private int[] BC000A34_A1445PaiBaseCliCod ;
   private String[] BC000A34_A1446PaiBaseConCodigo ;
   private short[] BC000A35_A46PaiCod ;
   private int[] BC000A35_A1356PaiMenCliCod ;
   private String[] BC000A35_A1358PaiMesConCodigo ;
   private short[] BC000A36_A46PaiCod ;
   private int[] BC000A36_A1354PaiJorCliCod ;
   private String[] BC000A36_A1355PaiJorConCodigo ;
   private int[] BC000A37_A3CliCod ;
   private short[] BC000A37_A1EmpCod ;
   private int[] BC000A37_A6LegNumero ;
   private short[] BC000A37_A1135LegSuelSec ;
   private String[] BC000A37_A2349LegSuelConcepto ;
   private int[] BC000A38_A3CliCod ;
   private String[] BC000A38_A26ConCodigo ;
   private String[] BC000A38_A2119ConOpeId ;
   private String[] BC000A38_A923ConOperFor ;
   private int[] BC000A39_A3CliCod ;
   private short[] BC000A39_A1EmpCod ;
   private int[] BC000A39_A6LegNumero ;
   private String[] BC000A39_A1829PreliqTLiqCod ;
   private java.util.Date[] BC000A39_A1830PreliqPeriodo ;
   private String[] BC000A39_A1831PreliqConcepto ;
   private int[] BC000A40_A3CliCod ;
   private short[] BC000A40_A1564CliPaiConve ;
   private String[] BC000A40_A1565CliConvenio ;
   private short[] BC000A40_A1327ConveHsExSec ;
   private int[] BC000A41_A3CliCod ;
   private short[] BC000A41_A1564CliPaiConve ;
   private String[] BC000A41_A1565CliConvenio ;
   private int[] BC000A41_A1381ConveMenCliCod ;
   private String[] BC000A41_A1375ConveMenConCodigo ;
   private int[] BC000A42_A3CliCod ;
   private short[] BC000A42_A1EmpCod ;
   private int[] BC000A42_A31LiqNro ;
   private int[] BC000A42_A6LegNumero ;
   private short[] BC000A42_A1541LiqAjuNro ;
   private short[] BC000A42_A1543LiqAjuSec ;
   private int[] BC000A43_A3CliCod ;
   private short[] BC000A43_A1EmpCod ;
   private String[] BC000A43_A1366EmpJorConCodigo ;
   private int[] BC000A44_A3CliCod ;
   private short[] BC000A44_A1EmpCod ;
   private String[] BC000A44_A1368EmpMenConCodigo ;
   private int[] BC000A45_A3CliCod ;
   private short[] BC000A45_A1EmpCod ;
   private int[] BC000A45_A6LegNumero ;
   private short[] BC000A45_A1172OblSecuencial ;
   private String[] BC000A45_A1170OblExcConCOdigo ;
   private int[] BC000A46_A3CliCod ;
   private short[] BC000A46_A1EmpCod ;
   private int[] BC000A46_A6LegNumero ;
   private short[] BC000A46_A1172OblSecuencial ;
   private int[] BC000A47_A3CliCod ;
   private short[] BC000A47_A1EmpCod ;
   private int[] BC000A47_A6LegNumero ;
   private short[] BC000A47_A1172OblSecuencial ;
   private int[] BC000A48_A3CliCod ;
   private short[] BC000A48_A1EmpCod ;
   private short[] BC000A48_A1129LiqExAnio ;
   private int[] BC000A48_A31LiqNro ;
   private int[] BC000A48_A6LegNumero ;
   private String[] BC000A48_A1127LiqExenConCodigo ;
   private short[] BC000A48_A1128LiqExAplIIGG ;
   private int[] BC000A49_A3CliCod ;
   private short[] BC000A49_A1112AplIIGG ;
   private boolean[] BC000A49_n1112AplIIGG ;
   private int[] BC000A50_A3CliCod ;
   private short[] BC000A50_A1112AplIIGG ;
   private boolean[] BC000A50_n1112AplIIGG ;
   private int[] BC000A51_A3CliCod ;
   private short[] BC000A51_A1112AplIIGG ;
   private boolean[] BC000A51_n1112AplIIGG ;
   private int[] BC000A52_A3CliCod ;
   private String[] BC000A52_A1105CondExenIIGG ;
   private int[] BC000A53_A3CliCod ;
   private String[] BC000A53_A1101SiraTipo ;
   private String[] BC000A53_A1102SiraCodigo ;
   private int[] BC000A54_A3CliCod ;
   private short[] BC000A54_A1EmpCod ;
   private short[] BC000A54_A869LiqLegConAnio ;
   private int[] BC000A54_A6LegNumero ;
   private String[] BC000A54_A26ConCodigo ;
   private int[] BC000A54_A1097LiqAltaNro ;
   private int[] BC000A54_A1098LiqNuevaNro ;
   private int[] BC000A55_A3CliCod ;
   private short[] BC000A55_A1EmpCod ;
   private int[] BC000A55_A6LegNumero ;
   private int[] BC000A55_A83LegDedSec ;
   private int[] BC000A56_A3CliCod ;
   private String[] BC000A56_A26ConCodigo ;
   private short[] BC000A56_A51ForHisNum ;
   private int[] BC000A57_A3CliCod ;
   private short[] BC000A57_A1EmpCod ;
   private int[] BC000A57_A6LegNumero ;
   private short[] BC000A57_A25AgeOrden ;
   private String[] BC000A58_A42ConCodYDesc ;
   private boolean[] BC000A58_n42ConCodYDesc ;
   private String[] BC000A58_A26ConCodigo ;
   private java.util.Date[] BC000A58_A145ConFchModFor ;
   private boolean[] BC000A58_n145ConFchModFor ;
   private String[] BC000A58_A156ConUsuModFor ;
   private boolean[] BC000A58_n156ConUsuModFor ;
   private boolean[] BC000A58_A143ConCanti ;
   private boolean[] BC000A58_A158ConValUni ;
   private boolean[] BC000A58_A152ConImporte ;
   private boolean[] BC000A58_A159ConVariable ;
   private int[] BC000A58_A1905ConRelSecCli ;
   private String[] BC000A58_A1974ConOldValues ;
   private String[] BC000A58_A41ConDescrip ;
   private boolean[] BC000A58_A150ConHabilitado ;
   private int[] BC000A58_A40ConOrden ;
   private byte[] BC000A58_A162ConVigencia ;
   private byte[] BC000A58_A1488ConLiqBasica ;
   private String[] BC000A58_A148ConFormula ;
   private boolean[] BC000A58_n148ConFormula ;
   private String[] BC000A58_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A58_A157ConValorGen ;
   private boolean[] BC000A58_n157ConValorGen ;
   private String[] BC000A58_A155ConTipoLiqGanancias ;
   private boolean[] BC000A58_n155ConTipoLiqGanancias ;
   private String[] BC000A58_A153ConObservacion ;
   private String[] BC000A58_A151ConHisFormula ;
   private boolean[] BC000A58_n151ConHisFormula ;
   private byte[] BC000A58_A154ConTipo ;
   private String[] BC000A58_A469ConCodOld ;
   private String[] BC000A58_A487ConCuenDebe ;
   private boolean[] BC000A58_n487ConCuenDebe ;
   private String[] BC000A58_A488ConCuenHaber ;
   private boolean[] BC000A58_n488ConCuenHaber ;
   private String[] BC000A58_A503ConTipoLiqAux ;
   private boolean[] BC000A58_n503ConTipoLiqAux ;
   private String[] BC000A58_A969ConConveAux ;
   private boolean[] BC000A58_n969ConConveAux ;
   private String[] BC000A58_A970ConClasifAux ;
   private boolean[] BC000A58_n970ConClasifAux ;
   private long[] BC000A58_A510ConOrdEjec ;
   private String[] BC000A58_A569ConFormulaExpl ;
   private String[] BC000A58_A720ConFormulaObs2 ;
   private boolean[] BC000A58_A734ConRetGanPropor ;
   private byte[] BC000A58_A735ConAplicGan ;
   private boolean[] BC000A58_n735ConAplicGan ;
   private boolean[] BC000A58_A762ConRecalcular ;
   private boolean[] BC000A58_A894ConImportado ;
   private short[] BC000A58_A895ConTipoOrden ;
   private boolean[] BC000A58_A1017ConEdiEnRec ;
   private String[] BC000A58_A1018ConRangoCant ;
   private boolean[] BC000A58_A922ConUsado ;
   private boolean[] BC000A58_A951ConObliga ;
   private boolean[] BC000A58_n951ConObliga ;
   private boolean[] BC000A58_A952ConObligaSiSac ;
   private boolean[] BC000A58_n952ConObligaSiSac ;
   private String[] BC000A58_A954ConCondCodigo ;
   private String[] BC000A58_A1066ConPreReq ;
   private boolean[] BC000A58_n1066ConPreReq ;
   private boolean[] BC000A58_A1068ConMostrarPos ;
   private byte[] BC000A58_A1077ConAdelDescu ;
   private boolean[] BC000A58_n1077ConAdelDescu ;
   private boolean[] BC000A58_A1194ConSegunPla ;
   private byte[] BC000A58_A1471ConNumero ;
   private byte[] BC000A58_A1472ConSIPAApo ;
   private byte[] BC000A58_A1473ConSIPACont ;
   private byte[] BC000A58_A1474ConINSSJyPApo ;
   private byte[] BC000A58_A1475ConINSSJyPCont ;
   private byte[] BC000A58_A1476ConObraSocApo ;
   private byte[] BC000A58_A1477ConObraSocCont ;
   private byte[] BC000A58_A1478ConFonSolRedApo ;
   private byte[] BC000A58_A1479ConFonSolRedCont ;
   private byte[] BC000A58_A1480ConRenateaApo ;
   private byte[] BC000A58_A1481ConRenateaCont ;
   private byte[] BC000A58_A1482ConAsigFamCont ;
   private byte[] BC000A58_A1483ConFonNacEmpCont ;
   private byte[] BC000A58_A1484ConLeyRieTrabCont ;
   private byte[] BC000A58_A1485ConRegDifApo ;
   private byte[] BC000A58_A1486ConRegEspApo ;
   private byte[] BC000A58_A1539ConSacDeven ;
   private byte[] BC000A58_A1620ConBaseLic ;
   private byte[] BC000A58_A1797ConBaseLicProm ;
   private byte[] BC000A58_A1621ConBaseFer ;
   private byte[] BC000A58_A1798ConBaseFerProm ;
   private byte[] BC000A58_A1622ConBaseHorExt ;
   private byte[] BC000A58_A1799ConBaseHorExtProm ;
   private byte[] BC000A58_A1800ConBasePres ;
   private byte[] BC000A58_A1801ConBaseAnt ;
   private byte[] BC000A58_A1827ConBaseOSDif ;
   private byte[] BC000A58_A2191ConBaseAus ;
   private byte[] BC000A58_A2192ConBaseAusProm ;
   private String[] BC000A58_A1648ConCodAfip ;
   private byte[] BC000A58_A1769ConCntPa ;
   private boolean[] BC000A58_A1821ConErrorSiCero ;
   private boolean[] BC000A58_A1826ConPueNov ;
   private int[] BC000A58_A1886ConRelSec ;
   private String[] BC000A58_A2013ConRelRef ;
   private String[] BC000A58_A2185ConDescripSinAc ;
   private String[] BC000A58_A2187ConOblPalabra ;
   private boolean[] BC000A58_n2187ConOblPalabra ;
   private int[] BC000A58_A1822CliPadre ;
   private boolean[] BC000A58_n1822CliPadre ;
   private int[] BC000A58_A3CliCod ;
   private short[] BC000A58_A1112AplIIGG ;
   private boolean[] BC000A58_n1112AplIIGG ;
   private String[] BC000A58_A37TipoConCod ;
   private String[] BC000A58_A38SubTipoConCod1 ;
   private boolean[] BC000A58_n38SubTipoConCod1 ;
   private String[] BC000A58_A39SubTipoConCod2 ;
   private boolean[] BC000A58_n39SubTipoConCod2 ;
   private String[] BC000A58_A953ConCondicion ;
   private boolean[] BC000A58_n953ConCondicion ;
   private short[] BC000A58_A1644ConceptoPais ;
   private boolean[] BC000A58_n1644ConceptoPais ;
   private String[] BC000A58_A1645ConceptoConveCodigo ;
   private boolean[] BC000A58_n1645ConceptoConveCodigo ;
   private String[] BC000A58_A921ConPadre ;
   private boolean[] BC000A58_n921ConPadre ;
   private String[] BC000A59_A26ConCodigo ;
   private String[] BC000A59_A340TliqDesc ;
   private boolean[] BC000A59_A925ConTLiqSinCausa ;
   private boolean[] BC000A59_n925ConTLiqSinCausa ;
   private boolean[] BC000A59_A926ConTLiqSinPre ;
   private boolean[] BC000A59_n926ConTLiqSinPre ;
   private String[] BC000A59_A950ConTLTipEgr ;
   private long[] BC000A59_A1406ConTLOrdejec ;
   private short[] BC000A59_A1407ConTLConOrd ;
   private byte[] BC000A59_A1409ConTLVigencia ;
   private boolean[] BC000A59_n1409ConTLVigencia ;
   private String[] BC000A59_A1410ConTLCondicion ;
   private boolean[] BC000A59_n1410ConTLCondicion ;
   private byte[] BC000A59_A1470ConTLConHab ;
   private String[] BC000A59_A1788ConTLTipoCon ;
   private boolean[] BC000A59_n1788ConTLTipoCon ;
   private byte[] BC000A59_A1789CONTLSegPla ;
   private boolean[] BC000A59_n1789CONTLSegPla ;
   private int[] BC000A59_A3CliCod ;
   private String[] BC000A59_A32TLiqCod ;
   private String[] BC000A60_A340TliqDesc ;
   private int[] BC000A61_A3CliCod ;
   private String[] BC000A61_A26ConCodigo ;
   private String[] BC000A61_A32TLiqCod ;
   private String[] BC000A62_A26ConCodigo ;
   private boolean[] BC000A62_A925ConTLiqSinCausa ;
   private boolean[] BC000A62_n925ConTLiqSinCausa ;
   private boolean[] BC000A62_A926ConTLiqSinPre ;
   private boolean[] BC000A62_n926ConTLiqSinPre ;
   private String[] BC000A62_A950ConTLTipEgr ;
   private long[] BC000A62_A1406ConTLOrdejec ;
   private short[] BC000A62_A1407ConTLConOrd ;
   private byte[] BC000A62_A1409ConTLVigencia ;
   private boolean[] BC000A62_n1409ConTLVigencia ;
   private String[] BC000A62_A1410ConTLCondicion ;
   private boolean[] BC000A62_n1410ConTLCondicion ;
   private byte[] BC000A62_A1470ConTLConHab ;
   private String[] BC000A62_A1788ConTLTipoCon ;
   private boolean[] BC000A62_n1788ConTLTipoCon ;
   private byte[] BC000A62_A1789CONTLSegPla ;
   private boolean[] BC000A62_n1789CONTLSegPla ;
   private int[] BC000A62_A3CliCod ;
   private String[] BC000A62_A32TLiqCod ;
   private String[] BC000A63_A26ConCodigo ;
   private boolean[] BC000A63_A925ConTLiqSinCausa ;
   private boolean[] BC000A63_n925ConTLiqSinCausa ;
   private boolean[] BC000A63_A926ConTLiqSinPre ;
   private boolean[] BC000A63_n926ConTLiqSinPre ;
   private String[] BC000A63_A950ConTLTipEgr ;
   private long[] BC000A63_A1406ConTLOrdejec ;
   private short[] BC000A63_A1407ConTLConOrd ;
   private byte[] BC000A63_A1409ConTLVigencia ;
   private boolean[] BC000A63_n1409ConTLVigencia ;
   private String[] BC000A63_A1410ConTLCondicion ;
   private boolean[] BC000A63_n1410ConTLCondicion ;
   private byte[] BC000A63_A1470ConTLConHab ;
   private String[] BC000A63_A1788ConTLTipoCon ;
   private boolean[] BC000A63_n1788ConTLTipoCon ;
   private byte[] BC000A63_A1789CONTLSegPla ;
   private boolean[] BC000A63_n1789CONTLSegPla ;
   private int[] BC000A63_A3CliCod ;
   private String[] BC000A63_A32TLiqCod ;
   private String[] BC000A67_A340TliqDesc ;
   private String[] BC000A68_A26ConCodigo ;
   private String[] BC000A68_A340TliqDesc ;
   private boolean[] BC000A68_A925ConTLiqSinCausa ;
   private boolean[] BC000A68_n925ConTLiqSinCausa ;
   private boolean[] BC000A68_A926ConTLiqSinPre ;
   private boolean[] BC000A68_n926ConTLiqSinPre ;
   private String[] BC000A68_A950ConTLTipEgr ;
   private long[] BC000A68_A1406ConTLOrdejec ;
   private short[] BC000A68_A1407ConTLConOrd ;
   private byte[] BC000A68_A1409ConTLVigencia ;
   private boolean[] BC000A68_n1409ConTLVigencia ;
   private String[] BC000A68_A1410ConTLCondicion ;
   private boolean[] BC000A68_n1410ConTLCondicion ;
   private byte[] BC000A68_A1470ConTLConHab ;
   private String[] BC000A68_A1788ConTLTipoCon ;
   private boolean[] BC000A68_n1788ConTLTipoCon ;
   private byte[] BC000A68_A1789CONTLSegPla ;
   private boolean[] BC000A68_n1789CONTLSegPla ;
   private int[] BC000A68_A3CliCod ;
   private String[] BC000A68_A32TLiqCod ;
   private String[] BC000A69_A26ConCodigo ;
   private short[] BC000A69_A2077ConMegSec ;
   private String[] BC000A69_A1532MegPreaTipo ;
   private byte[] BC000A69_A1530ConMegMeses ;
   private String[] BC000A69_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A69_A1529ConMegPropor ;
   private int[] BC000A69_A3CliCod ;
   private String[] BC000A69_A11MegCodigo ;
   private int[] BC000A70_A3CliCod ;
   private int[] BC000A71_A3CliCod ;
   private int[] BC000A72_A3CliCod ;
   private String[] BC000A72_A26ConCodigo ;
   private String[] BC000A72_A11MegCodigo ;
   private short[] BC000A72_A2077ConMegSec ;
   private String[] BC000A73_A26ConCodigo ;
   private short[] BC000A73_A2077ConMegSec ;
   private String[] BC000A73_A1532MegPreaTipo ;
   private byte[] BC000A73_A1530ConMegMeses ;
   private String[] BC000A73_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A73_A1529ConMegPropor ;
   private int[] BC000A73_A3CliCod ;
   private String[] BC000A73_A11MegCodigo ;
   private String[] BC000A74_A26ConCodigo ;
   private short[] BC000A74_A2077ConMegSec ;
   private String[] BC000A74_A1532MegPreaTipo ;
   private byte[] BC000A74_A1530ConMegMeses ;
   private String[] BC000A74_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A74_A1529ConMegPropor ;
   private int[] BC000A74_A3CliCod ;
   private String[] BC000A74_A11MegCodigo ;
   private String[] BC000A78_A26ConCodigo ;
   private short[] BC000A78_A2077ConMegSec ;
   private String[] BC000A78_A1532MegPreaTipo ;
   private byte[] BC000A78_A1530ConMegMeses ;
   private String[] BC000A78_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A78_A1529ConMegPropor ;
   private int[] BC000A78_A3CliCod ;
   private String[] BC000A78_A11MegCodigo ;
   private String[] BC000A2_A26ConCodigo ;
   private short[] BC000A2_A2077ConMegSec ;
   private String[] BC000A2_A1532MegPreaTipo ;
   private byte[] BC000A2_A1530ConMegMeses ;
   private String[] BC000A2_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A2_A1529ConMegPropor ;
   private int[] BC000A2_A3CliCod ;
   private String[] BC000A2_A11MegCodigo ;
   private String[] BC000A3_A26ConCodigo ;
   private short[] BC000A3_A2077ConMegSec ;
   private String[] BC000A3_A1532MegPreaTipo ;
   private byte[] BC000A3_A1530ConMegMeses ;
   private String[] BC000A3_A1534ConMegDura ;
   private java.math.BigDecimal[] BC000A3_A1529ConMegPropor ;
   private int[] BC000A3_A3CliCod ;
   private String[] BC000A3_A11MegCodigo ;
   private int[] BC000A4_A3CliCod ;
   private String[] BC000A5_A26ConCodigo ;
   private boolean[] BC000A5_A925ConTLiqSinCausa ;
   private boolean[] BC000A5_A926ConTLiqSinPre ;
   private String[] BC000A5_A950ConTLTipEgr ;
   private long[] BC000A5_A1406ConTLOrdejec ;
   private short[] BC000A5_A1407ConTLConOrd ;
   private byte[] BC000A5_A1409ConTLVigencia ;
   private String[] BC000A5_A1410ConTLCondicion ;
   private byte[] BC000A5_A1470ConTLConHab ;
   private String[] BC000A5_A1788ConTLTipoCon ;
   private byte[] BC000A5_A1789CONTLSegPla ;
   private int[] BC000A5_A3CliCod ;
   private String[] BC000A5_A32TLiqCod ;
   private String[] BC000A6_A26ConCodigo ;
   private boolean[] BC000A6_A925ConTLiqSinCausa ;
   private boolean[] BC000A6_A926ConTLiqSinPre ;
   private String[] BC000A6_A950ConTLTipEgr ;
   private long[] BC000A6_A1406ConTLOrdejec ;
   private short[] BC000A6_A1407ConTLConOrd ;
   private byte[] BC000A6_A1409ConTLVigencia ;
   private String[] BC000A6_A1410ConTLCondicion ;
   private byte[] BC000A6_A1470ConTLConHab ;
   private String[] BC000A6_A1788ConTLTipoCon ;
   private byte[] BC000A6_A1789CONTLSegPla ;
   private int[] BC000A6_A3CliCod ;
   private String[] BC000A6_A32TLiqCod ;
   private String[] BC000A7_A340TliqDesc ;
   private String[] BC000A8_A42ConCodYDesc ;
   private String[] BC000A8_A26ConCodigo ;
   private java.util.Date[] BC000A8_A145ConFchModFor ;
   private String[] BC000A8_A156ConUsuModFor ;
   private boolean[] BC000A8_A143ConCanti ;
   private boolean[] BC000A8_A158ConValUni ;
   private boolean[] BC000A8_A152ConImporte ;
   private boolean[] BC000A8_A159ConVariable ;
   private int[] BC000A8_A1905ConRelSecCli ;
   private String[] BC000A8_A1974ConOldValues ;
   private String[] BC000A8_A41ConDescrip ;
   private boolean[] BC000A8_A150ConHabilitado ;
   private int[] BC000A8_A40ConOrden ;
   private byte[] BC000A8_A162ConVigencia ;
   private byte[] BC000A8_A1488ConLiqBasica ;
   private String[] BC000A8_A148ConFormula ;
   private String[] BC000A8_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A8_A157ConValorGen ;
   private String[] BC000A8_A155ConTipoLiqGanancias ;
   private String[] BC000A8_A153ConObservacion ;
   private String[] BC000A8_A151ConHisFormula ;
   private byte[] BC000A8_A154ConTipo ;
   private String[] BC000A8_A469ConCodOld ;
   private String[] BC000A8_A487ConCuenDebe ;
   private String[] BC000A8_A488ConCuenHaber ;
   private String[] BC000A8_A503ConTipoLiqAux ;
   private String[] BC000A8_A969ConConveAux ;
   private String[] BC000A8_A970ConClasifAux ;
   private long[] BC000A8_A510ConOrdEjec ;
   private String[] BC000A8_A569ConFormulaExpl ;
   private String[] BC000A8_A720ConFormulaObs2 ;
   private boolean[] BC000A8_A734ConRetGanPropor ;
   private byte[] BC000A8_A735ConAplicGan ;
   private boolean[] BC000A8_A762ConRecalcular ;
   private boolean[] BC000A8_A894ConImportado ;
   private short[] BC000A8_A895ConTipoOrden ;
   private boolean[] BC000A8_A1017ConEdiEnRec ;
   private String[] BC000A8_A1018ConRangoCant ;
   private boolean[] BC000A8_A922ConUsado ;
   private boolean[] BC000A8_A951ConObliga ;
   private boolean[] BC000A8_A952ConObligaSiSac ;
   private String[] BC000A8_A954ConCondCodigo ;
   private String[] BC000A8_A1066ConPreReq ;
   private boolean[] BC000A8_A1068ConMostrarPos ;
   private byte[] BC000A8_A1077ConAdelDescu ;
   private boolean[] BC000A8_A1194ConSegunPla ;
   private byte[] BC000A8_A1471ConNumero ;
   private byte[] BC000A8_A1472ConSIPAApo ;
   private byte[] BC000A8_A1473ConSIPACont ;
   private byte[] BC000A8_A1474ConINSSJyPApo ;
   private byte[] BC000A8_A1475ConINSSJyPCont ;
   private byte[] BC000A8_A1476ConObraSocApo ;
   private byte[] BC000A8_A1477ConObraSocCont ;
   private byte[] BC000A8_A1478ConFonSolRedApo ;
   private byte[] BC000A8_A1479ConFonSolRedCont ;
   private byte[] BC000A8_A1480ConRenateaApo ;
   private byte[] BC000A8_A1481ConRenateaCont ;
   private byte[] BC000A8_A1482ConAsigFamCont ;
   private byte[] BC000A8_A1483ConFonNacEmpCont ;
   private byte[] BC000A8_A1484ConLeyRieTrabCont ;
   private byte[] BC000A8_A1485ConRegDifApo ;
   private byte[] BC000A8_A1486ConRegEspApo ;
   private byte[] BC000A8_A1539ConSacDeven ;
   private byte[] BC000A8_A1620ConBaseLic ;
   private byte[] BC000A8_A1797ConBaseLicProm ;
   private byte[] BC000A8_A1621ConBaseFer ;
   private byte[] BC000A8_A1798ConBaseFerProm ;
   private byte[] BC000A8_A1622ConBaseHorExt ;
   private byte[] BC000A8_A1799ConBaseHorExtProm ;
   private byte[] BC000A8_A1800ConBasePres ;
   private byte[] BC000A8_A1801ConBaseAnt ;
   private byte[] BC000A8_A1827ConBaseOSDif ;
   private byte[] BC000A8_A2191ConBaseAus ;
   private byte[] BC000A8_A2192ConBaseAusProm ;
   private String[] BC000A8_A1648ConCodAfip ;
   private byte[] BC000A8_A1769ConCntPa ;
   private boolean[] BC000A8_A1821ConErrorSiCero ;
   private boolean[] BC000A8_A1826ConPueNov ;
   private int[] BC000A8_A1886ConRelSec ;
   private String[] BC000A8_A2013ConRelRef ;
   private String[] BC000A8_A2185ConDescripSinAc ;
   private String[] BC000A8_A2187ConOblPalabra ;
   private int[] BC000A8_A1822CliPadre ;
   private int[] BC000A8_A3CliCod ;
   private short[] BC000A8_A1112AplIIGG ;
   private String[] BC000A8_A37TipoConCod ;
   private String[] BC000A8_A38SubTipoConCod1 ;
   private String[] BC000A8_A39SubTipoConCod2 ;
   private String[] BC000A8_A953ConCondicion ;
   private short[] BC000A8_A1644ConceptoPais ;
   private String[] BC000A8_A1645ConceptoConveCodigo ;
   private String[] BC000A8_A921ConPadre ;
   private String[] BC000A9_A42ConCodYDesc ;
   private String[] BC000A9_A26ConCodigo ;
   private java.util.Date[] BC000A9_A145ConFchModFor ;
   private String[] BC000A9_A156ConUsuModFor ;
   private boolean[] BC000A9_A143ConCanti ;
   private boolean[] BC000A9_A158ConValUni ;
   private boolean[] BC000A9_A152ConImporte ;
   private boolean[] BC000A9_A159ConVariable ;
   private int[] BC000A9_A1905ConRelSecCli ;
   private String[] BC000A9_A1974ConOldValues ;
   private String[] BC000A9_A41ConDescrip ;
   private boolean[] BC000A9_A150ConHabilitado ;
   private int[] BC000A9_A40ConOrden ;
   private byte[] BC000A9_A162ConVigencia ;
   private byte[] BC000A9_A1488ConLiqBasica ;
   private String[] BC000A9_A148ConFormula ;
   private String[] BC000A9_A729ConFormulaPreResuelta ;
   private java.math.BigDecimal[] BC000A9_A157ConValorGen ;
   private String[] BC000A9_A155ConTipoLiqGanancias ;
   private String[] BC000A9_A153ConObservacion ;
   private String[] BC000A9_A151ConHisFormula ;
   private byte[] BC000A9_A154ConTipo ;
   private String[] BC000A9_A469ConCodOld ;
   private String[] BC000A9_A487ConCuenDebe ;
   private String[] BC000A9_A488ConCuenHaber ;
   private String[] BC000A9_A503ConTipoLiqAux ;
   private String[] BC000A9_A969ConConveAux ;
   private String[] BC000A9_A970ConClasifAux ;
   private long[] BC000A9_A510ConOrdEjec ;
   private String[] BC000A9_A569ConFormulaExpl ;
   private String[] BC000A9_A720ConFormulaObs2 ;
   private boolean[] BC000A9_A734ConRetGanPropor ;
   private byte[] BC000A9_A735ConAplicGan ;
   private boolean[] BC000A9_A762ConRecalcular ;
   private boolean[] BC000A9_A894ConImportado ;
   private short[] BC000A9_A895ConTipoOrden ;
   private boolean[] BC000A9_A1017ConEdiEnRec ;
   private String[] BC000A9_A1018ConRangoCant ;
   private boolean[] BC000A9_A922ConUsado ;
   private boolean[] BC000A9_A951ConObliga ;
   private boolean[] BC000A9_A952ConObligaSiSac ;
   private String[] BC000A9_A954ConCondCodigo ;
   private String[] BC000A9_A1066ConPreReq ;
   private boolean[] BC000A9_A1068ConMostrarPos ;
   private byte[] BC000A9_A1077ConAdelDescu ;
   private boolean[] BC000A9_A1194ConSegunPla ;
   private byte[] BC000A9_A1471ConNumero ;
   private byte[] BC000A9_A1472ConSIPAApo ;
   private byte[] BC000A9_A1473ConSIPACont ;
   private byte[] BC000A9_A1474ConINSSJyPApo ;
   private byte[] BC000A9_A1475ConINSSJyPCont ;
   private byte[] BC000A9_A1476ConObraSocApo ;
   private byte[] BC000A9_A1477ConObraSocCont ;
   private byte[] BC000A9_A1478ConFonSolRedApo ;
   private byte[] BC000A9_A1479ConFonSolRedCont ;
   private byte[] BC000A9_A1480ConRenateaApo ;
   private byte[] BC000A9_A1481ConRenateaCont ;
   private byte[] BC000A9_A1482ConAsigFamCont ;
   private byte[] BC000A9_A1483ConFonNacEmpCont ;
   private byte[] BC000A9_A1484ConLeyRieTrabCont ;
   private byte[] BC000A9_A1485ConRegDifApo ;
   private byte[] BC000A9_A1486ConRegEspApo ;
   private byte[] BC000A9_A1539ConSacDeven ;
   private byte[] BC000A9_A1620ConBaseLic ;
   private byte[] BC000A9_A1797ConBaseLicProm ;
   private byte[] BC000A9_A1621ConBaseFer ;
   private byte[] BC000A9_A1798ConBaseFerProm ;
   private byte[] BC000A9_A1622ConBaseHorExt ;
   private byte[] BC000A9_A1799ConBaseHorExtProm ;
   private byte[] BC000A9_A1800ConBasePres ;
   private byte[] BC000A9_A1801ConBaseAnt ;
   private byte[] BC000A9_A1827ConBaseOSDif ;
   private byte[] BC000A9_A2191ConBaseAus ;
   private byte[] BC000A9_A2192ConBaseAusProm ;
   private String[] BC000A9_A1648ConCodAfip ;
   private byte[] BC000A9_A1769ConCntPa ;
   private boolean[] BC000A9_A1821ConErrorSiCero ;
   private boolean[] BC000A9_A1826ConPueNov ;
   private int[] BC000A9_A1886ConRelSec ;
   private String[] BC000A9_A2013ConRelRef ;
   private String[] BC000A9_A2185ConDescripSinAc ;
   private String[] BC000A9_A2187ConOblPalabra ;
   private int[] BC000A9_A1822CliPadre ;
   private int[] BC000A9_A3CliCod ;
   private short[] BC000A9_A1112AplIIGG ;
   private String[] BC000A9_A37TipoConCod ;
   private String[] BC000A9_A38SubTipoConCod1 ;
   private String[] BC000A9_A39SubTipoConCod2 ;
   private String[] BC000A9_A953ConCondicion ;
   private short[] BC000A9_A1644ConceptoPais ;
   private String[] BC000A9_A1645ConceptoConveCodigo ;
   private String[] BC000A9_A921ConPadre ;
   private int[] BC000A10_A3CliCod ;
   private int[] BC000A11_A3CliCod ;
   private String[] BC000A12_A37TipoConCod ;
   private String[] BC000A13_A37TipoConCod ;
   private String[] BC000A14_A37TipoConCod ;
   private String[] BC000A15_A953ConCondicion ;
   private short[] BC000A16_A1644ConceptoPais ;
   private int[] BC000A17_A1822CliPadre ;
   private boolean[] BC000A5_n925ConTLiqSinCausa ;
   private boolean[] BC000A5_n926ConTLiqSinPre ;
   private boolean[] BC000A5_n1409ConTLVigencia ;
   private boolean[] BC000A5_n1410ConTLCondicion ;
   private boolean[] BC000A5_n1788ConTLTipoCon ;
   private boolean[] BC000A5_n1789CONTLSegPla ;
   private boolean[] BC000A6_n925ConTLiqSinCausa ;
   private boolean[] BC000A6_n926ConTLiqSinPre ;
   private boolean[] BC000A6_n1409ConTLVigencia ;
   private boolean[] BC000A6_n1410ConTLCondicion ;
   private boolean[] BC000A6_n1788ConTLTipoCon ;
   private boolean[] BC000A6_n1789CONTLSegPla ;
   private boolean[] BC000A8_n42ConCodYDesc ;
   private boolean[] BC000A8_n145ConFchModFor ;
   private boolean[] BC000A8_n156ConUsuModFor ;
   private boolean[] BC000A8_n148ConFormula ;
   private boolean[] BC000A8_n157ConValorGen ;
   private boolean[] BC000A8_n155ConTipoLiqGanancias ;
   private boolean[] BC000A8_n151ConHisFormula ;
   private boolean[] BC000A8_n487ConCuenDebe ;
   private boolean[] BC000A8_n488ConCuenHaber ;
   private boolean[] BC000A8_n503ConTipoLiqAux ;
   private boolean[] BC000A8_n969ConConveAux ;
   private boolean[] BC000A8_n970ConClasifAux ;
   private boolean[] BC000A8_n735ConAplicGan ;
   private boolean[] BC000A8_n951ConObliga ;
   private boolean[] BC000A8_n952ConObligaSiSac ;
   private boolean[] BC000A8_n1066ConPreReq ;
   private boolean[] BC000A8_n1077ConAdelDescu ;
   private boolean[] BC000A8_n2187ConOblPalabra ;
   private boolean[] BC000A8_n1822CliPadre ;
   private boolean[] BC000A8_n1112AplIIGG ;
   private boolean[] BC000A8_n38SubTipoConCod1 ;
   private boolean[] BC000A8_n39SubTipoConCod2 ;
   private boolean[] BC000A8_n953ConCondicion ;
   private boolean[] BC000A8_n1644ConceptoPais ;
   private boolean[] BC000A8_n1645ConceptoConveCodigo ;
   private boolean[] BC000A8_n921ConPadre ;
   private boolean[] BC000A9_n42ConCodYDesc ;
   private boolean[] BC000A9_n145ConFchModFor ;
   private boolean[] BC000A9_n156ConUsuModFor ;
   private boolean[] BC000A9_n148ConFormula ;
   private boolean[] BC000A9_n157ConValorGen ;
   private boolean[] BC000A9_n155ConTipoLiqGanancias ;
   private boolean[] BC000A9_n151ConHisFormula ;
   private boolean[] BC000A9_n487ConCuenDebe ;
   private boolean[] BC000A9_n488ConCuenHaber ;
   private boolean[] BC000A9_n503ConTipoLiqAux ;
   private boolean[] BC000A9_n969ConConveAux ;
   private boolean[] BC000A9_n970ConClasifAux ;
   private boolean[] BC000A9_n735ConAplicGan ;
   private boolean[] BC000A9_n951ConObliga ;
   private boolean[] BC000A9_n952ConObligaSiSac ;
   private boolean[] BC000A9_n1066ConPreReq ;
   private boolean[] BC000A9_n1077ConAdelDescu ;
   private boolean[] BC000A9_n2187ConOblPalabra ;
   private boolean[] BC000A9_n1822CliPadre ;
   private boolean[] BC000A9_n1112AplIIGG ;
   private boolean[] BC000A9_n38SubTipoConCod1 ;
   private boolean[] BC000A9_n39SubTipoConCod2 ;
   private boolean[] BC000A9_n953ConCondicion ;
   private boolean[] BC000A9_n1644ConceptoPais ;
   private boolean[] BC000A9_n1645ConceptoConveCodigo ;
   private boolean[] BC000A9_n921ConPadre ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV20TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV26TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV22WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class concepto_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000A2", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?  FOR UPDATE OF ConceptoMotivosEgreso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A3", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A4", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A5", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?  FOR UPDATE OF ConceptoTipoLiquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A6", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A7", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A8", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ?  FOR UPDATE OF Concepto",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A9", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A10", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A11", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A12", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A13", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A14", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A15", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A16", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A17", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A18", "SELECT TM1.ConCodYDesc, TM1.ConCodigo, TM1.ConFchModFor, TM1.ConUsuModFor, TM1.ConCanti, TM1.ConValUni, TM1.ConImporte, TM1.ConVariable, TM1.ConRelSecCli, TM1.ConOldValues, TM1.ConDescrip, TM1.ConHabilitado, TM1.ConOrden, TM1.ConVigencia, TM1.ConLiqBasica, TM1.ConFormula, TM1.ConFormulaPreResuelta, TM1.ConValorGen, TM1.ConTipoLiqGanancias, TM1.ConObservacion, TM1.ConHisFormula, TM1.ConTipo, TM1.ConCodOld, TM1.ConCuenDebe, TM1.ConCuenHaber, TM1.ConTipoLiqAux, TM1.ConConveAux, TM1.ConClasifAux, TM1.ConOrdEjec, TM1.ConFormulaExpl, TM1.ConFormulaObs2, TM1.ConRetGanPropor, TM1.ConAplicGan, TM1.ConRecalcular, TM1.ConImportado, TM1.ConTipoOrden, TM1.ConEdiEnRec, TM1.ConRangoCant, TM1.ConUsado, TM1.ConObliga, TM1.ConObligaSiSac, TM1.ConCondCodigo, TM1.ConPreReq, TM1.ConMostrarPos, TM1.ConAdelDescu, TM1.ConSegunPla, TM1.ConNumero, TM1.ConSIPAApo, TM1.ConSIPACont, TM1.ConINSSJyPApo, TM1.ConINSSJyPCont, TM1.ConObraSocApo, TM1.ConObraSocCont, TM1.ConFonSolRedApo, TM1.ConFonSolRedCont, TM1.ConRenateaApo, TM1.ConRenateaCont, TM1.ConAsigFamCont, TM1.ConFonNacEmpCont, TM1.ConLeyRieTrabCont, TM1.ConRegDifApo, TM1.ConRegEspApo, TM1.ConSacDeven, TM1.ConBaseLic, TM1.ConBaseLicProm, TM1.ConBaseFer, TM1.ConBaseFerProm, TM1.ConBaseHorExt, TM1.ConBaseHorExtProm, TM1.ConBasePres, TM1.ConBaseAnt, TM1.ConBaseOSDif, TM1.ConBaseAus, TM1.ConBaseAusProm, TM1.ConCodAfip, TM1.ConCntPa, TM1.ConErrorSiCero, TM1.ConPueNov, TM1.ConRelSec, TM1.ConRelRef, TM1.ConDescripSinAc, TM1.ConOblPalabra, TM1.CliPadre AS CliPadre, TM1.CliCod, TM1.AplIIGG, TM1.TipoConCod, TM1.SubTipoConCod1, TM1.SubTipoConCod2, TM1.ConCondicion, TM1.ConceptoPais AS ConceptoPais, TM1.ConceptoConveCodigo AS ConceptoConveCodigo, TM1.ConPadre AS ConPadre FROM Concepto TM1 WHERE TM1.CliCod = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A19", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A20", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A21", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A22", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A23", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A24", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A25", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A26", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A27", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A28", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A29", "SELECT ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ?  FOR UPDATE OF Concepto",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000A30", "SAVEPOINT gxupdate;INSERT INTO Concepto(ConCodYDesc, ConCodigo, ConFchModFor, ConUsuModFor, ConCanti, ConValUni, ConImporte, ConVariable, ConRelSecCli, ConOldValues, ConDescrip, ConHabilitado, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConFormulaPreResuelta, ConValorGen, ConTipoLiqGanancias, ConObservacion, ConHisFormula, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConTipoLiqAux, ConConveAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConFormulaObs2, ConRetGanPropor, ConAplicGan, ConRecalcular, ConImportado, ConTipoOrden, ConEdiEnRec, ConRangoCant, ConUsado, ConObliga, ConObligaSiSac, ConCondCodigo, ConPreReq, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConBaseAus, ConBaseAusProm, ConCodAfip, ConCntPa, ConErrorSiCero, ConPueNov, ConRelSec, ConRelRef, ConDescripSinAc, ConOblPalabra, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre, ConForEditable) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A31", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCodYDesc=?, ConFchModFor=?, ConUsuModFor=?, ConCanti=?, ConValUni=?, ConImporte=?, ConVariable=?, ConRelSecCli=?, ConOldValues=?, ConDescrip=?, ConHabilitado=?, ConOrden=?, ConVigencia=?, ConLiqBasica=?, ConFormula=?, ConFormulaPreResuelta=?, ConValorGen=?, ConTipoLiqGanancias=?, ConObservacion=?, ConHisFormula=?, ConTipo=?, ConCodOld=?, ConCuenDebe=?, ConCuenHaber=?, ConTipoLiqAux=?, ConConveAux=?, ConClasifAux=?, ConOrdEjec=?, ConFormulaExpl=?, ConFormulaObs2=?, ConRetGanPropor=?, ConAplicGan=?, ConRecalcular=?, ConImportado=?, ConTipoOrden=?, ConEdiEnRec=?, ConRangoCant=?, ConUsado=?, ConObliga=?, ConObligaSiSac=?, ConCondCodigo=?, ConPreReq=?, ConMostrarPos=?, ConAdelDescu=?, ConSegunPla=?, ConNumero=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?, ConSacDeven=?, ConBaseLic=?, ConBaseLicProm=?, ConBaseFer=?, ConBaseFerProm=?, ConBaseHorExt=?, ConBaseHorExtProm=?, ConBasePres=?, ConBaseAnt=?, ConBaseOSDif=?, ConBaseAus=?, ConBaseAusProm=?, ConCodAfip=?, ConCntPa=?, ConErrorSiCero=?, ConPueNov=?, ConRelSec=?, ConRelRef=?, ConDescripSinAc=?, ConOblPalabra=?, CliPadre=?, AplIIGG=?, TipoConCod=?, SubTipoConCod1=?, SubTipoConCod2=?, ConCondicion=?, ConceptoPais=?, ConceptoConveCodigo=?, ConPadre=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A32", "SAVEPOINT gxupdate;DELETE FROM Concepto  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000A33", "SELECT CliCod AS CliPadre, ConCodigo AS ConPadre FROM Concepto WHERE CliPadre = ? AND ConPadre = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A34", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiBaseCliCod = ? AND PaiBaseConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A35", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiMenCliCod = ? AND PaiMesConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A36", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiJorCliCod = ? AND PaiJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A37", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto FROM Legajo_sueldosConceptos WHERE CliCod = ? AND LegSuelConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A38", "SELECT CliCod, ConCodigo, ConOpeId, ConOperFor FROM concepto_operandos WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A39", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo, PreliqConcepto FROM LegPreliqConceptosExclu WHERE CliCod = ? AND PreliqConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A40", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND ConveHSPDiaConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A41", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE ConveMenCliCod = ? AND ConveMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A42", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE CliCod = ? AND LiqAjuConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A43", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A44", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A45", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? AND OblExcConCOdigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A46", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A47", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A48", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND LiqExenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A49", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND ApliIIGGExenOtr = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A50", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGExenCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A51", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGTopeCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A52", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGGCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A53", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A54", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A55", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND LegDedConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A56", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A57", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A58", "SELECT TM1.ConCodYDesc, TM1.ConCodigo, TM1.ConFchModFor, TM1.ConUsuModFor, TM1.ConCanti, TM1.ConValUni, TM1.ConImporte, TM1.ConVariable, TM1.ConRelSecCli, TM1.ConOldValues, TM1.ConDescrip, TM1.ConHabilitado, TM1.ConOrden, TM1.ConVigencia, TM1.ConLiqBasica, TM1.ConFormula, TM1.ConFormulaPreResuelta, TM1.ConValorGen, TM1.ConTipoLiqGanancias, TM1.ConObservacion, TM1.ConHisFormula, TM1.ConTipo, TM1.ConCodOld, TM1.ConCuenDebe, TM1.ConCuenHaber, TM1.ConTipoLiqAux, TM1.ConConveAux, TM1.ConClasifAux, TM1.ConOrdEjec, TM1.ConFormulaExpl, TM1.ConFormulaObs2, TM1.ConRetGanPropor, TM1.ConAplicGan, TM1.ConRecalcular, TM1.ConImportado, TM1.ConTipoOrden, TM1.ConEdiEnRec, TM1.ConRangoCant, TM1.ConUsado, TM1.ConObliga, TM1.ConObligaSiSac, TM1.ConCondCodigo, TM1.ConPreReq, TM1.ConMostrarPos, TM1.ConAdelDescu, TM1.ConSegunPla, TM1.ConNumero, TM1.ConSIPAApo, TM1.ConSIPACont, TM1.ConINSSJyPApo, TM1.ConINSSJyPCont, TM1.ConObraSocApo, TM1.ConObraSocCont, TM1.ConFonSolRedApo, TM1.ConFonSolRedCont, TM1.ConRenateaApo, TM1.ConRenateaCont, TM1.ConAsigFamCont, TM1.ConFonNacEmpCont, TM1.ConLeyRieTrabCont, TM1.ConRegDifApo, TM1.ConRegEspApo, TM1.ConSacDeven, TM1.ConBaseLic, TM1.ConBaseLicProm, TM1.ConBaseFer, TM1.ConBaseFerProm, TM1.ConBaseHorExt, TM1.ConBaseHorExtProm, TM1.ConBasePres, TM1.ConBaseAnt, TM1.ConBaseOSDif, TM1.ConBaseAus, TM1.ConBaseAusProm, TM1.ConCodAfip, TM1.ConCntPa, TM1.ConErrorSiCero, TM1.ConPueNov, TM1.ConRelSec, TM1.ConRelRef, TM1.ConDescripSinAc, TM1.ConOblPalabra, TM1.CliPadre AS CliPadre, TM1.CliCod, TM1.AplIIGG, TM1.TipoConCod, TM1.SubTipoConCod1, TM1.SubTipoConCod2, TM1.ConCondicion, TM1.ConceptoPais AS ConceptoPais, TM1.ConceptoConveCodigo AS ConceptoConveCodigo, TM1.ConPadre AS ConPadre FROM Concepto TM1 WHERE TM1.CliCod = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A59", "SELECT T1.ConCodigo, T2.TliqDesc, T1.ConTLiqSinCausa, T1.ConTLiqSinPre, T1.ConTLTipEgr, T1.ConTLOrdejec, T1.ConTLConOrd, T1.ConTLVigencia, T1.ConTLCondicion, T1.ConTLConHab, T1.ConTLTipoCon, T1.CONTLSegPla, T1.CliCod, T1.TLiqCod FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) and T1.TLiqCod = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A60", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A61", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A62", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A63", "SELECT ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?  FOR UPDATE OF ConceptoTipoLiquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000A64", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(ConCodigo, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla, CliCod, TLiqCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A65", "SAVEPOINT gxupdate;UPDATE ConceptoTipoLiquidacion SET ConTLiqSinCausa=?, ConTLiqSinPre=?, ConTLTipEgr=?, ConTLOrdejec=?, ConTLConOrd=?, ConTLVigencia=?, ConTLCondicion=?, ConTLConHab=?, ConTLTipoCon=?, CONTLSegPla=?  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A66", "SAVEPOINT gxupdate;DELETE FROM ConceptoTipoLiquidacion  WHERE CliCod = ? AND ConCodigo = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000A67", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A68", "SELECT T1.ConCodigo, T2.TliqDesc, T1.ConTLiqSinCausa, T1.ConTLiqSinPre, T1.ConTLTipEgr, T1.ConTLOrdejec, T1.ConTLConOrd, T1.ConTLVigencia, T1.ConTLCondicion, T1.ConTLConHab, T1.ConTLTipoCon, T1.CONTLSegPla, T1.CliCod, T1.TLiqCod FROM (ConceptoTipoLiquidacion T1 INNER JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo, T1.TLiqCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A69", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ? ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A70", "SELECT CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A71", "SELECT CliCod FROM ConceptoMotivosEgreso WHERE (CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND MegPreaTipo = ? AND ConMegMeses = ? AND ConMegDura = ?) AND (Not ( CliCod = ? and ConCodigo = ( ?) and MegCodigo = ( ?) and ConMegSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A72", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A73", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A74", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?  FOR UPDATE OF ConceptoMotivosEgreso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000A75", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A76", "SAVEPOINT gxupdate;UPDATE ConceptoMotivosEgreso SET MegPreaTipo=?, ConMegMeses=?, ConMegDura=?, ConMegPropor=?  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000A77", "SAVEPOINT gxupdate;DELETE FROM ConceptoMotivosEgreso  WHERE CliCod = ? AND ConCodigo = ? AND MegCodigo = ? AND ConMegSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000A78", "SELECT ConCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor, CliCod, MegCodigo FROM ConceptoMotivosEgreso WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo, MegCodigo, ConMegSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 32 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 56 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(17);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(18,4);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getLongVarchar(20);
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((byte[]) buf[28])[0] = rslt.getByte(22);
               ((String[]) buf[29])[0] = rslt.getString(23, 10);
               ((String[]) buf[30])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(29);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.getBoolean(32);
               ((byte[]) buf[44])[0] = rslt.getByte(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(34);
               ((boolean[]) buf[47])[0] = rslt.getBoolean(35);
               ((short[]) buf[48])[0] = rslt.getShort(36);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(37);
               ((String[]) buf[50])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[51])[0] = rslt.getBoolean(39);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(40);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((boolean[]) buf[54])[0] = rslt.getBoolean(41);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((String[]) buf[57])[0] = rslt.getString(43, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(44);
               ((byte[]) buf[60])[0] = rslt.getByte(45);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((boolean[]) buf[62])[0] = rslt.getBoolean(46);
               ((byte[]) buf[63])[0] = rslt.getByte(47);
               ((byte[]) buf[64])[0] = rslt.getByte(48);
               ((byte[]) buf[65])[0] = rslt.getByte(49);
               ((byte[]) buf[66])[0] = rslt.getByte(50);
               ((byte[]) buf[67])[0] = rslt.getByte(51);
               ((byte[]) buf[68])[0] = rslt.getByte(52);
               ((byte[]) buf[69])[0] = rslt.getByte(53);
               ((byte[]) buf[70])[0] = rslt.getByte(54);
               ((byte[]) buf[71])[0] = rslt.getByte(55);
               ((byte[]) buf[72])[0] = rslt.getByte(56);
               ((byte[]) buf[73])[0] = rslt.getByte(57);
               ((byte[]) buf[74])[0] = rslt.getByte(58);
               ((byte[]) buf[75])[0] = rslt.getByte(59);
               ((byte[]) buf[76])[0] = rslt.getByte(60);
               ((byte[]) buf[77])[0] = rslt.getByte(61);
               ((byte[]) buf[78])[0] = rslt.getByte(62);
               ((byte[]) buf[79])[0] = rslt.getByte(63);
               ((byte[]) buf[80])[0] = rslt.getByte(64);
               ((byte[]) buf[81])[0] = rslt.getByte(65);
               ((byte[]) buf[82])[0] = rslt.getByte(66);
               ((byte[]) buf[83])[0] = rslt.getByte(67);
               ((byte[]) buf[84])[0] = rslt.getByte(68);
               ((byte[]) buf[85])[0] = rslt.getByte(69);
               ((byte[]) buf[86])[0] = rslt.getByte(70);
               ((byte[]) buf[87])[0] = rslt.getByte(71);
               ((byte[]) buf[88])[0] = rslt.getByte(72);
               ((byte[]) buf[89])[0] = rslt.getByte(73);
               ((byte[]) buf[90])[0] = rslt.getByte(74);
               ((String[]) buf[91])[0] = rslt.getString(75, 6);
               ((byte[]) buf[92])[0] = rslt.getByte(76);
               ((boolean[]) buf[93])[0] = rslt.getBoolean(77);
               ((boolean[]) buf[94])[0] = rslt.getBoolean(78);
               ((int[]) buf[95])[0] = rslt.getInt(79);
               ((String[]) buf[96])[0] = rslt.getVarchar(80);
               ((String[]) buf[97])[0] = rslt.getVarchar(81);
               ((String[]) buf[98])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[99])[0] = rslt.wasNull();
               ((int[]) buf[100])[0] = rslt.getInt(83);
               ((boolean[]) buf[101])[0] = rslt.wasNull();
               ((int[]) buf[102])[0] = rslt.getInt(84);
               ((short[]) buf[103])[0] = rslt.getShort(85);
               ((boolean[]) buf[104])[0] = rslt.wasNull();
               ((String[]) buf[105])[0] = rslt.getString(86, 20);
               ((String[]) buf[106])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(88, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(89, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((short[]) buf[112])[0] = rslt.getShort(90);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(91, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((String[]) buf[116])[0] = rslt.getString(92, 10);
               ((boolean[]) buf[117])[0] = rslt.wasNull();
               return;
            case 57 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((String[]) buf[14])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((int[]) buf[18])[0] = rslt.getInt(13);
               ((String[]) buf[19])[0] = rslt.getString(14, 20);
               return;
            case 58 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 61 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               return;
            case 65 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 66 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((String[]) buf[14])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(12);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((int[]) buf[18])[0] = rslt.getInt(13);
               ((String[]) buf[19])[0] = rslt.getString(14, 20);
               return;
            case 67 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 71 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 72 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 76 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 10);
               }
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 22 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 10);
               }
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               stmt.setString(2, (String)parms[2], 10);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[4], false);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[6], 20);
               }
               stmt.setBoolean(5, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[10]).booleanValue());
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setNLongVarchar(10, (String)parms[12], false);
               stmt.setVarchar(11, (String)parms[13], 400, false);
               stmt.setBoolean(12, ((Boolean) parms[14]).booleanValue());
               stmt.setInt(13, ((Number) parms[15]).intValue());
               stmt.setByte(14, ((Number) parms[16]).byteValue());
               stmt.setByte(15, ((Number) parms[17]).byteValue());
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(16, (String)parms[19]);
               }
               stmt.setNLongVarchar(17, (String)parms[20], false);
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[22], 4);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(19, (String)parms[24], 1);
               }
               stmt.setNLongVarchar(20, (String)parms[25], false);
               if ( ((Boolean) parms[26]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(21, (String)parms[27]);
               }
               stmt.setByte(22, ((Number) parms[28]).byteValue());
               stmt.setString(23, (String)parms[29], 10);
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(24, (String)parms[31], 20);
               }
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(25, (String)parms[33], 20);
               }
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[35], 40);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[37], 40);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(28, (String)parms[39], 80);
               }
               stmt.setLong(29, ((Number) parms[40]).longValue());
               stmt.setNLongVarchar(30, (String)parms[41], false);
               stmt.setNLongVarchar(31, (String)parms[42], false);
               stmt.setBoolean(32, ((Boolean) parms[43]).booleanValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(33, ((Number) parms[45]).byteValue());
               }
               stmt.setBoolean(34, ((Boolean) parms[46]).booleanValue());
               stmt.setBoolean(35, ((Boolean) parms[47]).booleanValue());
               stmt.setShort(36, ((Number) parms[48]).shortValue());
               stmt.setBoolean(37, ((Boolean) parms[49]).booleanValue());
               stmt.setVarchar(38, (String)parms[50], 400, false);
               stmt.setBoolean(39, ((Boolean) parms[51]).booleanValue());
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(40, ((Boolean) parms[53]).booleanValue());
               }
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 41 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(41, ((Boolean) parms[55]).booleanValue());
               }
               stmt.setString(42, (String)parms[56], 20);
               if ( ((Boolean) parms[57]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[58], 20);
               }
               stmt.setBoolean(44, ((Boolean) parms[59]).booleanValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 45 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(45, ((Number) parms[61]).byteValue());
               }
               stmt.setBoolean(46, ((Boolean) parms[62]).booleanValue());
               stmt.setByte(47, ((Number) parms[63]).byteValue());
               stmt.setByte(48, ((Number) parms[64]).byteValue());
               stmt.setByte(49, ((Number) parms[65]).byteValue());
               stmt.setByte(50, ((Number) parms[66]).byteValue());
               stmt.setByte(51, ((Number) parms[67]).byteValue());
               stmt.setByte(52, ((Number) parms[68]).byteValue());
               stmt.setByte(53, ((Number) parms[69]).byteValue());
               stmt.setByte(54, ((Number) parms[70]).byteValue());
               stmt.setByte(55, ((Number) parms[71]).byteValue());
               stmt.setByte(56, ((Number) parms[72]).byteValue());
               stmt.setByte(57, ((Number) parms[73]).byteValue());
               stmt.setByte(58, ((Number) parms[74]).byteValue());
               stmt.setByte(59, ((Number) parms[75]).byteValue());
               stmt.setByte(60, ((Number) parms[76]).byteValue());
               stmt.setByte(61, ((Number) parms[77]).byteValue());
               stmt.setByte(62, ((Number) parms[78]).byteValue());
               stmt.setByte(63, ((Number) parms[79]).byteValue());
               stmt.setByte(64, ((Number) parms[80]).byteValue());
               stmt.setByte(65, ((Number) parms[81]).byteValue());
               stmt.setByte(66, ((Number) parms[82]).byteValue());
               stmt.setByte(67, ((Number) parms[83]).byteValue());
               stmt.setByte(68, ((Number) parms[84]).byteValue());
               stmt.setByte(69, ((Number) parms[85]).byteValue());
               stmt.setByte(70, ((Number) parms[86]).byteValue());
               stmt.setByte(71, ((Number) parms[87]).byteValue());
               stmt.setByte(72, ((Number) parms[88]).byteValue());
               stmt.setByte(73, ((Number) parms[89]).byteValue());
               stmt.setByte(74, ((Number) parms[90]).byteValue());
               stmt.setString(75, (String)parms[91], 6);
               stmt.setByte(76, ((Number) parms[92]).byteValue());
               stmt.setBoolean(77, ((Boolean) parms[93]).booleanValue());
               stmt.setBoolean(78, ((Boolean) parms[94]).booleanValue());
               stmt.setInt(79, ((Number) parms[95]).intValue());
               stmt.setVarchar(80, (String)parms[96], 40, false);
               stmt.setVarchar(81, (String)parms[97], 400, false);
               if ( ((Boolean) parms[98]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(82, (String)parms[99], 20);
               }
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(83, ((Number) parms[101]).intValue());
               }
               stmt.setInt(84, ((Number) parms[102]).intValue());
               if ( ((Boolean) parms[103]).booleanValue() )
               {
                  stmt.setNull( 85 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(85, ((Number) parms[104]).shortValue());
               }
               stmt.setString(86, (String)parms[105], 20);
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 87 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(87, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 88 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(88, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 89 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(89, (String)parms[111], 20);
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 90 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(90, ((Number) parms[113]).shortValue());
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 91 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(91, (String)parms[115], 20);
               }
               if ( ((Boolean) parms[116]).booleanValue() )
               {
                  stmt.setNull( 92 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(92, (String)parms[117], 10);
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(2, (java.util.Date)parms[3], false);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[5], 20);
               }
               stmt.setBoolean(4, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(8, ((Number) parms[10]).intValue());
               stmt.setNLongVarchar(9, (String)parms[11], false);
               stmt.setVarchar(10, (String)parms[12], 400, false);
               stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               stmt.setInt(12, ((Number) parms[14]).intValue());
               stmt.setByte(13, ((Number) parms[15]).byteValue());
               stmt.setByte(14, ((Number) parms[16]).byteValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(15, (String)parms[18]);
               }
               stmt.setNLongVarchar(16, (String)parms[19], false);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(17, (java.math.BigDecimal)parms[21], 4);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[23], 1);
               }
               stmt.setNLongVarchar(19, (String)parms[24], false);
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(20, (String)parms[26]);
               }
               stmt.setByte(21, ((Number) parms[27]).byteValue());
               stmt.setString(22, (String)parms[28], 10);
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[30], 20);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(24, (String)parms[32], 20);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(25, (String)parms[34], 40);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[36], 40);
               }
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[38], 80);
               }
               stmt.setLong(28, ((Number) parms[39]).longValue());
               stmt.setNLongVarchar(29, (String)parms[40], false);
               stmt.setNLongVarchar(30, (String)parms[41], false);
               stmt.setBoolean(31, ((Boolean) parms[42]).booleanValue());
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(32, ((Number) parms[44]).byteValue());
               }
               stmt.setBoolean(33, ((Boolean) parms[45]).booleanValue());
               stmt.setBoolean(34, ((Boolean) parms[46]).booleanValue());
               stmt.setShort(35, ((Number) parms[47]).shortValue());
               stmt.setBoolean(36, ((Boolean) parms[48]).booleanValue());
               stmt.setVarchar(37, (String)parms[49], 400, false);
               stmt.setBoolean(38, ((Boolean) parms[50]).booleanValue());
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(39, ((Boolean) parms[52]).booleanValue());
               }
               if ( ((Boolean) parms[53]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(40, ((Boolean) parms[54]).booleanValue());
               }
               stmt.setString(41, (String)parms[55], 20);
               if ( ((Boolean) parms[56]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[57], 20);
               }
               stmt.setBoolean(43, ((Boolean) parms[58]).booleanValue());
               if ( ((Boolean) parms[59]).booleanValue() )
               {
                  stmt.setNull( 44 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(44, ((Number) parms[60]).byteValue());
               }
               stmt.setBoolean(45, ((Boolean) parms[61]).booleanValue());
               stmt.setByte(46, ((Number) parms[62]).byteValue());
               stmt.setByte(47, ((Number) parms[63]).byteValue());
               stmt.setByte(48, ((Number) parms[64]).byteValue());
               stmt.setByte(49, ((Number) parms[65]).byteValue());
               stmt.setByte(50, ((Number) parms[66]).byteValue());
               stmt.setByte(51, ((Number) parms[67]).byteValue());
               stmt.setByte(52, ((Number) parms[68]).byteValue());
               stmt.setByte(53, ((Number) parms[69]).byteValue());
               stmt.setByte(54, ((Number) parms[70]).byteValue());
               stmt.setByte(55, ((Number) parms[71]).byteValue());
               stmt.setByte(56, ((Number) parms[72]).byteValue());
               stmt.setByte(57, ((Number) parms[73]).byteValue());
               stmt.setByte(58, ((Number) parms[74]).byteValue());
               stmt.setByte(59, ((Number) parms[75]).byteValue());
               stmt.setByte(60, ((Number) parms[76]).byteValue());
               stmt.setByte(61, ((Number) parms[77]).byteValue());
               stmt.setByte(62, ((Number) parms[78]).byteValue());
               stmt.setByte(63, ((Number) parms[79]).byteValue());
               stmt.setByte(64, ((Number) parms[80]).byteValue());
               stmt.setByte(65, ((Number) parms[81]).byteValue());
               stmt.setByte(66, ((Number) parms[82]).byteValue());
               stmt.setByte(67, ((Number) parms[83]).byteValue());
               stmt.setByte(68, ((Number) parms[84]).byteValue());
               stmt.setByte(69, ((Number) parms[85]).byteValue());
               stmt.setByte(70, ((Number) parms[86]).byteValue());
               stmt.setByte(71, ((Number) parms[87]).byteValue());
               stmt.setByte(72, ((Number) parms[88]).byteValue());
               stmt.setByte(73, ((Number) parms[89]).byteValue());
               stmt.setString(74, (String)parms[90], 6);
               stmt.setByte(75, ((Number) parms[91]).byteValue());
               stmt.setBoolean(76, ((Boolean) parms[92]).booleanValue());
               stmt.setBoolean(77, ((Boolean) parms[93]).booleanValue());
               stmt.setInt(78, ((Number) parms[94]).intValue());
               stmt.setVarchar(79, (String)parms[95], 40, false);
               stmt.setVarchar(80, (String)parms[96], 400, false);
               if ( ((Boolean) parms[97]).booleanValue() )
               {
                  stmt.setNull( 81 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(81, (String)parms[98], 20);
               }
               if ( ((Boolean) parms[99]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(82, ((Number) parms[100]).intValue());
               }
               if ( ((Boolean) parms[101]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(83, ((Number) parms[102]).shortValue());
               }
               stmt.setString(84, (String)parms[103], 20);
               if ( ((Boolean) parms[104]).booleanValue() )
               {
                  stmt.setNull( 85 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(85, (String)parms[105], 20);
               }
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 86 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(86, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 87 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(87, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 88 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(88, ((Number) parms[111]).shortValue());
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 89 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(89, (String)parms[113], 20);
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 90 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(90, (String)parms[115], 10);
               }
               stmt.setInt(91, ((Number) parms[116]).intValue());
               stmt.setString(92, (String)parms[117], 10);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 62 :
               stmt.setString(1, (String)parms[0], 10);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[2]).booleanValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(3, ((Boolean) parms[4]).booleanValue());
               }
               stmt.setString(4, (String)parms[5], 20);
               stmt.setLong(5, ((Number) parms[6]).longValue());
               stmt.setShort(6, ((Number) parms[7]).shortValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(7, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               stmt.setByte(9, ((Number) parms[12]).byteValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 20);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[16]).byteValue());
               }
               stmt.setInt(12, ((Number) parms[17]).intValue());
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 63 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(1, ((Boolean) parms[1]).booleanValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[3]).booleanValue());
               }
               stmt.setString(3, (String)parms[4], 20);
               stmt.setLong(4, ((Number) parms[5]).longValue());
               stmt.setShort(5, ((Number) parms[6]).shortValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[8]).byteValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               stmt.setByte(8, ((Number) parms[11]).byteValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[13], 20);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[15]).byteValue());
               }
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setString(12, (String)parms[17], 10);
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 73 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 74 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

