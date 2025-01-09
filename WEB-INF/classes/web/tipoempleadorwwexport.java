package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipoempleadorwwexport extends GXProcedure
{
   public tipoempleadorwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoempleadorwwexport.class ), "" );
   }

   public tipoempleadorwwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      tipoempleadorwwexport.this.aP1 = new String[] {""};
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
      tipoempleadorwwexport.this.aP0 = aP0;
      tipoempleadorwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoEmpleador", GXv_boolean2) ;
      tipoempleadorwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "TipoEmpleadorWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV40TFTipEmpleCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipoempleadorwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV55GXV1 = 1 ;
         while ( AV55GXV1 <= AV40TFTipEmpleCod_Sels.size() )
         {
            AV41TFTipEmpleCod_Sel = (String)AV40TFTipEmpleCod_Sels.elementAt(-1+AV55GXV1) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFTipEmpleCod_Sel, GXv_char7) ;
            tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV55GXV1 = (int)(AV55GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFTipEmpleCod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            tipoempleadorwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFTipEmpleCod, GXv_char7) ;
            tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFTipEmpleDescri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripcion", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipoempleadorwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV56GXV2 = 1 ;
         while ( AV56GXV2 <= AV44TFTipEmpleDescri_Sels.size() )
         {
            AV45TFTipEmpleDescri_Sel = (String)AV44TFTipEmpleDescri_Sels.elementAt(-1+AV56GXV2) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFTipEmpleDescri_Sel, GXv_char7) ;
            tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV56GXV2 = (int)(AV56GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFTipEmpleDescri)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripcion", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            tipoempleadorwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFTipEmpleDescri, GXv_char7) ;
            tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV47TFTipEmpleDefIns_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Inciso relacionado al tipo de empleador", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipoempleadorwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV57GXV3 = 1 ;
         while ( AV57GXV3 <= AV47TFTipEmpleDefIns_Sels.size() )
         {
            AV48TFTipEmpleDefIns_Sel = (String)AV47TFTipEmpleDefIns_Sels.elementAt(-1+AV57GXV3) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaininciso.getDescription(httpContext,(String)AV48TFTipEmpleDefIns_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV57GXV3 = (int)(AV57GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV35VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("TipoEmpleadorWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV20Session.getValue("TipoEmpleadorWWColumnsSelector") ;
         AV27ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV58GXV4 = 1 ;
      while ( AV58GXV4 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV58GXV4));
         if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setColor( 11 );
            AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
         }
         AV58GXV4 = (int)(AV58GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV60Tipoempleadorwwds_1_tftipemplecod = AV39TFTipEmpleCod ;
      AV61Tipoempleadorwwds_2_tftipemplecod_sels = AV40TFTipEmpleCod_Sels ;
      AV62Tipoempleadorwwds_3_tftipempledescri = AV43TFTipEmpleDescri ;
      AV63Tipoempleadorwwds_4_tftipempledescri_sels = AV44TFTipEmpleDescri_Sels ;
      AV64Tipoempleadorwwds_5_tftipempledefins_sels = AV47TFTipEmpleDefIns_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A45TipEmpleCod ,
                                           AV61Tipoempleadorwwds_2_tftipemplecod_sels ,
                                           A339TipEmpleDescri ,
                                           AV63Tipoempleadorwwds_4_tftipempledescri_sels ,
                                           A530TipEmpleDefIns ,
                                           AV64Tipoempleadorwwds_5_tftipempledefins_sels ,
                                           Integer.valueOf(AV61Tipoempleadorwwds_2_tftipemplecod_sels.size()) ,
                                           AV60Tipoempleadorwwds_1_tftipemplecod ,
                                           Integer.valueOf(AV63Tipoempleadorwwds_4_tftipempledescri_sels.size()) ,
                                           AV62Tipoempleadorwwds_3_tftipempledescri ,
                                           Integer.valueOf(AV64Tipoempleadorwwds_5_tftipempledefins_sels.size()) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV60Tipoempleadorwwds_1_tftipemplecod = GXutil.padr( GXutil.rtrim( AV60Tipoempleadorwwds_1_tftipemplecod), 4, "%") ;
      lV62Tipoempleadorwwds_3_tftipempledescri = GXutil.concat( GXutil.rtrim( AV62Tipoempleadorwwds_3_tftipempledescri), "%", "") ;
      /* Using cursor P02FH2 */
      pr_default.execute(0, new Object[] {lV60Tipoempleadorwwds_1_tftipemplecod, lV62Tipoempleadorwwds_3_tftipempledescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A530TipEmpleDefIns = P02FH2_A530TipEmpleDefIns[0] ;
         A339TipEmpleDescri = P02FH2_A339TipEmpleDescri[0] ;
         A45TipEmpleCod = P02FH2_A45TipEmpleCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV35VisibleColumnCount = 0 ;
         AV65GXV5 = 1 ;
         while ( AV65GXV5 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV5));
            if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipEmpleCod") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A45TipEmpleCod, GXv_char7) ;
                  tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipEmpleDescri") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A339TipEmpleDescri, GXv_char7) ;
                  tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipEmpleDefIns") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaininciso.getDescription(httpContext,(String)A530TipEmpleDefIns), "") );
               }
               AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
            }
            AV65GXV5 = (int)(AV65GXV5+1) ;
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
      AV27ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipEmpleCod", "", "Tipo de Empleador según decreto 814/01 art. 2", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipEmpleDescri", "", "Descripcion", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipEmpleDefIns", "", "Inciso relacionado al tipo de empleador", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV66Nucleoes.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( ( ( AV66Nucleoes.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "TipoEmpleadorWWColumnsSelector", GXv_char7) ;
      tipoempleadorwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV28ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV28ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("TipoEmpleadorWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoEmpleadorWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("TipoEmpleadorWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV67GXV6 = 1 ;
      while ( AV67GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV67GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLECOD") == 0 )
         {
            AV39TFTipEmpleCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLECOD_SEL") == 0 )
         {
            AV38TFTipEmpleCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFTipEmpleCod_Sels.fromJSonString(AV38TFTipEmpleCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI") == 0 )
         {
            AV43TFTipEmpleDescri = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI_SEL") == 0 )
         {
            AV42TFTipEmpleDescri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFTipEmpleDescri_Sels.fromJSonString(AV42TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDEFINS_SEL") == 0 )
         {
            AV46TFTipEmpleDefIns_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFTipEmpleDefIns_Sels.fromJSonString(AV46TFTipEmpleDefIns_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV67GXV6 = (int)(AV67GXV6+1) ;
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
      this.aP0[0] = tipoempleadorwwexport.this.AV12Filename;
      this.aP1[0] = tipoempleadorwwexport.this.AV13ErrorMessage;
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
      AV54Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV40TFTipEmpleCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFTipEmpleCod_Sel = "" ;
      AV39TFTipEmpleCod = "" ;
      AV44TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFTipEmpleDescri_Sel = "" ;
      AV43TFTipEmpleDescri = "" ;
      AV47TFTipEmpleDefIns_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV48TFTipEmpleDefIns_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV27ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A45TipEmpleCod = "" ;
      A339TipEmpleDescri = "" ;
      A530TipEmpleDefIns = "" ;
      AV60Tipoempleadorwwds_1_tftipemplecod = "" ;
      AV61Tipoempleadorwwds_2_tftipemplecod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Tipoempleadorwwds_3_tftipempledescri = "" ;
      AV63Tipoempleadorwwds_4_tftipempledescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Tipoempleadorwwds_5_tftipempledefins_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV60Tipoempleadorwwds_1_tftipemplecod = "" ;
      lV62Tipoempleadorwwds_3_tftipempledescri = "" ;
      P02FH2_A530TipEmpleDefIns = new String[] {""} ;
      P02FH2_A339TipEmpleDescri = new String[] {""} ;
      P02FH2_A45TipEmpleCod = new String[] {""} ;
      AV66Nucleoes = DecimalUtil.ZERO ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV28ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38TFTipEmpleCod_SelsJson = "" ;
      AV42TFTipEmpleDescri_SelsJson = "" ;
      AV46TFTipEmpleDefIns_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipoempleadorwwexport__default(),
         new Object[] {
             new Object[] {
            P02FH2_A530TipEmpleDefIns, P02FH2_A339TipEmpleDescri, P02FH2_A45TipEmpleCod
            }
         }
      );
      AV54Pgmname = "TipoEmpleadorWWExport" ;
      /* GeneXus formulas. */
      AV54Pgmname = "TipoEmpleadorWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV55GXV1 ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int AV58GXV4 ;
   private int AV61Tipoempleadorwwds_2_tftipemplecod_sels_size ;
   private int AV63Tipoempleadorwwds_4_tftipempledescri_sels_size ;
   private int AV64Tipoempleadorwwds_5_tftipempledefins_sels_size ;
   private int AV65GXV5 ;
   private int AV67GXV6 ;
   private long AV49i ;
   private long AV35VisibleColumnCount ;
   private java.math.BigDecimal AV66Nucleoes ;
   private String AV54Pgmname ;
   private String AV41TFTipEmpleCod_Sel ;
   private String AV39TFTipEmpleCod ;
   private String AV48TFTipEmpleDefIns_Sel ;
   private String A45TipEmpleCod ;
   private String A530TipEmpleDefIns ;
   private String AV60Tipoempleadorwwds_1_tftipemplecod ;
   private String scmdbuf ;
   private String lV60Tipoempleadorwwds_1_tftipemplecod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV30ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV38TFTipEmpleCod_SelsJson ;
   private String AV42TFTipEmpleDescri_SelsJson ;
   private String AV46TFTipEmpleDefIns_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV45TFTipEmpleDescri_Sel ;
   private String AV43TFTipEmpleDescri ;
   private String A339TipEmpleDescri ;
   private String AV62Tipoempleadorwwds_3_tftipempledescri ;
   private String lV62Tipoempleadorwwds_3_tftipempledescri ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV40TFTipEmpleCod_Sels ;
   private GXSimpleCollection<String> AV47TFTipEmpleDefIns_Sels ;
   private GXSimpleCollection<String> AV44TFTipEmpleDescri_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FH2_A530TipEmpleDefIns ;
   private String[] P02FH2_A339TipEmpleDescri ;
   private String[] P02FH2_A45TipEmpleCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV61Tipoempleadorwwds_2_tftipemplecod_sels ;
   private GXSimpleCollection<String> AV64Tipoempleadorwwds_5_tftipempledefins_sels ;
   private GXSimpleCollection<String> AV63Tipoempleadorwwds_4_tftipempledescri_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV29ColumnsSelector_Column ;
}

final  class tipoempleadorwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FH2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A45TipEmpleCod ,
                                          GXSimpleCollection<String> AV61Tipoempleadorwwds_2_tftipemplecod_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV63Tipoempleadorwwds_4_tftipempledescri_sels ,
                                          String A530TipEmpleDefIns ,
                                          GXSimpleCollection<String> AV64Tipoempleadorwwds_5_tftipempledefins_sels ,
                                          int AV61Tipoempleadorwwds_2_tftipemplecod_sels_size ,
                                          String AV60Tipoempleadorwwds_1_tftipemplecod ,
                                          int AV63Tipoempleadorwwds_4_tftipempledescri_sels_size ,
                                          String AV62Tipoempleadorwwds_3_tftipempledescri ,
                                          int AV64Tipoempleadorwwds_5_tftipempledefins_sels_size ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[2];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT TipEmpleDefIns, TipEmpleDescri, TipEmpleCod FROM TipoEmpleador" ;
      if ( ( AV61Tipoempleadorwwds_2_tftipemplecod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Tipoempleadorwwds_1_tftipemplecod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleCod) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV61Tipoempleadorwwds_2_tftipemplecod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Tipoempleadorwwds_2_tftipemplecod_sels, "TipEmpleCod IN (", ")")+")");
      }
      if ( ( AV63Tipoempleadorwwds_4_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Tipoempleadorwwds_3_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV63Tipoempleadorwwds_4_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Tipoempleadorwwds_4_tftipempledescri_sels, "TipEmpleDescri IN (", ")")+")");
      }
      if ( AV64Tipoempleadorwwds_5_tftipempledefins_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Tipoempleadorwwds_5_tftipempledefins_sels, "TipEmpleDefIns IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipEmpleCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipEmpleCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipEmpleDescri" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipEmpleDescri DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipEmpleDefIns" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipEmpleDefIns DESC" ;
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
                  return conditional_P02FH2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Boolean) dynConstraints[12]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FH2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
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
                  stmt.setString(sIdx, (String)parms[2], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

