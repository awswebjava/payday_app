package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientewwexport extends GXProcedure
{
   public clientewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientewwexport.class ), "" );
   }

   public clientewwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clientewwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      clientewwexport.this.aP0 = aP0;
      clientewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente", GXv_boolean2) ;
      clientewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV62Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "ClienteWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (0==AV35TFCliCod) && (0==AV36TFCliCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFCliCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFCliCod_To );
      }
      if ( ! ( ( AV39TFCliNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV63GXV1 = 1 ;
         while ( AV63GXV1 <= AV39TFCliNom_Sels.size() )
         {
            AV40TFCliNom_Sel = (String)AV39TFCliNom_Sels.elementAt(-1+AV63GXV1) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFCliNom_Sel, GXv_char7) ;
            clientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV63GXV1 = (int)(AV63GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFCliNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFCliNom, GXv_char7) ;
            clientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV42TFCliCUIT) && (0==AV58TFCliCUIT_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "CUIT", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV42TFCliCUIT );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV58TFCliCUIT_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV45TFCliFecAlta)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFCliFecAlta_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fec Alta", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV45TFCliFecAlta );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV46TFCliFecAlta_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( (0==AV47TFCliMultiEmp_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Multi Emp", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV47TFCliMultiEmp_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV47TFCliMultiEmp_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV48TFClientePadre) && (0==AV49TFClientePadre_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Padre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV48TFClientePadre );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV49TFClientePadre_To );
      }
      if ( ! ( (0==AV50TFCliPaiCod) && (0==AV51TFCliPaiCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pai Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV50TFCliPaiCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV51TFCliPaiCod_To );
      }
      if ( ! ( (0==AV52TFClienteSistema_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Sistema", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV52TFClienteSistema_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV52TFClienteSistema_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV53TFClienteConveniador_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Conveniador", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV53TFClienteConveniador_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV53TFClienteConveniador_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ClienteWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV64GXV2 = 1 ;
      while ( AV64GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV64GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV64GXV2 = (int)(AV64GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV66Clientewwds_1_tfclicod = AV35TFCliCod ;
      AV67Clientewwds_2_tfclicod_to = AV36TFCliCod_To ;
      AV68Clientewwds_3_tfclinom = AV38TFCliNom ;
      AV69Clientewwds_4_tfclinom_sels = AV39TFCliNom_Sels ;
      AV70Clientewwds_5_tfclicuit = AV42TFCliCUIT ;
      AV71Clientewwds_6_tfclicuit_to = AV58TFCliCUIT_To ;
      AV72Clientewwds_7_tfclifecalta = AV45TFCliFecAlta ;
      AV73Clientewwds_8_tfclifecalta_to = AV46TFCliFecAlta_To ;
      AV74Clientewwds_9_tfclimultiemp_sel = AV47TFCliMultiEmp_Sel ;
      AV75Clientewwds_10_tfclientepadre = AV48TFClientePadre ;
      AV76Clientewwds_11_tfclientepadre_to = AV49TFClientePadre_To ;
      AV77Clientewwds_12_tfclipaicod = AV50TFCliPaiCod ;
      AV78Clientewwds_13_tfclipaicod_to = AV51TFCliPaiCod_To ;
      AV79Clientewwds_14_tfclientesistema_sel = AV52TFClienteSistema_Sel ;
      AV80Clientewwds_15_tfclienteconveniador_sel = AV53TFClienteConveniador_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A344CliNom ,
                                           AV69Clientewwds_4_tfclinom_sels ,
                                           Integer.valueOf(AV66Clientewwds_1_tfclicod) ,
                                           Integer.valueOf(AV67Clientewwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV69Clientewwds_4_tfclinom_sels.size()) ,
                                           AV68Clientewwds_3_tfclinom ,
                                           Long.valueOf(AV70Clientewwds_5_tfclicuit) ,
                                           Long.valueOf(AV71Clientewwds_6_tfclicuit_to) ,
                                           AV72Clientewwds_7_tfclifecalta ,
                                           AV73Clientewwds_8_tfclifecalta_to ,
                                           Byte.valueOf(AV74Clientewwds_9_tfclimultiemp_sel) ,
                                           Long.valueOf(AV75Clientewwds_10_tfclientepadre) ,
                                           Long.valueOf(AV76Clientewwds_11_tfclientepadre_to) ,
                                           Short.valueOf(AV77Clientewwds_12_tfclipaicod) ,
                                           Short.valueOf(AV78Clientewwds_13_tfclipaicod_to) ,
                                           Byte.valueOf(AV79Clientewwds_14_tfclientesistema_sel) ,
                                           Byte.valueOf(AV80Clientewwds_15_tfclienteconveniador_sel) ,
                                           Short.valueOf(AV57PaiCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A345CliCUIT) ,
                                           A346CliFecAlta ,
                                           Boolean.valueOf(A366CliMultiEmp) ,
                                           Long.valueOf(A546ClientePadre) ,
                                           Short.valueOf(A4CliPaiCod) ,
                                           Boolean.valueOf(A747ClienteSistema) ,
                                           Boolean.valueOf(A1605ClienteConveniador) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV68Clientewwds_3_tfclinom = GXutil.concat( GXutil.rtrim( AV68Clientewwds_3_tfclinom), "%", "") ;
      /* Using cursor P01IZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV66Clientewwds_1_tfclicod), Integer.valueOf(AV67Clientewwds_2_tfclicod_to), lV68Clientewwds_3_tfclinom, Long.valueOf(AV70Clientewwds_5_tfclicuit), Long.valueOf(AV71Clientewwds_6_tfclicuit_to), AV72Clientewwds_7_tfclifecalta, AV73Clientewwds_8_tfclifecalta_to, Long.valueOf(AV75Clientewwds_10_tfclientepadre), Long.valueOf(AV76Clientewwds_11_tfclientepadre_to), Short.valueOf(AV77Clientewwds_12_tfclipaicod), Short.valueOf(AV78Clientewwds_13_tfclipaicod_to), Short.valueOf(AV57PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1605ClienteConveniador = P01IZ2_A1605ClienteConveniador[0] ;
         A747ClienteSistema = P01IZ2_A747ClienteSistema[0] ;
         A4CliPaiCod = P01IZ2_A4CliPaiCod[0] ;
         n4CliPaiCod = P01IZ2_n4CliPaiCod[0] ;
         A546ClientePadre = P01IZ2_A546ClientePadre[0] ;
         n546ClientePadre = P01IZ2_n546ClientePadre[0] ;
         A366CliMultiEmp = P01IZ2_A366CliMultiEmp[0] ;
         A346CliFecAlta = P01IZ2_A346CliFecAlta[0] ;
         A345CliCUIT = P01IZ2_A345CliCUIT[0] ;
         A344CliNom = P01IZ2_A344CliNom[0] ;
         A3CliCod = P01IZ2_A3CliCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV81GXV3 = 1 ;
         while ( AV81GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV81GXV3));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A344CliNom, GXv_char7) ;
                  clientewwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCUIT") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A345CliCUIT );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliFecAlta") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A346CliFecAlta );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliMultiEmp") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A366CliMultiEmp) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ClientePadre") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A546ClientePadre );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliPaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A4CliPaiCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ClienteSistema") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A747ClienteSistema) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ClienteConveniador") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1605ClienteConveniador) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV81GXV3 = (int)(AV81GXV3+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliCod", "", "Cod", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliNom", "", "Nom", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliCUIT", "", "CUIT", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliFecAlta", "", "Fec Alta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliMultiEmp", "", "Multi Emp", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClientePadre", "", "Padre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliPaiCod", "", "Pai Cod", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClienteSistema", "", "Sistema", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ClienteConveniador", "", "Conveniador", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClienteWWColumnsSelector", GXv_char7) ;
      clientewwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClienteWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV82GXV4 = 1 ;
      while ( AV82GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV82GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV35TFCliCod = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFCliCod_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINOM") == 0 )
         {
            AV38TFCliNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINOM_SEL") == 0 )
         {
            AV37TFCliNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFCliNom_Sels.fromJSonString(AV37TFCliNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICUIT") == 0 )
         {
            AV42TFCliCUIT = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV58TFCliCUIT_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIFECALTA") == 0 )
         {
            AV45TFCliFecAlta = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV46TFCliFecAlta_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIMULTIEMP_SEL") == 0 )
         {
            AV47TFCliMultiEmp_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTEPADRE") == 0 )
         {
            AV48TFClientePadre = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV49TFClientePadre_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIPAICOD") == 0 )
         {
            AV50TFCliPaiCod = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFCliPaiCod_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTESISTEMA_SEL") == 0 )
         {
            AV52TFClienteSistema_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTECONVENIADOR_SEL") == 0 )
         {
            AV53TFClienteConveniador_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV59MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV82GXV4 = (int)(AV82GXV4+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = clientewwexport.this.AV12Filename;
      this.aP1[0] = clientewwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV62Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFCliNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFCliNom_Sel = "" ;
      AV38TFCliNom = "" ;
      AV45TFCliFecAlta = GXutil.nullDate() ;
      AV46TFCliFecAlta_To = GXutil.nullDate() ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A344CliNom = "" ;
      A346CliFecAlta = GXutil.nullDate() ;
      AV68Clientewwds_3_tfclinom = "" ;
      AV69Clientewwds_4_tfclinom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Clientewwds_7_tfclifecalta = GXutil.nullDate() ;
      AV73Clientewwds_8_tfclifecalta_to = GXutil.nullDate() ;
      scmdbuf = "" ;
      lV68Clientewwds_3_tfclinom = "" ;
      P01IZ2_A1605ClienteConveniador = new boolean[] {false} ;
      P01IZ2_A747ClienteSistema = new boolean[] {false} ;
      P01IZ2_A4CliPaiCod = new short[1] ;
      P01IZ2_n4CliPaiCod = new boolean[] {false} ;
      P01IZ2_A546ClientePadre = new long[1] ;
      P01IZ2_n546ClientePadre = new boolean[] {false} ;
      P01IZ2_A366CliMultiEmp = new boolean[] {false} ;
      P01IZ2_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      P01IZ2_A345CliCUIT = new long[1] ;
      P01IZ2_A344CliNom = new String[] {""} ;
      P01IZ2_A3CliCod = new int[1] ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFCliNom_SelsJson = "" ;
      AV59MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientewwexport__default(),
         new Object[] {
             new Object[] {
            P01IZ2_A1605ClienteConveniador, P01IZ2_A747ClienteSistema, P01IZ2_A4CliPaiCod, P01IZ2_n4CliPaiCod, P01IZ2_A546ClientePadre, P01IZ2_n546ClientePadre, P01IZ2_A366CliMultiEmp, P01IZ2_A346CliFecAlta, P01IZ2_A345CliCUIT, P01IZ2_A344CliNom,
            P01IZ2_A3CliCod
            }
         }
      );
      AV62Pgmname = "ClienteWWExport" ;
      /* GeneXus formulas. */
      AV62Pgmname = "ClienteWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV47TFCliMultiEmp_Sel ;
   private byte AV52TFClienteSistema_Sel ;
   private byte AV53TFClienteConveniador_Sel ;
   private byte AV74Clientewwds_9_tfclimultiemp_sel ;
   private byte AV79Clientewwds_14_tfclientesistema_sel ;
   private byte AV80Clientewwds_15_tfclienteconveniador_sel ;
   private short AV50TFCliPaiCod ;
   private short AV51TFCliPaiCod_To ;
   private short GXv_int5[] ;
   private short A4CliPaiCod ;
   private short AV77Clientewwds_12_tfclipaicod ;
   private short AV78Clientewwds_13_tfclipaicod_to ;
   private short AV57PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFCliCod ;
   private int AV36TFCliCod_To ;
   private int AV63GXV1 ;
   private int AV64GXV2 ;
   private int A3CliCod ;
   private int AV66Clientewwds_1_tfclicod ;
   private int AV67Clientewwds_2_tfclicod_to ;
   private int AV69Clientewwds_4_tfclinom_sels_size ;
   private int AV81GXV3 ;
   private int AV82GXV4 ;
   private long AV54i ;
   private long AV42TFCliCUIT ;
   private long AV58TFCliCUIT_To ;
   private long AV48TFClientePadre ;
   private long AV49TFClientePadre_To ;
   private long AV32VisibleColumnCount ;
   private long A345CliCUIT ;
   private long A546ClientePadre ;
   private long AV70Clientewwds_5_tfclicuit ;
   private long AV71Clientewwds_6_tfclicuit_to ;
   private long AV75Clientewwds_10_tfclientepadre ;
   private long AV76Clientewwds_11_tfclientepadre_to ;
   private String AV62Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV45TFCliFecAlta ;
   private java.util.Date AV46TFCliFecAlta_To ;
   private java.util.Date A346CliFecAlta ;
   private java.util.Date AV72Clientewwds_7_tfclifecalta ;
   private java.util.Date AV73Clientewwds_8_tfclifecalta_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A366CliMultiEmp ;
   private boolean A747ClienteSistema ;
   private boolean A1605ClienteConveniador ;
   private boolean AV19OrderedDsc ;
   private boolean n4CliPaiCod ;
   private boolean n546ClientePadre ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFCliNom_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFCliNom_Sel ;
   private String AV38TFCliNom ;
   private String A344CliNom ;
   private String AV68Clientewwds_3_tfclinom ;
   private String lV68Clientewwds_3_tfclinom ;
   private String AV59MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV39TFCliNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01IZ2_A1605ClienteConveniador ;
   private boolean[] P01IZ2_A747ClienteSistema ;
   private short[] P01IZ2_A4CliPaiCod ;
   private boolean[] P01IZ2_n4CliPaiCod ;
   private long[] P01IZ2_A546ClientePadre ;
   private boolean[] P01IZ2_n546ClientePadre ;
   private boolean[] P01IZ2_A366CliMultiEmp ;
   private java.util.Date[] P01IZ2_A346CliFecAlta ;
   private long[] P01IZ2_A345CliCUIT ;
   private String[] P01IZ2_A344CliNom ;
   private int[] P01IZ2_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV69Clientewwds_4_tfclinom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class clientewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A344CliNom ,
                                          GXSimpleCollection<String> AV69Clientewwds_4_tfclinom_sels ,
                                          int AV66Clientewwds_1_tfclicod ,
                                          int AV67Clientewwds_2_tfclicod_to ,
                                          int AV69Clientewwds_4_tfclinom_sels_size ,
                                          String AV68Clientewwds_3_tfclinom ,
                                          long AV70Clientewwds_5_tfclicuit ,
                                          long AV71Clientewwds_6_tfclicuit_to ,
                                          java.util.Date AV72Clientewwds_7_tfclifecalta ,
                                          java.util.Date AV73Clientewwds_8_tfclifecalta_to ,
                                          byte AV74Clientewwds_9_tfclimultiemp_sel ,
                                          long AV75Clientewwds_10_tfclientepadre ,
                                          long AV76Clientewwds_11_tfclientepadre_to ,
                                          short AV77Clientewwds_12_tfclipaicod ,
                                          short AV78Clientewwds_13_tfclipaicod_to ,
                                          byte AV79Clientewwds_14_tfclientesistema_sel ,
                                          byte AV80Clientewwds_15_tfclienteconveniador_sel ,
                                          short AV57PaiCod ,
                                          int A3CliCod ,
                                          long A345CliCUIT ,
                                          java.util.Date A346CliFecAlta ,
                                          boolean A366CliMultiEmp ,
                                          long A546ClientePadre ,
                                          short A4CliPaiCod ,
                                          boolean A747ClienteSistema ,
                                          boolean A1605ClienteConveniador ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[12];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT ClienteConveniador, ClienteSistema, CliPaiCod, ClientePadre, CliMultiEmp, CliFecAlta, CliCUIT, CliNom, CliCod FROM Cliente" ;
      if ( ! (0==AV66Clientewwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV67Clientewwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV69Clientewwds_4_tfclinom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Clientewwds_3_tfclinom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV69Clientewwds_4_tfclinom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Clientewwds_4_tfclinom_sels, "CliNom IN (", ")")+")");
      }
      if ( ! (0==AV70Clientewwds_5_tfclicuit) )
      {
         addWhere(sWhereString, "(CliCUIT >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV71Clientewwds_6_tfclicuit_to) )
      {
         addWhere(sWhereString, "(CliCUIT <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV72Clientewwds_7_tfclifecalta)) )
      {
         addWhere(sWhereString, "(CliFecAlta >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV73Clientewwds_8_tfclifecalta_to)) )
      {
         addWhere(sWhereString, "(CliFecAlta <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV74Clientewwds_9_tfclimultiemp_sel == 1 )
      {
         addWhere(sWhereString, "(CliMultiEmp = TRUE)");
      }
      if ( AV74Clientewwds_9_tfclimultiemp_sel == 2 )
      {
         addWhere(sWhereString, "(CliMultiEmp = FALSE)");
      }
      if ( ! (0==AV75Clientewwds_10_tfclientepadre) )
      {
         addWhere(sWhereString, "(ClientePadre >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (0==AV76Clientewwds_11_tfclientepadre_to) )
      {
         addWhere(sWhereString, "(ClientePadre <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV77Clientewwds_12_tfclipaicod) )
      {
         addWhere(sWhereString, "(CliPaiCod >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV78Clientewwds_13_tfclipaicod_to) )
      {
         addWhere(sWhereString, "(CliPaiCod <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV79Clientewwds_14_tfclientesistema_sel == 1 )
      {
         addWhere(sWhereString, "(ClienteSistema = TRUE)");
      }
      if ( AV79Clientewwds_14_tfclientesistema_sel == 2 )
      {
         addWhere(sWhereString, "(ClienteSistema = FALSE)");
      }
      if ( AV80Clientewwds_15_tfclienteconveniador_sel == 1 )
      {
         addWhere(sWhereString, "(ClienteConveniador = TRUE)");
      }
      if ( AV80Clientewwds_15_tfclienteconveniador_sel == 2 )
      {
         addWhere(sWhereString, "(ClienteConveniador = FALSE)");
      }
      if ( ! (0==AV57PaiCod) )
      {
         addWhere(sWhereString, "(CliPaiCod = ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliNom" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCUIT" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCUIT DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliFecAlta" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliFecAlta DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliMultiEmp" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliMultiEmp DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ClientePadre" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ClientePadre DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliPaiCod" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliPaiCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ClienteSistema" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ClienteSistema DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ClienteConveniador" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ClienteConveniador DESC" ;
      }
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01IZ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).longValue() , (java.util.Date)dynConstraints[20] , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).longValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Boolean) dynConstraints[25]).booleanValue() , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(5);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((long[]) buf[8])[0] = rslt.getLong(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[15]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[16]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[17]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[18]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[20]).longValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               return;
      }
   }

}

