package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class rest_locationwwexport extends GXProcedure
{
   public rest_locationwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( rest_locationwwexport.class ), "" );
   }

   public rest_locationwwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      rest_locationwwexport.this.aP1 = new String[] {""};
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
      rest_locationwwexport.this.aP0 = aP0;
      rest_locationwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWrest_location", GXv_boolean2) ;
      rest_locationwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "rest_locationWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFRestLocId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV56i = 1 ;
         AV62GXV1 = 1 ;
         while ( AV62GXV1 <= AV37TFRestLocId_Sels.size() )
         {
            AV38TFRestLocId_Sel = (String)AV37TFRestLocId_Sels.elementAt(-1+AV62GXV1) ;
            if ( AV56i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFRestLocId_Sel, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV56i = (long)(AV56i+1) ;
            AV62GXV1 = (int)(AV62GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFRestLocId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Id", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFRestLocId, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV39TFRestLocHab_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Hab", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV39TFRestLocHab_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV39TFRestLocHab_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV42TFRestLocBaseUrl_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Base Url", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV56i = 1 ;
         AV63GXV2 = 1 ;
         while ( AV63GXV2 <= AV42TFRestLocBaseUrl_Sels.size() )
         {
            AV43TFRestLocBaseUrl_Sel = (String)AV42TFRestLocBaseUrl_Sels.elementAt(-1+AV63GXV2) ;
            if ( AV56i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFRestLocBaseUrl_Sel, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV56i = (long)(AV56i+1) ;
            AV63GXV2 = (int)(AV63GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFRestLocBaseUrl)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Base Url", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFRestLocBaseUrl, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV44TFRestLocCancelOnError) && (0==AV45TFRestLocCancelOnError_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "On Error", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV44TFRestLocCancelOnError );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV45TFRestLocCancelOnError_To );
      }
      if ( ! ( ( AV48TFRestLocHost_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Host", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV56i = 1 ;
         AV64GXV3 = 1 ;
         while ( AV64GXV3 <= AV48TFRestLocHost_Sels.size() )
         {
            AV49TFRestLocHost_Sel = (String)AV48TFRestLocHost_Sels.elementAt(-1+AV64GXV3) ;
            if ( AV56i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFRestLocHost_Sel, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV56i = (long)(AV56i+1) ;
            AV64GXV3 = (int)(AV64GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFRestLocHost)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Host", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFRestLocHost, GXv_char7) ;
            rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV50TFRestLocPort) && (0==AV51TFRestLocPort_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Port", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV50TFRestLocPort );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV51TFRestLocPort_To );
      }
      if ( ! ( (0==AV52TFRestLocTimeout) && (0==AV53TFRestLocTimeout_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Timeout", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV52TFRestLocTimeout );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV53TFRestLocTimeout_To );
      }
      if ( ! ( (0==AV54TFRestLocSecure) && (0==AV55TFRestLocSecure_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Loc Secure", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV54TFRestLocSecure );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         rest_locationwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV55TFRestLocSecure_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("rest_locationWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("rest_locationWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV4 = 1 ;
      while ( AV65GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV65GXV4 = (int)(AV65GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Rest_locationwwds_1_tfrestlocid = AV36TFRestLocId ;
      AV68Rest_locationwwds_2_tfrestlocid_sels = AV37TFRestLocId_Sels ;
      AV69Rest_locationwwds_3_tfrestlochab_sel = AV39TFRestLocHab_Sel ;
      AV70Rest_locationwwds_4_tfrestlocbaseurl = AV41TFRestLocBaseUrl ;
      AV71Rest_locationwwds_5_tfrestlocbaseurl_sels = AV42TFRestLocBaseUrl_Sels ;
      AV72Rest_locationwwds_6_tfrestloccancelonerror = AV44TFRestLocCancelOnError ;
      AV73Rest_locationwwds_7_tfrestloccancelonerror_to = AV45TFRestLocCancelOnError_To ;
      AV74Rest_locationwwds_8_tfrestlochost = AV47TFRestLocHost ;
      AV75Rest_locationwwds_9_tfrestlochost_sels = AV48TFRestLocHost_Sels ;
      AV76Rest_locationwwds_10_tfrestlocport = AV50TFRestLocPort ;
      AV77Rest_locationwwds_11_tfrestlocport_to = AV51TFRestLocPort_To ;
      AV78Rest_locationwwds_12_tfrestloctimeout = AV52TFRestLocTimeout ;
      AV79Rest_locationwwds_13_tfrestloctimeout_to = AV53TFRestLocTimeout_To ;
      AV80Rest_locationwwds_14_tfrestlocsecure = AV54TFRestLocSecure ;
      AV81Rest_locationwwds_15_tfrestlocsecure_to = AV55TFRestLocSecure_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2171RestLocId ,
                                           AV68Rest_locationwwds_2_tfrestlocid_sels ,
                                           A2173RestLocBaseUrl ,
                                           AV71Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                           A2175RestLocHost ,
                                           AV75Rest_locationwwds_9_tfrestlochost_sels ,
                                           Integer.valueOf(AV68Rest_locationwwds_2_tfrestlocid_sels.size()) ,
                                           AV67Rest_locationwwds_1_tfrestlocid ,
                                           Byte.valueOf(AV69Rest_locationwwds_3_tfrestlochab_sel) ,
                                           Integer.valueOf(AV71Rest_locationwwds_5_tfrestlocbaseurl_sels.size()) ,
                                           AV70Rest_locationwwds_4_tfrestlocbaseurl ,
                                           Byte.valueOf(AV72Rest_locationwwds_6_tfrestloccancelonerror) ,
                                           Byte.valueOf(AV73Rest_locationwwds_7_tfrestloccancelonerror_to) ,
                                           Integer.valueOf(AV75Rest_locationwwds_9_tfrestlochost_sels.size()) ,
                                           AV74Rest_locationwwds_8_tfrestlochost ,
                                           Integer.valueOf(AV76Rest_locationwwds_10_tfrestlocport) ,
                                           Integer.valueOf(AV77Rest_locationwwds_11_tfrestlocport_to) ,
                                           Short.valueOf(AV78Rest_locationwwds_12_tfrestloctimeout) ,
                                           Short.valueOf(AV79Rest_locationwwds_13_tfrestloctimeout_to) ,
                                           Byte.valueOf(AV80Rest_locationwwds_14_tfrestlocsecure) ,
                                           Byte.valueOf(AV81Rest_locationwwds_15_tfrestlocsecure_to) ,
                                           Boolean.valueOf(A2172RestLocHab) ,
                                           Byte.valueOf(A2174RestLocCancelOnError) ,
                                           Integer.valueOf(A2176RestLocPort) ,
                                           Short.valueOf(A2177RestLocTimeout) ,
                                           Byte.valueOf(A2178RestLocSecure) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV57CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV67Rest_locationwwds_1_tfrestlocid = GXutil.padr( GXutil.rtrim( AV67Rest_locationwwds_1_tfrestlocid), 40, "%") ;
      lV70Rest_locationwwds_4_tfrestlocbaseurl = GXutil.concat( GXutil.rtrim( AV70Rest_locationwwds_4_tfrestlocbaseurl), "%", "") ;
      lV74Rest_locationwwds_8_tfrestlochost = GXutil.concat( GXutil.rtrim( AV74Rest_locationwwds_8_tfrestlochost), "%", "") ;
      /* Using cursor P02FZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV57CliCod), lV67Rest_locationwwds_1_tfrestlocid, lV70Rest_locationwwds_4_tfrestlocbaseurl, Byte.valueOf(AV72Rest_locationwwds_6_tfrestloccancelonerror), Byte.valueOf(AV73Rest_locationwwds_7_tfrestloccancelonerror_to), lV74Rest_locationwwds_8_tfrestlochost, Integer.valueOf(AV76Rest_locationwwds_10_tfrestlocport), Integer.valueOf(AV77Rest_locationwwds_11_tfrestlocport_to), Short.valueOf(AV78Rest_locationwwds_12_tfrestloctimeout), Short.valueOf(AV79Rest_locationwwds_13_tfrestloctimeout_to), Byte.valueOf(AV80Rest_locationwwds_14_tfrestlocsecure), Byte.valueOf(AV81Rest_locationwwds_15_tfrestlocsecure_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02FZ2_A3CliCod[0] ;
         A2178RestLocSecure = P02FZ2_A2178RestLocSecure[0] ;
         A2177RestLocTimeout = P02FZ2_A2177RestLocTimeout[0] ;
         A2176RestLocPort = P02FZ2_A2176RestLocPort[0] ;
         A2175RestLocHost = P02FZ2_A2175RestLocHost[0] ;
         A2174RestLocCancelOnError = P02FZ2_A2174RestLocCancelOnError[0] ;
         A2173RestLocBaseUrl = P02FZ2_A2173RestLocBaseUrl[0] ;
         A2172RestLocHab = P02FZ2_A2172RestLocHab[0] ;
         A2171RestLocId = P02FZ2_A2171RestLocId[0] ;
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
         AV82GXV5 = 1 ;
         while ( AV82GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2171RestLocId, GXv_char7) ;
                  rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocHab") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2172RestLocHab) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocBaseUrl") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2173RestLocBaseUrl, GXv_char7) ;
                  rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocCancelOnError") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2174RestLocCancelOnError );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocHost") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2175RestLocHost, GXv_char7) ;
                  rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocPort") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2176RestLocPort );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocTimeout") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2177RestLocTimeout );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RestLocSecure") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2178RestLocSecure );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV82GXV5 = (int)(AV82GXV5+1) ;
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
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocId", "", "Loc Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocHab", "", "Loc Hab", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocBaseUrl", "", "Base Url", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocCancelOnError", "", "On Error", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocHost", "", "Loc Host", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocPort", "", "Loc Port", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocTimeout", "", "Loc Timeout", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RestLocSecure", "", "Loc Secure", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "rest_locationWWColumnsSelector", GXv_char7) ;
      rest_locationwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("rest_locationWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "rest_locationWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("rest_locationWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV6 = 1 ;
      while ( AV83GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCID") == 0 )
         {
            AV36TFRestLocId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCID_SEL") == 0 )
         {
            AV35TFRestLocId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFRestLocId_Sels.fromJSonString(AV35TFRestLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHAB_SEL") == 0 )
         {
            AV39TFRestLocHab_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCBASEURL") == 0 )
         {
            AV41TFRestLocBaseUrl = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCBASEURL_SEL") == 0 )
         {
            AV40TFRestLocBaseUrl_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFRestLocBaseUrl_Sels.fromJSonString(AV40TFRestLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCCANCELONERROR") == 0 )
         {
            AV44TFRestLocCancelOnError = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV45TFRestLocCancelOnError_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHOST") == 0 )
         {
            AV47TFRestLocHost = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHOST_SEL") == 0 )
         {
            AV46TFRestLocHost_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFRestLocHost_Sels.fromJSonString(AV46TFRestLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCPORT") == 0 )
         {
            AV50TFRestLocPort = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFRestLocPort_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCTIMEOUT") == 0 )
         {
            AV52TFRestLocTimeout = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFRestLocTimeout_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCSECURE") == 0 )
         {
            AV54TFRestLocSecure = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV55TFRestLocSecure_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV83GXV6 = (int)(AV83GXV6+1) ;
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
      this.aP0[0] = rest_locationwwexport.this.AV12Filename;
      this.aP1[0] = rest_locationwwexport.this.AV13ErrorMessage;
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
      AV61Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFRestLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFRestLocId_Sel = "" ;
      AV36TFRestLocId = "" ;
      AV42TFRestLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFRestLocBaseUrl_Sel = "" ;
      AV41TFRestLocBaseUrl = "" ;
      AV48TFRestLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFRestLocHost_Sel = "" ;
      AV47TFRestLocHost = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A2171RestLocId = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      AV67Rest_locationwwds_1_tfrestlocid = "" ;
      AV68Rest_locationwwds_2_tfrestlocid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Rest_locationwwds_4_tfrestlocbaseurl = "" ;
      AV71Rest_locationwwds_5_tfrestlocbaseurl_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Rest_locationwwds_8_tfrestlochost = "" ;
      AV75Rest_locationwwds_9_tfrestlochost_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Rest_locationwwds_1_tfrestlocid = "" ;
      lV70Rest_locationwwds_4_tfrestlocbaseurl = "" ;
      lV74Rest_locationwwds_8_tfrestlochost = "" ;
      P02FZ2_A3CliCod = new int[1] ;
      P02FZ2_A2178RestLocSecure = new byte[1] ;
      P02FZ2_A2177RestLocTimeout = new short[1] ;
      P02FZ2_A2176RestLocPort = new int[1] ;
      P02FZ2_A2175RestLocHost = new String[] {""} ;
      P02FZ2_A2174RestLocCancelOnError = new byte[1] ;
      P02FZ2_A2173RestLocBaseUrl = new String[] {""} ;
      P02FZ2_A2172RestLocHab = new boolean[] {false} ;
      P02FZ2_A2171RestLocId = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFRestLocId_SelsJson = "" ;
      AV40TFRestLocBaseUrl_SelsJson = "" ;
      AV46TFRestLocHost_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.rest_locationwwexport__default(),
         new Object[] {
             new Object[] {
            P02FZ2_A3CliCod, P02FZ2_A2178RestLocSecure, P02FZ2_A2177RestLocTimeout, P02FZ2_A2176RestLocPort, P02FZ2_A2175RestLocHost, P02FZ2_A2174RestLocCancelOnError, P02FZ2_A2173RestLocBaseUrl, P02FZ2_A2172RestLocHab, P02FZ2_A2171RestLocId
            }
         }
      );
      AV61Pgmname = "rest_locationWWExport" ;
      /* GeneXus formulas. */
      AV61Pgmname = "rest_locationWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV39TFRestLocHab_Sel ;
   private byte AV44TFRestLocCancelOnError ;
   private byte AV45TFRestLocCancelOnError_To ;
   private byte AV54TFRestLocSecure ;
   private byte AV55TFRestLocSecure_To ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private byte AV69Rest_locationwwds_3_tfrestlochab_sel ;
   private byte AV72Rest_locationwwds_6_tfrestloccancelonerror ;
   private byte AV73Rest_locationwwds_7_tfrestloccancelonerror_to ;
   private byte AV80Rest_locationwwds_14_tfrestlocsecure ;
   private byte AV81Rest_locationwwds_15_tfrestlocsecure_to ;
   private short AV52TFRestLocTimeout ;
   private short AV53TFRestLocTimeout_To ;
   private short GXv_int5[] ;
   private short A2177RestLocTimeout ;
   private short AV78Rest_locationwwds_12_tfrestloctimeout ;
   private short AV79Rest_locationwwds_13_tfrestloctimeout_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV62GXV1 ;
   private int AV63GXV2 ;
   private int AV64GXV3 ;
   private int AV50TFRestLocPort ;
   private int AV51TFRestLocPort_To ;
   private int AV65GXV4 ;
   private int A2176RestLocPort ;
   private int AV76Rest_locationwwds_10_tfrestlocport ;
   private int AV77Rest_locationwwds_11_tfrestlocport_to ;
   private int AV68Rest_locationwwds_2_tfrestlocid_sels_size ;
   private int AV71Rest_locationwwds_5_tfrestlocbaseurl_sels_size ;
   private int AV75Rest_locationwwds_9_tfrestlochost_sels_size ;
   private int AV57CliCod ;
   private int A3CliCod ;
   private int AV82GXV5 ;
   private int AV83GXV6 ;
   private long AV56i ;
   private long AV32VisibleColumnCount ;
   private String AV61Pgmname ;
   private String AV38TFRestLocId_Sel ;
   private String AV36TFRestLocId ;
   private String A2171RestLocId ;
   private String AV67Rest_locationwwds_1_tfrestlocid ;
   private String scmdbuf ;
   private String lV67Rest_locationwwds_1_tfrestlocid ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2172RestLocHab ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFRestLocId_SelsJson ;
   private String AV40TFRestLocBaseUrl_SelsJson ;
   private String AV46TFRestLocHost_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV43TFRestLocBaseUrl_Sel ;
   private String AV41TFRestLocBaseUrl ;
   private String AV49TFRestLocHost_Sel ;
   private String AV47TFRestLocHost ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private String AV70Rest_locationwwds_4_tfrestlocbaseurl ;
   private String AV74Rest_locationwwds_8_tfrestlochost ;
   private String lV70Rest_locationwwds_4_tfrestlocbaseurl ;
   private String lV74Rest_locationwwds_8_tfrestlochost ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFRestLocId_Sels ;
   private GXSimpleCollection<String> AV42TFRestLocBaseUrl_Sels ;
   private GXSimpleCollection<String> AV48TFRestLocHost_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FZ2_A3CliCod ;
   private byte[] P02FZ2_A2178RestLocSecure ;
   private short[] P02FZ2_A2177RestLocTimeout ;
   private int[] P02FZ2_A2176RestLocPort ;
   private String[] P02FZ2_A2175RestLocHost ;
   private byte[] P02FZ2_A2174RestLocCancelOnError ;
   private String[] P02FZ2_A2173RestLocBaseUrl ;
   private boolean[] P02FZ2_A2172RestLocHab ;
   private String[] P02FZ2_A2171RestLocId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV68Rest_locationwwds_2_tfrestlocid_sels ;
   private GXSimpleCollection<String> AV71Rest_locationwwds_5_tfrestlocbaseurl_sels ;
   private GXSimpleCollection<String> AV75Rest_locationwwds_9_tfrestlochost_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class rest_locationwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2171RestLocId ,
                                          GXSimpleCollection<String> AV68Rest_locationwwds_2_tfrestlocid_sels ,
                                          String A2173RestLocBaseUrl ,
                                          GXSimpleCollection<String> AV71Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                          String A2175RestLocHost ,
                                          GXSimpleCollection<String> AV75Rest_locationwwds_9_tfrestlochost_sels ,
                                          int AV68Rest_locationwwds_2_tfrestlocid_sels_size ,
                                          String AV67Rest_locationwwds_1_tfrestlocid ,
                                          byte AV69Rest_locationwwds_3_tfrestlochab_sel ,
                                          int AV71Rest_locationwwds_5_tfrestlocbaseurl_sels_size ,
                                          String AV70Rest_locationwwds_4_tfrestlocbaseurl ,
                                          byte AV72Rest_locationwwds_6_tfrestloccancelonerror ,
                                          byte AV73Rest_locationwwds_7_tfrestloccancelonerror_to ,
                                          int AV75Rest_locationwwds_9_tfrestlochost_sels_size ,
                                          String AV74Rest_locationwwds_8_tfrestlochost ,
                                          int AV76Rest_locationwwds_10_tfrestlocport ,
                                          int AV77Rest_locationwwds_11_tfrestlocport_to ,
                                          short AV78Rest_locationwwds_12_tfrestloctimeout ,
                                          short AV79Rest_locationwwds_13_tfrestloctimeout_to ,
                                          byte AV80Rest_locationwwds_14_tfrestlocsecure ,
                                          byte AV81Rest_locationwwds_15_tfrestlocsecure_to ,
                                          boolean A2172RestLocHab ,
                                          byte A2174RestLocCancelOnError ,
                                          int A2176RestLocPort ,
                                          short A2177RestLocTimeout ,
                                          byte A2178RestLocSecure ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV57CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliCod, RestLocSecure, RestLocTimeout, RestLocPort, RestLocHost, RestLocCancelOnError, RestLocBaseUrl, RestLocHab, RestLocId FROM rest_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV68Rest_locationwwds_2_tfrestlocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Rest_locationwwds_1_tfrestlocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocId) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV68Rest_locationwwds_2_tfrestlocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Rest_locationwwds_2_tfrestlocid_sels, "RestLocId IN (", ")")+")");
      }
      if ( AV69Rest_locationwwds_3_tfrestlochab_sel == 1 )
      {
         addWhere(sWhereString, "(RestLocHab = TRUE)");
      }
      if ( AV69Rest_locationwwds_3_tfrestlochab_sel == 2 )
      {
         addWhere(sWhereString, "(RestLocHab = FALSE)");
      }
      if ( ( AV71Rest_locationwwds_5_tfrestlocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Rest_locationwwds_4_tfrestlocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV71Rest_locationwwds_5_tfrestlocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Rest_locationwwds_5_tfrestlocbaseurl_sels, "RestLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV72Rest_locationwwds_6_tfrestloccancelonerror) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV73Rest_locationwwds_7_tfrestloccancelonerror_to) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ( AV75Rest_locationwwds_9_tfrestlochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Rest_locationwwds_8_tfrestlochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV75Rest_locationwwds_9_tfrestlochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Rest_locationwwds_9_tfrestlochost_sels, "RestLocHost IN (", ")")+")");
      }
      if ( ! (0==AV76Rest_locationwwds_10_tfrestlocport) )
      {
         addWhere(sWhereString, "(RestLocPort >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV77Rest_locationwwds_11_tfrestlocport_to) )
      {
         addWhere(sWhereString, "(RestLocPort <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV78Rest_locationwwds_12_tfrestloctimeout) )
      {
         addWhere(sWhereString, "(RestLocTimeout >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV79Rest_locationwwds_13_tfrestloctimeout_to) )
      {
         addWhere(sWhereString, "(RestLocTimeout <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV80Rest_locationwwds_14_tfrestlocsecure) )
      {
         addWhere(sWhereString, "(RestLocSecure >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV81Rest_locationwwds_15_tfrestlocsecure_to) )
      {
         addWhere(sWhereString, "(RestLocSecure <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocHab" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocHab DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocBaseUrl" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocBaseUrl DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocCancelOnError" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocCancelOnError DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocHost" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocHost DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocPort" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocPort DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocTimeout" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocTimeout DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY RestLocSecure" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY RestLocSecure DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P02FZ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).intValue() , ((Number) dynConstraints[29]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 40);
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
                  stmt.setString(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 1000);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               return;
      }
   }

}

