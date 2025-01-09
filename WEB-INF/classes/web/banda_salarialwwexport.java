package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class banda_salarialwwexport extends GXProcedure
{
   public banda_salarialwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( banda_salarialwwexport.class ), "" );
   }

   public banda_salarialwwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      banda_salarialwwexport.this.aP1 = new String[] {""};
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
      banda_salarialwwexport.this.aP0 = aP0;
      banda_salarialwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWbanda_salarial", GXv_boolean2) ;
      banda_salarialwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "banda_salarialWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFBanSaNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV55GXV1 = 1 ;
         while ( AV55GXV1 <= AV37TFBanSaNombre_Sels.size() )
         {
            AV38TFBanSaNombre_Sel = (String)AV37TFBanSaNombre_Sels.elementAt(-1+AV55GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFBanSaNombre_Sel, GXv_char7) ;
            banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV55GXV1 = (int)(AV55GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFBanSaNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFBanSaNombre, GXv_char7) ;
            banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFBanSalDescripcion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV56GXV2 = 1 ;
         while ( AV56GXV2 <= AV41TFBanSalDescripcion_Sels.size() )
         {
            AV42TFBanSalDescripcion_Sel = (String)AV41TFBanSalDescripcion_Sels.elementAt(-1+AV56GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV42TFBanSalDescripcion_Sel, 1, 1000), GXv_char7) ;
            banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV56GXV2 = (int)(AV56GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFBanSalDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV40TFBanSalDescripcion, 1, 1000), GXv_char7) ;
            banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFBanSalFrecPag_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV57GXV3 = 1 ;
         while ( AV57GXV3 <= AV44TFBanSalFrecPag_Sels.size() )
         {
            AV45TFBanSalFrecPag_Sel = ((Number) AV44TFBanSalFrecPag_Sels.elementAt(-1+AV57GXV3)).byteValue() ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV45TFBanSalFrecPag_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV57GXV3 = (int)(AV57GXV3+1) ;
         }
      }
      if ( ! ( ( AV47TFBanSalTipoTarifa_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de tarifa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         banda_salarialwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV58GXV4 = 1 ;
         while ( AV58GXV4 <= AV47TFBanSalTipoTarifa_Sels.size() )
         {
            AV48TFBanSalTipoTarifa_Sel = (String)AV47TFBanSalTipoTarifa_Sels.elementAt(-1+AV58GXV4) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV48TFBanSalTipoTarifa_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV58GXV4 = (int)(AV58GXV4+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("banda_salarialWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("banda_salarialWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV59GXV5 = 1 ;
      while ( AV59GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV59GXV5 = (int)(AV59GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV61Banda_salarialwwds_1_tfbansanombre = AV36TFBanSaNombre ;
      AV62Banda_salarialwwds_2_tfbansanombre_sels = AV37TFBanSaNombre_Sels ;
      AV63Banda_salarialwwds_3_tfbansaldescripcion = AV40TFBanSalDescripcion ;
      AV64Banda_salarialwwds_4_tfbansaldescripcion_sels = AV41TFBanSalDescripcion_Sels ;
      AV65Banda_salarialwwds_5_tfbansalfrecpag_sels = AV44TFBanSalFrecPag_Sels ;
      AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels = AV47TFBanSalTipoTarifa_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2419BanSaNombre ,
                                           AV62Banda_salarialwwds_2_tfbansanombre_sels ,
                                           A2420BanSalDescripcion ,
                                           AV64Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                           Byte.valueOf(A2421BanSalFrecPag) ,
                                           AV65Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                           A2422BanSalTipoTarifa ,
                                           AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                           Integer.valueOf(AV62Banda_salarialwwds_2_tfbansanombre_sels.size()) ,
                                           AV61Banda_salarialwwds_1_tfbansanombre ,
                                           Integer.valueOf(AV64Banda_salarialwwds_4_tfbansaldescripcion_sels.size()) ,
                                           AV63Banda_salarialwwds_3_tfbansaldescripcion ,
                                           Integer.valueOf(AV65Banda_salarialwwds_5_tfbansalfrecpag_sels.size()) ,
                                           Integer.valueOf(AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels.size()) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV50CliCod) ,
                                           Short.valueOf(AV51EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV61Banda_salarialwwds_1_tfbansanombre = GXutil.concat( GXutil.rtrim( AV61Banda_salarialwwds_1_tfbansanombre), "%", "") ;
      lV63Banda_salarialwwds_3_tfbansaldescripcion = GXutil.concat( GXutil.rtrim( AV63Banda_salarialwwds_3_tfbansaldescripcion), "%", "") ;
      /* Using cursor P02LK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV50CliCod), Short.valueOf(AV51EmpCod), lV61Banda_salarialwwds_1_tfbansanombre, lV63Banda_salarialwwds_3_tfbansaldescripcion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02LK2_A1EmpCod[0] ;
         A3CliCod = P02LK2_A3CliCod[0] ;
         A2422BanSalTipoTarifa = P02LK2_A2422BanSalTipoTarifa[0] ;
         A2421BanSalFrecPag = P02LK2_A2421BanSalFrecPag[0] ;
         A2420BanSalDescripcion = P02LK2_A2420BanSalDescripcion[0] ;
         A2419BanSaNombre = P02LK2_A2419BanSaNombre[0] ;
         A2418BanSalCod = P02LK2_A2418BanSalCod[0] ;
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
         AV67GXV6 = 1 ;
         while ( AV67GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV67GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "BanSaNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2419BanSaNombre, GXv_char7) ;
                  banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "BanSalDescripcion") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A2420BanSalDescripcion, 1, 1000), GXv_char7) ;
                  banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "BanSalFrecPag") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A2421BanSalFrecPag), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "BanSalTipoTarifa") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)A2422BanSalTipoTarifa), "") );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV67GXV6 = (int)(AV67GXV6+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "BanSaNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "BanSalDescripcion", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "BanSalFrecPag", "", "Frecuencia de pago", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "BanSalTipoTarifa", "", "Tipo de tarifa", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "banda_salarialWWColumnsSelector", GXv_char7) ;
      banda_salarialwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("banda_salarialWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "banda_salarialWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("banda_salarialWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV68GXV7 = 1 ;
      while ( AV68GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV68GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSANOMBRE") == 0 )
         {
            AV36TFBanSaNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSANOMBRE_SEL") == 0 )
         {
            AV35TFBanSaNombre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFBanSaNombre_Sels.fromJSonString(AV35TFBanSaNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALDESCRIPCION") == 0 )
         {
            AV40TFBanSalDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALDESCRIPCION_SEL") == 0 )
         {
            AV39TFBanSalDescripcion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFBanSalDescripcion_Sels.fromJSonString(AV39TFBanSalDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALFRECPAG_SEL") == 0 )
         {
            AV43TFBanSalFrecPag_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFBanSalFrecPag_Sels.fromJSonString(AV43TFBanSalFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFBANSALTIPOTARIFA_SEL") == 0 )
         {
            AV46TFBanSalTipoTarifa_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFBanSalTipoTarifa_Sels.fromJSonString(AV46TFBanSalTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV68GXV7 = (int)(AV68GXV7+1) ;
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
      this.aP0[0] = banda_salarialwwexport.this.AV12Filename;
      this.aP1[0] = banda_salarialwwexport.this.AV13ErrorMessage;
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
      AV37TFBanSaNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFBanSaNombre_Sel = "" ;
      AV36TFBanSaNombre = "" ;
      AV41TFBanSalDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFBanSalDescripcion_Sel = "" ;
      AV40TFBanSalDescripcion = "" ;
      AV44TFBanSalFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV47TFBanSalTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV48TFBanSalTipoTarifa_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A2419BanSaNombre = "" ;
      A2420BanSalDescripcion = "" ;
      A2422BanSalTipoTarifa = "" ;
      AV61Banda_salarialwwds_1_tfbansanombre = "" ;
      AV62Banda_salarialwwds_2_tfbansanombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Banda_salarialwwds_3_tfbansaldescripcion = "" ;
      AV64Banda_salarialwwds_4_tfbansaldescripcion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Banda_salarialwwds_5_tfbansalfrecpag_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Banda_salarialwwds_1_tfbansanombre = "" ;
      lV63Banda_salarialwwds_3_tfbansaldescripcion = "" ;
      P02LK2_A1EmpCod = new short[1] ;
      P02LK2_A3CliCod = new int[1] ;
      P02LK2_A2422BanSalTipoTarifa = new String[] {""} ;
      P02LK2_A2421BanSalFrecPag = new byte[1] ;
      P02LK2_A2420BanSalDescripcion = new String[] {""} ;
      P02LK2_A2419BanSaNombre = new String[] {""} ;
      P02LK2_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      A2418BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFBanSaNombre_SelsJson = "" ;
      AV39TFBanSalDescripcion_SelsJson = "" ;
      AV43TFBanSalFrecPag_SelsJson = "" ;
      AV46TFBanSalTipoTarifa_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.banda_salarialwwexport__default(),
         new Object[] {
             new Object[] {
            P02LK2_A1EmpCod, P02LK2_A3CliCod, P02LK2_A2422BanSalTipoTarifa, P02LK2_A2421BanSalFrecPag, P02LK2_A2420BanSalDescripcion, P02LK2_A2419BanSaNombre, P02LK2_A2418BanSalCod
            }
         }
      );
      AV54Pgmname = "banda_salarialWWExport" ;
      /* GeneXus formulas. */
      AV54Pgmname = "banda_salarialWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV45TFBanSalFrecPag_Sel ;
   private byte A2421BanSalFrecPag ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short AV51EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV55GXV1 ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int AV58GXV4 ;
   private int AV59GXV5 ;
   private int AV62Banda_salarialwwds_2_tfbansanombre_sels_size ;
   private int AV64Banda_salarialwwds_4_tfbansaldescripcion_sels_size ;
   private int AV65Banda_salarialwwds_5_tfbansalfrecpag_sels_size ;
   private int AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels_size ;
   private int AV50CliCod ;
   private int A3CliCod ;
   private int AV67GXV6 ;
   private int AV68GXV7 ;
   private long AV49i ;
   private long AV32VisibleColumnCount ;
   private String AV54Pgmname ;
   private String AV48TFBanSalTipoTarifa_Sel ;
   private String A2422BanSalTipoTarifa ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String A2420BanSalDescripcion ;
   private String AV28UserCustomValue ;
   private String AV35TFBanSaNombre_SelsJson ;
   private String AV39TFBanSalDescripcion_SelsJson ;
   private String AV43TFBanSalFrecPag_SelsJson ;
   private String AV46TFBanSalTipoTarifa_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFBanSaNombre_Sel ;
   private String AV36TFBanSaNombre ;
   private String AV42TFBanSalDescripcion_Sel ;
   private String AV40TFBanSalDescripcion ;
   private String A2419BanSaNombre ;
   private String AV61Banda_salarialwwds_1_tfbansanombre ;
   private String AV63Banda_salarialwwds_3_tfbansaldescripcion ;
   private String lV61Banda_salarialwwds_1_tfbansanombre ;
   private String lV63Banda_salarialwwds_3_tfbansaldescripcion ;
   private String AV17MenuOpcCod ;
   private java.util.UUID A2418BanSalCod ;
   private GXSimpleCollection<Byte> AV44TFBanSalFrecPag_Sels ;
   private GXSimpleCollection<Byte> AV65Banda_salarialwwds_5_tfbansalfrecpag_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV47TFBanSalTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV37TFBanSaNombre_Sels ;
   private GXSimpleCollection<String> AV41TFBanSalDescripcion_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02LK2_A1EmpCod ;
   private int[] P02LK2_A3CliCod ;
   private String[] P02LK2_A2422BanSalTipoTarifa ;
   private byte[] P02LK2_A2421BanSalFrecPag ;
   private String[] P02LK2_A2420BanSalDescripcion ;
   private String[] P02LK2_A2419BanSaNombre ;
   private java.util.UUID[] P02LK2_A2418BanSalCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels ;
   private GXSimpleCollection<String> AV62Banda_salarialwwds_2_tfbansanombre_sels ;
   private GXSimpleCollection<String> AV64Banda_salarialwwds_4_tfbansaldescripcion_sels ;
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

final  class banda_salarialwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02LK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2419BanSaNombre ,
                                          GXSimpleCollection<String> AV62Banda_salarialwwds_2_tfbansanombre_sels ,
                                          String A2420BanSalDescripcion ,
                                          GXSimpleCollection<String> AV64Banda_salarialwwds_4_tfbansaldescripcion_sels ,
                                          byte A2421BanSalFrecPag ,
                                          GXSimpleCollection<Byte> AV65Banda_salarialwwds_5_tfbansalfrecpag_sels ,
                                          String A2422BanSalTipoTarifa ,
                                          GXSimpleCollection<String> AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels ,
                                          int AV62Banda_salarialwwds_2_tfbansanombre_sels_size ,
                                          String AV61Banda_salarialwwds_1_tfbansanombre ,
                                          int AV64Banda_salarialwwds_4_tfbansaldescripcion_sels_size ,
                                          String AV63Banda_salarialwwds_3_tfbansaldescripcion ,
                                          int AV65Banda_salarialwwds_5_tfbansalfrecpag_sels_size ,
                                          int AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels_size ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV50CliCod ,
                                          short AV51EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[4];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, BanSalTipoTarifa, BanSalFrecPag, BanSalDescripcion, BanSaNombre, BanSalCod FROM banda_salarial" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ( AV62Banda_salarialwwds_2_tfbansanombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Banda_salarialwwds_1_tfbansanombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSaNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV62Banda_salarialwwds_2_tfbansanombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Banda_salarialwwds_2_tfbansanombre_sels, "BanSaNombre IN (", ")")+")");
      }
      if ( ( AV64Banda_salarialwwds_4_tfbansaldescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Banda_salarialwwds_3_tfbansaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(BanSalDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV64Banda_salarialwwds_4_tfbansaldescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Banda_salarialwwds_4_tfbansaldescripcion_sels, "BanSalDescripcion IN (", ")")+")");
      }
      if ( AV65Banda_salarialwwds_5_tfbansalfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Banda_salarialwwds_5_tfbansalfrecpag_sels, "BanSalFrecPag IN (", ")")+")");
      }
      if ( AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Banda_salarialwwds_6_tfbansaltipotarifa_sels, "BanSalTipoTarifa IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY BanSaNombre" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY BanSaNombre DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY BanSalDescripcion" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY BanSalDescripcion DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY BanSalFrecPag" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY BanSalFrecPag DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY BanSalTipoTarifa" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY BanSalTipoTarifa DESC" ;
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
                  return conditional_P02LK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.UUID[]) buf[6])[0] = rslt.getGUID(7);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 200);
               }
               return;
      }
   }

}

