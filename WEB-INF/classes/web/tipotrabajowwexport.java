package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipotrabajowwexport extends GXProcedure
{
   public tipotrabajowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipotrabajowwexport.class ), "" );
   }

   public tipotrabajowwexport( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      tipotrabajowwexport.this.aP1 = new String[] {""};
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
      tipotrabajowwexport.this.aP0 = aP0;
      tipotrabajowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoTrabajo", GXv_boolean2) ;
      tipotrabajowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "TipoTrabajoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFTipoTraId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV42i = 1 ;
         AV49GXV1 = 1 ;
         while ( AV49GXV1 <= AV36TFTipoTraId_Sels.size() )
         {
            AV37TFTipoTraId_Sel = (String)AV36TFTipoTraId_Sels.elementAt(-1+AV49GXV1) ;
            if ( AV42i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV37TFTipoTraId_Sel), "") );
            AV42i = (long)(AV42i+1) ;
            AV49GXV1 = (int)(AV49GXV1+1) ;
         }
      }
      if ( ! ( ( AV40TFTipoTraNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV42i = 1 ;
         AV50GXV2 = 1 ;
         while ( AV50GXV2 <= AV40TFTipoTraNom_Sels.size() )
         {
            AV41TFTipoTraNom_Sel = (String)AV40TFTipoTraNom_Sels.elementAt(-1+AV50GXV2) ;
            if ( AV42i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFTipoTraNom_Sel, GXv_char7) ;
            tipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV42i = (long)(AV42i+1) ;
            AV50GXV2 = (int)(AV50GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFTipoTraNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            tipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFTipoTraNom, GXv_char7) ;
            tipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("TipoTrabajoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("TipoTrabajoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV51GXV3 = 1 ;
      while ( AV51GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV51GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV51GXV3 = (int)(AV51GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV53Tipotrabajowwds_1_tftipotraid_sels = AV36TFTipoTraId_Sels ;
      AV54Tipotrabajowwds_2_tftipotranom = AV39TFTipoTraNom ;
      AV55Tipotrabajowwds_3_tftipotranom_sels = AV40TFTipoTraNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1292TipoTraId ,
                                           AV53Tipotrabajowwds_1_tftipotraid_sels ,
                                           A1293TipoTraNom ,
                                           AV55Tipotrabajowwds_3_tftipotranom_sels ,
                                           Integer.valueOf(AV53Tipotrabajowwds_1_tftipotraid_sels.size()) ,
                                           Integer.valueOf(AV55Tipotrabajowwds_3_tftipotranom_sels.size()) ,
                                           AV54Tipotrabajowwds_2_tftipotranom ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV54Tipotrabajowwds_2_tftipotranom = GXutil.concat( GXutil.rtrim( AV54Tipotrabajowwds_2_tftipotranom), "%", "") ;
      /* Using cursor P01JT2 */
      pr_default.execute(0, new Object[] {lV54Tipotrabajowwds_2_tftipotranom});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1293TipoTraNom = P01JT2_A1293TipoTraNom[0] ;
         A1292TipoTraId = P01JT2_A1292TipoTraId[0] ;
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
         AV56GXV4 = 1 ;
         while ( AV56GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV56GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoTraId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1292TipoTraId), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoTraNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1293TipoTraNom, GXv_char7) ;
                  tipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV56GXV4 = (int)(AV56GXV4+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoTraId", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoTraNom", "", "Descripción", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "TipoTrabajoWWColumnsSelector", GXv_char7) ;
      tipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("TipoTrabajoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoTrabajoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("TipoTrabajoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV57GXV5 = 1 ;
      while ( AV57GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRAID_SEL") == 0 )
         {
            AV35TFTipoTraId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFTipoTraId_Sels.fromJSonString(AV35TFTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRANOM") == 0 )
         {
            AV39TFTipoTraNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRANOM_SEL") == 0 )
         {
            AV38TFTipoTraNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFTipoTraNom_Sels.fromJSonString(AV38TFTipoTraNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV45MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV57GXV5 = (int)(AV57GXV5+1) ;
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
      this.aP0[0] = tipotrabajowwexport.this.AV12Filename;
      this.aP1[0] = tipotrabajowwexport.this.AV13ErrorMessage;
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
      AV48Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFTipoTraId_Sel = "" ;
      AV40TFTipoTraNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFTipoTraNom_Sel = "" ;
      AV39TFTipoTraNom = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1292TipoTraId = "" ;
      A1293TipoTraNom = "" ;
      AV53Tipotrabajowwds_1_tftipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Tipotrabajowwds_2_tftipotranom = "" ;
      AV55Tipotrabajowwds_3_tftipotranom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Tipotrabajowwds_2_tftipotranom = "" ;
      P01JT2_A1293TipoTraNom = new String[] {""} ;
      P01JT2_A1292TipoTraId = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFTipoTraId_SelsJson = "" ;
      AV38TFTipoTraNom_SelsJson = "" ;
      AV45MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipotrabajowwexport__default(),
         new Object[] {
             new Object[] {
            P01JT2_A1293TipoTraNom, P01JT2_A1292TipoTraId
            }
         }
      );
      AV48Pgmname = "TipoTrabajoWWExport" ;
      /* GeneXus formulas. */
      AV48Pgmname = "TipoTrabajoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV49GXV1 ;
   private int AV50GXV2 ;
   private int AV51GXV3 ;
   private int AV53Tipotrabajowwds_1_tftipotraid_sels_size ;
   private int AV55Tipotrabajowwds_3_tftipotranom_sels_size ;
   private int AV56GXV4 ;
   private int AV57GXV5 ;
   private long AV42i ;
   private long AV32VisibleColumnCount ;
   private String AV48Pgmname ;
   private String AV37TFTipoTraId_Sel ;
   private String A1292TipoTraId ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFTipoTraId_SelsJson ;
   private String AV38TFTipoTraNom_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV41TFTipoTraNom_Sel ;
   private String AV39TFTipoTraNom ;
   private String A1293TipoTraNom ;
   private String AV54Tipotrabajowwds_2_tftipotranom ;
   private String lV54Tipotrabajowwds_2_tftipotranom ;
   private String AV45MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFTipoTraId_Sels ;
   private GXSimpleCollection<String> AV40TFTipoTraNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JT2_A1293TipoTraNom ;
   private String[] P01JT2_A1292TipoTraId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV53Tipotrabajowwds_1_tftipotraid_sels ;
   private GXSimpleCollection<String> AV55Tipotrabajowwds_3_tftipotranom_sels ;
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

final  class tipotrabajowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1292TipoTraId ,
                                          GXSimpleCollection<String> AV53Tipotrabajowwds_1_tftipotraid_sels ,
                                          String A1293TipoTraNom ,
                                          GXSimpleCollection<String> AV55Tipotrabajowwds_3_tftipotranom_sels ,
                                          int AV53Tipotrabajowwds_1_tftipotraid_sels_size ,
                                          int AV55Tipotrabajowwds_3_tftipotranom_sels_size ,
                                          String AV54Tipotrabajowwds_2_tftipotranom ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[1];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( AV53Tipotrabajowwds_1_tftipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Tipotrabajowwds_1_tftipotraid_sels, "TipoTraId IN (", ")")+")");
      }
      if ( ( AV55Tipotrabajowwds_3_tftipotranom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Tipotrabajowwds_2_tftipotranom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV55Tipotrabajowwds_3_tftipotranom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Tipotrabajowwds_3_tftipotranom_sels, "TipoTraNom IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoTraId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoTraId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoTraNom" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoTraNom DESC" ;
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
                  return conditional_P01JT2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 30);
               }
               return;
      }
   }

}

