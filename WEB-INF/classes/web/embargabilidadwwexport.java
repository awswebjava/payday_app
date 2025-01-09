package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class embargabilidadwwexport extends GXProcedure
{
   public embargabilidadwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( embargabilidadwwexport.class ), "" );
   }

   public embargabilidadwwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      embargabilidadwwexport.this.aP1 = new String[] {""};
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
      embargabilidadwwexport.this.aP0 = aP0;
      embargabilidadwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV44CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      embargabilidadwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV44CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad", GXv_boolean4) ;
      embargabilidadwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV50Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
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
      AV12Filename = "embargabilidadWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFEmbargaDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         embargabilidadwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV51GXV1 = 1 ;
         while ( AV51GXV1 <= AV37TFEmbargaDescrip_Sels.size() )
         {
            AV38TFEmbargaDescrip_Sel = (String)AV37TFEmbargaDescrip_Sels.elementAt(-1+AV51GXV1) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEmbargaDescrip_Sel, GXv_char9) ;
            embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV51GXV1 = (int)(AV51GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFEmbargaDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            embargabilidadwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFEmbargaDescrip, GXv_char9) ;
            embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFEmbargaExplicacion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Explicacion", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         embargabilidadwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV52GXV2 = 1 ;
         while ( AV52GXV2 <= AV41TFEmbargaExplicacion_Sels.size() )
         {
            AV42TFEmbargaExplicacion_Sel = (String)AV41TFEmbargaExplicacion_Sels.elementAt(-1+AV52GXV2) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV42TFEmbargaExplicacion_Sel, 1, 1000), GXv_char9) ;
            embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV52GXV2 = (int)(AV52GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFEmbargaExplicacion)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Explicacion", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            embargabilidadwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV40TFEmbargaExplicacion, 1, 1000), GXv_char9) ;
            embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("embargabilidadWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("embargabilidadWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "EmbargaSec" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Embargabilidad predefinida", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "EmbarPaiCod" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Pai Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV53GXV3 = 1 ;
      while ( AV53GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV53GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV53GXV3 = (int)(AV53GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV55Embargabilidadwwds_1_tfembargadescrip = AV36TFEmbargaDescrip ;
      AV56Embargabilidadwwds_2_tfembargadescrip_sels = AV37TFEmbargaDescrip_Sels ;
      AV57Embargabilidadwwds_3_tfembargaexplicacion = AV40TFEmbargaExplicacion ;
      AV58Embargabilidadwwds_4_tfembargaexplicacion_sels = AV41TFEmbargaExplicacion_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1162EmbargaDescrip ,
                                           AV56Embargabilidadwwds_2_tfembargadescrip_sels ,
                                           A1203EmbargaExplicacion ,
                                           AV58Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                           Integer.valueOf(AV56Embargabilidadwwds_2_tfembargadescrip_sels.size()) ,
                                           AV55Embargabilidadwwds_1_tfembargadescrip ,
                                           Integer.valueOf(AV58Embargabilidadwwds_4_tfembargaexplicacion_sels.size()) ,
                                           AV57Embargabilidadwwds_3_tfembargaexplicacion ,
                                           Short.valueOf(AV46PaiCod) ,
                                           Short.valueOf(A1160EmbarPaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV55Embargabilidadwwds_1_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV55Embargabilidadwwds_1_tfembargadescrip), "%", "") ;
      lV57Embargabilidadwwds_3_tfembargaexplicacion = GXutil.concat( GXutil.rtrim( AV57Embargabilidadwwds_3_tfembargaexplicacion), "%", "") ;
      /* Using cursor P01K32 */
      pr_default.execute(0, new Object[] {lV55Embargabilidadwwds_1_tfembargadescrip, lV57Embargabilidadwwds_3_tfembargaexplicacion, Short.valueOf(AV46PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1160EmbarPaiCod = P01K32_A1160EmbarPaiCod[0] ;
         A1203EmbargaExplicacion = P01K32_A1203EmbargaExplicacion[0] ;
         A1162EmbargaDescrip = P01K32_A1162EmbargaDescrip[0] ;
         A1161EmbargaSec = P01K32_A1161EmbargaSec[0] ;
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
         AV59GXV4 = 1 ;
         while ( AV59GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmbargaSec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1161EmbargaSec );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmbarPaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1160EmbarPaiCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmbargaDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1162EmbargaDescrip, GXv_char9) ;
                  embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmbargaExplicacion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1203EmbargaExplicacion, 1, 1000), GXv_char9) ;
                  embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV59GXV4 = (int)(AV59GXV4+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EmbargaDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EmbargaExplicacion", "", "Explicacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "embargabilidadWWColumnsSelector", GXv_char9) ;
      embargabilidadwwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("embargabilidadWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "embargabilidadWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("embargabilidadWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV60GXV5 = 1 ;
      while ( AV60GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV60GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP") == 0 )
         {
            AV36TFEmbargaDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP_SEL") == 0 )
         {
            AV35TFEmbargaDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFEmbargaDescrip_Sels.fromJSonString(AV35TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION") == 0 )
         {
            AV40TFEmbargaExplicacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION_SEL") == 0 )
         {
            AV39TFEmbargaExplicacion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFEmbargaExplicacion_Sels.fromJSonString(AV39TFEmbargaExplicacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV60GXV5 = (int)(AV60GXV5+1) ;
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
      this.aP0[0] = embargabilidadwwexport.this.AV12Filename;
      this.aP1[0] = embargabilidadwwexport.this.AV13ErrorMessage;
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
      GXv_int2 = new int[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV50Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFEmbargaDescrip_Sel = "" ;
      AV36TFEmbargaDescrip = "" ;
      AV41TFEmbargaExplicacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFEmbargaExplicacion_Sel = "" ;
      AV40TFEmbargaExplicacion = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1162EmbargaDescrip = "" ;
      A1203EmbargaExplicacion = "" ;
      AV55Embargabilidadwwds_1_tfembargadescrip = "" ;
      AV56Embargabilidadwwds_2_tfembargadescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      AV58Embargabilidadwwds_4_tfembargaexplicacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Embargabilidadwwds_1_tfembargadescrip = "" ;
      lV57Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      P01K32_A1160EmbarPaiCod = new short[1] ;
      P01K32_A1203EmbargaExplicacion = new String[] {""} ;
      P01K32_A1162EmbargaDescrip = new String[] {""} ;
      P01K32_A1161EmbargaSec = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFEmbargaDescrip_SelsJson = "" ;
      AV39TFEmbargaExplicacion_SelsJson = "" ;
      AV47MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.embargabilidadwwexport__default(),
         new Object[] {
             new Object[] {
            P01K32_A1160EmbarPaiCod, P01K32_A1203EmbargaExplicacion, P01K32_A1162EmbargaDescrip, P01K32_A1161EmbargaSec
            }
         }
      );
      AV50Pgmname = "embargabilidadWWExport" ;
      /* GeneXus formulas. */
      AV50Pgmname = "embargabilidadWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int7[] ;
   private short A1161EmbargaSec ;
   private short A1160EmbarPaiCod ;
   private short AV46PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV51GXV1 ;
   private int AV52GXV2 ;
   private int AV53GXV3 ;
   private int AV56Embargabilidadwwds_2_tfembargadescrip_sels_size ;
   private int AV58Embargabilidadwwds_4_tfembargaexplicacion_sels_size ;
   private int AV59GXV4 ;
   private int AV60GXV5 ;
   private long AV43i ;
   private long AV32VisibleColumnCount ;
   private String AV50Pgmname ;
   private String scmdbuf ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String A1203EmbargaExplicacion ;
   private String AV28UserCustomValue ;
   private String AV35TFEmbargaDescrip_SelsJson ;
   private String AV39TFEmbargaExplicacion_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFEmbargaDescrip_Sel ;
   private String AV36TFEmbargaDescrip ;
   private String AV42TFEmbargaExplicacion_Sel ;
   private String AV40TFEmbargaExplicacion ;
   private String A1162EmbargaDescrip ;
   private String AV55Embargabilidadwwds_1_tfembargadescrip ;
   private String AV57Embargabilidadwwds_3_tfembargaexplicacion ;
   private String lV55Embargabilidadwwds_1_tfembargadescrip ;
   private String lV57Embargabilidadwwds_3_tfembargaexplicacion ;
   private String AV47MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFEmbargaDescrip_Sels ;
   private GXSimpleCollection<String> AV41TFEmbargaExplicacion_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01K32_A1160EmbarPaiCod ;
   private String[] P01K32_A1203EmbargaExplicacion ;
   private String[] P01K32_A1162EmbargaDescrip ;
   private short[] P01K32_A1161EmbargaSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV56Embargabilidadwwds_2_tfembargadescrip_sels ;
   private GXSimpleCollection<String> AV58Embargabilidadwwds_4_tfembargaexplicacion_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class embargabilidadwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV56Embargabilidadwwds_2_tfembargadescrip_sels ,
                                          String A1203EmbargaExplicacion ,
                                          GXSimpleCollection<String> AV58Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                          int AV56Embargabilidadwwds_2_tfembargadescrip_sels_size ,
                                          String AV55Embargabilidadwwds_1_tfembargadescrip ,
                                          int AV58Embargabilidadwwds_4_tfembargaexplicacion_sels_size ,
                                          String AV57Embargabilidadwwds_3_tfembargaexplicacion ,
                                          short AV46PaiCod ,
                                          short A1160EmbarPaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[3];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT EmbarPaiCod, EmbargaExplicacion, EmbargaDescrip, EmbargaSec FROM embargabilidad" ;
      if ( ( AV56Embargabilidadwwds_2_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Embargabilidadwwds_1_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( AV56Embargabilidadwwds_2_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Embargabilidadwwds_2_tfembargadescrip_sels, "EmbargaDescrip IN (", ")")+")");
      }
      if ( ( AV58Embargabilidadwwds_4_tfembargaexplicacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Embargabilidadwwds_3_tfembargaexplicacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaExplicacion) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV58Embargabilidadwwds_4_tfembargaexplicacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Embargabilidadwwds_4_tfembargaexplicacion_sels, "EmbargaExplicacion IN (", ")")+")");
      }
      if ( ! (0==AV46PaiCod) )
      {
         addWhere(sWhereString, "(EmbarPaiCod = ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmbargaDescrip" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmbargaDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmbargaExplicacion" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmbargaExplicacion DESC" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P01K32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 200);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

