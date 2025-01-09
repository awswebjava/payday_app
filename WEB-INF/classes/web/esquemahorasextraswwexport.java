package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esquemahorasextraswwexport extends GXProcedure
{
   public esquemahorasextraswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemahorasextraswwexport.class ), "" );
   }

   public esquemahorasextraswwexport( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      esquemahorasextraswwexport.this.aP1 = new String[] {""};
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
      esquemahorasextraswwexport.this.aP0 = aP0;
      esquemahorasextraswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasExtras", GXv_boolean2) ;
      esquemahorasextraswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV60Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EsquemaHorasExtrasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFPaiTipoTraId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV55i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV37TFPaiTipoTraId_Sels.size() )
         {
            AV38TFPaiTipoTraId_Sel = (String)AV37TFPaiTipoTraId_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV38TFPaiTipoTraId_Sel), "") );
            AV55i = (long)(AV55i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFConveHsDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFConveHsDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV39TFConveHsDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV40TFConveHsDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFConveHsSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFConveHsSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFConveHsSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV42TFConveHsSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFConveHsMaxDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFConveHsMaxDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFConveHsMaxDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFConveHsMaxDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFConveHsMaxSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFConveHsMaxSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFConveHsMaxSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFConveHsMaxSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFConveHsMaxMes)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFConveHsMaxMes_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFConveHsMaxMes)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFConveHsMaxMes_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFConveHsMaxAnu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFConveHsMaxAnu_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFConveHsMaxAnu)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasextraswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV54TFConveHsMaxAnu_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("EsquemaHorasExtrasWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("EsquemaHorasExtrasWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV2 = 1 ;
      while ( AV62GXV2 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV2));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV62GXV2 = (int)(AV62GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels = AV37TFPaiTipoTraId_Sels ;
      AV65Esquemahorasextraswwds_2_tfconvehsdia = AV39TFConveHsDia ;
      AV66Esquemahorasextraswwds_3_tfconvehsdia_to = AV40TFConveHsDia_To ;
      AV67Esquemahorasextraswwds_4_tfconvehssem = AV41TFConveHsSem ;
      AV68Esquemahorasextraswwds_5_tfconvehssem_to = AV42TFConveHsSem_To ;
      AV69Esquemahorasextraswwds_6_tfconvehsmaxdia = AV47TFConveHsMaxDia ;
      AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to = AV48TFConveHsMaxDia_To ;
      AV71Esquemahorasextraswwds_8_tfconvehsmaxsem = AV49TFConveHsMaxSem ;
      AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to = AV50TFConveHsMaxSem_To ;
      AV73Esquemahorasextraswwds_10_tfconvehsmaxmes = AV51TFConveHsMaxMes ;
      AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to = AV52TFConveHsMaxMes_To ;
      AV75Esquemahorasextraswwds_12_tfconvehsmaxanu = AV53TFConveHsMaxAnu ;
      AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to = AV54TFConveHsMaxAnu_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels ,
                                           Integer.valueOf(AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels.size()) ,
                                           AV65Esquemahorasextraswwds_2_tfconvehsdia ,
                                           AV66Esquemahorasextraswwds_3_tfconvehsdia_to ,
                                           AV67Esquemahorasextraswwds_4_tfconvehssem ,
                                           AV68Esquemahorasextraswwds_5_tfconvehssem_to ,
                                           AV69Esquemahorasextraswwds_6_tfconvehsmaxdia ,
                                           AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to ,
                                           AV71Esquemahorasextraswwds_8_tfconvehsmaxsem ,
                                           AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to ,
                                           AV73Esquemahorasextraswwds_10_tfconvehsmaxmes ,
                                           AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to ,
                                           AV75Esquemahorasextraswwds_12_tfconvehsmaxanu ,
                                           AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to ,
                                           A1323ConveHsDia ,
                                           A1324ConveHsSem ,
                                           A1391ConveHsMaxDia ,
                                           A1392ConveHsMaxSem ,
                                           A1393ConveHsMaxMes ,
                                           A1394ConveHsMaxAnu ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           A1565CliConvenio ,
                                           AV18CliConvenio ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02M12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), AV18CliConvenio, AV65Esquemahorasextraswwds_2_tfconvehsdia, AV66Esquemahorasextraswwds_3_tfconvehsdia_to, AV67Esquemahorasextraswwds_4_tfconvehssem, AV68Esquemahorasextraswwds_5_tfconvehssem_to, AV69Esquemahorasextraswwds_6_tfconvehsmaxdia, AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to, AV71Esquemahorasextraswwds_8_tfconvehsmaxsem, AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to, AV73Esquemahorasextraswwds_10_tfconvehsmaxmes, AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to, AV75Esquemahorasextraswwds_12_tfconvehsmaxanu, AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P02M12_A1565CliConvenio[0] ;
         A3CliCod = P02M12_A3CliCod[0] ;
         A1394ConveHsMaxAnu = P02M12_A1394ConveHsMaxAnu[0] ;
         A1393ConveHsMaxMes = P02M12_A1393ConveHsMaxMes[0] ;
         A1392ConveHsMaxSem = P02M12_A1392ConveHsMaxSem[0] ;
         A1391ConveHsMaxDia = P02M12_A1391ConveHsMaxDia[0] ;
         A1324ConveHsSem = P02M12_A1324ConveHsSem[0] ;
         A1323ConveHsDia = P02M12_A1323ConveHsDia[0] ;
         A1294PaiTipoTraId = P02M12_A1294PaiTipoTraId[0] ;
         A1564CliPaiConve = P02M12_A1564CliPaiConve[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV77GXV3 = 1 ;
         while ( AV77GXV3 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV77GXV3));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1294PaiTipoTraId), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1323ConveHsDia)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1324ConveHsSem)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1391ConveHsMaxDia)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1392ConveHsMaxSem)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1393ConveHsMaxMes)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxAnu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1394ConveHsMaxAnu)) );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV77GXV3 = (int)(AV77GXV3+1) ;
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "PaiTipoTraId", "", "Tipo de Trabajo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsDia", "", "Límite de horas normales por día", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsSem", "", "Límite de horas normales por semana", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsMaxDia", "", "Máximo de horas extras por día", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsMaxSem", "", "Máximo de horas extras por semana", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsMaxMes", "", "Máximo de horas extras por mes", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "ConveHsMaxAnu", "", "Máximo de horas extras por año", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXt_char7 = AV29UserCustomValue ;
      GXv_char8[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EsquemaHorasExtrasWWColumnsSelector", GXv_char8) ;
      esquemahorasextraswwexport.this.GXt_char7 = GXv_char8[0] ;
      AV29UserCustomValue = GXt_char7 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector6[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, GXv_SdtWWPColumnsSelector9) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector6[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("EsquemaHorasExtrasWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EsquemaHorasExtrasWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("EsquemaHorasExtrasWWGridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV78GXV4 = 1 ;
      while ( AV78GXV4 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV78GXV4));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV36TFPaiTipoTraId_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFPaiTipoTraId_Sels.fromJSonString(AV36TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSDIA") == 0 )
         {
            AV39TFConveHsDia = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV40TFConveHsDia_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSSEM") == 0 )
         {
            AV41TFConveHsSem = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV42TFConveHsSem_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXDIA") == 0 )
         {
            AV47TFConveHsMaxDia = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV48TFConveHsMaxDia_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXSEM") == 0 )
         {
            AV49TFConveHsMaxSem = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFConveHsMaxSem_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXMES") == 0 )
         {
            AV51TFConveHsMaxMes = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFConveHsMaxMes_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXANU") == 0 )
         {
            AV53TFConveHsMaxAnu = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV54TFConveHsMaxAnu_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICONVENIO") == 0 )
         {
            AV18CliConvenio = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV78GXV4 = (int)(AV78GXV4+1) ;
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
      this.aP0[0] = esquemahorasextraswwexport.this.AV12Filename;
      this.aP1[0] = esquemahorasextraswwexport.this.AV13ErrorMessage;
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
      AV60Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFPaiTipoTraId_Sel = "" ;
      AV39TFConveHsDia = DecimalUtil.ZERO ;
      AV40TFConveHsDia_To = DecimalUtil.ZERO ;
      AV41TFConveHsSem = DecimalUtil.ZERO ;
      AV42TFConveHsSem_To = DecimalUtil.ZERO ;
      AV47TFConveHsMaxDia = DecimalUtil.ZERO ;
      AV48TFConveHsMaxDia_To = DecimalUtil.ZERO ;
      AV49TFConveHsMaxSem = DecimalUtil.ZERO ;
      AV50TFConveHsMaxSem_To = DecimalUtil.ZERO ;
      AV51TFConveHsMaxMes = DecimalUtil.ZERO ;
      AV52TFConveHsMaxMes_To = DecimalUtil.ZERO ;
      AV53TFConveHsMaxAnu = DecimalUtil.ZERO ;
      AV54TFConveHsMaxAnu_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Esquemahorasextraswwds_2_tfconvehsdia = DecimalUtil.ZERO ;
      AV66Esquemahorasextraswwds_3_tfconvehsdia_to = DecimalUtil.ZERO ;
      AV67Esquemahorasextraswwds_4_tfconvehssem = DecimalUtil.ZERO ;
      AV68Esquemahorasextraswwds_5_tfconvehssem_to = DecimalUtil.ZERO ;
      AV69Esquemahorasextraswwds_6_tfconvehsmaxdia = DecimalUtil.ZERO ;
      AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to = DecimalUtil.ZERO ;
      AV71Esquemahorasextraswwds_8_tfconvehsmaxsem = DecimalUtil.ZERO ;
      AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to = DecimalUtil.ZERO ;
      AV73Esquemahorasextraswwds_10_tfconvehsmaxmes = DecimalUtil.ZERO ;
      AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to = DecimalUtil.ZERO ;
      AV75Esquemahorasextraswwds_12_tfconvehsmaxanu = DecimalUtil.ZERO ;
      AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      A1565CliConvenio = "" ;
      AV18CliConvenio = "" ;
      P02M12_A1565CliConvenio = new String[] {""} ;
      P02M12_A3CliCod = new int[1] ;
      P02M12_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M12_A1294PaiTipoTraId = new String[] {""} ;
      P02M12_A1564CliPaiConve = new short[1] ;
      AV29UserCustomValue = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector6 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFPaiTipoTraId_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemahorasextraswwexport__default(),
         new Object[] {
             new Object[] {
            P02M12_A1565CliConvenio, P02M12_A3CliCod, P02M12_A1394ConveHsMaxAnu, P02M12_A1393ConveHsMaxMes, P02M12_A1392ConveHsMaxSem, P02M12_A1391ConveHsMaxDia, P02M12_A1324ConveHsSem, P02M12_A1323ConveHsDia, P02M12_A1294PaiTipoTraId, P02M12_A1564CliPaiConve
            }
         }
      );
      AV60Pgmname = "EsquemaHorasExtrasWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "EsquemaHorasExtrasWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV19OrderedBy ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels_size ;
   private int AV56CliCod ;
   private int A3CliCod ;
   private int AV77GXV3 ;
   private int AV78GXV4 ;
   private long AV55i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV39TFConveHsDia ;
   private java.math.BigDecimal AV40TFConveHsDia_To ;
   private java.math.BigDecimal AV41TFConveHsSem ;
   private java.math.BigDecimal AV42TFConveHsSem_To ;
   private java.math.BigDecimal AV47TFConveHsMaxDia ;
   private java.math.BigDecimal AV48TFConveHsMaxDia_To ;
   private java.math.BigDecimal AV49TFConveHsMaxSem ;
   private java.math.BigDecimal AV50TFConveHsMaxSem_To ;
   private java.math.BigDecimal AV51TFConveHsMaxMes ;
   private java.math.BigDecimal AV52TFConveHsMaxMes_To ;
   private java.math.BigDecimal AV53TFConveHsMaxAnu ;
   private java.math.BigDecimal AV54TFConveHsMaxAnu_To ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private java.math.BigDecimal AV65Esquemahorasextraswwds_2_tfconvehsdia ;
   private java.math.BigDecimal AV66Esquemahorasextraswwds_3_tfconvehsdia_to ;
   private java.math.BigDecimal AV67Esquemahorasextraswwds_4_tfconvehssem ;
   private java.math.BigDecimal AV68Esquemahorasextraswwds_5_tfconvehssem_to ;
   private java.math.BigDecimal AV69Esquemahorasextraswwds_6_tfconvehsmaxdia ;
   private java.math.BigDecimal AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to ;
   private java.math.BigDecimal AV71Esquemahorasextraswwds_8_tfconvehsmaxsem ;
   private java.math.BigDecimal AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to ;
   private java.math.BigDecimal AV73Esquemahorasextraswwds_10_tfconvehsmaxmes ;
   private java.math.BigDecimal AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to ;
   private java.math.BigDecimal AV75Esquemahorasextraswwds_12_tfconvehsmaxanu ;
   private java.math.BigDecimal AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to ;
   private String AV60Pgmname ;
   private String AV38TFPaiTipoTraId_Sel ;
   private String A1294PaiTipoTraId ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV18CliConvenio ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20OrderedDsc ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV36TFPaiTipoTraId_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV37TFPaiTipoTraId_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02M12_A1565CliConvenio ;
   private int[] P02M12_A3CliCod ;
   private java.math.BigDecimal[] P02M12_A1394ConveHsMaxAnu ;
   private java.math.BigDecimal[] P02M12_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] P02M12_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] P02M12_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] P02M12_A1324ConveHsSem ;
   private java.math.BigDecimal[] P02M12_A1323ConveHsDia ;
   private String[] P02M12_A1294PaiTipoTraId ;
   private short[] P02M12_A1564CliPaiConve ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector6[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class esquemahorasextraswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02M12( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels ,
                                          int AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV65Esquemahorasextraswwds_2_tfconvehsdia ,
                                          java.math.BigDecimal AV66Esquemahorasextraswwds_3_tfconvehsdia_to ,
                                          java.math.BigDecimal AV67Esquemahorasextraswwds_4_tfconvehssem ,
                                          java.math.BigDecimal AV68Esquemahorasextraswwds_5_tfconvehssem_to ,
                                          java.math.BigDecimal AV69Esquemahorasextraswwds_6_tfconvehsmaxdia ,
                                          java.math.BigDecimal AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to ,
                                          java.math.BigDecimal AV71Esquemahorasextraswwds_8_tfconvehsmaxsem ,
                                          java.math.BigDecimal AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to ,
                                          java.math.BigDecimal AV73Esquemahorasextraswwds_10_tfconvehsmaxmes ,
                                          java.math.BigDecimal AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to ,
                                          java.math.BigDecimal AV75Esquemahorasextraswwds_12_tfconvehsmaxanu ,
                                          java.math.BigDecimal AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          java.math.BigDecimal A1324ConveHsSem ,
                                          java.math.BigDecimal A1391ConveHsMaxDia ,
                                          java.math.BigDecimal A1392ConveHsMaxSem ,
                                          java.math.BigDecimal A1393ConveHsMaxMes ,
                                          java.math.BigDecimal A1394ConveHsMaxAnu ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          String A1565CliConvenio ,
                                          String AV18CliConvenio ,
                                          int AV56CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliCod, ConveHsMaxAnu, ConveHsMaxMes, ConveHsMaxSem, ConveHsMaxDia, ConveHsSem, ConveHsDia, PaiTipoTraId, CliPaiConve FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Esquemahorasextraswwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Esquemahorasextraswwds_2_tfconvehsdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Esquemahorasextraswwds_3_tfconvehsdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Esquemahorasextraswwds_4_tfconvehssem)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Esquemahorasextraswwds_5_tfconvehssem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69Esquemahorasextraswwds_6_tfconvehsmaxdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Esquemahorasextraswwds_7_tfconvehsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Esquemahorasextraswwds_8_tfconvehsmaxsem)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Esquemahorasextraswwds_9_tfconvehsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Esquemahorasextraswwds_10_tfconvehsmaxmes)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Esquemahorasextraswwds_11_tfconvehsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Esquemahorasextraswwds_12_tfconvehsmaxanu)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Esquemahorasextraswwds_13_tfconvehsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV19OrderedBy == 1 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoTraId" ;
      }
      else if ( ( AV19OrderedBy == 1 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoTraId DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsDia" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsDia DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsSem" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsSem DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxDia" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxDia DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxSem" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxSem DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxMes" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxMes DESC" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxAnu" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxAnu DESC" ;
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
                  return conditional_P02M12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (java.math.BigDecimal)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 1);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               return;
      }
   }

}

