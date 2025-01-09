package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esquemacategoriawwexport extends GXProcedure
{
   public esquemacategoriawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemacategoriawwexport.class ), "" );
   }

   public esquemacategoriawwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      esquemacategoriawwexport.this.aP1 = new String[] {""};
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
      esquemacategoriawwexport.this.aP0 = aP0;
      esquemacategoriawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaCategoria", GXv_boolean2) ;
      esquemacategoriawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EsquemaCategoriaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFCatCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV37TFCatCodigo_Sels.size() )
         {
            AV38TFCatCodigo_Sel = (String)AV37TFCatCodigo_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFCatCodigo_Sel, GXv_char7) ;
            esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFCatCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFCatCodigo, GXv_char7) ;
            esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFCatDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV59GXV2 = 1 ;
         while ( AV59GXV2 <= AV41TFCatDescrip_Sels.size() )
         {
            AV42TFCatDescrip_Sel = (String)AV41TFCatDescrip_Sels.elementAt(-1+AV59GXV2) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFCatDescrip_Sel, GXv_char7) ;
            esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV59GXV2 = (int)(AV59GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFCatDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFCatDescrip, GXv_char7) ;
            esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFCatClase_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV60GXV3 = 1 ;
         while ( AV60GXV3 <= AV44TFCatClase_Sels.size() )
         {
            AV45TFCatClase_Sel = ((Number) AV44TFCatClase_Sels.elementAt(-1+AV60GXV3)).byteValue() ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV45TFCatClase_Sel), "") );
            AV51i = (long)(AV51i+1) ;
            AV60GXV3 = (int)(AV60GXV3+1) ;
         }
      }
      if ( ! ( ( AV47TFCatTipoTarifa_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de tarifa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV61GXV4 = 1 ;
         while ( AV61GXV4 <= AV47TFCatTipoTarifa_Sels.size() )
         {
            AV48TFCatTipoTarifa_Sel = (String)AV47TFCatTipoTarifa_Sels.elementAt(-1+AV61GXV4) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV48TFCatTipoTarifa_Sel), "") );
            AV51i = (long)(AV51i+1) ;
            AV61GXV4 = (int)(AV61GXV4+1) ;
         }
      }
      if ( ! ( (0==AV49TFCatFrecAct) && (0==AV50TFCatFrecAct_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de actualización (meses)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFCatFrecAct );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemacategoriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFCatFrecAct_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("EsquemaCategoriaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EsquemaCategoriaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV5 = 1 ;
      while ( AV62GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV62GXV5 = (int)(AV62GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Esquemacategoriawwds_1_tfcatcodigo = AV36TFCatCodigo ;
      AV65Esquemacategoriawwds_2_tfcatcodigo_sels = AV37TFCatCodigo_Sels ;
      AV66Esquemacategoriawwds_3_tfcatdescrip = AV40TFCatDescrip ;
      AV67Esquemacategoriawwds_4_tfcatdescrip_sels = AV41TFCatDescrip_Sels ;
      AV68Esquemacategoriawwds_5_tfcatclase_sels = AV44TFCatClase_Sels ;
      AV69Esquemacategoriawwds_6_tfcattipotarifa_sels = AV47TFCatTipoTarifa_Sels ;
      AV70Esquemacategoriawwds_7_tfcatfrecact = AV49TFCatFrecAct ;
      AV71Esquemacategoriawwds_8_tfcatfrecact_to = AV50TFCatFrecAct_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV65Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                           A123CatDescrip ,
                                           AV67Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                           Byte.valueOf(A1838CatClase) ,
                                           AV68Esquemacategoriawwds_5_tfcatclase_sels ,
                                           A2416CatTipoTarifa ,
                                           AV69Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                           Integer.valueOf(AV65Esquemacategoriawwds_2_tfcatcodigo_sels.size()) ,
                                           AV64Esquemacategoriawwds_1_tfcatcodigo ,
                                           Integer.valueOf(AV67Esquemacategoriawwds_4_tfcatdescrip_sels.size()) ,
                                           AV66Esquemacategoriawwds_3_tfcatdescrip ,
                                           Integer.valueOf(AV68Esquemacategoriawwds_5_tfcatclase_sels.size()) ,
                                           Integer.valueOf(AV69Esquemacategoriawwds_6_tfcattipotarifa_sels.size()) ,
                                           Byte.valueOf(AV70Esquemacategoriawwds_7_tfcatfrecact) ,
                                           Byte.valueOf(AV71Esquemacategoriawwds_8_tfcatfrecact_to) ,
                                           Byte.valueOf(A1914CatFrecAct) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV64Esquemacategoriawwds_1_tfcatcodigo = GXutil.padr( GXutil.rtrim( AV64Esquemacategoriawwds_1_tfcatcodigo), 40, "%") ;
      lV66Esquemacategoriawwds_3_tfcatdescrip = GXutil.concat( GXutil.rtrim( AV66Esquemacategoriawwds_3_tfcatdescrip), "%", "") ;
      /* Using cursor P02LU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV52CliCod), lV64Esquemacategoriawwds_1_tfcatcodigo, lV66Esquemacategoriawwds_3_tfcatdescrip, Byte.valueOf(AV70Esquemacategoriawwds_7_tfcatfrecact), Byte.valueOf(AV71Esquemacategoriawwds_8_tfcatfrecact_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02LU2_A3CliCod[0] ;
         A1914CatFrecAct = P02LU2_A1914CatFrecAct[0] ;
         A2416CatTipoTarifa = P02LU2_A2416CatTipoTarifa[0] ;
         A1838CatClase = P02LU2_A1838CatClase[0] ;
         A123CatDescrip = P02LU2_A123CatDescrip[0] ;
         A8CatCodigo = P02LU2_A8CatCodigo[0] ;
         A1564CliPaiConve = P02LU2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02LU2_A1565CliConvenio[0] ;
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
         AV72GXV6 = 1 ;
         while ( AV72GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV72GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatCodigo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A8CatCodigo, GXv_char7) ;
                  esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A123CatDescrip, GXv_char7) ;
                  esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatClase") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A1838CatClase), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatTipoTarifa") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)A2416CatTipoTarifa), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatFrecAct") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1914CatFrecAct );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV72GXV6 = (int)(AV72GXV6+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CatCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CatDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CatClase", "", "Frecuencia de pago", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CatTipoTarifa", "", "Tipo de tarifa", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CatFrecAct", "", "Frecuencia de actualización (meses)", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EsquemaCategoriaWWColumnsSelector", GXv_char7) ;
      esquemacategoriawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("EsquemaCategoriaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EsquemaCategoriaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EsquemaCategoriaWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV73GXV7 = 1 ;
      while ( AV73GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV73GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO") == 0 )
         {
            AV36TFCatCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO_SEL") == 0 )
         {
            AV35TFCatCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFCatCodigo_Sels.fromJSonString(AV35TFCatCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV40TFCatDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV39TFCatDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFCatDescrip_Sels.fromJSonString(AV39TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCLASE_SEL") == 0 )
         {
            AV43TFCatClase_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFCatClase_Sels.fromJSonString(AV43TFCatClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATTIPOTARIFA_SEL") == 0 )
         {
            AV46TFCatTipoTarifa_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFCatTipoTarifa_Sels.fromJSonString(AV46TFCatTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATFRECACT") == 0 )
         {
            AV49TFCatFrecAct = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFCatFrecAct_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICONVENIO") == 0 )
         {
            AV54CliConvenio = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV73GXV7 = (int)(AV73GXV7+1) ;
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
      this.aP0[0] = esquemacategoriawwexport.this.AV12Filename;
      this.aP1[0] = esquemacategoriawwexport.this.AV13ErrorMessage;
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
      AV57Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFCatCodigo_Sel = "" ;
      AV36TFCatCodigo = "" ;
      AV41TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFCatDescrip_Sel = "" ;
      AV40TFCatDescrip = "" ;
      AV44TFCatClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV47TFCatTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFCatTipoTarifa_Sel = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      A2416CatTipoTarifa = "" ;
      AV64Esquemacategoriawwds_1_tfcatcodigo = "" ;
      AV65Esquemacategoriawwds_2_tfcatcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Esquemacategoriawwds_3_tfcatdescrip = "" ;
      AV67Esquemacategoriawwds_4_tfcatdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Esquemacategoriawwds_5_tfcatclase_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV69Esquemacategoriawwds_6_tfcattipotarifa_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV64Esquemacategoriawwds_1_tfcatcodigo = "" ;
      lV66Esquemacategoriawwds_3_tfcatdescrip = "" ;
      P02LU2_A3CliCod = new int[1] ;
      P02LU2_A1914CatFrecAct = new byte[1] ;
      P02LU2_A2416CatTipoTarifa = new String[] {""} ;
      P02LU2_A1838CatClase = new byte[1] ;
      P02LU2_A123CatDescrip = new String[] {""} ;
      P02LU2_A8CatCodigo = new String[] {""} ;
      P02LU2_A1564CliPaiConve = new short[1] ;
      P02LU2_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFCatCodigo_SelsJson = "" ;
      AV39TFCatDescrip_SelsJson = "" ;
      AV43TFCatClase_SelsJson = "" ;
      AV46TFCatTipoTarifa_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      AV54CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemacategoriawwexport__default(),
         new Object[] {
             new Object[] {
            P02LU2_A3CliCod, P02LU2_A1914CatFrecAct, P02LU2_A2416CatTipoTarifa, P02LU2_A1838CatClase, P02LU2_A123CatDescrip, P02LU2_A8CatCodigo, P02LU2_A1564CliPaiConve, P02LU2_A1565CliConvenio
            }
         }
      );
      AV57Pgmname = "EsquemaCategoriaWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "EsquemaCategoriaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV45TFCatClase_Sel ;
   private byte AV49TFCatFrecAct ;
   private byte AV50TFCatFrecAct_To ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private byte AV70Esquemacategoriawwds_7_tfcatfrecact ;
   private byte AV71Esquemacategoriawwds_8_tfcatfrecact_to ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int AV60GXV3 ;
   private int AV61GXV4 ;
   private int AV62GXV5 ;
   private int AV65Esquemacategoriawwds_2_tfcatcodigo_sels_size ;
   private int AV67Esquemacategoriawwds_4_tfcatdescrip_sels_size ;
   private int AV68Esquemacategoriawwds_5_tfcatclase_sels_size ;
   private int AV69Esquemacategoriawwds_6_tfcattipotarifa_sels_size ;
   private int AV52CliCod ;
   private int A3CliCod ;
   private int AV72GXV6 ;
   private int AV73GXV7 ;
   private long AV51i ;
   private long AV32VisibleColumnCount ;
   private String AV57Pgmname ;
   private String AV38TFCatCodigo_Sel ;
   private String AV36TFCatCodigo ;
   private String AV48TFCatTipoTarifa_Sel ;
   private String A8CatCodigo ;
   private String A2416CatTipoTarifa ;
   private String AV64Esquemacategoriawwds_1_tfcatcodigo ;
   private String scmdbuf ;
   private String lV64Esquemacategoriawwds_1_tfcatcodigo ;
   private String A1565CliConvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String AV54CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFCatCodigo_SelsJson ;
   private String AV39TFCatDescrip_SelsJson ;
   private String AV43TFCatClase_SelsJson ;
   private String AV46TFCatTipoTarifa_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFCatDescrip_Sel ;
   private String AV40TFCatDescrip ;
   private String A123CatDescrip ;
   private String AV66Esquemacategoriawwds_3_tfcatdescrip ;
   private String lV66Esquemacategoriawwds_3_tfcatdescrip ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV44TFCatClase_Sels ;
   private GXSimpleCollection<Byte> AV68Esquemacategoriawwds_5_tfcatclase_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFCatCodigo_Sels ;
   private GXSimpleCollection<String> AV47TFCatTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV41TFCatDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LU2_A3CliCod ;
   private byte[] P02LU2_A1914CatFrecAct ;
   private String[] P02LU2_A2416CatTipoTarifa ;
   private byte[] P02LU2_A1838CatClase ;
   private String[] P02LU2_A123CatDescrip ;
   private String[] P02LU2_A8CatCodigo ;
   private short[] P02LU2_A1564CliPaiConve ;
   private String[] P02LU2_A1565CliConvenio ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV65Esquemacategoriawwds_2_tfcatcodigo_sels ;
   private GXSimpleCollection<String> AV69Esquemacategoriawwds_6_tfcattipotarifa_sels ;
   private GXSimpleCollection<String> AV67Esquemacategoriawwds_4_tfcatdescrip_sels ;
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

final  class esquemacategoriawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02LU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV65Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV67Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                          byte A1838CatClase ,
                                          GXSimpleCollection<Byte> AV68Esquemacategoriawwds_5_tfcatclase_sels ,
                                          String A2416CatTipoTarifa ,
                                          GXSimpleCollection<String> AV69Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                          int AV65Esquemacategoriawwds_2_tfcatcodigo_sels_size ,
                                          String AV64Esquemacategoriawwds_1_tfcatcodigo ,
                                          int AV67Esquemacategoriawwds_4_tfcatdescrip_sels_size ,
                                          String AV66Esquemacategoriawwds_3_tfcatdescrip ,
                                          int AV68Esquemacategoriawwds_5_tfcatclase_sels_size ,
                                          int AV69Esquemacategoriawwds_6_tfcattipotarifa_sels_size ,
                                          byte AV70Esquemacategoriawwds_7_tfcatfrecact ,
                                          byte AV71Esquemacategoriawwds_8_tfcatfrecact_to ,
                                          byte A1914CatFrecAct ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV52CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliCod, CatFrecAct, CatTipoTarifa, CatClase, CatDescrip, CatCodigo, CliPaiConve, CliConvenio FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV65Esquemacategoriawwds_2_tfcatcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Esquemacategoriawwds_1_tfcatcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV65Esquemacategoriawwds_2_tfcatcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Esquemacategoriawwds_2_tfcatcodigo_sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV67Esquemacategoriawwds_4_tfcatdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Esquemacategoriawwds_3_tfcatdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV67Esquemacategoriawwds_4_tfcatdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Esquemacategoriawwds_4_tfcatdescrip_sels, "CatDescrip IN (", ")")+")");
      }
      if ( AV68Esquemacategoriawwds_5_tfcatclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Esquemacategoriawwds_5_tfcatclase_sels, "CatClase IN (", ")")+")");
      }
      if ( AV69Esquemacategoriawwds_6_tfcattipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Esquemacategoriawwds_6_tfcattipotarifa_sels, "CatTipoTarifa IN (", ")")+")");
      }
      if ( ! (0==AV70Esquemacategoriawwds_7_tfcatfrecact) )
      {
         addWhere(sWhereString, "(CatFrecAct >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV71Esquemacategoriawwds_8_tfcatfrecact_to) )
      {
         addWhere(sWhereString, "(CatFrecAct <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatClase" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatClase DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatTipoTarifa" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatTipoTarifa DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatFrecAct" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatFrecAct DESC" ;
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
                  return conditional_P02LU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).shortValue() , ((Boolean) dynConstraints[18]).booleanValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               return;
      }
   }

}

