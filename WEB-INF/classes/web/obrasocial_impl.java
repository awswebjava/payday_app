package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obrasocial_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action24") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         A1981OsoRelSec = (int)(GXutil.lval( httpContext.GetPar( "OsoRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_24_1437( Gx_mode, AV11CliCod, A1981OsoRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OSORELSEC") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaosorelsec1437( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"OSODESCRIPSINAC") == 0 )
      {
         A307OsoDescrip = httpContext.GetPar( "OsoDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaosodescripsinac1437( A307OsoDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CLICOD") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaclicod1437( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel10"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa19811437( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_31") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_31( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_32") == 0 )
      {
         A2160OsoActCom = httpContext.GetPar( "OsoActCom") ;
         n2160OsoActCom = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2160OsoActCom", A2160OsoActCom);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_32( A2160OsoActCom) ;
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
            AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
            AV7OsoCod = httpContext.GetPar( "OsoCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7OsoCod", AV7OsoCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOSOCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7OsoCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Obra Social", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtOsoCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public obrasocial_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obrasocial_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obrasocial_impl.class ));
   }

   public obrasocial_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynOsoRelSec = new HTMLChoice();
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
      if ( dynOsoRelSec.getItemCount() > 0 )
      {
         A1981OsoRelSec = (int)(GXutil.lval( dynOsoRelSec.getValidValue(GXutil.trim( GXutil.str( A1981OsoRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOsoRelSec.setValue( GXutil.trim( GXutil.str( A1981OsoRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynOsoRelSec.getInternalname(), "Values", dynOsoRelSec.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_ObraSocial.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOsoCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOsoCod_Internalname, GXutil.rtrim( A5OsoCod), GXutil.rtrim( localUtil.format( A5OsoCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOsoCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOsoCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOsoDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOsoDescrip_Internalname, A307OsoDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", (short)(0), 1, edtOsoDescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoSigla_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOsoSigla_Internalname, httpContext.getMessage( "Sigla", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOsoSigla_Internalname, GXutil.rtrim( A392OsoSigla), GXutil.rtrim( localUtil.format( A392OsoSigla, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOsoSigla_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOsoSigla_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoC3992_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOsoC3992_Internalname, httpContext.getMessage( "Código AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOsoC3992_Internalname, GXutil.rtrim( A306OsoC3992), GXutil.rtrim( localUtil.format( A306OsoC3992, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOsoC3992_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOsoC3992_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOsoAporteAdic_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOsoAporteAdic_Internalname, httpContext.getMessage( "Aporte adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOsoAporteAdic_Internalname, GXutil.ltrim( localUtil.ntoc( A893OsoAporteAdic, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( A893OsoAporteAdic, "ZZ,ZZZ,ZZZ,ZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOsoAporteAdic_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOsoAporteAdic_Enabled, 1, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOsorelsec_cell_Internalname, 1, 0, "px", 0, "px", divOsorelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynOsoRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOsoRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynOsoRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOsoRelSec, dynOsoRelSec.getInternalname(), GXutil.trim( GXutil.str( A1981OsoRelSec, 6, 0)), 1, dynOsoRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynOsoRelSec.getVisible(), dynOsoRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_ObraSocial.htm");
      dynOsoRelSec.setValue( GXutil.trim( GXutil.str( A1981OsoRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynOsoRelSec.getInternalname(), "Values", dynOsoRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ObraSocial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ObraSocial.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ObraSocial.htm");
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
      e11142 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z5OsoCod = httpContext.cgiGet( "Z5OsoCod") ;
            Z555OsoSiglaYDesc = httpContext.cgiGet( "Z555OsoSiglaYDesc") ;
            Z681OsoDescripSinAc = httpContext.cgiGet( "Z681OsoDescripSinAc") ;
            Z307OsoDescrip = httpContext.cgiGet( "Z307OsoDescrip") ;
            Z392OsoSigla = httpContext.cgiGet( "Z392OsoSigla") ;
            Z308OsoHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z308OsoHabilitada")) ;
            Z306OsoC3992 = httpContext.cgiGet( "Z306OsoC3992") ;
            n306OsoC3992 = ((GXutil.strcmp("", A306OsoC3992)==0) ? true : false) ;
            Z893OsoAporteAdic = localUtil.ctond( httpContext.cgiGet( "Z893OsoAporteAdic")) ;
            Z1981OsoRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1981OsoRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1982OsoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1982OsoRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1983OsoPadre = httpContext.cgiGet( "Z1983OsoPadre") ;
            Z2014OsoRelRef = httpContext.cgiGet( "Z2014OsoRelRef") ;
            Z2160OsoActCom = httpContext.cgiGet( "Z2160OsoActCom") ;
            n2160OsoActCom = ((GXutil.strcmp("", A2160OsoActCom)==0) ? true : false) ;
            A555OsoSiglaYDesc = httpContext.cgiGet( "Z555OsoSiglaYDesc") ;
            A681OsoDescripSinAc = httpContext.cgiGet( "Z681OsoDescripSinAc") ;
            A308OsoHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z308OsoHabilitada")) ;
            A1982OsoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1982OsoRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1983OsoPadre = httpContext.cgiGet( "Z1983OsoPadre") ;
            A2014OsoRelRef = httpContext.cgiGet( "Z2014OsoRelRef") ;
            A2160OsoActCom = httpContext.cgiGet( "Z2160OsoActCom") ;
            n2160OsoActCom = false ;
            n2160OsoActCom = ((GXutil.strcmp("", A2160OsoActCom)==0) ? true : false) ;
            O893OsoAporteAdic = localUtil.ctond( httpContext.cgiGet( "O893OsoAporteAdic")) ;
            O306OsoC3992 = httpContext.cgiGet( "O306OsoC3992") ;
            n306OsoC3992 = ((GXutil.strcmp("", A306OsoC3992)==0) ? true : false) ;
            O307OsoDescrip = httpContext.cgiGet( "O307OsoDescrip") ;
            O5OsoCod = httpContext.cgiGet( "O5OsoCod") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N2160OsoActCom = httpContext.cgiGet( "N2160OsoActCom") ;
            n2160OsoActCom = ((GXutil.strcmp("", A2160OsoActCom)==0) ? true : false) ;
            N307OsoDescrip = httpContext.cgiGet( "N307OsoDescrip") ;
            N306OsoC3992 = httpContext.cgiGet( "N306OsoC3992") ;
            n306OsoC3992 = ((GXutil.strcmp("", A306OsoC3992)==0) ? true : false) ;
            N893OsoAporteAdic = localUtil.ctond( httpContext.cgiGet( "N893OsoAporteAdic")) ;
            N392OsoSigla = httpContext.cgiGet( "N392OsoSigla") ;
            A681OsoDescripSinAc = httpContext.cgiGet( "OSODESCRIPSINAC") ;
            A555OsoSiglaYDesc = httpContext.cgiGet( "OSOSIGLAYDESC") ;
            AV11CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7OsoCod = httpContext.cgiGet( "vOSOCOD") ;
            AV16Insert_OsoActCom = httpContext.cgiGet( "vINSERT_OSOACTCOM") ;
            A2160OsoActCom = httpContext.cgiGet( "OSOACTCOM") ;
            n2160OsoActCom = ((GXutil.strcmp("", A2160OsoActCom)==0) ? true : false) ;
            A1983OsoPadre = httpContext.cgiGet( "OSOPADRE") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A308OsoHabilitada = GXutil.strtobool( httpContext.cgiGet( "OSOHABILITADA")) ;
            AV15aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A1982OsoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "OSORELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2014OsoRelRef = httpContext.cgiGet( "OSORELREF") ;
            A2035OsoOld = httpContext.cgiGet( "OSOOLD") ;
            A2161OsoActComDesc = httpContext.cgiGet( "OSOACTCOMDESC") ;
            AV19Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A5OsoCod = httpContext.cgiGet( edtOsoCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
            A307OsoDescrip = httpContext.cgiGet( edtOsoDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
            A392OsoSigla = httpContext.cgiGet( edtOsoSigla_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A392OsoSigla", A392OsoSigla);
            A306OsoC3992 = httpContext.cgiGet( edtOsoC3992_Internalname) ;
            n306OsoC3992 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
            n306OsoC3992 = ((GXutil.strcmp("", A306OsoC3992)==0) ? true : false) ;
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOsoAporteAdic_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtOsoAporteAdic_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OSOAPORTEADIC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOsoAporteAdic_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A893OsoAporteAdic = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
            }
            else
            {
               A893OsoAporteAdic = localUtil.ctond( httpContext.cgiGet( edtOsoAporteAdic_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
            }
            dynOsoRelSec.setValue( httpContext.cgiGet( dynOsoRelSec.getInternalname()) );
            A1981OsoRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynOsoRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ObraSocial");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("OsoHabilitada", GXutil.booltostr( A308OsoHabilitada));
            forbiddenHiddens.add("OsoRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1982OsoRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("OsoPadre", GXutil.rtrim( localUtil.format( A1983OsoPadre, "")));
            forbiddenHiddens.add("OsoRelRef", GXutil.rtrim( localUtil.format( A2014OsoRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A5OsoCod, Z5OsoCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("obrasocial:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A5OsoCod = httpContext.GetPar( "OsoCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
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
                  sMode37 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode37 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound37 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_140( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
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
                        e11142 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12142 ();
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
         e12142 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1437( ) ;
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
         disableAttributes1437( ) ;
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

   public void confirm_140( )
   {
      beforeValidate1437( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1437( ) ;
         }
         else
         {
            checkExtendedTable1437( ) ;
            closeExtendedTableCursors1437( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption140( )
   {
   }

   public void e11142( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObraSocial_Insert", GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObraSocial_Update", GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObraSocial_Delete", GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV19Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV20GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         while ( AV20GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV20GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OsoActCom") == 0 )
            {
               AV16Insert_OsoActCom = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_OsoActCom", AV16Insert_OsoActCom);
            }
            AV20GXV1 = (int)(AV20GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e12142( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.obrasocialgrabarrelref(remoteHandle, context).execute( A3CliCod) ;
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

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divOsorelsec_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
      httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
   }

   public void zm1437( int GX_JID )
   {
      if ( ( GX_JID == 30 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z555OsoSiglaYDesc = T00143_A555OsoSiglaYDesc[0] ;
            Z681OsoDescripSinAc = T00143_A681OsoDescripSinAc[0] ;
            Z307OsoDescrip = T00143_A307OsoDescrip[0] ;
            Z392OsoSigla = T00143_A392OsoSigla[0] ;
            Z308OsoHabilitada = T00143_A308OsoHabilitada[0] ;
            Z306OsoC3992 = T00143_A306OsoC3992[0] ;
            Z893OsoAporteAdic = T00143_A893OsoAporteAdic[0] ;
            Z1981OsoRelSec = T00143_A1981OsoRelSec[0] ;
            Z1982OsoRelSecCli = T00143_A1982OsoRelSecCli[0] ;
            Z1983OsoPadre = T00143_A1983OsoPadre[0] ;
            Z2014OsoRelRef = T00143_A2014OsoRelRef[0] ;
            Z2160OsoActCom = T00143_A2160OsoActCom[0] ;
         }
         else
         {
            Z555OsoSiglaYDesc = A555OsoSiglaYDesc ;
            Z681OsoDescripSinAc = A681OsoDescripSinAc ;
            Z307OsoDescrip = A307OsoDescrip ;
            Z392OsoSigla = A392OsoSigla ;
            Z308OsoHabilitada = A308OsoHabilitada ;
            Z306OsoC3992 = A306OsoC3992 ;
            Z893OsoAporteAdic = A893OsoAporteAdic ;
            Z1981OsoRelSec = A1981OsoRelSec ;
            Z1982OsoRelSecCli = A1982OsoRelSecCli ;
            Z1983OsoPadre = A1983OsoPadre ;
            Z2014OsoRelRef = A2014OsoRelRef ;
            Z2160OsoActCom = A2160OsoActCom ;
         }
      }
      if ( GX_JID == -30 )
      {
         Z555OsoSiglaYDesc = A555OsoSiglaYDesc ;
         Z681OsoDescripSinAc = A681OsoDescripSinAc ;
         Z5OsoCod = A5OsoCod ;
         Z307OsoDescrip = A307OsoDescrip ;
         Z392OsoSigla = A392OsoSigla ;
         Z308OsoHabilitada = A308OsoHabilitada ;
         Z306OsoC3992 = A306OsoC3992 ;
         Z893OsoAporteAdic = A893OsoAporteAdic ;
         Z1981OsoRelSec = A1981OsoRelSec ;
         Z1982OsoRelSecCli = A1982OsoRelSecCli ;
         Z1983OsoPadre = A1983OsoPadre ;
         Z2014OsoRelRef = A2014OsoRelRef ;
         Z2035OsoOld = A2035OsoOld ;
         Z3CliCod = A3CliCod ;
         Z2160OsoActCom = A2160OsoActCom ;
         Z2161OsoActComDesc = A2161OsoActComDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaosorelsec_html1437( AV11CliCod) ;
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            obrasocial_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynOsoRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOsoRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynOsoRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7OsoCod)==0) )
      {
         A5OsoCod = AV7OsoCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
      }
      if ( ! (GXutil.strcmp("", AV7OsoCod)==0) )
      {
         edtOsoCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoCod_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7OsoCod)==0) )
      {
         edtOsoCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_OsoActCom)==0) )
      {
         A2160OsoActCom = AV16Insert_OsoActCom ;
         n2160OsoActCom = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2160OsoActCom", A2160OsoActCom);
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
      if ( isIns( )  && (false==A308OsoHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A308OsoHabilitada = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A308OsoHabilitada", A308OsoHabilitada);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV19Pgmname = "ObraSocial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
         /* Using cursor T00145 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
         A2161OsoActComDesc = T00145_A2161OsoActComDesc[0] ;
         pr_default.close(3);
      }
   }

   public void load1437( )
   {
      /* Using cursor T00146 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A555OsoSiglaYDesc = T00146_A555OsoSiglaYDesc[0] ;
         A681OsoDescripSinAc = T00146_A681OsoDescripSinAc[0] ;
         A307OsoDescrip = T00146_A307OsoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
         A392OsoSigla = T00146_A392OsoSigla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A392OsoSigla", A392OsoSigla);
         A308OsoHabilitada = T00146_A308OsoHabilitada[0] ;
         A306OsoC3992 = T00146_A306OsoC3992[0] ;
         n306OsoC3992 = T00146_n306OsoC3992[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
         A893OsoAporteAdic = T00146_A893OsoAporteAdic[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
         A1981OsoRelSec = T00146_A1981OsoRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
         A1982OsoRelSecCli = T00146_A1982OsoRelSecCli[0] ;
         A1983OsoPadre = T00146_A1983OsoPadre[0] ;
         A2014OsoRelRef = T00146_A2014OsoRelRef[0] ;
         A2035OsoOld = T00146_A2035OsoOld[0] ;
         A2161OsoActComDesc = T00146_A2161OsoActComDesc[0] ;
         A2160OsoActCom = T00146_A2160OsoActCom[0] ;
         n2160OsoActCom = T00146_n2160OsoActCom[0] ;
         zm1437( -30) ;
      }
      pr_default.close(4);
      onLoadActions1437( ) ;
   }

   public void onLoadActions1437( )
   {
      AV19Pgmname = "ObraSocial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) )
      {
         divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) )
         {
            divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
         }
      }
      GXt_char6 = A681OsoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char7) ;
      obrasocial_impl.this.GXt_char6 = GXv_char7[0] ;
      A681OsoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               A555OsoSiglaYDesc = A307OsoDescrip ;
               httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
         }
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoC3992_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoC3992_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoAporteAdic_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoAporteAdic_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoSigla_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoSigla_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
      }
   }

   public void checkExtendedTable1437( )
   {
      nIsDirty_37 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV19Pgmname = "ObraSocial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1981OsoRelSec, GXv_boolean3) ;
         obrasocial_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      /* Using cursor T00144 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) )
      {
         divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) )
         {
            divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A5OsoCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "OSOCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOsoCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) && (0==A1981OsoRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "OSOCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOsoCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_37 = (short)(1) ;
      GXt_char6 = A681OsoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char7) ;
      obrasocial_impl.this.GXt_char6 = GXv_char7[0] ;
      A681OsoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         nIsDirty_37 = (short)(1) ;
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            nIsDirty_37 = (short)(1) ;
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               nIsDirty_37 = (short)(1) ;
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
            else
            {
               nIsDirty_37 = (short)(1) ;
               A555OsoSiglaYDesc = A307OsoDescrip ;
               httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
            }
         }
      }
      if ( (GXutil.strcmp("", A307OsoDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "OSODESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOsoDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoC3992_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoC3992_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoAporteAdic_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoAporteAdic_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
      {
         edtOsoSigla_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
      }
      else
      {
         edtOsoSigla_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
      }
      /* Using cursor T00145 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A2160OsoActCom)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OSOACTCOM");
            AnyError = (short)(1) ;
         }
      }
      A2161OsoActComDesc = T00145_A2161OsoActComDesc[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors1437( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_31( int A3CliCod )
   {
      /* Using cursor T00147 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
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

   public void gxload_32( String A2160OsoActCom )
   {
      /* Using cursor T00148 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A2160OsoActCom)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OSOACTCOM");
            AnyError = (short)(1) ;
         }
      }
      A2161OsoActComDesc = T00148_A2161OsoActComDesc[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2161OsoActComDesc)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1437( )
   {
      /* Using cursor T00149 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound37 = (short)(1) ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00143 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1437( 30) ;
         RcdFound37 = (short)(1) ;
         A555OsoSiglaYDesc = T00143_A555OsoSiglaYDesc[0] ;
         A681OsoDescripSinAc = T00143_A681OsoDescripSinAc[0] ;
         A5OsoCod = T00143_A5OsoCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
         A307OsoDescrip = T00143_A307OsoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
         A392OsoSigla = T00143_A392OsoSigla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A392OsoSigla", A392OsoSigla);
         A308OsoHabilitada = T00143_A308OsoHabilitada[0] ;
         A306OsoC3992 = T00143_A306OsoC3992[0] ;
         n306OsoC3992 = T00143_n306OsoC3992[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
         A893OsoAporteAdic = T00143_A893OsoAporteAdic[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
         A1981OsoRelSec = T00143_A1981OsoRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
         A1982OsoRelSecCli = T00143_A1982OsoRelSecCli[0] ;
         A1983OsoPadre = T00143_A1983OsoPadre[0] ;
         A2014OsoRelRef = T00143_A2014OsoRelRef[0] ;
         A2035OsoOld = T00143_A2035OsoOld[0] ;
         A3CliCod = T00143_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2160OsoActCom = T00143_A2160OsoActCom[0] ;
         n2160OsoActCom = T00143_n2160OsoActCom[0] ;
         O893OsoAporteAdic = A893OsoAporteAdic ;
         httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
         O306OsoC3992 = A306OsoC3992 ;
         n306OsoC3992 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
         O307OsoDescrip = A307OsoDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
         O5OsoCod = A5OsoCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
         Z3CliCod = A3CliCod ;
         Z5OsoCod = A5OsoCod ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1437( ) ;
         if ( AnyError == 1 )
         {
            RcdFound37 = (short)(0) ;
            initializeNonKey1437( ) ;
         }
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound37 = (short)(0) ;
         initializeNonKey1437( ) ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1437( ) ;
      if ( RcdFound37 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound37 = (short)(0) ;
      /* Using cursor T001410 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A5OsoCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001410_A3CliCod[0] < A3CliCod ) || ( T001410_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001410_A5OsoCod[0], A5OsoCod) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001410_A3CliCod[0] > A3CliCod ) || ( T001410_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001410_A5OsoCod[0], A5OsoCod) > 0 ) ) )
         {
            A3CliCod = T001410_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A5OsoCod = T001410_A5OsoCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound37 = (short)(0) ;
      /* Using cursor T001411 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A5OsoCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001411_A3CliCod[0] > A3CliCod ) || ( T001411_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001411_A5OsoCod[0], A5OsoCod) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001411_A3CliCod[0] < A3CliCod ) || ( T001411_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001411_A5OsoCod[0], A5OsoCod) < 0 ) ) )
         {
            A3CliCod = T001411_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A5OsoCod = T001411_A5OsoCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1437( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtOsoCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1437( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound37 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A5OsoCod, Z5OsoCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A5OsoCod = Z5OsoCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtOsoCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1437( ) ;
               GX_FocusControl = edtOsoCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A5OsoCod, Z5OsoCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtOsoCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1437( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtOsoCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1437( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A5OsoCod, Z5OsoCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A5OsoCod = Z5OsoCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtOsoCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1437( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00142 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObraSocial"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z555OsoSiglaYDesc, T00142_A555OsoSiglaYDesc[0]) != 0 ) || ( GXutil.strcmp(Z681OsoDescripSinAc, T00142_A681OsoDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z307OsoDescrip, T00142_A307OsoDescrip[0]) != 0 ) || ( GXutil.strcmp(Z392OsoSigla, T00142_A392OsoSigla[0]) != 0 ) || ( Z308OsoHabilitada != T00142_A308OsoHabilitada[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z306OsoC3992, T00142_A306OsoC3992[0]) != 0 ) || ( DecimalUtil.compareTo(Z893OsoAporteAdic, T00142_A893OsoAporteAdic[0]) != 0 ) || ( Z1981OsoRelSec != T00142_A1981OsoRelSec[0] ) || ( Z1982OsoRelSecCli != T00142_A1982OsoRelSecCli[0] ) || ( GXutil.strcmp(Z1983OsoPadre, T00142_A1983OsoPadre[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2014OsoRelRef, T00142_A2014OsoRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2160OsoActCom, T00142_A2160OsoActCom[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z555OsoSiglaYDesc, T00142_A555OsoSiglaYDesc[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoSiglaYDesc");
               GXutil.writeLogRaw("Old: ",Z555OsoSiglaYDesc);
               GXutil.writeLogRaw("Current: ",T00142_A555OsoSiglaYDesc[0]);
            }
            if ( GXutil.strcmp(Z681OsoDescripSinAc, T00142_A681OsoDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z681OsoDescripSinAc);
               GXutil.writeLogRaw("Current: ",T00142_A681OsoDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z307OsoDescrip, T00142_A307OsoDescrip[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoDescrip");
               GXutil.writeLogRaw("Old: ",Z307OsoDescrip);
               GXutil.writeLogRaw("Current: ",T00142_A307OsoDescrip[0]);
            }
            if ( GXutil.strcmp(Z392OsoSigla, T00142_A392OsoSigla[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoSigla");
               GXutil.writeLogRaw("Old: ",Z392OsoSigla);
               GXutil.writeLogRaw("Current: ",T00142_A392OsoSigla[0]);
            }
            if ( Z308OsoHabilitada != T00142_A308OsoHabilitada[0] )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoHabilitada");
               GXutil.writeLogRaw("Old: ",Z308OsoHabilitada);
               GXutil.writeLogRaw("Current: ",T00142_A308OsoHabilitada[0]);
            }
            if ( GXutil.strcmp(Z306OsoC3992, T00142_A306OsoC3992[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoC3992");
               GXutil.writeLogRaw("Old: ",Z306OsoC3992);
               GXutil.writeLogRaw("Current: ",T00142_A306OsoC3992[0]);
            }
            if ( DecimalUtil.compareTo(Z893OsoAporteAdic, T00142_A893OsoAporteAdic[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoAporteAdic");
               GXutil.writeLogRaw("Old: ",Z893OsoAporteAdic);
               GXutil.writeLogRaw("Current: ",T00142_A893OsoAporteAdic[0]);
            }
            if ( Z1981OsoRelSec != T00142_A1981OsoRelSec[0] )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoRelSec");
               GXutil.writeLogRaw("Old: ",Z1981OsoRelSec);
               GXutil.writeLogRaw("Current: ",T00142_A1981OsoRelSec[0]);
            }
            if ( Z1982OsoRelSecCli != T00142_A1982OsoRelSecCli[0] )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1982OsoRelSecCli);
               GXutil.writeLogRaw("Current: ",T00142_A1982OsoRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z1983OsoPadre, T00142_A1983OsoPadre[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoPadre");
               GXutil.writeLogRaw("Old: ",Z1983OsoPadre);
               GXutil.writeLogRaw("Current: ",T00142_A1983OsoPadre[0]);
            }
            if ( GXutil.strcmp(Z2014OsoRelRef, T00142_A2014OsoRelRef[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoRelRef");
               GXutil.writeLogRaw("Old: ",Z2014OsoRelRef);
               GXutil.writeLogRaw("Current: ",T00142_A2014OsoRelRef[0]);
            }
            if ( GXutil.strcmp(Z2160OsoActCom, T00142_A2160OsoActCom[0]) != 0 )
            {
               GXutil.writeLogln("obrasocial:[seudo value changed for attri]"+"OsoActCom");
               GXutil.writeLogRaw("Old: ",Z2160OsoActCom);
               GXutil.writeLogRaw("Current: ",T00142_A2160OsoActCom[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ObraSocial"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1437( )
   {
      beforeValidate1437( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1437( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1437( 0) ;
         checkOptimisticConcurrency1437( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1437( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1437( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001412 */
                  pr_default.execute(10, new Object[] {A555OsoSiglaYDesc, A681OsoDescripSinAc, A5OsoCod, A307OsoDescrip, A392OsoSigla, Boolean.valueOf(A308OsoHabilitada), Boolean.valueOf(n306OsoC3992), A306OsoC3992, A893OsoAporteAdic, Integer.valueOf(A1981OsoRelSec), Integer.valueOf(A1982OsoRelSecCli), A1983OsoPadre, A2014OsoRelRef, A2035OsoOld, Integer.valueOf(A3CliCod), Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
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
                        resetCaption140( ) ;
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
            load1437( ) ;
         }
         endLevel1437( ) ;
      }
      closeExtendedTableCursors1437( ) ;
   }

   public void update1437( )
   {
      beforeValidate1437( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1437( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1437( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1437( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1437( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001413 */
                  pr_default.execute(11, new Object[] {A555OsoSiglaYDesc, A681OsoDescripSinAc, A307OsoDescrip, A392OsoSigla, Boolean.valueOf(A308OsoHabilitada), Boolean.valueOf(n306OsoC3992), A306OsoC3992, A893OsoAporteAdic, Integer.valueOf(A1981OsoRelSec), Integer.valueOf(A1982OsoRelSecCli), A1983OsoPadre, A2014OsoRelRef, A2035OsoOld, Boolean.valueOf(n2160OsoActCom), A2160OsoActCom, Integer.valueOf(A3CliCod), A5OsoCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObraSocial"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1437( ) ;
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
         endLevel1437( ) ;
      }
      closeExtendedTableCursors1437( ) ;
   }

   public void deferredUpdate1437( )
   {
   }

   public void delete( )
   {
      beforeValidate1437( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1437( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1437( ) ;
         afterConfirm1437( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1437( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001414 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
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
      sMode37 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1437( ) ;
      Gx_mode = sMode37 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1437( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV15aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1981OsoRelSec, GXv_boolean3) ;
            obrasocial_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
         }
         AV19Pgmname = "ObraSocial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) )
         {
            divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean2 = false ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
            obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) )
            {
               divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
            }
         }
         if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
         {
            edtOsoDescrip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
         }
         else
         {
            edtOsoDescrip_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
         }
         if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
         {
            edtOsoC3992_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
         }
         else
         {
            edtOsoC3992_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
         }
         if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
         {
            edtOsoAporteAdic_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
         }
         else
         {
            edtOsoAporteAdic_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
         }
         if ( ! (GXutil.strcmp("", A1983OsoPadre)==0) )
         {
            edtOsoSigla_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
         }
         else
         {
            edtOsoSigla_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
         }
         /* Using cursor T001415 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
         A2161OsoActComDesc = T001415_A2161OsoActComDesc[0] ;
         pr_default.close(13);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001416 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001417 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void endLevel1437( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1437( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "obrasocial");
         if ( AnyError == 0 )
         {
            confirmValues140( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "obrasocial");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1437( )
   {
      /* Scan By routine */
      /* Using cursor T001418 */
      pr_default.execute(16);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A3CliCod = T001418_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A5OsoCod = T001418_A5OsoCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1437( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A3CliCod = T001418_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A5OsoCod = T001418_A5OsoCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
      }
   }

   public void scanEnd1437( )
   {
      pr_default.close(16);
   }

   public void afterConfirm1437( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV15aplicadoHay ) && ! (0==A1981OsoRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV11CliCod), "OsoRelSec", 1, "OSORELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOsoRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert1437( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1437( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1437( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1437( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1437( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1437( )
   {
      edtOsoCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOsoCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoCod_Enabled), 5, 0), true);
      edtOsoDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOsoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoDescrip_Enabled), 5, 0), true);
      edtOsoSigla_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOsoSigla_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoSigla_Enabled), 5, 0), true);
      edtOsoC3992_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOsoC3992_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoC3992_Enabled), 5, 0), true);
      edtOsoAporteAdic_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOsoAporteAdic_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOsoAporteAdic_Enabled), 5, 0), true);
      dynOsoRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOsoRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynOsoRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1437( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues140( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.obrasocial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7OsoCod))}, new String[] {"Gx_mode","CliCod","OsoCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ObraSocial");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("OsoHabilitada", GXutil.booltostr( A308OsoHabilitada));
      forbiddenHiddens.add("OsoRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1982OsoRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("OsoPadre", GXutil.rtrim( localUtil.format( A1983OsoPadre, "")));
      forbiddenHiddens.add("OsoRelRef", GXutil.rtrim( localUtil.format( A2014OsoRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("obrasocial:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z5OsoCod", GXutil.rtrim( Z5OsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z555OsoSiglaYDesc", Z555OsoSiglaYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z681OsoDescripSinAc", Z681OsoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z307OsoDescrip", Z307OsoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z392OsoSigla", GXutil.rtrim( Z392OsoSigla));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z308OsoHabilitada", Z308OsoHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, "Z306OsoC3992", GXutil.rtrim( Z306OsoC3992));
      web.GxWebStd.gx_hidden_field( httpContext, "Z893OsoAporteAdic", GXutil.ltrim( localUtil.ntoc( Z893OsoAporteAdic, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1981OsoRelSec", GXutil.ltrim( localUtil.ntoc( Z1981OsoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1982OsoRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1982OsoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1983OsoPadre", GXutil.rtrim( Z1983OsoPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2014OsoRelRef", Z2014OsoRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2160OsoActCom", GXutil.rtrim( Z2160OsoActCom));
      web.GxWebStd.gx_hidden_field( httpContext, "O893OsoAporteAdic", GXutil.ltrim( localUtil.ntoc( O893OsoAporteAdic, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O306OsoC3992", GXutil.rtrim( O306OsoC3992));
      web.GxWebStd.gx_hidden_field( httpContext, "O307OsoDescrip", O307OsoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O5OsoCod", GXutil.rtrim( O5OsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N2160OsoActCom", GXutil.rtrim( A2160OsoActCom));
      web.GxWebStd.gx_hidden_field( httpContext, "N307OsoDescrip", A307OsoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "N306OsoC3992", GXutil.rtrim( A306OsoC3992));
      web.GxWebStd.gx_hidden_field( httpContext, "N893OsoAporteAdic", GXutil.ltrim( localUtil.ntoc( A893OsoAporteAdic, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N392OsoSigla", GXutil.rtrim( A392OsoSigla));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "OSODESCRIPSINAC", A681OsoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "OSOSIGLAYDESC", A555OsoSiglaYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOSOCOD", GXutil.rtrim( AV7OsoCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOSOCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7OsoCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_OSOACTCOM", GXutil.rtrim( AV16Insert_OsoActCom));
      web.GxWebStd.gx_hidden_field( httpContext, "OSOACTCOM", GXutil.rtrim( A2160OsoActCom));
      web.GxWebStd.gx_hidden_field( httpContext, "OSOPADRE", GXutil.rtrim( A1983OsoPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "OSOHABILITADA", A308OsoHabilitada);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV15aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "OSORELSECCLI", GXutil.ltrim( localUtil.ntoc( A1982OsoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "OSORELREF", A2014OsoRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "OSOOLD", A2035OsoOld);
      web.GxWebStd.gx_hidden_field( httpContext, "OSOACTCOMDESC", A2161OsoActComDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
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
      return formatLink("web.obrasocial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7OsoCod))}, new String[] {"Gx_mode","CliCod","OsoCod"})  ;
   }

   public String getPgmname( )
   {
      return "ObraSocial" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Obra Social", "") ;
   }

   public void initializeNonKey1437( )
   {
      A2160OsoActCom = "" ;
      n2160OsoActCom = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2160OsoActCom", A2160OsoActCom);
      AV15aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      A555OsoSiglaYDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A555OsoSiglaYDesc", A555OsoSiglaYDesc);
      A681OsoDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      A307OsoDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
      A392OsoSigla = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A392OsoSigla", A392OsoSigla);
      A306OsoC3992 = "" ;
      n306OsoC3992 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
      n306OsoC3992 = ((GXutil.strcmp("", A306OsoC3992)==0) ? true : false) ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
      A1981OsoRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1981OsoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1981OsoRelSec), 6, 0));
      A1982OsoRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1982OsoRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1982OsoRelSecCli), 6, 0));
      A1983OsoPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1983OsoPadre", A1983OsoPadre);
      A2014OsoRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2014OsoRelRef", A2014OsoRelRef);
      A2035OsoOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2035OsoOld", A2035OsoOld);
      A2161OsoActComDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2161OsoActComDesc", A2161OsoActComDesc);
      A308OsoHabilitada = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A308OsoHabilitada", A308OsoHabilitada);
      O893OsoAporteAdic = A893OsoAporteAdic ;
      httpContext.ajax_rsp_assign_attri("", false, "A893OsoAporteAdic", GXutil.ltrimstr( A893OsoAporteAdic, 14, 2));
      O306OsoC3992 = A306OsoC3992 ;
      n306OsoC3992 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A306OsoC3992", A306OsoC3992);
      O307OsoDescrip = A307OsoDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A307OsoDescrip", A307OsoDescrip);
      Z555OsoSiglaYDesc = "" ;
      Z681OsoDescripSinAc = "" ;
      Z307OsoDescrip = "" ;
      Z392OsoSigla = "" ;
      Z308OsoHabilitada = false ;
      Z306OsoC3992 = "" ;
      Z893OsoAporteAdic = DecimalUtil.ZERO ;
      Z1981OsoRelSec = 0 ;
      Z1982OsoRelSecCli = 0 ;
      Z1983OsoPadre = "" ;
      Z2014OsoRelRef = "" ;
      Z2160OsoActCom = "" ;
   }

   public void initAll1437( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A5OsoCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A5OsoCod", A5OsoCod);
      initializeNonKey1437( ) ;
   }

   public void standaloneModalInsert( )
   {
      A308OsoHabilitada = i308OsoHabilitada ;
      httpContext.ajax_rsp_assign_attri("", false, "A308OsoHabilitada", A308OsoHabilitada);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713562496", true, true);
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
      httpContext.AddJavascriptSource("obrasocial.js", "?20251713562496", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtOsoCod_Internalname = "OSOCOD" ;
      edtOsoDescrip_Internalname = "OSODESCRIP" ;
      edtOsoSigla_Internalname = "OSOSIGLA" ;
      edtOsoC3992_Internalname = "OSOC3992" ;
      edtOsoAporteAdic_Internalname = "OSOAPORTEADIC" ;
      dynOsoRelSec.setInternalname( "OSORELSEC" );
      divOsorelsec_cell_Internalname = "OSORELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Obra Social", "") );
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynOsoRelSec.setJsonclick( "" );
      dynOsoRelSec.setEnabled( 1 );
      dynOsoRelSec.setVisible( 1 );
      divOsorelsec_cell_Class = "col-xs-12 col-sm-6" ;
      edtOsoAporteAdic_Jsonclick = "" ;
      edtOsoAporteAdic_Enabled = 1 ;
      edtOsoC3992_Jsonclick = "" ;
      edtOsoC3992_Enabled = 1 ;
      edtOsoSigla_Jsonclick = "" ;
      edtOsoSigla_Enabled = 1 ;
      edtOsoDescrip_Enabled = 1 ;
      edtOsoCod_Jsonclick = "" ;
      edtOsoCod_Enabled = 1 ;
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

   public void gxdlaosorelsec1437( int AV11CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaosorelsec_data1437( AV11CliCod) ;
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

   public void gxaosorelsec_html1437( int AV11CliCod )
   {
      int gxdynajaxvalue;
      gxdlaosorelsec_data1437( AV11CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOsoRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynOsoRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaosorelsec_data1437( int AV11CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T001419 */
      pr_default.execute(17, new Object[] {Integer.valueOf(AV11CliCod)});
      while ( (pr_default.getStatus(17) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001419_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001419_A1880CliReDTChar[0]);
         pr_default.readNext(17);
      }
      pr_default.close(17);
   }

   public void gx3asaosodescripsinac1437( String A307OsoDescrip )
   {
      GXt_char6 = A681OsoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char7) ;
      obrasocial_impl.this.GXt_char6 = GXv_char7[0] ;
      A681OsoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A681OsoDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx5asaclicod1437( int AV11CliCod )
   {
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            obrasocial_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa19811437( int AV11CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynOsoRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOsoRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynOsoRelSec.getVisible(), 5, 0), true);
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

   public void xc_24_1437( String Gx_mode ,
                           int AV11CliCod ,
                           int A1981OsoRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1981OsoRelSec, GXv_boolean3) ;
         AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV15aplicadoHay))+"\"") ;
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
      dynOsoRelSec.setName( "OSORELSEC" );
      dynOsoRelSec.setWebtags( "" );
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

   public void valid_Clicod( )
   {
      A1981OsoRelSec = (int)(GXutil.lval( dynOsoRelSec.getValue())) ;
      /* Using cursor T001420 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Osodescrip( )
   {
      A1981OsoRelSec = (int)(GXutil.lval( dynOsoRelSec.getValue())) ;
      GXt_char6 = A681OsoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char7) ;
      obrasocial_impl.this.GXt_char6 = GXv_char7[0] ;
      A681OsoDescripSinAc = GXt_char6 ;
      if ( (GXutil.strcmp("", A307OsoDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "OSODESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOsoDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A681OsoDescripSinAc", A681OsoDescripSinAc);
   }

   public void valid_Osoaporteadic( )
   {
      n306OsoC3992 = false ;
      A1981OsoRelSec = (int)(GXutil.lval( dynOsoRelSec.getValue())) ;
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) )
      {
         divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         obrasocial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) )
         {
            divOsorelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
         }
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divOsorelsec_cell_Internalname, "Class", divOsorelsec_cell_Class, true);
   }

   public void valid_Osorelsec( )
   {
      n306OsoC3992 = false ;
      A1981OsoRelSec = (int)(GXutil.lval( dynOsoRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A5OsoCod, O5OsoCod) != 0 ) || ( GXutil.strcmp(A307OsoDescrip, O307OsoDescrip) != 0 ) || ( GXutil.strcmp(A306OsoC3992, O306OsoC3992) != 0 ) || ( DecimalUtil.compareTo(A893OsoAporteAdic, O893OsoAporteAdic) != 0 ) ) ) && (0==A1981OsoRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "OSORELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOsoRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1981OsoRelSec, GXv_boolean3) ;
         obrasocial_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         AV15aplicadoHay = this.AV15aplicadoHay ;
      }
      O893OsoAporteAdic = A893OsoAporteAdic ;
      O306OsoC3992 = A306OsoC3992 ;
      n306OsoC3992 = false ;
      O307OsoDescrip = A307OsoDescrip ;
      O5OsoCod = A5OsoCod ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7OsoCod',fld:'vOSOCOD',pic:'',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7OsoCod',fld:'vOSOCOD',pic:'',hsh:true},{av:'A308OsoHabilitada',fld:'OSOHABILITADA',pic:''},{av:'A1982OsoRelSecCli',fld:'OSORELSECCLI',pic:'ZZZZZ9'},{av:'A1983OsoPadre',fld:'OSOPADRE',pic:''},{av:'A2014OsoRelRef',fld:'OSORELREF',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12142',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSOCOD","{handler:'valid_Osocod',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSOCOD",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSODESCRIP","{handler:'valid_Osodescrip',iparms:[{av:'A307OsoDescrip',fld:'OSODESCRIP',pic:''},{av:'A681OsoDescripSinAc',fld:'OSODESCRIPSINAC',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSODESCRIP",",oparms:[{av:'A681OsoDescripSinAc',fld:'OSODESCRIPSINAC',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSOSIGLA","{handler:'valid_Ososigla',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSOSIGLA",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSOC3992","{handler:'valid_Osoc3992',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSOC3992",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSOAPORTEADIC","{handler:'valid_Osoaporteadic',iparms:[{av:'O893OsoAporteAdic'},{av:'O306OsoC3992'},{av:'O307OsoDescrip'},{av:'O5OsoCod'},{av:'A5OsoCod',fld:'OSOCOD',pic:''},{av:'A307OsoDescrip',fld:'OSODESCRIP',pic:''},{av:'A306OsoC3992',fld:'OSOC3992',pic:''},{av:'A893OsoAporteAdic',fld:'OSOAPORTEADIC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSOAPORTEADIC",",oparms:[{av:'divOsorelsec_cell_Class',ctrl:'OSORELSEC_CELL',prop:'Class'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OSORELSEC","{handler:'valid_Osorelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O893OsoAporteAdic'},{av:'O306OsoC3992'},{av:'O307OsoDescrip'},{av:'O5OsoCod'},{av:'A5OsoCod',fld:'OSOCOD',pic:''},{av:'A307OsoDescrip',fld:'OSODESCRIP',pic:''},{av:'A306OsoC3992',fld:'OSOC3992',pic:''},{av:'A893OsoAporteAdic',fld:'OSOAPORTEADIC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OSORELSEC",",oparms:[{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOsoRelSec'},{av:'A1981OsoRelSec',fld:'OSORELSEC',pic:'ZZZZZ9'}]}");
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
      return "obrasocial_Execute";
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7OsoCod = "" ;
      Z5OsoCod = "" ;
      Z555OsoSiglaYDesc = "" ;
      Z681OsoDescripSinAc = "" ;
      Z307OsoDescrip = "" ;
      Z392OsoSigla = "" ;
      Z306OsoC3992 = "" ;
      Z893OsoAporteAdic = DecimalUtil.ZERO ;
      Z1983OsoPadre = "" ;
      Z2014OsoRelRef = "" ;
      Z2160OsoActCom = "" ;
      O893OsoAporteAdic = DecimalUtil.ZERO ;
      O306OsoC3992 = "" ;
      O307OsoDescrip = "" ;
      O5OsoCod = "" ;
      N2160OsoActCom = "" ;
      N307OsoDescrip = "" ;
      N306OsoC3992 = "" ;
      N893OsoAporteAdic = DecimalUtil.ZERO ;
      N392OsoSigla = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A307OsoDescrip = "" ;
      A2160OsoActCom = "" ;
      AV7OsoCod = "" ;
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
      A5OsoCod = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A555OsoSiglaYDesc = "" ;
      A681OsoDescripSinAc = "" ;
      A1983OsoPadre = "" ;
      A2014OsoRelRef = "" ;
      AV16Insert_OsoActCom = "" ;
      A2035OsoOld = "" ;
      A2161OsoActComDesc = "" ;
      AV19Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode37 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z2035OsoOld = "" ;
      Z2161OsoActComDesc = "" ;
      T00145_A2161OsoActComDesc = new String[] {""} ;
      T00146_A555OsoSiglaYDesc = new String[] {""} ;
      T00146_A681OsoDescripSinAc = new String[] {""} ;
      T00146_A5OsoCod = new String[] {""} ;
      T00146_A307OsoDescrip = new String[] {""} ;
      T00146_A392OsoSigla = new String[] {""} ;
      T00146_A308OsoHabilitada = new boolean[] {false} ;
      T00146_A306OsoC3992 = new String[] {""} ;
      T00146_n306OsoC3992 = new boolean[] {false} ;
      T00146_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00146_A1981OsoRelSec = new int[1] ;
      T00146_A1982OsoRelSecCli = new int[1] ;
      T00146_A1983OsoPadre = new String[] {""} ;
      T00146_A2014OsoRelRef = new String[] {""} ;
      T00146_A2035OsoOld = new String[] {""} ;
      T00146_A2161OsoActComDesc = new String[] {""} ;
      T00146_A3CliCod = new int[1] ;
      T00146_A2160OsoActCom = new String[] {""} ;
      T00146_n2160OsoActCom = new boolean[] {false} ;
      T00144_A3CliCod = new int[1] ;
      T00147_A3CliCod = new int[1] ;
      T00148_A2161OsoActComDesc = new String[] {""} ;
      T00149_A3CliCod = new int[1] ;
      T00149_A5OsoCod = new String[] {""} ;
      T00143_A555OsoSiglaYDesc = new String[] {""} ;
      T00143_A681OsoDescripSinAc = new String[] {""} ;
      T00143_A5OsoCod = new String[] {""} ;
      T00143_A307OsoDescrip = new String[] {""} ;
      T00143_A392OsoSigla = new String[] {""} ;
      T00143_A308OsoHabilitada = new boolean[] {false} ;
      T00143_A306OsoC3992 = new String[] {""} ;
      T00143_n306OsoC3992 = new boolean[] {false} ;
      T00143_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00143_A1981OsoRelSec = new int[1] ;
      T00143_A1982OsoRelSecCli = new int[1] ;
      T00143_A1983OsoPadre = new String[] {""} ;
      T00143_A2014OsoRelRef = new String[] {""} ;
      T00143_A2035OsoOld = new String[] {""} ;
      T00143_A3CliCod = new int[1] ;
      T00143_A2160OsoActCom = new String[] {""} ;
      T00143_n2160OsoActCom = new boolean[] {false} ;
      T001410_A3CliCod = new int[1] ;
      T001410_A5OsoCod = new String[] {""} ;
      T001411_A3CliCod = new int[1] ;
      T001411_A5OsoCod = new String[] {""} ;
      T00142_A555OsoSiglaYDesc = new String[] {""} ;
      T00142_A681OsoDescripSinAc = new String[] {""} ;
      T00142_A5OsoCod = new String[] {""} ;
      T00142_A307OsoDescrip = new String[] {""} ;
      T00142_A392OsoSigla = new String[] {""} ;
      T00142_A308OsoHabilitada = new boolean[] {false} ;
      T00142_A306OsoC3992 = new String[] {""} ;
      T00142_n306OsoC3992 = new boolean[] {false} ;
      T00142_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00142_A1981OsoRelSec = new int[1] ;
      T00142_A1982OsoRelSecCli = new int[1] ;
      T00142_A1983OsoPadre = new String[] {""} ;
      T00142_A2014OsoRelRef = new String[] {""} ;
      T00142_A2035OsoOld = new String[] {""} ;
      T00142_A3CliCod = new int[1] ;
      T00142_A2160OsoActCom = new String[] {""} ;
      T00142_n2160OsoActCom = new boolean[] {false} ;
      T001415_A2161OsoActComDesc = new String[] {""} ;
      T001416_A3CliCod = new int[1] ;
      T001416_A1EmpCod = new short[1] ;
      T001416_A6LegNumero = new int[1] ;
      T001417_A3CliCod = new int[1] ;
      T001417_A1EmpCod = new short[1] ;
      T001418_A3CliCod = new int[1] ;
      T001418_A5OsoCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T001419_A3CliCod = new int[1] ;
      T001419_A1885CliRelSec = new int[1] ;
      T001419_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T001420_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obrasocial__default(),
         new Object[] {
             new Object[] {
            T00142_A555OsoSiglaYDesc, T00142_A681OsoDescripSinAc, T00142_A5OsoCod, T00142_A307OsoDescrip, T00142_A392OsoSigla, T00142_A308OsoHabilitada, T00142_A306OsoC3992, T00142_n306OsoC3992, T00142_A893OsoAporteAdic, T00142_A1981OsoRelSec,
            T00142_A1982OsoRelSecCli, T00142_A1983OsoPadre, T00142_A2014OsoRelRef, T00142_A2035OsoOld, T00142_A3CliCod, T00142_A2160OsoActCom, T00142_n2160OsoActCom
            }
            , new Object[] {
            T00143_A555OsoSiglaYDesc, T00143_A681OsoDescripSinAc, T00143_A5OsoCod, T00143_A307OsoDescrip, T00143_A392OsoSigla, T00143_A308OsoHabilitada, T00143_A306OsoC3992, T00143_n306OsoC3992, T00143_A893OsoAporteAdic, T00143_A1981OsoRelSec,
            T00143_A1982OsoRelSecCli, T00143_A1983OsoPadre, T00143_A2014OsoRelRef, T00143_A2035OsoOld, T00143_A3CliCod, T00143_A2160OsoActCom, T00143_n2160OsoActCom
            }
            , new Object[] {
            T00144_A3CliCod
            }
            , new Object[] {
            T00145_A2161OsoActComDesc
            }
            , new Object[] {
            T00146_A555OsoSiglaYDesc, T00146_A681OsoDescripSinAc, T00146_A5OsoCod, T00146_A307OsoDescrip, T00146_A392OsoSigla, T00146_A308OsoHabilitada, T00146_A306OsoC3992, T00146_n306OsoC3992, T00146_A893OsoAporteAdic, T00146_A1981OsoRelSec,
            T00146_A1982OsoRelSecCli, T00146_A1983OsoPadre, T00146_A2014OsoRelRef, T00146_A2035OsoOld, T00146_A2161OsoActComDesc, T00146_A3CliCod, T00146_A2160OsoActCom, T00146_n2160OsoActCom
            }
            , new Object[] {
            T00147_A3CliCod
            }
            , new Object[] {
            T00148_A2161OsoActComDesc
            }
            , new Object[] {
            T00149_A3CliCod, T00149_A5OsoCod
            }
            , new Object[] {
            T001410_A3CliCod, T001410_A5OsoCod
            }
            , new Object[] {
            T001411_A3CliCod, T001411_A5OsoCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001415_A2161OsoActComDesc
            }
            , new Object[] {
            T001416_A3CliCod, T001416_A1EmpCod, T001416_A6LegNumero
            }
            , new Object[] {
            T001417_A3CliCod, T001417_A1EmpCod
            }
            , new Object[] {
            T001418_A3CliCod, T001418_A5OsoCod
            }
            , new Object[] {
            T001419_A3CliCod, T001419_A1885CliRelSec, T001419_A1880CliReDTChar
            }
            , new Object[] {
            T001420_A3CliCod
            }
         }
      );
      AV19Pgmname = "ObraSocial" ;
      Z308OsoHabilitada = true ;
      A308OsoHabilitada = true ;
      i308OsoHabilitada = true ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound37 ;
   private short nIsDirty_37 ;
   private int wcpOAV11CliCod ;
   private int Z3CliCod ;
   private int Z1981OsoRelSec ;
   private int Z1982OsoRelSecCli ;
   private int AV11CliCod ;
   private int A1981OsoRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtOsoCod_Enabled ;
   private int edtOsoDescrip_Enabled ;
   private int edtOsoSigla_Enabled ;
   private int edtOsoC3992_Enabled ;
   private int edtOsoAporteAdic_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1982OsoRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV20GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z893OsoAporteAdic ;
   private java.math.BigDecimal O893OsoAporteAdic ;
   private java.math.BigDecimal N893OsoAporteAdic ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7OsoCod ;
   private String Z5OsoCod ;
   private String Z392OsoSigla ;
   private String Z306OsoC3992 ;
   private String Z1983OsoPadre ;
   private String Z2160OsoActCom ;
   private String O306OsoC3992 ;
   private String O5OsoCod ;
   private String N2160OsoActCom ;
   private String N306OsoC3992 ;
   private String N392OsoSigla ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A2160OsoActCom ;
   private String AV7OsoCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtOsoCod_Internalname ;
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
   private String A5OsoCod ;
   private String edtOsoCod_Jsonclick ;
   private String edtOsoDescrip_Internalname ;
   private String edtOsoSigla_Internalname ;
   private String A392OsoSigla ;
   private String edtOsoSigla_Jsonclick ;
   private String edtOsoC3992_Internalname ;
   private String A306OsoC3992 ;
   private String edtOsoC3992_Jsonclick ;
   private String edtOsoAporteAdic_Internalname ;
   private String edtOsoAporteAdic_Jsonclick ;
   private String divOsorelsec_cell_Internalname ;
   private String divOsorelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A1983OsoPadre ;
   private String AV16Insert_OsoActCom ;
   private String AV19Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode37 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z308OsoHabilitada ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n2160OsoActCom ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n306OsoC3992 ;
   private boolean A308OsoHabilitada ;
   private boolean AV15aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean Gx_longc ;
   private boolean i308OsoHabilitada ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean ZV15aplicadoHay ;
   private String A2035OsoOld ;
   private String Z2035OsoOld ;
   private String Z555OsoSiglaYDesc ;
   private String Z681OsoDescripSinAc ;
   private String Z307OsoDescrip ;
   private String Z2014OsoRelRef ;
   private String O307OsoDescrip ;
   private String N307OsoDescrip ;
   private String A307OsoDescrip ;
   private String A555OsoSiglaYDesc ;
   private String A681OsoDescripSinAc ;
   private String A2014OsoRelRef ;
   private String A2161OsoActComDesc ;
   private String Z2161OsoActComDesc ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynOsoRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T00145_A2161OsoActComDesc ;
   private String[] T00146_A555OsoSiglaYDesc ;
   private String[] T00146_A681OsoDescripSinAc ;
   private String[] T00146_A5OsoCod ;
   private String[] T00146_A307OsoDescrip ;
   private String[] T00146_A392OsoSigla ;
   private boolean[] T00146_A308OsoHabilitada ;
   private String[] T00146_A306OsoC3992 ;
   private boolean[] T00146_n306OsoC3992 ;
   private java.math.BigDecimal[] T00146_A893OsoAporteAdic ;
   private int[] T00146_A1981OsoRelSec ;
   private int[] T00146_A1982OsoRelSecCli ;
   private String[] T00146_A1983OsoPadre ;
   private String[] T00146_A2014OsoRelRef ;
   private String[] T00146_A2035OsoOld ;
   private String[] T00146_A2161OsoActComDesc ;
   private int[] T00146_A3CliCod ;
   private String[] T00146_A2160OsoActCom ;
   private boolean[] T00146_n2160OsoActCom ;
   private int[] T00144_A3CliCod ;
   private int[] T00147_A3CliCod ;
   private String[] T00148_A2161OsoActComDesc ;
   private int[] T00149_A3CliCod ;
   private String[] T00149_A5OsoCod ;
   private String[] T00143_A555OsoSiglaYDesc ;
   private String[] T00143_A681OsoDescripSinAc ;
   private String[] T00143_A5OsoCod ;
   private String[] T00143_A307OsoDescrip ;
   private String[] T00143_A392OsoSigla ;
   private boolean[] T00143_A308OsoHabilitada ;
   private String[] T00143_A306OsoC3992 ;
   private boolean[] T00143_n306OsoC3992 ;
   private java.math.BigDecimal[] T00143_A893OsoAporteAdic ;
   private int[] T00143_A1981OsoRelSec ;
   private int[] T00143_A1982OsoRelSecCli ;
   private String[] T00143_A1983OsoPadre ;
   private String[] T00143_A2014OsoRelRef ;
   private String[] T00143_A2035OsoOld ;
   private int[] T00143_A3CliCod ;
   private String[] T00143_A2160OsoActCom ;
   private boolean[] T00143_n2160OsoActCom ;
   private int[] T001410_A3CliCod ;
   private String[] T001410_A5OsoCod ;
   private int[] T001411_A3CliCod ;
   private String[] T001411_A5OsoCod ;
   private String[] T00142_A555OsoSiglaYDesc ;
   private String[] T00142_A681OsoDescripSinAc ;
   private String[] T00142_A5OsoCod ;
   private String[] T00142_A307OsoDescrip ;
   private String[] T00142_A392OsoSigla ;
   private boolean[] T00142_A308OsoHabilitada ;
   private String[] T00142_A306OsoC3992 ;
   private boolean[] T00142_n306OsoC3992 ;
   private java.math.BigDecimal[] T00142_A893OsoAporteAdic ;
   private int[] T00142_A1981OsoRelSec ;
   private int[] T00142_A1982OsoRelSecCli ;
   private String[] T00142_A1983OsoPadre ;
   private String[] T00142_A2014OsoRelRef ;
   private String[] T00142_A2035OsoOld ;
   private int[] T00142_A3CliCod ;
   private String[] T00142_A2160OsoActCom ;
   private boolean[] T00142_n2160OsoActCom ;
   private String[] T001415_A2161OsoActComDesc ;
   private int[] T001416_A3CliCod ;
   private short[] T001416_A1EmpCod ;
   private int[] T001416_A6LegNumero ;
   private int[] T001417_A3CliCod ;
   private short[] T001417_A1EmpCod ;
   private int[] T001418_A3CliCod ;
   private String[] T001418_A5OsoCod ;
   private int[] T001419_A3CliCod ;
   private int[] T001419_A1885CliRelSec ;
   private String[] T001419_A1880CliReDTChar ;
   private int[] T001420_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
}

final  class obrasocial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00142", "SELECT OsoSiglaYDesc, OsoDescripSinAc, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoAporteAdic, OsoRelSec, OsoRelSecCli, OsoPadre, OsoRelRef, OsoOld, CliCod, OsoActCom FROM ObraSocial WHERE CliCod = ? AND OsoCod = ?  FOR UPDATE OF ObraSocial NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00143", "SELECT OsoSiglaYDesc, OsoDescripSinAc, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoAporteAdic, OsoRelSec, OsoRelSecCli, OsoPadre, OsoRelRef, OsoOld, CliCod, OsoActCom FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00144", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00145", "SELECT ActComDescripcion AS OsoActComDesc FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00146", "SELECT TM1.OsoSiglaYDesc, TM1.OsoDescripSinAc, TM1.OsoCod, TM1.OsoDescrip, TM1.OsoSigla, TM1.OsoHabilitada, TM1.OsoC3992, TM1.OsoAporteAdic, TM1.OsoRelSec, TM1.OsoRelSecCli, TM1.OsoPadre, TM1.OsoRelRef, TM1.OsoOld, T2.ActComDescripcion AS OsoActComDesc, TM1.CliCod, TM1.OsoActCom AS OsoActCom FROM (ObraSocial TM1 LEFT JOIN actividadcomercial T2 ON T2.ActComCodigo = TM1.OsoActCom) WHERE TM1.CliCod = ? and TM1.OsoCod = ( ?) ORDER BY TM1.CliCod, TM1.OsoCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00147", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00148", "SELECT ActComDescripcion AS OsoActComDesc FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00149", "SELECT CliCod, OsoCod FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001410", "SELECT CliCod, OsoCod FROM ObraSocial WHERE ( CliCod > ? or CliCod = ? and OsoCod > ( ?)) ORDER BY CliCod, OsoCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001411", "SELECT CliCod, OsoCod FROM ObraSocial WHERE ( CliCod < ? or CliCod = ? and OsoCod < ( ?)) ORDER BY CliCod DESC, OsoCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001412", "SAVEPOINT gxupdate;INSERT INTO ObraSocial(OsoSiglaYDesc, OsoDescripSinAc, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoAporteAdic, OsoRelSec, OsoRelSecCli, OsoPadre, OsoRelRef, OsoOld, CliCod, OsoActCom) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001413", "SAVEPOINT gxupdate;UPDATE ObraSocial SET OsoSiglaYDesc=?, OsoDescripSinAc=?, OsoDescrip=?, OsoSigla=?, OsoHabilitada=?, OsoC3992=?, OsoAporteAdic=?, OsoRelSec=?, OsoRelSecCli=?, OsoPadre=?, OsoRelRef=?, OsoOld=?, OsoActCom=?  WHERE CliCod = ? AND OsoCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001414", "SAVEPOINT gxupdate;DELETE FROM ObraSocial  WHERE CliCod = ? AND OsoCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001415", "SELECT ActComDescripcion AS OsoActComDesc FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001416", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegOsoCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001417", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? AND EmpOsoCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001418", "SELECT CliCod, OsoCod FROM ObraSocial ORDER BY CliCod, OsoCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001419", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001420", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[14])[0] = rslt.getVarchar(14);
               ((int[]) buf[15])[0] = rslt.getInt(15);
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 18 :
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setInt(10, ((Number) parms[10]).intValue());
               stmt.setString(11, (String)parms[11], 20);
               stmt.setVarchar(12, (String)parms[12], 40, false);
               stmt.setNLongVarchar(13, (String)parms[13], false);
               stmt.setInt(14, ((Number) parms[14]).intValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[16], 20);
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setString(10, (String)parms[10], 20);
               stmt.setVarchar(11, (String)parms[11], 40, false);
               stmt.setNLongVarchar(12, (String)parms[12], false);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[14], 20);
               }
               stmt.setInt(14, ((Number) parms[15]).intValue());
               stmt.setString(15, (String)parms[16], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

