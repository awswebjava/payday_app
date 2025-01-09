package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class localidadwwexport extends GXProcedure
{
   public localidadwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidadwwexport.class ), "" );
   }

   public localidadwwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      localidadwwexport.this.aP1 = new String[] {""};
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
      localidadwwexport.this.aP0 = aP0;
      localidadwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad", GXv_boolean2) ;
      localidadwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "LocalidadWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV20PaiCod) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "País", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV20PaiCod );
      }
      if ( ! ( (0==AV21ProvCod) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Provincia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV21ProvCod );
      }
      if ( ! ( ( AV39TFPaiNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "País", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV39TFPaiNom_Sels.size() )
         {
            AV40TFPaiNom_Sel = (String)AV39TFPaiNom_Sels.elementAt(-1+AV61GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPaiNom_Sel, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFPaiNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "País", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFPaiNom, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV43TFProvNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Provincia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV43TFProvNom_Sels.size() )
         {
            AV44TFProvNom_Sel = (String)AV43TFProvNom_Sels.elementAt(-1+AV62GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFProvNom_Sel, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFProvNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Provincia", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFProvNom, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV45TFLocCod) && (0==AV46TFLocCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV45TFLocCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV46TFLocCod_To );
      }
      if ( ! ( ( AV49TFLocNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV63GXV3 = 1 ;
         while ( AV63GXV3 <= AV49TFLocNom_Sels.size() )
         {
            AV50TFLocNom_Sel = (String)AV49TFLocNom_Sels.elementAt(-1+AV63GXV3) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFLocNom_Sel, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV63GXV3 = (int)(AV63GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV48TFLocNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            localidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFLocNom, GXv_char7) ;
            localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV34VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV22Session.getValue("LocalidadWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV22Session.getValue("LocalidadWWColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "PaiCod" );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod. Pais", "") );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV28ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "ProvCod" );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod. Prov.", "") );
      AV28ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV28ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV64GXV4 = 1 ;
      while ( AV64GXV4 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV64GXV4));
         if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setColor( 11 );
            AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
         }
         AV64GXV4 = (int)(AV64GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV66Localidadwwds_1_paicod = AV20PaiCod ;
      AV67Localidadwwds_2_provcod = AV21ProvCod ;
      AV68Localidadwwds_3_tfpainom = AV38TFPaiNom ;
      AV69Localidadwwds_4_tfpainom_sels = AV39TFPaiNom_Sels ;
      AV70Localidadwwds_5_tfprovnom = AV42TFProvNom ;
      AV71Localidadwwds_6_tfprovnom_sels = AV43TFProvNom_Sels ;
      AV72Localidadwwds_7_tfloccod = AV45TFLocCod ;
      AV73Localidadwwds_8_tfloccod_to = AV46TFLocCod_To ;
      AV74Localidadwwds_9_tflocnom = AV48TFLocNom ;
      AV75Localidadwwds_10_tflocnom_sels = AV49TFLocNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV69Localidadwwds_4_tfpainom_sels ,
                                           A322ProvNom ,
                                           AV71Localidadwwds_6_tfprovnom_sels ,
                                           A286LocNom ,
                                           AV75Localidadwwds_10_tflocnom_sels ,
                                           Short.valueOf(AV66Localidadwwds_1_paicod) ,
                                           Short.valueOf(AV67Localidadwwds_2_provcod) ,
                                           Integer.valueOf(AV69Localidadwwds_4_tfpainom_sels.size()) ,
                                           AV68Localidadwwds_3_tfpainom ,
                                           Integer.valueOf(AV71Localidadwwds_6_tfprovnom_sels.size()) ,
                                           AV70Localidadwwds_5_tfprovnom ,
                                           Short.valueOf(AV72Localidadwwds_7_tfloccod) ,
                                           Short.valueOf(AV73Localidadwwds_8_tfloccod_to) ,
                                           Integer.valueOf(AV75Localidadwwds_10_tflocnom_sels.size()) ,
                                           Short.valueOf(AV20PaiCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(A47ProvCod) ,
                                           Short.valueOf(A48LocCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV68Localidadwwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV68Localidadwwds_3_tfpainom), "%", "") ;
      lV70Localidadwwds_5_tfprovnom = GXutil.concat( GXutil.rtrim( AV70Localidadwwds_5_tfprovnom), "%", "") ;
      /* Using cursor P01IH2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV66Localidadwwds_1_paicod), Short.valueOf(AV67Localidadwwds_2_provcod), lV68Localidadwwds_3_tfpainom, lV70Localidadwwds_5_tfprovnom, Short.valueOf(AV72Localidadwwds_7_tfloccod), Short.valueOf(AV73Localidadwwds_8_tfloccod_to), Short.valueOf(AV20PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A286LocNom = P01IH2_A286LocNom[0] ;
         A48LocCod = P01IH2_A48LocCod[0] ;
         A322ProvNom = P01IH2_A322ProvNom[0] ;
         A312PaiNom = P01IH2_A312PaiNom[0] ;
         A47ProvCod = P01IH2_A47ProvCod[0] ;
         A46PaiCod = P01IH2_A46PaiCod[0] ;
         A312PaiNom = P01IH2_A312PaiNom[0] ;
         A322ProvNom = P01IH2_A322ProvNom[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV34VisibleColumnCount = 0 ;
         AV76GXV5 = 1 ;
         while ( AV76GXV5 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV76GXV5));
            if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A46PaiCod );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ProvCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A47ProvCod );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LocCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A48LocCod );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LocNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A286LocNom, GXv_char7) ;
                  localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
            }
            AV76GXV5 = (int)(AV76GXV5+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiNom", "", "País", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ProvNom", "", "Provincia", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LocCod", "", "Código", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LocNom", "", "Nombre", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV77Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( ( ( AV77Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV30UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LocalidadWWColumnsSelector", GXv_char7) ;
      localidadwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV30UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV30UserCustomValue)==0) ) )
      {
         AV27ColumnsSelectorAux.fromxml(AV30UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV27ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("LocalidadWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LocalidadWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("LocalidadWWGridState"), null, null);
      }
      AV18OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV78GXV6 = 1 ;
      while ( AV78GXV6 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV78GXV6));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PAICOD") == 0 )
         {
            AV20PaiCod = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PROVCOD") == 0 )
         {
            AV21ProvCod = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM") == 0 )
         {
            AV38TFPaiNom = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM_SEL") == 0 )
         {
            AV37TFPaiNom_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFPaiNom_Sels.fromJSonString(AV37TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM") == 0 )
         {
            AV42TFProvNom = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM_SEL") == 0 )
         {
            AV41TFProvNom_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFProvNom_Sels.fromJSonString(AV41TFProvNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCCOD") == 0 )
         {
            AV45TFLocCod = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV46TFLocCod_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCNOM") == 0 )
         {
            AV48TFLocNom = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCNOM_SEL") == 0 )
         {
            AV47TFLocNom_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFLocNom_Sels.fromJSonString(AV47TFLocNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV78GXV6 = (int)(AV78GXV6+1) ;
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
      this.aP0[0] = localidadwwexport.this.AV12Filename;
      this.aP1[0] = localidadwwexport.this.AV13ErrorMessage;
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
      AV39TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFPaiNom_Sel = "" ;
      AV38TFPaiNom = "" ;
      AV43TFProvNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFProvNom_Sel = "" ;
      AV42TFProvNom = "" ;
      AV49TFLocNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFLocNom_Sel = "" ;
      AV48TFLocNom = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV22Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV28ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A286LocNom = "" ;
      AV68Localidadwwds_3_tfpainom = "" ;
      AV69Localidadwwds_4_tfpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Localidadwwds_5_tfprovnom = "" ;
      AV71Localidadwwds_6_tfprovnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Localidadwwds_9_tflocnom = "" ;
      AV75Localidadwwds_10_tflocnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV68Localidadwwds_3_tfpainom = "" ;
      lV70Localidadwwds_5_tfprovnom = "" ;
      A312PaiNom = "" ;
      A322ProvNom = "" ;
      P01IH2_A286LocNom = new String[] {""} ;
      P01IH2_A48LocCod = new short[1] ;
      P01IH2_A322ProvNom = new String[] {""} ;
      P01IH2_A312PaiNom = new String[] {""} ;
      P01IH2_A47ProvCod = new short[1] ;
      P01IH2_A46PaiCod = new short[1] ;
      AV77Paises = DecimalUtil.ZERO ;
      AV30UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFPaiNom_SelsJson = "" ;
      AV41TFProvNom_SelsJson = "" ;
      AV47TFLocNom_SelsJson = "" ;
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.localidadwwexport__default(),
         new Object[] {
             new Object[] {
            P01IH2_A286LocNom, P01IH2_A48LocCod, P01IH2_A322ProvNom, P01IH2_A312PaiNom, P01IH2_A47ProvCod, P01IH2_A46PaiCod
            }
         }
      );
      AV60Pgmname = "LocalidadWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "LocalidadWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV20PaiCod ;
   private short AV21ProvCod ;
   private short AV45TFLocCod ;
   private short AV46TFLocCod_To ;
   private short GXv_int5[] ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short AV66Localidadwwds_1_paicod ;
   private short AV67Localidadwwds_2_provcod ;
   private short AV72Localidadwwds_7_tfloccod ;
   private short AV73Localidadwwds_8_tfloccod_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV63GXV3 ;
   private int AV64GXV4 ;
   private int AV69Localidadwwds_4_tfpainom_sels_size ;
   private int AV71Localidadwwds_6_tfprovnom_sels_size ;
   private int AV75Localidadwwds_10_tflocnom_sels_size ;
   private int AV76GXV5 ;
   private int AV78GXV6 ;
   private long AV51i ;
   private long AV34VisibleColumnCount ;
   private java.math.BigDecimal AV77Paises ;
   private String AV60Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV29ColumnsSelectorXML ;
   private String AV30UserCustomValue ;
   private String AV37TFPaiNom_SelsJson ;
   private String AV41TFProvNom_SelsJson ;
   private String AV47TFLocNom_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFPaiNom_Sel ;
   private String AV38TFPaiNom ;
   private String AV44TFProvNom_Sel ;
   private String AV42TFProvNom ;
   private String AV50TFLocNom_Sel ;
   private String AV48TFLocNom ;
   private String A286LocNom ;
   private String AV68Localidadwwds_3_tfpainom ;
   private String AV70Localidadwwds_5_tfprovnom ;
   private String AV74Localidadwwds_9_tflocnom ;
   private String lV68Localidadwwds_3_tfpainom ;
   private String lV70Localidadwwds_5_tfprovnom ;
   private String A312PaiNom ;
   private String A322ProvNom ;
   private String AV54MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private GXSimpleCollection<String> AV39TFPaiNom_Sels ;
   private GXSimpleCollection<String> AV43TFProvNom_Sels ;
   private GXSimpleCollection<String> AV49TFLocNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01IH2_A286LocNom ;
   private short[] P01IH2_A48LocCod ;
   private String[] P01IH2_A322ProvNom ;
   private String[] P01IH2_A312PaiNom ;
   private short[] P01IH2_A47ProvCod ;
   private short[] P01IH2_A46PaiCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV69Localidadwwds_4_tfpainom_sels ;
   private GXSimpleCollection<String> AV71Localidadwwds_6_tfprovnom_sels ;
   private GXSimpleCollection<String> AV75Localidadwwds_10_tflocnom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV28ColumnsSelector_Column ;
}

final  class localidadwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IH2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV69Localidadwwds_4_tfpainom_sels ,
                                          String A322ProvNom ,
                                          GXSimpleCollection<String> AV71Localidadwwds_6_tfprovnom_sels ,
                                          String A286LocNom ,
                                          GXSimpleCollection<String> AV75Localidadwwds_10_tflocnom_sels ,
                                          short AV66Localidadwwds_1_paicod ,
                                          short AV67Localidadwwds_2_provcod ,
                                          int AV69Localidadwwds_4_tfpainom_sels_size ,
                                          String AV68Localidadwwds_3_tfpainom ,
                                          int AV71Localidadwwds_6_tfprovnom_sels_size ,
                                          String AV70Localidadwwds_5_tfprovnom ,
                                          short AV72Localidadwwds_7_tfloccod ,
                                          short AV73Localidadwwds_8_tfloccod_to ,
                                          int AV75Localidadwwds_10_tflocnom_sels_size ,
                                          short AV20PaiCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod ,
                                          short A48LocCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.LocNom, T1.LocCod, T3.ProvNom, T2.PaiNom, T1.ProvCod, T1.PaiCod FROM ((Localidad T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) INNER JOIN Provincia T3" ;
      scmdbuf += " ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod)" ;
      if ( ! (0==AV66Localidadwwds_1_paicod) )
      {
         addWhere(sWhereString, "(T1.PaiCod >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV67Localidadwwds_2_provcod) )
      {
         addWhere(sWhereString, "(T1.ProvCod >= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( AV69Localidadwwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Localidadwwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV69Localidadwwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Localidadwwds_4_tfpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ( AV71Localidadwwds_6_tfprovnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Localidadwwds_5_tfprovnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ProvNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV71Localidadwwds_6_tfprovnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Localidadwwds_6_tfprovnom_sels, "T3.ProvNom IN (", ")")+")");
      }
      if ( ! (0==AV72Localidadwwds_7_tfloccod) )
      {
         addWhere(sWhereString, "(T1.LocCod >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Localidadwwds_8_tfloccod_to) )
      {
         addWhere(sWhereString, "(T1.LocCod <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV75Localidadwwds_10_tflocnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Localidadwwds_10_tflocnom_sels, "T1.LocNom IN (", ")")+")");
      }
      if ( ! (0==AV20PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.PaiNom" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.PaiNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.ProvNom" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.ProvNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LocCod" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LocCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LocNom" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LocNom DESC" ;
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
                  return conditional_P01IH2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IH2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

