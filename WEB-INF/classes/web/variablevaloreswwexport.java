package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variablevaloreswwexport extends GXProcedure
{
   public variablevaloreswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablevaloreswwexport.class ), "" );
   }

   public variablevaloreswwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      variablevaloreswwexport.this.aP1 = new String[] {""};
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
      variablevaloreswwexport.this.aP0 = aP0;
      variablevaloreswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV49CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      variablevaloreswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV49CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores", GXv_boolean4) ;
      variablevaloreswwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "VariableValoresWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFOpeCliId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV55GXV1 = 1 ;
         while ( AV55GXV1 <= AV37TFOpeCliId_Sels.size() )
         {
            AV38TFOpeCliId_Sel = (String)AV37TFOpeCliId_Sels.elementAt(-1+AV55GXV1) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFOpeCliId_Sel, GXv_char9) ;
            variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV48i = (long)(AV48i+1) ;
            AV55GXV1 = (int)(AV55GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFOpeCliId)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFOpeCliId, GXv_char9) ;
            variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV39TFOpeCliVig)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV40TFOpeCliVig_To)) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Vigencia desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         GXt_dtime10 = GXutil.resetTime( AV39TFOpeCliVig );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime10 );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         GXt_dtime10 = GXutil.resetTime( AV40TFOpeCliVig_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime10 );
      }
      if ( ! ( ( AV43TFOpeCliValor_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Valor", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV56GXV2 = 1 ;
         while ( AV56GXV2 <= AV43TFOpeCliValor_Sels.size() )
         {
            AV44TFOpeCliValor_Sel = (String)AV43TFOpeCliValor_Sels.elementAt(-1+AV56GXV2) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV44TFOpeCliValor_Sel, 1, 1000), GXv_char9) ;
            variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV48i = (long)(AV48i+1) ;
            AV56GXV2 = (int)(AV56GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFOpeCliValor)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Valor", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV42TFOpeCliValor, 1, 1000), GXv_char9) ;
            variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV45TFOpeCliVPropagar_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "(borrar)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV45TFOpeCliVPropagar_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV45TFOpeCliVPropagar_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFOpeCliVRetro)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV47TFOpeCliVRetro_To)) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Retroactivo a", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         GXt_dtime10 = GXutil.resetTime( AV46TFOpeCliVRetro );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime10 );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variablevaloreswwexport.this.AV14CellRow = GXv_int7[0] ;
         GXt_dtime10 = GXutil.resetTime( AV47TFOpeCliVRetro_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime10 );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("VariableValoresWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("VariableValoresWWColumnsSelector") ;
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
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliCod" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV57GXV3 = 1 ;
      while ( AV57GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV57GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV57GXV3 = (int)(AV57GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV59Variablevaloreswwds_1_tfopecliid = AV36TFOpeCliId ;
      AV60Variablevaloreswwds_2_tfopecliid_sels = AV37TFOpeCliId_Sels ;
      AV61Variablevaloreswwds_3_tfopeclivig = AV39TFOpeCliVig ;
      AV62Variablevaloreswwds_4_tfopeclivig_to = AV40TFOpeCliVig_To ;
      AV63Variablevaloreswwds_5_tfopeclivalor = AV42TFOpeCliValor ;
      AV64Variablevaloreswwds_6_tfopeclivalor_sels = AV43TFOpeCliValor_Sels ;
      AV65Variablevaloreswwds_7_tfopeclivpropagar_sel = AV45TFOpeCliVPropagar_Sel ;
      AV66Variablevaloreswwds_8_tfopeclivretro = AV46TFOpeCliVRetro ;
      AV67Variablevaloreswwds_9_tfopeclivretro_to = AV47TFOpeCliVRetro_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV60Variablevaloreswwds_2_tfopecliid_sels ,
                                           A535OpeCliValor ,
                                           AV64Variablevaloreswwds_6_tfopeclivalor_sels ,
                                           Integer.valueOf(AV60Variablevaloreswwds_2_tfopecliid_sels.size()) ,
                                           AV59Variablevaloreswwds_1_tfopecliid ,
                                           AV61Variablevaloreswwds_3_tfopeclivig ,
                                           AV62Variablevaloreswwds_4_tfopeclivig_to ,
                                           Integer.valueOf(AV64Variablevaloreswwds_6_tfopeclivalor_sels.size()) ,
                                           AV63Variablevaloreswwds_5_tfopeclivalor ,
                                           Byte.valueOf(AV65Variablevaloreswwds_7_tfopeclivpropagar_sel) ,
                                           AV66Variablevaloreswwds_8_tfopeclivretro ,
                                           AV67Variablevaloreswwds_9_tfopeclivretro_to ,
                                           A754OpeCliVig ,
                                           Boolean.valueOf(A924OpeCliVPropagar) ,
                                           A1146OpeCliVRetro ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV59Variablevaloreswwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV59Variablevaloreswwds_1_tfopecliid), 40, "%") ;
      lV63Variablevaloreswwds_5_tfopeclivalor = GXutil.concat( GXutil.rtrim( AV63Variablevaloreswwds_5_tfopeclivalor), "%", "") ;
      /* Using cursor P01KE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV49CliCod), lV59Variablevaloreswwds_1_tfopecliid, AV61Variablevaloreswwds_3_tfopeclivig, AV62Variablevaloreswwds_4_tfopeclivig_to, lV63Variablevaloreswwds_5_tfopeclivalor, AV66Variablevaloreswwds_8_tfopeclivretro, AV67Variablevaloreswwds_9_tfopeclivretro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01KE2_A3CliCod[0] ;
         A1146OpeCliVRetro = P01KE2_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = P01KE2_n1146OpeCliVRetro[0] ;
         A924OpeCliVPropagar = P01KE2_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = P01KE2_n924OpeCliVPropagar[0] ;
         A535OpeCliValor = P01KE2_A535OpeCliValor[0] ;
         A754OpeCliVig = P01KE2_A754OpeCliVig[0] ;
         A82OpeCliId = P01KE2_A82OpeCliId[0] ;
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
         AV68GXV4 = 1 ;
         while ( AV68GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV68GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliId") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A82OpeCliId, GXv_char9) ;
                  variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliVig") == 0 )
               {
                  GXt_dtime10 = GXutil.resetTime( A754OpeCliVig );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime10 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliValor") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A535OpeCliValor, 1, 1000), GXv_char9) ;
                  variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliVPropagar") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A924OpeCliVPropagar) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliVRetro") == 0 )
               {
                  GXt_dtime10 = GXutil.resetTime( A1146OpeCliVRetro );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime10 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV68GXV4 = (int)(AV68GXV4+1) ;
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
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "OpeCliId", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "OpeCliVig", "", "Vigencia desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "OpeCliValor", "", "Valor", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "OpeCliVPropagar", "", "(borrar)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "OpeCliVRetro", "", "Retroactivo a", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "VariableValoresWWColumnsSelector", GXv_char9) ;
      variablevaloreswwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, GXv_SdtWWPColumnsSelector12) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector11[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("VariableValoresWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "VariableValoresWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("VariableValoresWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV69GXV5 = 1 ;
      while ( AV69GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV69GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID") == 0 )
         {
            AV36TFOpeCliId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID_SEL") == 0 )
         {
            AV35TFOpeCliId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFOpeCliId_Sels.fromJSonString(AV35TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVIG") == 0 )
         {
            AV39TFOpeCliVig = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV40TFOpeCliVig_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVALOR") == 0 )
         {
            AV42TFOpeCliValor = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVALOR_SEL") == 0 )
         {
            AV41TFOpeCliValor_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFOpeCliValor_Sels.fromJSonString(AV41TFOpeCliValor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVPROPAGAR_SEL") == 0 )
         {
            AV45TFOpeCliVPropagar_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVRETRO") == 0 )
         {
            AV46TFOpeCliVRetro = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV47TFOpeCliVRetro_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV69GXV5 = (int)(AV69GXV5+1) ;
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
      this.aP0[0] = variablevaloreswwexport.this.AV12Filename;
      this.aP1[0] = variablevaloreswwexport.this.AV13ErrorMessage;
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
      AV54Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFOpeCliId_Sel = "" ;
      AV36TFOpeCliId = "" ;
      AV39TFOpeCliVig = GXutil.nullDate() ;
      AV40TFOpeCliVig_To = GXutil.nullDate() ;
      AV43TFOpeCliValor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFOpeCliValor_Sel = "" ;
      AV42TFOpeCliValor = "" ;
      AV46TFOpeCliVRetro = GXutil.nullDate() ;
      AV47TFOpeCliVRetro_To = GXutil.nullDate() ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A82OpeCliId = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A535OpeCliValor = "" ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      AV59Variablevaloreswwds_1_tfopecliid = "" ;
      AV60Variablevaloreswwds_2_tfopecliid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Variablevaloreswwds_3_tfopeclivig = GXutil.nullDate() ;
      AV62Variablevaloreswwds_4_tfopeclivig_to = GXutil.nullDate() ;
      AV63Variablevaloreswwds_5_tfopeclivalor = "" ;
      AV64Variablevaloreswwds_6_tfopeclivalor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Variablevaloreswwds_8_tfopeclivretro = GXutil.nullDate() ;
      AV67Variablevaloreswwds_9_tfopeclivretro_to = GXutil.nullDate() ;
      scmdbuf = "" ;
      lV59Variablevaloreswwds_1_tfopecliid = "" ;
      lV63Variablevaloreswwds_5_tfopeclivalor = "" ;
      P01KE2_A3CliCod = new int[1] ;
      P01KE2_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P01KE2_n1146OpeCliVRetro = new boolean[] {false} ;
      P01KE2_A924OpeCliVPropagar = new boolean[] {false} ;
      P01KE2_n924OpeCliVPropagar = new boolean[] {false} ;
      P01KE2_A535OpeCliValor = new String[] {""} ;
      P01KE2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01KE2_A82OpeCliId = new String[] {""} ;
      GXt_dtime10 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFOpeCliId_SelsJson = "" ;
      AV41TFOpeCliValor_SelsJson = "" ;
      AV51MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablevaloreswwexport__default(),
         new Object[] {
             new Object[] {
            P01KE2_A3CliCod, P01KE2_A1146OpeCliVRetro, P01KE2_n1146OpeCliVRetro, P01KE2_A924OpeCliVPropagar, P01KE2_n924OpeCliVPropagar, P01KE2_A535OpeCliValor, P01KE2_A754OpeCliVig, P01KE2_A82OpeCliId
            }
         }
      );
      AV54Pgmname = "VariableValoresWWExport" ;
      /* GeneXus formulas. */
      AV54Pgmname = "VariableValoresWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV45TFOpeCliVPropagar_Sel ;
   private byte AV65Variablevaloreswwds_7_tfopeclivpropagar_sel ;
   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV55GXV1 ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int A3CliCod ;
   private int AV60Variablevaloreswwds_2_tfopecliid_sels_size ;
   private int AV64Variablevaloreswwds_6_tfopeclivalor_sels_size ;
   private int AV68GXV4 ;
   private int AV69GXV5 ;
   private long AV48i ;
   private long AV32VisibleColumnCount ;
   private String AV54Pgmname ;
   private String AV38TFOpeCliId_Sel ;
   private String AV36TFOpeCliId ;
   private String A82OpeCliId ;
   private String AV59Variablevaloreswwds_1_tfopecliid ;
   private String scmdbuf ;
   private String lV59Variablevaloreswwds_1_tfopecliid ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private java.util.Date GXt_dtime10 ;
   private java.util.Date AV39TFOpeCliVig ;
   private java.util.Date AV40TFOpeCliVig_To ;
   private java.util.Date AV46TFOpeCliVRetro ;
   private java.util.Date AV47TFOpeCliVRetro_To ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private java.util.Date AV61Variablevaloreswwds_3_tfopeclivig ;
   private java.util.Date AV62Variablevaloreswwds_4_tfopeclivig_to ;
   private java.util.Date AV66Variablevaloreswwds_8_tfopeclivretro ;
   private java.util.Date AV67Variablevaloreswwds_9_tfopeclivretro_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A924OpeCliVPropagar ;
   private boolean AV19OrderedDsc ;
   private boolean n1146OpeCliVRetro ;
   private boolean n924OpeCliVPropagar ;
   private String AV27ColumnsSelectorXML ;
   private String A535OpeCliValor ;
   private String AV28UserCustomValue ;
   private String AV35TFOpeCliId_SelsJson ;
   private String AV41TFOpeCliValor_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV44TFOpeCliValor_Sel ;
   private String AV42TFOpeCliValor ;
   private String AV63Variablevaloreswwds_5_tfopeclivalor ;
   private String lV63Variablevaloreswwds_5_tfopeclivalor ;
   private String AV51MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFOpeCliId_Sels ;
   private GXSimpleCollection<String> AV43TFOpeCliValor_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01KE2_A3CliCod ;
   private java.util.Date[] P01KE2_A1146OpeCliVRetro ;
   private boolean[] P01KE2_n1146OpeCliVRetro ;
   private boolean[] P01KE2_A924OpeCliVPropagar ;
   private boolean[] P01KE2_n924OpeCliVPropagar ;
   private String[] P01KE2_A535OpeCliValor ;
   private java.util.Date[] P01KE2_A754OpeCliVig ;
   private String[] P01KE2_A82OpeCliId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV60Variablevaloreswwds_2_tfopecliid_sels ;
   private GXSimpleCollection<String> AV64Variablevaloreswwds_6_tfopeclivalor_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class variablevaloreswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV60Variablevaloreswwds_2_tfopecliid_sels ,
                                          String A535OpeCliValor ,
                                          GXSimpleCollection<String> AV64Variablevaloreswwds_6_tfopeclivalor_sels ,
                                          int AV60Variablevaloreswwds_2_tfopecliid_sels_size ,
                                          String AV59Variablevaloreswwds_1_tfopecliid ,
                                          java.util.Date AV61Variablevaloreswwds_3_tfopeclivig ,
                                          java.util.Date AV62Variablevaloreswwds_4_tfopeclivig_to ,
                                          int AV64Variablevaloreswwds_6_tfopeclivalor_sels_size ,
                                          String AV63Variablevaloreswwds_5_tfopeclivalor ,
                                          byte AV65Variablevaloreswwds_7_tfopeclivpropagar_sel ,
                                          java.util.Date AV66Variablevaloreswwds_8_tfopeclivretro ,
                                          java.util.Date AV67Variablevaloreswwds_9_tfopeclivretro_to ,
                                          java.util.Date A754OpeCliVig ,
                                          boolean A924OpeCliVPropagar ,
                                          java.util.Date A1146OpeCliVRetro ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV49CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[7];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliVRetro, OpeCliVPropagar, OpeCliValor, OpeCliVig, OpeCliId FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV60Variablevaloreswwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Variablevaloreswwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int13[1] = (byte)(1) ;
      }
      if ( AV60Variablevaloreswwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Variablevaloreswwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Variablevaloreswwds_3_tfopeclivig)) )
      {
         addWhere(sWhereString, "(OpeCliVig >= ?)");
      }
      else
      {
         GXv_int13[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Variablevaloreswwds_4_tfopeclivig_to)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( ( AV64Variablevaloreswwds_6_tfopeclivalor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Variablevaloreswwds_5_tfopeclivalor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliValor) like LOWER(?))");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( AV64Variablevaloreswwds_6_tfopeclivalor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Variablevaloreswwds_6_tfopeclivalor_sels, "OpeCliValor IN (", ")")+")");
      }
      if ( AV65Variablevaloreswwds_7_tfopeclivpropagar_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = TRUE)");
      }
      if ( AV65Variablevaloreswwds_7_tfopeclivpropagar_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliVPropagar = FALSE)");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66Variablevaloreswwds_8_tfopeclivretro)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro >= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV67Variablevaloreswwds_9_tfopeclivretro_to)) )
      {
         addWhere(sWhereString, "(OpeCliVRetro <= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliVig" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliVig DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliValor" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliValor DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliVPropagar" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliVPropagar DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliVRetro" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliVRetro DESC" ;
      }
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_P01KE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 40);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               return;
      }
   }

}

