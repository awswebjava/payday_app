package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class motivoegresowwexport extends GXProcedure
{
   public motivoegresowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresowwexport.class ), "" );
   }

   public motivoegresowwexport( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      motivoegresowwexport.this.aP1 = new String[] {""};
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
      motivoegresowwexport.this.aP0 = aP0;
      motivoegresowwexport.this.aP1 = aP1;
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
      motivoegresowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV44CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso", GXv_boolean4) ;
      motivoegresowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
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
         S211 ();
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
         /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
         S191 ();
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
         S201 ();
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
      AV12Filename = "MotivoEgresoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFMegCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV56GXV1 = 1 ;
         while ( AV56GXV1 <= AV37TFMegCodigo_Sels.size() )
         {
            AV38TFMegCodigo_Sel = (String)AV37TFMegCodigo_Sels.elementAt(-1+AV56GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFMegCodigo_Sel, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV56GXV1 = (int)(AV56GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFMegCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFMegCodigo, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFMegDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV57GXV2 = 1 ;
         while ( AV57GXV2 <= AV41TFMegDescrip_Sels.size() )
         {
            AV42TFMegDescrip_Sel = (String)AV41TFMegDescrip_Sels.elementAt(-1+AV57GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFMegDescrip_Sel, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV57GXV2 = (int)(AV57GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFMegDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFMegDescrip, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV51TFMegRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV58GXV3 = 1 ;
         while ( AV58GXV3 <= AV51TFMegRelRef_Sels.size() )
         {
            AV52TFMegRelRef_Sel = (String)AV51TFMegRelRef_Sels.elementAt(-1+AV58GXV3) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFMegRelRef_Sel, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV58GXV3 = (int)(AV58GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFMegRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            motivoegresowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFMegRelRef, GXv_char9) ;
            motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("MotivoEgresoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("MotivoEgresoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV47IsAuthorizedMegRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV59GXV4 = 1 ;
      while ( AV59GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV59GXV4 = (int)(AV59GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV61Motivoegresowwds_1_tfmegcodigo = AV36TFMegCodigo ;
      AV62Motivoegresowwds_2_tfmegcodigo_sels = AV37TFMegCodigo_Sels ;
      AV63Motivoegresowwds_3_tfmegdescrip = AV40TFMegDescrip ;
      AV64Motivoegresowwds_4_tfmegdescrip_sels = AV41TFMegDescrip_Sels ;
      AV65Motivoegresowwds_5_tfmegrelref = AV50TFMegRelRef ;
      AV66Motivoegresowwds_6_tfmegrelref_sels = AV51TFMegRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A11MegCodigo ,
                                           AV62Motivoegresowwds_2_tfmegcodigo_sels ,
                                           A300MegDescrip ,
                                           AV64Motivoegresowwds_4_tfmegdescrip_sels ,
                                           A2017MegRelRef ,
                                           AV66Motivoegresowwds_6_tfmegrelref_sels ,
                                           Integer.valueOf(AV62Motivoegresowwds_2_tfmegcodigo_sels.size()) ,
                                           AV61Motivoegresowwds_1_tfmegcodigo ,
                                           Integer.valueOf(AV64Motivoegresowwds_4_tfmegdescrip_sels.size()) ,
                                           AV63Motivoegresowwds_3_tfmegdescrip ,
                                           Integer.valueOf(AV66Motivoegresowwds_6_tfmegrelref_sels.size()) ,
                                           AV65Motivoegresowwds_5_tfmegrelref ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV61Motivoegresowwds_1_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV61Motivoegresowwds_1_tfmegcodigo), 20, "%") ;
      lV63Motivoegresowwds_3_tfmegdescrip = GXutil.concat( GXutil.rtrim( AV63Motivoegresowwds_3_tfmegdescrip), "%", "") ;
      lV65Motivoegresowwds_5_tfmegrelref = GXutil.concat( GXutil.rtrim( AV65Motivoegresowwds_5_tfmegrelref), "%", "") ;
      /* Using cursor P01IM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), lV61Motivoegresowwds_1_tfmegcodigo, lV63Motivoegresowwds_3_tfmegdescrip, lV65Motivoegresowwds_5_tfmegrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01IM2_A3CliCod[0] ;
         A2017MegRelRef = P01IM2_A2017MegRelRef[0] ;
         A300MegDescrip = P01IM2_A300MegDescrip[0] ;
         A11MegCodigo = P01IM2_A11MegCodigo[0] ;
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
         AV67GXV5 = 1 ;
         while ( AV67GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV67GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A11MegCodigo, GXv_char9) ;
                  motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A300MegDescrip, GXv_char9) ;
                  motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2017MegRelRef, GXv_char9) ;
                  motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV67GXV5 = (int)(AV67GXV5+1) ;
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV47IsAuthorizedMegRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV44CliCod, GXv_boolean4) ;
      motivoegresowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV47IsAuthorizedMegRelRef = (boolean)((!GXt_boolean3)) ;
   }

   public void S201( )
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "MegCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "MegDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV44CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "MegRelRef", "", "Liberación", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "MotivoEgresoWWColumnsSelector", GXv_char9) ;
      motivoegresowwexport.this.GXt_char8 = GXv_char9[0] ;
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

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("MotivoEgresoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MotivoEgresoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("MotivoEgresoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV68GXV6 = 1 ;
      while ( AV68GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV68GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO") == 0 )
         {
            AV36TFMegCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO_SEL") == 0 )
         {
            AV35TFMegCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFMegCodigo_Sels.fromJSonString(AV35TFMegCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGDESCRIP") == 0 )
         {
            AV40TFMegDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGDESCRIP_SEL") == 0 )
         {
            AV39TFMegDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFMegDescrip_Sels.fromJSonString(AV39TFMegDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGRELREF") == 0 )
         {
            AV50TFMegRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGRELREF_SEL") == 0 )
         {
            AV49TFMegRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFMegRelRef_Sels.fromJSonString(AV49TFMegRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV46MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV68GXV6 = (int)(AV68GXV6+1) ;
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
      this.aP0[0] = motivoegresowwexport.this.AV12Filename;
      this.aP1[0] = motivoegresowwexport.this.AV13ErrorMessage;
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
      AV55Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFMegCodigo_Sel = "" ;
      AV36TFMegCodigo = "" ;
      AV41TFMegDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFMegDescrip_Sel = "" ;
      AV40TFMegDescrip = "" ;
      AV51TFMegRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFMegRelRef_Sel = "" ;
      AV50TFMegRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A11MegCodigo = "" ;
      A300MegDescrip = "" ;
      A2017MegRelRef = "" ;
      AV61Motivoegresowwds_1_tfmegcodigo = "" ;
      AV62Motivoegresowwds_2_tfmegcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Motivoegresowwds_3_tfmegdescrip = "" ;
      AV64Motivoegresowwds_4_tfmegdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Motivoegresowwds_5_tfmegrelref = "" ;
      AV66Motivoegresowwds_6_tfmegrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Motivoegresowwds_1_tfmegcodigo = "" ;
      lV63Motivoegresowwds_3_tfmegdescrip = "" ;
      lV65Motivoegresowwds_5_tfmegrelref = "" ;
      P01IM2_A3CliCod = new int[1] ;
      P01IM2_A2017MegRelRef = new String[] {""} ;
      P01IM2_A300MegDescrip = new String[] {""} ;
      P01IM2_A11MegCodigo = new String[] {""} ;
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFMegCodigo_SelsJson = "" ;
      AV39TFMegDescrip_SelsJson = "" ;
      AV49TFMegRelRef_SelsJson = "" ;
      AV46MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresowwexport__default(),
         new Object[] {
             new Object[] {
            P01IM2_A3CliCod, P01IM2_A2017MegRelRef, P01IM2_A300MegDescrip, P01IM2_A11MegCodigo
            }
         }
      );
      AV55Pgmname = "MotivoEgresoWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "MotivoEgresoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV56GXV1 ;
   private int AV57GXV2 ;
   private int AV58GXV3 ;
   private int AV59GXV4 ;
   private int AV62Motivoegresowwds_2_tfmegcodigo_sels_size ;
   private int AV64Motivoegresowwds_4_tfmegdescrip_sels_size ;
   private int AV66Motivoegresowwds_6_tfmegrelref_sels_size ;
   private int A3CliCod ;
   private int AV67GXV5 ;
   private int AV68GXV6 ;
   private long AV43i ;
   private long AV32VisibleColumnCount ;
   private String AV55Pgmname ;
   private String AV38TFMegCodigo_Sel ;
   private String AV36TFMegCodigo ;
   private String A11MegCodigo ;
   private String AV61Motivoegresowwds_1_tfmegcodigo ;
   private String scmdbuf ;
   private String lV61Motivoegresowwds_1_tfmegcodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV47IsAuthorizedMegRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFMegCodigo_SelsJson ;
   private String AV39TFMegDescrip_SelsJson ;
   private String AV49TFMegRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFMegDescrip_Sel ;
   private String AV40TFMegDescrip ;
   private String AV52TFMegRelRef_Sel ;
   private String AV50TFMegRelRef ;
   private String A300MegDescrip ;
   private String A2017MegRelRef ;
   private String AV63Motivoegresowwds_3_tfmegdescrip ;
   private String AV65Motivoegresowwds_5_tfmegrelref ;
   private String lV63Motivoegresowwds_3_tfmegdescrip ;
   private String lV65Motivoegresowwds_5_tfmegrelref ;
   private String AV46MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFMegCodigo_Sels ;
   private GXSimpleCollection<String> AV41TFMegDescrip_Sels ;
   private GXSimpleCollection<String> AV51TFMegRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01IM2_A3CliCod ;
   private String[] P01IM2_A2017MegRelRef ;
   private String[] P01IM2_A300MegDescrip ;
   private String[] P01IM2_A11MegCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV62Motivoegresowwds_2_tfmegcodigo_sels ;
   private GXSimpleCollection<String> AV64Motivoegresowwds_4_tfmegdescrip_sels ;
   private GXSimpleCollection<String> AV66Motivoegresowwds_6_tfmegrelref_sels ;
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

final  class motivoegresowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV62Motivoegresowwds_2_tfmegcodigo_sels ,
                                          String A300MegDescrip ,
                                          GXSimpleCollection<String> AV64Motivoegresowwds_4_tfmegdescrip_sels ,
                                          String A2017MegRelRef ,
                                          GXSimpleCollection<String> AV66Motivoegresowwds_6_tfmegrelref_sels ,
                                          int AV62Motivoegresowwds_2_tfmegcodigo_sels_size ,
                                          String AV61Motivoegresowwds_1_tfmegcodigo ,
                                          int AV64Motivoegresowwds_4_tfmegdescrip_sels_size ,
                                          String AV63Motivoegresowwds_3_tfmegdescrip ,
                                          int AV66Motivoegresowwds_6_tfmegrelref_sels_size ,
                                          String AV65Motivoegresowwds_5_tfmegrelref ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV44CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[4];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, MegRelRef, MegDescrip, MegCodigo FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Motivoegresowwds_2_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Motivoegresowwds_1_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV62Motivoegresowwds_2_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Motivoegresowwds_2_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( ( AV64Motivoegresowwds_4_tfmegdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Motivoegresowwds_3_tfmegdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV64Motivoegresowwds_4_tfmegdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Motivoegresowwds_4_tfmegdescrip_sels, "MegDescrip IN (", ")")+")");
      }
      if ( ( AV66Motivoegresowwds_6_tfmegrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Motivoegresowwds_5_tfmegrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV66Motivoegresowwds_6_tfmegrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Motivoegresowwds_6_tfmegrelref_sels, "MegRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MegCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MegCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MegDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MegDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MegRelRef" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MegRelRef DESC" ;
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
                  return conditional_P01IM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
      }
   }

}

