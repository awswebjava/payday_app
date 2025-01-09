package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class estado_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"SITDESCRIPSINAC") == 0 )
      {
         A334SitDescrip = httpContext.GetPar( "SitDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A334SitDescrip", A334SitDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asasitdescripsinac1D46( A334SitDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A1598EstadoSitRevista = (short)(GXutil.lval( httpContext.GetPar( "EstadoSitRevista"))) ;
         n1598EstadoSitRevista = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A1598EstadoSitRevista) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A1600EstadoSiniestro = httpContext.GetPar( "EstadoSiniestro") ;
         n1600EstadoSiniestro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A1600EstadoSiniestro) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A1593SitPaiCod = (short)(GXutil.lval( httpContext.GetPar( "SitPaiCod"))) ;
         n1593SitPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1593SitPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1593SitPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A1593SitPaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7SitCodigo = httpContext.GetPar( "SitCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SitCodigo", AV7SitCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SitCodigo, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Situaciones de revista / Licencias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSitCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public estado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public estado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estado_impl.class ));
   }

   public estado_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkSitEsLicencia = UIFactory.getCheckbox(this);
      chkSitLicCuentaTrab = UIFactory.getCheckbox(this);
      chkSitEsAusencia = UIFactory.getCheckbox(this);
      chkSitAbsorbeFer = UIFactory.getCheckbox(this);
      chkEstadoCanPresen = UIFactory.getCheckbox(this);
      chkEstadoRemCorr = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
      A738SitEsLicencia = GXutil.strtobool( GXutil.booltostr( A738SitEsLicencia)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
      A739SitLicCuentaTrab = GXutil.strtobool( GXutil.booltostr( A739SitLicCuentaTrab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
      A916SitEsAusencia = GXutil.strtobool( GXutil.booltostr( A916SitEsAusencia)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
      A1220SitAbsorbeFer = GXutil.strtobool( GXutil.booltostr( A1220SitAbsorbeFer)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
      A1807EstadoCanPresen = GXutil.strtobool( GXutil.booltostr( A1807EstadoCanPresen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
      A1809EstadoRemCorr = GXutil.strtobool( GXutil.booltostr( A1809EstadoRemCorr)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Estado", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSitCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSitCodigo_Internalname, httpContext.getMessage( "Situacion de Revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSitCodigo_Internalname, GXutil.rtrim( A16SitCodigo), GXutil.rtrim( localUtil.format( A16SitCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSitCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSitCodigo_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSitDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSitDescrip_Internalname, httpContext.getMessage( "Situación de Revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSitDescrip_Internalname, A334SitDescrip, GXutil.rtrim( localUtil.format( A334SitDescrip, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSitDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSitDescrip_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitEsLicencia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSitEsLicencia.getInternalname(), httpContext.getMessage( "Es Licencia", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitEsLicencia.getInternalname(), GXutil.booltostr( A738SitEsLicencia), "", httpContext.getMessage( "Es Licencia", ""), 1, chkSitEsLicencia.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(35, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,35);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSitliccuentatrab_cell_Internalname, 1, 0, "px", 0, "px", divSitliccuentatrab_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkSitLicCuentaTrab.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitLicCuentaTrab.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSitLicCuentaTrab.getInternalname(), httpContext.getMessage( "Con goce de sueldo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitLicCuentaTrab.getInternalname(), GXutil.booltostr( A739SitLicCuentaTrab), "", httpContext.getMessage( "Con goce de sueldo", ""), chkSitLicCuentaTrab.getVisible(), chkSitLicCuentaTrab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(40, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,40);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitEsAusencia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSitEsAusencia.getInternalname(), httpContext.getMessage( "Es Ausencia", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitEsAusencia.getInternalname(), GXutil.booltostr( A916SitEsAusencia), "", httpContext.getMessage( "Es Ausencia", ""), 1, chkSitEsAusencia.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(45, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSitAbsorbeFer.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSitAbsorbeFer.getInternalname(), httpContext.getMessage( "Absorbe feriado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSitAbsorbeFer.getInternalname(), GXutil.booltostr( A1220SitAbsorbeFer), "", httpContext.getMessage( "Absorbe feriado", ""), 1, chkSitAbsorbeFer.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(50, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,50);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEstadoCanPresen.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEstadoCanPresen.getInternalname(), httpContext.getMessage( "Cancela presentismo (para fuera de convenio)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEstadoCanPresen.getInternalname(), GXutil.booltostr( A1807EstadoCanPresen), "", httpContext.getMessage( "Cancela presentismo (para fuera de convenio)", ""), 1, chkEstadoCanPresen.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,55);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEstadoRemCorr.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEstadoRemCorr.getInternalname(), httpContext.getMessage( "Remunera días corridos para jornales", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEstadoRemCorr.getInternalname(), GXutil.booltostr( A1809EstadoRemCorr), "", httpContext.getMessage( "Remunera días corridos para jornales", ""), 1, chkEstadoRemCorr.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(60, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,60);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedestadositrevista_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockestadositrevista_Internalname, httpContext.getMessage( "Situación de revista AFIP", ""), "", "", lblTextblockestadositrevista_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_estadositrevista.setProperty("Caption", Combo_estadositrevista_Caption);
      ucCombo_estadositrevista.setProperty("Cls", Combo_estadositrevista_Cls);
      ucCombo_estadositrevista.setProperty("DataListProc", Combo_estadositrevista_Datalistproc);
      ucCombo_estadositrevista.setProperty("DataListProcParametersPrefix", Combo_estadositrevista_Datalistprocparametersprefix);
      ucCombo_estadositrevista.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_estadositrevista.setProperty("DropDownOptionsData", AV20EstadoSitRevista_Data);
      ucCombo_estadositrevista.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_estadositrevista_Internalname, "COMBO_ESTADOSITREVISTAContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstadoSitRevista_Internalname, httpContext.getMessage( "Situación de revista AFIP", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstadoSitRevista_Internalname, GXutil.ltrim( localUtil.ntoc( A1598EstadoSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1598EstadoSitRevista), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstadoSitRevista_Jsonclick, 0, "Attribute", "", "", "", "", edtEstadoSitRevista_Visible, edtEstadoSitRevista_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedestadosiniestro_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockestadosiniestro_Internalname, httpContext.getMessage( "Siniestrado AFIP", ""), "", "", lblTextblockestadosiniestro_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_estadosiniestro.setProperty("Caption", Combo_estadosiniestro_Caption);
      ucCombo_estadosiniestro.setProperty("Cls", Combo_estadosiniestro_Cls);
      ucCombo_estadosiniestro.setProperty("DataListProc", Combo_estadosiniestro_Datalistproc);
      ucCombo_estadosiniestro.setProperty("DataListProcParametersPrefix", Combo_estadosiniestro_Datalistprocparametersprefix);
      ucCombo_estadosiniestro.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_estadosiniestro.setProperty("DropDownOptionsData", AV27EstadoSiniestro_Data);
      ucCombo_estadosiniestro.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_estadosiniestro_Internalname, "COMBO_ESTADOSINIESTROContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstadoSiniestro_Internalname, httpContext.getMessage( "Siniestrado AFIP", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstadoSiniestro_Internalname, GXutil.rtrim( A1600EstadoSiniestro), GXutil.rtrim( localUtil.format( A1600EstadoSiniestro, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstadoSiniestro_Jsonclick, 0, "Attribute", "", "", "", "", edtEstadoSiniestro_Visible, edtEstadoSiniestro_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_estadositrevista_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboestadositrevista_Internalname, GXutil.ltrim( localUtil.ntoc( AV25ComboEstadoSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboestadositrevista_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboestadositrevista_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboestadositrevista_Visible, edtavComboestadositrevista_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_estadosiniestro_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboestadosiniestro_Internalname, GXutil.rtrim( AV28ComboEstadoSiniestro), GXutil.rtrim( localUtil.format( AV28ComboEstadoSiniestro, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboestadosiniestro_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboestadosiniestro_Visible, edtavComboestadosiniestro_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Estado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vESTADOSITREVISTA_DATA"), AV20EstadoSitRevista_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vESTADOSINIESTRO_DATA"), AV27EstadoSiniestro_Data);
            /* Read saved values. */
            Z16SitCodigo = httpContext.cgiGet( "Z16SitCodigo") ;
            Z685SitDescripSinAc = httpContext.cgiGet( "Z685SitDescripSinAc") ;
            Z334SitDescrip = httpContext.cgiGet( "Z334SitDescrip") ;
            Z738SitEsLicencia = GXutil.strtobool( httpContext.cgiGet( "Z738SitEsLicencia")) ;
            Z739SitLicCuentaTrab = GXutil.strtobool( httpContext.cgiGet( "Z739SitLicCuentaTrab")) ;
            Z897SitLicMesesProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z897SitLicMesesProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z898SitLicMesesProm2 = (byte)(localUtil.ctol( httpContext.cgiGet( "Z898SitLicMesesProm2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z913sItDescAbrev = httpContext.cgiGet( "Z913sItDescAbrev") ;
            Z915SitDiasDivision = localUtil.ctond( httpContext.cgiGet( "Z915SitDiasDivision")) ;
            Z916SitEsAusencia = GXutil.strtobool( httpContext.cgiGet( "Z916SitEsAusencia")) ;
            Z1217SitAplicaPlus = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1217SitAplicaPlus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1220SitAbsorbeFer = GXutil.strtobool( httpContext.cgiGet( "Z1220SitAbsorbeFer")) ;
            Z1489SitLicLimiteDef = (short)(localUtil.ctol( httpContext.cgiGet( "Z1489SitLicLimiteDef"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1490SitLicAdjunDef = GXutil.strtobool( httpContext.cgiGet( "Z1490SitLicAdjunDef")) ;
            Z1491SitLicAdjOblDef = GXutil.strtobool( httpContext.cgiGet( "Z1491SitLicAdjOblDef")) ;
            Z1492SitLicNecApr = GXutil.strtobool( httpContext.cgiGet( "Z1492SitLicNecApr")) ;
            Z1493SitLIcIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1493SitLIcIngMot")) ;
            Z1494SitLicOblIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1494SitLicOblIngMot")) ;
            Z1807EstadoCanPresen = GXutil.strtobool( httpContext.cgiGet( "Z1807EstadoCanPresen")) ;
            Z1809EstadoRemCorr = GXutil.strtobool( httpContext.cgiGet( "Z1809EstadoRemCorr")) ;
            Z1593SitPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1593SitPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1593SitPaiCod = ((0==A1593SitPaiCod) ? true : false) ;
            Z1598EstadoSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( "Z1598EstadoSitRevista"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1598EstadoSitRevista = ((0==A1598EstadoSitRevista) ? true : false) ;
            Z1600EstadoSiniestro = httpContext.cgiGet( "Z1600EstadoSiniestro") ;
            n1600EstadoSiniestro = ((GXutil.strcmp("", A1600EstadoSiniestro)==0) ? true : false) ;
            A685SitDescripSinAc = httpContext.cgiGet( "Z685SitDescripSinAc") ;
            A897SitLicMesesProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z897SitLicMesesProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A898SitLicMesesProm2 = (byte)(localUtil.ctol( httpContext.cgiGet( "Z898SitLicMesesProm2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A913sItDescAbrev = httpContext.cgiGet( "Z913sItDescAbrev") ;
            A915SitDiasDivision = localUtil.ctond( httpContext.cgiGet( "Z915SitDiasDivision")) ;
            A1217SitAplicaPlus = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1217SitAplicaPlus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1489SitLicLimiteDef = (short)(localUtil.ctol( httpContext.cgiGet( "Z1489SitLicLimiteDef"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1490SitLicAdjunDef = GXutil.strtobool( httpContext.cgiGet( "Z1490SitLicAdjunDef")) ;
            A1491SitLicAdjOblDef = GXutil.strtobool( httpContext.cgiGet( "Z1491SitLicAdjOblDef")) ;
            A1492SitLicNecApr = GXutil.strtobool( httpContext.cgiGet( "Z1492SitLicNecApr")) ;
            A1493SitLIcIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1493SitLIcIngMot")) ;
            A1494SitLicOblIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1494SitLicOblIngMot")) ;
            A1593SitPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1593SitPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1593SitPaiCod = false ;
            n1593SitPaiCod = ((0==A1593SitPaiCod) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1593SitPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N1593SitPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1593SitPaiCod = ((0==A1593SitPaiCod) ? true : false) ;
            N1598EstadoSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( "N1598EstadoSitRevista"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1598EstadoSitRevista = ((0==A1598EstadoSitRevista) ? true : false) ;
            N1600EstadoSiniestro = httpContext.cgiGet( "N1600EstadoSiniestro") ;
            n1600EstadoSiniestro = ((GXutil.strcmp("", A1600EstadoSiniestro)==0) ? true : false) ;
            A685SitDescripSinAc = httpContext.cgiGet( "SITDESCRIPSINAC") ;
            AV7SitCodigo = httpContext.cgiGet( "vSITCODIGO") ;
            AV16Insert_SitPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SITPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1593SitPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "SITPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1593SitPaiCod = ((0==A1593SitPaiCod) ? true : false) ;
            AV18Insert_EstadoSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_ESTADOSITREVISTA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV19Insert_EstadoSiniestro = httpContext.cgiGet( "vINSERT_ESTADOSINIESTRO") ;
            A897SitLicMesesProm = (byte)(localUtil.ctol( httpContext.cgiGet( "SITLICMESESPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A898SitLicMesesProm2 = (byte)(localUtil.ctol( httpContext.cgiGet( "SITLICMESESPROM2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A913sItDescAbrev = httpContext.cgiGet( "SITDESCABREV") ;
            A915SitDiasDivision = localUtil.ctond( httpContext.cgiGet( "SITDIASDIVISION")) ;
            A1217SitAplicaPlus = (byte)(localUtil.ctol( httpContext.cgiGet( "SITAPLICAPLUS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1489SitLicLimiteDef = (short)(localUtil.ctol( httpContext.cgiGet( "SITLICLIMITEDEF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1490SitLicAdjunDef = GXutil.strtobool( httpContext.cgiGet( "SITLICADJUNDEF")) ;
            A1491SitLicAdjOblDef = GXutil.strtobool( httpContext.cgiGet( "SITLICADJOBLDEF")) ;
            A1492SitLicNecApr = GXutil.strtobool( httpContext.cgiGet( "SITLICNECAPR")) ;
            A1493SitLIcIngMot = GXutil.strtobool( httpContext.cgiGet( "SITLICINGMOT")) ;
            A1494SitLicOblIngMot = GXutil.strtobool( httpContext.cgiGet( "SITLICOBLINGMOT")) ;
            AV30Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_estadositrevista_Objectcall = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Objectcall") ;
            Combo_estadositrevista_Class = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Class") ;
            Combo_estadositrevista_Icontype = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Icontype") ;
            Combo_estadositrevista_Icon = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Icon") ;
            Combo_estadositrevista_Caption = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Caption") ;
            Combo_estadositrevista_Tooltip = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Tooltip") ;
            Combo_estadositrevista_Cls = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Cls") ;
            Combo_estadositrevista_Selectedvalue_set = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Selectedvalue_set") ;
            Combo_estadositrevista_Selectedvalue_get = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Selectedvalue_get") ;
            Combo_estadositrevista_Selectedtext_set = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Selectedtext_set") ;
            Combo_estadositrevista_Selectedtext_get = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Selectedtext_get") ;
            Combo_estadositrevista_Gamoauthtoken = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Gamoauthtoken") ;
            Combo_estadositrevista_Ddointernalname = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Ddointernalname") ;
            Combo_estadositrevista_Titlecontrolalign = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Titlecontrolalign") ;
            Combo_estadositrevista_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Dropdownoptionstype") ;
            Combo_estadositrevista_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Enabled")) ;
            Combo_estadositrevista_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Visible")) ;
            Combo_estadositrevista_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Titlecontrolidtoreplace") ;
            Combo_estadositrevista_Datalisttype = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Datalisttype") ;
            Combo_estadositrevista_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Allowmultipleselection")) ;
            Combo_estadositrevista_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Datalistfixedvalues") ;
            Combo_estadositrevista_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Isgriditem")) ;
            Combo_estadositrevista_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Hasdescription")) ;
            Combo_estadositrevista_Datalistproc = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Datalistproc") ;
            Combo_estadositrevista_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Datalistprocparametersprefix") ;
            Combo_estadositrevista_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Remoteservicesparameters") ;
            Combo_estadositrevista_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_estadositrevista_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Includeonlyselectedoption")) ;
            Combo_estadositrevista_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Includeselectalloption")) ;
            Combo_estadositrevista_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Emptyitem")) ;
            Combo_estadositrevista_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Includeaddnewoption")) ;
            Combo_estadositrevista_Htmltemplate = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Htmltemplate") ;
            Combo_estadositrevista_Multiplevaluestype = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Multiplevaluestype") ;
            Combo_estadositrevista_Loadingdata = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Loadingdata") ;
            Combo_estadositrevista_Noresultsfound = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Noresultsfound") ;
            Combo_estadositrevista_Emptyitemtext = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Emptyitemtext") ;
            Combo_estadositrevista_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Onlyselectedvalues") ;
            Combo_estadositrevista_Selectalltext = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Selectalltext") ;
            Combo_estadositrevista_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Multiplevaluesseparator") ;
            Combo_estadositrevista_Addnewoptiontext = httpContext.cgiGet( "COMBO_ESTADOSITREVISTA_Addnewoptiontext") ;
            Combo_estadosiniestro_Objectcall = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Objectcall") ;
            Combo_estadosiniestro_Class = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Class") ;
            Combo_estadosiniestro_Icontype = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Icontype") ;
            Combo_estadosiniestro_Icon = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Icon") ;
            Combo_estadosiniestro_Caption = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Caption") ;
            Combo_estadosiniestro_Tooltip = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Tooltip") ;
            Combo_estadosiniestro_Cls = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Cls") ;
            Combo_estadosiniestro_Selectedvalue_set = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Selectedvalue_set") ;
            Combo_estadosiniestro_Selectedvalue_get = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Selectedvalue_get") ;
            Combo_estadosiniestro_Selectedtext_set = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Selectedtext_set") ;
            Combo_estadosiniestro_Selectedtext_get = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Selectedtext_get") ;
            Combo_estadosiniestro_Gamoauthtoken = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Gamoauthtoken") ;
            Combo_estadosiniestro_Ddointernalname = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Ddointernalname") ;
            Combo_estadosiniestro_Titlecontrolalign = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Titlecontrolalign") ;
            Combo_estadosiniestro_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Dropdownoptionstype") ;
            Combo_estadosiniestro_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Enabled")) ;
            Combo_estadosiniestro_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Visible")) ;
            Combo_estadosiniestro_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Titlecontrolidtoreplace") ;
            Combo_estadosiniestro_Datalisttype = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Datalisttype") ;
            Combo_estadosiniestro_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Allowmultipleselection")) ;
            Combo_estadosiniestro_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Datalistfixedvalues") ;
            Combo_estadosiniestro_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Isgriditem")) ;
            Combo_estadosiniestro_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Hasdescription")) ;
            Combo_estadosiniestro_Datalistproc = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Datalistproc") ;
            Combo_estadosiniestro_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Datalistprocparametersprefix") ;
            Combo_estadosiniestro_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Remoteservicesparameters") ;
            Combo_estadosiniestro_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_estadosiniestro_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Includeonlyselectedoption")) ;
            Combo_estadosiniestro_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Includeselectalloption")) ;
            Combo_estadosiniestro_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Emptyitem")) ;
            Combo_estadosiniestro_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Includeaddnewoption")) ;
            Combo_estadosiniestro_Htmltemplate = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Htmltemplate") ;
            Combo_estadosiniestro_Multiplevaluestype = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Multiplevaluestype") ;
            Combo_estadosiniestro_Loadingdata = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Loadingdata") ;
            Combo_estadosiniestro_Noresultsfound = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Noresultsfound") ;
            Combo_estadosiniestro_Emptyitemtext = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Emptyitemtext") ;
            Combo_estadosiniestro_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Onlyselectedvalues") ;
            Combo_estadosiniestro_Selectalltext = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Selectalltext") ;
            Combo_estadosiniestro_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Multiplevaluesseparator") ;
            Combo_estadosiniestro_Addnewoptiontext = httpContext.cgiGet( "COMBO_ESTADOSINIESTRO_Addnewoptiontext") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A16SitCodigo = httpContext.cgiGet( edtSitCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
            A334SitDescrip = GXutil.upper( httpContext.cgiGet( edtSitDescrip_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A334SitDescrip", A334SitDescrip);
            A738SitEsLicencia = GXutil.strtobool( httpContext.cgiGet( chkSitEsLicencia.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
            A739SitLicCuentaTrab = GXutil.strtobool( httpContext.cgiGet( chkSitLicCuentaTrab.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
            A916SitEsAusencia = GXutil.strtobool( httpContext.cgiGet( chkSitEsAusencia.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
            A1220SitAbsorbeFer = GXutil.strtobool( httpContext.cgiGet( chkSitAbsorbeFer.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
            A1807EstadoCanPresen = GXutil.strtobool( httpContext.cgiGet( chkEstadoCanPresen.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
            A1809EstadoRemCorr = GXutil.strtobool( httpContext.cgiGet( chkEstadoRemCorr.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEstadoSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEstadoSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ESTADOSITREVISTA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEstadoSitRevista_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1598EstadoSitRevista = (short)(0) ;
               n1598EstadoSitRevista = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
            }
            else
            {
               A1598EstadoSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( edtEstadoSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1598EstadoSitRevista = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
            }
            n1598EstadoSitRevista = ((0==A1598EstadoSitRevista) ? true : false) ;
            A1600EstadoSiniestro = httpContext.cgiGet( edtEstadoSiniestro_Internalname) ;
            n1600EstadoSiniestro = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
            n1600EstadoSiniestro = ((GXutil.strcmp("", A1600EstadoSiniestro)==0) ? true : false) ;
            AV25ComboEstadoSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboestadositrevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), 3, 0));
            AV28ComboEstadoSiniestro = httpContext.cgiGet( edtavComboestadosiniestro_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28ComboEstadoSiniestro", AV28ComboEstadoSiniestro);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Estado");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SitLicMesesProm", localUtil.format( DecimalUtil.doubleToDec(A897SitLicMesesProm), "Z9"));
            forbiddenHiddens.add("SitLicMesesProm2", localUtil.format( DecimalUtil.doubleToDec(A898SitLicMesesProm2), "Z9"));
            forbiddenHiddens.add("sItDescAbrev", GXutil.rtrim( localUtil.format( A913sItDescAbrev, "@!")));
            forbiddenHiddens.add("SitDiasDivision", localUtil.format( A915SitDiasDivision, "Z9.9"));
            forbiddenHiddens.add("SitAplicaPlus", localUtil.format( DecimalUtil.doubleToDec(A1217SitAplicaPlus), "9"));
            forbiddenHiddens.add("SitLicLimiteDef", localUtil.format( DecimalUtil.doubleToDec(A1489SitLicLimiteDef), "ZZZ9"));
            forbiddenHiddens.add("SitLicAdjunDef", GXutil.booltostr( A1490SitLicAdjunDef));
            forbiddenHiddens.add("SitLicAdjOblDef", GXutil.booltostr( A1491SitLicAdjOblDef));
            forbiddenHiddens.add("SitLicNecApr", GXutil.booltostr( A1492SitLicNecApr));
            forbiddenHiddens.add("SitLIcIngMot", GXutil.booltostr( A1493SitLIcIngMot));
            forbiddenHiddens.add("SitLicOblIngMot", GXutil.booltostr( A1494SitLicOblIngMot));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("estado:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A16SitCodigo = httpContext.GetPar( "SitCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode46 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode46 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound46 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1D0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SITCODIGO");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSitCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e111D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
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
         e121D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1D46( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
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

   public void disable_std_buttons( )
   {
      if ( isDsp( ) || isDlt( ) )
      {
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1D46( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadositrevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadositrevista_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadosiniestro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadosiniestro_Enabled), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_1D0( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1D46( ) ;
         }
         else
         {
            checkExtendedTable1D46( ) ;
            closeExtendedTableCursors1D46( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1D0( )
   {
   }

   public void e111D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtEstadoSiniestro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstadoSiniestro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSiniestro_Visible), 5, 0), true);
      AV28ComboEstadoSiniestro = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboEstadoSiniestro", AV28ComboEstadoSiniestro);
      edtavComboestadosiniestro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadosiniestro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadosiniestro_Visible), 5, 0), true);
      edtEstadoSitRevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstadoSitRevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSitRevista_Visible), 5, 0), true);
      AV25ComboEstadoSitRevista = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), 3, 0));
      edtavComboestadositrevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadositrevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadositrevista_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOESTADOSITREVISTA' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOESTADOSINIESTRO' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Insert", GXv_boolean5) ;
         estado_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Update", GXv_boolean5) ;
         estado_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Delete", GXv_boolean5) ;
         estado_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV30Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV30Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV31GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GXV1), 8, 0));
         while ( AV31GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV31GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SitPaiCod") == 0 )
            {
               AV16Insert_SitPaiCod = (short)(GXutil.lval( AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_SitPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_SitPaiCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EstadoSitRevista") == 0 )
            {
               AV18Insert_EstadoSitRevista = (short)(GXutil.lval( AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18Insert_EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18Insert_EstadoSitRevista), 3, 0));
               if ( ! (0==AV18Insert_EstadoSitRevista) )
               {
                  AV25ComboEstadoSitRevista = AV18Insert_EstadoSitRevista ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), 3, 0));
                  Combo_estadositrevista_Selectedvalue_set = GXutil.trim( GXutil.str( AV25ComboEstadoSitRevista, 3, 0)) ;
                  ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "SelectedValue_set", Combo_estadositrevista_Selectedvalue_set);
                  GXt_char6 = AV24Combo_DataJson ;
                  GXv_char7[0] = AV22ComboSelectedValue ;
                  GXv_char8[0] = AV23ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSitRevista", "GET", false, AV7SitCodigo, AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  estado_impl.this.AV22ComboSelectedValue = GXv_char7[0] ;
                  estado_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
                  estado_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
                  AV24Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
                  Combo_estadositrevista_Selectedtext_set = AV23ComboSelectedText ;
                  ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "SelectedText_set", Combo_estadositrevista_Selectedtext_set);
                  Combo_estadositrevista_Enabled = false ;
                  ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "Enabled", GXutil.booltostr( Combo_estadositrevista_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EstadoSiniestro") == 0 )
            {
               AV19Insert_EstadoSiniestro = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV19Insert_EstadoSiniestro", AV19Insert_EstadoSiniestro);
               if ( ! (GXutil.strcmp("", AV19Insert_EstadoSiniestro)==0) )
               {
                  AV28ComboEstadoSiniestro = AV19Insert_EstadoSiniestro ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV28ComboEstadoSiniestro", AV28ComboEstadoSiniestro);
                  Combo_estadosiniestro_Selectedvalue_set = AV28ComboEstadoSiniestro ;
                  ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "SelectedValue_set", Combo_estadosiniestro_Selectedvalue_set);
                  GXt_char6 = AV24Combo_DataJson ;
                  GXv_char9[0] = AV22ComboSelectedValue ;
                  GXv_char8[0] = AV23ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSiniestro", "GET", false, AV7SitCodigo, AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  estado_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
                  estado_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
                  estado_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
                  AV24Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
                  Combo_estadosiniestro_Selectedtext_set = AV23ComboSelectedText ;
                  ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "SelectedText_set", Combo_estadosiniestro_Selectedtext_set);
                  Combo_estadosiniestro_Enabled = false ;
                  ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "Enabled", GXutil.booltostr( Combo_estadosiniestro_Enabled));
               }
            }
            AV31GXV1 = (int)(AV31GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GXV1), 8, 0));
         }
      }
   }

   public void e121D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      chkSitLicCuentaTrab.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
      divSitliccuentatrab_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOESTADOSINIESTRO' Routine */
      returnInSub = false ;
      GXt_char6 = AV24Combo_DataJson ;
      GXv_char9[0] = AV22ComboSelectedValue ;
      GXv_char8[0] = AV23ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSiniestro", Gx_mode, false, AV7SitCodigo, "", GXv_char9, GXv_char8, GXv_char7) ;
      estado_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
      estado_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
      estado_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
      AV24Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
      Combo_estadosiniestro_Selectedvalue_set = AV22ComboSelectedValue ;
      ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "SelectedValue_set", Combo_estadosiniestro_Selectedvalue_set);
      Combo_estadosiniestro_Selectedtext_set = AV23ComboSelectedText ;
      ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "SelectedText_set", Combo_estadosiniestro_Selectedtext_set);
      AV28ComboEstadoSiniestro = AV22ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboEstadoSiniestro", AV28ComboEstadoSiniestro);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_estadosiniestro_Enabled = false ;
         ucCombo_estadosiniestro.sendProperty(context, "", false, Combo_estadosiniestro_Internalname, "Enabled", GXutil.booltostr( Combo_estadosiniestro_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOESTADOSITREVISTA' Routine */
      returnInSub = false ;
      GXt_char6 = AV24Combo_DataJson ;
      GXv_char9[0] = AV22ComboSelectedValue ;
      GXv_char8[0] = AV23ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.estadoloaddvcombo(remoteHandle, context).execute( "EstadoSitRevista", Gx_mode, false, AV7SitCodigo, "", GXv_char9, GXv_char8, GXv_char7) ;
      estado_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
      estado_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
      estado_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
      AV24Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
      Combo_estadositrevista_Selectedvalue_set = AV22ComboSelectedValue ;
      ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "SelectedValue_set", Combo_estadositrevista_Selectedvalue_set);
      Combo_estadositrevista_Selectedtext_set = AV23ComboSelectedText ;
      ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "SelectedText_set", Combo_estadositrevista_Selectedtext_set);
      AV25ComboEstadoSitRevista = (short)(GXutil.lval( AV22ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEstadoSitRevista), 3, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_estadositrevista_Enabled = false ;
         ucCombo_estadositrevista.sendProperty(context, "", false, Combo_estadositrevista_Internalname, "Enabled", GXutil.booltostr( Combo_estadositrevista_Enabled));
      }
   }

   public void zm1D46( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z685SitDescripSinAc = T001D3_A685SitDescripSinAc[0] ;
            Z334SitDescrip = T001D3_A334SitDescrip[0] ;
            Z738SitEsLicencia = T001D3_A738SitEsLicencia[0] ;
            Z739SitLicCuentaTrab = T001D3_A739SitLicCuentaTrab[0] ;
            Z897SitLicMesesProm = T001D3_A897SitLicMesesProm[0] ;
            Z898SitLicMesesProm2 = T001D3_A898SitLicMesesProm2[0] ;
            Z913sItDescAbrev = T001D3_A913sItDescAbrev[0] ;
            Z915SitDiasDivision = T001D3_A915SitDiasDivision[0] ;
            Z916SitEsAusencia = T001D3_A916SitEsAusencia[0] ;
            Z1217SitAplicaPlus = T001D3_A1217SitAplicaPlus[0] ;
            Z1220SitAbsorbeFer = T001D3_A1220SitAbsorbeFer[0] ;
            Z1489SitLicLimiteDef = T001D3_A1489SitLicLimiteDef[0] ;
            Z1490SitLicAdjunDef = T001D3_A1490SitLicAdjunDef[0] ;
            Z1491SitLicAdjOblDef = T001D3_A1491SitLicAdjOblDef[0] ;
            Z1492SitLicNecApr = T001D3_A1492SitLicNecApr[0] ;
            Z1493SitLIcIngMot = T001D3_A1493SitLIcIngMot[0] ;
            Z1494SitLicOblIngMot = T001D3_A1494SitLicOblIngMot[0] ;
            Z1807EstadoCanPresen = T001D3_A1807EstadoCanPresen[0] ;
            Z1809EstadoRemCorr = T001D3_A1809EstadoRemCorr[0] ;
            Z1593SitPaiCod = T001D3_A1593SitPaiCod[0] ;
            Z1598EstadoSitRevista = T001D3_A1598EstadoSitRevista[0] ;
            Z1600EstadoSiniestro = T001D3_A1600EstadoSiniestro[0] ;
         }
         else
         {
            Z685SitDescripSinAc = A685SitDescripSinAc ;
            Z334SitDescrip = A334SitDescrip ;
            Z738SitEsLicencia = A738SitEsLicencia ;
            Z739SitLicCuentaTrab = A739SitLicCuentaTrab ;
            Z897SitLicMesesProm = A897SitLicMesesProm ;
            Z898SitLicMesesProm2 = A898SitLicMesesProm2 ;
            Z913sItDescAbrev = A913sItDescAbrev ;
            Z915SitDiasDivision = A915SitDiasDivision ;
            Z916SitEsAusencia = A916SitEsAusencia ;
            Z1217SitAplicaPlus = A1217SitAplicaPlus ;
            Z1220SitAbsorbeFer = A1220SitAbsorbeFer ;
            Z1489SitLicLimiteDef = A1489SitLicLimiteDef ;
            Z1490SitLicAdjunDef = A1490SitLicAdjunDef ;
            Z1491SitLicAdjOblDef = A1491SitLicAdjOblDef ;
            Z1492SitLicNecApr = A1492SitLicNecApr ;
            Z1493SitLIcIngMot = A1493SitLIcIngMot ;
            Z1494SitLicOblIngMot = A1494SitLicOblIngMot ;
            Z1807EstadoCanPresen = A1807EstadoCanPresen ;
            Z1809EstadoRemCorr = A1809EstadoRemCorr ;
            Z1593SitPaiCod = A1593SitPaiCod ;
            Z1598EstadoSitRevista = A1598EstadoSitRevista ;
            Z1600EstadoSiniestro = A1600EstadoSiniestro ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z685SitDescripSinAc = A685SitDescripSinAc ;
         Z16SitCodigo = A16SitCodigo ;
         Z334SitDescrip = A334SitDescrip ;
         Z738SitEsLicencia = A738SitEsLicencia ;
         Z739SitLicCuentaTrab = A739SitLicCuentaTrab ;
         Z897SitLicMesesProm = A897SitLicMesesProm ;
         Z898SitLicMesesProm2 = A898SitLicMesesProm2 ;
         Z913sItDescAbrev = A913sItDescAbrev ;
         Z915SitDiasDivision = A915SitDiasDivision ;
         Z916SitEsAusencia = A916SitEsAusencia ;
         Z1217SitAplicaPlus = A1217SitAplicaPlus ;
         Z1220SitAbsorbeFer = A1220SitAbsorbeFer ;
         Z1489SitLicLimiteDef = A1489SitLicLimiteDef ;
         Z1490SitLicAdjunDef = A1490SitLicAdjunDef ;
         Z1491SitLicAdjOblDef = A1491SitLicAdjOblDef ;
         Z1492SitLicNecApr = A1492SitLicNecApr ;
         Z1493SitLIcIngMot = A1493SitLIcIngMot ;
         Z1494SitLicOblIngMot = A1494SitLicOblIngMot ;
         Z1807EstadoCanPresen = A1807EstadoCanPresen ;
         Z1809EstadoRemCorr = A1809EstadoRemCorr ;
         Z1593SitPaiCod = A1593SitPaiCod ;
         Z1598EstadoSitRevista = A1598EstadoSitRevista ;
         Z1600EstadoSiniestro = A1600EstadoSiniestro ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( ! (GXutil.strcmp("", AV7SitCodigo)==0) )
      {
         A16SitCodigo = AV7SitCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
      }
      if ( ! (GXutil.strcmp("", AV7SitCodigo)==0) )
      {
         edtSitCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSitCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSitCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSitCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSitCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSitCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SitCodigo)==0) )
      {
         edtSitCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSitCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSitCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_EstadoSitRevista) )
      {
         edtEstadoSitRevista_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstadoSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSitRevista_Enabled), 5, 0), true);
      }
      else
      {
         edtEstadoSitRevista_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstadoSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSitRevista_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV19Insert_EstadoSiniestro)==0) )
      {
         edtEstadoSiniestro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstadoSiniestro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSiniestro_Enabled), 5, 0), true);
      }
      else
      {
         edtEstadoSiniestro_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstadoSiniestro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSiniestro_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_SitPaiCod) )
      {
         A1593SitPaiCod = AV16Insert_SitPaiCod ;
         n1593SitPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1593SitPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1593SitPaiCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_EstadoSitRevista) )
      {
         A1598EstadoSitRevista = AV18Insert_EstadoSitRevista ;
         n1598EstadoSitRevista = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
      }
      else
      {
         if ( (0==AV25ComboEstadoSitRevista) )
         {
            A1598EstadoSitRevista = (short)(0) ;
            n1598EstadoSitRevista = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
            n1598EstadoSitRevista = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
         }
         else
         {
            if ( ! (0==AV25ComboEstadoSitRevista) )
            {
               A1598EstadoSitRevista = AV25ComboEstadoSitRevista ;
               n1598EstadoSitRevista = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV19Insert_EstadoSiniestro)==0) )
      {
         A1600EstadoSiniestro = AV19Insert_EstadoSiniestro ;
         n1600EstadoSiniestro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
      }
      else
      {
         if ( (GXutil.strcmp("", AV28ComboEstadoSiniestro)==0) )
         {
            A1600EstadoSiniestro = "" ;
            n1600EstadoSiniestro = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
            n1600EstadoSiniestro = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV28ComboEstadoSiniestro)==0) )
            {
               A1600EstadoSiniestro = AV28ComboEstadoSiniestro ;
               n1600EstadoSiniestro = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
            }
         }
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV30Pgmname = "Estado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      }
   }

   public void load1D46( )
   {
      /* Using cursor T001D7 */
      pr_default.execute(5, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = T001D7_A685SitDescripSinAc[0] ;
         A334SitDescrip = T001D7_A334SitDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A334SitDescrip", A334SitDescrip);
         A738SitEsLicencia = T001D7_A738SitEsLicencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
         A739SitLicCuentaTrab = T001D7_A739SitLicCuentaTrab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
         A897SitLicMesesProm = T001D7_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = T001D7_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = T001D7_A913sItDescAbrev[0] ;
         A915SitDiasDivision = T001D7_A915SitDiasDivision[0] ;
         A916SitEsAusencia = T001D7_A916SitEsAusencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
         A1217SitAplicaPlus = T001D7_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = T001D7_A1220SitAbsorbeFer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
         A1489SitLicLimiteDef = T001D7_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = T001D7_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = T001D7_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = T001D7_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = T001D7_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = T001D7_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = T001D7_A1807EstadoCanPresen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
         A1809EstadoRemCorr = T001D7_A1809EstadoRemCorr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
         A1593SitPaiCod = T001D7_A1593SitPaiCod[0] ;
         n1593SitPaiCod = T001D7_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = T001D7_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = T001D7_n1598EstadoSitRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
         A1600EstadoSiniestro = T001D7_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = T001D7_n1600EstadoSiniestro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
         zm1D46( -17) ;
      }
      pr_default.close(5);
      onLoadActions1D46( ) ;
   }

   public void onLoadActions1D46( )
   {
      AV30Pgmname = "Estado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      GXt_char6 = A685SitDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char9) ;
      estado_impl.this.GXt_char6 = GXv_char9[0] ;
      A685SitDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A685SitDescripSinAc", A685SitDescripSinAc);
      chkSitLicCuentaTrab.setVisible( ((A738SitEsLicencia) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
      if ( ! ( ( A738SitEsLicencia ) ) )
      {
         divSitliccuentatrab_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
      }
      else
      {
         if ( A738SitEsLicencia )
         {
            divSitliccuentatrab_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable1D46( )
   {
      nIsDirty_46 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV30Pgmname = "Estado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      nIsDirty_46 = (short)(1) ;
      GXt_char6 = A685SitDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char9) ;
      estado_impl.this.GXt_char6 = GXv_char9[0] ;
      A685SitDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A685SitDescripSinAc", A685SitDescripSinAc);
      chkSitLicCuentaTrab.setVisible( ((A738SitEsLicencia) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
      if ( ! ( ( A738SitEsLicencia ) ) )
      {
         divSitliccuentatrab_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
      }
      else
      {
         if ( A738SitEsLicencia )
         {
            divSitliccuentatrab_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
         }
      }
      /* Using cursor T001D5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A1598EstadoSitRevista) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Situacion Revista", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSITREVISTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSitRevista_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      /* Using cursor T001D6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1600EstadoSiniestro)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Siniestro Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSINIESTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSiniestro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(4);
      /* Using cursor T001D4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A1593SitPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SITPAICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors1D46( )
   {
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( short A1598EstadoSitRevista )
   {
      /* Using cursor T001D8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A1598EstadoSitRevista) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Situacion Revista", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSITREVISTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSitRevista_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_20( String A1600EstadoSiniestro )
   {
      /* Using cursor T001D9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1600EstadoSiniestro)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Siniestro Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSINIESTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSiniestro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_18( short A1593SitPaiCod )
   {
      /* Using cursor T001D10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A1593SitPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SITPAICOD");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey1D46( )
   {
      /* Using cursor T001D11 */
      pr_default.execute(9, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound46 = (short)(1) ;
      }
      else
      {
         RcdFound46 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001D3 */
      pr_default.execute(1, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1D46( 17) ;
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = T001D3_A685SitDescripSinAc[0] ;
         A16SitCodigo = T001D3_A16SitCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
         A334SitDescrip = T001D3_A334SitDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A334SitDescrip", A334SitDescrip);
         A738SitEsLicencia = T001D3_A738SitEsLicencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
         A739SitLicCuentaTrab = T001D3_A739SitLicCuentaTrab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
         A897SitLicMesesProm = T001D3_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = T001D3_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = T001D3_A913sItDescAbrev[0] ;
         A915SitDiasDivision = T001D3_A915SitDiasDivision[0] ;
         A916SitEsAusencia = T001D3_A916SitEsAusencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
         A1217SitAplicaPlus = T001D3_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = T001D3_A1220SitAbsorbeFer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
         A1489SitLicLimiteDef = T001D3_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = T001D3_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = T001D3_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = T001D3_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = T001D3_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = T001D3_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = T001D3_A1807EstadoCanPresen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
         A1809EstadoRemCorr = T001D3_A1809EstadoRemCorr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
         A1593SitPaiCod = T001D3_A1593SitPaiCod[0] ;
         n1593SitPaiCod = T001D3_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = T001D3_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = T001D3_n1598EstadoSitRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
         A1600EstadoSiniestro = T001D3_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = T001D3_n1600EstadoSiniestro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
         Z16SitCodigo = A16SitCodigo ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1D46( ) ;
         if ( AnyError == 1 )
         {
            RcdFound46 = (short)(0) ;
            initializeNonKey1D46( ) ;
         }
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound46 = (short)(0) ;
         initializeNonKey1D46( ) ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1D46( ) ;
      if ( RcdFound46 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T001D12 */
      pr_default.execute(10, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( GXutil.strcmp(T001D12_A16SitCodigo[0], A16SitCodigo) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( GXutil.strcmp(T001D12_A16SitCodigo[0], A16SitCodigo) > 0 ) ) )
         {
            A16SitCodigo = T001D12_A16SitCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T001D13 */
      pr_default.execute(11, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( GXutil.strcmp(T001D13_A16SitCodigo[0], A16SitCodigo) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( GXutil.strcmp(T001D13_A16SitCodigo[0], A16SitCodigo) < 0 ) ) )
         {
            A16SitCodigo = T001D13_A16SitCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1D46( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSitCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1D46( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound46 == 1 )
         {
            if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
            {
               A16SitCodigo = Z16SitCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SITCODIGO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSitCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSitCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1D46( ) ;
               GX_FocusControl = edtSitCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtSitCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1D46( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SITCODIGO");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSitCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSitCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1D46( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
      {
         A16SitCodigo = Z16SitCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSitCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSitCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1D46( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001D2 */
         pr_default.execute(0, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z685SitDescripSinAc, T001D2_A685SitDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z334SitDescrip, T001D2_A334SitDescrip[0]) != 0 ) || ( Z738SitEsLicencia != T001D2_A738SitEsLicencia[0] ) || ( Z739SitLicCuentaTrab != T001D2_A739SitLicCuentaTrab[0] ) || ( Z897SitLicMesesProm != T001D2_A897SitLicMesesProm[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z898SitLicMesesProm2 != T001D2_A898SitLicMesesProm2[0] ) || ( GXutil.strcmp(Z913sItDescAbrev, T001D2_A913sItDescAbrev[0]) != 0 ) || ( DecimalUtil.compareTo(Z915SitDiasDivision, T001D2_A915SitDiasDivision[0]) != 0 ) || ( Z916SitEsAusencia != T001D2_A916SitEsAusencia[0] ) || ( Z1217SitAplicaPlus != T001D2_A1217SitAplicaPlus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1220SitAbsorbeFer != T001D2_A1220SitAbsorbeFer[0] ) || ( Z1489SitLicLimiteDef != T001D2_A1489SitLicLimiteDef[0] ) || ( Z1490SitLicAdjunDef != T001D2_A1490SitLicAdjunDef[0] ) || ( Z1491SitLicAdjOblDef != T001D2_A1491SitLicAdjOblDef[0] ) || ( Z1492SitLicNecApr != T001D2_A1492SitLicNecApr[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1493SitLIcIngMot != T001D2_A1493SitLIcIngMot[0] ) || ( Z1494SitLicOblIngMot != T001D2_A1494SitLicOblIngMot[0] ) || ( Z1807EstadoCanPresen != T001D2_A1807EstadoCanPresen[0] ) || ( Z1809EstadoRemCorr != T001D2_A1809EstadoRemCorr[0] ) || ( Z1593SitPaiCod != T001D2_A1593SitPaiCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1598EstadoSitRevista != T001D2_A1598EstadoSitRevista[0] ) || ( GXutil.strcmp(Z1600EstadoSiniestro, T001D2_A1600EstadoSiniestro[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z685SitDescripSinAc, T001D2_A685SitDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z685SitDescripSinAc);
               GXutil.writeLogRaw("Current: ",T001D2_A685SitDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z334SitDescrip, T001D2_A334SitDescrip[0]) != 0 )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitDescrip");
               GXutil.writeLogRaw("Old: ",Z334SitDescrip);
               GXutil.writeLogRaw("Current: ",T001D2_A334SitDescrip[0]);
            }
            if ( Z738SitEsLicencia != T001D2_A738SitEsLicencia[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitEsLicencia");
               GXutil.writeLogRaw("Old: ",Z738SitEsLicencia);
               GXutil.writeLogRaw("Current: ",T001D2_A738SitEsLicencia[0]);
            }
            if ( Z739SitLicCuentaTrab != T001D2_A739SitLicCuentaTrab[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicCuentaTrab");
               GXutil.writeLogRaw("Old: ",Z739SitLicCuentaTrab);
               GXutil.writeLogRaw("Current: ",T001D2_A739SitLicCuentaTrab[0]);
            }
            if ( Z897SitLicMesesProm != T001D2_A897SitLicMesesProm[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicMesesProm");
               GXutil.writeLogRaw("Old: ",Z897SitLicMesesProm);
               GXutil.writeLogRaw("Current: ",T001D2_A897SitLicMesesProm[0]);
            }
            if ( Z898SitLicMesesProm2 != T001D2_A898SitLicMesesProm2[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicMesesProm2");
               GXutil.writeLogRaw("Old: ",Z898SitLicMesesProm2);
               GXutil.writeLogRaw("Current: ",T001D2_A898SitLicMesesProm2[0]);
            }
            if ( GXutil.strcmp(Z913sItDescAbrev, T001D2_A913sItDescAbrev[0]) != 0 )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"sItDescAbrev");
               GXutil.writeLogRaw("Old: ",Z913sItDescAbrev);
               GXutil.writeLogRaw("Current: ",T001D2_A913sItDescAbrev[0]);
            }
            if ( DecimalUtil.compareTo(Z915SitDiasDivision, T001D2_A915SitDiasDivision[0]) != 0 )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitDiasDivision");
               GXutil.writeLogRaw("Old: ",Z915SitDiasDivision);
               GXutil.writeLogRaw("Current: ",T001D2_A915SitDiasDivision[0]);
            }
            if ( Z916SitEsAusencia != T001D2_A916SitEsAusencia[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitEsAusencia");
               GXutil.writeLogRaw("Old: ",Z916SitEsAusencia);
               GXutil.writeLogRaw("Current: ",T001D2_A916SitEsAusencia[0]);
            }
            if ( Z1217SitAplicaPlus != T001D2_A1217SitAplicaPlus[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitAplicaPlus");
               GXutil.writeLogRaw("Old: ",Z1217SitAplicaPlus);
               GXutil.writeLogRaw("Current: ",T001D2_A1217SitAplicaPlus[0]);
            }
            if ( Z1220SitAbsorbeFer != T001D2_A1220SitAbsorbeFer[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitAbsorbeFer");
               GXutil.writeLogRaw("Old: ",Z1220SitAbsorbeFer);
               GXutil.writeLogRaw("Current: ",T001D2_A1220SitAbsorbeFer[0]);
            }
            if ( Z1489SitLicLimiteDef != T001D2_A1489SitLicLimiteDef[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicLimiteDef");
               GXutil.writeLogRaw("Old: ",Z1489SitLicLimiteDef);
               GXutil.writeLogRaw("Current: ",T001D2_A1489SitLicLimiteDef[0]);
            }
            if ( Z1490SitLicAdjunDef != T001D2_A1490SitLicAdjunDef[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicAdjunDef");
               GXutil.writeLogRaw("Old: ",Z1490SitLicAdjunDef);
               GXutil.writeLogRaw("Current: ",T001D2_A1490SitLicAdjunDef[0]);
            }
            if ( Z1491SitLicAdjOblDef != T001D2_A1491SitLicAdjOblDef[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicAdjOblDef");
               GXutil.writeLogRaw("Old: ",Z1491SitLicAdjOblDef);
               GXutil.writeLogRaw("Current: ",T001D2_A1491SitLicAdjOblDef[0]);
            }
            if ( Z1492SitLicNecApr != T001D2_A1492SitLicNecApr[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicNecApr");
               GXutil.writeLogRaw("Old: ",Z1492SitLicNecApr);
               GXutil.writeLogRaw("Current: ",T001D2_A1492SitLicNecApr[0]);
            }
            if ( Z1493SitLIcIngMot != T001D2_A1493SitLIcIngMot[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLIcIngMot");
               GXutil.writeLogRaw("Old: ",Z1493SitLIcIngMot);
               GXutil.writeLogRaw("Current: ",T001D2_A1493SitLIcIngMot[0]);
            }
            if ( Z1494SitLicOblIngMot != T001D2_A1494SitLicOblIngMot[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitLicOblIngMot");
               GXutil.writeLogRaw("Old: ",Z1494SitLicOblIngMot);
               GXutil.writeLogRaw("Current: ",T001D2_A1494SitLicOblIngMot[0]);
            }
            if ( Z1807EstadoCanPresen != T001D2_A1807EstadoCanPresen[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"EstadoCanPresen");
               GXutil.writeLogRaw("Old: ",Z1807EstadoCanPresen);
               GXutil.writeLogRaw("Current: ",T001D2_A1807EstadoCanPresen[0]);
            }
            if ( Z1809EstadoRemCorr != T001D2_A1809EstadoRemCorr[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"EstadoRemCorr");
               GXutil.writeLogRaw("Old: ",Z1809EstadoRemCorr);
               GXutil.writeLogRaw("Current: ",T001D2_A1809EstadoRemCorr[0]);
            }
            if ( Z1593SitPaiCod != T001D2_A1593SitPaiCod[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"SitPaiCod");
               GXutil.writeLogRaw("Old: ",Z1593SitPaiCod);
               GXutil.writeLogRaw("Current: ",T001D2_A1593SitPaiCod[0]);
            }
            if ( Z1598EstadoSitRevista != T001D2_A1598EstadoSitRevista[0] )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"EstadoSitRevista");
               GXutil.writeLogRaw("Old: ",Z1598EstadoSitRevista);
               GXutil.writeLogRaw("Current: ",T001D2_A1598EstadoSitRevista[0]);
            }
            if ( GXutil.strcmp(Z1600EstadoSiniestro, T001D2_A1600EstadoSiniestro[0]) != 0 )
            {
               GXutil.writeLogln("estado:[seudo value changed for attri]"+"EstadoSiniestro");
               GXutil.writeLogRaw("Old: ",Z1600EstadoSiniestro);
               GXutil.writeLogRaw("Current: ",T001D2_A1600EstadoSiniestro[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Estado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1D46( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1D46( 0) ;
         checkOptimisticConcurrency1D46( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1D46( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1D46( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001D14 */
                  pr_default.execute(12, new Object[] {A685SitDescripSinAc, A16SitCodigo, A334SitDescrip, Boolean.valueOf(A738SitEsLicencia), Boolean.valueOf(A739SitLicCuentaTrab), Byte.valueOf(A897SitLicMesesProm), Byte.valueOf(A898SitLicMesesProm2), A913sItDescAbrev, A915SitDiasDivision, Boolean.valueOf(A916SitEsAusencia), Byte.valueOf(A1217SitAplicaPlus), Boolean.valueOf(A1220SitAbsorbeFer), Short.valueOf(A1489SitLicLimiteDef), Boolean.valueOf(A1490SitLicAdjunDef), Boolean.valueOf(A1491SitLicAdjOblDef), Boolean.valueOf(A1492SitLicNecApr), Boolean.valueOf(A1493SitLIcIngMot), Boolean.valueOf(A1494SitLicOblIngMot), Boolean.valueOf(A1807EstadoCanPresen), Boolean.valueOf(A1809EstadoRemCorr), Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod), Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista), Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
                  if ( (pr_default.getStatus(12) == 1) )
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
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1D0( ) ;
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
            load1D46( ) ;
         }
         endLevel1D46( ) ;
      }
      closeExtendedTableCursors1D46( ) ;
   }

   public void update1D46( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1D46( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1D46( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1D46( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001D15 */
                  pr_default.execute(13, new Object[] {A685SitDescripSinAc, A334SitDescrip, Boolean.valueOf(A738SitEsLicencia), Boolean.valueOf(A739SitLicCuentaTrab), Byte.valueOf(A897SitLicMesesProm), Byte.valueOf(A898SitLicMesesProm2), A913sItDescAbrev, A915SitDiasDivision, Boolean.valueOf(A916SitEsAusencia), Byte.valueOf(A1217SitAplicaPlus), Boolean.valueOf(A1220SitAbsorbeFer), Short.valueOf(A1489SitLicLimiteDef), Boolean.valueOf(A1490SitLicAdjunDef), Boolean.valueOf(A1491SitLicAdjOblDef), Boolean.valueOf(A1492SitLicNecApr), Boolean.valueOf(A1493SitLIcIngMot), Boolean.valueOf(A1494SitLicOblIngMot), Boolean.valueOf(A1807EstadoCanPresen), Boolean.valueOf(A1809EstadoRemCorr), Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod), Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista), Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro, A16SitCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1D46( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
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
         }
         endLevel1D46( ) ;
      }
      closeExtendedTableCursors1D46( ) ;
   }

   public void deferredUpdate1D46( )
   {
   }

   public void delete( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1D46( ) ;
         afterConfirm1D46( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1D46( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001D16 */
               pr_default.execute(14, new Object[] {A16SitCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
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
      }
      sMode46 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1D46( ) ;
      Gx_mode = sMode46 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1D46( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV30Pgmname = "Estado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         chkSitLicCuentaTrab.setVisible( ((A738SitEsLicencia) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "Visible", GXutil.ltrimstr( chkSitLicCuentaTrab.getVisible(), 5, 0), true);
         if ( ! ( ( A738SitEsLicencia ) ) )
         {
            divSitliccuentatrab_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
         }
         else
         {
            if ( A738SitEsLicencia )
            {
               divSitliccuentatrab_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divSitliccuentatrab_cell_Internalname, "Class", divSitliccuentatrab_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001D17 */
         pr_default.execute(15, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_adicionalCancela", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001D18 */
         pr_default.execute(16, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_estados_no_presen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T001D19 */
         pr_default.execute(17, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel1D46( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "estado");
         if ( AnyError == 0 )
         {
            confirmValues1D0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "estado");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1D46( )
   {
      /* Scan By routine */
      /* Using cursor T001D20 */
      pr_default.execute(18);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A16SitCodigo = T001D20_A16SitCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1D46( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A16SitCodigo = T001D20_A16SitCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
      }
   }

   public void scanEnd1D46( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1D46( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1D46( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1D46( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1D46( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1D46( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1D46( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1D46( )
   {
      edtSitCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSitCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSitCodigo_Enabled), 5, 0), true);
      edtSitDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSitDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSitDescrip_Enabled), 5, 0), true);
      chkSitEsLicencia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSitEsLicencia.getInternalname(), "Enabled", GXutil.ltrimstr( chkSitEsLicencia.getEnabled(), 5, 0), true);
      chkSitLicCuentaTrab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "Enabled", GXutil.ltrimstr( chkSitLicCuentaTrab.getEnabled(), 5, 0), true);
      chkSitEsAusencia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSitEsAusencia.getInternalname(), "Enabled", GXutil.ltrimstr( chkSitEsAusencia.getEnabled(), 5, 0), true);
      chkSitAbsorbeFer.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSitAbsorbeFer.getInternalname(), "Enabled", GXutil.ltrimstr( chkSitAbsorbeFer.getEnabled(), 5, 0), true);
      chkEstadoCanPresen.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEstadoCanPresen.getInternalname(), "Enabled", GXutil.ltrimstr( chkEstadoCanPresen.getEnabled(), 5, 0), true);
      chkEstadoRemCorr.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEstadoRemCorr.getInternalname(), "Enabled", GXutil.ltrimstr( chkEstadoRemCorr.getEnabled(), 5, 0), true);
      edtEstadoSitRevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstadoSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSitRevista_Enabled), 5, 0), true);
      edtEstadoSiniestro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstadoSiniestro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstadoSiniestro_Enabled), 5, 0), true);
      edtavComboestadositrevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadositrevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadositrevista_Enabled), 5, 0), true);
      edtavComboestadosiniestro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestadosiniestro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestadosiniestro_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1D46( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1D0( )
   {
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.estado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7SitCodigo))}, new String[] {"Gx_mode","SitCodigo"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Estado");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SitLicMesesProm", localUtil.format( DecimalUtil.doubleToDec(A897SitLicMesesProm), "Z9"));
      forbiddenHiddens.add("SitLicMesesProm2", localUtil.format( DecimalUtil.doubleToDec(A898SitLicMesesProm2), "Z9"));
      forbiddenHiddens.add("sItDescAbrev", GXutil.rtrim( localUtil.format( A913sItDescAbrev, "@!")));
      forbiddenHiddens.add("SitDiasDivision", localUtil.format( A915SitDiasDivision, "Z9.9"));
      forbiddenHiddens.add("SitAplicaPlus", localUtil.format( DecimalUtil.doubleToDec(A1217SitAplicaPlus), "9"));
      forbiddenHiddens.add("SitLicLimiteDef", localUtil.format( DecimalUtil.doubleToDec(A1489SitLicLimiteDef), "ZZZ9"));
      forbiddenHiddens.add("SitLicAdjunDef", GXutil.booltostr( A1490SitLicAdjunDef));
      forbiddenHiddens.add("SitLicAdjOblDef", GXutil.booltostr( A1491SitLicAdjOblDef));
      forbiddenHiddens.add("SitLicNecApr", GXutil.booltostr( A1492SitLicNecApr));
      forbiddenHiddens.add("SitLIcIngMot", GXutil.booltostr( A1493SitLIcIngMot));
      forbiddenHiddens.add("SitLicOblIngMot", GXutil.booltostr( A1494SitLicOblIngMot));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("estado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z16SitCodigo", GXutil.rtrim( Z16SitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z685SitDescripSinAc", Z685SitDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z334SitDescrip", Z334SitDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z738SitEsLicencia", Z738SitEsLicencia);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z739SitLicCuentaTrab", Z739SitLicCuentaTrab);
      web.GxWebStd.gx_hidden_field( httpContext, "Z897SitLicMesesProm", GXutil.ltrim( localUtil.ntoc( Z897SitLicMesesProm, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z898SitLicMesesProm2", GXutil.ltrim( localUtil.ntoc( Z898SitLicMesesProm2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z913sItDescAbrev", Z913sItDescAbrev);
      web.GxWebStd.gx_hidden_field( httpContext, "Z915SitDiasDivision", GXutil.ltrim( localUtil.ntoc( Z915SitDiasDivision, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z916SitEsAusencia", Z916SitEsAusencia);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1217SitAplicaPlus", GXutil.ltrim( localUtil.ntoc( Z1217SitAplicaPlus, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1220SitAbsorbeFer", Z1220SitAbsorbeFer);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1489SitLicLimiteDef", GXutil.ltrim( localUtil.ntoc( Z1489SitLicLimiteDef, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1490SitLicAdjunDef", Z1490SitLicAdjunDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1491SitLicAdjOblDef", Z1491SitLicAdjOblDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1492SitLicNecApr", Z1492SitLicNecApr);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1493SitLIcIngMot", Z1493SitLIcIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1494SitLicOblIngMot", Z1494SitLicOblIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1807EstadoCanPresen", Z1807EstadoCanPresen);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1809EstadoRemCorr", Z1809EstadoRemCorr);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1593SitPaiCod", GXutil.ltrim( localUtil.ntoc( Z1593SitPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1598EstadoSitRevista", GXutil.ltrim( localUtil.ntoc( Z1598EstadoSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1600EstadoSiniestro", GXutil.rtrim( Z1600EstadoSiniestro));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1593SitPaiCod", GXutil.ltrim( localUtil.ntoc( A1593SitPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1598EstadoSitRevista", GXutil.ltrim( localUtil.ntoc( A1598EstadoSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1600EstadoSiniestro", GXutil.rtrim( A1600EstadoSiniestro));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESTADOSITREVISTA_DATA", AV20EstadoSitRevista_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESTADOSITREVISTA_DATA", AV20EstadoSitRevista_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESTADOSINIESTRO_DATA", AV27EstadoSiniestro_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESTADOSINIESTRO_DATA", AV27EstadoSiniestro_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "SITDESCRIPSINAC", A685SitDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vSITCODIGO", GXutil.rtrim( AV7SitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SitCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SITPAICOD", GXutil.ltrim( localUtil.ntoc( AV16Insert_SitPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITPAICOD", GXutil.ltrim( localUtil.ntoc( A1593SitPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ESTADOSITREVISTA", GXutil.ltrim( localUtil.ntoc( AV18Insert_EstadoSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ESTADOSINIESTRO", GXutil.rtrim( AV19Insert_EstadoSiniestro));
      web.GxWebStd.gx_hidden_field( httpContext, "SITLICMESESPROM", GXutil.ltrim( localUtil.ntoc( A897SitLicMesesProm, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITLICMESESPROM2", GXutil.ltrim( localUtil.ntoc( A898SitLicMesesProm2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITDESCABREV", A913sItDescAbrev);
      web.GxWebStd.gx_hidden_field( httpContext, "SITDIASDIVISION", GXutil.ltrim( localUtil.ntoc( A915SitDiasDivision, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITAPLICAPLUS", GXutil.ltrim( localUtil.ntoc( A1217SitAplicaPlus, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITLICLIMITEDEF", GXutil.ltrim( localUtil.ntoc( A1489SitLicLimiteDef, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICADJUNDEF", A1490SitLicAdjunDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICADJOBLDEF", A1491SitLicAdjOblDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICNECAPR", A1492SitLicNecApr);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICINGMOT", A1493SitLIcIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICOBLINGMOT", A1494SitLicOblIngMot);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV30Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Objectcall", GXutil.rtrim( Combo_estadositrevista_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Cls", GXutil.rtrim( Combo_estadositrevista_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Selectedvalue_set", GXutil.rtrim( Combo_estadositrevista_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Selectedtext_set", GXutil.rtrim( Combo_estadositrevista_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Enabled", GXutil.booltostr( Combo_estadositrevista_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Datalistproc", GXutil.rtrim( Combo_estadositrevista_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSITREVISTA_Datalistprocparametersprefix", GXutil.rtrim( Combo_estadositrevista_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Objectcall", GXutil.rtrim( Combo_estadosiniestro_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Cls", GXutil.rtrim( Combo_estadosiniestro_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Selectedvalue_set", GXutil.rtrim( Combo_estadosiniestro_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Selectedtext_set", GXutil.rtrim( Combo_estadosiniestro_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Enabled", GXutil.booltostr( Combo_estadosiniestro_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Datalistproc", GXutil.rtrim( Combo_estadosiniestro_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTADOSINIESTRO_Datalistprocparametersprefix", GXutil.rtrim( Combo_estadosiniestro_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.estado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7SitCodigo))}, new String[] {"Gx_mode","SitCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Estado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Situaciones de revista / Licencias", "") ;
   }

   public void initializeNonKey1D46( )
   {
      A1593SitPaiCod = (short)(0) ;
      n1593SitPaiCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1593SitPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1593SitPaiCod), 4, 0));
      A1598EstadoSitRevista = (short)(0) ;
      n1598EstadoSitRevista = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1598EstadoSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1598EstadoSitRevista), 3, 0));
      n1598EstadoSitRevista = ((0==A1598EstadoSitRevista) ? true : false) ;
      A1600EstadoSiniestro = "" ;
      n1600EstadoSiniestro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1600EstadoSiniestro", A1600EstadoSiniestro);
      n1600EstadoSiniestro = ((GXutil.strcmp("", A1600EstadoSiniestro)==0) ? true : false) ;
      A685SitDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A685SitDescripSinAc", A685SitDescripSinAc);
      A334SitDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A334SitDescrip", A334SitDescrip);
      A738SitEsLicencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
      A739SitLicCuentaTrab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
      A897SitLicMesesProm = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A897SitLicMesesProm", GXutil.ltrimstr( DecimalUtil.doubleToDec(A897SitLicMesesProm), 2, 0));
      A898SitLicMesesProm2 = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A898SitLicMesesProm2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A898SitLicMesesProm2), 2, 0));
      A913sItDescAbrev = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A913sItDescAbrev", A913sItDescAbrev);
      A915SitDiasDivision = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A915SitDiasDivision", GXutil.ltrimstr( A915SitDiasDivision, 4, 1));
      A916SitEsAusencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
      A1217SitAplicaPlus = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1217SitAplicaPlus", GXutil.str( A1217SitAplicaPlus, 1, 0));
      A1220SitAbsorbeFer = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
      A1489SitLicLimiteDef = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1489SitLicLimiteDef", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1489SitLicLimiteDef), 4, 0));
      A1490SitLicAdjunDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1490SitLicAdjunDef", A1490SitLicAdjunDef);
      A1491SitLicAdjOblDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1491SitLicAdjOblDef", A1491SitLicAdjOblDef);
      A1492SitLicNecApr = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1492SitLicNecApr", A1492SitLicNecApr);
      A1493SitLIcIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1493SitLIcIngMot", A1493SitLIcIngMot);
      A1494SitLicOblIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1494SitLicOblIngMot", A1494SitLicOblIngMot);
      A1807EstadoCanPresen = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
      A1809EstadoRemCorr = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
      Z685SitDescripSinAc = "" ;
      Z334SitDescrip = "" ;
      Z738SitEsLicencia = false ;
      Z739SitLicCuentaTrab = false ;
      Z897SitLicMesesProm = (byte)(0) ;
      Z898SitLicMesesProm2 = (byte)(0) ;
      Z913sItDescAbrev = "" ;
      Z915SitDiasDivision = DecimalUtil.ZERO ;
      Z916SitEsAusencia = false ;
      Z1217SitAplicaPlus = (byte)(0) ;
      Z1220SitAbsorbeFer = false ;
      Z1489SitLicLimiteDef = (short)(0) ;
      Z1490SitLicAdjunDef = false ;
      Z1491SitLicAdjOblDef = false ;
      Z1492SitLicNecApr = false ;
      Z1493SitLIcIngMot = false ;
      Z1494SitLicOblIngMot = false ;
      Z1807EstadoCanPresen = false ;
      Z1809EstadoRemCorr = false ;
      Z1593SitPaiCod = (short)(0) ;
      Z1598EstadoSitRevista = (short)(0) ;
      Z1600EstadoSiniestro = "" ;
   }

   public void initAll1D46( )
   {
      A16SitCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A16SitCodigo", A16SitCodigo);
      initializeNonKey1D46( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202041563", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("estado.js", "?202412202041563", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtSitCodigo_Internalname = "SITCODIGO" ;
      edtSitDescrip_Internalname = "SITDESCRIP" ;
      chkSitEsLicencia.setInternalname( "SITESLICENCIA" );
      chkSitLicCuentaTrab.setInternalname( "SITLICCUENTATRAB" );
      divSitliccuentatrab_cell_Internalname = "SITLICCUENTATRAB_CELL" ;
      chkSitEsAusencia.setInternalname( "SITESAUSENCIA" );
      chkSitAbsorbeFer.setInternalname( "SITABSORBEFER" );
      chkEstadoCanPresen.setInternalname( "ESTADOCANPRESEN" );
      chkEstadoRemCorr.setInternalname( "ESTADOREMCORR" );
      lblTextblockestadositrevista_Internalname = "TEXTBLOCKESTADOSITREVISTA" ;
      Combo_estadositrevista_Internalname = "COMBO_ESTADOSITREVISTA" ;
      edtEstadoSitRevista_Internalname = "ESTADOSITREVISTA" ;
      divTablesplittedestadositrevista_Internalname = "TABLESPLITTEDESTADOSITREVISTA" ;
      lblTextblockestadosiniestro_Internalname = "TEXTBLOCKESTADOSINIESTRO" ;
      Combo_estadosiniestro_Internalname = "COMBO_ESTADOSINIESTRO" ;
      edtEstadoSiniestro_Internalname = "ESTADOSINIESTRO" ;
      divTablesplittedestadosiniestro_Internalname = "TABLESPLITTEDESTADOSINIESTRO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboestadositrevista_Internalname = "vCOMBOESTADOSITREVISTA" ;
      divSectionattribute_estadositrevista_Internalname = "SECTIONATTRIBUTE_ESTADOSITREVISTA" ;
      edtavComboestadosiniestro_Internalname = "vCOMBOESTADOSINIESTRO" ;
      divSectionattribute_estadosiniestro_Internalname = "SECTIONATTRIBUTE_ESTADOSINIESTRO" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Situaciones de revista / Licencias", "") );
      edtavComboestadosiniestro_Jsonclick = "" ;
      edtavComboestadosiniestro_Enabled = 0 ;
      edtavComboestadosiniestro_Visible = 1 ;
      edtavComboestadositrevista_Jsonclick = "" ;
      edtavComboestadositrevista_Enabled = 0 ;
      edtavComboestadositrevista_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtEstadoSiniestro_Jsonclick = "" ;
      edtEstadoSiniestro_Enabled = 1 ;
      edtEstadoSiniestro_Visible = 1 ;
      Combo_estadosiniestro_Datalistprocparametersprefix = " \"ComboName\": \"EstadoSiniestro\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"SitCodigo\": \"\"" ;
      Combo_estadosiniestro_Datalistproc = "EstadoLoadDVCombo" ;
      Combo_estadosiniestro_Cls = "ExtendedCombo Attribute" ;
      Combo_estadosiniestro_Caption = "" ;
      Combo_estadosiniestro_Enabled = GXutil.toBoolean( -1) ;
      edtEstadoSitRevista_Jsonclick = "" ;
      edtEstadoSitRevista_Enabled = 1 ;
      edtEstadoSitRevista_Visible = 1 ;
      Combo_estadositrevista_Datalistprocparametersprefix = " \"ComboName\": \"EstadoSitRevista\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"SitCodigo\": \"\"" ;
      Combo_estadositrevista_Datalistproc = "EstadoLoadDVCombo" ;
      Combo_estadositrevista_Cls = "ExtendedCombo Attribute" ;
      Combo_estadositrevista_Caption = "" ;
      Combo_estadositrevista_Enabled = GXutil.toBoolean( -1) ;
      chkEstadoRemCorr.setEnabled( 1 );
      chkEstadoCanPresen.setEnabled( 1 );
      chkSitAbsorbeFer.setEnabled( 1 );
      chkSitEsAusencia.setEnabled( 1 );
      chkSitLicCuentaTrab.setEnabled( 1 );
      chkSitLicCuentaTrab.setVisible( 1 );
      divSitliccuentatrab_cell_Class = "col-xs-12" ;
      chkSitEsLicencia.setEnabled( 1 );
      edtSitDescrip_Jsonclick = "" ;
      edtSitDescrip_Enabled = 1 ;
      edtSitCodigo_Jsonclick = "" ;
      edtSitCodigo_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx3asasitdescripsinac1D46( String A334SitDescrip )
   {
      GXt_char6 = A685SitDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char9) ;
      estado_impl.this.GXt_char6 = GXv_char9[0] ;
      A685SitDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A685SitDescripSinAc", A685SitDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A685SitDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      chkSitEsLicencia.setName( "SITESLICENCIA" );
      chkSitEsLicencia.setWebtags( "" );
      chkSitEsLicencia.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSitEsLicencia.getInternalname(), "TitleCaption", chkSitEsLicencia.getCaption(), true);
      chkSitEsLicencia.setCheckedValue( "false" );
      A738SitEsLicencia = GXutil.strtobool( GXutil.booltostr( A738SitEsLicencia)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A738SitEsLicencia", A738SitEsLicencia);
      chkSitLicCuentaTrab.setName( "SITLICCUENTATRAB" );
      chkSitLicCuentaTrab.setWebtags( "" );
      chkSitLicCuentaTrab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSitLicCuentaTrab.getInternalname(), "TitleCaption", chkSitLicCuentaTrab.getCaption(), true);
      chkSitLicCuentaTrab.setCheckedValue( "false" );
      A739SitLicCuentaTrab = GXutil.strtobool( GXutil.booltostr( A739SitLicCuentaTrab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A739SitLicCuentaTrab", A739SitLicCuentaTrab);
      chkSitEsAusencia.setName( "SITESAUSENCIA" );
      chkSitEsAusencia.setWebtags( "" );
      chkSitEsAusencia.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSitEsAusencia.getInternalname(), "TitleCaption", chkSitEsAusencia.getCaption(), true);
      chkSitEsAusencia.setCheckedValue( "false" );
      A916SitEsAusencia = GXutil.strtobool( GXutil.booltostr( A916SitEsAusencia)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A916SitEsAusencia", A916SitEsAusencia);
      chkSitAbsorbeFer.setName( "SITABSORBEFER" );
      chkSitAbsorbeFer.setWebtags( "" );
      chkSitAbsorbeFer.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSitAbsorbeFer.getInternalname(), "TitleCaption", chkSitAbsorbeFer.getCaption(), true);
      chkSitAbsorbeFer.setCheckedValue( "false" );
      A1220SitAbsorbeFer = GXutil.strtobool( GXutil.booltostr( A1220SitAbsorbeFer)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1220SitAbsorbeFer", A1220SitAbsorbeFer);
      chkEstadoCanPresen.setName( "ESTADOCANPRESEN" );
      chkEstadoCanPresen.setWebtags( "" );
      chkEstadoCanPresen.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEstadoCanPresen.getInternalname(), "TitleCaption", chkEstadoCanPresen.getCaption(), true);
      chkEstadoCanPresen.setCheckedValue( "false" );
      A1807EstadoCanPresen = GXutil.strtobool( GXutil.booltostr( A1807EstadoCanPresen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1807EstadoCanPresen", A1807EstadoCanPresen);
      chkEstadoRemCorr.setName( "ESTADOREMCORR" );
      chkEstadoRemCorr.setWebtags( "" );
      chkEstadoRemCorr.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEstadoRemCorr.getInternalname(), "TitleCaption", chkEstadoRemCorr.getCaption(), true);
      chkEstadoRemCorr.setCheckedValue( "false" );
      A1809EstadoRemCorr = GXutil.strtobool( GXutil.booltostr( A1809EstadoRemCorr)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1809EstadoRemCorr", A1809EstadoRemCorr);
      /* End function init_web_controls */
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

   public void valid_Sitdescrip( )
   {
      GXt_char6 = A685SitDescripSinAc ;
      GXv_char9[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char9) ;
      estado_impl.this.GXt_char6 = GXv_char9[0] ;
      A685SitDescripSinAc = GXt_char6 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A685SitDescripSinAc", A685SitDescripSinAc);
   }

   public void valid_Estadositrevista( )
   {
      n1598EstadoSitRevista = false ;
      /* Using cursor T001D21 */
      pr_default.execute(19, new Object[] {Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (0==A1598EstadoSitRevista) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Situacion Revista", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSITREVISTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSitRevista_Internalname ;
         }
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Estadosiniestro( )
   {
      n1600EstadoSiniestro = false ;
      /* Using cursor T001D22 */
      pr_default.execute(20, new Object[] {Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1600EstadoSiniestro)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Siniestro Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSINIESTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEstadoSiniestro_Internalname ;
         }
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SitCodigo',fld:'vSITCODIGO',pic:'',hsh:true},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SitCodigo',fld:'vSITCODIGO',pic:'',hsh:true},{av:'A897SitLicMesesProm',fld:'SITLICMESESPROM',pic:'Z9'},{av:'A898SitLicMesesProm2',fld:'SITLICMESESPROM2',pic:'Z9'},{av:'A913sItDescAbrev',fld:'SITDESCABREV',pic:'@!'},{av:'A915SitDiasDivision',fld:'SITDIASDIVISION',pic:'Z9.9'},{av:'A1217SitAplicaPlus',fld:'SITAPLICAPLUS',pic:'9'},{av:'A1489SitLicLimiteDef',fld:'SITLICLIMITEDEF',pic:'ZZZ9'},{av:'A1490SitLicAdjunDef',fld:'SITLICADJUNDEF',pic:''},{av:'A1491SitLicAdjOblDef',fld:'SITLICADJOBLDEF',pic:''},{av:'A1492SitLicNecApr',fld:'SITLICNECAPR',pic:''},{av:'A1493SitLIcIngMot',fld:'SITLICINGMOT',pic:''},{av:'A1494SitLicOblIngMot',fld:'SITLICOBLINGMOT',pic:''},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121D2',iparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALID_SITCODIGO","{handler:'valid_Sitcodigo',iparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALID_SITCODIGO",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALID_SITDESCRIP","{handler:'valid_Sitdescrip',iparms:[{av:'A334SitDescrip',fld:'SITDESCRIP',pic:'@!'},{av:'A685SitDescripSinAc',fld:'SITDESCRIPSINAC',pic:'@!'},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALID_SITDESCRIP",",oparms:[{av:'A685SitDescripSinAc',fld:'SITDESCRIPSINAC',pic:'@!'},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALID_SITESLICENCIA","{handler:'valid_Siteslicencia',iparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALID_SITESLICENCIA",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALID_ESTADOSITREVISTA","{handler:'valid_Estadositrevista',iparms:[{av:'A1598EstadoSitRevista',fld:'ESTADOSITREVISTA',pic:'ZZ9'},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALID_ESTADOSITREVISTA",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALID_ESTADOSINIESTRO","{handler:'valid_Estadosiniestro',iparms:[{av:'A1600EstadoSiniestro',fld:'ESTADOSINIESTRO',pic:''},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALID_ESTADOSINIESTRO",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALIDV_COMBOESTADOSITREVISTA","{handler:'validv_Comboestadositrevista',iparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALIDV_COMBOESTADOSITREVISTA",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
      setEventMetadata("VALIDV_COMBOESTADOSINIESTRO","{handler:'validv_Comboestadosiniestro',iparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]");
      setEventMetadata("VALIDV_COMBOESTADOSINIESTRO",",oparms:[{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A916SitEsAusencia',fld:'SITESAUSENCIA',pic:''},{av:'A1220SitAbsorbeFer',fld:'SITABSORBEFER',pic:''},{av:'A1807EstadoCanPresen',fld:'ESTADOCANPRESEN',pic:''},{av:'A1809EstadoRemCorr',fld:'ESTADOREMCORR',pic:''}]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(19);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7SitCodigo = "" ;
      Z16SitCodigo = "" ;
      Z685SitDescripSinAc = "" ;
      Z334SitDescrip = "" ;
      Z913sItDescAbrev = "" ;
      Z915SitDiasDivision = DecimalUtil.ZERO ;
      Z1600EstadoSiniestro = "" ;
      N1600EstadoSiniestro = "" ;
      Combo_estadosiniestro_Selectedvalue_get = "" ;
      Combo_estadositrevista_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A334SitDescrip = "" ;
      A1600EstadoSiniestro = "" ;
      Gx_mode = "" ;
      AV7SitCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A16SitCodigo = "" ;
      lblTextblockestadositrevista_Jsonclick = "" ;
      ucCombo_estadositrevista = new com.genexus.webpanels.GXUserControl();
      AV21DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV20EstadoSitRevista_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockestadosiniestro_Jsonclick = "" ;
      ucCombo_estadosiniestro = new com.genexus.webpanels.GXUserControl();
      AV27EstadoSiniestro_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      AV28ComboEstadoSiniestro = "" ;
      A685SitDescripSinAc = "" ;
      A913sItDescAbrev = "" ;
      A915SitDiasDivision = DecimalUtil.ZERO ;
      AV19Insert_EstadoSiniestro = "" ;
      AV30Pgmname = "" ;
      Combo_estadositrevista_Objectcall = "" ;
      Combo_estadositrevista_Class = "" ;
      Combo_estadositrevista_Icontype = "" ;
      Combo_estadositrevista_Icon = "" ;
      Combo_estadositrevista_Tooltip = "" ;
      Combo_estadositrevista_Selectedvalue_set = "" ;
      Combo_estadositrevista_Selectedtext_set = "" ;
      Combo_estadositrevista_Selectedtext_get = "" ;
      Combo_estadositrevista_Gamoauthtoken = "" ;
      Combo_estadositrevista_Ddointernalname = "" ;
      Combo_estadositrevista_Titlecontrolalign = "" ;
      Combo_estadositrevista_Dropdownoptionstype = "" ;
      Combo_estadositrevista_Titlecontrolidtoreplace = "" ;
      Combo_estadositrevista_Datalisttype = "" ;
      Combo_estadositrevista_Datalistfixedvalues = "" ;
      Combo_estadositrevista_Remoteservicesparameters = "" ;
      Combo_estadositrevista_Htmltemplate = "" ;
      Combo_estadositrevista_Multiplevaluestype = "" ;
      Combo_estadositrevista_Loadingdata = "" ;
      Combo_estadositrevista_Noresultsfound = "" ;
      Combo_estadositrevista_Emptyitemtext = "" ;
      Combo_estadositrevista_Onlyselectedvalues = "" ;
      Combo_estadositrevista_Selectalltext = "" ;
      Combo_estadositrevista_Multiplevaluesseparator = "" ;
      Combo_estadositrevista_Addnewoptiontext = "" ;
      Combo_estadosiniestro_Objectcall = "" ;
      Combo_estadosiniestro_Class = "" ;
      Combo_estadosiniestro_Icontype = "" ;
      Combo_estadosiniestro_Icon = "" ;
      Combo_estadosiniestro_Tooltip = "" ;
      Combo_estadosiniestro_Selectedvalue_set = "" ;
      Combo_estadosiniestro_Selectedtext_set = "" ;
      Combo_estadosiniestro_Selectedtext_get = "" ;
      Combo_estadosiniestro_Gamoauthtoken = "" ;
      Combo_estadosiniestro_Ddointernalname = "" ;
      Combo_estadosiniestro_Titlecontrolalign = "" ;
      Combo_estadosiniestro_Dropdownoptionstype = "" ;
      Combo_estadosiniestro_Titlecontrolidtoreplace = "" ;
      Combo_estadosiniestro_Datalisttype = "" ;
      Combo_estadosiniestro_Datalistfixedvalues = "" ;
      Combo_estadosiniestro_Remoteservicesparameters = "" ;
      Combo_estadosiniestro_Htmltemplate = "" ;
      Combo_estadosiniestro_Multiplevaluestype = "" ;
      Combo_estadosiniestro_Loadingdata = "" ;
      Combo_estadosiniestro_Noresultsfound = "" ;
      Combo_estadosiniestro_Emptyitemtext = "" ;
      Combo_estadosiniestro_Onlyselectedvalues = "" ;
      Combo_estadosiniestro_Selectalltext = "" ;
      Combo_estadosiniestro_Multiplevaluesseparator = "" ;
      Combo_estadosiniestro_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode46 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV24Combo_DataJson = "" ;
      AV22ComboSelectedValue = "" ;
      AV23ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T001D7_A685SitDescripSinAc = new String[] {""} ;
      T001D7_A16SitCodigo = new String[] {""} ;
      T001D7_A334SitDescrip = new String[] {""} ;
      T001D7_A738SitEsLicencia = new boolean[] {false} ;
      T001D7_A739SitLicCuentaTrab = new boolean[] {false} ;
      T001D7_A897SitLicMesesProm = new byte[1] ;
      T001D7_A898SitLicMesesProm2 = new byte[1] ;
      T001D7_A913sItDescAbrev = new String[] {""} ;
      T001D7_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001D7_A916SitEsAusencia = new boolean[] {false} ;
      T001D7_A1217SitAplicaPlus = new byte[1] ;
      T001D7_A1220SitAbsorbeFer = new boolean[] {false} ;
      T001D7_A1489SitLicLimiteDef = new short[1] ;
      T001D7_A1490SitLicAdjunDef = new boolean[] {false} ;
      T001D7_A1491SitLicAdjOblDef = new boolean[] {false} ;
      T001D7_A1492SitLicNecApr = new boolean[] {false} ;
      T001D7_A1493SitLIcIngMot = new boolean[] {false} ;
      T001D7_A1494SitLicOblIngMot = new boolean[] {false} ;
      T001D7_A1807EstadoCanPresen = new boolean[] {false} ;
      T001D7_A1809EstadoRemCorr = new boolean[] {false} ;
      T001D7_A1593SitPaiCod = new short[1] ;
      T001D7_n1593SitPaiCod = new boolean[] {false} ;
      T001D7_A1598EstadoSitRevista = new short[1] ;
      T001D7_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D7_A1600EstadoSiniestro = new String[] {""} ;
      T001D7_n1600EstadoSiniestro = new boolean[] {false} ;
      T001D5_A1598EstadoSitRevista = new short[1] ;
      T001D5_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D6_A1600EstadoSiniestro = new String[] {""} ;
      T001D6_n1600EstadoSiniestro = new boolean[] {false} ;
      T001D4_A1593SitPaiCod = new short[1] ;
      T001D4_n1593SitPaiCod = new boolean[] {false} ;
      T001D8_A1598EstadoSitRevista = new short[1] ;
      T001D8_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D9_A1600EstadoSiniestro = new String[] {""} ;
      T001D9_n1600EstadoSiniestro = new boolean[] {false} ;
      T001D10_A1593SitPaiCod = new short[1] ;
      T001D10_n1593SitPaiCod = new boolean[] {false} ;
      T001D11_A16SitCodigo = new String[] {""} ;
      T001D3_A685SitDescripSinAc = new String[] {""} ;
      T001D3_A16SitCodigo = new String[] {""} ;
      T001D3_A334SitDescrip = new String[] {""} ;
      T001D3_A738SitEsLicencia = new boolean[] {false} ;
      T001D3_A739SitLicCuentaTrab = new boolean[] {false} ;
      T001D3_A897SitLicMesesProm = new byte[1] ;
      T001D3_A898SitLicMesesProm2 = new byte[1] ;
      T001D3_A913sItDescAbrev = new String[] {""} ;
      T001D3_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001D3_A916SitEsAusencia = new boolean[] {false} ;
      T001D3_A1217SitAplicaPlus = new byte[1] ;
      T001D3_A1220SitAbsorbeFer = new boolean[] {false} ;
      T001D3_A1489SitLicLimiteDef = new short[1] ;
      T001D3_A1490SitLicAdjunDef = new boolean[] {false} ;
      T001D3_A1491SitLicAdjOblDef = new boolean[] {false} ;
      T001D3_A1492SitLicNecApr = new boolean[] {false} ;
      T001D3_A1493SitLIcIngMot = new boolean[] {false} ;
      T001D3_A1494SitLicOblIngMot = new boolean[] {false} ;
      T001D3_A1807EstadoCanPresen = new boolean[] {false} ;
      T001D3_A1809EstadoRemCorr = new boolean[] {false} ;
      T001D3_A1593SitPaiCod = new short[1] ;
      T001D3_n1593SitPaiCod = new boolean[] {false} ;
      T001D3_A1598EstadoSitRevista = new short[1] ;
      T001D3_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D3_A1600EstadoSiniestro = new String[] {""} ;
      T001D3_n1600EstadoSiniestro = new boolean[] {false} ;
      T001D12_A16SitCodigo = new String[] {""} ;
      T001D13_A16SitCodigo = new String[] {""} ;
      T001D2_A685SitDescripSinAc = new String[] {""} ;
      T001D2_A16SitCodigo = new String[] {""} ;
      T001D2_A334SitDescrip = new String[] {""} ;
      T001D2_A738SitEsLicencia = new boolean[] {false} ;
      T001D2_A739SitLicCuentaTrab = new boolean[] {false} ;
      T001D2_A897SitLicMesesProm = new byte[1] ;
      T001D2_A898SitLicMesesProm2 = new byte[1] ;
      T001D2_A913sItDescAbrev = new String[] {""} ;
      T001D2_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001D2_A916SitEsAusencia = new boolean[] {false} ;
      T001D2_A1217SitAplicaPlus = new byte[1] ;
      T001D2_A1220SitAbsorbeFer = new boolean[] {false} ;
      T001D2_A1489SitLicLimiteDef = new short[1] ;
      T001D2_A1490SitLicAdjunDef = new boolean[] {false} ;
      T001D2_A1491SitLicAdjOblDef = new boolean[] {false} ;
      T001D2_A1492SitLicNecApr = new boolean[] {false} ;
      T001D2_A1493SitLIcIngMot = new boolean[] {false} ;
      T001D2_A1494SitLicOblIngMot = new boolean[] {false} ;
      T001D2_A1807EstadoCanPresen = new boolean[] {false} ;
      T001D2_A1809EstadoRemCorr = new boolean[] {false} ;
      T001D2_A1593SitPaiCod = new short[1] ;
      T001D2_n1593SitPaiCod = new boolean[] {false} ;
      T001D2_A1598EstadoSitRevista = new short[1] ;
      T001D2_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D2_A1600EstadoSiniestro = new String[] {""} ;
      T001D2_n1600EstadoSiniestro = new boolean[] {false} ;
      T001D17_A3CliCod = new int[1] ;
      T001D17_A1564CliPaiConve = new short[1] ;
      T001D17_A1565CliConvenio = new String[] {""} ;
      T001D17_A996ConveAdicod = new String[] {""} ;
      T001D17_A1824ConveAdiSitCancela = new String[] {""} ;
      T001D18_A3CliCod = new int[1] ;
      T001D18_A1564CliPaiConve = new short[1] ;
      T001D18_A1565CliConvenio = new String[] {""} ;
      T001D18_A1805ConveSitPresen = new String[] {""} ;
      T001D19_A3CliCod = new int[1] ;
      T001D19_A1EmpCod = new short[1] ;
      T001D19_A6LegNumero = new int[1] ;
      T001D19_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T001D20_A16SitCodigo = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      T001D21_A1598EstadoSitRevista = new short[1] ;
      T001D21_n1598EstadoSitRevista = new boolean[] {false} ;
      T001D22_A1600EstadoSiniestro = new String[] {""} ;
      T001D22_n1600EstadoSiniestro = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estado__default(),
         new Object[] {
             new Object[] {
            T001D2_A685SitDescripSinAc, T001D2_A16SitCodigo, T001D2_A334SitDescrip, T001D2_A738SitEsLicencia, T001D2_A739SitLicCuentaTrab, T001D2_A897SitLicMesesProm, T001D2_A898SitLicMesesProm2, T001D2_A913sItDescAbrev, T001D2_A915SitDiasDivision, T001D2_A916SitEsAusencia,
            T001D2_A1217SitAplicaPlus, T001D2_A1220SitAbsorbeFer, T001D2_A1489SitLicLimiteDef, T001D2_A1490SitLicAdjunDef, T001D2_A1491SitLicAdjOblDef, T001D2_A1492SitLicNecApr, T001D2_A1493SitLIcIngMot, T001D2_A1494SitLicOblIngMot, T001D2_A1807EstadoCanPresen, T001D2_A1809EstadoRemCorr,
            T001D2_A1593SitPaiCod, T001D2_n1593SitPaiCod, T001D2_A1598EstadoSitRevista, T001D2_n1598EstadoSitRevista, T001D2_A1600EstadoSiniestro, T001D2_n1600EstadoSiniestro
            }
            , new Object[] {
            T001D3_A685SitDescripSinAc, T001D3_A16SitCodigo, T001D3_A334SitDescrip, T001D3_A738SitEsLicencia, T001D3_A739SitLicCuentaTrab, T001D3_A897SitLicMesesProm, T001D3_A898SitLicMesesProm2, T001D3_A913sItDescAbrev, T001D3_A915SitDiasDivision, T001D3_A916SitEsAusencia,
            T001D3_A1217SitAplicaPlus, T001D3_A1220SitAbsorbeFer, T001D3_A1489SitLicLimiteDef, T001D3_A1490SitLicAdjunDef, T001D3_A1491SitLicAdjOblDef, T001D3_A1492SitLicNecApr, T001D3_A1493SitLIcIngMot, T001D3_A1494SitLicOblIngMot, T001D3_A1807EstadoCanPresen, T001D3_A1809EstadoRemCorr,
            T001D3_A1593SitPaiCod, T001D3_n1593SitPaiCod, T001D3_A1598EstadoSitRevista, T001D3_n1598EstadoSitRevista, T001D3_A1600EstadoSiniestro, T001D3_n1600EstadoSiniestro
            }
            , new Object[] {
            T001D4_A1593SitPaiCod
            }
            , new Object[] {
            T001D5_A1598EstadoSitRevista
            }
            , new Object[] {
            T001D6_A1600EstadoSiniestro
            }
            , new Object[] {
            T001D7_A685SitDescripSinAc, T001D7_A16SitCodigo, T001D7_A334SitDescrip, T001D7_A738SitEsLicencia, T001D7_A739SitLicCuentaTrab, T001D7_A897SitLicMesesProm, T001D7_A898SitLicMesesProm2, T001D7_A913sItDescAbrev, T001D7_A915SitDiasDivision, T001D7_A916SitEsAusencia,
            T001D7_A1217SitAplicaPlus, T001D7_A1220SitAbsorbeFer, T001D7_A1489SitLicLimiteDef, T001D7_A1490SitLicAdjunDef, T001D7_A1491SitLicAdjOblDef, T001D7_A1492SitLicNecApr, T001D7_A1493SitLIcIngMot, T001D7_A1494SitLicOblIngMot, T001D7_A1807EstadoCanPresen, T001D7_A1809EstadoRemCorr,
            T001D7_A1593SitPaiCod, T001D7_n1593SitPaiCod, T001D7_A1598EstadoSitRevista, T001D7_n1598EstadoSitRevista, T001D7_A1600EstadoSiniestro, T001D7_n1600EstadoSiniestro
            }
            , new Object[] {
            T001D8_A1598EstadoSitRevista
            }
            , new Object[] {
            T001D9_A1600EstadoSiniestro
            }
            , new Object[] {
            T001D10_A1593SitPaiCod
            }
            , new Object[] {
            T001D11_A16SitCodigo
            }
            , new Object[] {
            T001D12_A16SitCodigo
            }
            , new Object[] {
            T001D13_A16SitCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001D17_A3CliCod, T001D17_A1564CliPaiConve, T001D17_A1565CliConvenio, T001D17_A996ConveAdicod, T001D17_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T001D18_A3CliCod, T001D18_A1564CliPaiConve, T001D18_A1565CliConvenio, T001D18_A1805ConveSitPresen
            }
            , new Object[] {
            T001D19_A3CliCod, T001D19_A1EmpCod, T001D19_A6LegNumero, T001D19_A76LegLicenIni
            }
            , new Object[] {
            T001D20_A16SitCodigo
            }
            , new Object[] {
            T001D21_A1598EstadoSitRevista
            }
            , new Object[] {
            T001D22_A1600EstadoSiniestro
            }
         }
      );
      AV30Pgmname = "Estado" ;
   }

   private byte Z897SitLicMesesProm ;
   private byte Z898SitLicMesesProm2 ;
   private byte Z1217SitAplicaPlus ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A897SitLicMesesProm ;
   private byte A898SitLicMesesProm2 ;
   private byte A1217SitAplicaPlus ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1489SitLicLimiteDef ;
   private short Z1593SitPaiCod ;
   private short Z1598EstadoSitRevista ;
   private short N1593SitPaiCod ;
   private short N1598EstadoSitRevista ;
   private short A1598EstadoSitRevista ;
   private short A1593SitPaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV25ComboEstadoSitRevista ;
   private short A1489SitLicLimiteDef ;
   private short AV16Insert_SitPaiCod ;
   private short AV18Insert_EstadoSitRevista ;
   private short RcdFound46 ;
   private short nIsDirty_46 ;
   private int trnEnded ;
   private int edtSitCodigo_Enabled ;
   private int edtSitDescrip_Enabled ;
   private int edtEstadoSitRevista_Visible ;
   private int edtEstadoSitRevista_Enabled ;
   private int edtEstadoSiniestro_Visible ;
   private int edtEstadoSiniestro_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int edtavComboestadositrevista_Enabled ;
   private int edtavComboestadositrevista_Visible ;
   private int edtavComboestadosiniestro_Visible ;
   private int edtavComboestadosiniestro_Enabled ;
   private int Combo_estadositrevista_Datalistupdateminimumcharacters ;
   private int Combo_estadosiniestro_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV31GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z915SitDiasDivision ;
   private java.math.BigDecimal A915SitDiasDivision ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7SitCodigo ;
   private String Z16SitCodigo ;
   private String Z1600EstadoSiniestro ;
   private String N1600EstadoSiniestro ;
   private String Combo_estadosiniestro_Selectedvalue_get ;
   private String Combo_estadositrevista_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1600EstadoSiniestro ;
   private String Gx_mode ;
   private String AV7SitCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSitCodigo_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A16SitCodigo ;
   private String edtSitCodigo_Jsonclick ;
   private String edtSitDescrip_Internalname ;
   private String edtSitDescrip_Jsonclick ;
   private String divSitliccuentatrab_cell_Internalname ;
   private String divSitliccuentatrab_cell_Class ;
   private String divTablesplittedestadositrevista_Internalname ;
   private String lblTextblockestadositrevista_Internalname ;
   private String lblTextblockestadositrevista_Jsonclick ;
   private String Combo_estadositrevista_Caption ;
   private String Combo_estadositrevista_Cls ;
   private String Combo_estadositrevista_Datalistproc ;
   private String Combo_estadositrevista_Datalistprocparametersprefix ;
   private String Combo_estadositrevista_Internalname ;
   private String edtEstadoSitRevista_Internalname ;
   private String edtEstadoSitRevista_Jsonclick ;
   private String divTablesplittedestadosiniestro_Internalname ;
   private String lblTextblockestadosiniestro_Internalname ;
   private String lblTextblockestadosiniestro_Jsonclick ;
   private String Combo_estadosiniestro_Caption ;
   private String Combo_estadosiniestro_Cls ;
   private String Combo_estadosiniestro_Datalistproc ;
   private String Combo_estadosiniestro_Datalistprocparametersprefix ;
   private String Combo_estadosiniestro_Internalname ;
   private String edtEstadoSiniestro_Internalname ;
   private String edtEstadoSiniestro_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_estadositrevista_Internalname ;
   private String edtavComboestadositrevista_Internalname ;
   private String edtavComboestadositrevista_Jsonclick ;
   private String divSectionattribute_estadosiniestro_Internalname ;
   private String edtavComboestadosiniestro_Internalname ;
   private String AV28ComboEstadoSiniestro ;
   private String edtavComboestadosiniestro_Jsonclick ;
   private String AV19Insert_EstadoSiniestro ;
   private String AV30Pgmname ;
   private String Combo_estadositrevista_Objectcall ;
   private String Combo_estadositrevista_Class ;
   private String Combo_estadositrevista_Icontype ;
   private String Combo_estadositrevista_Icon ;
   private String Combo_estadositrevista_Tooltip ;
   private String Combo_estadositrevista_Selectedvalue_set ;
   private String Combo_estadositrevista_Selectedtext_set ;
   private String Combo_estadositrevista_Selectedtext_get ;
   private String Combo_estadositrevista_Gamoauthtoken ;
   private String Combo_estadositrevista_Ddointernalname ;
   private String Combo_estadositrevista_Titlecontrolalign ;
   private String Combo_estadositrevista_Dropdownoptionstype ;
   private String Combo_estadositrevista_Titlecontrolidtoreplace ;
   private String Combo_estadositrevista_Datalisttype ;
   private String Combo_estadositrevista_Datalistfixedvalues ;
   private String Combo_estadositrevista_Remoteservicesparameters ;
   private String Combo_estadositrevista_Htmltemplate ;
   private String Combo_estadositrevista_Multiplevaluestype ;
   private String Combo_estadositrevista_Loadingdata ;
   private String Combo_estadositrevista_Noresultsfound ;
   private String Combo_estadositrevista_Emptyitemtext ;
   private String Combo_estadositrevista_Onlyselectedvalues ;
   private String Combo_estadositrevista_Selectalltext ;
   private String Combo_estadositrevista_Multiplevaluesseparator ;
   private String Combo_estadositrevista_Addnewoptiontext ;
   private String Combo_estadosiniestro_Objectcall ;
   private String Combo_estadosiniestro_Class ;
   private String Combo_estadosiniestro_Icontype ;
   private String Combo_estadosiniestro_Icon ;
   private String Combo_estadosiniestro_Tooltip ;
   private String Combo_estadosiniestro_Selectedvalue_set ;
   private String Combo_estadosiniestro_Selectedtext_set ;
   private String Combo_estadosiniestro_Selectedtext_get ;
   private String Combo_estadosiniestro_Gamoauthtoken ;
   private String Combo_estadosiniestro_Ddointernalname ;
   private String Combo_estadosiniestro_Titlecontrolalign ;
   private String Combo_estadosiniestro_Dropdownoptionstype ;
   private String Combo_estadosiniestro_Titlecontrolidtoreplace ;
   private String Combo_estadosiniestro_Datalisttype ;
   private String Combo_estadosiniestro_Datalistfixedvalues ;
   private String Combo_estadosiniestro_Remoteservicesparameters ;
   private String Combo_estadosiniestro_Htmltemplate ;
   private String Combo_estadosiniestro_Multiplevaluestype ;
   private String Combo_estadosiniestro_Loadingdata ;
   private String Combo_estadosiniestro_Noresultsfound ;
   private String Combo_estadosiniestro_Emptyitemtext ;
   private String Combo_estadosiniestro_Onlyselectedvalues ;
   private String Combo_estadosiniestro_Selectalltext ;
   private String Combo_estadosiniestro_Multiplevaluesseparator ;
   private String Combo_estadosiniestro_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode46 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private boolean Z738SitEsLicencia ;
   private boolean Z739SitLicCuentaTrab ;
   private boolean Z916SitEsAusencia ;
   private boolean Z1220SitAbsorbeFer ;
   private boolean Z1490SitLicAdjunDef ;
   private boolean Z1491SitLicAdjOblDef ;
   private boolean Z1492SitLicNecApr ;
   private boolean Z1493SitLIcIngMot ;
   private boolean Z1494SitLicOblIngMot ;
   private boolean Z1807EstadoCanPresen ;
   private boolean Z1809EstadoRemCorr ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1598EstadoSitRevista ;
   private boolean n1600EstadoSiniestro ;
   private boolean n1593SitPaiCod ;
   private boolean wbErr ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean A1807EstadoCanPresen ;
   private boolean A1809EstadoRemCorr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A1490SitLicAdjunDef ;
   private boolean A1491SitLicAdjOblDef ;
   private boolean A1492SitLicNecApr ;
   private boolean A1493SitLIcIngMot ;
   private boolean A1494SitLicOblIngMot ;
   private boolean Combo_estadositrevista_Enabled ;
   private boolean Combo_estadositrevista_Visible ;
   private boolean Combo_estadositrevista_Allowmultipleselection ;
   private boolean Combo_estadositrevista_Isgriditem ;
   private boolean Combo_estadositrevista_Hasdescription ;
   private boolean Combo_estadositrevista_Includeonlyselectedoption ;
   private boolean Combo_estadositrevista_Includeselectalloption ;
   private boolean Combo_estadositrevista_Emptyitem ;
   private boolean Combo_estadositrevista_Includeaddnewoption ;
   private boolean Combo_estadosiniestro_Enabled ;
   private boolean Combo_estadosiniestro_Visible ;
   private boolean Combo_estadosiniestro_Allowmultipleselection ;
   private boolean Combo_estadosiniestro_Isgriditem ;
   private boolean Combo_estadosiniestro_Hasdescription ;
   private boolean Combo_estadosiniestro_Includeonlyselectedoption ;
   private boolean Combo_estadosiniestro_Includeselectalloption ;
   private boolean Combo_estadosiniestro_Emptyitem ;
   private boolean Combo_estadosiniestro_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV24Combo_DataJson ;
   private String Z685SitDescripSinAc ;
   private String Z334SitDescrip ;
   private String Z913sItDescAbrev ;
   private String A334SitDescrip ;
   private String A685SitDescripSinAc ;
   private String A913sItDescAbrev ;
   private String AV22ComboSelectedValue ;
   private String AV23ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_estadositrevista ;
   private com.genexus.webpanels.GXUserControl ucCombo_estadosiniestro ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkSitEsLicencia ;
   private ICheckbox chkSitLicCuentaTrab ;
   private ICheckbox chkSitEsAusencia ;
   private ICheckbox chkSitAbsorbeFer ;
   private ICheckbox chkEstadoCanPresen ;
   private ICheckbox chkEstadoRemCorr ;
   private IDataStoreProvider pr_default ;
   private String[] T001D7_A685SitDescripSinAc ;
   private String[] T001D7_A16SitCodigo ;
   private String[] T001D7_A334SitDescrip ;
   private boolean[] T001D7_A738SitEsLicencia ;
   private boolean[] T001D7_A739SitLicCuentaTrab ;
   private byte[] T001D7_A897SitLicMesesProm ;
   private byte[] T001D7_A898SitLicMesesProm2 ;
   private String[] T001D7_A913sItDescAbrev ;
   private java.math.BigDecimal[] T001D7_A915SitDiasDivision ;
   private boolean[] T001D7_A916SitEsAusencia ;
   private byte[] T001D7_A1217SitAplicaPlus ;
   private boolean[] T001D7_A1220SitAbsorbeFer ;
   private short[] T001D7_A1489SitLicLimiteDef ;
   private boolean[] T001D7_A1490SitLicAdjunDef ;
   private boolean[] T001D7_A1491SitLicAdjOblDef ;
   private boolean[] T001D7_A1492SitLicNecApr ;
   private boolean[] T001D7_A1493SitLIcIngMot ;
   private boolean[] T001D7_A1494SitLicOblIngMot ;
   private boolean[] T001D7_A1807EstadoCanPresen ;
   private boolean[] T001D7_A1809EstadoRemCorr ;
   private short[] T001D7_A1593SitPaiCod ;
   private boolean[] T001D7_n1593SitPaiCod ;
   private short[] T001D7_A1598EstadoSitRevista ;
   private boolean[] T001D7_n1598EstadoSitRevista ;
   private String[] T001D7_A1600EstadoSiniestro ;
   private boolean[] T001D7_n1600EstadoSiniestro ;
   private short[] T001D5_A1598EstadoSitRevista ;
   private boolean[] T001D5_n1598EstadoSitRevista ;
   private String[] T001D6_A1600EstadoSiniestro ;
   private boolean[] T001D6_n1600EstadoSiniestro ;
   private short[] T001D4_A1593SitPaiCod ;
   private boolean[] T001D4_n1593SitPaiCod ;
   private short[] T001D8_A1598EstadoSitRevista ;
   private boolean[] T001D8_n1598EstadoSitRevista ;
   private String[] T001D9_A1600EstadoSiniestro ;
   private boolean[] T001D9_n1600EstadoSiniestro ;
   private short[] T001D10_A1593SitPaiCod ;
   private boolean[] T001D10_n1593SitPaiCod ;
   private String[] T001D11_A16SitCodigo ;
   private String[] T001D3_A685SitDescripSinAc ;
   private String[] T001D3_A16SitCodigo ;
   private String[] T001D3_A334SitDescrip ;
   private boolean[] T001D3_A738SitEsLicencia ;
   private boolean[] T001D3_A739SitLicCuentaTrab ;
   private byte[] T001D3_A897SitLicMesesProm ;
   private byte[] T001D3_A898SitLicMesesProm2 ;
   private String[] T001D3_A913sItDescAbrev ;
   private java.math.BigDecimal[] T001D3_A915SitDiasDivision ;
   private boolean[] T001D3_A916SitEsAusencia ;
   private byte[] T001D3_A1217SitAplicaPlus ;
   private boolean[] T001D3_A1220SitAbsorbeFer ;
   private short[] T001D3_A1489SitLicLimiteDef ;
   private boolean[] T001D3_A1490SitLicAdjunDef ;
   private boolean[] T001D3_A1491SitLicAdjOblDef ;
   private boolean[] T001D3_A1492SitLicNecApr ;
   private boolean[] T001D3_A1493SitLIcIngMot ;
   private boolean[] T001D3_A1494SitLicOblIngMot ;
   private boolean[] T001D3_A1807EstadoCanPresen ;
   private boolean[] T001D3_A1809EstadoRemCorr ;
   private short[] T001D3_A1593SitPaiCod ;
   private boolean[] T001D3_n1593SitPaiCod ;
   private short[] T001D3_A1598EstadoSitRevista ;
   private boolean[] T001D3_n1598EstadoSitRevista ;
   private String[] T001D3_A1600EstadoSiniestro ;
   private boolean[] T001D3_n1600EstadoSiniestro ;
   private String[] T001D12_A16SitCodigo ;
   private String[] T001D13_A16SitCodigo ;
   private String[] T001D2_A685SitDescripSinAc ;
   private String[] T001D2_A16SitCodigo ;
   private String[] T001D2_A334SitDescrip ;
   private boolean[] T001D2_A738SitEsLicencia ;
   private boolean[] T001D2_A739SitLicCuentaTrab ;
   private byte[] T001D2_A897SitLicMesesProm ;
   private byte[] T001D2_A898SitLicMesesProm2 ;
   private String[] T001D2_A913sItDescAbrev ;
   private java.math.BigDecimal[] T001D2_A915SitDiasDivision ;
   private boolean[] T001D2_A916SitEsAusencia ;
   private byte[] T001D2_A1217SitAplicaPlus ;
   private boolean[] T001D2_A1220SitAbsorbeFer ;
   private short[] T001D2_A1489SitLicLimiteDef ;
   private boolean[] T001D2_A1490SitLicAdjunDef ;
   private boolean[] T001D2_A1491SitLicAdjOblDef ;
   private boolean[] T001D2_A1492SitLicNecApr ;
   private boolean[] T001D2_A1493SitLIcIngMot ;
   private boolean[] T001D2_A1494SitLicOblIngMot ;
   private boolean[] T001D2_A1807EstadoCanPresen ;
   private boolean[] T001D2_A1809EstadoRemCorr ;
   private short[] T001D2_A1593SitPaiCod ;
   private boolean[] T001D2_n1593SitPaiCod ;
   private short[] T001D2_A1598EstadoSitRevista ;
   private boolean[] T001D2_n1598EstadoSitRevista ;
   private String[] T001D2_A1600EstadoSiniestro ;
   private boolean[] T001D2_n1600EstadoSiniestro ;
   private int[] T001D17_A3CliCod ;
   private short[] T001D17_A1564CliPaiConve ;
   private String[] T001D17_A1565CliConvenio ;
   private String[] T001D17_A996ConveAdicod ;
   private String[] T001D17_A1824ConveAdiSitCancela ;
   private int[] T001D18_A3CliCod ;
   private short[] T001D18_A1564CliPaiConve ;
   private String[] T001D18_A1565CliConvenio ;
   private String[] T001D18_A1805ConveSitPresen ;
   private int[] T001D19_A3CliCod ;
   private short[] T001D19_A1EmpCod ;
   private int[] T001D19_A6LegNumero ;
   private java.util.Date[] T001D19_A76LegLicenIni ;
   private String[] T001D20_A16SitCodigo ;
   private short[] T001D21_A1598EstadoSitRevista ;
   private boolean[] T001D21_n1598EstadoSitRevista ;
   private String[] T001D22_A1600EstadoSiniestro ;
   private boolean[] T001D22_n1600EstadoSiniestro ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20EstadoSitRevista_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV27EstadoSiniestro_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class estado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001D2", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ?  FOR UPDATE OF Estado NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D3", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D4", "SELECT PaiCod AS SitPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D5", "SELECT SitRevCodigo AS EstadoSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D6", "SELECT SinieCodigo AS EstadoSiniestro FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D7", "SELECT TM1.SitDescripSinAc, TM1.SitCodigo, TM1.SitDescrip, TM1.SitEsLicencia, TM1.SitLicCuentaTrab, TM1.SitLicMesesProm, TM1.SitLicMesesProm2, TM1.sItDescAbrev, TM1.SitDiasDivision, TM1.SitEsAusencia, TM1.SitAplicaPlus, TM1.SitAbsorbeFer, TM1.SitLicLimiteDef, TM1.SitLicAdjunDef, TM1.SitLicAdjOblDef, TM1.SitLicNecApr, TM1.SitLIcIngMot, TM1.SitLicOblIngMot, TM1.EstadoCanPresen, TM1.EstadoRemCorr, TM1.SitPaiCod AS SitPaiCod, TM1.EstadoSitRevista AS EstadoSitRevista, TM1.EstadoSiniestro AS EstadoSiniestro FROM Estado TM1 WHERE TM1.SitCodigo = ( ?) ORDER BY TM1.SitCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D8", "SELECT SitRevCodigo AS EstadoSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D9", "SELECT SinieCodigo AS EstadoSiniestro FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D10", "SELECT PaiCod AS SitPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D11", "SELECT SitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D12", "SELECT SitCodigo FROM Estado WHERE ( SitCodigo > ( ?)) ORDER BY SitCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001D13", "SELECT SitCodigo FROM Estado WHERE ( SitCodigo < ( ?)) ORDER BY SitCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001D14", "SAVEPOINT gxupdate;INSERT INTO Estado(SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001D15", "SAVEPOINT gxupdate;UPDATE Estado SET SitDescripSinAc=?, SitDescrip=?, SitEsLicencia=?, SitLicCuentaTrab=?, SitLicMesesProm=?, SitLicMesesProm2=?, sItDescAbrev=?, SitDiasDivision=?, SitEsAusencia=?, SitAplicaPlus=?, SitAbsorbeFer=?, SitLicLimiteDef=?, SitLicAdjunDef=?, SitLicAdjOblDef=?, SitLicNecApr=?, SitLIcIngMot=?, SitLicOblIngMot=?, EstadoCanPresen=?, EstadoRemCorr=?, SitPaiCod=?, EstadoSitRevista=?, EstadoSiniestro=?  WHERE SitCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001D16", "SAVEPOINT gxupdate;DELETE FROM Estado  WHERE SitCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001D17", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE ConveAdiSitCancela = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001D18", "SELECT CliCod, CliPaiConve, CliConvenio, ConveSitPresen FROM convenio_estados_no_presen WHERE ConveSitPresen = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001D19", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE LegLicSitCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001D20", "SELECT SitCodigo FROM Estado ORDER BY SitCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D21", "SELECT SitRevCodigo AS EstadoSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001D22", "SELECT SinieCodigo AS EstadoSiniestro FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 4);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 4);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setBoolean(19, ((Boolean) parms[18]).booleanValue());
               stmt.setBoolean(20, ((Boolean) parms[19]).booleanValue());
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(21, ((Number) parms[21]).shortValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(22, ((Number) parms[23]).shortValue());
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[25], 4);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setBoolean(19, ((Boolean) parms[18]).booleanValue());
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[20]).shortValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(21, ((Number) parms[22]).shortValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(22, (String)parms[24], 4);
               }
               stmt.setString(23, (String)parms[25], 4);
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 17 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 19 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
      }
   }

}

