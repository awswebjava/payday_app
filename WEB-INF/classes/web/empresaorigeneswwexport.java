package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresaorigeneswwexport extends GXProcedure
{
   public empresaorigeneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaorigeneswwexport.class ), "" );
   }

   public empresaorigeneswwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresaorigeneswwexport.this.aP1 = new String[] {""};
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
      empresaorigeneswwexport.this.aP0 = aP0;
      empresaorigeneswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaOrigenes", GXv_boolean2) ;
      empresaorigeneswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV45Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EmpresaOrigenesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFEmpOrigen_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresaorigeneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV39i = 1 ;
         AV46GXV1 = 1 ;
         while ( AV46GXV1 <= AV36TFEmpOrigen_Sels.size() )
         {
            AV37TFEmpOrigen_Sel = (String)AV36TFEmpOrigen_Sels.elementAt(-1+AV46GXV1) ;
            if ( AV39i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV38TFEmpOrigen_SelDsc = AV37TFEmpOrigen_Sel ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+AV38TFEmpOrigen_SelDsc );
            AV39i = (long)(AV39i+1) ;
            AV46GXV1 = (int)(AV46GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV35TFEmpOrigen)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresaorigeneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFEmpOrigen, GXv_char7) ;
            empresaorigeneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV31VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV19Session.getValue("EmpresaOrigenesWWColumnsSelector"), "") != 0 )
      {
         AV26ColumnsSelectorXML = AV19Session.getValue("EmpresaOrigenesWWColumnsSelector") ;
         AV23ColumnsSelector.fromxml(AV26ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV47GXV2 = 1 ;
      while ( AV47GXV2 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV47GXV2));
         if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setColor( 11 );
            AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
         }
         AV47GXV2 = (int)(AV47GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV49Empresaorigeneswwds_1_tfemporigen = AV35TFEmpOrigen ;
      AV50Empresaorigeneswwds_2_tfemporigen_sels = AV36TFEmpOrigen_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1238EmpOrigen ,
                                           AV50Empresaorigeneswwds_2_tfemporigen_sels ,
                                           Integer.valueOf(AV50Empresaorigeneswwds_2_tfemporigen_sels.size()) ,
                                           AV49Empresaorigeneswwds_1_tfemporigen ,
                                           A1284OrigNombre ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV40CliCod) ,
                                           Short.valueOf(AV41EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV49Empresaorigeneswwds_1_tfemporigen = GXutil.concat( GXutil.rtrim( AV49Empresaorigeneswwds_1_tfemporigen), "%", "") ;
      /* Using cursor P01SS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV40CliCod), Short.valueOf(AV41EmpCod), lV49Empresaorigeneswwds_1_tfemporigen});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1231OrigId = P01SS2_A1231OrigId[0] ;
         A1EmpCod = P01SS2_A1EmpCod[0] ;
         A3CliCod = P01SS2_A3CliCod[0] ;
         A1284OrigNombre = P01SS2_A1284OrigNombre[0] ;
         A1238EmpOrigen = P01SS2_A1238EmpOrigen[0] ;
         A1284OrigNombre = P01SS2_A1284OrigNombre[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV31VisibleColumnCount = 0 ;
         AV51GXV3 = 1 ;
         while ( AV51GXV3 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV51GXV3));
            if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpOrigen") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1284OrigNombre, GXv_char7) ;
                  empresaorigeneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
            }
            AV51GXV3 = (int)(AV51GXV3+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      AV23ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpOrigen", "", "Origen", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV27UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EmpresaOrigenesWWColumnsSelector", GXv_char7) ;
      empresaorigeneswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV27UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV27UserCustomValue)==0) ) )
      {
         AV24ColumnsSelectorAux.fromxml(AV27UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV23ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV24ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV23ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue("EmpresaOrigenesWWGridState"), "") == 0 )
      {
         AV21GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaOrigenesWWGridState"), null, null);
      }
      else
      {
         AV21GridState.fromxml(AV19Session.getValue("EmpresaOrigenesWWGridState"), null, null);
      }
      AV18OrderedDsc = AV21GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV52GXV4 = 1 ;
      while ( AV52GXV4 <= AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV22GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV4));
         if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPORIGEN") == 0 )
         {
            AV35TFEmpOrigen = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPORIGEN_SEL") == 0 )
         {
            AV34TFEmpOrigen_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFEmpOrigen_Sels.fromJSonString(AV34TFEmpOrigen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV4 = (int)(AV52GXV4+1) ;
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
      this.aP0[0] = empresaorigeneswwexport.this.AV12Filename;
      this.aP1[0] = empresaorigeneswwexport.this.AV13ErrorMessage;
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
      AV45Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFEmpOrigen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFEmpOrigen_Sel = "" ;
      AV38TFEmpOrigen_SelDsc = "" ;
      AV35TFEmpOrigen = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV19Session = httpContext.getWebSession();
      AV26ColumnsSelectorXML = "" ;
      AV23ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV25ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1284OrigNombre = "" ;
      AV49Empresaorigeneswwds_1_tfemporigen = "" ;
      AV50Empresaorigeneswwds_2_tfemporigen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV49Empresaorigeneswwds_1_tfemporigen = "" ;
      A1238EmpOrigen = "" ;
      P01SS2_A1231OrigId = new String[] {""} ;
      P01SS2_A1EmpCod = new short[1] ;
      P01SS2_A3CliCod = new int[1] ;
      P01SS2_A1284OrigNombre = new String[] {""} ;
      P01SS2_A1238EmpOrigen = new String[] {""} ;
      A1231OrigId = "" ;
      AV27UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV24ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV21GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV34TFEmpOrigen_SelsJson = "" ;
      AV42MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaorigeneswwexport__default(),
         new Object[] {
             new Object[] {
            P01SS2_A1231OrigId, P01SS2_A1EmpCod, P01SS2_A3CliCod, P01SS2_A1284OrigNombre, P01SS2_A1238EmpOrigen
            }
         }
      );
      AV45Pgmname = "EmpresaOrigenesWWExport" ;
      /* GeneXus formulas. */
      AV45Pgmname = "EmpresaOrigenesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV41EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV46GXV1 ;
   private int AV47GXV2 ;
   private int AV50Empresaorigeneswwds_2_tfemporigen_sels_size ;
   private int AV40CliCod ;
   private int A3CliCod ;
   private int AV51GXV3 ;
   private int AV52GXV4 ;
   private long AV39i ;
   private long AV31VisibleColumnCount ;
   private String AV45Pgmname ;
   private String AV37TFEmpOrigen_Sel ;
   private String scmdbuf ;
   private String A1238EmpOrigen ;
   private String A1231OrigId ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV26ColumnsSelectorXML ;
   private String AV27UserCustomValue ;
   private String AV34TFEmpOrigen_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFEmpOrigen_SelDsc ;
   private String AV35TFEmpOrigen ;
   private String A1284OrigNombre ;
   private String AV49Empresaorigeneswwds_1_tfemporigen ;
   private String lV49Empresaorigeneswwds_1_tfemporigen ;
   private String AV42MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private GXSimpleCollection<String> AV36TFEmpOrigen_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01SS2_A1231OrigId ;
   private short[] P01SS2_A1EmpCod ;
   private int[] P01SS2_A3CliCod ;
   private String[] P01SS2_A1284OrigNombre ;
   private String[] P01SS2_A1238EmpOrigen ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV50Empresaorigeneswwds_2_tfemporigen_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV21GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV22GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV25ColumnsSelector_Column ;
}

final  class empresaorigeneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1238EmpOrigen ,
                                          GXSimpleCollection<String> AV50Empresaorigeneswwds_2_tfemporigen_sels ,
                                          int AV50Empresaorigeneswwds_2_tfemporigen_sels_size ,
                                          String AV49Empresaorigeneswwds_1_tfemporigen ,
                                          String A1284OrigNombre ,
                                          boolean AV18OrderedDsc ,
                                          int AV40CliCod ,
                                          short AV41EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[3];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.OrigId, T1.EmpCod, T1.CliCod, T2.OrigNombre, T1.EmpOrigen FROM (Empresanolaborables_origen T1 INNER JOIN Origen T2 ON T2.OrigId = T1.EmpOrigen)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV50Empresaorigeneswwds_2_tfemporigen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Empresaorigeneswwds_1_tfemporigen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.OrigNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV50Empresaorigeneswwds_2_tfemporigen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Empresaorigeneswwds_2_tfemporigen_sels, "T1.EmpOrigen IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpOrigen" ;
      }
      else if ( AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpOrigen DESC" ;
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
                  return conditional_P01SS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Boolean) dynConstraints[5]).booleanValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
      }
   }

}

