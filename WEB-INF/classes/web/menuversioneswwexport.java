package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuversioneswwexport extends GXProcedure
{
   public menuversioneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuversioneswwexport.class ), "" );
   }

   public menuversioneswwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      menuversioneswwexport.this.aP1 = new String[] {""};
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
      menuversioneswwexport.this.aP0 = aP0;
      menuversioneswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones", GXv_boolean2) ;
      menuversioneswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "MenuVersionesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFRolNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Rol", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV56GXV1 = 1 ;
         while ( AV56GXV1 <= AV37TFRolNombre_Sels.size() )
         {
            AV38TFRolNombre_Sel = (String)AV37TFRolNombre_Sels.elementAt(-1+AV56GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFRolNombre_Sel, GXv_char7) ;
            menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV56GXV1 = (int)(AV56GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFRolNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Rol", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFRolNombre, GXv_char7) ;
            menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFPerfilNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Perfil", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV57GXV2 = 1 ;
         while ( AV57GXV2 <= AV41TFPerfilNombre_Sels.size() )
         {
            AV42TFPerfilNombre_Sel = (String)AV41TFPerfilNombre_Sels.elementAt(-1+AV57GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPerfilNombre_Sel, GXv_char7) ;
            menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV57GXV2 = (int)(AV57GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFPerfilNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Perfil", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPerfilNombre, GXv_char7) ;
            menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFMenuVerId) && (0==AV44TFMenuVerId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Menú", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV43TFMenuVerId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV44TFMenuVerId_To );
      }
      if ( ! ( ( AV47TFMenuPais_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pais", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV58GXV3 = 1 ;
         while ( AV58GXV3 <= AV47TFMenuPais_Sels.size() )
         {
            AV48TFMenuPais_Sel = ((Number) AV47TFMenuPais_Sels.elementAt(-1+AV58GXV3)).shortValue() ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV49TFMenuPais_SelDsc = GXutil.trim( GXutil.str( AV48TFMenuPais_Sel, 4, 0)) ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+AV49TFMenuPais_SelDsc );
            AV50i = (long)(AV50i+1) ;
            AV58GXV3 = (int)(AV58GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFMenuPais)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pais", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuversioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFMenuPais, GXv_char7) ;
            menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("MenuVersionesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("MenuVersionesWWColumnsSelector") ;
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
      AV61Menuversioneswwds_1_tfrolnombre = AV36TFRolNombre ;
      AV62Menuversioneswwds_2_tfrolnombre_sels = AV37TFRolNombre_Sels ;
      AV63Menuversioneswwds_3_tfperfilnombre = AV40TFPerfilNombre ;
      AV64Menuversioneswwds_4_tfperfilnombre_sels = AV41TFPerfilNombre_Sels ;
      AV65Menuversioneswwds_5_tfmenuverid = AV43TFMenuVerId ;
      AV66Menuversioneswwds_6_tfmenuverid_to = AV44TFMenuVerId_To ;
      AV67Menuversioneswwds_7_tfmenupais = AV46TFMenuPais ;
      AV68Menuversioneswwds_8_tfmenupais_sels = AV47TFMenuPais_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1924RolNombre ,
                                           AV62Menuversioneswwds_2_tfrolnombre_sels ,
                                           A1926PerfilNombre ,
                                           AV64Menuversioneswwds_4_tfperfilnombre_sels ,
                                           Short.valueOf(A1927MenuPais) ,
                                           AV68Menuversioneswwds_8_tfmenupais_sels ,
                                           Integer.valueOf(AV62Menuversioneswwds_2_tfrolnombre_sels.size()) ,
                                           AV61Menuversioneswwds_1_tfrolnombre ,
                                           Integer.valueOf(AV64Menuversioneswwds_4_tfperfilnombre_sels.size()) ,
                                           AV63Menuversioneswwds_3_tfperfilnombre ,
                                           Long.valueOf(AV65Menuversioneswwds_5_tfmenuverid) ,
                                           Long.valueOf(AV66Menuversioneswwds_6_tfmenuverid_to) ,
                                           Integer.valueOf(AV68Menuversioneswwds_8_tfmenupais_sels.size()) ,
                                           AV67Menuversioneswwds_7_tfmenupais ,
                                           Long.valueOf(A1928MenuVerId) ,
                                           A312PaiNom ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV51CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV61Menuversioneswwds_1_tfrolnombre = GXutil.concat( GXutil.rtrim( AV61Menuversioneswwds_1_tfrolnombre), "%", "") ;
      lV63Menuversioneswwds_3_tfperfilnombre = GXutil.concat( GXutil.rtrim( AV63Menuversioneswwds_3_tfperfilnombre), "%", "") ;
      lV67Menuversioneswwds_7_tfmenupais = GXutil.concat( GXutil.rtrim( AV67Menuversioneswwds_7_tfmenupais), "%", "") ;
      /* Using cursor P02FW2 */
      pr_default.execute(0, new Object[] {lV61Menuversioneswwds_1_tfrolnombre, lV63Menuversioneswwds_3_tfperfilnombre, Long.valueOf(AV65Menuversioneswwds_5_tfmenuverid), Long.valueOf(AV66Menuversioneswwds_6_tfmenuverid_to), lV67Menuversioneswwds_7_tfmenupais});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = P02FW2_A1923RolId[0] ;
         A1925PerfilId = P02FW2_A1925PerfilId[0] ;
         A312PaiNom = P02FW2_A312PaiNom[0] ;
         n312PaiNom = P02FW2_n312PaiNom[0] ;
         A1927MenuPais = P02FW2_A1927MenuPais[0] ;
         n1927MenuPais = P02FW2_n1927MenuPais[0] ;
         A1928MenuVerId = P02FW2_A1928MenuVerId[0] ;
         A1926PerfilNombre = P02FW2_A1926PerfilNombre[0] ;
         A1924RolNombre = P02FW2_A1924RolNombre[0] ;
         A1924RolNombre = P02FW2_A1924RolNombre[0] ;
         A1926PerfilNombre = P02FW2_A1926PerfilNombre[0] ;
         A312PaiNom = P02FW2_A312PaiNom[0] ;
         n312PaiNom = P02FW2_n312PaiNom[0] ;
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
         AV69GXV5 = 1 ;
         while ( AV69GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV69GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "RolNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1924RolNombre, GXv_char7) ;
                  menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PerfilNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1926PerfilNombre, GXv_char7) ;
                  menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MenuVerId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1928MenuVerId );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MenuPais") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A312PaiNom, GXv_char7) ;
                  menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RolNombre", "", "Rol", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PerfilNombre", "", "Perfil", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MenuVerId", "", "Menú", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MenuPais", "", "Pais", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "MenuVersionesWWColumnsSelector", GXv_char7) ;
      menuversioneswwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("MenuVersionesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MenuVersionesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("MenuVersionesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV70GXV6 = 1 ;
      while ( AV70GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE") == 0 )
         {
            AV36TFRolNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE_SEL") == 0 )
         {
            AV35TFRolNombre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFRolNombre_Sels.fromJSonString(AV35TFRolNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE") == 0 )
         {
            AV40TFPerfilNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE_SEL") == 0 )
         {
            AV39TFPerfilNombre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFPerfilNombre_Sels.fromJSonString(AV39TFPerfilNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUVERID") == 0 )
         {
            AV43TFMenuVerId = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV44TFMenuVerId_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUPAIS") == 0 )
         {
            AV46TFMenuPais = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUPAIS_SEL") == 0 )
         {
            AV45TFMenuPais_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFMenuPais_Sels.fromJSonString(AV45TFMenuPais_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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
      this.aP0[0] = menuversioneswwexport.this.AV12Filename;
      this.aP1[0] = menuversioneswwexport.this.AV13ErrorMessage;
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
      AV37TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFRolNombre_Sel = "" ;
      AV36TFRolNombre = "" ;
      AV41TFPerfilNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFPerfilNombre_Sel = "" ;
      AV40TFPerfilNombre = "" ;
      AV47TFMenuPais_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV49TFMenuPais_SelDsc = "" ;
      AV46TFMenuPais = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1924RolNombre = "" ;
      A1926PerfilNombre = "" ;
      A312PaiNom = "" ;
      AV61Menuversioneswwds_1_tfrolnombre = "" ;
      AV62Menuversioneswwds_2_tfrolnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Menuversioneswwds_3_tfperfilnombre = "" ;
      AV64Menuversioneswwds_4_tfperfilnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Menuversioneswwds_7_tfmenupais = "" ;
      AV68Menuversioneswwds_8_tfmenupais_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      lV61Menuversioneswwds_1_tfrolnombre = "" ;
      lV63Menuversioneswwds_3_tfperfilnombre = "" ;
      lV67Menuversioneswwds_7_tfmenupais = "" ;
      P02FW2_A1923RolId = new byte[1] ;
      P02FW2_A1925PerfilId = new byte[1] ;
      P02FW2_A312PaiNom = new String[] {""} ;
      P02FW2_n312PaiNom = new boolean[] {false} ;
      P02FW2_A1927MenuPais = new short[1] ;
      P02FW2_n1927MenuPais = new boolean[] {false} ;
      P02FW2_A1928MenuVerId = new long[1] ;
      P02FW2_A1926PerfilNombre = new String[] {""} ;
      P02FW2_A1924RolNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFRolNombre_SelsJson = "" ;
      AV39TFPerfilNombre_SelsJson = "" ;
      AV45TFMenuPais_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuversioneswwexport__default(),
         new Object[] {
             new Object[] {
            P02FW2_A1923RolId, P02FW2_A1925PerfilId, P02FW2_A312PaiNom, P02FW2_n312PaiNom, P02FW2_A1927MenuPais, P02FW2_n1927MenuPais, P02FW2_A1928MenuVerId, P02FW2_A1926PerfilNombre, P02FW2_A1924RolNombre
            }
         }
      );
      AV55Pgmname = "MenuVersionesWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "MenuVersionesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private short AV48TFMenuPais_Sel ;
   private short GXv_int5[] ;
   private short A1927MenuPais ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV56GXV1 ;
   private int AV57GXV2 ;
   private int AV58GXV3 ;
   private int AV59GXV4 ;
   private int AV62Menuversioneswwds_2_tfrolnombre_sels_size ;
   private int AV64Menuversioneswwds_4_tfperfilnombre_sels_size ;
   private int AV68Menuversioneswwds_8_tfmenupais_sels_size ;
   private int AV51CliCod ;
   private int AV69GXV5 ;
   private int AV70GXV6 ;
   private long AV50i ;
   private long AV43TFMenuVerId ;
   private long AV44TFMenuVerId_To ;
   private long AV32VisibleColumnCount ;
   private long A1928MenuVerId ;
   private long AV65Menuversioneswwds_5_tfmenuverid ;
   private long AV66Menuversioneswwds_6_tfmenuverid_to ;
   private String AV55Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n312PaiNom ;
   private boolean n1927MenuPais ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFRolNombre_SelsJson ;
   private String AV39TFPerfilNombre_SelsJson ;
   private String AV45TFMenuPais_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFRolNombre_Sel ;
   private String AV36TFRolNombre ;
   private String AV42TFPerfilNombre_Sel ;
   private String AV40TFPerfilNombre ;
   private String AV49TFMenuPais_SelDsc ;
   private String AV46TFMenuPais ;
   private String A1924RolNombre ;
   private String A1926PerfilNombre ;
   private String A312PaiNom ;
   private String AV61Menuversioneswwds_1_tfrolnombre ;
   private String AV63Menuversioneswwds_3_tfperfilnombre ;
   private String AV67Menuversioneswwds_7_tfmenupais ;
   private String lV61Menuversioneswwds_1_tfrolnombre ;
   private String lV63Menuversioneswwds_3_tfperfilnombre ;
   private String lV67Menuversioneswwds_7_tfmenupais ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Short> AV47TFMenuPais_Sels ;
   private GXSimpleCollection<Short> AV68Menuversioneswwds_8_tfmenupais_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFRolNombre_Sels ;
   private GXSimpleCollection<String> AV41TFPerfilNombre_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02FW2_A1923RolId ;
   private byte[] P02FW2_A1925PerfilId ;
   private String[] P02FW2_A312PaiNom ;
   private boolean[] P02FW2_n312PaiNom ;
   private short[] P02FW2_A1927MenuPais ;
   private boolean[] P02FW2_n1927MenuPais ;
   private long[] P02FW2_A1928MenuVerId ;
   private String[] P02FW2_A1926PerfilNombre ;
   private String[] P02FW2_A1924RolNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV62Menuversioneswwds_2_tfrolnombre_sels ;
   private GXSimpleCollection<String> AV64Menuversioneswwds_4_tfperfilnombre_sels ;
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

final  class menuversioneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV62Menuversioneswwds_2_tfrolnombre_sels ,
                                          String A1926PerfilNombre ,
                                          GXSimpleCollection<String> AV64Menuversioneswwds_4_tfperfilnombre_sels ,
                                          short A1927MenuPais ,
                                          GXSimpleCollection<Short> AV68Menuversioneswwds_8_tfmenupais_sels ,
                                          int AV62Menuversioneswwds_2_tfrolnombre_sels_size ,
                                          String AV61Menuversioneswwds_1_tfrolnombre ,
                                          int AV64Menuversioneswwds_4_tfperfilnombre_sels_size ,
                                          String AV63Menuversioneswwds_3_tfperfilnombre ,
                                          long AV65Menuversioneswwds_5_tfmenuverid ,
                                          long AV66Menuversioneswwds_6_tfmenuverid_to ,
                                          int AV68Menuversioneswwds_8_tfmenupais_sels_size ,
                                          String AV67Menuversioneswwds_7_tfmenupais ,
                                          long A1928MenuVerId ,
                                          String A312PaiNom ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV51CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.PerfilId, T4.PaiNom, T1.MenuPais AS MenuPais, T1.MenuVerId, T3.PerfilNombre, T2.RolNombre FROM (((MenuVersiones T1 INNER JOIN RolUsuario T2 ON" ;
      scmdbuf += " T2.RolId = T1.RolId) INNER JOIN Perfil T3 ON T3.PerfilId = T1.PerfilId) LEFT JOIN Pais T4 ON T4.PaiCod = T1.MenuPais)" ;
      if ( ( AV62Menuversioneswwds_2_tfrolnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Menuversioneswwds_1_tfrolnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV62Menuversioneswwds_2_tfrolnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Menuversioneswwds_2_tfrolnombre_sels, "T2.RolNombre IN (", ")")+")");
      }
      if ( ( AV64Menuversioneswwds_4_tfperfilnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Menuversioneswwds_3_tfperfilnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.PerfilNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV64Menuversioneswwds_4_tfperfilnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Menuversioneswwds_4_tfperfilnombre_sels, "T3.PerfilNombre IN (", ")")+")");
      }
      if ( ! (0==AV65Menuversioneswwds_5_tfmenuverid) )
      {
         addWhere(sWhereString, "(T1.MenuVerId >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV66Menuversioneswwds_6_tfmenuverid_to) )
      {
         addWhere(sWhereString, "(T1.MenuVerId <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV68Menuversioneswwds_8_tfmenupais_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Menuversioneswwds_7_tfmenupais)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV68Menuversioneswwds_8_tfmenupais_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Menuversioneswwds_8_tfmenupais_sels, "T1.MenuPais IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.RolNombre" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.RolNombre DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.PerfilNombre" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.PerfilNombre DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.MenuVerId" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.MenuVerId DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.MenuPais" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.MenuPais DESC" ;
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
                  return conditional_P02FW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[8]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               return;
      }
   }

}

