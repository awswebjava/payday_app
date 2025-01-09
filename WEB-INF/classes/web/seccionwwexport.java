package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class seccionwwexport extends GXProcedure
{
   public seccionwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seccionwwexport.class ), "" );
   }

   public seccionwwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      seccionwwexport.this.aP1 = new String[] {""};
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
      seccionwwexport.this.aP0 = aP0;
      seccionwwexport.this.aP1 = aP1;
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
      seccionwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV44CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion", GXv_boolean4) ;
      seccionwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV56Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "SeccionWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFSecCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV57GXV1 = 1 ;
         while ( AV57GXV1 <= AV37TFSecCodigo_Sels.size() )
         {
            AV38TFSecCodigo_Sel = (String)AV37TFSecCodigo_Sels.elementAt(-1+AV57GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSecCodigo_Sel, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV57GXV1 = (int)(AV57GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFSecCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFSecCodigo, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFSecDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Area", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV58GXV2 = 1 ;
         while ( AV58GXV2 <= AV41TFSecDescrip_Sels.size() )
         {
            AV42TFSecDescrip_Sel = (String)AV41TFSecDescrip_Sels.elementAt(-1+AV58GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFSecDescrip_Sel, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV58GXV2 = (int)(AV58GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFSecDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Area", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSecDescrip, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV53TFSecApoOpc_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es opcional la liquidación de descuentos de ley", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV53TFSecApoOpc_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV53TFSecApoOpc_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV51TFSecRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV43i = 1 ;
         AV59GXV3 = 1 ;
         while ( AV59GXV3 <= AV51TFSecRelRef_Sels.size() )
         {
            AV52TFSecRelRef_Sel = (String)AV51TFSecRelRef_Sels.elementAt(-1+AV59GXV3) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFSecRelRef_Sel, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV43i = (long)(AV43i+1) ;
            AV59GXV3 = (int)(AV59GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFSecRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            seccionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFSecRelRef, GXv_char9) ;
            seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("SeccionWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("SeccionWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV47IsAuthorizedSecRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV60GXV4 = 1 ;
      while ( AV60GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV60GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV60GXV4 = (int)(AV60GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV62Seccionwwds_1_tfseccodigo = AV36TFSecCodigo ;
      AV63Seccionwwds_2_tfseccodigo_sels = AV37TFSecCodigo_Sels ;
      AV64Seccionwwds_3_tfsecdescrip = AV40TFSecDescrip ;
      AV65Seccionwwds_4_tfsecdescrip_sels = AV41TFSecDescrip_Sels ;
      AV66Seccionwwds_5_tfsecapoopc_sel = AV53TFSecApoOpc_Sel ;
      AV67Seccionwwds_6_tfsecrelref = AV50TFSecRelRef ;
      AV68Seccionwwds_7_tfsecrelref_sels = AV51TFSecRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV63Seccionwwds_2_tfseccodigo_sels ,
                                           A329SecDescrip ,
                                           AV65Seccionwwds_4_tfsecdescrip_sels ,
                                           A2015SecRelRef ,
                                           AV68Seccionwwds_7_tfsecrelref_sels ,
                                           Integer.valueOf(AV63Seccionwwds_2_tfseccodigo_sels.size()) ,
                                           AV62Seccionwwds_1_tfseccodigo ,
                                           Integer.valueOf(AV65Seccionwwds_4_tfsecdescrip_sels.size()) ,
                                           AV64Seccionwwds_3_tfsecdescrip ,
                                           Byte.valueOf(AV66Seccionwwds_5_tfsecapoopc_sel) ,
                                           Integer.valueOf(AV68Seccionwwds_7_tfsecrelref_sels.size()) ,
                                           AV67Seccionwwds_6_tfsecrelref ,
                                           Boolean.valueOf(A2308SecApoOpc) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV62Seccionwwds_1_tfseccodigo = GXutil.padr( GXutil.rtrim( AV62Seccionwwds_1_tfseccodigo), 20, "%") ;
      lV64Seccionwwds_3_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV64Seccionwwds_3_tfsecdescrip), "%", "") ;
      lV67Seccionwwds_6_tfsecrelref = GXutil.concat( GXutil.rtrim( AV67Seccionwwds_6_tfsecrelref), "%", "") ;
      /* Using cursor P01IK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), lV62Seccionwwds_1_tfseccodigo, lV64Seccionwwds_3_tfsecdescrip, lV67Seccionwwds_6_tfsecrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01IK2_A3CliCod[0] ;
         A2015SecRelRef = P01IK2_A2015SecRelRef[0] ;
         A2308SecApoOpc = P01IK2_A2308SecApoOpc[0] ;
         A329SecDescrip = P01IK2_A329SecDescrip[0] ;
         A13SecCodigo = P01IK2_A13SecCodigo[0] ;
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
         AV69GXV5 = 1 ;
         while ( AV69GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV69GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A13SecCodigo, GXv_char9) ;
                  seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A329SecDescrip, GXv_char9) ;
                  seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecApoOpc") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2308SecApoOpc) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2015SecRelRef, GXv_char9) ;
                  seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV69GXV5 = (int)(AV69GXV5+1) ;
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
      GXt_boolean3 = AV47IsAuthorizedSecRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV44CliCod, GXv_boolean4) ;
      seccionwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV47IsAuthorizedSecRelRef = (boolean)((!GXt_boolean3)) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecDescrip", "", "Area", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecApoOpc", "", "Es opcional la liquidación de descuentos de ley", true, "") ;
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
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecRelRef", "", "Liberación", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "SeccionWWColumnsSelector", GXv_char9) ;
      seccionwwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("SeccionWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SeccionWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("SeccionWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV70GXV6 = 1 ;
      while ( AV70GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECCODIGO") == 0 )
         {
            AV36TFSecCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECCODIGO_SEL") == 0 )
         {
            AV35TFSecCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSecCodigo_Sels.fromJSonString(AV35TFSecCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV40TFSecDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV39TFSecDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSecDescrip_Sels.fromJSonString(AV39TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECAPOOPC_SEL") == 0 )
         {
            AV53TFSecApoOpc_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECRELREF") == 0 )
         {
            AV50TFSecRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECRELREF_SEL") == 0 )
         {
            AV49TFSecRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFSecRelRef_Sels.fromJSonString(AV49TFSecRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV46MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV70GXV6 = (int)(AV70GXV6+1) ;
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
      this.aP0[0] = seccionwwexport.this.AV12Filename;
      this.aP1[0] = seccionwwexport.this.AV13ErrorMessage;
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
      AV56Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFSecCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFSecCodigo_Sel = "" ;
      AV36TFSecCodigo = "" ;
      AV41TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFSecDescrip_Sel = "" ;
      AV40TFSecDescrip = "" ;
      AV51TFSecRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFSecRelRef_Sel = "" ;
      AV50TFSecRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A13SecCodigo = "" ;
      A329SecDescrip = "" ;
      A2015SecRelRef = "" ;
      AV62Seccionwwds_1_tfseccodigo = "" ;
      AV63Seccionwwds_2_tfseccodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Seccionwwds_3_tfsecdescrip = "" ;
      AV65Seccionwwds_4_tfsecdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Seccionwwds_6_tfsecrelref = "" ;
      AV68Seccionwwds_7_tfsecrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV62Seccionwwds_1_tfseccodigo = "" ;
      lV64Seccionwwds_3_tfsecdescrip = "" ;
      lV67Seccionwwds_6_tfsecrelref = "" ;
      P01IK2_A3CliCod = new int[1] ;
      P01IK2_A2015SecRelRef = new String[] {""} ;
      P01IK2_A2308SecApoOpc = new boolean[] {false} ;
      P01IK2_A329SecDescrip = new String[] {""} ;
      P01IK2_A13SecCodigo = new String[] {""} ;
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFSecCodigo_SelsJson = "" ;
      AV39TFSecDescrip_SelsJson = "" ;
      AV49TFSecRelRef_SelsJson = "" ;
      AV46MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seccionwwexport__default(),
         new Object[] {
             new Object[] {
            P01IK2_A3CliCod, P01IK2_A2015SecRelRef, P01IK2_A2308SecApoOpc, P01IK2_A329SecDescrip, P01IK2_A13SecCodigo
            }
         }
      );
      AV56Pgmname = "SeccionWWExport" ;
      /* GeneXus formulas. */
      AV56Pgmname = "SeccionWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV53TFSecApoOpc_Sel ;
   private byte AV66Seccionwwds_5_tfsecapoopc_sel ;
   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV57GXV1 ;
   private int AV58GXV2 ;
   private int AV59GXV3 ;
   private int AV60GXV4 ;
   private int AV63Seccionwwds_2_tfseccodigo_sels_size ;
   private int AV65Seccionwwds_4_tfsecdescrip_sels_size ;
   private int AV68Seccionwwds_7_tfsecrelref_sels_size ;
   private int A3CliCod ;
   private int AV69GXV5 ;
   private int AV70GXV6 ;
   private long AV43i ;
   private long AV32VisibleColumnCount ;
   private String AV56Pgmname ;
   private String AV38TFSecCodigo_Sel ;
   private String AV36TFSecCodigo ;
   private String A13SecCodigo ;
   private String AV62Seccionwwds_1_tfseccodigo ;
   private String scmdbuf ;
   private String lV62Seccionwwds_1_tfseccodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV47IsAuthorizedSecRelRef ;
   private boolean A2308SecApoOpc ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFSecCodigo_SelsJson ;
   private String AV39TFSecDescrip_SelsJson ;
   private String AV49TFSecRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFSecDescrip_Sel ;
   private String AV40TFSecDescrip ;
   private String AV52TFSecRelRef_Sel ;
   private String AV50TFSecRelRef ;
   private String A329SecDescrip ;
   private String A2015SecRelRef ;
   private String AV64Seccionwwds_3_tfsecdescrip ;
   private String AV67Seccionwwds_6_tfsecrelref ;
   private String lV64Seccionwwds_3_tfsecdescrip ;
   private String lV67Seccionwwds_6_tfsecrelref ;
   private String AV46MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFSecCodigo_Sels ;
   private GXSimpleCollection<String> AV41TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV51TFSecRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01IK2_A3CliCod ;
   private String[] P01IK2_A2015SecRelRef ;
   private boolean[] P01IK2_A2308SecApoOpc ;
   private String[] P01IK2_A329SecDescrip ;
   private String[] P01IK2_A13SecCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV63Seccionwwds_2_tfseccodigo_sels ;
   private GXSimpleCollection<String> AV65Seccionwwds_4_tfsecdescrip_sels ;
   private GXSimpleCollection<String> AV68Seccionwwds_7_tfsecrelref_sels ;
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

final  class seccionwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV63Seccionwwds_2_tfseccodigo_sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV65Seccionwwds_4_tfsecdescrip_sels ,
                                          String A2015SecRelRef ,
                                          GXSimpleCollection<String> AV68Seccionwwds_7_tfsecrelref_sels ,
                                          int AV63Seccionwwds_2_tfseccodigo_sels_size ,
                                          String AV62Seccionwwds_1_tfseccodigo ,
                                          int AV65Seccionwwds_4_tfsecdescrip_sels_size ,
                                          String AV64Seccionwwds_3_tfsecdescrip ,
                                          byte AV66Seccionwwds_5_tfsecapoopc_sel ,
                                          int AV68Seccionwwds_7_tfsecrelref_sels_size ,
                                          String AV67Seccionwwds_6_tfsecrelref ,
                                          boolean A2308SecApoOpc ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV44CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[4];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, SecRelRef, SecApoOpc, SecDescrip, SecCodigo FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV63Seccionwwds_2_tfseccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Seccionwwds_1_tfseccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV63Seccionwwds_2_tfseccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Seccionwwds_2_tfseccodigo_sels, "SecCodigo IN (", ")")+")");
      }
      if ( ( AV65Seccionwwds_4_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Seccionwwds_3_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV65Seccionwwds_4_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Seccionwwds_4_tfsecdescrip_sels, "SecDescrip IN (", ")")+")");
      }
      if ( AV66Seccionwwds_5_tfsecapoopc_sel == 1 )
      {
         addWhere(sWhereString, "(SecApoOpc = TRUE)");
      }
      if ( AV66Seccionwwds_5_tfsecapoopc_sel == 2 )
      {
         addWhere(sWhereString, "(SecApoOpc = FALSE)");
      }
      if ( ( AV68Seccionwwds_7_tfsecrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Seccionwwds_6_tfsecrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV68Seccionwwds_7_tfsecrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Seccionwwds_7_tfsecrelref_sels, "SecRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SecCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SecDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SecApoOpc" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecApoOpc DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SecRelRef" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecRelRef DESC" ;
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
                  return conditional_P01IK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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

