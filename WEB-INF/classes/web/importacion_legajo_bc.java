package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajo_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_legajo_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajo_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajo_bc.class ));
   }

   public importacion_legajo_bc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0175( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0175( ) ;
      standaloneModal( ) ;
      addRow0175( ) ;
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
         e11012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z87MigrLegNumero = A87MigrLegNumero ;
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

   public void confirm_010( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0175( ) ;
         }
         else
         {
            checkExtendedTable0175( ) ;
            if ( AnyError == 0 )
            {
               zm0175( 5) ;
            }
            closeExtendedTableCursors0175( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode75 = Gx_mode ;
         confirm_01262( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode75 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode75 ;
      }
   }

   public void confirm_01262( )
   {
      nGXsfl_262_idx = 0 ;
      while ( nGXsfl_262_idx < bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().size() )
      {
         readRow01262( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound262 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_262 != 0 ) )
         {
            getKey01262( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound262 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate01262( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable01262( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors01262( ) ;
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
               if ( RcdFound262 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey01262( ) ;
                     load01262( ) ;
                     beforeValidate01262( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls01262( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_262 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate01262( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable01262( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors01262( ) ;
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
            VarsToRow262( ((web.Sdtimportacion_legajo_Familia)bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().elementAt(-1+nGXsfl_262_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12012( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV56WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV56WWPContext = GXv_SdtWWPContext1[0] ;
      AV22IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Insert", GXv_boolean3) ;
         importacion_legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Update", GXv_boolean3) ;
         importacion_legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Delete", GXv_boolean3) ;
         importacion_legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV69Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV54TrnContext.fromxml(AV55WebSession.getValue("TrnContext"), null, null);
   }

   public void e11012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.msgdebug7(remoteHandle, context).execute( AV69Pgmname, httpContext.getMessage( "&Mode ", "")+Gx_mode) ;
      if ( ( A2197MigrValCadaSave ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV69Pgmname, httpContext.getMessage( "llama a validarRegistroMigracion", "")) ;
         GXv_objcol_svchar4[0] = AV67errores ;
         GXv_objcol_svchar5[0] = AV68warnings ;
         new web.validarregistromigracion(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, false, false, (short)(0), GXv_objcol_svchar4, GXv_objcol_svchar5) ;
         AV67errores = GXv_objcol_svchar4[0] ;
         AV68warnings = GXv_objcol_svchar5[0] ;
      }
   }

   public void zm0175( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z594MigrLegFecNac = A594MigrLegFecNac ;
         Z595MigrLegSexo = A595MigrLegSexo ;
         Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
         Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
         Z599MigrLegDomici = A599MigrLegDomici ;
         Z600MigrLegEmail = A600MigrLegEmail ;
         Z601MigrLegCodPos = A601MigrLegCodPos ;
         Z602MigrLegTelefono = A602MigrLegTelefono ;
         Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
         Z604MigrLegCategoria = A604MigrLegCategoria ;
         Z605MigrLegArea = A605MigrLegArea ;
         Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
         Z2415MigrLegModTra = A2415MigrLegModTra ;
         Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         Z607MigrLegClase = A607MigrLegClase ;
         Z608MigrLegBasico = A608MigrLegBasico ;
         Z609MigrLegFormaPago = A609MigrLegFormaPago ;
         Z691MigrLegClaseDef = A691MigrLegClaseDef ;
         Z610MigrLegBanco = A610MigrLegBanco ;
         Z611MigrLegBanSuc = A611MigrLegBanSuc ;
         Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
         Z613MigrLegSindicato = A613MigrLegSindicato ;
         Z614MigrLegObraSocial = A614MigrLegObraSocial ;
         Z634MigrLegOSAfip = A634MigrLegOSAfip ;
         Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
         Z616MigrLegActividad = A616MigrLegActividad ;
         Z617MigrLegModalidad = A617MigrLegModalidad ;
         Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
         Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
         Z620MigrLegZona = A620MigrLegZona ;
         Z621MigrLegCBU = A621MigrLegCBU ;
         Z622MigrLegSCVO = A622MigrLegSCVO ;
         Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
         Z624MigrLegCondicion = A624MigrLegCondicion ;
         Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
         Z626MigrLegId = A626MigrLegId ;
         Z627MigrLegConvenio = A627MigrLegConvenio ;
         Z631MigrTieneConyuge = A631MigrTieneConyuge ;
         Z632MigrCantidadHijos = A632MigrCantidadHijos ;
         Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         Z1398MigrTraDiurno = A1398MigrTraDiurno ;
         Z1399MigrTraNoct = A1399MigrTraNoct ;
         Z1400MigrTraIns = A1400MigrTraIns ;
         Z1820MigrEncontroOsoAfip = A1820MigrEncontroOsoAfip ;
         Z2190MigrPeriodo = A2190MigrPeriodo ;
         Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
         Z696MigrLegZonaDef = A696MigrLegZonaDef ;
         Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
         Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
         Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
         Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
         Z694MigrLegActividadDef = A694MigrLegActividadDef ;
         Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
         Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
         Z2197MigrValCadaSave = A2197MigrValCadaSave ;
         Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
         Z2216MigrPuesto = A2216MigrPuesto ;
         Z2221MigrLegMarcaCCT = A2221MigrLegMarcaCCT ;
         Z2222MigrArchSec = A2222MigrArchSec ;
         Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
         Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
         Z2275MigrLegHorSem = A2275MigrLegHorSem ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -4 )
      {
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z594MigrLegFecNac = A594MigrLegFecNac ;
         Z595MigrLegSexo = A595MigrLegSexo ;
         Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
         Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
         Z599MigrLegDomici = A599MigrLegDomici ;
         Z600MigrLegEmail = A600MigrLegEmail ;
         Z601MigrLegCodPos = A601MigrLegCodPos ;
         Z602MigrLegTelefono = A602MigrLegTelefono ;
         Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
         Z604MigrLegCategoria = A604MigrLegCategoria ;
         Z605MigrLegArea = A605MigrLegArea ;
         Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
         Z2415MigrLegModTra = A2415MigrLegModTra ;
         Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         Z607MigrLegClase = A607MigrLegClase ;
         Z608MigrLegBasico = A608MigrLegBasico ;
         Z609MigrLegFormaPago = A609MigrLegFormaPago ;
         Z691MigrLegClaseDef = A691MigrLegClaseDef ;
         Z610MigrLegBanco = A610MigrLegBanco ;
         Z611MigrLegBanSuc = A611MigrLegBanSuc ;
         Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
         Z613MigrLegSindicato = A613MigrLegSindicato ;
         Z614MigrLegObraSocial = A614MigrLegObraSocial ;
         Z634MigrLegOSAfip = A634MigrLegOSAfip ;
         Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
         Z616MigrLegActividad = A616MigrLegActividad ;
         Z617MigrLegModalidad = A617MigrLegModalidad ;
         Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
         Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
         Z620MigrLegZona = A620MigrLegZona ;
         Z621MigrLegCBU = A621MigrLegCBU ;
         Z622MigrLegSCVO = A622MigrLegSCVO ;
         Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
         Z624MigrLegCondicion = A624MigrLegCondicion ;
         Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
         Z626MigrLegId = A626MigrLegId ;
         Z627MigrLegConvenio = A627MigrLegConvenio ;
         Z628MigrLegObs = A628MigrLegObs ;
         Z629MigrLegErrores = A629MigrLegErrores ;
         Z633MigrLegWarnings = A633MigrLegWarnings ;
         Z631MigrTieneConyuge = A631MigrTieneConyuge ;
         Z632MigrCantidadHijos = A632MigrCantidadHijos ;
         Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         Z1398MigrTraDiurno = A1398MigrTraDiurno ;
         Z1399MigrTraNoct = A1399MigrTraNoct ;
         Z1400MigrTraIns = A1400MigrTraIns ;
         Z1820MigrEncontroOsoAfip = A1820MigrEncontroOsoAfip ;
         Z2189MigrSueldos = A2189MigrSueldos ;
         Z2190MigrPeriodo = A2190MigrPeriodo ;
         Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
         Z696MigrLegZonaDef = A696MigrLegZonaDef ;
         Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
         Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
         Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
         Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
         Z694MigrLegActividadDef = A694MigrLegActividadDef ;
         Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
         Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
         Z2197MigrValCadaSave = A2197MigrValCadaSave ;
         Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
         Z2206MigrOtrosDatos = A2206MigrOtrosDatos ;
         Z2216MigrPuesto = A2216MigrPuesto ;
         Z2221MigrLegMarcaCCT = A2221MigrLegMarcaCCT ;
         Z2222MigrArchSec = A2222MigrArchSec ;
         Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
         Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
         Z2275MigrLegHorSem = A2275MigrLegHorSem ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int6 = A3CliCod ;
         GXv_int7[0] = GXt_int6 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
         importacion_legajo_bc.this.GXt_int6 = GXv_int7[0] ;
         A3CliCod = GXt_int6 ;
      }
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int8 = A1EmpCod ;
         GXv_int9[0] = GXt_int8 ;
         new web.getempcod(remoteHandle, context).execute( GXv_int9) ;
         importacion_legajo_bc.this.GXt_int8 = GXv_int9[0] ;
         A1EmpCod = GXt_int8 ;
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV69Pgmname = "importacion_legajo_BC" ;
      }
   }

   public void load0175( )
   {
      /* Using cursor BC00017 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A592MigrLegApellido = BC00017_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC00017_A593MigrLegNombre[0] ;
         A594MigrLegFecNac = BC00017_A594MigrLegFecNac[0] ;
         A595MigrLegSexo = BC00017_A595MigrLegSexo[0] ;
         A596MigrLegEstadoCivil = BC00017_A596MigrLegEstadoCivil[0] ;
         A597MigrLegCUIL = BC00017_A597MigrLegCUIL[0] ;
         A598MigrLegDiscapacidad = BC00017_A598MigrLegDiscapacidad[0] ;
         A599MigrLegDomici = BC00017_A599MigrLegDomici[0] ;
         A600MigrLegEmail = BC00017_A600MigrLegEmail[0] ;
         A601MigrLegCodPos = BC00017_A601MigrLegCodPos[0] ;
         A602MigrLegTelefono = BC00017_A602MigrLegTelefono[0] ;
         A603MigrLegFecIngreso = BC00017_A603MigrLegFecIngreso[0] ;
         A604MigrLegCategoria = BC00017_A604MigrLegCategoria[0] ;
         A605MigrLegArea = BC00017_A605MigrLegArea[0] ;
         A606MigrLegLugarDePago = BC00017_A606MigrLegLugarDePago[0] ;
         A2415MigrLegModTra = BC00017_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = BC00017_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = BC00017_A607MigrLegClase[0] ;
         A608MigrLegBasico = BC00017_A608MigrLegBasico[0] ;
         A609MigrLegFormaPago = BC00017_A609MigrLegFormaPago[0] ;
         A691MigrLegClaseDef = BC00017_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = BC00017_A610MigrLegBanco[0] ;
         A611MigrLegBanSuc = BC00017_A611MigrLegBanSuc[0] ;
         A612MigrLegBanTipCuen = BC00017_A612MigrLegBanTipCuen[0] ;
         A613MigrLegSindicato = BC00017_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = BC00017_A614MigrLegObraSocial[0] ;
         A634MigrLegOSAfip = BC00017_A634MigrLegOSAfip[0] ;
         A615MigrLegPlanMedico = BC00017_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = BC00017_A616MigrLegActividad[0] ;
         A617MigrLegModalidad = BC00017_A617MigrLegModalidad[0] ;
         A618MigrLegFecUltMod = BC00017_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = BC00017_A619MigrLegCuentaBanc[0] ;
         A620MigrLegZona = BC00017_A620MigrLegZona[0] ;
         A621MigrLegCBU = BC00017_A621MigrLegCBU[0] ;
         A622MigrLegSCVO = BC00017_A622MigrLegSCVO[0] ;
         A623MigrLegSituacionRevista = BC00017_A623MigrLegSituacionRevista[0] ;
         A624MigrLegCondicion = BC00017_A624MigrLegCondicion[0] ;
         A625MigrLegSiniestrado = BC00017_A625MigrLegSiniestrado[0] ;
         A626MigrLegId = BC00017_A626MigrLegId[0] ;
         A627MigrLegConvenio = BC00017_A627MigrLegConvenio[0] ;
         A628MigrLegObs = BC00017_A628MigrLegObs[0] ;
         A629MigrLegErrores = BC00017_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = BC00017_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = BC00017_A631MigrTieneConyuge[0] ;
         A632MigrCantidadHijos = BC00017_A632MigrCantidadHijos[0] ;
         A635MigrEncontroOsoSigla = BC00017_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = BC00017_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = BC00017_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = BC00017_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = BC00017_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = BC00017_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = BC00017_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = BC00017_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = BC00017_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = BC00017_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = BC00017_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = BC00017_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = BC00017_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = BC00017_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = BC00017_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = BC00017_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = BC00017_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = BC00017_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = BC00017_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = BC00017_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = BC00017_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = BC00017_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = BC00017_A2222MigrArchSec[0] ;
         n2222MigrArchSec = BC00017_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = BC00017_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = BC00017_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = BC00017_A2275MigrLegHorSem[0] ;
         zm0175( -4) ;
      }
      pr_default.close(5);
      onLoadActions0175( ) ;
   }

   public void onLoadActions0175( )
   {
      AV69Pgmname = "importacion_legajo_BC" ;
   }

   public void checkExtendedTable0175( )
   {
      nIsDirty_75 = (short)(0) ;
      standaloneModal( ) ;
      AV69Pgmname = "importacion_legajo_BC" ;
      /* Using cursor BC00018 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0175( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0175( )
   {
      /* Using cursor BC00019 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound75 = (short)(1) ;
      }
      else
      {
         RcdFound75 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000110 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0175( 4) ;
         RcdFound75 = (short)(1) ;
         A87MigrLegNumero = BC000110_A87MigrLegNumero[0] ;
         A592MigrLegApellido = BC000110_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC000110_A593MigrLegNombre[0] ;
         A594MigrLegFecNac = BC000110_A594MigrLegFecNac[0] ;
         A595MigrLegSexo = BC000110_A595MigrLegSexo[0] ;
         A596MigrLegEstadoCivil = BC000110_A596MigrLegEstadoCivil[0] ;
         A597MigrLegCUIL = BC000110_A597MigrLegCUIL[0] ;
         A598MigrLegDiscapacidad = BC000110_A598MigrLegDiscapacidad[0] ;
         A599MigrLegDomici = BC000110_A599MigrLegDomici[0] ;
         A600MigrLegEmail = BC000110_A600MigrLegEmail[0] ;
         A601MigrLegCodPos = BC000110_A601MigrLegCodPos[0] ;
         A602MigrLegTelefono = BC000110_A602MigrLegTelefono[0] ;
         A603MigrLegFecIngreso = BC000110_A603MigrLegFecIngreso[0] ;
         A604MigrLegCategoria = BC000110_A604MigrLegCategoria[0] ;
         A605MigrLegArea = BC000110_A605MigrLegArea[0] ;
         A606MigrLegLugarDePago = BC000110_A606MigrLegLugarDePago[0] ;
         A2415MigrLegModTra = BC000110_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = BC000110_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = BC000110_A607MigrLegClase[0] ;
         A608MigrLegBasico = BC000110_A608MigrLegBasico[0] ;
         A609MigrLegFormaPago = BC000110_A609MigrLegFormaPago[0] ;
         A691MigrLegClaseDef = BC000110_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = BC000110_A610MigrLegBanco[0] ;
         A611MigrLegBanSuc = BC000110_A611MigrLegBanSuc[0] ;
         A612MigrLegBanTipCuen = BC000110_A612MigrLegBanTipCuen[0] ;
         A613MigrLegSindicato = BC000110_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = BC000110_A614MigrLegObraSocial[0] ;
         A634MigrLegOSAfip = BC000110_A634MigrLegOSAfip[0] ;
         A615MigrLegPlanMedico = BC000110_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = BC000110_A616MigrLegActividad[0] ;
         A617MigrLegModalidad = BC000110_A617MigrLegModalidad[0] ;
         A618MigrLegFecUltMod = BC000110_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = BC000110_A619MigrLegCuentaBanc[0] ;
         A620MigrLegZona = BC000110_A620MigrLegZona[0] ;
         A621MigrLegCBU = BC000110_A621MigrLegCBU[0] ;
         A622MigrLegSCVO = BC000110_A622MigrLegSCVO[0] ;
         A623MigrLegSituacionRevista = BC000110_A623MigrLegSituacionRevista[0] ;
         A624MigrLegCondicion = BC000110_A624MigrLegCondicion[0] ;
         A625MigrLegSiniestrado = BC000110_A625MigrLegSiniestrado[0] ;
         A626MigrLegId = BC000110_A626MigrLegId[0] ;
         A627MigrLegConvenio = BC000110_A627MigrLegConvenio[0] ;
         A628MigrLegObs = BC000110_A628MigrLegObs[0] ;
         A629MigrLegErrores = BC000110_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = BC000110_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = BC000110_A631MigrTieneConyuge[0] ;
         A632MigrCantidadHijos = BC000110_A632MigrCantidadHijos[0] ;
         A635MigrEncontroOsoSigla = BC000110_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = BC000110_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = BC000110_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = BC000110_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = BC000110_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = BC000110_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = BC000110_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = BC000110_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = BC000110_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = BC000110_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = BC000110_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = BC000110_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = BC000110_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = BC000110_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = BC000110_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = BC000110_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = BC000110_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = BC000110_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = BC000110_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = BC000110_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = BC000110_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = BC000110_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = BC000110_A2222MigrArchSec[0] ;
         n2222MigrArchSec = BC000110_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = BC000110_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = BC000110_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = BC000110_A2275MigrLegHorSem[0] ;
         A3CliCod = BC000110_A3CliCod[0] ;
         A1EmpCod = BC000110_A1EmpCod[0] ;
         O634MigrLegOSAfip = A634MigrLegOSAfip ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0175( ) ;
         if ( AnyError == 1 )
         {
            RcdFound75 = (short)(0) ;
            initializeNonKey0175( ) ;
         }
         Gx_mode = sMode75 ;
      }
      else
      {
         RcdFound75 = (short)(0) ;
         initializeNonKey0175( ) ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode75 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0175( ) ;
      if ( RcdFound75 == 0 )
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
      confirm_010( ) ;
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

   public void checkOptimisticConcurrency0175( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000111 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z592MigrLegApellido, BC000111_A592MigrLegApellido[0]) != 0 ) || ( GXutil.strcmp(Z593MigrLegNombre, BC000111_A593MigrLegNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z594MigrLegFecNac), GXutil.resetTime(BC000111_A594MigrLegFecNac[0])) ) || ( GXutil.strcmp(Z595MigrLegSexo, BC000111_A595MigrLegSexo[0]) != 0 ) || ( GXutil.strcmp(Z596MigrLegEstadoCivil, BC000111_A596MigrLegEstadoCivil[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z597MigrLegCUIL, BC000111_A597MigrLegCUIL[0]) != 0 ) || ( GXutil.strcmp(Z598MigrLegDiscapacidad, BC000111_A598MigrLegDiscapacidad[0]) != 0 ) || ( GXutil.strcmp(Z599MigrLegDomici, BC000111_A599MigrLegDomici[0]) != 0 ) || ( GXutil.strcmp(Z600MigrLegEmail, BC000111_A600MigrLegEmail[0]) != 0 ) || ( GXutil.strcmp(Z601MigrLegCodPos, BC000111_A601MigrLegCodPos[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z602MigrLegTelefono, BC000111_A602MigrLegTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z603MigrLegFecIngreso), GXutil.resetTime(BC000111_A603MigrLegFecIngreso[0])) ) || ( GXutil.strcmp(Z604MigrLegCategoria, BC000111_A604MigrLegCategoria[0]) != 0 ) || ( GXutil.strcmp(Z605MigrLegArea, BC000111_A605MigrLegArea[0]) != 0 ) || ( GXutil.strcmp(Z606MigrLegLugarDePago, BC000111_A606MigrLegLugarDePago[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2415MigrLegModTra, BC000111_A2415MigrLegModTra[0]) != 0 ) || ( GXutil.strcmp(Z2427MigrLegTipoTarifa, BC000111_A2427MigrLegTipoTarifa[0]) != 0 ) || ( GXutil.strcmp(Z607MigrLegClase, BC000111_A607MigrLegClase[0]) != 0 ) || ( DecimalUtil.compareTo(Z608MigrLegBasico, BC000111_A608MigrLegBasico[0]) != 0 ) || ( GXutil.strcmp(Z609MigrLegFormaPago, BC000111_A609MigrLegFormaPago[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z691MigrLegClaseDef != BC000111_A691MigrLegClaseDef[0] ) || ( GXutil.strcmp(Z610MigrLegBanco, BC000111_A610MigrLegBanco[0]) != 0 ) || ( GXutil.strcmp(Z611MigrLegBanSuc, BC000111_A611MigrLegBanSuc[0]) != 0 ) || ( GXutil.strcmp(Z612MigrLegBanTipCuen, BC000111_A612MigrLegBanTipCuen[0]) != 0 ) || ( GXutil.strcmp(Z613MigrLegSindicato, BC000111_A613MigrLegSindicato[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z614MigrLegObraSocial, BC000111_A614MigrLegObraSocial[0]) != 0 ) || ( GXutil.strcmp(Z634MigrLegOSAfip, BC000111_A634MigrLegOSAfip[0]) != 0 ) || ( GXutil.strcmp(Z615MigrLegPlanMedico, BC000111_A615MigrLegPlanMedico[0]) != 0 ) || ( GXutil.strcmp(Z616MigrLegActividad, BC000111_A616MigrLegActividad[0]) != 0 ) || ( GXutil.strcmp(Z617MigrLegModalidad, BC000111_A617MigrLegModalidad[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z618MigrLegFecUltMod), GXutil.resetTime(BC000111_A618MigrLegFecUltMod[0])) ) || ( GXutil.strcmp(Z619MigrLegCuentaBanc, BC000111_A619MigrLegCuentaBanc[0]) != 0 ) || ( GXutil.strcmp(Z620MigrLegZona, BC000111_A620MigrLegZona[0]) != 0 ) || ( GXutil.strcmp(Z621MigrLegCBU, BC000111_A621MigrLegCBU[0]) != 0 ) || ( GXutil.strcmp(Z622MigrLegSCVO, BC000111_A622MigrLegSCVO[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z623MigrLegSituacionRevista, BC000111_A623MigrLegSituacionRevista[0]) != 0 ) || ( GXutil.strcmp(Z624MigrLegCondicion, BC000111_A624MigrLegCondicion[0]) != 0 ) || ( GXutil.strcmp(Z625MigrLegSiniestrado, BC000111_A625MigrLegSiniestrado[0]) != 0 ) || ( GXutil.strcmp(Z626MigrLegId, BC000111_A626MigrLegId[0]) != 0 ) || ( GXutil.strcmp(Z627MigrLegConvenio, BC000111_A627MigrLegConvenio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z631MigrTieneConyuge, BC000111_A631MigrTieneConyuge[0]) != 0 ) || ( Z632MigrCantidadHijos != BC000111_A632MigrCantidadHijos[0] ) || ( Z635MigrEncontroOsoSigla != BC000111_A635MigrEncontroOsoSigla[0] ) || ( GXutil.strcmp(Z1398MigrTraDiurno, BC000111_A1398MigrTraDiurno[0]) != 0 ) || ( GXutil.strcmp(Z1399MigrTraNoct, BC000111_A1399MigrTraNoct[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1400MigrTraIns, BC000111_A1400MigrTraIns[0]) != 0 ) || ( Z1820MigrEncontroOsoAfip != BC000111_A1820MigrEncontroOsoAfip[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z2190MigrPeriodo), GXutil.resetTime(BC000111_A2190MigrPeriodo[0])) ) || ( Z695MigrLegModalidadDef != BC000111_A695MigrLegModalidadDef[0] ) || ( Z696MigrLegZonaDef != BC000111_A696MigrLegZonaDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z698MigrLegSituacionDef != BC000111_A698MigrLegSituacionDef[0] ) || ( Z690MigrLegEstadoCivilDef != BC000111_A690MigrLegEstadoCivilDef[0] ) || ( Z692MigrLegFormaPagoDef != BC000111_A692MigrLegFormaPagoDef[0] ) || ( Z693MigrLegTipoCuentaDef != BC000111_A693MigrLegTipoCuentaDef[0] ) || ( Z694MigrLegActividadDef != BC000111_A694MigrLegActividadDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z699MigrLegCondicionDef != BC000111_A699MigrLegCondicionDef[0] ) || ( Z700MigrLegSiniestradoDef != BC000111_A700MigrLegSiniestradoDef[0] ) || ( Z2197MigrValCadaSave != BC000111_A2197MigrValCadaSave[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z2205MigrLegFecEgreso), GXutil.resetTime(BC000111_A2205MigrLegFecEgreso[0])) ) || ( GXutil.strcmp(Z2216MigrPuesto, BC000111_A2216MigrPuesto[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2221MigrLegMarcaCCT, BC000111_A2221MigrLegMarcaCCT[0]) != 0 ) || ( Z2222MigrArchSec != BC000111_A2222MigrArchSec[0] ) || ( GXutil.strcmp(Z2239MigrLegActLabClas, BC000111_A2239MigrLegActLabClas[0]) != 0 ) || ( GXutil.strcmp(Z2240MigrLegPueAfip, BC000111_A2240MigrLegPueAfip[0]) != 0 ) || ( DecimalUtil.compareTo(Z2275MigrLegHorSem, BC000111_A2275MigrLegHorSem[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0175( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0175( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0175( 0) ;
         checkOptimisticConcurrency0175( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0175( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0175( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000112 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A87MigrLegNumero), A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A595MigrLegSexo, A596MigrLegEstadoCivil, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A604MigrLegCategoria, A605MigrLegArea, A606MigrLegLugarDePago, A2415MigrLegModTra, A2427MigrLegTipoTarifa, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, Boolean.valueOf(A691MigrLegClaseDef), A610MigrLegBanco, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A613MigrLegSindicato, A614MigrLegObraSocial, A634MigrLegOSAfip, A615MigrLegPlanMedico, A616MigrLegActividad, A617MigrLegModalidad, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A620MigrLegZona, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A624MigrLegCondicion, A625MigrLegSiniestrado, A626MigrLegId, A627MigrLegConvenio, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), A1398MigrTraDiurno, A1399MigrTraNoct, A1400MigrTraIns, Boolean.valueOf(A1820MigrEncontroOsoAfip), A2189MigrSueldos, A2190MigrPeriodo, Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), Boolean.valueOf(A2197MigrValCadaSave), A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2216MigrPuesto, Boolean.valueOf(n2221MigrLegMarcaCCT), A2221MigrLegMarcaCCT, Boolean.valueOf(n2222MigrArchSec), Short.valueOf(A2222MigrArchSec), A2239MigrLegActLabClas, A2240MigrLegPueAfip, A2275MigrLegHorSem, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel0175( ) ;
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
            load0175( ) ;
         }
         endLevel0175( ) ;
      }
      closeExtendedTableCursors0175( ) ;
   }

   public void update0175( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0175( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0175( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0175( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0175( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000113 */
                  pr_default.execute(11, new Object[] {A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A595MigrLegSexo, A596MigrLegEstadoCivil, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A604MigrLegCategoria, A605MigrLegArea, A606MigrLegLugarDePago, A2415MigrLegModTra, A2427MigrLegTipoTarifa, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, Boolean.valueOf(A691MigrLegClaseDef), A610MigrLegBanco, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A613MigrLegSindicato, A614MigrLegObraSocial, A634MigrLegOSAfip, A615MigrLegPlanMedico, A616MigrLegActividad, A617MigrLegModalidad, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A620MigrLegZona, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A624MigrLegCondicion, A625MigrLegSiniestrado, A626MigrLegId, A627MigrLegConvenio, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), A1398MigrTraDiurno, A1399MigrTraNoct, A1400MigrTraIns, Boolean.valueOf(A1820MigrEncontroOsoAfip), A2189MigrSueldos, A2190MigrPeriodo, Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), Boolean.valueOf(A2197MigrValCadaSave), A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2216MigrPuesto, Boolean.valueOf(n2221MigrLegMarcaCCT), A2221MigrLegMarcaCCT, Boolean.valueOf(n2222MigrArchSec), Short.valueOf(A2222MigrArchSec), A2239MigrLegActLabClas, A2240MigrLegPueAfip, A2275MigrLegHorSem, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0175( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0175( ) ;
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
         endLevel0175( ) ;
      }
      closeExtendedTableCursors0175( ) ;
   }

   public void deferredUpdate0175( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0175( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0175( ) ;
         afterConfirm0175( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0175( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart01262( ) ;
               while ( RcdFound262 != 0 )
               {
                  getByPrimaryKey01262( ) ;
                  delete01262( ) ;
                  scanKeyNext01262( ) ;
               }
               scanKeyEnd01262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000114 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
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
      sMode75 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0175( ) ;
      Gx_mode = sMode75 ;
   }

   public void onDeleteControls0175( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV69Pgmname = "importacion_legajo_BC" ;
      }
   }

   public void processNestedLevel01262( )
   {
      nGXsfl_262_idx = 0 ;
      while ( nGXsfl_262_idx < bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().size() )
      {
         readRow01262( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound262 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_262 != 0 ) )
         {
            standaloneNotModal01262( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert01262( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete01262( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update01262( ) ;
               }
            }
         }
         KeyVarsToRow262( ((web.Sdtimportacion_legajo_Familia)bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().elementAt(-1+nGXsfl_262_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_262_idx = 0 ;
         while ( nGXsfl_262_idx < bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().size() )
         {
            readRow01262( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound262 == 0 )
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
               bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().removeElement(nGXsfl_262_idx);
               nGXsfl_262_idx = (int)(nGXsfl_262_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey01262( ) ;
               VarsToRow262( ((web.Sdtimportacion_legajo_Familia)bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().elementAt(-1+nGXsfl_262_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll01262( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_262 = (short)(0) ;
      nIsMod_262 = (short)(0) ;
      Gxremove262 = (byte)(0) ;
   }

   public void processLevel0175( )
   {
      /* Save parent mode. */
      sMode75 = Gx_mode ;
      processNestedLevel01262( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode75 ;
      /* ' Update level parameters */
   }

   public void endLevel0175( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0175( ) ;
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

   public void scanKeyStart0175( )
   {
      /* Scan By routine */
      /* Using cursor BC000115 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      RcdFound75 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A87MigrLegNumero = BC000115_A87MigrLegNumero[0] ;
         A592MigrLegApellido = BC000115_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC000115_A593MigrLegNombre[0] ;
         A594MigrLegFecNac = BC000115_A594MigrLegFecNac[0] ;
         A595MigrLegSexo = BC000115_A595MigrLegSexo[0] ;
         A596MigrLegEstadoCivil = BC000115_A596MigrLegEstadoCivil[0] ;
         A597MigrLegCUIL = BC000115_A597MigrLegCUIL[0] ;
         A598MigrLegDiscapacidad = BC000115_A598MigrLegDiscapacidad[0] ;
         A599MigrLegDomici = BC000115_A599MigrLegDomici[0] ;
         A600MigrLegEmail = BC000115_A600MigrLegEmail[0] ;
         A601MigrLegCodPos = BC000115_A601MigrLegCodPos[0] ;
         A602MigrLegTelefono = BC000115_A602MigrLegTelefono[0] ;
         A603MigrLegFecIngreso = BC000115_A603MigrLegFecIngreso[0] ;
         A604MigrLegCategoria = BC000115_A604MigrLegCategoria[0] ;
         A605MigrLegArea = BC000115_A605MigrLegArea[0] ;
         A606MigrLegLugarDePago = BC000115_A606MigrLegLugarDePago[0] ;
         A2415MigrLegModTra = BC000115_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = BC000115_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = BC000115_A607MigrLegClase[0] ;
         A608MigrLegBasico = BC000115_A608MigrLegBasico[0] ;
         A609MigrLegFormaPago = BC000115_A609MigrLegFormaPago[0] ;
         A691MigrLegClaseDef = BC000115_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = BC000115_A610MigrLegBanco[0] ;
         A611MigrLegBanSuc = BC000115_A611MigrLegBanSuc[0] ;
         A612MigrLegBanTipCuen = BC000115_A612MigrLegBanTipCuen[0] ;
         A613MigrLegSindicato = BC000115_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = BC000115_A614MigrLegObraSocial[0] ;
         A634MigrLegOSAfip = BC000115_A634MigrLegOSAfip[0] ;
         A615MigrLegPlanMedico = BC000115_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = BC000115_A616MigrLegActividad[0] ;
         A617MigrLegModalidad = BC000115_A617MigrLegModalidad[0] ;
         A618MigrLegFecUltMod = BC000115_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = BC000115_A619MigrLegCuentaBanc[0] ;
         A620MigrLegZona = BC000115_A620MigrLegZona[0] ;
         A621MigrLegCBU = BC000115_A621MigrLegCBU[0] ;
         A622MigrLegSCVO = BC000115_A622MigrLegSCVO[0] ;
         A623MigrLegSituacionRevista = BC000115_A623MigrLegSituacionRevista[0] ;
         A624MigrLegCondicion = BC000115_A624MigrLegCondicion[0] ;
         A625MigrLegSiniestrado = BC000115_A625MigrLegSiniestrado[0] ;
         A626MigrLegId = BC000115_A626MigrLegId[0] ;
         A627MigrLegConvenio = BC000115_A627MigrLegConvenio[0] ;
         A628MigrLegObs = BC000115_A628MigrLegObs[0] ;
         A629MigrLegErrores = BC000115_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = BC000115_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = BC000115_A631MigrTieneConyuge[0] ;
         A632MigrCantidadHijos = BC000115_A632MigrCantidadHijos[0] ;
         A635MigrEncontroOsoSigla = BC000115_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = BC000115_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = BC000115_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = BC000115_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = BC000115_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = BC000115_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = BC000115_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = BC000115_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = BC000115_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = BC000115_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = BC000115_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = BC000115_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = BC000115_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = BC000115_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = BC000115_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = BC000115_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = BC000115_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = BC000115_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = BC000115_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = BC000115_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = BC000115_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = BC000115_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = BC000115_A2222MigrArchSec[0] ;
         n2222MigrArchSec = BC000115_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = BC000115_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = BC000115_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = BC000115_A2275MigrLegHorSem[0] ;
         A3CliCod = BC000115_A3CliCod[0] ;
         A1EmpCod = BC000115_A1EmpCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0175( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound75 = (short)(0) ;
      scanKeyLoad0175( ) ;
   }

   public void scanKeyLoad0175( )
   {
      sMode75 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A87MigrLegNumero = BC000115_A87MigrLegNumero[0] ;
         A592MigrLegApellido = BC000115_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC000115_A593MigrLegNombre[0] ;
         A594MigrLegFecNac = BC000115_A594MigrLegFecNac[0] ;
         A595MigrLegSexo = BC000115_A595MigrLegSexo[0] ;
         A596MigrLegEstadoCivil = BC000115_A596MigrLegEstadoCivil[0] ;
         A597MigrLegCUIL = BC000115_A597MigrLegCUIL[0] ;
         A598MigrLegDiscapacidad = BC000115_A598MigrLegDiscapacidad[0] ;
         A599MigrLegDomici = BC000115_A599MigrLegDomici[0] ;
         A600MigrLegEmail = BC000115_A600MigrLegEmail[0] ;
         A601MigrLegCodPos = BC000115_A601MigrLegCodPos[0] ;
         A602MigrLegTelefono = BC000115_A602MigrLegTelefono[0] ;
         A603MigrLegFecIngreso = BC000115_A603MigrLegFecIngreso[0] ;
         A604MigrLegCategoria = BC000115_A604MigrLegCategoria[0] ;
         A605MigrLegArea = BC000115_A605MigrLegArea[0] ;
         A606MigrLegLugarDePago = BC000115_A606MigrLegLugarDePago[0] ;
         A2415MigrLegModTra = BC000115_A2415MigrLegModTra[0] ;
         A2427MigrLegTipoTarifa = BC000115_A2427MigrLegTipoTarifa[0] ;
         A607MigrLegClase = BC000115_A607MigrLegClase[0] ;
         A608MigrLegBasico = BC000115_A608MigrLegBasico[0] ;
         A609MigrLegFormaPago = BC000115_A609MigrLegFormaPago[0] ;
         A691MigrLegClaseDef = BC000115_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = BC000115_A610MigrLegBanco[0] ;
         A611MigrLegBanSuc = BC000115_A611MigrLegBanSuc[0] ;
         A612MigrLegBanTipCuen = BC000115_A612MigrLegBanTipCuen[0] ;
         A613MigrLegSindicato = BC000115_A613MigrLegSindicato[0] ;
         A614MigrLegObraSocial = BC000115_A614MigrLegObraSocial[0] ;
         A634MigrLegOSAfip = BC000115_A634MigrLegOSAfip[0] ;
         A615MigrLegPlanMedico = BC000115_A615MigrLegPlanMedico[0] ;
         A616MigrLegActividad = BC000115_A616MigrLegActividad[0] ;
         A617MigrLegModalidad = BC000115_A617MigrLegModalidad[0] ;
         A618MigrLegFecUltMod = BC000115_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = BC000115_A619MigrLegCuentaBanc[0] ;
         A620MigrLegZona = BC000115_A620MigrLegZona[0] ;
         A621MigrLegCBU = BC000115_A621MigrLegCBU[0] ;
         A622MigrLegSCVO = BC000115_A622MigrLegSCVO[0] ;
         A623MigrLegSituacionRevista = BC000115_A623MigrLegSituacionRevista[0] ;
         A624MigrLegCondicion = BC000115_A624MigrLegCondicion[0] ;
         A625MigrLegSiniestrado = BC000115_A625MigrLegSiniestrado[0] ;
         A626MigrLegId = BC000115_A626MigrLegId[0] ;
         A627MigrLegConvenio = BC000115_A627MigrLegConvenio[0] ;
         A628MigrLegObs = BC000115_A628MigrLegObs[0] ;
         A629MigrLegErrores = BC000115_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = BC000115_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = BC000115_A631MigrTieneConyuge[0] ;
         A632MigrCantidadHijos = BC000115_A632MigrCantidadHijos[0] ;
         A635MigrEncontroOsoSigla = BC000115_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = BC000115_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = BC000115_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = BC000115_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = BC000115_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = BC000115_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = BC000115_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = BC000115_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = BC000115_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = BC000115_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = BC000115_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = BC000115_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = BC000115_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = BC000115_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = BC000115_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = BC000115_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = BC000115_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = BC000115_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = BC000115_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = BC000115_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = BC000115_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = BC000115_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = BC000115_A2222MigrArchSec[0] ;
         n2222MigrArchSec = BC000115_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = BC000115_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = BC000115_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = BC000115_A2275MigrLegHorSem[0] ;
         A3CliCod = BC000115_A3CliCod[0] ;
         A1EmpCod = BC000115_A1EmpCod[0] ;
      }
      Gx_mode = sMode75 ;
   }

   public void scanKeyEnd0175( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0175( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0175( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0175( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0175( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0175( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0175( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0175( )
   {
   }

   public void zm01262( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
      }
      if ( GX_JID == -6 )
      {
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal01262( )
   {
   }

   public void standaloneModal01262( )
   {
   }

   public void load01262( )
   {
      /* Using cursor BC000116 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2079MigrLegFamParen = BC000116_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = BC000116_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC000116_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC000116_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = BC000116_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = BC000116_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC000116_A2089MigrLegFamFecNac[0] ;
         zm01262( -6) ;
      }
      pr_default.close(14);
      onLoadActions01262( ) ;
   }

   public void onLoadActions01262( )
   {
   }

   public void checkExtendedTable01262( )
   {
      nIsDirty_262 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal01262( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors01262( )
   {
   }

   public void enableDisable01262( )
   {
   }

   public void getKey01262( )
   {
      /* Using cursor BC000117 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound262 = (short)(1) ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey01262( )
   {
      /* Using cursor BC000118 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         zm01262( 6) ;
         RcdFound262 = (short)(1) ;
         initializeNonKey01262( ) ;
         A2078MigrLegFamSec = BC000118_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC000118_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = BC000118_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC000118_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC000118_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = BC000118_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = BC000118_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC000118_A2089MigrLegFamFecNac[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         load01262( ) ;
         Gx_mode = sMode262 ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
         initializeNonKey01262( ) ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal01262( ) ;
         Gx_mode = sMode262 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes01262( ) ;
      }
      pr_default.close(16);
   }

   public void checkOptimisticConcurrency01262( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000119 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
         if ( (pr_default.getStatus(17) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(17) == 101) || ( GXutil.strcmp(Z2079MigrLegFamParen, BC000119_A2079MigrLegFamParen[0]) != 0 ) || ( GXutil.strcmp(Z2080MigrLegFamNroDoc, BC000119_A2080MigrLegFamNroDoc[0]) != 0 ) || ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, BC000119_A2081MigrLegFamDedGan[0]) != 0 ) || ( GXutil.strcmp(Z2082MigrLegFamAdh, BC000119_A2082MigrLegFamAdh[0]) != 0 ) || ( GXutil.strcmp(Z2086MigrLegFamDiscap, BC000119_A2086MigrLegFamDiscap[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2088MigrLegFamNomApe, BC000119_A2088MigrLegFamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(BC000119_A2089MigrLegFamFecNac[0])) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert01262( )
   {
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable01262( ) ;
      }
      if ( AnyError == 0 )
      {
         zm01262( 0) ;
         checkOptimisticConcurrency01262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm01262( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert01262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000120 */
                  pr_default.execute(18, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec), A2079MigrLegFamParen, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2086MigrLegFamDiscap, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(18) == 1) )
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
            load01262( ) ;
         }
         endLevel01262( ) ;
      }
      closeExtendedTableCursors01262( ) ;
   }

   public void update01262( )
   {
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable01262( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency01262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm01262( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate01262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000121 */
                  pr_default.execute(19, new Object[] {A2079MigrLegFamParen, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2086MigrLegFamDiscap, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate01262( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey01262( ) ;
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
         endLevel01262( ) ;
      }
      closeExtendedTableCursors01262( ) ;
   }

   public void deferredUpdate01262( )
   {
   }

   public void delete01262( )
   {
      Gx_mode = "DLT" ;
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency01262( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls01262( ) ;
         afterConfirm01262( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete01262( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000122 */
               pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
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
      sMode262 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel01262( ) ;
      Gx_mode = sMode262 ;
   }

   public void onDeleteControls01262( )
   {
      standaloneModal01262( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel01262( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(17);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart01262( )
   {
      /* Scan By routine */
      /* Using cursor BC000123 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = BC000123_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC000123_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = BC000123_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC000123_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC000123_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = BC000123_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = BC000123_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC000123_A2089MigrLegFamFecNac[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext01262( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound262 = (short)(0) ;
      scanKeyLoad01262( ) ;
   }

   public void scanKeyLoad01262( )
   {
      sMode262 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = BC000123_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC000123_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = BC000123_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC000123_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC000123_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = BC000123_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = BC000123_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC000123_A2089MigrLegFamFecNac[0] ;
      }
      Gx_mode = sMode262 ;
   }

   public void scanKeyEnd01262( )
   {
      pr_default.close(21);
   }

   public void afterConfirm01262( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert01262( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate01262( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete01262( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete01262( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate01262( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes01262( )
   {
   }

   public void send_integrity_lvl_hashes01262( )
   {
   }

   public void send_integrity_lvl_hashes0175( )
   {
   }

   public void addRow0175( )
   {
      VarsToRow75( bcimportacion_legajo) ;
   }

   public void readRow0175( )
   {
      RowToVars75( bcimportacion_legajo, 1) ;
   }

   public void addRow01262( )
   {
      web.Sdtimportacion_legajo_Familia obj262;
      obj262 = new web.Sdtimportacion_legajo_Familia(remoteHandle);
      VarsToRow262( obj262) ;
      bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().add(obj262, 0);
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Mode( "UPD" );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Modified( (short)(0) );
   }

   public void readRow01262( )
   {
      nGXsfl_262_idx = (int)(nGXsfl_262_idx+1) ;
      RowToVars262( ((web.Sdtimportacion_legajo_Familia)bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().elementAt(-1+nGXsfl_262_idx)), 1) ;
   }

   public void initializeNonKey0175( )
   {
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A595MigrLegSexo = "" ;
      A596MigrLegEstadoCivil = "" ;
      A597MigrLegCUIL = "" ;
      A598MigrLegDiscapacidad = "" ;
      A599MigrLegDomici = "" ;
      A600MigrLegEmail = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      A604MigrLegCategoria = "" ;
      A605MigrLegArea = "" ;
      A606MigrLegLugarDePago = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      A607MigrLegClase = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      A609MigrLegFormaPago = "" ;
      A691MigrLegClaseDef = false ;
      A610MigrLegBanco = "" ;
      A611MigrLegBanSuc = "" ;
      A612MigrLegBanTipCuen = "" ;
      A613MigrLegSindicato = "" ;
      A614MigrLegObraSocial = "" ;
      A634MigrLegOSAfip = "" ;
      A615MigrLegPlanMedico = "" ;
      A616MigrLegActividad = "" ;
      A617MigrLegModalidad = "" ;
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      A619MigrLegCuentaBanc = "" ;
      A620MigrLegZona = "" ;
      A621MigrLegCBU = "" ;
      A622MigrLegSCVO = "" ;
      A623MigrLegSituacionRevista = "" ;
      A624MigrLegCondicion = "" ;
      A625MigrLegSiniestrado = "" ;
      A626MigrLegId = "" ;
      A627MigrLegConvenio = "" ;
      A628MigrLegObs = "" ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      A631MigrTieneConyuge = "" ;
      A632MigrCantidadHijos = (short)(0) ;
      A635MigrEncontroOsoSigla = false ;
      A1398MigrTraDiurno = "" ;
      A1399MigrTraNoct = "" ;
      A1400MigrTraIns = "" ;
      A1820MigrEncontroOsoAfip = false ;
      A2189MigrSueldos = "" ;
      A2190MigrPeriodo = GXutil.nullDate() ;
      A695MigrLegModalidadDef = false ;
      A696MigrLegZonaDef = false ;
      A698MigrLegSituacionDef = false ;
      A690MigrLegEstadoCivilDef = false ;
      A692MigrLegFormaPagoDef = false ;
      A693MigrLegTipoCuentaDef = false ;
      A694MigrLegActividadDef = false ;
      A699MigrLegCondicionDef = false ;
      A700MigrLegSiniestradoDef = false ;
      A2197MigrValCadaSave = false ;
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      A2206MigrOtrosDatos = "" ;
      A2216MigrPuesto = "" ;
      A2221MigrLegMarcaCCT = "" ;
      n2221MigrLegMarcaCCT = false ;
      A2222MigrArchSec = (short)(0) ;
      n2222MigrArchSec = false ;
      A2239MigrLegActLabClas = "" ;
      A2240MigrLegPueAfip = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      O634MigrLegOSAfip = A634MigrLegOSAfip ;
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      Z595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      Z597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      Z604MigrLegCategoria = "" ;
      Z605MigrLegArea = "" ;
      Z606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      Z2427MigrLegTipoTarifa = "" ;
      Z607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      Z691MigrLegClaseDef = false ;
      Z610MigrLegBanco = "" ;
      Z611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      Z613MigrLegSindicato = "" ;
      Z614MigrLegObraSocial = "" ;
      Z634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      Z616MigrLegActividad = "" ;
      Z617MigrLegModalidad = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      Z620MigrLegZona = "" ;
      Z621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      Z624MigrLegCondicion = "" ;
      Z625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      Z627MigrLegConvenio = "" ;
      Z631MigrTieneConyuge = "" ;
      Z632MigrCantidadHijos = (short)(0) ;
      Z635MigrEncontroOsoSigla = false ;
      Z1398MigrTraDiurno = "" ;
      Z1399MigrTraNoct = "" ;
      Z1400MigrTraIns = "" ;
      Z1820MigrEncontroOsoAfip = false ;
      Z2190MigrPeriodo = GXutil.nullDate() ;
      Z695MigrLegModalidadDef = false ;
      Z696MigrLegZonaDef = false ;
      Z698MigrLegSituacionDef = false ;
      Z690MigrLegEstadoCivilDef = false ;
      Z692MigrLegFormaPagoDef = false ;
      Z693MigrLegTipoCuentaDef = false ;
      Z694MigrLegActividadDef = false ;
      Z699MigrLegCondicionDef = false ;
      Z700MigrLegSiniestradoDef = false ;
      Z2197MigrValCadaSave = false ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2216MigrPuesto = "" ;
      Z2221MigrLegMarcaCCT = "" ;
      Z2222MigrArchSec = (short)(0) ;
      Z2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
   }

   public void initAll0175( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A87MigrLegNumero = 0 ;
      initializeNonKey0175( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey01262( )
   {
      A2079MigrLegFamParen = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      Z2079MigrLegFamParen = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
   }

   public void initAll01262( )
   {
      A2078MigrLegFamSec = (short)(0) ;
      initializeNonKey01262( ) ;
   }

   public void standaloneModalInsert01262( )
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

   public void VarsToRow75( web.Sdtimportacion_legajo obj75 )
   {
      obj75.setgxTv_Sdtimportacion_legajo_Mode( Gx_mode );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegapellido( A592MigrLegApellido );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegnombre( A593MigrLegNombre );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( A594MigrLegFecNac );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsexo( A595MigrLegSexo );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( A596MigrLegEstadoCivil );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcuil( A597MigrLegCUIL );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad( A598MigrLegDiscapacidad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegdomici( A599MigrLegDomici );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegemail( A600MigrLegEmail );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcodpos( A601MigrLegCodPos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtelefono( A602MigrLegTelefono );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( A603MigrLegFecIngreso );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcategoria( A604MigrLegCategoria );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegarea( A605MigrLegArea );
      obj75.setgxTv_Sdtimportacion_legajo_Migrleglugardepago( A606MigrLegLugarDePago );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodtra( A2415MigrLegModTra );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( A2427MigrLegTipoTarifa );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegclase( A607MigrLegClase );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbasico( A608MigrLegBasico );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegformapago( A609MigrLegFormaPago );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegclasedef( A691MigrLegClaseDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbanco( A610MigrLegBanco );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbansuc( A611MigrLegBanSuc );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen( A612MigrLegBanTipCuen );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsindicato( A613MigrLegSindicato );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( A614MigrLegObraSocial );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegosafip( A634MigrLegOSAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegplanmedico( A615MigrLegPlanMedico );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactividad( A616MigrLegActividad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( A617MigrLegModalidad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecultmod( A618MigrLegFecUltMod );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc( A619MigrLegCuentaBanc );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegzona( A620MigrLegZona );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcbu( A621MigrLegCBU );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegscvo( A622MigrLegSCVO );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista( A623MigrLegSituacionRevista );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcondicion( A624MigrLegCondicion );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado( A625MigrLegSiniestrado );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegid( A626MigrLegId );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegconvenio( A627MigrLegConvenio );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegobs( A628MigrLegObs );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegerrores( A629MigrLegErrores );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegwarnings( A633MigrLegWarnings );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtieneconyuge( A631MigrTieneConyuge );
      obj75.setgxTv_Sdtimportacion_legajo_Migrcantidadhijos( A632MigrCantidadHijos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrencontroososigla( A635MigrEncontroOsoSigla );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtradiurno( A1398MigrTraDiurno );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtranoct( A1399MigrTraNoct );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtrains( A1400MigrTraIns );
      obj75.setgxTv_Sdtimportacion_legajo_Migrencontroosoafip( A1820MigrEncontroOsoAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrsueldos( A2189MigrSueldos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrperiodo( A2190MigrPeriodo );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( A695MigrLegModalidadDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegzonadef( A696MigrLegZonaDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef( A698MigrLegSituacionDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef( A690MigrLegEstadoCivilDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef( A692MigrLegFormaPagoDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef( A693MigrLegTipoCuentaDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactividaddef( A694MigrLegActividadDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef( A699MigrLegCondicionDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef( A700MigrLegSiniestradoDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( A2197MigrValCadaSave );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso( A2205MigrLegFecEgreso );
      obj75.setgxTv_Sdtimportacion_legajo_Migrotrosdatos( A2206MigrOtrosDatos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrpuesto( A2216MigrPuesto );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct( A2221MigrLegMarcaCCT );
      obj75.setgxTv_Sdtimportacion_legajo_Migrarchsec( A2222MigrArchSec );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas( A2239MigrLegActLabClas );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegpueafip( A2240MigrLegPueAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrleghorsem( A2275MigrLegHorSem );
      obj75.setgxTv_Sdtimportacion_legajo_Clicod( A3CliCod );
      obj75.setgxTv_Sdtimportacion_legajo_Empcod( A1EmpCod );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegnumero( A87MigrLegNumero );
      obj75.setgxTv_Sdtimportacion_legajo_Clicod_Z( Z3CliCod );
      obj75.setgxTv_Sdtimportacion_legajo_Empcod_Z( Z1EmpCod );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z( Z87MigrLegNumero );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z( Z592MigrLegApellido );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z( Z593MigrLegNombre );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z( Z594MigrLegFecNac );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z( Z595MigrLegSexo );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z( Z596MigrLegEstadoCivil );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z( Z597MigrLegCUIL );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z( Z598MigrLegDiscapacidad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z( Z599MigrLegDomici );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegemail_Z( Z600MigrLegEmail );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z( Z601MigrLegCodPos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z( Z602MigrLegTelefono );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z( Z603MigrLegFecIngreso );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z( Z604MigrLegCategoria );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegarea_Z( Z605MigrLegArea );
      obj75.setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z( Z606MigrLegLugarDePago );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z( Z2415MigrLegModTra );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z( Z2427MigrLegTipoTarifa );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegclase_Z( Z607MigrLegClase );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z( Z608MigrLegBasico );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z( Z609MigrLegFormaPago );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z( Z691MigrLegClaseDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z( Z610MigrLegBanco );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z( Z611MigrLegBanSuc );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z( Z612MigrLegBanTipCuen );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z( Z613MigrLegSindicato );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z( Z614MigrLegObraSocial );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z( Z634MigrLegOSAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z( Z615MigrLegPlanMedico );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z( Z616MigrLegActividad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z( Z617MigrLegModalidad );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z( Z618MigrLegFecUltMod );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z( Z619MigrLegCuentaBanc );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegzona_Z( Z620MigrLegZona );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z( Z621MigrLegCBU );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z( Z622MigrLegSCVO );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z( Z623MigrLegSituacionRevista );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z( Z624MigrLegCondicion );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z( Z625MigrLegSiniestrado );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegid_Z( Z626MigrLegId );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z( Z627MigrLegConvenio );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z( Z631MigrTieneConyuge );
      obj75.setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z( Z632MigrCantidadHijos );
      obj75.setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z( Z635MigrEncontroOsoSigla );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z( Z1398MigrTraDiurno );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtranoct_Z( Z1399MigrTraNoct );
      obj75.setgxTv_Sdtimportacion_legajo_Migrtrains_Z( Z1400MigrTraIns );
      obj75.setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z( Z1820MigrEncontroOsoAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrperiodo_Z( Z2190MigrPeriodo );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z( Z695MigrLegModalidadDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z( Z696MigrLegZonaDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z( Z698MigrLegSituacionDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z( Z690MigrLegEstadoCivilDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z( Z692MigrLegFormaPagoDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z( Z693MigrLegTipoCuentaDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z( Z694MigrLegActividadDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z( Z699MigrLegCondicionDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z( Z700MigrLegSiniestradoDef );
      obj75.setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z( Z2197MigrValCadaSave );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z( Z2205MigrLegFecEgreso );
      obj75.setgxTv_Sdtimportacion_legajo_Migrpuesto_Z( Z2216MigrPuesto );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z( Z2221MigrLegMarcaCCT );
      obj75.setgxTv_Sdtimportacion_legajo_Migrarchsec_Z( Z2222MigrArchSec );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z( Z2239MigrLegActLabClas );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z( Z2240MigrLegPueAfip );
      obj75.setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z( Z2275MigrLegHorSem );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N( (byte)((byte)((n2221MigrLegMarcaCCT)?1:0)) );
      obj75.setgxTv_Sdtimportacion_legajo_Migrarchsec_N( (byte)((byte)((n2222MigrArchSec)?1:0)) );
      obj75.setgxTv_Sdtimportacion_legajo_Mode( Gx_mode );
   }

   public void KeyVarsToRow75( web.Sdtimportacion_legajo obj75 )
   {
      obj75.setgxTv_Sdtimportacion_legajo_Clicod( A3CliCod );
      obj75.setgxTv_Sdtimportacion_legajo_Empcod( A1EmpCod );
      obj75.setgxTv_Sdtimportacion_legajo_Migrlegnumero( A87MigrLegNumero );
   }

   public void RowToVars75( web.Sdtimportacion_legajo obj75 ,
                            int forceLoad )
   {
      Gx_mode = obj75.getgxTv_Sdtimportacion_legajo_Mode() ;
      A592MigrLegApellido = obj75.getgxTv_Sdtimportacion_legajo_Migrlegapellido() ;
      A593MigrLegNombre = obj75.getgxTv_Sdtimportacion_legajo_Migrlegnombre() ;
      A594MigrLegFecNac = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecnac() ;
      A595MigrLegSexo = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsexo() ;
      A596MigrLegEstadoCivil = obj75.getgxTv_Sdtimportacion_legajo_Migrlegestadocivil() ;
      A597MigrLegCUIL = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcuil() ;
      A598MigrLegDiscapacidad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad() ;
      A599MigrLegDomici = obj75.getgxTv_Sdtimportacion_legajo_Migrlegdomici() ;
      A600MigrLegEmail = obj75.getgxTv_Sdtimportacion_legajo_Migrlegemail() ;
      A601MigrLegCodPos = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcodpos() ;
      A602MigrLegTelefono = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtelefono() ;
      A603MigrLegFecIngreso = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso() ;
      A604MigrLegCategoria = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcategoria() ;
      A605MigrLegArea = obj75.getgxTv_Sdtimportacion_legajo_Migrlegarea() ;
      A606MigrLegLugarDePago = obj75.getgxTv_Sdtimportacion_legajo_Migrleglugardepago() ;
      A2415MigrLegModTra = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodtra() ;
      A2427MigrLegTipoTarifa = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa() ;
      A607MigrLegClase = obj75.getgxTv_Sdtimportacion_legajo_Migrlegclase() ;
      A608MigrLegBasico = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbasico() ;
      A609MigrLegFormaPago = obj75.getgxTv_Sdtimportacion_legajo_Migrlegformapago() ;
      A691MigrLegClaseDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegclasedef() ;
      A610MigrLegBanco = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbanco() ;
      A611MigrLegBanSuc = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbansuc() ;
      A612MigrLegBanTipCuen = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen() ;
      A613MigrLegSindicato = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsindicato() ;
      A614MigrLegObraSocial = obj75.getgxTv_Sdtimportacion_legajo_Migrlegobrasocial() ;
      if ( ! ( ( GXutil.strcmp(obj75.getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z(), "") != 0 ) ) || ( forceLoad == 1 ) )
      {
         A634MigrLegOSAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrlegosafip() ;
      }
      A615MigrLegPlanMedico = obj75.getgxTv_Sdtimportacion_legajo_Migrlegplanmedico() ;
      A616MigrLegActividad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactividad() ;
      A617MigrLegModalidad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodalidad() ;
      A618MigrLegFecUltMod = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecultmod() ;
      A619MigrLegCuentaBanc = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc() ;
      A620MigrLegZona = obj75.getgxTv_Sdtimportacion_legajo_Migrlegzona() ;
      A621MigrLegCBU = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcbu() ;
      A622MigrLegSCVO = obj75.getgxTv_Sdtimportacion_legajo_Migrlegscvo() ;
      A623MigrLegSituacionRevista = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista() ;
      A624MigrLegCondicion = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcondicion() ;
      A625MigrLegSiniestrado = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado() ;
      A626MigrLegId = obj75.getgxTv_Sdtimportacion_legajo_Migrlegid() ;
      A627MigrLegConvenio = obj75.getgxTv_Sdtimportacion_legajo_Migrlegconvenio() ;
      A628MigrLegObs = obj75.getgxTv_Sdtimportacion_legajo_Migrlegobs() ;
      A629MigrLegErrores = obj75.getgxTv_Sdtimportacion_legajo_Migrlegerrores() ;
      A633MigrLegWarnings = obj75.getgxTv_Sdtimportacion_legajo_Migrlegwarnings() ;
      A631MigrTieneConyuge = obj75.getgxTv_Sdtimportacion_legajo_Migrtieneconyuge() ;
      A632MigrCantidadHijos = obj75.getgxTv_Sdtimportacion_legajo_Migrcantidadhijos() ;
      A635MigrEncontroOsoSigla = obj75.getgxTv_Sdtimportacion_legajo_Migrencontroososigla() ;
      A1398MigrTraDiurno = obj75.getgxTv_Sdtimportacion_legajo_Migrtradiurno() ;
      A1399MigrTraNoct = obj75.getgxTv_Sdtimportacion_legajo_Migrtranoct() ;
      A1400MigrTraIns = obj75.getgxTv_Sdtimportacion_legajo_Migrtrains() ;
      A1820MigrEncontroOsoAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrencontroosoafip() ;
      A2189MigrSueldos = obj75.getgxTv_Sdtimportacion_legajo_Migrsueldos() ;
      A2190MigrPeriodo = obj75.getgxTv_Sdtimportacion_legajo_Migrperiodo() ;
      A695MigrLegModalidadDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef() ;
      A696MigrLegZonaDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegzonadef() ;
      A698MigrLegSituacionDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef() ;
      A690MigrLegEstadoCivilDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef() ;
      A692MigrLegFormaPagoDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegformapagodef() ;
      A693MigrLegTipoCuentaDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef() ;
      A694MigrLegActividadDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactividaddef() ;
      A699MigrLegCondicionDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef() ;
      A700MigrLegSiniestradoDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef() ;
      A2197MigrValCadaSave = obj75.getgxTv_Sdtimportacion_legajo_Migrvalcadasave() ;
      A2205MigrLegFecEgreso = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecegreso() ;
      A2206MigrOtrosDatos = obj75.getgxTv_Sdtimportacion_legajo_Migrotrosdatos() ;
      A2216MigrPuesto = obj75.getgxTv_Sdtimportacion_legajo_Migrpuesto() ;
      A2221MigrLegMarcaCCT = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct() ;
      n2221MigrLegMarcaCCT = false ;
      A2222MigrArchSec = obj75.getgxTv_Sdtimportacion_legajo_Migrarchsec() ;
      n2222MigrArchSec = false ;
      A2239MigrLegActLabClas = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactlabclas() ;
      A2240MigrLegPueAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrlegpueafip() ;
      A2275MigrLegHorSem = obj75.getgxTv_Sdtimportacion_legajo_Migrleghorsem() ;
      A3CliCod = obj75.getgxTv_Sdtimportacion_legajo_Clicod() ;
      A1EmpCod = obj75.getgxTv_Sdtimportacion_legajo_Empcod() ;
      A87MigrLegNumero = obj75.getgxTv_Sdtimportacion_legajo_Migrlegnumero() ;
      Z3CliCod = obj75.getgxTv_Sdtimportacion_legajo_Clicod_Z() ;
      Z1EmpCod = obj75.getgxTv_Sdtimportacion_legajo_Empcod_Z() ;
      Z87MigrLegNumero = obj75.getgxTv_Sdtimportacion_legajo_Migrlegnumero_Z() ;
      Z592MigrLegApellido = obj75.getgxTv_Sdtimportacion_legajo_Migrlegapellido_Z() ;
      Z593MigrLegNombre = obj75.getgxTv_Sdtimportacion_legajo_Migrlegnombre_Z() ;
      Z594MigrLegFecNac = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z() ;
      Z595MigrLegSexo = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsexo_Z() ;
      Z596MigrLegEstadoCivil = obj75.getgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z() ;
      Z597MigrLegCUIL = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcuil_Z() ;
      Z598MigrLegDiscapacidad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z() ;
      Z599MigrLegDomici = obj75.getgxTv_Sdtimportacion_legajo_Migrlegdomici_Z() ;
      Z600MigrLegEmail = obj75.getgxTv_Sdtimportacion_legajo_Migrlegemail_Z() ;
      Z601MigrLegCodPos = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z() ;
      Z602MigrLegTelefono = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z() ;
      Z603MigrLegFecIngreso = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z() ;
      Z604MigrLegCategoria = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z() ;
      Z605MigrLegArea = obj75.getgxTv_Sdtimportacion_legajo_Migrlegarea_Z() ;
      Z606MigrLegLugarDePago = obj75.getgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z() ;
      Z2415MigrLegModTra = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z() ;
      Z2427MigrLegTipoTarifa = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z() ;
      Z607MigrLegClase = obj75.getgxTv_Sdtimportacion_legajo_Migrlegclase_Z() ;
      Z608MigrLegBasico = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbasico_Z() ;
      Z609MigrLegFormaPago = obj75.getgxTv_Sdtimportacion_legajo_Migrlegformapago_Z() ;
      Z691MigrLegClaseDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z() ;
      Z610MigrLegBanco = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbanco_Z() ;
      Z611MigrLegBanSuc = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z() ;
      Z612MigrLegBanTipCuen = obj75.getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z() ;
      Z613MigrLegSindicato = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z() ;
      Z614MigrLegObraSocial = obj75.getgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z() ;
      Z634MigrLegOSAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z() ;
      O634MigrLegOSAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z() ;
      Z615MigrLegPlanMedico = obj75.getgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z() ;
      Z616MigrLegActividad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactividad_Z() ;
      Z617MigrLegModalidad = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z() ;
      Z618MigrLegFecUltMod = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z() ;
      Z619MigrLegCuentaBanc = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z() ;
      Z620MigrLegZona = obj75.getgxTv_Sdtimportacion_legajo_Migrlegzona_Z() ;
      Z621MigrLegCBU = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcbu_Z() ;
      Z622MigrLegSCVO = obj75.getgxTv_Sdtimportacion_legajo_Migrlegscvo_Z() ;
      Z623MigrLegSituacionRevista = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z() ;
      Z624MigrLegCondicion = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z() ;
      Z625MigrLegSiniestrado = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z() ;
      Z626MigrLegId = obj75.getgxTv_Sdtimportacion_legajo_Migrlegid_Z() ;
      Z627MigrLegConvenio = obj75.getgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z() ;
      Z631MigrTieneConyuge = obj75.getgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z() ;
      Z632MigrCantidadHijos = obj75.getgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z() ;
      Z635MigrEncontroOsoSigla = obj75.getgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z() ;
      Z1398MigrTraDiurno = obj75.getgxTv_Sdtimportacion_legajo_Migrtradiurno_Z() ;
      Z1399MigrTraNoct = obj75.getgxTv_Sdtimportacion_legajo_Migrtranoct_Z() ;
      Z1400MigrTraIns = obj75.getgxTv_Sdtimportacion_legajo_Migrtrains_Z() ;
      Z1820MigrEncontroOsoAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z() ;
      Z2190MigrPeriodo = obj75.getgxTv_Sdtimportacion_legajo_Migrperiodo_Z() ;
      Z695MigrLegModalidadDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z() ;
      Z696MigrLegZonaDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z() ;
      Z698MigrLegSituacionDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z() ;
      Z690MigrLegEstadoCivilDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z() ;
      Z692MigrLegFormaPagoDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z() ;
      Z693MigrLegTipoCuentaDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z() ;
      Z694MigrLegActividadDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z() ;
      Z699MigrLegCondicionDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z() ;
      Z700MigrLegSiniestradoDef = obj75.getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z() ;
      Z2197MigrValCadaSave = obj75.getgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z() ;
      Z2205MigrLegFecEgreso = obj75.getgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z() ;
      Z2216MigrPuesto = obj75.getgxTv_Sdtimportacion_legajo_Migrpuesto_Z() ;
      Z2221MigrLegMarcaCCT = obj75.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z() ;
      Z2222MigrArchSec = obj75.getgxTv_Sdtimportacion_legajo_Migrarchsec_Z() ;
      Z2239MigrLegActLabClas = obj75.getgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z() ;
      Z2240MigrLegPueAfip = obj75.getgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z() ;
      Z2275MigrLegHorSem = obj75.getgxTv_Sdtimportacion_legajo_Migrleghorsem_Z() ;
      n2221MigrLegMarcaCCT = (boolean)((obj75.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N()==0)?false:true) ;
      n2222MigrArchSec = (boolean)((obj75.getgxTv_Sdtimportacion_legajo_Migrarchsec_N()==0)?false:true) ;
      Gx_mode = obj75.getgxTv_Sdtimportacion_legajo_Mode() ;
   }

   public void VarsToRow262( web.Sdtimportacion_legajo_Familia obj262 )
   {
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Mode( Gx_mode );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen( A2079MigrLegFamParen );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc( A2080MigrLegFamNroDoc );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan( A2081MigrLegFamDedGan );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh( A2082MigrLegFamAdh );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap( A2086MigrLegFamDiscap );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape( A2088MigrLegFamNomApe );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac( A2089MigrLegFamFecNac );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec( A2078MigrLegFamSec );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z( Z2078MigrLegFamSec );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z( Z2079MigrLegFamParen );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z( Z2080MigrLegFamNroDoc );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z( Z2081MigrLegFamDedGan );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z( Z2082MigrLegFamAdh );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z( Z2086MigrLegFamDiscap );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z( Z2088MigrLegFamNomApe );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z( Z2089MigrLegFamFecNac );
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Modified( nIsMod_262 );
   }

   public void KeyVarsToRow262( web.Sdtimportacion_legajo_Familia obj262 )
   {
      obj262.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec( A2078MigrLegFamSec );
   }

   public void RowToVars262( web.Sdtimportacion_legajo_Familia obj262 ,
                             int forceLoad )
   {
      Gx_mode = obj262.getgxTv_Sdtimportacion_legajo_Familia_Mode() ;
      A2079MigrLegFamParen = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen() ;
      A2080MigrLegFamNroDoc = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc() ;
      A2081MigrLegFamDedGan = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan() ;
      A2082MigrLegFamAdh = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh() ;
      A2086MigrLegFamDiscap = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap() ;
      A2088MigrLegFamNomApe = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape() ;
      A2089MigrLegFamFecNac = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac() ;
      A2078MigrLegFamSec = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec() ;
      Z2078MigrLegFamSec = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec_Z() ;
      Z2079MigrLegFamParen = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen_Z() ;
      Z2080MigrLegFamNroDoc = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc_Z() ;
      Z2081MigrLegFamDedGan = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan_Z() ;
      Z2082MigrLegFamAdh = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh_Z() ;
      Z2086MigrLegFamDiscap = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap_Z() ;
      Z2088MigrLegFamNomApe = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape_Z() ;
      Z2089MigrLegFamFecNac = obj262.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac_Z() ;
      nIsMod_262 = obj262.getgxTv_Sdtimportacion_legajo_Familia_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A87MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0175( ) ;
      scanKeyStart0175( ) ;
      if ( RcdFound75 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000124 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(22) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         O634MigrLegOSAfip = A634MigrLegOSAfip ;
      }
      zm0175( -4) ;
      onLoadActions0175( ) ;
      addRow0175( ) ;
      bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().clearCollection();
      if ( RcdFound75 == 1 )
      {
         scanKeyStart01262( ) ;
         nGXsfl_262_idx = 1 ;
         while ( RcdFound262 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z87MigrLegNumero = A87MigrLegNumero ;
            Z2078MigrLegFamSec = A2078MigrLegFamSec ;
            zm01262( -6) ;
            onLoadActions01262( ) ;
            nRcdExists_262 = (short)(1) ;
            nIsMod_262 = (short)(0) ;
            addRow01262( ) ;
            nGXsfl_262_idx = (int)(nGXsfl_262_idx+1) ;
            scanKeyNext01262( ) ;
         }
         scanKeyEnd01262( ) ;
      }
      scanKeyEnd0175( ) ;
      if ( RcdFound75 == 0 )
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
      RowToVars75( bcimportacion_legajo, 0) ;
      scanKeyStart0175( ) ;
      if ( RcdFound75 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000125 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(23) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         O634MigrLegOSAfip = A634MigrLegOSAfip ;
      }
      zm0175( -4) ;
      onLoadActions0175( ) ;
      addRow0175( ) ;
      bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().clearCollection();
      if ( RcdFound75 == 1 )
      {
         scanKeyStart01262( ) ;
         nGXsfl_262_idx = 1 ;
         while ( RcdFound262 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z87MigrLegNumero = A87MigrLegNumero ;
            Z2078MigrLegFamSec = A2078MigrLegFamSec ;
            zm01262( -6) ;
            onLoadActions01262( ) ;
            nRcdExists_262 = (short)(1) ;
            nIsMod_262 = (short)(0) ;
            addRow01262( ) ;
            nGXsfl_262_idx = (int)(nGXsfl_262_idx+1) ;
            scanKeyNext01262( ) ;
         }
         scanKeyEnd01262( ) ;
      }
      scanKeyEnd0175( ) ;
      if ( RcdFound75 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0175( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0175( ) ;
      }
      else
      {
         if ( RcdFound75 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A87MigrLegNumero = Z87MigrLegNumero ;
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
               update0175( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
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
                     insert0175( ) ;
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
                     insert0175( ) ;
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
      RowToVars75( bcimportacion_legajo, 1) ;
      saveImpl( ) ;
      VarsToRow75( bcimportacion_legajo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars75( bcimportacion_legajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0175( ) ;
      afterTrn( ) ;
      VarsToRow75( bcimportacion_legajo) ;
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
         web.Sdtimportacion_legajo auxBC = new web.Sdtimportacion_legajo( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A87MigrLegNumero);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_legajo);
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
      RowToVars75( bcimportacion_legajo, 1) ;
      updateImpl( ) ;
      VarsToRow75( bcimportacion_legajo) ;
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
      RowToVars75( bcimportacion_legajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0175( ) ;
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
      VarsToRow75( bcimportacion_legajo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars75( bcimportacion_legajo, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0175( ) ;
      if ( RcdFound75 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A87MigrLegNumero = Z87MigrLegNumero ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_legajo_bc");
      VarsToRow75( bcimportacion_legajo) ;
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
      Gx_mode = bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_legajo.setgxTv_Sdtimportacion_legajo_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_legajo sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_legajo )
      {
         bcimportacion_legajo = sdt ;
         if ( GXutil.strcmp(bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Mode(), "") == 0 )
         {
            bcimportacion_legajo.setgxTv_Sdtimportacion_legajo_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow75( bcimportacion_legajo) ;
         }
         else
         {
            RowToVars75( bcimportacion_legajo, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_legajo.getgxTv_Sdtimportacion_legajo_Mode(), "") == 0 )
         {
            bcimportacion_legajo.setgxTv_Sdtimportacion_legajo_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars75( bcimportacion_legajo, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_legajo getimportacion_legajo_BC( )
   {
      return bcimportacion_legajo ;
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
      sMode75 = "" ;
      AV56WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV69Pgmname = "" ;
      AV54TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV55WebSession = httpContext.getWebSession();
      AV67errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar4 = new GXSimpleCollection[1] ;
      AV68warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar5 = new GXSimpleCollection[1] ;
      Z592MigrLegApellido = "" ;
      A592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      A593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      Z595MigrLegSexo = "" ;
      A595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      A596MigrLegEstadoCivil = "" ;
      Z597MigrLegCUIL = "" ;
      A597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      A598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      A599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      A600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      A601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      A602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      Z604MigrLegCategoria = "" ;
      A604MigrLegCategoria = "" ;
      Z605MigrLegArea = "" ;
      A605MigrLegArea = "" ;
      Z606MigrLegLugarDePago = "" ;
      A606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      A2415MigrLegModTra = "" ;
      Z2427MigrLegTipoTarifa = "" ;
      A2427MigrLegTipoTarifa = "" ;
      Z607MigrLegClase = "" ;
      A607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      A609MigrLegFormaPago = "" ;
      Z610MigrLegBanco = "" ;
      A610MigrLegBanco = "" ;
      Z611MigrLegBanSuc = "" ;
      A611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      A612MigrLegBanTipCuen = "" ;
      Z613MigrLegSindicato = "" ;
      A613MigrLegSindicato = "" ;
      Z614MigrLegObraSocial = "" ;
      A614MigrLegObraSocial = "" ;
      Z634MigrLegOSAfip = "" ;
      A634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      A615MigrLegPlanMedico = "" ;
      Z616MigrLegActividad = "" ;
      A616MigrLegActividad = "" ;
      Z617MigrLegModalidad = "" ;
      A617MigrLegModalidad = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      A619MigrLegCuentaBanc = "" ;
      Z620MigrLegZona = "" ;
      A620MigrLegZona = "" ;
      Z621MigrLegCBU = "" ;
      A621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      A622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      A623MigrLegSituacionRevista = "" ;
      Z624MigrLegCondicion = "" ;
      A624MigrLegCondicion = "" ;
      Z625MigrLegSiniestrado = "" ;
      A625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      A626MigrLegId = "" ;
      Z627MigrLegConvenio = "" ;
      A627MigrLegConvenio = "" ;
      Z631MigrTieneConyuge = "" ;
      A631MigrTieneConyuge = "" ;
      Z1398MigrTraDiurno = "" ;
      A1398MigrTraDiurno = "" ;
      Z1399MigrTraNoct = "" ;
      A1399MigrTraNoct = "" ;
      Z1400MigrTraIns = "" ;
      A1400MigrTraIns = "" ;
      Z2190MigrPeriodo = GXutil.nullDate() ;
      A2190MigrPeriodo = GXutil.nullDate() ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2216MigrPuesto = "" ;
      A2216MigrPuesto = "" ;
      Z2221MigrLegMarcaCCT = "" ;
      A2221MigrLegMarcaCCT = "" ;
      Z2239MigrLegActLabClas = "" ;
      A2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      A2240MigrLegPueAfip = "" ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      Z628MigrLegObs = "" ;
      A628MigrLegObs = "" ;
      Z629MigrLegErrores = "" ;
      A629MigrLegErrores = "" ;
      Z633MigrLegWarnings = "" ;
      A633MigrLegWarnings = "" ;
      Z2189MigrSueldos = "" ;
      A2189MigrSueldos = "" ;
      Z2206MigrOtrosDatos = "" ;
      A2206MigrOtrosDatos = "" ;
      GXv_int7 = new int[1] ;
      GXv_int9 = new short[1] ;
      BC00017_A87MigrLegNumero = new int[1] ;
      BC00017_A592MigrLegApellido = new String[] {""} ;
      BC00017_A593MigrLegNombre = new String[] {""} ;
      BC00017_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC00017_A595MigrLegSexo = new String[] {""} ;
      BC00017_A596MigrLegEstadoCivil = new String[] {""} ;
      BC00017_A597MigrLegCUIL = new String[] {""} ;
      BC00017_A598MigrLegDiscapacidad = new String[] {""} ;
      BC00017_A599MigrLegDomici = new String[] {""} ;
      BC00017_A600MigrLegEmail = new String[] {""} ;
      BC00017_A601MigrLegCodPos = new String[] {""} ;
      BC00017_A602MigrLegTelefono = new String[] {""} ;
      BC00017_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC00017_A604MigrLegCategoria = new String[] {""} ;
      BC00017_A605MigrLegArea = new String[] {""} ;
      BC00017_A606MigrLegLugarDePago = new String[] {""} ;
      BC00017_A2415MigrLegModTra = new String[] {""} ;
      BC00017_A2427MigrLegTipoTarifa = new String[] {""} ;
      BC00017_A607MigrLegClase = new String[] {""} ;
      BC00017_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00017_A609MigrLegFormaPago = new String[] {""} ;
      BC00017_A691MigrLegClaseDef = new boolean[] {false} ;
      BC00017_A610MigrLegBanco = new String[] {""} ;
      BC00017_A611MigrLegBanSuc = new String[] {""} ;
      BC00017_A612MigrLegBanTipCuen = new String[] {""} ;
      BC00017_A613MigrLegSindicato = new String[] {""} ;
      BC00017_A614MigrLegObraSocial = new String[] {""} ;
      BC00017_A634MigrLegOSAfip = new String[] {""} ;
      BC00017_A615MigrLegPlanMedico = new String[] {""} ;
      BC00017_A616MigrLegActividad = new String[] {""} ;
      BC00017_A617MigrLegModalidad = new String[] {""} ;
      BC00017_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC00017_A619MigrLegCuentaBanc = new String[] {""} ;
      BC00017_A620MigrLegZona = new String[] {""} ;
      BC00017_A621MigrLegCBU = new String[] {""} ;
      BC00017_A622MigrLegSCVO = new String[] {""} ;
      BC00017_A623MigrLegSituacionRevista = new String[] {""} ;
      BC00017_A624MigrLegCondicion = new String[] {""} ;
      BC00017_A625MigrLegSiniestrado = new String[] {""} ;
      BC00017_A626MigrLegId = new String[] {""} ;
      BC00017_A627MigrLegConvenio = new String[] {""} ;
      BC00017_A628MigrLegObs = new String[] {""} ;
      BC00017_A629MigrLegErrores = new String[] {""} ;
      BC00017_A633MigrLegWarnings = new String[] {""} ;
      BC00017_A631MigrTieneConyuge = new String[] {""} ;
      BC00017_A632MigrCantidadHijos = new short[1] ;
      BC00017_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      BC00017_A1398MigrTraDiurno = new String[] {""} ;
      BC00017_A1399MigrTraNoct = new String[] {""} ;
      BC00017_A1400MigrTraIns = new String[] {""} ;
      BC00017_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      BC00017_A2189MigrSueldos = new String[] {""} ;
      BC00017_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC00017_A695MigrLegModalidadDef = new boolean[] {false} ;
      BC00017_A696MigrLegZonaDef = new boolean[] {false} ;
      BC00017_A698MigrLegSituacionDef = new boolean[] {false} ;
      BC00017_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      BC00017_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      BC00017_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      BC00017_A694MigrLegActividadDef = new boolean[] {false} ;
      BC00017_A699MigrLegCondicionDef = new boolean[] {false} ;
      BC00017_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      BC00017_A2197MigrValCadaSave = new boolean[] {false} ;
      BC00017_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC00017_A2206MigrOtrosDatos = new String[] {""} ;
      BC00017_A2216MigrPuesto = new String[] {""} ;
      BC00017_A2221MigrLegMarcaCCT = new String[] {""} ;
      BC00017_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      BC00017_A2222MigrArchSec = new short[1] ;
      BC00017_n2222MigrArchSec = new boolean[] {false} ;
      BC00017_A2239MigrLegActLabClas = new String[] {""} ;
      BC00017_A2240MigrLegPueAfip = new String[] {""} ;
      BC00017_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00017_A3CliCod = new int[1] ;
      BC00017_A1EmpCod = new short[1] ;
      BC00018_A3CliCod = new int[1] ;
      BC00019_A3CliCod = new int[1] ;
      BC00019_A1EmpCod = new short[1] ;
      BC00019_A87MigrLegNumero = new int[1] ;
      BC000110_A87MigrLegNumero = new int[1] ;
      BC000110_A592MigrLegApellido = new String[] {""} ;
      BC000110_A593MigrLegNombre = new String[] {""} ;
      BC000110_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000110_A595MigrLegSexo = new String[] {""} ;
      BC000110_A596MigrLegEstadoCivil = new String[] {""} ;
      BC000110_A597MigrLegCUIL = new String[] {""} ;
      BC000110_A598MigrLegDiscapacidad = new String[] {""} ;
      BC000110_A599MigrLegDomici = new String[] {""} ;
      BC000110_A600MigrLegEmail = new String[] {""} ;
      BC000110_A601MigrLegCodPos = new String[] {""} ;
      BC000110_A602MigrLegTelefono = new String[] {""} ;
      BC000110_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000110_A604MigrLegCategoria = new String[] {""} ;
      BC000110_A605MigrLegArea = new String[] {""} ;
      BC000110_A606MigrLegLugarDePago = new String[] {""} ;
      BC000110_A2415MigrLegModTra = new String[] {""} ;
      BC000110_A2427MigrLegTipoTarifa = new String[] {""} ;
      BC000110_A607MigrLegClase = new String[] {""} ;
      BC000110_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000110_A609MigrLegFormaPago = new String[] {""} ;
      BC000110_A691MigrLegClaseDef = new boolean[] {false} ;
      BC000110_A610MigrLegBanco = new String[] {""} ;
      BC000110_A611MigrLegBanSuc = new String[] {""} ;
      BC000110_A612MigrLegBanTipCuen = new String[] {""} ;
      BC000110_A613MigrLegSindicato = new String[] {""} ;
      BC000110_A614MigrLegObraSocial = new String[] {""} ;
      BC000110_A634MigrLegOSAfip = new String[] {""} ;
      BC000110_A615MigrLegPlanMedico = new String[] {""} ;
      BC000110_A616MigrLegActividad = new String[] {""} ;
      BC000110_A617MigrLegModalidad = new String[] {""} ;
      BC000110_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000110_A619MigrLegCuentaBanc = new String[] {""} ;
      BC000110_A620MigrLegZona = new String[] {""} ;
      BC000110_A621MigrLegCBU = new String[] {""} ;
      BC000110_A622MigrLegSCVO = new String[] {""} ;
      BC000110_A623MigrLegSituacionRevista = new String[] {""} ;
      BC000110_A624MigrLegCondicion = new String[] {""} ;
      BC000110_A625MigrLegSiniestrado = new String[] {""} ;
      BC000110_A626MigrLegId = new String[] {""} ;
      BC000110_A627MigrLegConvenio = new String[] {""} ;
      BC000110_A628MigrLegObs = new String[] {""} ;
      BC000110_A629MigrLegErrores = new String[] {""} ;
      BC000110_A633MigrLegWarnings = new String[] {""} ;
      BC000110_A631MigrTieneConyuge = new String[] {""} ;
      BC000110_A632MigrCantidadHijos = new short[1] ;
      BC000110_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      BC000110_A1398MigrTraDiurno = new String[] {""} ;
      BC000110_A1399MigrTraNoct = new String[] {""} ;
      BC000110_A1400MigrTraIns = new String[] {""} ;
      BC000110_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      BC000110_A2189MigrSueldos = new String[] {""} ;
      BC000110_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000110_A695MigrLegModalidadDef = new boolean[] {false} ;
      BC000110_A696MigrLegZonaDef = new boolean[] {false} ;
      BC000110_A698MigrLegSituacionDef = new boolean[] {false} ;
      BC000110_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      BC000110_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      BC000110_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      BC000110_A694MigrLegActividadDef = new boolean[] {false} ;
      BC000110_A699MigrLegCondicionDef = new boolean[] {false} ;
      BC000110_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      BC000110_A2197MigrValCadaSave = new boolean[] {false} ;
      BC000110_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000110_A2206MigrOtrosDatos = new String[] {""} ;
      BC000110_A2216MigrPuesto = new String[] {""} ;
      BC000110_A2221MigrLegMarcaCCT = new String[] {""} ;
      BC000110_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      BC000110_A2222MigrArchSec = new short[1] ;
      BC000110_n2222MigrArchSec = new boolean[] {false} ;
      BC000110_A2239MigrLegActLabClas = new String[] {""} ;
      BC000110_A2240MigrLegPueAfip = new String[] {""} ;
      BC000110_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000110_A3CliCod = new int[1] ;
      BC000110_A1EmpCod = new short[1] ;
      O634MigrLegOSAfip = "" ;
      BC000111_A87MigrLegNumero = new int[1] ;
      BC000111_A592MigrLegApellido = new String[] {""} ;
      BC000111_A593MigrLegNombre = new String[] {""} ;
      BC000111_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000111_A595MigrLegSexo = new String[] {""} ;
      BC000111_A596MigrLegEstadoCivil = new String[] {""} ;
      BC000111_A597MigrLegCUIL = new String[] {""} ;
      BC000111_A598MigrLegDiscapacidad = new String[] {""} ;
      BC000111_A599MigrLegDomici = new String[] {""} ;
      BC000111_A600MigrLegEmail = new String[] {""} ;
      BC000111_A601MigrLegCodPos = new String[] {""} ;
      BC000111_A602MigrLegTelefono = new String[] {""} ;
      BC000111_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000111_A604MigrLegCategoria = new String[] {""} ;
      BC000111_A605MigrLegArea = new String[] {""} ;
      BC000111_A606MigrLegLugarDePago = new String[] {""} ;
      BC000111_A2415MigrLegModTra = new String[] {""} ;
      BC000111_A2427MigrLegTipoTarifa = new String[] {""} ;
      BC000111_A607MigrLegClase = new String[] {""} ;
      BC000111_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000111_A609MigrLegFormaPago = new String[] {""} ;
      BC000111_A691MigrLegClaseDef = new boolean[] {false} ;
      BC000111_A610MigrLegBanco = new String[] {""} ;
      BC000111_A611MigrLegBanSuc = new String[] {""} ;
      BC000111_A612MigrLegBanTipCuen = new String[] {""} ;
      BC000111_A613MigrLegSindicato = new String[] {""} ;
      BC000111_A614MigrLegObraSocial = new String[] {""} ;
      BC000111_A634MigrLegOSAfip = new String[] {""} ;
      BC000111_A615MigrLegPlanMedico = new String[] {""} ;
      BC000111_A616MigrLegActividad = new String[] {""} ;
      BC000111_A617MigrLegModalidad = new String[] {""} ;
      BC000111_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000111_A619MigrLegCuentaBanc = new String[] {""} ;
      BC000111_A620MigrLegZona = new String[] {""} ;
      BC000111_A621MigrLegCBU = new String[] {""} ;
      BC000111_A622MigrLegSCVO = new String[] {""} ;
      BC000111_A623MigrLegSituacionRevista = new String[] {""} ;
      BC000111_A624MigrLegCondicion = new String[] {""} ;
      BC000111_A625MigrLegSiniestrado = new String[] {""} ;
      BC000111_A626MigrLegId = new String[] {""} ;
      BC000111_A627MigrLegConvenio = new String[] {""} ;
      BC000111_A628MigrLegObs = new String[] {""} ;
      BC000111_A629MigrLegErrores = new String[] {""} ;
      BC000111_A633MigrLegWarnings = new String[] {""} ;
      BC000111_A631MigrTieneConyuge = new String[] {""} ;
      BC000111_A632MigrCantidadHijos = new short[1] ;
      BC000111_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      BC000111_A1398MigrTraDiurno = new String[] {""} ;
      BC000111_A1399MigrTraNoct = new String[] {""} ;
      BC000111_A1400MigrTraIns = new String[] {""} ;
      BC000111_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      BC000111_A2189MigrSueldos = new String[] {""} ;
      BC000111_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000111_A695MigrLegModalidadDef = new boolean[] {false} ;
      BC000111_A696MigrLegZonaDef = new boolean[] {false} ;
      BC000111_A698MigrLegSituacionDef = new boolean[] {false} ;
      BC000111_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      BC000111_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      BC000111_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      BC000111_A694MigrLegActividadDef = new boolean[] {false} ;
      BC000111_A699MigrLegCondicionDef = new boolean[] {false} ;
      BC000111_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      BC000111_A2197MigrValCadaSave = new boolean[] {false} ;
      BC000111_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000111_A2206MigrOtrosDatos = new String[] {""} ;
      BC000111_A2216MigrPuesto = new String[] {""} ;
      BC000111_A2221MigrLegMarcaCCT = new String[] {""} ;
      BC000111_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      BC000111_A2222MigrArchSec = new short[1] ;
      BC000111_n2222MigrArchSec = new boolean[] {false} ;
      BC000111_A2239MigrLegActLabClas = new String[] {""} ;
      BC000111_A2240MigrLegPueAfip = new String[] {""} ;
      BC000111_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000111_A3CliCod = new int[1] ;
      BC000111_A1EmpCod = new short[1] ;
      BC000115_A87MigrLegNumero = new int[1] ;
      BC000115_A592MigrLegApellido = new String[] {""} ;
      BC000115_A593MigrLegNombre = new String[] {""} ;
      BC000115_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000115_A595MigrLegSexo = new String[] {""} ;
      BC000115_A596MigrLegEstadoCivil = new String[] {""} ;
      BC000115_A597MigrLegCUIL = new String[] {""} ;
      BC000115_A598MigrLegDiscapacidad = new String[] {""} ;
      BC000115_A599MigrLegDomici = new String[] {""} ;
      BC000115_A600MigrLegEmail = new String[] {""} ;
      BC000115_A601MigrLegCodPos = new String[] {""} ;
      BC000115_A602MigrLegTelefono = new String[] {""} ;
      BC000115_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000115_A604MigrLegCategoria = new String[] {""} ;
      BC000115_A605MigrLegArea = new String[] {""} ;
      BC000115_A606MigrLegLugarDePago = new String[] {""} ;
      BC000115_A2415MigrLegModTra = new String[] {""} ;
      BC000115_A2427MigrLegTipoTarifa = new String[] {""} ;
      BC000115_A607MigrLegClase = new String[] {""} ;
      BC000115_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000115_A609MigrLegFormaPago = new String[] {""} ;
      BC000115_A691MigrLegClaseDef = new boolean[] {false} ;
      BC000115_A610MigrLegBanco = new String[] {""} ;
      BC000115_A611MigrLegBanSuc = new String[] {""} ;
      BC000115_A612MigrLegBanTipCuen = new String[] {""} ;
      BC000115_A613MigrLegSindicato = new String[] {""} ;
      BC000115_A614MigrLegObraSocial = new String[] {""} ;
      BC000115_A634MigrLegOSAfip = new String[] {""} ;
      BC000115_A615MigrLegPlanMedico = new String[] {""} ;
      BC000115_A616MigrLegActividad = new String[] {""} ;
      BC000115_A617MigrLegModalidad = new String[] {""} ;
      BC000115_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000115_A619MigrLegCuentaBanc = new String[] {""} ;
      BC000115_A620MigrLegZona = new String[] {""} ;
      BC000115_A621MigrLegCBU = new String[] {""} ;
      BC000115_A622MigrLegSCVO = new String[] {""} ;
      BC000115_A623MigrLegSituacionRevista = new String[] {""} ;
      BC000115_A624MigrLegCondicion = new String[] {""} ;
      BC000115_A625MigrLegSiniestrado = new String[] {""} ;
      BC000115_A626MigrLegId = new String[] {""} ;
      BC000115_A627MigrLegConvenio = new String[] {""} ;
      BC000115_A628MigrLegObs = new String[] {""} ;
      BC000115_A629MigrLegErrores = new String[] {""} ;
      BC000115_A633MigrLegWarnings = new String[] {""} ;
      BC000115_A631MigrTieneConyuge = new String[] {""} ;
      BC000115_A632MigrCantidadHijos = new short[1] ;
      BC000115_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      BC000115_A1398MigrTraDiurno = new String[] {""} ;
      BC000115_A1399MigrTraNoct = new String[] {""} ;
      BC000115_A1400MigrTraIns = new String[] {""} ;
      BC000115_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      BC000115_A2189MigrSueldos = new String[] {""} ;
      BC000115_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000115_A695MigrLegModalidadDef = new boolean[] {false} ;
      BC000115_A696MigrLegZonaDef = new boolean[] {false} ;
      BC000115_A698MigrLegSituacionDef = new boolean[] {false} ;
      BC000115_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      BC000115_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      BC000115_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      BC000115_A694MigrLegActividadDef = new boolean[] {false} ;
      BC000115_A699MigrLegCondicionDef = new boolean[] {false} ;
      BC000115_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      BC000115_A2197MigrValCadaSave = new boolean[] {false} ;
      BC000115_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000115_A2206MigrOtrosDatos = new String[] {""} ;
      BC000115_A2216MigrPuesto = new String[] {""} ;
      BC000115_A2221MigrLegMarcaCCT = new String[] {""} ;
      BC000115_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      BC000115_A2222MigrArchSec = new short[1] ;
      BC000115_n2222MigrArchSec = new boolean[] {false} ;
      BC000115_A2239MigrLegActLabClas = new String[] {""} ;
      BC000115_A2240MigrLegPueAfip = new String[] {""} ;
      BC000115_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000115_A3CliCod = new int[1] ;
      BC000115_A1EmpCod = new short[1] ;
      Z2079MigrLegFamParen = "" ;
      A2079MigrLegFamParen = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      A2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      A2082MigrLegFamAdh = "" ;
      Z2086MigrLegFamDiscap = "" ;
      A2086MigrLegFamDiscap = "" ;
      Z2088MigrLegFamNomApe = "" ;
      A2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      BC000116_A1EmpCod = new short[1] ;
      BC000116_A87MigrLegNumero = new int[1] ;
      BC000116_A2078MigrLegFamSec = new short[1] ;
      BC000116_A2079MigrLegFamParen = new String[] {""} ;
      BC000116_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC000116_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000116_A2082MigrLegFamAdh = new String[] {""} ;
      BC000116_A2086MigrLegFamDiscap = new String[] {""} ;
      BC000116_A2088MigrLegFamNomApe = new String[] {""} ;
      BC000116_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000116_A3CliCod = new int[1] ;
      BC000117_A3CliCod = new int[1] ;
      BC000117_A1EmpCod = new short[1] ;
      BC000117_A87MigrLegNumero = new int[1] ;
      BC000117_A2078MigrLegFamSec = new short[1] ;
      BC000118_A1EmpCod = new short[1] ;
      BC000118_A87MigrLegNumero = new int[1] ;
      BC000118_A2078MigrLegFamSec = new short[1] ;
      BC000118_A2079MigrLegFamParen = new String[] {""} ;
      BC000118_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC000118_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000118_A2082MigrLegFamAdh = new String[] {""} ;
      BC000118_A2086MigrLegFamDiscap = new String[] {""} ;
      BC000118_A2088MigrLegFamNomApe = new String[] {""} ;
      BC000118_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000118_A3CliCod = new int[1] ;
      sMode262 = "" ;
      BC000119_A1EmpCod = new short[1] ;
      BC000119_A87MigrLegNumero = new int[1] ;
      BC000119_A2078MigrLegFamSec = new short[1] ;
      BC000119_A2079MigrLegFamParen = new String[] {""} ;
      BC000119_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC000119_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000119_A2082MigrLegFamAdh = new String[] {""} ;
      BC000119_A2086MigrLegFamDiscap = new String[] {""} ;
      BC000119_A2088MigrLegFamNomApe = new String[] {""} ;
      BC000119_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000119_A3CliCod = new int[1] ;
      BC000123_A1EmpCod = new short[1] ;
      BC000123_A87MigrLegNumero = new int[1] ;
      BC000123_A2078MigrLegFamSec = new short[1] ;
      BC000123_A2079MigrLegFamParen = new String[] {""} ;
      BC000123_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC000123_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000123_A2082MigrLegFamAdh = new String[] {""} ;
      BC000123_A2086MigrLegFamDiscap = new String[] {""} ;
      BC000123_A2088MigrLegFamNomApe = new String[] {""} ;
      BC000123_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000123_A3CliCod = new int[1] ;
      N634MigrLegOSAfip = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000124_A3CliCod = new int[1] ;
      BC000125_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajo_bc__default(),
         new Object[] {
             new Object[] {
            BC00012_A1EmpCod, BC00012_A87MigrLegNumero, BC00012_A2078MigrLegFamSec, BC00012_A2079MigrLegFamParen, BC00012_A2080MigrLegFamNroDoc, BC00012_A2081MigrLegFamDedGan, BC00012_A2082MigrLegFamAdh, BC00012_A2086MigrLegFamDiscap, BC00012_A2088MigrLegFamNomApe, BC00012_A2089MigrLegFamFecNac,
            BC00012_A3CliCod
            }
            , new Object[] {
            BC00013_A1EmpCod, BC00013_A87MigrLegNumero, BC00013_A2078MigrLegFamSec, BC00013_A2079MigrLegFamParen, BC00013_A2080MigrLegFamNroDoc, BC00013_A2081MigrLegFamDedGan, BC00013_A2082MigrLegFamAdh, BC00013_A2086MigrLegFamDiscap, BC00013_A2088MigrLegFamNomApe, BC00013_A2089MigrLegFamFecNac,
            BC00013_A3CliCod
            }
            , new Object[] {
            BC00014_A87MigrLegNumero, BC00014_A592MigrLegApellido, BC00014_A593MigrLegNombre, BC00014_A594MigrLegFecNac, BC00014_A595MigrLegSexo, BC00014_A596MigrLegEstadoCivil, BC00014_A597MigrLegCUIL, BC00014_A598MigrLegDiscapacidad, BC00014_A599MigrLegDomici, BC00014_A600MigrLegEmail,
            BC00014_A601MigrLegCodPos, BC00014_A602MigrLegTelefono, BC00014_A603MigrLegFecIngreso, BC00014_A604MigrLegCategoria, BC00014_A605MigrLegArea, BC00014_A606MigrLegLugarDePago, BC00014_A2415MigrLegModTra, BC00014_A2427MigrLegTipoTarifa, BC00014_A607MigrLegClase, BC00014_A608MigrLegBasico,
            BC00014_A609MigrLegFormaPago, BC00014_A691MigrLegClaseDef, BC00014_A610MigrLegBanco, BC00014_A611MigrLegBanSuc, BC00014_A612MigrLegBanTipCuen, BC00014_A613MigrLegSindicato, BC00014_A614MigrLegObraSocial, BC00014_A634MigrLegOSAfip, BC00014_A615MigrLegPlanMedico, BC00014_A616MigrLegActividad,
            BC00014_A617MigrLegModalidad, BC00014_A618MigrLegFecUltMod, BC00014_A619MigrLegCuentaBanc, BC00014_A620MigrLegZona, BC00014_A621MigrLegCBU, BC00014_A622MigrLegSCVO, BC00014_A623MigrLegSituacionRevista, BC00014_A624MigrLegCondicion, BC00014_A625MigrLegSiniestrado, BC00014_A626MigrLegId,
            BC00014_A627MigrLegConvenio, BC00014_A628MigrLegObs, BC00014_A629MigrLegErrores, BC00014_A633MigrLegWarnings, BC00014_A631MigrTieneConyuge, BC00014_A632MigrCantidadHijos, BC00014_A635MigrEncontroOsoSigla, BC00014_A1398MigrTraDiurno, BC00014_A1399MigrTraNoct, BC00014_A1400MigrTraIns,
            BC00014_A1820MigrEncontroOsoAfip, BC00014_A2189MigrSueldos, BC00014_A2190MigrPeriodo, BC00014_A695MigrLegModalidadDef, BC00014_A696MigrLegZonaDef, BC00014_A698MigrLegSituacionDef, BC00014_A690MigrLegEstadoCivilDef, BC00014_A692MigrLegFormaPagoDef, BC00014_A693MigrLegTipoCuentaDef, BC00014_A694MigrLegActividadDef,
            BC00014_A699MigrLegCondicionDef, BC00014_A700MigrLegSiniestradoDef, BC00014_A2197MigrValCadaSave, BC00014_A2205MigrLegFecEgreso, BC00014_A2206MigrOtrosDatos, BC00014_A2216MigrPuesto, BC00014_A2221MigrLegMarcaCCT, BC00014_n2221MigrLegMarcaCCT, BC00014_A2222MigrArchSec, BC00014_n2222MigrArchSec,
            BC00014_A2239MigrLegActLabClas, BC00014_A2240MigrLegPueAfip, BC00014_A2275MigrLegHorSem, BC00014_A3CliCod, BC00014_A1EmpCod
            }
            , new Object[] {
            BC00015_A87MigrLegNumero, BC00015_A592MigrLegApellido, BC00015_A593MigrLegNombre, BC00015_A594MigrLegFecNac, BC00015_A595MigrLegSexo, BC00015_A596MigrLegEstadoCivil, BC00015_A597MigrLegCUIL, BC00015_A598MigrLegDiscapacidad, BC00015_A599MigrLegDomici, BC00015_A600MigrLegEmail,
            BC00015_A601MigrLegCodPos, BC00015_A602MigrLegTelefono, BC00015_A603MigrLegFecIngreso, BC00015_A604MigrLegCategoria, BC00015_A605MigrLegArea, BC00015_A606MigrLegLugarDePago, BC00015_A2415MigrLegModTra, BC00015_A2427MigrLegTipoTarifa, BC00015_A607MigrLegClase, BC00015_A608MigrLegBasico,
            BC00015_A609MigrLegFormaPago, BC00015_A691MigrLegClaseDef, BC00015_A610MigrLegBanco, BC00015_A611MigrLegBanSuc, BC00015_A612MigrLegBanTipCuen, BC00015_A613MigrLegSindicato, BC00015_A614MigrLegObraSocial, BC00015_A634MigrLegOSAfip, BC00015_A615MigrLegPlanMedico, BC00015_A616MigrLegActividad,
            BC00015_A617MigrLegModalidad, BC00015_A618MigrLegFecUltMod, BC00015_A619MigrLegCuentaBanc, BC00015_A620MigrLegZona, BC00015_A621MigrLegCBU, BC00015_A622MigrLegSCVO, BC00015_A623MigrLegSituacionRevista, BC00015_A624MigrLegCondicion, BC00015_A625MigrLegSiniestrado, BC00015_A626MigrLegId,
            BC00015_A627MigrLegConvenio, BC00015_A628MigrLegObs, BC00015_A629MigrLegErrores, BC00015_A633MigrLegWarnings, BC00015_A631MigrTieneConyuge, BC00015_A632MigrCantidadHijos, BC00015_A635MigrEncontroOsoSigla, BC00015_A1398MigrTraDiurno, BC00015_A1399MigrTraNoct, BC00015_A1400MigrTraIns,
            BC00015_A1820MigrEncontroOsoAfip, BC00015_A2189MigrSueldos, BC00015_A2190MigrPeriodo, BC00015_A695MigrLegModalidadDef, BC00015_A696MigrLegZonaDef, BC00015_A698MigrLegSituacionDef, BC00015_A690MigrLegEstadoCivilDef, BC00015_A692MigrLegFormaPagoDef, BC00015_A693MigrLegTipoCuentaDef, BC00015_A694MigrLegActividadDef,
            BC00015_A699MigrLegCondicionDef, BC00015_A700MigrLegSiniestradoDef, BC00015_A2197MigrValCadaSave, BC00015_A2205MigrLegFecEgreso, BC00015_A2206MigrOtrosDatos, BC00015_A2216MigrPuesto, BC00015_A2221MigrLegMarcaCCT, BC00015_n2221MigrLegMarcaCCT, BC00015_A2222MigrArchSec, BC00015_n2222MigrArchSec,
            BC00015_A2239MigrLegActLabClas, BC00015_A2240MigrLegPueAfip, BC00015_A2275MigrLegHorSem, BC00015_A3CliCod, BC00015_A1EmpCod
            }
            , new Object[] {
            BC00016_A3CliCod
            }
            , new Object[] {
            BC00017_A87MigrLegNumero, BC00017_A592MigrLegApellido, BC00017_A593MigrLegNombre, BC00017_A594MigrLegFecNac, BC00017_A595MigrLegSexo, BC00017_A596MigrLegEstadoCivil, BC00017_A597MigrLegCUIL, BC00017_A598MigrLegDiscapacidad, BC00017_A599MigrLegDomici, BC00017_A600MigrLegEmail,
            BC00017_A601MigrLegCodPos, BC00017_A602MigrLegTelefono, BC00017_A603MigrLegFecIngreso, BC00017_A604MigrLegCategoria, BC00017_A605MigrLegArea, BC00017_A606MigrLegLugarDePago, BC00017_A2415MigrLegModTra, BC00017_A2427MigrLegTipoTarifa, BC00017_A607MigrLegClase, BC00017_A608MigrLegBasico,
            BC00017_A609MigrLegFormaPago, BC00017_A691MigrLegClaseDef, BC00017_A610MigrLegBanco, BC00017_A611MigrLegBanSuc, BC00017_A612MigrLegBanTipCuen, BC00017_A613MigrLegSindicato, BC00017_A614MigrLegObraSocial, BC00017_A634MigrLegOSAfip, BC00017_A615MigrLegPlanMedico, BC00017_A616MigrLegActividad,
            BC00017_A617MigrLegModalidad, BC00017_A618MigrLegFecUltMod, BC00017_A619MigrLegCuentaBanc, BC00017_A620MigrLegZona, BC00017_A621MigrLegCBU, BC00017_A622MigrLegSCVO, BC00017_A623MigrLegSituacionRevista, BC00017_A624MigrLegCondicion, BC00017_A625MigrLegSiniestrado, BC00017_A626MigrLegId,
            BC00017_A627MigrLegConvenio, BC00017_A628MigrLegObs, BC00017_A629MigrLegErrores, BC00017_A633MigrLegWarnings, BC00017_A631MigrTieneConyuge, BC00017_A632MigrCantidadHijos, BC00017_A635MigrEncontroOsoSigla, BC00017_A1398MigrTraDiurno, BC00017_A1399MigrTraNoct, BC00017_A1400MigrTraIns,
            BC00017_A1820MigrEncontroOsoAfip, BC00017_A2189MigrSueldos, BC00017_A2190MigrPeriodo, BC00017_A695MigrLegModalidadDef, BC00017_A696MigrLegZonaDef, BC00017_A698MigrLegSituacionDef, BC00017_A690MigrLegEstadoCivilDef, BC00017_A692MigrLegFormaPagoDef, BC00017_A693MigrLegTipoCuentaDef, BC00017_A694MigrLegActividadDef,
            BC00017_A699MigrLegCondicionDef, BC00017_A700MigrLegSiniestradoDef, BC00017_A2197MigrValCadaSave, BC00017_A2205MigrLegFecEgreso, BC00017_A2206MigrOtrosDatos, BC00017_A2216MigrPuesto, BC00017_A2221MigrLegMarcaCCT, BC00017_n2221MigrLegMarcaCCT, BC00017_A2222MigrArchSec, BC00017_n2222MigrArchSec,
            BC00017_A2239MigrLegActLabClas, BC00017_A2240MigrLegPueAfip, BC00017_A2275MigrLegHorSem, BC00017_A3CliCod, BC00017_A1EmpCod
            }
            , new Object[] {
            BC00018_A3CliCod
            }
            , new Object[] {
            BC00019_A3CliCod, BC00019_A1EmpCod, BC00019_A87MigrLegNumero
            }
            , new Object[] {
            BC000110_A87MigrLegNumero, BC000110_A592MigrLegApellido, BC000110_A593MigrLegNombre, BC000110_A594MigrLegFecNac, BC000110_A595MigrLegSexo, BC000110_A596MigrLegEstadoCivil, BC000110_A597MigrLegCUIL, BC000110_A598MigrLegDiscapacidad, BC000110_A599MigrLegDomici, BC000110_A600MigrLegEmail,
            BC000110_A601MigrLegCodPos, BC000110_A602MigrLegTelefono, BC000110_A603MigrLegFecIngreso, BC000110_A604MigrLegCategoria, BC000110_A605MigrLegArea, BC000110_A606MigrLegLugarDePago, BC000110_A2415MigrLegModTra, BC000110_A2427MigrLegTipoTarifa, BC000110_A607MigrLegClase, BC000110_A608MigrLegBasico,
            BC000110_A609MigrLegFormaPago, BC000110_A691MigrLegClaseDef, BC000110_A610MigrLegBanco, BC000110_A611MigrLegBanSuc, BC000110_A612MigrLegBanTipCuen, BC000110_A613MigrLegSindicato, BC000110_A614MigrLegObraSocial, BC000110_A634MigrLegOSAfip, BC000110_A615MigrLegPlanMedico, BC000110_A616MigrLegActividad,
            BC000110_A617MigrLegModalidad, BC000110_A618MigrLegFecUltMod, BC000110_A619MigrLegCuentaBanc, BC000110_A620MigrLegZona, BC000110_A621MigrLegCBU, BC000110_A622MigrLegSCVO, BC000110_A623MigrLegSituacionRevista, BC000110_A624MigrLegCondicion, BC000110_A625MigrLegSiniestrado, BC000110_A626MigrLegId,
            BC000110_A627MigrLegConvenio, BC000110_A628MigrLegObs, BC000110_A629MigrLegErrores, BC000110_A633MigrLegWarnings, BC000110_A631MigrTieneConyuge, BC000110_A632MigrCantidadHijos, BC000110_A635MigrEncontroOsoSigla, BC000110_A1398MigrTraDiurno, BC000110_A1399MigrTraNoct, BC000110_A1400MigrTraIns,
            BC000110_A1820MigrEncontroOsoAfip, BC000110_A2189MigrSueldos, BC000110_A2190MigrPeriodo, BC000110_A695MigrLegModalidadDef, BC000110_A696MigrLegZonaDef, BC000110_A698MigrLegSituacionDef, BC000110_A690MigrLegEstadoCivilDef, BC000110_A692MigrLegFormaPagoDef, BC000110_A693MigrLegTipoCuentaDef, BC000110_A694MigrLegActividadDef,
            BC000110_A699MigrLegCondicionDef, BC000110_A700MigrLegSiniestradoDef, BC000110_A2197MigrValCadaSave, BC000110_A2205MigrLegFecEgreso, BC000110_A2206MigrOtrosDatos, BC000110_A2216MigrPuesto, BC000110_A2221MigrLegMarcaCCT, BC000110_n2221MigrLegMarcaCCT, BC000110_A2222MigrArchSec, BC000110_n2222MigrArchSec,
            BC000110_A2239MigrLegActLabClas, BC000110_A2240MigrLegPueAfip, BC000110_A2275MigrLegHorSem, BC000110_A3CliCod, BC000110_A1EmpCod
            }
            , new Object[] {
            BC000111_A87MigrLegNumero, BC000111_A592MigrLegApellido, BC000111_A593MigrLegNombre, BC000111_A594MigrLegFecNac, BC000111_A595MigrLegSexo, BC000111_A596MigrLegEstadoCivil, BC000111_A597MigrLegCUIL, BC000111_A598MigrLegDiscapacidad, BC000111_A599MigrLegDomici, BC000111_A600MigrLegEmail,
            BC000111_A601MigrLegCodPos, BC000111_A602MigrLegTelefono, BC000111_A603MigrLegFecIngreso, BC000111_A604MigrLegCategoria, BC000111_A605MigrLegArea, BC000111_A606MigrLegLugarDePago, BC000111_A2415MigrLegModTra, BC000111_A2427MigrLegTipoTarifa, BC000111_A607MigrLegClase, BC000111_A608MigrLegBasico,
            BC000111_A609MigrLegFormaPago, BC000111_A691MigrLegClaseDef, BC000111_A610MigrLegBanco, BC000111_A611MigrLegBanSuc, BC000111_A612MigrLegBanTipCuen, BC000111_A613MigrLegSindicato, BC000111_A614MigrLegObraSocial, BC000111_A634MigrLegOSAfip, BC000111_A615MigrLegPlanMedico, BC000111_A616MigrLegActividad,
            BC000111_A617MigrLegModalidad, BC000111_A618MigrLegFecUltMod, BC000111_A619MigrLegCuentaBanc, BC000111_A620MigrLegZona, BC000111_A621MigrLegCBU, BC000111_A622MigrLegSCVO, BC000111_A623MigrLegSituacionRevista, BC000111_A624MigrLegCondicion, BC000111_A625MigrLegSiniestrado, BC000111_A626MigrLegId,
            BC000111_A627MigrLegConvenio, BC000111_A628MigrLegObs, BC000111_A629MigrLegErrores, BC000111_A633MigrLegWarnings, BC000111_A631MigrTieneConyuge, BC000111_A632MigrCantidadHijos, BC000111_A635MigrEncontroOsoSigla, BC000111_A1398MigrTraDiurno, BC000111_A1399MigrTraNoct, BC000111_A1400MigrTraIns,
            BC000111_A1820MigrEncontroOsoAfip, BC000111_A2189MigrSueldos, BC000111_A2190MigrPeriodo, BC000111_A695MigrLegModalidadDef, BC000111_A696MigrLegZonaDef, BC000111_A698MigrLegSituacionDef, BC000111_A690MigrLegEstadoCivilDef, BC000111_A692MigrLegFormaPagoDef, BC000111_A693MigrLegTipoCuentaDef, BC000111_A694MigrLegActividadDef,
            BC000111_A699MigrLegCondicionDef, BC000111_A700MigrLegSiniestradoDef, BC000111_A2197MigrValCadaSave, BC000111_A2205MigrLegFecEgreso, BC000111_A2206MigrOtrosDatos, BC000111_A2216MigrPuesto, BC000111_A2221MigrLegMarcaCCT, BC000111_n2221MigrLegMarcaCCT, BC000111_A2222MigrArchSec, BC000111_n2222MigrArchSec,
            BC000111_A2239MigrLegActLabClas, BC000111_A2240MigrLegPueAfip, BC000111_A2275MigrLegHorSem, BC000111_A3CliCod, BC000111_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000115_A87MigrLegNumero, BC000115_A592MigrLegApellido, BC000115_A593MigrLegNombre, BC000115_A594MigrLegFecNac, BC000115_A595MigrLegSexo, BC000115_A596MigrLegEstadoCivil, BC000115_A597MigrLegCUIL, BC000115_A598MigrLegDiscapacidad, BC000115_A599MigrLegDomici, BC000115_A600MigrLegEmail,
            BC000115_A601MigrLegCodPos, BC000115_A602MigrLegTelefono, BC000115_A603MigrLegFecIngreso, BC000115_A604MigrLegCategoria, BC000115_A605MigrLegArea, BC000115_A606MigrLegLugarDePago, BC000115_A2415MigrLegModTra, BC000115_A2427MigrLegTipoTarifa, BC000115_A607MigrLegClase, BC000115_A608MigrLegBasico,
            BC000115_A609MigrLegFormaPago, BC000115_A691MigrLegClaseDef, BC000115_A610MigrLegBanco, BC000115_A611MigrLegBanSuc, BC000115_A612MigrLegBanTipCuen, BC000115_A613MigrLegSindicato, BC000115_A614MigrLegObraSocial, BC000115_A634MigrLegOSAfip, BC000115_A615MigrLegPlanMedico, BC000115_A616MigrLegActividad,
            BC000115_A617MigrLegModalidad, BC000115_A618MigrLegFecUltMod, BC000115_A619MigrLegCuentaBanc, BC000115_A620MigrLegZona, BC000115_A621MigrLegCBU, BC000115_A622MigrLegSCVO, BC000115_A623MigrLegSituacionRevista, BC000115_A624MigrLegCondicion, BC000115_A625MigrLegSiniestrado, BC000115_A626MigrLegId,
            BC000115_A627MigrLegConvenio, BC000115_A628MigrLegObs, BC000115_A629MigrLegErrores, BC000115_A633MigrLegWarnings, BC000115_A631MigrTieneConyuge, BC000115_A632MigrCantidadHijos, BC000115_A635MigrEncontroOsoSigla, BC000115_A1398MigrTraDiurno, BC000115_A1399MigrTraNoct, BC000115_A1400MigrTraIns,
            BC000115_A1820MigrEncontroOsoAfip, BC000115_A2189MigrSueldos, BC000115_A2190MigrPeriodo, BC000115_A695MigrLegModalidadDef, BC000115_A696MigrLegZonaDef, BC000115_A698MigrLegSituacionDef, BC000115_A690MigrLegEstadoCivilDef, BC000115_A692MigrLegFormaPagoDef, BC000115_A693MigrLegTipoCuentaDef, BC000115_A694MigrLegActividadDef,
            BC000115_A699MigrLegCondicionDef, BC000115_A700MigrLegSiniestradoDef, BC000115_A2197MigrValCadaSave, BC000115_A2205MigrLegFecEgreso, BC000115_A2206MigrOtrosDatos, BC000115_A2216MigrPuesto, BC000115_A2221MigrLegMarcaCCT, BC000115_n2221MigrLegMarcaCCT, BC000115_A2222MigrArchSec, BC000115_n2222MigrArchSec,
            BC000115_A2239MigrLegActLabClas, BC000115_A2240MigrLegPueAfip, BC000115_A2275MigrLegHorSem, BC000115_A3CliCod, BC000115_A1EmpCod
            }
            , new Object[] {
            BC000116_A1EmpCod, BC000116_A87MigrLegNumero, BC000116_A2078MigrLegFamSec, BC000116_A2079MigrLegFamParen, BC000116_A2080MigrLegFamNroDoc, BC000116_A2081MigrLegFamDedGan, BC000116_A2082MigrLegFamAdh, BC000116_A2086MigrLegFamDiscap, BC000116_A2088MigrLegFamNomApe, BC000116_A2089MigrLegFamFecNac,
            BC000116_A3CliCod
            }
            , new Object[] {
            BC000117_A3CliCod, BC000117_A1EmpCod, BC000117_A87MigrLegNumero, BC000117_A2078MigrLegFamSec
            }
            , new Object[] {
            BC000118_A1EmpCod, BC000118_A87MigrLegNumero, BC000118_A2078MigrLegFamSec, BC000118_A2079MigrLegFamParen, BC000118_A2080MigrLegFamNroDoc, BC000118_A2081MigrLegFamDedGan, BC000118_A2082MigrLegFamAdh, BC000118_A2086MigrLegFamDiscap, BC000118_A2088MigrLegFamNomApe, BC000118_A2089MigrLegFamFecNac,
            BC000118_A3CliCod
            }
            , new Object[] {
            BC000119_A1EmpCod, BC000119_A87MigrLegNumero, BC000119_A2078MigrLegFamSec, BC000119_A2079MigrLegFamParen, BC000119_A2080MigrLegFamNroDoc, BC000119_A2081MigrLegFamDedGan, BC000119_A2082MigrLegFamAdh, BC000119_A2086MigrLegFamDiscap, BC000119_A2088MigrLegFamNomApe, BC000119_A2089MigrLegFamFecNac,
            BC000119_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000123_A1EmpCod, BC000123_A87MigrLegNumero, BC000123_A2078MigrLegFamSec, BC000123_A2079MigrLegFamParen, BC000123_A2080MigrLegFamNroDoc, BC000123_A2081MigrLegFamDedGan, BC000123_A2082MigrLegFamAdh, BC000123_A2086MigrLegFamDiscap, BC000123_A2088MigrLegFamNomApe, BC000123_A2089MigrLegFamFecNac,
            BC000123_A3CliCod
            }
            , new Object[] {
            BC000124_A3CliCod
            }
            , new Object[] {
            BC000125_A3CliCod
            }
         }
      );
      AV69Pgmname = "importacion_legajo_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12012 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove262 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short nIsMod_262 ;
   private short RcdFound262 ;
   private short Z632MigrCantidadHijos ;
   private short A632MigrCantidadHijos ;
   private short Z2222MigrArchSec ;
   private short A2222MigrArchSec ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short RcdFound75 ;
   private short nIsDirty_75 ;
   private short nRcdExists_262 ;
   private short Z2078MigrLegFamSec ;
   private short A2078MigrLegFamSec ;
   private short nIsDirty_262 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z87MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int nGXsfl_262_idx=1 ;
   private int GX_JID ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private java.math.BigDecimal Z608MigrLegBasico ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal Z2275MigrLegHorSem ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
   private java.math.BigDecimal Z2081MigrLegFamDedGan ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode75 ;
   private String AV69Pgmname ;
   private String Z595MigrLegSexo ;
   private String A595MigrLegSexo ;
   private String Z597MigrLegCUIL ;
   private String A597MigrLegCUIL ;
   private String Z598MigrLegDiscapacidad ;
   private String A598MigrLegDiscapacidad ;
   private String Z634MigrLegOSAfip ;
   private String A634MigrLegOSAfip ;
   private String Z622MigrLegSCVO ;
   private String A622MigrLegSCVO ;
   private String Z626MigrLegId ;
   private String A626MigrLegId ;
   private String Z631MigrTieneConyuge ;
   private String A631MigrTieneConyuge ;
   private String Z1398MigrTraDiurno ;
   private String A1398MigrTraDiurno ;
   private String Z1399MigrTraNoct ;
   private String A1399MigrTraNoct ;
   private String Z1400MigrTraIns ;
   private String A1400MigrTraIns ;
   private String Z2221MigrLegMarcaCCT ;
   private String A2221MigrLegMarcaCCT ;
   private String O634MigrLegOSAfip ;
   private String Z2082MigrLegFamAdh ;
   private String A2082MigrLegFamAdh ;
   private String Z2086MigrLegFamDiscap ;
   private String A2086MigrLegFamDiscap ;
   private String sMode262 ;
   private String N634MigrLegOSAfip ;
   private java.util.Date Z594MigrLegFecNac ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date Z603MigrLegFecIngreso ;
   private java.util.Date A603MigrLegFecIngreso ;
   private java.util.Date Z618MigrLegFecUltMod ;
   private java.util.Date A618MigrLegFecUltMod ;
   private java.util.Date Z2190MigrPeriodo ;
   private java.util.Date A2190MigrPeriodo ;
   private java.util.Date Z2205MigrLegFecEgreso ;
   private java.util.Date A2205MigrLegFecEgreso ;
   private java.util.Date Z2089MigrLegFamFecNac ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private boolean returnInSub ;
   private boolean AV22IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean A2197MigrValCadaSave ;
   private boolean Z691MigrLegClaseDef ;
   private boolean A691MigrLegClaseDef ;
   private boolean Z635MigrEncontroOsoSigla ;
   private boolean A635MigrEncontroOsoSigla ;
   private boolean Z1820MigrEncontroOsoAfip ;
   private boolean A1820MigrEncontroOsoAfip ;
   private boolean Z695MigrLegModalidadDef ;
   private boolean A695MigrLegModalidadDef ;
   private boolean Z696MigrLegZonaDef ;
   private boolean A696MigrLegZonaDef ;
   private boolean Z698MigrLegSituacionDef ;
   private boolean A698MigrLegSituacionDef ;
   private boolean Z690MigrLegEstadoCivilDef ;
   private boolean A690MigrLegEstadoCivilDef ;
   private boolean Z692MigrLegFormaPagoDef ;
   private boolean A692MigrLegFormaPagoDef ;
   private boolean Z693MigrLegTipoCuentaDef ;
   private boolean A693MigrLegTipoCuentaDef ;
   private boolean Z694MigrLegActividadDef ;
   private boolean A694MigrLegActividadDef ;
   private boolean Z699MigrLegCondicionDef ;
   private boolean A699MigrLegCondicionDef ;
   private boolean Z700MigrLegSiniestradoDef ;
   private boolean A700MigrLegSiniestradoDef ;
   private boolean Z2197MigrValCadaSave ;
   private boolean n2221MigrLegMarcaCCT ;
   private boolean n2222MigrArchSec ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z628MigrLegObs ;
   private String A628MigrLegObs ;
   private String Z629MigrLegErrores ;
   private String A629MigrLegErrores ;
   private String Z633MigrLegWarnings ;
   private String A633MigrLegWarnings ;
   private String Z2189MigrSueldos ;
   private String A2189MigrSueldos ;
   private String Z2206MigrOtrosDatos ;
   private String A2206MigrOtrosDatos ;
   private String Z592MigrLegApellido ;
   private String A592MigrLegApellido ;
   private String Z593MigrLegNombre ;
   private String A593MigrLegNombre ;
   private String Z596MigrLegEstadoCivil ;
   private String A596MigrLegEstadoCivil ;
   private String Z599MigrLegDomici ;
   private String A599MigrLegDomici ;
   private String Z600MigrLegEmail ;
   private String A600MigrLegEmail ;
   private String Z601MigrLegCodPos ;
   private String A601MigrLegCodPos ;
   private String Z602MigrLegTelefono ;
   private String A602MigrLegTelefono ;
   private String Z604MigrLegCategoria ;
   private String A604MigrLegCategoria ;
   private String Z605MigrLegArea ;
   private String A605MigrLegArea ;
   private String Z606MigrLegLugarDePago ;
   private String A606MigrLegLugarDePago ;
   private String Z2415MigrLegModTra ;
   private String A2415MigrLegModTra ;
   private String Z2427MigrLegTipoTarifa ;
   private String A2427MigrLegTipoTarifa ;
   private String Z607MigrLegClase ;
   private String A607MigrLegClase ;
   private String Z609MigrLegFormaPago ;
   private String A609MigrLegFormaPago ;
   private String Z610MigrLegBanco ;
   private String A610MigrLegBanco ;
   private String Z611MigrLegBanSuc ;
   private String A611MigrLegBanSuc ;
   private String Z612MigrLegBanTipCuen ;
   private String A612MigrLegBanTipCuen ;
   private String Z613MigrLegSindicato ;
   private String A613MigrLegSindicato ;
   private String Z614MigrLegObraSocial ;
   private String A614MigrLegObraSocial ;
   private String Z615MigrLegPlanMedico ;
   private String A615MigrLegPlanMedico ;
   private String Z616MigrLegActividad ;
   private String A616MigrLegActividad ;
   private String Z617MigrLegModalidad ;
   private String A617MigrLegModalidad ;
   private String Z619MigrLegCuentaBanc ;
   private String A619MigrLegCuentaBanc ;
   private String Z620MigrLegZona ;
   private String A620MigrLegZona ;
   private String Z621MigrLegCBU ;
   private String A621MigrLegCBU ;
   private String Z623MigrLegSituacionRevista ;
   private String A623MigrLegSituacionRevista ;
   private String Z624MigrLegCondicion ;
   private String A624MigrLegCondicion ;
   private String Z625MigrLegSiniestrado ;
   private String A625MigrLegSiniestrado ;
   private String Z627MigrLegConvenio ;
   private String A627MigrLegConvenio ;
   private String Z2216MigrPuesto ;
   private String A2216MigrPuesto ;
   private String Z2239MigrLegActLabClas ;
   private String A2239MigrLegActLabClas ;
   private String Z2240MigrLegPueAfip ;
   private String A2240MigrLegPueAfip ;
   private String Z2079MigrLegFamParen ;
   private String A2079MigrLegFamParen ;
   private String Z2080MigrLegFamNroDoc ;
   private String A2080MigrLegFamNroDoc ;
   private String Z2088MigrLegFamNomApe ;
   private String A2088MigrLegFamNomApe ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV55WebSession ;
   private web.Sdtimportacion_legajo bcimportacion_legajo ;
   private IDataStoreProvider pr_default ;
   private int[] BC00017_A87MigrLegNumero ;
   private String[] BC00017_A592MigrLegApellido ;
   private String[] BC00017_A593MigrLegNombre ;
   private java.util.Date[] BC00017_A594MigrLegFecNac ;
   private String[] BC00017_A595MigrLegSexo ;
   private String[] BC00017_A596MigrLegEstadoCivil ;
   private String[] BC00017_A597MigrLegCUIL ;
   private String[] BC00017_A598MigrLegDiscapacidad ;
   private String[] BC00017_A599MigrLegDomici ;
   private String[] BC00017_A600MigrLegEmail ;
   private String[] BC00017_A601MigrLegCodPos ;
   private String[] BC00017_A602MigrLegTelefono ;
   private java.util.Date[] BC00017_A603MigrLegFecIngreso ;
   private String[] BC00017_A604MigrLegCategoria ;
   private String[] BC00017_A605MigrLegArea ;
   private String[] BC00017_A606MigrLegLugarDePago ;
   private String[] BC00017_A2415MigrLegModTra ;
   private String[] BC00017_A2427MigrLegTipoTarifa ;
   private String[] BC00017_A607MigrLegClase ;
   private java.math.BigDecimal[] BC00017_A608MigrLegBasico ;
   private String[] BC00017_A609MigrLegFormaPago ;
   private boolean[] BC00017_A691MigrLegClaseDef ;
   private String[] BC00017_A610MigrLegBanco ;
   private String[] BC00017_A611MigrLegBanSuc ;
   private String[] BC00017_A612MigrLegBanTipCuen ;
   private String[] BC00017_A613MigrLegSindicato ;
   private String[] BC00017_A614MigrLegObraSocial ;
   private String[] BC00017_A634MigrLegOSAfip ;
   private String[] BC00017_A615MigrLegPlanMedico ;
   private String[] BC00017_A616MigrLegActividad ;
   private String[] BC00017_A617MigrLegModalidad ;
   private java.util.Date[] BC00017_A618MigrLegFecUltMod ;
   private String[] BC00017_A619MigrLegCuentaBanc ;
   private String[] BC00017_A620MigrLegZona ;
   private String[] BC00017_A621MigrLegCBU ;
   private String[] BC00017_A622MigrLegSCVO ;
   private String[] BC00017_A623MigrLegSituacionRevista ;
   private String[] BC00017_A624MigrLegCondicion ;
   private String[] BC00017_A625MigrLegSiniestrado ;
   private String[] BC00017_A626MigrLegId ;
   private String[] BC00017_A627MigrLegConvenio ;
   private String[] BC00017_A628MigrLegObs ;
   private String[] BC00017_A629MigrLegErrores ;
   private String[] BC00017_A633MigrLegWarnings ;
   private String[] BC00017_A631MigrTieneConyuge ;
   private short[] BC00017_A632MigrCantidadHijos ;
   private boolean[] BC00017_A635MigrEncontroOsoSigla ;
   private String[] BC00017_A1398MigrTraDiurno ;
   private String[] BC00017_A1399MigrTraNoct ;
   private String[] BC00017_A1400MigrTraIns ;
   private boolean[] BC00017_A1820MigrEncontroOsoAfip ;
   private String[] BC00017_A2189MigrSueldos ;
   private java.util.Date[] BC00017_A2190MigrPeriodo ;
   private boolean[] BC00017_A695MigrLegModalidadDef ;
   private boolean[] BC00017_A696MigrLegZonaDef ;
   private boolean[] BC00017_A698MigrLegSituacionDef ;
   private boolean[] BC00017_A690MigrLegEstadoCivilDef ;
   private boolean[] BC00017_A692MigrLegFormaPagoDef ;
   private boolean[] BC00017_A693MigrLegTipoCuentaDef ;
   private boolean[] BC00017_A694MigrLegActividadDef ;
   private boolean[] BC00017_A699MigrLegCondicionDef ;
   private boolean[] BC00017_A700MigrLegSiniestradoDef ;
   private boolean[] BC00017_A2197MigrValCadaSave ;
   private java.util.Date[] BC00017_A2205MigrLegFecEgreso ;
   private String[] BC00017_A2206MigrOtrosDatos ;
   private String[] BC00017_A2216MigrPuesto ;
   private String[] BC00017_A2221MigrLegMarcaCCT ;
   private boolean[] BC00017_n2221MigrLegMarcaCCT ;
   private short[] BC00017_A2222MigrArchSec ;
   private boolean[] BC00017_n2222MigrArchSec ;
   private String[] BC00017_A2239MigrLegActLabClas ;
   private String[] BC00017_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC00017_A2275MigrLegHorSem ;
   private int[] BC00017_A3CliCod ;
   private short[] BC00017_A1EmpCod ;
   private int[] BC00018_A3CliCod ;
   private int[] BC00019_A3CliCod ;
   private short[] BC00019_A1EmpCod ;
   private int[] BC00019_A87MigrLegNumero ;
   private int[] BC000110_A87MigrLegNumero ;
   private String[] BC000110_A592MigrLegApellido ;
   private String[] BC000110_A593MigrLegNombre ;
   private java.util.Date[] BC000110_A594MigrLegFecNac ;
   private String[] BC000110_A595MigrLegSexo ;
   private String[] BC000110_A596MigrLegEstadoCivil ;
   private String[] BC000110_A597MigrLegCUIL ;
   private String[] BC000110_A598MigrLegDiscapacidad ;
   private String[] BC000110_A599MigrLegDomici ;
   private String[] BC000110_A600MigrLegEmail ;
   private String[] BC000110_A601MigrLegCodPos ;
   private String[] BC000110_A602MigrLegTelefono ;
   private java.util.Date[] BC000110_A603MigrLegFecIngreso ;
   private String[] BC000110_A604MigrLegCategoria ;
   private String[] BC000110_A605MigrLegArea ;
   private String[] BC000110_A606MigrLegLugarDePago ;
   private String[] BC000110_A2415MigrLegModTra ;
   private String[] BC000110_A2427MigrLegTipoTarifa ;
   private String[] BC000110_A607MigrLegClase ;
   private java.math.BigDecimal[] BC000110_A608MigrLegBasico ;
   private String[] BC000110_A609MigrLegFormaPago ;
   private boolean[] BC000110_A691MigrLegClaseDef ;
   private String[] BC000110_A610MigrLegBanco ;
   private String[] BC000110_A611MigrLegBanSuc ;
   private String[] BC000110_A612MigrLegBanTipCuen ;
   private String[] BC000110_A613MigrLegSindicato ;
   private String[] BC000110_A614MigrLegObraSocial ;
   private String[] BC000110_A634MigrLegOSAfip ;
   private String[] BC000110_A615MigrLegPlanMedico ;
   private String[] BC000110_A616MigrLegActividad ;
   private String[] BC000110_A617MigrLegModalidad ;
   private java.util.Date[] BC000110_A618MigrLegFecUltMod ;
   private String[] BC000110_A619MigrLegCuentaBanc ;
   private String[] BC000110_A620MigrLegZona ;
   private String[] BC000110_A621MigrLegCBU ;
   private String[] BC000110_A622MigrLegSCVO ;
   private String[] BC000110_A623MigrLegSituacionRevista ;
   private String[] BC000110_A624MigrLegCondicion ;
   private String[] BC000110_A625MigrLegSiniestrado ;
   private String[] BC000110_A626MigrLegId ;
   private String[] BC000110_A627MigrLegConvenio ;
   private String[] BC000110_A628MigrLegObs ;
   private String[] BC000110_A629MigrLegErrores ;
   private String[] BC000110_A633MigrLegWarnings ;
   private String[] BC000110_A631MigrTieneConyuge ;
   private short[] BC000110_A632MigrCantidadHijos ;
   private boolean[] BC000110_A635MigrEncontroOsoSigla ;
   private String[] BC000110_A1398MigrTraDiurno ;
   private String[] BC000110_A1399MigrTraNoct ;
   private String[] BC000110_A1400MigrTraIns ;
   private boolean[] BC000110_A1820MigrEncontroOsoAfip ;
   private String[] BC000110_A2189MigrSueldos ;
   private java.util.Date[] BC000110_A2190MigrPeriodo ;
   private boolean[] BC000110_A695MigrLegModalidadDef ;
   private boolean[] BC000110_A696MigrLegZonaDef ;
   private boolean[] BC000110_A698MigrLegSituacionDef ;
   private boolean[] BC000110_A690MigrLegEstadoCivilDef ;
   private boolean[] BC000110_A692MigrLegFormaPagoDef ;
   private boolean[] BC000110_A693MigrLegTipoCuentaDef ;
   private boolean[] BC000110_A694MigrLegActividadDef ;
   private boolean[] BC000110_A699MigrLegCondicionDef ;
   private boolean[] BC000110_A700MigrLegSiniestradoDef ;
   private boolean[] BC000110_A2197MigrValCadaSave ;
   private java.util.Date[] BC000110_A2205MigrLegFecEgreso ;
   private String[] BC000110_A2206MigrOtrosDatos ;
   private String[] BC000110_A2216MigrPuesto ;
   private String[] BC000110_A2221MigrLegMarcaCCT ;
   private boolean[] BC000110_n2221MigrLegMarcaCCT ;
   private short[] BC000110_A2222MigrArchSec ;
   private boolean[] BC000110_n2222MigrArchSec ;
   private String[] BC000110_A2239MigrLegActLabClas ;
   private String[] BC000110_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC000110_A2275MigrLegHorSem ;
   private int[] BC000110_A3CliCod ;
   private short[] BC000110_A1EmpCod ;
   private int[] BC000111_A87MigrLegNumero ;
   private String[] BC000111_A592MigrLegApellido ;
   private String[] BC000111_A593MigrLegNombre ;
   private java.util.Date[] BC000111_A594MigrLegFecNac ;
   private String[] BC000111_A595MigrLegSexo ;
   private String[] BC000111_A596MigrLegEstadoCivil ;
   private String[] BC000111_A597MigrLegCUIL ;
   private String[] BC000111_A598MigrLegDiscapacidad ;
   private String[] BC000111_A599MigrLegDomici ;
   private String[] BC000111_A600MigrLegEmail ;
   private String[] BC000111_A601MigrLegCodPos ;
   private String[] BC000111_A602MigrLegTelefono ;
   private java.util.Date[] BC000111_A603MigrLegFecIngreso ;
   private String[] BC000111_A604MigrLegCategoria ;
   private String[] BC000111_A605MigrLegArea ;
   private String[] BC000111_A606MigrLegLugarDePago ;
   private String[] BC000111_A2415MigrLegModTra ;
   private String[] BC000111_A2427MigrLegTipoTarifa ;
   private String[] BC000111_A607MigrLegClase ;
   private java.math.BigDecimal[] BC000111_A608MigrLegBasico ;
   private String[] BC000111_A609MigrLegFormaPago ;
   private boolean[] BC000111_A691MigrLegClaseDef ;
   private String[] BC000111_A610MigrLegBanco ;
   private String[] BC000111_A611MigrLegBanSuc ;
   private String[] BC000111_A612MigrLegBanTipCuen ;
   private String[] BC000111_A613MigrLegSindicato ;
   private String[] BC000111_A614MigrLegObraSocial ;
   private String[] BC000111_A634MigrLegOSAfip ;
   private String[] BC000111_A615MigrLegPlanMedico ;
   private String[] BC000111_A616MigrLegActividad ;
   private String[] BC000111_A617MigrLegModalidad ;
   private java.util.Date[] BC000111_A618MigrLegFecUltMod ;
   private String[] BC000111_A619MigrLegCuentaBanc ;
   private String[] BC000111_A620MigrLegZona ;
   private String[] BC000111_A621MigrLegCBU ;
   private String[] BC000111_A622MigrLegSCVO ;
   private String[] BC000111_A623MigrLegSituacionRevista ;
   private String[] BC000111_A624MigrLegCondicion ;
   private String[] BC000111_A625MigrLegSiniestrado ;
   private String[] BC000111_A626MigrLegId ;
   private String[] BC000111_A627MigrLegConvenio ;
   private String[] BC000111_A628MigrLegObs ;
   private String[] BC000111_A629MigrLegErrores ;
   private String[] BC000111_A633MigrLegWarnings ;
   private String[] BC000111_A631MigrTieneConyuge ;
   private short[] BC000111_A632MigrCantidadHijos ;
   private boolean[] BC000111_A635MigrEncontroOsoSigla ;
   private String[] BC000111_A1398MigrTraDiurno ;
   private String[] BC000111_A1399MigrTraNoct ;
   private String[] BC000111_A1400MigrTraIns ;
   private boolean[] BC000111_A1820MigrEncontroOsoAfip ;
   private String[] BC000111_A2189MigrSueldos ;
   private java.util.Date[] BC000111_A2190MigrPeriodo ;
   private boolean[] BC000111_A695MigrLegModalidadDef ;
   private boolean[] BC000111_A696MigrLegZonaDef ;
   private boolean[] BC000111_A698MigrLegSituacionDef ;
   private boolean[] BC000111_A690MigrLegEstadoCivilDef ;
   private boolean[] BC000111_A692MigrLegFormaPagoDef ;
   private boolean[] BC000111_A693MigrLegTipoCuentaDef ;
   private boolean[] BC000111_A694MigrLegActividadDef ;
   private boolean[] BC000111_A699MigrLegCondicionDef ;
   private boolean[] BC000111_A700MigrLegSiniestradoDef ;
   private boolean[] BC000111_A2197MigrValCadaSave ;
   private java.util.Date[] BC000111_A2205MigrLegFecEgreso ;
   private String[] BC000111_A2206MigrOtrosDatos ;
   private String[] BC000111_A2216MigrPuesto ;
   private String[] BC000111_A2221MigrLegMarcaCCT ;
   private boolean[] BC000111_n2221MigrLegMarcaCCT ;
   private short[] BC000111_A2222MigrArchSec ;
   private boolean[] BC000111_n2222MigrArchSec ;
   private String[] BC000111_A2239MigrLegActLabClas ;
   private String[] BC000111_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC000111_A2275MigrLegHorSem ;
   private int[] BC000111_A3CliCod ;
   private short[] BC000111_A1EmpCod ;
   private int[] BC000115_A87MigrLegNumero ;
   private String[] BC000115_A592MigrLegApellido ;
   private String[] BC000115_A593MigrLegNombre ;
   private java.util.Date[] BC000115_A594MigrLegFecNac ;
   private String[] BC000115_A595MigrLegSexo ;
   private String[] BC000115_A596MigrLegEstadoCivil ;
   private String[] BC000115_A597MigrLegCUIL ;
   private String[] BC000115_A598MigrLegDiscapacidad ;
   private String[] BC000115_A599MigrLegDomici ;
   private String[] BC000115_A600MigrLegEmail ;
   private String[] BC000115_A601MigrLegCodPos ;
   private String[] BC000115_A602MigrLegTelefono ;
   private java.util.Date[] BC000115_A603MigrLegFecIngreso ;
   private String[] BC000115_A604MigrLegCategoria ;
   private String[] BC000115_A605MigrLegArea ;
   private String[] BC000115_A606MigrLegLugarDePago ;
   private String[] BC000115_A2415MigrLegModTra ;
   private String[] BC000115_A2427MigrLegTipoTarifa ;
   private String[] BC000115_A607MigrLegClase ;
   private java.math.BigDecimal[] BC000115_A608MigrLegBasico ;
   private String[] BC000115_A609MigrLegFormaPago ;
   private boolean[] BC000115_A691MigrLegClaseDef ;
   private String[] BC000115_A610MigrLegBanco ;
   private String[] BC000115_A611MigrLegBanSuc ;
   private String[] BC000115_A612MigrLegBanTipCuen ;
   private String[] BC000115_A613MigrLegSindicato ;
   private String[] BC000115_A614MigrLegObraSocial ;
   private String[] BC000115_A634MigrLegOSAfip ;
   private String[] BC000115_A615MigrLegPlanMedico ;
   private String[] BC000115_A616MigrLegActividad ;
   private String[] BC000115_A617MigrLegModalidad ;
   private java.util.Date[] BC000115_A618MigrLegFecUltMod ;
   private String[] BC000115_A619MigrLegCuentaBanc ;
   private String[] BC000115_A620MigrLegZona ;
   private String[] BC000115_A621MigrLegCBU ;
   private String[] BC000115_A622MigrLegSCVO ;
   private String[] BC000115_A623MigrLegSituacionRevista ;
   private String[] BC000115_A624MigrLegCondicion ;
   private String[] BC000115_A625MigrLegSiniestrado ;
   private String[] BC000115_A626MigrLegId ;
   private String[] BC000115_A627MigrLegConvenio ;
   private String[] BC000115_A628MigrLegObs ;
   private String[] BC000115_A629MigrLegErrores ;
   private String[] BC000115_A633MigrLegWarnings ;
   private String[] BC000115_A631MigrTieneConyuge ;
   private short[] BC000115_A632MigrCantidadHijos ;
   private boolean[] BC000115_A635MigrEncontroOsoSigla ;
   private String[] BC000115_A1398MigrTraDiurno ;
   private String[] BC000115_A1399MigrTraNoct ;
   private String[] BC000115_A1400MigrTraIns ;
   private boolean[] BC000115_A1820MigrEncontroOsoAfip ;
   private String[] BC000115_A2189MigrSueldos ;
   private java.util.Date[] BC000115_A2190MigrPeriodo ;
   private boolean[] BC000115_A695MigrLegModalidadDef ;
   private boolean[] BC000115_A696MigrLegZonaDef ;
   private boolean[] BC000115_A698MigrLegSituacionDef ;
   private boolean[] BC000115_A690MigrLegEstadoCivilDef ;
   private boolean[] BC000115_A692MigrLegFormaPagoDef ;
   private boolean[] BC000115_A693MigrLegTipoCuentaDef ;
   private boolean[] BC000115_A694MigrLegActividadDef ;
   private boolean[] BC000115_A699MigrLegCondicionDef ;
   private boolean[] BC000115_A700MigrLegSiniestradoDef ;
   private boolean[] BC000115_A2197MigrValCadaSave ;
   private java.util.Date[] BC000115_A2205MigrLegFecEgreso ;
   private String[] BC000115_A2206MigrOtrosDatos ;
   private String[] BC000115_A2216MigrPuesto ;
   private String[] BC000115_A2221MigrLegMarcaCCT ;
   private boolean[] BC000115_n2221MigrLegMarcaCCT ;
   private short[] BC000115_A2222MigrArchSec ;
   private boolean[] BC000115_n2222MigrArchSec ;
   private String[] BC000115_A2239MigrLegActLabClas ;
   private String[] BC000115_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC000115_A2275MigrLegHorSem ;
   private int[] BC000115_A3CliCod ;
   private short[] BC000115_A1EmpCod ;
   private short[] BC000116_A1EmpCod ;
   private int[] BC000116_A87MigrLegNumero ;
   private short[] BC000116_A2078MigrLegFamSec ;
   private String[] BC000116_A2079MigrLegFamParen ;
   private String[] BC000116_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC000116_A2081MigrLegFamDedGan ;
   private String[] BC000116_A2082MigrLegFamAdh ;
   private String[] BC000116_A2086MigrLegFamDiscap ;
   private String[] BC000116_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC000116_A2089MigrLegFamFecNac ;
   private int[] BC000116_A3CliCod ;
   private int[] BC000117_A3CliCod ;
   private short[] BC000117_A1EmpCod ;
   private int[] BC000117_A87MigrLegNumero ;
   private short[] BC000117_A2078MigrLegFamSec ;
   private short[] BC000118_A1EmpCod ;
   private int[] BC000118_A87MigrLegNumero ;
   private short[] BC000118_A2078MigrLegFamSec ;
   private String[] BC000118_A2079MigrLegFamParen ;
   private String[] BC000118_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC000118_A2081MigrLegFamDedGan ;
   private String[] BC000118_A2082MigrLegFamAdh ;
   private String[] BC000118_A2086MigrLegFamDiscap ;
   private String[] BC000118_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC000118_A2089MigrLegFamFecNac ;
   private int[] BC000118_A3CliCod ;
   private short[] BC000119_A1EmpCod ;
   private int[] BC000119_A87MigrLegNumero ;
   private short[] BC000119_A2078MigrLegFamSec ;
   private String[] BC000119_A2079MigrLegFamParen ;
   private String[] BC000119_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC000119_A2081MigrLegFamDedGan ;
   private String[] BC000119_A2082MigrLegFamAdh ;
   private String[] BC000119_A2086MigrLegFamDiscap ;
   private String[] BC000119_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC000119_A2089MigrLegFamFecNac ;
   private int[] BC000119_A3CliCod ;
   private short[] BC000123_A1EmpCod ;
   private int[] BC000123_A87MigrLegNumero ;
   private short[] BC000123_A2078MigrLegFamSec ;
   private String[] BC000123_A2079MigrLegFamParen ;
   private String[] BC000123_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC000123_A2081MigrLegFamDedGan ;
   private String[] BC000123_A2082MigrLegFamAdh ;
   private String[] BC000123_A2086MigrLegFamDiscap ;
   private String[] BC000123_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC000123_A2089MigrLegFamFecNac ;
   private int[] BC000123_A3CliCod ;
   private int[] BC000124_A3CliCod ;
   private int[] BC000125_A3CliCod ;
   private short[] BC00012_A1EmpCod ;
   private int[] BC00012_A87MigrLegNumero ;
   private short[] BC00012_A2078MigrLegFamSec ;
   private String[] BC00012_A2079MigrLegFamParen ;
   private String[] BC00012_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00012_A2081MigrLegFamDedGan ;
   private String[] BC00012_A2082MigrLegFamAdh ;
   private String[] BC00012_A2086MigrLegFamDiscap ;
   private String[] BC00012_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00012_A2089MigrLegFamFecNac ;
   private int[] BC00012_A3CliCod ;
   private short[] BC00013_A1EmpCod ;
   private int[] BC00013_A87MigrLegNumero ;
   private short[] BC00013_A2078MigrLegFamSec ;
   private String[] BC00013_A2079MigrLegFamParen ;
   private String[] BC00013_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00013_A2081MigrLegFamDedGan ;
   private String[] BC00013_A2082MigrLegFamAdh ;
   private String[] BC00013_A2086MigrLegFamDiscap ;
   private String[] BC00013_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00013_A2089MigrLegFamFecNac ;
   private int[] BC00013_A3CliCod ;
   private int[] BC00014_A87MigrLegNumero ;
   private String[] BC00014_A592MigrLegApellido ;
   private String[] BC00014_A593MigrLegNombre ;
   private java.util.Date[] BC00014_A594MigrLegFecNac ;
   private String[] BC00014_A595MigrLegSexo ;
   private String[] BC00014_A596MigrLegEstadoCivil ;
   private String[] BC00014_A597MigrLegCUIL ;
   private String[] BC00014_A598MigrLegDiscapacidad ;
   private String[] BC00014_A599MigrLegDomici ;
   private String[] BC00014_A600MigrLegEmail ;
   private String[] BC00014_A601MigrLegCodPos ;
   private String[] BC00014_A602MigrLegTelefono ;
   private java.util.Date[] BC00014_A603MigrLegFecIngreso ;
   private String[] BC00014_A604MigrLegCategoria ;
   private String[] BC00014_A605MigrLegArea ;
   private String[] BC00014_A606MigrLegLugarDePago ;
   private String[] BC00014_A2415MigrLegModTra ;
   private String[] BC00014_A2427MigrLegTipoTarifa ;
   private String[] BC00014_A607MigrLegClase ;
   private java.math.BigDecimal[] BC00014_A608MigrLegBasico ;
   private String[] BC00014_A609MigrLegFormaPago ;
   private boolean[] BC00014_A691MigrLegClaseDef ;
   private String[] BC00014_A610MigrLegBanco ;
   private String[] BC00014_A611MigrLegBanSuc ;
   private String[] BC00014_A612MigrLegBanTipCuen ;
   private String[] BC00014_A613MigrLegSindicato ;
   private String[] BC00014_A614MigrLegObraSocial ;
   private String[] BC00014_A634MigrLegOSAfip ;
   private String[] BC00014_A615MigrLegPlanMedico ;
   private String[] BC00014_A616MigrLegActividad ;
   private String[] BC00014_A617MigrLegModalidad ;
   private java.util.Date[] BC00014_A618MigrLegFecUltMod ;
   private String[] BC00014_A619MigrLegCuentaBanc ;
   private String[] BC00014_A620MigrLegZona ;
   private String[] BC00014_A621MigrLegCBU ;
   private String[] BC00014_A622MigrLegSCVO ;
   private String[] BC00014_A623MigrLegSituacionRevista ;
   private String[] BC00014_A624MigrLegCondicion ;
   private String[] BC00014_A625MigrLegSiniestrado ;
   private String[] BC00014_A626MigrLegId ;
   private String[] BC00014_A627MigrLegConvenio ;
   private String[] BC00014_A628MigrLegObs ;
   private String[] BC00014_A629MigrLegErrores ;
   private String[] BC00014_A633MigrLegWarnings ;
   private String[] BC00014_A631MigrTieneConyuge ;
   private short[] BC00014_A632MigrCantidadHijos ;
   private boolean[] BC00014_A635MigrEncontroOsoSigla ;
   private String[] BC00014_A1398MigrTraDiurno ;
   private String[] BC00014_A1399MigrTraNoct ;
   private String[] BC00014_A1400MigrTraIns ;
   private boolean[] BC00014_A1820MigrEncontroOsoAfip ;
   private String[] BC00014_A2189MigrSueldos ;
   private java.util.Date[] BC00014_A2190MigrPeriodo ;
   private boolean[] BC00014_A695MigrLegModalidadDef ;
   private boolean[] BC00014_A696MigrLegZonaDef ;
   private boolean[] BC00014_A698MigrLegSituacionDef ;
   private boolean[] BC00014_A690MigrLegEstadoCivilDef ;
   private boolean[] BC00014_A692MigrLegFormaPagoDef ;
   private boolean[] BC00014_A693MigrLegTipoCuentaDef ;
   private boolean[] BC00014_A694MigrLegActividadDef ;
   private boolean[] BC00014_A699MigrLegCondicionDef ;
   private boolean[] BC00014_A700MigrLegSiniestradoDef ;
   private boolean[] BC00014_A2197MigrValCadaSave ;
   private java.util.Date[] BC00014_A2205MigrLegFecEgreso ;
   private String[] BC00014_A2206MigrOtrosDatos ;
   private String[] BC00014_A2216MigrPuesto ;
   private String[] BC00014_A2221MigrLegMarcaCCT ;
   private short[] BC00014_A2222MigrArchSec ;
   private String[] BC00014_A2239MigrLegActLabClas ;
   private String[] BC00014_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC00014_A2275MigrLegHorSem ;
   private int[] BC00014_A3CliCod ;
   private short[] BC00014_A1EmpCod ;
   private int[] BC00015_A87MigrLegNumero ;
   private String[] BC00015_A592MigrLegApellido ;
   private String[] BC00015_A593MigrLegNombre ;
   private java.util.Date[] BC00015_A594MigrLegFecNac ;
   private String[] BC00015_A595MigrLegSexo ;
   private String[] BC00015_A596MigrLegEstadoCivil ;
   private String[] BC00015_A597MigrLegCUIL ;
   private String[] BC00015_A598MigrLegDiscapacidad ;
   private String[] BC00015_A599MigrLegDomici ;
   private String[] BC00015_A600MigrLegEmail ;
   private String[] BC00015_A601MigrLegCodPos ;
   private String[] BC00015_A602MigrLegTelefono ;
   private java.util.Date[] BC00015_A603MigrLegFecIngreso ;
   private String[] BC00015_A604MigrLegCategoria ;
   private String[] BC00015_A605MigrLegArea ;
   private String[] BC00015_A606MigrLegLugarDePago ;
   private String[] BC00015_A2415MigrLegModTra ;
   private String[] BC00015_A2427MigrLegTipoTarifa ;
   private String[] BC00015_A607MigrLegClase ;
   private java.math.BigDecimal[] BC00015_A608MigrLegBasico ;
   private String[] BC00015_A609MigrLegFormaPago ;
   private boolean[] BC00015_A691MigrLegClaseDef ;
   private String[] BC00015_A610MigrLegBanco ;
   private String[] BC00015_A611MigrLegBanSuc ;
   private String[] BC00015_A612MigrLegBanTipCuen ;
   private String[] BC00015_A613MigrLegSindicato ;
   private String[] BC00015_A614MigrLegObraSocial ;
   private String[] BC00015_A634MigrLegOSAfip ;
   private String[] BC00015_A615MigrLegPlanMedico ;
   private String[] BC00015_A616MigrLegActividad ;
   private String[] BC00015_A617MigrLegModalidad ;
   private java.util.Date[] BC00015_A618MigrLegFecUltMod ;
   private String[] BC00015_A619MigrLegCuentaBanc ;
   private String[] BC00015_A620MigrLegZona ;
   private String[] BC00015_A621MigrLegCBU ;
   private String[] BC00015_A622MigrLegSCVO ;
   private String[] BC00015_A623MigrLegSituacionRevista ;
   private String[] BC00015_A624MigrLegCondicion ;
   private String[] BC00015_A625MigrLegSiniestrado ;
   private String[] BC00015_A626MigrLegId ;
   private String[] BC00015_A627MigrLegConvenio ;
   private String[] BC00015_A628MigrLegObs ;
   private String[] BC00015_A629MigrLegErrores ;
   private String[] BC00015_A633MigrLegWarnings ;
   private String[] BC00015_A631MigrTieneConyuge ;
   private short[] BC00015_A632MigrCantidadHijos ;
   private boolean[] BC00015_A635MigrEncontroOsoSigla ;
   private String[] BC00015_A1398MigrTraDiurno ;
   private String[] BC00015_A1399MigrTraNoct ;
   private String[] BC00015_A1400MigrTraIns ;
   private boolean[] BC00015_A1820MigrEncontroOsoAfip ;
   private String[] BC00015_A2189MigrSueldos ;
   private java.util.Date[] BC00015_A2190MigrPeriodo ;
   private boolean[] BC00015_A695MigrLegModalidadDef ;
   private boolean[] BC00015_A696MigrLegZonaDef ;
   private boolean[] BC00015_A698MigrLegSituacionDef ;
   private boolean[] BC00015_A690MigrLegEstadoCivilDef ;
   private boolean[] BC00015_A692MigrLegFormaPagoDef ;
   private boolean[] BC00015_A693MigrLegTipoCuentaDef ;
   private boolean[] BC00015_A694MigrLegActividadDef ;
   private boolean[] BC00015_A699MigrLegCondicionDef ;
   private boolean[] BC00015_A700MigrLegSiniestradoDef ;
   private boolean[] BC00015_A2197MigrValCadaSave ;
   private java.util.Date[] BC00015_A2205MigrLegFecEgreso ;
   private String[] BC00015_A2206MigrOtrosDatos ;
   private String[] BC00015_A2216MigrPuesto ;
   private String[] BC00015_A2221MigrLegMarcaCCT ;
   private short[] BC00015_A2222MigrArchSec ;
   private String[] BC00015_A2239MigrLegActLabClas ;
   private String[] BC00015_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] BC00015_A2275MigrLegHorSem ;
   private int[] BC00015_A3CliCod ;
   private short[] BC00015_A1EmpCod ;
   private int[] BC00016_A3CliCod ;
   private boolean[] BC00014_n2221MigrLegMarcaCCT ;
   private boolean[] BC00014_n2222MigrArchSec ;
   private boolean[] BC00015_n2221MigrLegMarcaCCT ;
   private boolean[] BC00015_n2222MigrArchSec ;
   private GXSimpleCollection<String> AV67errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar4[] ;
   private GXSimpleCollection<String> AV68warnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV54TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV56WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class importacion_legajo_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00012", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00013", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00014", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?  FOR UPDATE OF importacion_legajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00015", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00016", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00017", "SELECT TM1.MigrLegNumero, TM1.MigrLegApellido, TM1.MigrLegNombre, TM1.MigrLegFecNac, TM1.MigrLegSexo, TM1.MigrLegEstadoCivil, TM1.MigrLegCUIL, TM1.MigrLegDiscapacidad, TM1.MigrLegDomici, TM1.MigrLegEmail, TM1.MigrLegCodPos, TM1.MigrLegTelefono, TM1.MigrLegFecIngreso, TM1.MigrLegCategoria, TM1.MigrLegArea, TM1.MigrLegLugarDePago, TM1.MigrLegModTra, TM1.MigrLegTipoTarifa, TM1.MigrLegClase, TM1.MigrLegBasico, TM1.MigrLegFormaPago, TM1.MigrLegClaseDef, TM1.MigrLegBanco, TM1.MigrLegBanSuc, TM1.MigrLegBanTipCuen, TM1.MigrLegSindicato, TM1.MigrLegObraSocial, TM1.MigrLegOSAfip, TM1.MigrLegPlanMedico, TM1.MigrLegActividad, TM1.MigrLegModalidad, TM1.MigrLegFecUltMod, TM1.MigrLegCuentaBanc, TM1.MigrLegZona, TM1.MigrLegCBU, TM1.MigrLegSCVO, TM1.MigrLegSituacionRevista, TM1.MigrLegCondicion, TM1.MigrLegSiniestrado, TM1.MigrLegId, TM1.MigrLegConvenio, TM1.MigrLegObs, TM1.MigrLegErrores, TM1.MigrLegWarnings, TM1.MigrTieneConyuge, TM1.MigrCantidadHijos, TM1.MigrEncontroOsoSigla, TM1.MigrTraDiurno, TM1.MigrTraNoct, TM1.MigrTraIns, TM1.MigrEncontroOsoAfip, TM1.MigrSueldos, TM1.MigrPeriodo, TM1.MigrLegModalidadDef, TM1.MigrLegZonaDef, TM1.MigrLegSituacionDef, TM1.MigrLegEstadoCivilDef, TM1.MigrLegFormaPagoDef, TM1.MigrLegTipoCuentaDef, TM1.MigrLegActividadDef, TM1.MigrLegCondicionDef, TM1.MigrLegSiniestradoDef, TM1.MigrValCadaSave, TM1.MigrLegFecEgreso, TM1.MigrOtrosDatos, TM1.MigrPuesto, TM1.MigrLegMarcaCCT, TM1.MigrArchSec, TM1.MigrLegActLabClas, TM1.MigrLegPueAfip, TM1.MigrLegHorSem, TM1.CliCod, TM1.EmpCod FROM importacion_legajo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00018", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00019", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000110", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000111", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?  FOR UPDATE OF importacion_legajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000112", "SAVEPOINT gxupdate;INSERT INTO importacion_legajo(MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod, MigrLegAreaDef, MigrLegSCVODef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000113", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegApellido=?, MigrLegNombre=?, MigrLegFecNac=?, MigrLegSexo=?, MigrLegEstadoCivil=?, MigrLegCUIL=?, MigrLegDiscapacidad=?, MigrLegDomici=?, MigrLegEmail=?, MigrLegCodPos=?, MigrLegTelefono=?, MigrLegFecIngreso=?, MigrLegCategoria=?, MigrLegArea=?, MigrLegLugarDePago=?, MigrLegModTra=?, MigrLegTipoTarifa=?, MigrLegClase=?, MigrLegBasico=?, MigrLegFormaPago=?, MigrLegClaseDef=?, MigrLegBanco=?, MigrLegBanSuc=?, MigrLegBanTipCuen=?, MigrLegSindicato=?, MigrLegObraSocial=?, MigrLegOSAfip=?, MigrLegPlanMedico=?, MigrLegActividad=?, MigrLegModalidad=?, MigrLegFecUltMod=?, MigrLegCuentaBanc=?, MigrLegZona=?, MigrLegCBU=?, MigrLegSCVO=?, MigrLegSituacionRevista=?, MigrLegCondicion=?, MigrLegSiniestrado=?, MigrLegId=?, MigrLegConvenio=?, MigrLegObs=?, MigrLegErrores=?, MigrLegWarnings=?, MigrTieneConyuge=?, MigrCantidadHijos=?, MigrEncontroOsoSigla=?, MigrTraDiurno=?, MigrTraNoct=?, MigrTraIns=?, MigrEncontroOsoAfip=?, MigrSueldos=?, MigrPeriodo=?, MigrLegModalidadDef=?, MigrLegZonaDef=?, MigrLegSituacionDef=?, MigrLegEstadoCivilDef=?, MigrLegFormaPagoDef=?, MigrLegTipoCuentaDef=?, MigrLegActividadDef=?, MigrLegCondicionDef=?, MigrLegSiniestradoDef=?, MigrValCadaSave=?, MigrLegFecEgreso=?, MigrOtrosDatos=?, MigrPuesto=?, MigrLegMarcaCCT=?, MigrArchSec=?, MigrLegActLabClas=?, MigrLegPueAfip=?, MigrLegHorSem=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000114", "SAVEPOINT gxupdate;DELETE FROM importacion_legajo  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000115", "SELECT TM1.MigrLegNumero, TM1.MigrLegApellido, TM1.MigrLegNombre, TM1.MigrLegFecNac, TM1.MigrLegSexo, TM1.MigrLegEstadoCivil, TM1.MigrLegCUIL, TM1.MigrLegDiscapacidad, TM1.MigrLegDomici, TM1.MigrLegEmail, TM1.MigrLegCodPos, TM1.MigrLegTelefono, TM1.MigrLegFecIngreso, TM1.MigrLegCategoria, TM1.MigrLegArea, TM1.MigrLegLugarDePago, TM1.MigrLegModTra, TM1.MigrLegTipoTarifa, TM1.MigrLegClase, TM1.MigrLegBasico, TM1.MigrLegFormaPago, TM1.MigrLegClaseDef, TM1.MigrLegBanco, TM1.MigrLegBanSuc, TM1.MigrLegBanTipCuen, TM1.MigrLegSindicato, TM1.MigrLegObraSocial, TM1.MigrLegOSAfip, TM1.MigrLegPlanMedico, TM1.MigrLegActividad, TM1.MigrLegModalidad, TM1.MigrLegFecUltMod, TM1.MigrLegCuentaBanc, TM1.MigrLegZona, TM1.MigrLegCBU, TM1.MigrLegSCVO, TM1.MigrLegSituacionRevista, TM1.MigrLegCondicion, TM1.MigrLegSiniestrado, TM1.MigrLegId, TM1.MigrLegConvenio, TM1.MigrLegObs, TM1.MigrLegErrores, TM1.MigrLegWarnings, TM1.MigrTieneConyuge, TM1.MigrCantidadHijos, TM1.MigrEncontroOsoSigla, TM1.MigrTraDiurno, TM1.MigrTraNoct, TM1.MigrTraIns, TM1.MigrEncontroOsoAfip, TM1.MigrSueldos, TM1.MigrPeriodo, TM1.MigrLegModalidadDef, TM1.MigrLegZonaDef, TM1.MigrLegSituacionDef, TM1.MigrLegEstadoCivilDef, TM1.MigrLegFormaPagoDef, TM1.MigrLegTipoCuentaDef, TM1.MigrLegActividadDef, TM1.MigrLegCondicionDef, TM1.MigrLegSiniestradoDef, TM1.MigrValCadaSave, TM1.MigrLegFecEgreso, TM1.MigrOtrosDatos, TM1.MigrPuesto, TM1.MigrLegMarcaCCT, TM1.MigrArchSec, TM1.MigrLegActLabClas, TM1.MigrLegPueAfip, TM1.MigrLegHorSem, TM1.CliCod, TM1.EmpCod FROM importacion_legajo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000116", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? and MigrLegFamSec = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000117", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000118", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000119", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000120", "SAVEPOINT gxupdate;INSERT INTO importacion_legajoFamilia(EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, MigrLegFamErrores, MigrLegFamWarnings) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000121", "SAVEPOINT gxupdate;UPDATE importacion_legajoFamilia SET MigrLegFamParen=?, MigrLegFamNroDoc=?, MigrLegFamDedGan=?, MigrLegFamAdh=?, MigrLegFamDiscap=?, MigrLegFamNomApe=?, MigrLegFamFecNac=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000122", "SAVEPOINT gxupdate;DELETE FROM importacion_legajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000123", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000124", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000125", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setString(7, (String)parms[6], 13);
               stmt.setString(8, (String)parms[7], 2);
               stmt.setVarchar(9, (String)parms[8], 4000, false);
               stmt.setVarchar(10, (String)parms[9], 100, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setDate(13, (java.util.Date)parms[12]);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 400, false);
               stmt.setVarchar(16, (String)parms[15], 20, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setVarchar(21, (String)parms[20], 400, false);
               stmt.setBoolean(22, ((Boolean) parms[21]).booleanValue());
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setVarchar(24, (String)parms[23], 400, false);
               stmt.setVarchar(25, (String)parms[24], 20, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setVarchar(27, (String)parms[26], 400, false);
               stmt.setString(28, (String)parms[27], 20);
               stmt.setVarchar(29, (String)parms[28], 400, false);
               stmt.setVarchar(30, (String)parms[29], 150, false);
               stmt.setVarchar(31, (String)parms[30], 400, false);
               stmt.setDate(32, (java.util.Date)parms[31]);
               stmt.setVarchar(33, (String)parms[32], 20, false);
               stmt.setVarchar(34, (String)parms[33], 400, false);
               stmt.setVarchar(35, (String)parms[34], 22, false);
               stmt.setString(36, (String)parms[35], 2);
               stmt.setVarchar(37, (String)parms[36], 40, false);
               stmt.setVarchar(38, (String)parms[37], 40, false);
               stmt.setVarchar(39, (String)parms[38], 400, false);
               stmt.setString(40, (String)parms[39], 20);
               stmt.setVarchar(41, (String)parms[40], 400, false);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setNLongVarchar(44, (String)parms[43], false);
               stmt.setString(45, (String)parms[44], 20);
               stmt.setShort(46, ((Number) parms[45]).shortValue());
               stmt.setBoolean(47, ((Boolean) parms[46]).booleanValue());
               stmt.setString(48, (String)parms[47], 2);
               stmt.setString(49, (String)parms[48], 2);
               stmt.setString(50, (String)parms[49], 2);
               stmt.setBoolean(51, ((Boolean) parms[50]).booleanValue());
               stmt.setNLongVarchar(52, (String)parms[51], false);
               stmt.setDate(53, (java.util.Date)parms[52]);
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(59, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(60, ((Boolean) parms[59]).booleanValue());
               stmt.setBoolean(61, ((Boolean) parms[60]).booleanValue());
               stmt.setBoolean(62, ((Boolean) parms[61]).booleanValue());
               stmt.setBoolean(63, ((Boolean) parms[62]).booleanValue());
               stmt.setDate(64, (java.util.Date)parms[63]);
               stmt.setNLongVarchar(65, (String)parms[64], false);
               stmt.setVarchar(66, (String)parms[65], 400, false);
               if ( ((Boolean) parms[66]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(67, (String)parms[67], 1);
               }
               if ( ((Boolean) parms[68]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(68, ((Number) parms[69]).shortValue());
               }
               stmt.setVarchar(69, (String)parms[70], 60, false);
               stmt.setVarchar(70, (String)parms[71], 255, false);
               stmt.setBigDecimal(71, (java.math.BigDecimal)parms[72], 1);
               stmt.setInt(72, ((Number) parms[73]).intValue());
               stmt.setShort(73, ((Number) parms[74]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setString(6, (String)parms[5], 13);
               stmt.setString(7, (String)parms[6], 2);
               stmt.setVarchar(8, (String)parms[7], 4000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setDate(12, (java.util.Date)parms[11]);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 20, false);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setVarchar(20, (String)parms[19], 400, false);
               stmt.setBoolean(21, ((Boolean) parms[20]).booleanValue());
               stmt.setVarchar(22, (String)parms[21], 400, false);
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setVarchar(24, (String)parms[23], 20, false);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setString(27, (String)parms[26], 20);
               stmt.setVarchar(28, (String)parms[27], 400, false);
               stmt.setVarchar(29, (String)parms[28], 150, false);
               stmt.setVarchar(30, (String)parms[29], 400, false);
               stmt.setDate(31, (java.util.Date)parms[30]);
               stmt.setVarchar(32, (String)parms[31], 20, false);
               stmt.setVarchar(33, (String)parms[32], 400, false);
               stmt.setVarchar(34, (String)parms[33], 22, false);
               stmt.setString(35, (String)parms[34], 2);
               stmt.setVarchar(36, (String)parms[35], 40, false);
               stmt.setVarchar(37, (String)parms[36], 40, false);
               stmt.setVarchar(38, (String)parms[37], 400, false);
               stmt.setString(39, (String)parms[38], 20);
               stmt.setVarchar(40, (String)parms[39], 400, false);
               stmt.setNLongVarchar(41, (String)parms[40], false);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setString(44, (String)parms[43], 20);
               stmt.setShort(45, ((Number) parms[44]).shortValue());
               stmt.setBoolean(46, ((Boolean) parms[45]).booleanValue());
               stmt.setString(47, (String)parms[46], 2);
               stmt.setString(48, (String)parms[47], 2);
               stmt.setString(49, (String)parms[48], 2);
               stmt.setBoolean(50, ((Boolean) parms[49]).booleanValue());
               stmt.setNLongVarchar(51, (String)parms[50], false);
               stmt.setDate(52, (java.util.Date)parms[51]);
               stmt.setBoolean(53, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(59, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(60, ((Boolean) parms[59]).booleanValue());
               stmt.setBoolean(61, ((Boolean) parms[60]).booleanValue());
               stmt.setBoolean(62, ((Boolean) parms[61]).booleanValue());
               stmt.setDate(63, (java.util.Date)parms[62]);
               stmt.setNLongVarchar(64, (String)parms[63], false);
               stmt.setVarchar(65, (String)parms[64], 400, false);
               if ( ((Boolean) parms[65]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[66], 1);
               }
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(67, ((Number) parms[68]).shortValue());
               }
               stmt.setVarchar(68, (String)parms[69], 60, false);
               stmt.setVarchar(69, (String)parms[70], 255, false);
               stmt.setBigDecimal(70, (java.math.BigDecimal)parms[71], 1);
               stmt.setInt(71, ((Number) parms[72]).intValue());
               stmt.setShort(72, ((Number) parms[73]).shortValue());
               stmt.setInt(73, ((Number) parms[74]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

