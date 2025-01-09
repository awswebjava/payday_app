package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresawwexport extends GXProcedure
{
   public empresawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresawwexport.class ), "" );
   }

   public empresawwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresawwexport.this.aP1 = new String[] {""};
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
      empresawwexport.this.aP0 = aP0;
      empresawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa", GXv_boolean2) ;
      empresawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EmpresaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFEmpNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV59GXV1 = 1 ;
         while ( AV59GXV1 <= AV37TFEmpNom_Sels.size() )
         {
            AV38TFEmpNom_Sel = (String)AV37TFEmpNom_Sels.elementAt(-1+AV59GXV1) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEmpNom_Sel, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV59GXV1 = (int)(AV59GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFEmpNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFEmpNom, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV39TFEmpCUIT) && (0==AV40TFEmpCUIT_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "CUIT", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFEmpCUIT );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFEmpCUIT_To );
      }
      if ( ! ( ( AV43TFActDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Actividad", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV60GXV2 = 1 ;
         while ( AV60GXV2 <= AV43TFActDescrip_Sels.size() )
         {
            AV44TFActDescrip_Sel = (String)AV43TFActDescrip_Sels.elementAt(-1+AV60GXV2) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFActDescrip_Sel, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV60GXV2 = (int)(AV60GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFActDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Actividad", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFActDescrip, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV47TFTipEmpleDescri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Empleador", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV61GXV3 = 1 ;
         while ( AV61GXV3 <= AV47TFTipEmpleDescri_Sels.size() )
         {
            AV48TFTipEmpleDescri_Sel = (String)AV47TFTipEmpleDescri_Sels.elementAt(-1+AV61GXV3) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFTipEmpleDescri_Sel, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV61GXV3 = (int)(AV61GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFTipEmpleDescri)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Empleador", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFTipEmpleDescri, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV51TFEmpZonDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Zona", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV62GXV4 = 1 ;
         while ( AV62GXV4 <= AV51TFEmpZonDescrip_Sels.size() )
         {
            AV52TFEmpZonDescrip_Sel = (String)AV51TFEmpZonDescrip_Sels.elementAt(-1+AV62GXV4) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFEmpZonDescrip_Sel, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV62GXV4 = (int)(AV62GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFEmpZonDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Zona", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFEmpZonDescrip, GXv_char7) ;
            empresawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("EmpresaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EmpresaWWColumnsSelector") ;
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
      AV63GXV5 = 1 ;
      while ( AV63GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV63GXV5 = (int)(AV63GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV65Empresawwds_1_tfempnom = AV36TFEmpNom ;
      AV66Empresawwds_2_tfempnom_sels = AV37TFEmpNom_Sels ;
      AV67Empresawwds_3_tfempcuit = AV39TFEmpCUIT ;
      AV68Empresawwds_4_tfempcuit_to = AV40TFEmpCUIT_To ;
      AV69Empresawwds_5_tfactdescrip = AV42TFActDescrip ;
      AV70Empresawwds_6_tfactdescrip_sels = AV43TFActDescrip_Sels ;
      AV71Empresawwds_7_tftipempledescri = AV46TFTipEmpleDescri ;
      AV72Empresawwds_8_tftipempledescri_sels = AV47TFTipEmpleDescri_Sels ;
      AV73Empresawwds_9_tfempzondescrip = AV50TFEmpZonDescrip ;
      AV74Empresawwds_10_tfempzondescrip_sels = AV51TFEmpZonDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV66Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV70Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV72Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV74Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV66Empresawwds_2_tfempnom_sels.size()) ,
                                           AV65Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV67Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV68Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV70Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV69Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV72Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV71Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV74Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV73Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV54CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV65Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV65Empresawwds_1_tfempnom), "%", "") ;
      lV69Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV69Empresawwds_5_tfactdescrip), "%", "") ;
      lV71Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV71Empresawwds_7_tftipempledescri), "%", "") ;
      lV73Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV73Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor P02EX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV54CliCod), lV65Empresawwds_1_tfempnom, Long.valueOf(AV67Empresawwds_3_tfempcuit), Long.valueOf(AV68Empresawwds_4_tfempcuit_to), lV69Empresawwds_5_tfactdescrip, lV71Empresawwds_7_tftipempledescri, lV73Empresawwds_9_tfempzondescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A43ActCodigo = P02EX2_A43ActCodigo[0] ;
         n43ActCodigo = P02EX2_n43ActCodigo[0] ;
         A45TipEmpleCod = P02EX2_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P02EX2_n45TipEmpleCod[0] ;
         A44EmpZonCod = P02EX2_A44EmpZonCod[0] ;
         n44EmpZonCod = P02EX2_n44EmpZonCod[0] ;
         A3CliCod = P02EX2_A3CliCod[0] ;
         A518EmpZonDescrip = P02EX2_A518EmpZonDescrip[0] ;
         A339TipEmpleDescri = P02EX2_A339TipEmpleDescri[0] ;
         A108ActDescrip = P02EX2_A108ActDescrip[0] ;
         A177EmpCUIT = P02EX2_A177EmpCUIT[0] ;
         A2EmpNom = P02EX2_A2EmpNom[0] ;
         A1EmpCod = P02EX2_A1EmpCod[0] ;
         A108ActDescrip = P02EX2_A108ActDescrip[0] ;
         A339TipEmpleDescri = P02EX2_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P02EX2_A518EmpZonDescrip[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV75GXV6 = 1 ;
         while ( AV75GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV75GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2EmpNom, GXv_char7) ;
                  empresawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpCUIT") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A177EmpCUIT );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ActDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A108ActDescrip, GXv_char7) ;
                  empresawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipEmpleDescri") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A339TipEmpleDescri, GXv_char7) ;
                  empresawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpZonDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A518EmpZonDescrip, GXv_char7) ;
                  empresawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV75GXV6 = (int)(AV75GXV6+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpNom", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpCUIT", "", "CUIT", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ActDescrip", "", "Actividad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipEmpleDescri", "", "Tipo de Empleador", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpZonDescrip", "", "Zona", false, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EmpresaWWColumnsSelector", GXv_char7) ;
      empresawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("EmpresaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EmpresaWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV76GXV7 = 1 ;
      while ( AV76GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV76GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM") == 0 )
         {
            AV36TFEmpNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM_SEL") == 0 )
         {
            AV35TFEmpNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFEmpNom_Sels.fromJSonString(AV35TFEmpNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUIT") == 0 )
         {
            AV39TFEmpCUIT = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV40TFEmpCUIT_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP") == 0 )
         {
            AV42TFActDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP_SEL") == 0 )
         {
            AV41TFActDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFActDescrip_Sels.fromJSonString(AV41TFActDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI") == 0 )
         {
            AV46TFTipEmpleDescri = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI_SEL") == 0 )
         {
            AV45TFTipEmpleDescri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFTipEmpleDescri_Sels.fromJSonString(AV45TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP") == 0 )
         {
            AV50TFEmpZonDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP_SEL") == 0 )
         {
            AV49TFEmpZonDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFEmpZonDescrip_Sels.fromJSonString(AV49TFEmpZonDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV76GXV7 = (int)(AV76GXV7+1) ;
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
      this.aP0[0] = empresawwexport.this.AV12Filename;
      this.aP1[0] = empresawwexport.this.AV13ErrorMessage;
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
      AV58Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFEmpNom_Sel = "" ;
      AV36TFEmpNom = "" ;
      AV43TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFActDescrip_Sel = "" ;
      AV42TFActDescrip = "" ;
      AV47TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFTipEmpleDescri_Sel = "" ;
      AV46TFTipEmpleDescri = "" ;
      AV51TFEmpZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFEmpZonDescrip_Sel = "" ;
      AV50TFEmpZonDescrip = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A2EmpNom = "" ;
      A108ActDescrip = "" ;
      A339TipEmpleDescri = "" ;
      A518EmpZonDescrip = "" ;
      AV65Empresawwds_1_tfempnom = "" ;
      AV66Empresawwds_2_tfempnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Empresawwds_5_tfactdescrip = "" ;
      AV70Empresawwds_6_tfactdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Empresawwds_7_tftipempledescri = "" ;
      AV72Empresawwds_8_tftipempledescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Empresawwds_9_tfempzondescrip = "" ;
      AV74Empresawwds_10_tfempzondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV65Empresawwds_1_tfempnom = "" ;
      lV69Empresawwds_5_tfactdescrip = "" ;
      lV71Empresawwds_7_tftipempledescri = "" ;
      lV73Empresawwds_9_tfempzondescrip = "" ;
      P02EX2_A43ActCodigo = new String[] {""} ;
      P02EX2_n43ActCodigo = new boolean[] {false} ;
      P02EX2_A45TipEmpleCod = new String[] {""} ;
      P02EX2_n45TipEmpleCod = new boolean[] {false} ;
      P02EX2_A44EmpZonCod = new String[] {""} ;
      P02EX2_n44EmpZonCod = new boolean[] {false} ;
      P02EX2_A3CliCod = new int[1] ;
      P02EX2_A518EmpZonDescrip = new String[] {""} ;
      P02EX2_A339TipEmpleDescri = new String[] {""} ;
      P02EX2_A108ActDescrip = new String[] {""} ;
      P02EX2_A177EmpCUIT = new long[1] ;
      P02EX2_A2EmpNom = new String[] {""} ;
      P02EX2_A1EmpCod = new short[1] ;
      A43ActCodigo = "" ;
      A45TipEmpleCod = "" ;
      A44EmpZonCod = "" ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFEmpNom_SelsJson = "" ;
      AV41TFActDescrip_SelsJson = "" ;
      AV45TFTipEmpleDescri_SelsJson = "" ;
      AV49TFEmpZonDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresawwexport__default(),
         new Object[] {
             new Object[] {
            P02EX2_A43ActCodigo, P02EX2_n43ActCodigo, P02EX2_A45TipEmpleCod, P02EX2_n45TipEmpleCod, P02EX2_A44EmpZonCod, P02EX2_n44EmpZonCod, P02EX2_A3CliCod, P02EX2_A518EmpZonDescrip, P02EX2_A339TipEmpleDescri, P02EX2_A108ActDescrip,
            P02EX2_A177EmpCUIT, P02EX2_A2EmpNom, P02EX2_A1EmpCod
            }
         }
      );
      AV58Pgmname = "EmpresaWWExport" ;
      /* GeneXus formulas. */
      AV58Pgmname = "EmpresaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV59GXV1 ;
   private int AV60GXV2 ;
   private int AV61GXV3 ;
   private int AV62GXV4 ;
   private int AV63GXV5 ;
   private int AV66Empresawwds_2_tfempnom_sels_size ;
   private int AV70Empresawwds_6_tfactdescrip_sels_size ;
   private int AV72Empresawwds_8_tftipempledescri_sels_size ;
   private int AV74Empresawwds_10_tfempzondescrip_sels_size ;
   private int AV54CliCod ;
   private int A3CliCod ;
   private int AV75GXV6 ;
   private int AV76GXV7 ;
   private long AV53i ;
   private long AV39TFEmpCUIT ;
   private long AV40TFEmpCUIT_To ;
   private long AV32VisibleColumnCount ;
   private long A177EmpCUIT ;
   private long AV67Empresawwds_3_tfempcuit ;
   private long AV68Empresawwds_4_tfempcuit_to ;
   private String AV58Pgmname ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private String A44EmpZonCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFEmpNom_SelsJson ;
   private String AV41TFActDescrip_SelsJson ;
   private String AV45TFTipEmpleDescri_SelsJson ;
   private String AV49TFEmpZonDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFEmpNom_Sel ;
   private String AV36TFEmpNom ;
   private String AV44TFActDescrip_Sel ;
   private String AV42TFActDescrip ;
   private String AV48TFTipEmpleDescri_Sel ;
   private String AV46TFTipEmpleDescri ;
   private String AV52TFEmpZonDescrip_Sel ;
   private String AV50TFEmpZonDescrip ;
   private String A2EmpNom ;
   private String A108ActDescrip ;
   private String A339TipEmpleDescri ;
   private String A518EmpZonDescrip ;
   private String AV65Empresawwds_1_tfempnom ;
   private String AV69Empresawwds_5_tfactdescrip ;
   private String AV71Empresawwds_7_tftipempledescri ;
   private String AV73Empresawwds_9_tfempzondescrip ;
   private String lV65Empresawwds_1_tfempnom ;
   private String lV69Empresawwds_5_tfactdescrip ;
   private String lV71Empresawwds_7_tftipempledescri ;
   private String lV73Empresawwds_9_tfempzondescrip ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFEmpNom_Sels ;
   private GXSimpleCollection<String> AV43TFActDescrip_Sels ;
   private GXSimpleCollection<String> AV47TFTipEmpleDescri_Sels ;
   private GXSimpleCollection<String> AV51TFEmpZonDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02EX2_A43ActCodigo ;
   private boolean[] P02EX2_n43ActCodigo ;
   private String[] P02EX2_A45TipEmpleCod ;
   private boolean[] P02EX2_n45TipEmpleCod ;
   private String[] P02EX2_A44EmpZonCod ;
   private boolean[] P02EX2_n44EmpZonCod ;
   private int[] P02EX2_A3CliCod ;
   private String[] P02EX2_A518EmpZonDescrip ;
   private String[] P02EX2_A339TipEmpleDescri ;
   private String[] P02EX2_A108ActDescrip ;
   private long[] P02EX2_A177EmpCUIT ;
   private String[] P02EX2_A2EmpNom ;
   private short[] P02EX2_A1EmpCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV66Empresawwds_2_tfempnom_sels ;
   private GXSimpleCollection<String> AV70Empresawwds_6_tfactdescrip_sels ;
   private GXSimpleCollection<String> AV72Empresawwds_8_tftipempledescri_sels ;
   private GXSimpleCollection<String> AV74Empresawwds_10_tfempzondescrip_sels ;
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

final  class empresawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02EX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV66Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV70Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV72Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV74Empresawwds_10_tfempzondescrip_sels ,
                                          int AV66Empresawwds_2_tfempnom_sels_size ,
                                          String AV65Empresawwds_1_tfempnom ,
                                          long AV67Empresawwds_3_tfempcuit ,
                                          long AV68Empresawwds_4_tfempcuit_to ,
                                          int AV70Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV69Empresawwds_5_tfactdescrip ,
                                          int AV72Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV71Empresawwds_7_tftipempledescri ,
                                          int AV74Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV73Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV54CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.ActCodigo, T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T1.CliCod, T4.ZonDescrip AS EmpZonDescrip, T3.TipEmpleDescri, T2.ActDescrip, T1.EmpCUIT, T1.EmpNom," ;
      scmdbuf += " T1.EmpCod FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona" ;
      scmdbuf += " T4 ON T4.ZonCod = T1.EmpZonCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV66Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV66Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV67Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV68Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV70Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV70Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV72Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV72Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV74Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV74Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpNom" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpCUIT" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpCUIT DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.ActDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.ActDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.TipEmpleDescri" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.TipEmpleDescri DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.ZonDescrip" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.ZonDescrip DESC" ;
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
                  return conditional_P02EX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((long[]) buf[10])[0] = rslt.getLong(8);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
      }
   }

}

