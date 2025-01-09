package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obrasocialwwexport extends GXProcedure
{
   public obrasocialwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obrasocialwwexport.class ), "" );
   }

   public obrasocialwwexport( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      obrasocialwwexport.this.aP1 = new String[] {""};
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
      obrasocialwwexport.this.aP0 = aP0;
      obrasocialwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV50CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obrasocialwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV50CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObraSocial", GXv_boolean4) ;
      obrasocialwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV65Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ObraSocialWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFOsoCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV49i = 1 ;
         AV66GXV1 = 1 ;
         while ( AV66GXV1 <= AV37TFOsoCod_Sels.size() )
         {
            AV38TFOsoCod_Sel = (String)AV37TFOsoCod_Sels.elementAt(-1+AV66GXV1) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFOsoCod_Sel, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV49i = (long)(AV49i+1) ;
            AV66GXV1 = (int)(AV66GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFOsoCod)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFOsoCod, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFOsoDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Obra Social", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV49i = 1 ;
         AV67GXV2 = 1 ;
         while ( AV67GXV2 <= AV41TFOsoDescrip_Sels.size() )
         {
            AV42TFOsoDescrip_Sel = (String)AV41TFOsoDescrip_Sels.elementAt(-1+AV67GXV2) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFOsoDescrip_Sel, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV49i = (long)(AV49i+1) ;
            AV67GXV2 = (int)(AV67GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFOsoDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Obra Social", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFOsoDescrip, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV54TFOsoSigla_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Sigla", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV49i = 1 ;
         AV68GXV3 = 1 ;
         while ( AV68GXV3 <= AV54TFOsoSigla_Sels.size() )
         {
            AV55TFOsoSigla_Sel = (String)AV54TFOsoSigla_Sels.elementAt(-1+AV68GXV3) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFOsoSigla_Sel, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV49i = (long)(AV49i+1) ;
            AV68GXV3 = (int)(AV68GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV53TFOsoSigla)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Sigla", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFOsoSigla, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV45TFOsoC3992_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código de AFIP", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV49i = 1 ;
         AV69GXV4 = 1 ;
         while ( AV69GXV4 <= AV45TFOsoC3992_Sels.size() )
         {
            AV46TFOsoC3992_Sel = (String)AV45TFOsoC3992_Sels.elementAt(-1+AV69GXV4) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFOsoC3992_Sel, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV49i = (long)(AV49i+1) ;
            AV69GXV4 = (int)(AV69GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFOsoC3992)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código de AFIP", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFOsoC3992, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFOsoAporteAdic)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFOsoAporteAdic_To)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Aporte adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFOsoAporteAdic)) );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFOsoAporteAdic_To)) );
      }
      if ( ! ( ( AV61TFOsoRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV49i = 1 ;
         AV70GXV5 = 1 ;
         while ( AV70GXV5 <= AV61TFOsoRelRef_Sels.size() )
         {
            AV62TFOsoRelRef_Sel = (String)AV61TFOsoRelRef_Sels.elementAt(-1+AV70GXV5) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFOsoRelRef_Sel, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV49i = (long)(AV49i+1) ;
            AV70GXV5 = (int)(AV70GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV60TFOsoRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            obrasocialwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFOsoRelRef, GXv_char9) ;
            obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ObraSocialWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ObraSocialWWColumnsSelector") ;
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
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cli Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV57IsAuthorizedOsoRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV71GXV6 = 1 ;
      while ( AV71GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV71GXV6));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV71GXV6 = (int)(AV71GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV73Obrasocialwwds_1_tfosocod = AV36TFOsoCod ;
      AV74Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV75Obrasocialwwds_3_tfosodescrip = AV40TFOsoDescrip ;
      AV76Obrasocialwwds_4_tfosodescrip_sels = AV41TFOsoDescrip_Sels ;
      AV77Obrasocialwwds_5_tfososigla = AV53TFOsoSigla ;
      AV78Obrasocialwwds_6_tfososigla_sels = AV54TFOsoSigla_Sels ;
      AV79Obrasocialwwds_7_tfosoc3992 = AV44TFOsoC3992 ;
      AV80Obrasocialwwds_8_tfosoc3992_sels = AV45TFOsoC3992_Sels ;
      AV81Obrasocialwwds_9_tfosoaporteadic = AV47TFOsoAporteAdic ;
      AV82Obrasocialwwds_10_tfosoaporteadic_to = AV48TFOsoAporteAdic_To ;
      AV83Obrasocialwwds_11_tfosorelref = AV60TFOsoRelRef ;
      AV84Obrasocialwwds_12_tfosorelref_sels = AV61TFOsoRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV74Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV76Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV78Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV80Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV84Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV74Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV73Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV76Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV75Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV78Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV77Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV80Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV79Obrasocialwwds_7_tfosoc3992 ,
                                           AV81Obrasocialwwds_9_tfosoaporteadic ,
                                           AV82Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV84Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV83Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV50CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV73Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV73Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV75Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV75Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV77Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV77Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV79Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV79Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV83Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV83Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P01JZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV50CliCod), lV73Obrasocialwwds_1_tfosocod, lV75Obrasocialwwds_3_tfosodescrip, lV77Obrasocialwwds_5_tfososigla, lV79Obrasocialwwds_7_tfosoc3992, AV81Obrasocialwwds_9_tfosoaporteadic, AV82Obrasocialwwds_10_tfosoaporteadic_to, lV83Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01JZ2_A3CliCod[0] ;
         A2014OsoRelRef = P01JZ2_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P01JZ2_A893OsoAporteAdic[0] ;
         A306OsoC3992 = P01JZ2_A306OsoC3992[0] ;
         n306OsoC3992 = P01JZ2_n306OsoC3992[0] ;
         A392OsoSigla = P01JZ2_A392OsoSigla[0] ;
         A307OsoDescrip = P01JZ2_A307OsoDescrip[0] ;
         A5OsoCod = P01JZ2_A5OsoCod[0] ;
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
         AV85GXV7 = 1 ;
         while ( AV85GXV7 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV85GXV7));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoCod") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A5OsoCod, GXv_char9) ;
                  obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A307OsoDescrip, GXv_char9) ;
                  obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoSigla") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A392OsoSigla, GXv_char9) ;
                  obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoC3992") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A306OsoC3992, GXv_char9) ;
                  obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoAporteAdic") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A893OsoAporteAdic)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OsoRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2014OsoRelRef, GXv_char9) ;
                  obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV85GXV7 = (int)(AV85GXV7+1) ;
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
      GXt_boolean3 = AV57IsAuthorizedOsoRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV50CliCod, GXv_boolean4) ;
      obrasocialwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV57IsAuthorizedOsoRelRef = (boolean)((!GXt_boolean3)) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoCod", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoDescrip", "", "Obra Social", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoSigla", "", "Sigla", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoC3992", "", "Código de AFIP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoAporteAdic", "", "Aporte adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV50CliCod) )
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
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "OsoRelRef", "", "Liberación", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ObraSocialWWColumnsSelector", GXv_char9) ;
      obrasocialwwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ObraSocialWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ObraSocialWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ObraSocialWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV86GXV8 = 1 ;
      while ( AV86GXV8 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV86GXV8));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOCOD") == 0 )
         {
            AV36TFOsoCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOCOD_SEL") == 0 )
         {
            AV35TFOsoCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFOsoCod_Sels.fromJSonString(AV35TFOsoCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSODESCRIP") == 0 )
         {
            AV40TFOsoDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSODESCRIP_SEL") == 0 )
         {
            AV39TFOsoDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFOsoDescrip_Sels.fromJSonString(AV39TFOsoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOSIGLA") == 0 )
         {
            AV53TFOsoSigla = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOSIGLA_SEL") == 0 )
         {
            AV52TFOsoSigla_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFOsoSigla_Sels.fromJSonString(AV52TFOsoSigla_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOC3992") == 0 )
         {
            AV44TFOsoC3992 = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOC3992_SEL") == 0 )
         {
            AV43TFOsoC3992_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFOsoC3992_Sels.fromJSonString(AV43TFOsoC3992_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOAPORTEADIC") == 0 )
         {
            AV47TFOsoAporteAdic = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV48TFOsoAporteAdic_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSORELREF") == 0 )
         {
            AV60TFOsoRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSORELREF_SEL") == 0 )
         {
            AV59TFOsoRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFOsoRelRef_Sels.fromJSonString(AV59TFOsoRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV56MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV86GXV8 = (int)(AV86GXV8+1) ;
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
      this.aP0[0] = obrasocialwwexport.this.AV12Filename;
      this.aP1[0] = obrasocialwwexport.this.AV13ErrorMessage;
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
      AV65Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFOsoCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFOsoCod_Sel = "" ;
      AV36TFOsoCod = "" ;
      AV41TFOsoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFOsoDescrip_Sel = "" ;
      AV40TFOsoDescrip = "" ;
      AV54TFOsoSigla_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFOsoSigla_Sel = "" ;
      AV53TFOsoSigla = "" ;
      AV45TFOsoC3992_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFOsoC3992_Sel = "" ;
      AV44TFOsoC3992 = "" ;
      AV47TFOsoAporteAdic = DecimalUtil.ZERO ;
      AV48TFOsoAporteAdic_To = DecimalUtil.ZERO ;
      AV61TFOsoRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFOsoRelRef_Sel = "" ;
      AV60TFOsoRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A5OsoCod = "" ;
      A307OsoDescrip = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      A2014OsoRelRef = "" ;
      AV73Obrasocialwwds_1_tfosocod = "" ;
      AV74Obrasocialwwds_2_tfosocod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Obrasocialwwds_3_tfosodescrip = "" ;
      AV76Obrasocialwwds_4_tfosodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Obrasocialwwds_5_tfososigla = "" ;
      AV78Obrasocialwwds_6_tfososigla_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Obrasocialwwds_7_tfosoc3992 = "" ;
      AV80Obrasocialwwds_8_tfosoc3992_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81Obrasocialwwds_9_tfosoaporteadic = DecimalUtil.ZERO ;
      AV82Obrasocialwwds_10_tfosoaporteadic_to = DecimalUtil.ZERO ;
      AV83Obrasocialwwds_11_tfosorelref = "" ;
      AV84Obrasocialwwds_12_tfosorelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV73Obrasocialwwds_1_tfosocod = "" ;
      lV75Obrasocialwwds_3_tfosodescrip = "" ;
      lV77Obrasocialwwds_5_tfososigla = "" ;
      lV79Obrasocialwwds_7_tfosoc3992 = "" ;
      lV83Obrasocialwwds_11_tfosorelref = "" ;
      P01JZ2_A3CliCod = new int[1] ;
      P01JZ2_A2014OsoRelRef = new String[] {""} ;
      P01JZ2_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JZ2_A306OsoC3992 = new String[] {""} ;
      P01JZ2_n306OsoC3992 = new boolean[] {false} ;
      P01JZ2_A392OsoSigla = new String[] {""} ;
      P01JZ2_A307OsoDescrip = new String[] {""} ;
      P01JZ2_A5OsoCod = new String[] {""} ;
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFOsoCod_SelsJson = "" ;
      AV39TFOsoDescrip_SelsJson = "" ;
      AV52TFOsoSigla_SelsJson = "" ;
      AV43TFOsoC3992_SelsJson = "" ;
      AV59TFOsoRelRef_SelsJson = "" ;
      AV56MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obrasocialwwexport__default(),
         new Object[] {
             new Object[] {
            P01JZ2_A3CliCod, P01JZ2_A2014OsoRelRef, P01JZ2_A893OsoAporteAdic, P01JZ2_A306OsoC3992, P01JZ2_n306OsoC3992, P01JZ2_A392OsoSigla, P01JZ2_A307OsoDescrip, P01JZ2_A5OsoCod
            }
         }
      );
      AV65Pgmname = "ObraSocialWWExport" ;
      /* GeneXus formulas. */
      AV65Pgmname = "ObraSocialWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV50CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV66GXV1 ;
   private int AV67GXV2 ;
   private int AV68GXV3 ;
   private int AV69GXV4 ;
   private int AV70GXV5 ;
   private int AV71GXV6 ;
   private int A3CliCod ;
   private int AV74Obrasocialwwds_2_tfosocod_sels_size ;
   private int AV76Obrasocialwwds_4_tfosodescrip_sels_size ;
   private int AV78Obrasocialwwds_6_tfososigla_sels_size ;
   private int AV80Obrasocialwwds_8_tfosoc3992_sels_size ;
   private int AV84Obrasocialwwds_12_tfosorelref_sels_size ;
   private int AV85GXV7 ;
   private int AV86GXV8 ;
   private long AV49i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV47TFOsoAporteAdic ;
   private java.math.BigDecimal AV48TFOsoAporteAdic_To ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private java.math.BigDecimal AV81Obrasocialwwds_9_tfosoaporteadic ;
   private java.math.BigDecimal AV82Obrasocialwwds_10_tfosoaporteadic_to ;
   private String AV65Pgmname ;
   private String AV38TFOsoCod_Sel ;
   private String AV36TFOsoCod ;
   private String AV55TFOsoSigla_Sel ;
   private String AV53TFOsoSigla ;
   private String AV46TFOsoC3992_Sel ;
   private String AV44TFOsoC3992 ;
   private String A5OsoCod ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String AV73Obrasocialwwds_1_tfosocod ;
   private String AV77Obrasocialwwds_5_tfososigla ;
   private String AV79Obrasocialwwds_7_tfosoc3992 ;
   private String scmdbuf ;
   private String lV73Obrasocialwwds_1_tfosocod ;
   private String lV77Obrasocialwwds_5_tfososigla ;
   private String lV79Obrasocialwwds_7_tfosoc3992 ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV57IsAuthorizedOsoRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean n306OsoC3992 ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFOsoCod_SelsJson ;
   private String AV39TFOsoDescrip_SelsJson ;
   private String AV52TFOsoSigla_SelsJson ;
   private String AV43TFOsoC3992_SelsJson ;
   private String AV59TFOsoRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFOsoDescrip_Sel ;
   private String AV40TFOsoDescrip ;
   private String AV62TFOsoRelRef_Sel ;
   private String AV60TFOsoRelRef ;
   private String A307OsoDescrip ;
   private String A2014OsoRelRef ;
   private String AV75Obrasocialwwds_3_tfosodescrip ;
   private String AV83Obrasocialwwds_11_tfosorelref ;
   private String lV75Obrasocialwwds_3_tfosodescrip ;
   private String lV83Obrasocialwwds_11_tfosorelref ;
   private String AV56MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFOsoCod_Sels ;
   private GXSimpleCollection<String> AV54TFOsoSigla_Sels ;
   private GXSimpleCollection<String> AV45TFOsoC3992_Sels ;
   private GXSimpleCollection<String> AV41TFOsoDescrip_Sels ;
   private GXSimpleCollection<String> AV61TFOsoRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01JZ2_A3CliCod ;
   private String[] P01JZ2_A2014OsoRelRef ;
   private java.math.BigDecimal[] P01JZ2_A893OsoAporteAdic ;
   private String[] P01JZ2_A306OsoC3992 ;
   private boolean[] P01JZ2_n306OsoC3992 ;
   private String[] P01JZ2_A392OsoSigla ;
   private String[] P01JZ2_A307OsoDescrip ;
   private String[] P01JZ2_A5OsoCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV74Obrasocialwwds_2_tfosocod_sels ;
   private GXSimpleCollection<String> AV78Obrasocialwwds_6_tfososigla_sels ;
   private GXSimpleCollection<String> AV80Obrasocialwwds_8_tfosoc3992_sels ;
   private GXSimpleCollection<String> AV76Obrasocialwwds_4_tfosodescrip_sels ;
   private GXSimpleCollection<String> AV84Obrasocialwwds_12_tfosorelref_sels ;
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

final  class obrasocialwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV74Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV76Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV78Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV80Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV84Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV74Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV73Obrasocialwwds_1_tfosocod ,
                                          int AV76Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV75Obrasocialwwds_3_tfosodescrip ,
                                          int AV78Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV77Obrasocialwwds_5_tfososigla ,
                                          int AV80Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV79Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV81Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV82Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV84Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV83Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV50CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[8];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoRelRef, OsoAporteAdic, OsoC3992, OsoSigla, OsoDescrip, OsoCod FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV74Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV74Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV76Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV76Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV78Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV78Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV80Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV80Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ( AV84Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV83Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( AV84Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoSigla" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoSigla DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoC3992" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoC3992 DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoAporteAdic" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoAporteAdic DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OsoRelRef" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OsoRelRef DESC" ;
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
                  return conditional_P01JZ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
      }
   }

}

