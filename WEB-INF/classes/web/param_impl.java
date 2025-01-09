package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class param_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action13") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         A1996ParmRelSec = (int)(GXutil.lval( httpContext.GetPar( "ParmRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_13_1639( Gx_mode, AV11CliCod, A1996ParmRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PARMRELSEC") == 0 )
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
         gxdlaparmrelsec1639( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
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
         gx1asaclicod1639( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"") == 0 )
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
         gxasa19961639( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A3CliCod) ;
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
            AV7ParmCod = httpContext.GetPar( "ParmCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ParmCod", AV7ParmCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPARMCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ParmCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Valores Predeterminados y Otros Parámetros", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtParmCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public param_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public param_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( param_impl.class ));
   }

   public param_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynParmRelSec = new HTMLChoice();
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
      if ( dynParmRelSec.getItemCount() > 0 )
      {
         A1996ParmRelSec = (int)(GXutil.lval( dynParmRelSec.getValidValue(GXutil.trim( GXutil.str( A1996ParmRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynParmRelSec.setValue( GXutil.trim( GXutil.str( A1996ParmRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynParmRelSec.getInternalname(), "Values", dynParmRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Parámetro", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Param.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtParmCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtParmCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtParmCod_Internalname, GXutil.rtrim( A61ParmCod), GXutil.rtrim( localUtil.format( A61ParmCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtParmCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtParmCod_Enabled, 1, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Param.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtParmDescri_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtParmDescri_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtParmDescri_Internalname, A315ParmDescri, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", (short)(0), 1, edtParmDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Param.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtParmValue_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtParmValue_Internalname, httpContext.getMessage( "Valor", ""), "col-sm-3 AttributeLabel BootstrapTooltipRightLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      ClassString = "Attribute BootstrapTooltipRight" ;
      StyleString = "" ;
      ClassString = "Attribute BootstrapTooltipRight" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtParmValue_Internalname, A316ParmValue, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", (short)(0), 1, edtParmValue_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Param.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divParmrelsec_cell_Internalname, 1, 0, "px", 0, "px", divParmrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynParmRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynParmRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynParmRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynParmRelSec, dynParmRelSec.getInternalname(), GXutil.trim( GXutil.str( A1996ParmRelSec, 6, 0)), 1, dynParmRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynParmRelSec.getVisible(), dynParmRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "", true, (byte)(0), "HLP_Param.htm");
      dynParmRelSec.setValue( GXutil.trim( GXutil.str( A1996ParmRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynParmRelSec.getInternalname(), "Values", dynParmRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Param.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Param.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Param.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Param.htm");
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
      e11162 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z61ParmCod = httpContext.cgiGet( "Z61ParmCod") ;
            Z315ParmDescri = httpContext.cgiGet( "Z315ParmDescri") ;
            Z887ParmTipo = httpContext.cgiGet( "Z887ParmTipo") ;
            Z1364ParmDatoTipo = httpContext.cgiGet( "Z1364ParmDatoTipo") ;
            Z1996ParmRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1996ParmRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1997ParmRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1997ParmRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2019ParmRelRef = httpContext.cgiGet( "Z2019ParmRelRef") ;
            A887ParmTipo = httpContext.cgiGet( "Z887ParmTipo") ;
            A1364ParmDatoTipo = httpContext.cgiGet( "Z1364ParmDatoTipo") ;
            A1997ParmRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1997ParmRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2019ParmRelRef = httpContext.cgiGet( "Z2019ParmRelRef") ;
            O316ParmValue = httpContext.cgiGet( "O316ParmValue") ;
            O315ParmDescri = httpContext.cgiGet( "O315ParmDescri") ;
            O61ParmCod = httpContext.cgiGet( "O61ParmCod") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV11CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7ParmCod = httpContext.cgiGet( "vPARMCOD") ;
            AV15aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A887ParmTipo = httpContext.cgiGet( "PARMTIPO") ;
            A1364ParmDatoTipo = httpContext.cgiGet( "PARMDATOTIPO") ;
            A1997ParmRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "PARMRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2019ParmRelRef = httpContext.cgiGet( "PARMRELREF") ;
            A2031ParmOld = httpContext.cgiGet( "PARMOLD") ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A61ParmCod = httpContext.cgiGet( edtParmCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
            A315ParmDescri = httpContext.cgiGet( edtParmDescri_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
            A316ParmValue = httpContext.cgiGet( edtParmValue_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
            dynParmRelSec.setValue( httpContext.cgiGet( dynParmRelSec.getInternalname()) );
            A1996ParmRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynParmRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Param");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ParmTipo", GXutil.rtrim( localUtil.format( A887ParmTipo, "")));
            forbiddenHiddens.add("ParmDatoTipo", GXutil.rtrim( localUtil.format( A1364ParmDatoTipo, "")));
            forbiddenHiddens.add("ParmRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1997ParmRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("ParmRelRef", GXutil.rtrim( localUtil.format( A2019ParmRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A61ParmCod, Z61ParmCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("param:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A61ParmCod = httpContext.GetPar( "ParmCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
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
                  sMode39 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode39 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound39 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_160( ) ;
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
                        e11162 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12162 ();
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
         e12162 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1639( ) ;
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
         disableAttributes1639( ) ;
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

   public void confirm_160( )
   {
      beforeValidate1639( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1639( ) ;
         }
         else
         {
            checkExtendedTable1639( ) ;
            closeExtendedTableCursors1639( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption160( )
   {
   }

   public void e11162( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      edtParmValue_Tooltiptext = httpContext.getMessage( "Valor de parámetro", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtParmValue_Internalname, "Tooltiptext", edtParmValue_Tooltiptext, true);
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParam_Insert", GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParam_Update", GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParam_Delete", GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e12162( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.paramgrabarrelref(remoteHandle, context).execute( A3CliCod) ;
      new web.removerdesesion(remoteHandle, context).execute( httpContext.getMessage( "getParametro_", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+"_"+GXutil.trim( AV7ParmCod)) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divParmrelsec_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
      httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
   }

   public void zm1639( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z315ParmDescri = T00163_A315ParmDescri[0] ;
            Z887ParmTipo = T00163_A887ParmTipo[0] ;
            Z1364ParmDatoTipo = T00163_A1364ParmDatoTipo[0] ;
            Z1996ParmRelSec = T00163_A1996ParmRelSec[0] ;
            Z1997ParmRelSecCli = T00163_A1997ParmRelSecCli[0] ;
            Z2019ParmRelRef = T00163_A2019ParmRelRef[0] ;
         }
         else
         {
            Z315ParmDescri = A315ParmDescri ;
            Z887ParmTipo = A887ParmTipo ;
            Z1364ParmDatoTipo = A1364ParmDatoTipo ;
            Z1996ParmRelSec = A1996ParmRelSec ;
            Z1997ParmRelSecCli = A1997ParmRelSecCli ;
            Z2019ParmRelRef = A2019ParmRelRef ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z61ParmCod = A61ParmCod ;
         Z316ParmValue = A316ParmValue ;
         Z315ParmDescri = A315ParmDescri ;
         Z887ParmTipo = A887ParmTipo ;
         Z1364ParmDatoTipo = A1364ParmDatoTipo ;
         Z1996ParmRelSec = A1996ParmRelSec ;
         Z1997ParmRelSecCli = A1997ParmRelSecCli ;
         Z2019ParmRelRef = A2019ParmRelRef ;
         Z2031ParmOld = A2031ParmOld ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaparmrelsec_html1639( AV11CliCod) ;
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
            param_impl.this.GXt_int4 = GXv_int5[0] ;
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
      param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynParmRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynParmRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynParmRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7ParmCod)==0) )
      {
         A61ParmCod = AV7ParmCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
      }
      if ( ! (GXutil.strcmp("", AV7ParmCod)==0) )
      {
         edtParmCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtParmCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmCod_Enabled), 5, 0), true);
      }
      else
      {
         edtParmCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtParmCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7ParmCod)==0) )
      {
         edtParmCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtParmCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmCod_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV16Pgmname = "Param" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
   }

   public void load1639( )
   {
      /* Using cursor T00165 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A316ParmValue = T00165_A316ParmValue[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
         A315ParmDescri = T00165_A315ParmDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
         A887ParmTipo = T00165_A887ParmTipo[0] ;
         A1364ParmDatoTipo = T00165_A1364ParmDatoTipo[0] ;
         A1996ParmRelSec = T00165_A1996ParmRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
         A1997ParmRelSecCli = T00165_A1997ParmRelSecCli[0] ;
         A2019ParmRelRef = T00165_A2019ParmRelRef[0] ;
         A2031ParmOld = T00165_A2031ParmOld[0] ;
         zm1639( -15) ;
      }
      pr_default.close(3);
      onLoadActions1639( ) ;
   }

   public void onLoadActions1639( )
   {
      AV16Pgmname = "Param" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) )
      {
         divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) )
         {
            divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable1639( )
   {
      nIsDirty_39 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV16Pgmname = "Param" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1996ParmRelSec, GXv_boolean3) ;
         param_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      /* Using cursor T00164 */
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
      param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) )
      {
         divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) )
         {
            divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A61ParmCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Cod", ""), "", "", "", "", "", "", "", ""), 1, "PARMCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtParmCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) && (0==A1996ParmRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PARMCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtParmCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A315ParmDescri)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descri", ""), "", "", "", "", "", "", "", ""), 1, "PARMDESCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtParmDescri_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1639( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_16( int A3CliCod )
   {
      /* Using cursor T00166 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey1639( )
   {
      /* Using cursor T00167 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound39 = (short)(1) ;
      }
      else
      {
         RcdFound39 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00163 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1639( 15) ;
         RcdFound39 = (short)(1) ;
         A61ParmCod = T00163_A61ParmCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
         A316ParmValue = T00163_A316ParmValue[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
         A315ParmDescri = T00163_A315ParmDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
         A887ParmTipo = T00163_A887ParmTipo[0] ;
         A1364ParmDatoTipo = T00163_A1364ParmDatoTipo[0] ;
         A1996ParmRelSec = T00163_A1996ParmRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
         A1997ParmRelSecCli = T00163_A1997ParmRelSecCli[0] ;
         A2019ParmRelRef = T00163_A2019ParmRelRef[0] ;
         A2031ParmOld = T00163_A2031ParmOld[0] ;
         A3CliCod = T00163_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O316ParmValue = A316ParmValue ;
         httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
         O315ParmDescri = A315ParmDescri ;
         httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
         O61ParmCod = A61ParmCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
         Z3CliCod = A3CliCod ;
         Z61ParmCod = A61ParmCod ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1639( ) ;
         if ( AnyError == 1 )
         {
            RcdFound39 = (short)(0) ;
            initializeNonKey1639( ) ;
         }
         Gx_mode = sMode39 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound39 = (short)(0) ;
         initializeNonKey1639( ) ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode39 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1639( ) ;
      if ( RcdFound39 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound39 = (short)(0) ;
      /* Using cursor T00168 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A61ParmCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00168_A3CliCod[0] < A3CliCod ) || ( T00168_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00168_A61ParmCod[0], A61ParmCod) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00168_A3CliCod[0] > A3CliCod ) || ( T00168_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00168_A61ParmCod[0], A61ParmCod) > 0 ) ) )
         {
            A3CliCod = T00168_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A61ParmCod = T00168_A61ParmCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
            RcdFound39 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound39 = (short)(0) ;
      /* Using cursor T00169 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A61ParmCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00169_A3CliCod[0] > A3CliCod ) || ( T00169_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00169_A61ParmCod[0], A61ParmCod) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00169_A3CliCod[0] < A3CliCod ) || ( T00169_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00169_A61ParmCod[0], A61ParmCod) < 0 ) ) )
         {
            A3CliCod = T00169_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A61ParmCod = T00169_A61ParmCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
            RcdFound39 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1639( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtParmCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1639( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound39 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A61ParmCod, Z61ParmCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A61ParmCod = Z61ParmCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtParmCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1639( ) ;
               GX_FocusControl = edtParmCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A61ParmCod, Z61ParmCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtParmCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1639( ) ;
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
                  GX_FocusControl = edtParmCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1639( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A61ParmCod, Z61ParmCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A61ParmCod = Z61ParmCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtParmCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1639( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00162 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Param"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z315ParmDescri, T00162_A315ParmDescri[0]) != 0 ) || ( GXutil.strcmp(Z887ParmTipo, T00162_A887ParmTipo[0]) != 0 ) || ( GXutil.strcmp(Z1364ParmDatoTipo, T00162_A1364ParmDatoTipo[0]) != 0 ) || ( Z1996ParmRelSec != T00162_A1996ParmRelSec[0] ) || ( Z1997ParmRelSecCli != T00162_A1997ParmRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2019ParmRelRef, T00162_A2019ParmRelRef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z315ParmDescri, T00162_A315ParmDescri[0]) != 0 )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmDescri");
               GXutil.writeLogRaw("Old: ",Z315ParmDescri);
               GXutil.writeLogRaw("Current: ",T00162_A315ParmDescri[0]);
            }
            if ( GXutil.strcmp(Z887ParmTipo, T00162_A887ParmTipo[0]) != 0 )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmTipo");
               GXutil.writeLogRaw("Old: ",Z887ParmTipo);
               GXutil.writeLogRaw("Current: ",T00162_A887ParmTipo[0]);
            }
            if ( GXutil.strcmp(Z1364ParmDatoTipo, T00162_A1364ParmDatoTipo[0]) != 0 )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmDatoTipo");
               GXutil.writeLogRaw("Old: ",Z1364ParmDatoTipo);
               GXutil.writeLogRaw("Current: ",T00162_A1364ParmDatoTipo[0]);
            }
            if ( Z1996ParmRelSec != T00162_A1996ParmRelSec[0] )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmRelSec");
               GXutil.writeLogRaw("Old: ",Z1996ParmRelSec);
               GXutil.writeLogRaw("Current: ",T00162_A1996ParmRelSec[0]);
            }
            if ( Z1997ParmRelSecCli != T00162_A1997ParmRelSecCli[0] )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1997ParmRelSecCli);
               GXutil.writeLogRaw("Current: ",T00162_A1997ParmRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z2019ParmRelRef, T00162_A2019ParmRelRef[0]) != 0 )
            {
               GXutil.writeLogln("param:[seudo value changed for attri]"+"ParmRelRef");
               GXutil.writeLogRaw("Old: ",Z2019ParmRelRef);
               GXutil.writeLogRaw("Current: ",T00162_A2019ParmRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Param"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1639( )
   {
      beforeValidate1639( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1639( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1639( 0) ;
         checkOptimisticConcurrency1639( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1639( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1639( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001610 */
                  pr_default.execute(8, new Object[] {A61ParmCod, A316ParmValue, A315ParmDescri, A887ParmTipo, A1364ParmDatoTipo, Integer.valueOf(A1996ParmRelSec), Integer.valueOf(A1997ParmRelSecCli), A2019ParmRelRef, A2031ParmOld, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
                  if ( (pr_default.getStatus(8) == 1) )
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
                        resetCaption160( ) ;
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
            load1639( ) ;
         }
         endLevel1639( ) ;
      }
      closeExtendedTableCursors1639( ) ;
   }

   public void update1639( )
   {
      beforeValidate1639( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1639( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1639( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1639( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1639( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001611 */
                  pr_default.execute(9, new Object[] {A316ParmValue, A315ParmDescri, A887ParmTipo, A1364ParmDatoTipo, Integer.valueOf(A1996ParmRelSec), Integer.valueOf(A1997ParmRelSecCli), A2019ParmRelRef, A2031ParmOld, Integer.valueOf(A3CliCod), A61ParmCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Param"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1639( ) ;
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
         endLevel1639( ) ;
      }
      closeExtendedTableCursors1639( ) ;
   }

   public void deferredUpdate1639( )
   {
   }

   public void delete( )
   {
      beforeValidate1639( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1639( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1639( ) ;
         afterConfirm1639( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1639( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001612 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
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
      sMode39 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1639( ) ;
      Gx_mode = sMode39 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1639( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV15aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1996ParmRelSec, GXv_boolean3) ;
            param_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
         }
         AV16Pgmname = "Param" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) )
         {
            divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean2 = false ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
            param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) )
            {
               divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel1639( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1639( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "param");
         if ( AnyError == 0 )
         {
            confirmValues160( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "param");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1639( )
   {
      /* Scan By routine */
      /* Using cursor T001613 */
      pr_default.execute(11);
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A3CliCod = T001613_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A61ParmCod = T001613_A61ParmCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1639( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A3CliCod = T001613_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A61ParmCod = T001613_A61ParmCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
      }
   }

   public void scanEnd1639( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1639( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV15aplicadoHay ) && ! (0==A1996ParmRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV11CliCod), "ParmRelSec", 1, "PARMRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynParmRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert1639( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1639( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1639( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1639( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1639( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1639( )
   {
      edtParmCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtParmCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmCod_Enabled), 5, 0), true);
      edtParmDescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtParmDescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmDescri_Enabled), 5, 0), true);
      edtParmValue_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtParmValue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtParmValue_Enabled), 5, 0), true);
      dynParmRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynParmRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynParmRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1639( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues160( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.param", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7ParmCod))}, new String[] {"Gx_mode","CliCod","ParmCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Param");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ParmTipo", GXutil.rtrim( localUtil.format( A887ParmTipo, "")));
      forbiddenHiddens.add("ParmDatoTipo", GXutil.rtrim( localUtil.format( A1364ParmDatoTipo, "")));
      forbiddenHiddens.add("ParmRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1997ParmRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("ParmRelRef", GXutil.rtrim( localUtil.format( A2019ParmRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("param:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z61ParmCod", GXutil.rtrim( Z61ParmCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z315ParmDescri", Z315ParmDescri);
      web.GxWebStd.gx_hidden_field( httpContext, "Z887ParmTipo", GXutil.rtrim( Z887ParmTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1364ParmDatoTipo", GXutil.rtrim( Z1364ParmDatoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1996ParmRelSec", GXutil.ltrim( localUtil.ntoc( Z1996ParmRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1997ParmRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1997ParmRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2019ParmRelRef", Z2019ParmRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O316ParmValue", O316ParmValue);
      web.GxWebStd.gx_hidden_field( httpContext, "O315ParmDescri", O315ParmDescri);
      web.GxWebStd.gx_hidden_field( httpContext, "O61ParmCod", GXutil.rtrim( O61ParmCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPARMCOD", GXutil.rtrim( AV7ParmCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPARMCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ParmCod, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV15aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "PARMTIPO", GXutil.rtrim( A887ParmTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "PARMDATOTIPO", GXutil.rtrim( A1364ParmDatoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "PARMRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1997ParmRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PARMRELREF", A2019ParmRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "PARMOLD", A2031ParmOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
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
      return formatLink("web.param", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7ParmCod))}, new String[] {"Gx_mode","CliCod","ParmCod"})  ;
   }

   public String getPgmname( )
   {
      return "Param" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Valores Predeterminados y Otros Parámetros", "") ;
   }

   public void initializeNonKey1639( )
   {
      AV15aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      A316ParmValue = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
      A315ParmDescri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
      A887ParmTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A887ParmTipo", A887ParmTipo);
      A1364ParmDatoTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1364ParmDatoTipo", A1364ParmDatoTipo);
      A1996ParmRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1996ParmRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1996ParmRelSec), 6, 0));
      A1997ParmRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1997ParmRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1997ParmRelSecCli), 6, 0));
      A2019ParmRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2019ParmRelRef", A2019ParmRelRef);
      A2031ParmOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2031ParmOld", A2031ParmOld);
      O316ParmValue = A316ParmValue ;
      httpContext.ajax_rsp_assign_attri("", false, "A316ParmValue", A316ParmValue);
      O315ParmDescri = A315ParmDescri ;
      httpContext.ajax_rsp_assign_attri("", false, "A315ParmDescri", A315ParmDescri);
      Z315ParmDescri = "" ;
      Z887ParmTipo = "" ;
      Z1364ParmDatoTipo = "" ;
      Z1996ParmRelSec = 0 ;
      Z1997ParmRelSecCli = 0 ;
      Z2019ParmRelRef = "" ;
   }

   public void initAll1639( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A61ParmCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A61ParmCod", A61ParmCod);
      initializeNonKey1639( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020355672", true, true);
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
      httpContext.AddJavascriptSource("param.js", "?2024122020355672", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtParmCod_Internalname = "PARMCOD" ;
      edtParmDescri_Internalname = "PARMDESCRI" ;
      edtParmValue_Internalname = "PARMVALUE" ;
      dynParmRelSec.setInternalname( "PARMRELSEC" );
      divParmrelsec_cell_Internalname = "PARMRELSEC_CELL" ;
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
      Form.setCaption( httpContext.getMessage( "Valores Predeterminados y Otros Parámetros", "") );
      edtParmValue_Tooltiptext = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynParmRelSec.setJsonclick( "" );
      dynParmRelSec.setEnabled( 1 );
      dynParmRelSec.setVisible( 1 );
      divParmrelsec_cell_Class = "col-xs-12 col-sm-6" ;
      edtParmValue_Enabled = 1 ;
      edtParmDescri_Enabled = 1 ;
      edtParmCod_Jsonclick = "" ;
      edtParmCod_Enabled = 1 ;
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

   public void gxdlaparmrelsec1639( int AV11CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaparmrelsec_data1639( AV11CliCod) ;
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

   public void gxaparmrelsec_html1639( int AV11CliCod )
   {
      int gxdynajaxvalue;
      gxdlaparmrelsec_data1639( AV11CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynParmRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynParmRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaparmrelsec_data1639( int AV11CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T001614 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV11CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001614_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001614_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx1asaclicod1639( int AV11CliCod )
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
            param_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxasa19961639( int AV11CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynParmRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynParmRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynParmRelSec.getVisible(), 5, 0), true);
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

   public void xc_13_1639( String Gx_mode ,
                           int AV11CliCod ,
                           int A1996ParmRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1996ParmRelSec, GXv_boolean3) ;
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
      dynParmRelSec.setName( "PARMRELSEC" );
      dynParmRelSec.setWebtags( "" );
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
      A1996ParmRelSec = (int)(GXutil.lval( dynParmRelSec.getValue())) ;
      /* Using cursor T001615 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Parmvalue( )
   {
      A1996ParmRelSec = (int)(GXutil.lval( dynParmRelSec.getValue())) ;
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) )
      {
         divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         param_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) )
         {
            divParmrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
         }
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divParmrelsec_cell_Internalname, "Class", divParmrelsec_cell_Class, true);
   }

   public void valid_Parmrelsec( )
   {
      A1996ParmRelSec = (int)(GXutil.lval( dynParmRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A61ParmCod, O61ParmCod) != 0 ) || ( GXutil.strcmp(A315ParmDescri, O315ParmDescri) != 0 ) || ( GXutil.strcmp(A316ParmValue, O316ParmValue) != 0 ) ) ) && (0==A1996ParmRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PARMRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynParmRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1996ParmRelSec, GXv_boolean3) ;
         param_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         AV15aplicadoHay = this.AV15aplicadoHay ;
      }
      O316ParmValue = A316ParmValue ;
      O315ParmDescri = A315ParmDescri ;
      O61ParmCod = A61ParmCod ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ParmCod',fld:'vPARMCOD',pic:'',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ParmCod',fld:'vPARMCOD',pic:'',hsh:true},{av:'A887ParmTipo',fld:'PARMTIPO',pic:''},{av:'A1364ParmDatoTipo',fld:'PARMDATOTIPO',pic:''},{av:'A1997ParmRelSecCli',fld:'PARMRELSECCLI',pic:'ZZZZZ9'},{av:'A2019ParmRelRef',fld:'PARMRELREF',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12162',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7ParmCod',fld:'vPARMCOD',pic:'',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_PARMCOD","{handler:'valid_Parmcod',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_PARMCOD",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_PARMDESCRI","{handler:'valid_Parmdescri',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_PARMDESCRI",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_PARMVALUE","{handler:'valid_Parmvalue',iparms:[{av:'O316ParmValue'},{av:'O315ParmDescri'},{av:'O61ParmCod'},{av:'A61ParmCod',fld:'PARMCOD',pic:''},{av:'A315ParmDescri',fld:'PARMDESCRI',pic:''},{av:'A316ParmValue',fld:'PARMVALUE',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_PARMVALUE",",oparms:[{av:'divParmrelsec_cell_Class',ctrl:'PARMRELSEC_CELL',prop:'Class'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_PARMRELSEC","{handler:'valid_Parmrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O316ParmValue'},{av:'O315ParmDescri'},{av:'O61ParmCod'},{av:'A61ParmCod',fld:'PARMCOD',pic:''},{av:'A315ParmDescri',fld:'PARMDESCRI',pic:''},{av:'A316ParmValue',fld:'PARMVALUE',pic:''},{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_PARMRELSEC",",oparms:[{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynParmRelSec'},{av:'A1996ParmRelSec',fld:'PARMRELSEC',pic:'ZZZZZ9'}]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7ParmCod = "" ;
      Z61ParmCod = "" ;
      Z315ParmDescri = "" ;
      Z887ParmTipo = "" ;
      Z1364ParmDatoTipo = "" ;
      Z2019ParmRelRef = "" ;
      O316ParmValue = "" ;
      O315ParmDescri = "" ;
      O61ParmCod = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7ParmCod = "" ;
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
      A61ParmCod = "" ;
      A315ParmDescri = "" ;
      A316ParmValue = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A887ParmTipo = "" ;
      A1364ParmDatoTipo = "" ;
      A2019ParmRelRef = "" ;
      A2031ParmOld = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode39 = "" ;
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
      Z316ParmValue = "" ;
      Z2031ParmOld = "" ;
      T00165_A61ParmCod = new String[] {""} ;
      T00165_A316ParmValue = new String[] {""} ;
      T00165_A315ParmDescri = new String[] {""} ;
      T00165_A887ParmTipo = new String[] {""} ;
      T00165_A1364ParmDatoTipo = new String[] {""} ;
      T00165_A1996ParmRelSec = new int[1] ;
      T00165_A1997ParmRelSecCli = new int[1] ;
      T00165_A2019ParmRelRef = new String[] {""} ;
      T00165_A2031ParmOld = new String[] {""} ;
      T00165_A3CliCod = new int[1] ;
      T00164_A3CliCod = new int[1] ;
      T00166_A3CliCod = new int[1] ;
      T00167_A3CliCod = new int[1] ;
      T00167_A61ParmCod = new String[] {""} ;
      T00163_A61ParmCod = new String[] {""} ;
      T00163_A316ParmValue = new String[] {""} ;
      T00163_A315ParmDescri = new String[] {""} ;
      T00163_A887ParmTipo = new String[] {""} ;
      T00163_A1364ParmDatoTipo = new String[] {""} ;
      T00163_A1996ParmRelSec = new int[1] ;
      T00163_A1997ParmRelSecCli = new int[1] ;
      T00163_A2019ParmRelRef = new String[] {""} ;
      T00163_A2031ParmOld = new String[] {""} ;
      T00163_A3CliCod = new int[1] ;
      T00168_A3CliCod = new int[1] ;
      T00168_A61ParmCod = new String[] {""} ;
      T00169_A3CliCod = new int[1] ;
      T00169_A61ParmCod = new String[] {""} ;
      T00162_A61ParmCod = new String[] {""} ;
      T00162_A316ParmValue = new String[] {""} ;
      T00162_A315ParmDescri = new String[] {""} ;
      T00162_A887ParmTipo = new String[] {""} ;
      T00162_A1364ParmDatoTipo = new String[] {""} ;
      T00162_A1996ParmRelSec = new int[1] ;
      T00162_A1997ParmRelSecCli = new int[1] ;
      T00162_A2019ParmRelRef = new String[] {""} ;
      T00162_A2031ParmOld = new String[] {""} ;
      T00162_A3CliCod = new int[1] ;
      T001613_A3CliCod = new int[1] ;
      T001613_A61ParmCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T001614_A3CliCod = new int[1] ;
      T001614_A1885CliRelSec = new int[1] ;
      T001614_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T001615_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.param__default(),
         new Object[] {
             new Object[] {
            T00162_A61ParmCod, T00162_A316ParmValue, T00162_A315ParmDescri, T00162_A887ParmTipo, T00162_A1364ParmDatoTipo, T00162_A1996ParmRelSec, T00162_A1997ParmRelSecCli, T00162_A2019ParmRelRef, T00162_A2031ParmOld, T00162_A3CliCod
            }
            , new Object[] {
            T00163_A61ParmCod, T00163_A316ParmValue, T00163_A315ParmDescri, T00163_A887ParmTipo, T00163_A1364ParmDatoTipo, T00163_A1996ParmRelSec, T00163_A1997ParmRelSecCli, T00163_A2019ParmRelRef, T00163_A2031ParmOld, T00163_A3CliCod
            }
            , new Object[] {
            T00164_A3CliCod
            }
            , new Object[] {
            T00165_A61ParmCod, T00165_A316ParmValue, T00165_A315ParmDescri, T00165_A887ParmTipo, T00165_A1364ParmDatoTipo, T00165_A1996ParmRelSec, T00165_A1997ParmRelSecCli, T00165_A2019ParmRelRef, T00165_A2031ParmOld, T00165_A3CliCod
            }
            , new Object[] {
            T00166_A3CliCod
            }
            , new Object[] {
            T00167_A3CliCod, T00167_A61ParmCod
            }
            , new Object[] {
            T00168_A3CliCod, T00168_A61ParmCod
            }
            , new Object[] {
            T00169_A3CliCod, T00169_A61ParmCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001613_A3CliCod, T001613_A61ParmCod
            }
            , new Object[] {
            T001614_A3CliCod, T001614_A1885CliRelSec, T001614_A1880CliReDTChar
            }
            , new Object[] {
            T001615_A3CliCod
            }
         }
      );
      AV16Pgmname = "Param" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound39 ;
   private short nIsDirty_39 ;
   private int wcpOAV11CliCod ;
   private int Z3CliCod ;
   private int Z1996ParmRelSec ;
   private int Z1997ParmRelSecCli ;
   private int AV11CliCod ;
   private int A1996ParmRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtParmCod_Enabled ;
   private int edtParmDescri_Enabled ;
   private int edtParmValue_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1997ParmRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7ParmCod ;
   private String Z61ParmCod ;
   private String Z887ParmTipo ;
   private String Z1364ParmDatoTipo ;
   private String O61ParmCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7ParmCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtParmCod_Internalname ;
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
   private String A61ParmCod ;
   private String edtParmCod_Jsonclick ;
   private String edtParmDescri_Internalname ;
   private String edtParmValue_Internalname ;
   private String divParmrelsec_cell_Internalname ;
   private String divParmrelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A887ParmTipo ;
   private String A1364ParmDatoTipo ;
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode39 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String edtParmValue_Tooltiptext ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV15aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean ZV15aplicadoHay ;
   private String O316ParmValue ;
   private String A316ParmValue ;
   private String A2031ParmOld ;
   private String Z316ParmValue ;
   private String Z2031ParmOld ;
   private String Z315ParmDescri ;
   private String Z2019ParmRelRef ;
   private String O315ParmDescri ;
   private String A315ParmDescri ;
   private String A2019ParmRelRef ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynParmRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T00165_A61ParmCod ;
   private String[] T00165_A316ParmValue ;
   private String[] T00165_A315ParmDescri ;
   private String[] T00165_A887ParmTipo ;
   private String[] T00165_A1364ParmDatoTipo ;
   private int[] T00165_A1996ParmRelSec ;
   private int[] T00165_A1997ParmRelSecCli ;
   private String[] T00165_A2019ParmRelRef ;
   private String[] T00165_A2031ParmOld ;
   private int[] T00165_A3CliCod ;
   private int[] T00164_A3CliCod ;
   private int[] T00166_A3CliCod ;
   private int[] T00167_A3CliCod ;
   private String[] T00167_A61ParmCod ;
   private String[] T00163_A61ParmCod ;
   private String[] T00163_A316ParmValue ;
   private String[] T00163_A315ParmDescri ;
   private String[] T00163_A887ParmTipo ;
   private String[] T00163_A1364ParmDatoTipo ;
   private int[] T00163_A1996ParmRelSec ;
   private int[] T00163_A1997ParmRelSecCli ;
   private String[] T00163_A2019ParmRelRef ;
   private String[] T00163_A2031ParmOld ;
   private int[] T00163_A3CliCod ;
   private int[] T00168_A3CliCod ;
   private String[] T00168_A61ParmCod ;
   private int[] T00169_A3CliCod ;
   private String[] T00169_A61ParmCod ;
   private String[] T00162_A61ParmCod ;
   private String[] T00162_A316ParmValue ;
   private String[] T00162_A315ParmDescri ;
   private String[] T00162_A887ParmTipo ;
   private String[] T00162_A1364ParmDatoTipo ;
   private int[] T00162_A1996ParmRelSec ;
   private int[] T00162_A1997ParmRelSecCli ;
   private String[] T00162_A2019ParmRelRef ;
   private String[] T00162_A2031ParmOld ;
   private int[] T00162_A3CliCod ;
   private int[] T001613_A3CliCod ;
   private String[] T001613_A61ParmCod ;
   private int[] T001614_A3CliCod ;
   private int[] T001614_A1885CliRelSec ;
   private String[] T001614_A1880CliReDTChar ;
   private int[] T001615_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class param__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00162", "SELECT ParmCod, ParmValue, ParmDescri, ParmTipo, ParmDatoTipo, ParmRelSec, ParmRelSecCli, ParmRelRef, ParmOld, CliCod FROM Param WHERE CliCod = ? AND ParmCod = ?  FOR UPDATE OF Param NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00163", "SELECT ParmCod, ParmValue, ParmDescri, ParmTipo, ParmDatoTipo, ParmRelSec, ParmRelSecCli, ParmRelRef, ParmOld, CliCod FROM Param WHERE CliCod = ? AND ParmCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00164", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00165", "SELECT TM1.ParmCod, TM1.ParmValue, TM1.ParmDescri, TM1.ParmTipo, TM1.ParmDatoTipo, TM1.ParmRelSec, TM1.ParmRelSecCli, TM1.ParmRelRef, TM1.ParmOld, TM1.CliCod FROM Param TM1 WHERE TM1.CliCod = ? and TM1.ParmCod = ( ?) ORDER BY TM1.CliCod, TM1.ParmCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00166", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00167", "SELECT CliCod, ParmCod FROM Param WHERE CliCod = ? AND ParmCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00168", "SELECT CliCod, ParmCod FROM Param WHERE ( CliCod > ? or CliCod = ? and ParmCod > ( ?)) ORDER BY CliCod, ParmCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00169", "SELECT CliCod, ParmCod FROM Param WHERE ( CliCod < ? or CliCod = ? and ParmCod < ( ?)) ORDER BY CliCod DESC, ParmCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001610", "SAVEPOINT gxupdate;INSERT INTO Param(ParmCod, ParmValue, ParmDescri, ParmTipo, ParmDatoTipo, ParmRelSec, ParmRelSecCli, ParmRelRef, ParmOld, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001611", "SAVEPOINT gxupdate;UPDATE Param SET ParmValue=?, ParmDescri=?, ParmTipo=?, ParmDatoTipo=?, ParmRelSec=?, ParmRelSecCli=?, ParmRelRef=?, ParmOld=?  WHERE CliCod = ? AND ParmCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001612", "SAVEPOINT gxupdate;DELETE FROM Param  WHERE CliCod = ? AND ParmCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001613", "SELECT CliCod, ParmCod FROM Param ORDER BY CliCod, ParmCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001614", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001615", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 13 :
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
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 30);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 30);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 30);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 30);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

