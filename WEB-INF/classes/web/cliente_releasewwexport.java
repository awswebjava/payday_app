package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cliente_releasewwexport extends GXProcedure
{
   public cliente_releasewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_releasewwexport.class ), "" );
   }

   public cliente_releasewwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      cliente_releasewwexport.this.aP1 = new String[] {""};
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
      cliente_releasewwexport.this.aP0 = aP0;
      cliente_releasewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Release", GXv_boolean2) ;
      cliente_releasewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Cliente_ReleaseWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFCliRelNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV56GXV1 = 1 ;
         while ( AV56GXV1 <= AV37TFCliRelNombre_Sels.size() )
         {
            AV38TFCliRelNombre_Sel = (String)AV37TFCliRelNombre_Sels.elementAt(-1+AV56GXV1) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFCliRelNombre_Sel, GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV56GXV1 = (int)(AV56GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFCliRelNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFCliRelNombre, GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFCliReleaseDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripcion", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV57GXV2 = 1 ;
         while ( AV57GXV2 <= AV41TFCliReleaseDes_Sels.size() )
         {
            AV42TFCliReleaseDes_Sel = (String)AV41TFCliReleaseDes_Sels.elementAt(-1+AV57GXV2) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFCliReleaseDes_Sel, GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV57GXV2 = (int)(AV57GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFCliReleaseDes)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripcion", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFCliReleaseDes, GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV43TFCliRelease) && GXutil.dateCompare(GXutil.nullDate(), AV44TFCliRelease_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha/hora de liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( AV43TFCliRelease );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( AV44TFCliRelease_To );
      }
      if ( ! ( (0==AV45TFCliReHabilitado_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Habilitado", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV45TFCliReHabilitado_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV45TFCliReHabilitado_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV48TFCliReObs_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV58GXV3 = 1 ;
         while ( AV58GXV3 <= AV48TFCliReObs_Sels.size() )
         {
            AV49TFCliReObs_Sel = (String)AV48TFCliReObs_Sels.elementAt(-1+AV58GXV3) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV49TFCliReObs_Sel, 1, 1000), GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV58GXV3 = (int)(AV58GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFCliReObs)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observaciones", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            cliente_releasewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV47TFCliReObs, 1, 1000), GXv_char7) ;
            cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("Cliente_ReleaseWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Cliente_ReleaseWWColumnsSelector") ;
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
      AV61Cliente_releasewwds_1_tfclirelnombre = AV36TFCliRelNombre ;
      AV62Cliente_releasewwds_2_tfclirelnombre_sels = AV37TFCliRelNombre_Sels ;
      AV63Cliente_releasewwds_3_tfclireleasedes = AV40TFCliReleaseDes ;
      AV64Cliente_releasewwds_4_tfclireleasedes_sels = AV41TFCliReleaseDes_Sels ;
      AV65Cliente_releasewwds_5_tfclirelease = AV43TFCliRelease ;
      AV66Cliente_releasewwds_6_tfclirelease_to = AV44TFCliRelease_To ;
      AV67Cliente_releasewwds_7_tfclirehabilitado_sel = AV45TFCliReHabilitado_Sel ;
      AV68Cliente_releasewwds_8_tfclireobs = AV47TFCliReObs ;
      AV69Cliente_releasewwds_9_tfclireobs_sels = AV48TFCliReObs_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1973CliRelNombre ,
                                           AV62Cliente_releasewwds_2_tfclirelnombre_sels ,
                                           A1879CliReleaseDes ,
                                           AV64Cliente_releasewwds_4_tfclireleasedes_sels ,
                                           A1878CliReObs ,
                                           AV69Cliente_releasewwds_9_tfclireobs_sels ,
                                           Integer.valueOf(AV62Cliente_releasewwds_2_tfclirelnombre_sels.size()) ,
                                           AV61Cliente_releasewwds_1_tfclirelnombre ,
                                           Integer.valueOf(AV64Cliente_releasewwds_4_tfclireleasedes_sels.size()) ,
                                           AV63Cliente_releasewwds_3_tfclireleasedes ,
                                           AV65Cliente_releasewwds_5_tfclirelease ,
                                           AV66Cliente_releasewwds_6_tfclirelease_to ,
                                           Byte.valueOf(AV67Cliente_releasewwds_7_tfclirehabilitado_sel) ,
                                           Integer.valueOf(AV69Cliente_releasewwds_9_tfclireobs_sels.size()) ,
                                           AV68Cliente_releasewwds_8_tfclireobs ,
                                           A1876CliRelease ,
                                           Boolean.valueOf(A1877CliReHabilitado) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV51CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV61Cliente_releasewwds_1_tfclirelnombre = GXutil.concat( GXutil.rtrim( AV61Cliente_releasewwds_1_tfclirelnombre), "%", "") ;
      lV63Cliente_releasewwds_3_tfclireleasedes = GXutil.concat( GXutil.rtrim( AV63Cliente_releasewwds_3_tfclireleasedes), "%", "") ;
      lV68Cliente_releasewwds_8_tfclireobs = GXutil.concat( GXutil.rtrim( AV68Cliente_releasewwds_8_tfclireobs), "%", "") ;
      /* Using cursor P02FR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV51CliCod), lV61Cliente_releasewwds_1_tfclirelnombre, lV63Cliente_releasewwds_3_tfclireleasedes, AV65Cliente_releasewwds_5_tfclirelease, AV66Cliente_releasewwds_6_tfclirelease_to, lV68Cliente_releasewwds_8_tfclireobs});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02FR2_A3CliCod[0] ;
         A1878CliReObs = P02FR2_A1878CliReObs[0] ;
         A1877CliReHabilitado = P02FR2_A1877CliReHabilitado[0] ;
         A1876CliRelease = P02FR2_A1876CliRelease[0] ;
         A1879CliReleaseDes = P02FR2_A1879CliReleaseDes[0] ;
         A1973CliRelNombre = P02FR2_A1973CliRelNombre[0] ;
         A1885CliRelSec = P02FR2_A1885CliRelSec[0] ;
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
         AV70GXV5 = 1 ;
         while ( AV70GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV70GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliRelNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1973CliRelNombre, GXv_char7) ;
                  cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliReleaseDes") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1879CliReleaseDes, GXv_char7) ;
                  cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliRelease") == 0 )
               {
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( A1876CliRelease );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliReHabilitado") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1877CliReHabilitado) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliReObs") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1878CliReObs, 1, 1000), GXv_char7) ;
                  cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV70GXV5 = (int)(AV70GXV5+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliRelNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliReleaseDes", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliRelease", "", "Fecha/hora de liberación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliReHabilitado", "", "Habilitado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliReObs", "", "Observaciones", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Cliente_ReleaseWWColumnsSelector", GXv_char7) ;
      cliente_releasewwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("Cliente_ReleaseWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Cliente_ReleaseWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Cliente_ReleaseWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV71GXV6 = 1 ;
      while ( AV71GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV71GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELNOMBRE") == 0 )
         {
            AV36TFCliRelNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELNOMBRE_SEL") == 0 )
         {
            AV35TFCliRelNombre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFCliRelNombre_Sels.fromJSonString(AV35TFCliRelNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASEDES") == 0 )
         {
            AV40TFCliReleaseDes = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASEDES_SEL") == 0 )
         {
            AV39TFCliReleaseDes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFCliReleaseDes_Sels.fromJSonString(AV39TFCliReleaseDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIRELEASE") == 0 )
         {
            AV43TFCliRelease = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV44TFCliRelease_To = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREHABILITADO_SEL") == 0 )
         {
            AV45TFCliReHabilitado_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREOBS") == 0 )
         {
            AV47TFCliReObs = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIREOBS_SEL") == 0 )
         {
            AV46TFCliReObs_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFCliReObs_Sels.fromJSonString(AV46TFCliReObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV71GXV6 = (int)(AV71GXV6+1) ;
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
      this.aP0[0] = cliente_releasewwexport.this.AV12Filename;
      this.aP1[0] = cliente_releasewwexport.this.AV13ErrorMessage;
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
      AV55Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFCliRelNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFCliRelNombre_Sel = "" ;
      AV36TFCliRelNombre = "" ;
      AV41TFCliReleaseDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFCliReleaseDes_Sel = "" ;
      AV40TFCliReleaseDes = "" ;
      AV43TFCliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV44TFCliRelease_To = GXutil.resetTime( GXutil.nullDate() );
      AV48TFCliReObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFCliReObs_Sel = "" ;
      AV47TFCliReObs = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1973CliRelNombre = "" ;
      A1879CliReleaseDes = "" ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      A1878CliReObs = "" ;
      AV61Cliente_releasewwds_1_tfclirelnombre = "" ;
      AV62Cliente_releasewwds_2_tfclirelnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Cliente_releasewwds_3_tfclireleasedes = "" ;
      AV64Cliente_releasewwds_4_tfclireleasedes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Cliente_releasewwds_5_tfclirelease = GXutil.resetTime( GXutil.nullDate() );
      AV66Cliente_releasewwds_6_tfclirelease_to = GXutil.resetTime( GXutil.nullDate() );
      AV68Cliente_releasewwds_8_tfclireobs = "" ;
      AV69Cliente_releasewwds_9_tfclireobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Cliente_releasewwds_1_tfclirelnombre = "" ;
      lV63Cliente_releasewwds_3_tfclireleasedes = "" ;
      lV68Cliente_releasewwds_8_tfclireobs = "" ;
      P02FR2_A3CliCod = new int[1] ;
      P02FR2_A1878CliReObs = new String[] {""} ;
      P02FR2_A1877CliReHabilitado = new boolean[] {false} ;
      P02FR2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P02FR2_A1879CliReleaseDes = new String[] {""} ;
      P02FR2_A1973CliRelNombre = new String[] {""} ;
      P02FR2_A1885CliRelSec = new int[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFCliRelNombre_SelsJson = "" ;
      AV39TFCliReleaseDes_SelsJson = "" ;
      AV46TFCliReObs_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_releasewwexport__default(),
         new Object[] {
             new Object[] {
            P02FR2_A3CliCod, P02FR2_A1878CliReObs, P02FR2_A1877CliReHabilitado, P02FR2_A1876CliRelease, P02FR2_A1879CliReleaseDes, P02FR2_A1973CliRelNombre, P02FR2_A1885CliRelSec
            }
         }
      );
      AV55Pgmname = "Cliente_ReleaseWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "Cliente_ReleaseWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV45TFCliReHabilitado_Sel ;
   private byte AV67Cliente_releasewwds_7_tfclirehabilitado_sel ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV56GXV1 ;
   private int AV57GXV2 ;
   private int AV58GXV3 ;
   private int AV59GXV4 ;
   private int AV62Cliente_releasewwds_2_tfclirelnombre_sels_size ;
   private int AV64Cliente_releasewwds_4_tfclireleasedes_sels_size ;
   private int AV69Cliente_releasewwds_9_tfclireobs_sels_size ;
   private int AV51CliCod ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private int AV70GXV5 ;
   private int AV71GXV6 ;
   private long AV50i ;
   private long AV32VisibleColumnCount ;
   private String AV55Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV43TFCliRelease ;
   private java.util.Date AV44TFCliRelease_To ;
   private java.util.Date A1876CliRelease ;
   private java.util.Date AV65Cliente_releasewwds_5_tfclirelease ;
   private java.util.Date AV66Cliente_releasewwds_6_tfclirelease_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A1877CliReHabilitado ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String A1878CliReObs ;
   private String AV28UserCustomValue ;
   private String AV35TFCliRelNombre_SelsJson ;
   private String AV39TFCliReleaseDes_SelsJson ;
   private String AV46TFCliReObs_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFCliRelNombre_Sel ;
   private String AV36TFCliRelNombre ;
   private String AV42TFCliReleaseDes_Sel ;
   private String AV40TFCliReleaseDes ;
   private String AV49TFCliReObs_Sel ;
   private String AV47TFCliReObs ;
   private String A1973CliRelNombre ;
   private String A1879CliReleaseDes ;
   private String AV61Cliente_releasewwds_1_tfclirelnombre ;
   private String AV63Cliente_releasewwds_3_tfclireleasedes ;
   private String AV68Cliente_releasewwds_8_tfclireobs ;
   private String lV61Cliente_releasewwds_1_tfclirelnombre ;
   private String lV63Cliente_releasewwds_3_tfclireleasedes ;
   private String lV68Cliente_releasewwds_8_tfclireobs ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFCliRelNombre_Sels ;
   private GXSimpleCollection<String> AV41TFCliReleaseDes_Sels ;
   private GXSimpleCollection<String> AV48TFCliReObs_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FR2_A3CliCod ;
   private String[] P02FR2_A1878CliReObs ;
   private boolean[] P02FR2_A1877CliReHabilitado ;
   private java.util.Date[] P02FR2_A1876CliRelease ;
   private String[] P02FR2_A1879CliReleaseDes ;
   private String[] P02FR2_A1973CliRelNombre ;
   private int[] P02FR2_A1885CliRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV62Cliente_releasewwds_2_tfclirelnombre_sels ;
   private GXSimpleCollection<String> AV64Cliente_releasewwds_4_tfclireleasedes_sels ;
   private GXSimpleCollection<String> AV69Cliente_releasewwds_9_tfclireobs_sels ;
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

final  class cliente_releasewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1973CliRelNombre ,
                                          GXSimpleCollection<String> AV62Cliente_releasewwds_2_tfclirelnombre_sels ,
                                          String A1879CliReleaseDes ,
                                          GXSimpleCollection<String> AV64Cliente_releasewwds_4_tfclireleasedes_sels ,
                                          String A1878CliReObs ,
                                          GXSimpleCollection<String> AV69Cliente_releasewwds_9_tfclireobs_sels ,
                                          int AV62Cliente_releasewwds_2_tfclirelnombre_sels_size ,
                                          String AV61Cliente_releasewwds_1_tfclirelnombre ,
                                          int AV64Cliente_releasewwds_4_tfclireleasedes_sels_size ,
                                          String AV63Cliente_releasewwds_3_tfclireleasedes ,
                                          java.util.Date AV65Cliente_releasewwds_5_tfclirelease ,
                                          java.util.Date AV66Cliente_releasewwds_6_tfclirelease_to ,
                                          byte AV67Cliente_releasewwds_7_tfclirehabilitado_sel ,
                                          int AV69Cliente_releasewwds_9_tfclireobs_sels_size ,
                                          String AV68Cliente_releasewwds_8_tfclireobs ,
                                          java.util.Date A1876CliRelease ,
                                          boolean A1877CliReHabilitado ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV51CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[6];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliCod, CliReObs, CliReHabilitado, CliRelease, CliReleaseDes, CliRelNombre, CliRelSec FROM Cliente_Release" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV62Cliente_releasewwds_2_tfclirelnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Cliente_releasewwds_1_tfclirelnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliRelNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV62Cliente_releasewwds_2_tfclirelnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Cliente_releasewwds_2_tfclirelnombre_sels, "CliRelNombre IN (", ")")+")");
      }
      if ( ( AV64Cliente_releasewwds_4_tfclireleasedes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Cliente_releasewwds_3_tfclireleasedes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReleaseDes) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV64Cliente_releasewwds_4_tfclireleasedes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Cliente_releasewwds_4_tfclireleasedes_sels, "CliReleaseDes IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV65Cliente_releasewwds_5_tfclirelease) )
      {
         addWhere(sWhereString, "(CliRelease >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV66Cliente_releasewwds_6_tfclirelease_to) )
      {
         addWhere(sWhereString, "(CliRelease <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV67Cliente_releasewwds_7_tfclirehabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(CliReHabilitado = TRUE)");
      }
      if ( AV67Cliente_releasewwds_7_tfclirehabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(CliReHabilitado = FALSE)");
      }
      if ( ( AV69Cliente_releasewwds_9_tfclireobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Cliente_releasewwds_8_tfclireobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliReObs) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV69Cliente_releasewwds_9_tfclireobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Cliente_releasewwds_9_tfclireobs_sels, "CliReObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY CliCod, CliRelSec DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliRelNombre" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliRelNombre DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliReleaseDes" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliReleaseDes DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliRelease" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliRelease DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliReHabilitado" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliReHabilitado DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliReObs" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliReObs DESC" ;
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
                  return conditional_P02FR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).shortValue() , ((Boolean) dynConstraints[18]).booleanValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[10], false);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               return;
      }
   }

}

