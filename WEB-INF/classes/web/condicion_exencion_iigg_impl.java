package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class condicion_exencion_iigg_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action20") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A2001CondExenRelSec = (int)(GXutil.lval( httpContext.GetPar( "CondExenRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_20_36124( Gx_mode, AV7CliCod, A2001CondExenRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONDEXENRELSEC") == 0 )
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
         gxdlacondexenrelsec36124( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"CLICOD") == 0 )
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
         gx4asaclicod36124( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"") == 0 )
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
         gxasa200136124( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1104CondExenIIGGCon = httpContext.GetPar( "CondExenIIGGCon") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A3CliCod, A1104CondExenIIGGCon) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1123CondExenIIGGVar = httpContext.GetPar( "CondExenIIGGVar") ;
         n1123CondExenIIGGVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A3CliCod, A1123CondExenIIGGVar) ;
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
            AV8CondExenIIGG = httpContext.GetPar( "CondExenIIGG") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CondExenIIGG", AV8CondExenIIGG);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONDEXENIIGG", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8CondExenIIGG, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "condicion_exencion_iigg", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCondExenIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public condicion_exencion_iigg_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public condicion_exencion_iigg_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicion_exencion_iigg_impl.class ));
   }

   public condicion_exencion_iigg_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkCondExenIIGGAcu = UIFactory.getCheckbox(this);
      chkCondExenIIGGProm = UIFactory.getCheckbox(this);
      cmbCondExenIIGGOpe = new HTMLChoice();
      dynCondExenRelSec = new HTMLChoice();
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
      A1106CondExenIIGGAcu = GXutil.strtobool( GXutil.booltostr( A1106CondExenIIGGAcu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
      A1107CondExenIIGGProm = GXutil.strtobool( GXutil.booltostr( A1107CondExenIIGGProm)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
      if ( cmbCondExenIIGGOpe.getItemCount() > 0 )
      {
         A2238CondExenIIGGOpe = cmbCondExenIIGGOpe.getValidValue(A2238CondExenIIGGOpe) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCondExenIIGGOpe.setValue( GXutil.rtrim( A2238CondExenIIGGOpe) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCondExenIIGGOpe.getInternalname(), "Values", cmbCondExenIIGGOpe.ToJavascriptSource(), true);
      }
      if ( dynCondExenRelSec.getItemCount() > 0 )
      {
         A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValidValue(GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCondExenRelSec.setValue( GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynCondExenRelSec.getInternalname(), "Values", dynCondExenRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondExenIIGG_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGG_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGG_Internalname, GXutil.rtrim( A1105CondExenIIGG), GXutil.rtrim( localUtil.format( A1105CondExenIIGG, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCondExenIIGG_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcondexeniiggcon_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcondexeniiggcon_Internalname, httpContext.getMessage( "Concepto a evaluar", ""), "", "", lblTextblockcondexeniiggcon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_condexeniiggcon.setProperty("Caption", Combo_condexeniiggcon_Caption);
      ucCombo_condexeniiggcon.setProperty("Cls", Combo_condexeniiggcon_Cls);
      ucCombo_condexeniiggcon.setProperty("DataListProc", Combo_condexeniiggcon_Datalistproc);
      ucCombo_condexeniiggcon.setProperty("EmptyItem", Combo_condexeniiggcon_Emptyitem);
      ucCombo_condexeniiggcon.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_condexeniiggcon.setProperty("DropDownOptionsData", AV27CondExenIIGGCon_Data);
      ucCombo_condexeniiggcon.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_condexeniiggcon_Internalname, "COMBO_CONDEXENIIGGCONContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGGCon_Internalname, httpContext.getMessage( "Concepto a evaluar", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGGCon_Internalname, GXutil.rtrim( A1104CondExenIIGGCon), GXutil.rtrim( localUtil.format( A1104CondExenIIGGCon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGGCon_Jsonclick, 0, "Attribute", "", "", "", "", edtCondExenIIGGCon_Visible, edtCondExenIIGGCon_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondExenIIGGAcu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCondExenIIGGAcu.getInternalname(), httpContext.getMessage( "Acumulado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondExenIIGGAcu.getInternalname(), GXutil.booltostr( A1106CondExenIIGGAcu), "", httpContext.getMessage( "Acumulado", ""), 1, chkCondExenIIGGAcu.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(38, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,38);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCondExenIIGGProm.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCondExenIIGGProm.getInternalname(), httpContext.getMessage( "Promedio", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCondExenIIGGProm.getInternalname(), GXutil.booltostr( A1107CondExenIIGGProm), "", httpContext.getMessage( "Promedio", ""), 1, chkCondExenIIGGProm.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(43, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,43);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCondExenIIGGOpe.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCondExenIIGGOpe.getInternalname(), httpContext.getMessage( "Operador de comparación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCondExenIIGGOpe, cmbCondExenIIGGOpe.getInternalname(), GXutil.rtrim( A2238CondExenIIGGOpe), 1, cmbCondExenIIGGOpe.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCondExenIIGGOpe.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_condicion_exencion_iigg.htm");
      cmbCondExenIIGGOpe.setValue( GXutil.rtrim( A2238CondExenIIGGOpe) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCondExenIIGGOpe.getInternalname(), "Values", cmbCondExenIIGGOpe.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcondexeniiggvar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcondexeniiggvar_Internalname, httpContext.getMessage( "Variable a comparar", ""), "", "", lblTextblockcondexeniiggvar_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_condexeniiggvar.setProperty("Caption", Combo_condexeniiggvar_Caption);
      ucCombo_condexeniiggvar.setProperty("Cls", Combo_condexeniiggvar_Cls);
      ucCombo_condexeniiggvar.setProperty("DataListProc", Combo_condexeniiggvar_Datalistproc);
      ucCombo_condexeniiggvar.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_condexeniiggvar.setProperty("DropDownOptionsData", AV23CondExenIIGGVar_Data);
      ucCombo_condexeniiggvar.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_condexeniiggvar_Internalname, "COMBO_CONDEXENIIGGVARContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGGVar_Internalname, httpContext.getMessage( "Variable a comparar", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGGVar_Internalname, GXutil.rtrim( A1123CondExenIIGGVar), GXutil.rtrim( localUtil.format( A1123CondExenIIGGVar, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGGVar_Jsonclick, 0, "Attribute", "", "", "", "", edtCondExenIIGGVar_Visible, edtCondExenIIGGVar_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondExenIIGGVFi_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondExenIIGGVFi_Internalname, httpContext.getMessage( "Valor fijo a comparar", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCondExenIIGGVFi_Internalname, GXutil.ltrim( localUtil.ntoc( A2237CondExenIIGGVFi, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCondExenIIGGVFi_Enabled!=0) ? localUtil.format( A2237CondExenIIGGVFi, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A2237CondExenIIGGVFi, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCondExenIIGGVFi_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCondExenIIGGVFi_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCondexenIIGGNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCondexenIIGGNom_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCondexenIIGGNom_Internalname, A1108CondexenIIGGNom, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtCondexenIIGGNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCondexenrelsec_cell_Internalname, 1, 0, "px", 0, "px", divCondexenrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynCondExenRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCondExenRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCondExenRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCondExenRelSec, dynCondExenRelSec.getInternalname(), GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)), 1, dynCondExenRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynCondExenRelSec.getVisible(), dynCondExenRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_condicion_exencion_iigg.htm");
      dynCondExenRelSec.setValue( GXutil.trim( GXutil.str( A2001CondExenRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCondExenRelSec.getInternalname(), "Values", dynCondExenRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_condicion_exencion_iigg.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_condexeniiggcon_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocondexeniiggcon_Internalname, GXutil.rtrim( AV28ComboCondExenIIGGCon), GXutil.rtrim( localUtil.format( AV28ComboCondExenIIGGCon, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocondexeniiggcon_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocondexeniiggcon_Visible, edtavCombocondexeniiggcon_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_condexeniiggvar_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocondexeniiggvar_Internalname, GXutil.rtrim( AV24ComboCondExenIIGGVar), GXutil.rtrim( localUtil.format( AV24ComboCondExenIIGGVar, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocondexeniiggvar_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocondexeniiggvar_Visible, edtavCombocondexeniiggvar_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_condicion_exencion_iigg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_condicion_exencion_iigg.htm");
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
      e11362 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONDEXENIIGGCON_DATA"), AV27CondExenIIGGCon_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONDEXENIIGGVAR_DATA"), AV23CondExenIIGGVar_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1105CondExenIIGG = httpContext.cgiGet( "Z1105CondExenIIGG") ;
            Z1106CondExenIIGGAcu = GXutil.strtobool( httpContext.cgiGet( "Z1106CondExenIIGGAcu")) ;
            Z1107CondExenIIGGProm = GXutil.strtobool( httpContext.cgiGet( "Z1107CondExenIIGGProm")) ;
            Z2237CondExenIIGGVFi = localUtil.ctond( httpContext.cgiGet( "Z2237CondExenIIGGVFi")) ;
            Z2238CondExenIIGGOpe = httpContext.cgiGet( "Z2238CondExenIIGGOpe") ;
            Z1108CondexenIIGGNom = httpContext.cgiGet( "Z1108CondexenIIGGNom") ;
            Z2001CondExenRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2001CondExenRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2002CondRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z2002CondRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2021CondExenRelRef = httpContext.cgiGet( "Z2021CondExenRelRef") ;
            Z1104CondExenIIGGCon = httpContext.cgiGet( "Z1104CondExenIIGGCon") ;
            Z1123CondExenIIGGVar = httpContext.cgiGet( "Z1123CondExenIIGGVar") ;
            n1123CondExenIIGGVar = ((GXutil.strcmp("", A1123CondExenIIGGVar)==0) ? true : false) ;
            A2002CondRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z2002CondRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2021CondExenRelRef = httpContext.cgiGet( "Z2021CondExenRelRef") ;
            O1108CondexenIIGGNom = httpContext.cgiGet( "O1108CondexenIIGGNom") ;
            O1123CondExenIIGGVar = httpContext.cgiGet( "O1123CondExenIIGGVar") ;
            n1123CondExenIIGGVar = ((GXutil.strcmp("", A1123CondExenIIGGVar)==0) ? true : false) ;
            O1107CondExenIIGGProm = GXutil.strtobool( httpContext.cgiGet( "O1107CondExenIIGGProm")) ;
            O1106CondExenIIGGAcu = GXutil.strtobool( httpContext.cgiGet( "O1106CondExenIIGGAcu")) ;
            O1104CondExenIIGGCon = httpContext.cgiGet( "O1104CondExenIIGGCon") ;
            O1105CondExenIIGG = httpContext.cgiGet( "O1105CondExenIIGG") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1104CondExenIIGGCon = httpContext.cgiGet( "N1104CondExenIIGGCon") ;
            N1123CondExenIIGGVar = httpContext.cgiGet( "N1123CondExenIIGGVar") ;
            n1123CondExenIIGGVar = ((GXutil.strcmp("", A1123CondExenIIGGVar)==0) ? true : false) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CondExenIIGG = httpContext.cgiGet( "vCONDEXENIIGG") ;
            AV14Insert_CondExenIIGGCon = httpContext.cgiGet( "vINSERT_CONDEXENIIGGCON") ;
            AV15Insert_CondExenIIGGVar = httpContext.cgiGet( "vINSERT_CONDEXENIIGGVAR") ;
            AV31aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2002CondRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "CONDRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2021CondExenRelRef = httpContext.cgiGet( "CONDEXENRELREF") ;
            A2027CondExenOld = httpContext.cgiGet( "CONDEXENOLD") ;
            AV32Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_condexeniiggcon_Objectcall = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Objectcall") ;
            Combo_condexeniiggcon_Class = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Class") ;
            Combo_condexeniiggcon_Icontype = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Icontype") ;
            Combo_condexeniiggcon_Icon = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Icon") ;
            Combo_condexeniiggcon_Caption = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Caption") ;
            Combo_condexeniiggcon_Tooltip = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Tooltip") ;
            Combo_condexeniiggcon_Cls = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Cls") ;
            Combo_condexeniiggcon_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Selectedvalue_set") ;
            Combo_condexeniiggcon_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Selectedvalue_get") ;
            Combo_condexeniiggcon_Selectedtext_set = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Selectedtext_set") ;
            Combo_condexeniiggcon_Selectedtext_get = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Selectedtext_get") ;
            Combo_condexeniiggcon_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Gamoauthtoken") ;
            Combo_condexeniiggcon_Ddointernalname = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Ddointernalname") ;
            Combo_condexeniiggcon_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Titlecontrolalign") ;
            Combo_condexeniiggcon_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Dropdownoptionstype") ;
            Combo_condexeniiggcon_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Enabled")) ;
            Combo_condexeniiggcon_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Visible")) ;
            Combo_condexeniiggcon_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Titlecontrolidtoreplace") ;
            Combo_condexeniiggcon_Datalisttype = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Datalisttype") ;
            Combo_condexeniiggcon_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Allowmultipleselection")) ;
            Combo_condexeniiggcon_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Datalistfixedvalues") ;
            Combo_condexeniiggcon_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Isgriditem")) ;
            Combo_condexeniiggcon_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Hasdescription")) ;
            Combo_condexeniiggcon_Datalistproc = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Datalistproc") ;
            Combo_condexeniiggcon_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Datalistprocparametersprefix") ;
            Combo_condexeniiggcon_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Remoteservicesparameters") ;
            Combo_condexeniiggcon_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_condexeniiggcon_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Includeonlyselectedoption")) ;
            Combo_condexeniiggcon_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Includeselectalloption")) ;
            Combo_condexeniiggcon_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Emptyitem")) ;
            Combo_condexeniiggcon_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Includeaddnewoption")) ;
            Combo_condexeniiggcon_Htmltemplate = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Htmltemplate") ;
            Combo_condexeniiggcon_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Multiplevaluestype") ;
            Combo_condexeniiggcon_Loadingdata = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Loadingdata") ;
            Combo_condexeniiggcon_Noresultsfound = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Noresultsfound") ;
            Combo_condexeniiggcon_Emptyitemtext = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Emptyitemtext") ;
            Combo_condexeniiggcon_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Onlyselectedvalues") ;
            Combo_condexeniiggcon_Selectalltext = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Selectalltext") ;
            Combo_condexeniiggcon_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Multiplevaluesseparator") ;
            Combo_condexeniiggcon_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Addnewoptiontext") ;
            Combo_condexeniiggcon_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDEXENIIGGCON_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_condexeniiggvar_Objectcall = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Objectcall") ;
            Combo_condexeniiggvar_Class = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Class") ;
            Combo_condexeniiggvar_Icontype = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Icontype") ;
            Combo_condexeniiggvar_Icon = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Icon") ;
            Combo_condexeniiggvar_Caption = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Caption") ;
            Combo_condexeniiggvar_Tooltip = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Tooltip") ;
            Combo_condexeniiggvar_Cls = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Cls") ;
            Combo_condexeniiggvar_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Selectedvalue_set") ;
            Combo_condexeniiggvar_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Selectedvalue_get") ;
            Combo_condexeniiggvar_Selectedtext_set = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Selectedtext_set") ;
            Combo_condexeniiggvar_Selectedtext_get = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Selectedtext_get") ;
            Combo_condexeniiggvar_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Gamoauthtoken") ;
            Combo_condexeniiggvar_Ddointernalname = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Ddointernalname") ;
            Combo_condexeniiggvar_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Titlecontrolalign") ;
            Combo_condexeniiggvar_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Dropdownoptionstype") ;
            Combo_condexeniiggvar_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Enabled")) ;
            Combo_condexeniiggvar_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Visible")) ;
            Combo_condexeniiggvar_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Titlecontrolidtoreplace") ;
            Combo_condexeniiggvar_Datalisttype = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Datalisttype") ;
            Combo_condexeniiggvar_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Allowmultipleselection")) ;
            Combo_condexeniiggvar_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Datalistfixedvalues") ;
            Combo_condexeniiggvar_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Isgriditem")) ;
            Combo_condexeniiggvar_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Hasdescription")) ;
            Combo_condexeniiggvar_Datalistproc = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Datalistproc") ;
            Combo_condexeniiggvar_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Datalistprocparametersprefix") ;
            Combo_condexeniiggvar_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Remoteservicesparameters") ;
            Combo_condexeniiggvar_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_condexeniiggvar_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Includeonlyselectedoption")) ;
            Combo_condexeniiggvar_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Includeselectalloption")) ;
            Combo_condexeniiggvar_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Emptyitem")) ;
            Combo_condexeniiggvar_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Includeaddnewoption")) ;
            Combo_condexeniiggvar_Htmltemplate = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Htmltemplate") ;
            Combo_condexeniiggvar_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Multiplevaluestype") ;
            Combo_condexeniiggvar_Loadingdata = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Loadingdata") ;
            Combo_condexeniiggvar_Noresultsfound = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Noresultsfound") ;
            Combo_condexeniiggvar_Emptyitemtext = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Emptyitemtext") ;
            Combo_condexeniiggvar_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Onlyselectedvalues") ;
            Combo_condexeniiggvar_Selectalltext = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Selectalltext") ;
            Combo_condexeniiggvar_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Multiplevaluesseparator") ;
            Combo_condexeniiggvar_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Addnewoptiontext") ;
            Combo_condexeniiggvar_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONDEXENIIGGVAR_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1105CondExenIIGG = httpContext.cgiGet( edtCondExenIIGG_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
            A1104CondExenIIGGCon = httpContext.cgiGet( edtCondExenIIGGCon_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
            A1106CondExenIIGGAcu = GXutil.strtobool( httpContext.cgiGet( chkCondExenIIGGAcu.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
            A1107CondExenIIGGProm = GXutil.strtobool( httpContext.cgiGet( chkCondExenIIGGProm.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
            cmbCondExenIIGGOpe.setValue( httpContext.cgiGet( cmbCondExenIIGGOpe.getInternalname()) );
            A2238CondExenIIGGOpe = httpContext.cgiGet( cmbCondExenIIGGOpe.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
            A1123CondExenIIGGVar = httpContext.cgiGet( edtCondExenIIGGVar_Internalname) ;
            n1123CondExenIIGGVar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
            n1123CondExenIIGGVar = ((GXutil.strcmp("", A1123CondExenIIGGVar)==0) ? true : false) ;
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCondExenIIGGVFi_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCondExenIIGGVFi_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONDEXENIIGGVFI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCondExenIIGGVFi_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
            }
            else
            {
               A2237CondExenIIGGVFi = localUtil.ctond( httpContext.cgiGet( edtCondExenIIGGVFi_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
            }
            A1108CondexenIIGGNom = httpContext.cgiGet( edtCondexenIIGGNom_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
            dynCondExenRelSec.setValue( httpContext.cgiGet( dynCondExenRelSec.getInternalname()) );
            A2001CondExenRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCondExenRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
            AV28ComboCondExenIIGGCon = httpContext.cgiGet( edtavCombocondexeniiggcon_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28ComboCondExenIIGGCon", AV28ComboCondExenIIGGCon);
            AV24ComboCondExenIIGGVar = httpContext.cgiGet( edtavCombocondexeniiggvar_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCondExenIIGGVar", AV24ComboCondExenIIGGVar);
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
            forbiddenHiddens.add("hshsalt", "hsh"+"condicion_exencion_iigg");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CondRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A2002CondRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("CondExenRelRef", GXutil.rtrim( localUtil.format( A2021CondExenRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1105CondExenIIGG, Z1105CondExenIIGG) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("condicion_exencion_iigg:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1105CondExenIIGG = httpContext.GetPar( "CondExenIIGG") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
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
                  sMode124 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode124 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound124 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_360( ) ;
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
                        e11362 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12362 ();
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
         e12362 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll36124( ) ;
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
         disableAttributes36124( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggcon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggcon_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggvar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggvar_Enabled), 5, 0), true);
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

   public void confirm_360( )
   {
      beforeValidate36124( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls36124( ) ;
         }
         else
         {
            checkExtendedTable36124( ) ;
            closeExtendedTableCursors36124( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption360( )
   {
   }

   public void e11362( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCondExenIIGGVar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGVar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGVar_Visible), 5, 0), true);
      AV24ComboCondExenIIGGVar = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCondExenIIGGVar", AV24ComboCondExenIIGGVar);
      edtavCombocondexeniiggvar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggvar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggvar_Visible), 5, 0), true);
      edtCondExenIIGGCon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGCon_Visible), 5, 0), true);
      AV28ComboCondExenIIGGCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboCondExenIIGGCon", AV28ComboCondExenIIGGCon);
      edtavCombocondexeniiggcon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggcon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggcon_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONDEXENIIGGCON' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCONDEXENIIGGVAR' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg_Insert", GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg_Update", GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg_Delete", GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV32Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV32Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV33GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         while ( AV33GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV33GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CondExenIIGGCon") == 0 )
            {
               AV14Insert_CondExenIIGGCon = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_CondExenIIGGCon", AV14Insert_CondExenIIGGCon);
               if ( ! (GXutil.strcmp("", AV14Insert_CondExenIIGGCon)==0) )
               {
                  AV28ComboCondExenIIGGCon = AV14Insert_CondExenIIGGCon ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV28ComboCondExenIIGGCon", AV28ComboCondExenIIGGCon);
                  Combo_condexeniiggcon_Selectedvalue_set = AV28ComboCondExenIIGGCon ;
                  ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "SelectedValue_set", Combo_condexeniiggcon_Selectedvalue_set);
                  GXt_char6 = AV21Combo_DataJson ;
                  GXv_char7[0] = AV19ComboSelectedValue ;
                  GXv_char8[0] = AV20ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGCon", "GET", false, AV7CliCod, AV8CondExenIIGG, AV30Insert_CliCod, AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  condicion_exencion_iigg_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
                  condicion_exencion_iigg_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
                  condicion_exencion_iigg_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_condexeniiggcon_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "SelectedText_set", Combo_condexeniiggcon_Selectedtext_set);
                  Combo_condexeniiggcon_Enabled = false ;
                  ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "Enabled", GXutil.booltostr( Combo_condexeniiggcon_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CondExenIIGGVar") == 0 )
            {
               AV15Insert_CondExenIIGGVar = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_CondExenIIGGVar", AV15Insert_CondExenIIGGVar);
               if ( ! (GXutil.strcmp("", AV15Insert_CondExenIIGGVar)==0) )
               {
                  AV24ComboCondExenIIGGVar = AV15Insert_CondExenIIGGVar ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCondExenIIGGVar", AV24ComboCondExenIIGGVar);
                  Combo_condexeniiggvar_Selectedvalue_set = AV24ComboCondExenIIGGVar ;
                  ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "SelectedValue_set", Combo_condexeniiggvar_Selectedvalue_set);
                  GXt_char6 = AV21Combo_DataJson ;
                  GXv_char9[0] = AV19ComboSelectedValue ;
                  GXv_char8[0] = AV20ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGVar", "GET", false, AV7CliCod, AV8CondExenIIGG, AV30Insert_CliCod, AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  condicion_exencion_iigg_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
                  condicion_exencion_iigg_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
                  condicion_exencion_iigg_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_condexeniiggvar_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "SelectedText_set", Combo_condexeniiggvar_Selectedtext_set);
                  Combo_condexeniiggvar_Enabled = false ;
                  ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "Enabled", GXutil.booltostr( Combo_condexeniiggvar_Enabled));
               }
            }
            AV33GXV1 = (int)(AV33GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e12362( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.condexengrabarrelref(remoteHandle, context).execute( A3CliCod) ;
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

   public void S132( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divCondexenrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOCONDEXENIIGGVAR' Routine */
      returnInSub = false ;
      Combo_condexeniiggvar_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CondExenIIGGVar\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CondExenIIGG\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "DataListProcParametersPrefix", Combo_condexeniiggvar_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGVar", Gx_mode, false, AV7CliCod, AV8CondExenIIGG, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      condicion_exencion_iigg_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      condicion_exencion_iigg_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      condicion_exencion_iigg_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_condexeniiggvar_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "SelectedValue_set", Combo_condexeniiggvar_Selectedvalue_set);
      Combo_condexeniiggvar_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "SelectedText_set", Combo_condexeniiggvar_Selectedtext_set);
      AV24ComboCondExenIIGGVar = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCondExenIIGGVar", AV24ComboCondExenIIGGVar);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_condexeniiggvar_Enabled = false ;
         ucCombo_condexeniiggvar.sendProperty(context, "", false, Combo_condexeniiggvar_Internalname, "Enabled", GXutil.booltostr( Combo_condexeniiggvar_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCONDEXENIIGGCON' Routine */
      returnInSub = false ;
      Combo_condexeniiggcon_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CondExenIIGGCon\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CondExenIIGG\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "DataListProcParametersPrefix", Combo_condexeniiggcon_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.condicion_exencion_iiggloaddvcombo(remoteHandle, context).execute( "CondExenIIGGCon", Gx_mode, false, AV7CliCod, AV8CondExenIIGG, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      condicion_exencion_iigg_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      condicion_exencion_iigg_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      condicion_exencion_iigg_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_condexeniiggcon_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "SelectedValue_set", Combo_condexeniiggcon_Selectedvalue_set);
      Combo_condexeniiggcon_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "SelectedText_set", Combo_condexeniiggcon_Selectedtext_set);
      AV28ComboCondExenIIGGCon = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboCondExenIIGGCon", AV28ComboCondExenIIGGCon);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_condexeniiggcon_Enabled = false ;
         ucCombo_condexeniiggcon.sendProperty(context, "", false, Combo_condexeniiggcon_Internalname, "Enabled", GXutil.booltostr( Combo_condexeniiggcon_Enabled));
      }
   }

   public void zm36124( int GX_JID )
   {
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1106CondExenIIGGAcu = T00363_A1106CondExenIIGGAcu[0] ;
            Z1107CondExenIIGGProm = T00363_A1107CondExenIIGGProm[0] ;
            Z2237CondExenIIGGVFi = T00363_A2237CondExenIIGGVFi[0] ;
            Z2238CondExenIIGGOpe = T00363_A2238CondExenIIGGOpe[0] ;
            Z1108CondexenIIGGNom = T00363_A1108CondexenIIGGNom[0] ;
            Z2001CondExenRelSec = T00363_A2001CondExenRelSec[0] ;
            Z2002CondRelSecCli = T00363_A2002CondRelSecCli[0] ;
            Z2021CondExenRelRef = T00363_A2021CondExenRelRef[0] ;
            Z1104CondExenIIGGCon = T00363_A1104CondExenIIGGCon[0] ;
            Z1123CondExenIIGGVar = T00363_A1123CondExenIIGGVar[0] ;
         }
         else
         {
            Z1106CondExenIIGGAcu = A1106CondExenIIGGAcu ;
            Z1107CondExenIIGGProm = A1107CondExenIIGGProm ;
            Z2237CondExenIIGGVFi = A2237CondExenIIGGVFi ;
            Z2238CondExenIIGGOpe = A2238CondExenIIGGOpe ;
            Z1108CondexenIIGGNom = A1108CondexenIIGGNom ;
            Z2001CondExenRelSec = A2001CondExenRelSec ;
            Z2002CondRelSecCli = A2002CondRelSecCli ;
            Z2021CondExenRelRef = A2021CondExenRelRef ;
            Z1104CondExenIIGGCon = A1104CondExenIIGGCon ;
            Z1123CondExenIIGGVar = A1123CondExenIIGGVar ;
         }
      }
      if ( GX_JID == -22 )
      {
         Z1105CondExenIIGG = A1105CondExenIIGG ;
         Z1106CondExenIIGGAcu = A1106CondExenIIGGAcu ;
         Z1107CondExenIIGGProm = A1107CondExenIIGGProm ;
         Z2237CondExenIIGGVFi = A2237CondExenIIGGVFi ;
         Z2238CondExenIIGGOpe = A2238CondExenIIGGOpe ;
         Z1108CondexenIIGGNom = A1108CondexenIIGGNom ;
         Z2001CondExenRelSec = A2001CondExenRelSec ;
         Z2002CondRelSecCli = A2002CondRelSecCli ;
         Z2021CondExenRelRef = A2021CondExenRelRef ;
         Z2027CondExenOld = A2027CondExenOld ;
         Z3CliCod = A3CliCod ;
         Z1104CondExenIIGGCon = A1104CondExenIIGGCon ;
         Z1123CondExenIIGGVar = A1123CondExenIIGGVar ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxacondexenrelsec_html36124( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            condicion_exencion_iigg_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynCondExenRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCondExenRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCondExenRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8CondExenIIGG)==0) )
      {
         A1105CondExenIIGG = AV8CondExenIIGG ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
      }
      if ( ! (GXutil.strcmp("", AV8CondExenIIGG)==0) )
      {
         edtCondExenIIGG_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGG_Enabled), 5, 0), true);
      }
      else
      {
         edtCondExenIIGG_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGG_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8CondExenIIGG)==0) )
      {
         edtCondExenIIGG_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGG_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_CondExenIIGGCon)==0) )
      {
         edtCondExenIIGGCon_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGCon_Enabled), 5, 0), true);
      }
      else
      {
         edtCondExenIIGGCon_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGCon_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_CondExenIIGGVar)==0) )
      {
         edtCondExenIIGGVar_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGVar_Enabled), 5, 0), true);
      }
      else
      {
         edtCondExenIIGGVar_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGVar_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_CondExenIIGGCon)==0) )
      {
         A1104CondExenIIGGCon = AV14Insert_CondExenIIGGCon ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
      }
      else
      {
         A1104CondExenIIGGCon = AV28ComboCondExenIIGGCon ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_CondExenIIGGVar)==0) )
      {
         A1123CondExenIIGGVar = AV15Insert_CondExenIIGGVar ;
         n1123CondExenIIGGVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
      }
      else
      {
         if ( (GXutil.strcmp("", AV24ComboCondExenIIGGVar)==0) )
         {
            A1123CondExenIIGGVar = "" ;
            n1123CondExenIIGGVar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
            n1123CondExenIIGGVar = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV24ComboCondExenIIGGVar)==0) )
            {
               A1123CondExenIIGGVar = AV24ComboCondExenIIGGVar ;
               n1123CondExenIIGGVar = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
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
         AV32Pgmname = "condicion_exencion_iigg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      }
   }

   public void load36124( )
   {
      /* Using cursor T00366 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound124 = (short)(1) ;
         A1106CondExenIIGGAcu = T00366_A1106CondExenIIGGAcu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
         A1107CondExenIIGGProm = T00366_A1107CondExenIIGGProm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
         A2237CondExenIIGGVFi = T00366_A2237CondExenIIGGVFi[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
         A2238CondExenIIGGOpe = T00366_A2238CondExenIIGGOpe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
         A1108CondexenIIGGNom = T00366_A1108CondexenIIGGNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
         A2001CondExenRelSec = T00366_A2001CondExenRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
         A2002CondRelSecCli = T00366_A2002CondRelSecCli[0] ;
         A2021CondExenRelRef = T00366_A2021CondExenRelRef[0] ;
         A2027CondExenOld = T00366_A2027CondExenOld[0] ;
         A1104CondExenIIGGCon = T00366_A1104CondExenIIGGCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
         A1123CondExenIIGGVar = T00366_A1123CondExenIIGGVar[0] ;
         n1123CondExenIIGGVar = T00366_n1123CondExenIIGGVar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
         zm36124( -22) ;
      }
      pr_default.close(4);
      onLoadActions36124( ) ;
   }

   public void onLoadActions36124( )
   {
      AV32Pgmname = "condicion_exencion_iigg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) )
      {
         divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) )
         {
            divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable36124( )
   {
      nIsDirty_124 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV32Pgmname = "condicion_exencion_iigg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV31aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2001CondExenRelSec, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.AV31aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31aplicadoHay", AV31aplicadoHay);
      }
      /* Using cursor T00364 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1104CondExenIIGGCon});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion Exen Conc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGCON");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T00365 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1123CondExenIIGGVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condi Exen Var Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) )
      {
         divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) )
         {
            divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
         }
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) && (0==A2001CondExenRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONDEXENIIGG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCondExenIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2238CondExenIIGGOpe, "menor") == 0 ) || ( GXutil.strcmp(A2238CondExenIIGGOpe, "mayor") == 0 ) || ( GXutil.strcmp(A2238CondExenIIGGOpe, "igual") == 0 ) || ( GXutil.strcmp(A2238CondExenIIGGOpe, "menorOIgual") == 0 ) || ( GXutil.strcmp(A2238CondExenIIGGOpe, "mayorOIgual") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Operador de comparación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONDEXENIIGGOPE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCondExenIIGGOpe.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors36124( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( int A3CliCod ,
                          String A1104CondExenIIGGCon )
   {
      /* Using cursor T00367 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A1104CondExenIIGGCon});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion Exen Conc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGCON");
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

   public void gxload_24( int A3CliCod ,
                          String A1123CondExenIIGGVar )
   {
      /* Using cursor T00368 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1123CondExenIIGGVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condi Exen Var Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
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

   public void getKey36124( )
   {
      /* Using cursor T00369 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound124 = (short)(1) ;
      }
      else
      {
         RcdFound124 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00363 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm36124( 22) ;
         RcdFound124 = (short)(1) ;
         A1105CondExenIIGG = T00363_A1105CondExenIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
         A1106CondExenIIGGAcu = T00363_A1106CondExenIIGGAcu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
         A1107CondExenIIGGProm = T00363_A1107CondExenIIGGProm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
         A2237CondExenIIGGVFi = T00363_A2237CondExenIIGGVFi[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
         A2238CondExenIIGGOpe = T00363_A2238CondExenIIGGOpe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
         A1108CondexenIIGGNom = T00363_A1108CondexenIIGGNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
         A2001CondExenRelSec = T00363_A2001CondExenRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
         A2002CondRelSecCli = T00363_A2002CondRelSecCli[0] ;
         A2021CondExenRelRef = T00363_A2021CondExenRelRef[0] ;
         A2027CondExenOld = T00363_A2027CondExenOld[0] ;
         A3CliCod = T00363_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1104CondExenIIGGCon = T00363_A1104CondExenIIGGCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
         A1123CondExenIIGGVar = T00363_A1123CondExenIIGGVar[0] ;
         n1123CondExenIIGGVar = T00363_n1123CondExenIIGGVar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
         O1108CondexenIIGGNom = A1108CondexenIIGGNom ;
         httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
         O1123CondExenIIGGVar = A1123CondExenIIGGVar ;
         n1123CondExenIIGGVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
         O1107CondExenIIGGProm = A1107CondExenIIGGProm ;
         httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
         O1106CondExenIIGGAcu = A1106CondExenIIGGAcu ;
         httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
         O1104CondExenIIGGCon = A1104CondExenIIGGCon ;
         httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
         O1105CondExenIIGG = A1105CondExenIIGG ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
         Z3CliCod = A3CliCod ;
         Z1105CondExenIIGG = A1105CondExenIIGG ;
         sMode124 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load36124( ) ;
         if ( AnyError == 1 )
         {
            RcdFound124 = (short)(0) ;
            initializeNonKey36124( ) ;
         }
         Gx_mode = sMode124 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound124 = (short)(0) ;
         initializeNonKey36124( ) ;
         sMode124 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode124 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey36124( ) ;
      if ( RcdFound124 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound124 = (short)(0) ;
      /* Using cursor T003610 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1105CondExenIIGG});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T003610_A3CliCod[0] < A3CliCod ) || ( T003610_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003610_A1105CondExenIIGG[0], A1105CondExenIIGG) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T003610_A3CliCod[0] > A3CliCod ) || ( T003610_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003610_A1105CondExenIIGG[0], A1105CondExenIIGG) > 0 ) ) )
         {
            A3CliCod = T003610_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1105CondExenIIGG = T003610_A1105CondExenIIGG[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
            RcdFound124 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound124 = (short)(0) ;
      /* Using cursor T003611 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1105CondExenIIGG});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T003611_A3CliCod[0] > A3CliCod ) || ( T003611_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003611_A1105CondExenIIGG[0], A1105CondExenIIGG) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T003611_A3CliCod[0] < A3CliCod ) || ( T003611_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T003611_A1105CondExenIIGG[0], A1105CondExenIIGG) < 0 ) ) )
         {
            A3CliCod = T003611_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1105CondExenIIGG = T003611_A1105CondExenIIGG[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
            RcdFound124 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey36124( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCondExenIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert36124( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound124 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1105CondExenIIGG, Z1105CondExenIIGG) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1105CondExenIIGG = Z1105CondExenIIGG ;
               httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCondExenIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update36124( ) ;
               GX_FocusControl = edtCondExenIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1105CondExenIIGG, Z1105CondExenIIGG) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCondExenIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert36124( ) ;
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
                  GX_FocusControl = edtCondExenIIGG_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert36124( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A1105CondExenIIGG, Z1105CondExenIIGG) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1105CondExenIIGG = Z1105CondExenIIGG ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCondExenIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency36124( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00362 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"condicion_exencion_iigg"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1106CondExenIIGGAcu != T00362_A1106CondExenIIGGAcu[0] ) || ( Z1107CondExenIIGGProm != T00362_A1107CondExenIIGGProm[0] ) || ( DecimalUtil.compareTo(Z2237CondExenIIGGVFi, T00362_A2237CondExenIIGGVFi[0]) != 0 ) || ( GXutil.strcmp(Z2238CondExenIIGGOpe, T00362_A2238CondExenIIGGOpe[0]) != 0 ) || ( GXutil.strcmp(Z1108CondexenIIGGNom, T00362_A1108CondexenIIGGNom[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2001CondExenRelSec != T00362_A2001CondExenRelSec[0] ) || ( Z2002CondRelSecCli != T00362_A2002CondRelSecCli[0] ) || ( GXutil.strcmp(Z2021CondExenRelRef, T00362_A2021CondExenRelRef[0]) != 0 ) || ( GXutil.strcmp(Z1104CondExenIIGGCon, T00362_A1104CondExenIIGGCon[0]) != 0 ) || ( GXutil.strcmp(Z1123CondExenIIGGVar, T00362_A1123CondExenIIGGVar[0]) != 0 ) )
         {
            if ( Z1106CondExenIIGGAcu != T00362_A1106CondExenIIGGAcu[0] )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGAcu");
               GXutil.writeLogRaw("Old: ",Z1106CondExenIIGGAcu);
               GXutil.writeLogRaw("Current: ",T00362_A1106CondExenIIGGAcu[0]);
            }
            if ( Z1107CondExenIIGGProm != T00362_A1107CondExenIIGGProm[0] )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGProm");
               GXutil.writeLogRaw("Old: ",Z1107CondExenIIGGProm);
               GXutil.writeLogRaw("Current: ",T00362_A1107CondExenIIGGProm[0]);
            }
            if ( DecimalUtil.compareTo(Z2237CondExenIIGGVFi, T00362_A2237CondExenIIGGVFi[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGVFi");
               GXutil.writeLogRaw("Old: ",Z2237CondExenIIGGVFi);
               GXutil.writeLogRaw("Current: ",T00362_A2237CondExenIIGGVFi[0]);
            }
            if ( GXutil.strcmp(Z2238CondExenIIGGOpe, T00362_A2238CondExenIIGGOpe[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGOpe");
               GXutil.writeLogRaw("Old: ",Z2238CondExenIIGGOpe);
               GXutil.writeLogRaw("Current: ",T00362_A2238CondExenIIGGOpe[0]);
            }
            if ( GXutil.strcmp(Z1108CondexenIIGGNom, T00362_A1108CondexenIIGGNom[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondexenIIGGNom");
               GXutil.writeLogRaw("Old: ",Z1108CondexenIIGGNom);
               GXutil.writeLogRaw("Current: ",T00362_A1108CondexenIIGGNom[0]);
            }
            if ( Z2001CondExenRelSec != T00362_A2001CondExenRelSec[0] )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenRelSec");
               GXutil.writeLogRaw("Old: ",Z2001CondExenRelSec);
               GXutil.writeLogRaw("Current: ",T00362_A2001CondExenRelSec[0]);
            }
            if ( Z2002CondRelSecCli != T00362_A2002CondRelSecCli[0] )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondRelSecCli");
               GXutil.writeLogRaw("Old: ",Z2002CondRelSecCli);
               GXutil.writeLogRaw("Current: ",T00362_A2002CondRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z2021CondExenRelRef, T00362_A2021CondExenRelRef[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenRelRef");
               GXutil.writeLogRaw("Old: ",Z2021CondExenRelRef);
               GXutil.writeLogRaw("Current: ",T00362_A2021CondExenRelRef[0]);
            }
            if ( GXutil.strcmp(Z1104CondExenIIGGCon, T00362_A1104CondExenIIGGCon[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGCon");
               GXutil.writeLogRaw("Old: ",Z1104CondExenIIGGCon);
               GXutil.writeLogRaw("Current: ",T00362_A1104CondExenIIGGCon[0]);
            }
            if ( GXutil.strcmp(Z1123CondExenIIGGVar, T00362_A1123CondExenIIGGVar[0]) != 0 )
            {
               GXutil.writeLogln("condicion_exencion_iigg:[seudo value changed for attri]"+"CondExenIIGGVar");
               GXutil.writeLogRaw("Old: ",Z1123CondExenIIGGVar);
               GXutil.writeLogRaw("Current: ",T00362_A1123CondExenIIGGVar[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"condicion_exencion_iigg"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert36124( )
   {
      beforeValidate36124( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable36124( ) ;
      }
      if ( AnyError == 0 )
      {
         zm36124( 0) ;
         checkOptimisticConcurrency36124( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm36124( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert36124( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003612 */
                  pr_default.execute(10, new Object[] {A1105CondExenIIGG, Boolean.valueOf(A1106CondExenIIGGAcu), Boolean.valueOf(A1107CondExenIIGGProm), A2237CondExenIIGGVFi, A2238CondExenIIGGOpe, A1108CondexenIIGGNom, Integer.valueOf(A2001CondExenRelSec), Integer.valueOf(A2002CondRelSecCli), A2021CondExenRelRef, A2027CondExenOld, Integer.valueOf(A3CliCod), A1104CondExenIIGGCon, Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("condicion_exencion_iigg");
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
                        resetCaption360( ) ;
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
            load36124( ) ;
         }
         endLevel36124( ) ;
      }
      closeExtendedTableCursors36124( ) ;
   }

   public void update36124( )
   {
      beforeValidate36124( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable36124( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency36124( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm36124( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate36124( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003613 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(A1106CondExenIIGGAcu), Boolean.valueOf(A1107CondExenIIGGProm), A2237CondExenIIGGVFi, A2238CondExenIIGGOpe, A1108CondexenIIGGNom, Integer.valueOf(A2001CondExenRelSec), Integer.valueOf(A2002CondRelSecCli), A2021CondExenRelRef, A2027CondExenOld, A1104CondExenIIGGCon, Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar, Integer.valueOf(A3CliCod), A1105CondExenIIGG});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("condicion_exencion_iigg");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"condicion_exencion_iigg"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate36124( ) ;
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
         endLevel36124( ) ;
      }
      closeExtendedTableCursors36124( ) ;
   }

   public void deferredUpdate36124( )
   {
   }

   public void delete( )
   {
      beforeValidate36124( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency36124( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls36124( ) ;
         afterConfirm36124( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete36124( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003614 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("condicion_exencion_iigg");
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
      sMode124 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel36124( ) ;
      Gx_mode = sMode124 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls36124( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV31aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2001CondExenRelSec, GXv_boolean5) ;
            condicion_exencion_iigg_impl.this.AV31aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31aplicadoHay", AV31aplicadoHay);
         }
         AV32Pgmname = "condicion_exencion_iigg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) )
         {
            divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean4 = false ;
            GXv_boolean5[0] = GXt_boolean4 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
            condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
            if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) )
            {
               divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003615 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A1105CondExenIIGG});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel36124( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete36124( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "condicion_exencion_iigg");
         if ( AnyError == 0 )
         {
            confirmValues360( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "condicion_exencion_iigg");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart36124( )
   {
      /* Scan By routine */
      /* Using cursor T003616 */
      pr_default.execute(14);
      RcdFound124 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound124 = (short)(1) ;
         A3CliCod = T003616_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1105CondExenIIGG = T003616_A1105CondExenIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext36124( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound124 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound124 = (short)(1) ;
         A3CliCod = T003616_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1105CondExenIIGG = T003616_A1105CondExenIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
      }
   }

   public void scanEnd36124( )
   {
      pr_default.close(14);
   }

   public void afterConfirm36124( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV31aplicadoHay ) && ! (0==A2001CondExenRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "CondExenRelSec", 1, "CONDEXENRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCondExenRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert36124( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate36124( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete36124( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete36124( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate36124( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes36124( )
   {
      edtCondExenIIGG_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGG_Enabled), 5, 0), true);
      edtCondExenIIGGCon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGCon_Enabled), 5, 0), true);
      chkCondExenIIGGAcu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCondExenIIGGAcu.getInternalname(), "Enabled", GXutil.ltrimstr( chkCondExenIIGGAcu.getEnabled(), 5, 0), true);
      chkCondExenIIGGProm.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCondExenIIGGProm.getInternalname(), "Enabled", GXutil.ltrimstr( chkCondExenIIGGProm.getEnabled(), 5, 0), true);
      cmbCondExenIIGGOpe.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCondExenIIGGOpe.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCondExenIIGGOpe.getEnabled(), 5, 0), true);
      edtCondExenIIGGVar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGVar_Enabled), 5, 0), true);
      edtCondExenIIGGVFi_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondExenIIGGVFi_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondExenIIGGVFi_Enabled), 5, 0), true);
      edtCondexenIIGGNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCondexenIIGGNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCondexenIIGGNom_Enabled), 5, 0), true);
      dynCondExenRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCondExenRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCondExenRelSec.getEnabled(), 5, 0), true);
      edtavCombocondexeniiggcon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggcon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggcon_Enabled), 5, 0), true);
      edtavCombocondexeniiggvar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocondexeniiggvar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocondexeniiggvar_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes36124( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues360( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.condicion_exencion_iigg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8CondExenIIGG))}, new String[] {"Gx_mode","CliCod","CondExenIIGG"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"condicion_exencion_iigg");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CondRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A2002CondRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("CondExenRelRef", GXutil.rtrim( localUtil.format( A2021CondExenRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("condicion_exencion_iigg:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1105CondExenIIGG", GXutil.rtrim( Z1105CondExenIIGG));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1106CondExenIIGGAcu", Z1106CondExenIIGGAcu);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1107CondExenIIGGProm", Z1107CondExenIIGGProm);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2237CondExenIIGGVFi", GXutil.ltrim( localUtil.ntoc( Z2237CondExenIIGGVFi, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2238CondExenIIGGOpe", GXutil.rtrim( Z2238CondExenIIGGOpe));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1108CondexenIIGGNom", Z1108CondexenIIGGNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2001CondExenRelSec", GXutil.ltrim( localUtil.ntoc( Z2001CondExenRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2002CondRelSecCli", GXutil.ltrim( localUtil.ntoc( Z2002CondRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2021CondExenRelRef", Z2021CondExenRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1104CondExenIIGGCon", GXutil.rtrim( Z1104CondExenIIGGCon));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1123CondExenIIGGVar", GXutil.rtrim( Z1123CondExenIIGGVar));
      web.GxWebStd.gx_hidden_field( httpContext, "O1108CondexenIIGGNom", O1108CondexenIIGGNom);
      web.GxWebStd.gx_hidden_field( httpContext, "O1123CondExenIIGGVar", GXutil.rtrim( O1123CondExenIIGGVar));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1107CondExenIIGGProm", O1107CondExenIIGGProm);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1106CondExenIIGGAcu", O1106CondExenIIGGAcu);
      web.GxWebStd.gx_hidden_field( httpContext, "O1104CondExenIIGGCon", GXutil.rtrim( O1104CondExenIIGGCon));
      web.GxWebStd.gx_hidden_field( httpContext, "O1105CondExenIIGG", GXutil.rtrim( O1105CondExenIIGG));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1104CondExenIIGGCon", GXutil.rtrim( A1104CondExenIIGGCon));
      web.GxWebStd.gx_hidden_field( httpContext, "N1123CondExenIIGGVar", GXutil.rtrim( A1123CondExenIIGGVar));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONDEXENIIGGCON_DATA", AV27CondExenIIGGCon_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONDEXENIIGGCON_DATA", AV27CondExenIIGGCon_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONDEXENIIGGVAR_DATA", AV23CondExenIIGGVar_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONDEXENIIGGVAR_DATA", AV23CondExenIIGGVar_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONDEXENIIGG", GXutil.rtrim( AV8CondExenIIGG));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONDEXENIIGG", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8CondExenIIGG, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONDEXENIIGGCON", GXutil.rtrim( AV14Insert_CondExenIIGGCon));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONDEXENIIGGVAR", GXutil.rtrim( AV15Insert_CondExenIIGGVar));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV31aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDRELSECCLI", GXutil.ltrim( localUtil.ntoc( A2002CondRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONDEXENRELREF", A2021CondExenRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDEXENOLD", A2027CondExenOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV32Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Objectcall", GXutil.rtrim( Combo_condexeniiggcon_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Cls", GXutil.rtrim( Combo_condexeniiggcon_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Selectedvalue_set", GXutil.rtrim( Combo_condexeniiggcon_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Selectedtext_set", GXutil.rtrim( Combo_condexeniiggcon_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Enabled", GXutil.booltostr( Combo_condexeniiggcon_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Datalistproc", GXutil.rtrim( Combo_condexeniiggcon_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Datalistprocparametersprefix", GXutil.rtrim( Combo_condexeniiggcon_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGCON_Emptyitem", GXutil.booltostr( Combo_condexeniiggcon_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Objectcall", GXutil.rtrim( Combo_condexeniiggvar_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Cls", GXutil.rtrim( Combo_condexeniiggvar_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Selectedvalue_set", GXutil.rtrim( Combo_condexeniiggvar_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Selectedtext_set", GXutil.rtrim( Combo_condexeniiggvar_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Enabled", GXutil.booltostr( Combo_condexeniiggvar_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Datalistproc", GXutil.rtrim( Combo_condexeniiggvar_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONDEXENIIGGVAR_Datalistprocparametersprefix", GXutil.rtrim( Combo_condexeniiggvar_Datalistprocparametersprefix));
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
      return formatLink("web.condicion_exencion_iigg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8CondExenIIGG))}, new String[] {"Gx_mode","CliCod","CondExenIIGG"})  ;
   }

   public String getPgmname( )
   {
      return "condicion_exencion_iigg" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "condicion_exencion_iigg", "") ;
   }

   public void initializeNonKey36124( )
   {
      A1104CondExenIIGGCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
      A1123CondExenIIGGVar = "" ;
      n1123CondExenIIGGVar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
      n1123CondExenIIGGVar = ((GXutil.strcmp("", A1123CondExenIIGGVar)==0) ? true : false) ;
      AV31aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31aplicadoHay", AV31aplicadoHay);
      A1106CondExenIIGGAcu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
      A1107CondExenIIGGProm = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2237CondExenIIGGVFi", GXutil.ltrimstr( A2237CondExenIIGGVFi, 14, 2));
      A2238CondExenIIGGOpe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
      A1108CondexenIIGGNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
      A2001CondExenRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2001CondExenRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2001CondExenRelSec), 6, 0));
      A2002CondRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2002CondRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2002CondRelSecCli), 6, 0));
      A2021CondExenRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2021CondExenRelRef", A2021CondExenRelRef);
      A2027CondExenOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2027CondExenOld", A2027CondExenOld);
      O1108CondexenIIGGNom = A1108CondexenIIGGNom ;
      httpContext.ajax_rsp_assign_attri("", false, "A1108CondexenIIGGNom", A1108CondexenIIGGNom);
      O1123CondExenIIGGVar = A1123CondExenIIGGVar ;
      n1123CondExenIIGGVar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1123CondExenIIGGVar", A1123CondExenIIGGVar);
      O1107CondExenIIGGProm = A1107CondExenIIGGProm ;
      httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
      O1106CondExenIIGGAcu = A1106CondExenIIGGAcu ;
      httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
      O1104CondExenIIGGCon = A1104CondExenIIGGCon ;
      httpContext.ajax_rsp_assign_attri("", false, "A1104CondExenIIGGCon", A1104CondExenIIGGCon);
      Z1106CondExenIIGGAcu = false ;
      Z1107CondExenIIGGProm = false ;
      Z2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      Z2238CondExenIIGGOpe = "" ;
      Z1108CondexenIIGGNom = "" ;
      Z2001CondExenRelSec = 0 ;
      Z2002CondRelSecCli = 0 ;
      Z2021CondExenRelRef = "" ;
      Z1104CondExenIIGGCon = "" ;
      Z1123CondExenIIGGVar = "" ;
   }

   public void initAll36124( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1105CondExenIIGG = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1105CondExenIIGG", A1105CondExenIIGG);
      initializeNonKey36124( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251816595768", true, true);
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
      httpContext.AddJavascriptSource("condicion_exencion_iigg.js", "?20251816595768", false, true);
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
      edtCondExenIIGG_Internalname = "CONDEXENIIGG" ;
      lblTextblockcondexeniiggcon_Internalname = "TEXTBLOCKCONDEXENIIGGCON" ;
      Combo_condexeniiggcon_Internalname = "COMBO_CONDEXENIIGGCON" ;
      edtCondExenIIGGCon_Internalname = "CONDEXENIIGGCON" ;
      divTablesplittedcondexeniiggcon_Internalname = "TABLESPLITTEDCONDEXENIIGGCON" ;
      chkCondExenIIGGAcu.setInternalname( "CONDEXENIIGGACU" );
      chkCondExenIIGGProm.setInternalname( "CONDEXENIIGGPROM" );
      cmbCondExenIIGGOpe.setInternalname( "CONDEXENIIGGOPE" );
      lblTextblockcondexeniiggvar_Internalname = "TEXTBLOCKCONDEXENIIGGVAR" ;
      Combo_condexeniiggvar_Internalname = "COMBO_CONDEXENIIGGVAR" ;
      edtCondExenIIGGVar_Internalname = "CONDEXENIIGGVAR" ;
      divTablesplittedcondexeniiggvar_Internalname = "TABLESPLITTEDCONDEXENIIGGVAR" ;
      edtCondExenIIGGVFi_Internalname = "CONDEXENIIGGVFI" ;
      edtCondexenIIGGNom_Internalname = "CONDEXENIIGGNOM" ;
      dynCondExenRelSec.setInternalname( "CONDEXENRELSEC" );
      divCondexenrelsec_cell_Internalname = "CONDEXENRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocondexeniiggcon_Internalname = "vCOMBOCONDEXENIIGGCON" ;
      divSectionattribute_condexeniiggcon_Internalname = "SECTIONATTRIBUTE_CONDEXENIIGGCON" ;
      edtavCombocondexeniiggvar_Internalname = "vCOMBOCONDEXENIIGGVAR" ;
      divSectionattribute_condexeniiggvar_Internalname = "SECTIONATTRIBUTE_CONDEXENIIGGVAR" ;
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
      Form.setCaption( httpContext.getMessage( "condicion_exencion_iigg", "") );
      Combo_condexeniiggcon_Datalistprocparametersprefix = "" ;
      Combo_condexeniiggvar_Datalistprocparametersprefix = "" ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombocondexeniiggvar_Jsonclick = "" ;
      edtavCombocondexeniiggvar_Enabled = 0 ;
      edtavCombocondexeniiggvar_Visible = 1 ;
      edtavCombocondexeniiggcon_Jsonclick = "" ;
      edtavCombocondexeniiggcon_Enabled = 0 ;
      edtavCombocondexeniiggcon_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynCondExenRelSec.setJsonclick( "" );
      dynCondExenRelSec.setEnabled( 1 );
      dynCondExenRelSec.setVisible( 1 );
      divCondexenrelsec_cell_Class = "col-xs-12" ;
      edtCondexenIIGGNom_Enabled = 1 ;
      edtCondExenIIGGVFi_Jsonclick = "" ;
      edtCondExenIIGGVFi_Enabled = 1 ;
      edtCondExenIIGGVar_Jsonclick = "" ;
      edtCondExenIIGGVar_Enabled = 1 ;
      edtCondExenIIGGVar_Visible = 1 ;
      Combo_condexeniiggvar_Datalistproc = "condicion_exencion_iiggLoadDVCombo" ;
      Combo_condexeniiggvar_Cls = "ExtendedCombo Attribute" ;
      Combo_condexeniiggvar_Caption = "" ;
      Combo_condexeniiggvar_Enabled = GXutil.toBoolean( -1) ;
      cmbCondExenIIGGOpe.setJsonclick( "" );
      cmbCondExenIIGGOpe.setEnabled( 1 );
      chkCondExenIIGGProm.setEnabled( 1 );
      chkCondExenIIGGAcu.setEnabled( 1 );
      edtCondExenIIGGCon_Jsonclick = "" ;
      edtCondExenIIGGCon_Enabled = 1 ;
      edtCondExenIIGGCon_Visible = 1 ;
      Combo_condexeniiggcon_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_condexeniiggcon_Datalistproc = "condicion_exencion_iiggLoadDVCombo" ;
      Combo_condexeniiggcon_Cls = "ExtendedCombo Attribute" ;
      Combo_condexeniiggcon_Caption = "" ;
      Combo_condexeniiggcon_Enabled = GXutil.toBoolean( -1) ;
      edtCondExenIIGG_Jsonclick = "" ;
      edtCondExenIIGG_Enabled = 1 ;
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

   public void gxdlacondexenrelsec36124( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacondexenrelsec_data36124( AV7CliCod) ;
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

   public void gxacondexenrelsec_html36124( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlacondexenrelsec_data36124( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCondExenRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCondExenRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacondexenrelsec_data36124( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003617 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003617_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003617_A1880CliReDTChar[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gx4asaclicod36124( int AV7CliCod )
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
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            condicion_exencion_iigg_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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

   public void gxasa200136124( int AV7CliCod )
   {
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynCondExenRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCondExenRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCondExenRelSec.getVisible(), 5, 0), true);
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

   public void xc_20_36124( String Gx_mode ,
                            int AV7CliCod ,
                            int A2001CondExenRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV31aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2001CondExenRelSec, GXv_boolean5) ;
         AV31aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31aplicadoHay", AV31aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV31aplicadoHay))+"\"") ;
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
      chkCondExenIIGGAcu.setName( "CONDEXENIIGGACU" );
      chkCondExenIIGGAcu.setWebtags( "" );
      chkCondExenIIGGAcu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCondExenIIGGAcu.getInternalname(), "TitleCaption", chkCondExenIIGGAcu.getCaption(), true);
      chkCondExenIIGGAcu.setCheckedValue( "false" );
      A1106CondExenIIGGAcu = GXutil.strtobool( GXutil.booltostr( A1106CondExenIIGGAcu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1106CondExenIIGGAcu", A1106CondExenIIGGAcu);
      chkCondExenIIGGProm.setName( "CONDEXENIIGGPROM" );
      chkCondExenIIGGProm.setWebtags( "" );
      chkCondExenIIGGProm.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCondExenIIGGProm.getInternalname(), "TitleCaption", chkCondExenIIGGProm.getCaption(), true);
      chkCondExenIIGGProm.setCheckedValue( "false" );
      A1107CondExenIIGGProm = GXutil.strtobool( GXutil.booltostr( A1107CondExenIIGGProm)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1107CondExenIIGGProm", A1107CondExenIIGGProm);
      cmbCondExenIIGGOpe.setName( "CONDEXENIIGGOPE" );
      cmbCondExenIIGGOpe.setWebtags( "" );
      cmbCondExenIIGGOpe.addItem("menor", "<", (short)(0));
      cmbCondExenIIGGOpe.addItem("mayor", ">", (short)(0));
      cmbCondExenIIGGOpe.addItem("igual", "=", (short)(0));
      cmbCondExenIIGGOpe.addItem("menorOIgual", "<=", (short)(0));
      cmbCondExenIIGGOpe.addItem("mayorOIgual", ">=", (short)(0));
      if ( cmbCondExenIIGGOpe.getItemCount() > 0 )
      {
         A2238CondExenIIGGOpe = cmbCondExenIIGGOpe.getValidValue(A2238CondExenIIGGOpe) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2238CondExenIIGGOpe", A2238CondExenIIGGOpe);
      }
      dynCondExenRelSec.setName( "CONDEXENRELSEC" );
      dynCondExenRelSec.setWebtags( "" );
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

   public void valid_Condexeniiggcon( )
   {
      A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValue())) ;
      /* Using cursor T003618 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A1104CondExenIIGGCon});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion Exen Conc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGCON");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Condexeniiggvar( )
   {
      n1123CondExenIIGGVar = false ;
      A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValue())) ;
      /* Using cursor T003619 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1123CondExenIIGGVar), A1123CondExenIIGGVar});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1123CondExenIIGGVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condi Exen Var Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDEXENIIGGVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Condexeniiggnom( )
   {
      n1123CondExenIIGGVar = false ;
      A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValue())) ;
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) )
      {
         divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) )
         {
            divCondexenrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divCondexenrelsec_cell_Internalname, "Class", divCondexenrelsec_cell_Class, true);
   }

   public void valid_Condexenrelsec( )
   {
      n1123CondExenIIGGVar = false ;
      A2001CondExenRelSec = (int)(GXutil.lval( dynCondExenRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A1105CondExenIIGG, O1105CondExenIIGG) != 0 ) || ( GXutil.strcmp(A1104CondExenIIGGCon, O1104CondExenIIGGCon) != 0 ) || ( A1106CondExenIIGGAcu != O1106CondExenIIGGAcu ) || ( A1107CondExenIIGGProm != O1107CondExenIIGGProm ) || ( GXutil.strcmp(A1123CondExenIIGGVar, O1123CondExenIIGGVar) != 0 ) || ( GXutil.strcmp(A1108CondexenIIGGNom, O1108CondexenIIGGNom) != 0 ) ) ) && (0==A2001CondExenRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONDEXENRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCondExenRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV31aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2001CondExenRelSec, GXv_boolean5) ;
         condicion_exencion_iigg_impl.this.AV31aplicadoHay = GXv_boolean5[0] ;
         AV31aplicadoHay = this.AV31aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV31aplicadoHay", AV31aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CondExenIIGG',fld:'vCONDEXENIIGG',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CondExenIIGG',fld:'vCONDEXENIIGG',pic:'',hsh:true},{av:'A2002CondRelSecCli',fld:'CONDRELSECCLI',pic:'ZZZZZ9'},{av:'A2021CondExenRelRef',fld:'CONDEXENRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12362',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGG","{handler:'valid_Condexeniigg',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGCON","{handler:'valid_Condexeniiggcon',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1104CondExenIIGGCon',fld:'CONDEXENIIGGCON',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGCON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGACU","{handler:'valid_Condexeniiggacu',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGACU",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGPROM","{handler:'valid_Condexeniiggprom',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGPROM",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGOPE","{handler:'valid_Condexeniiggope',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGOPE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGVAR","{handler:'valid_Condexeniiggvar',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1123CondExenIIGGVar',fld:'CONDEXENIIGGVAR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGVAR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENIIGGNOM","{handler:'valid_Condexeniiggnom',iparms:[{av:'O1108CondexenIIGGNom'},{av:'O1123CondExenIIGGVar'},{av:'O1107CondExenIIGGProm'},{av:'O1106CondExenIIGGAcu'},{av:'O1104CondExenIIGGCon'},{av:'O1105CondExenIIGG'},{av:'A1105CondExenIIGG',fld:'CONDEXENIIGG',pic:''},{av:'A1104CondExenIIGGCon',fld:'CONDEXENIIGGCON',pic:''},{av:'A1123CondExenIIGGVar',fld:'CONDEXENIIGGVAR',pic:''},{av:'A1108CondexenIIGGNom',fld:'CONDEXENIIGGNOM',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENIIGGNOM",",oparms:[{av:'divCondexenrelsec_cell_Class',ctrl:'CONDEXENRELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CONDEXENRELSEC","{handler:'valid_Condexenrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1108CondexenIIGGNom'},{av:'O1123CondExenIIGGVar'},{av:'O1107CondExenIIGGProm'},{av:'O1106CondExenIIGGAcu'},{av:'O1104CondExenIIGGCon'},{av:'O1105CondExenIIGG'},{av:'A1105CondExenIIGG',fld:'CONDEXENIIGG',pic:''},{av:'A1104CondExenIIGGCon',fld:'CONDEXENIIGGCON',pic:''},{av:'A1123CondExenIIGGVar',fld:'CONDEXENIIGGVAR',pic:''},{av:'A1108CondexenIIGGNom',fld:'CONDEXENIIGGNOM',pic:''},{av:'AV31aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CONDEXENRELSEC",",oparms:[{av:'AV31aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONDEXENIIGGCON","{handler:'validv_Combocondexeniiggcon',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALIDV_COMBOCONDEXENIIGGCON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONDEXENIIGGVAR","{handler:'validv_Combocondexeniiggvar',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALIDV_COMBOCONDEXENIIGGVAR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCondExenRelSec'},{av:'A2001CondExenRelSec',fld:'CONDEXENRELSEC',pic:'ZZZZZ9'},{av:'A1106CondExenIIGGAcu',fld:'CONDEXENIIGGACU',pic:''},{av:'A1107CondExenIIGGProm',fld:'CONDEXENIIGGPROM',pic:''}]}");
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
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8CondExenIIGG = "" ;
      Z1105CondExenIIGG = "" ;
      Z2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      Z2238CondExenIIGGOpe = "" ;
      Z1108CondexenIIGGNom = "" ;
      Z2021CondExenRelRef = "" ;
      Z1104CondExenIIGGCon = "" ;
      Z1123CondExenIIGGVar = "" ;
      O1108CondexenIIGGNom = "" ;
      O1123CondExenIIGGVar = "" ;
      O1104CondExenIIGGCon = "" ;
      O1105CondExenIIGG = "" ;
      N1104CondExenIIGGCon = "" ;
      N1123CondExenIIGGVar = "" ;
      Combo_condexeniiggvar_Selectedvalue_get = "" ;
      Combo_condexeniiggcon_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1104CondExenIIGGCon = "" ;
      A1123CondExenIIGGVar = "" ;
      AV8CondExenIIGG = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2238CondExenIIGGOpe = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1105CondExenIIGG = "" ;
      lblTextblockcondexeniiggcon_Jsonclick = "" ;
      ucCombo_condexeniiggcon = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV27CondExenIIGGCon_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      lblTextblockcondexeniiggvar_Jsonclick = "" ;
      ucCombo_condexeniiggvar = new com.genexus.webpanels.GXUserControl();
      AV23CondExenIIGGVar_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A1108CondexenIIGGNom = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV28ComboCondExenIIGGCon = "" ;
      AV24ComboCondExenIIGGVar = "" ;
      A2021CondExenRelRef = "" ;
      AV14Insert_CondExenIIGGCon = "" ;
      AV15Insert_CondExenIIGGVar = "" ;
      A2027CondExenOld = "" ;
      AV32Pgmname = "" ;
      Combo_condexeniiggcon_Objectcall = "" ;
      Combo_condexeniiggcon_Class = "" ;
      Combo_condexeniiggcon_Icontype = "" ;
      Combo_condexeniiggcon_Icon = "" ;
      Combo_condexeniiggcon_Tooltip = "" ;
      Combo_condexeniiggcon_Selectedvalue_set = "" ;
      Combo_condexeniiggcon_Selectedtext_set = "" ;
      Combo_condexeniiggcon_Selectedtext_get = "" ;
      Combo_condexeniiggcon_Gamoauthtoken = "" ;
      Combo_condexeniiggcon_Ddointernalname = "" ;
      Combo_condexeniiggcon_Titlecontrolalign = "" ;
      Combo_condexeniiggcon_Dropdownoptionstype = "" ;
      Combo_condexeniiggcon_Titlecontrolidtoreplace = "" ;
      Combo_condexeniiggcon_Datalisttype = "" ;
      Combo_condexeniiggcon_Datalistfixedvalues = "" ;
      Combo_condexeniiggcon_Remoteservicesparameters = "" ;
      Combo_condexeniiggcon_Htmltemplate = "" ;
      Combo_condexeniiggcon_Multiplevaluestype = "" ;
      Combo_condexeniiggcon_Loadingdata = "" ;
      Combo_condexeniiggcon_Noresultsfound = "" ;
      Combo_condexeniiggcon_Emptyitemtext = "" ;
      Combo_condexeniiggcon_Onlyselectedvalues = "" ;
      Combo_condexeniiggcon_Selectalltext = "" ;
      Combo_condexeniiggcon_Multiplevaluesseparator = "" ;
      Combo_condexeniiggcon_Addnewoptiontext = "" ;
      Combo_condexeniiggvar_Objectcall = "" ;
      Combo_condexeniiggvar_Class = "" ;
      Combo_condexeniiggvar_Icontype = "" ;
      Combo_condexeniiggvar_Icon = "" ;
      Combo_condexeniiggvar_Tooltip = "" ;
      Combo_condexeniiggvar_Selectedvalue_set = "" ;
      Combo_condexeniiggvar_Selectedtext_set = "" ;
      Combo_condexeniiggvar_Selectedtext_get = "" ;
      Combo_condexeniiggvar_Gamoauthtoken = "" ;
      Combo_condexeniiggvar_Ddointernalname = "" ;
      Combo_condexeniiggvar_Titlecontrolalign = "" ;
      Combo_condexeniiggvar_Dropdownoptionstype = "" ;
      Combo_condexeniiggvar_Titlecontrolidtoreplace = "" ;
      Combo_condexeniiggvar_Datalisttype = "" ;
      Combo_condexeniiggvar_Datalistfixedvalues = "" ;
      Combo_condexeniiggvar_Remoteservicesparameters = "" ;
      Combo_condexeniiggvar_Htmltemplate = "" ;
      Combo_condexeniiggvar_Multiplevaluestype = "" ;
      Combo_condexeniiggvar_Loadingdata = "" ;
      Combo_condexeniiggvar_Noresultsfound = "" ;
      Combo_condexeniiggvar_Emptyitemtext = "" ;
      Combo_condexeniiggvar_Onlyselectedvalues = "" ;
      Combo_condexeniiggvar_Selectalltext = "" ;
      Combo_condexeniiggvar_Multiplevaluesseparator = "" ;
      Combo_condexeniiggvar_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode124 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z2027CondExenOld = "" ;
      T00366_A1105CondExenIIGG = new String[] {""} ;
      T00366_A1106CondExenIIGGAcu = new boolean[] {false} ;
      T00366_A1107CondExenIIGGProm = new boolean[] {false} ;
      T00366_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00366_A2238CondExenIIGGOpe = new String[] {""} ;
      T00366_A1108CondexenIIGGNom = new String[] {""} ;
      T00366_A2001CondExenRelSec = new int[1] ;
      T00366_A2002CondRelSecCli = new int[1] ;
      T00366_A2021CondExenRelRef = new String[] {""} ;
      T00366_A2027CondExenOld = new String[] {""} ;
      T00366_A3CliCod = new int[1] ;
      T00366_A1104CondExenIIGGCon = new String[] {""} ;
      T00366_A1123CondExenIIGGVar = new String[] {""} ;
      T00366_n1123CondExenIIGGVar = new boolean[] {false} ;
      T00364_A3CliCod = new int[1] ;
      T00365_A3CliCod = new int[1] ;
      T00367_A3CliCod = new int[1] ;
      T00368_A3CliCod = new int[1] ;
      T00369_A3CliCod = new int[1] ;
      T00369_A1105CondExenIIGG = new String[] {""} ;
      T00363_A1105CondExenIIGG = new String[] {""} ;
      T00363_A1106CondExenIIGGAcu = new boolean[] {false} ;
      T00363_A1107CondExenIIGGProm = new boolean[] {false} ;
      T00363_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00363_A2238CondExenIIGGOpe = new String[] {""} ;
      T00363_A1108CondexenIIGGNom = new String[] {""} ;
      T00363_A2001CondExenRelSec = new int[1] ;
      T00363_A2002CondRelSecCli = new int[1] ;
      T00363_A2021CondExenRelRef = new String[] {""} ;
      T00363_A2027CondExenOld = new String[] {""} ;
      T00363_A3CliCod = new int[1] ;
      T00363_A1104CondExenIIGGCon = new String[] {""} ;
      T00363_A1123CondExenIIGGVar = new String[] {""} ;
      T00363_n1123CondExenIIGGVar = new boolean[] {false} ;
      T003610_A3CliCod = new int[1] ;
      T003610_A1105CondExenIIGG = new String[] {""} ;
      T003611_A3CliCod = new int[1] ;
      T003611_A1105CondExenIIGG = new String[] {""} ;
      T00362_A1105CondExenIIGG = new String[] {""} ;
      T00362_A1106CondExenIIGGAcu = new boolean[] {false} ;
      T00362_A1107CondExenIIGGProm = new boolean[] {false} ;
      T00362_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00362_A2238CondExenIIGGOpe = new String[] {""} ;
      T00362_A1108CondexenIIGGNom = new String[] {""} ;
      T00362_A2001CondExenRelSec = new int[1] ;
      T00362_A2002CondRelSecCli = new int[1] ;
      T00362_A2021CondExenRelRef = new String[] {""} ;
      T00362_A2027CondExenOld = new String[] {""} ;
      T00362_A3CliCod = new int[1] ;
      T00362_A1104CondExenIIGGCon = new String[] {""} ;
      T00362_A1123CondExenIIGGVar = new String[] {""} ;
      T00362_n1123CondExenIIGGVar = new boolean[] {false} ;
      T003615_A3CliCod = new int[1] ;
      T003615_A1112AplIIGG = new short[1] ;
      T003616_A3CliCod = new int[1] ;
      T003616_A1105CondExenIIGG = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003617_A3CliCod = new int[1] ;
      T003617_A1885CliRelSec = new int[1] ;
      T003617_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T003618_A3CliCod = new int[1] ;
      T003619_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicion_exencion_iigg__default(),
         new Object[] {
             new Object[] {
            T00362_A1105CondExenIIGG, T00362_A1106CondExenIIGGAcu, T00362_A1107CondExenIIGGProm, T00362_A2237CondExenIIGGVFi, T00362_A2238CondExenIIGGOpe, T00362_A1108CondexenIIGGNom, T00362_A2001CondExenRelSec, T00362_A2002CondRelSecCli, T00362_A2021CondExenRelRef, T00362_A2027CondExenOld,
            T00362_A3CliCod, T00362_A1104CondExenIIGGCon, T00362_A1123CondExenIIGGVar, T00362_n1123CondExenIIGGVar
            }
            , new Object[] {
            T00363_A1105CondExenIIGG, T00363_A1106CondExenIIGGAcu, T00363_A1107CondExenIIGGProm, T00363_A2237CondExenIIGGVFi, T00363_A2238CondExenIIGGOpe, T00363_A1108CondexenIIGGNom, T00363_A2001CondExenRelSec, T00363_A2002CondRelSecCli, T00363_A2021CondExenRelRef, T00363_A2027CondExenOld,
            T00363_A3CliCod, T00363_A1104CondExenIIGGCon, T00363_A1123CondExenIIGGVar, T00363_n1123CondExenIIGGVar
            }
            , new Object[] {
            T00364_A3CliCod
            }
            , new Object[] {
            T00365_A3CliCod
            }
            , new Object[] {
            T00366_A1105CondExenIIGG, T00366_A1106CondExenIIGGAcu, T00366_A1107CondExenIIGGProm, T00366_A2237CondExenIIGGVFi, T00366_A2238CondExenIIGGOpe, T00366_A1108CondexenIIGGNom, T00366_A2001CondExenRelSec, T00366_A2002CondRelSecCli, T00366_A2021CondExenRelRef, T00366_A2027CondExenOld,
            T00366_A3CliCod, T00366_A1104CondExenIIGGCon, T00366_A1123CondExenIIGGVar, T00366_n1123CondExenIIGGVar
            }
            , new Object[] {
            T00367_A3CliCod
            }
            , new Object[] {
            T00368_A3CliCod
            }
            , new Object[] {
            T00369_A3CliCod, T00369_A1105CondExenIIGG
            }
            , new Object[] {
            T003610_A3CliCod, T003610_A1105CondExenIIGG
            }
            , new Object[] {
            T003611_A3CliCod, T003611_A1105CondExenIIGG
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003615_A3CliCod, T003615_A1112AplIIGG
            }
            , new Object[] {
            T003616_A3CliCod, T003616_A1105CondExenIIGG
            }
            , new Object[] {
            T003617_A3CliCod, T003617_A1885CliRelSec, T003617_A1880CliReDTChar
            }
            , new Object[] {
            T003618_A3CliCod
            }
            , new Object[] {
            T003619_A3CliCod
            }
         }
      );
      AV32Pgmname = "condicion_exencion_iigg" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound124 ;
   private short nIsDirty_124 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2001CondExenRelSec ;
   private int Z2002CondRelSecCli ;
   private int AV7CliCod ;
   private int A2001CondExenRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCondExenIIGG_Enabled ;
   private int edtCondExenIIGGCon_Visible ;
   private int edtCondExenIIGGCon_Enabled ;
   private int edtCondExenIIGGVar_Visible ;
   private int edtCondExenIIGGVar_Enabled ;
   private int edtCondExenIIGGVFi_Enabled ;
   private int edtCondexenIIGGNom_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombocondexeniiggcon_Visible ;
   private int edtavCombocondexeniiggcon_Enabled ;
   private int edtavCombocondexeniiggvar_Visible ;
   private int edtavCombocondexeniiggvar_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A2002CondRelSecCli ;
   private int Combo_condexeniiggcon_Datalistupdateminimumcharacters ;
   private int Combo_condexeniiggcon_Gxcontroltype ;
   private int Combo_condexeniiggvar_Datalistupdateminimumcharacters ;
   private int Combo_condexeniiggvar_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV33GXV1 ;
   private int AV30Insert_CliCod ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z2237CondExenIIGGVFi ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8CondExenIIGG ;
   private String Z1105CondExenIIGG ;
   private String Z2238CondExenIIGGOpe ;
   private String Z1104CondExenIIGGCon ;
   private String Z1123CondExenIIGGVar ;
   private String O1123CondExenIIGGVar ;
   private String O1104CondExenIIGGCon ;
   private String O1105CondExenIIGG ;
   private String N1104CondExenIIGGCon ;
   private String N1123CondExenIIGGVar ;
   private String Combo_condexeniiggvar_Selectedvalue_get ;
   private String Combo_condexeniiggcon_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1104CondExenIIGGCon ;
   private String A1123CondExenIIGGVar ;
   private String AV8CondExenIIGG ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCondExenIIGG_Internalname ;
   private String A2238CondExenIIGGOpe ;
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
   private String A1105CondExenIIGG ;
   private String edtCondExenIIGG_Jsonclick ;
   private String divTablesplittedcondexeniiggcon_Internalname ;
   private String lblTextblockcondexeniiggcon_Internalname ;
   private String lblTextblockcondexeniiggcon_Jsonclick ;
   private String Combo_condexeniiggcon_Caption ;
   private String Combo_condexeniiggcon_Cls ;
   private String Combo_condexeniiggcon_Datalistproc ;
   private String Combo_condexeniiggcon_Internalname ;
   private String edtCondExenIIGGCon_Internalname ;
   private String edtCondExenIIGGCon_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablesplittedcondexeniiggvar_Internalname ;
   private String lblTextblockcondexeniiggvar_Internalname ;
   private String lblTextblockcondexeniiggvar_Jsonclick ;
   private String Combo_condexeniiggvar_Caption ;
   private String Combo_condexeniiggvar_Cls ;
   private String Combo_condexeniiggvar_Datalistproc ;
   private String Combo_condexeniiggvar_Internalname ;
   private String edtCondExenIIGGVar_Internalname ;
   private String edtCondExenIIGGVar_Jsonclick ;
   private String edtCondExenIIGGVFi_Internalname ;
   private String edtCondExenIIGGVFi_Jsonclick ;
   private String edtCondexenIIGGNom_Internalname ;
   private String divCondexenrelsec_cell_Internalname ;
   private String divCondexenrelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_condexeniiggcon_Internalname ;
   private String edtavCombocondexeniiggcon_Internalname ;
   private String AV28ComboCondExenIIGGCon ;
   private String edtavCombocondexeniiggcon_Jsonclick ;
   private String divSectionattribute_condexeniiggvar_Internalname ;
   private String edtavCombocondexeniiggvar_Internalname ;
   private String AV24ComboCondExenIIGGVar ;
   private String edtavCombocondexeniiggvar_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV14Insert_CondExenIIGGCon ;
   private String AV15Insert_CondExenIIGGVar ;
   private String AV32Pgmname ;
   private String Combo_condexeniiggcon_Objectcall ;
   private String Combo_condexeniiggcon_Class ;
   private String Combo_condexeniiggcon_Icontype ;
   private String Combo_condexeniiggcon_Icon ;
   private String Combo_condexeniiggcon_Tooltip ;
   private String Combo_condexeniiggcon_Selectedvalue_set ;
   private String Combo_condexeniiggcon_Selectedtext_set ;
   private String Combo_condexeniiggcon_Selectedtext_get ;
   private String Combo_condexeniiggcon_Gamoauthtoken ;
   private String Combo_condexeniiggcon_Ddointernalname ;
   private String Combo_condexeniiggcon_Titlecontrolalign ;
   private String Combo_condexeniiggcon_Dropdownoptionstype ;
   private String Combo_condexeniiggcon_Titlecontrolidtoreplace ;
   private String Combo_condexeniiggcon_Datalisttype ;
   private String Combo_condexeniiggcon_Datalistfixedvalues ;
   private String Combo_condexeniiggcon_Datalistprocparametersprefix ;
   private String Combo_condexeniiggcon_Remoteservicesparameters ;
   private String Combo_condexeniiggcon_Htmltemplate ;
   private String Combo_condexeniiggcon_Multiplevaluestype ;
   private String Combo_condexeniiggcon_Loadingdata ;
   private String Combo_condexeniiggcon_Noresultsfound ;
   private String Combo_condexeniiggcon_Emptyitemtext ;
   private String Combo_condexeniiggcon_Onlyselectedvalues ;
   private String Combo_condexeniiggcon_Selectalltext ;
   private String Combo_condexeniiggcon_Multiplevaluesseparator ;
   private String Combo_condexeniiggcon_Addnewoptiontext ;
   private String Combo_condexeniiggvar_Objectcall ;
   private String Combo_condexeniiggvar_Class ;
   private String Combo_condexeniiggvar_Icontype ;
   private String Combo_condexeniiggvar_Icon ;
   private String Combo_condexeniiggvar_Tooltip ;
   private String Combo_condexeniiggvar_Selectedvalue_set ;
   private String Combo_condexeniiggvar_Selectedtext_set ;
   private String Combo_condexeniiggvar_Selectedtext_get ;
   private String Combo_condexeniiggvar_Gamoauthtoken ;
   private String Combo_condexeniiggvar_Ddointernalname ;
   private String Combo_condexeniiggvar_Titlecontrolalign ;
   private String Combo_condexeniiggvar_Dropdownoptionstype ;
   private String Combo_condexeniiggvar_Titlecontrolidtoreplace ;
   private String Combo_condexeniiggvar_Datalisttype ;
   private String Combo_condexeniiggvar_Datalistfixedvalues ;
   private String Combo_condexeniiggvar_Datalistprocparametersprefix ;
   private String Combo_condexeniiggvar_Remoteservicesparameters ;
   private String Combo_condexeniiggvar_Htmltemplate ;
   private String Combo_condexeniiggvar_Multiplevaluestype ;
   private String Combo_condexeniiggvar_Loadingdata ;
   private String Combo_condexeniiggvar_Noresultsfound ;
   private String Combo_condexeniiggvar_Emptyitemtext ;
   private String Combo_condexeniiggvar_Onlyselectedvalues ;
   private String Combo_condexeniiggvar_Selectalltext ;
   private String Combo_condexeniiggvar_Multiplevaluesseparator ;
   private String Combo_condexeniiggvar_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode124 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean Z1106CondExenIIGGAcu ;
   private boolean Z1107CondExenIIGGProm ;
   private boolean O1107CondExenIIGGProm ;
   private boolean O1106CondExenIIGGAcu ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1123CondExenIIGGVar ;
   private boolean wbErr ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_condexeniiggcon_Emptyitem ;
   private boolean AV31aplicadoHay ;
   private boolean Combo_condexeniiggcon_Enabled ;
   private boolean Combo_condexeniiggcon_Visible ;
   private boolean Combo_condexeniiggcon_Allowmultipleselection ;
   private boolean Combo_condexeniiggcon_Isgriditem ;
   private boolean Combo_condexeniiggcon_Hasdescription ;
   private boolean Combo_condexeniiggcon_Includeonlyselectedoption ;
   private boolean Combo_condexeniiggcon_Includeselectalloption ;
   private boolean Combo_condexeniiggcon_Includeaddnewoption ;
   private boolean Combo_condexeniiggvar_Enabled ;
   private boolean Combo_condexeniiggvar_Visible ;
   private boolean Combo_condexeniiggvar_Allowmultipleselection ;
   private boolean Combo_condexeniiggvar_Isgriditem ;
   private boolean Combo_condexeniiggvar_Hasdescription ;
   private boolean Combo_condexeniiggvar_Includeonlyselectedoption ;
   private boolean Combo_condexeniiggvar_Includeselectalloption ;
   private boolean Combo_condexeniiggvar_Emptyitem ;
   private boolean Combo_condexeniiggvar_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean ZV31aplicadoHay ;
   private String A2027CondExenOld ;
   private String AV21Combo_DataJson ;
   private String Z2027CondExenOld ;
   private String Z1108CondexenIIGGNom ;
   private String Z2021CondExenRelRef ;
   private String O1108CondexenIIGGNom ;
   private String A1108CondexenIIGGNom ;
   private String A2021CondExenRelRef ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_condexeniiggcon ;
   private com.genexus.webpanels.GXUserControl ucCombo_condexeniiggvar ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkCondExenIIGGAcu ;
   private ICheckbox chkCondExenIIGGProm ;
   private HTMLChoice cmbCondExenIIGGOpe ;
   private HTMLChoice dynCondExenRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T00366_A1105CondExenIIGG ;
   private boolean[] T00366_A1106CondExenIIGGAcu ;
   private boolean[] T00366_A1107CondExenIIGGProm ;
   private java.math.BigDecimal[] T00366_A2237CondExenIIGGVFi ;
   private String[] T00366_A2238CondExenIIGGOpe ;
   private String[] T00366_A1108CondexenIIGGNom ;
   private int[] T00366_A2001CondExenRelSec ;
   private int[] T00366_A2002CondRelSecCli ;
   private String[] T00366_A2021CondExenRelRef ;
   private String[] T00366_A2027CondExenOld ;
   private int[] T00366_A3CliCod ;
   private String[] T00366_A1104CondExenIIGGCon ;
   private String[] T00366_A1123CondExenIIGGVar ;
   private boolean[] T00366_n1123CondExenIIGGVar ;
   private int[] T00364_A3CliCod ;
   private int[] T00365_A3CliCod ;
   private int[] T00367_A3CliCod ;
   private int[] T00368_A3CliCod ;
   private int[] T00369_A3CliCod ;
   private String[] T00369_A1105CondExenIIGG ;
   private String[] T00363_A1105CondExenIIGG ;
   private boolean[] T00363_A1106CondExenIIGGAcu ;
   private boolean[] T00363_A1107CondExenIIGGProm ;
   private java.math.BigDecimal[] T00363_A2237CondExenIIGGVFi ;
   private String[] T00363_A2238CondExenIIGGOpe ;
   private String[] T00363_A1108CondexenIIGGNom ;
   private int[] T00363_A2001CondExenRelSec ;
   private int[] T00363_A2002CondRelSecCli ;
   private String[] T00363_A2021CondExenRelRef ;
   private String[] T00363_A2027CondExenOld ;
   private int[] T00363_A3CliCod ;
   private String[] T00363_A1104CondExenIIGGCon ;
   private String[] T00363_A1123CondExenIIGGVar ;
   private boolean[] T00363_n1123CondExenIIGGVar ;
   private int[] T003610_A3CliCod ;
   private String[] T003610_A1105CondExenIIGG ;
   private int[] T003611_A3CliCod ;
   private String[] T003611_A1105CondExenIIGG ;
   private String[] T00362_A1105CondExenIIGG ;
   private boolean[] T00362_A1106CondExenIIGGAcu ;
   private boolean[] T00362_A1107CondExenIIGGProm ;
   private java.math.BigDecimal[] T00362_A2237CondExenIIGGVFi ;
   private String[] T00362_A2238CondExenIIGGOpe ;
   private String[] T00362_A1108CondexenIIGGNom ;
   private int[] T00362_A2001CondExenRelSec ;
   private int[] T00362_A2002CondRelSecCli ;
   private String[] T00362_A2021CondExenRelRef ;
   private String[] T00362_A2027CondExenOld ;
   private int[] T00362_A3CliCod ;
   private String[] T00362_A1104CondExenIIGGCon ;
   private String[] T00362_A1123CondExenIIGGVar ;
   private boolean[] T00362_n1123CondExenIIGGVar ;
   private int[] T003615_A3CliCod ;
   private short[] T003615_A1112AplIIGG ;
   private int[] T003616_A3CliCod ;
   private String[] T003616_A1105CondExenIIGG ;
   private int[] T003617_A3CliCod ;
   private int[] T003617_A1885CliRelSec ;
   private String[] T003617_A1880CliReDTChar ;
   private int[] T003618_A3CliCod ;
   private int[] T003619_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV27CondExenIIGGCon_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23CondExenIIGGVar_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class condicion_exencion_iigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00362", "SELECT CondExenIIGG, CondExenIIGGAcu, CondExenIIGGProm, CondExenIIGGVFi, CondExenIIGGOpe, CondexenIIGGNom, CondExenRelSec, CondRelSecCli, CondExenRelRef, CondExenOld, CliCod, CondExenIIGGCon, CondExenIIGGVar FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ?  FOR UPDATE OF condicion_exencion_iigg NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00363", "SELECT CondExenIIGG, CondExenIIGGAcu, CondExenIIGGProm, CondExenIIGGVFi, CondExenIIGGOpe, CondexenIIGGNom, CondExenRelSec, CondRelSecCli, CondExenRelRef, CondExenOld, CliCod, CondExenIIGGCon, CondExenIIGGVar FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00364", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00365", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00366", "SELECT TM1.CondExenIIGG, TM1.CondExenIIGGAcu, TM1.CondExenIIGGProm, TM1.CondExenIIGGVFi, TM1.CondExenIIGGOpe, TM1.CondexenIIGGNom, TM1.CondExenRelSec, TM1.CondRelSecCli, TM1.CondExenRelRef, TM1.CondExenOld, TM1.CliCod, TM1.CondExenIIGGCon AS CondExenIIGGCon, TM1.CondExenIIGGVar AS CondExenIIGGVar FROM condicion_exencion_iigg TM1 WHERE TM1.CliCod = ? and TM1.CondExenIIGG = ( ?) ORDER BY TM1.CliCod, TM1.CondExenIIGG ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00367", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00368", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00369", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003610", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE ( CliCod > ? or CliCod = ? and CondExenIIGG > ( ?)) ORDER BY CliCod, CondExenIIGG  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003611", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE ( CliCod < ? or CliCod = ? and CondExenIIGG < ( ?)) ORDER BY CliCod DESC, CondExenIIGG DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003612", "SAVEPOINT gxupdate;INSERT INTO condicion_exencion_iigg(CondExenIIGG, CondExenIIGGAcu, CondExenIIGGProm, CondExenIIGGVFi, CondExenIIGGOpe, CondexenIIGGNom, CondExenRelSec, CondRelSecCli, CondExenRelRef, CondExenOld, CliCod, CondExenIIGGCon, CondExenIIGGVar) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003613", "SAVEPOINT gxupdate;UPDATE condicion_exencion_iigg SET CondExenIIGGAcu=?, CondExenIIGGProm=?, CondExenIIGGVFi=?, CondExenIIGGOpe=?, CondexenIIGGNom=?, CondExenRelSec=?, CondRelSecCli=?, CondExenRelRef=?, CondExenOld=?, CondExenIIGGCon=?, CondExenIIGGVar=?  WHERE CliCod = ? AND CondExenIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003614", "SAVEPOINT gxupdate;DELETE FROM condicion_exencion_iigg  WHERE CliCod = ? AND CondExenIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003615", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGCondicion = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003616", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg ORDER BY CliCod, CondExenIIGG ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003617", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003618", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003619", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 10);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 10);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 10);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setString(12, (String)parms[11], 10);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[13], 40);
               }
               return;
            case 11 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setString(10, (String)parms[9], 10);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[11], 40);
               }
               stmt.setInt(12, ((Number) parms[12]).intValue());
               stmt.setString(13, (String)parms[13], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
               }
               return;
      }
   }

}

