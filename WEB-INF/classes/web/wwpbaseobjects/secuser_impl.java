package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuser_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"") == 0 )
      {
         A68SecUserName = httpContext.GetPar( "SecUserName") ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SecUserName", A68SecUserName);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa3641M55( A68SecUserName) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel14"+"_"+"vSESSION_CLICOD") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx14asasession_clicod1M55( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         n3CliCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_26( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A1923RolId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
         n1928MenuVerId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A1923RolId, A1925PerfilId, A1928MenuVerId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_28") == 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_28( A1925PerfilId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_30") == 0 )
      {
         A69SecUserPaiCod = (short)(GXutil.lval( httpContext.GetPar( "SecUserPaiCod"))) ;
         n69SecUserPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A69SecUserPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A69SecUserPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_30( A69SecUserPaiCod) ;
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
            AV7SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7SecUserId), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecUserId), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "User", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public secuser_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuser_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuser_impl.class ));
   }

   public secuser_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkSecUsuActivo = UIFactory.getCheckbox(this);
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
      A364SecUsuActivo = GXutil.strtobool( GXutil.booltostr( A364SecUsuActivo)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
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
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecUserName_Internalname, httpContext.getMessage( "Usuario (Mail)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecUserName_Internalname, A68SecUserName, GXutil.rtrim( localUtil.format( A68SecUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Usuario", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserPerName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecUserPerName_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecUserPerName_Internalname, A359SecUserPerName, GXutil.rtrim( localUtil.format( A359SecUserPerName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserPerName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserPerName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserPerLastName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecUserPerLastName_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecUserPerLastName_Internalname, A360SecUserPerLastName, GXutil.rtrim( localUtil.format( A360SecUserPerLastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserPerLastName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserPerLastName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSecusuactivo_cell_Internalname, 1, 0, "px", 0, "px", divSecusuactivo_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkSecUsuActivo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSecUsuActivo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSecUsuActivo.getInternalname(), httpContext.getMessage( "Activo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSecUsuActivo.getInternalname(), GXutil.booltostr( A364SecUsuActivo), "", httpContext.getMessage( "Activo", ""), chkSecUsuActivo.getVisible(), chkSecUsuActivo.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A67SecUserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSecUserId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A67SecUserId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A67SecUserId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecUserId_Visible, edtSecUserId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecUser.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecUser.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecUserEmpNom_Internalname, A357SecUserEmpNom, GXutil.rtrim( localUtil.format( A357SecUserEmpNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserEmpNom_Jsonclick, 0, "Attribute", "", "", "", "", edtSecUserEmpNom_Visible, edtSecUserEmpNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
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
      e111M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z67SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z67SecUserId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z68SecUserName = httpContext.cgiGet( "Z68SecUserName") ;
            Z356SecUserPassword = httpContext.cgiGet( "Z356SecUserPassword") ;
            Z357SecUserEmpNom = httpContext.cgiGet( "Z357SecUserEmpNom") ;
            Z364SecUsuActivo = GXutil.strtobool( httpContext.cgiGet( "Z364SecUsuActivo")) ;
            Z359SecUserPerName = httpContext.cgiGet( "Z359SecUserPerName") ;
            Z360SecUserPerLastName = httpContext.cgiGet( "Z360SecUserPerLastName") ;
            Z358SecUserEmpCuit = localUtil.ctol( httpContext.cgiGet( "Z358SecUserEmpCuit"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z531SecUserTipEmpl = httpContext.cgiGet( "Z531SecUserTipEmpl") ;
            Z2388SecUserSal = httpContext.cgiGet( "Z2388SecUserSal") ;
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n3CliCod = ((0==A3CliCod) ? true : false) ;
            Z1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1923RolId = ((0==A1923RolId) ? true : false) ;
            Z1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1925PerfilId = ((0==A1925PerfilId) ? true : false) ;
            Z1928MenuVerId = localUtil.ctol( httpContext.cgiGet( "Z1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n1928MenuVerId = ((0==A1928MenuVerId) ? true : false) ;
            Z69SecUserPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z69SecUserPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n69SecUserPaiCod = ((0==A69SecUserPaiCod) ? true : false) ;
            A356SecUserPassword = httpContext.cgiGet( "Z356SecUserPassword") ;
            A358SecUserEmpCuit = localUtil.ctol( httpContext.cgiGet( "Z358SecUserEmpCuit"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A531SecUserTipEmpl = httpContext.cgiGet( "Z531SecUserTipEmpl") ;
            A2388SecUserSal = httpContext.cgiGet( "Z2388SecUserSal") ;
            A1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1923RolId = false ;
            n1923RolId = ((0==A1923RolId) ? true : false) ;
            A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1925PerfilId = false ;
            n1925PerfilId = ((0==A1925PerfilId) ? true : false) ;
            A1928MenuVerId = localUtil.ctol( httpContext.cgiGet( "Z1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n1928MenuVerId = false ;
            n1928MenuVerId = ((0==A1928MenuVerId) ? true : false) ;
            A69SecUserPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z69SecUserPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n69SecUserPaiCod = false ;
            n69SecUserPaiCod = ((0==A69SecUserPaiCod) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "N3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n3CliCod = ((0==A3CliCod) ? true : false) ;
            N69SecUserPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N69SecUserPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n69SecUserPaiCod = ((0==A69SecUserPaiCod) ? true : false) ;
            N1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "N1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1923RolId = ((0==A1923RolId) ? true : false) ;
            N1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "N1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1925PerfilId = ((0==A1925PerfilId) ? true : false) ;
            N1928MenuVerId = localUtil.ctol( httpContext.cgiGet( "N1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n1928MenuVerId = ((0==A1928MenuVerId) ? true : false) ;
            AV7SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "vSECUSERID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV18Insert_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV26session_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vSESSION_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV29Insert_SecUserPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SECUSERPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A69SecUserPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "SECUSERPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n69SecUserPaiCod = ((0==A69SecUserPaiCod) ? true : false) ;
            AV30Insert_RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "vINSERT_ROLID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "ROLID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1923RolId = ((0==A1923RolId) ? true : false) ;
            AV31Insert_PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PERFILID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "PERFILID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1925PerfilId = ((0==A1925PerfilId) ? true : false) ;
            AV32Insert_MenuVerId = localUtil.ctol( httpContext.cgiGet( "vINSERT_MENUVERID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A1928MenuVerId = localUtil.ctol( httpContext.cgiGet( "MENUVERID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n1928MenuVerId = ((0==A1928MenuVerId) ? true : false) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A356SecUserPassword = httpContext.cgiGet( "SECUSERPASSWORD") ;
            A358SecUserEmpCuit = localUtil.ctol( httpContext.cgiGet( "SECUSEREMPCUIT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A531SecUserTipEmpl = httpContext.cgiGet( "SECUSERTIPEMPL") ;
            A2388SecUserSal = httpContext.cgiGet( "SECUSERSAL") ;
            A1924RolNombre = httpContext.cgiGet( "ROLNOMBRE") ;
            AV35Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A68SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A68SecUserName", A68SecUserName);
            A359SecUserPerName = httpContext.cgiGet( edtSecUserPerName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A359SecUserPerName", A359SecUserPerName);
            A360SecUserPerLastName = httpContext.cgiGet( edtSecUserPerLastName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A360SecUserPerLastName", A360SecUserPerLastName);
            A364SecUsuActivo = GXutil.strtobool( httpContext.cgiGet( chkSecUsuActivo.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
            A67SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               n3CliCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n3CliCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            n3CliCod = ((0==A3CliCod) ? true : false) ;
            A357SecUserEmpNom = GXutil.upper( httpContext.cgiGet( edtSecUserEmpNom_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A357SecUserEmpNom", A357SecUserEmpNom);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"SecUser");
            A67SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
            forbiddenHiddens.add("SecUserId", localUtil.format( DecimalUtil.doubleToDec(A67SecUserId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SecUserPassword", GXutil.rtrim( localUtil.format( A356SecUserPassword, "")));
            forbiddenHiddens.add("SecUserEmpCuit", localUtil.format( DecimalUtil.doubleToDec(A358SecUserEmpCuit), "ZZ-ZZZZZZZZ-9"));
            forbiddenHiddens.add("SecUserTipEmpl", GXutil.rtrim( localUtil.format( A531SecUserTipEmpl, "")));
            forbiddenHiddens.add("SecUserSal", GXutil.rtrim( localUtil.format( A2388SecUserSal, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A67SecUserId != Z67SecUserId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("wwpbaseobjects\\secuser:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A67SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
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
                  sMode55 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode55 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound55 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1M0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SECUSERID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecUserId_Internalname ;
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
                        e111M2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121M2 ();
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
         e121M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1M55( ) ;
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
         disableAttributes1M55( ) ;
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

   public void confirm_1M0( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1M55( ) ;
         }
         else
         {
            checkExtendedTable1M55( ) ;
            closeExtendedTableCursors1M55( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1M0( )
   {
   }

   public void e111M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV15WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV15WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Insert", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Update", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Delete", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV35Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV35Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV36GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36GXV1), 8, 0));
         while ( AV36GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV19TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV36GXV1));
            if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliCod") == 0 )
            {
               AV18Insert_CliCod = (int)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18Insert_CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18Insert_CliCod), 6, 0));
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserPaiCod") == 0 )
            {
               AV29Insert_SecUserPaiCod = (short)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29Insert_SecUserPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29Insert_SecUserPaiCod), 4, 0));
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "RolId") == 0 )
            {
               AV30Insert_RolId = (byte)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV30Insert_RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30Insert_RolId), 2, 0));
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PerfilId") == 0 )
            {
               AV31Insert_PerfilId = (byte)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV31Insert_PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31Insert_PerfilId), 2, 0));
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MenuVerId") == 0 )
            {
               AV32Insert_MenuVerId = GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV32Insert_MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32Insert_MenuVerId), 15, 0));
            }
            AV36GXV1 = (int)(AV36GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36GXV1), 8, 0));
         }
      }
      edtSecUserId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtSecUserEmpNom_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserEmpNom_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserEmpNom_Visible), 5, 0), true);
   }

   public void e121M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      chkSecUsuActivo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
      divSecusuactivo_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
   }

   public void zm1M55( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z68SecUserName = T001M3_A68SecUserName[0] ;
            Z356SecUserPassword = T001M3_A356SecUserPassword[0] ;
            Z357SecUserEmpNom = T001M3_A357SecUserEmpNom[0] ;
            Z364SecUsuActivo = T001M3_A364SecUsuActivo[0] ;
            Z359SecUserPerName = T001M3_A359SecUserPerName[0] ;
            Z360SecUserPerLastName = T001M3_A360SecUserPerLastName[0] ;
            Z358SecUserEmpCuit = T001M3_A358SecUserEmpCuit[0] ;
            Z531SecUserTipEmpl = T001M3_A531SecUserTipEmpl[0] ;
            Z2388SecUserSal = T001M3_A2388SecUserSal[0] ;
            Z3CliCod = T001M3_A3CliCod[0] ;
            Z1923RolId = T001M3_A1923RolId[0] ;
            Z1925PerfilId = T001M3_A1925PerfilId[0] ;
            Z1928MenuVerId = T001M3_A1928MenuVerId[0] ;
            Z69SecUserPaiCod = T001M3_A69SecUserPaiCod[0] ;
         }
         else
         {
            Z68SecUserName = A68SecUserName ;
            Z356SecUserPassword = A356SecUserPassword ;
            Z357SecUserEmpNom = A357SecUserEmpNom ;
            Z364SecUsuActivo = A364SecUsuActivo ;
            Z359SecUserPerName = A359SecUserPerName ;
            Z360SecUserPerLastName = A360SecUserPerLastName ;
            Z358SecUserEmpCuit = A358SecUserEmpCuit ;
            Z531SecUserTipEmpl = A531SecUserTipEmpl ;
            Z2388SecUserSal = A2388SecUserSal ;
            Z3CliCod = A3CliCod ;
            Z1923RolId = A1923RolId ;
            Z1925PerfilId = A1925PerfilId ;
            Z1928MenuVerId = A1928MenuVerId ;
            Z69SecUserPaiCod = A69SecUserPaiCod ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z67SecUserId = A67SecUserId ;
         Z68SecUserName = A68SecUserName ;
         Z356SecUserPassword = A356SecUserPassword ;
         Z357SecUserEmpNom = A357SecUserEmpNom ;
         Z364SecUsuActivo = A364SecUsuActivo ;
         Z359SecUserPerName = A359SecUserPerName ;
         Z360SecUserPerLastName = A360SecUserPerLastName ;
         Z358SecUserEmpCuit = A358SecUserEmpCuit ;
         Z531SecUserTipEmpl = A531SecUserTipEmpl ;
         Z2388SecUserSal = A2388SecUserSal ;
         Z3CliCod = A3CliCod ;
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1928MenuVerId = A1928MenuVerId ;
         Z69SecUserPaiCod = A69SecUserPaiCod ;
         Z1924RolNombre = A1924RolNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = AV26session_CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         secuser_impl.this.GXt_int4 = GXv_int5[0] ;
         AV26session_CliCod = GXt_int4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26session_CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26session_CliCod), 6, 0));
      }
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7SecUserId) )
      {
         A67SecUserId = AV7SecUserId ;
         httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV32Insert_MenuVerId) )
      {
         A1928MenuVerId = AV32Insert_MenuVerId ;
         n1928MenuVerId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV31Insert_PerfilId) )
      {
         A1925PerfilId = AV31Insert_PerfilId ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV30Insert_RolId) )
      {
         A1923RolId = AV30Insert_RolId ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV29Insert_SecUserPaiCod) )
      {
         A69SecUserPaiCod = AV29Insert_SecUserPaiCod ;
         n69SecUserPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A69SecUserPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A69SecUserPaiCod), 4, 0));
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
      if ( isIns( )  && (false==A364SecUsuActivo) && ( Gx_BScreen == 0 ) )
      {
         A364SecUsuActivo = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_CliCod) )
      {
         A3CliCod = AV18Insert_CliCod ;
         n3CliCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ! (0==AV26session_CliCod) )
         {
            A3CliCod = AV26session_CliCod ;
            n3CliCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV35Pgmname = "WWPBaseObjects.SecUser" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
         /* Using cursor T001M5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
         A1924RolNombre = T001M5_A1924RolNombre[0] ;
         pr_default.close(3);
      }
   }

   public void load1M55( )
   {
      /* Using cursor T001M9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A68SecUserName = T001M9_A68SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SecUserName", A68SecUserName);
         A356SecUserPassword = T001M9_A356SecUserPassword[0] ;
         A357SecUserEmpNom = T001M9_A357SecUserEmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A357SecUserEmpNom", A357SecUserEmpNom);
         A364SecUsuActivo = T001M9_A364SecUsuActivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
         A359SecUserPerName = T001M9_A359SecUserPerName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A359SecUserPerName", A359SecUserPerName);
         A360SecUserPerLastName = T001M9_A360SecUserPerLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A360SecUserPerLastName", A360SecUserPerLastName);
         A358SecUserEmpCuit = T001M9_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = T001M9_A531SecUserTipEmpl[0] ;
         A1924RolNombre = T001M9_A1924RolNombre[0] ;
         A2388SecUserSal = T001M9_A2388SecUserSal[0] ;
         A3CliCod = T001M9_A3CliCod[0] ;
         n3CliCod = T001M9_n3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1923RolId = T001M9_A1923RolId[0] ;
         n1923RolId = T001M9_n1923RolId[0] ;
         A1925PerfilId = T001M9_A1925PerfilId[0] ;
         n1925PerfilId = T001M9_n1925PerfilId[0] ;
         A1928MenuVerId = T001M9_A1928MenuVerId[0] ;
         n1928MenuVerId = T001M9_n1928MenuVerId[0] ;
         A69SecUserPaiCod = T001M9_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = T001M9_n69SecUserPaiCod[0] ;
         zm1M55( -24) ;
      }
      pr_default.close(7);
      onLoadActions1M55( ) ;
   }

   public void onLoadActions1M55( )
   {
      AV35Pgmname = "WWPBaseObjects.SecUser" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      chkSecUsuActivo.setVisible( ((GXutil.strcmp(A68SecUserName, GXt_char6)!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      if ( ! ( ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 ) ) )
      {
         divSecusuactivo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
      }
      else
      {
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
         secuser_impl.this.GXt_char6 = GXv_char7[0] ;
         if ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 )
         {
            divSecusuactivo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable1M55( )
   {
      nIsDirty_55 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV35Pgmname = "WWPBaseObjects.SecUser" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
      /* Using cursor T001M10 */
      pr_default.execute(8, new Object[] {A68SecUserName, Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Usuario", "")}), 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(8);
      if ( ! ( GxRegex.IsMatch(A68SecUserName,"(?:[a-z0-9!#$%&'*+/=?^_{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "Debe ser una dirección de correo válida", ""), httpContext.getMessage( "Usuario", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      chkSecUsuActivo.setVisible( ((GXutil.strcmp(A68SecUserName, GXt_char6)!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      if ( ! ( ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 ) ) )
      {
         divSecusuactivo_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
      }
      else
      {
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
         secuser_impl.this.GXt_char6 = GXv_char7[0] ;
         if ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 )
         {
            divSecusuactivo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A68SecUserName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Name", ""), "", "", "", "", "", "", "", ""), 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T001M4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      if ( (GXutil.strcmp("", A359SecUserPerName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), 1, "SECUSERPERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserPerName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A360SecUserPerLastName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Apellido", ""), "", "", "", "", "", "", "", ""), 1, "SECUSERPERLASTNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserPerLastName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T001M5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A1923RolId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
            AnyError = (short)(1) ;
         }
      }
      A1924RolNombre = T001M5_A1924RolNombre[0] ;
      pr_default.close(3);
      /* Using cursor T001M7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A1923RolId) || (0==A1925PerfilId) || (0==A1928MenuVerId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuVersiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUVERID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(5);
      /* Using cursor T001M6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(4);
      /* Using cursor T001M8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A69SecUserPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "User Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECUSERPAICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors1M55( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_26( int A3CliCod )
   {
      /* Using cursor T001M11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A3CliCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_27( byte A1923RolId )
   {
      /* Using cursor T001M12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (0==A1923RolId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
            AnyError = (short)(1) ;
         }
      }
      A1924RolNombre = T001M12_A1924RolNombre[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1924RolNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_29( byte A1923RolId ,
                          byte A1925PerfilId ,
                          long A1928MenuVerId )
   {
      /* Using cursor T001M13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A1923RolId) || (0==A1925PerfilId) || (0==A1928MenuVerId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuVersiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUVERID");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_28( byte A1925PerfilId )
   {
      /* Using cursor T001M14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_30( short A69SecUserPaiCod )
   {
      /* Using cursor T001M15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A69SecUserPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "User Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECUSERPAICOD");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void getKey1M55( )
   {
      /* Using cursor T001M16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound55 = (short)(1) ;
      }
      else
      {
         RcdFound55 = (short)(0) ;
      }
      pr_default.close(14);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001M3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1M55( 24) ;
         RcdFound55 = (short)(1) ;
         A67SecUserId = T001M3_A67SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
         A68SecUserName = T001M3_A68SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SecUserName", A68SecUserName);
         A356SecUserPassword = T001M3_A356SecUserPassword[0] ;
         A357SecUserEmpNom = T001M3_A357SecUserEmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A357SecUserEmpNom", A357SecUserEmpNom);
         A364SecUsuActivo = T001M3_A364SecUsuActivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
         A359SecUserPerName = T001M3_A359SecUserPerName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A359SecUserPerName", A359SecUserPerName);
         A360SecUserPerLastName = T001M3_A360SecUserPerLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A360SecUserPerLastName", A360SecUserPerLastName);
         A358SecUserEmpCuit = T001M3_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = T001M3_A531SecUserTipEmpl[0] ;
         A2388SecUserSal = T001M3_A2388SecUserSal[0] ;
         A3CliCod = T001M3_A3CliCod[0] ;
         n3CliCod = T001M3_n3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1923RolId = T001M3_A1923RolId[0] ;
         n1923RolId = T001M3_n1923RolId[0] ;
         A1925PerfilId = T001M3_A1925PerfilId[0] ;
         n1925PerfilId = T001M3_n1925PerfilId[0] ;
         A1928MenuVerId = T001M3_A1928MenuVerId[0] ;
         n1928MenuVerId = T001M3_n1928MenuVerId[0] ;
         A69SecUserPaiCod = T001M3_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = T001M3_n69SecUserPaiCod[0] ;
         Z67SecUserId = A67SecUserId ;
         sMode55 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1M55( ) ;
         if ( AnyError == 1 )
         {
            RcdFound55 = (short)(0) ;
            initializeNonKey1M55( ) ;
         }
         Gx_mode = sMode55 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound55 = (short)(0) ;
         initializeNonKey1M55( ) ;
         sMode55 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode55 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1M55( ) ;
      if ( RcdFound55 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound55 = (short)(0) ;
      /* Using cursor T001M17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         while ( (pr_default.getStatus(15) != 101) && ( ( T001M17_A67SecUserId[0] < A67SecUserId ) ) )
         {
            pr_default.readNext(15);
         }
         if ( (pr_default.getStatus(15) != 101) && ( ( T001M17_A67SecUserId[0] > A67SecUserId ) ) )
         {
            A67SecUserId = T001M17_A67SecUserId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
            RcdFound55 = (short)(1) ;
         }
      }
      pr_default.close(15);
   }

   public void move_previous( )
   {
      RcdFound55 = (short)(0) ;
      /* Using cursor T001M18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T001M18_A67SecUserId[0] > A67SecUserId ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T001M18_A67SecUserId[0] < A67SecUserId ) ) )
         {
            A67SecUserId = T001M18_A67SecUserId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
            RcdFound55 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1M55( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1M55( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound55 == 1 )
         {
            if ( A67SecUserId != Z67SecUserId )
            {
               A67SecUserId = Z67SecUserId ;
               httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SECUSERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1M55( ) ;
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A67SecUserId != Z67SecUserId )
            {
               /* Insert record */
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1M55( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SECUSERID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecUserId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSecUserName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1M55( ) ;
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
      if ( A67SecUserId != Z67SecUserId )
      {
         A67SecUserId = Z67SecUserId ;
         httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1M55( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001M2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A67SecUserId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z68SecUserName, T001M2_A68SecUserName[0]) != 0 ) || ( GXutil.strcmp(Z356SecUserPassword, T001M2_A356SecUserPassword[0]) != 0 ) || ( GXutil.strcmp(Z357SecUserEmpNom, T001M2_A357SecUserEmpNom[0]) != 0 ) || ( Z364SecUsuActivo != T001M2_A364SecUsuActivo[0] ) || ( GXutil.strcmp(Z359SecUserPerName, T001M2_A359SecUserPerName[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z360SecUserPerLastName, T001M2_A360SecUserPerLastName[0]) != 0 ) || ( Z358SecUserEmpCuit != T001M2_A358SecUserEmpCuit[0] ) || ( GXutil.strcmp(Z531SecUserTipEmpl, T001M2_A531SecUserTipEmpl[0]) != 0 ) || ( GXutil.strcmp(Z2388SecUserSal, T001M2_A2388SecUserSal[0]) != 0 ) || ( Z3CliCod != T001M2_A3CliCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1923RolId != T001M2_A1923RolId[0] ) || ( Z1925PerfilId != T001M2_A1925PerfilId[0] ) || ( Z1928MenuVerId != T001M2_A1928MenuVerId[0] ) || ( Z69SecUserPaiCod != T001M2_A69SecUserPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z68SecUserName, T001M2_A68SecUserName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserName");
               GXutil.writeLogRaw("Old: ",Z68SecUserName);
               GXutil.writeLogRaw("Current: ",T001M2_A68SecUserName[0]);
            }
            if ( GXutil.strcmp(Z356SecUserPassword, T001M2_A356SecUserPassword[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserPassword");
               GXutil.writeLogRaw("Old: ",Z356SecUserPassword);
               GXutil.writeLogRaw("Current: ",T001M2_A356SecUserPassword[0]);
            }
            if ( GXutil.strcmp(Z357SecUserEmpNom, T001M2_A357SecUserEmpNom[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserEmpNom");
               GXutil.writeLogRaw("Old: ",Z357SecUserEmpNom);
               GXutil.writeLogRaw("Current: ",T001M2_A357SecUserEmpNom[0]);
            }
            if ( Z364SecUsuActivo != T001M2_A364SecUsuActivo[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUsuActivo");
               GXutil.writeLogRaw("Old: ",Z364SecUsuActivo);
               GXutil.writeLogRaw("Current: ",T001M2_A364SecUsuActivo[0]);
            }
            if ( GXutil.strcmp(Z359SecUserPerName, T001M2_A359SecUserPerName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserPerName");
               GXutil.writeLogRaw("Old: ",Z359SecUserPerName);
               GXutil.writeLogRaw("Current: ",T001M2_A359SecUserPerName[0]);
            }
            if ( GXutil.strcmp(Z360SecUserPerLastName, T001M2_A360SecUserPerLastName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserPerLastName");
               GXutil.writeLogRaw("Old: ",Z360SecUserPerLastName);
               GXutil.writeLogRaw("Current: ",T001M2_A360SecUserPerLastName[0]);
            }
            if ( Z358SecUserEmpCuit != T001M2_A358SecUserEmpCuit[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserEmpCuit");
               GXutil.writeLogRaw("Old: ",Z358SecUserEmpCuit);
               GXutil.writeLogRaw("Current: ",T001M2_A358SecUserEmpCuit[0]);
            }
            if ( GXutil.strcmp(Z531SecUserTipEmpl, T001M2_A531SecUserTipEmpl[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserTipEmpl");
               GXutil.writeLogRaw("Old: ",Z531SecUserTipEmpl);
               GXutil.writeLogRaw("Current: ",T001M2_A531SecUserTipEmpl[0]);
            }
            if ( GXutil.strcmp(Z2388SecUserSal, T001M2_A2388SecUserSal[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserSal");
               GXutil.writeLogRaw("Old: ",Z2388SecUserSal);
               GXutil.writeLogRaw("Current: ",T001M2_A2388SecUserSal[0]);
            }
            if ( Z3CliCod != T001M2_A3CliCod[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"CliCod");
               GXutil.writeLogRaw("Old: ",Z3CliCod);
               GXutil.writeLogRaw("Current: ",T001M2_A3CliCod[0]);
            }
            if ( Z1923RolId != T001M2_A1923RolId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"RolId");
               GXutil.writeLogRaw("Old: ",Z1923RolId);
               GXutil.writeLogRaw("Current: ",T001M2_A1923RolId[0]);
            }
            if ( Z1925PerfilId != T001M2_A1925PerfilId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"PerfilId");
               GXutil.writeLogRaw("Old: ",Z1925PerfilId);
               GXutil.writeLogRaw("Current: ",T001M2_A1925PerfilId[0]);
            }
            if ( Z1928MenuVerId != T001M2_A1928MenuVerId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"MenuVerId");
               GXutil.writeLogRaw("Old: ",Z1928MenuVerId);
               GXutil.writeLogRaw("Current: ",T001M2_A1928MenuVerId[0]);
            }
            if ( Z69SecUserPaiCod != T001M2_A69SecUserPaiCod[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserPaiCod");
               GXutil.writeLogRaw("Old: ",Z69SecUserPaiCod);
               GXutil.writeLogRaw("Current: ",T001M2_A69SecUserPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecUser"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1M55( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1M55( 0) ;
         checkOptimisticConcurrency1M55( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1M55( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1M55( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001M19 */
                  pr_default.execute(17, new Object[] {A68SecUserName, A356SecUserPassword, A357SecUserEmpNom, Boolean.valueOf(A364SecUsuActivo), A359SecUserPerName, A360SecUserPerLastName, Long.valueOf(A358SecUserEmpCuit), A531SecUserTipEmpl, A2388SecUserSal, Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T001M20 */
                  pr_default.execute(18);
                  A67SecUserId = T001M20_A67SecUserId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
                  pr_default.close(18);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1M0( ) ;
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
            load1M55( ) ;
         }
         endLevel1M55( ) ;
      }
      closeExtendedTableCursors1M55( ) ;
   }

   public void update1M55( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1M55( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1M55( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1M55( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001M21 */
                  pr_default.execute(19, new Object[] {A68SecUserName, A356SecUserPassword, A357SecUserEmpNom, Boolean.valueOf(A364SecUsuActivo), A359SecUserPerName, A360SecUserPerLastName, Long.valueOf(A358SecUserEmpCuit), A531SecUserTipEmpl, A2388SecUserSal, Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod), Short.valueOf(A67SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1M55( ) ;
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
         endLevel1M55( ) ;
      }
      closeExtendedTableCursors1M55( ) ;
   }

   public void deferredUpdate1M55( )
   {
   }

   public void delete( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1M55( ) ;
         afterConfirm1M55( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1M55( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001M22 */
               pr_default.execute(20, new Object[] {Short.valueOf(A67SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
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
      sMode55 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1M55( ) ;
      Gx_mode = sMode55 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1M55( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV35Pgmname = "WWPBaseObjects.SecUser" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35Pgmname", AV35Pgmname);
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
         secuser_impl.this.GXt_char6 = GXv_char7[0] ;
         chkSecUsuActivo.setVisible( ((GXutil.strcmp(A68SecUserName, GXt_char6)!=0) ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
         secuser_impl.this.GXt_char6 = GXv_char7[0] ;
         if ( ! ( ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 ) ) )
         {
            divSecusuactivo_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
         }
         else
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
            secuser_impl.this.GXt_char6 = GXv_char7[0] ;
            if ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 )
            {
               divSecusuactivo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
            }
         }
         /* Using cursor T001M23 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
         A1924RolNombre = T001M23_A1924RolNombre[0] ;
         pr_default.close(21);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001M24 */
         pr_default.execute(22, new Object[] {Short.valueOf(A67SecUserId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sec User Role", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
      }
   }

   public void endLevel1M55( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser");
         if ( AnyError == 0 )
         {
            confirmValues1M0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1M55( )
   {
      /* Scan By routine */
      /* Using cursor T001M25 */
      pr_default.execute(23);
      RcdFound55 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A67SecUserId = T001M25_A67SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1M55( )
   {
      /* Scan next routine */
      pr_default.readNext(23);
      RcdFound55 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A67SecUserId = T001M25_A67SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
      }
   }

   public void scanEnd1M55( )
   {
      pr_default.close(23);
   }

   public void afterConfirm1M55( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1M55( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1M55( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1M55( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1M55( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1M55( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1M55( )
   {
      edtSecUserName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), true);
      edtSecUserPerName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserPerName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserPerName_Enabled), 5, 0), true);
      edtSecUserPerLastName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserPerLastName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserPerLastName_Enabled), 5, 0), true);
      chkSecUsuActivo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Enabled", GXutil.ltrimstr( chkSecUsuActivo.getEnabled(), 5, 0), true);
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtSecUserEmpNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserEmpNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserEmpNom_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1M55( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1M0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.secuser", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecUserId,4,0))}, new String[] {"Gx_mode","SecUserId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"SecUser");
      forbiddenHiddens.add("SecUserId", localUtil.format( DecimalUtil.doubleToDec(A67SecUserId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SecUserPassword", GXutil.rtrim( localUtil.format( A356SecUserPassword, "")));
      forbiddenHiddens.add("SecUserEmpCuit", localUtil.format( DecimalUtil.doubleToDec(A358SecUserEmpCuit), "ZZ-ZZZZZZZZ-9"));
      forbiddenHiddens.add("SecUserTipEmpl", GXutil.rtrim( localUtil.format( A531SecUserTipEmpl, "")));
      forbiddenHiddens.add("SecUserSal", GXutil.rtrim( localUtil.format( A2388SecUserSal, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secuser:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z67SecUserId", GXutil.ltrim( localUtil.ntoc( Z67SecUserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z68SecUserName", Z68SecUserName);
      web.GxWebStd.gx_hidden_field( httpContext, "Z356SecUserPassword", Z356SecUserPassword);
      web.GxWebStd.gx_hidden_field( httpContext, "Z357SecUserEmpNom", Z357SecUserEmpNom);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z364SecUsuActivo", Z364SecUsuActivo);
      web.GxWebStd.gx_hidden_field( httpContext, "Z359SecUserPerName", Z359SecUserPerName);
      web.GxWebStd.gx_hidden_field( httpContext, "Z360SecUserPerLastName", Z360SecUserPerLastName);
      web.GxWebStd.gx_hidden_field( httpContext, "Z358SecUserEmpCuit", GXutil.ltrim( localUtil.ntoc( Z358SecUserEmpCuit, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z531SecUserTipEmpl", GXutil.rtrim( Z531SecUserTipEmpl));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2388SecUserSal", Z2388SecUserSal);
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1923RolId", GXutil.ltrim( localUtil.ntoc( Z1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1925PerfilId", GXutil.ltrim( localUtil.ntoc( Z1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1928MenuVerId", GXutil.ltrim( localUtil.ntoc( Z1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z69SecUserPaiCod", GXutil.ltrim( localUtil.ntoc( Z69SecUserPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N3CliCod", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N69SecUserPaiCod", GXutil.ltrim( localUtil.ntoc( A69SecUserPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1923RolId", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1925PerfilId", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1928MenuVerId", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV7SecUserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecUserId), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLICOD", GXutil.ltrim( localUtil.ntoc( AV18Insert_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSESSION_CLICOD", GXutil.ltrim( localUtil.ntoc( AV26session_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECUSERPAICOD", GXutil.ltrim( localUtil.ntoc( AV29Insert_SecUserPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECUSERPAICOD", GXutil.ltrim( localUtil.ntoc( A69SecUserPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ROLID", GXutil.ltrim( localUtil.ntoc( AV30Insert_RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ROLID", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PERFILID", GXutil.ltrim( localUtil.ntoc( AV31Insert_PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERFILID", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MENUVERID", GXutil.ltrim( localUtil.ntoc( AV32Insert_MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUVERID", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECUSERPASSWORD", A356SecUserPassword);
      web.GxWebStd.gx_hidden_field( httpContext, "SECUSEREMPCUIT", GXutil.ltrim( localUtil.ntoc( A358SecUserEmpCuit, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECUSERTIPEMPL", GXutil.rtrim( A531SecUserTipEmpl));
      web.GxWebStd.gx_hidden_field( httpContext, "SECUSERSAL", A2388SecUserSal);
      web.GxWebStd.gx_hidden_field( httpContext, "ROLNOMBRE", A1924RolNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV35Pgmname));
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
      return formatLink("web.wwpbaseobjects.secuser", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecUserId,4,0))}, new String[] {"Gx_mode","SecUserId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecUser" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "User", "") ;
   }

   public void initializeNonKey1M55( )
   {
      A3CliCod = 0 ;
      n3CliCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      n3CliCod = ((0==A3CliCod) ? true : false) ;
      A69SecUserPaiCod = (short)(0) ;
      n69SecUserPaiCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A69SecUserPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A69SecUserPaiCod), 4, 0));
      A1923RolId = (byte)(0) ;
      n1923RolId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      A1925PerfilId = (byte)(0) ;
      n1925PerfilId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      A1928MenuVerId = 0 ;
      n1928MenuVerId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      A68SecUserName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A68SecUserName", A68SecUserName);
      A356SecUserPassword = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A356SecUserPassword", A356SecUserPassword);
      A357SecUserEmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A357SecUserEmpNom", A357SecUserEmpNom);
      A359SecUserPerName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A359SecUserPerName", A359SecUserPerName);
      A360SecUserPerLastName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A360SecUserPerLastName", A360SecUserPerLastName);
      A358SecUserEmpCuit = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A358SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(A358SecUserEmpCuit), 11, 0));
      A531SecUserTipEmpl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A531SecUserTipEmpl", A531SecUserTipEmpl);
      A1924RolNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1924RolNombre", A1924RolNombre);
      A2388SecUserSal = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2388SecUserSal", A2388SecUserSal);
      A364SecUsuActivo = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
      Z68SecUserName = "" ;
      Z356SecUserPassword = "" ;
      Z357SecUserEmpNom = "" ;
      Z364SecUsuActivo = false ;
      Z359SecUserPerName = "" ;
      Z360SecUserPerLastName = "" ;
      Z358SecUserEmpCuit = 0 ;
      Z531SecUserTipEmpl = "" ;
      Z2388SecUserSal = "" ;
      Z3CliCod = 0 ;
      Z1923RolId = (byte)(0) ;
      Z1925PerfilId = (byte)(0) ;
      Z1928MenuVerId = 0 ;
      Z69SecUserPaiCod = (short)(0) ;
   }

   public void initAll1M55( )
   {
      A67SecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A67SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A67SecUserId), 4, 0));
      initializeNonKey1M55( ) ;
   }

   public void standaloneModalInsert( )
   {
      A364SecUsuActivo = i364SecUsuActivo ;
      httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202041383", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secuser.js", "?202412202041383", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtSecUserName_Internalname = "SECUSERNAME" ;
      edtSecUserPerName_Internalname = "SECUSERPERNAME" ;
      edtSecUserPerLastName_Internalname = "SECUSERPERLASTNAME" ;
      chkSecUsuActivo.setInternalname( "SECUSUACTIVO" );
      divSecusuactivo_cell_Internalname = "SECUSUACTIVO_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtSecUserEmpNom_Internalname = "SECUSEREMPNOM" ;
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
      Form.setCaption( httpContext.getMessage( "User", "") );
      edtSecUserEmpNom_Jsonclick = "" ;
      edtSecUserEmpNom_Enabled = 1 ;
      edtSecUserEmpNom_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtSecUserId_Jsonclick = "" ;
      edtSecUserId_Enabled = 0 ;
      edtSecUserId_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkSecUsuActivo.setEnabled( 1 );
      chkSecUsuActivo.setVisible( 1 );
      divSecusuactivo_cell_Class = "col-xs-12" ;
      edtSecUserPerLastName_Jsonclick = "" ;
      edtSecUserPerLastName_Enabled = 1 ;
      edtSecUserPerName_Jsonclick = "" ;
      edtSecUserPerName_Enabled = 1 ;
      edtSecUserName_Jsonclick = "" ;
      edtSecUserName_Enabled = 1 ;
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

   public void gxasa3641M55( String A68SecUserName )
   {
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      chkSecUsuActivo.setVisible( ((GXutil.strcmp(A68SecUserName, GXt_char6)!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx14asasession_clicod1M55( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = AV26session_CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         secuser_impl.this.GXt_int4 = GXv_int5[0] ;
         AV26session_CliCod = GXt_int4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26session_CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26session_CliCod), 6, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV26session_CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
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
      chkSecUsuActivo.setName( "SECUSUACTIVO" );
      chkSecUsuActivo.setWebtags( "" );
      chkSecUsuActivo.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "TitleCaption", chkSecUsuActivo.getCaption(), true);
      chkSecUsuActivo.setCheckedValue( "false" );
      if ( isIns( ) && (false==A364SecUsuActivo) )
      {
         A364SecUsuActivo = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A364SecUsuActivo", A364SecUsuActivo);
      }
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

   public void valid_Secusername( )
   {
      /* Using cursor T001M26 */
      pr_default.execute(24, new Object[] {A68SecUserName, Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Usuario", "")}), 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
      }
      pr_default.close(24);
      if ( ! ( GxRegex.IsMatch(A68SecUserName,"(?:[a-z0-9!#$%&'*+/=?^_{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "Debe ser una dirección de correo válida", ""), httpContext.getMessage( "Usuario", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      chkSecUsuActivo.setVisible( ((GXutil.strcmp(A68SecUserName, GXt_char6)!=0) ? 1 : 0) );
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
      secuser_impl.this.GXt_char6 = GXv_char7[0] ;
      if ( ! ( ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 ) ) )
      {
         divSecusuactivo_cell_Class = httpContext.getMessage( "Invisible", "") ;
      }
      else
      {
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char7) ;
         secuser_impl.this.GXt_char6 = GXv_char7[0] ;
         if ( GXutil.strcmp(A68SecUserName, GXt_char6) != 0 )
         {
            divSecusuactivo_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         }
      }
      if ( (GXutil.strcmp("", A68SecUserName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Name", ""), "", "", "", "", "", "", "", ""), 1, "SECUSERNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserName_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, chkSecUsuActivo.getInternalname(), "Visible", GXutil.ltrimstr( chkSecUsuActivo.getVisible(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, divSecusuactivo_cell_Internalname, "Class", divSecusuactivo_cell_Class, true);
   }

   public void valid_Clicod( )
   {
      n3CliCod = false ;
      /* Using cursor T001M27 */
      pr_default.execute(25, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(25) == 101) )
      {
         if ( ! ( (0==A3CliCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(25);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'A67SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A356SecUserPassword',fld:'SECUSERPASSWORD',pic:''},{av:'A358SecUserEmpCuit',fld:'SECUSEREMPCUIT',pic:'ZZ-ZZZZZZZZ-9'},{av:'A531SecUserTipEmpl',fld:'SECUSERTIPEMPL',pic:''},{av:'A2388SecUserSal',fld:'SECUSERSAL',pic:''},{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121M2',iparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("VALID_SECUSERNAME","{handler:'valid_Secusername',iparms:[{av:'A68SecUserName',fld:'SECUSERNAME',pic:''},{av:'A67SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("VALID_SECUSERNAME",",oparms:[{av:'chkSecUsuActivo.getVisible()',ctrl:'SECUSUACTIVO',prop:'Visible'},{av:'divSecusuactivo_cell_Class',ctrl:'SECUSUACTIVO_CELL',prop:'Class'},{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("VALID_SECUSERPERNAME","{handler:'valid_Secuserpername',iparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("VALID_SECUSERPERNAME",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("VALID_SECUSERPERLASTNAME","{handler:'valid_Secuserperlastname',iparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("VALID_SECUSERPERLASTNAME",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("VALID_SECUSERID",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A364SecUsuActivo',fld:'SECUSUACTIVO',pic:''}]}");
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
      pr_default.close(25);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z68SecUserName = "" ;
      Z356SecUserPassword = "" ;
      Z357SecUserEmpNom = "" ;
      Z359SecUserPerName = "" ;
      Z360SecUserPerLastName = "" ;
      Z531SecUserTipEmpl = "" ;
      Z2388SecUserSal = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A68SecUserName = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A359SecUserPerName = "" ;
      A360SecUserPerLastName = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A357SecUserEmpNom = "" ;
      A356SecUserPassword = "" ;
      A531SecUserTipEmpl = "" ;
      A2388SecUserSal = "" ;
      A1924RolNombre = "" ;
      AV35Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode55 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV15WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV19TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z1924RolNombre = "" ;
      T001M5_A1924RolNombre = new String[] {""} ;
      T001M9_A67SecUserId = new short[1] ;
      T001M9_A68SecUserName = new String[] {""} ;
      T001M9_A356SecUserPassword = new String[] {""} ;
      T001M9_A357SecUserEmpNom = new String[] {""} ;
      T001M9_A364SecUsuActivo = new boolean[] {false} ;
      T001M9_A359SecUserPerName = new String[] {""} ;
      T001M9_A360SecUserPerLastName = new String[] {""} ;
      T001M9_A358SecUserEmpCuit = new long[1] ;
      T001M9_A531SecUserTipEmpl = new String[] {""} ;
      T001M9_A1924RolNombre = new String[] {""} ;
      T001M9_A2388SecUserSal = new String[] {""} ;
      T001M9_A3CliCod = new int[1] ;
      T001M9_n3CliCod = new boolean[] {false} ;
      T001M9_A1923RolId = new byte[1] ;
      T001M9_n1923RolId = new boolean[] {false} ;
      T001M9_A1925PerfilId = new byte[1] ;
      T001M9_n1925PerfilId = new boolean[] {false} ;
      T001M9_A1928MenuVerId = new long[1] ;
      T001M9_n1928MenuVerId = new boolean[] {false} ;
      T001M9_A69SecUserPaiCod = new short[1] ;
      T001M9_n69SecUserPaiCod = new boolean[] {false} ;
      T001M10_A68SecUserName = new String[] {""} ;
      T001M4_A3CliCod = new int[1] ;
      T001M4_n3CliCod = new boolean[] {false} ;
      T001M7_A1923RolId = new byte[1] ;
      T001M7_n1923RolId = new boolean[] {false} ;
      T001M6_A1925PerfilId = new byte[1] ;
      T001M6_n1925PerfilId = new boolean[] {false} ;
      T001M8_A69SecUserPaiCod = new short[1] ;
      T001M8_n69SecUserPaiCod = new boolean[] {false} ;
      T001M11_A3CliCod = new int[1] ;
      T001M11_n3CliCod = new boolean[] {false} ;
      T001M12_A1924RolNombre = new String[] {""} ;
      T001M13_A1923RolId = new byte[1] ;
      T001M13_n1923RolId = new boolean[] {false} ;
      T001M14_A1925PerfilId = new byte[1] ;
      T001M14_n1925PerfilId = new boolean[] {false} ;
      T001M15_A69SecUserPaiCod = new short[1] ;
      T001M15_n69SecUserPaiCod = new boolean[] {false} ;
      T001M16_A67SecUserId = new short[1] ;
      T001M3_A67SecUserId = new short[1] ;
      T001M3_A68SecUserName = new String[] {""} ;
      T001M3_A356SecUserPassword = new String[] {""} ;
      T001M3_A357SecUserEmpNom = new String[] {""} ;
      T001M3_A364SecUsuActivo = new boolean[] {false} ;
      T001M3_A359SecUserPerName = new String[] {""} ;
      T001M3_A360SecUserPerLastName = new String[] {""} ;
      T001M3_A358SecUserEmpCuit = new long[1] ;
      T001M3_A531SecUserTipEmpl = new String[] {""} ;
      T001M3_A2388SecUserSal = new String[] {""} ;
      T001M3_A3CliCod = new int[1] ;
      T001M3_n3CliCod = new boolean[] {false} ;
      T001M3_A1923RolId = new byte[1] ;
      T001M3_n1923RolId = new boolean[] {false} ;
      T001M3_A1925PerfilId = new byte[1] ;
      T001M3_n1925PerfilId = new boolean[] {false} ;
      T001M3_A1928MenuVerId = new long[1] ;
      T001M3_n1928MenuVerId = new boolean[] {false} ;
      T001M3_A69SecUserPaiCod = new short[1] ;
      T001M3_n69SecUserPaiCod = new boolean[] {false} ;
      T001M17_A67SecUserId = new short[1] ;
      T001M18_A67SecUserId = new short[1] ;
      T001M2_A67SecUserId = new short[1] ;
      T001M2_A68SecUserName = new String[] {""} ;
      T001M2_A356SecUserPassword = new String[] {""} ;
      T001M2_A357SecUserEmpNom = new String[] {""} ;
      T001M2_A364SecUsuActivo = new boolean[] {false} ;
      T001M2_A359SecUserPerName = new String[] {""} ;
      T001M2_A360SecUserPerLastName = new String[] {""} ;
      T001M2_A358SecUserEmpCuit = new long[1] ;
      T001M2_A531SecUserTipEmpl = new String[] {""} ;
      T001M2_A2388SecUserSal = new String[] {""} ;
      T001M2_A3CliCod = new int[1] ;
      T001M2_n3CliCod = new boolean[] {false} ;
      T001M2_A1923RolId = new byte[1] ;
      T001M2_n1923RolId = new boolean[] {false} ;
      T001M2_A1925PerfilId = new byte[1] ;
      T001M2_n1925PerfilId = new boolean[] {false} ;
      T001M2_A1928MenuVerId = new long[1] ;
      T001M2_n1928MenuVerId = new boolean[] {false} ;
      T001M2_A69SecUserPaiCod = new short[1] ;
      T001M2_n69SecUserPaiCod = new boolean[] {false} ;
      T001M20_A67SecUserId = new short[1] ;
      T001M23_A1924RolNombre = new String[] {""} ;
      T001M24_A67SecUserId = new short[1] ;
      T001M24_A65SecRoleId = new short[1] ;
      T001M25_A67SecUserId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T001M26_A68SecUserName = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      T001M27_A3CliCod = new int[1] ;
      T001M27_n3CliCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secuser__default(),
         new Object[] {
             new Object[] {
            T001M2_A67SecUserId, T001M2_A68SecUserName, T001M2_A356SecUserPassword, T001M2_A357SecUserEmpNom, T001M2_A364SecUsuActivo, T001M2_A359SecUserPerName, T001M2_A360SecUserPerLastName, T001M2_A358SecUserEmpCuit, T001M2_A531SecUserTipEmpl, T001M2_A2388SecUserSal,
            T001M2_A3CliCod, T001M2_n3CliCod, T001M2_A1923RolId, T001M2_n1923RolId, T001M2_A1925PerfilId, T001M2_n1925PerfilId, T001M2_A1928MenuVerId, T001M2_n1928MenuVerId, T001M2_A69SecUserPaiCod, T001M2_n69SecUserPaiCod
            }
            , new Object[] {
            T001M3_A67SecUserId, T001M3_A68SecUserName, T001M3_A356SecUserPassword, T001M3_A357SecUserEmpNom, T001M3_A364SecUsuActivo, T001M3_A359SecUserPerName, T001M3_A360SecUserPerLastName, T001M3_A358SecUserEmpCuit, T001M3_A531SecUserTipEmpl, T001M3_A2388SecUserSal,
            T001M3_A3CliCod, T001M3_n3CliCod, T001M3_A1923RolId, T001M3_n1923RolId, T001M3_A1925PerfilId, T001M3_n1925PerfilId, T001M3_A1928MenuVerId, T001M3_n1928MenuVerId, T001M3_A69SecUserPaiCod, T001M3_n69SecUserPaiCod
            }
            , new Object[] {
            T001M4_A3CliCod
            }
            , new Object[] {
            T001M5_A1924RolNombre
            }
            , new Object[] {
            T001M6_A1925PerfilId
            }
            , new Object[] {
            T001M7_A1923RolId
            }
            , new Object[] {
            T001M8_A69SecUserPaiCod
            }
            , new Object[] {
            T001M9_A67SecUserId, T001M9_A68SecUserName, T001M9_A356SecUserPassword, T001M9_A357SecUserEmpNom, T001M9_A364SecUsuActivo, T001M9_A359SecUserPerName, T001M9_A360SecUserPerLastName, T001M9_A358SecUserEmpCuit, T001M9_A531SecUserTipEmpl, T001M9_A1924RolNombre,
            T001M9_A2388SecUserSal, T001M9_A3CliCod, T001M9_n3CliCod, T001M9_A1923RolId, T001M9_n1923RolId, T001M9_A1925PerfilId, T001M9_n1925PerfilId, T001M9_A1928MenuVerId, T001M9_n1928MenuVerId, T001M9_A69SecUserPaiCod,
            T001M9_n69SecUserPaiCod
            }
            , new Object[] {
            T001M10_A68SecUserName
            }
            , new Object[] {
            T001M11_A3CliCod
            }
            , new Object[] {
            T001M12_A1924RolNombre
            }
            , new Object[] {
            T001M13_A1923RolId
            }
            , new Object[] {
            T001M14_A1925PerfilId
            }
            , new Object[] {
            T001M15_A69SecUserPaiCod
            }
            , new Object[] {
            T001M16_A67SecUserId
            }
            , new Object[] {
            T001M17_A67SecUserId
            }
            , new Object[] {
            T001M18_A67SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            T001M20_A67SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001M23_A1924RolNombre
            }
            , new Object[] {
            T001M24_A67SecUserId, T001M24_A65SecRoleId
            }
            , new Object[] {
            T001M25_A67SecUserId
            }
            , new Object[] {
            T001M26_A68SecUserName
            }
            , new Object[] {
            T001M27_A3CliCod
            }
         }
      );
      AV35Pgmname = "WWPBaseObjects.SecUser" ;
      Z364SecUsuActivo = true ;
      A364SecUsuActivo = true ;
      i364SecUsuActivo = true ;
   }

   private byte Z1923RolId ;
   private byte Z1925PerfilId ;
   private byte N1923RolId ;
   private byte N1925PerfilId ;
   private byte GxWebError ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private byte nKeyPressed ;
   private byte AV30Insert_RolId ;
   private byte AV31Insert_PerfilId ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7SecUserId ;
   private short Z67SecUserId ;
   private short Z69SecUserPaiCod ;
   private short N69SecUserPaiCod ;
   private short A69SecUserPaiCod ;
   private short AV7SecUserId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A67SecUserId ;
   private short AV29Insert_SecUserPaiCod ;
   private short RcdFound55 ;
   private short nIsDirty_55 ;
   private int Z3CliCod ;
   private int N3CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtSecUserName_Enabled ;
   private int edtSecUserPerName_Enabled ;
   private int edtSecUserPerLastName_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSecUserId_Enabled ;
   private int edtSecUserId_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtSecUserEmpNom_Visible ;
   private int edtSecUserEmpNom_Enabled ;
   private int AV18Insert_CliCod ;
   private int AV26session_CliCod ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV36GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long Z358SecUserEmpCuit ;
   private long Z1928MenuVerId ;
   private long N1928MenuVerId ;
   private long A1928MenuVerId ;
   private long A358SecUserEmpCuit ;
   private long AV32Insert_MenuVerId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z531SecUserTipEmpl ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecUserName_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtSecUserName_Jsonclick ;
   private String edtSecUserPerName_Internalname ;
   private String edtSecUserPerName_Jsonclick ;
   private String edtSecUserPerLastName_Internalname ;
   private String edtSecUserPerLastName_Jsonclick ;
   private String divSecusuactivo_cell_Internalname ;
   private String divSecusuactivo_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtSecUserId_Internalname ;
   private String edtSecUserId_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtSecUserEmpNom_Internalname ;
   private String edtSecUserEmpNom_Jsonclick ;
   private String A531SecUserTipEmpl ;
   private String AV35Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode55 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z364SecUsuActivo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n3CliCod ;
   private boolean n1923RolId ;
   private boolean n1925PerfilId ;
   private boolean n1928MenuVerId ;
   private boolean n69SecUserPaiCod ;
   private boolean wbErr ;
   private boolean A364SecUsuActivo ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean i364SecUsuActivo ;
   private String Z68SecUserName ;
   private String Z356SecUserPassword ;
   private String Z357SecUserEmpNom ;
   private String Z359SecUserPerName ;
   private String Z360SecUserPerLastName ;
   private String Z2388SecUserSal ;
   private String A68SecUserName ;
   private String A359SecUserPerName ;
   private String A360SecUserPerLastName ;
   private String A357SecUserEmpNom ;
   private String A356SecUserPassword ;
   private String A2388SecUserSal ;
   private String A1924RolNombre ;
   private String Z1924RolNombre ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkSecUsuActivo ;
   private IDataStoreProvider pr_default ;
   private String[] T001M5_A1924RolNombre ;
   private short[] T001M9_A67SecUserId ;
   private String[] T001M9_A68SecUserName ;
   private String[] T001M9_A356SecUserPassword ;
   private String[] T001M9_A357SecUserEmpNom ;
   private boolean[] T001M9_A364SecUsuActivo ;
   private String[] T001M9_A359SecUserPerName ;
   private String[] T001M9_A360SecUserPerLastName ;
   private long[] T001M9_A358SecUserEmpCuit ;
   private String[] T001M9_A531SecUserTipEmpl ;
   private String[] T001M9_A1924RolNombre ;
   private String[] T001M9_A2388SecUserSal ;
   private int[] T001M9_A3CliCod ;
   private boolean[] T001M9_n3CliCod ;
   private byte[] T001M9_A1923RolId ;
   private boolean[] T001M9_n1923RolId ;
   private byte[] T001M9_A1925PerfilId ;
   private boolean[] T001M9_n1925PerfilId ;
   private long[] T001M9_A1928MenuVerId ;
   private boolean[] T001M9_n1928MenuVerId ;
   private short[] T001M9_A69SecUserPaiCod ;
   private boolean[] T001M9_n69SecUserPaiCod ;
   private String[] T001M10_A68SecUserName ;
   private int[] T001M4_A3CliCod ;
   private boolean[] T001M4_n3CliCod ;
   private byte[] T001M7_A1923RolId ;
   private boolean[] T001M7_n1923RolId ;
   private byte[] T001M6_A1925PerfilId ;
   private boolean[] T001M6_n1925PerfilId ;
   private short[] T001M8_A69SecUserPaiCod ;
   private boolean[] T001M8_n69SecUserPaiCod ;
   private int[] T001M11_A3CliCod ;
   private boolean[] T001M11_n3CliCod ;
   private String[] T001M12_A1924RolNombre ;
   private byte[] T001M13_A1923RolId ;
   private boolean[] T001M13_n1923RolId ;
   private byte[] T001M14_A1925PerfilId ;
   private boolean[] T001M14_n1925PerfilId ;
   private short[] T001M15_A69SecUserPaiCod ;
   private boolean[] T001M15_n69SecUserPaiCod ;
   private short[] T001M16_A67SecUserId ;
   private short[] T001M3_A67SecUserId ;
   private String[] T001M3_A68SecUserName ;
   private String[] T001M3_A356SecUserPassword ;
   private String[] T001M3_A357SecUserEmpNom ;
   private boolean[] T001M3_A364SecUsuActivo ;
   private String[] T001M3_A359SecUserPerName ;
   private String[] T001M3_A360SecUserPerLastName ;
   private long[] T001M3_A358SecUserEmpCuit ;
   private String[] T001M3_A531SecUserTipEmpl ;
   private String[] T001M3_A2388SecUserSal ;
   private int[] T001M3_A3CliCod ;
   private boolean[] T001M3_n3CliCod ;
   private byte[] T001M3_A1923RolId ;
   private boolean[] T001M3_n1923RolId ;
   private byte[] T001M3_A1925PerfilId ;
   private boolean[] T001M3_n1925PerfilId ;
   private long[] T001M3_A1928MenuVerId ;
   private boolean[] T001M3_n1928MenuVerId ;
   private short[] T001M3_A69SecUserPaiCod ;
   private boolean[] T001M3_n69SecUserPaiCod ;
   private short[] T001M17_A67SecUserId ;
   private short[] T001M18_A67SecUserId ;
   private short[] T001M2_A67SecUserId ;
   private String[] T001M2_A68SecUserName ;
   private String[] T001M2_A356SecUserPassword ;
   private String[] T001M2_A357SecUserEmpNom ;
   private boolean[] T001M2_A364SecUsuActivo ;
   private String[] T001M2_A359SecUserPerName ;
   private String[] T001M2_A360SecUserPerLastName ;
   private long[] T001M2_A358SecUserEmpCuit ;
   private String[] T001M2_A531SecUserTipEmpl ;
   private String[] T001M2_A2388SecUserSal ;
   private int[] T001M2_A3CliCod ;
   private boolean[] T001M2_n3CliCod ;
   private byte[] T001M2_A1923RolId ;
   private boolean[] T001M2_n1923RolId ;
   private byte[] T001M2_A1925PerfilId ;
   private boolean[] T001M2_n1925PerfilId ;
   private long[] T001M2_A1928MenuVerId ;
   private boolean[] T001M2_n1928MenuVerId ;
   private short[] T001M2_A69SecUserPaiCod ;
   private boolean[] T001M2_n69SecUserPaiCod ;
   private short[] T001M20_A67SecUserId ;
   private String[] T001M23_A1924RolNombre ;
   private short[] T001M24_A67SecUserId ;
   private short[] T001M24_A65SecRoleId ;
   private short[] T001M25_A67SecUserId ;
   private String[] T001M26_A68SecUserName ;
   private int[] T001M27_A3CliCod ;
   private boolean[] T001M27_n3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV19TrnContextAtt ;
}

final  class secuser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001M2", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ?  FOR UPDATE OF SecUser NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M3", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M5", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M6", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M7", "SELECT RolId FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M8", "SELECT PaiCod AS SecUserPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M9", "SELECT TM1.SecUserId, TM1.SecUserName, TM1.SecUserPassword, TM1.SecUserEmpNom, TM1.SecUsuActivo, TM1.SecUserPerName, TM1.SecUserPerLastName, TM1.SecUserEmpCuit, TM1.SecUserTipEmpl, T2.RolNombre, TM1.SecUserSal, TM1.CliCod, TM1.RolId, TM1.PerfilId, TM1.MenuVerId, TM1.SecUserPaiCod AS SecUserPaiCod FROM (SecUser TM1 LEFT JOIN RolUsuario T2 ON T2.RolId = TM1.RolId) WHERE TM1.SecUserId = ? ORDER BY TM1.SecUserId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M10", "SELECT SecUserName FROM SecUser WHERE (SecUserName = ?) AND (Not ( SecUserId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M11", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M12", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M13", "SELECT RolId FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M14", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M15", "SELECT PaiCod AS SecUserPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M16", "SELECT SecUserId FROM SecUser WHERE SecUserId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M17", "SELECT SecUserId FROM SecUser WHERE ( SecUserId > ?) ORDER BY SecUserId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001M18", "SELECT SecUserId FROM SecUser WHERE ( SecUserId < ?) ORDER BY SecUserId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001M19", "SAVEPOINT gxupdate;INSERT INTO SecUser(SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod, SecParAct) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001M20", "SELECT currval('SecUserId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001M21", "SAVEPOINT gxupdate;UPDATE SecUser SET SecUserName=?, SecUserPassword=?, SecUserEmpNom=?, SecUsuActivo=?, SecUserPerName=?, SecUserPerLastName=?, SecUserEmpCuit=?, SecUserTipEmpl=?, SecUserSal=?, CliCod=?, RolId=?, PerfilId=?, MenuVerId=?, SecUserPaiCod=?  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001M22", "SAVEPOINT gxupdate;DELETE FROM SecUser  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001M23", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M24", "SELECT SecUserId, SecRoleId FROM SecUserRole WHERE SecUserId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001M25", "SELECT SecUserId FROM SecUser ORDER BY SecUserId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M26", "SELECT SecUserName FROM SecUser WHERE (SecUserName = ?) AND (Not ( SecUserId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001M27", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 5 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(14);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((short[]) buf[19])[0] = rslt.getShort(16);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 11 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 12 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 25 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setString(8, (String)parms[7], 4);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[14]).byteValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[16]).longValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(14, ((Number) parms[18]).shortValue());
               }
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setString(8, (String)parms[7], 4);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[14]).byteValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[16]).longValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(14, ((Number) parms[18]).shortValue());
               }
               stmt.setShort(15, ((Number) parms[19]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 24 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

