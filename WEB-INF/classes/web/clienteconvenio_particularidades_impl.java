package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clienteconvenio_particularidades_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action19") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1897ConveRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_19_4M204( Gx_mode, AV7CliCod, A1897ConveRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action24") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1902ConveVacRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveVacRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_24_4M239( Gx_mode, AV7CliCod, A1902ConveVacRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVERELSEC") == 0 )
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
         gxdlaconverelsec4M204( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEVACRELSEC") == 0 )
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
         gxdlaconvevacrelsec4M239( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
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
         gx2asaclicod4M204( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
         return  ;
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
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CliConveVig", localUtil.format(AV10CliConveVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente Convenio_Particularidades", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_86 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_86"))) ;
      nGXsfl_86_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_86_idx"))) ;
      sGXsfl_86_idx = httpContext.GetPar( "sGXsfl_86_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public clienteconvenio_particularidades_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clienteconvenio_particularidades_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_particularidades_impl.class ));
   }

   public clienteconvenio_particularidades_impl( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConveDiaHsPExt = new HTMLChoice();
      chkConveFondoCese = UIFactory.getCheckbox(this);
      dynConveRelSec = new HTMLChoice();
      dynConveVacRelSec = new HTMLChoice();
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
      if ( cmbConveDiaHsPExt.getItemCount() > 0 )
      {
         A1270ConveDiaHsPExt = cmbConveDiaHsPExt.getValidValue(A1270ConveDiaHsPExt) ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveDiaHsPExt.setValue( GXutil.rtrim( A1270ConveDiaHsPExt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Values", cmbConveDiaHsPExt.ToJavascriptSource(), true);
      }
      A1401ConveFondoCese = GXutil.strtobool( GXutil.booltostr( A1401ConveFondoCese)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
      if ( dynConveRelSec.getItemCount() > 0 )
      {
         A1897ConveRelSec = (int)(GXutil.lval( dynConveRelSec.getValidValue(GXutil.trim( GXutil.str( A1897ConveRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveRelSec.setValue( GXutil.trim( GXutil.str( A1897ConveRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveRelSec.getInternalname(), "Values", dynConveRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcliconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockcliconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliconvenio.setProperty("Caption", Combo_cliconvenio_Caption);
      ucCombo_cliconvenio.setProperty("Cls", Combo_cliconvenio_Cls);
      ucCombo_cliconvenio.setProperty("DataListProc", Combo_cliconvenio_Datalistproc);
      ucCombo_cliconvenio.setProperty("EmptyItem", Combo_cliconvenio_Emptyitem);
      ucCombo_cliconvenio.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_cliconvenio.setProperty("DropDownOptionsData", AV16CliConvenio_Data);
      ucCombo_cliconvenio.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cliconvenio_Internalname, "COMBO_CLICONVENIOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConvenio_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClienteConvenio_Particularidades.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveVig_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveVig_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliConveVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVig_Internalname, localUtil.format(A1575CliConveVig, "99/99/99"), localUtil.format( A1575CliConveVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtCliConveVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliConveVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCliConveVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ClienteConvenio_Particularidades.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveMesHsPExt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveMesHsPExt_Internalname, httpContext.getMessage( "Cantidad de horas del mes para calcular horas extras", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveMesHsPExt_Internalname, GXutil.ltrim( localUtil.ntoc( A1269ConveMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveMesHsPExt_Enabled!=0) ? localUtil.format( A1269ConveMesHsPExt, "ZZ9.9") : localUtil.format( A1269ConveMesHsPExt, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveMesHsPExt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveMesHsPExt_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveDiaHsPExt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveDiaHsPExt.getInternalname(), httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de horas extras", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveDiaHsPExt, cmbConveDiaHsPExt.getInternalname(), GXutil.rtrim( A1270ConveDiaHsPExt), 1, cmbConveDiaHsPExt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveDiaHsPExt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_ClienteConvenio_Particularidades.htm");
      cmbConveDiaHsPExt.setValue( GXutil.rtrim( A1270ConveDiaHsPExt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Values", cmbConveDiaHsPExt.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveFondoCese.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveFondoCese.getInternalname(), httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveFondoCese.getInternalname(), GXutil.booltostr( A1401ConveFondoCese), "", httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), 1, chkConveFondoCese.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(48, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,48);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConverelsec_cell_Internalname, 1, 0, "px", 0, "px", divConverelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynConveRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveRelSec, dynConveRelSec.getInternalname(), GXutil.trim( GXutil.str( A1897ConveRelSec, 6, 0)), 1, dynConveRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynConveRelSec.getVisible(), dynConveRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_ClienteConvenio_Particularidades.htm");
      dynConveRelSec.setValue( GXutil.trim( GXutil.str( A1897ConveRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveRelSec.getInternalname(), "Values", dynConveRelSec.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveGuarEdadMax_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveGuarEdadMax_Internalname, httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveGuarEdadMax_Internalname, GXutil.ltrim( localUtil.ntoc( A1628ConveGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveGuarEdadMax_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveGuarEdadMax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveGuarEdadMax_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveGuarEdadMin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveGuarEdadMin_Internalname, httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveGuarEdadMin_Internalname, GXutil.ltrim( localUtil.ntoc( A1627ConveGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveGuarEdadMin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveGuarEdadMin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveGuarEdadMin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
      ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
      ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
      ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
      ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
      ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
      ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
      ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
      ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
      ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
      ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveInterDiasJor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveInterDiasJor_Internalname, httpContext.getMessage( "Intervalo de jornadas trabajadas para x días de vacación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveInterDiasJor_Internalname, GXutil.ltrim( localUtil.ntoc( A1043ConveInterDiasJor, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveInterDiasJor_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveInterDiasJor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveInterDiasJor_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveDiasAcuVac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveDiasAcuVac_Internalname, httpContext.getMessage( "Días acumulados de vacaciones por jornadas trabajadas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveDiasAcuVac_Internalname, GXutil.ltrim( localUtil.ntoc( A1044ConveDiasAcuVac, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveDiasAcuVac_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1044ConveDiasAcuVac), "9") : localUtil.format( DecimalUtil.doubleToDec(A1044ConveDiasAcuVac), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveDiasAcuVac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveDiasAcuVac_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveMinMesesVac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveMinMesesVac_Internalname, httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveMinMesesVac_Internalname, GXutil.ltrim( localUtil.ntoc( A1046ConveMinMesesVac, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveMinMesesVac_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveMinMesesVac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveMinMesesVac_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol86( ) ;
      nGXsfl_86_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount239 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_239 = (short)(1) ;
            scanStart4M239( ) ;
            while ( RcdFound239 != 0 )
            {
               init_level_properties239( ) ;
               getByPrimaryKey4M239( ) ;
               addRow4M239( ) ;
               scanNext4M239( ) ;
            }
            scanEnd4M239( ) ;
            nBlankRcdCount239 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         B1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         B1401ConveFondoCese = A1401ConveFondoCese ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         B1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         B1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         B1575CliConveVig = A1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         B1565CliConvenio = A1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         standaloneNotModal4M239( ) ;
         standaloneModal4M239( ) ;
         sMode239 = Gx_mode ;
         while ( nGXsfl_86_idx < nRC_GXsfl_86 )
         {
            bGXsfl_86_Refreshing = true ;
            readRow4M239( ) ;
            edtCliConveVacDesAnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACDESANT_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
            edtCliConveVacHasAnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACHASANT_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacHasAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacHasAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
            edtCliConveVacDias_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACDIAS_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDias_Enabled), 5, 0), !bGXsfl_86_Refreshing);
            dynConveVacRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynConveVacRelSec.getVisible(), 5, 0), !bGXsfl_86_Refreshing);
            dynConveVacRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveVacRelSec.getEnabled(), 5, 0), !bGXsfl_86_Refreshing);
            if ( ( nRcdExists_239 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal4M239( ) ;
            }
            sendRow4M239( ) ;
            bGXsfl_86_Refreshing = false ;
         }
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1627ConveGuarEdadMin = B1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         A1628ConveGuarEdadMax = B1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         A1401ConveFondoCese = B1401ConveFondoCese ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         A1270ConveDiaHsPExt = B1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         A1269ConveMesHsPExt = B1269ConveMesHsPExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         A1575CliConveVig = B1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A1565CliConvenio = B1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount239 = (short)(5) ;
         nRcdExists_239 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart4M239( ) ;
            while ( RcdFound239 != 0 )
            {
               sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_86239( ) ;
               init_level_properties239( ) ;
               standaloneNotModal4M239( ) ;
               getByPrimaryKey4M239( ) ;
               standaloneModal4M239( ) ;
               addRow4M239( ) ;
               scanNext4M239( ) ;
            }
            scanEnd4M239( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode239 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_86239( ) ;
         initAll4M239( ) ;
         init_level_properties239( ) ;
         B1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         B1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         B1401ConveFondoCese = A1401ConveFondoCese ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         B1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         B1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         B1575CliConveVig = A1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         B1565CliConvenio = A1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         nRcdExists_239 = (short)(0) ;
         nIsMod_239 = (short)(0) ;
         nRcdDeleted_239 = (short)(0) ;
         nBlankRcdCount239 = (short)(nBlankRcdUsr239+nBlankRcdCount239) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount239 > 0 )
         {
            standaloneNotModal4M239( ) ;
            standaloneModal4M239( ) ;
            addRow4M239( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount239 = (short)(nBlankRcdCount239-1) ;
         }
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1627ConveGuarEdadMin = B1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         A1628ConveGuarEdadMax = B1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         A1401ConveFondoCese = B1401ConveFondoCese ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         A1270ConveDiaHsPExt = B1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         A1269ConveMesHsPExt = B1269ConveMesHsPExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         A1575CliConveVig = B1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A1565CliConvenio = B1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_Particularidades.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_cliconvenio_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliconvenio_Internalname, GXutil.rtrim( AV21ComboCliConvenio), GXutil.rtrim( localUtil.format( AV21ComboCliConvenio, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliconvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliconvenio_Visible, edtavCombocliconvenio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClienteConvenio_Particularidades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveDefault_Internalname, GXutil.booltostr( A905ConveDefault), GXutil.booltostr( A905ConveDefault), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,110);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveDefault_Jsonclick, 0, "Attribute", "", "", "", "", edtConveDefault_Visible, edtConveDefault_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_Particularidades.htm");
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
      e114M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICONVENIO_DATA"), AV16CliConvenio_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1575CliConveVig = localUtil.ctod( httpContext.cgiGet( "Z1575CliConveVig"), 0) ;
            Z905ConveDefault = GXutil.strtobool( httpContext.cgiGet( "Z905ConveDefault")) ;
            Z1043ConveInterDiasJor = (short)(localUtil.ctol( httpContext.cgiGet( "Z1043ConveInterDiasJor"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1044ConveDiasAcuVac = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1044ConveDiasAcuVac"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1046ConveMinMesesVac = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1046ConveMinMesesVac"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1269ConveMesHsPExt = localUtil.ctond( httpContext.cgiGet( "Z1269ConveMesHsPExt")) ;
            Z1270ConveDiaHsPExt = httpContext.cgiGet( "Z1270ConveDiaHsPExt") ;
            n1270ConveDiaHsPExt = ((GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ? true : false) ;
            Z1401ConveFondoCese = GXutil.strtobool( httpContext.cgiGet( "Z1401ConveFondoCese")) ;
            Z1627ConveGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1627ConveGuarEdadMin"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1627ConveGuarEdadMin = ((0==A1627ConveGuarEdadMin) ? true : false) ;
            Z1628ConveGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1628ConveGuarEdadMax"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1628ConveGuarEdadMax = ((0==A1628ConveGuarEdadMax) ? true : false) ;
            Z1897ConveRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1897ConveRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2036ConveRelRef = httpContext.cgiGet( "Z2036ConveRelRef") ;
            A2036ConveRelRef = httpContext.cgiGet( "Z2036ConveRelRef") ;
            O1627ConveGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( "O1627ConveGuarEdadMin"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1627ConveGuarEdadMin = ((0==A1627ConveGuarEdadMin) ? true : false) ;
            O1628ConveGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( "O1628ConveGuarEdadMax"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1628ConveGuarEdadMax = ((0==A1628ConveGuarEdadMax) ? true : false) ;
            O1401ConveFondoCese = GXutil.strtobool( httpContext.cgiGet( "O1401ConveFondoCese")) ;
            O1270ConveDiaHsPExt = httpContext.cgiGet( "O1270ConveDiaHsPExt") ;
            n1270ConveDiaHsPExt = ((GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ? true : false) ;
            O1269ConveMesHsPExt = localUtil.ctond( httpContext.cgiGet( "O1269ConveMesHsPExt")) ;
            O1575CliConveVig = localUtil.ctod( httpContext.cgiGet( "O1575CliConveVig"), 0) ;
            O1565CliConvenio = httpContext.cgiGet( "O1565CliConvenio") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_86 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_86"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CliConveVig = localUtil.ctod( httpContext.cgiGet( "vCLICONVEVIG"), 0) ;
            AV22esSistemaConceptosDefault = (short)(localUtil.ctol( httpContext.cgiGet( "vESSISTEMACONCEPTOSDEFAULT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV23ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "vCLIENTECONVENIADOR")) ;
            AV24aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2036ConveRelRef = httpContext.cgiGet( "CONVERELREF") ;
            A2037ConvePartOld = httpContext.cgiGet( "CONVEPARTOLD") ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A2038ConveVacRelRef = httpContext.cgiGet( "CONVEVACRELREF") ;
            A2039ConveVacOld = httpContext.cgiGet( "CONVEVACOLD") ;
            Combo_cliconvenio_Objectcall = httpContext.cgiGet( "COMBO_CLICONVENIO_Objectcall") ;
            Combo_cliconvenio_Class = httpContext.cgiGet( "COMBO_CLICONVENIO_Class") ;
            Combo_cliconvenio_Icontype = httpContext.cgiGet( "COMBO_CLICONVENIO_Icontype") ;
            Combo_cliconvenio_Icon = httpContext.cgiGet( "COMBO_CLICONVENIO_Icon") ;
            Combo_cliconvenio_Caption = httpContext.cgiGet( "COMBO_CLICONVENIO_Caption") ;
            Combo_cliconvenio_Tooltip = httpContext.cgiGet( "COMBO_CLICONVENIO_Tooltip") ;
            Combo_cliconvenio_Cls = httpContext.cgiGet( "COMBO_CLICONVENIO_Cls") ;
            Combo_cliconvenio_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedvalue_set") ;
            Combo_cliconvenio_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedvalue_get") ;
            Combo_cliconvenio_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedtext_set") ;
            Combo_cliconvenio_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedtext_get") ;
            Combo_cliconvenio_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICONVENIO_Gamoauthtoken") ;
            Combo_cliconvenio_Ddointernalname = httpContext.cgiGet( "COMBO_CLICONVENIO_Ddointernalname") ;
            Combo_cliconvenio_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICONVENIO_Titlecontrolalign") ;
            Combo_cliconvenio_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICONVENIO_Dropdownoptionstype") ;
            Combo_cliconvenio_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Enabled")) ;
            Combo_cliconvenio_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Visible")) ;
            Combo_cliconvenio_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICONVENIO_Titlecontrolidtoreplace") ;
            Combo_cliconvenio_Datalisttype = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalisttype") ;
            Combo_cliconvenio_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Allowmultipleselection")) ;
            Combo_cliconvenio_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistfixedvalues") ;
            Combo_cliconvenio_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Isgriditem")) ;
            Combo_cliconvenio_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Hasdescription")) ;
            Combo_cliconvenio_Datalistproc = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistproc") ;
            Combo_cliconvenio_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistprocparametersprefix") ;
            Combo_cliconvenio_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICONVENIO_Remoteservicesparameters") ;
            Combo_cliconvenio_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliconvenio_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeonlyselectedoption")) ;
            Combo_cliconvenio_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeselectalloption")) ;
            Combo_cliconvenio_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Emptyitem")) ;
            Combo_cliconvenio_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeaddnewoption")) ;
            Combo_cliconvenio_Htmltemplate = httpContext.cgiGet( "COMBO_CLICONVENIO_Htmltemplate") ;
            Combo_cliconvenio_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICONVENIO_Multiplevaluestype") ;
            Combo_cliconvenio_Loadingdata = httpContext.cgiGet( "COMBO_CLICONVENIO_Loadingdata") ;
            Combo_cliconvenio_Noresultsfound = httpContext.cgiGet( "COMBO_CLICONVENIO_Noresultsfound") ;
            Combo_cliconvenio_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICONVENIO_Emptyitemtext") ;
            Combo_cliconvenio_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICONVENIO_Onlyselectedvalues") ;
            Combo_cliconvenio_Selectalltext = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectalltext") ;
            Combo_cliconvenio_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICONVENIO_Multiplevaluesseparator") ;
            Combo_cliconvenio_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICONVENIO_Addnewoptiontext") ;
            Combo_cliconvenio_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVENIO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            Dvpanel_unnamedtable1_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Objectcall") ;
            Dvpanel_unnamedtable1_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Class") ;
            Dvpanel_unnamedtable1_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Enabled")) ;
            Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
            Dvpanel_unnamedtable1_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Height") ;
            Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
            Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
            Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
            Dvpanel_unnamedtable1_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showheader")) ;
            Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
            Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
            Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
            Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
            Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
            Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
            Dvpanel_unnamedtable1_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Visible")) ;
            Dvpanel_unnamedtable1_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            if ( localUtil.vcdate( httpContext.cgiGet( edtCliConveVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CLICONVEVIG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1575CliConveVig = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            }
            else
            {
               A1575CliConveVig = localUtil.ctod( httpContext.cgiGet( edtCliConveVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveMesHsPExt_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveMesHsPExt_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEMESHSPEXT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveMesHsPExt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1269ConveMesHsPExt = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
            }
            else
            {
               A1269ConveMesHsPExt = localUtil.ctond( httpContext.cgiGet( edtConveMesHsPExt_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
            }
            cmbConveDiaHsPExt.setName( cmbConveDiaHsPExt.getInternalname() );
            cmbConveDiaHsPExt.setValue( httpContext.cgiGet( cmbConveDiaHsPExt.getInternalname()) );
            A1270ConveDiaHsPExt = httpContext.cgiGet( cmbConveDiaHsPExt.getInternalname()) ;
            n1270ConveDiaHsPExt = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
            n1270ConveDiaHsPExt = ((GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ? true : false) ;
            A1401ConveFondoCese = GXutil.strtobool( httpContext.cgiGet( chkConveFondoCese.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
            dynConveRelSec.setName( dynConveRelSec.getInternalname() );
            dynConveRelSec.setValue( httpContext.cgiGet( dynConveRelSec.getInternalname()) );
            A1897ConveRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEGUAREDADMAX");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveGuarEdadMax_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1628ConveGuarEdadMax = (byte)(0) ;
               n1628ConveGuarEdadMax = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
            }
            else
            {
               A1628ConveGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1628ConveGuarEdadMax = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
            }
            n1628ConveGuarEdadMax = ((0==A1628ConveGuarEdadMax) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEGUAREDADMIN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveGuarEdadMin_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1627ConveGuarEdadMin = (byte)(0) ;
               n1627ConveGuarEdadMin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
            }
            else
            {
               A1627ConveGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1627ConveGuarEdadMin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
            }
            n1627ConveGuarEdadMin = ((0==A1627ConveGuarEdadMin) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveInterDiasJor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveInterDiasJor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEINTERDIASJOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveInterDiasJor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1043ConveInterDiasJor = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1043ConveInterDiasJor", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), 3, 0));
            }
            else
            {
               A1043ConveInterDiasJor = (short)(localUtil.ctol( httpContext.cgiGet( edtConveInterDiasJor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1043ConveInterDiasJor", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveDiasAcuVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveDiasAcuVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEDIASACUVAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveDiasAcuVac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1044ConveDiasAcuVac = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1044ConveDiasAcuVac", GXutil.str( A1044ConveDiasAcuVac, 1, 0));
            }
            else
            {
               A1044ConveDiasAcuVac = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveDiasAcuVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1044ConveDiasAcuVac", GXutil.str( A1044ConveDiasAcuVac, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveMinMesesVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveMinMesesVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEMINMESESVAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveMinMesesVac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1046ConveMinMesesVac = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1046ConveMinMesesVac", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), 2, 0));
            }
            else
            {
               A1046ConveMinMesesVac = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveMinMesesVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1046ConveMinMesesVac", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), 2, 0));
            }
            AV21ComboCliConvenio = httpContext.cgiGet( edtavCombocliconvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliConvenio", AV21ComboCliConvenio);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            A905ConveDefault = GXutil.strtobool( httpContext.cgiGet( edtConveDefault_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A905ConveDefault", A905ConveDefault);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ClienteConvenio_Particularidades");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveRelRef", GXutil.rtrim( localUtil.format( A2036ConveRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clienteconvenio_particularidades:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
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
                  sMode204 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode204 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound204 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4M0( ) ;
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
                        e114M2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124M2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e124M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4M204( ) ;
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
         disableAttributes4M204( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
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

   public void confirm_4M0( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4M204( ) ;
         }
         else
         {
            checkExtendedTable4M204( ) ;
            closeExtendedTableCursors4M204( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode204 = Gx_mode ;
         confirm_4M239( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode204 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode204 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_4M239( )
   {
      nGXsfl_86_idx = 0 ;
      while ( nGXsfl_86_idx < nRC_GXsfl_86 )
      {
         readRow4M239( ) ;
         if ( ( nRcdExists_239 != 0 ) || ( nIsMod_239 != 0 ) )
         {
            getKey4M239( ) ;
            if ( ( nRcdExists_239 == 0 ) && ( nRcdDeleted_239 == 0 ) )
            {
               if ( RcdFound239 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate4M239( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable4M239( ) ;
                     closeExtendedTableCursors4M239( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CLICONVEVACDESANT_" + sGXsfl_86_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound239 != 0 )
               {
                  if ( nRcdDeleted_239 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey4M239( ) ;
                     load4M239( ) ;
                     beforeValidate4M239( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls4M239( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_239 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate4M239( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable4M239( ) ;
                           closeExtendedTableCursors4M239( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_239 == 0 )
                  {
                     GXCCtl = "CLICONVEVACDESANT_" + sGXsfl_86_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCliConveVacDesAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCliConveVacHasAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCliConveVacDias_Internalname, GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynConveVacRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1902ConveVacRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1761CliConveVacDesAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1762CliConveVacHasAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1763CliConveVacDias_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1902ConveVacRelSec_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1902ConveVacRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2038ConveVacRelRef_"+sGXsfl_86_idx, Z2038ConveVacRelRef) ;
         httpContext.changePostValue( "T1761CliConveVacDesAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1762CliConveVacHasAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1763CliConveVacDias_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_239 != 0 )
         {
            httpContext.changePostValue( "CLICONVEVACDESANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDesAnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLICONVEVACHASANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacHasAnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLICONVEVACDIAS_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDias_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption4M0( )
   {
   }

   public void e114M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      AV21ComboCliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliConvenio", AV21ComboCliConvenio);
      edtavCombocliconvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICONVENIO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Insert", GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Update", GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Delete", GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtConveDefault_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveDefault_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveDefault_Visible), 5, 0), true);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      clienteconvenio_particularidades_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV22esSistemaConceptosDefault = (short)((byte)((GXt_boolean4)?1:0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22esSistemaConceptosDefault", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22esSistemaConceptosDefault), 4, 0));
      GXv_boolean5[0] = AV23ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      clienteconvenio_particularidades_impl.this.AV23ClienteConveniador = GXv_boolean5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ClienteConveniador", AV23ClienteConveniador);
   }

   public void e124M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      dynConveRelSec.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynConveRelSec.getVisible(), 5, 0), true);
      divConverelsec_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICONVENIO' Routine */
      returnInSub = false ;
      Combo_cliconvenio_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CliConvenio\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CliConveVig\": \"\", \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "DataListProcParametersPrefix", Combo_cliconvenio_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.clienteconvenio_particularidadesloaddvcombo(remoteHandle, context).execute( "CliConvenio", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10CliConveVig, A3CliCod, A1564CliPaiConve, "", GXv_char7, GXv_char8, GXv_char9) ;
      clienteconvenio_particularidades_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      clienteconvenio_particularidades_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      clienteconvenio_particularidades_impl.this.GXt_char6 = GXv_char9[0] ;
      AV20Combo_DataJson = GXt_char6 ;
      Combo_cliconvenio_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedValue_set", Combo_cliconvenio_Selectedvalue_set);
      Combo_cliconvenio_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedText_set", Combo_cliconvenio_Selectedtext_set);
      AV21ComboCliConvenio = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCliConvenio", AV21ComboCliConvenio);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         Combo_cliconvenio_Enabled = false ;
         ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      }
   }

   public void zm4M204( int GX_JID )
   {
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z905ConveDefault = T004M5_A905ConveDefault[0] ;
            Z1043ConveInterDiasJor = T004M5_A1043ConveInterDiasJor[0] ;
            Z1044ConveDiasAcuVac = T004M5_A1044ConveDiasAcuVac[0] ;
            Z1046ConveMinMesesVac = T004M5_A1046ConveMinMesesVac[0] ;
            Z1269ConveMesHsPExt = T004M5_A1269ConveMesHsPExt[0] ;
            Z1270ConveDiaHsPExt = T004M5_A1270ConveDiaHsPExt[0] ;
            Z1401ConveFondoCese = T004M5_A1401ConveFondoCese[0] ;
            Z1627ConveGuarEdadMin = T004M5_A1627ConveGuarEdadMin[0] ;
            Z1628ConveGuarEdadMax = T004M5_A1628ConveGuarEdadMax[0] ;
            Z1897ConveRelSec = T004M5_A1897ConveRelSec[0] ;
            Z2036ConveRelRef = T004M5_A2036ConveRelRef[0] ;
         }
         else
         {
            Z905ConveDefault = A905ConveDefault ;
            Z1043ConveInterDiasJor = A1043ConveInterDiasJor ;
            Z1044ConveDiasAcuVac = A1044ConveDiasAcuVac ;
            Z1046ConveMinMesesVac = A1046ConveMinMesesVac ;
            Z1269ConveMesHsPExt = A1269ConveMesHsPExt ;
            Z1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
            Z1401ConveFondoCese = A1401ConveFondoCese ;
            Z1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
            Z1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
            Z1897ConveRelSec = A1897ConveRelSec ;
            Z2036ConveRelRef = A2036ConveRelRef ;
         }
      }
      if ( GX_JID == -26 )
      {
         Z1575CliConveVig = A1575CliConveVig ;
         Z905ConveDefault = A905ConveDefault ;
         Z1043ConveInterDiasJor = A1043ConveInterDiasJor ;
         Z1044ConveDiasAcuVac = A1044ConveDiasAcuVac ;
         Z1046ConveMinMesesVac = A1046ConveMinMesesVac ;
         Z1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         Z1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         Z1401ConveFondoCese = A1401ConveFondoCese ;
         Z1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         Z1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         Z1897ConveRelSec = A1897ConveRelSec ;
         Z2036ConveRelRef = A2036ConveRelRef ;
         Z2037ConvePartOld = A2037ConvePartOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconverelsec_html4M204( AV7CliCod) ;
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
            clienteconvenio_particularidades_impl.this.GXt_int10 = GXv_int11[0] ;
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
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         A1575CliConveVig = AV10CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         edtCliConveVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         edtCliConveVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         A1565CliConvenio = AV21ComboCliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      dynConveVacRelSec.setVisible( ((AV22esSistemaConceptosDefault==(1))||(AV23ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynConveVacRelSec.getVisible(), 5, 0), !bGXsfl_86_Refreshing);
      dynConveRelSec.setVisible( ((AV22esSistemaConceptosDefault==(1))||(AV23ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynConveRelSec.getVisible(), 5, 0), true);
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
         AV25Pgmname = "ClienteConvenio_Particularidades" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      }
   }

   public void load4M204( )
   {
      /* Using cursor T004M7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A905ConveDefault = T004M7_A905ConveDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A905ConveDefault", A905ConveDefault);
         A1043ConveInterDiasJor = T004M7_A1043ConveInterDiasJor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1043ConveInterDiasJor", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), 3, 0));
         A1044ConveDiasAcuVac = T004M7_A1044ConveDiasAcuVac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1044ConveDiasAcuVac", GXutil.str( A1044ConveDiasAcuVac, 1, 0));
         A1046ConveMinMesesVac = T004M7_A1046ConveMinMesesVac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1046ConveMinMesesVac", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), 2, 0));
         A1269ConveMesHsPExt = T004M7_A1269ConveMesHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         A1270ConveDiaHsPExt = T004M7_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = T004M7_n1270ConveDiaHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         A1401ConveFondoCese = T004M7_A1401ConveFondoCese[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         A1627ConveGuarEdadMin = T004M7_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = T004M7_n1627ConveGuarEdadMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         A1628ConveGuarEdadMax = T004M7_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = T004M7_n1628ConveGuarEdadMax[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         A1897ConveRelSec = T004M7_A1897ConveRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
         A2036ConveRelRef = T004M7_A2036ConveRelRef[0] ;
         A2037ConvePartOld = T004M7_A2037ConvePartOld[0] ;
         zm4M204( -26) ;
      }
      pr_default.close(5);
      onLoadActions4M204( ) ;
   }

   public void onLoadActions4M204( )
   {
      AV25Pgmname = "ClienteConvenio_Particularidades" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( ! ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) ) )
      {
         divConverelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
         {
            divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
            {
               divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
            }
         }
      }
   }

   public void checkExtendedTable4M204( )
   {
      nIsDirty_204 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV25Pgmname = "ClienteConvenio_Particularidades" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1897ConveRelSec, GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      /* Using cursor T004M6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) ) )
      {
         divConverelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
         {
            divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
            {
               divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
            }
         }
      }
      if ( ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) && (0==A1897ConveRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1270ConveDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, "diasSemanaMes") == 0 ) || (GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de 1 hora de trabajo para mensualizados", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEDIAHSPEXT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveDiaHsPExt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4M204( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_27( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T004M8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
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

   public void getKey4M204( )
   {
      /* Using cursor T004M9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound204 = (short)(1) ;
      }
      else
      {
         RcdFound204 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004M5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm4M204( 26) ;
         RcdFound204 = (short)(1) ;
         A1575CliConveVig = T004M5_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A905ConveDefault = T004M5_A905ConveDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A905ConveDefault", A905ConveDefault);
         A1043ConveInterDiasJor = T004M5_A1043ConveInterDiasJor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1043ConveInterDiasJor", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), 3, 0));
         A1044ConveDiasAcuVac = T004M5_A1044ConveDiasAcuVac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1044ConveDiasAcuVac", GXutil.str( A1044ConveDiasAcuVac, 1, 0));
         A1046ConveMinMesesVac = T004M5_A1046ConveMinMesesVac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1046ConveMinMesesVac", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), 2, 0));
         A1269ConveMesHsPExt = T004M5_A1269ConveMesHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         A1270ConveDiaHsPExt = T004M5_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = T004M5_n1270ConveDiaHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         A1401ConveFondoCese = T004M5_A1401ConveFondoCese[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         A1627ConveGuarEdadMin = T004M5_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = T004M5_n1627ConveGuarEdadMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         A1628ConveGuarEdadMax = T004M5_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = T004M5_n1628ConveGuarEdadMax[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         A1897ConveRelSec = T004M5_A1897ConveRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
         A2036ConveRelRef = T004M5_A2036ConveRelRef[0] ;
         A2037ConvePartOld = T004M5_A2037ConvePartOld[0] ;
         A3CliCod = T004M5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004M5_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004M5_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
         O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
         O1401ConveFondoCese = A1401ConveFondoCese ;
         httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
         O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
         O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
         O1575CliConveVig = A1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         O1565CliConvenio = A1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         sMode204 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4M204( ) ;
         if ( AnyError == 1 )
         {
            RcdFound204 = (short)(0) ;
            initializeNonKey4M204( ) ;
         }
         Gx_mode = sMode204 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound204 = (short)(0) ;
         initializeNonKey4M204( ) ;
         sMode204 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode204 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey4M204( ) ;
      if ( RcdFound204 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound204 = (short)(0) ;
      /* Using cursor T004M10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T004M10_A3CliCod[0] < A3CliCod ) || ( T004M10_A3CliCod[0] == A3CliCod ) && ( T004M10_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004M10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004M10_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004M10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004M10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M10_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004M10_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T004M10_A3CliCod[0] > A3CliCod ) || ( T004M10_A3CliCod[0] == A3CliCod ) && ( T004M10_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004M10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004M10_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004M10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004M10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M10_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004M10_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) ) )
         {
            A3CliCod = T004M10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004M10_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004M10_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T004M10_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            RcdFound204 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound204 = (short)(0) ;
      /* Using cursor T004M11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T004M11_A3CliCod[0] > A3CliCod ) || ( T004M11_A3CliCod[0] == A3CliCod ) && ( T004M11_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004M11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004M11_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004M11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004M11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M11_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004M11_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T004M11_A3CliCod[0] < A3CliCod ) || ( T004M11_A3CliCod[0] == A3CliCod ) && ( T004M11_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004M11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004M11_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004M11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004M11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004M11_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004M11_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) ) )
         {
            A3CliCod = T004M11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004M11_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004M11_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T004M11_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            RcdFound204 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4M204( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4M204( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound204 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = Z1575CliConveVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4M204( ) ;
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4M204( ) ;
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
                  GX_FocusControl = edtCliConvenio_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4M204( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = Z1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4M204( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004M4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_Particularidades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( Z905ConveDefault != T004M4_A905ConveDefault[0] ) || ( Z1043ConveInterDiasJor != T004M4_A1043ConveInterDiasJor[0] ) || ( Z1044ConveDiasAcuVac != T004M4_A1044ConveDiasAcuVac[0] ) || ( Z1046ConveMinMesesVac != T004M4_A1046ConveMinMesesVac[0] ) || ( DecimalUtil.compareTo(Z1269ConveMesHsPExt, T004M4_A1269ConveMesHsPExt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1270ConveDiaHsPExt, T004M4_A1270ConveDiaHsPExt[0]) != 0 ) || ( Z1401ConveFondoCese != T004M4_A1401ConveFondoCese[0] ) || ( Z1627ConveGuarEdadMin != T004M4_A1627ConveGuarEdadMin[0] ) || ( Z1628ConveGuarEdadMax != T004M4_A1628ConveGuarEdadMax[0] ) || ( Z1897ConveRelSec != T004M4_A1897ConveRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2036ConveRelRef, T004M4_A2036ConveRelRef[0]) != 0 ) )
         {
            if ( Z905ConveDefault != T004M4_A905ConveDefault[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveDefault");
               GXutil.writeLogRaw("Old: ",Z905ConveDefault);
               GXutil.writeLogRaw("Current: ",T004M4_A905ConveDefault[0]);
            }
            if ( Z1043ConveInterDiasJor != T004M4_A1043ConveInterDiasJor[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveInterDiasJor");
               GXutil.writeLogRaw("Old: ",Z1043ConveInterDiasJor);
               GXutil.writeLogRaw("Current: ",T004M4_A1043ConveInterDiasJor[0]);
            }
            if ( Z1044ConveDiasAcuVac != T004M4_A1044ConveDiasAcuVac[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveDiasAcuVac");
               GXutil.writeLogRaw("Old: ",Z1044ConveDiasAcuVac);
               GXutil.writeLogRaw("Current: ",T004M4_A1044ConveDiasAcuVac[0]);
            }
            if ( Z1046ConveMinMesesVac != T004M4_A1046ConveMinMesesVac[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveMinMesesVac");
               GXutil.writeLogRaw("Old: ",Z1046ConveMinMesesVac);
               GXutil.writeLogRaw("Current: ",T004M4_A1046ConveMinMesesVac[0]);
            }
            if ( DecimalUtil.compareTo(Z1269ConveMesHsPExt, T004M4_A1269ConveMesHsPExt[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveMesHsPExt");
               GXutil.writeLogRaw("Old: ",Z1269ConveMesHsPExt);
               GXutil.writeLogRaw("Current: ",T004M4_A1269ConveMesHsPExt[0]);
            }
            if ( GXutil.strcmp(Z1270ConveDiaHsPExt, T004M4_A1270ConveDiaHsPExt[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveDiaHsPExt");
               GXutil.writeLogRaw("Old: ",Z1270ConveDiaHsPExt);
               GXutil.writeLogRaw("Current: ",T004M4_A1270ConveDiaHsPExt[0]);
            }
            if ( Z1401ConveFondoCese != T004M4_A1401ConveFondoCese[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveFondoCese");
               GXutil.writeLogRaw("Old: ",Z1401ConveFondoCese);
               GXutil.writeLogRaw("Current: ",T004M4_A1401ConveFondoCese[0]);
            }
            if ( Z1627ConveGuarEdadMin != T004M4_A1627ConveGuarEdadMin[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveGuarEdadMin");
               GXutil.writeLogRaw("Old: ",Z1627ConveGuarEdadMin);
               GXutil.writeLogRaw("Current: ",T004M4_A1627ConveGuarEdadMin[0]);
            }
            if ( Z1628ConveGuarEdadMax != T004M4_A1628ConveGuarEdadMax[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveGuarEdadMax");
               GXutil.writeLogRaw("Old: ",Z1628ConveGuarEdadMax);
               GXutil.writeLogRaw("Current: ",T004M4_A1628ConveGuarEdadMax[0]);
            }
            if ( Z1897ConveRelSec != T004M4_A1897ConveRelSec[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveRelSec");
               GXutil.writeLogRaw("Old: ",Z1897ConveRelSec);
               GXutil.writeLogRaw("Current: ",T004M4_A1897ConveRelSec[0]);
            }
            if ( GXutil.strcmp(Z2036ConveRelRef, T004M4_A2036ConveRelRef[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveRelRef");
               GXutil.writeLogRaw("Old: ",Z2036ConveRelRef);
               GXutil.writeLogRaw("Current: ",T004M4_A2036ConveRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenio_Particularidades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4M204( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4M204( 0) ;
         checkOptimisticConcurrency4M204( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M204( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4M204( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004M12 */
                  pr_default.execute(10, new Object[] {A1575CliConveVig, Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1044ConveDiasAcuVac), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A1897ConveRelSec), A2036ConveRelRef, A2037ConvePartOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
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
                        processLevel4M204( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption4M0( ) ;
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
            load4M204( ) ;
         }
         endLevel4M204( ) ;
      }
      closeExtendedTableCursors4M204( ) ;
   }

   public void update4M204( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M204( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M204( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4M204( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004M13 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1044ConveDiasAcuVac), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A1897ConveRelSec), A2036ConveRelRef, A2037ConvePartOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_Particularidades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4M204( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel4M204( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel4M204( ) ;
      }
      closeExtendedTableCursors4M204( ) ;
   }

   public void deferredUpdate4M204( )
   {
   }

   public void delete( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4M204( ) ;
         afterConfirm4M204( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4M204( ) ;
            if ( AnyError == 0 )
            {
               scanStart4M239( ) ;
               while ( RcdFound239 != 0 )
               {
                  getByPrimaryKey4M239( ) ;
                  delete4M239( ) ;
                  scanNext4M239( ) ;
               }
               scanEnd4M239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004M14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
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
      }
      sMode204 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4M204( ) ;
      Gx_mode = sMode204 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4M204( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV24aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1897ConveRelSec, GXv_boolean5) ;
            clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
         }
         AV25Pgmname = "ClienteConvenio_Particularidades" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         if ( ! ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) ) )
         {
            divConverelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
            {
               divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
            }
            else
            {
               if ( ( AV22esSistemaConceptosDefault == ( 1 )) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) )
               {
                  divConverelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divConverelsec_cell_Internalname, "Class", divConverelsec_cell_Class, true);
               }
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T004M15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void processNestedLevel4M239( )
   {
      nGXsfl_86_idx = 0 ;
      while ( nGXsfl_86_idx < nRC_GXsfl_86 )
      {
         readRow4M239( ) ;
         if ( ( nRcdExists_239 != 0 ) || ( nIsMod_239 != 0 ) )
         {
            standaloneNotModal4M239( ) ;
            getKey4M239( ) ;
            if ( ( nRcdExists_239 == 0 ) && ( nRcdDeleted_239 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert4M239( ) ;
            }
            else
            {
               if ( RcdFound239 != 0 )
               {
                  if ( ( nRcdDeleted_239 != 0 ) && ( nRcdExists_239 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete4M239( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_239 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update4M239( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_239 == 0 )
                  {
                     GXCCtl = "CLICONVEVACDESANT_" + sGXsfl_86_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCliConveVacDesAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCliConveVacHasAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCliConveVacDias_Internalname, GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynConveVacRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1902ConveVacRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1761CliConveVacDesAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1762CliConveVacHasAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1763CliConveVacDias_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1902ConveVacRelSec_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( Z1902ConveVacRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2038ConveVacRelRef_"+sGXsfl_86_idx, Z2038ConveVacRelRef) ;
         httpContext.changePostValue( "T1761CliConveVacDesAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1762CliConveVacHasAnt_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1763CliConveVacDias_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( O1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_239_"+sGXsfl_86_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_239 != 0 )
         {
            httpContext.changePostValue( "CLICONVEVACDESANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDesAnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLICONVEVACHASANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacHasAnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLICONVEVACDIAS_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDias_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll4M239( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_239 = (short)(0) ;
      nIsMod_239 = (short)(0) ;
      nRcdDeleted_239 = (short)(0) ;
   }

   public void processLevel4M204( )
   {
      /* Save parent mode. */
      sMode204 = Gx_mode ;
      processNestedLevel4M239( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode204 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel4M204( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clienteconvenio_particularidades");
         if ( AnyError == 0 )
         {
            confirmValues4M0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clienteconvenio_particularidades");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4M204( )
   {
      /* Scan By routine */
      /* Using cursor T004M16 */
      pr_default.execute(14);
      RcdFound204 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A3CliCod = T004M16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004M16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004M16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T004M16_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4M204( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound204 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A3CliCod = T004M16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004M16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004M16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T004M16_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
   }

   public void scanEnd4M204( )
   {
      pr_default.close(14);
   }

   public void afterConfirm4M204( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV24aplicadoHay ) && ! (0==A1897ConveRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveRelSec", 1, "CONVERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4M204( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4M204( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4M204( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4M204( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4M204( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4M204( )
   {
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      edtCliConveVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      edtConveMesHsPExt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveMesHsPExt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveMesHsPExt_Enabled), 5, 0), true);
      cmbConveDiaHsPExt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveDiaHsPExt.getEnabled(), 5, 0), true);
      chkConveFondoCese.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveFondoCese.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveFondoCese.getEnabled(), 5, 0), true);
      dynConveRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveRelSec.getEnabled(), 5, 0), true);
      edtConveGuarEdadMax_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveGuarEdadMax_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveGuarEdadMax_Enabled), 5, 0), true);
      edtConveGuarEdadMin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveGuarEdadMin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveGuarEdadMin_Enabled), 5, 0), true);
      edtConveInterDiasJor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveInterDiasJor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveInterDiasJor_Enabled), 5, 0), true);
      edtConveDiasAcuVac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveDiasAcuVac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveDiasAcuVac_Enabled), 5, 0), true);
      edtConveMinMesesVac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveMinMesesVac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveMinMesesVac_Enabled), 5, 0), true);
      edtavCombocliconvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtConveDefault_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveDefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveDefault_Enabled), 5, 0), true);
   }

   public void zm4M239( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1762CliConveVacHasAnt = T004M3_A1762CliConveVacHasAnt[0] ;
            Z1763CliConveVacDias = T004M3_A1763CliConveVacDias[0] ;
            Z1902ConveVacRelSec = T004M3_A1902ConveVacRelSec[0] ;
            Z2038ConveVacRelRef = T004M3_A2038ConveVacRelRef[0] ;
         }
         else
         {
            Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            Z1763CliConveVacDias = A1763CliConveVacDias ;
            Z1902ConveVacRelSec = A1902ConveVacRelSec ;
            Z2038ConveVacRelRef = A2038ConveVacRelRef ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         Z1763CliConveVacDias = A1763CliConveVacDias ;
         Z1902ConveVacRelSec = A1902ConveVacRelSec ;
         Z2038ConveVacRelRef = A2038ConveVacRelRef ;
         Z2039ConveVacOld = A2039ConveVacOld ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal4M239( )
   {
      gxaconvevacrelsec_html4M239( AV7CliCod) ;
   }

   public void standaloneModal4M239( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCliConveVacDesAnt_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
      }
      else
      {
         edtCliConveVacDesAnt_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
      }
   }

   public void load4M239( )
   {
      /* Using cursor T004M17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1762CliConveVacHasAnt = T004M17_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = T004M17_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = T004M17_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = T004M17_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = T004M17_A2039ConveVacOld[0] ;
         zm4M239( -28) ;
      }
      pr_default.close(15);
      onLoadActions4M239( ) ;
   }

   public void onLoadActions4M239( )
   {
   }

   public void checkExtendedTable4M239( )
   {
      nIsDirty_239 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal4M239( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      if ( ( ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) && (0==A1902ConveVacRelSec) )
      {
         GXCCtl = "CLICONVEVACDESANT_" + sGXsfl_86_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4M239( )
   {
   }

   public void enableDisable4M239( )
   {
   }

   public void getKey4M239( )
   {
      /* Using cursor T004M18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound239 = (short)(1) ;
      }
      else
      {
         RcdFound239 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey4M239( )
   {
      /* Using cursor T004M3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4M239( 28) ;
         RcdFound239 = (short)(1) ;
         initializeNonKey4M239( ) ;
         A1761CliConveVacDesAnt = T004M3_A1761CliConveVacDesAnt[0] ;
         A1762CliConveVacHasAnt = T004M3_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = T004M3_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = T004M3_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = T004M3_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = T004M3_A2039ConveVacOld[0] ;
         O1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         O1763CliConveVacDias = A1763CliConveVacDias ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4M239( ) ;
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound239 = (short)(0) ;
         initializeNonKey4M239( ) ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal4M239( ) ;
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes4M239( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency4M239( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004M2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1762CliConveVacHasAnt != T004M2_A1762CliConveVacHasAnt[0] ) || ( Z1763CliConveVacDias != T004M2_A1763CliConveVacDias[0] ) || ( Z1902ConveVacRelSec != T004M2_A1902ConveVacRelSec[0] ) || ( GXutil.strcmp(Z2038ConveVacRelRef, T004M2_A2038ConveVacRelRef[0]) != 0 ) )
         {
            if ( Z1762CliConveVacHasAnt != T004M2_A1762CliConveVacHasAnt[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"CliConveVacHasAnt");
               GXutil.writeLogRaw("Old: ",Z1762CliConveVacHasAnt);
               GXutil.writeLogRaw("Current: ",T004M2_A1762CliConveVacHasAnt[0]);
            }
            if ( Z1763CliConveVacDias != T004M2_A1763CliConveVacDias[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"CliConveVacDias");
               GXutil.writeLogRaw("Old: ",Z1763CliConveVacDias);
               GXutil.writeLogRaw("Current: ",T004M2_A1763CliConveVacDias[0]);
            }
            if ( Z1902ConveVacRelSec != T004M2_A1902ConveVacRelSec[0] )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveVacRelSec");
               GXutil.writeLogRaw("Old: ",Z1902ConveVacRelSec);
               GXutil.writeLogRaw("Current: ",T004M2_A1902ConveVacRelSec[0]);
            }
            if ( GXutil.strcmp(Z2038ConveVacRelRef, T004M2_A2038ConveVacRelRef[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_particularidades:[seudo value changed for attri]"+"ConveVacRelRef");
               GXutil.writeLogRaw("Old: ",Z2038ConveVacRelRef);
               GXutil.writeLogRaw("Current: ",T004M2_A2038ConveVacRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4M239( )
   {
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M239( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4M239( 0) ;
         checkOptimisticConcurrency4M239( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M239( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4M239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004M19 */
                  pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt), Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
                  if ( (pr_default.getStatus(17) == 1) )
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
            load4M239( ) ;
         }
         endLevel4M239( ) ;
      }
      closeExtendedTableCursors4M239( ) ;
   }

   public void update4M239( )
   {
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M239( ) ;
      }
      if ( ( nIsMod_239 != 0 ) || ( nIsDirty_239 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency4M239( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm4M239( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate4M239( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T004M20 */
                     pr_default.execute(18, new Object[] {Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
                     if ( (pr_default.getStatus(18) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate4M239( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey4M239( ) ;
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
            endLevel4M239( ) ;
         }
      }
      closeExtendedTableCursors4M239( ) ;
   }

   public void deferredUpdate4M239( )
   {
   }

   public void delete4M239( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M239( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4M239( ) ;
         afterConfirm4M239( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4M239( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004M21 */
               pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
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
      sMode239 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4M239( ) ;
      Gx_mode = sMode239 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4M239( )
   {
      standaloneModal4M239( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV24aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean5) ;
            clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
         }
      }
   }

   public void endLevel4M239( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4M239( )
   {
      /* Scan By routine */
      /* Using cursor T004M22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      RcdFound239 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1761CliConveVacDesAnt = T004M22_A1761CliConveVacDesAnt[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4M239( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound239 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1761CliConveVacDesAnt = T004M22_A1761CliConveVacDesAnt[0] ;
      }
   }

   public void scanEnd4M239( )
   {
      pr_default.close(20);
   }

   public void afterConfirm4M239( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV24aplicadoHay ) && ! (0==A1902ConveVacRelSec) )
      {
         GXCCtl = "CONVEVACRELSEC_" + sGXsfl_86_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveVacRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveVacRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV24aplicadoHay ) && ! (0==A1897ConveRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveRelSec", 1, "CONVERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4M239( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4M239( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4M239( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4M239( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4M239( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4M239( )
   {
      edtCliConveVacDesAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
      edtCliConveVacHasAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacHasAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacHasAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
      edtCliConveVacDias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDias_Enabled), 5, 0), !bGXsfl_86_Refreshing);
      dynConveVacRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveVacRelSec.getEnabled(), 5, 0), !bGXsfl_86_Refreshing);
   }

   public void send_integrity_lvl_hashes4M239( )
   {
   }

   public void send_integrity_lvl_hashes4M204( )
   {
   }

   public void subsflControlProps_86239( )
   {
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT_"+sGXsfl_86_idx ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT_"+sGXsfl_86_idx ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS_"+sGXsfl_86_idx ;
      dynConveVacRelSec.setInternalname( "CONVEVACRELSEC_"+sGXsfl_86_idx );
   }

   public void subsflControlProps_fel_86239( )
   {
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT_"+sGXsfl_86_fel_idx ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT_"+sGXsfl_86_fel_idx ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS_"+sGXsfl_86_fel_idx ;
      dynConveVacRelSec.setInternalname( "CONVEVACRELSEC_"+sGXsfl_86_fel_idx );
   }

   public void addRow4M239( )
   {
      nGXsfl_86_idx = (int)(nGXsfl_86_idx+1) ;
      sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_86239( ) ;
      sendRow4M239( ) ;
   }

   public void sendRow4M239( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_86_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_239_" + sGXsfl_86_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 87,'',false,'" + sGXsfl_86_idx + "',86)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacDesAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,87);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacDesAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCliConveVacDesAnt_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(86),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_239_" + sGXsfl_86_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 88,'',false,'" + sGXsfl_86_idx + "',86)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacHasAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCliConveVacHasAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), "Z9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,88);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacHasAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCliConveVacHasAnt_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(86),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_239_" + sGXsfl_86_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 89,'',false,'" + sGXsfl_86_idx + "',86)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacDias_Internalname,GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCliConveVacDias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1763CliConveVacDias), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1763CliConveVacDias), "Z9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,89);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacDias_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCliConveVacDias_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(86),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      gxaconvevacrelsec_html4M239( AV7CliCod) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_239_" + sGXsfl_86_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 90,'',false,'" + sGXsfl_86_idx + "',86)\"" ;
      if ( ( dynConveVacRelSec.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CONVEVACRELSEC_" + sGXsfl_86_idx ;
         dynConveVacRelSec.setName( GXCCtl );
         dynConveVacRelSec.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynConveVacRelSec,dynConveVacRelSec.getInternalname(),GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0)),Integer.valueOf(1),dynConveVacRelSec.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(dynConveVacRelSec.getVisible()),Integer.valueOf(dynConveVacRelSec.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynConveVacRelSec.setValue( GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Values", dynConveVacRelSec.ToJavascriptSource(), !bGXsfl_86_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes4M239( ) ;
      GXCCtl = "Z1761CliConveVacDesAnt_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1762CliConveVacHasAnt_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1763CliConveVacDias_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1902ConveVacRelSec_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1902ConveVacRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2038ConveVacRelRef_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2038ConveVacRelRef);
      GXCCtl = "O1761CliConveVacDesAnt_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O1762CliConveVacHasAnt_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O1763CliConveVacDias_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_239_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_239_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_239_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_239, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9CliConvenio));
      GXCCtl = "vCLICONVEVIG_" + sGXsfl_86_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( AV10CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVACDESANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDesAnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVACHASANT_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacHasAnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVACDIAS_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDias_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACRELSEC_"+sGXsfl_86_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACRELSEC_"+sGXsfl_86_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow4M239( )
   {
      nGXsfl_86_idx = (int)(nGXsfl_86_idx+1) ;
      sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_86239( ) ;
      edtCliConveVacDesAnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACDESANT_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCliConveVacHasAnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACHASANT_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCliConveVacDias_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLICONVEVACDIAS_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynConveVacRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynConveVacRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CONVEVACRELSEC_"+sGXsfl_86_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
      {
         GXCCtl = "CLICONVEVACDESANT_" + sGXsfl_86_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
         wbErr = true ;
         A1761CliConveVacDesAnt = (byte)(0) ;
      }
      else
      {
         A1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
      {
         GXCCtl = "CLICONVEVACHASANT_" + sGXsfl_86_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacHasAnt_Internalname ;
         wbErr = true ;
         A1762CliConveVacHasAnt = (byte)(0) ;
      }
      else
      {
         A1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
      {
         GXCCtl = "CLICONVEVACDIAS_" + sGXsfl_86_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacDias_Internalname ;
         wbErr = true ;
         A1763CliConveVacDias = (byte)(0) ;
      }
      else
      {
         A1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      dynConveVacRelSec.setName( dynConveVacRelSec.getInternalname() );
      dynConveVacRelSec.setValue( httpContext.cgiGet( dynConveVacRelSec.getInternalname()) );
      A1902ConveVacRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveVacRelSec.getInternalname()))) ;
      GXCCtl = "Z1761CliConveVacDesAnt_" + sGXsfl_86_idx ;
      Z1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1762CliConveVacHasAnt_" + sGXsfl_86_idx ;
      Z1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1763CliConveVacDias_" + sGXsfl_86_idx ;
      Z1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1902ConveVacRelSec_" + sGXsfl_86_idx ;
      Z1902ConveVacRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2038ConveVacRelRef_" + sGXsfl_86_idx ;
      Z2038ConveVacRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2038ConveVacRelRef_" + sGXsfl_86_idx ;
      A2038ConveVacRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "O1761CliConveVacDesAnt_" + sGXsfl_86_idx ;
      O1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "O1762CliConveVacHasAnt_" + sGXsfl_86_idx ;
      O1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "O1763CliConveVacDias_" + sGXsfl_86_idx ;
      O1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_239_" + sGXsfl_86_idx ;
      nRcdDeleted_239 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_239_" + sGXsfl_86_idx ;
      nRcdExists_239 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_239_" + sGXsfl_86_idx ;
      nIsMod_239 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtCliConveVacDesAnt_Enabled = edtCliConveVacDesAnt_Enabled ;
   }

   public void confirmValues4M0( )
   {
      nGXsfl_86_idx = 0 ;
      sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_86239( ) ;
      while ( nGXsfl_86_idx < nRC_GXsfl_86 )
      {
         nGXsfl_86_idx = (int)(nGXsfl_86_idx+1) ;
         sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_86239( ) ;
         httpContext.changePostValue( "Z1761CliConveVacDesAnt_"+sGXsfl_86_idx, httpContext.cgiGet( "ZT_"+"Z1761CliConveVacDesAnt_"+sGXsfl_86_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1761CliConveVacDesAnt_"+sGXsfl_86_idx) ;
         httpContext.changePostValue( "Z1762CliConveVacHasAnt_"+sGXsfl_86_idx, httpContext.cgiGet( "ZT_"+"Z1762CliConveVacHasAnt_"+sGXsfl_86_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1762CliConveVacHasAnt_"+sGXsfl_86_idx) ;
         httpContext.changePostValue( "Z1763CliConveVacDias_"+sGXsfl_86_idx, httpContext.cgiGet( "ZT_"+"Z1763CliConveVacDias_"+sGXsfl_86_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1763CliConveVacDias_"+sGXsfl_86_idx) ;
         httpContext.changePostValue( "Z1902ConveVacRelSec_"+sGXsfl_86_idx, httpContext.cgiGet( "ZT_"+"Z1902ConveVacRelSec_"+sGXsfl_86_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1902ConveVacRelSec_"+sGXsfl_86_idx) ;
         httpContext.changePostValue( "Z2038ConveVacRelRef_"+sGXsfl_86_idx, httpContext.cgiGet( "ZT_"+"Z2038ConveVacRelRef_"+sGXsfl_86_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2038ConveVacRelRef_"+sGXsfl_86_idx) ;
      }
      httpContext.changePostValue( "O1761CliConveVacDesAnt", httpContext.cgiGet( "T1761CliConveVacDesAnt")) ;
      httpContext.deletePostValue( "T1761CliConveVacDesAnt") ;
      httpContext.changePostValue( "O1762CliConveVacHasAnt", httpContext.cgiGet( "T1762CliConveVacHasAnt")) ;
      httpContext.deletePostValue( "T1762CliConveVacHasAnt") ;
      httpContext.changePostValue( "O1763CliConveVacDias", httpContext.cgiGet( "T1763CliConveVacDias")) ;
      httpContext.deletePostValue( "T1763CliConveVacDias") ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clienteconvenio_particularidades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ClienteConvenio_Particularidades");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveRelRef", GXutil.rtrim( localUtil.format( A2036ConveRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clienteconvenio_particularidades:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1575CliConveVig", localUtil.dtoc( Z1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z905ConveDefault", Z905ConveDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1043ConveInterDiasJor", GXutil.ltrim( localUtil.ntoc( Z1043ConveInterDiasJor, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1044ConveDiasAcuVac", GXutil.ltrim( localUtil.ntoc( Z1044ConveDiasAcuVac, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1046ConveMinMesesVac", GXutil.ltrim( localUtil.ntoc( Z1046ConveMinMesesVac, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1269ConveMesHsPExt", GXutil.ltrim( localUtil.ntoc( Z1269ConveMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1270ConveDiaHsPExt", GXutil.rtrim( Z1270ConveDiaHsPExt));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1401ConveFondoCese", Z1401ConveFondoCese);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1627ConveGuarEdadMin", GXutil.ltrim( localUtil.ntoc( Z1627ConveGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1628ConveGuarEdadMax", GXutil.ltrim( localUtil.ntoc( Z1628ConveGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1897ConveRelSec", GXutil.ltrim( localUtil.ntoc( Z1897ConveRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2036ConveRelRef", Z2036ConveRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1627ConveGuarEdadMin", GXutil.ltrim( localUtil.ntoc( O1627ConveGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1628ConveGuarEdadMax", GXutil.ltrim( localUtil.ntoc( O1628ConveGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1401ConveFondoCese", O1401ConveFondoCese);
      web.GxWebStd.gx_hidden_field( httpContext, "O1270ConveDiaHsPExt", GXutil.rtrim( O1270ConveDiaHsPExt));
      web.GxWebStd.gx_hidden_field( httpContext, "O1269ConveMesHsPExt", GXutil.ltrim( localUtil.ntoc( O1269ConveMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1575CliConveVig", localUtil.dtoc( O1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "O1565CliConvenio", GXutil.rtrim( O1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_86", GXutil.ltrim( localUtil.ntoc( nGXsfl_86_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICONVENIO_DATA", AV16CliConvenio_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICONVENIO_DATA", AV16CliConvenio_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEVIG", localUtil.dtoc( AV10CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", GXutil.ltrim( localUtil.ntoc( AV22esSistemaConceptosDefault, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV23ClienteConveniador);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV24aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVERELREF", A2036ConveRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEPARTOLD", A2037ConvePartOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACRELREF", A2038ConveVacRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACOLD", A2039ConveVacOld);
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Objectcall", GXutil.rtrim( Combo_cliconvenio_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Cls", GXutil.rtrim( Combo_cliconvenio_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedvalue_set", GXutil.rtrim( Combo_cliconvenio_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedtext_set", GXutil.rtrim( Combo_cliconvenio_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistproc", GXutil.rtrim( Combo_cliconvenio_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliconvenio_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Emptyitem", GXutil.booltostr( Combo_cliconvenio_Emptyitem));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable1_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Enabled", GXutil.booltostr( Dvpanel_unnamedtable1_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
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
      return formatLink("web.clienteconvenio_particularidades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig"})  ;
   }

   public String getPgmname( )
   {
      return "ClienteConvenio_Particularidades" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente Convenio_Particularidades", "") ;
   }

   public void initializeNonKey4M204( )
   {
      AV24aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      A905ConveDefault = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A905ConveDefault", A905ConveDefault);
      A1043ConveInterDiasJor = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1043ConveInterDiasJor", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), 3, 0));
      A1044ConveDiasAcuVac = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1044ConveDiasAcuVac", GXutil.str( A1044ConveDiasAcuVac, 1, 0));
      A1046ConveMinMesesVac = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1046ConveMinMesesVac", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), 2, 0));
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
      A1270ConveDiaHsPExt = "" ;
      n1270ConveDiaHsPExt = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
      n1270ConveDiaHsPExt = ((GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ? true : false) ;
      A1401ConveFondoCese = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
      A1627ConveGuarEdadMin = (byte)(0) ;
      n1627ConveGuarEdadMin = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
      n1627ConveGuarEdadMin = ((0==A1627ConveGuarEdadMin) ? true : false) ;
      A1628ConveGuarEdadMax = (byte)(0) ;
      n1628ConveGuarEdadMax = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
      n1628ConveGuarEdadMax = ((0==A1628ConveGuarEdadMax) ? true : false) ;
      A1897ConveRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1897ConveRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1897ConveRelSec), 6, 0));
      A2036ConveRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2036ConveRelRef", A2036ConveRelRef);
      A2037ConvePartOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2037ConvePartOld", A2037ConvePartOld);
      O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
      n1627ConveGuarEdadMin = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1627ConveGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), 2, 0));
      O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
      n1628ConveGuarEdadMax = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1628ConveGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), 2, 0));
      O1401ConveFondoCese = A1401ConveFondoCese ;
      httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
      O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
      n1270ConveDiaHsPExt = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
      O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1269ConveMesHsPExt", GXutil.ltrimstr( A1269ConveMesHsPExt, 5, 1));
      Z905ConveDefault = false ;
      Z1043ConveInterDiasJor = (short)(0) ;
      Z1044ConveDiasAcuVac = (byte)(0) ;
      Z1046ConveMinMesesVac = (byte)(0) ;
      Z1269ConveMesHsPExt = DecimalUtil.ZERO ;
      Z1270ConveDiaHsPExt = "" ;
      Z1401ConveFondoCese = false ;
      Z1627ConveGuarEdadMin = (byte)(0) ;
      Z1628ConveGuarEdadMax = (byte)(0) ;
      Z1897ConveRelSec = 0 ;
      Z2036ConveRelRef = "" ;
   }

   public void initAll4M204( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1575CliConveVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      initializeNonKey4M204( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey4M239( )
   {
      A1762CliConveVacHasAnt = (byte)(0) ;
      A1763CliConveVacDias = (byte)(0) ;
      A1902ConveVacRelSec = 0 ;
      A2038ConveVacRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2038ConveVacRelRef", A2038ConveVacRelRef);
      A2039ConveVacOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2039ConveVacOld", A2039ConveVacOld);
      O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
      O1763CliConveVacDias = A1763CliConveVacDias ;
      Z1762CliConveVacHasAnt = (byte)(0) ;
      Z1763CliConveVacDias = (byte)(0) ;
      Z1902ConveVacRelSec = 0 ;
      Z2038ConveVacRelRef = "" ;
   }

   public void initAll4M239( )
   {
      A1761CliConveVacDesAnt = (byte)(0) ;
      initializeNonKey4M239( ) ;
   }

   public void standaloneModalInsert4M239( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713271578", true, true);
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
      httpContext.AddJavascriptSource("clienteconvenio_particularidades.js", "?20251713271579", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties239( )
   {
      edtCliConveVacDesAnt_Enabled = defedtCliConveVacDesAnt_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), !bGXsfl_86_Refreshing);
   }

   public void startgridcontrol86( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDesAnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacHasAnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCliConveVacDias_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1902ConveVacRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynConveVacRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTextblockcliconvenio_Internalname = "TEXTBLOCKCLICONVENIO" ;
      Combo_cliconvenio_Internalname = "COMBO_CLICONVENIO" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      divTablesplittedcliconvenio_Internalname = "TABLESPLITTEDCLICONVENIO" ;
      edtCliConveVig_Internalname = "CLICONVEVIG" ;
      edtConveMesHsPExt_Internalname = "CONVEMESHSPEXT" ;
      cmbConveDiaHsPExt.setInternalname( "CONVEDIAHSPEXT" );
      chkConveFondoCese.setInternalname( "CONVEFONDOCESE" );
      dynConveRelSec.setInternalname( "CONVERELSEC" );
      divConverelsec_cell_Internalname = "CONVERELSEC_CELL" ;
      edtConveGuarEdadMax_Internalname = "CONVEGUAREDADMAX" ;
      edtConveGuarEdadMin_Internalname = "CONVEGUAREDADMIN" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtConveInterDiasJor_Internalname = "CONVEINTERDIASJOR" ;
      edtConveDiasAcuVac_Internalname = "CONVEDIASACUVAC" ;
      edtConveMinMesesVac_Internalname = "CONVEMINMESESVAC" ;
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT" ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT" ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS" ;
      dynConveVacRelSec.setInternalname( "CONVEVACRELSEC" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocliconvenio_Internalname = "vCOMBOCLICONVENIO" ;
      divSectionattribute_cliconvenio_Internalname = "SECTIONATTRIBUTE_CLICONVENIO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtConveDefault_Internalname = "CONVEDEFAULT" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Cliente Convenio_Particularidades", "") );
      dynConveVacRelSec.setJsonclick( "" );
      edtCliConveVacDias_Jsonclick = "" ;
      edtCliConveVacHasAnt_Jsonclick = "" ;
      edtCliConveVacDesAnt_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      Combo_cliconvenio_Datalistprocparametersprefix = "" ;
      edtConveDefault_Jsonclick = "" ;
      edtConveDefault_Enabled = 1 ;
      edtConveDefault_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombocliconvenio_Jsonclick = "" ;
      edtavCombocliconvenio_Enabled = 0 ;
      edtavCombocliconvenio_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynConveVacRelSec.setEnabled( 1 );
      dynConveVacRelSec.setVisible( -1 );
      edtCliConveVacDias_Enabled = 1 ;
      edtCliConveVacHasAnt_Enabled = 1 ;
      edtCliConveVacDesAnt_Enabled = 1 ;
      edtConveMinMesesVac_Jsonclick = "" ;
      edtConveMinMesesVac_Enabled = 1 ;
      edtConveDiasAcuVac_Jsonclick = "" ;
      edtConveDiasAcuVac_Enabled = 1 ;
      edtConveInterDiasJor_Jsonclick = "" ;
      edtConveInterDiasJor_Enabled = 1 ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Vacaciones", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      edtConveGuarEdadMin_Jsonclick = "" ;
      edtConveGuarEdadMin_Enabled = 1 ;
      edtConveGuarEdadMax_Jsonclick = "" ;
      edtConveGuarEdadMax_Enabled = 1 ;
      dynConveRelSec.setJsonclick( "" );
      dynConveRelSec.setEnabled( 1 );
      dynConveRelSec.setVisible( 1 );
      divConverelsec_cell_Class = "col-xs-12" ;
      chkConveFondoCese.setEnabled( 1 );
      cmbConveDiaHsPExt.setJsonclick( "" );
      cmbConveDiaHsPExt.setEnabled( 1 );
      edtConveMesHsPExt_Jsonclick = "" ;
      edtConveMesHsPExt_Enabled = 1 ;
      edtCliConveVig_Jsonclick = "" ;
      edtCliConveVig_Enabled = 1 ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      Combo_cliconvenio_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliconvenio_Datalistproc = "ClienteConvenio_ParticularidadesLoadDVCombo" ;
      Combo_cliconvenio_Cls = "ExtendedCombo Attribute" ;
      Combo_cliconvenio_Caption = "" ;
      Combo_cliconvenio_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlaconverelsec4M204( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconverelsec_data4M204( AV7CliCod) ;
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

   public void gxaconverelsec_html4M204( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconverelsec_data4M204( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconverelsec_data4M204( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T004M23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(21) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004M23_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004M23_A1880CliReDTChar[0]);
         pr_default.readNext(21);
      }
      pr_default.close(21);
   }

   public void gxdlaconvevacrelsec4M239( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvevacrelsec_data4M239( AV7CliCod) ;
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

   public void gxaconvevacrelsec_html4M239( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconvevacrelsec_data4M239( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveVacRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveVacRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvevacrelsec_data4M239( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T004M24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(22) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004M24_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004M24_A1880CliReDTChar[0]);
         pr_default.readNext(22);
      }
      pr_default.close(22);
   }

   public void gx2asaclicod4M204( int AV7CliCod )
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
            clienteconvenio_particularidades_impl.this.GXt_int10 = GXv_int11[0] ;
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

   public void xc_19_4M204( String Gx_mode ,
                            int AV7CliCod ,
                            int A1897ConveRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1897ConveRelSec, GXv_boolean5) ;
         AV24aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV24aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_24_4M239( String Gx_mode ,
                            int AV7CliCod ,
                            int A1902ConveVacRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean5) ;
         AV24aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV24aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_86239( ) ;
      while ( nGXsfl_86_idx <= nRC_GXsfl_86 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal4M239( ) ;
         standaloneModal4M239( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow4M239( ) ;
         nGXsfl_86_idx = (int)(nGXsfl_86_idx+1) ;
         sGXsfl_86_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_86_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_86239( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      cmbConveDiaHsPExt.setName( "CONVEDIAHSPEXT" );
      cmbConveDiaHsPExt.setWebtags( "" );
      cmbConveDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbConveDiaHsPExt.getItemCount() > 0 )
      {
         A1270ConveDiaHsPExt = cmbConveDiaHsPExt.getValidValue(A1270ConveDiaHsPExt) ;
         n1270ConveDiaHsPExt = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1270ConveDiaHsPExt", A1270ConveDiaHsPExt);
      }
      chkConveFondoCese.setName( "CONVEFONDOCESE" );
      chkConveFondoCese.setWebtags( "" );
      chkConveFondoCese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveFondoCese.getInternalname(), "TitleCaption", chkConveFondoCese.getCaption(), true);
      chkConveFondoCese.setCheckedValue( "false" );
      A1401ConveFondoCese = GXutil.strtobool( GXutil.booltostr( A1401ConveFondoCese)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1401ConveFondoCese", A1401ConveFondoCese);
      dynConveRelSec.setName( "CONVERELSEC" );
      dynConveRelSec.setWebtags( "" );
      GXCCtl = "CONVEVACRELSEC_" + sGXsfl_86_idx ;
      dynConveVacRelSec.setName( GXCCtl );
      dynConveVacRelSec.setWebtags( "" );
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

   public void valid_Clipaiconve( )
   {
      A1897ConveRelSec = (int)(GXutil.lval( dynConveRelSec.getValue())) ;
      A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValue())) ;
      /* Using cursor T004M25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Converelsec( )
   {
      A1897ConveRelSec = (int)(GXutil.lval( dynConveRelSec.getValue())) ;
      A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValue())) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1897ConveRelSec, GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
         AV24aplicadoHay = this.AV24aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
   }

   public void valid_Convevacrelsec( )
   {
      A1897ConveRelSec = (int)(GXutil.lval( dynConveRelSec.getValue())) ;
      A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValue())) ;
      if ( ( ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) && (0==A1902ConveVacRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEVACRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveVacRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean5) ;
         clienteconvenio_particularidades_impl.this.AV24aplicadoHay = GXv_boolean5[0] ;
         AV24aplicadoHay = this.AV24aplicadoHay ;
      }
      O1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
      O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
      O1763CliConveVacDias = A1763CliConveVacDias ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'A2036ConveRelRef',fld:'CONVERELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124M2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVIG","{handler:'valid_Cliconvevig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICONVEVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEMESHSPEXT","{handler:'valid_Convemeshspext',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEMESHSPEXT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEDIAHSPEXT","{handler:'valid_Convediahspext',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEDIAHSPEXT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEFONDOCESE","{handler:'valid_Convefondocese',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEFONDOCESE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVERELSEC","{handler:'valid_Converelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVERELSEC",",oparms:[{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEGUAREDADMAX","{handler:'valid_Conveguaredadmax',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEGUAREDADMAX",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEGUAREDADMIN","{handler:'valid_Conveguaredadmin',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEGUAREDADMIN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICONVENIO","{handler:'validv_Combocliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACDESANT","{handler:'valid_Cliconvevacdesant',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACDESANT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACHASANT","{handler:'valid_Cliconvevachasant',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACHASANT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACDIAS","{handler:'valid_Cliconvevacdias',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACDIAS",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
      setEventMetadata("VALID_CONVEVACRELSEC","{handler:'valid_Convevacrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O1763CliConveVacDias'},{av:'O1762CliConveVacHasAnt'},{av:'O1761CliConveVacDesAnt'},{av:'A1761CliConveVacDesAnt',fld:'CLICONVEVACDESANT',pic:'Z9'},{av:'A1762CliConveVacHasAnt',fld:'CLICONVEVACHASANT',pic:'Z9'},{av:'A1763CliConveVacDias',fld:'CLICONVEVACDIAS',pic:'Z9'},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]");
      setEventMetadata("VALID_CONVEVACRELSEC",",oparms:[{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynConveRelSec'},{av:'A1897ConveRelSec',fld:'CONVERELSEC',pic:'ZZZZZ9'},{av:'A1401ConveFondoCese',fld:'CONVEFONDOCESE',pic:''}]}");
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
      pr_default.close(23);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10CliConveVig = GXutil.nullDate() ;
      Z1565CliConvenio = "" ;
      Z1575CliConveVig = GXutil.nullDate() ;
      Z1269ConveMesHsPExt = DecimalUtil.ZERO ;
      Z1270ConveDiaHsPExt = "" ;
      Z2036ConveRelRef = "" ;
      O1270ConveDiaHsPExt = "" ;
      O1269ConveMesHsPExt = DecimalUtil.ZERO ;
      O1575CliConveVig = GXutil.nullDate() ;
      O1565CliConvenio = "" ;
      Combo_cliconvenio_Selectedvalue_get = "" ;
      Z2038ConveVacRelRef = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1565CliConvenio = "" ;
      AV9CliConvenio = "" ;
      AV10CliConveVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1270ConveDiaHsPExt = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcliconvenio_Jsonclick = "" ;
      ucCombo_cliconvenio = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16CliConvenio_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      B1270ConveDiaHsPExt = "" ;
      B1269ConveMesHsPExt = DecimalUtil.ZERO ;
      B1575CliConveVig = GXutil.nullDate() ;
      B1565CliConvenio = "" ;
      sMode239 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV21ComboCliConvenio = "" ;
      A2036ConveRelRef = "" ;
      A2037ConvePartOld = "" ;
      AV25Pgmname = "" ;
      A2038ConveVacRelRef = "" ;
      A2039ConveVacOld = "" ;
      Combo_cliconvenio_Objectcall = "" ;
      Combo_cliconvenio_Class = "" ;
      Combo_cliconvenio_Icontype = "" ;
      Combo_cliconvenio_Icon = "" ;
      Combo_cliconvenio_Tooltip = "" ;
      Combo_cliconvenio_Selectedvalue_set = "" ;
      Combo_cliconvenio_Selectedtext_set = "" ;
      Combo_cliconvenio_Selectedtext_get = "" ;
      Combo_cliconvenio_Gamoauthtoken = "" ;
      Combo_cliconvenio_Ddointernalname = "" ;
      Combo_cliconvenio_Titlecontrolalign = "" ;
      Combo_cliconvenio_Dropdownoptionstype = "" ;
      Combo_cliconvenio_Titlecontrolidtoreplace = "" ;
      Combo_cliconvenio_Datalisttype = "" ;
      Combo_cliconvenio_Datalistfixedvalues = "" ;
      Combo_cliconvenio_Remoteservicesparameters = "" ;
      Combo_cliconvenio_Htmltemplate = "" ;
      Combo_cliconvenio_Multiplevaluestype = "" ;
      Combo_cliconvenio_Loadingdata = "" ;
      Combo_cliconvenio_Noresultsfound = "" ;
      Combo_cliconvenio_Emptyitemtext = "" ;
      Combo_cliconvenio_Onlyselectedvalues = "" ;
      Combo_cliconvenio_Selectalltext = "" ;
      Combo_cliconvenio_Multiplevaluesseparator = "" ;
      Combo_cliconvenio_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_unnamedtable1_Objectcall = "" ;
      Dvpanel_unnamedtable1_Class = "" ;
      Dvpanel_unnamedtable1_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode204 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV20Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV18ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV19ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z2037ConvePartOld = "" ;
      T004M7_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M7_A905ConveDefault = new boolean[] {false} ;
      T004M7_A1043ConveInterDiasJor = new short[1] ;
      T004M7_A1044ConveDiasAcuVac = new byte[1] ;
      T004M7_A1046ConveMinMesesVac = new byte[1] ;
      T004M7_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004M7_A1270ConveDiaHsPExt = new String[] {""} ;
      T004M7_n1270ConveDiaHsPExt = new boolean[] {false} ;
      T004M7_A1401ConveFondoCese = new boolean[] {false} ;
      T004M7_A1627ConveGuarEdadMin = new byte[1] ;
      T004M7_n1627ConveGuarEdadMin = new boolean[] {false} ;
      T004M7_A1628ConveGuarEdadMax = new byte[1] ;
      T004M7_n1628ConveGuarEdadMax = new boolean[] {false} ;
      T004M7_A1897ConveRelSec = new int[1] ;
      T004M7_A2036ConveRelRef = new String[] {""} ;
      T004M7_A2037ConvePartOld = new String[] {""} ;
      T004M7_A3CliCod = new int[1] ;
      T004M7_A1564CliPaiConve = new short[1] ;
      T004M7_A1565CliConvenio = new String[] {""} ;
      T004M6_A3CliCod = new int[1] ;
      T004M8_A3CliCod = new int[1] ;
      T004M9_A3CliCod = new int[1] ;
      T004M9_A1564CliPaiConve = new short[1] ;
      T004M9_A1565CliConvenio = new String[] {""} ;
      T004M9_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M5_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M5_A905ConveDefault = new boolean[] {false} ;
      T004M5_A1043ConveInterDiasJor = new short[1] ;
      T004M5_A1044ConveDiasAcuVac = new byte[1] ;
      T004M5_A1046ConveMinMesesVac = new byte[1] ;
      T004M5_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004M5_A1270ConveDiaHsPExt = new String[] {""} ;
      T004M5_n1270ConveDiaHsPExt = new boolean[] {false} ;
      T004M5_A1401ConveFondoCese = new boolean[] {false} ;
      T004M5_A1627ConveGuarEdadMin = new byte[1] ;
      T004M5_n1627ConveGuarEdadMin = new boolean[] {false} ;
      T004M5_A1628ConveGuarEdadMax = new byte[1] ;
      T004M5_n1628ConveGuarEdadMax = new boolean[] {false} ;
      T004M5_A1897ConveRelSec = new int[1] ;
      T004M5_A2036ConveRelRef = new String[] {""} ;
      T004M5_A2037ConvePartOld = new String[] {""} ;
      T004M5_A3CliCod = new int[1] ;
      T004M5_A1564CliPaiConve = new short[1] ;
      T004M5_A1565CliConvenio = new String[] {""} ;
      T004M10_A3CliCod = new int[1] ;
      T004M10_A1564CliPaiConve = new short[1] ;
      T004M10_A1565CliConvenio = new String[] {""} ;
      T004M10_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M11_A3CliCod = new int[1] ;
      T004M11_A1564CliPaiConve = new short[1] ;
      T004M11_A1565CliConvenio = new String[] {""} ;
      T004M11_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M4_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M4_A905ConveDefault = new boolean[] {false} ;
      T004M4_A1043ConveInterDiasJor = new short[1] ;
      T004M4_A1044ConveDiasAcuVac = new byte[1] ;
      T004M4_A1046ConveMinMesesVac = new byte[1] ;
      T004M4_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004M4_A1270ConveDiaHsPExt = new String[] {""} ;
      T004M4_n1270ConveDiaHsPExt = new boolean[] {false} ;
      T004M4_A1401ConveFondoCese = new boolean[] {false} ;
      T004M4_A1627ConveGuarEdadMin = new byte[1] ;
      T004M4_n1627ConveGuarEdadMin = new boolean[] {false} ;
      T004M4_A1628ConveGuarEdadMax = new byte[1] ;
      T004M4_n1628ConveGuarEdadMax = new boolean[] {false} ;
      T004M4_A1897ConveRelSec = new int[1] ;
      T004M4_A2036ConveRelRef = new String[] {""} ;
      T004M4_A2037ConvePartOld = new String[] {""} ;
      T004M4_A3CliCod = new int[1] ;
      T004M4_A1564CliPaiConve = new short[1] ;
      T004M4_A1565CliConvenio = new String[] {""} ;
      T004M15_A3CliCod = new int[1] ;
      T004M15_A1564CliPaiConve = new short[1] ;
      T004M15_A1565CliConvenio = new String[] {""} ;
      T004M15_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M15_A2147CliConveFondoSec = new short[1] ;
      T004M16_A3CliCod = new int[1] ;
      T004M16_A1564CliPaiConve = new short[1] ;
      T004M16_A1565CliConvenio = new String[] {""} ;
      T004M16_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      Z2039ConveVacOld = "" ;
      T004M17_A3CliCod = new int[1] ;
      T004M17_A1565CliConvenio = new String[] {""} ;
      T004M17_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M17_A1761CliConveVacDesAnt = new byte[1] ;
      T004M17_A1762CliConveVacHasAnt = new byte[1] ;
      T004M17_A1763CliConveVacDias = new byte[1] ;
      T004M17_A1902ConveVacRelSec = new int[1] ;
      T004M17_A2038ConveVacRelRef = new String[] {""} ;
      T004M17_A2039ConveVacOld = new String[] {""} ;
      T004M17_A1564CliPaiConve = new short[1] ;
      T004M18_A3CliCod = new int[1] ;
      T004M18_A1564CliPaiConve = new short[1] ;
      T004M18_A1565CliConvenio = new String[] {""} ;
      T004M18_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M18_A1761CliConveVacDesAnt = new byte[1] ;
      T004M3_A3CliCod = new int[1] ;
      T004M3_A1565CliConvenio = new String[] {""} ;
      T004M3_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M3_A1761CliConveVacDesAnt = new byte[1] ;
      T004M3_A1762CliConveVacHasAnt = new byte[1] ;
      T004M3_A1763CliConveVacDias = new byte[1] ;
      T004M3_A1902ConveVacRelSec = new int[1] ;
      T004M3_A2038ConveVacRelRef = new String[] {""} ;
      T004M3_A2039ConveVacOld = new String[] {""} ;
      T004M3_A1564CliPaiConve = new short[1] ;
      T004M2_A3CliCod = new int[1] ;
      T004M2_A1565CliConvenio = new String[] {""} ;
      T004M2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M2_A1761CliConveVacDesAnt = new byte[1] ;
      T004M2_A1762CliConveVacHasAnt = new byte[1] ;
      T004M2_A1763CliConveVacDias = new byte[1] ;
      T004M2_A1902ConveVacRelSec = new int[1] ;
      T004M2_A2038ConveVacRelRef = new String[] {""} ;
      T004M2_A2039ConveVacOld = new String[] {""} ;
      T004M2_A1564CliPaiConve = new short[1] ;
      T004M22_A3CliCod = new int[1] ;
      T004M22_A1564CliPaiConve = new short[1] ;
      T004M22_A1565CliConvenio = new String[] {""} ;
      T004M22_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004M22_A1761CliConveVacDesAnt = new byte[1] ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004M23_A3CliCod = new int[1] ;
      T004M23_A1885CliRelSec = new int[1] ;
      T004M23_A1880CliReDTChar = new String[] {""} ;
      T004M24_A3CliCod = new int[1] ;
      T004M24_A1885CliRelSec = new int[1] ;
      T004M24_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T004M25_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_particularidades__default(),
         new Object[] {
             new Object[] {
            T004M2_A3CliCod, T004M2_A1565CliConvenio, T004M2_A1575CliConveVig, T004M2_A1761CliConveVacDesAnt, T004M2_A1762CliConveVacHasAnt, T004M2_A1763CliConveVacDias, T004M2_A1902ConveVacRelSec, T004M2_A2038ConveVacRelRef, T004M2_A2039ConveVacOld, T004M2_A1564CliPaiConve
            }
            , new Object[] {
            T004M3_A3CliCod, T004M3_A1565CliConvenio, T004M3_A1575CliConveVig, T004M3_A1761CliConveVacDesAnt, T004M3_A1762CliConveVacHasAnt, T004M3_A1763CliConveVacDias, T004M3_A1902ConveVacRelSec, T004M3_A2038ConveVacRelRef, T004M3_A2039ConveVacOld, T004M3_A1564CliPaiConve
            }
            , new Object[] {
            T004M4_A1575CliConveVig, T004M4_A905ConveDefault, T004M4_A1043ConveInterDiasJor, T004M4_A1044ConveDiasAcuVac, T004M4_A1046ConveMinMesesVac, T004M4_A1269ConveMesHsPExt, T004M4_A1270ConveDiaHsPExt, T004M4_n1270ConveDiaHsPExt, T004M4_A1401ConveFondoCese, T004M4_A1627ConveGuarEdadMin,
            T004M4_n1627ConveGuarEdadMin, T004M4_A1628ConveGuarEdadMax, T004M4_n1628ConveGuarEdadMax, T004M4_A1897ConveRelSec, T004M4_A2036ConveRelRef, T004M4_A2037ConvePartOld, T004M4_A3CliCod, T004M4_A1564CliPaiConve, T004M4_A1565CliConvenio
            }
            , new Object[] {
            T004M5_A1575CliConveVig, T004M5_A905ConveDefault, T004M5_A1043ConveInterDiasJor, T004M5_A1044ConveDiasAcuVac, T004M5_A1046ConveMinMesesVac, T004M5_A1269ConveMesHsPExt, T004M5_A1270ConveDiaHsPExt, T004M5_n1270ConveDiaHsPExt, T004M5_A1401ConveFondoCese, T004M5_A1627ConveGuarEdadMin,
            T004M5_n1627ConveGuarEdadMin, T004M5_A1628ConveGuarEdadMax, T004M5_n1628ConveGuarEdadMax, T004M5_A1897ConveRelSec, T004M5_A2036ConveRelRef, T004M5_A2037ConvePartOld, T004M5_A3CliCod, T004M5_A1564CliPaiConve, T004M5_A1565CliConvenio
            }
            , new Object[] {
            T004M6_A3CliCod
            }
            , new Object[] {
            T004M7_A1575CliConveVig, T004M7_A905ConveDefault, T004M7_A1043ConveInterDiasJor, T004M7_A1044ConveDiasAcuVac, T004M7_A1046ConveMinMesesVac, T004M7_A1269ConveMesHsPExt, T004M7_A1270ConveDiaHsPExt, T004M7_n1270ConveDiaHsPExt, T004M7_A1401ConveFondoCese, T004M7_A1627ConveGuarEdadMin,
            T004M7_n1627ConveGuarEdadMin, T004M7_A1628ConveGuarEdadMax, T004M7_n1628ConveGuarEdadMax, T004M7_A1897ConveRelSec, T004M7_A2036ConveRelRef, T004M7_A2037ConvePartOld, T004M7_A3CliCod, T004M7_A1564CliPaiConve, T004M7_A1565CliConvenio
            }
            , new Object[] {
            T004M8_A3CliCod
            }
            , new Object[] {
            T004M9_A3CliCod, T004M9_A1564CliPaiConve, T004M9_A1565CliConvenio, T004M9_A1575CliConveVig
            }
            , new Object[] {
            T004M10_A3CliCod, T004M10_A1564CliPaiConve, T004M10_A1565CliConvenio, T004M10_A1575CliConveVig
            }
            , new Object[] {
            T004M11_A3CliCod, T004M11_A1564CliPaiConve, T004M11_A1565CliConvenio, T004M11_A1575CliConveVig
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004M15_A3CliCod, T004M15_A1564CliPaiConve, T004M15_A1565CliConvenio, T004M15_A1575CliConveVig, T004M15_A2147CliConveFondoSec
            }
            , new Object[] {
            T004M16_A3CliCod, T004M16_A1564CliPaiConve, T004M16_A1565CliConvenio, T004M16_A1575CliConveVig
            }
            , new Object[] {
            T004M17_A3CliCod, T004M17_A1565CliConvenio, T004M17_A1575CliConveVig, T004M17_A1761CliConveVacDesAnt, T004M17_A1762CliConveVacHasAnt, T004M17_A1763CliConveVacDias, T004M17_A1902ConveVacRelSec, T004M17_A2038ConveVacRelRef, T004M17_A2039ConveVacOld, T004M17_A1564CliPaiConve
            }
            , new Object[] {
            T004M18_A3CliCod, T004M18_A1564CliPaiConve, T004M18_A1565CliConvenio, T004M18_A1575CliConveVig, T004M18_A1761CliConveVacDesAnt
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004M22_A3CliCod, T004M22_A1564CliPaiConve, T004M22_A1565CliConvenio, T004M22_A1575CliConveVig, T004M22_A1761CliConveVacDesAnt
            }
            , new Object[] {
            T004M23_A3CliCod, T004M23_A1885CliRelSec, T004M23_A1880CliReDTChar
            }
            , new Object[] {
            T004M24_A3CliCod, T004M24_A1885CliRelSec, T004M24_A1880CliReDTChar
            }
            , new Object[] {
            T004M25_A3CliCod
            }
         }
      );
      AV25Pgmname = "ClienteConvenio_Particularidades" ;
   }

   private byte Z1044ConveDiasAcuVac ;
   private byte Z1046ConveMinMesesVac ;
   private byte Z1627ConveGuarEdadMin ;
   private byte Z1628ConveGuarEdadMax ;
   private byte O1627ConveGuarEdadMin ;
   private byte O1628ConveGuarEdadMax ;
   private byte Z1761CliConveVacDesAnt ;
   private byte Z1762CliConveVacHasAnt ;
   private byte Z1763CliConveVacDias ;
   private byte O1761CliConveVacDesAnt ;
   private byte O1762CliConveVacHasAnt ;
   private byte O1763CliConveVacDias ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1628ConveGuarEdadMax ;
   private byte A1627ConveGuarEdadMin ;
   private byte A1044ConveDiasAcuVac ;
   private byte A1046ConveMinMesesVac ;
   private byte B1627ConveGuarEdadMin ;
   private byte B1628ConveGuarEdadMax ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private byte T1761CliConveVacDesAnt ;
   private byte T1762CliConveVacHasAnt ;
   private byte T1763CliConveVacDias ;
   private byte Gx_BScreen ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short Z1043ConveInterDiasJor ;
   private short nRcdDeleted_239 ;
   private short nRcdExists_239 ;
   private short nIsMod_239 ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1043ConveInterDiasJor ;
   private short nBlankRcdCount239 ;
   private short RcdFound239 ;
   private short nBlankRcdUsr239 ;
   private short AV22esSistemaConceptosDefault ;
   private short RcdFound204 ;
   private short nIsDirty_204 ;
   private short nIsDirty_239 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1897ConveRelSec ;
   private int nRC_GXsfl_86 ;
   private int nGXsfl_86_idx=1 ;
   private int Z1902ConveVacRelSec ;
   private int AV7CliCod ;
   private int A1897ConveRelSec ;
   private int A1902ConveVacRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int edtCliConveVig_Enabled ;
   private int edtConveMesHsPExt_Enabled ;
   private int edtConveGuarEdadMax_Enabled ;
   private int edtConveGuarEdadMin_Enabled ;
   private int edtConveInterDiasJor_Enabled ;
   private int edtConveDiasAcuVac_Enabled ;
   private int edtConveMinMesesVac_Enabled ;
   private int edtCliConveVacDesAnt_Enabled ;
   private int edtCliConveVacHasAnt_Enabled ;
   private int edtCliConveVacDias_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombocliconvenio_Visible ;
   private int edtavCombocliconvenio_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtConveDefault_Visible ;
   private int edtConveDefault_Enabled ;
   private int Combo_cliconvenio_Datalistupdateminimumcharacters ;
   private int Combo_cliconvenio_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_unnamedtable1_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtCliConveVacDesAnt_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private java.math.BigDecimal Z1269ConveMesHsPExt ;
   private java.math.BigDecimal O1269ConveMesHsPExt ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private java.math.BigDecimal B1269ConveMesHsPExt ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String Z1565CliConvenio ;
   private String Z1270ConveDiaHsPExt ;
   private String O1270ConveDiaHsPExt ;
   private String O1565CliConvenio ;
   private String Combo_cliconvenio_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1565CliConvenio ;
   private String AV9CliConvenio ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliConvenio_Internalname ;
   private String sGXsfl_86_idx="0001" ;
   private String A1270ConveDiaHsPExt ;
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
   private String divTablesplittedcliconvenio_Internalname ;
   private String lblTextblockcliconvenio_Internalname ;
   private String lblTextblockcliconvenio_Jsonclick ;
   private String Combo_cliconvenio_Caption ;
   private String Combo_cliconvenio_Cls ;
   private String Combo_cliconvenio_Datalistproc ;
   private String Combo_cliconvenio_Internalname ;
   private String TempTags ;
   private String edtCliConvenio_Jsonclick ;
   private String edtCliConveVig_Internalname ;
   private String edtCliConveVig_Jsonclick ;
   private String edtConveMesHsPExt_Internalname ;
   private String edtConveMesHsPExt_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divConverelsec_cell_Internalname ;
   private String divConverelsec_cell_Class ;
   private String edtConveGuarEdadMax_Internalname ;
   private String edtConveGuarEdadMax_Jsonclick ;
   private String edtConveGuarEdadMin_Internalname ;
   private String edtConveGuarEdadMin_Jsonclick ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtConveInterDiasJor_Internalname ;
   private String edtConveInterDiasJor_Jsonclick ;
   private String edtConveDiasAcuVac_Internalname ;
   private String edtConveDiasAcuVac_Jsonclick ;
   private String edtConveMinMesesVac_Internalname ;
   private String edtConveMinMesesVac_Jsonclick ;
   private String B1270ConveDiaHsPExt ;
   private String B1565CliConvenio ;
   private String sMode239 ;
   private String edtCliConveVacDesAnt_Internalname ;
   private String edtCliConveVacHasAnt_Internalname ;
   private String edtCliConveVacDias_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_cliconvenio_Internalname ;
   private String edtavCombocliconvenio_Internalname ;
   private String AV21ComboCliConvenio ;
   private String edtavCombocliconvenio_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtConveDefault_Internalname ;
   private String edtConveDefault_Jsonclick ;
   private String AV25Pgmname ;
   private String Combo_cliconvenio_Objectcall ;
   private String Combo_cliconvenio_Class ;
   private String Combo_cliconvenio_Icontype ;
   private String Combo_cliconvenio_Icon ;
   private String Combo_cliconvenio_Tooltip ;
   private String Combo_cliconvenio_Selectedvalue_set ;
   private String Combo_cliconvenio_Selectedtext_set ;
   private String Combo_cliconvenio_Selectedtext_get ;
   private String Combo_cliconvenio_Gamoauthtoken ;
   private String Combo_cliconvenio_Ddointernalname ;
   private String Combo_cliconvenio_Titlecontrolalign ;
   private String Combo_cliconvenio_Dropdownoptionstype ;
   private String Combo_cliconvenio_Titlecontrolidtoreplace ;
   private String Combo_cliconvenio_Datalisttype ;
   private String Combo_cliconvenio_Datalistfixedvalues ;
   private String Combo_cliconvenio_Datalistprocparametersprefix ;
   private String Combo_cliconvenio_Remoteservicesparameters ;
   private String Combo_cliconvenio_Htmltemplate ;
   private String Combo_cliconvenio_Multiplevaluestype ;
   private String Combo_cliconvenio_Loadingdata ;
   private String Combo_cliconvenio_Noresultsfound ;
   private String Combo_cliconvenio_Emptyitemtext ;
   private String Combo_cliconvenio_Onlyselectedvalues ;
   private String Combo_cliconvenio_Selectalltext ;
   private String Combo_cliconvenio_Multiplevaluesseparator ;
   private String Combo_cliconvenio_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_unnamedtable1_Objectcall ;
   private String Dvpanel_unnamedtable1_Class ;
   private String Dvpanel_unnamedtable1_Height ;
   private String hsh ;
   private String sMode204 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String sGXsfl_86_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtCliConveVacDesAnt_Jsonclick ;
   private String edtCliConveVacHasAnt_Jsonclick ;
   private String edtCliConveVacDias_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV10CliConveVig ;
   private java.util.Date Z1575CliConveVig ;
   private java.util.Date O1575CliConveVig ;
   private java.util.Date AV10CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date B1575CliConveVig ;
   private boolean Z905ConveDefault ;
   private boolean Z1401ConveFondoCese ;
   private boolean O1401ConveFondoCese ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean A1401ConveFondoCese ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_cliconvenio_Emptyitem ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1628ConveGuarEdadMax ;
   private boolean B1401ConveFondoCese ;
   private boolean bGXsfl_86_Refreshing=false ;
   private boolean A905ConveDefault ;
   private boolean AV23ClienteConveniador ;
   private boolean AV24aplicadoHay ;
   private boolean Combo_cliconvenio_Enabled ;
   private boolean Combo_cliconvenio_Visible ;
   private boolean Combo_cliconvenio_Allowmultipleselection ;
   private boolean Combo_cliconvenio_Isgriditem ;
   private boolean Combo_cliconvenio_Hasdescription ;
   private boolean Combo_cliconvenio_Includeonlyselectedoption ;
   private boolean Combo_cliconvenio_Includeselectalloption ;
   private boolean Combo_cliconvenio_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_unnamedtable1_Enabled ;
   private boolean Dvpanel_unnamedtable1_Showheader ;
   private boolean Dvpanel_unnamedtable1_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean ZV24aplicadoHay ;
   private boolean GXv_boolean5[] ;
   private String A2037ConvePartOld ;
   private String A2039ConveVacOld ;
   private String AV20Combo_DataJson ;
   private String Z2037ConvePartOld ;
   private String Z2039ConveVacOld ;
   private String Z2036ConveRelRef ;
   private String Z2038ConveVacRelRef ;
   private String A2036ConveRelRef ;
   private String A2038ConveVacRelRef ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliconvenio ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConveDiaHsPExt ;
   private ICheckbox chkConveFondoCese ;
   private HTMLChoice dynConveRelSec ;
   private HTMLChoice dynConveVacRelSec ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T004M7_A1575CliConveVig ;
   private boolean[] T004M7_A905ConveDefault ;
   private short[] T004M7_A1043ConveInterDiasJor ;
   private byte[] T004M7_A1044ConveDiasAcuVac ;
   private byte[] T004M7_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] T004M7_A1269ConveMesHsPExt ;
   private String[] T004M7_A1270ConveDiaHsPExt ;
   private boolean[] T004M7_n1270ConveDiaHsPExt ;
   private boolean[] T004M7_A1401ConveFondoCese ;
   private byte[] T004M7_A1627ConveGuarEdadMin ;
   private boolean[] T004M7_n1627ConveGuarEdadMin ;
   private byte[] T004M7_A1628ConveGuarEdadMax ;
   private boolean[] T004M7_n1628ConveGuarEdadMax ;
   private int[] T004M7_A1897ConveRelSec ;
   private String[] T004M7_A2036ConveRelRef ;
   private String[] T004M7_A2037ConvePartOld ;
   private int[] T004M7_A3CliCod ;
   private short[] T004M7_A1564CliPaiConve ;
   private String[] T004M7_A1565CliConvenio ;
   private int[] T004M6_A3CliCod ;
   private int[] T004M8_A3CliCod ;
   private int[] T004M9_A3CliCod ;
   private short[] T004M9_A1564CliPaiConve ;
   private String[] T004M9_A1565CliConvenio ;
   private java.util.Date[] T004M9_A1575CliConveVig ;
   private java.util.Date[] T004M5_A1575CliConveVig ;
   private boolean[] T004M5_A905ConveDefault ;
   private short[] T004M5_A1043ConveInterDiasJor ;
   private byte[] T004M5_A1044ConveDiasAcuVac ;
   private byte[] T004M5_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] T004M5_A1269ConveMesHsPExt ;
   private String[] T004M5_A1270ConveDiaHsPExt ;
   private boolean[] T004M5_n1270ConveDiaHsPExt ;
   private boolean[] T004M5_A1401ConveFondoCese ;
   private byte[] T004M5_A1627ConveGuarEdadMin ;
   private boolean[] T004M5_n1627ConveGuarEdadMin ;
   private byte[] T004M5_A1628ConveGuarEdadMax ;
   private boolean[] T004M5_n1628ConveGuarEdadMax ;
   private int[] T004M5_A1897ConveRelSec ;
   private String[] T004M5_A2036ConveRelRef ;
   private String[] T004M5_A2037ConvePartOld ;
   private int[] T004M5_A3CliCod ;
   private short[] T004M5_A1564CliPaiConve ;
   private String[] T004M5_A1565CliConvenio ;
   private int[] T004M10_A3CliCod ;
   private short[] T004M10_A1564CliPaiConve ;
   private String[] T004M10_A1565CliConvenio ;
   private java.util.Date[] T004M10_A1575CliConveVig ;
   private int[] T004M11_A3CliCod ;
   private short[] T004M11_A1564CliPaiConve ;
   private String[] T004M11_A1565CliConvenio ;
   private java.util.Date[] T004M11_A1575CliConveVig ;
   private java.util.Date[] T004M4_A1575CliConveVig ;
   private boolean[] T004M4_A905ConveDefault ;
   private short[] T004M4_A1043ConveInterDiasJor ;
   private byte[] T004M4_A1044ConveDiasAcuVac ;
   private byte[] T004M4_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] T004M4_A1269ConveMesHsPExt ;
   private String[] T004M4_A1270ConveDiaHsPExt ;
   private boolean[] T004M4_n1270ConveDiaHsPExt ;
   private boolean[] T004M4_A1401ConveFondoCese ;
   private byte[] T004M4_A1627ConveGuarEdadMin ;
   private boolean[] T004M4_n1627ConveGuarEdadMin ;
   private byte[] T004M4_A1628ConveGuarEdadMax ;
   private boolean[] T004M4_n1628ConveGuarEdadMax ;
   private int[] T004M4_A1897ConveRelSec ;
   private String[] T004M4_A2036ConveRelRef ;
   private String[] T004M4_A2037ConvePartOld ;
   private int[] T004M4_A3CliCod ;
   private short[] T004M4_A1564CliPaiConve ;
   private String[] T004M4_A1565CliConvenio ;
   private int[] T004M15_A3CliCod ;
   private short[] T004M15_A1564CliPaiConve ;
   private String[] T004M15_A1565CliConvenio ;
   private java.util.Date[] T004M15_A1575CliConveVig ;
   private short[] T004M15_A2147CliConveFondoSec ;
   private int[] T004M16_A3CliCod ;
   private short[] T004M16_A1564CliPaiConve ;
   private String[] T004M16_A1565CliConvenio ;
   private java.util.Date[] T004M16_A1575CliConveVig ;
   private int[] T004M17_A3CliCod ;
   private String[] T004M17_A1565CliConvenio ;
   private java.util.Date[] T004M17_A1575CliConveVig ;
   private byte[] T004M17_A1761CliConveVacDesAnt ;
   private byte[] T004M17_A1762CliConveVacHasAnt ;
   private byte[] T004M17_A1763CliConveVacDias ;
   private int[] T004M17_A1902ConveVacRelSec ;
   private String[] T004M17_A2038ConveVacRelRef ;
   private String[] T004M17_A2039ConveVacOld ;
   private short[] T004M17_A1564CliPaiConve ;
   private int[] T004M18_A3CliCod ;
   private short[] T004M18_A1564CliPaiConve ;
   private String[] T004M18_A1565CliConvenio ;
   private java.util.Date[] T004M18_A1575CliConveVig ;
   private byte[] T004M18_A1761CliConveVacDesAnt ;
   private int[] T004M3_A3CliCod ;
   private String[] T004M3_A1565CliConvenio ;
   private java.util.Date[] T004M3_A1575CliConveVig ;
   private byte[] T004M3_A1761CliConveVacDesAnt ;
   private byte[] T004M3_A1762CliConveVacHasAnt ;
   private byte[] T004M3_A1763CliConveVacDias ;
   private int[] T004M3_A1902ConveVacRelSec ;
   private String[] T004M3_A2038ConveVacRelRef ;
   private String[] T004M3_A2039ConveVacOld ;
   private short[] T004M3_A1564CliPaiConve ;
   private int[] T004M2_A3CliCod ;
   private String[] T004M2_A1565CliConvenio ;
   private java.util.Date[] T004M2_A1575CliConveVig ;
   private byte[] T004M2_A1761CliConveVacDesAnt ;
   private byte[] T004M2_A1762CliConveVacHasAnt ;
   private byte[] T004M2_A1763CliConveVacDias ;
   private int[] T004M2_A1902ConveVacRelSec ;
   private String[] T004M2_A2038ConveVacRelRef ;
   private String[] T004M2_A2039ConveVacOld ;
   private short[] T004M2_A1564CliPaiConve ;
   private int[] T004M22_A3CliCod ;
   private short[] T004M22_A1564CliPaiConve ;
   private String[] T004M22_A1565CliConvenio ;
   private java.util.Date[] T004M22_A1575CliConveVig ;
   private byte[] T004M22_A1761CliConveVacDesAnt ;
   private int[] T004M23_A3CliCod ;
   private int[] T004M23_A1885CliRelSec ;
   private String[] T004M23_A1880CliReDTChar ;
   private int[] T004M24_A3CliCod ;
   private int[] T004M24_A1885CliRelSec ;
   private String[] T004M24_A1880CliReDTChar ;
   private int[] T004M25_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16CliConvenio_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class clienteconvenio_particularidades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004M2", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?  FOR UPDATE OF ClienteConvenio_ParticularidadesVacacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M3", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M4", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?  FOR UPDATE OF ClienteConvenio_Particularidades NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M5", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M6", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M7", "SELECT TM1.CliConveVig, TM1.ConveDefault, TM1.ConveInterDiasJor, TM1.ConveDiasAcuVac, TM1.ConveMinMesesVac, TM1.ConveMesHsPExt, TM1.ConveDiaHsPExt, TM1.ConveFondoCese, TM1.ConveGuarEdadMin, TM1.ConveGuarEdadMax, TM1.ConveRelSec, TM1.ConveRelRef, TM1.ConvePartOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM ClienteConvenio_Particularidades TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveVig = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M8", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M9", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M10", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004M11", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CliConveVig DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004M12", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_Particularidades(CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004M13", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_Particularidades SET ConveDefault=?, ConveInterDiasJor=?, ConveDiasAcuVac=?, ConveMinMesesVac=?, ConveMesHsPExt=?, ConveDiaHsPExt=?, ConveFondoCese=?, ConveGuarEdadMin=?, ConveGuarEdadMax=?, ConveRelSec=?, ConveRelRef=?, ConvePartOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004M14", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenio_Particularidades  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004M15", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004M16", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M17", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveVacDesAnt = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M18", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T004M19", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_ParticularidadesVacacion(CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004M20", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_ParticularidadesVacacion SET CliConveVacHasAnt=?, CliConveVacDias=?, ConveVacRelSec=?, ConveVacRelRef=?, ConveVacOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004M21", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenio_ParticularidadesVacacion  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004M22", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M23", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M24", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004M25", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[10]).byteValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[12]).byteValue());
               }
               stmt.setInt(11, ((Number) parms[13]).intValue());
               stmt.setVarchar(12, (String)parms[14], 40, false);
               stmt.setNLongVarchar(13, (String)parms[15], false);
               stmt.setInt(14, ((Number) parms[16]).intValue());
               stmt.setShort(15, ((Number) parms[17]).shortValue());
               stmt.setString(16, (String)parms[18], 20);
               return;
            case 11 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(8, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[11]).byteValue());
               }
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setVarchar(11, (String)parms[13], 40, false);
               stmt.setNLongVarchar(12, (String)parms[14], false);
               stmt.setInt(13, ((Number) parms[15]).intValue());
               stmt.setShort(14, ((Number) parms[16]).shortValue());
               stmt.setString(15, (String)parms[17], 20);
               stmt.setDate(16, (java.util.Date)parms[18]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 18 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

