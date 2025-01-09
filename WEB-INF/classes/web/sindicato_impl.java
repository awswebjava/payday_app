package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sindicato_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action17") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_17_1B107( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"SINDESCRIPSINAC") == 0 )
      {
         A331SinDescrip = httpContext.GetPar( "SinDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A331SinDescrip", A331SinDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asasindescripsinac1B107( A331SinDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"PAICOD") == 0 )
      {
         AV18PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PaiCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PaiCod), "ZZZ9")));
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asapaicod1B107( AV18PaiCod, AV11CliCod, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"ACTCOMCODIGO") == 0 )
      {
         AV17Insert_ActComCodigo = httpContext.GetPar( "Insert_ActComCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_ActComCodigo", AV17Insert_ActComCodigo);
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx8asaactcomcodigo1B107( AV17Insert_ActComCodigo, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A903ActComCodigo = httpContext.GetPar( "ActComCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A903ActComCodigo) ;
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
            AV18PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PaiCod), "ZZZ9")));
            AV7SinCod = httpContext.GetPar( "SinCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SinCod", AV7SinCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSINCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SinCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Sindicato", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public sindicato_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sindicato_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sindicato_impl.class ));
   }

   public sindicato_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynActComCodigo = new HTMLChoice();
      chkSinDefault = UIFactory.getCheckbox(this);
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
      if ( dynActComCodigo.getItemCount() > 0 )
      {
         A903ActComCodigo = dynActComCodigo.getValidValue(A903ActComCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynActComCodigo.setValue( GXutil.rtrim( A903ActComCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynActComCodigo.getInternalname(), "Values", dynActComCodigo.ToJavascriptSource(), true);
      }
      A906SinDefault = GXutil.strtobool( GXutil.booltostr( A906SinDefault)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Sindicato", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynActComCodigo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynActComCodigo.getInternalname(), httpContext.getMessage( "Actividad comercial", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynActComCodigo, dynActComCodigo.getInternalname(), GXutil.rtrim( A903ActComCodigo), 1, dynActComCodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynActComCodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "", true, (byte)(0), "HLP_Sindicato.htm");
      dynActComCodigo.setValue( GXutil.rtrim( A903ActComCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynActComCodigo.getInternalname(), "Values", dynActComCodigo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSinCod_Internalname, GXutil.rtrim( A14SinCod), GXutil.rtrim( localUtil.format( A14SinCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSinCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSinCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtSinDescrip_Internalname, A331SinDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtSinDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinSigla_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinSigla_Internalname, httpContext.getMessage( "Sigla", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSinSigla_Internalname, A1647SinSigla, GXutil.rtrim( localUtil.format( A1647SinSigla, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSinSigla_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSinSigla_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSinCuotaAli_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSinCuotaAli_Internalname, httpContext.getMessage( "Alícuota Cuota Sindical", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSinCuotaAli_Internalname, GXutil.ltrim( localUtil.ntoc( A930SinCuotaAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSinCuotaAli_Enabled!=0) ? localUtil.format( A930SinCuotaAli, "9.9999") : localUtil.format( A930SinCuotaAli, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSinCuotaAli_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSinCuotaAli_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSinDefault.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSinDefault.getInternalname(), httpContext.getMessage( "Default", ""), " AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSinDefault.getInternalname(), GXutil.booltostr( A906SinDefault), "", httpContext.getMessage( "Default", ""), 1, chkSinDefault.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(53, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,53);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sindicato.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sindicato.htm");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Sindicato.htm");
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
      e111B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z14SinCod = httpContext.cgiGet( "Z14SinCod") ;
            Z680SinDescripSinAc = httpContext.cgiGet( "Z680SinDescripSinAc") ;
            Z331SinDescrip = httpContext.cgiGet( "Z331SinDescrip") ;
            Z332SinHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z332SinHabilitado")) ;
            Z906SinDefault = GXutil.strtobool( httpContext.cgiGet( "Z906SinDefault")) ;
            Z930SinCuotaAli = localUtil.ctond( httpContext.cgiGet( "Z930SinCuotaAli")) ;
            Z1647SinSigla = httpContext.cgiGet( "Z1647SinSigla") ;
            Z903ActComCodigo = httpContext.cgiGet( "Z903ActComCodigo") ;
            A680SinDescripSinAc = httpContext.cgiGet( "Z680SinDescripSinAc") ;
            A332SinHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z332SinHabilitado")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N903ActComCodigo = httpContext.cgiGet( "N903ActComCodigo") ;
            A680SinDescripSinAc = httpContext.cgiGet( "SINDESCRIPSINAC") ;
            AV18PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7SinCod = httpContext.cgiGet( "vSINCOD") ;
            AV17Insert_ActComCodigo = httpContext.cgiGet( "vINSERT_ACTCOMCODIGO") ;
            A332SinHabilitado = GXutil.strtobool( httpContext.cgiGet( "SINHABILITADO")) ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynActComCodigo.setValue( httpContext.cgiGet( dynActComCodigo.getInternalname()) );
            A903ActComCodigo = httpContext.cgiGet( dynActComCodigo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
            A14SinCod = httpContext.cgiGet( edtSinCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
            A331SinDescrip = httpContext.cgiGet( edtSinDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A331SinDescrip", A331SinDescrip);
            A1647SinSigla = httpContext.cgiGet( edtSinSigla_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1647SinSigla", A1647SinSigla);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtSinCuotaAli_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtSinCuotaAli_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SINCUOTAALI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSinCuotaAli_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A930SinCuotaAli = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A930SinCuotaAli", GXutil.ltrimstr( A930SinCuotaAli, 6, 4));
            }
            else
            {
               A930SinCuotaAli = localUtil.ctond( httpContext.cgiGet( edtSinCuotaAli_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A930SinCuotaAli", GXutil.ltrimstr( A930SinCuotaAli, 6, 4));
            }
            A906SinDefault = GXutil.strtobool( httpContext.cgiGet( chkSinDefault.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Sindicato");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SinHabilitado", GXutil.booltostr( A332SinHabilitado));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A14SinCod, Z14SinCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("sindicato:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A14SinCod = httpContext.GetPar( "SinCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
               getEqualNoModal( ) ;
               if ( ! (0==AV18PaiCod) )
               {
                  A46PaiCod = AV18PaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               }
               else
               {
                  if ( isIns( )  && (0==A46PaiCod) && ( Gx_BScreen == 0 ) )
                  {
                     GXt_int1 = A46PaiCod ;
                     GXv_int2[0] = GXt_int1 ;
                     new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
                     sindicato_impl.this.GXt_int1 = GXv_int2[0] ;
                     A46PaiCod = GXt_int1 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode107 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (0==AV18PaiCod) )
                  {
                     A46PaiCod = AV18PaiCod ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
                  else
                  {
                     if ( isIns( )  && (0==A46PaiCod) && ( Gx_BScreen == 0 ) )
                     {
                        GXt_int1 = A46PaiCod ;
                        GXv_int2[0] = GXt_int1 ;
                        new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
                        sindicato_impl.this.GXt_int1 = GXv_int2[0] ;
                        A46PaiCod = GXt_int1 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                     }
                  }
                  Gx_mode = sMode107 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound107 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1B0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
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
                        e111B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121B2 ();
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
         e121B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1B107( ) ;
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
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1B107( ) ;
      }
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

   public void confirm_1B0( )
   {
      beforeValidate1B107( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1B107( ) ;
         }
         else
         {
            checkExtendedTable1B107( ) ;
            closeExtendedTableCursors1B107( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1B0( )
   {
   }

   public void e111B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV8WWPContext = GXv_SdtWWPContext3[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSindicato_Insert", GXv_boolean5) ;
         sindicato_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSindicato_Update", GXv_boolean5) ;
         sindicato_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSindicato_Delete", GXv_boolean5) ;
         sindicato_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV20Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV21GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21GXV1), 8, 0));
         while ( AV21GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV21GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ActComCodigo") == 0 )
            {
               AV17Insert_ActComCodigo = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_ActComCodigo", AV17Insert_ActComCodigo);
            }
            AV21GXV1 = (int)(AV21GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21GXV1), 8, 0));
         }
      }
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e121B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1B107( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z680SinDescripSinAc = T001B3_A680SinDescripSinAc[0] ;
            Z331SinDescrip = T001B3_A331SinDescrip[0] ;
            Z332SinHabilitado = T001B3_A332SinHabilitado[0] ;
            Z906SinDefault = T001B3_A906SinDefault[0] ;
            Z930SinCuotaAli = T001B3_A930SinCuotaAli[0] ;
            Z1647SinSigla = T001B3_A1647SinSigla[0] ;
            Z903ActComCodigo = T001B3_A903ActComCodigo[0] ;
         }
         else
         {
            Z680SinDescripSinAc = A680SinDescripSinAc ;
            Z331SinDescrip = A331SinDescrip ;
            Z332SinHabilitado = A332SinHabilitado ;
            Z906SinDefault = A906SinDefault ;
            Z930SinCuotaAli = A930SinCuotaAli ;
            Z1647SinSigla = A1647SinSigla ;
            Z903ActComCodigo = A903ActComCodigo ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z680SinDescripSinAc = A680SinDescripSinAc ;
         Z14SinCod = A14SinCod ;
         Z331SinDescrip = A331SinDescrip ;
         Z332SinHabilitado = A332SinHabilitado ;
         Z906SinDefault = A906SinDefault ;
         Z930SinCuotaAli = A930SinCuotaAli ;
         Z1647SinSigla = A1647SinSigla ;
         Z46PaiCod = A46PaiCod ;
         Z903ActComCodigo = A903ActComCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      GXv_int6[0] = AV11CliCod ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      sindicato_impl.this.AV11CliCod = GXv_int6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV18PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV18PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SinCod)==0) )
      {
         A14SinCod = AV7SinCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
      }
      if ( ! (GXutil.strcmp("", AV7SinCod)==0) )
      {
         edtSinCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinCod_Enabled), 5, 0), true);
      }
      else
      {
         edtSinCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SinCod)==0) )
      {
         edtSinCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSinCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_ActComCodigo)==0) )
      {
         dynActComCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynActComCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynActComCodigo.getEnabled(), 5, 0), true);
      }
      else
      {
         dynActComCodigo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynActComCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynActComCodigo.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_ActComCodigo)==0) )
      {
         A903ActComCodigo = AV17Insert_ActComCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A903ActComCodigo)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char7 = A903ActComCodigo ;
            GXv_char8[0] = GXt_char7 ;
            new web.actcomconstruccion(remoteHandle, context).execute( GXv_char8) ;
            sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
            A903ActComCodigo = GXt_char7 ;
            httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         }
      }
      if ( isIns( )  && (false==A332SinHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A332SinHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A332SinHabilitado", A332SinHabilitado);
      }
      if ( ! (0==AV18PaiCod) )
      {
         A46PaiCod = AV18PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  && (0==A46PaiCod) && ( Gx_BScreen == 0 ) )
         {
            GXt_int1 = A46PaiCod ;
            GXv_int2[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
            sindicato_impl.this.GXt_int1 = GXv_int2[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV20Pgmname = "Sindicato" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load1B107( )
   {
      /* Using cursor T001B6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound107 = (short)(1) ;
         A680SinDescripSinAc = T001B6_A680SinDescripSinAc[0] ;
         A331SinDescrip = T001B6_A331SinDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A331SinDescrip", A331SinDescrip);
         A332SinHabilitado = T001B6_A332SinHabilitado[0] ;
         A906SinDefault = T001B6_A906SinDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
         A930SinCuotaAli = T001B6_A930SinCuotaAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A930SinCuotaAli", GXutil.ltrimstr( A930SinCuotaAli, 6, 4));
         A1647SinSigla = T001B6_A1647SinSigla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1647SinSigla", A1647SinSigla);
         A903ActComCodigo = T001B6_A903ActComCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         zm1B107( -18) ;
      }
      pr_default.close(4);
      onLoadActions1B107( ) ;
   }

   public void onLoadActions1B107( )
   {
      AV20Pgmname = "Sindicato" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      GXt_char7 = A680SinDescripSinAc ;
      GXv_char8[0] = GXt_char7 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char8) ;
      sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
      A680SinDescripSinAc = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri("", false, "A680SinDescripSinAc", A680SinDescripSinAc);
   }

   public void checkExtendedTable1B107( )
   {
      nIsDirty_107 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV20Pgmname = "Sindicato" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T001B4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( (GXutil.strcmp("", A14SinCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Sindicato", ""), "", "", "", "", "", "", "", ""), 1, "SINCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSinCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_107 = (short)(1) ;
      GXt_char7 = A680SinDescripSinAc ;
      GXv_char8[0] = GXt_char7 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char8) ;
      sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
      A680SinDescripSinAc = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri("", false, "A680SinDescripSinAc", A680SinDescripSinAc);
      if ( (GXutil.strcmp("", A331SinDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Sindicato", ""), "", "", "", "", "", "", "", ""), 1, "SINDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSinDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T001B5 */
      pr_default.execute(3, new Object[] {A903ActComCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "actividadcomercial", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( (GXutil.strcmp("", A903ActComCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad comercial", ""), "", "", "", "", "", "", "", ""), 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1B107( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( short A46PaiCod )
   {
      /* Using cursor T001B7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_20( String A903ActComCodigo )
   {
      /* Using cursor T001B8 */
      pr_default.execute(6, new Object[] {A903ActComCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "actividadcomercial", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void getKey1B107( )
   {
      /* Using cursor T001B9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound107 = (short)(1) ;
      }
      else
      {
         RcdFound107 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001B3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1B107( 18) ;
         RcdFound107 = (short)(1) ;
         A680SinDescripSinAc = T001B3_A680SinDescripSinAc[0] ;
         A14SinCod = T001B3_A14SinCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
         A331SinDescrip = T001B3_A331SinDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A331SinDescrip", A331SinDescrip);
         A332SinHabilitado = T001B3_A332SinHabilitado[0] ;
         A906SinDefault = T001B3_A906SinDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
         A930SinCuotaAli = T001B3_A930SinCuotaAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A930SinCuotaAli", GXutil.ltrimstr( A930SinCuotaAli, 6, 4));
         A1647SinSigla = T001B3_A1647SinSigla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1647SinSigla", A1647SinSigla);
         A46PaiCod = T001B3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A903ActComCodigo = T001B3_A903ActComCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         Z46PaiCod = A46PaiCod ;
         Z14SinCod = A14SinCod ;
         sMode107 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1B107( ) ;
         if ( AnyError == 1 )
         {
            RcdFound107 = (short)(0) ;
            initializeNonKey1B107( ) ;
         }
         Gx_mode = sMode107 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound107 = (short)(0) ;
         initializeNonKey1B107( ) ;
         sMode107 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode107 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1B107( ) ;
      if ( RcdFound107 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound107 = (short)(0) ;
      /* Using cursor T001B10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A14SinCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001B10_A46PaiCod[0] < A46PaiCod ) || ( T001B10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001B10_A14SinCod[0], A14SinCod) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001B10_A46PaiCod[0] > A46PaiCod ) || ( T001B10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001B10_A14SinCod[0], A14SinCod) > 0 ) ) )
         {
            A46PaiCod = T001B10_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A14SinCod = T001B10_A14SinCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
            RcdFound107 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound107 = (short)(0) ;
      /* Using cursor T001B11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A14SinCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001B11_A46PaiCod[0] > A46PaiCod ) || ( T001B11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001B11_A14SinCod[0], A14SinCod) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001B11_A46PaiCod[0] < A46PaiCod ) || ( T001B11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001B11_A14SinCod[0], A14SinCod) < 0 ) ) )
         {
            A46PaiCod = T001B11_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A14SinCod = T001B11_A14SinCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
            RcdFound107 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1B107( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1B107( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound107 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A14SinCod, Z14SinCod) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A14SinCod = Z14SinCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynActComCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1B107( ) ;
               GX_FocusControl = dynActComCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A14SinCod, Z14SinCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = dynActComCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1B107( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = dynActComCodigo.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1B107( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A14SinCod, Z14SinCod) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A14SinCod = Z14SinCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1B107( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001B2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sindicato"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z680SinDescripSinAc, T001B2_A680SinDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z331SinDescrip, T001B2_A331SinDescrip[0]) != 0 ) || ( Z332SinHabilitado != T001B2_A332SinHabilitado[0] ) || ( Z906SinDefault != T001B2_A906SinDefault[0] ) || ( DecimalUtil.compareTo(Z930SinCuotaAli, T001B2_A930SinCuotaAli[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1647SinSigla, T001B2_A1647SinSigla[0]) != 0 ) || ( GXutil.strcmp(Z903ActComCodigo, T001B2_A903ActComCodigo[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z680SinDescripSinAc, T001B2_A680SinDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z680SinDescripSinAc);
               GXutil.writeLogRaw("Current: ",T001B2_A680SinDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z331SinDescrip, T001B2_A331SinDescrip[0]) != 0 )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinDescrip");
               GXutil.writeLogRaw("Old: ",Z331SinDescrip);
               GXutil.writeLogRaw("Current: ",T001B2_A331SinDescrip[0]);
            }
            if ( Z332SinHabilitado != T001B2_A332SinHabilitado[0] )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinHabilitado");
               GXutil.writeLogRaw("Old: ",Z332SinHabilitado);
               GXutil.writeLogRaw("Current: ",T001B2_A332SinHabilitado[0]);
            }
            if ( Z906SinDefault != T001B2_A906SinDefault[0] )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinDefault");
               GXutil.writeLogRaw("Old: ",Z906SinDefault);
               GXutil.writeLogRaw("Current: ",T001B2_A906SinDefault[0]);
            }
            if ( DecimalUtil.compareTo(Z930SinCuotaAli, T001B2_A930SinCuotaAli[0]) != 0 )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinCuotaAli");
               GXutil.writeLogRaw("Old: ",Z930SinCuotaAli);
               GXutil.writeLogRaw("Current: ",T001B2_A930SinCuotaAli[0]);
            }
            if ( GXutil.strcmp(Z1647SinSigla, T001B2_A1647SinSigla[0]) != 0 )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"SinSigla");
               GXutil.writeLogRaw("Old: ",Z1647SinSigla);
               GXutil.writeLogRaw("Current: ",T001B2_A1647SinSigla[0]);
            }
            if ( GXutil.strcmp(Z903ActComCodigo, T001B2_A903ActComCodigo[0]) != 0 )
            {
               GXutil.writeLogln("sindicato:[seudo value changed for attri]"+"ActComCodigo");
               GXutil.writeLogRaw("Old: ",Z903ActComCodigo);
               GXutil.writeLogRaw("Current: ",T001B2_A903ActComCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Sindicato"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1B107( )
   {
      beforeValidate1B107( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1B107( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1B107( 0) ;
         checkOptimisticConcurrency1B107( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1B107( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1B107( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001B12 */
                  pr_default.execute(10, new Object[] {A680SinDescripSinAc, A14SinCod, A331SinDescrip, Boolean.valueOf(A332SinHabilitado), Boolean.valueOf(A906SinDefault), A930SinCuotaAli, A1647SinSigla, Short.valueOf(A46PaiCod), A903ActComCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sindicato");
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
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1B0( ) ;
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
            load1B107( ) ;
         }
         endLevel1B107( ) ;
      }
      closeExtendedTableCursors1B107( ) ;
   }

   public void update1B107( )
   {
      beforeValidate1B107( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1B107( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1B107( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1B107( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1B107( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001B13 */
                  pr_default.execute(11, new Object[] {A680SinDescripSinAc, A331SinDescrip, Boolean.valueOf(A332SinHabilitado), Boolean.valueOf(A906SinDefault), A930SinCuotaAli, A1647SinSigla, A903ActComCodigo, Short.valueOf(A46PaiCod), A14SinCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sindicato");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sindicato"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1B107( ) ;
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
         endLevel1B107( ) ;
      }
      closeExtendedTableCursors1B107( ) ;
   }

   public void deferredUpdate1B107( )
   {
   }

   public void delete( )
   {
      beforeValidate1B107( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1B107( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1B107( ) ;
         afterConfirm1B107( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1B107( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001B14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Sindicato");
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
      sMode107 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1B107( ) ;
      Gx_mode = sMode107 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1B107( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "Sindicato" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001B15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T001B16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod), A14SinCod});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel1B107( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1B107( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "sindicato");
         if ( AnyError == 0 )
         {
            confirmValues1B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "sindicato");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1B107( )
   {
      /* Scan By routine */
      /* Using cursor T001B17 */
      pr_default.execute(15);
      RcdFound107 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound107 = (short)(1) ;
         A46PaiCod = T001B17_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A14SinCod = T001B17_A14SinCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1B107( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound107 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound107 = (short)(1) ;
         A46PaiCod = T001B17_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A14SinCod = T001B17_A14SinCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
      }
   }

   public void scanEnd1B107( )
   {
      pr_default.close(15);
   }

   public void afterConfirm1B107( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1B107( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1B107( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1B107( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1B107( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1B107( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1B107( )
   {
      dynActComCodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynActComCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynActComCodigo.getEnabled(), 5, 0), true);
      edtSinCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinCod_Enabled), 5, 0), true);
      edtSinDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinDescrip_Enabled), 5, 0), true);
      edtSinSigla_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinSigla_Enabled), 5, 0), true);
      edtSinCuotaAli_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSinCuotaAli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSinCuotaAli_Enabled), 5, 0), true);
      chkSinDefault.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSinDefault.getInternalname(), "Enabled", GXutil.ltrimstr( chkSinDefault.getEnabled(), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1B107( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1B0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.sindicato", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV18PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV7SinCod))}, new String[] {"Gx_mode","PaiCod","SinCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Sindicato");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SinHabilitado", GXutil.booltostr( A332SinHabilitado));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("sindicato:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z14SinCod", GXutil.rtrim( Z14SinCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z680SinDescripSinAc", Z680SinDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z331SinDescrip", Z331SinDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z332SinHabilitado", Z332SinHabilitado);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z906SinDefault", Z906SinDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "Z930SinCuotaAli", GXutil.ltrim( localUtil.ntoc( Z930SinCuotaAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1647SinSigla", Z1647SinSigla);
      web.GxWebStd.gx_hidden_field( httpContext, "Z903ActComCodigo", GXutil.rtrim( Z903ActComCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N903ActComCodigo", GXutil.rtrim( A903ActComCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "SINDESCRIPSINAC", A680SinDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV18PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSINCOD", GXutil.rtrim( AV7SinCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSINCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SinCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ACTCOMCODIGO", GXutil.rtrim( AV17Insert_ActComCodigo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SINHABILITADO", A332SinHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
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
      return formatLink("web.sindicato", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV18PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV7SinCod))}, new String[] {"Gx_mode","PaiCod","SinCod"})  ;
   }

   public String getPgmname( )
   {
      return "Sindicato" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Sindicato", "") ;
   }

   public void initializeNonKey1B107( )
   {
      A680SinDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A680SinDescripSinAc", A680SinDescripSinAc);
      A331SinDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A331SinDescrip", A331SinDescrip);
      A906SinDefault = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
      A930SinCuotaAli = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A930SinCuotaAli", GXutil.ltrimstr( A930SinCuotaAli, 6, 4));
      A1647SinSigla = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1647SinSigla", A1647SinSigla);
      A903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
      A332SinHabilitado = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A332SinHabilitado", A332SinHabilitado);
      Z680SinDescripSinAc = "" ;
      Z331SinDescrip = "" ;
      Z332SinHabilitado = false ;
      Z906SinDefault = false ;
      Z930SinCuotaAli = DecimalUtil.ZERO ;
      Z1647SinSigla = "" ;
      Z903ActComCodigo = "" ;
   }

   public void initAll1B107( )
   {
      A46PaiCod = new web.clientegetpais(remoteHandle, context).executeUdp( AV11CliCod) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A14SinCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A14SinCod", A14SinCod);
      initializeNonKey1B107( ) ;
   }

   public void standaloneModalInsert( )
   {
      A903ActComCodigo = i903ActComCodigo ;
      httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
      A332SinHabilitado = i332SinHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A332SinHabilitado", A332SinHabilitado);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171842039", true, true);
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
      httpContext.AddJavascriptSource("sindicato.js", "?2025171842039", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      dynActComCodigo.setInternalname( "ACTCOMCODIGO" );
      edtSinCod_Internalname = "SINCOD" ;
      edtSinDescrip_Internalname = "SINDESCRIP" ;
      edtSinSigla_Internalname = "SINSIGLA" ;
      edtSinCuotaAli_Internalname = "SINCUOTAALI" ;
      chkSinDefault.setInternalname( "SINDEFAULT" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtPaiCod_Internalname = "PAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Sindicato", "") );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkSinDefault.setEnabled( 1 );
      edtSinCuotaAli_Jsonclick = "" ;
      edtSinCuotaAli_Enabled = 1 ;
      edtSinSigla_Jsonclick = "" ;
      edtSinSigla_Enabled = 1 ;
      edtSinDescrip_Enabled = 1 ;
      edtSinCod_Jsonclick = "" ;
      edtSinCod_Enabled = 1 ;
      dynActComCodigo.setJsonclick( "" );
      dynActComCodigo.setEnabled( 1 );
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

   public void gxdlaactcomcodigo1B1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaactcomcodigo_data1B1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaactcomcodigo_html1B1( )
   {
      String gxdynajaxvalue;
      gxdlaactcomcodigo_data1B1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynActComCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynActComCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaactcomcodigo_data1B1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T001B18 */
      pr_default.execute(16);
      while ( (pr_default.getStatus(16) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T001B18_A903ActComCodigo[0]));
         gxdynajaxctrldescr.add(T001B18_A904ActComDescripcion[0]);
         pr_default.readNext(16);
      }
      pr_default.close(16);
   }

   public void gx3asasindescripsinac1B107( String A331SinDescrip )
   {
      GXt_char7 = A680SinDescripSinAc ;
      GXv_char8[0] = GXt_char7 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char8) ;
      sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
      A680SinDescripSinAc = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri("", false, "A680SinDescripSinAc", A680SinDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A680SinDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx4asapaicod1B107( short AV18PaiCod ,
                                  int AV11CliCod ,
                                  byte Gx_BScreen )
   {
      if ( ! (0==AV18PaiCod) )
      {
         A46PaiCod = AV18PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  && (0==A46PaiCod) && ( Gx_BScreen == 0 ) )
         {
            GXt_int1 = A46PaiCod ;
            GXv_int2[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
            sindicato_impl.this.GXt_int1 = GXv_int2[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx8asaactcomcodigo1B107( String AV17Insert_ActComCodigo ,
                                        byte Gx_BScreen )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_ActComCodigo)==0) )
      {
         A903ActComCodigo = AV17Insert_ActComCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A903ActComCodigo)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char7 = A903ActComCodigo ;
            GXv_char8[0] = GXt_char7 ;
            new web.actcomconstruccion(remoteHandle, context).execute( GXv_char8) ;
            sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
            A903ActComCodigo = GXt_char7 ;
            httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A903ActComCodigo))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_17_1B107( )
   {
      GXv_int6[0] = AV11CliCod ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      AV11CliCod = GXv_int6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
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
      dynActComCodigo.setName( "ACTCOMCODIGO" );
      dynActComCodigo.setWebtags( "" );
      dynActComCodigo.removeAllItems();
      /* Using cursor T001B19 */
      pr_default.execute(17);
      while ( (pr_default.getStatus(17) != 101) )
      {
         dynActComCodigo.addItem(T001B19_A903ActComCodigo[0], T001B19_A904ActComDescripcion[0], (short)(0));
         pr_default.readNext(17);
      }
      pr_default.close(17);
      if ( dynActComCodigo.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A903ActComCodigo)==0) )
         {
            A903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
            httpContext.ajax_rsp_assign_attri("", false, "A903ActComCodigo", A903ActComCodigo);
         }
      }
      chkSinDefault.setName( "SINDEFAULT" );
      chkSinDefault.setWebtags( "" );
      chkSinDefault.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSinDefault.getInternalname(), "TitleCaption", chkSinDefault.getCaption(), true);
      chkSinDefault.setCheckedValue( "false" );
      A906SinDefault = GXutil.strtobool( GXutil.booltostr( A906SinDefault)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A906SinDefault", A906SinDefault);
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

   public void valid_Paicod( )
   {
      A903ActComCodigo = dynActComCodigo.getValue() ;
      /* Using cursor T001B20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Actcomcodigo( )
   {
      A903ActComCodigo = dynActComCodigo.getValue() ;
      /* Using cursor T001B21 */
      pr_default.execute(19, new Object[] {A903ActComCodigo});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "actividadcomercial", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
      }
      pr_default.close(19);
      if ( (GXutil.strcmp("", A903ActComCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad comercial", ""), "", "", "", "", "", "", "", ""), 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynActComCodigo.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Sindescrip( )
   {
      A903ActComCodigo = dynActComCodigo.getValue() ;
      GXt_char7 = A680SinDescripSinAc ;
      GXv_char8[0] = GXt_char7 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char8) ;
      sindicato_impl.this.GXt_char7 = GXv_char8[0] ;
      A680SinDescripSinAc = GXt_char7 ;
      if ( (GXutil.strcmp("", A331SinDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Sindicato", ""), "", "", "", "", "", "", "", ""), 1, "SINDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSinDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A680SinDescripSinAc", A680SinDescripSinAc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV18PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV7SinCod',fld:'vSINCOD',pic:'',hsh:true},{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV18PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV7SinCod',fld:'vSINCOD',pic:'',hsh:true},{av:'A332SinHabilitado',fld:'SINHABILITADO',pic:''},{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121B2',iparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("VALID_ACTCOMCODIGO","{handler:'valid_Actcomcodigo',iparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("VALID_ACTCOMCODIGO",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("VALID_SINCOD","{handler:'valid_Sincod',iparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("VALID_SINCOD",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("VALID_SINDESCRIP","{handler:'valid_Sindescrip',iparms:[{av:'A331SinDescrip',fld:'SINDESCRIP',pic:''},{av:'A680SinDescripSinAc',fld:'SINDESCRIPSINAC',pic:''},{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("VALID_SINDESCRIP",",oparms:[{av:'A680SinDescripSinAc',fld:'SINDESCRIPSINAC',pic:''},{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'dynActComCodigo'},{av:'A903ActComCodigo',fld:'ACTCOMCODIGO',pic:''},{av:'A906SinDefault',fld:'SINDEFAULT',pic:''}]}");
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
      return "sindicato_Execute";
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
      pr_default.close(18);
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7SinCod = "" ;
      Z14SinCod = "" ;
      Z680SinDescripSinAc = "" ;
      Z331SinDescrip = "" ;
      Z930SinCuotaAli = DecimalUtil.ZERO ;
      Z1647SinSigla = "" ;
      Z903ActComCodigo = "" ;
      N903ActComCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A331SinDescrip = "" ;
      AV17Insert_ActComCodigo = "" ;
      A903ActComCodigo = "" ;
      Gx_mode = "" ;
      AV7SinCod = "" ;
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
      A14SinCod = "" ;
      A1647SinSigla = "" ;
      A930SinCuotaAli = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A680SinDescripSinAc = "" ;
      AV20Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode107 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      T001B6_A680SinDescripSinAc = new String[] {""} ;
      T001B6_A14SinCod = new String[] {""} ;
      T001B6_A331SinDescrip = new String[] {""} ;
      T001B6_A332SinHabilitado = new boolean[] {false} ;
      T001B6_A906SinDefault = new boolean[] {false} ;
      T001B6_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001B6_A1647SinSigla = new String[] {""} ;
      T001B6_A46PaiCod = new short[1] ;
      T001B6_A903ActComCodigo = new String[] {""} ;
      T001B4_A46PaiCod = new short[1] ;
      T001B5_A903ActComCodigo = new String[] {""} ;
      T001B7_A46PaiCod = new short[1] ;
      T001B8_A903ActComCodigo = new String[] {""} ;
      T001B9_A46PaiCod = new short[1] ;
      T001B9_A14SinCod = new String[] {""} ;
      T001B3_A680SinDescripSinAc = new String[] {""} ;
      T001B3_A14SinCod = new String[] {""} ;
      T001B3_A331SinDescrip = new String[] {""} ;
      T001B3_A332SinHabilitado = new boolean[] {false} ;
      T001B3_A906SinDefault = new boolean[] {false} ;
      T001B3_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001B3_A1647SinSigla = new String[] {""} ;
      T001B3_A46PaiCod = new short[1] ;
      T001B3_A903ActComCodigo = new String[] {""} ;
      T001B10_A46PaiCod = new short[1] ;
      T001B10_A14SinCod = new String[] {""} ;
      T001B11_A46PaiCod = new short[1] ;
      T001B11_A14SinCod = new String[] {""} ;
      T001B2_A680SinDescripSinAc = new String[] {""} ;
      T001B2_A14SinCod = new String[] {""} ;
      T001B2_A331SinDescrip = new String[] {""} ;
      T001B2_A332SinHabilitado = new boolean[] {false} ;
      T001B2_A906SinDefault = new boolean[] {false} ;
      T001B2_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001B2_A1647SinSigla = new String[] {""} ;
      T001B2_A46PaiCod = new short[1] ;
      T001B2_A903ActComCodigo = new String[] {""} ;
      T001B15_A46PaiCod = new short[1] ;
      T001B15_A9ConveCodigo = new String[] {""} ;
      T001B16_A3CliCod = new int[1] ;
      T001B16_A1EmpCod = new short[1] ;
      T001B16_A6LegNumero = new int[1] ;
      T001B17_A46PaiCod = new short[1] ;
      T001B17_A14SinCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i903ActComCodigo = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T001B18_A903ActComCodigo = new String[] {""} ;
      T001B18_A904ActComDescripcion = new String[] {""} ;
      GXv_int2 = new short[1] ;
      GXv_int6 = new int[1] ;
      T001B19_A903ActComCodigo = new String[] {""} ;
      T001B19_A904ActComDescripcion = new String[] {""} ;
      T001B20_A46PaiCod = new short[1] ;
      T001B21_A903ActComCodigo = new String[] {""} ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sindicato__default(),
         new Object[] {
             new Object[] {
            T001B2_A680SinDescripSinAc, T001B2_A14SinCod, T001B2_A331SinDescrip, T001B2_A332SinHabilitado, T001B2_A906SinDefault, T001B2_A930SinCuotaAli, T001B2_A1647SinSigla, T001B2_A46PaiCod, T001B2_A903ActComCodigo
            }
            , new Object[] {
            T001B3_A680SinDescripSinAc, T001B3_A14SinCod, T001B3_A331SinDescrip, T001B3_A332SinHabilitado, T001B3_A906SinDefault, T001B3_A930SinCuotaAli, T001B3_A1647SinSigla, T001B3_A46PaiCod, T001B3_A903ActComCodigo
            }
            , new Object[] {
            T001B4_A46PaiCod
            }
            , new Object[] {
            T001B5_A903ActComCodigo
            }
            , new Object[] {
            T001B6_A680SinDescripSinAc, T001B6_A14SinCod, T001B6_A331SinDescrip, T001B6_A332SinHabilitado, T001B6_A906SinDefault, T001B6_A930SinCuotaAli, T001B6_A1647SinSigla, T001B6_A46PaiCod, T001B6_A903ActComCodigo
            }
            , new Object[] {
            T001B7_A46PaiCod
            }
            , new Object[] {
            T001B8_A903ActComCodigo
            }
            , new Object[] {
            T001B9_A46PaiCod, T001B9_A14SinCod
            }
            , new Object[] {
            T001B10_A46PaiCod, T001B10_A14SinCod
            }
            , new Object[] {
            T001B11_A46PaiCod, T001B11_A14SinCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001B15_A46PaiCod, T001B15_A9ConveCodigo
            }
            , new Object[] {
            T001B16_A3CliCod, T001B16_A1EmpCod, T001B16_A6LegNumero
            }
            , new Object[] {
            T001B17_A46PaiCod, T001B17_A14SinCod
            }
            , new Object[] {
            T001B18_A903ActComCodigo, T001B18_A904ActComDescripcion
            }
            , new Object[] {
            T001B19_A903ActComCodigo, T001B19_A904ActComDescripcion
            }
            , new Object[] {
            T001B20_A46PaiCod
            }
            , new Object[] {
            T001B21_A903ActComCodigo
            }
         }
      );
      AV20Pgmname = "Sindicato" ;
      Z46PaiCod = (short)(0) ;
      A46PaiCod = (short)(0) ;
      Z903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
      N903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
      i903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
      A903ActComCodigo = new web.actcomconstruccion(remoteHandle, context).executeUdp( ) ;
      Z332SinHabilitado = true ;
      A332SinHabilitado = true ;
      i332SinHabilitado = true ;
   }

   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte gxajaxcallmode ;
   private short wcpOAV18PaiCod ;
   private short Z46PaiCod ;
   private short AV18PaiCod ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound107 ;
   private short nIsDirty_107 ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int AV11CliCod ;
   private int trnEnded ;
   private int edtSinCod_Enabled ;
   private int edtSinDescrip_Enabled ;
   private int edtSinSigla_Enabled ;
   private int edtSinCuotaAli_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV21GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXv_int6[] ;
   private java.math.BigDecimal Z930SinCuotaAli ;
   private java.math.BigDecimal A930SinCuotaAli ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7SinCod ;
   private String Z14SinCod ;
   private String Z903ActComCodigo ;
   private String N903ActComCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV17Insert_ActComCodigo ;
   private String A903ActComCodigo ;
   private String Gx_mode ;
   private String AV7SinCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String divTableheader_Internalname ;
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
   private String edtSinCod_Internalname ;
   private String A14SinCod ;
   private String edtSinCod_Jsonclick ;
   private String edtSinDescrip_Internalname ;
   private String edtSinSigla_Internalname ;
   private String edtSinSigla_Jsonclick ;
   private String edtSinCuotaAli_Internalname ;
   private String edtSinCuotaAli_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String AV20Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode107 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i903ActComCodigo ;
   private String gxwrpcisep ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private boolean Z332SinHabilitado ;
   private boolean Z906SinDefault ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A906SinDefault ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A332SinHabilitado ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private boolean i332SinHabilitado ;
   private boolean gxdyncontrolsrefreshing ;
   private String Z680SinDescripSinAc ;
   private String Z331SinDescrip ;
   private String Z1647SinSigla ;
   private String A331SinDescrip ;
   private String A1647SinSigla ;
   private String A680SinDescripSinAc ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynActComCodigo ;
   private ICheckbox chkSinDefault ;
   private IDataStoreProvider pr_default ;
   private String[] T001B6_A680SinDescripSinAc ;
   private String[] T001B6_A14SinCod ;
   private String[] T001B6_A331SinDescrip ;
   private boolean[] T001B6_A332SinHabilitado ;
   private boolean[] T001B6_A906SinDefault ;
   private java.math.BigDecimal[] T001B6_A930SinCuotaAli ;
   private String[] T001B6_A1647SinSigla ;
   private short[] T001B6_A46PaiCod ;
   private String[] T001B6_A903ActComCodigo ;
   private short[] T001B4_A46PaiCod ;
   private String[] T001B5_A903ActComCodigo ;
   private short[] T001B7_A46PaiCod ;
   private String[] T001B8_A903ActComCodigo ;
   private short[] T001B9_A46PaiCod ;
   private String[] T001B9_A14SinCod ;
   private String[] T001B3_A680SinDescripSinAc ;
   private String[] T001B3_A14SinCod ;
   private String[] T001B3_A331SinDescrip ;
   private boolean[] T001B3_A332SinHabilitado ;
   private boolean[] T001B3_A906SinDefault ;
   private java.math.BigDecimal[] T001B3_A930SinCuotaAli ;
   private String[] T001B3_A1647SinSigla ;
   private short[] T001B3_A46PaiCod ;
   private String[] T001B3_A903ActComCodigo ;
   private short[] T001B10_A46PaiCod ;
   private String[] T001B10_A14SinCod ;
   private short[] T001B11_A46PaiCod ;
   private String[] T001B11_A14SinCod ;
   private String[] T001B2_A680SinDescripSinAc ;
   private String[] T001B2_A14SinCod ;
   private String[] T001B2_A331SinDescrip ;
   private boolean[] T001B2_A332SinHabilitado ;
   private boolean[] T001B2_A906SinDefault ;
   private java.math.BigDecimal[] T001B2_A930SinCuotaAli ;
   private String[] T001B2_A1647SinSigla ;
   private short[] T001B2_A46PaiCod ;
   private String[] T001B2_A903ActComCodigo ;
   private short[] T001B15_A46PaiCod ;
   private String[] T001B15_A9ConveCodigo ;
   private int[] T001B16_A3CliCod ;
   private short[] T001B16_A1EmpCod ;
   private int[] T001B16_A6LegNumero ;
   private short[] T001B17_A46PaiCod ;
   private String[] T001B17_A14SinCod ;
   private String[] T001B18_A903ActComCodigo ;
   private String[] T001B18_A904ActComDescripcion ;
   private String[] T001B19_A903ActComCodigo ;
   private String[] T001B19_A904ActComDescripcion ;
   private short[] T001B20_A46PaiCod ;
   private String[] T001B21_A903ActComCodigo ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
}

final  class sindicato__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001B2", "SELECT SinDescripSinAc, SinCod, SinDescrip, SinHabilitado, SinDefault, SinCuotaAli, SinSigla, PaiCod, ActComCodigo FROM Sindicato WHERE PaiCod = ? AND SinCod = ?  FOR UPDATE OF Sindicato NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B3", "SELECT SinDescripSinAc, SinCod, SinDescrip, SinHabilitado, SinDefault, SinCuotaAli, SinSigla, PaiCod, ActComCodigo FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B4", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B5", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B6", "SELECT TM1.SinDescripSinAc, TM1.SinCod, TM1.SinDescrip, TM1.SinHabilitado, TM1.SinDefault, TM1.SinCuotaAli, TM1.SinSigla, TM1.PaiCod, TM1.ActComCodigo FROM Sindicato TM1 WHERE TM1.PaiCod = ? and TM1.SinCod = ( ?) ORDER BY TM1.PaiCod, TM1.SinCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B7", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B8", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B9", "SELECT PaiCod, SinCod FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B10", "SELECT PaiCod, SinCod FROM Sindicato WHERE ( PaiCod > ? or PaiCod = ? and SinCod > ( ?)) ORDER BY PaiCod, SinCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001B11", "SELECT PaiCod, SinCod FROM Sindicato WHERE ( PaiCod < ? or PaiCod = ? and SinCod < ( ?)) ORDER BY PaiCod DESC, SinCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001B12", "SAVEPOINT gxupdate;INSERT INTO Sindicato(SinDescripSinAc, SinCod, SinDescrip, SinHabilitado, SinDefault, SinCuotaAli, SinSigla, PaiCod, ActComCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001B13", "SAVEPOINT gxupdate;UPDATE Sindicato SET SinDescripSinAc=?, SinDescrip=?, SinHabilitado=?, SinDefault=?, SinCuotaAli=?, SinSigla=?, ActComCodigo=?  WHERE PaiCod = ? AND SinCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001B14", "SAVEPOINT gxupdate;DELETE FROM Sindicato  WHERE PaiCod = ? AND SinCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001B15", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE PaiCod = ? AND ConveSinCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001B16", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ? AND LegSinCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001B17", "SELECT PaiCod, SinCod FROM Sindicato ORDER BY PaiCod, SinCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B18", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B19", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B20", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001B21", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

