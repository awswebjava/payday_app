package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variable_listar_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action21") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1895VarRelSec = (int)(GXutil.lval( httpContext.GetPar( "VarRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_21_5I71( Gx_mode, AV7CliCod, A1895VarRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"VARRELSEC") == 0 )
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
         gxdlavarrelsec5I71( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"VARFECPROX") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asavarfecprox5I71( A3CliCod, A82OpeCliId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"OPECLIULTVAL") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaopecliultval5I71( A3CliCod, A82OpeCliId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
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
         gx3asaclicod5I71( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel7"+"_"+"") == 0 )
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
         gxasa21295I71( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A3CliCod) ;
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
            AV8OpeCliId = httpContext.GetPar( "OpeCliId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8OpeCliId", AV8OpeCliId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8OpeCliId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Variable_listar", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public variable_listar_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variable_listar_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_listar_impl.class ));
   }

   public variable_listar_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkOpeCliEsCant = UIFactory.getCheckbox(this);
      chkOpeCliAliEs = UIFactory.getCheckbox(this);
      chkVarActObl = UIFactory.getCheckbox(this);
      dynVarRelSec = new HTMLChoice();
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
      A931OpeCliEsCant = GXutil.strtobool( GXutil.booltostr( A931OpeCliEsCant)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
      A934OpeCliAliEs = GXutil.strtobool( GXutil.booltostr( A934OpeCliAliEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
      A2129VarActObl = GXutil.strtobool( GXutil.booltostr( A2129VarActObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
      if ( dynVarRelSec.getItemCount() > 0 )
      {
         A1895VarRelSec = (int)(GXutil.lval( dynVarRelSec.getValidValue(GXutil.trim( GXutil.str( A1895VarRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynVarRelSec.setValue( GXutil.trim( GXutil.str( A1895VarRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynVarRelSec.getInternalname(), "Values", dynVarRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliId_Internalname, httpContext.getMessage( "Id. de variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliId_Internalname, GXutil.rtrim( A82OpeCliId), GXutil.rtrim( localUtil.format( A82OpeCliId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOpeCliId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliCodFormula_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliCodFormula_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliCodFormula_Internalname, GXutil.rtrim( A549OpeCliCodFormula), GXutil.rtrim( localUtil.format( A549OpeCliCodFormula, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliCodFormula_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOpeCliCodFormula_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOpeCliDescrip_Internalname, A534OpeCliDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtOpeCliDescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeCliEsCant.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOpeCliEsCant.getInternalname(), httpContext.getMessage( "Es cantidad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeCliEsCant.getInternalname(), GXutil.booltostr( A931OpeCliEsCant), "", httpContext.getMessage( "Es cantidad", ""), 1, chkOpeCliEsCant.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeCliAliEs.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOpeCliAliEs.getInternalname(), httpContext.getMessage( "Es alicuota", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeCliAliEs.getInternalname(), GXutil.booltostr( A934OpeCliAliEs), "", httpContext.getMessage( "Es alicuota", ""), 1, chkOpeCliAliEs.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVarFrecAct_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtVarFrecAct_Internalname, httpContext.getMessage( "Frecuencia de actualización (meses)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtVarFrecAct_Internalname, GXutil.ltrim( localUtil.ntoc( A1913VarFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1913VarFrecAct), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVarFrecAct_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVarFrecAct_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divVaractobl_cell_Internalname, 1, 0, "px", 0, "px", divVaractobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkVarActObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkVarActObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkVarActObl.getInternalname(), httpContext.getMessage( "Actualización obligatoria", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkVarActObl.getInternalname(), GXutil.booltostr( A2129VarActObl), "", httpContext.getMessage( "Actualización obligatoria", ""), chkVarActObl.getVisible(), chkVarActObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(52, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,52);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divVarrelsec_cell_Internalname, 1, 0, "px", 0, "px", divVarrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynVarRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynVarRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynVarRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynVarRelSec, dynVarRelSec.getInternalname(), GXutil.trim( GXutil.str( A1895VarRelSec, 6, 0)), 1, dynVarRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynVarRelSec.getVisible(), dynVarRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_Variable_listar.htm");
      dynVarRelSec.setValue( GXutil.trim( GXutil.str( A1895VarRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynVarRelSec.getInternalname(), "Values", dynVarRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Variable_listar.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Variable_listar.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Variable_listar.htm");
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
      e115I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z82OpeCliId = httpContext.cgiGet( "Z82OpeCliId") ;
            Z1903ValRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1903ValRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z549OpeCliCodFormula = httpContext.cgiGet( "Z549OpeCliCodFormula") ;
            Z534OpeCliDescrip = httpContext.cgiGet( "Z534OpeCliDescrip") ;
            Z931OpeCliEsCant = GXutil.strtobool( httpContext.cgiGet( "Z931OpeCliEsCant")) ;
            Z934OpeCliAliEs = GXutil.strtobool( httpContext.cgiGet( "Z934OpeCliAliEs")) ;
            Z1895VarRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1895VarRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1906OpeCliIdPadre = httpContext.cgiGet( "Z1906OpeCliIdPadre") ;
            Z2011VarRelRef = httpContext.cgiGet( "Z2011VarRelRef") ;
            Z1913VarFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1913VarFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2129VarActObl = GXutil.strtobool( httpContext.cgiGet( "Z2129VarActObl")) ;
            Z2140VarDetail = httpContext.cgiGet( "Z2140VarDetail") ;
            A1903ValRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1903ValRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1906OpeCliIdPadre = httpContext.cgiGet( "Z1906OpeCliIdPadre") ;
            A2011VarRelRef = httpContext.cgiGet( "Z2011VarRelRef") ;
            A2140VarDetail = httpContext.cgiGet( "Z2140VarDetail") ;
            O934OpeCliAliEs = GXutil.strtobool( httpContext.cgiGet( "O934OpeCliAliEs")) ;
            O931OpeCliEsCant = GXutil.strtobool( httpContext.cgiGet( "O931OpeCliEsCant")) ;
            O534OpeCliDescrip = httpContext.cgiGet( "O534OpeCliDescrip") ;
            O549OpeCliCodFormula = httpContext.cgiGet( "O549OpeCliCodFormula") ;
            O82OpeCliId = httpContext.cgiGet( "O82OpeCliId") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N549OpeCliCodFormula = httpContext.cgiGet( "N549OpeCliCodFormula") ;
            N534OpeCliDescrip = httpContext.cgiGet( "N534OpeCliDescrip") ;
            N931OpeCliEsCant = GXutil.strtobool( httpContext.cgiGet( "N931OpeCliEsCant")) ;
            N934OpeCliAliEs = GXutil.strtobool( httpContext.cgiGet( "N934OpeCliAliEs")) ;
            N1913VarFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "N1913VarFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1922VarFecProx = localUtil.ctod( httpContext.cgiGet( "VARFECPROX"), 0) ;
            A1828OpeCliUltVal = httpContext.cgiGet( "OPECLIULTVAL") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8OpeCliId = httpContext.cgiGet( "vOPECLIID") ;
            AV22esSistemaConceptosDefault = GXutil.strtobool( httpContext.cgiGet( "vESSISTEMACONCEPTOSDEFAULT")) ;
            AV21ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "vCLIENTECONVENIADOR")) ;
            A1903ValRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "VALRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1906OpeCliIdPadre = httpContext.cgiGet( "OPECLIIDPADRE") ;
            AV20aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2011VarRelRef = httpContext.cgiGet( "VARRELREF") ;
            A2025VarOld = httpContext.cgiGet( "VAROLD") ;
            A2139VarHelp = httpContext.cgiGet( "VARHELP") ;
            A2140VarDetail = httpContext.cgiGet( "VARDETAIL") ;
            AV23Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A82OpeCliId = httpContext.cgiGet( edtOpeCliId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            A549OpeCliCodFormula = httpContext.cgiGet( edtOpeCliCodFormula_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
            A534OpeCliDescrip = httpContext.cgiGet( edtOpeCliDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
            A931OpeCliEsCant = GXutil.strtobool( httpContext.cgiGet( chkOpeCliEsCant.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
            A934OpeCliAliEs = GXutil.strtobool( httpContext.cgiGet( chkOpeCliAliEs.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVarFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVarFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VARFRECACT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVarFrecAct_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1913VarFrecAct = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1913VarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1913VarFrecAct), 2, 0));
            }
            else
            {
               A1913VarFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( edtVarFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1913VarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1913VarFrecAct), 2, 0));
            }
            A2129VarActObl = GXutil.strtobool( httpContext.cgiGet( chkVarActObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
            dynVarRelSec.setValue( httpContext.cgiGet( dynVarRelSec.getInternalname()) );
            A1895VarRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynVarRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Variable_listar");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ValRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1903ValRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("OpeCliIdPadre", GXutil.rtrim( localUtil.format( A1906OpeCliIdPadre, "")));
            forbiddenHiddens.add("VarRelRef", GXutil.rtrim( localUtil.format( A2011VarRelRef, "")));
            forbiddenHiddens.add("VarDetail", GXutil.rtrim( localUtil.format( A2140VarDetail, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("variable_listar:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
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
                  sMode71 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode71 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound71 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5I0( ) ;
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
                        e115I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125I2 ();
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
         e125I2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5I71( ) ;
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
         disableAttributes5I71( ) ;
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

   public void confirm_5I0( )
   {
      beforeValidate5I71( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5I71( ) ;
         }
         else
         {
            checkExtendedTable5I71( ) ;
            closeExtendedTableCursors5I71( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5I0( )
   {
   }

   public void e115I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Insert", GXv_boolean3) ;
         variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Update", GXv_boolean3) ;
         variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar_Delete", GXv_boolean3) ;
         variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV23Pgmname))}, new String[] {"GxObject"}) );
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
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      GXt_boolean2 = AV22esSistemaConceptosDefault ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean3) ;
      variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV22esSistemaConceptosDefault = GXt_boolean2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22esSistemaConceptosDefault", AV22esSistemaConceptosDefault);
      GXv_boolean3[0] = AV21ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      variable_listar_impl.this.AV21ClienteConveniador = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ClienteConveniador", AV21ClienteConveniador);
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&&&CliCod ", "")+GXutil.trim( GXutil.str( AV7CliCod, 6, 0))+httpContext.getMessage( " &ClienteConveniador ", "")+GXutil.trim( GXutil.booltostr( AV21ClienteConveniador))+httpContext.getMessage( " &esSistemaConceptosDefault ", "")+GXutil.trim( GXutil.booltostr( AV22esSistemaConceptosDefault))) ;
   }

   public void e125I2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.variablegrabarrelref(remoteHandle, context).execute( A3CliCod, A82OpeCliId) ;
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
      divVaractobl_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divVaractobl_cell_Internalname, "Class", divVaractobl_cell_Class, true);
      divVarrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
   }

   public void zm5I71( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1903ValRelSecCli = T005I3_A1903ValRelSecCli[0] ;
            Z549OpeCliCodFormula = T005I3_A549OpeCliCodFormula[0] ;
            Z534OpeCliDescrip = T005I3_A534OpeCliDescrip[0] ;
            Z931OpeCliEsCant = T005I3_A931OpeCliEsCant[0] ;
            Z934OpeCliAliEs = T005I3_A934OpeCliAliEs[0] ;
            Z1895VarRelSec = T005I3_A1895VarRelSec[0] ;
            Z1906OpeCliIdPadre = T005I3_A1906OpeCliIdPadre[0] ;
            Z2011VarRelRef = T005I3_A2011VarRelRef[0] ;
            Z1913VarFrecAct = T005I3_A1913VarFrecAct[0] ;
            Z2129VarActObl = T005I3_A2129VarActObl[0] ;
            Z2140VarDetail = T005I3_A2140VarDetail[0] ;
         }
         else
         {
            Z1903ValRelSecCli = A1903ValRelSecCli ;
            Z549OpeCliCodFormula = A549OpeCliCodFormula ;
            Z534OpeCliDescrip = A534OpeCliDescrip ;
            Z931OpeCliEsCant = A931OpeCliEsCant ;
            Z934OpeCliAliEs = A934OpeCliAliEs ;
            Z1895VarRelSec = A1895VarRelSec ;
            Z1906OpeCliIdPadre = A1906OpeCliIdPadre ;
            Z2011VarRelRef = A2011VarRelRef ;
            Z1913VarFrecAct = A1913VarFrecAct ;
            Z2129VarActObl = A2129VarActObl ;
            Z2140VarDetail = A2140VarDetail ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z82OpeCliId = A82OpeCliId ;
         Z1903ValRelSecCli = A1903ValRelSecCli ;
         Z549OpeCliCodFormula = A549OpeCliCodFormula ;
         Z534OpeCliDescrip = A534OpeCliDescrip ;
         Z931OpeCliEsCant = A931OpeCliEsCant ;
         Z934OpeCliAliEs = A934OpeCliAliEs ;
         Z1895VarRelSec = A1895VarRelSec ;
         Z1906OpeCliIdPadre = A1906OpeCliIdPadre ;
         Z2011VarRelRef = A2011VarRelRef ;
         Z2025VarOld = A2025VarOld ;
         Z1913VarFrecAct = A1913VarFrecAct ;
         Z2129VarActObl = A2129VarActObl ;
         Z2139VarHelp = A2139VarHelp ;
         Z2140VarDetail = A2140VarDetail ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxavarrelsec_html5I71( AV7CliCod) ;
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
            variable_listar_impl.this.GXt_int4 = GXv_int5[0] ;
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
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkVarActObl.setVisible( (GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkVarActObl.getInternalname(), "Visible", GXutil.ltrimstr( chkVarActObl.getVisible(), 5, 0), true);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( GXt_boolean2 ) )
      {
         divVaractobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divVaractobl_cell_Internalname, "Class", divVaractobl_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( GXt_boolean2 )
         {
            divVaractobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divVaractobl_cell_Internalname, "Class", divVaractobl_cell_Class, true);
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         A82OpeCliId = AV8OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         edtOpeCliId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         edtOpeCliId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      dynVarRelSec.setVisible( (((AV22esSistemaConceptosDefault)||(AV21ClienteConveniador)) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynVarRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynVarRelSec.getVisible(), 5, 0), true);
   }

   public void standaloneModal( )
   {
      if ( isIns( )  || isUpd( )  )
      {
         A1903ValRelSecCli = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1903ValRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1903ValRelSecCli), 6, 0));
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
         AV23Pgmname = "Variable_listar" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
         GXt_date6 = A1922VarFecProx ;
         GXv_date7[0] = GXt_date6 ;
         new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
         variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
         A1922VarFecProx = GXt_date6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
         GXt_char8 = A1828OpeCliUltVal ;
         GXv_char9[0] = GXt_char8 ;
         new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
         variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
         A1828OpeCliUltVal = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
      }
   }

   public void load5I71( )
   {
      /* Using cursor T005I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound71 = (short)(1) ;
         A1903ValRelSecCli = T005I5_A1903ValRelSecCli[0] ;
         A549OpeCliCodFormula = T005I5_A549OpeCliCodFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
         A534OpeCliDescrip = T005I5_A534OpeCliDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
         A931OpeCliEsCant = T005I5_A931OpeCliEsCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
         A934OpeCliAliEs = T005I5_A934OpeCliAliEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
         A1895VarRelSec = T005I5_A1895VarRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
         A1906OpeCliIdPadre = T005I5_A1906OpeCliIdPadre[0] ;
         A2011VarRelRef = T005I5_A2011VarRelRef[0] ;
         A2025VarOld = T005I5_A2025VarOld[0] ;
         A1913VarFrecAct = T005I5_A1913VarFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1913VarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1913VarFrecAct), 2, 0));
         A2129VarActObl = T005I5_A2129VarActObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
         A2139VarHelp = T005I5_A2139VarHelp[0] ;
         A2140VarDetail = T005I5_A2140VarDetail[0] ;
         zm5I71( -28) ;
      }
      pr_default.close(3);
      onLoadActions5I71( ) ;
   }

   public void onLoadActions5I71( )
   {
      AV23Pgmname = "Variable_listar" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      GXt_date6 = A1922VarFecProx ;
      GXv_date7[0] = GXt_date6 ;
      new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
      variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
      A1922VarFecProx = GXt_date6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
      GXt_char8 = A1828OpeCliUltVal ;
      GXv_char9[0] = GXt_char8 ;
      new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
      variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
      A1828OpeCliUltVal = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
      if ( ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) ) )
      {
         divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
      }
      else
      {
         if ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) )
         {
            divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
         }
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtOpeCliCodFormula_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliCodFormula_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtOpeCliDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         chkOpeCliEsCant.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
      }
      else
      {
         chkOpeCliEsCant.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         chkOpeCliAliEs.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
      }
      else
      {
         chkOpeCliAliEs.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtVarFrecAct_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
      }
      else
      {
         edtVarFrecAct_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
      }
   }

   public void checkExtendedTable5I71( )
   {
      nIsDirty_71 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV23Pgmname = "Variable_listar" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV20aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1895VarRelSec, GXv_boolean3) ;
         variable_listar_impl.this.AV20aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20aplicadoHay", AV20aplicadoHay);
      }
      /* Using cursor T005I4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_71 = (short)(1) ;
      GXt_date6 = A1922VarFecProx ;
      GXv_date7[0] = GXt_date6 ;
      new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
      variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
      A1922VarFecProx = GXt_date6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
      nIsDirty_71 = (short)(1) ;
      GXt_char8 = A1828OpeCliUltVal ;
      GXv_char9[0] = GXt_char8 ;
      new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
      variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
      A1828OpeCliUltVal = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
      if ( ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) ) )
      {
         divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
      }
      else
      {
         if ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) )
         {
            divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
         }
      }
      if ( ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) ) && (0==A1895VarRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtOpeCliCodFormula_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliCodFormula_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtOpeCliDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         chkOpeCliEsCant.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
      }
      else
      {
         chkOpeCliEsCant.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         chkOpeCliAliEs.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
      }
      else
      {
         chkOpeCliAliEs.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
      }
      if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I3_n1906OpeCliIdPadre[0] ) )
      {
         edtVarFrecAct_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
      }
      else
      {
         edtVarFrecAct_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
      }
   }

   public void closeExtendedTableCursors5I71( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_29( int A3CliCod )
   {
      /* Using cursor T005I6 */
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

   public void getKey5I71( )
   {
      /* Using cursor T005I7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound71 = (short)(1) ;
      }
      else
      {
         RcdFound71 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5I71( 28) ;
         RcdFound71 = (short)(1) ;
         A82OpeCliId = T005I3_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A1903ValRelSecCli = T005I3_A1903ValRelSecCli[0] ;
         A549OpeCliCodFormula = T005I3_A549OpeCliCodFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
         A534OpeCliDescrip = T005I3_A534OpeCliDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
         A931OpeCliEsCant = T005I3_A931OpeCliEsCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
         A934OpeCliAliEs = T005I3_A934OpeCliAliEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
         A1895VarRelSec = T005I3_A1895VarRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
         A1906OpeCliIdPadre = T005I3_A1906OpeCliIdPadre[0] ;
         A2011VarRelRef = T005I3_A2011VarRelRef[0] ;
         A2025VarOld = T005I3_A2025VarOld[0] ;
         A1913VarFrecAct = T005I3_A1913VarFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1913VarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1913VarFrecAct), 2, 0));
         A2129VarActObl = T005I3_A2129VarActObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
         A2139VarHelp = T005I3_A2139VarHelp[0] ;
         A2140VarDetail = T005I3_A2140VarDetail[0] ;
         A3CliCod = T005I3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O934OpeCliAliEs = A934OpeCliAliEs ;
         httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
         O931OpeCliEsCant = A931OpeCliEsCant ;
         httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
         O534OpeCliDescrip = A534OpeCliDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
         O549OpeCliCodFormula = A549OpeCliCodFormula ;
         httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
         O82OpeCliId = A82OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         sMode71 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5I71( ) ;
         if ( AnyError == 1 )
         {
            RcdFound71 = (short)(0) ;
            initializeNonKey5I71( ) ;
         }
         Gx_mode = sMode71 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound71 = (short)(0) ;
         initializeNonKey5I71( ) ;
         sMode71 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode71 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5I71( ) ;
      if ( RcdFound71 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound71 = (short)(0) ;
      /* Using cursor T005I8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T005I8_A3CliCod[0] < A3CliCod ) || ( T005I8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005I8_A82OpeCliId[0], A82OpeCliId) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T005I8_A3CliCod[0] > A3CliCod ) || ( T005I8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005I8_A82OpeCliId[0], A82OpeCliId) > 0 ) ) )
         {
            A3CliCod = T005I8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T005I8_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            RcdFound71 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound71 = (short)(0) ;
      /* Using cursor T005I9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005I9_A3CliCod[0] > A3CliCod ) || ( T005I9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005I9_A82OpeCliId[0], A82OpeCliId) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005I9_A3CliCod[0] < A3CliCod ) || ( T005I9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005I9_A82OpeCliId[0], A82OpeCliId) < 0 ) ) )
         {
            A3CliCod = T005I9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T005I9_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            RcdFound71 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5I71( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5I71( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound71 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A82OpeCliId = Z82OpeCliId ;
               httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5I71( ) ;
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5I71( ) ;
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
                  GX_FocusControl = edtOpeCliId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5I71( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = Z82OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5I71( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Variable"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1903ValRelSecCli != T005I2_A1903ValRelSecCli[0] ) || ( GXutil.strcmp(Z549OpeCliCodFormula, T005I2_A549OpeCliCodFormula[0]) != 0 ) || ( GXutil.strcmp(Z534OpeCliDescrip, T005I2_A534OpeCliDescrip[0]) != 0 ) || ( Z931OpeCliEsCant != T005I2_A931OpeCliEsCant[0] ) || ( Z934OpeCliAliEs != T005I2_A934OpeCliAliEs[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1895VarRelSec != T005I2_A1895VarRelSec[0] ) || ( GXutil.strcmp(Z1906OpeCliIdPadre, T005I2_A1906OpeCliIdPadre[0]) != 0 ) || ( GXutil.strcmp(Z2011VarRelRef, T005I2_A2011VarRelRef[0]) != 0 ) || ( Z1913VarFrecAct != T005I2_A1913VarFrecAct[0] ) || ( Z2129VarActObl != T005I2_A2129VarActObl[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2140VarDetail, T005I2_A2140VarDetail[0]) != 0 ) )
         {
            if ( Z1903ValRelSecCli != T005I2_A1903ValRelSecCli[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"ValRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1903ValRelSecCli);
               GXutil.writeLogRaw("Current: ",T005I2_A1903ValRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z549OpeCliCodFormula, T005I2_A549OpeCliCodFormula[0]) != 0 )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"OpeCliCodFormula");
               GXutil.writeLogRaw("Old: ",Z549OpeCliCodFormula);
               GXutil.writeLogRaw("Current: ",T005I2_A549OpeCliCodFormula[0]);
            }
            if ( GXutil.strcmp(Z534OpeCliDescrip, T005I2_A534OpeCliDescrip[0]) != 0 )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"OpeCliDescrip");
               GXutil.writeLogRaw("Old: ",Z534OpeCliDescrip);
               GXutil.writeLogRaw("Current: ",T005I2_A534OpeCliDescrip[0]);
            }
            if ( Z931OpeCliEsCant != T005I2_A931OpeCliEsCant[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"OpeCliEsCant");
               GXutil.writeLogRaw("Old: ",Z931OpeCliEsCant);
               GXutil.writeLogRaw("Current: ",T005I2_A931OpeCliEsCant[0]);
            }
            if ( Z934OpeCliAliEs != T005I2_A934OpeCliAliEs[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"OpeCliAliEs");
               GXutil.writeLogRaw("Old: ",Z934OpeCliAliEs);
               GXutil.writeLogRaw("Current: ",T005I2_A934OpeCliAliEs[0]);
            }
            if ( Z1895VarRelSec != T005I2_A1895VarRelSec[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"VarRelSec");
               GXutil.writeLogRaw("Old: ",Z1895VarRelSec);
               GXutil.writeLogRaw("Current: ",T005I2_A1895VarRelSec[0]);
            }
            if ( GXutil.strcmp(Z1906OpeCliIdPadre, T005I2_A1906OpeCliIdPadre[0]) != 0 )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"OpeCliIdPadre");
               GXutil.writeLogRaw("Old: ",Z1906OpeCliIdPadre);
               GXutil.writeLogRaw("Current: ",T005I2_A1906OpeCliIdPadre[0]);
            }
            if ( GXutil.strcmp(Z2011VarRelRef, T005I2_A2011VarRelRef[0]) != 0 )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"VarRelRef");
               GXutil.writeLogRaw("Old: ",Z2011VarRelRef);
               GXutil.writeLogRaw("Current: ",T005I2_A2011VarRelRef[0]);
            }
            if ( Z1913VarFrecAct != T005I2_A1913VarFrecAct[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"VarFrecAct");
               GXutil.writeLogRaw("Old: ",Z1913VarFrecAct);
               GXutil.writeLogRaw("Current: ",T005I2_A1913VarFrecAct[0]);
            }
            if ( Z2129VarActObl != T005I2_A2129VarActObl[0] )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"VarActObl");
               GXutil.writeLogRaw("Old: ",Z2129VarActObl);
               GXutil.writeLogRaw("Current: ",T005I2_A2129VarActObl[0]);
            }
            if ( GXutil.strcmp(Z2140VarDetail, T005I2_A2140VarDetail[0]) != 0 )
            {
               GXutil.writeLogln("variable_listar:[seudo value changed for attri]"+"VarDetail");
               GXutil.writeLogRaw("Old: ",Z2140VarDetail);
               GXutil.writeLogRaw("Current: ",T005I2_A2140VarDetail[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Variable"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5I71( )
   {
      beforeValidate5I71( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5I71( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5I71( 0) ;
         checkOptimisticConcurrency5I71( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5I71( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5I71( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005I10 */
                  pr_default.execute(8, new Object[] {A82OpeCliId, Integer.valueOf(A1903ValRelSecCli), A549OpeCliCodFormula, A534OpeCliDescrip, Boolean.valueOf(A931OpeCliEsCant), Boolean.valueOf(A934OpeCliAliEs), Integer.valueOf(A1895VarRelSec), A1906OpeCliIdPadre, A2011VarRelRef, A2025VarOld, Byte.valueOf(A1913VarFrecAct), Boolean.valueOf(A2129VarActObl), A2139VarHelp, A2140VarDetail, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
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
                        resetCaption5I0( ) ;
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
            load5I71( ) ;
         }
         endLevel5I71( ) ;
      }
      closeExtendedTableCursors5I71( ) ;
   }

   public void update5I71( )
   {
      beforeValidate5I71( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5I71( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5I71( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5I71( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5I71( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005I11 */
                  pr_default.execute(9, new Object[] {Integer.valueOf(A1903ValRelSecCli), A549OpeCliCodFormula, A534OpeCliDescrip, Boolean.valueOf(A931OpeCliEsCant), Boolean.valueOf(A934OpeCliAliEs), Integer.valueOf(A1895VarRelSec), A1906OpeCliIdPadre, A2011VarRelRef, A2025VarOld, Byte.valueOf(A1913VarFrecAct), Boolean.valueOf(A2129VarActObl), A2139VarHelp, A2140VarDetail, Integer.valueOf(A3CliCod), A82OpeCliId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Variable"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5I71( ) ;
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
         endLevel5I71( ) ;
      }
      closeExtendedTableCursors5I71( ) ;
   }

   public void deferredUpdate5I71( )
   {
   }

   public void delete( )
   {
      beforeValidate5I71( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5I71( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5I71( ) ;
         afterConfirm5I71( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5I71( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005I12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
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
      sMode71 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5I71( ) ;
      Gx_mode = sMode71 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5I71( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV20aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1895VarRelSec, GXv_boolean3) ;
            variable_listar_impl.this.AV20aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20aplicadoHay", AV20aplicadoHay);
         }
         AV23Pgmname = "Variable_listar" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
         GXt_date6 = A1922VarFecProx ;
         GXv_date7[0] = GXt_date6 ;
         new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
         variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
         A1922VarFecProx = GXt_date6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
         GXt_char8 = A1828OpeCliUltVal ;
         GXv_char9[0] = GXt_char8 ;
         new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
         variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
         A1828OpeCliUltVal = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
         if ( ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) ) )
         {
            divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
         }
         else
         {
            if ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) )
            {
               divVarrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divVarrelsec_cell_Internalname, "Class", divVarrelsec_cell_Class, true);
            }
         }
         if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I2_n1906OpeCliIdPadre[0] ) )
         {
            edtOpeCliCodFormula_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
         }
         else
         {
            edtOpeCliCodFormula_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
         }
         if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I2_n1906OpeCliIdPadre[0] ) )
         {
            edtOpeCliDescrip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
         }
         else
         {
            edtOpeCliDescrip_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
         }
         if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I2_n1906OpeCliIdPadre[0] ) )
         {
            chkOpeCliEsCant.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
         }
         else
         {
            chkOpeCliEsCant.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
         }
         if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I2_n1906OpeCliIdPadre[0] ) )
         {
            chkOpeCliAliEs.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
         }
         else
         {
            chkOpeCliAliEs.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
         }
         if ( ! isIns( )  && ( ! (GXutil.strcmp("", A1906OpeCliIdPadre)==0) && ! T005I2_n1906OpeCliIdPadre[0] ) )
         {
            edtVarFrecAct_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
         }
         else
         {
            edtVarFrecAct_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005I13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T005I14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "condicion_exencion_iigg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T005I15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Valores", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel5I71( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5I71( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "variable_listar");
         if ( AnyError == 0 )
         {
            confirmValues5I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "variable_listar");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5I71( )
   {
      /* Scan By routine */
      /* Using cursor T005I16 */
      pr_default.execute(14);
      RcdFound71 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound71 = (short)(1) ;
         A3CliCod = T005I16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T005I16_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5I71( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound71 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound71 = (short)(1) ;
         A3CliCod = T005I16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T005I16_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
   }

   public void scanEnd5I71( )
   {
      pr_default.close(14);
   }

   public void afterConfirm5I71( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV20aplicadoHay ) && ! (0==A1895VarRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "VarRelSec", 1, "VARRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynVarRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert5I71( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5I71( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5I71( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5I71( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5I71( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5I71( )
   {
      edtOpeCliId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      edtOpeCliCodFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliCodFormula_Enabled), 5, 0), true);
      edtOpeCliDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliDescrip_Enabled), 5, 0), true);
      chkOpeCliEsCant.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliEsCant.getEnabled(), 5, 0), true);
      chkOpeCliAliEs.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliAliEs.getEnabled(), 5, 0), true);
      edtVarFrecAct_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVarFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVarFrecAct_Enabled), 5, 0), true);
      chkVarActObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkVarActObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkVarActObl.getEnabled(), 5, 0), true);
      dynVarRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynVarRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynVarRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5I71( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5I0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.variable_listar", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId))}, new String[] {"Gx_mode","CliCod","OpeCliId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Variable_listar");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ValRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1903ValRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("OpeCliIdPadre", GXutil.rtrim( localUtil.format( A1906OpeCliIdPadre, "")));
      forbiddenHiddens.add("VarRelRef", GXutil.rtrim( localUtil.format( A2011VarRelRef, "")));
      forbiddenHiddens.add("VarDetail", GXutil.rtrim( localUtil.format( A2140VarDetail, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("variable_listar:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z82OpeCliId", GXutil.rtrim( Z82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1903ValRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1903ValRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z549OpeCliCodFormula", GXutil.rtrim( Z549OpeCliCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "Z534OpeCliDescrip", Z534OpeCliDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z931OpeCliEsCant", Z931OpeCliEsCant);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z934OpeCliAliEs", Z934OpeCliAliEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1895VarRelSec", GXutil.ltrim( localUtil.ntoc( Z1895VarRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1906OpeCliIdPadre", GXutil.rtrim( Z1906OpeCliIdPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2011VarRelRef", Z2011VarRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1913VarFrecAct", GXutil.ltrim( localUtil.ntoc( Z1913VarFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2129VarActObl", Z2129VarActObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2140VarDetail", Z2140VarDetail);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O934OpeCliAliEs", O934OpeCliAliEs);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O931OpeCliEsCant", O931OpeCliEsCant);
      web.GxWebStd.gx_hidden_field( httpContext, "O534OpeCliDescrip", O534OpeCliDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O549OpeCliCodFormula", GXutil.rtrim( O549OpeCliCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "O82OpeCliId", GXutil.rtrim( O82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N549OpeCliCodFormula", GXutil.rtrim( A549OpeCliCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "N534OpeCliDescrip", A534OpeCliDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "N931OpeCliEsCant", A931OpeCliEsCant);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "N934OpeCliAliEs", A934OpeCliAliEs);
      web.GxWebStd.gx_hidden_field( httpContext, "N1913VarFrecAct", GXutil.ltrim( localUtil.ntoc( A1913VarFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "VARFECPROX", localUtil.dtoc( A1922VarFecProx, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIULTVAL", A1828OpeCliUltVal);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECLIID", GXutil.rtrim( AV8OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8OpeCliId, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV22esSistemaConceptosDefault);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV21ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "VALRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1903ValRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIIDPADRE", GXutil.rtrim( A1906OpeCliIdPadre));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV20aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "VARRELREF", A2011VarRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "VAROLD", A2025VarOld);
      web.GxWebStd.gx_hidden_field( httpContext, "VARHELP", A2139VarHelp);
      web.GxWebStd.gx_hidden_field( httpContext, "VARDETAIL", A2140VarDetail);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV23Pgmname));
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
      return formatLink("web.variable_listar", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId))}, new String[] {"Gx_mode","CliCod","OpeCliId"})  ;
   }

   public String getPgmname( )
   {
      return "Variable_listar" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Variable_listar", "") ;
   }

   public void initializeNonKey5I71( )
   {
      AV20aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20aplicadoHay", AV20aplicadoHay);
      A1903ValRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1903ValRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1903ValRelSecCli), 6, 0));
      A1828OpeCliUltVal = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
      A1922VarFecProx = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
      A549OpeCliCodFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
      A534OpeCliDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
      A931OpeCliEsCant = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
      A934OpeCliAliEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
      A1895VarRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1895VarRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1895VarRelSec), 6, 0));
      A1906OpeCliIdPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1906OpeCliIdPadre", A1906OpeCliIdPadre);
      A2011VarRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2011VarRelRef", A2011VarRelRef);
      A2025VarOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2025VarOld", A2025VarOld);
      A1913VarFrecAct = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1913VarFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1913VarFrecAct), 2, 0));
      A2129VarActObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
      A2139VarHelp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2139VarHelp", A2139VarHelp);
      A2140VarDetail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2140VarDetail", A2140VarDetail);
      O934OpeCliAliEs = A934OpeCliAliEs ;
      httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
      O931OpeCliEsCant = A931OpeCliEsCant ;
      httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
      O534OpeCliDescrip = A534OpeCliDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A534OpeCliDescrip", A534OpeCliDescrip);
      O549OpeCliCodFormula = A549OpeCliCodFormula ;
      httpContext.ajax_rsp_assign_attri("", false, "A549OpeCliCodFormula", A549OpeCliCodFormula);
      Z1903ValRelSecCli = 0 ;
      Z549OpeCliCodFormula = "" ;
      Z534OpeCliDescrip = "" ;
      Z931OpeCliEsCant = false ;
      Z934OpeCliAliEs = false ;
      Z1895VarRelSec = 0 ;
      Z1906OpeCliIdPadre = "" ;
      Z2011VarRelRef = "" ;
      Z1913VarFrecAct = (byte)(0) ;
      Z2129VarActObl = false ;
      Z2140VarDetail = "" ;
   }

   public void initAll5I71( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A82OpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      initializeNonKey5I71( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1903ValRelSecCli = i1903ValRelSecCli ;
      httpContext.ajax_rsp_assign_attri("", false, "A1903ValRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1903ValRelSecCli), 6, 0));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181784262", true, true);
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
      httpContext.AddJavascriptSource("variable_listar.js", "?2025181784262", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtOpeCliId_Internalname = "OPECLIID" ;
      edtOpeCliCodFormula_Internalname = "OPECLICODFORMULA" ;
      edtOpeCliDescrip_Internalname = "OPECLIDESCRIP" ;
      chkOpeCliEsCant.setInternalname( "OPECLIESCANT" );
      chkOpeCliAliEs.setInternalname( "OPECLIALIES" );
      edtVarFrecAct_Internalname = "VARFRECACT" ;
      chkVarActObl.setInternalname( "VARACTOBL" );
      divVaractobl_cell_Internalname = "VARACTOBL_CELL" ;
      dynVarRelSec.setInternalname( "VARRELSEC" );
      divVarrelsec_cell_Internalname = "VARRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
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
      Form.setCaption( httpContext.getMessage( "Variable_listar", "") );
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynVarRelSec.setJsonclick( "" );
      dynVarRelSec.setEnabled( 1 );
      dynVarRelSec.setVisible( 1 );
      divVarrelsec_cell_Class = "col-xs-12" ;
      chkVarActObl.setEnabled( 1 );
      chkVarActObl.setVisible( 1 );
      divVaractobl_cell_Class = "col-xs-12" ;
      edtVarFrecAct_Jsonclick = "" ;
      edtVarFrecAct_Enabled = 1 ;
      chkOpeCliAliEs.setEnabled( 1 );
      chkOpeCliEsCant.setEnabled( 1 );
      edtOpeCliDescrip_Enabled = 1 ;
      edtOpeCliCodFormula_Jsonclick = "" ;
      edtOpeCliCodFormula_Enabled = 1 ;
      edtOpeCliId_Jsonclick = "" ;
      edtOpeCliId_Enabled = 1 ;
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

   public void gxdlavarrelsec5I71( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlavarrelsec_data5I71( AV7CliCod) ;
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

   public void gxavarrelsec_html5I71( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlavarrelsec_data5I71( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynVarRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynVarRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlavarrelsec_data5I71( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005I17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005I17_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005I17_A1880CliReDTChar[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gx1asavarfecprox5I71( int A3CliCod ,
                                     String A82OpeCliId )
   {
      GXt_date6 = A1922VarFecProx ;
      GXv_date7[0] = GXt_date6 ;
      new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
      variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
      A1922VarFecProx = GXt_date6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.format(A1922VarFecProx, "99/99/99"))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx2asaopecliultval5I71( int A3CliCod ,
                                       String A82OpeCliId )
   {
      GXt_char8 = A1828OpeCliUltVal ;
      GXv_char9[0] = GXt_char8 ;
      new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
      variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
      A1828OpeCliUltVal = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1828OpeCliUltVal)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx3asaclicod5I71( int AV7CliCod )
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
            variable_listar_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxasa21295I71( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      variable_listar_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkVarActObl.setVisible( (GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkVarActObl.getInternalname(), "Visible", GXutil.ltrimstr( chkVarActObl.getVisible(), 5, 0), true);
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

   public void xc_21_5I71( String Gx_mode ,
                           int AV7CliCod ,
                           int A1895VarRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV20aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1895VarRelSec, GXv_boolean3) ;
         AV20aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20aplicadoHay", AV20aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV20aplicadoHay))+"\"") ;
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
      chkOpeCliEsCant.setName( "OPECLIESCANT" );
      chkOpeCliEsCant.setWebtags( "" );
      chkOpeCliEsCant.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliEsCant.getInternalname(), "TitleCaption", chkOpeCliEsCant.getCaption(), true);
      chkOpeCliEsCant.setCheckedValue( "false" );
      A931OpeCliEsCant = GXutil.strtobool( GXutil.booltostr( A931OpeCliEsCant)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A931OpeCliEsCant", A931OpeCliEsCant);
      chkOpeCliAliEs.setName( "OPECLIALIES" );
      chkOpeCliAliEs.setWebtags( "" );
      chkOpeCliAliEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliAliEs.getInternalname(), "TitleCaption", chkOpeCliAliEs.getCaption(), true);
      chkOpeCliAliEs.setCheckedValue( "false" );
      A934OpeCliAliEs = GXutil.strtobool( GXutil.booltostr( A934OpeCliAliEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A934OpeCliAliEs", A934OpeCliAliEs);
      chkVarActObl.setName( "VARACTOBL" );
      chkVarActObl.setWebtags( "" );
      chkVarActObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkVarActObl.getInternalname(), "TitleCaption", chkVarActObl.getCaption(), true);
      chkVarActObl.setCheckedValue( "false" );
      A2129VarActObl = GXutil.strtobool( GXutil.booltostr( A2129VarActObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2129VarActObl", A2129VarActObl);
      dynVarRelSec.setName( "VARRELSEC" );
      dynVarRelSec.setWebtags( "" );
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
      A1895VarRelSec = (int)(GXutil.lval( dynVarRelSec.getValue())) ;
      /* Using cursor T005I18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      GXt_date6 = A1922VarFecProx ;
      GXv_date7[0] = GXt_date6 ;
      new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date7) ;
      variable_listar_impl.this.GXt_date6 = GXv_date7[0] ;
      A1922VarFecProx = GXt_date6 ;
      GXt_char8 = A1828OpeCliUltVal ;
      GXv_char9[0] = GXt_char8 ;
      new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
      variable_listar_impl.this.GXt_char8 = GXv_char9[0] ;
      A1828OpeCliUltVal = GXt_char8 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1922VarFecProx", localUtil.format(A1922VarFecProx, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A1828OpeCliUltVal", A1828OpeCliUltVal);
   }

   public void valid_Varrelsec( )
   {
      A1895VarRelSec = (int)(GXutil.lval( dynVarRelSec.getValue())) ;
      if ( ( ( ( AV22esSistemaConceptosDefault ) || ( AV21ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || ( GXutil.strcmp(A549OpeCliCodFormula, O549OpeCliCodFormula) != 0 ) || ( GXutil.strcmp(A534OpeCliDescrip, O534OpeCliDescrip) != 0 ) || ( A931OpeCliEsCant != O931OpeCliEsCant ) || ( A934OpeCliAliEs != O934OpeCliAliEs ) ) ) && (0==A1895VarRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "VARRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynVarRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV20aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1895VarRelSec, GXv_boolean3) ;
         variable_listar_impl.this.AV20aplicadoHay = GXv_boolean3[0] ;
         AV20aplicadoHay = this.AV20aplicadoHay ;
      }
      O934OpeCliAliEs = A934OpeCliAliEs ;
      O931OpeCliEsCant = A931OpeCliEsCant ;
      O534OpeCliDescrip = A534OpeCliDescrip ;
      O549OpeCliCodFormula = A549OpeCliCodFormula ;
      O82OpeCliId = A82OpeCliId ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV20aplicadoHay", AV20aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'A1903ValRelSecCli',fld:'VALRELSECCLI',pic:'ZZZZZ9'},{av:'A1906OpeCliIdPadre',fld:'OPECLIIDPADRE',pic:''},{av:'A2011VarRelRef',fld:'VARRELREF',pic:''},{av:'A2140VarDetail',fld:'VARDETAIL',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125I2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_OPECLIID","{handler:'valid_Opecliid',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_OPECLIID",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_OPECLICODFORMULA","{handler:'valid_Opeclicodformula',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_OPECLICODFORMULA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_OPECLIDESCRIP","{handler:'valid_Opeclidescrip',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_OPECLIDESCRIP",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_OPECLIESCANT","{handler:'valid_Opecliescant',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_OPECLIESCANT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_OPECLIALIES","{handler:'valid_Opeclialies',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_OPECLIALIES",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_VARRELSEC","{handler:'valid_Varrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O934OpeCliAliEs'},{av:'O931OpeCliEsCant'},{av:'O534OpeCliDescrip'},{av:'O549OpeCliCodFormula'},{av:'O82OpeCliId'},{av:'AV22esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''},{av:'AV21ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:''},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV20aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_VARRELSEC",",oparms:[{av:'AV20aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A1922VarFecProx',fld:'VARFECPROX',pic:''},{av:'A1828OpeCliUltVal',fld:'OPECLIULTVAL',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1922VarFecProx',fld:'VARFECPROX',pic:''},{av:'A1828OpeCliUltVal',fld:'OPECLIULTVAL',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynVarRelSec'},{av:'A1895VarRelSec',fld:'VARRELSEC',pic:'ZZZZZ9'},{av:'A931OpeCliEsCant',fld:'OPECLIESCANT',pic:''},{av:'A934OpeCliAliEs',fld:'OPECLIALIES',pic:''},{av:'A2129VarActObl',fld:'VARACTOBL',pic:''}]}");
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
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8OpeCliId = "" ;
      Z82OpeCliId = "" ;
      Z549OpeCliCodFormula = "" ;
      Z534OpeCliDescrip = "" ;
      Z1906OpeCliIdPadre = "" ;
      Z2011VarRelRef = "" ;
      Z2140VarDetail = "" ;
      O534OpeCliDescrip = "" ;
      O549OpeCliCodFormula = "" ;
      O82OpeCliId = "" ;
      N549OpeCliCodFormula = "" ;
      N534OpeCliDescrip = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A82OpeCliId = "" ;
      AV8OpeCliId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A549OpeCliCodFormula = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A534OpeCliDescrip = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1906OpeCliIdPadre = "" ;
      A2011VarRelRef = "" ;
      A2140VarDetail = "" ;
      A1922VarFecProx = GXutil.nullDate() ;
      A1828OpeCliUltVal = "" ;
      A2025VarOld = "" ;
      A2139VarHelp = "" ;
      AV23Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode71 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z2025VarOld = "" ;
      Z2139VarHelp = "" ;
      T005I5_A82OpeCliId = new String[] {""} ;
      T005I5_A1903ValRelSecCli = new int[1] ;
      T005I5_A549OpeCliCodFormula = new String[] {""} ;
      T005I5_A534OpeCliDescrip = new String[] {""} ;
      T005I5_A931OpeCliEsCant = new boolean[] {false} ;
      T005I5_A934OpeCliAliEs = new boolean[] {false} ;
      T005I5_A1895VarRelSec = new int[1] ;
      T005I5_A1906OpeCliIdPadre = new String[] {""} ;
      T005I5_A2011VarRelRef = new String[] {""} ;
      T005I5_A2025VarOld = new String[] {""} ;
      T005I5_A1913VarFrecAct = new byte[1] ;
      T005I5_A2129VarActObl = new boolean[] {false} ;
      T005I5_A2139VarHelp = new String[] {""} ;
      T005I5_A2140VarDetail = new String[] {""} ;
      T005I5_A3CliCod = new int[1] ;
      T005I3_n1906OpeCliIdPadre = new boolean[] {false} ;
      T005I4_A3CliCod = new int[1] ;
      T005I6_A3CliCod = new int[1] ;
      T005I7_A3CliCod = new int[1] ;
      T005I7_A82OpeCliId = new String[] {""} ;
      T005I3_A82OpeCliId = new String[] {""} ;
      T005I3_A1903ValRelSecCli = new int[1] ;
      T005I3_A549OpeCliCodFormula = new String[] {""} ;
      T005I3_A534OpeCliDescrip = new String[] {""} ;
      T005I3_A931OpeCliEsCant = new boolean[] {false} ;
      T005I3_A934OpeCliAliEs = new boolean[] {false} ;
      T005I3_A1895VarRelSec = new int[1] ;
      T005I3_A1906OpeCliIdPadre = new String[] {""} ;
      T005I3_A2011VarRelRef = new String[] {""} ;
      T005I3_A2025VarOld = new String[] {""} ;
      T005I3_A1913VarFrecAct = new byte[1] ;
      T005I3_A2129VarActObl = new boolean[] {false} ;
      T005I3_A2139VarHelp = new String[] {""} ;
      T005I3_A2140VarDetail = new String[] {""} ;
      T005I3_A3CliCod = new int[1] ;
      T005I8_A3CliCod = new int[1] ;
      T005I8_A82OpeCliId = new String[] {""} ;
      T005I9_A3CliCod = new int[1] ;
      T005I9_A82OpeCliId = new String[] {""} ;
      T005I2_A82OpeCliId = new String[] {""} ;
      T005I2_A1903ValRelSecCli = new int[1] ;
      T005I2_A549OpeCliCodFormula = new String[] {""} ;
      T005I2_A534OpeCliDescrip = new String[] {""} ;
      T005I2_A931OpeCliEsCant = new boolean[] {false} ;
      T005I2_A934OpeCliAliEs = new boolean[] {false} ;
      T005I2_A1895VarRelSec = new int[1] ;
      T005I2_A1906OpeCliIdPadre = new String[] {""} ;
      T005I2_A2011VarRelRef = new String[] {""} ;
      T005I2_A2025VarOld = new String[] {""} ;
      T005I2_A1913VarFrecAct = new byte[1] ;
      T005I2_A2129VarActObl = new boolean[] {false} ;
      T005I2_A2139VarHelp = new String[] {""} ;
      T005I2_A2140VarDetail = new String[] {""} ;
      T005I2_A3CliCod = new int[1] ;
      T005I2_n1906OpeCliIdPadre = new boolean[] {false} ;
      T005I13_A3CliCod = new int[1] ;
      T005I13_A1112AplIIGG = new short[1] ;
      T005I14_A3CliCod = new int[1] ;
      T005I14_A1105CondExenIIGG = new String[] {""} ;
      T005I15_A3CliCod = new int[1] ;
      T005I15_A82OpeCliId = new String[] {""} ;
      T005I15_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005I16_A3CliCod = new int[1] ;
      T005I16_A82OpeCliId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005I17_A3CliCod = new int[1] ;
      T005I17_A1885CliRelSec = new int[1] ;
      T005I17_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T005I18_A3CliCod = new int[1] ;
      GXt_date6 = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      Z1922VarFecProx = GXutil.nullDate() ;
      Z1828OpeCliUltVal = "" ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_listar__default(),
         new Object[] {
             new Object[] {
            T005I2_A82OpeCliId, T005I2_A1903ValRelSecCli, T005I2_A549OpeCliCodFormula, T005I2_A534OpeCliDescrip, T005I2_A931OpeCliEsCant, T005I2_A934OpeCliAliEs, T005I2_A1895VarRelSec, T005I2_A1906OpeCliIdPadre, T005I2_A2011VarRelRef, T005I2_A2025VarOld,
            T005I2_A1913VarFrecAct, T005I2_A2129VarActObl, T005I2_A2139VarHelp, T005I2_A2140VarDetail, T005I2_A3CliCod
            }
            , new Object[] {
            T005I3_A82OpeCliId, T005I3_A1903ValRelSecCli, T005I3_A549OpeCliCodFormula, T005I3_A534OpeCliDescrip, T005I3_A931OpeCliEsCant, T005I3_A934OpeCliAliEs, T005I3_A1895VarRelSec, T005I3_A1906OpeCliIdPadre, T005I3_A2011VarRelRef, T005I3_A2025VarOld,
            T005I3_A1913VarFrecAct, T005I3_A2129VarActObl, T005I3_A2139VarHelp, T005I3_A2140VarDetail, T005I3_A3CliCod
            }
            , new Object[] {
            T005I4_A3CliCod
            }
            , new Object[] {
            T005I5_A82OpeCliId, T005I5_A1903ValRelSecCli, T005I5_A549OpeCliCodFormula, T005I5_A534OpeCliDescrip, T005I5_A931OpeCliEsCant, T005I5_A934OpeCliAliEs, T005I5_A1895VarRelSec, T005I5_A1906OpeCliIdPadre, T005I5_A2011VarRelRef, T005I5_A2025VarOld,
            T005I5_A1913VarFrecAct, T005I5_A2129VarActObl, T005I5_A2139VarHelp, T005I5_A2140VarDetail, T005I5_A3CliCod
            }
            , new Object[] {
            T005I6_A3CliCod
            }
            , new Object[] {
            T005I7_A3CliCod, T005I7_A82OpeCliId
            }
            , new Object[] {
            T005I8_A3CliCod, T005I8_A82OpeCliId
            }
            , new Object[] {
            T005I9_A3CliCod, T005I9_A82OpeCliId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005I13_A3CliCod, T005I13_A1112AplIIGG
            }
            , new Object[] {
            T005I14_A3CliCod, T005I14_A1105CondExenIIGG
            }
            , new Object[] {
            T005I15_A3CliCod, T005I15_A82OpeCliId, T005I15_A754OpeCliVig
            }
            , new Object[] {
            T005I16_A3CliCod, T005I16_A82OpeCliId
            }
            , new Object[] {
            T005I17_A3CliCod, T005I17_A1885CliRelSec, T005I17_A1880CliReDTChar
            }
            , new Object[] {
            T005I18_A3CliCod
            }
         }
      );
      AV23Pgmname = "Variable_listar" ;
   }

   private byte Z1913VarFrecAct ;
   private byte N1913VarFrecAct ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1913VarFrecAct ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound71 ;
   private short nIsDirty_71 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1903ValRelSecCli ;
   private int Z1895VarRelSec ;
   private int AV7CliCod ;
   private int A1895VarRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtOpeCliId_Enabled ;
   private int edtOpeCliCodFormula_Enabled ;
   private int edtOpeCliDescrip_Enabled ;
   private int edtVarFrecAct_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1903ValRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int i1903ValRelSecCli ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8OpeCliId ;
   private String Z82OpeCliId ;
   private String Z549OpeCliCodFormula ;
   private String Z1906OpeCliIdPadre ;
   private String O549OpeCliCodFormula ;
   private String O82OpeCliId ;
   private String N549OpeCliCodFormula ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A82OpeCliId ;
   private String AV8OpeCliId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtOpeCliId_Internalname ;
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
   private String edtOpeCliId_Jsonclick ;
   private String edtOpeCliCodFormula_Internalname ;
   private String A549OpeCliCodFormula ;
   private String edtOpeCliCodFormula_Jsonclick ;
   private String edtOpeCliDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtVarFrecAct_Internalname ;
   private String edtVarFrecAct_Jsonclick ;
   private String divVaractobl_cell_Internalname ;
   private String divVaractobl_cell_Class ;
   private String divVarrelsec_cell_Internalname ;
   private String divVarrelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A1906OpeCliIdPadre ;
   private String AV23Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode71 ;
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
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private java.util.Date A1922VarFecProx ;
   private java.util.Date GXt_date6 ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date Z1922VarFecProx ;
   private boolean Z931OpeCliEsCant ;
   private boolean Z934OpeCliAliEs ;
   private boolean Z2129VarActObl ;
   private boolean O934OpeCliAliEs ;
   private boolean O931OpeCliEsCant ;
   private boolean N931OpeCliEsCant ;
   private boolean N934OpeCliAliEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean A2129VarActObl ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV22esSistemaConceptosDefault ;
   private boolean AV21ClienteConveniador ;
   private boolean AV20aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean ZV20aplicadoHay ;
   private String A2025VarOld ;
   private String A2139VarHelp ;
   private String Z2025VarOld ;
   private String Z2139VarHelp ;
   private String Z534OpeCliDescrip ;
   private String Z2011VarRelRef ;
   private String Z2140VarDetail ;
   private String O534OpeCliDescrip ;
   private String N534OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private String A2011VarRelRef ;
   private String A2140VarDetail ;
   private String A1828OpeCliUltVal ;
   private String Z1828OpeCliUltVal ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkOpeCliEsCant ;
   private ICheckbox chkOpeCliAliEs ;
   private ICheckbox chkVarActObl ;
   private HTMLChoice dynVarRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T005I5_A82OpeCliId ;
   private int[] T005I5_A1903ValRelSecCli ;
   private String[] T005I5_A549OpeCliCodFormula ;
   private String[] T005I5_A534OpeCliDescrip ;
   private boolean[] T005I5_A931OpeCliEsCant ;
   private boolean[] T005I5_A934OpeCliAliEs ;
   private int[] T005I5_A1895VarRelSec ;
   private String[] T005I5_A1906OpeCliIdPadre ;
   private String[] T005I5_A2011VarRelRef ;
   private String[] T005I5_A2025VarOld ;
   private byte[] T005I5_A1913VarFrecAct ;
   private boolean[] T005I5_A2129VarActObl ;
   private String[] T005I5_A2139VarHelp ;
   private String[] T005I5_A2140VarDetail ;
   private int[] T005I5_A3CliCod ;
   private boolean[] T005I3_n1906OpeCliIdPadre ;
   private int[] T005I4_A3CliCod ;
   private int[] T005I6_A3CliCod ;
   private int[] T005I7_A3CliCod ;
   private String[] T005I7_A82OpeCliId ;
   private String[] T005I3_A82OpeCliId ;
   private int[] T005I3_A1903ValRelSecCli ;
   private String[] T005I3_A549OpeCliCodFormula ;
   private String[] T005I3_A534OpeCliDescrip ;
   private boolean[] T005I3_A931OpeCliEsCant ;
   private boolean[] T005I3_A934OpeCliAliEs ;
   private int[] T005I3_A1895VarRelSec ;
   private String[] T005I3_A1906OpeCliIdPadre ;
   private String[] T005I3_A2011VarRelRef ;
   private String[] T005I3_A2025VarOld ;
   private byte[] T005I3_A1913VarFrecAct ;
   private boolean[] T005I3_A2129VarActObl ;
   private String[] T005I3_A2139VarHelp ;
   private String[] T005I3_A2140VarDetail ;
   private int[] T005I3_A3CliCod ;
   private int[] T005I8_A3CliCod ;
   private String[] T005I8_A82OpeCliId ;
   private int[] T005I9_A3CliCod ;
   private String[] T005I9_A82OpeCliId ;
   private String[] T005I2_A82OpeCliId ;
   private int[] T005I2_A1903ValRelSecCli ;
   private String[] T005I2_A549OpeCliCodFormula ;
   private String[] T005I2_A534OpeCliDescrip ;
   private boolean[] T005I2_A931OpeCliEsCant ;
   private boolean[] T005I2_A934OpeCliAliEs ;
   private int[] T005I2_A1895VarRelSec ;
   private String[] T005I2_A1906OpeCliIdPadre ;
   private String[] T005I2_A2011VarRelRef ;
   private String[] T005I2_A2025VarOld ;
   private byte[] T005I2_A1913VarFrecAct ;
   private boolean[] T005I2_A2129VarActObl ;
   private String[] T005I2_A2139VarHelp ;
   private String[] T005I2_A2140VarDetail ;
   private int[] T005I2_A3CliCod ;
   private boolean[] T005I2_n1906OpeCliIdPadre ;
   private int[] T005I13_A3CliCod ;
   private short[] T005I13_A1112AplIIGG ;
   private int[] T005I14_A3CliCod ;
   private String[] T005I14_A1105CondExenIIGG ;
   private int[] T005I15_A3CliCod ;
   private String[] T005I15_A82OpeCliId ;
   private java.util.Date[] T005I15_A754OpeCliVig ;
   private int[] T005I16_A3CliCod ;
   private String[] T005I16_A82OpeCliId ;
   private int[] T005I17_A3CliCod ;
   private int[] T005I17_A1885CliRelSec ;
   private String[] T005I17_A1880CliReDTChar ;
   private int[] T005I18_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class variable_listar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005I2", "SELECT OpeCliId, ValRelSecCli, OpeCliCodFormula, OpeCliDescrip, OpeCliEsCant, OpeCliAliEs, VarRelSec, OpeCliIdPadre, VarRelRef, VarOld, VarFrecAct, VarActObl, VarHelp, VarDetail, CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ?  FOR UPDATE OF Variable NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I3", "SELECT OpeCliId, ValRelSecCli, OpeCliCodFormula, OpeCliDescrip, OpeCliEsCant, OpeCliAliEs, VarRelSec, OpeCliIdPadre, VarRelRef, VarOld, VarFrecAct, VarActObl, VarHelp, VarDetail, CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I5", "SELECT TM1.OpeCliId, TM1.ValRelSecCli, TM1.OpeCliCodFormula, TM1.OpeCliDescrip, TM1.OpeCliEsCant, TM1.OpeCliAliEs, TM1.VarRelSec, TM1.OpeCliIdPadre, TM1.VarRelRef, TM1.VarOld, TM1.VarFrecAct, TM1.VarActObl, TM1.VarHelp, TM1.VarDetail, TM1.CliCod FROM Variable TM1 WHERE TM1.CliCod = ? and TM1.OpeCliId = ( ?) ORDER BY TM1.CliCod, TM1.OpeCliId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I7", "SELECT CliCod, OpeCliId FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I8", "SELECT CliCod, OpeCliId FROM Variable WHERE ( CliCod > ? or CliCod = ? and OpeCliId > ( ?)) ORDER BY CliCod, OpeCliId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005I9", "SELECT CliCod, OpeCliId FROM Variable WHERE ( CliCod < ? or CliCod = ? and OpeCliId < ( ?)) ORDER BY CliCod DESC, OpeCliId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005I10", "SAVEPOINT gxupdate;INSERT INTO Variable(OpeCliId, ValRelSecCli, OpeCliCodFormula, OpeCliDescrip, OpeCliEsCant, OpeCliAliEs, VarRelSec, OpeCliIdPadre, VarRelRef, VarOld, VarFrecAct, VarActObl, VarHelp, VarDetail, CliCod, OpeCliIdMay, OpeCliUsuCre, OpeCliFecCre, OpeCLiAliLey, VarBusGoogle, VarBusWeb, VarBaseURL, VarScrapTDoc, VarScrapTipo, VarScrapFin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', DATE '00010101', FALSE, '', '', '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005I11", "SAVEPOINT gxupdate;UPDATE Variable SET ValRelSecCli=?, OpeCliCodFormula=?, OpeCliDescrip=?, OpeCliEsCant=?, OpeCliAliEs=?, VarRelSec=?, OpeCliIdPadre=?, VarRelRef=?, VarOld=?, VarFrecAct=?, VarActObl=?, VarHelp=?, VarDetail=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005I12", "SAVEPOINT gxupdate;DELETE FROM Variable  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005I13", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGTopeVar = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005I14", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGGVar = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005I15", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE CliCod = ? AND OpeCliId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005I16", "SELECT CliCod, OpeCliId FROM Variable ORDER BY CliCod, OpeCliId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I17", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005I18", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 16 :
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 40);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setInt(15, ((Number) parms[14]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 40);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 40);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

