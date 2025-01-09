package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajofamilia_impl extends GXDataArea
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
         gx1asaclicod61262( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A3CliCod, A1EmpCod, A87MigrLegNumero) ;
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
            AV9MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9MigrLegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MigrLegNumero), "ZZZZZZZ9")));
            AV10MigrLegFamSec = (short)(GXutil.lval( httpContext.GetPar( "MigrLegFamSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10MigrLegFamSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGFAMSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10MigrLegFamSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "importacion_legajo Familia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMigrLegFamParen_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public importacion_legajofamilia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajofamilia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajofamilia_impl.class ));
   }

   public importacion_legajofamilia_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbMigrLegFamAdh = new HTMLChoice();
      cmbMigrLegFamDiscap = new HTMLChoice();
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
      if ( cmbMigrLegFamAdh.getItemCount() > 0 )
      {
         A2082MigrLegFamAdh = cmbMigrLegFamAdh.getValidValue(A2082MigrLegFamAdh) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegFamAdh.setValue( GXutil.rtrim( A2082MigrLegFamAdh) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamAdh.getInternalname(), "Values", cmbMigrLegFamAdh.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegFamDiscap.getItemCount() > 0 )
      {
         A2086MigrLegFamDiscap = cmbMigrLegFamDiscap.getValidValue(A2086MigrLegFamDiscap) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegFamDiscap.setValue( GXutil.rtrim( A2086MigrLegFamDiscap) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamDiscap.getInternalname(), "Values", cmbMigrLegFamDiscap.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Control Group */
      web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Legajo", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_importacion_legajoFamilia.htm");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegApellido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegApellido_Internalname, A592MigrLegApellido, "", "", (short)(0), 1, edtMigrLegApellido_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegNombre_Internalname, httpContext.getMessage( "Nombres", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegNombre_Internalname, A593MigrLegNombre, "", "", (short)(0), 1, edtMigrLegNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCUIL_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCUIL_Internalname, httpContext.getMessage( "CUIL", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCUIL_Internalname, GXutil.rtrim( A597MigrLegCUIL), GXutil.rtrim( localUtil.format( A597MigrLegCUIL, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCUIL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCUIL_Enabled, 0, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Cuit", "left", true, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      httpContext.writeText( "</fieldset>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegfamparen_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegfamparen_Internalname, httpContext.getMessage( "Parentesco", ""), "", "", lblTextblockmigrlegfamparen_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegfamparen_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegfamparen_Internalname, tblTablemergedmigrlegfamparen_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* User Defined Control */
      ucCombo_migrlegfamparen.setProperty("Caption", Combo_migrlegfamparen_Caption);
      ucCombo_migrlegfamparen.setProperty("Cls", Combo_migrlegfamparen_Cls);
      ucCombo_migrlegfamparen.setProperty("EmptyItem", Combo_migrlegfamparen_Emptyitem);
      ucCombo_migrlegfamparen.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_migrlegfamparen.setProperty("DropDownOptionsData", AV16MigrLegFamParen_Data);
      ucCombo_migrlegfamparen.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_migrlegfamparen_Internalname, "COMBO_MIGRLEGFAMPARENContainer");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td class='Invisible'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFamParen_Internalname, httpContext.getMessage( "Parentesco", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamParen_Internalname, A2079MigrLegFamParen, GXutil.rtrim( localUtil.format( A2079MigrLegFamParen, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamParen_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegFamParen_Visible, edtMigrLegFamParen_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegfamparen_righttext_Internalname, lblMigrlegfamparen_righttext_Caption, "", "", lblMigrlegfamparen_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFamNroDoc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFamNroDoc_Internalname, httpContext.getMessage( "Nro. Doc.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamNroDoc_Internalname, A2080MigrLegFamNroDoc, GXutil.rtrim( localUtil.format( A2080MigrLegFamNroDoc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamNroDoc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegFamNroDoc_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFamNomApe_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFamNomApe_Internalname, httpContext.getMessage( "Nombre y apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamNomApe_Internalname, A2088MigrLegFamNomApe, GXutil.rtrim( localUtil.format( A2088MigrLegFamNomApe, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamNomApe_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegFamNomApe_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFamFecNac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFamFecNac_Internalname, httpContext.getMessage( "Fecha de nacimiento", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMigrLegFamFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamFecNac_Internalname, localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"), localUtil.format( A2089MigrLegFamFecNac, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamFecNac_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtMigrLegFamFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFamFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFamFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_importacion_legajoFamilia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFamDedGan_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFamDedGan_Internalname, httpContext.getMessage( "Deduce ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamDedGan_Internalname, GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegFamDedGan_Enabled!=0) ? localUtil.format( A2081MigrLegFamDedGan, "9.9999") : localUtil.format( A2081MigrLegFamDedGan, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamDedGan_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegFamDedGan_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegfamadh_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegfamadh_Internalname, httpContext.getMessage( "Adherente a la obra social", ""), "", "", lblTextblockmigrlegfamadh_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegfamadh_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegfamadh_Internalname, tblTablemergedmigrlegfamadh_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegFamAdh.getInternalname(), httpContext.getMessage( "Adherente a la obra social", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegFamAdh, cmbMigrLegFamAdh.getInternalname(), GXutil.rtrim( A2082MigrLegFamAdh), 1, cmbMigrLegFamAdh.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbMigrLegFamAdh.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "", true, (byte)(0), "HLP_importacion_legajoFamilia.htm");
      cmbMigrLegFamAdh.setValue( GXutil.rtrim( A2082MigrLegFamAdh) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamAdh.getInternalname(), "Values", cmbMigrLegFamAdh.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegfamadh_righttext_Internalname, lblMigrlegfamadh_righttext_Caption, "", "", lblMigrlegfamadh_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegfamdiscap_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegfamdiscap_Internalname, httpContext.getMessage( "Discapacitado", ""), "", "", lblTextblockmigrlegfamdiscap_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", ((lblTextblockmigrlegfamdiscap_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegfamdiscap_Internalname, tblTablemergedmigrlegfamdiscap_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegFamDiscap.getInternalname(), httpContext.getMessage( "Discapacitado", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegFamDiscap, cmbMigrLegFamDiscap.getInternalname(), GXutil.rtrim( A2086MigrLegFamDiscap), 1, cmbMigrLegFamDiscap.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbMigrLegFamDiscap.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(0), "HLP_importacion_legajoFamilia.htm");
      cmbMigrLegFamDiscap.setValue( GXutil.rtrim( A2086MigrLegFamDiscap) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamDiscap.getInternalname(), "Values", cmbMigrLegFamDiscap.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegfamdiscap_righttext_Internalname, lblMigrlegfamdiscap_righttext_Caption, "", "", lblMigrlegfamdiscap_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoFamilia.htm");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoFamilia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_migrlegfamparen_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomigrlegfamparen_Internalname, AV19ComboMigrLegFamParen, GXutil.rtrim( localUtil.format( AV19ComboMigrLegFamParen, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomigrlegfamparen_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomigrlegfamparen_Visible, edtavCombomigrlegfamparen_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,118);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,119);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_legajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegNumero_Visible, edtMigrLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_importacion_legajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFamSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,121);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFamSec_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegFamSec_Visible, edtMigrLegFamSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajoFamilia.htm");
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
      e11612 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMIGRLEGFAMPAREN_DATA"), AV16MigrLegFamParen_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z87MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2078MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z2078MigrLegFamSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2079MigrLegFamParen = httpContext.cgiGet( "Z2079MigrLegFamParen") ;
            Z2086MigrLegFamDiscap = httpContext.cgiGet( "Z2086MigrLegFamDiscap") ;
            Z2080MigrLegFamNroDoc = httpContext.cgiGet( "Z2080MigrLegFamNroDoc") ;
            Z2081MigrLegFamDedGan = localUtil.ctond( httpContext.cgiGet( "Z2081MigrLegFamDedGan")) ;
            Z2082MigrLegFamAdh = httpContext.cgiGet( "Z2082MigrLegFamAdh") ;
            Z2088MigrLegFamNomApe = httpContext.cgiGet( "Z2088MigrLegFamNomApe") ;
            Z2089MigrLegFamFecNac = localUtil.ctod( httpContext.cgiGet( "Z2089MigrLegFamFecNac"), 0) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vMIGRLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( "vMIGRLEGFAMSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2084MigrLegFamErrores = httpContext.cgiGet( "MIGRLEGFAMERRORES") ;
            A2085MigrLegFamWarnings = httpContext.cgiGet( "MIGRLEGFAMWARNINGS") ;
            AV34Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_migrlegfamparen_Objectcall = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Objectcall") ;
            Combo_migrlegfamparen_Class = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Class") ;
            Combo_migrlegfamparen_Icontype = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Icontype") ;
            Combo_migrlegfamparen_Icon = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Icon") ;
            Combo_migrlegfamparen_Caption = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Caption") ;
            Combo_migrlegfamparen_Tooltip = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Tooltip") ;
            Combo_migrlegfamparen_Cls = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Cls") ;
            Combo_migrlegfamparen_Selectedvalue_set = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Selectedvalue_set") ;
            Combo_migrlegfamparen_Selectedvalue_get = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Selectedvalue_get") ;
            Combo_migrlegfamparen_Selectedtext_set = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Selectedtext_set") ;
            Combo_migrlegfamparen_Selectedtext_get = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Selectedtext_get") ;
            Combo_migrlegfamparen_Gamoauthtoken = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Gamoauthtoken") ;
            Combo_migrlegfamparen_Ddointernalname = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Ddointernalname") ;
            Combo_migrlegfamparen_Titlecontrolalign = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Titlecontrolalign") ;
            Combo_migrlegfamparen_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Dropdownoptionstype") ;
            Combo_migrlegfamparen_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Enabled")) ;
            Combo_migrlegfamparen_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Visible")) ;
            Combo_migrlegfamparen_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Titlecontrolidtoreplace") ;
            Combo_migrlegfamparen_Datalisttype = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Datalisttype") ;
            Combo_migrlegfamparen_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Allowmultipleselection")) ;
            Combo_migrlegfamparen_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Datalistfixedvalues") ;
            Combo_migrlegfamparen_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Isgriditem")) ;
            Combo_migrlegfamparen_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Hasdescription")) ;
            Combo_migrlegfamparen_Datalistproc = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Datalistproc") ;
            Combo_migrlegfamparen_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Datalistprocparametersprefix") ;
            Combo_migrlegfamparen_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Remoteservicesparameters") ;
            Combo_migrlegfamparen_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_migrlegfamparen_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Includeonlyselectedoption")) ;
            Combo_migrlegfamparen_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Includeselectalloption")) ;
            Combo_migrlegfamparen_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Emptyitem")) ;
            Combo_migrlegfamparen_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Includeaddnewoption")) ;
            Combo_migrlegfamparen_Htmltemplate = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Htmltemplate") ;
            Combo_migrlegfamparen_Multiplevaluestype = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Multiplevaluestype") ;
            Combo_migrlegfamparen_Loadingdata = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Loadingdata") ;
            Combo_migrlegfamparen_Noresultsfound = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Noresultsfound") ;
            Combo_migrlegfamparen_Emptyitemtext = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Emptyitemtext") ;
            Combo_migrlegfamparen_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Onlyselectedvalues") ;
            Combo_migrlegfamparen_Selectalltext = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Selectalltext") ;
            Combo_migrlegfamparen_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Multiplevaluesseparator") ;
            Combo_migrlegfamparen_Addnewoptiontext = httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Addnewoptiontext") ;
            Combo_migrlegfamparen_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MIGRLEGFAMPAREN_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
            A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
            A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
            A2079MigrLegFamParen = httpContext.cgiGet( edtMigrLegFamParen_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2079MigrLegFamParen", A2079MigrLegFamParen);
            A2080MigrLegFamNroDoc = httpContext.cgiGet( edtMigrLegFamNroDoc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2080MigrLegFamNroDoc", A2080MigrLegFamNroDoc);
            A2088MigrLegFamNomApe = httpContext.cgiGet( edtMigrLegFamNomApe_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2088MigrLegFamNomApe", A2088MigrLegFamNomApe);
            if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFamFecNac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MIGRLEGFAMFECNAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFamFecNac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2089MigrLegFamFecNac = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A2089MigrLegFamFecNac", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
            }
            else
            {
               A2089MigrLegFamFecNac = localUtil.ctod( httpContext.cgiGet( edtMigrLegFamFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2089MigrLegFamFecNac", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGFAMDEDGAN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFamDedGan_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A2081MigrLegFamDedGan", GXutil.ltrimstr( A2081MigrLegFamDedGan, 6, 4));
            }
            else
            {
               A2081MigrLegFamDedGan = localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2081MigrLegFamDedGan", GXutil.ltrimstr( A2081MigrLegFamDedGan, 6, 4));
            }
            cmbMigrLegFamAdh.setValue( httpContext.cgiGet( cmbMigrLegFamAdh.getInternalname()) );
            A2082MigrLegFamAdh = httpContext.cgiGet( cmbMigrLegFamAdh.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
            cmbMigrLegFamDiscap.setValue( httpContext.cgiGet( cmbMigrLegFamDiscap.getInternalname()) );
            A2086MigrLegFamDiscap = httpContext.cgiGet( cmbMigrLegFamDiscap.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
            AV19ComboMigrLegFamParen = httpContext.cgiGet( edtavCombomigrlegfamparen_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboMigrLegFamParen", AV19ComboMigrLegFamParen);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A87MigrLegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            else
            {
               A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegFamSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegFamSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGFAMSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFamSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2078MigrLegFamSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
            }
            else
            {
               A2078MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrLegFamSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"importacion_legajoFamilia");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("importacion_legajofamilia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A87MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               A2078MigrLegFamSec = (short)(GXutil.lval( httpContext.GetPar( "MigrLegFamSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
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
                  sMode262 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode262 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound262 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_610( ) ;
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
                        e11612 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12612 ();
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
         e12612 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll61262( ) ;
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
         disableAttributes61262( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegfamparen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegfamparen_Enabled), 5, 0), true);
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

   public void confirm_610( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls61262( ) ;
         }
         else
         {
            checkExtendedTable61262( ) ;
            closeExtendedTableCursors61262( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption610( )
   {
   }

   public void e11612( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_char1[0] = AV25MigrLegFamAdh ;
      GXv_decimal2[0] = AV24MigrLegFamDedGan ;
      GXv_char3[0] = AV23MigrLegFamNroDoc ;
      GXv_char4[0] = AV22MigrLegFamParen ;
      GXv_char5[0] = AV30MigrLegFamDiscap ;
      GXv_date6[0] = AV33MigrLegFamFecNac ;
      GXv_char7[0] = "" ;
      new web.getmigrfamiliadatos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9MigrLegNumero, AV10MigrLegFamSec, GXv_char1, GXv_decimal2, GXv_char3, GXv_char4, GXv_char5, GXv_date6, GXv_char7) ;
      importacion_legajofamilia_impl.this.AV25MigrLegFamAdh = GXv_char1[0] ;
      importacion_legajofamilia_impl.this.AV24MigrLegFamDedGan = GXv_decimal2[0] ;
      importacion_legajofamilia_impl.this.AV23MigrLegFamNroDoc = GXv_char3[0] ;
      importacion_legajofamilia_impl.this.AV22MigrLegFamParen = GXv_char4[0] ;
      importacion_legajofamilia_impl.this.AV30MigrLegFamDiscap = GXv_char5[0] ;
      importacion_legajofamilia_impl.this.AV33MigrLegFamFecNac = GXv_date6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25MigrLegFamAdh", AV25MigrLegFamAdh);
      httpContext.ajax_rsp_assign_attri("", false, "AV24MigrLegFamDedGan", GXutil.ltrimstr( AV24MigrLegFamDedGan, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV23MigrLegFamNroDoc", AV23MigrLegFamNroDoc);
      httpContext.ajax_rsp_assign_attri("", false, "AV22MigrLegFamParen", AV22MigrLegFamParen);
      httpContext.ajax_rsp_assign_attri("", false, "AV30MigrLegFamDiscap", AV30MigrLegFamDiscap);
      httpContext.ajax_rsp_assign_attri("", false, "AV33MigrLegFamFecNac", localUtil.format(AV33MigrLegFamFecNac, "99/99/9999"));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext8[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext8) ;
      AV11WWPContext = GXv_SdtWWPContext8[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      edtMigrLegFamParen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamParen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamParen_Visible), 5, 0), true);
      AV19ComboMigrLegFamParen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboMigrLegFamParen", AV19ComboMigrLegFamParen);
      edtavCombomigrlegfamparen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegfamparen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegfamparen_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGFAMPAREN' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean11 = AV12IsAuthorized ;
         GXv_boolean12[0] = GXt_boolean11 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Insert", GXv_boolean12) ;
         importacion_legajofamilia_impl.this.GXt_boolean11 = GXv_boolean12[0] ;
         AV12IsAuthorized = GXt_boolean11 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean11 = AV12IsAuthorized ;
         GXv_boolean12[0] = GXt_boolean11 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Update", GXv_boolean12) ;
         importacion_legajofamilia_impl.this.GXt_boolean11 = GXv_boolean12[0] ;
         AV12IsAuthorized = GXt_boolean11 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean11 = AV12IsAuthorized ;
         GXv_boolean12[0] = GXt_boolean11 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Delete", GXv_boolean12) ;
         importacion_legajofamilia_impl.this.GXt_boolean11 = GXv_boolean12[0] ;
         AV12IsAuthorized = GXt_boolean11 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV34Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtMigrLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Visible), 5, 0), true);
      edtMigrLegFamSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGFAMADH' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMIGRLEGFAMDISCAP' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e12612( )
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

   public void S112( )
   {
      /* 'LOADCOMBOMIGRLEGFAMPAREN' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item13 = AV16MigrLegFamParen_Data ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item14[0] = GXt_objcol_SdtDVB_SDTComboData_Item13 ;
      new web.importacion_legajofamilialoaddvcombo(remoteHandle, context).execute( "MigrLegFamParen", Gx_mode, AV7CliCod, AV8EmpCod, AV9MigrLegNumero, AV10MigrLegFamSec, GXv_char7, GXv_objcol_SdtDVB_SDTComboData_Item14) ;
      importacion_legajofamilia_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item13 = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
      AV16MigrLegFamParen_Data = GXt_objcol_SdtDVB_SDTComboData_Item13 ;
      Combo_migrlegfamparen_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_migrlegfamparen.sendProperty(context, "", false, Combo_migrlegfamparen_Internalname, "SelectedValue_set", Combo_migrlegfamparen_Selectedvalue_set);
      AV19ComboMigrLegFamParen = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboMigrLegFamParen", AV19ComboMigrLegFamParen);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_migrlegfamparen_Enabled = false ;
         ucCombo_migrlegfamparen.sendProperty(context, "", false, Combo_migrlegfamparen_Internalname, "Enabled", GXutil.booltostr( Combo_migrlegfamparen_Enabled));
      }
      GXv_boolean12[0] = false ;
      GXv_char7[0] = AV26valorFiltro ;
      GXv_boolean15[0] = AV27existe ;
      GXv_boolean16[0] = false ;
      GXv_boolean17[0] = false ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9MigrLegNumero, httpContext.getMessage( "Parentesco", ""), "", AV22MigrLegFamParen, GXv_boolean12, GXv_char7, GXv_boolean15, GXv_boolean16, GXv_boolean17) ;
      importacion_legajofamilia_impl.this.AV26valorFiltro = GXv_char7[0] ;
      importacion_legajofamilia_impl.this.AV27existe = GXv_boolean15[0] ;
      if ( ! AV27existe && ! (GXutil.strcmp("", AV26valorFiltro)==0) )
      {
         GXt_char18 = "" ;
         GXv_char7[0] = GXt_char18 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Parentesco", ""), AV26valorFiltro, false, GXv_char7) ;
         importacion_legajofamilia_impl.this.GXt_char18 = GXv_char7[0] ;
         lblMigrlegfamparen_righttext_Caption = GXt_char18 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamparen_righttext_Internalname, "Caption", lblMigrlegfamparen_righttext_Caption, true);
         lblTextblockmigrlegfamparen_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegfamparen_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegfamparen_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegfamparen_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamparen_righttext_Internalname, "Caption", lblMigrlegfamparen_righttext_Caption, true);
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOMIGRLEGFAMDISCAP' Routine */
      returnInSub = false ;
      cmbMigrLegFamDiscap.removeAllItems();
      cmbMigrLegFamDiscap.addItem(httpContext.getMessage( "SI", ""), httpContext.getMessage( "SI", ""), (short)(0));
      cmbMigrLegFamDiscap.addItem(httpContext.getMessage( "NO", ""), httpContext.getMessage( "NO", ""), (short)(0));
      cmbMigrLegFamDiscap.addItem(AV25MigrLegFamAdh, AV25MigrLegFamAdh, (short)(0));
      GXv_boolean17[0] = false ;
      GXv_char7[0] = AV26valorFiltro ;
      GXv_boolean16[0] = AV27existe ;
      GXv_boolean15[0] = false ;
      GXv_boolean12[0] = false ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9MigrLegNumero, httpContext.getMessage( "Discapacitado", ""), "", AV30MigrLegFamDiscap, GXv_boolean17, GXv_char7, GXv_boolean16, GXv_boolean15, GXv_boolean12) ;
      importacion_legajofamilia_impl.this.AV26valorFiltro = GXv_char7[0] ;
      importacion_legajofamilia_impl.this.AV27existe = GXv_boolean16[0] ;
      if ( ! AV27existe && ! (GXutil.strcmp("", AV26valorFiltro)==0) )
      {
         GXt_char18 = "" ;
         GXv_char7[0] = GXt_char18 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Discapacitado", ""), AV26valorFiltro, false, GXv_char7) ;
         importacion_legajofamilia_impl.this.GXt_char18 = GXv_char7[0] ;
         lblMigrlegfamdiscap_righttext_Caption = GXt_char18 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamdiscap_righttext_Internalname, "Caption", lblMigrlegfamdiscap_righttext_Caption, true);
         lblTextblockmigrlegfamdiscap_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegfamdiscap_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegfamdiscap_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegfamdiscap_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamdiscap_righttext_Internalname, "Caption", lblMigrlegfamdiscap_righttext_Caption, true);
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOMIGRLEGFAMADH' Routine */
      returnInSub = false ;
      cmbMigrLegFamAdh.removeAllItems();
      cmbMigrLegFamAdh.addItem(httpContext.getMessage( "SI", ""), httpContext.getMessage( "SI", ""), (short)(0));
      cmbMigrLegFamAdh.addItem(httpContext.getMessage( "NO", ""), httpContext.getMessage( "NO", ""), (short)(0));
      cmbMigrLegFamAdh.addItem(AV25MigrLegFamAdh, AV25MigrLegFamAdh, (short)(0));
      GXv_boolean17[0] = false ;
      GXv_char7[0] = AV26valorFiltro ;
      GXv_boolean16[0] = AV27existe ;
      GXv_boolean15[0] = false ;
      GXv_boolean12[0] = false ;
      new web.migrgetpropiedades(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9MigrLegNumero, httpContext.getMessage( "Adherente", ""), "", AV25MigrLegFamAdh, GXv_boolean17, GXv_char7, GXv_boolean16, GXv_boolean15, GXv_boolean12) ;
      importacion_legajofamilia_impl.this.AV26valorFiltro = GXv_char7[0] ;
      importacion_legajofamilia_impl.this.AV27existe = GXv_boolean16[0] ;
      if ( ! AV27existe && ! (GXutil.strcmp("", AV26valorFiltro)==0) )
      {
         GXt_char18 = "" ;
         GXv_char7[0] = GXt_char18 ;
         new web.mensajeseleccionaropcionmigr(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "Adherente", ""), AV26valorFiltro, false, GXv_char7) ;
         importacion_legajofamilia_impl.this.GXt_char18 = GXv_char7[0] ;
         lblMigrlegfamadh_righttext_Caption = GXt_char18 ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamadh_righttext_Internalname, "Caption", lblMigrlegfamadh_righttext_Caption, true);
         lblTextblockmigrlegfamadh_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockmigrlegfamadh_Internalname, "Fontbold", GXutil.str( lblTextblockmigrlegfamadh_Fontbold, 1, 0), true);
      }
      else
      {
         lblMigrlegfamadh_righttext_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMigrlegfamadh_righttext_Internalname, "Caption", lblMigrlegfamadh_righttext_Caption, true);
      }
   }

   public void zm61262( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2079MigrLegFamParen = T00613_A2079MigrLegFamParen[0] ;
            Z2086MigrLegFamDiscap = T00613_A2086MigrLegFamDiscap[0] ;
            Z2080MigrLegFamNroDoc = T00613_A2080MigrLegFamNroDoc[0] ;
            Z2081MigrLegFamDedGan = T00613_A2081MigrLegFamDedGan[0] ;
            Z2082MigrLegFamAdh = T00613_A2082MigrLegFamAdh[0] ;
            Z2088MigrLegFamNomApe = T00613_A2088MigrLegFamNomApe[0] ;
            Z2089MigrLegFamFecNac = T00613_A2089MigrLegFamFecNac[0] ;
         }
         else
         {
            Z2079MigrLegFamParen = A2079MigrLegFamParen ;
            Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
            Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
            Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
            Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
            Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
            Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2084MigrLegFamErrores = A2084MigrLegFamErrores ;
         Z2085MigrLegFamWarnings = A2085MigrLegFamWarnings ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
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
            GXt_int19 = A3CliCod ;
            GXv_int20[0] = GXt_int19 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int20) ;
            importacion_legajofamilia_impl.this.GXt_int19 = GXv_int20[0] ;
            A3CliCod = GXt_int19 ;
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
      if ( ! (0==AV9MigrLegNumero) )
      {
         A87MigrLegNumero = AV9MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      if ( ! (0==AV9MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10MigrLegFamSec) )
      {
         A2078MigrLegFamSec = AV10MigrLegFamSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
      }
      if ( ! (0==AV10MigrLegFamSec) )
      {
         edtMigrLegFamSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegFamSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10MigrLegFamSec) )
      {
         edtMigrLegFamSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      A2079MigrLegFamParen = AV19ComboMigrLegFamParen ;
      httpContext.ajax_rsp_assign_attri("", false, "A2079MigrLegFamParen", A2079MigrLegFamParen);
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
         AV34Pgmname = "importacion_legajoFamilia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34Pgmname", AV34Pgmname);
         /* Using cursor T00614 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         A592MigrLegApellido = T00614_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00614_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A597MigrLegCUIL = T00614_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         pr_default.close(2);
      }
   }

   public void load61262( )
   {
      /* Using cursor T00615 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2079MigrLegFamParen = T00615_A2079MigrLegFamParen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2079MigrLegFamParen", A2079MigrLegFamParen);
         A2086MigrLegFamDiscap = T00615_A2086MigrLegFamDiscap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
         A2080MigrLegFamNroDoc = T00615_A2080MigrLegFamNroDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2080MigrLegFamNroDoc", A2080MigrLegFamNroDoc);
         A2081MigrLegFamDedGan = T00615_A2081MigrLegFamDedGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2081MigrLegFamDedGan", GXutil.ltrimstr( A2081MigrLegFamDedGan, 6, 4));
         A2082MigrLegFamAdh = T00615_A2082MigrLegFamAdh[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
         A2084MigrLegFamErrores = T00615_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = T00615_A2085MigrLegFamWarnings[0] ;
         A592MigrLegApellido = T00615_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00615_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A597MigrLegCUIL = T00615_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A2088MigrLegFamNomApe = T00615_A2088MigrLegFamNomApe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2088MigrLegFamNomApe", A2088MigrLegFamNomApe);
         A2089MigrLegFamFecNac = T00615_A2089MigrLegFamFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2089MigrLegFamFecNac", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
         zm61262( -14) ;
      }
      pr_default.close(3);
      onLoadActions61262( ) ;
   }

   public void onLoadActions61262( )
   {
      AV34Pgmname = "importacion_legajoFamilia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34Pgmname", AV34Pgmname);
   }

   public void checkExtendedTable61262( )
   {
      nIsDirty_262 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV34Pgmname = "importacion_legajoFamilia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34Pgmname", AV34Pgmname);
      /* Using cursor T00614 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A592MigrLegApellido = T00614_A592MigrLegApellido[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      A593MigrLegNombre = T00614_A593MigrLegNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      A597MigrLegCUIL = T00614_A597MigrLegCUIL[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
      pr_default.close(2);
   }

   public void closeExtendedTableCursors61262( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( int A3CliCod ,
                          short A1EmpCod ,
                          int A87MigrLegNumero )
   {
      /* Using cursor T00616 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A592MigrLegApellido = T00616_A592MigrLegApellido[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      A593MigrLegNombre = T00616_A593MigrLegNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      A597MigrLegCUIL = T00616_A597MigrLegCUIL[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A592MigrLegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A593MigrLegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A597MigrLegCUIL))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey61262( )
   {
      /* Using cursor T00617 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound262 = (short)(1) ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00613 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm61262( 14) ;
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = T00613_A2078MigrLegFamSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
         A2079MigrLegFamParen = T00613_A2079MigrLegFamParen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2079MigrLegFamParen", A2079MigrLegFamParen);
         A2086MigrLegFamDiscap = T00613_A2086MigrLegFamDiscap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
         A2080MigrLegFamNroDoc = T00613_A2080MigrLegFamNroDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2080MigrLegFamNroDoc", A2080MigrLegFamNroDoc);
         A2081MigrLegFamDedGan = T00613_A2081MigrLegFamDedGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2081MigrLegFamDedGan", GXutil.ltrimstr( A2081MigrLegFamDedGan, 6, 4));
         A2082MigrLegFamAdh = T00613_A2082MigrLegFamAdh[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
         A2084MigrLegFamErrores = T00613_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = T00613_A2085MigrLegFamWarnings[0] ;
         A2088MigrLegFamNomApe = T00613_A2088MigrLegFamNomApe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2088MigrLegFamNomApe", A2088MigrLegFamNomApe);
         A2089MigrLegFamFecNac = T00613_A2089MigrLegFamFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2089MigrLegFamFecNac", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
         A3CliCod = T00613_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00613_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T00613_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load61262( ) ;
         if ( AnyError == 1 )
         {
            RcdFound262 = (short)(0) ;
            initializeNonKey61262( ) ;
         }
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound262 = (short)(0) ;
         initializeNonKey61262( ) ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey61262( ) ;
      if ( RcdFound262 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound262 = (short)(0) ;
      /* Using cursor T00618 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00618_A3CliCod[0] < A3CliCod ) || ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A1EmpCod[0] < A1EmpCod ) || ( T00618_A1EmpCod[0] == A1EmpCod ) && ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A87MigrLegNumero[0] < A87MigrLegNumero ) || ( T00618_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( T00618_A1EmpCod[0] == A1EmpCod ) && ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A2078MigrLegFamSec[0] < A2078MigrLegFamSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00618_A3CliCod[0] > A3CliCod ) || ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A1EmpCod[0] > A1EmpCod ) || ( T00618_A1EmpCod[0] == A1EmpCod ) && ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A87MigrLegNumero[0] > A87MigrLegNumero ) || ( T00618_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( T00618_A1EmpCod[0] == A1EmpCod ) && ( T00618_A3CliCod[0] == A3CliCod ) && ( T00618_A2078MigrLegFamSec[0] > A2078MigrLegFamSec ) ) )
         {
            A3CliCod = T00618_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00618_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T00618_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            A2078MigrLegFamSec = T00618_A2078MigrLegFamSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
            RcdFound262 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound262 = (short)(0) ;
      /* Using cursor T00619 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00619_A3CliCod[0] > A3CliCod ) || ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A1EmpCod[0] > A1EmpCod ) || ( T00619_A1EmpCod[0] == A1EmpCod ) && ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A87MigrLegNumero[0] > A87MigrLegNumero ) || ( T00619_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( T00619_A1EmpCod[0] == A1EmpCod ) && ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A2078MigrLegFamSec[0] > A2078MigrLegFamSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00619_A3CliCod[0] < A3CliCod ) || ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A1EmpCod[0] < A1EmpCod ) || ( T00619_A1EmpCod[0] == A1EmpCod ) && ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A87MigrLegNumero[0] < A87MigrLegNumero ) || ( T00619_A87MigrLegNumero[0] == A87MigrLegNumero ) && ( T00619_A1EmpCod[0] == A1EmpCod ) && ( T00619_A3CliCod[0] == A3CliCod ) && ( T00619_A2078MigrLegFamSec[0] < A2078MigrLegFamSec ) ) )
         {
            A3CliCod = T00619_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00619_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T00619_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            A2078MigrLegFamSec = T00619_A2078MigrLegFamSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
            RcdFound262 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey61262( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMigrLegFamParen_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert61262( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound262 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A87MigrLegNumero = Z87MigrLegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               A2078MigrLegFamSec = Z2078MigrLegFamSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMigrLegFamParen_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update61262( ) ;
               GX_FocusControl = edtMigrLegFamParen_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtMigrLegFamParen_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert61262( ) ;
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
                  GX_FocusControl = edtMigrLegFamParen_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert61262( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = Z87MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         A2078MigrLegFamSec = Z2078MigrLegFamSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMigrLegFamParen_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency61262( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00612 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2079MigrLegFamParen, T00612_A2079MigrLegFamParen[0]) != 0 ) || ( GXutil.strcmp(Z2086MigrLegFamDiscap, T00612_A2086MigrLegFamDiscap[0]) != 0 ) || ( GXutil.strcmp(Z2080MigrLegFamNroDoc, T00612_A2080MigrLegFamNroDoc[0]) != 0 ) || ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, T00612_A2081MigrLegFamDedGan[0]) != 0 ) || ( GXutil.strcmp(Z2082MigrLegFamAdh, T00612_A2082MigrLegFamAdh[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2088MigrLegFamNomApe, T00612_A2088MigrLegFamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(T00612_A2089MigrLegFamFecNac[0])) ) )
         {
            if ( GXutil.strcmp(Z2079MigrLegFamParen, T00612_A2079MigrLegFamParen[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamParen");
               GXutil.writeLogRaw("Old: ",Z2079MigrLegFamParen);
               GXutil.writeLogRaw("Current: ",T00612_A2079MigrLegFamParen[0]);
            }
            if ( GXutil.strcmp(Z2086MigrLegFamDiscap, T00612_A2086MigrLegFamDiscap[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamDiscap");
               GXutil.writeLogRaw("Old: ",Z2086MigrLegFamDiscap);
               GXutil.writeLogRaw("Current: ",T00612_A2086MigrLegFamDiscap[0]);
            }
            if ( GXutil.strcmp(Z2080MigrLegFamNroDoc, T00612_A2080MigrLegFamNroDoc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamNroDoc");
               GXutil.writeLogRaw("Old: ",Z2080MigrLegFamNroDoc);
               GXutil.writeLogRaw("Current: ",T00612_A2080MigrLegFamNroDoc[0]);
            }
            if ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, T00612_A2081MigrLegFamDedGan[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamDedGan");
               GXutil.writeLogRaw("Old: ",Z2081MigrLegFamDedGan);
               GXutil.writeLogRaw("Current: ",T00612_A2081MigrLegFamDedGan[0]);
            }
            if ( GXutil.strcmp(Z2082MigrLegFamAdh, T00612_A2082MigrLegFamAdh[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamAdh");
               GXutil.writeLogRaw("Old: ",Z2082MigrLegFamAdh);
               GXutil.writeLogRaw("Current: ",T00612_A2082MigrLegFamAdh[0]);
            }
            if ( GXutil.strcmp(Z2088MigrLegFamNomApe, T00612_A2088MigrLegFamNomApe[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamNomApe");
               GXutil.writeLogRaw("Old: ",Z2088MigrLegFamNomApe);
               GXutil.writeLogRaw("Current: ",T00612_A2088MigrLegFamNomApe[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(T00612_A2089MigrLegFamFecNac[0])) ) )
            {
               GXutil.writeLogln("importacion_legajofamilia:[seudo value changed for attri]"+"MigrLegFamFecNac");
               GXutil.writeLogRaw("Old: ",Z2089MigrLegFamFecNac);
               GXutil.writeLogRaw("Current: ",T00612_A2089MigrLegFamFecNac[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert61262( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable61262( ) ;
      }
      if ( AnyError == 0 )
      {
         zm61262( 0) ;
         checkOptimisticConcurrency61262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm61262( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert61262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006110 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A2078MigrLegFamSec), A2079MigrLegFamParen, A2086MigrLegFamDiscap, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2084MigrLegFamErrores, A2085MigrLegFamWarnings, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
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
                        resetCaption610( ) ;
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
            load61262( ) ;
         }
         endLevel61262( ) ;
      }
      closeExtendedTableCursors61262( ) ;
   }

   public void update61262( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable61262( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency61262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm61262( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate61262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006111 */
                  pr_default.execute(9, new Object[] {A2079MigrLegFamParen, A2086MigrLegFamDiscap, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2084MigrLegFamErrores, A2085MigrLegFamWarnings, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate61262( ) ;
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
         endLevel61262( ) ;
      }
      closeExtendedTableCursors61262( ) ;
   }

   public void deferredUpdate61262( )
   {
   }

   public void delete( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency61262( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls61262( ) ;
         afterConfirm61262( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete61262( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006112 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
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
      sMode262 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel61262( ) ;
      Gx_mode = sMode262 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls61262( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV34Pgmname = "importacion_legajoFamilia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34Pgmname", AV34Pgmname);
         /* Using cursor T006113 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         A592MigrLegApellido = T006113_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T006113_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A597MigrLegCUIL = T006113_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         pr_default.close(11);
      }
   }

   public void endLevel61262( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete61262( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importacion_legajofamilia");
         if ( AnyError == 0 )
         {
            confirmValues610( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_legajofamilia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart61262( )
   {
      /* Scan By routine */
      /* Using cursor T006114 */
      pr_default.execute(12);
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A3CliCod = T006114_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006114_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T006114_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         A2078MigrLegFamSec = T006114_A2078MigrLegFamSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext61262( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A3CliCod = T006114_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006114_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T006114_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         A2078MigrLegFamSec = T006114_A2078MigrLegFamSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
      }
   }

   public void scanEnd61262( )
   {
      pr_default.close(12);
   }

   public void afterConfirm61262( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert61262( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate61262( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete61262( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete61262( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate61262( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes61262( )
   {
      edtMigrLegApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegApellido_Enabled), 5, 0), true);
      edtMigrLegNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNombre_Enabled), 5, 0), true);
      edtMigrLegCUIL_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCUIL_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCUIL_Enabled), 5, 0), true);
      edtMigrLegFamParen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamParen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamParen_Enabled), 5, 0), true);
      edtMigrLegFamNroDoc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNroDoc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNroDoc_Enabled), 5, 0), true);
      edtMigrLegFamNomApe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNomApe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNomApe_Enabled), 5, 0), true);
      edtMigrLegFamFecNac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamFecNac_Enabled), 5, 0), true);
      edtMigrLegFamDedGan_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamDedGan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamDedGan_Enabled), 5, 0), true);
      cmbMigrLegFamAdh.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamAdh.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegFamAdh.getEnabled(), 5, 0), true);
      cmbMigrLegFamDiscap.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegFamDiscap.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegFamDiscap.getEnabled(), 5, 0), true);
      edtavCombomigrlegfamparen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomigrlegfamparen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomigrlegfamparen_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtMigrLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      edtMigrLegFamSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes61262( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues610( )
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_legajofamilia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9MigrLegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10MigrLegFamSec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero","MigrLegFamSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"importacion_legajoFamilia");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("importacion_legajofamilia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z87MigrLegNumero", GXutil.ltrim( localUtil.ntoc( Z87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2078MigrLegFamSec", GXutil.ltrim( localUtil.ntoc( Z2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2079MigrLegFamParen", Z2079MigrLegFamParen);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2086MigrLegFamDiscap", GXutil.rtrim( Z2086MigrLegFamDiscap));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2080MigrLegFamNroDoc", Z2080MigrLegFamNroDoc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2081MigrLegFamDedGan", GXutil.ltrim( localUtil.ntoc( Z2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2082MigrLegFamAdh", GXutil.rtrim( Z2082MigrLegFamAdh));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2088MigrLegFamNomApe", Z2088MigrLegFamNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2089MigrLegFamFecNac", localUtil.dtoc( Z2089MigrLegFamFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGFAMPAREN_DATA", AV16MigrLegFamParen_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGFAMPAREN_DATA", AV16MigrLegFamParen_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MigrLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGFAMSEC", GXutil.ltrim( localUtil.ntoc( AV10MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGFAMSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10MigrLegFamSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMERRORES", A2084MigrLegFamErrores);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMWARNINGS", A2085MigrLegFamWarnings);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV34Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGFAMPAREN_Objectcall", GXutil.rtrim( Combo_migrlegfamparen_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGFAMPAREN_Cls", GXutil.rtrim( Combo_migrlegfamparen_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGFAMPAREN_Selectedvalue_set", GXutil.rtrim( Combo_migrlegfamparen_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGFAMPAREN_Enabled", GXutil.booltostr( Combo_migrlegfamparen_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MIGRLEGFAMPAREN_Emptyitem", GXutil.booltostr( Combo_migrlegfamparen_Emptyitem));
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
      return formatLink("web.importacion_legajofamilia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9MigrLegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10MigrLegFamSec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero","MigrLegFamSec"})  ;
   }

   public String getPgmname( )
   {
      return "importacion_legajoFamilia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "importacion_legajo Familia", "") ;
   }

   public void initializeNonKey61262( )
   {
      A2079MigrLegFamParen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2079MigrLegFamParen", A2079MigrLegFamParen);
      A2086MigrLegFamDiscap = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
      A2080MigrLegFamNroDoc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2080MigrLegFamNroDoc", A2080MigrLegFamNroDoc);
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2081MigrLegFamDedGan", GXutil.ltrimstr( A2081MigrLegFamDedGan, 6, 4));
      A2082MigrLegFamAdh = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
      A2084MigrLegFamErrores = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2084MigrLegFamErrores", A2084MigrLegFamErrores);
      A2085MigrLegFamWarnings = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2085MigrLegFamWarnings", A2085MigrLegFamWarnings);
      A592MigrLegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      A593MigrLegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      A597MigrLegCUIL = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
      A2088MigrLegFamNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2088MigrLegFamNomApe", A2088MigrLegFamNomApe);
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2089MigrLegFamFecNac", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
      Z2079MigrLegFamParen = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
   }

   public void initAll61262( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A87MigrLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      A2078MigrLegFamSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2078MigrLegFamSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2078MigrLegFamSec), 4, 0));
      initializeNonKey61262( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025131655113", true, true);
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
      httpContext.AddJavascriptSource("importacion_legajofamilia.js", "?2025131655114", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO" ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE" ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      lblTextblockmigrlegfamparen_Internalname = "TEXTBLOCKMIGRLEGFAMPAREN" ;
      Combo_migrlegfamparen_Internalname = "COMBO_MIGRLEGFAMPAREN" ;
      edtMigrLegFamParen_Internalname = "MIGRLEGFAMPAREN" ;
      lblMigrlegfamparen_righttext_Internalname = "MIGRLEGFAMPAREN_RIGHTTEXT" ;
      tblTablemergedmigrlegfamparen_Internalname = "TABLEMERGEDMIGRLEGFAMPAREN" ;
      divTablesplittedmigrlegfamparen_Internalname = "TABLESPLITTEDMIGRLEGFAMPAREN" ;
      edtMigrLegFamNroDoc_Internalname = "MIGRLEGFAMNRODOC" ;
      edtMigrLegFamNomApe_Internalname = "MIGRLEGFAMNOMAPE" ;
      edtMigrLegFamFecNac_Internalname = "MIGRLEGFAMFECNAC" ;
      edtMigrLegFamDedGan_Internalname = "MIGRLEGFAMDEDGAN" ;
      lblTextblockmigrlegfamadh_Internalname = "TEXTBLOCKMIGRLEGFAMADH" ;
      cmbMigrLegFamAdh.setInternalname( "MIGRLEGFAMADH" );
      lblMigrlegfamadh_righttext_Internalname = "MIGRLEGFAMADH_RIGHTTEXT" ;
      tblTablemergedmigrlegfamadh_Internalname = "TABLEMERGEDMIGRLEGFAMADH" ;
      divTablesplittedmigrlegfamadh_Internalname = "TABLESPLITTEDMIGRLEGFAMADH" ;
      lblTextblockmigrlegfamdiscap_Internalname = "TEXTBLOCKMIGRLEGFAMDISCAP" ;
      cmbMigrLegFamDiscap.setInternalname( "MIGRLEGFAMDISCAP" );
      lblMigrlegfamdiscap_righttext_Internalname = "MIGRLEGFAMDISCAP_RIGHTTEXT" ;
      tblTablemergedmigrlegfamdiscap_Internalname = "TABLEMERGEDMIGRLEGFAMDISCAP" ;
      divTablesplittedmigrlegfamdiscap_Internalname = "TABLESPLITTEDMIGRLEGFAMDISCAP" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombomigrlegfamparen_Internalname = "vCOMBOMIGRLEGFAMPAREN" ;
      divSectionattribute_migrlegfamparen_Internalname = "SECTIONATTRIBUTE_MIGRLEGFAMPAREN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO" ;
      edtMigrLegFamSec_Internalname = "MIGRLEGFAMSEC" ;
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
      Form.setCaption( httpContext.getMessage( "importacion_legajo Familia", "") );
      edtMigrLegFamSec_Jsonclick = "" ;
      edtMigrLegFamSec_Enabled = 1 ;
      edtMigrLegFamSec_Visible = 1 ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtMigrLegNumero_Enabled = 1 ;
      edtMigrLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombomigrlegfamparen_Jsonclick = "" ;
      edtavCombomigrlegfamparen_Enabled = 0 ;
      edtavCombomigrlegfamparen_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      lblMigrlegfamdiscap_righttext_Caption = httpContext.getMessage( "right text", "") ;
      cmbMigrLegFamDiscap.setJsonclick( "" );
      cmbMigrLegFamDiscap.setEnabled( 1 );
      lblTextblockmigrlegfamdiscap_Fontbold = (byte)(0) ;
      lblMigrlegfamadh_righttext_Caption = httpContext.getMessage( "right text", "") ;
      cmbMigrLegFamAdh.setJsonclick( "" );
      cmbMigrLegFamAdh.setEnabled( 1 );
      lblTextblockmigrlegfamadh_Fontbold = (byte)(0) ;
      edtMigrLegFamDedGan_Jsonclick = "" ;
      edtMigrLegFamDedGan_Enabled = 1 ;
      edtMigrLegFamFecNac_Jsonclick = "" ;
      edtMigrLegFamFecNac_Enabled = 1 ;
      edtMigrLegFamNomApe_Jsonclick = "" ;
      edtMigrLegFamNomApe_Enabled = 1 ;
      edtMigrLegFamNroDoc_Jsonclick = "" ;
      edtMigrLegFamNroDoc_Enabled = 1 ;
      lblMigrlegfamparen_righttext_Caption = httpContext.getMessage( "right text", "") ;
      edtMigrLegFamParen_Jsonclick = "" ;
      edtMigrLegFamParen_Enabled = 1 ;
      edtMigrLegFamParen_Visible = 1 ;
      Combo_migrlegfamparen_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_migrlegfamparen_Cls = "ExtendedCombo Attribute" ;
      Combo_migrlegfamparen_Caption = "" ;
      Combo_migrlegfamparen_Enabled = GXutil.toBoolean( -1) ;
      lblTextblockmigrlegfamparen_Fontbold = (byte)(0) ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Datos de Familiar", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      edtMigrLegCUIL_Jsonclick = "" ;
      edtMigrLegCUIL_Enabled = 0 ;
      edtMigrLegNombre_Enabled = 0 ;
      edtMigrLegApellido_Enabled = 0 ;
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

   public void gx1asaclicod61262( int AV7CliCod )
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
            GXt_int19 = A3CliCod ;
            GXv_int20[0] = GXt_int19 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int20) ;
            importacion_legajofamilia_impl.this.GXt_int19 = GXv_int20[0] ;
            A3CliCod = GXt_int19 ;
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
      cmbMigrLegFamAdh.setName( "MIGRLEGFAMADH" );
      cmbMigrLegFamAdh.setWebtags( "" );
      if ( cmbMigrLegFamAdh.getItemCount() > 0 )
      {
         A2082MigrLegFamAdh = cmbMigrLegFamAdh.getValidValue(A2082MigrLegFamAdh) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2082MigrLegFamAdh", A2082MigrLegFamAdh);
      }
      cmbMigrLegFamDiscap.setName( "MIGRLEGFAMDISCAP" );
      cmbMigrLegFamDiscap.setWebtags( "" );
      if ( cmbMigrLegFamDiscap.getItemCount() > 0 )
      {
         A2086MigrLegFamDiscap = cmbMigrLegFamDiscap.getValidValue(A2086MigrLegFamDiscap) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2086MigrLegFamDiscap", A2086MigrLegFamDiscap);
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

   public void valid_Migrlegnumero( )
   {
      /* Using cursor T006113 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A592MigrLegApellido = T006113_A592MigrLegApellido[0] ;
      A593MigrLegNombre = T006113_A593MigrLegNombre[0] ;
      A597MigrLegCUIL = T006113_A597MigrLegCUIL[0] ;
      pr_default.close(11);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", GXutil.rtrim( A597MigrLegCUIL));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10MigrLegFamSec',fld:'vMIGRLEGFAMSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10MigrLegFamSec',fld:'vMIGRLEGFAMSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12612',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMIGRLEGFAMPAREN","{handler:'validv_Combomigrlegfamparen',iparms:[]");
      setEventMetadata("VALIDV_COMBOMIGRLEGFAMPAREN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNUMERO","{handler:'valid_Migrlegnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'A592MigrLegApellido',fld:'MIGRLEGAPELLIDO',pic:''},{av:'A593MigrLegNombre',fld:'MIGRLEGNOMBRE',pic:''},{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''}]");
      setEventMetadata("VALID_MIGRLEGNUMERO",",oparms:[{av:'A592MigrLegApellido',fld:'MIGRLEGAPELLIDO',pic:''},{av:'A593MigrLegNombre',fld:'MIGRLEGNOMBRE',pic:''},{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGFAMSEC","{handler:'valid_Migrlegfamsec',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFAMSEC",",oparms:[]}");
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
      pr_default.close(11);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z2079MigrLegFamParen = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
      Combo_migrlegfamparen_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      sStyleString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A597MigrLegCUIL = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockmigrlegfamparen_Jsonclick = "" ;
      ucCombo_migrlegfamparen = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16MigrLegFamParen_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A2079MigrLegFamParen = "" ;
      lblMigrlegfamparen_righttext_Jsonclick = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      lblTextblockmigrlegfamadh_Jsonclick = "" ;
      lblMigrlegfamadh_righttext_Jsonclick = "" ;
      lblTextblockmigrlegfamdiscap_Jsonclick = "" ;
      lblMigrlegfamdiscap_righttext_Jsonclick = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV19ComboMigrLegFamParen = "" ;
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      AV34Pgmname = "" ;
      Combo_migrlegfamparen_Objectcall = "" ;
      Combo_migrlegfamparen_Class = "" ;
      Combo_migrlegfamparen_Icontype = "" ;
      Combo_migrlegfamparen_Icon = "" ;
      Combo_migrlegfamparen_Tooltip = "" ;
      Combo_migrlegfamparen_Selectedvalue_set = "" ;
      Combo_migrlegfamparen_Selectedtext_set = "" ;
      Combo_migrlegfamparen_Selectedtext_get = "" ;
      Combo_migrlegfamparen_Gamoauthtoken = "" ;
      Combo_migrlegfamparen_Ddointernalname = "" ;
      Combo_migrlegfamparen_Titlecontrolalign = "" ;
      Combo_migrlegfamparen_Dropdownoptionstype = "" ;
      Combo_migrlegfamparen_Titlecontrolidtoreplace = "" ;
      Combo_migrlegfamparen_Datalisttype = "" ;
      Combo_migrlegfamparen_Datalistfixedvalues = "" ;
      Combo_migrlegfamparen_Datalistproc = "" ;
      Combo_migrlegfamparen_Datalistprocparametersprefix = "" ;
      Combo_migrlegfamparen_Remoteservicesparameters = "" ;
      Combo_migrlegfamparen_Htmltemplate = "" ;
      Combo_migrlegfamparen_Multiplevaluestype = "" ;
      Combo_migrlegfamparen_Loadingdata = "" ;
      Combo_migrlegfamparen_Noresultsfound = "" ;
      Combo_migrlegfamparen_Emptyitemtext = "" ;
      Combo_migrlegfamparen_Onlyselectedvalues = "" ;
      Combo_migrlegfamparen_Selectalltext = "" ;
      Combo_migrlegfamparen_Multiplevaluesseparator = "" ;
      Combo_migrlegfamparen_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode262 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV25MigrLegFamAdh = "" ;
      GXv_char1 = new String[1] ;
      AV24MigrLegFamDedGan = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV23MigrLegFamNroDoc = "" ;
      GXv_char3 = new String[1] ;
      AV22MigrLegFamParen = "" ;
      GXv_char4 = new String[1] ;
      AV30MigrLegFamDiscap = "" ;
      GXv_char5 = new String[1] ;
      AV33MigrLegFamFecNac = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext8 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      GXt_objcol_SdtDVB_SDTComboData_Item13 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV18ComboSelectedValue = "" ;
      GXv_objcol_SdtDVB_SDTComboData_Item14 = new GXBaseCollection[1] ;
      AV26valorFiltro = "" ;
      GXv_boolean17 = new boolean[1] ;
      GXv_boolean16 = new boolean[1] ;
      GXv_boolean15 = new boolean[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      Z2084MigrLegFamErrores = "" ;
      Z2085MigrLegFamWarnings = "" ;
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z597MigrLegCUIL = "" ;
      T00614_A592MigrLegApellido = new String[] {""} ;
      T00614_A593MigrLegNombre = new String[] {""} ;
      T00614_A597MigrLegCUIL = new String[] {""} ;
      T00615_A2078MigrLegFamSec = new short[1] ;
      T00615_A2079MigrLegFamParen = new String[] {""} ;
      T00615_A2086MigrLegFamDiscap = new String[] {""} ;
      T00615_A2080MigrLegFamNroDoc = new String[] {""} ;
      T00615_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00615_A2082MigrLegFamAdh = new String[] {""} ;
      T00615_A2084MigrLegFamErrores = new String[] {""} ;
      T00615_A2085MigrLegFamWarnings = new String[] {""} ;
      T00615_A592MigrLegApellido = new String[] {""} ;
      T00615_A593MigrLegNombre = new String[] {""} ;
      T00615_A597MigrLegCUIL = new String[] {""} ;
      T00615_A2088MigrLegFamNomApe = new String[] {""} ;
      T00615_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00615_A3CliCod = new int[1] ;
      T00615_A1EmpCod = new short[1] ;
      T00615_A87MigrLegNumero = new int[1] ;
      T00616_A592MigrLegApellido = new String[] {""} ;
      T00616_A593MigrLegNombre = new String[] {""} ;
      T00616_A597MigrLegCUIL = new String[] {""} ;
      T00617_A3CliCod = new int[1] ;
      T00617_A1EmpCod = new short[1] ;
      T00617_A87MigrLegNumero = new int[1] ;
      T00617_A2078MigrLegFamSec = new short[1] ;
      T00613_A2078MigrLegFamSec = new short[1] ;
      T00613_A2079MigrLegFamParen = new String[] {""} ;
      T00613_A2086MigrLegFamDiscap = new String[] {""} ;
      T00613_A2080MigrLegFamNroDoc = new String[] {""} ;
      T00613_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00613_A2082MigrLegFamAdh = new String[] {""} ;
      T00613_A2084MigrLegFamErrores = new String[] {""} ;
      T00613_A2085MigrLegFamWarnings = new String[] {""} ;
      T00613_A2088MigrLegFamNomApe = new String[] {""} ;
      T00613_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00613_A3CliCod = new int[1] ;
      T00613_A1EmpCod = new short[1] ;
      T00613_A87MigrLegNumero = new int[1] ;
      T00618_A3CliCod = new int[1] ;
      T00618_A1EmpCod = new short[1] ;
      T00618_A87MigrLegNumero = new int[1] ;
      T00618_A2078MigrLegFamSec = new short[1] ;
      T00619_A3CliCod = new int[1] ;
      T00619_A1EmpCod = new short[1] ;
      T00619_A87MigrLegNumero = new int[1] ;
      T00619_A2078MigrLegFamSec = new short[1] ;
      T00612_A2078MigrLegFamSec = new short[1] ;
      T00612_A2079MigrLegFamParen = new String[] {""} ;
      T00612_A2086MigrLegFamDiscap = new String[] {""} ;
      T00612_A2080MigrLegFamNroDoc = new String[] {""} ;
      T00612_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00612_A2082MigrLegFamAdh = new String[] {""} ;
      T00612_A2084MigrLegFamErrores = new String[] {""} ;
      T00612_A2085MigrLegFamWarnings = new String[] {""} ;
      T00612_A2088MigrLegFamNomApe = new String[] {""} ;
      T00612_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00612_A3CliCod = new int[1] ;
      T00612_A1EmpCod = new short[1] ;
      T00612_A87MigrLegNumero = new int[1] ;
      T006113_A592MigrLegApellido = new String[] {""} ;
      T006113_A593MigrLegNombre = new String[] {""} ;
      T006113_A597MigrLegCUIL = new String[] {""} ;
      T006114_A3CliCod = new int[1] ;
      T006114_A1EmpCod = new short[1] ;
      T006114_A87MigrLegNumero = new int[1] ;
      T006114_A2078MigrLegFamSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int20 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajofamilia__default(),
         new Object[] {
             new Object[] {
            T00612_A2078MigrLegFamSec, T00612_A2079MigrLegFamParen, T00612_A2086MigrLegFamDiscap, T00612_A2080MigrLegFamNroDoc, T00612_A2081MigrLegFamDedGan, T00612_A2082MigrLegFamAdh, T00612_A2084MigrLegFamErrores, T00612_A2085MigrLegFamWarnings, T00612_A2088MigrLegFamNomApe, T00612_A2089MigrLegFamFecNac,
            T00612_A3CliCod, T00612_A1EmpCod, T00612_A87MigrLegNumero
            }
            , new Object[] {
            T00613_A2078MigrLegFamSec, T00613_A2079MigrLegFamParen, T00613_A2086MigrLegFamDiscap, T00613_A2080MigrLegFamNroDoc, T00613_A2081MigrLegFamDedGan, T00613_A2082MigrLegFamAdh, T00613_A2084MigrLegFamErrores, T00613_A2085MigrLegFamWarnings, T00613_A2088MigrLegFamNomApe, T00613_A2089MigrLegFamFecNac,
            T00613_A3CliCod, T00613_A1EmpCod, T00613_A87MigrLegNumero
            }
            , new Object[] {
            T00614_A592MigrLegApellido, T00614_A593MigrLegNombre, T00614_A597MigrLegCUIL
            }
            , new Object[] {
            T00615_A2078MigrLegFamSec, T00615_A2079MigrLegFamParen, T00615_A2086MigrLegFamDiscap, T00615_A2080MigrLegFamNroDoc, T00615_A2081MigrLegFamDedGan, T00615_A2082MigrLegFamAdh, T00615_A2084MigrLegFamErrores, T00615_A2085MigrLegFamWarnings, T00615_A592MigrLegApellido, T00615_A593MigrLegNombre,
            T00615_A597MigrLegCUIL, T00615_A2088MigrLegFamNomApe, T00615_A2089MigrLegFamFecNac, T00615_A3CliCod, T00615_A1EmpCod, T00615_A87MigrLegNumero
            }
            , new Object[] {
            T00616_A592MigrLegApellido, T00616_A593MigrLegNombre, T00616_A597MigrLegCUIL
            }
            , new Object[] {
            T00617_A3CliCod, T00617_A1EmpCod, T00617_A87MigrLegNumero, T00617_A2078MigrLegFamSec
            }
            , new Object[] {
            T00618_A3CliCod, T00618_A1EmpCod, T00618_A87MigrLegNumero, T00618_A2078MigrLegFamSec
            }
            , new Object[] {
            T00619_A3CliCod, T00619_A1EmpCod, T00619_A87MigrLegNumero, T00619_A2078MigrLegFamSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006113_A592MigrLegApellido, T006113_A593MigrLegNombre, T006113_A597MigrLegCUIL
            }
            , new Object[] {
            T006114_A3CliCod, T006114_A1EmpCod, T006114_A87MigrLegNumero, T006114_A2078MigrLegFamSec
            }
         }
      );
      AV34Pgmname = "importacion_legajoFamilia" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte lblTextblockmigrlegfamparen_Fontbold ;
   private byte lblTextblockmigrlegfamadh_Fontbold ;
   private byte lblTextblockmigrlegfamdiscap_Fontbold ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV10MigrLegFamSec ;
   private short Z1EmpCod ;
   private short Z2078MigrLegFamSec ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV10MigrLegFamSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2078MigrLegFamSec ;
   private short RcdFound262 ;
   private short nIsDirty_262 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9MigrLegNumero ;
   private int Z3CliCod ;
   private int Z87MigrLegNumero ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int AV9MigrLegNumero ;
   private int trnEnded ;
   private int edtMigrLegApellido_Enabled ;
   private int edtMigrLegNombre_Enabled ;
   private int edtMigrLegCUIL_Enabled ;
   private int edtMigrLegFamParen_Visible ;
   private int edtMigrLegFamParen_Enabled ;
   private int edtMigrLegFamNroDoc_Enabled ;
   private int edtMigrLegFamNomApe_Enabled ;
   private int edtMigrLegFamFecNac_Enabled ;
   private int edtMigrLegFamDedGan_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombomigrlegfamparen_Visible ;
   private int edtavCombomigrlegfamparen_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtMigrLegNumero_Visible ;
   private int edtMigrLegNumero_Enabled ;
   private int edtMigrLegFamSec_Visible ;
   private int edtMigrLegFamSec_Enabled ;
   private int Combo_migrlegfamparen_Datalistupdateminimumcharacters ;
   private int Combo_migrlegfamparen_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int19 ;
   private int GXv_int20[] ;
   private java.math.BigDecimal Z2081MigrLegFamDedGan ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private java.math.BigDecimal AV24MigrLegFamDedGan ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2086MigrLegFamDiscap ;
   private String Z2082MigrLegFamAdh ;
   private String Combo_migrlegfamparen_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMigrLegFamParen_Internalname ;
   private String A2082MigrLegFamAdh ;
   private String A2086MigrLegFamDiscap ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String edtMigrLegApellido_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtMigrLegNombre_Internalname ;
   private String edtMigrLegCUIL_Internalname ;
   private String A597MigrLegCUIL ;
   private String edtMigrLegCUIL_Jsonclick ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String divTablesplittedmigrlegfamparen_Internalname ;
   private String lblTextblockmigrlegfamparen_Internalname ;
   private String lblTextblockmigrlegfamparen_Jsonclick ;
   private String tblTablemergedmigrlegfamparen_Internalname ;
   private String Combo_migrlegfamparen_Caption ;
   private String Combo_migrlegfamparen_Cls ;
   private String Combo_migrlegfamparen_Internalname ;
   private String TempTags ;
   private String edtMigrLegFamParen_Jsonclick ;
   private String lblMigrlegfamparen_righttext_Internalname ;
   private String lblMigrlegfamparen_righttext_Caption ;
   private String lblMigrlegfamparen_righttext_Jsonclick ;
   private String edtMigrLegFamNroDoc_Internalname ;
   private String edtMigrLegFamNroDoc_Jsonclick ;
   private String edtMigrLegFamNomApe_Internalname ;
   private String edtMigrLegFamNomApe_Jsonclick ;
   private String edtMigrLegFamFecNac_Internalname ;
   private String edtMigrLegFamFecNac_Jsonclick ;
   private String edtMigrLegFamDedGan_Internalname ;
   private String edtMigrLegFamDedGan_Jsonclick ;
   private String divTablesplittedmigrlegfamadh_Internalname ;
   private String lblTextblockmigrlegfamadh_Internalname ;
   private String lblTextblockmigrlegfamadh_Jsonclick ;
   private String tblTablemergedmigrlegfamadh_Internalname ;
   private String lblMigrlegfamadh_righttext_Internalname ;
   private String lblMigrlegfamadh_righttext_Caption ;
   private String lblMigrlegfamadh_righttext_Jsonclick ;
   private String divTablesplittedmigrlegfamdiscap_Internalname ;
   private String lblTextblockmigrlegfamdiscap_Internalname ;
   private String lblTextblockmigrlegfamdiscap_Jsonclick ;
   private String tblTablemergedmigrlegfamdiscap_Internalname ;
   private String lblMigrlegfamdiscap_righttext_Internalname ;
   private String lblMigrlegfamdiscap_righttext_Caption ;
   private String lblMigrlegfamdiscap_righttext_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_migrlegfamparen_Internalname ;
   private String edtavCombomigrlegfamparen_Internalname ;
   private String edtavCombomigrlegfamparen_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtMigrLegNumero_Internalname ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegFamSec_Internalname ;
   private String edtMigrLegFamSec_Jsonclick ;
   private String AV34Pgmname ;
   private String Combo_migrlegfamparen_Objectcall ;
   private String Combo_migrlegfamparen_Class ;
   private String Combo_migrlegfamparen_Icontype ;
   private String Combo_migrlegfamparen_Icon ;
   private String Combo_migrlegfamparen_Tooltip ;
   private String Combo_migrlegfamparen_Selectedvalue_set ;
   private String Combo_migrlegfamparen_Selectedtext_set ;
   private String Combo_migrlegfamparen_Selectedtext_get ;
   private String Combo_migrlegfamparen_Gamoauthtoken ;
   private String Combo_migrlegfamparen_Ddointernalname ;
   private String Combo_migrlegfamparen_Titlecontrolalign ;
   private String Combo_migrlegfamparen_Dropdownoptionstype ;
   private String Combo_migrlegfamparen_Titlecontrolidtoreplace ;
   private String Combo_migrlegfamparen_Datalisttype ;
   private String Combo_migrlegfamparen_Datalistfixedvalues ;
   private String Combo_migrlegfamparen_Datalistproc ;
   private String Combo_migrlegfamparen_Datalistprocparametersprefix ;
   private String Combo_migrlegfamparen_Remoteservicesparameters ;
   private String Combo_migrlegfamparen_Htmltemplate ;
   private String Combo_migrlegfamparen_Multiplevaluestype ;
   private String Combo_migrlegfamparen_Loadingdata ;
   private String Combo_migrlegfamparen_Noresultsfound ;
   private String Combo_migrlegfamparen_Emptyitemtext ;
   private String Combo_migrlegfamparen_Onlyselectedvalues ;
   private String Combo_migrlegfamparen_Selectalltext ;
   private String Combo_migrlegfamparen_Multiplevaluesseparator ;
   private String Combo_migrlegfamparen_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode262 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV25MigrLegFamAdh ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV30MigrLegFamDiscap ;
   private String GXv_char5[] ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String Z597MigrLegCUIL ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z2089MigrLegFamFecNac ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private java.util.Date AV33MigrLegFamFecNac ;
   private java.util.Date GXv_date6[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_migrlegfamparen_Emptyitem ;
   private boolean Combo_migrlegfamparen_Enabled ;
   private boolean Combo_migrlegfamparen_Visible ;
   private boolean Combo_migrlegfamparen_Allowmultipleselection ;
   private boolean Combo_migrlegfamparen_Isgriditem ;
   private boolean Combo_migrlegfamparen_Hasdescription ;
   private boolean Combo_migrlegfamparen_Includeonlyselectedoption ;
   private boolean Combo_migrlegfamparen_Includeselectalloption ;
   private boolean Combo_migrlegfamparen_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean11 ;
   private boolean AV27existe ;
   private boolean GXv_boolean17[] ;
   private boolean GXv_boolean16[] ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean12[] ;
   private boolean Gx_longc ;
   private String A2084MigrLegFamErrores ;
   private String A2085MigrLegFamWarnings ;
   private String Z2084MigrLegFamErrores ;
   private String Z2085MigrLegFamWarnings ;
   private String Z2079MigrLegFamParen ;
   private String Z2080MigrLegFamNroDoc ;
   private String Z2088MigrLegFamNomApe ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A2079MigrLegFamParen ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String AV19ComboMigrLegFamParen ;
   private String AV23MigrLegFamNroDoc ;
   private String AV22MigrLegFamParen ;
   private String AV18ComboSelectedValue ;
   private String AV26valorFiltro ;
   private String Z592MigrLegApellido ;
   private String Z593MigrLegNombre ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_migrlegfamparen ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbMigrLegFamAdh ;
   private HTMLChoice cmbMigrLegFamDiscap ;
   private IDataStoreProvider pr_default ;
   private String[] T00614_A592MigrLegApellido ;
   private String[] T00614_A593MigrLegNombre ;
   private String[] T00614_A597MigrLegCUIL ;
   private short[] T00615_A2078MigrLegFamSec ;
   private String[] T00615_A2079MigrLegFamParen ;
   private String[] T00615_A2086MigrLegFamDiscap ;
   private String[] T00615_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T00615_A2081MigrLegFamDedGan ;
   private String[] T00615_A2082MigrLegFamAdh ;
   private String[] T00615_A2084MigrLegFamErrores ;
   private String[] T00615_A2085MigrLegFamWarnings ;
   private String[] T00615_A592MigrLegApellido ;
   private String[] T00615_A593MigrLegNombre ;
   private String[] T00615_A597MigrLegCUIL ;
   private String[] T00615_A2088MigrLegFamNomApe ;
   private java.util.Date[] T00615_A2089MigrLegFamFecNac ;
   private int[] T00615_A3CliCod ;
   private short[] T00615_A1EmpCod ;
   private int[] T00615_A87MigrLegNumero ;
   private String[] T00616_A592MigrLegApellido ;
   private String[] T00616_A593MigrLegNombre ;
   private String[] T00616_A597MigrLegCUIL ;
   private int[] T00617_A3CliCod ;
   private short[] T00617_A1EmpCod ;
   private int[] T00617_A87MigrLegNumero ;
   private short[] T00617_A2078MigrLegFamSec ;
   private short[] T00613_A2078MigrLegFamSec ;
   private String[] T00613_A2079MigrLegFamParen ;
   private String[] T00613_A2086MigrLegFamDiscap ;
   private String[] T00613_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T00613_A2081MigrLegFamDedGan ;
   private String[] T00613_A2082MigrLegFamAdh ;
   private String[] T00613_A2084MigrLegFamErrores ;
   private String[] T00613_A2085MigrLegFamWarnings ;
   private String[] T00613_A2088MigrLegFamNomApe ;
   private java.util.Date[] T00613_A2089MigrLegFamFecNac ;
   private int[] T00613_A3CliCod ;
   private short[] T00613_A1EmpCod ;
   private int[] T00613_A87MigrLegNumero ;
   private int[] T00618_A3CliCod ;
   private short[] T00618_A1EmpCod ;
   private int[] T00618_A87MigrLegNumero ;
   private short[] T00618_A2078MigrLegFamSec ;
   private int[] T00619_A3CliCod ;
   private short[] T00619_A1EmpCod ;
   private int[] T00619_A87MigrLegNumero ;
   private short[] T00619_A2078MigrLegFamSec ;
   private short[] T00612_A2078MigrLegFamSec ;
   private String[] T00612_A2079MigrLegFamParen ;
   private String[] T00612_A2086MigrLegFamDiscap ;
   private String[] T00612_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T00612_A2081MigrLegFamDedGan ;
   private String[] T00612_A2082MigrLegFamAdh ;
   private String[] T00612_A2084MigrLegFamErrores ;
   private String[] T00612_A2085MigrLegFamWarnings ;
   private String[] T00612_A2088MigrLegFamNomApe ;
   private java.util.Date[] T00612_A2089MigrLegFamFecNac ;
   private int[] T00612_A3CliCod ;
   private short[] T00612_A1EmpCod ;
   private int[] T00612_A87MigrLegNumero ;
   private String[] T006113_A592MigrLegApellido ;
   private String[] T006113_A593MigrLegNombre ;
   private String[] T006113_A597MigrLegCUIL ;
   private int[] T006114_A3CliCod ;
   private short[] T006114_A1EmpCod ;
   private int[] T006114_A87MigrLegNumero ;
   private short[] T006114_A2078MigrLegFamSec ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16MigrLegFamParen_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item13 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item14[] ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext8[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[] ;
}

final  class importacion_legajofamilia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00612", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00613", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00614", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00615", "SELECT TM1.MigrLegFamSec, TM1.MigrLegFamParen, TM1.MigrLegFamDiscap, TM1.MigrLegFamNroDoc, TM1.MigrLegFamDedGan, TM1.MigrLegFamAdh, TM1.MigrLegFamErrores, TM1.MigrLegFamWarnings, T2.MigrLegApellido, T2.MigrLegNombre, T2.MigrLegCUIL, TM1.MigrLegFamNomApe, TM1.MigrLegFamFecNac, TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero FROM (importacion_legajoFamilia TM1 INNER JOIN importacion_legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.MigrLegNumero = TM1.MigrLegNumero) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? and TM1.MigrLegFamSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero, TM1.MigrLegFamSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00616", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00617", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00618", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and MigrLegNumero > ? or MigrLegNumero = ? and EmpCod = ? and CliCod = ? and MigrLegFamSec > ?) ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00619", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and MigrLegNumero < ? or MigrLegNumero = ? and EmpCod = ? and CliCod = ? and MigrLegFamSec < ?) ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC, MigrLegFamSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006110", "SAVEPOINT gxupdate;INSERT INTO importacion_legajoFamilia(MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006111", "SAVEPOINT gxupdate;UPDATE importacion_legajoFamilia SET MigrLegFamParen=?, MigrLegFamDiscap=?, MigrLegFamNroDoc=?, MigrLegFamDedGan=?, MigrLegFamAdh=?, MigrLegFamErrores=?, MigrLegFamWarnings=?, MigrLegFamNomApe=?, MigrLegFamFecNac=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006112", "SAVEPOINT gxupdate;DELETE FROM importacion_legajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006113", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006114", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 13);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
               stmt.setShort(10, ((Number) parms[9]).shortValue());
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
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

