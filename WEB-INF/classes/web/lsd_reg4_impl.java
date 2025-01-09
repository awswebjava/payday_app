package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg4_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod4Y232( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec) ;
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
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LSDSec), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LSDSec), "ZZZZZZZ9")));
            AV10LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSD2Sec), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LSD2Sec), "ZZZZZZZ9")));
            AV11LSD4Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD4Sec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD4Sec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LSD4Sec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg4", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public lsd_reg4_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg4_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg4_impl.class ));
   }

   public lsd_reg4_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CUIL_3_11_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CUIL_3_11_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CUIL_3_11_Internalname, GXutil.ltrim( localUtil.ntoc( A1675LSD4CUIL_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CUIL_3_11_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CUIL_3_11_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CUIL_3_11_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4Conyuge_14_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4Conyuge_14_1_Internalname, httpContext.getMessage( "Conyuge", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4Conyuge_14_1_Internalname, GXutil.rtrim( A1676LSD4Conyuge_14_1), GXutil.rtrim( localUtil.format( A1676LSD4Conyuge_14_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4Conyuge_14_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4Conyuge_14_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadHijos_15_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadHijos_15_2_Internalname, httpContext.getMessage( "Hijos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadHijos_15_2_Internalname, GXutil.ltrim( localUtil.ntoc( A1677LSD4CantidadHijos_15_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadHijos_15_2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadHijos_15_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadHijos_15_2_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaCCT_17_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaCCT_17_1_Internalname, httpContext.getMessage( "En convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaCCT_17_1_Internalname, GXutil.rtrim( A1678LSD4MarcaCCT_17_1), GXutil.rtrim( localUtil.format( A1678LSD4MarcaCCT_17_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaCCT_17_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaCCT_17_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaSCVO_18_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaSCVO_18_1_Internalname, httpContext.getMessage( "SCVO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaSCVO_18_1_Internalname, GXutil.rtrim( A1679LSD4MarcaSCVO_18_1), GXutil.rtrim( localUtil.format( A1679LSD4MarcaSCVO_18_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaSCVO_18_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaSCVO_18_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4MarcaReduccion_19_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4MarcaReduccion_19_1_Internalname, httpContext.getMessage( "Reducc.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4MarcaReduccion_19_1_Internalname, GXutil.rtrim( A1680LSD4MarcaReduccion_19_1), GXutil.rtrim( localUtil.format( A1680LSD4MarcaReduccion_19_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4MarcaReduccion_19_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4MarcaReduccion_19_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4TipoEmpresa_20_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4TipoEmpresa_20_1_Internalname, httpContext.getMessage( "Empl.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4TipoEmpresa_20_1_Internalname, GXutil.rtrim( A1681LSD4TipoEmpresa_20_1), GXutil.rtrim( localUtil.format( A1681LSD4TipoEmpresa_20_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4TipoEmpresa_20_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4TipoEmpresa_20_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4TipoOperacion_21_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4TipoOperacion_21_1_Internalname, httpContext.getMessage( "Tipo Ope.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4TipoOperacion_21_1_Internalname, GXutil.rtrim( A1682LSD4TipoOperacion_21_1), GXutil.rtrim( localUtil.format( A1682LSD4TipoOperacion_21_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4TipoOperacion_21_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4TipoOperacion_21_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoSituacion_22_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoSituacion_22_2_Internalname, httpContext.getMessage( "Situación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoSituacion_22_2_Internalname, GXutil.rtrim( A1683LSD4CodigoSituacion_22_2), GXutil.rtrim( localUtil.format( A1683LSD4CodigoSituacion_22_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoSituacion_22_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoSituacion_22_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoCondicion_24_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoCondicion_24_2_Internalname, httpContext.getMessage( "Condición", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoCondicion_24_2_Internalname, GXutil.rtrim( A1684LSD4CodigoCondicion_24_2), GXutil.rtrim( localUtil.format( A1684LSD4CodigoCondicion_24_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoCondicion_24_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoCondicion_24_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoActividad_26_3_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoActividad_26_3_Internalname, httpContext.getMessage( "Actividad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoActividad_26_3_Internalname, GXutil.rtrim( A1685LSD4CodigoActividad_26_3), GXutil.rtrim( localUtil.format( A1685LSD4CodigoActividad_26_3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoActividad_26_3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoActividad_26_3_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoModalidadContratacio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoModalidadContratacio_Internalname, httpContext.getMessage( "Modalidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoModalidadContratacio_Internalname, GXutil.rtrim( A1686LSD4CodigoModalidadContratacio), GXutil.rtrim( localUtil.format( A1686LSD4CodigoModalidadContratacio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoModalidadContratacio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoModalidadContratacio_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoSiniestrado_32_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoSiniestrado_32_2_Internalname, httpContext.getMessage( "Siniestrado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoSiniestrado_32_2_Internalname, GXutil.rtrim( A1687LSD4CodigoSiniestrado_32_2), GXutil.rtrim( localUtil.format( A1687LSD4CodigoSiniestrado_32_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoSiniestrado_32_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoSiniestrado_32_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoLocalidad_34_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoLocalidad_34_2_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoLocalidad_34_2_Internalname, GXutil.rtrim( A1688LSD4CodigoLocalidad_34_2), GXutil.rtrim( localUtil.format( A1688LSD4CodigoLocalidad_34_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoLocalidad_34_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoLocalidad_34_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista1_36_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista1_36_2_Internalname, httpContext.getMessage( "Sit. 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista1_36_2_Internalname, GXutil.rtrim( A1689LSD4SituacionRevista1_36_2), GXutil.rtrim( localUtil.format( A1689LSD4SituacionRevista1_36_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista1_36_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista1_36_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista1_Internalname, httpContext.getMessage( "Sit. 1 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista1_Internalname, GXutil.rtrim( A1690LSD4DiaInicioSituacionRevista1), GXutil.rtrim( localUtil.format( A1690LSD4DiaInicioSituacionRevista1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista1_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista2_40_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista2_40_2_Internalname, httpContext.getMessage( "Sit. 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista2_40_2_Internalname, GXutil.rtrim( A1691LSD4SituacionRevista2_40_2), GXutil.rtrim( localUtil.format( A1691LSD4SituacionRevista2_40_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista2_40_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista2_40_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista2_Internalname, httpContext.getMessage( "Sit. 2 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista2_Internalname, GXutil.rtrim( A1692LSD4DiaInicioSituacionRevista2), GXutil.rtrim( localUtil.format( A1692LSD4DiaInicioSituacionRevista2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4SituacionRevista3_44_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4SituacionRevista3_44_2_Internalname, httpContext.getMessage( "Sit. 3", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4SituacionRevista3_44_2_Internalname, GXutil.rtrim( A1693LSD4SituacionRevista3_44_2), GXutil.rtrim( localUtil.format( A1693LSD4SituacionRevista3_44_2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4SituacionRevista3_44_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4SituacionRevista3_44_2_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4DiaInicioSituacionRevista3_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4DiaInicioSituacionRevista3_Internalname, httpContext.getMessage( "Sit. 3 ini.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4DiaInicioSituacionRevista3_Internalname, GXutil.rtrim( A1694LSD4DiaInicioSituacionRevista3), GXutil.rtrim( localUtil.format( A1694LSD4DiaInicioSituacionRevista3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4DiaInicioSituacionRevista3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4DiaInicioSituacionRevista3_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadDiasTrabajados_48__Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadDiasTrabajados_48__Internalname, httpContext.getMessage( "Días trab.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadDiasTrabajados_48__Internalname, GXutil.ltrim( localUtil.ntoc( A1695LSD4CantidadDiasTrabajados_48_, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadDiasTrabajados_48__Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,122);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadDiasTrabajados_48__Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadDiasTrabajados_48__Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4HorasTrabajadas_50_3_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4HorasTrabajadas_50_3_Internalname, httpContext.getMessage( "Horas trab.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4HorasTrabajadas_50_3_Internalname, GXutil.ltrim( localUtil.ntoc( A1696LSD4HorasTrabajadas_50_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4HorasTrabajadas_50_3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,127);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4HorasTrabajadas_50_3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4HorasTrabajadas_50_3_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4PorcentajeAporteAdicionalS_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4PorcentajeAporteAdicionalS_Internalname, httpContext.getMessage( "Porc. adic. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4PorcentajeAporteAdicionalS_Internalname, GXutil.ltrim( localUtil.ntoc( A1697LSD4PorcentajeAporteAdicionalS, (byte)(8), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4PorcentajeAporteAdicionalS_Enabled!=0) ? localUtil.format( A1697LSD4PorcentajeAporteAdicionalS, "ZZZZ9.99") : localUtil.format( A1697LSD4PorcentajeAporteAdicionalS, "ZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,132);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4PorcentajeAporteAdicionalS_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4PorcentajeAporteAdicionalS_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ContribucionTareaDiferenci_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4ContribucionTareaDiferenci_Internalname, httpContext.getMessage( "Contr. tarea dif.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ContribucionTareaDiferenci_Internalname, GXutil.ltrim( localUtil.ntoc( A1698LSD4ContribucionTareaDiferenci, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ContribucionTareaDiferenci_Enabled!=0) ? localUtil.format( A1698LSD4ContribucionTareaDiferenci, "ZZ9.99") : localUtil.format( A1698LSD4ContribucionTareaDiferenci, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,137);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ContribucionTareaDiferenci_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ContribucionTareaDiferenci_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CodigoObraSocial_63_6_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CodigoObraSocial_63_6_Internalname, httpContext.getMessage( "Obra social", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CodigoObraSocial_63_6_Internalname, GXutil.rtrim( A1699LSD4CodigoObraSocial_63_6), GXutil.rtrim( localUtil.format( A1699LSD4CodigoObraSocial_63_6, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,142);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CodigoObraSocial_63_6_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CodigoObraSocial_63_6_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4CantidadAdherentes_69_2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4CantidadAdherentes_69_2_Internalname, httpContext.getMessage( "Adherentes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4CantidadAdherentes_69_2_Internalname, GXutil.ltrim( localUtil.ntoc( A1700LSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4CantidadAdherentes_69_2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,147);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4CantidadAdherentes_69_2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4CantidadAdherentes_69_2_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4AporteAdicionalOS_71_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4AporteAdicionalOS_71_15_Internalname, httpContext.getMessage( "Apo. adic. OS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 152,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4AporteAdicionalOS_71_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1701LSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4AporteAdicionalOS_71_15_Enabled!=0) ? localUtil.format( A1701LSD4AporteAdicionalOS_71_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1701LSD4AporteAdicionalOS_71_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,152);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4AporteAdicionalOS_71_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4AporteAdicionalOS_71_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ContribucionAdicionalOS_86_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4ContribucionAdicionalOS_86_Internalname, httpContext.getMessage( "Contr. adic. OS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ContribucionAdicionalOS_86_Internalname, GXutil.ltrim( localUtil.ntoc( A1702LSD4ContribucionAdicionalOS_86, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ContribucionAdicionalOS_86_Enabled!=0) ? localUtil.format( A1702LSD4ContribucionAdicionalOS_86, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1702LSD4ContribucionAdicionalOS_86, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,157);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ContribucionAdicionalOS_86_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ContribucionAdicionalOS_86_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialApor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialApor_Internalname, httpContext.getMessage( "Base calc. dif. apo. OS y FSR", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 162,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialApor_Internalname, GXutil.ltrim( localUtil.ntoc( A1703LSD4BaseCalculoDiferencialApor, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialApor_Enabled!=0) ? localUtil.format( A1703LSD4BaseCalculoDiferencialApor, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1703LSD4BaseCalculoDiferencialApor, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,162);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialApor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialApor_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialOSyF_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialOSyF_Internalname, httpContext.getMessage( "Base calc. Dif. OS y FSR", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 167,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialOSyF_Internalname, GXutil.ltrim( localUtil.ntoc( A1704LSD4BaseCalculoDiferencialOSyF, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialOSyF_Enabled!=0) ? localUtil.format( A1704LSD4BaseCalculoDiferencialOSyF, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1704LSD4BaseCalculoDiferencialOSyF, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,167);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialOSyF_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialOSyF_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseCalculoDiferencialLRT__Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseCalculoDiferencialLRT__Internalname, httpContext.getMessage( "dif. LRT", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 172,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseCalculoDiferencialLRT__Internalname, GXutil.ltrim( localUtil.ntoc( A1705LSD4BaseCalculoDiferencialLRT_, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseCalculoDiferencialLRT__Enabled!=0) ? localUtil.format( A1705LSD4BaseCalculoDiferencialLRT_, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1705LSD4BaseCalculoDiferencialLRT_, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,172);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseCalculoDiferencialLRT__Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseCalculoDiferencialLRT__Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4RemuneracionMaternidadANSe_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4RemuneracionMaternidadANSe_Internalname, httpContext.getMessage( "Maternidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4RemuneracionMaternidadANSe_Internalname, GXutil.ltrim( localUtil.ntoc( A1706LSD4RemuneracionMaternidadANSe, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4RemuneracionMaternidadANSe_Enabled!=0) ? localUtil.format( A1706LSD4RemuneracionMaternidadANSe, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1706LSD4RemuneracionMaternidadANSe, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,177);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4RemuneracionMaternidadANSe_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4RemuneracionMaternidadANSe_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4RemuneracionBruta_161_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4RemuneracionBruta_161_15_Internalname, httpContext.getMessage( "Bruto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 182,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4RemuneracionBruta_161_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1707LSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4RemuneracionBruta_161_15_Enabled!=0) ? localUtil.format( A1707LSD4RemuneracionBruta_161_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1707LSD4RemuneracionBruta_161_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,182);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4RemuneracionBruta_161_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4RemuneracionBruta_161_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible1_176_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible1_176_15_Internalname, httpContext.getMessage( "Base imp. 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible1_176_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1708LSD4BaseImponible1_176_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible1_176_15_Enabled!=0) ? localUtil.format( A1708LSD4BaseImponible1_176_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1708LSD4BaseImponible1_176_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,187);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible1_176_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible1_176_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible2_191_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible2_191_15_Internalname, httpContext.getMessage( "Base imp. 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 192,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible2_191_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1709LSD4BaseImponible2_191_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible2_191_15_Enabled!=0) ? localUtil.format( A1709LSD4BaseImponible2_191_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1709LSD4BaseImponible2_191_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,192);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible2_191_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible2_191_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible3_206_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible3_206_15_Internalname, httpContext.getMessage( "Base imp. 3", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 197,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible3_206_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1710LSD4BaseImponible3_206_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible3_206_15_Enabled!=0) ? localUtil.format( A1710LSD4BaseImponible3_206_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1710LSD4BaseImponible3_206_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,197);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible3_206_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible3_206_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible4_221_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible4_221_15_Internalname, httpContext.getMessage( "Base imp. 4", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 202,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible4_221_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1711LSD4BaseImponible4_221_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible4_221_15_Enabled!=0) ? localUtil.format( A1711LSD4BaseImponible4_221_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1711LSD4BaseImponible4_221_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,202);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible4_221_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible4_221_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible5_236_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible5_236_15_Internalname, httpContext.getMessage( "Base imp. 5", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 207,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible5_236_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1712LSD4BaseImponible5_236_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible5_236_15_Enabled!=0) ? localUtil.format( A1712LSD4BaseImponible5_236_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1712LSD4BaseImponible5_236_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,207);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible5_236_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible5_236_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible6_251_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible6_251_15_Internalname, httpContext.getMessage( "Base imp. 6", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 212,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible6_251_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1713LSD4BaseImponible6_251_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible6_251_15_Enabled!=0) ? localUtil.format( A1713LSD4BaseImponible6_251_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1713LSD4BaseImponible6_251_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,212);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible6_251_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible6_251_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible7_266_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible7_266_15_Internalname, httpContext.getMessage( "Base imp. 7", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 217,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible7_266_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1714LSD4BaseImponible7_266_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible7_266_15_Enabled!=0) ? localUtil.format( A1714LSD4BaseImponible7_266_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1714LSD4BaseImponible7_266_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,217);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible7_266_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible7_266_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible8_281_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible8_281_15_Internalname, httpContext.getMessage( "Base imp. 8", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 222,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible8_281_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1715LSD4BaseImponible8_281_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible8_281_15_Enabled!=0) ? localUtil.format( A1715LSD4BaseImponible8_281_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1715LSD4BaseImponible8_281_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,222);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible8_281_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible8_281_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible9_296_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible9_296_15_Internalname, httpContext.getMessage( "Base imp. 9", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible9_296_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1716LSD4BaseImponible9_296_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible9_296_15_Enabled!=0) ? localUtil.format( A1716LSD4BaseImponible9_296_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1716LSD4BaseImponible9_296_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,227);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible9_296_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible9_296_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseDifApoSegSoc_311_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseDifApoSegSoc_311_15_Internalname, httpContext.getMessage( "Base dif. apo. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 232,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseDifApoSegSoc_311_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1717LSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseDifApoSegSoc_311_15_Enabled!=0) ? localUtil.format( A1717LSD4BaseDifApoSegSoc_311_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1717LSD4BaseDifApoSegSoc_311_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,232);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseDifApoSegSoc_311_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseDifApoSegSoc_311_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseDifContSegSoc_326_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseDifContSegSoc_326_15_Internalname, httpContext.getMessage( "Base dif. cont. SS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseDifContSegSoc_326_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1718LSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseDifContSegSoc_326_15_Enabled!=0) ? localUtil.format( A1718LSD4BaseDifContSegSoc_326_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1718LSD4BaseDifContSegSoc_326_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,237);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseDifContSegSoc_326_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseDifContSegSoc_326_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4BaseImponible10_341_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4BaseImponible10_341_15_Internalname, httpContext.getMessage( "Base imp. 10", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4BaseImponible10_341_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1719LSD4BaseImponible10_341_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4BaseImponible10_341_15_Enabled!=0) ? localUtil.format( A1719LSD4BaseImponible10_341_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1719LSD4BaseImponible10_341_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4BaseImponible10_341_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4BaseImponible10_341_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD4ImporteADetraer_356_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD4ImporteADetraer_356_15_Internalname, httpContext.getMessage( "Importe a detraer", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 247,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4ImporteADetraer_356_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1720LSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD4ImporteADetraer_356_15_Enabled!=0) ? localUtil.format( A1720LSD4ImporteADetraer_356_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1720LSD4ImporteADetraer_356_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,247);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4ImporteADetraer_356_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD4ImporteADetraer_356_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 255,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 257,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg4.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 259,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg4.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 263,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,263);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 264,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,264);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LSD_reg4.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 265,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,265);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSDSec_Visible, edtLSDSec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 266,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,266);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD2Sec_Visible, edtLSD2Sec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 267,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD4Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1674LSD4Sec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,267);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD4Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD4Sec_Visible, edtLSD4Sec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg4.htm");
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
      e114Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1649LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1657LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1674LSD4Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1675LSD4CUIL_3_11 = localUtil.ctol( httpContext.cgiGet( "Z1675LSD4CUIL_3_11"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1676LSD4Conyuge_14_1 = httpContext.cgiGet( "Z1676LSD4Conyuge_14_1") ;
            Z1677LSD4CantidadHijos_15_2 = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1677LSD4CantidadHijos_15_2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1678LSD4MarcaCCT_17_1 = httpContext.cgiGet( "Z1678LSD4MarcaCCT_17_1") ;
            Z1679LSD4MarcaSCVO_18_1 = httpContext.cgiGet( "Z1679LSD4MarcaSCVO_18_1") ;
            Z1680LSD4MarcaReduccion_19_1 = httpContext.cgiGet( "Z1680LSD4MarcaReduccion_19_1") ;
            Z1681LSD4TipoEmpresa_20_1 = httpContext.cgiGet( "Z1681LSD4TipoEmpresa_20_1") ;
            Z1682LSD4TipoOperacion_21_1 = httpContext.cgiGet( "Z1682LSD4TipoOperacion_21_1") ;
            Z1683LSD4CodigoSituacion_22_2 = httpContext.cgiGet( "Z1683LSD4CodigoSituacion_22_2") ;
            Z1684LSD4CodigoCondicion_24_2 = httpContext.cgiGet( "Z1684LSD4CodigoCondicion_24_2") ;
            Z1685LSD4CodigoActividad_26_3 = httpContext.cgiGet( "Z1685LSD4CodigoActividad_26_3") ;
            Z1686LSD4CodigoModalidadContratacio = httpContext.cgiGet( "Z1686LSD4CodigoModalidadContratacio") ;
            Z1687LSD4CodigoSiniestrado_32_2 = httpContext.cgiGet( "Z1687LSD4CodigoSiniestrado_32_2") ;
            Z1688LSD4CodigoLocalidad_34_2 = httpContext.cgiGet( "Z1688LSD4CodigoLocalidad_34_2") ;
            Z1689LSD4SituacionRevista1_36_2 = httpContext.cgiGet( "Z1689LSD4SituacionRevista1_36_2") ;
            Z1690LSD4DiaInicioSituacionRevista1 = httpContext.cgiGet( "Z1690LSD4DiaInicioSituacionRevista1") ;
            Z1691LSD4SituacionRevista2_40_2 = httpContext.cgiGet( "Z1691LSD4SituacionRevista2_40_2") ;
            Z1692LSD4DiaInicioSituacionRevista2 = httpContext.cgiGet( "Z1692LSD4DiaInicioSituacionRevista2") ;
            Z1693LSD4SituacionRevista3_44_2 = httpContext.cgiGet( "Z1693LSD4SituacionRevista3_44_2") ;
            Z1694LSD4DiaInicioSituacionRevista3 = httpContext.cgiGet( "Z1694LSD4DiaInicioSituacionRevista3") ;
            Z1695LSD4CantidadDiasTrabajados_48_ = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1695LSD4CantidadDiasTrabajados_48_"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1696LSD4HorasTrabajadas_50_3 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1696LSD4HorasTrabajadas_50_3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1697LSD4PorcentajeAporteAdicionalS = localUtil.ctond( httpContext.cgiGet( "Z1697LSD4PorcentajeAporteAdicionalS")) ;
            Z1698LSD4ContribucionTareaDiferenci = localUtil.ctond( httpContext.cgiGet( "Z1698LSD4ContribucionTareaDiferenci")) ;
            Z1699LSD4CodigoObraSocial_63_6 = httpContext.cgiGet( "Z1699LSD4CodigoObraSocial_63_6") ;
            Z1700LSD4CantidadAdherentes_69_2 = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1700LSD4CantidadAdherentes_69_2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1701LSD4AporteAdicionalOS_71_15 = localUtil.ctond( httpContext.cgiGet( "Z1701LSD4AporteAdicionalOS_71_15")) ;
            Z1702LSD4ContribucionAdicionalOS_86 = localUtil.ctond( httpContext.cgiGet( "Z1702LSD4ContribucionAdicionalOS_86")) ;
            Z1703LSD4BaseCalculoDiferencialApor = localUtil.ctond( httpContext.cgiGet( "Z1703LSD4BaseCalculoDiferencialApor")) ;
            Z1704LSD4BaseCalculoDiferencialOSyF = localUtil.ctond( httpContext.cgiGet( "Z1704LSD4BaseCalculoDiferencialOSyF")) ;
            Z1705LSD4BaseCalculoDiferencialLRT_ = localUtil.ctond( httpContext.cgiGet( "Z1705LSD4BaseCalculoDiferencialLRT_")) ;
            Z1706LSD4RemuneracionMaternidadANSe = localUtil.ctond( httpContext.cgiGet( "Z1706LSD4RemuneracionMaternidadANSe")) ;
            Z1707LSD4RemuneracionBruta_161_15 = localUtil.ctond( httpContext.cgiGet( "Z1707LSD4RemuneracionBruta_161_15")) ;
            Z1708LSD4BaseImponible1_176_15 = localUtil.ctond( httpContext.cgiGet( "Z1708LSD4BaseImponible1_176_15")) ;
            Z1709LSD4BaseImponible2_191_15 = localUtil.ctond( httpContext.cgiGet( "Z1709LSD4BaseImponible2_191_15")) ;
            Z1710LSD4BaseImponible3_206_15 = localUtil.ctond( httpContext.cgiGet( "Z1710LSD4BaseImponible3_206_15")) ;
            Z1711LSD4BaseImponible4_221_15 = localUtil.ctond( httpContext.cgiGet( "Z1711LSD4BaseImponible4_221_15")) ;
            Z1712LSD4BaseImponible5_236_15 = localUtil.ctond( httpContext.cgiGet( "Z1712LSD4BaseImponible5_236_15")) ;
            Z1713LSD4BaseImponible6_251_15 = localUtil.ctond( httpContext.cgiGet( "Z1713LSD4BaseImponible6_251_15")) ;
            Z1714LSD4BaseImponible7_266_15 = localUtil.ctond( httpContext.cgiGet( "Z1714LSD4BaseImponible7_266_15")) ;
            Z1715LSD4BaseImponible8_281_15 = localUtil.ctond( httpContext.cgiGet( "Z1715LSD4BaseImponible8_281_15")) ;
            Z1716LSD4BaseImponible9_296_15 = localUtil.ctond( httpContext.cgiGet( "Z1716LSD4BaseImponible9_296_15")) ;
            Z1717LSD4BaseDifApoSegSoc_311_15 = localUtil.ctond( httpContext.cgiGet( "Z1717LSD4BaseDifApoSegSoc_311_15")) ;
            Z1718LSD4BaseDifContSegSoc_326_15 = localUtil.ctond( httpContext.cgiGet( "Z1718LSD4BaseDifContSegSoc_326_15")) ;
            Z1719LSD4BaseImponible10_341_15 = localUtil.ctond( httpContext.cgiGet( "Z1719LSD4BaseImponible10_341_15")) ;
            Z1720LSD4ImporteADetraer_356_15 = localUtil.ctond( httpContext.cgiGet( "Z1720LSD4ImporteADetraer_356_15")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSDSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSD2SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( "vLSD4SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CUIL_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CUIL_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CUIL_3_11");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1675LSD4CUIL_3_11 = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
            }
            else
            {
               A1675LSD4CUIL_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD4CUIL_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
            }
            A1676LSD4Conyuge_14_1 = httpContext.cgiGet( edtLSD4Conyuge_14_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadHijos_15_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadHijos_15_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CANTIDADHIJOS_15_2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4CantidadHijos_15_2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1677LSD4CantidadHijos_15_2 = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
            }
            else
            {
               A1677LSD4CantidadHijos_15_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadHijos_15_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
            }
            A1678LSD4MarcaCCT_17_1 = httpContext.cgiGet( edtLSD4MarcaCCT_17_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
            A1679LSD4MarcaSCVO_18_1 = httpContext.cgiGet( edtLSD4MarcaSCVO_18_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
            A1680LSD4MarcaReduccion_19_1 = httpContext.cgiGet( edtLSD4MarcaReduccion_19_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
            A1681LSD4TipoEmpresa_20_1 = httpContext.cgiGet( edtLSD4TipoEmpresa_20_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
            A1682LSD4TipoOperacion_21_1 = httpContext.cgiGet( edtLSD4TipoOperacion_21_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
            A1683LSD4CodigoSituacion_22_2 = httpContext.cgiGet( edtLSD4CodigoSituacion_22_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
            A1684LSD4CodigoCondicion_24_2 = httpContext.cgiGet( edtLSD4CodigoCondicion_24_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
            A1685LSD4CodigoActividad_26_3 = httpContext.cgiGet( edtLSD4CodigoActividad_26_3_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
            A1686LSD4CodigoModalidadContratacio = httpContext.cgiGet( edtLSD4CodigoModalidadContratacio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
            A1687LSD4CodigoSiniestrado_32_2 = httpContext.cgiGet( edtLSD4CodigoSiniestrado_32_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
            A1688LSD4CodigoLocalidad_34_2 = httpContext.cgiGet( edtLSD4CodigoLocalidad_34_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
            A1689LSD4SituacionRevista1_36_2 = httpContext.cgiGet( edtLSD4SituacionRevista1_36_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
            A1690LSD4DiaInicioSituacionRevista1 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
            A1691LSD4SituacionRevista2_40_2 = httpContext.cgiGet( edtLSD4SituacionRevista2_40_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
            A1692LSD4DiaInicioSituacionRevista2 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
            A1693LSD4SituacionRevista3_44_2 = httpContext.cgiGet( edtLSD4SituacionRevista3_44_2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
            A1694LSD4DiaInicioSituacionRevista3 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista3_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadDiasTrabajados_48__Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadDiasTrabajados_48__Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CANTIDADDIASTRABAJADOS_48_");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4CantidadDiasTrabajados_48__Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1695LSD4CantidadDiasTrabajados_48_ = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
            }
            else
            {
               A1695LSD4CantidadDiasTrabajados_48_ = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadDiasTrabajados_48__Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4HorasTrabajadas_50_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4HorasTrabajadas_50_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4HORASTRABAJADAS_50_3");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4HorasTrabajadas_50_3_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1696LSD4HorasTrabajadas_50_3 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
            }
            else
            {
               A1696LSD4HorasTrabajadas_50_3 = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD4HorasTrabajadas_50_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4PorcentajeAporteAdicionalS_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4PorcentajeAporteAdicionalS_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4PORCENTAJEAPORTEADICIONALS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4PorcentajeAporteAdicionalS_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
            }
            else
            {
               A1697LSD4PorcentajeAporteAdicionalS = localUtil.ctond( httpContext.cgiGet( edtLSD4PorcentajeAporteAdicionalS_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionTareaDiferenci_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionTareaDiferenci_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CONTRIBUCIONTAREADIFERENCI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4ContribucionTareaDiferenci_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
            }
            else
            {
               A1698LSD4ContribucionTareaDiferenci = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionTareaDiferenci_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
            }
            A1699LSD4CodigoObraSocial_63_6 = httpContext.cgiGet( edtLSD4CodigoObraSocial_63_6_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadAdherentes_69_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadAdherentes_69_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CANTIDADADHERENTES_69_2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4CantidadAdherentes_69_2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1700LSD4CantidadAdherentes_69_2 = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
            }
            else
            {
               A1700LSD4CantidadAdherentes_69_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadAdherentes_69_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4AporteAdicionalOS_71_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4AporteAdicionalOS_71_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4APORTEADICIONALOS_71_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4AporteAdicionalOS_71_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
            }
            else
            {
               A1701LSD4AporteAdicionalOS_71_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4AporteAdicionalOS_71_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionAdicionalOS_86_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionAdicionalOS_86_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4CONTRIBUCIONADICIONALOS_86");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4ContribucionAdicionalOS_86_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
            }
            else
            {
               A1702LSD4ContribucionAdicionalOS_86 = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionAdicionalOS_86_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialApor_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialApor_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASECALCULODIFERENCIALAPOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseCalculoDiferencialApor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
            }
            else
            {
               A1703LSD4BaseCalculoDiferencialApor = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialApor_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialOSyF_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialOSyF_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASECALCULODIFERENCIALOSYF");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseCalculoDiferencialOSyF_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
            }
            else
            {
               A1704LSD4BaseCalculoDiferencialOSyF = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialOSyF_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialLRT__Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialLRT__Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASECALCULODIFERENCIALLRT_");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseCalculoDiferencialLRT__Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
            }
            else
            {
               A1705LSD4BaseCalculoDiferencialLRT_ = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialLRT__Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionMaternidadANSe_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionMaternidadANSe_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4REMUNERACIONMATERNIDADANSE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4RemuneracionMaternidadANSe_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
            }
            else
            {
               A1706LSD4RemuneracionMaternidadANSe = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionMaternidadANSe_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionBruta_161_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionBruta_161_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4REMUNERACIONBRUTA_161_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4RemuneracionBruta_161_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
            }
            else
            {
               A1707LSD4RemuneracionBruta_161_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionBruta_161_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible1_176_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible1_176_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE1_176_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible1_176_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
            }
            else
            {
               A1708LSD4BaseImponible1_176_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible1_176_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible2_191_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible2_191_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE2_191_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible2_191_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
            }
            else
            {
               A1709LSD4BaseImponible2_191_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible2_191_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible3_206_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible3_206_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE3_206_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible3_206_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
            }
            else
            {
               A1710LSD4BaseImponible3_206_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible3_206_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible4_221_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible4_221_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE4_221_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible4_221_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
            }
            else
            {
               A1711LSD4BaseImponible4_221_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible4_221_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible5_236_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible5_236_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE5_236_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible5_236_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
            }
            else
            {
               A1712LSD4BaseImponible5_236_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible5_236_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible6_251_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible6_251_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE6_251_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible6_251_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
            }
            else
            {
               A1713LSD4BaseImponible6_251_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible6_251_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible7_266_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible7_266_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE7_266_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible7_266_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
            }
            else
            {
               A1714LSD4BaseImponible7_266_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible7_266_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible8_281_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible8_281_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE8_281_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible8_281_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
            }
            else
            {
               A1715LSD4BaseImponible8_281_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible8_281_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible9_296_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible9_296_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE9_296_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible9_296_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
            }
            else
            {
               A1716LSD4BaseImponible9_296_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible9_296_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifApoSegSoc_311_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifApoSegSoc_311_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEDIFAPOSEGSOC_311_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseDifApoSegSoc_311_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
            }
            else
            {
               A1717LSD4BaseDifApoSegSoc_311_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifApoSegSoc_311_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifContSegSoc_326_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifContSegSoc_326_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEDIFCONTSEGSOC_326_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseDifContSegSoc_326_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
            }
            else
            {
               A1718LSD4BaseDifContSegSoc_326_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifContSegSoc_326_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible10_341_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible10_341_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4BASEIMPONIBLE10_341_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4BaseImponible10_341_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
            }
            else
            {
               A1719LSD4BaseImponible10_341_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible10_341_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD4ImporteADetraer_356_15_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD4ImporteADetraer_356_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4IMPORTEADETRAER_356_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4ImporteADetraer_356_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
            }
            else
            {
               A1720LSD4ImporteADetraer_356_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4ImporteADetraer_356_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
            }
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSDSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSDSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1649LSDSec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            }
            else
            {
               A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD2SEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2Sec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1657LSD2Sec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            }
            else
            {
               A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD4Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD4SEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD4Sec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1674LSD4Sec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
            }
            else
            {
               A1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD4Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg4");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1674LSD4Sec != Z1674LSD4Sec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("lsd_reg4:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               A1674LSD4Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD4Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
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
                  sMode232 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode232 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound232 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4Y0( ) ;
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
                        e114Y2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124Y2 ();
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
         e124Y2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4Y232( ) ;
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
         disableAttributes4Y232( ) ;
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

   public void confirm_4Y0( )
   {
      beforeValidate4Y232( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4Y232( ) ;
         }
         else
         {
            checkExtendedTable4Y232( ) ;
            closeExtendedTableCursors4Y232( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4Y0( )
   {
   }

   public void e114Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Insert", GXv_boolean3) ;
         lsd_reg4_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Update", GXv_boolean3) ;
         lsd_reg4_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Delete", GXv_boolean3) ;
         lsd_reg4_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLSDSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Visible), 5, 0), true);
      edtLSD2Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Visible), 5, 0), true);
      edtLSD4Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Visible), 5, 0), true);
   }

   public void e124Y2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm4Y232( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1675LSD4CUIL_3_11 = T004Y3_A1675LSD4CUIL_3_11[0] ;
            Z1676LSD4Conyuge_14_1 = T004Y3_A1676LSD4Conyuge_14_1[0] ;
            Z1677LSD4CantidadHijos_15_2 = T004Y3_A1677LSD4CantidadHijos_15_2[0] ;
            Z1678LSD4MarcaCCT_17_1 = T004Y3_A1678LSD4MarcaCCT_17_1[0] ;
            Z1679LSD4MarcaSCVO_18_1 = T004Y3_A1679LSD4MarcaSCVO_18_1[0] ;
            Z1680LSD4MarcaReduccion_19_1 = T004Y3_A1680LSD4MarcaReduccion_19_1[0] ;
            Z1681LSD4TipoEmpresa_20_1 = T004Y3_A1681LSD4TipoEmpresa_20_1[0] ;
            Z1682LSD4TipoOperacion_21_1 = T004Y3_A1682LSD4TipoOperacion_21_1[0] ;
            Z1683LSD4CodigoSituacion_22_2 = T004Y3_A1683LSD4CodigoSituacion_22_2[0] ;
            Z1684LSD4CodigoCondicion_24_2 = T004Y3_A1684LSD4CodigoCondicion_24_2[0] ;
            Z1685LSD4CodigoActividad_26_3 = T004Y3_A1685LSD4CodigoActividad_26_3[0] ;
            Z1686LSD4CodigoModalidadContratacio = T004Y3_A1686LSD4CodigoModalidadContratacio[0] ;
            Z1687LSD4CodigoSiniestrado_32_2 = T004Y3_A1687LSD4CodigoSiniestrado_32_2[0] ;
            Z1688LSD4CodigoLocalidad_34_2 = T004Y3_A1688LSD4CodigoLocalidad_34_2[0] ;
            Z1689LSD4SituacionRevista1_36_2 = T004Y3_A1689LSD4SituacionRevista1_36_2[0] ;
            Z1690LSD4DiaInicioSituacionRevista1 = T004Y3_A1690LSD4DiaInicioSituacionRevista1[0] ;
            Z1691LSD4SituacionRevista2_40_2 = T004Y3_A1691LSD4SituacionRevista2_40_2[0] ;
            Z1692LSD4DiaInicioSituacionRevista2 = T004Y3_A1692LSD4DiaInicioSituacionRevista2[0] ;
            Z1693LSD4SituacionRevista3_44_2 = T004Y3_A1693LSD4SituacionRevista3_44_2[0] ;
            Z1694LSD4DiaInicioSituacionRevista3 = T004Y3_A1694LSD4DiaInicioSituacionRevista3[0] ;
            Z1695LSD4CantidadDiasTrabajados_48_ = T004Y3_A1695LSD4CantidadDiasTrabajados_48_[0] ;
            Z1696LSD4HorasTrabajadas_50_3 = T004Y3_A1696LSD4HorasTrabajadas_50_3[0] ;
            Z1697LSD4PorcentajeAporteAdicionalS = T004Y3_A1697LSD4PorcentajeAporteAdicionalS[0] ;
            Z1698LSD4ContribucionTareaDiferenci = T004Y3_A1698LSD4ContribucionTareaDiferenci[0] ;
            Z1699LSD4CodigoObraSocial_63_6 = T004Y3_A1699LSD4CodigoObraSocial_63_6[0] ;
            Z1700LSD4CantidadAdherentes_69_2 = T004Y3_A1700LSD4CantidadAdherentes_69_2[0] ;
            Z1701LSD4AporteAdicionalOS_71_15 = T004Y3_A1701LSD4AporteAdicionalOS_71_15[0] ;
            Z1702LSD4ContribucionAdicionalOS_86 = T004Y3_A1702LSD4ContribucionAdicionalOS_86[0] ;
            Z1703LSD4BaseCalculoDiferencialApor = T004Y3_A1703LSD4BaseCalculoDiferencialApor[0] ;
            Z1704LSD4BaseCalculoDiferencialOSyF = T004Y3_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
            Z1705LSD4BaseCalculoDiferencialLRT_ = T004Y3_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
            Z1706LSD4RemuneracionMaternidadANSe = T004Y3_A1706LSD4RemuneracionMaternidadANSe[0] ;
            Z1707LSD4RemuneracionBruta_161_15 = T004Y3_A1707LSD4RemuneracionBruta_161_15[0] ;
            Z1708LSD4BaseImponible1_176_15 = T004Y3_A1708LSD4BaseImponible1_176_15[0] ;
            Z1709LSD4BaseImponible2_191_15 = T004Y3_A1709LSD4BaseImponible2_191_15[0] ;
            Z1710LSD4BaseImponible3_206_15 = T004Y3_A1710LSD4BaseImponible3_206_15[0] ;
            Z1711LSD4BaseImponible4_221_15 = T004Y3_A1711LSD4BaseImponible4_221_15[0] ;
            Z1712LSD4BaseImponible5_236_15 = T004Y3_A1712LSD4BaseImponible5_236_15[0] ;
            Z1713LSD4BaseImponible6_251_15 = T004Y3_A1713LSD4BaseImponible6_251_15[0] ;
            Z1714LSD4BaseImponible7_266_15 = T004Y3_A1714LSD4BaseImponible7_266_15[0] ;
            Z1715LSD4BaseImponible8_281_15 = T004Y3_A1715LSD4BaseImponible8_281_15[0] ;
            Z1716LSD4BaseImponible9_296_15 = T004Y3_A1716LSD4BaseImponible9_296_15[0] ;
            Z1717LSD4BaseDifApoSegSoc_311_15 = T004Y3_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
            Z1718LSD4BaseDifContSegSoc_326_15 = T004Y3_A1718LSD4BaseDifContSegSoc_326_15[0] ;
            Z1719LSD4BaseImponible10_341_15 = T004Y3_A1719LSD4BaseImponible10_341_15[0] ;
            Z1720LSD4ImporteADetraer_356_15 = T004Y3_A1720LSD4ImporteADetraer_356_15[0] ;
         }
         else
         {
            Z1675LSD4CUIL_3_11 = A1675LSD4CUIL_3_11 ;
            Z1676LSD4Conyuge_14_1 = A1676LSD4Conyuge_14_1 ;
            Z1677LSD4CantidadHijos_15_2 = A1677LSD4CantidadHijos_15_2 ;
            Z1678LSD4MarcaCCT_17_1 = A1678LSD4MarcaCCT_17_1 ;
            Z1679LSD4MarcaSCVO_18_1 = A1679LSD4MarcaSCVO_18_1 ;
            Z1680LSD4MarcaReduccion_19_1 = A1680LSD4MarcaReduccion_19_1 ;
            Z1681LSD4TipoEmpresa_20_1 = A1681LSD4TipoEmpresa_20_1 ;
            Z1682LSD4TipoOperacion_21_1 = A1682LSD4TipoOperacion_21_1 ;
            Z1683LSD4CodigoSituacion_22_2 = A1683LSD4CodigoSituacion_22_2 ;
            Z1684LSD4CodigoCondicion_24_2 = A1684LSD4CodigoCondicion_24_2 ;
            Z1685LSD4CodigoActividad_26_3 = A1685LSD4CodigoActividad_26_3 ;
            Z1686LSD4CodigoModalidadContratacio = A1686LSD4CodigoModalidadContratacio ;
            Z1687LSD4CodigoSiniestrado_32_2 = A1687LSD4CodigoSiniestrado_32_2 ;
            Z1688LSD4CodigoLocalidad_34_2 = A1688LSD4CodigoLocalidad_34_2 ;
            Z1689LSD4SituacionRevista1_36_2 = A1689LSD4SituacionRevista1_36_2 ;
            Z1690LSD4DiaInicioSituacionRevista1 = A1690LSD4DiaInicioSituacionRevista1 ;
            Z1691LSD4SituacionRevista2_40_2 = A1691LSD4SituacionRevista2_40_2 ;
            Z1692LSD4DiaInicioSituacionRevista2 = A1692LSD4DiaInicioSituacionRevista2 ;
            Z1693LSD4SituacionRevista3_44_2 = A1693LSD4SituacionRevista3_44_2 ;
            Z1694LSD4DiaInicioSituacionRevista3 = A1694LSD4DiaInicioSituacionRevista3 ;
            Z1695LSD4CantidadDiasTrabajados_48_ = A1695LSD4CantidadDiasTrabajados_48_ ;
            Z1696LSD4HorasTrabajadas_50_3 = A1696LSD4HorasTrabajadas_50_3 ;
            Z1697LSD4PorcentajeAporteAdicionalS = A1697LSD4PorcentajeAporteAdicionalS ;
            Z1698LSD4ContribucionTareaDiferenci = A1698LSD4ContribucionTareaDiferenci ;
            Z1699LSD4CodigoObraSocial_63_6 = A1699LSD4CodigoObraSocial_63_6 ;
            Z1700LSD4CantidadAdherentes_69_2 = A1700LSD4CantidadAdherentes_69_2 ;
            Z1701LSD4AporteAdicionalOS_71_15 = A1701LSD4AporteAdicionalOS_71_15 ;
            Z1702LSD4ContribucionAdicionalOS_86 = A1702LSD4ContribucionAdicionalOS_86 ;
            Z1703LSD4BaseCalculoDiferencialApor = A1703LSD4BaseCalculoDiferencialApor ;
            Z1704LSD4BaseCalculoDiferencialOSyF = A1704LSD4BaseCalculoDiferencialOSyF ;
            Z1705LSD4BaseCalculoDiferencialLRT_ = A1705LSD4BaseCalculoDiferencialLRT_ ;
            Z1706LSD4RemuneracionMaternidadANSe = A1706LSD4RemuneracionMaternidadANSe ;
            Z1707LSD4RemuneracionBruta_161_15 = A1707LSD4RemuneracionBruta_161_15 ;
            Z1708LSD4BaseImponible1_176_15 = A1708LSD4BaseImponible1_176_15 ;
            Z1709LSD4BaseImponible2_191_15 = A1709LSD4BaseImponible2_191_15 ;
            Z1710LSD4BaseImponible3_206_15 = A1710LSD4BaseImponible3_206_15 ;
            Z1711LSD4BaseImponible4_221_15 = A1711LSD4BaseImponible4_221_15 ;
            Z1712LSD4BaseImponible5_236_15 = A1712LSD4BaseImponible5_236_15 ;
            Z1713LSD4BaseImponible6_251_15 = A1713LSD4BaseImponible6_251_15 ;
            Z1714LSD4BaseImponible7_266_15 = A1714LSD4BaseImponible7_266_15 ;
            Z1715LSD4BaseImponible8_281_15 = A1715LSD4BaseImponible8_281_15 ;
            Z1716LSD4BaseImponible9_296_15 = A1716LSD4BaseImponible9_296_15 ;
            Z1717LSD4BaseDifApoSegSoc_311_15 = A1717LSD4BaseDifApoSegSoc_311_15 ;
            Z1718LSD4BaseDifContSegSoc_326_15 = A1718LSD4BaseDifContSegSoc_326_15 ;
            Z1719LSD4BaseImponible10_341_15 = A1719LSD4BaseImponible10_341_15 ;
            Z1720LSD4ImporteADetraer_356_15 = A1720LSD4ImporteADetraer_356_15 ;
         }
      }
      if ( GX_JID == -16 )
      {
         Z1674LSD4Sec = A1674LSD4Sec ;
         Z1675LSD4CUIL_3_11 = A1675LSD4CUIL_3_11 ;
         Z1676LSD4Conyuge_14_1 = A1676LSD4Conyuge_14_1 ;
         Z1677LSD4CantidadHijos_15_2 = A1677LSD4CantidadHijos_15_2 ;
         Z1678LSD4MarcaCCT_17_1 = A1678LSD4MarcaCCT_17_1 ;
         Z1679LSD4MarcaSCVO_18_1 = A1679LSD4MarcaSCVO_18_1 ;
         Z1680LSD4MarcaReduccion_19_1 = A1680LSD4MarcaReduccion_19_1 ;
         Z1681LSD4TipoEmpresa_20_1 = A1681LSD4TipoEmpresa_20_1 ;
         Z1682LSD4TipoOperacion_21_1 = A1682LSD4TipoOperacion_21_1 ;
         Z1683LSD4CodigoSituacion_22_2 = A1683LSD4CodigoSituacion_22_2 ;
         Z1684LSD4CodigoCondicion_24_2 = A1684LSD4CodigoCondicion_24_2 ;
         Z1685LSD4CodigoActividad_26_3 = A1685LSD4CodigoActividad_26_3 ;
         Z1686LSD4CodigoModalidadContratacio = A1686LSD4CodigoModalidadContratacio ;
         Z1687LSD4CodigoSiniestrado_32_2 = A1687LSD4CodigoSiniestrado_32_2 ;
         Z1688LSD4CodigoLocalidad_34_2 = A1688LSD4CodigoLocalidad_34_2 ;
         Z1689LSD4SituacionRevista1_36_2 = A1689LSD4SituacionRevista1_36_2 ;
         Z1690LSD4DiaInicioSituacionRevista1 = A1690LSD4DiaInicioSituacionRevista1 ;
         Z1691LSD4SituacionRevista2_40_2 = A1691LSD4SituacionRevista2_40_2 ;
         Z1692LSD4DiaInicioSituacionRevista2 = A1692LSD4DiaInicioSituacionRevista2 ;
         Z1693LSD4SituacionRevista3_44_2 = A1693LSD4SituacionRevista3_44_2 ;
         Z1694LSD4DiaInicioSituacionRevista3 = A1694LSD4DiaInicioSituacionRevista3 ;
         Z1695LSD4CantidadDiasTrabajados_48_ = A1695LSD4CantidadDiasTrabajados_48_ ;
         Z1696LSD4HorasTrabajadas_50_3 = A1696LSD4HorasTrabajadas_50_3 ;
         Z1697LSD4PorcentajeAporteAdicionalS = A1697LSD4PorcentajeAporteAdicionalS ;
         Z1698LSD4ContribucionTareaDiferenci = A1698LSD4ContribucionTareaDiferenci ;
         Z1699LSD4CodigoObraSocial_63_6 = A1699LSD4CodigoObraSocial_63_6 ;
         Z1700LSD4CantidadAdherentes_69_2 = A1700LSD4CantidadAdherentes_69_2 ;
         Z1701LSD4AporteAdicionalOS_71_15 = A1701LSD4AporteAdicionalOS_71_15 ;
         Z1702LSD4ContribucionAdicionalOS_86 = A1702LSD4ContribucionAdicionalOS_86 ;
         Z1703LSD4BaseCalculoDiferencialApor = A1703LSD4BaseCalculoDiferencialApor ;
         Z1704LSD4BaseCalculoDiferencialOSyF = A1704LSD4BaseCalculoDiferencialOSyF ;
         Z1705LSD4BaseCalculoDiferencialLRT_ = A1705LSD4BaseCalculoDiferencialLRT_ ;
         Z1706LSD4RemuneracionMaternidadANSe = A1706LSD4RemuneracionMaternidadANSe ;
         Z1707LSD4RemuneracionBruta_161_15 = A1707LSD4RemuneracionBruta_161_15 ;
         Z1708LSD4BaseImponible1_176_15 = A1708LSD4BaseImponible1_176_15 ;
         Z1709LSD4BaseImponible2_191_15 = A1709LSD4BaseImponible2_191_15 ;
         Z1710LSD4BaseImponible3_206_15 = A1710LSD4BaseImponible3_206_15 ;
         Z1711LSD4BaseImponible4_221_15 = A1711LSD4BaseImponible4_221_15 ;
         Z1712LSD4BaseImponible5_236_15 = A1712LSD4BaseImponible5_236_15 ;
         Z1713LSD4BaseImponible6_251_15 = A1713LSD4BaseImponible6_251_15 ;
         Z1714LSD4BaseImponible7_266_15 = A1714LSD4BaseImponible7_266_15 ;
         Z1715LSD4BaseImponible8_281_15 = A1715LSD4BaseImponible8_281_15 ;
         Z1716LSD4BaseImponible9_296_15 = A1716LSD4BaseImponible9_296_15 ;
         Z1717LSD4BaseDifApoSegSoc_311_15 = A1717LSD4BaseDifApoSegSoc_311_15 ;
         Z1718LSD4BaseDifContSegSoc_326_15 = A1718LSD4BaseDifContSegSoc_326_15 ;
         Z1719LSD4BaseImponible10_341_15 = A1719LSD4BaseImponible10_341_15 ;
         Z1720LSD4ImporteADetraer_356_15 = A1720LSD4ImporteADetraer_356_15 ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
         Z1657LSD2Sec = A1657LSD2Sec ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            lsd_reg4_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LSDSec) )
      {
         A1649LSDSec = AV9LSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      }
      if ( ! (0==AV9LSDSec) )
      {
         edtLSDSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSDSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LSDSec) )
      {
         edtLSDSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         A1657LSD2Sec = AV10LSD2Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         edtLSD2Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSD2Sec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         edtLSD2Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LSD4Sec) )
      {
         A1674LSD4Sec = AV11LSD4Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      }
      if ( ! (0==AV11LSD4Sec) )
      {
         edtLSD4Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD4Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSD4Sec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD4Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LSD4Sec) )
      {
         edtLSD4Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD4Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Enabled), 5, 0), true);
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
         AV17Pgmname = "LSD_reg4" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void load4Y232( )
   {
      /* Using cursor T004Y5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound232 = (short)(1) ;
         A1675LSD4CUIL_3_11 = T004Y5_A1675LSD4CUIL_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
         A1676LSD4Conyuge_14_1 = T004Y5_A1676LSD4Conyuge_14_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
         A1677LSD4CantidadHijos_15_2 = T004Y5_A1677LSD4CantidadHijos_15_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
         A1678LSD4MarcaCCT_17_1 = T004Y5_A1678LSD4MarcaCCT_17_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
         A1679LSD4MarcaSCVO_18_1 = T004Y5_A1679LSD4MarcaSCVO_18_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
         A1680LSD4MarcaReduccion_19_1 = T004Y5_A1680LSD4MarcaReduccion_19_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
         A1681LSD4TipoEmpresa_20_1 = T004Y5_A1681LSD4TipoEmpresa_20_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
         A1682LSD4TipoOperacion_21_1 = T004Y5_A1682LSD4TipoOperacion_21_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
         A1683LSD4CodigoSituacion_22_2 = T004Y5_A1683LSD4CodigoSituacion_22_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
         A1684LSD4CodigoCondicion_24_2 = T004Y5_A1684LSD4CodigoCondicion_24_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
         A1685LSD4CodigoActividad_26_3 = T004Y5_A1685LSD4CodigoActividad_26_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
         A1686LSD4CodigoModalidadContratacio = T004Y5_A1686LSD4CodigoModalidadContratacio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
         A1687LSD4CodigoSiniestrado_32_2 = T004Y5_A1687LSD4CodigoSiniestrado_32_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
         A1688LSD4CodigoLocalidad_34_2 = T004Y5_A1688LSD4CodigoLocalidad_34_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
         A1689LSD4SituacionRevista1_36_2 = T004Y5_A1689LSD4SituacionRevista1_36_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
         A1690LSD4DiaInicioSituacionRevista1 = T004Y5_A1690LSD4DiaInicioSituacionRevista1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
         A1691LSD4SituacionRevista2_40_2 = T004Y5_A1691LSD4SituacionRevista2_40_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
         A1692LSD4DiaInicioSituacionRevista2 = T004Y5_A1692LSD4DiaInicioSituacionRevista2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
         A1693LSD4SituacionRevista3_44_2 = T004Y5_A1693LSD4SituacionRevista3_44_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
         A1694LSD4DiaInicioSituacionRevista3 = T004Y5_A1694LSD4DiaInicioSituacionRevista3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
         A1695LSD4CantidadDiasTrabajados_48_ = T004Y5_A1695LSD4CantidadDiasTrabajados_48_[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
         A1696LSD4HorasTrabajadas_50_3 = T004Y5_A1696LSD4HorasTrabajadas_50_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
         A1697LSD4PorcentajeAporteAdicionalS = T004Y5_A1697LSD4PorcentajeAporteAdicionalS[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
         A1698LSD4ContribucionTareaDiferenci = T004Y5_A1698LSD4ContribucionTareaDiferenci[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
         A1699LSD4CodigoObraSocial_63_6 = T004Y5_A1699LSD4CodigoObraSocial_63_6[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
         A1700LSD4CantidadAdherentes_69_2 = T004Y5_A1700LSD4CantidadAdherentes_69_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
         A1701LSD4AporteAdicionalOS_71_15 = T004Y5_A1701LSD4AporteAdicionalOS_71_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
         A1702LSD4ContribucionAdicionalOS_86 = T004Y5_A1702LSD4ContribucionAdicionalOS_86[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
         A1703LSD4BaseCalculoDiferencialApor = T004Y5_A1703LSD4BaseCalculoDiferencialApor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
         A1704LSD4BaseCalculoDiferencialOSyF = T004Y5_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
         A1705LSD4BaseCalculoDiferencialLRT_ = T004Y5_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
         A1706LSD4RemuneracionMaternidadANSe = T004Y5_A1706LSD4RemuneracionMaternidadANSe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
         A1707LSD4RemuneracionBruta_161_15 = T004Y5_A1707LSD4RemuneracionBruta_161_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
         A1708LSD4BaseImponible1_176_15 = T004Y5_A1708LSD4BaseImponible1_176_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
         A1709LSD4BaseImponible2_191_15 = T004Y5_A1709LSD4BaseImponible2_191_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
         A1710LSD4BaseImponible3_206_15 = T004Y5_A1710LSD4BaseImponible3_206_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
         A1711LSD4BaseImponible4_221_15 = T004Y5_A1711LSD4BaseImponible4_221_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
         A1712LSD4BaseImponible5_236_15 = T004Y5_A1712LSD4BaseImponible5_236_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
         A1713LSD4BaseImponible6_251_15 = T004Y5_A1713LSD4BaseImponible6_251_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
         A1714LSD4BaseImponible7_266_15 = T004Y5_A1714LSD4BaseImponible7_266_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
         A1715LSD4BaseImponible8_281_15 = T004Y5_A1715LSD4BaseImponible8_281_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
         A1716LSD4BaseImponible9_296_15 = T004Y5_A1716LSD4BaseImponible9_296_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
         A1717LSD4BaseDifApoSegSoc_311_15 = T004Y5_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
         A1718LSD4BaseDifContSegSoc_326_15 = T004Y5_A1718LSD4BaseDifContSegSoc_326_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
         A1719LSD4BaseImponible10_341_15 = T004Y5_A1719LSD4BaseImponible10_341_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
         A1720LSD4ImporteADetraer_356_15 = T004Y5_A1720LSD4ImporteADetraer_356_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
         zm4Y232( -16) ;
      }
      pr_default.close(3);
      onLoadActions4Y232( ) ;
   }

   public void onLoadActions4Y232( )
   {
      AV17Pgmname = "LSD_reg4" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
   }

   public void checkExtendedTable4Y232( )
   {
      nIsDirty_232 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV17Pgmname = "LSD_reg4" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      /* Using cursor T004Y4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors4Y232( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( int A3CliCod ,
                          short A1EmpCod ,
                          int A1649LSDSec ,
                          int A1657LSD2Sec )
   {
      /* Using cursor T004Y6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
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

   public void getKey4Y232( )
   {
      /* Using cursor T004Y7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound232 = (short)(1) ;
      }
      else
      {
         RcdFound232 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004Y3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4Y232( 16) ;
         RcdFound232 = (short)(1) ;
         A1674LSD4Sec = T004Y3_A1674LSD4Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
         A1675LSD4CUIL_3_11 = T004Y3_A1675LSD4CUIL_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
         A1676LSD4Conyuge_14_1 = T004Y3_A1676LSD4Conyuge_14_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
         A1677LSD4CantidadHijos_15_2 = T004Y3_A1677LSD4CantidadHijos_15_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
         A1678LSD4MarcaCCT_17_1 = T004Y3_A1678LSD4MarcaCCT_17_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
         A1679LSD4MarcaSCVO_18_1 = T004Y3_A1679LSD4MarcaSCVO_18_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
         A1680LSD4MarcaReduccion_19_1 = T004Y3_A1680LSD4MarcaReduccion_19_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
         A1681LSD4TipoEmpresa_20_1 = T004Y3_A1681LSD4TipoEmpresa_20_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
         A1682LSD4TipoOperacion_21_1 = T004Y3_A1682LSD4TipoOperacion_21_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
         A1683LSD4CodigoSituacion_22_2 = T004Y3_A1683LSD4CodigoSituacion_22_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
         A1684LSD4CodigoCondicion_24_2 = T004Y3_A1684LSD4CodigoCondicion_24_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
         A1685LSD4CodigoActividad_26_3 = T004Y3_A1685LSD4CodigoActividad_26_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
         A1686LSD4CodigoModalidadContratacio = T004Y3_A1686LSD4CodigoModalidadContratacio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
         A1687LSD4CodigoSiniestrado_32_2 = T004Y3_A1687LSD4CodigoSiniestrado_32_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
         A1688LSD4CodigoLocalidad_34_2 = T004Y3_A1688LSD4CodigoLocalidad_34_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
         A1689LSD4SituacionRevista1_36_2 = T004Y3_A1689LSD4SituacionRevista1_36_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
         A1690LSD4DiaInicioSituacionRevista1 = T004Y3_A1690LSD4DiaInicioSituacionRevista1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
         A1691LSD4SituacionRevista2_40_2 = T004Y3_A1691LSD4SituacionRevista2_40_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
         A1692LSD4DiaInicioSituacionRevista2 = T004Y3_A1692LSD4DiaInicioSituacionRevista2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
         A1693LSD4SituacionRevista3_44_2 = T004Y3_A1693LSD4SituacionRevista3_44_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
         A1694LSD4DiaInicioSituacionRevista3 = T004Y3_A1694LSD4DiaInicioSituacionRevista3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
         A1695LSD4CantidadDiasTrabajados_48_ = T004Y3_A1695LSD4CantidadDiasTrabajados_48_[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
         A1696LSD4HorasTrabajadas_50_3 = T004Y3_A1696LSD4HorasTrabajadas_50_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
         A1697LSD4PorcentajeAporteAdicionalS = T004Y3_A1697LSD4PorcentajeAporteAdicionalS[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
         A1698LSD4ContribucionTareaDiferenci = T004Y3_A1698LSD4ContribucionTareaDiferenci[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
         A1699LSD4CodigoObraSocial_63_6 = T004Y3_A1699LSD4CodigoObraSocial_63_6[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
         A1700LSD4CantidadAdherentes_69_2 = T004Y3_A1700LSD4CantidadAdherentes_69_2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
         A1701LSD4AporteAdicionalOS_71_15 = T004Y3_A1701LSD4AporteAdicionalOS_71_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
         A1702LSD4ContribucionAdicionalOS_86 = T004Y3_A1702LSD4ContribucionAdicionalOS_86[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
         A1703LSD4BaseCalculoDiferencialApor = T004Y3_A1703LSD4BaseCalculoDiferencialApor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
         A1704LSD4BaseCalculoDiferencialOSyF = T004Y3_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
         A1705LSD4BaseCalculoDiferencialLRT_ = T004Y3_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
         A1706LSD4RemuneracionMaternidadANSe = T004Y3_A1706LSD4RemuneracionMaternidadANSe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
         A1707LSD4RemuneracionBruta_161_15 = T004Y3_A1707LSD4RemuneracionBruta_161_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
         A1708LSD4BaseImponible1_176_15 = T004Y3_A1708LSD4BaseImponible1_176_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
         A1709LSD4BaseImponible2_191_15 = T004Y3_A1709LSD4BaseImponible2_191_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
         A1710LSD4BaseImponible3_206_15 = T004Y3_A1710LSD4BaseImponible3_206_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
         A1711LSD4BaseImponible4_221_15 = T004Y3_A1711LSD4BaseImponible4_221_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
         A1712LSD4BaseImponible5_236_15 = T004Y3_A1712LSD4BaseImponible5_236_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
         A1713LSD4BaseImponible6_251_15 = T004Y3_A1713LSD4BaseImponible6_251_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
         A1714LSD4BaseImponible7_266_15 = T004Y3_A1714LSD4BaseImponible7_266_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
         A1715LSD4BaseImponible8_281_15 = T004Y3_A1715LSD4BaseImponible8_281_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
         A1716LSD4BaseImponible9_296_15 = T004Y3_A1716LSD4BaseImponible9_296_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
         A1717LSD4BaseDifApoSegSoc_311_15 = T004Y3_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
         A1718LSD4BaseDifContSegSoc_326_15 = T004Y3_A1718LSD4BaseDifContSegSoc_326_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
         A1719LSD4BaseImponible10_341_15 = T004Y3_A1719LSD4BaseImponible10_341_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
         A1720LSD4ImporteADetraer_356_15 = T004Y3_A1720LSD4ImporteADetraer_356_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
         A3CliCod = T004Y3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004Y3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004Y3_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004Y3_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
         Z1657LSD2Sec = A1657LSD2Sec ;
         Z1674LSD4Sec = A1674LSD4Sec ;
         sMode232 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4Y232( ) ;
         if ( AnyError == 1 )
         {
            RcdFound232 = (short)(0) ;
            initializeNonKey4Y232( ) ;
         }
         Gx_mode = sMode232 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound232 = (short)(0) ;
         initializeNonKey4Y232( ) ;
         sMode232 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode232 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4Y232( ) ;
      if ( RcdFound232 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound232 = (short)(0) ;
      /* Using cursor T004Y8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1674LSD4Sec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004Y8_A3CliCod[0] < A3CliCod ) || ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1EmpCod[0] < A1EmpCod ) || ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1649LSDSec[0] < A1649LSDSec ) || ( T004Y8_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1657LSD2Sec[0] < A1657LSD2Sec ) || ( T004Y8_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004Y8_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1674LSD4Sec[0] < A1674LSD4Sec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004Y8_A3CliCod[0] > A3CliCod ) || ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1EmpCod[0] > A1EmpCod ) || ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1649LSDSec[0] > A1649LSDSec ) || ( T004Y8_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1657LSD2Sec[0] > A1657LSD2Sec ) || ( T004Y8_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004Y8_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y8_A1EmpCod[0] == A1EmpCod ) && ( T004Y8_A3CliCod[0] == A3CliCod ) && ( T004Y8_A1674LSD4Sec[0] > A1674LSD4Sec ) ) )
         {
            A3CliCod = T004Y8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004Y8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004Y8_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004Y8_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            A1674LSD4Sec = T004Y8_A1674LSD4Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
            RcdFound232 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound232 = (short)(0) ;
      /* Using cursor T004Y9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1674LSD4Sec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004Y9_A3CliCod[0] > A3CliCod ) || ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1EmpCod[0] > A1EmpCod ) || ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1649LSDSec[0] > A1649LSDSec ) || ( T004Y9_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1657LSD2Sec[0] > A1657LSD2Sec ) || ( T004Y9_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004Y9_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1674LSD4Sec[0] > A1674LSD4Sec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004Y9_A3CliCod[0] < A3CliCod ) || ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1EmpCod[0] < A1EmpCod ) || ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1649LSDSec[0] < A1649LSDSec ) || ( T004Y9_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1657LSD2Sec[0] < A1657LSD2Sec ) || ( T004Y9_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004Y9_A1649LSDSec[0] == A1649LSDSec ) && ( T004Y9_A1EmpCod[0] == A1EmpCod ) && ( T004Y9_A3CliCod[0] == A3CliCod ) && ( T004Y9_A1674LSD4Sec[0] < A1674LSD4Sec ) ) )
         {
            A3CliCod = T004Y9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004Y9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004Y9_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004Y9_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            A1674LSD4Sec = T004Y9_A1674LSD4Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
            RcdFound232 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4Y232( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4Y232( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound232 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1674LSD4Sec != Z1674LSD4Sec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1649LSDSec = Z1649LSDSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = Z1657LSD2Sec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               A1674LSD4Sec = Z1674LSD4Sec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4Y232( ) ;
               GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1674LSD4Sec != Z1674LSD4Sec ) )
            {
               /* Insert record */
               GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4Y232( ) ;
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
                  GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4Y232( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1674LSD4Sec != Z1674LSD4Sec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = Z1649LSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = Z1657LSD2Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1674LSD4Sec = Z1674LSD4Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLSD4CUIL_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4Y232( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004Y2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg4"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1675LSD4CUIL_3_11 != T004Y2_A1675LSD4CUIL_3_11[0] ) || ( GXutil.strcmp(Z1676LSD4Conyuge_14_1, T004Y2_A1676LSD4Conyuge_14_1[0]) != 0 ) || ( Z1677LSD4CantidadHijos_15_2 != T004Y2_A1677LSD4CantidadHijos_15_2[0] ) || ( GXutil.strcmp(Z1678LSD4MarcaCCT_17_1, T004Y2_A1678LSD4MarcaCCT_17_1[0]) != 0 ) || ( GXutil.strcmp(Z1679LSD4MarcaSCVO_18_1, T004Y2_A1679LSD4MarcaSCVO_18_1[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1680LSD4MarcaReduccion_19_1, T004Y2_A1680LSD4MarcaReduccion_19_1[0]) != 0 ) || ( GXutil.strcmp(Z1681LSD4TipoEmpresa_20_1, T004Y2_A1681LSD4TipoEmpresa_20_1[0]) != 0 ) || ( GXutil.strcmp(Z1682LSD4TipoOperacion_21_1, T004Y2_A1682LSD4TipoOperacion_21_1[0]) != 0 ) || ( GXutil.strcmp(Z1683LSD4CodigoSituacion_22_2, T004Y2_A1683LSD4CodigoSituacion_22_2[0]) != 0 ) || ( GXutil.strcmp(Z1684LSD4CodigoCondicion_24_2, T004Y2_A1684LSD4CodigoCondicion_24_2[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1685LSD4CodigoActividad_26_3, T004Y2_A1685LSD4CodigoActividad_26_3[0]) != 0 ) || ( GXutil.strcmp(Z1686LSD4CodigoModalidadContratacio, T004Y2_A1686LSD4CodigoModalidadContratacio[0]) != 0 ) || ( GXutil.strcmp(Z1687LSD4CodigoSiniestrado_32_2, T004Y2_A1687LSD4CodigoSiniestrado_32_2[0]) != 0 ) || ( GXutil.strcmp(Z1688LSD4CodigoLocalidad_34_2, T004Y2_A1688LSD4CodigoLocalidad_34_2[0]) != 0 ) || ( GXutil.strcmp(Z1689LSD4SituacionRevista1_36_2, T004Y2_A1689LSD4SituacionRevista1_36_2[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1690LSD4DiaInicioSituacionRevista1, T004Y2_A1690LSD4DiaInicioSituacionRevista1[0]) != 0 ) || ( GXutil.strcmp(Z1691LSD4SituacionRevista2_40_2, T004Y2_A1691LSD4SituacionRevista2_40_2[0]) != 0 ) || ( GXutil.strcmp(Z1692LSD4DiaInicioSituacionRevista2, T004Y2_A1692LSD4DiaInicioSituacionRevista2[0]) != 0 ) || ( GXutil.strcmp(Z1693LSD4SituacionRevista3_44_2, T004Y2_A1693LSD4SituacionRevista3_44_2[0]) != 0 ) || ( GXutil.strcmp(Z1694LSD4DiaInicioSituacionRevista3, T004Y2_A1694LSD4DiaInicioSituacionRevista3[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1695LSD4CantidadDiasTrabajados_48_ != T004Y2_A1695LSD4CantidadDiasTrabajados_48_[0] ) || ( Z1696LSD4HorasTrabajadas_50_3 != T004Y2_A1696LSD4HorasTrabajadas_50_3[0] ) || ( DecimalUtil.compareTo(Z1697LSD4PorcentajeAporteAdicionalS, T004Y2_A1697LSD4PorcentajeAporteAdicionalS[0]) != 0 ) || ( DecimalUtil.compareTo(Z1698LSD4ContribucionTareaDiferenci, T004Y2_A1698LSD4ContribucionTareaDiferenci[0]) != 0 ) || ( GXutil.strcmp(Z1699LSD4CodigoObraSocial_63_6, T004Y2_A1699LSD4CodigoObraSocial_63_6[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1700LSD4CantidadAdherentes_69_2 != T004Y2_A1700LSD4CantidadAdherentes_69_2[0] ) || ( DecimalUtil.compareTo(Z1701LSD4AporteAdicionalOS_71_15, T004Y2_A1701LSD4AporteAdicionalOS_71_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1702LSD4ContribucionAdicionalOS_86, T004Y2_A1702LSD4ContribucionAdicionalOS_86[0]) != 0 ) || ( DecimalUtil.compareTo(Z1703LSD4BaseCalculoDiferencialApor, T004Y2_A1703LSD4BaseCalculoDiferencialApor[0]) != 0 ) || ( DecimalUtil.compareTo(Z1704LSD4BaseCalculoDiferencialOSyF, T004Y2_A1704LSD4BaseCalculoDiferencialOSyF[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1705LSD4BaseCalculoDiferencialLRT_, T004Y2_A1705LSD4BaseCalculoDiferencialLRT_[0]) != 0 ) || ( DecimalUtil.compareTo(Z1706LSD4RemuneracionMaternidadANSe, T004Y2_A1706LSD4RemuneracionMaternidadANSe[0]) != 0 ) || ( DecimalUtil.compareTo(Z1707LSD4RemuneracionBruta_161_15, T004Y2_A1707LSD4RemuneracionBruta_161_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1708LSD4BaseImponible1_176_15, T004Y2_A1708LSD4BaseImponible1_176_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1709LSD4BaseImponible2_191_15, T004Y2_A1709LSD4BaseImponible2_191_15[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1710LSD4BaseImponible3_206_15, T004Y2_A1710LSD4BaseImponible3_206_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1711LSD4BaseImponible4_221_15, T004Y2_A1711LSD4BaseImponible4_221_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1712LSD4BaseImponible5_236_15, T004Y2_A1712LSD4BaseImponible5_236_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1713LSD4BaseImponible6_251_15, T004Y2_A1713LSD4BaseImponible6_251_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1714LSD4BaseImponible7_266_15, T004Y2_A1714LSD4BaseImponible7_266_15[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1715LSD4BaseImponible8_281_15, T004Y2_A1715LSD4BaseImponible8_281_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1716LSD4BaseImponible9_296_15, T004Y2_A1716LSD4BaseImponible9_296_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1717LSD4BaseDifApoSegSoc_311_15, T004Y2_A1717LSD4BaseDifApoSegSoc_311_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1718LSD4BaseDifContSegSoc_326_15, T004Y2_A1718LSD4BaseDifContSegSoc_326_15[0]) != 0 ) || ( DecimalUtil.compareTo(Z1719LSD4BaseImponible10_341_15, T004Y2_A1719LSD4BaseImponible10_341_15[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1720LSD4ImporteADetraer_356_15, T004Y2_A1720LSD4ImporteADetraer_356_15[0]) != 0 ) )
         {
            if ( Z1675LSD4CUIL_3_11 != T004Y2_A1675LSD4CUIL_3_11[0] )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CUIL_3_11");
               GXutil.writeLogRaw("Old: ",Z1675LSD4CUIL_3_11);
               GXutil.writeLogRaw("Current: ",T004Y2_A1675LSD4CUIL_3_11[0]);
            }
            if ( GXutil.strcmp(Z1676LSD4Conyuge_14_1, T004Y2_A1676LSD4Conyuge_14_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4Conyuge_14_1");
               GXutil.writeLogRaw("Old: ",Z1676LSD4Conyuge_14_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1676LSD4Conyuge_14_1[0]);
            }
            if ( Z1677LSD4CantidadHijos_15_2 != T004Y2_A1677LSD4CantidadHijos_15_2[0] )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CantidadHijos_15_2");
               GXutil.writeLogRaw("Old: ",Z1677LSD4CantidadHijos_15_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1677LSD4CantidadHijos_15_2[0]);
            }
            if ( GXutil.strcmp(Z1678LSD4MarcaCCT_17_1, T004Y2_A1678LSD4MarcaCCT_17_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4MarcaCCT_17_1");
               GXutil.writeLogRaw("Old: ",Z1678LSD4MarcaCCT_17_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1678LSD4MarcaCCT_17_1[0]);
            }
            if ( GXutil.strcmp(Z1679LSD4MarcaSCVO_18_1, T004Y2_A1679LSD4MarcaSCVO_18_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4MarcaSCVO_18_1");
               GXutil.writeLogRaw("Old: ",Z1679LSD4MarcaSCVO_18_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1679LSD4MarcaSCVO_18_1[0]);
            }
            if ( GXutil.strcmp(Z1680LSD4MarcaReduccion_19_1, T004Y2_A1680LSD4MarcaReduccion_19_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4MarcaReduccion_19_1");
               GXutil.writeLogRaw("Old: ",Z1680LSD4MarcaReduccion_19_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1680LSD4MarcaReduccion_19_1[0]);
            }
            if ( GXutil.strcmp(Z1681LSD4TipoEmpresa_20_1, T004Y2_A1681LSD4TipoEmpresa_20_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4TipoEmpresa_20_1");
               GXutil.writeLogRaw("Old: ",Z1681LSD4TipoEmpresa_20_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1681LSD4TipoEmpresa_20_1[0]);
            }
            if ( GXutil.strcmp(Z1682LSD4TipoOperacion_21_1, T004Y2_A1682LSD4TipoOperacion_21_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4TipoOperacion_21_1");
               GXutil.writeLogRaw("Old: ",Z1682LSD4TipoOperacion_21_1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1682LSD4TipoOperacion_21_1[0]);
            }
            if ( GXutil.strcmp(Z1683LSD4CodigoSituacion_22_2, T004Y2_A1683LSD4CodigoSituacion_22_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoSituacion_22_2");
               GXutil.writeLogRaw("Old: ",Z1683LSD4CodigoSituacion_22_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1683LSD4CodigoSituacion_22_2[0]);
            }
            if ( GXutil.strcmp(Z1684LSD4CodigoCondicion_24_2, T004Y2_A1684LSD4CodigoCondicion_24_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoCondicion_24_2");
               GXutil.writeLogRaw("Old: ",Z1684LSD4CodigoCondicion_24_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1684LSD4CodigoCondicion_24_2[0]);
            }
            if ( GXutil.strcmp(Z1685LSD4CodigoActividad_26_3, T004Y2_A1685LSD4CodigoActividad_26_3[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoActividad_26_3");
               GXutil.writeLogRaw("Old: ",Z1685LSD4CodigoActividad_26_3);
               GXutil.writeLogRaw("Current: ",T004Y2_A1685LSD4CodigoActividad_26_3[0]);
            }
            if ( GXutil.strcmp(Z1686LSD4CodigoModalidadContratacio, T004Y2_A1686LSD4CodigoModalidadContratacio[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoModalidadContratacio");
               GXutil.writeLogRaw("Old: ",Z1686LSD4CodigoModalidadContratacio);
               GXutil.writeLogRaw("Current: ",T004Y2_A1686LSD4CodigoModalidadContratacio[0]);
            }
            if ( GXutil.strcmp(Z1687LSD4CodigoSiniestrado_32_2, T004Y2_A1687LSD4CodigoSiniestrado_32_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoSiniestrado_32_2");
               GXutil.writeLogRaw("Old: ",Z1687LSD4CodigoSiniestrado_32_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1687LSD4CodigoSiniestrado_32_2[0]);
            }
            if ( GXutil.strcmp(Z1688LSD4CodigoLocalidad_34_2, T004Y2_A1688LSD4CodigoLocalidad_34_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoLocalidad_34_2");
               GXutil.writeLogRaw("Old: ",Z1688LSD4CodigoLocalidad_34_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1688LSD4CodigoLocalidad_34_2[0]);
            }
            if ( GXutil.strcmp(Z1689LSD4SituacionRevista1_36_2, T004Y2_A1689LSD4SituacionRevista1_36_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4SituacionRevista1_36_2");
               GXutil.writeLogRaw("Old: ",Z1689LSD4SituacionRevista1_36_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1689LSD4SituacionRevista1_36_2[0]);
            }
            if ( GXutil.strcmp(Z1690LSD4DiaInicioSituacionRevista1, T004Y2_A1690LSD4DiaInicioSituacionRevista1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4DiaInicioSituacionRevista1");
               GXutil.writeLogRaw("Old: ",Z1690LSD4DiaInicioSituacionRevista1);
               GXutil.writeLogRaw("Current: ",T004Y2_A1690LSD4DiaInicioSituacionRevista1[0]);
            }
            if ( GXutil.strcmp(Z1691LSD4SituacionRevista2_40_2, T004Y2_A1691LSD4SituacionRevista2_40_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4SituacionRevista2_40_2");
               GXutil.writeLogRaw("Old: ",Z1691LSD4SituacionRevista2_40_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1691LSD4SituacionRevista2_40_2[0]);
            }
            if ( GXutil.strcmp(Z1692LSD4DiaInicioSituacionRevista2, T004Y2_A1692LSD4DiaInicioSituacionRevista2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4DiaInicioSituacionRevista2");
               GXutil.writeLogRaw("Old: ",Z1692LSD4DiaInicioSituacionRevista2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1692LSD4DiaInicioSituacionRevista2[0]);
            }
            if ( GXutil.strcmp(Z1693LSD4SituacionRevista3_44_2, T004Y2_A1693LSD4SituacionRevista3_44_2[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4SituacionRevista3_44_2");
               GXutil.writeLogRaw("Old: ",Z1693LSD4SituacionRevista3_44_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1693LSD4SituacionRevista3_44_2[0]);
            }
            if ( GXutil.strcmp(Z1694LSD4DiaInicioSituacionRevista3, T004Y2_A1694LSD4DiaInicioSituacionRevista3[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4DiaInicioSituacionRevista3");
               GXutil.writeLogRaw("Old: ",Z1694LSD4DiaInicioSituacionRevista3);
               GXutil.writeLogRaw("Current: ",T004Y2_A1694LSD4DiaInicioSituacionRevista3[0]);
            }
            if ( Z1695LSD4CantidadDiasTrabajados_48_ != T004Y2_A1695LSD4CantidadDiasTrabajados_48_[0] )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CantidadDiasTrabajados_48_");
               GXutil.writeLogRaw("Old: ",Z1695LSD4CantidadDiasTrabajados_48_);
               GXutil.writeLogRaw("Current: ",T004Y2_A1695LSD4CantidadDiasTrabajados_48_[0]);
            }
            if ( Z1696LSD4HorasTrabajadas_50_3 != T004Y2_A1696LSD4HorasTrabajadas_50_3[0] )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4HorasTrabajadas_50_3");
               GXutil.writeLogRaw("Old: ",Z1696LSD4HorasTrabajadas_50_3);
               GXutil.writeLogRaw("Current: ",T004Y2_A1696LSD4HorasTrabajadas_50_3[0]);
            }
            if ( DecimalUtil.compareTo(Z1697LSD4PorcentajeAporteAdicionalS, T004Y2_A1697LSD4PorcentajeAporteAdicionalS[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4PorcentajeAporteAdicionalS");
               GXutil.writeLogRaw("Old: ",Z1697LSD4PorcentajeAporteAdicionalS);
               GXutil.writeLogRaw("Current: ",T004Y2_A1697LSD4PorcentajeAporteAdicionalS[0]);
            }
            if ( DecimalUtil.compareTo(Z1698LSD4ContribucionTareaDiferenci, T004Y2_A1698LSD4ContribucionTareaDiferenci[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4ContribucionTareaDiferenci");
               GXutil.writeLogRaw("Old: ",Z1698LSD4ContribucionTareaDiferenci);
               GXutil.writeLogRaw("Current: ",T004Y2_A1698LSD4ContribucionTareaDiferenci[0]);
            }
            if ( GXutil.strcmp(Z1699LSD4CodigoObraSocial_63_6, T004Y2_A1699LSD4CodigoObraSocial_63_6[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CodigoObraSocial_63_6");
               GXutil.writeLogRaw("Old: ",Z1699LSD4CodigoObraSocial_63_6);
               GXutil.writeLogRaw("Current: ",T004Y2_A1699LSD4CodigoObraSocial_63_6[0]);
            }
            if ( Z1700LSD4CantidadAdherentes_69_2 != T004Y2_A1700LSD4CantidadAdherentes_69_2[0] )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4CantidadAdherentes_69_2");
               GXutil.writeLogRaw("Old: ",Z1700LSD4CantidadAdherentes_69_2);
               GXutil.writeLogRaw("Current: ",T004Y2_A1700LSD4CantidadAdherentes_69_2[0]);
            }
            if ( DecimalUtil.compareTo(Z1701LSD4AporteAdicionalOS_71_15, T004Y2_A1701LSD4AporteAdicionalOS_71_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4AporteAdicionalOS_71_15");
               GXutil.writeLogRaw("Old: ",Z1701LSD4AporteAdicionalOS_71_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1701LSD4AporteAdicionalOS_71_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1702LSD4ContribucionAdicionalOS_86, T004Y2_A1702LSD4ContribucionAdicionalOS_86[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4ContribucionAdicionalOS_86");
               GXutil.writeLogRaw("Old: ",Z1702LSD4ContribucionAdicionalOS_86);
               GXutil.writeLogRaw("Current: ",T004Y2_A1702LSD4ContribucionAdicionalOS_86[0]);
            }
            if ( DecimalUtil.compareTo(Z1703LSD4BaseCalculoDiferencialApor, T004Y2_A1703LSD4BaseCalculoDiferencialApor[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseCalculoDiferencialApor");
               GXutil.writeLogRaw("Old: ",Z1703LSD4BaseCalculoDiferencialApor);
               GXutil.writeLogRaw("Current: ",T004Y2_A1703LSD4BaseCalculoDiferencialApor[0]);
            }
            if ( DecimalUtil.compareTo(Z1704LSD4BaseCalculoDiferencialOSyF, T004Y2_A1704LSD4BaseCalculoDiferencialOSyF[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseCalculoDiferencialOSyF");
               GXutil.writeLogRaw("Old: ",Z1704LSD4BaseCalculoDiferencialOSyF);
               GXutil.writeLogRaw("Current: ",T004Y2_A1704LSD4BaseCalculoDiferencialOSyF[0]);
            }
            if ( DecimalUtil.compareTo(Z1705LSD4BaseCalculoDiferencialLRT_, T004Y2_A1705LSD4BaseCalculoDiferencialLRT_[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseCalculoDiferencialLRT_");
               GXutil.writeLogRaw("Old: ",Z1705LSD4BaseCalculoDiferencialLRT_);
               GXutil.writeLogRaw("Current: ",T004Y2_A1705LSD4BaseCalculoDiferencialLRT_[0]);
            }
            if ( DecimalUtil.compareTo(Z1706LSD4RemuneracionMaternidadANSe, T004Y2_A1706LSD4RemuneracionMaternidadANSe[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4RemuneracionMaternidadANSe");
               GXutil.writeLogRaw("Old: ",Z1706LSD4RemuneracionMaternidadANSe);
               GXutil.writeLogRaw("Current: ",T004Y2_A1706LSD4RemuneracionMaternidadANSe[0]);
            }
            if ( DecimalUtil.compareTo(Z1707LSD4RemuneracionBruta_161_15, T004Y2_A1707LSD4RemuneracionBruta_161_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4RemuneracionBruta_161_15");
               GXutil.writeLogRaw("Old: ",Z1707LSD4RemuneracionBruta_161_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1707LSD4RemuneracionBruta_161_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1708LSD4BaseImponible1_176_15, T004Y2_A1708LSD4BaseImponible1_176_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible1_176_15");
               GXutil.writeLogRaw("Old: ",Z1708LSD4BaseImponible1_176_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1708LSD4BaseImponible1_176_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1709LSD4BaseImponible2_191_15, T004Y2_A1709LSD4BaseImponible2_191_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible2_191_15");
               GXutil.writeLogRaw("Old: ",Z1709LSD4BaseImponible2_191_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1709LSD4BaseImponible2_191_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1710LSD4BaseImponible3_206_15, T004Y2_A1710LSD4BaseImponible3_206_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible3_206_15");
               GXutil.writeLogRaw("Old: ",Z1710LSD4BaseImponible3_206_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1710LSD4BaseImponible3_206_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1711LSD4BaseImponible4_221_15, T004Y2_A1711LSD4BaseImponible4_221_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible4_221_15");
               GXutil.writeLogRaw("Old: ",Z1711LSD4BaseImponible4_221_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1711LSD4BaseImponible4_221_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1712LSD4BaseImponible5_236_15, T004Y2_A1712LSD4BaseImponible5_236_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible5_236_15");
               GXutil.writeLogRaw("Old: ",Z1712LSD4BaseImponible5_236_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1712LSD4BaseImponible5_236_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1713LSD4BaseImponible6_251_15, T004Y2_A1713LSD4BaseImponible6_251_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible6_251_15");
               GXutil.writeLogRaw("Old: ",Z1713LSD4BaseImponible6_251_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1713LSD4BaseImponible6_251_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1714LSD4BaseImponible7_266_15, T004Y2_A1714LSD4BaseImponible7_266_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible7_266_15");
               GXutil.writeLogRaw("Old: ",Z1714LSD4BaseImponible7_266_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1714LSD4BaseImponible7_266_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1715LSD4BaseImponible8_281_15, T004Y2_A1715LSD4BaseImponible8_281_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible8_281_15");
               GXutil.writeLogRaw("Old: ",Z1715LSD4BaseImponible8_281_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1715LSD4BaseImponible8_281_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1716LSD4BaseImponible9_296_15, T004Y2_A1716LSD4BaseImponible9_296_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible9_296_15");
               GXutil.writeLogRaw("Old: ",Z1716LSD4BaseImponible9_296_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1716LSD4BaseImponible9_296_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1717LSD4BaseDifApoSegSoc_311_15, T004Y2_A1717LSD4BaseDifApoSegSoc_311_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseDifApoSegSoc_311_15");
               GXutil.writeLogRaw("Old: ",Z1717LSD4BaseDifApoSegSoc_311_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1717LSD4BaseDifApoSegSoc_311_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1718LSD4BaseDifContSegSoc_326_15, T004Y2_A1718LSD4BaseDifContSegSoc_326_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseDifContSegSoc_326_15");
               GXutil.writeLogRaw("Old: ",Z1718LSD4BaseDifContSegSoc_326_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1718LSD4BaseDifContSegSoc_326_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1719LSD4BaseImponible10_341_15, T004Y2_A1719LSD4BaseImponible10_341_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4BaseImponible10_341_15");
               GXutil.writeLogRaw("Old: ",Z1719LSD4BaseImponible10_341_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1719LSD4BaseImponible10_341_15[0]);
            }
            if ( DecimalUtil.compareTo(Z1720LSD4ImporteADetraer_356_15, T004Y2_A1720LSD4ImporteADetraer_356_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg4:[seudo value changed for attri]"+"LSD4ImporteADetraer_356_15");
               GXutil.writeLogRaw("Old: ",Z1720LSD4ImporteADetraer_356_15);
               GXutil.writeLogRaw("Current: ",T004Y2_A1720LSD4ImporteADetraer_356_15[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LSD_reg4"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4Y232( )
   {
      beforeValidate4Y232( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4Y232( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4Y232( 0) ;
         checkOptimisticConcurrency4Y232( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4Y232( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4Y232( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004Y10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1674LSD4Sec), Long.valueOf(A1675LSD4CUIL_3_11), A1676LSD4Conyuge_14_1, Byte.valueOf(A1677LSD4CantidadHijos_15_2), A1678LSD4MarcaCCT_17_1, A1679LSD4MarcaSCVO_18_1, A1680LSD4MarcaReduccion_19_1, A1681LSD4TipoEmpresa_20_1, A1682LSD4TipoOperacion_21_1, A1683LSD4CodigoSituacion_22_2, A1684LSD4CodigoCondicion_24_2, A1685LSD4CodigoActividad_26_3, A1686LSD4CodigoModalidadContratacio, A1687LSD4CodigoSiniestrado_32_2, A1688LSD4CodigoLocalidad_34_2, A1689LSD4SituacionRevista1_36_2, A1690LSD4DiaInicioSituacionRevista1, A1691LSD4SituacionRevista2_40_2, A1692LSD4DiaInicioSituacionRevista2, A1693LSD4SituacionRevista3_44_2, A1694LSD4DiaInicioSituacionRevista3, Byte.valueOf(A1695LSD4CantidadDiasTrabajados_48_), Short.valueOf(A1696LSD4HorasTrabajadas_50_3), A1697LSD4PorcentajeAporteAdicionalS, A1698LSD4ContribucionTareaDiferenci, A1699LSD4CodigoObraSocial_63_6, Byte.valueOf(A1700LSD4CantidadAdherentes_69_2), A1701LSD4AporteAdicionalOS_71_15, A1702LSD4ContribucionAdicionalOS_86, A1703LSD4BaseCalculoDiferencialApor, A1704LSD4BaseCalculoDiferencialOSyF, A1705LSD4BaseCalculoDiferencialLRT_, A1706LSD4RemuneracionMaternidadANSe, A1707LSD4RemuneracionBruta_161_15, A1708LSD4BaseImponible1_176_15, A1709LSD4BaseImponible2_191_15, A1710LSD4BaseImponible3_206_15, A1711LSD4BaseImponible4_221_15, A1712LSD4BaseImponible5_236_15, A1713LSD4BaseImponible6_251_15, A1714LSD4BaseImponible7_266_15, A1715LSD4BaseImponible8_281_15, A1716LSD4BaseImponible9_296_15, A1717LSD4BaseDifApoSegSoc_311_15, A1718LSD4BaseDifContSegSoc_326_15, A1719LSD4BaseImponible10_341_15, A1720LSD4ImporteADetraer_356_15, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
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
                        resetCaption4Y0( ) ;
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
            load4Y232( ) ;
         }
         endLevel4Y232( ) ;
      }
      closeExtendedTableCursors4Y232( ) ;
   }

   public void update4Y232( )
   {
      beforeValidate4Y232( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4Y232( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4Y232( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4Y232( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4Y232( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004Y11 */
                  pr_default.execute(9, new Object[] {Long.valueOf(A1675LSD4CUIL_3_11), A1676LSD4Conyuge_14_1, Byte.valueOf(A1677LSD4CantidadHijos_15_2), A1678LSD4MarcaCCT_17_1, A1679LSD4MarcaSCVO_18_1, A1680LSD4MarcaReduccion_19_1, A1681LSD4TipoEmpresa_20_1, A1682LSD4TipoOperacion_21_1, A1683LSD4CodigoSituacion_22_2, A1684LSD4CodigoCondicion_24_2, A1685LSD4CodigoActividad_26_3, A1686LSD4CodigoModalidadContratacio, A1687LSD4CodigoSiniestrado_32_2, A1688LSD4CodigoLocalidad_34_2, A1689LSD4SituacionRevista1_36_2, A1690LSD4DiaInicioSituacionRevista1, A1691LSD4SituacionRevista2_40_2, A1692LSD4DiaInicioSituacionRevista2, A1693LSD4SituacionRevista3_44_2, A1694LSD4DiaInicioSituacionRevista3, Byte.valueOf(A1695LSD4CantidadDiasTrabajados_48_), Short.valueOf(A1696LSD4HorasTrabajadas_50_3), A1697LSD4PorcentajeAporteAdicionalS, A1698LSD4ContribucionTareaDiferenci, A1699LSD4CodigoObraSocial_63_6, Byte.valueOf(A1700LSD4CantidadAdherentes_69_2), A1701LSD4AporteAdicionalOS_71_15, A1702LSD4ContribucionAdicionalOS_86, A1703LSD4BaseCalculoDiferencialApor, A1704LSD4BaseCalculoDiferencialOSyF, A1705LSD4BaseCalculoDiferencialLRT_, A1706LSD4RemuneracionMaternidadANSe, A1707LSD4RemuneracionBruta_161_15, A1708LSD4BaseImponible1_176_15, A1709LSD4BaseImponible2_191_15, A1710LSD4BaseImponible3_206_15, A1711LSD4BaseImponible4_221_15, A1712LSD4BaseImponible5_236_15, A1713LSD4BaseImponible6_251_15, A1714LSD4BaseImponible7_266_15, A1715LSD4BaseImponible8_281_15, A1716LSD4BaseImponible9_296_15, A1717LSD4BaseDifApoSegSoc_311_15, A1718LSD4BaseDifContSegSoc_326_15, A1719LSD4BaseImponible10_341_15, A1720LSD4ImporteADetraer_356_15, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg4"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4Y232( ) ;
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
         endLevel4Y232( ) ;
      }
      closeExtendedTableCursors4Y232( ) ;
   }

   public void deferredUpdate4Y232( )
   {
   }

   public void delete( )
   {
      beforeValidate4Y232( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4Y232( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4Y232( ) ;
         afterConfirm4Y232( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4Y232( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004Y12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
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
      sMode232 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4Y232( ) ;
      Gx_mode = sMode232 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4Y232( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV17Pgmname = "LSD_reg4" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void endLevel4Y232( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4Y232( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "lsd_reg4");
         if ( AnyError == 0 )
         {
            confirmValues4Y0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "lsd_reg4");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4Y232( )
   {
      /* Scan By routine */
      /* Using cursor T004Y13 */
      pr_default.execute(11);
      RcdFound232 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound232 = (short)(1) ;
         A3CliCod = T004Y13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004Y13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004Y13_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004Y13_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1674LSD4Sec = T004Y13_A1674LSD4Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4Y232( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound232 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound232 = (short)(1) ;
         A3CliCod = T004Y13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004Y13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004Y13_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004Y13_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1674LSD4Sec = T004Y13_A1674LSD4Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      }
   }

   public void scanEnd4Y232( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4Y232( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4Y232( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4Y232( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4Y232( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4Y232( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4Y232( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4Y232( )
   {
      edtLSD4CUIL_3_11_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CUIL_3_11_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CUIL_3_11_Enabled), 5, 0), true);
      edtLSD4Conyuge_14_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4Conyuge_14_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Conyuge_14_1_Enabled), 5, 0), true);
      edtLSD4CantidadHijos_15_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CantidadHijos_15_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CantidadHijos_15_2_Enabled), 5, 0), true);
      edtLSD4MarcaCCT_17_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4MarcaCCT_17_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4MarcaCCT_17_1_Enabled), 5, 0), true);
      edtLSD4MarcaSCVO_18_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4MarcaSCVO_18_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4MarcaSCVO_18_1_Enabled), 5, 0), true);
      edtLSD4MarcaReduccion_19_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4MarcaReduccion_19_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4MarcaReduccion_19_1_Enabled), 5, 0), true);
      edtLSD4TipoEmpresa_20_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4TipoEmpresa_20_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4TipoEmpresa_20_1_Enabled), 5, 0), true);
      edtLSD4TipoOperacion_21_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4TipoOperacion_21_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4TipoOperacion_21_1_Enabled), 5, 0), true);
      edtLSD4CodigoSituacion_22_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoSituacion_22_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoSituacion_22_2_Enabled), 5, 0), true);
      edtLSD4CodigoCondicion_24_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoCondicion_24_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoCondicion_24_2_Enabled), 5, 0), true);
      edtLSD4CodigoActividad_26_3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoActividad_26_3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoActividad_26_3_Enabled), 5, 0), true);
      edtLSD4CodigoModalidadContratacio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoModalidadContratacio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoModalidadContratacio_Enabled), 5, 0), true);
      edtLSD4CodigoSiniestrado_32_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoSiniestrado_32_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoSiniestrado_32_2_Enabled), 5, 0), true);
      edtLSD4CodigoLocalidad_34_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoLocalidad_34_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoLocalidad_34_2_Enabled), 5, 0), true);
      edtLSD4SituacionRevista1_36_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4SituacionRevista1_36_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4SituacionRevista1_36_2_Enabled), 5, 0), true);
      edtLSD4DiaInicioSituacionRevista1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4DiaInicioSituacionRevista1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4DiaInicioSituacionRevista1_Enabled), 5, 0), true);
      edtLSD4SituacionRevista2_40_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4SituacionRevista2_40_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4SituacionRevista2_40_2_Enabled), 5, 0), true);
      edtLSD4DiaInicioSituacionRevista2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4DiaInicioSituacionRevista2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4DiaInicioSituacionRevista2_Enabled), 5, 0), true);
      edtLSD4SituacionRevista3_44_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4SituacionRevista3_44_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4SituacionRevista3_44_2_Enabled), 5, 0), true);
      edtLSD4DiaInicioSituacionRevista3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4DiaInicioSituacionRevista3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4DiaInicioSituacionRevista3_Enabled), 5, 0), true);
      edtLSD4CantidadDiasTrabajados_48__Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CantidadDiasTrabajados_48__Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CantidadDiasTrabajados_48__Enabled), 5, 0), true);
      edtLSD4HorasTrabajadas_50_3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4HorasTrabajadas_50_3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4HorasTrabajadas_50_3_Enabled), 5, 0), true);
      edtLSD4PorcentajeAporteAdicionalS_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4PorcentajeAporteAdicionalS_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4PorcentajeAporteAdicionalS_Enabled), 5, 0), true);
      edtLSD4ContribucionTareaDiferenci_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4ContribucionTareaDiferenci_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4ContribucionTareaDiferenci_Enabled), 5, 0), true);
      edtLSD4CodigoObraSocial_63_6_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CodigoObraSocial_63_6_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CodigoObraSocial_63_6_Enabled), 5, 0), true);
      edtLSD4CantidadAdherentes_69_2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4CantidadAdherentes_69_2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4CantidadAdherentes_69_2_Enabled), 5, 0), true);
      edtLSD4AporteAdicionalOS_71_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4AporteAdicionalOS_71_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4AporteAdicionalOS_71_15_Enabled), 5, 0), true);
      edtLSD4ContribucionAdicionalOS_86_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4ContribucionAdicionalOS_86_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4ContribucionAdicionalOS_86_Enabled), 5, 0), true);
      edtLSD4BaseCalculoDiferencialApor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseCalculoDiferencialApor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseCalculoDiferencialApor_Enabled), 5, 0), true);
      edtLSD4BaseCalculoDiferencialOSyF_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseCalculoDiferencialOSyF_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseCalculoDiferencialOSyF_Enabled), 5, 0), true);
      edtLSD4BaseCalculoDiferencialLRT__Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseCalculoDiferencialLRT__Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseCalculoDiferencialLRT__Enabled), 5, 0), true);
      edtLSD4RemuneracionMaternidadANSe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4RemuneracionMaternidadANSe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4RemuneracionMaternidadANSe_Enabled), 5, 0), true);
      edtLSD4RemuneracionBruta_161_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4RemuneracionBruta_161_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4RemuneracionBruta_161_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible1_176_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible1_176_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible1_176_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible2_191_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible2_191_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible2_191_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible3_206_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible3_206_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible3_206_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible4_221_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible4_221_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible4_221_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible5_236_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible5_236_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible5_236_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible6_251_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible6_251_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible6_251_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible7_266_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible7_266_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible7_266_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible8_281_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible8_281_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible8_281_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible9_296_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible9_296_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible9_296_15_Enabled), 5, 0), true);
      edtLSD4BaseDifApoSegSoc_311_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseDifApoSegSoc_311_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseDifApoSegSoc_311_15_Enabled), 5, 0), true);
      edtLSD4BaseDifContSegSoc_326_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseDifContSegSoc_326_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseDifContSegSoc_326_15_Enabled), 5, 0), true);
      edtLSD4BaseImponible10_341_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4BaseImponible10_341_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4BaseImponible10_341_15_Enabled), 5, 0), true);
      edtLSD4ImporteADetraer_356_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4ImporteADetraer_356_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4ImporteADetraer_356_15_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLSDSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      edtLSD2Sec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      edtLSD4Sec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD4Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD4Sec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4Y232( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4Y0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg4", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD4Sec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg4");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("lsd_reg4:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1649LSDSec", GXutil.ltrim( localUtil.ntoc( Z1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1657LSD2Sec", GXutil.ltrim( localUtil.ntoc( Z1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1674LSD4Sec", GXutil.ltrim( localUtil.ntoc( Z1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1675LSD4CUIL_3_11", GXutil.ltrim( localUtil.ntoc( Z1675LSD4CUIL_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1676LSD4Conyuge_14_1", GXutil.rtrim( Z1676LSD4Conyuge_14_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1677LSD4CantidadHijos_15_2", GXutil.ltrim( localUtil.ntoc( Z1677LSD4CantidadHijos_15_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1678LSD4MarcaCCT_17_1", GXutil.rtrim( Z1678LSD4MarcaCCT_17_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1679LSD4MarcaSCVO_18_1", GXutil.rtrim( Z1679LSD4MarcaSCVO_18_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1680LSD4MarcaReduccion_19_1", GXutil.rtrim( Z1680LSD4MarcaReduccion_19_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1681LSD4TipoEmpresa_20_1", GXutil.rtrim( Z1681LSD4TipoEmpresa_20_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1682LSD4TipoOperacion_21_1", GXutil.rtrim( Z1682LSD4TipoOperacion_21_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1683LSD4CodigoSituacion_22_2", GXutil.rtrim( Z1683LSD4CodigoSituacion_22_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1684LSD4CodigoCondicion_24_2", GXutil.rtrim( Z1684LSD4CodigoCondicion_24_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1685LSD4CodigoActividad_26_3", GXutil.rtrim( Z1685LSD4CodigoActividad_26_3));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1686LSD4CodigoModalidadContratacio", GXutil.rtrim( Z1686LSD4CodigoModalidadContratacio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1687LSD4CodigoSiniestrado_32_2", GXutil.rtrim( Z1687LSD4CodigoSiniestrado_32_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1688LSD4CodigoLocalidad_34_2", GXutil.rtrim( Z1688LSD4CodigoLocalidad_34_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1689LSD4SituacionRevista1_36_2", GXutil.rtrim( Z1689LSD4SituacionRevista1_36_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1690LSD4DiaInicioSituacionRevista1", GXutil.rtrim( Z1690LSD4DiaInicioSituacionRevista1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1691LSD4SituacionRevista2_40_2", GXutil.rtrim( Z1691LSD4SituacionRevista2_40_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1692LSD4DiaInicioSituacionRevista2", GXutil.rtrim( Z1692LSD4DiaInicioSituacionRevista2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1693LSD4SituacionRevista3_44_2", GXutil.rtrim( Z1693LSD4SituacionRevista3_44_2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1694LSD4DiaInicioSituacionRevista3", GXutil.rtrim( Z1694LSD4DiaInicioSituacionRevista3));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrim( localUtil.ntoc( Z1695LSD4CantidadDiasTrabajados_48_, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1696LSD4HorasTrabajadas_50_3", GXutil.ltrim( localUtil.ntoc( Z1696LSD4HorasTrabajadas_50_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrim( localUtil.ntoc( Z1697LSD4PorcentajeAporteAdicionalS, (byte)(8), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1698LSD4ContribucionTareaDiferenci", GXutil.ltrim( localUtil.ntoc( Z1698LSD4ContribucionTareaDiferenci, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1699LSD4CodigoObraSocial_63_6", GXutil.rtrim( Z1699LSD4CodigoObraSocial_63_6));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1700LSD4CantidadAdherentes_69_2", GXutil.ltrim( localUtil.ntoc( Z1700LSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1701LSD4AporteAdicionalOS_71_15", GXutil.ltrim( localUtil.ntoc( Z1701LSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1702LSD4ContribucionAdicionalOS_86", GXutil.ltrim( localUtil.ntoc( Z1702LSD4ContribucionAdicionalOS_86, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1703LSD4BaseCalculoDiferencialApor", GXutil.ltrim( localUtil.ntoc( Z1703LSD4BaseCalculoDiferencialApor, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrim( localUtil.ntoc( Z1704LSD4BaseCalculoDiferencialOSyF, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrim( localUtil.ntoc( Z1705LSD4BaseCalculoDiferencialLRT_, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1706LSD4RemuneracionMaternidadANSe", GXutil.ltrim( localUtil.ntoc( Z1706LSD4RemuneracionMaternidadANSe, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1707LSD4RemuneracionBruta_161_15", GXutil.ltrim( localUtil.ntoc( Z1707LSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1708LSD4BaseImponible1_176_15", GXutil.ltrim( localUtil.ntoc( Z1708LSD4BaseImponible1_176_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1709LSD4BaseImponible2_191_15", GXutil.ltrim( localUtil.ntoc( Z1709LSD4BaseImponible2_191_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1710LSD4BaseImponible3_206_15", GXutil.ltrim( localUtil.ntoc( Z1710LSD4BaseImponible3_206_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1711LSD4BaseImponible4_221_15", GXutil.ltrim( localUtil.ntoc( Z1711LSD4BaseImponible4_221_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1712LSD4BaseImponible5_236_15", GXutil.ltrim( localUtil.ntoc( Z1712LSD4BaseImponible5_236_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1713LSD4BaseImponible6_251_15", GXutil.ltrim( localUtil.ntoc( Z1713LSD4BaseImponible6_251_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1714LSD4BaseImponible7_266_15", GXutil.ltrim( localUtil.ntoc( Z1714LSD4BaseImponible7_266_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1715LSD4BaseImponible8_281_15", GXutil.ltrim( localUtil.ntoc( Z1715LSD4BaseImponible8_281_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1716LSD4BaseImponible9_296_15", GXutil.ltrim( localUtil.ntoc( Z1716LSD4BaseImponible9_296_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrim( localUtil.ntoc( Z1717LSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrim( localUtil.ntoc( Z1718LSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1719LSD4BaseImponible10_341_15", GXutil.ltrim( localUtil.ntoc( Z1719LSD4BaseImponible10_341_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1720LSD4ImporteADetraer_356_15", GXutil.ltrim( localUtil.ntoc( Z1720LSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDSEC", GXutil.ltrim( localUtil.ntoc( AV9LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD2SEC", GXutil.ltrim( localUtil.ntoc( AV10LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LSD2Sec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD4SEC", GXutil.ltrim( localUtil.ntoc( AV11LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD4SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LSD4Sec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
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
      return formatLink("web.lsd_reg4", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD4Sec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"})  ;
   }

   public String getPgmname( )
   {
      return "LSD_reg4" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg4", "") ;
   }

   public void initializeNonKey4Y232( )
   {
      A1675LSD4CUIL_3_11 = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1675LSD4CUIL_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), 11, 0));
      A1676LSD4Conyuge_14_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1676LSD4Conyuge_14_1", A1676LSD4Conyuge_14_1);
      A1677LSD4CantidadHijos_15_2 = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1677LSD4CantidadHijos_15_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), 2, 0));
      A1678LSD4MarcaCCT_17_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1678LSD4MarcaCCT_17_1", A1678LSD4MarcaCCT_17_1);
      A1679LSD4MarcaSCVO_18_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1679LSD4MarcaSCVO_18_1", A1679LSD4MarcaSCVO_18_1);
      A1680LSD4MarcaReduccion_19_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1680LSD4MarcaReduccion_19_1", A1680LSD4MarcaReduccion_19_1);
      A1681LSD4TipoEmpresa_20_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1681LSD4TipoEmpresa_20_1", A1681LSD4TipoEmpresa_20_1);
      A1682LSD4TipoOperacion_21_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1682LSD4TipoOperacion_21_1", A1682LSD4TipoOperacion_21_1);
      A1683LSD4CodigoSituacion_22_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1683LSD4CodigoSituacion_22_2", A1683LSD4CodigoSituacion_22_2);
      A1684LSD4CodigoCondicion_24_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1684LSD4CodigoCondicion_24_2", A1684LSD4CodigoCondicion_24_2);
      A1685LSD4CodigoActividad_26_3 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1685LSD4CodigoActividad_26_3", A1685LSD4CodigoActividad_26_3);
      A1686LSD4CodigoModalidadContratacio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1686LSD4CodigoModalidadContratacio", A1686LSD4CodigoModalidadContratacio);
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1687LSD4CodigoSiniestrado_32_2", A1687LSD4CodigoSiniestrado_32_2);
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1688LSD4CodigoLocalidad_34_2", A1688LSD4CodigoLocalidad_34_2);
      A1689LSD4SituacionRevista1_36_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1689LSD4SituacionRevista1_36_2", A1689LSD4SituacionRevista1_36_2);
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1690LSD4DiaInicioSituacionRevista1", A1690LSD4DiaInicioSituacionRevista1);
      A1691LSD4SituacionRevista2_40_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1691LSD4SituacionRevista2_40_2", A1691LSD4SituacionRevista2_40_2);
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1692LSD4DiaInicioSituacionRevista2", A1692LSD4DiaInicioSituacionRevista2);
      A1693LSD4SituacionRevista3_44_2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1693LSD4SituacionRevista3_44_2", A1693LSD4SituacionRevista3_44_2);
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1694LSD4DiaInicioSituacionRevista3", A1694LSD4DiaInicioSituacionRevista3);
      A1695LSD4CantidadDiasTrabajados_48_ = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1695LSD4CantidadDiasTrabajados_48_", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), 2, 0));
      A1696LSD4HorasTrabajadas_50_3 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1696LSD4HorasTrabajadas_50_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), 3, 0));
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1697LSD4PorcentajeAporteAdicionalS", GXutil.ltrimstr( A1697LSD4PorcentajeAporteAdicionalS, 8, 2));
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1698LSD4ContribucionTareaDiferenci", GXutil.ltrimstr( A1698LSD4ContribucionTareaDiferenci, 6, 2));
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1699LSD4CodigoObraSocial_63_6", A1699LSD4CodigoObraSocial_63_6);
      A1700LSD4CantidadAdherentes_69_2 = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1700LSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), 2, 0));
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1701LSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( A1701LSD4AporteAdicionalOS_71_15, 16, 2));
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1702LSD4ContribucionAdicionalOS_86", GXutil.ltrimstr( A1702LSD4ContribucionAdicionalOS_86, 16, 2));
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1703LSD4BaseCalculoDiferencialApor", GXutil.ltrimstr( A1703LSD4BaseCalculoDiferencialApor, 16, 2));
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1704LSD4BaseCalculoDiferencialOSyF", GXutil.ltrimstr( A1704LSD4BaseCalculoDiferencialOSyF, 16, 2));
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1705LSD4BaseCalculoDiferencialLRT_", GXutil.ltrimstr( A1705LSD4BaseCalculoDiferencialLRT_, 16, 2));
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1706LSD4RemuneracionMaternidadANSe", GXutil.ltrimstr( A1706LSD4RemuneracionMaternidadANSe, 16, 2));
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1707LSD4RemuneracionBruta_161_15", GXutil.ltrimstr( A1707LSD4RemuneracionBruta_161_15, 16, 2));
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1708LSD4BaseImponible1_176_15", GXutil.ltrimstr( A1708LSD4BaseImponible1_176_15, 16, 2));
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1709LSD4BaseImponible2_191_15", GXutil.ltrimstr( A1709LSD4BaseImponible2_191_15, 16, 2));
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1710LSD4BaseImponible3_206_15", GXutil.ltrimstr( A1710LSD4BaseImponible3_206_15, 16, 2));
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1711LSD4BaseImponible4_221_15", GXutil.ltrimstr( A1711LSD4BaseImponible4_221_15, 16, 2));
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1712LSD4BaseImponible5_236_15", GXutil.ltrimstr( A1712LSD4BaseImponible5_236_15, 16, 2));
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1713LSD4BaseImponible6_251_15", GXutil.ltrimstr( A1713LSD4BaseImponible6_251_15, 16, 2));
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1714LSD4BaseImponible7_266_15", GXutil.ltrimstr( A1714LSD4BaseImponible7_266_15, 16, 2));
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1715LSD4BaseImponible8_281_15", GXutil.ltrimstr( A1715LSD4BaseImponible8_281_15, 16, 2));
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1716LSD4BaseImponible9_296_15", GXutil.ltrimstr( A1716LSD4BaseImponible9_296_15, 16, 2));
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1717LSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( A1717LSD4BaseDifApoSegSoc_311_15, 16, 2));
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1718LSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( A1718LSD4BaseDifContSegSoc_326_15, 16, 2));
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1719LSD4BaseImponible10_341_15", GXutil.ltrimstr( A1719LSD4BaseImponible10_341_15, 16, 2));
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1720LSD4ImporteADetraer_356_15", GXutil.ltrimstr( A1720LSD4ImporteADetraer_356_15, 16, 2));
      Z1675LSD4CUIL_3_11 = 0 ;
      Z1676LSD4Conyuge_14_1 = "" ;
      Z1677LSD4CantidadHijos_15_2 = (byte)(0) ;
      Z1678LSD4MarcaCCT_17_1 = "" ;
      Z1679LSD4MarcaSCVO_18_1 = "" ;
      Z1680LSD4MarcaReduccion_19_1 = "" ;
      Z1681LSD4TipoEmpresa_20_1 = "" ;
      Z1682LSD4TipoOperacion_21_1 = "" ;
      Z1683LSD4CodigoSituacion_22_2 = "" ;
      Z1684LSD4CodigoCondicion_24_2 = "" ;
      Z1685LSD4CodigoActividad_26_3 = "" ;
      Z1686LSD4CodigoModalidadContratacio = "" ;
      Z1687LSD4CodigoSiniestrado_32_2 = "" ;
      Z1688LSD4CodigoLocalidad_34_2 = "" ;
      Z1689LSD4SituacionRevista1_36_2 = "" ;
      Z1690LSD4DiaInicioSituacionRevista1 = "" ;
      Z1691LSD4SituacionRevista2_40_2 = "" ;
      Z1692LSD4DiaInicioSituacionRevista2 = "" ;
      Z1693LSD4SituacionRevista3_44_2 = "" ;
      Z1694LSD4DiaInicioSituacionRevista3 = "" ;
      Z1695LSD4CantidadDiasTrabajados_48_ = (byte)(0) ;
      Z1696LSD4HorasTrabajadas_50_3 = (short)(0) ;
      Z1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      Z1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      Z1699LSD4CodigoObraSocial_63_6 = "" ;
      Z1700LSD4CantidadAdherentes_69_2 = (byte)(0) ;
      Z1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      Z1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      Z1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      Z1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      Z1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      Z1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      Z1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      Z1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      Z1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      Z1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      Z1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      Z1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      Z1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      Z1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      Z1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      Z1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      Z1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      Z1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      Z1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      Z1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
   }

   public void initAll4Y232( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1649LSDSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      A1657LSD2Sec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      A1674LSD4Sec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1674LSD4Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1674LSD4Sec), 4, 0));
      initializeNonKey4Y232( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020265848", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("lsd_reg4.js", "?2024122020265848", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLSD4CUIL_3_11_Internalname = "LSD4CUIL_3_11" ;
      edtLSD4Conyuge_14_1_Internalname = "LSD4CONYUGE_14_1" ;
      edtLSD4CantidadHijos_15_2_Internalname = "LSD4CANTIDADHIJOS_15_2" ;
      edtLSD4MarcaCCT_17_1_Internalname = "LSD4MARCACCT_17_1" ;
      edtLSD4MarcaSCVO_18_1_Internalname = "LSD4MARCASCVO_18_1" ;
      edtLSD4MarcaReduccion_19_1_Internalname = "LSD4MARCAREDUCCION_19_1" ;
      edtLSD4TipoEmpresa_20_1_Internalname = "LSD4TIPOEMPRESA_20_1" ;
      edtLSD4TipoOperacion_21_1_Internalname = "LSD4TIPOOPERACION_21_1" ;
      edtLSD4CodigoSituacion_22_2_Internalname = "LSD4CODIGOSITUACION_22_2" ;
      edtLSD4CodigoCondicion_24_2_Internalname = "LSD4CODIGOCONDICION_24_2" ;
      edtLSD4CodigoActividad_26_3_Internalname = "LSD4CODIGOACTIVIDAD_26_3" ;
      edtLSD4CodigoModalidadContratacio_Internalname = "LSD4CODIGOMODALIDADCONTRATACIO" ;
      edtLSD4CodigoSiniestrado_32_2_Internalname = "LSD4CODIGOSINIESTRADO_32_2" ;
      edtLSD4CodigoLocalidad_34_2_Internalname = "LSD4CODIGOLOCALIDAD_34_2" ;
      edtLSD4SituacionRevista1_36_2_Internalname = "LSD4SITUACIONREVISTA1_36_2" ;
      edtLSD4DiaInicioSituacionRevista1_Internalname = "LSD4DIAINICIOSITUACIONREVISTA1" ;
      edtLSD4SituacionRevista2_40_2_Internalname = "LSD4SITUACIONREVISTA2_40_2" ;
      edtLSD4DiaInicioSituacionRevista2_Internalname = "LSD4DIAINICIOSITUACIONREVISTA2" ;
      edtLSD4SituacionRevista3_44_2_Internalname = "LSD4SITUACIONREVISTA3_44_2" ;
      edtLSD4DiaInicioSituacionRevista3_Internalname = "LSD4DIAINICIOSITUACIONREVISTA3" ;
      edtLSD4CantidadDiasTrabajados_48__Internalname = "LSD4CANTIDADDIASTRABAJADOS_48_" ;
      edtLSD4HorasTrabajadas_50_3_Internalname = "LSD4HORASTRABAJADAS_50_3" ;
      edtLSD4PorcentajeAporteAdicionalS_Internalname = "LSD4PORCENTAJEAPORTEADICIONALS" ;
      edtLSD4ContribucionTareaDiferenci_Internalname = "LSD4CONTRIBUCIONTAREADIFERENCI" ;
      edtLSD4CodigoObraSocial_63_6_Internalname = "LSD4CODIGOOBRASOCIAL_63_6" ;
      edtLSD4CantidadAdherentes_69_2_Internalname = "LSD4CANTIDADADHERENTES_69_2" ;
      edtLSD4AporteAdicionalOS_71_15_Internalname = "LSD4APORTEADICIONALOS_71_15" ;
      edtLSD4ContribucionAdicionalOS_86_Internalname = "LSD4CONTRIBUCIONADICIONALOS_86" ;
      edtLSD4BaseCalculoDiferencialApor_Internalname = "LSD4BASECALCULODIFERENCIALAPOR" ;
      edtLSD4BaseCalculoDiferencialOSyF_Internalname = "LSD4BASECALCULODIFERENCIALOSYF" ;
      edtLSD4BaseCalculoDiferencialLRT__Internalname = "LSD4BASECALCULODIFERENCIALLRT_" ;
      edtLSD4RemuneracionMaternidadANSe_Internalname = "LSD4REMUNERACIONMATERNIDADANSE" ;
      edtLSD4RemuneracionBruta_161_15_Internalname = "LSD4REMUNERACIONBRUTA_161_15" ;
      edtLSD4BaseImponible1_176_15_Internalname = "LSD4BASEIMPONIBLE1_176_15" ;
      edtLSD4BaseImponible2_191_15_Internalname = "LSD4BASEIMPONIBLE2_191_15" ;
      edtLSD4BaseImponible3_206_15_Internalname = "LSD4BASEIMPONIBLE3_206_15" ;
      edtLSD4BaseImponible4_221_15_Internalname = "LSD4BASEIMPONIBLE4_221_15" ;
      edtLSD4BaseImponible5_236_15_Internalname = "LSD4BASEIMPONIBLE5_236_15" ;
      edtLSD4BaseImponible6_251_15_Internalname = "LSD4BASEIMPONIBLE6_251_15" ;
      edtLSD4BaseImponible7_266_15_Internalname = "LSD4BASEIMPONIBLE7_266_15" ;
      edtLSD4BaseImponible8_281_15_Internalname = "LSD4BASEIMPONIBLE8_281_15" ;
      edtLSD4BaseImponible9_296_15_Internalname = "LSD4BASEIMPONIBLE9_296_15" ;
      edtLSD4BaseDifApoSegSoc_311_15_Internalname = "LSD4BASEDIFAPOSEGSOC_311_15" ;
      edtLSD4BaseDifContSegSoc_326_15_Internalname = "LSD4BASEDIFCONTSEGSOC_326_15" ;
      edtLSD4BaseImponible10_341_15_Internalname = "LSD4BASEIMPONIBLE10_341_15" ;
      edtLSD4ImporteADetraer_356_15_Internalname = "LSD4IMPORTEADETRAER_356_15" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLSDSec_Internalname = "LSDSEC" ;
      edtLSD2Sec_Internalname = "LSD2SEC" ;
      edtLSD4Sec_Internalname = "LSD4SEC" ;
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
      Form.setCaption( httpContext.getMessage( "LSD_reg4", "") );
      edtLSD4Sec_Jsonclick = "" ;
      edtLSD4Sec_Enabled = 1 ;
      edtLSD4Sec_Visible = 1 ;
      edtLSD2Sec_Jsonclick = "" ;
      edtLSD2Sec_Enabled = 1 ;
      edtLSD2Sec_Visible = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtLSDSec_Enabled = 1 ;
      edtLSDSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLSD4ImporteADetraer_356_15_Jsonclick = "" ;
      edtLSD4ImporteADetraer_356_15_Enabled = 1 ;
      edtLSD4BaseImponible10_341_15_Jsonclick = "" ;
      edtLSD4BaseImponible10_341_15_Enabled = 1 ;
      edtLSD4BaseDifContSegSoc_326_15_Jsonclick = "" ;
      edtLSD4BaseDifContSegSoc_326_15_Enabled = 1 ;
      edtLSD4BaseDifApoSegSoc_311_15_Jsonclick = "" ;
      edtLSD4BaseDifApoSegSoc_311_15_Enabled = 1 ;
      edtLSD4BaseImponible9_296_15_Jsonclick = "" ;
      edtLSD4BaseImponible9_296_15_Enabled = 1 ;
      edtLSD4BaseImponible8_281_15_Jsonclick = "" ;
      edtLSD4BaseImponible8_281_15_Enabled = 1 ;
      edtLSD4BaseImponible7_266_15_Jsonclick = "" ;
      edtLSD4BaseImponible7_266_15_Enabled = 1 ;
      edtLSD4BaseImponible6_251_15_Jsonclick = "" ;
      edtLSD4BaseImponible6_251_15_Enabled = 1 ;
      edtLSD4BaseImponible5_236_15_Jsonclick = "" ;
      edtLSD4BaseImponible5_236_15_Enabled = 1 ;
      edtLSD4BaseImponible4_221_15_Jsonclick = "" ;
      edtLSD4BaseImponible4_221_15_Enabled = 1 ;
      edtLSD4BaseImponible3_206_15_Jsonclick = "" ;
      edtLSD4BaseImponible3_206_15_Enabled = 1 ;
      edtLSD4BaseImponible2_191_15_Jsonclick = "" ;
      edtLSD4BaseImponible2_191_15_Enabled = 1 ;
      edtLSD4BaseImponible1_176_15_Jsonclick = "" ;
      edtLSD4BaseImponible1_176_15_Enabled = 1 ;
      edtLSD4RemuneracionBruta_161_15_Jsonclick = "" ;
      edtLSD4RemuneracionBruta_161_15_Enabled = 1 ;
      edtLSD4RemuneracionMaternidadANSe_Jsonclick = "" ;
      edtLSD4RemuneracionMaternidadANSe_Enabled = 1 ;
      edtLSD4BaseCalculoDiferencialLRT__Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialLRT__Enabled = 1 ;
      edtLSD4BaseCalculoDiferencialOSyF_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialOSyF_Enabled = 1 ;
      edtLSD4BaseCalculoDiferencialApor_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialApor_Enabled = 1 ;
      edtLSD4ContribucionAdicionalOS_86_Jsonclick = "" ;
      edtLSD4ContribucionAdicionalOS_86_Enabled = 1 ;
      edtLSD4AporteAdicionalOS_71_15_Jsonclick = "" ;
      edtLSD4AporteAdicionalOS_71_15_Enabled = 1 ;
      edtLSD4CantidadAdherentes_69_2_Jsonclick = "" ;
      edtLSD4CantidadAdherentes_69_2_Enabled = 1 ;
      edtLSD4CodigoObraSocial_63_6_Jsonclick = "" ;
      edtLSD4CodigoObraSocial_63_6_Enabled = 1 ;
      edtLSD4ContribucionTareaDiferenci_Jsonclick = "" ;
      edtLSD4ContribucionTareaDiferenci_Enabled = 1 ;
      edtLSD4PorcentajeAporteAdicionalS_Jsonclick = "" ;
      edtLSD4PorcentajeAporteAdicionalS_Enabled = 1 ;
      edtLSD4HorasTrabajadas_50_3_Jsonclick = "" ;
      edtLSD4HorasTrabajadas_50_3_Enabled = 1 ;
      edtLSD4CantidadDiasTrabajados_48__Jsonclick = "" ;
      edtLSD4CantidadDiasTrabajados_48__Enabled = 1 ;
      edtLSD4DiaInicioSituacionRevista3_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista3_Enabled = 1 ;
      edtLSD4SituacionRevista3_44_2_Jsonclick = "" ;
      edtLSD4SituacionRevista3_44_2_Enabled = 1 ;
      edtLSD4DiaInicioSituacionRevista2_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista2_Enabled = 1 ;
      edtLSD4SituacionRevista2_40_2_Jsonclick = "" ;
      edtLSD4SituacionRevista2_40_2_Enabled = 1 ;
      edtLSD4DiaInicioSituacionRevista1_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista1_Enabled = 1 ;
      edtLSD4SituacionRevista1_36_2_Jsonclick = "" ;
      edtLSD4SituacionRevista1_36_2_Enabled = 1 ;
      edtLSD4CodigoLocalidad_34_2_Jsonclick = "" ;
      edtLSD4CodigoLocalidad_34_2_Enabled = 1 ;
      edtLSD4CodigoSiniestrado_32_2_Jsonclick = "" ;
      edtLSD4CodigoSiniestrado_32_2_Enabled = 1 ;
      edtLSD4CodigoModalidadContratacio_Jsonclick = "" ;
      edtLSD4CodigoModalidadContratacio_Enabled = 1 ;
      edtLSD4CodigoActividad_26_3_Jsonclick = "" ;
      edtLSD4CodigoActividad_26_3_Enabled = 1 ;
      edtLSD4CodigoCondicion_24_2_Jsonclick = "" ;
      edtLSD4CodigoCondicion_24_2_Enabled = 1 ;
      edtLSD4CodigoSituacion_22_2_Jsonclick = "" ;
      edtLSD4CodigoSituacion_22_2_Enabled = 1 ;
      edtLSD4TipoOperacion_21_1_Jsonclick = "" ;
      edtLSD4TipoOperacion_21_1_Enabled = 1 ;
      edtLSD4TipoEmpresa_20_1_Jsonclick = "" ;
      edtLSD4TipoEmpresa_20_1_Enabled = 1 ;
      edtLSD4MarcaReduccion_19_1_Jsonclick = "" ;
      edtLSD4MarcaReduccion_19_1_Enabled = 1 ;
      edtLSD4MarcaSCVO_18_1_Jsonclick = "" ;
      edtLSD4MarcaSCVO_18_1_Enabled = 1 ;
      edtLSD4MarcaCCT_17_1_Jsonclick = "" ;
      edtLSD4MarcaCCT_17_1_Enabled = 1 ;
      edtLSD4CantidadHijos_15_2_Jsonclick = "" ;
      edtLSD4CantidadHijos_15_2_Enabled = 1 ;
      edtLSD4Conyuge_14_1_Jsonclick = "" ;
      edtLSD4Conyuge_14_1_Enabled = 1 ;
      edtLSD4CUIL_3_11_Jsonclick = "" ;
      edtLSD4CUIL_3_11_Enabled = 1 ;
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

   public void gx1asaclicod4Y232( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            lsd_reg4_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void init_web_controls( )
   {
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

   public void valid_Lsd2sec( )
   {
      /* Using cursor T004Y14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LSD4Sec',fld:'vLSD4SEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LSD4Sec',fld:'vLSD4SEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e124Y2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LSDSEC","{handler:'valid_Lsdsec',iparms:[]");
      setEventMetadata("VALID_LSDSEC",",oparms:[]}");
      setEventMetadata("VALID_LSD2SEC","{handler:'valid_Lsd2sec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_LSD2SEC",",oparms:[]}");
      setEventMetadata("VALID_LSD4SEC","{handler:'valid_Lsd4sec',iparms:[]");
      setEventMetadata("VALID_LSD4SEC",",oparms:[]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1676LSD4Conyuge_14_1 = "" ;
      Z1678LSD4MarcaCCT_17_1 = "" ;
      Z1679LSD4MarcaSCVO_18_1 = "" ;
      Z1680LSD4MarcaReduccion_19_1 = "" ;
      Z1681LSD4TipoEmpresa_20_1 = "" ;
      Z1682LSD4TipoOperacion_21_1 = "" ;
      Z1683LSD4CodigoSituacion_22_2 = "" ;
      Z1684LSD4CodigoCondicion_24_2 = "" ;
      Z1685LSD4CodigoActividad_26_3 = "" ;
      Z1686LSD4CodigoModalidadContratacio = "" ;
      Z1687LSD4CodigoSiniestrado_32_2 = "" ;
      Z1688LSD4CodigoLocalidad_34_2 = "" ;
      Z1689LSD4SituacionRevista1_36_2 = "" ;
      Z1690LSD4DiaInicioSituacionRevista1 = "" ;
      Z1691LSD4SituacionRevista2_40_2 = "" ;
      Z1692LSD4DiaInicioSituacionRevista2 = "" ;
      Z1693LSD4SituacionRevista3_44_2 = "" ;
      Z1694LSD4DiaInicioSituacionRevista3 = "" ;
      Z1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      Z1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      Z1699LSD4CodigoObraSocial_63_6 = "" ;
      Z1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      Z1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      Z1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      Z1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      Z1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      Z1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      Z1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      Z1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      Z1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      Z1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      Z1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      Z1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      Z1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      Z1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      Z1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      Z1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      Z1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      Z1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      Z1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      Z1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1676LSD4Conyuge_14_1 = "" ;
      A1678LSD4MarcaCCT_17_1 = "" ;
      A1679LSD4MarcaSCVO_18_1 = "" ;
      A1680LSD4MarcaReduccion_19_1 = "" ;
      A1681LSD4TipoEmpresa_20_1 = "" ;
      A1682LSD4TipoOperacion_21_1 = "" ;
      A1683LSD4CodigoSituacion_22_2 = "" ;
      A1684LSD4CodigoCondicion_24_2 = "" ;
      A1685LSD4CodigoActividad_26_3 = "" ;
      A1686LSD4CodigoModalidadContratacio = "" ;
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      A1689LSD4SituacionRevista1_36_2 = "" ;
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      A1691LSD4SituacionRevista2_40_2 = "" ;
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      A1693LSD4SituacionRevista3_44_2 = "" ;
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV17Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode232 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      T004Y5_A1674LSD4Sec = new short[1] ;
      T004Y5_A1675LSD4CUIL_3_11 = new long[1] ;
      T004Y5_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      T004Y5_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      T004Y5_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      T004Y5_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      T004Y5_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      T004Y5_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      T004Y5_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      T004Y5_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      T004Y5_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      T004Y5_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      T004Y5_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      T004Y5_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      T004Y5_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      T004Y5_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      T004Y5_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      T004Y5_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      T004Y5_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      T004Y5_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      T004Y5_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      T004Y5_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      T004Y5_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      T004Y5_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      T004Y5_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      T004Y5_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y5_A3CliCod = new int[1] ;
      T004Y5_A1EmpCod = new short[1] ;
      T004Y5_A1649LSDSec = new int[1] ;
      T004Y5_A1657LSD2Sec = new int[1] ;
      T004Y4_A3CliCod = new int[1] ;
      T004Y6_A3CliCod = new int[1] ;
      T004Y7_A3CliCod = new int[1] ;
      T004Y7_A1EmpCod = new short[1] ;
      T004Y7_A1649LSDSec = new int[1] ;
      T004Y7_A1657LSD2Sec = new int[1] ;
      T004Y7_A1674LSD4Sec = new short[1] ;
      T004Y3_A1674LSD4Sec = new short[1] ;
      T004Y3_A1675LSD4CUIL_3_11 = new long[1] ;
      T004Y3_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      T004Y3_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      T004Y3_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      T004Y3_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      T004Y3_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      T004Y3_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      T004Y3_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      T004Y3_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      T004Y3_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      T004Y3_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      T004Y3_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      T004Y3_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      T004Y3_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      T004Y3_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      T004Y3_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      T004Y3_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      T004Y3_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      T004Y3_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      T004Y3_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      T004Y3_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      T004Y3_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      T004Y3_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      T004Y3_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      T004Y3_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y3_A3CliCod = new int[1] ;
      T004Y3_A1EmpCod = new short[1] ;
      T004Y3_A1649LSDSec = new int[1] ;
      T004Y3_A1657LSD2Sec = new int[1] ;
      T004Y8_A3CliCod = new int[1] ;
      T004Y8_A1EmpCod = new short[1] ;
      T004Y8_A1649LSDSec = new int[1] ;
      T004Y8_A1657LSD2Sec = new int[1] ;
      T004Y8_A1674LSD4Sec = new short[1] ;
      T004Y9_A3CliCod = new int[1] ;
      T004Y9_A1EmpCod = new short[1] ;
      T004Y9_A1649LSDSec = new int[1] ;
      T004Y9_A1657LSD2Sec = new int[1] ;
      T004Y9_A1674LSD4Sec = new short[1] ;
      T004Y2_A1674LSD4Sec = new short[1] ;
      T004Y2_A1675LSD4CUIL_3_11 = new long[1] ;
      T004Y2_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      T004Y2_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      T004Y2_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      T004Y2_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      T004Y2_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      T004Y2_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      T004Y2_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      T004Y2_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      T004Y2_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      T004Y2_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      T004Y2_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      T004Y2_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      T004Y2_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      T004Y2_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      T004Y2_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      T004Y2_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      T004Y2_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      T004Y2_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      T004Y2_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      T004Y2_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      T004Y2_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      T004Y2_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      T004Y2_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      T004Y2_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004Y2_A3CliCod = new int[1] ;
      T004Y2_A1EmpCod = new short[1] ;
      T004Y2_A1649LSDSec = new int[1] ;
      T004Y2_A1657LSD2Sec = new int[1] ;
      T004Y13_A3CliCod = new int[1] ;
      T004Y13_A1EmpCod = new short[1] ;
      T004Y13_A1649LSDSec = new int[1] ;
      T004Y13_A1657LSD2Sec = new int[1] ;
      T004Y13_A1674LSD4Sec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T004Y14_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg4__default(),
         new Object[] {
             new Object[] {
            T004Y2_A1674LSD4Sec, T004Y2_A1675LSD4CUIL_3_11, T004Y2_A1676LSD4Conyuge_14_1, T004Y2_A1677LSD4CantidadHijos_15_2, T004Y2_A1678LSD4MarcaCCT_17_1, T004Y2_A1679LSD4MarcaSCVO_18_1, T004Y2_A1680LSD4MarcaReduccion_19_1, T004Y2_A1681LSD4TipoEmpresa_20_1, T004Y2_A1682LSD4TipoOperacion_21_1, T004Y2_A1683LSD4CodigoSituacion_22_2,
            T004Y2_A1684LSD4CodigoCondicion_24_2, T004Y2_A1685LSD4CodigoActividad_26_3, T004Y2_A1686LSD4CodigoModalidadContratacio, T004Y2_A1687LSD4CodigoSiniestrado_32_2, T004Y2_A1688LSD4CodigoLocalidad_34_2, T004Y2_A1689LSD4SituacionRevista1_36_2, T004Y2_A1690LSD4DiaInicioSituacionRevista1, T004Y2_A1691LSD4SituacionRevista2_40_2, T004Y2_A1692LSD4DiaInicioSituacionRevista2, T004Y2_A1693LSD4SituacionRevista3_44_2,
            T004Y2_A1694LSD4DiaInicioSituacionRevista3, T004Y2_A1695LSD4CantidadDiasTrabajados_48_, T004Y2_A1696LSD4HorasTrabajadas_50_3, T004Y2_A1697LSD4PorcentajeAporteAdicionalS, T004Y2_A1698LSD4ContribucionTareaDiferenci, T004Y2_A1699LSD4CodigoObraSocial_63_6, T004Y2_A1700LSD4CantidadAdherentes_69_2, T004Y2_A1701LSD4AporteAdicionalOS_71_15, T004Y2_A1702LSD4ContribucionAdicionalOS_86, T004Y2_A1703LSD4BaseCalculoDiferencialApor,
            T004Y2_A1704LSD4BaseCalculoDiferencialOSyF, T004Y2_A1705LSD4BaseCalculoDiferencialLRT_, T004Y2_A1706LSD4RemuneracionMaternidadANSe, T004Y2_A1707LSD4RemuneracionBruta_161_15, T004Y2_A1708LSD4BaseImponible1_176_15, T004Y2_A1709LSD4BaseImponible2_191_15, T004Y2_A1710LSD4BaseImponible3_206_15, T004Y2_A1711LSD4BaseImponible4_221_15, T004Y2_A1712LSD4BaseImponible5_236_15, T004Y2_A1713LSD4BaseImponible6_251_15,
            T004Y2_A1714LSD4BaseImponible7_266_15, T004Y2_A1715LSD4BaseImponible8_281_15, T004Y2_A1716LSD4BaseImponible9_296_15, T004Y2_A1717LSD4BaseDifApoSegSoc_311_15, T004Y2_A1718LSD4BaseDifContSegSoc_326_15, T004Y2_A1719LSD4BaseImponible10_341_15, T004Y2_A1720LSD4ImporteADetraer_356_15, T004Y2_A3CliCod, T004Y2_A1EmpCod, T004Y2_A1649LSDSec,
            T004Y2_A1657LSD2Sec
            }
            , new Object[] {
            T004Y3_A1674LSD4Sec, T004Y3_A1675LSD4CUIL_3_11, T004Y3_A1676LSD4Conyuge_14_1, T004Y3_A1677LSD4CantidadHijos_15_2, T004Y3_A1678LSD4MarcaCCT_17_1, T004Y3_A1679LSD4MarcaSCVO_18_1, T004Y3_A1680LSD4MarcaReduccion_19_1, T004Y3_A1681LSD4TipoEmpresa_20_1, T004Y3_A1682LSD4TipoOperacion_21_1, T004Y3_A1683LSD4CodigoSituacion_22_2,
            T004Y3_A1684LSD4CodigoCondicion_24_2, T004Y3_A1685LSD4CodigoActividad_26_3, T004Y3_A1686LSD4CodigoModalidadContratacio, T004Y3_A1687LSD4CodigoSiniestrado_32_2, T004Y3_A1688LSD4CodigoLocalidad_34_2, T004Y3_A1689LSD4SituacionRevista1_36_2, T004Y3_A1690LSD4DiaInicioSituacionRevista1, T004Y3_A1691LSD4SituacionRevista2_40_2, T004Y3_A1692LSD4DiaInicioSituacionRevista2, T004Y3_A1693LSD4SituacionRevista3_44_2,
            T004Y3_A1694LSD4DiaInicioSituacionRevista3, T004Y3_A1695LSD4CantidadDiasTrabajados_48_, T004Y3_A1696LSD4HorasTrabajadas_50_3, T004Y3_A1697LSD4PorcentajeAporteAdicionalS, T004Y3_A1698LSD4ContribucionTareaDiferenci, T004Y3_A1699LSD4CodigoObraSocial_63_6, T004Y3_A1700LSD4CantidadAdherentes_69_2, T004Y3_A1701LSD4AporteAdicionalOS_71_15, T004Y3_A1702LSD4ContribucionAdicionalOS_86, T004Y3_A1703LSD4BaseCalculoDiferencialApor,
            T004Y3_A1704LSD4BaseCalculoDiferencialOSyF, T004Y3_A1705LSD4BaseCalculoDiferencialLRT_, T004Y3_A1706LSD4RemuneracionMaternidadANSe, T004Y3_A1707LSD4RemuneracionBruta_161_15, T004Y3_A1708LSD4BaseImponible1_176_15, T004Y3_A1709LSD4BaseImponible2_191_15, T004Y3_A1710LSD4BaseImponible3_206_15, T004Y3_A1711LSD4BaseImponible4_221_15, T004Y3_A1712LSD4BaseImponible5_236_15, T004Y3_A1713LSD4BaseImponible6_251_15,
            T004Y3_A1714LSD4BaseImponible7_266_15, T004Y3_A1715LSD4BaseImponible8_281_15, T004Y3_A1716LSD4BaseImponible9_296_15, T004Y3_A1717LSD4BaseDifApoSegSoc_311_15, T004Y3_A1718LSD4BaseDifContSegSoc_326_15, T004Y3_A1719LSD4BaseImponible10_341_15, T004Y3_A1720LSD4ImporteADetraer_356_15, T004Y3_A3CliCod, T004Y3_A1EmpCod, T004Y3_A1649LSDSec,
            T004Y3_A1657LSD2Sec
            }
            , new Object[] {
            T004Y4_A3CliCod
            }
            , new Object[] {
            T004Y5_A1674LSD4Sec, T004Y5_A1675LSD4CUIL_3_11, T004Y5_A1676LSD4Conyuge_14_1, T004Y5_A1677LSD4CantidadHijos_15_2, T004Y5_A1678LSD4MarcaCCT_17_1, T004Y5_A1679LSD4MarcaSCVO_18_1, T004Y5_A1680LSD4MarcaReduccion_19_1, T004Y5_A1681LSD4TipoEmpresa_20_1, T004Y5_A1682LSD4TipoOperacion_21_1, T004Y5_A1683LSD4CodigoSituacion_22_2,
            T004Y5_A1684LSD4CodigoCondicion_24_2, T004Y5_A1685LSD4CodigoActividad_26_3, T004Y5_A1686LSD4CodigoModalidadContratacio, T004Y5_A1687LSD4CodigoSiniestrado_32_2, T004Y5_A1688LSD4CodigoLocalidad_34_2, T004Y5_A1689LSD4SituacionRevista1_36_2, T004Y5_A1690LSD4DiaInicioSituacionRevista1, T004Y5_A1691LSD4SituacionRevista2_40_2, T004Y5_A1692LSD4DiaInicioSituacionRevista2, T004Y5_A1693LSD4SituacionRevista3_44_2,
            T004Y5_A1694LSD4DiaInicioSituacionRevista3, T004Y5_A1695LSD4CantidadDiasTrabajados_48_, T004Y5_A1696LSD4HorasTrabajadas_50_3, T004Y5_A1697LSD4PorcentajeAporteAdicionalS, T004Y5_A1698LSD4ContribucionTareaDiferenci, T004Y5_A1699LSD4CodigoObraSocial_63_6, T004Y5_A1700LSD4CantidadAdherentes_69_2, T004Y5_A1701LSD4AporteAdicionalOS_71_15, T004Y5_A1702LSD4ContribucionAdicionalOS_86, T004Y5_A1703LSD4BaseCalculoDiferencialApor,
            T004Y5_A1704LSD4BaseCalculoDiferencialOSyF, T004Y5_A1705LSD4BaseCalculoDiferencialLRT_, T004Y5_A1706LSD4RemuneracionMaternidadANSe, T004Y5_A1707LSD4RemuneracionBruta_161_15, T004Y5_A1708LSD4BaseImponible1_176_15, T004Y5_A1709LSD4BaseImponible2_191_15, T004Y5_A1710LSD4BaseImponible3_206_15, T004Y5_A1711LSD4BaseImponible4_221_15, T004Y5_A1712LSD4BaseImponible5_236_15, T004Y5_A1713LSD4BaseImponible6_251_15,
            T004Y5_A1714LSD4BaseImponible7_266_15, T004Y5_A1715LSD4BaseImponible8_281_15, T004Y5_A1716LSD4BaseImponible9_296_15, T004Y5_A1717LSD4BaseDifApoSegSoc_311_15, T004Y5_A1718LSD4BaseDifContSegSoc_326_15, T004Y5_A1719LSD4BaseImponible10_341_15, T004Y5_A1720LSD4ImporteADetraer_356_15, T004Y5_A3CliCod, T004Y5_A1EmpCod, T004Y5_A1649LSDSec,
            T004Y5_A1657LSD2Sec
            }
            , new Object[] {
            T004Y6_A3CliCod
            }
            , new Object[] {
            T004Y7_A3CliCod, T004Y7_A1EmpCod, T004Y7_A1649LSDSec, T004Y7_A1657LSD2Sec, T004Y7_A1674LSD4Sec
            }
            , new Object[] {
            T004Y8_A3CliCod, T004Y8_A1EmpCod, T004Y8_A1649LSDSec, T004Y8_A1657LSD2Sec, T004Y8_A1674LSD4Sec
            }
            , new Object[] {
            T004Y9_A3CliCod, T004Y9_A1EmpCod, T004Y9_A1649LSDSec, T004Y9_A1657LSD2Sec, T004Y9_A1674LSD4Sec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004Y13_A3CliCod, T004Y13_A1EmpCod, T004Y13_A1649LSDSec, T004Y13_A1657LSD2Sec, T004Y13_A1674LSD4Sec
            }
            , new Object[] {
            T004Y14_A3CliCod
            }
         }
      );
      AV17Pgmname = "LSD_reg4" ;
   }

   private byte Z1677LSD4CantidadHijos_15_2 ;
   private byte Z1695LSD4CantidadDiasTrabajados_48_ ;
   private byte Z1700LSD4CantidadAdherentes_69_2 ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1677LSD4CantidadHijos_15_2 ;
   private byte A1695LSD4CantidadDiasTrabajados_48_ ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV11LSD4Sec ;
   private short Z1EmpCod ;
   private short Z1674LSD4Sec ;
   private short Z1696LSD4HorasTrabajadas_50_3 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV11LSD4Sec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1696LSD4HorasTrabajadas_50_3 ;
   private short A1674LSD4Sec ;
   private short RcdFound232 ;
   private short nIsDirty_232 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LSDSec ;
   private int wcpOAV10LSD2Sec ;
   private int Z3CliCod ;
   private int Z1649LSDSec ;
   private int Z1657LSD2Sec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private int AV9LSDSec ;
   private int AV10LSD2Sec ;
   private int trnEnded ;
   private int edtLSD4CUIL_3_11_Enabled ;
   private int edtLSD4Conyuge_14_1_Enabled ;
   private int edtLSD4CantidadHijos_15_2_Enabled ;
   private int edtLSD4MarcaCCT_17_1_Enabled ;
   private int edtLSD4MarcaSCVO_18_1_Enabled ;
   private int edtLSD4MarcaReduccion_19_1_Enabled ;
   private int edtLSD4TipoEmpresa_20_1_Enabled ;
   private int edtLSD4TipoOperacion_21_1_Enabled ;
   private int edtLSD4CodigoSituacion_22_2_Enabled ;
   private int edtLSD4CodigoCondicion_24_2_Enabled ;
   private int edtLSD4CodigoActividad_26_3_Enabled ;
   private int edtLSD4CodigoModalidadContratacio_Enabled ;
   private int edtLSD4CodigoSiniestrado_32_2_Enabled ;
   private int edtLSD4CodigoLocalidad_34_2_Enabled ;
   private int edtLSD4SituacionRevista1_36_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista1_Enabled ;
   private int edtLSD4SituacionRevista2_40_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista2_Enabled ;
   private int edtLSD4SituacionRevista3_44_2_Enabled ;
   private int edtLSD4DiaInicioSituacionRevista3_Enabled ;
   private int edtLSD4CantidadDiasTrabajados_48__Enabled ;
   private int edtLSD4HorasTrabajadas_50_3_Enabled ;
   private int edtLSD4PorcentajeAporteAdicionalS_Enabled ;
   private int edtLSD4ContribucionTareaDiferenci_Enabled ;
   private int edtLSD4CodigoObraSocial_63_6_Enabled ;
   private int edtLSD4CantidadAdherentes_69_2_Enabled ;
   private int edtLSD4AporteAdicionalOS_71_15_Enabled ;
   private int edtLSD4ContribucionAdicionalOS_86_Enabled ;
   private int edtLSD4BaseCalculoDiferencialApor_Enabled ;
   private int edtLSD4BaseCalculoDiferencialOSyF_Enabled ;
   private int edtLSD4BaseCalculoDiferencialLRT__Enabled ;
   private int edtLSD4RemuneracionMaternidadANSe_Enabled ;
   private int edtLSD4RemuneracionBruta_161_15_Enabled ;
   private int edtLSD4BaseImponible1_176_15_Enabled ;
   private int edtLSD4BaseImponible2_191_15_Enabled ;
   private int edtLSD4BaseImponible3_206_15_Enabled ;
   private int edtLSD4BaseImponible4_221_15_Enabled ;
   private int edtLSD4BaseImponible5_236_15_Enabled ;
   private int edtLSD4BaseImponible6_251_15_Enabled ;
   private int edtLSD4BaseImponible7_266_15_Enabled ;
   private int edtLSD4BaseImponible8_281_15_Enabled ;
   private int edtLSD4BaseImponible9_296_15_Enabled ;
   private int edtLSD4BaseDifApoSegSoc_311_15_Enabled ;
   private int edtLSD4BaseDifContSegSoc_326_15_Enabled ;
   private int edtLSD4BaseImponible10_341_15_Enabled ;
   private int edtLSD4ImporteADetraer_356_15_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLSDSec_Visible ;
   private int edtLSDSec_Enabled ;
   private int edtLSD2Sec_Visible ;
   private int edtLSD2Sec_Enabled ;
   private int edtLSD4Sec_Visible ;
   private int edtLSD4Sec_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long Z1675LSD4CUIL_3_11 ;
   private long A1675LSD4CUIL_3_11 ;
   private java.math.BigDecimal Z1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal Z1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal Z1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal Z1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal Z1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal Z1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal Z1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal Z1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal Z1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal Z1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal Z1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal Z1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal Z1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal Z1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal Z1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal Z1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal Z1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal Z1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal Z1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal Z1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal Z1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal Z1720LSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1676LSD4Conyuge_14_1 ;
   private String Z1678LSD4MarcaCCT_17_1 ;
   private String Z1679LSD4MarcaSCVO_18_1 ;
   private String Z1680LSD4MarcaReduccion_19_1 ;
   private String Z1681LSD4TipoEmpresa_20_1 ;
   private String Z1682LSD4TipoOperacion_21_1 ;
   private String Z1683LSD4CodigoSituacion_22_2 ;
   private String Z1684LSD4CodigoCondicion_24_2 ;
   private String Z1685LSD4CodigoActividad_26_3 ;
   private String Z1686LSD4CodigoModalidadContratacio ;
   private String Z1687LSD4CodigoSiniestrado_32_2 ;
   private String Z1688LSD4CodigoLocalidad_34_2 ;
   private String Z1689LSD4SituacionRevista1_36_2 ;
   private String Z1690LSD4DiaInicioSituacionRevista1 ;
   private String Z1691LSD4SituacionRevista2_40_2 ;
   private String Z1692LSD4DiaInicioSituacionRevista2 ;
   private String Z1693LSD4SituacionRevista3_44_2 ;
   private String Z1694LSD4DiaInicioSituacionRevista3 ;
   private String Z1699LSD4CodigoObraSocial_63_6 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLSD4CUIL_3_11_Internalname ;
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
   private String edtLSD4CUIL_3_11_Jsonclick ;
   private String edtLSD4Conyuge_14_1_Internalname ;
   private String A1676LSD4Conyuge_14_1 ;
   private String edtLSD4Conyuge_14_1_Jsonclick ;
   private String edtLSD4CantidadHijos_15_2_Internalname ;
   private String edtLSD4CantidadHijos_15_2_Jsonclick ;
   private String edtLSD4MarcaCCT_17_1_Internalname ;
   private String A1678LSD4MarcaCCT_17_1 ;
   private String edtLSD4MarcaCCT_17_1_Jsonclick ;
   private String edtLSD4MarcaSCVO_18_1_Internalname ;
   private String A1679LSD4MarcaSCVO_18_1 ;
   private String edtLSD4MarcaSCVO_18_1_Jsonclick ;
   private String edtLSD4MarcaReduccion_19_1_Internalname ;
   private String A1680LSD4MarcaReduccion_19_1 ;
   private String edtLSD4MarcaReduccion_19_1_Jsonclick ;
   private String edtLSD4TipoEmpresa_20_1_Internalname ;
   private String A1681LSD4TipoEmpresa_20_1 ;
   private String edtLSD4TipoEmpresa_20_1_Jsonclick ;
   private String edtLSD4TipoOperacion_21_1_Internalname ;
   private String A1682LSD4TipoOperacion_21_1 ;
   private String edtLSD4TipoOperacion_21_1_Jsonclick ;
   private String edtLSD4CodigoSituacion_22_2_Internalname ;
   private String A1683LSD4CodigoSituacion_22_2 ;
   private String edtLSD4CodigoSituacion_22_2_Jsonclick ;
   private String edtLSD4CodigoCondicion_24_2_Internalname ;
   private String A1684LSD4CodigoCondicion_24_2 ;
   private String edtLSD4CodigoCondicion_24_2_Jsonclick ;
   private String edtLSD4CodigoActividad_26_3_Internalname ;
   private String A1685LSD4CodigoActividad_26_3 ;
   private String edtLSD4CodigoActividad_26_3_Jsonclick ;
   private String edtLSD4CodigoModalidadContratacio_Internalname ;
   private String A1686LSD4CodigoModalidadContratacio ;
   private String edtLSD4CodigoModalidadContratacio_Jsonclick ;
   private String edtLSD4CodigoSiniestrado_32_2_Internalname ;
   private String A1687LSD4CodigoSiniestrado_32_2 ;
   private String edtLSD4CodigoSiniestrado_32_2_Jsonclick ;
   private String edtLSD4CodigoLocalidad_34_2_Internalname ;
   private String A1688LSD4CodigoLocalidad_34_2 ;
   private String edtLSD4CodigoLocalidad_34_2_Jsonclick ;
   private String edtLSD4SituacionRevista1_36_2_Internalname ;
   private String A1689LSD4SituacionRevista1_36_2 ;
   private String edtLSD4SituacionRevista1_36_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista1_Internalname ;
   private String A1690LSD4DiaInicioSituacionRevista1 ;
   private String edtLSD4DiaInicioSituacionRevista1_Jsonclick ;
   private String edtLSD4SituacionRevista2_40_2_Internalname ;
   private String A1691LSD4SituacionRevista2_40_2 ;
   private String edtLSD4SituacionRevista2_40_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista2_Internalname ;
   private String A1692LSD4DiaInicioSituacionRevista2 ;
   private String edtLSD4DiaInicioSituacionRevista2_Jsonclick ;
   private String edtLSD4SituacionRevista3_44_2_Internalname ;
   private String A1693LSD4SituacionRevista3_44_2 ;
   private String edtLSD4SituacionRevista3_44_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista3_Internalname ;
   private String A1694LSD4DiaInicioSituacionRevista3 ;
   private String edtLSD4DiaInicioSituacionRevista3_Jsonclick ;
   private String edtLSD4CantidadDiasTrabajados_48__Internalname ;
   private String edtLSD4CantidadDiasTrabajados_48__Jsonclick ;
   private String edtLSD4HorasTrabajadas_50_3_Internalname ;
   private String edtLSD4HorasTrabajadas_50_3_Jsonclick ;
   private String edtLSD4PorcentajeAporteAdicionalS_Internalname ;
   private String edtLSD4PorcentajeAporteAdicionalS_Jsonclick ;
   private String edtLSD4ContribucionTareaDiferenci_Internalname ;
   private String edtLSD4ContribucionTareaDiferenci_Jsonclick ;
   private String edtLSD4CodigoObraSocial_63_6_Internalname ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private String edtLSD4CodigoObraSocial_63_6_Jsonclick ;
   private String edtLSD4CantidadAdherentes_69_2_Internalname ;
   private String edtLSD4CantidadAdherentes_69_2_Jsonclick ;
   private String edtLSD4AporteAdicionalOS_71_15_Internalname ;
   private String edtLSD4AporteAdicionalOS_71_15_Jsonclick ;
   private String edtLSD4ContribucionAdicionalOS_86_Internalname ;
   private String edtLSD4ContribucionAdicionalOS_86_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialApor_Internalname ;
   private String edtLSD4BaseCalculoDiferencialApor_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Internalname ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialLRT__Internalname ;
   private String edtLSD4BaseCalculoDiferencialLRT__Jsonclick ;
   private String edtLSD4RemuneracionMaternidadANSe_Internalname ;
   private String edtLSD4RemuneracionMaternidadANSe_Jsonclick ;
   private String edtLSD4RemuneracionBruta_161_15_Internalname ;
   private String edtLSD4RemuneracionBruta_161_15_Jsonclick ;
   private String edtLSD4BaseImponible1_176_15_Internalname ;
   private String edtLSD4BaseImponible1_176_15_Jsonclick ;
   private String edtLSD4BaseImponible2_191_15_Internalname ;
   private String edtLSD4BaseImponible2_191_15_Jsonclick ;
   private String edtLSD4BaseImponible3_206_15_Internalname ;
   private String edtLSD4BaseImponible3_206_15_Jsonclick ;
   private String edtLSD4BaseImponible4_221_15_Internalname ;
   private String edtLSD4BaseImponible4_221_15_Jsonclick ;
   private String edtLSD4BaseImponible5_236_15_Internalname ;
   private String edtLSD4BaseImponible5_236_15_Jsonclick ;
   private String edtLSD4BaseImponible6_251_15_Internalname ;
   private String edtLSD4BaseImponible6_251_15_Jsonclick ;
   private String edtLSD4BaseImponible7_266_15_Internalname ;
   private String edtLSD4BaseImponible7_266_15_Jsonclick ;
   private String edtLSD4BaseImponible8_281_15_Internalname ;
   private String edtLSD4BaseImponible8_281_15_Jsonclick ;
   private String edtLSD4BaseImponible9_296_15_Internalname ;
   private String edtLSD4BaseImponible9_296_15_Jsonclick ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Internalname ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Jsonclick ;
   private String edtLSD4BaseDifContSegSoc_326_15_Internalname ;
   private String edtLSD4BaseDifContSegSoc_326_15_Jsonclick ;
   private String edtLSD4BaseImponible10_341_15_Internalname ;
   private String edtLSD4BaseImponible10_341_15_Jsonclick ;
   private String edtLSD4ImporteADetraer_356_15_Internalname ;
   private String edtLSD4ImporteADetraer_356_15_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLSDSec_Internalname ;
   private String edtLSDSec_Jsonclick ;
   private String edtLSD2Sec_Internalname ;
   private String edtLSD2Sec_Jsonclick ;
   private String edtLSD4Sec_Internalname ;
   private String edtLSD4Sec_Jsonclick ;
   private String AV17Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode232 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
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
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T004Y5_A1674LSD4Sec ;
   private long[] T004Y5_A1675LSD4CUIL_3_11 ;
   private String[] T004Y5_A1676LSD4Conyuge_14_1 ;
   private byte[] T004Y5_A1677LSD4CantidadHijos_15_2 ;
   private String[] T004Y5_A1678LSD4MarcaCCT_17_1 ;
   private String[] T004Y5_A1679LSD4MarcaSCVO_18_1 ;
   private String[] T004Y5_A1680LSD4MarcaReduccion_19_1 ;
   private String[] T004Y5_A1681LSD4TipoEmpresa_20_1 ;
   private String[] T004Y5_A1682LSD4TipoOperacion_21_1 ;
   private String[] T004Y5_A1683LSD4CodigoSituacion_22_2 ;
   private String[] T004Y5_A1684LSD4CodigoCondicion_24_2 ;
   private String[] T004Y5_A1685LSD4CodigoActividad_26_3 ;
   private String[] T004Y5_A1686LSD4CodigoModalidadContratacio ;
   private String[] T004Y5_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] T004Y5_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] T004Y5_A1689LSD4SituacionRevista1_36_2 ;
   private String[] T004Y5_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] T004Y5_A1691LSD4SituacionRevista2_40_2 ;
   private String[] T004Y5_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] T004Y5_A1693LSD4SituacionRevista3_44_2 ;
   private String[] T004Y5_A1694LSD4DiaInicioSituacionRevista3 ;
   private byte[] T004Y5_A1695LSD4CantidadDiasTrabajados_48_ ;
   private short[] T004Y5_A1696LSD4HorasTrabajadas_50_3 ;
   private java.math.BigDecimal[] T004Y5_A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal[] T004Y5_A1698LSD4ContribucionTareaDiferenci ;
   private String[] T004Y5_A1699LSD4CodigoObraSocial_63_6 ;
   private byte[] T004Y5_A1700LSD4CantidadAdherentes_69_2 ;
   private java.math.BigDecimal[] T004Y5_A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal[] T004Y5_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] T004Y5_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] T004Y5_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] T004Y5_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] T004Y5_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] T004Y5_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] T004Y5_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] T004Y5_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] T004Y5_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] T004Y5_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] T004Y5_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] T004Y5_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] T004Y5_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] T004Y5_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] T004Y5_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] T004Y5_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] T004Y5_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] T004Y5_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] T004Y5_A1720LSD4ImporteADetraer_356_15 ;
   private int[] T004Y5_A3CliCod ;
   private short[] T004Y5_A1EmpCod ;
   private int[] T004Y5_A1649LSDSec ;
   private int[] T004Y5_A1657LSD2Sec ;
   private int[] T004Y4_A3CliCod ;
   private int[] T004Y6_A3CliCod ;
   private int[] T004Y7_A3CliCod ;
   private short[] T004Y7_A1EmpCod ;
   private int[] T004Y7_A1649LSDSec ;
   private int[] T004Y7_A1657LSD2Sec ;
   private short[] T004Y7_A1674LSD4Sec ;
   private short[] T004Y3_A1674LSD4Sec ;
   private long[] T004Y3_A1675LSD4CUIL_3_11 ;
   private String[] T004Y3_A1676LSD4Conyuge_14_1 ;
   private byte[] T004Y3_A1677LSD4CantidadHijos_15_2 ;
   private String[] T004Y3_A1678LSD4MarcaCCT_17_1 ;
   private String[] T004Y3_A1679LSD4MarcaSCVO_18_1 ;
   private String[] T004Y3_A1680LSD4MarcaReduccion_19_1 ;
   private String[] T004Y3_A1681LSD4TipoEmpresa_20_1 ;
   private String[] T004Y3_A1682LSD4TipoOperacion_21_1 ;
   private String[] T004Y3_A1683LSD4CodigoSituacion_22_2 ;
   private String[] T004Y3_A1684LSD4CodigoCondicion_24_2 ;
   private String[] T004Y3_A1685LSD4CodigoActividad_26_3 ;
   private String[] T004Y3_A1686LSD4CodigoModalidadContratacio ;
   private String[] T004Y3_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] T004Y3_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] T004Y3_A1689LSD4SituacionRevista1_36_2 ;
   private String[] T004Y3_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] T004Y3_A1691LSD4SituacionRevista2_40_2 ;
   private String[] T004Y3_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] T004Y3_A1693LSD4SituacionRevista3_44_2 ;
   private String[] T004Y3_A1694LSD4DiaInicioSituacionRevista3 ;
   private byte[] T004Y3_A1695LSD4CantidadDiasTrabajados_48_ ;
   private short[] T004Y3_A1696LSD4HorasTrabajadas_50_3 ;
   private java.math.BigDecimal[] T004Y3_A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal[] T004Y3_A1698LSD4ContribucionTareaDiferenci ;
   private String[] T004Y3_A1699LSD4CodigoObraSocial_63_6 ;
   private byte[] T004Y3_A1700LSD4CantidadAdherentes_69_2 ;
   private java.math.BigDecimal[] T004Y3_A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal[] T004Y3_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] T004Y3_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] T004Y3_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] T004Y3_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] T004Y3_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] T004Y3_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] T004Y3_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] T004Y3_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] T004Y3_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] T004Y3_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] T004Y3_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] T004Y3_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] T004Y3_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] T004Y3_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] T004Y3_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] T004Y3_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] T004Y3_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] T004Y3_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] T004Y3_A1720LSD4ImporteADetraer_356_15 ;
   private int[] T004Y3_A3CliCod ;
   private short[] T004Y3_A1EmpCod ;
   private int[] T004Y3_A1649LSDSec ;
   private int[] T004Y3_A1657LSD2Sec ;
   private int[] T004Y8_A3CliCod ;
   private short[] T004Y8_A1EmpCod ;
   private int[] T004Y8_A1649LSDSec ;
   private int[] T004Y8_A1657LSD2Sec ;
   private short[] T004Y8_A1674LSD4Sec ;
   private int[] T004Y9_A3CliCod ;
   private short[] T004Y9_A1EmpCod ;
   private int[] T004Y9_A1649LSDSec ;
   private int[] T004Y9_A1657LSD2Sec ;
   private short[] T004Y9_A1674LSD4Sec ;
   private short[] T004Y2_A1674LSD4Sec ;
   private long[] T004Y2_A1675LSD4CUIL_3_11 ;
   private String[] T004Y2_A1676LSD4Conyuge_14_1 ;
   private byte[] T004Y2_A1677LSD4CantidadHijos_15_2 ;
   private String[] T004Y2_A1678LSD4MarcaCCT_17_1 ;
   private String[] T004Y2_A1679LSD4MarcaSCVO_18_1 ;
   private String[] T004Y2_A1680LSD4MarcaReduccion_19_1 ;
   private String[] T004Y2_A1681LSD4TipoEmpresa_20_1 ;
   private String[] T004Y2_A1682LSD4TipoOperacion_21_1 ;
   private String[] T004Y2_A1683LSD4CodigoSituacion_22_2 ;
   private String[] T004Y2_A1684LSD4CodigoCondicion_24_2 ;
   private String[] T004Y2_A1685LSD4CodigoActividad_26_3 ;
   private String[] T004Y2_A1686LSD4CodigoModalidadContratacio ;
   private String[] T004Y2_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] T004Y2_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] T004Y2_A1689LSD4SituacionRevista1_36_2 ;
   private String[] T004Y2_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] T004Y2_A1691LSD4SituacionRevista2_40_2 ;
   private String[] T004Y2_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] T004Y2_A1693LSD4SituacionRevista3_44_2 ;
   private String[] T004Y2_A1694LSD4DiaInicioSituacionRevista3 ;
   private byte[] T004Y2_A1695LSD4CantidadDiasTrabajados_48_ ;
   private short[] T004Y2_A1696LSD4HorasTrabajadas_50_3 ;
   private java.math.BigDecimal[] T004Y2_A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal[] T004Y2_A1698LSD4ContribucionTareaDiferenci ;
   private String[] T004Y2_A1699LSD4CodigoObraSocial_63_6 ;
   private byte[] T004Y2_A1700LSD4CantidadAdherentes_69_2 ;
   private java.math.BigDecimal[] T004Y2_A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal[] T004Y2_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] T004Y2_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] T004Y2_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] T004Y2_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] T004Y2_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] T004Y2_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] T004Y2_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] T004Y2_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] T004Y2_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] T004Y2_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] T004Y2_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] T004Y2_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] T004Y2_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] T004Y2_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] T004Y2_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] T004Y2_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] T004Y2_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] T004Y2_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] T004Y2_A1720LSD4ImporteADetraer_356_15 ;
   private int[] T004Y2_A3CliCod ;
   private short[] T004Y2_A1EmpCod ;
   private int[] T004Y2_A1649LSDSec ;
   private int[] T004Y2_A1657LSD2Sec ;
   private int[] T004Y13_A3CliCod ;
   private short[] T004Y13_A1EmpCod ;
   private int[] T004Y13_A1649LSDSec ;
   private int[] T004Y13_A1657LSD2Sec ;
   private short[] T004Y13_A1674LSD4Sec ;
   private int[] T004Y14_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class lsd_reg4__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004Y2", "SELECT LSD4Sec, LSD4CUIL_3_11, LSD4Conyuge_14_1, LSD4CantidadHijos_15_2, LSD4MarcaCCT_17_1, LSD4MarcaSCVO_18_1, LSD4MarcaReduccion_19_1, LSD4TipoEmpresa_20_1, LSD4TipoOperacion_21_1, LSD4CodigoSituacion_22_2, LSD4CodigoCondicion_24_2, LSD4CodigoActividad_26_3, LSD4CodigoModalidadContratacio, LSD4CodigoSiniestrado_32_2, LSD4CodigoLocalidad_34_2, LSD4SituacionRevista1_36_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista3, LSD4CantidadDiasTrabajados_48_, LSD4HorasTrabajadas_50_3, LSD4PorcentajeAporteAdicionalS, LSD4ContribucionTareaDiferenci, LSD4CodigoObraSocial_63_6, LSD4CantidadAdherentes_69_2, LSD4AporteAdicionalOS_71_15, LSD4ContribucionAdicionalOS_86, LSD4BaseCalculoDiferencialApor, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialLRT_, LSD4RemuneracionMaternidadANSe, LSD4RemuneracionBruta_161_15, LSD4BaseImponible1_176_15, LSD4BaseImponible2_191_15, LSD4BaseImponible3_206_15, LSD4BaseImponible4_221_15, LSD4BaseImponible5_236_15, LSD4BaseImponible6_251_15, LSD4BaseImponible7_266_15, LSD4BaseImponible8_281_15, LSD4BaseImponible9_296_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseImponible10_341_15, LSD4ImporteADetraer_356_15, CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg4 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ?  FOR UPDATE OF LSD_reg4 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y3", "SELECT LSD4Sec, LSD4CUIL_3_11, LSD4Conyuge_14_1, LSD4CantidadHijos_15_2, LSD4MarcaCCT_17_1, LSD4MarcaSCVO_18_1, LSD4MarcaReduccion_19_1, LSD4TipoEmpresa_20_1, LSD4TipoOperacion_21_1, LSD4CodigoSituacion_22_2, LSD4CodigoCondicion_24_2, LSD4CodigoActividad_26_3, LSD4CodigoModalidadContratacio, LSD4CodigoSiniestrado_32_2, LSD4CodigoLocalidad_34_2, LSD4SituacionRevista1_36_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista3, LSD4CantidadDiasTrabajados_48_, LSD4HorasTrabajadas_50_3, LSD4PorcentajeAporteAdicionalS, LSD4ContribucionTareaDiferenci, LSD4CodigoObraSocial_63_6, LSD4CantidadAdherentes_69_2, LSD4AporteAdicionalOS_71_15, LSD4ContribucionAdicionalOS_86, LSD4BaseCalculoDiferencialApor, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialLRT_, LSD4RemuneracionMaternidadANSe, LSD4RemuneracionBruta_161_15, LSD4BaseImponible1_176_15, LSD4BaseImponible2_191_15, LSD4BaseImponible3_206_15, LSD4BaseImponible4_221_15, LSD4BaseImponible5_236_15, LSD4BaseImponible6_251_15, LSD4BaseImponible7_266_15, LSD4BaseImponible8_281_15, LSD4BaseImponible9_296_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseImponible10_341_15, LSD4ImporteADetraer_356_15, CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg4 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y4", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y5", "SELECT TM1.LSD4Sec, TM1.LSD4CUIL_3_11, TM1.LSD4Conyuge_14_1, TM1.LSD4CantidadHijos_15_2, TM1.LSD4MarcaCCT_17_1, TM1.LSD4MarcaSCVO_18_1, TM1.LSD4MarcaReduccion_19_1, TM1.LSD4TipoEmpresa_20_1, TM1.LSD4TipoOperacion_21_1, TM1.LSD4CodigoSituacion_22_2, TM1.LSD4CodigoCondicion_24_2, TM1.LSD4CodigoActividad_26_3, TM1.LSD4CodigoModalidadContratacio, TM1.LSD4CodigoSiniestrado_32_2, TM1.LSD4CodigoLocalidad_34_2, TM1.LSD4SituacionRevista1_36_2, TM1.LSD4DiaInicioSituacionRevista1, TM1.LSD4SituacionRevista2_40_2, TM1.LSD4DiaInicioSituacionRevista2, TM1.LSD4SituacionRevista3_44_2, TM1.LSD4DiaInicioSituacionRevista3, TM1.LSD4CantidadDiasTrabajados_48_, TM1.LSD4HorasTrabajadas_50_3, TM1.LSD4PorcentajeAporteAdicionalS, TM1.LSD4ContribucionTareaDiferenci, TM1.LSD4CodigoObraSocial_63_6, TM1.LSD4CantidadAdherentes_69_2, TM1.LSD4AporteAdicionalOS_71_15, TM1.LSD4ContribucionAdicionalOS_86, TM1.LSD4BaseCalculoDiferencialApor, TM1.LSD4BaseCalculoDiferencialOSyF, TM1.LSD4BaseCalculoDiferencialLRT_, TM1.LSD4RemuneracionMaternidadANSe, TM1.LSD4RemuneracionBruta_161_15, TM1.LSD4BaseImponible1_176_15, TM1.LSD4BaseImponible2_191_15, TM1.LSD4BaseImponible3_206_15, TM1.LSD4BaseImponible4_221_15, TM1.LSD4BaseImponible5_236_15, TM1.LSD4BaseImponible6_251_15, TM1.LSD4BaseImponible7_266_15, TM1.LSD4BaseImponible8_281_15, TM1.LSD4BaseImponible9_296_15, TM1.LSD4BaseDifApoSegSoc_311_15, TM1.LSD4BaseDifContSegSoc_326_15, TM1.LSD4BaseImponible10_341_15, TM1.LSD4ImporteADetraer_356_15, TM1.CliCod, TM1.EmpCod, TM1.LSDSec, TM1.LSD2Sec FROM LSD_reg4 TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LSDSec = ? and TM1.LSD2Sec = ? and TM1.LSD4Sec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LSDSec, TM1.LSD2Sec, TM1.LSD4Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y6", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y7", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y8", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LSDSec > ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec > ? or LSD2Sec = ? and LSDSec = ? and EmpCod = ? and CliCod = ? and LSD4Sec > ?) ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004Y9", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LSDSec < ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec < ? or LSD2Sec = ? and LSDSec = ? and EmpCod = ? and CliCod = ? and LSD4Sec < ?) ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4Sec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004Y10", "SAVEPOINT gxupdate;INSERT INTO LSD_reg4(LSD4Sec, LSD4CUIL_3_11, LSD4Conyuge_14_1, LSD4CantidadHijos_15_2, LSD4MarcaCCT_17_1, LSD4MarcaSCVO_18_1, LSD4MarcaReduccion_19_1, LSD4TipoEmpresa_20_1, LSD4TipoOperacion_21_1, LSD4CodigoSituacion_22_2, LSD4CodigoCondicion_24_2, LSD4CodigoActividad_26_3, LSD4CodigoModalidadContratacio, LSD4CodigoSiniestrado_32_2, LSD4CodigoLocalidad_34_2, LSD4SituacionRevista1_36_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista3, LSD4CantidadDiasTrabajados_48_, LSD4HorasTrabajadas_50_3, LSD4PorcentajeAporteAdicionalS, LSD4ContribucionTareaDiferenci, LSD4CodigoObraSocial_63_6, LSD4CantidadAdherentes_69_2, LSD4AporteAdicionalOS_71_15, LSD4ContribucionAdicionalOS_86, LSD4BaseCalculoDiferencialApor, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialLRT_, LSD4RemuneracionMaternidadANSe, LSD4RemuneracionBruta_161_15, LSD4BaseImponible1_176_15, LSD4BaseImponible2_191_15, LSD4BaseImponible3_206_15, LSD4BaseImponible4_221_15, LSD4BaseImponible5_236_15, LSD4BaseImponible6_251_15, LSD4BaseImponible7_266_15, LSD4BaseImponible8_281_15, LSD4BaseImponible9_296_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseImponible10_341_15, LSD4ImporteADetraer_356_15, CliCod, EmpCod, LSDSec, LSD2Sec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004Y11", "SAVEPOINT gxupdate;UPDATE LSD_reg4 SET LSD4CUIL_3_11=?, LSD4Conyuge_14_1=?, LSD4CantidadHijos_15_2=?, LSD4MarcaCCT_17_1=?, LSD4MarcaSCVO_18_1=?, LSD4MarcaReduccion_19_1=?, LSD4TipoEmpresa_20_1=?, LSD4TipoOperacion_21_1=?, LSD4CodigoSituacion_22_2=?, LSD4CodigoCondicion_24_2=?, LSD4CodigoActividad_26_3=?, LSD4CodigoModalidadContratacio=?, LSD4CodigoSiniestrado_32_2=?, LSD4CodigoLocalidad_34_2=?, LSD4SituacionRevista1_36_2=?, LSD4DiaInicioSituacionRevista1=?, LSD4SituacionRevista2_40_2=?, LSD4DiaInicioSituacionRevista2=?, LSD4SituacionRevista3_44_2=?, LSD4DiaInicioSituacionRevista3=?, LSD4CantidadDiasTrabajados_48_=?, LSD4HorasTrabajadas_50_3=?, LSD4PorcentajeAporteAdicionalS=?, LSD4ContribucionTareaDiferenci=?, LSD4CodigoObraSocial_63_6=?, LSD4CantidadAdherentes_69_2=?, LSD4AporteAdicionalOS_71_15=?, LSD4ContribucionAdicionalOS_86=?, LSD4BaseCalculoDiferencialApor=?, LSD4BaseCalculoDiferencialOSyF=?, LSD4BaseCalculoDiferencialLRT_=?, LSD4RemuneracionMaternidadANSe=?, LSD4RemuneracionBruta_161_15=?, LSD4BaseImponible1_176_15=?, LSD4BaseImponible2_191_15=?, LSD4BaseImponible3_206_15=?, LSD4BaseImponible4_221_15=?, LSD4BaseImponible5_236_15=?, LSD4BaseImponible6_251_15=?, LSD4BaseImponible7_266_15=?, LSD4BaseImponible8_281_15=?, LSD4BaseImponible9_296_15=?, LSD4BaseDifApoSegSoc_311_15=?, LSD4BaseDifContSegSoc_326_15=?, LSD4BaseImponible10_341_15=?, LSD4ImporteADetraer_356_15=?  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004Y12", "SAVEPOINT gxupdate;DELETE FROM LSD_reg4  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004Y13", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004Y14", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               ((String[]) buf[10])[0] = rslt.getString(11, 2);
               ((String[]) buf[11])[0] = rslt.getString(12, 3);
               ((String[]) buf[12])[0] = rslt.getString(13, 3);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 2);
               ((String[]) buf[15])[0] = rslt.getString(16, 2);
               ((String[]) buf[16])[0] = rslt.getString(17, 2);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getString(19, 2);
               ((String[]) buf[19])[0] = rslt.getString(20, 2);
               ((String[]) buf[20])[0] = rslt.getString(21, 2);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(29,2);
               ((java.math.BigDecimal[]) buf[29])[0] = rslt.getBigDecimal(30,2);
               ((java.math.BigDecimal[]) buf[30])[0] = rslt.getBigDecimal(31,2);
               ((java.math.BigDecimal[]) buf[31])[0] = rslt.getBigDecimal(32,2);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(33,2);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(36,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(39,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(40,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(41,2);
               ((java.math.BigDecimal[]) buf[41])[0] = rslt.getBigDecimal(42,2);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(43,2);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(44,2);
               ((java.math.BigDecimal[]) buf[44])[0] = rslt.getBigDecimal(45,2);
               ((java.math.BigDecimal[]) buf[45])[0] = rslt.getBigDecimal(46,2);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(47,2);
               ((int[]) buf[47])[0] = rslt.getInt(48);
               ((short[]) buf[48])[0] = rslt.getShort(49);
               ((int[]) buf[49])[0] = rslt.getInt(50);
               ((int[]) buf[50])[0] = rslt.getInt(51);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               ((String[]) buf[10])[0] = rslt.getString(11, 2);
               ((String[]) buf[11])[0] = rslt.getString(12, 3);
               ((String[]) buf[12])[0] = rslt.getString(13, 3);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 2);
               ((String[]) buf[15])[0] = rslt.getString(16, 2);
               ((String[]) buf[16])[0] = rslt.getString(17, 2);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getString(19, 2);
               ((String[]) buf[19])[0] = rslt.getString(20, 2);
               ((String[]) buf[20])[0] = rslt.getString(21, 2);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(29,2);
               ((java.math.BigDecimal[]) buf[29])[0] = rslt.getBigDecimal(30,2);
               ((java.math.BigDecimal[]) buf[30])[0] = rslt.getBigDecimal(31,2);
               ((java.math.BigDecimal[]) buf[31])[0] = rslt.getBigDecimal(32,2);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(33,2);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(36,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(39,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(40,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(41,2);
               ((java.math.BigDecimal[]) buf[41])[0] = rslt.getBigDecimal(42,2);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(43,2);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(44,2);
               ((java.math.BigDecimal[]) buf[44])[0] = rslt.getBigDecimal(45,2);
               ((java.math.BigDecimal[]) buf[45])[0] = rslt.getBigDecimal(46,2);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(47,2);
               ((int[]) buf[47])[0] = rslt.getInt(48);
               ((short[]) buf[48])[0] = rslt.getShort(49);
               ((int[]) buf[49])[0] = rslt.getInt(50);
               ((int[]) buf[50])[0] = rslt.getInt(51);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               ((String[]) buf[10])[0] = rslt.getString(11, 2);
               ((String[]) buf[11])[0] = rslt.getString(12, 3);
               ((String[]) buf[12])[0] = rslt.getString(13, 3);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 2);
               ((String[]) buf[15])[0] = rslt.getString(16, 2);
               ((String[]) buf[16])[0] = rslt.getString(17, 2);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getString(19, 2);
               ((String[]) buf[19])[0] = rslt.getString(20, 2);
               ((String[]) buf[20])[0] = rslt.getString(21, 2);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(29,2);
               ((java.math.BigDecimal[]) buf[29])[0] = rslt.getBigDecimal(30,2);
               ((java.math.BigDecimal[]) buf[30])[0] = rslt.getBigDecimal(31,2);
               ((java.math.BigDecimal[]) buf[31])[0] = rslt.getBigDecimal(32,2);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(33,2);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(36,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(39,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(40,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(41,2);
               ((java.math.BigDecimal[]) buf[41])[0] = rslt.getBigDecimal(42,2);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(43,2);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(44,2);
               ((java.math.BigDecimal[]) buf[44])[0] = rslt.getBigDecimal(45,2);
               ((java.math.BigDecimal[]) buf[45])[0] = rslt.getBigDecimal(46,2);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(47,2);
               ((int[]) buf[47])[0] = rslt.getInt(48);
               ((short[]) buf[48])[0] = rslt.getShort(49);
               ((int[]) buf[49])[0] = rslt.getInt(50);
               ((int[]) buf[50])[0] = rslt.getInt(51);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 12 :
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 2);
               stmt.setString(11, (String)parms[10], 2);
               stmt.setString(12, (String)parms[11], 3);
               stmt.setString(13, (String)parms[12], 3);
               stmt.setString(14, (String)parms[13], 2);
               stmt.setString(15, (String)parms[14], 2);
               stmt.setString(16, (String)parms[15], 2);
               stmt.setString(17, (String)parms[16], 2);
               stmt.setString(18, (String)parms[17], 2);
               stmt.setString(19, (String)parms[18], 2);
               stmt.setString(20, (String)parms[19], 2);
               stmt.setString(21, (String)parms[20], 2);
               stmt.setByte(22, ((Number) parms[21]).byteValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setString(26, (String)parms[25], 6);
               stmt.setByte(27, ((Number) parms[26]).byteValue());
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[28], 2);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[29], 2);
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[30], 2);
               stmt.setBigDecimal(32, (java.math.BigDecimal)parms[31], 2);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[32], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[33], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(38, (java.math.BigDecimal)parms[37], 2);
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[38], 2);
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[39], 2);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[40], 2);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[41], 2);
               stmt.setBigDecimal(43, (java.math.BigDecimal)parms[42], 2);
               stmt.setBigDecimal(44, (java.math.BigDecimal)parms[43], 2);
               stmt.setBigDecimal(45, (java.math.BigDecimal)parms[44], 2);
               stmt.setBigDecimal(46, (java.math.BigDecimal)parms[45], 2);
               stmt.setBigDecimal(47, (java.math.BigDecimal)parms[46], 2);
               stmt.setInt(48, ((Number) parms[47]).intValue());
               stmt.setShort(49, ((Number) parms[48]).shortValue());
               stmt.setInt(50, ((Number) parms[49]).intValue());
               stmt.setInt(51, ((Number) parms[50]).intValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 1);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setString(9, (String)parms[8], 2);
               stmt.setString(10, (String)parms[9], 2);
               stmt.setString(11, (String)parms[10], 3);
               stmt.setString(12, (String)parms[11], 3);
               stmt.setString(13, (String)parms[12], 2);
               stmt.setString(14, (String)parms[13], 2);
               stmt.setString(15, (String)parms[14], 2);
               stmt.setString(16, (String)parms[15], 2);
               stmt.setString(17, (String)parms[16], 2);
               stmt.setString(18, (String)parms[17], 2);
               stmt.setString(19, (String)parms[18], 2);
               stmt.setString(20, (String)parms[19], 2);
               stmt.setByte(21, ((Number) parms[20]).byteValue());
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setString(25, (String)parms[24], 6);
               stmt.setByte(26, ((Number) parms[25]).byteValue());
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[28], 2);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[29], 2);
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[30], 2);
               stmt.setBigDecimal(32, (java.math.BigDecimal)parms[31], 2);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[32], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[33], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(38, (java.math.BigDecimal)parms[37], 2);
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[38], 2);
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[39], 2);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[40], 2);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[41], 2);
               stmt.setBigDecimal(43, (java.math.BigDecimal)parms[42], 2);
               stmt.setBigDecimal(44, (java.math.BigDecimal)parms[43], 2);
               stmt.setBigDecimal(45, (java.math.BigDecimal)parms[44], 2);
               stmt.setBigDecimal(46, (java.math.BigDecimal)parms[45], 2);
               stmt.setInt(47, ((Number) parms[46]).intValue());
               stmt.setShort(48, ((Number) parms[47]).shortValue());
               stmt.setInt(49, ((Number) parms[48]).intValue());
               stmt.setInt(50, ((Number) parms[49]).intValue());
               stmt.setShort(51, ((Number) parms[50]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

