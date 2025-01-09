package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuitemwwexport extends GXProcedure
{
   public menuitemwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitemwwexport.class ), "" );
   }

   public menuitemwwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      menuitemwwexport.this.aP1 = new String[] {""};
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
      menuitemwwexport.this.aP0 = aP0;
      menuitemwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem", GXv_boolean2) ;
      menuitemwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV74Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "MenuItemWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV37TFPerfilId) && (0==AV38TFPerfilId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Perfil", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFPerfilId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFPerfilId_To );
      }
      if ( ! ( ( AV41TFMenuItemId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Menú item ID", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV75GXV1 = 1 ;
         while ( AV75GXV1 <= AV41TFMenuItemId_Sels.size() )
         {
            AV42TFMenuItemId_Sel = (String)AV41TFMenuItemId_Sels.elementAt(-1+AV75GXV1) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFMenuItemId_Sel, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV75GXV1 = (int)(AV75GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFMenuItemId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Menú item ID", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFMenuItemId, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV45TFMenuItemTitulo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Título por defecto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV76GXV2 = 1 ;
         while ( AV76GXV2 <= AV45TFMenuItemTitulo_Sels.size() )
         {
            AV46TFMenuItemTitulo_Sel = (String)AV45TFMenuItemTitulo_Sels.elementAt(-1+AV76GXV2) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFMenuItemTitulo_Sel, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV76GXV2 = (int)(AV76GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFMenuItemTitulo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Título por defecto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFMenuItemTitulo, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV47TFMItemEsMenu_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Es menú", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV47TFMItemEsMenu_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV47TFMItemEsMenu_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV50TFMItemPadreDef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Padre default", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV77GXV3 = 1 ;
         while ( AV77GXV3 <= AV50TFMItemPadreDef_Sels.size() )
         {
            AV51TFMItemPadreDef_Sel = (String)AV50TFMItemPadreDef_Sels.elementAt(-1+AV77GXV3) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFMItemPadreDef_Sel, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV77GXV3 = (int)(AV77GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFMItemPadreDef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Padre default", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFMItemPadreDef, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV52TFMItemPadreObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Padre default es obligatorio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV52TFMItemPadreObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV52TFMItemPadreObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV55TFMItemIcoSVG_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "SVG de ícono por defecto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV78GXV4 = 1 ;
         while ( AV78GXV4 <= AV55TFMItemIcoSVG_Sels.size() )
         {
            AV56TFMItemIcoSVG_Sel = (String)AV55TFMItemIcoSVG_Sels.elementAt(-1+AV78GXV4) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFMItemIcoSVG_Sel, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV78GXV4 = (int)(AV78GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV54TFMItemIcoSVG)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "SVG de ícono por defecto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFMItemIcoSVG, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV59TFMItemBienTitDef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Título de bienvenida por defecto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV79GXV5 = 1 ;
         while ( AV79GXV5 <= AV59TFMItemBienTitDef_Sels.size() )
         {
            AV60TFMItemBienTitDef_Sel = (String)AV59TFMItemBienTitDef_Sels.elementAt(-1+AV79GXV5) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFMItemBienTitDef_Sel, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV79GXV5 = (int)(AV79GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV58TFMItemBienTitDef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Título de bienvenida por defecto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFMItemBienTitDef, GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV63TFMItemBienTextDef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Texto de bienvenida por defecto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV80GXV6 = 1 ;
         while ( AV80GXV6 <= AV63TFMItemBienTextDef_Sels.size() )
         {
            AV64TFMItemBienTextDef_Sel = (String)AV63TFMItemBienTextDef_Sels.elementAt(-1+AV80GXV6) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV64TFMItemBienTextDef_Sel, 1, 1000), GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV80GXV6 = (int)(AV80GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV62TFMItemBienTextDef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Texto de bienvenida por defecto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV62TFMItemBienTextDef, 1, 1000), GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV67TFMItemHelp_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Help", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV69i = 1 ;
         AV81GXV7 = 1 ;
         while ( AV81GXV7 <= AV67TFMItemHelp_Sels.size() )
         {
            AV68TFMItemHelp_Sel = (String)AV67TFMItemHelp_Sels.elementAt(-1+AV81GXV7) ;
            if ( AV69i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV68TFMItemHelp_Sel, 1, 1000), GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV69i = (long)(AV69i+1) ;
            AV81GXV7 = (int)(AV81GXV7+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV66TFMItemHelp)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Help", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            menuitemwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV66TFMItemHelp, 1, 1000), GXv_char7) ;
            menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("MenuItemWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV20Session.getValue("MenuItemWWColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV82GXV8 = 1 ;
      while ( AV82GXV8 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV8));
         if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setColor( 11 );
            AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
         }
         AV82GXV8 = (int)(AV82GXV8+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV84Menuitemwwds_1_tfperfilid = AV37TFPerfilId ;
      AV85Menuitemwwds_2_tfperfilid_to = AV38TFPerfilId_To ;
      AV86Menuitemwwds_3_tfmenuitemid = AV40TFMenuItemId ;
      AV87Menuitemwwds_4_tfmenuitemid_sels = AV41TFMenuItemId_Sels ;
      AV88Menuitemwwds_5_tfmenuitemtitulo = AV44TFMenuItemTitulo ;
      AV89Menuitemwwds_6_tfmenuitemtitulo_sels = AV45TFMenuItemTitulo_Sels ;
      AV90Menuitemwwds_7_tfmitemesmenu_sel = AV47TFMItemEsMenu_Sel ;
      AV91Menuitemwwds_8_tfmitempadredef = AV49TFMItemPadreDef ;
      AV92Menuitemwwds_9_tfmitempadredef_sels = AV50TFMItemPadreDef_Sels ;
      AV93Menuitemwwds_10_tfmitempadreobl_sel = AV52TFMItemPadreObl_Sel ;
      AV94Menuitemwwds_11_tfmitemicosvg = AV54TFMItemIcoSVG ;
      AV95Menuitemwwds_12_tfmitemicosvg_sels = AV55TFMItemIcoSVG_Sels ;
      AV96Menuitemwwds_13_tfmitembientitdef = AV58TFMItemBienTitDef ;
      AV97Menuitemwwds_14_tfmitembientitdef_sels = AV59TFMItemBienTitDef_Sels ;
      AV98Menuitemwwds_15_tfmitembientextdef = AV62TFMItemBienTextDef ;
      AV99Menuitemwwds_16_tfmitembientextdef_sels = AV63TFMItemBienTextDef_Sels ;
      AV100Menuitemwwds_17_tfmitemhelp = AV66TFMItemHelp ;
      AV101Menuitemwwds_18_tfmitemhelp_sels = AV67TFMItemHelp_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1937MenuItemId ,
                                           AV87Menuitemwwds_4_tfmenuitemid_sels ,
                                           A1939MenuItemTitulo ,
                                           AV89Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                           A1944MItemPadreDef ,
                                           AV92Menuitemwwds_9_tfmitempadredef_sels ,
                                           A1957MItemIcoSVG ,
                                           AV95Menuitemwwds_12_tfmitemicosvg_sels ,
                                           A1955MItemBienTitDef ,
                                           AV97Menuitemwwds_14_tfmitembientitdef_sels ,
                                           A1956MItemBienTextDef ,
                                           AV99Menuitemwwds_16_tfmitembientextdef_sels ,
                                           A1961MItemHelp ,
                                           AV101Menuitemwwds_18_tfmitemhelp_sels ,
                                           Byte.valueOf(AV84Menuitemwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV85Menuitemwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV87Menuitemwwds_4_tfmenuitemid_sels.size()) ,
                                           AV86Menuitemwwds_3_tfmenuitemid ,
                                           Integer.valueOf(AV89Menuitemwwds_6_tfmenuitemtitulo_sels.size()) ,
                                           AV88Menuitemwwds_5_tfmenuitemtitulo ,
                                           Byte.valueOf(AV90Menuitemwwds_7_tfmitemesmenu_sel) ,
                                           Integer.valueOf(AV92Menuitemwwds_9_tfmitempadredef_sels.size()) ,
                                           AV91Menuitemwwds_8_tfmitempadredef ,
                                           Byte.valueOf(AV93Menuitemwwds_10_tfmitempadreobl_sel) ,
                                           Integer.valueOf(AV95Menuitemwwds_12_tfmitemicosvg_sels.size()) ,
                                           AV94Menuitemwwds_11_tfmitemicosvg ,
                                           Integer.valueOf(AV97Menuitemwwds_14_tfmitembientitdef_sels.size()) ,
                                           AV96Menuitemwwds_13_tfmitembientitdef ,
                                           Integer.valueOf(AV99Menuitemwwds_16_tfmitembientextdef_sels.size()) ,
                                           AV98Menuitemwwds_15_tfmitembientextdef ,
                                           Integer.valueOf(AV101Menuitemwwds_18_tfmitemhelp_sels.size()) ,
                                           AV100Menuitemwwds_17_tfmitemhelp ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Boolean.valueOf(A1938MItemEsMenu) ,
                                           Boolean.valueOf(A1945MItemPadreObl) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV70CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV86Menuitemwwds_3_tfmenuitemid = GXutil.concat( GXutil.rtrim( AV86Menuitemwwds_3_tfmenuitemid), "%", "") ;
      lV88Menuitemwwds_5_tfmenuitemtitulo = GXutil.concat( GXutil.rtrim( AV88Menuitemwwds_5_tfmenuitemtitulo), "%", "") ;
      lV91Menuitemwwds_8_tfmitempadredef = GXutil.concat( GXutil.rtrim( AV91Menuitemwwds_8_tfmitempadredef), "%", "") ;
      lV94Menuitemwwds_11_tfmitemicosvg = GXutil.padr( GXutil.rtrim( AV94Menuitemwwds_11_tfmitemicosvg), 20, "%") ;
      lV96Menuitemwwds_13_tfmitembientitdef = GXutil.concat( GXutil.rtrim( AV96Menuitemwwds_13_tfmitembientitdef), "%", "") ;
      lV98Menuitemwwds_15_tfmitembientextdef = GXutil.concat( GXutil.rtrim( AV98Menuitemwwds_15_tfmitembientextdef), "%", "") ;
      lV100Menuitemwwds_17_tfmitemhelp = GXutil.concat( GXutil.rtrim( AV100Menuitemwwds_17_tfmitemhelp), "%", "") ;
      /* Using cursor P02FS2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV84Menuitemwwds_1_tfperfilid), Byte.valueOf(AV85Menuitemwwds_2_tfperfilid_to), lV86Menuitemwwds_3_tfmenuitemid, lV88Menuitemwwds_5_tfmenuitemtitulo, lV91Menuitemwwds_8_tfmitempadredef, lV94Menuitemwwds_11_tfmitemicosvg, lV96Menuitemwwds_13_tfmitembientitdef, lV98Menuitemwwds_15_tfmitembientextdef, lV100Menuitemwwds_17_tfmitemhelp});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1961MItemHelp = P02FS2_A1961MItemHelp[0] ;
         A1956MItemBienTextDef = P02FS2_A1956MItemBienTextDef[0] ;
         A1955MItemBienTitDef = P02FS2_A1955MItemBienTitDef[0] ;
         A1957MItemIcoSVG = P02FS2_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P02FS2_n1957MItemIcoSVG[0] ;
         A1945MItemPadreObl = P02FS2_A1945MItemPadreObl[0] ;
         A1944MItemPadreDef = P02FS2_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P02FS2_n1944MItemPadreDef[0] ;
         A1938MItemEsMenu = P02FS2_A1938MItemEsMenu[0] ;
         A1939MenuItemTitulo = P02FS2_A1939MenuItemTitulo[0] ;
         A1937MenuItemId = P02FS2_A1937MenuItemId[0] ;
         A1925PerfilId = P02FS2_A1925PerfilId[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV34VisibleColumnCount = 0 ;
         AV102GXV9 = 1 ;
         while ( AV102GXV9 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV102GXV9));
            if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PerfilId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A1925PerfilId );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MenuItemId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1937MenuItemId, GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MenuItemTitulo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1939MenuItemTitulo, GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemEsMenu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1938MItemEsMenu) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemPadreDef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1944MItemPadreDef, GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemPadreObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1945MItemPadreObl) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemIcoSVG") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1957MItemIcoSVG, GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MitemIcoImg") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( "" );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemBienImgDef") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( "" );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemBienTitDef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1955MItemBienTitDef, GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemBienTextDef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1956MItemBienTextDef, 1, 1000), GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MItemHelp") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1961MItemHelp, 1, 1000), GXv_char7) ;
                  menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
            }
            AV102GXV9 = (int)(AV102GXV9+1) ;
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
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PerfilId", "", "Perfil", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MenuItemId", "", "Menú item ID", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MenuItemTitulo", "", "Título por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemEsMenu", "", "Es menú", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemPadreDef", "", "Padre default", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemPadreObl", "", "Padre default es obligatorio", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemIcoSVG", "", "SVG de ícono por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MitemIcoImg", "", "Img de ícono por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemBienImgDef", "", "Imagen de bienvenida por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemBienTitDef", "", "Título de bienvenida por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemBienTextDef", "", "Texto de bienvenida por defecto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MItemHelp", "", "Help", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( A1938MItemEsMenu )
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "MenuItemWWColumnsSelector", GXv_char7) ;
      menuitemwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("MenuItemWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MenuItemWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("MenuItemWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV103GXV10 = 1 ;
      while ( AV103GXV10 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV103GXV10));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILID") == 0 )
         {
            AV37TFPerfilId = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFPerfilId_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID") == 0 )
         {
            AV40TFMenuItemId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMID_SEL") == 0 )
         {
            AV39TFMenuItemId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFMenuItemId_Sels.fromJSonString(AV39TFMenuItemId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO") == 0 )
         {
            AV44TFMenuItemTitulo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMENUITEMTITULO_SEL") == 0 )
         {
            AV43TFMenuItemTitulo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFMenuItemTitulo_Sels.fromJSonString(AV43TFMenuItemTitulo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMESMENU_SEL") == 0 )
         {
            AV47TFMItemEsMenu_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF") == 0 )
         {
            AV49TFMItemPadreDef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREDEF_SEL") == 0 )
         {
            AV48TFMItemPadreDef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFMItemPadreDef_Sels.fromJSonString(AV48TFMItemPadreDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMPADREOBL_SEL") == 0 )
         {
            AV52TFMItemPadreObl_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG") == 0 )
         {
            AV54TFMItemIcoSVG = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMICOSVG_SEL") == 0 )
         {
            AV53TFMItemIcoSVG_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFMItemIcoSVG_Sels.fromJSonString(AV53TFMItemIcoSVG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF") == 0 )
         {
            AV58TFMItemBienTitDef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTITDEF_SEL") == 0 )
         {
            AV57TFMItemBienTitDef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFMItemBienTitDef_Sels.fromJSonString(AV57TFMItemBienTitDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF") == 0 )
         {
            AV62TFMItemBienTextDef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMBIENTEXTDEF_SEL") == 0 )
         {
            AV61TFMItemBienTextDef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFMItemBienTextDef_Sels.fromJSonString(AV61TFMItemBienTextDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP") == 0 )
         {
            AV66TFMItemHelp = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMITEMHELP_SEL") == 0 )
         {
            AV65TFMItemHelp_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFMItemHelp_Sels.fromJSonString(AV65TFMItemHelp_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV103GXV10 = (int)(AV103GXV10+1) ;
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
      this.aP0[0] = menuitemwwexport.this.AV12Filename;
      this.aP1[0] = menuitemwwexport.this.AV13ErrorMessage;
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
      AV74Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV41TFMenuItemId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFMenuItemId_Sel = "" ;
      AV40TFMenuItemId = "" ;
      AV45TFMenuItemTitulo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFMenuItemTitulo_Sel = "" ;
      AV44TFMenuItemTitulo = "" ;
      AV50TFMItemPadreDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFMItemPadreDef_Sel = "" ;
      AV49TFMItemPadreDef = "" ;
      AV55TFMItemIcoSVG_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFMItemIcoSVG_Sel = "" ;
      AV54TFMItemIcoSVG = "" ;
      AV59TFMItemBienTitDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFMItemBienTitDef_Sel = "" ;
      AV58TFMItemBienTitDef = "" ;
      AV63TFMItemBienTextDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFMItemBienTextDef_Sel = "" ;
      AV62TFMItemBienTextDef = "" ;
      AV67TFMItemHelp_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFMItemHelp_Sel = "" ;
      AV66TFMItemHelp = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV28ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1937MenuItemId = "" ;
      A1939MenuItemTitulo = "" ;
      A1944MItemPadreDef = "" ;
      A1957MItemIcoSVG = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      A1961MItemHelp = "" ;
      AV86Menuitemwwds_3_tfmenuitemid = "" ;
      AV87Menuitemwwds_4_tfmenuitemid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88Menuitemwwds_5_tfmenuitemtitulo = "" ;
      AV89Menuitemwwds_6_tfmenuitemtitulo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Menuitemwwds_8_tfmitempadredef = "" ;
      AV92Menuitemwwds_9_tfmitempadredef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Menuitemwwds_11_tfmitemicosvg = "" ;
      AV95Menuitemwwds_12_tfmitemicosvg_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Menuitemwwds_13_tfmitembientitdef = "" ;
      AV97Menuitemwwds_14_tfmitembientitdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Menuitemwwds_15_tfmitembientextdef = "" ;
      AV99Menuitemwwds_16_tfmitembientextdef_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Menuitemwwds_17_tfmitemhelp = "" ;
      AV101Menuitemwwds_18_tfmitemhelp_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV86Menuitemwwds_3_tfmenuitemid = "" ;
      lV88Menuitemwwds_5_tfmenuitemtitulo = "" ;
      lV91Menuitemwwds_8_tfmitempadredef = "" ;
      lV94Menuitemwwds_11_tfmitemicosvg = "" ;
      lV96Menuitemwwds_13_tfmitembientitdef = "" ;
      lV98Menuitemwwds_15_tfmitembientextdef = "" ;
      lV100Menuitemwwds_17_tfmitemhelp = "" ;
      P02FS2_A1961MItemHelp = new String[] {""} ;
      P02FS2_A1956MItemBienTextDef = new String[] {""} ;
      P02FS2_A1955MItemBienTitDef = new String[] {""} ;
      P02FS2_A1957MItemIcoSVG = new String[] {""} ;
      P02FS2_n1957MItemIcoSVG = new boolean[] {false} ;
      P02FS2_A1945MItemPadreObl = new boolean[] {false} ;
      P02FS2_A1944MItemPadreDef = new String[] {""} ;
      P02FS2_n1944MItemPadreDef = new boolean[] {false} ;
      P02FS2_A1938MItemEsMenu = new boolean[] {false} ;
      P02FS2_A1939MenuItemTitulo = new String[] {""} ;
      P02FS2_A1937MenuItemId = new String[] {""} ;
      P02FS2_A1925PerfilId = new byte[1] ;
      AV30UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV39TFMenuItemId_SelsJson = "" ;
      AV43TFMenuItemTitulo_SelsJson = "" ;
      AV48TFMItemPadreDef_SelsJson = "" ;
      AV53TFMItemIcoSVG_SelsJson = "" ;
      AV57TFMItemBienTitDef_SelsJson = "" ;
      AV61TFMItemBienTextDef_SelsJson = "" ;
      AV65TFMItemHelp_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuitemwwexport__default(),
         new Object[] {
             new Object[] {
            P02FS2_A1961MItemHelp, P02FS2_A1956MItemBienTextDef, P02FS2_A1955MItemBienTitDef, P02FS2_A1957MItemIcoSVG, P02FS2_n1957MItemIcoSVG, P02FS2_A1945MItemPadreObl, P02FS2_A1944MItemPadreDef, P02FS2_n1944MItemPadreDef, P02FS2_A1938MItemEsMenu, P02FS2_A1939MenuItemTitulo,
            P02FS2_A1937MenuItemId, P02FS2_A1925PerfilId
            }
         }
      );
      AV74Pgmname = "MenuItemWWExport" ;
      /* GeneXus formulas. */
      AV74Pgmname = "MenuItemWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37TFPerfilId ;
   private byte AV38TFPerfilId_To ;
   private byte AV47TFMItemEsMenu_Sel ;
   private byte AV52TFMItemPadreObl_Sel ;
   private byte A1925PerfilId ;
   private byte AV84Menuitemwwds_1_tfperfilid ;
   private byte AV85Menuitemwwds_2_tfperfilid_to ;
   private byte AV90Menuitemwwds_7_tfmitemesmenu_sel ;
   private byte AV93Menuitemwwds_10_tfmitempadreobl_sel ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV75GXV1 ;
   private int AV76GXV2 ;
   private int AV77GXV3 ;
   private int AV78GXV4 ;
   private int AV79GXV5 ;
   private int AV80GXV6 ;
   private int AV81GXV7 ;
   private int AV82GXV8 ;
   private int AV87Menuitemwwds_4_tfmenuitemid_sels_size ;
   private int AV89Menuitemwwds_6_tfmenuitemtitulo_sels_size ;
   private int AV92Menuitemwwds_9_tfmitempadredef_sels_size ;
   private int AV95Menuitemwwds_12_tfmitemicosvg_sels_size ;
   private int AV97Menuitemwwds_14_tfmitembientitdef_sels_size ;
   private int AV99Menuitemwwds_16_tfmitembientextdef_sels_size ;
   private int AV101Menuitemwwds_18_tfmitemhelp_sels_size ;
   private int AV70CliCod ;
   private int AV102GXV9 ;
   private int AV103GXV10 ;
   private long AV69i ;
   private long AV34VisibleColumnCount ;
   private String AV74Pgmname ;
   private String AV56TFMItemIcoSVG_Sel ;
   private String AV54TFMItemIcoSVG ;
   private String A1957MItemIcoSVG ;
   private String AV94Menuitemwwds_11_tfmitemicosvg ;
   private String scmdbuf ;
   private String lV94Menuitemwwds_11_tfmitemicosvg ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A1938MItemEsMenu ;
   private boolean A1945MItemPadreObl ;
   private boolean AV19OrderedDsc ;
   private boolean n1957MItemIcoSVG ;
   private boolean n1944MItemPadreDef ;
   private String AV29ColumnsSelectorXML ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String AV30UserCustomValue ;
   private String AV39TFMenuItemId_SelsJson ;
   private String AV43TFMenuItemTitulo_SelsJson ;
   private String AV48TFMItemPadreDef_SelsJson ;
   private String AV53TFMItemIcoSVG_SelsJson ;
   private String AV57TFMItemBienTitDef_SelsJson ;
   private String AV61TFMItemBienTextDef_SelsJson ;
   private String AV65TFMItemHelp_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFMenuItemId_Sel ;
   private String AV40TFMenuItemId ;
   private String AV46TFMenuItemTitulo_Sel ;
   private String AV44TFMenuItemTitulo ;
   private String AV51TFMItemPadreDef_Sel ;
   private String AV49TFMItemPadreDef ;
   private String AV60TFMItemBienTitDef_Sel ;
   private String AV58TFMItemBienTitDef ;
   private String AV64TFMItemBienTextDef_Sel ;
   private String AV62TFMItemBienTextDef ;
   private String AV68TFMItemHelp_Sel ;
   private String AV66TFMItemHelp ;
   private String A1937MenuItemId ;
   private String A1939MenuItemTitulo ;
   private String A1944MItemPadreDef ;
   private String A1955MItemBienTitDef ;
   private String AV86Menuitemwwds_3_tfmenuitemid ;
   private String AV88Menuitemwwds_5_tfmenuitemtitulo ;
   private String AV91Menuitemwwds_8_tfmitempadredef ;
   private String AV96Menuitemwwds_13_tfmitembientitdef ;
   private String AV98Menuitemwwds_15_tfmitembientextdef ;
   private String AV100Menuitemwwds_17_tfmitemhelp ;
   private String lV86Menuitemwwds_3_tfmenuitemid ;
   private String lV88Menuitemwwds_5_tfmenuitemtitulo ;
   private String lV91Menuitemwwds_8_tfmitempadredef ;
   private String lV96Menuitemwwds_13_tfmitembientitdef ;
   private String lV98Menuitemwwds_15_tfmitembientextdef ;
   private String lV100Menuitemwwds_17_tfmitemhelp ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV55TFMItemIcoSVG_Sels ;
   private GXSimpleCollection<String> AV41TFMenuItemId_Sels ;
   private GXSimpleCollection<String> AV45TFMenuItemTitulo_Sels ;
   private GXSimpleCollection<String> AV50TFMItemPadreDef_Sels ;
   private GXSimpleCollection<String> AV59TFMItemBienTitDef_Sels ;
   private GXSimpleCollection<String> AV63TFMItemBienTextDef_Sels ;
   private GXSimpleCollection<String> AV67TFMItemHelp_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FS2_A1961MItemHelp ;
   private String[] P02FS2_A1956MItemBienTextDef ;
   private String[] P02FS2_A1955MItemBienTitDef ;
   private String[] P02FS2_A1957MItemIcoSVG ;
   private boolean[] P02FS2_n1957MItemIcoSVG ;
   private boolean[] P02FS2_A1945MItemPadreObl ;
   private String[] P02FS2_A1944MItemPadreDef ;
   private boolean[] P02FS2_n1944MItemPadreDef ;
   private boolean[] P02FS2_A1938MItemEsMenu ;
   private String[] P02FS2_A1939MenuItemTitulo ;
   private String[] P02FS2_A1937MenuItemId ;
   private byte[] P02FS2_A1925PerfilId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV95Menuitemwwds_12_tfmitemicosvg_sels ;
   private GXSimpleCollection<String> AV87Menuitemwwds_4_tfmenuitemid_sels ;
   private GXSimpleCollection<String> AV89Menuitemwwds_6_tfmenuitemtitulo_sels ;
   private GXSimpleCollection<String> AV92Menuitemwwds_9_tfmitempadredef_sels ;
   private GXSimpleCollection<String> AV97Menuitemwwds_14_tfmitembientitdef_sels ;
   private GXSimpleCollection<String> AV99Menuitemwwds_16_tfmitembientextdef_sels ;
   private GXSimpleCollection<String> AV101Menuitemwwds_18_tfmitemhelp_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV28ColumnsSelector_Column ;
}

final  class menuitemwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1937MenuItemId ,
                                          GXSimpleCollection<String> AV87Menuitemwwds_4_tfmenuitemid_sels ,
                                          String A1939MenuItemTitulo ,
                                          GXSimpleCollection<String> AV89Menuitemwwds_6_tfmenuitemtitulo_sels ,
                                          String A1944MItemPadreDef ,
                                          GXSimpleCollection<String> AV92Menuitemwwds_9_tfmitempadredef_sels ,
                                          String A1957MItemIcoSVG ,
                                          GXSimpleCollection<String> AV95Menuitemwwds_12_tfmitemicosvg_sels ,
                                          String A1955MItemBienTitDef ,
                                          GXSimpleCollection<String> AV97Menuitemwwds_14_tfmitembientitdef_sels ,
                                          String A1956MItemBienTextDef ,
                                          GXSimpleCollection<String> AV99Menuitemwwds_16_tfmitembientextdef_sels ,
                                          String A1961MItemHelp ,
                                          GXSimpleCollection<String> AV101Menuitemwwds_18_tfmitemhelp_sels ,
                                          byte AV84Menuitemwwds_1_tfperfilid ,
                                          byte AV85Menuitemwwds_2_tfperfilid_to ,
                                          int AV87Menuitemwwds_4_tfmenuitemid_sels_size ,
                                          String AV86Menuitemwwds_3_tfmenuitemid ,
                                          int AV89Menuitemwwds_6_tfmenuitemtitulo_sels_size ,
                                          String AV88Menuitemwwds_5_tfmenuitemtitulo ,
                                          byte AV90Menuitemwwds_7_tfmitemesmenu_sel ,
                                          int AV92Menuitemwwds_9_tfmitempadredef_sels_size ,
                                          String AV91Menuitemwwds_8_tfmitempadredef ,
                                          byte AV93Menuitemwwds_10_tfmitempadreobl_sel ,
                                          int AV95Menuitemwwds_12_tfmitemicosvg_sels_size ,
                                          String AV94Menuitemwwds_11_tfmitemicosvg ,
                                          int AV97Menuitemwwds_14_tfmitembientitdef_sels_size ,
                                          String AV96Menuitemwwds_13_tfmitembientitdef ,
                                          int AV99Menuitemwwds_16_tfmitembientextdef_sels_size ,
                                          String AV98Menuitemwwds_15_tfmitembientextdef ,
                                          int AV101Menuitemwwds_18_tfmitemhelp_sels_size ,
                                          String AV100Menuitemwwds_17_tfmitemhelp ,
                                          byte A1925PerfilId ,
                                          boolean A1938MItemEsMenu ,
                                          boolean A1945MItemPadreObl ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV70CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[9];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT MItemHelp, MItemBienTextDef, MItemBienTitDef, MItemIcoSVG, MItemPadreObl, MItemPadreDef, MItemEsMenu, MenuItemTitulo, MenuItemId, PerfilId FROM MenuItem" ;
      if ( ! (0==AV84Menuitemwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV85Menuitemwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( AV87Menuitemwwds_4_tfmenuitemid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV86Menuitemwwds_3_tfmenuitemid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemId) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV87Menuitemwwds_4_tfmenuitemid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Menuitemwwds_4_tfmenuitemid_sels, "MenuItemId IN (", ")")+")");
      }
      if ( ( AV89Menuitemwwds_6_tfmenuitemtitulo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Menuitemwwds_5_tfmenuitemtitulo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemTitulo) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV89Menuitemwwds_6_tfmenuitemtitulo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Menuitemwwds_6_tfmenuitemtitulo_sels, "MenuItemTitulo IN (", ")")+")");
      }
      if ( AV90Menuitemwwds_7_tfmitemesmenu_sel == 1 )
      {
         addWhere(sWhereString, "(MItemEsMenu = TRUE)");
      }
      if ( AV90Menuitemwwds_7_tfmitemesmenu_sel == 2 )
      {
         addWhere(sWhereString, "(MItemEsMenu = FALSE)");
      }
      if ( ( AV92Menuitemwwds_9_tfmitempadredef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Menuitemwwds_8_tfmitempadredef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemPadreDef) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV92Menuitemwwds_9_tfmitempadredef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Menuitemwwds_9_tfmitempadredef_sels, "MItemPadreDef IN (", ")")+")");
      }
      if ( AV93Menuitemwwds_10_tfmitempadreobl_sel == 1 )
      {
         addWhere(sWhereString, "(MItemPadreObl = TRUE)");
      }
      if ( AV93Menuitemwwds_10_tfmitempadreobl_sel == 2 )
      {
         addWhere(sWhereString, "(MItemPadreObl = FALSE)");
      }
      if ( ( AV95Menuitemwwds_12_tfmitemicosvg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Menuitemwwds_11_tfmitemicosvg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemIcoSVG) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV95Menuitemwwds_12_tfmitemicosvg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Menuitemwwds_12_tfmitemicosvg_sels, "MItemIcoSVG IN (", ")")+")");
      }
      if ( ( AV97Menuitemwwds_14_tfmitembientitdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Menuitemwwds_13_tfmitembientitdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTitDef) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV97Menuitemwwds_14_tfmitembientitdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Menuitemwwds_14_tfmitembientitdef_sels, "MItemBienTitDef IN (", ")")+")");
      }
      if ( ( AV99Menuitemwwds_16_tfmitembientextdef_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Menuitemwwds_15_tfmitembientextdef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemBienTextDef) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV99Menuitemwwds_16_tfmitembientextdef_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Menuitemwwds_16_tfmitembientextdef_sels, "MItemBienTextDef IN (", ")")+")");
      }
      if ( ( AV101Menuitemwwds_18_tfmitemhelp_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Menuitemwwds_17_tfmitemhelp)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MItemHelp) like LOWER(?))");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( AV101Menuitemwwds_18_tfmitemhelp_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Menuitemwwds_18_tfmitemhelp_sels, "MItemHelp IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PerfilId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PerfilId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MenuItemId" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MenuItemId DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MenuItemTitulo" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MenuItemTitulo DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemEsMenu" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemEsMenu DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemPadreDef" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemPadreDef DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemPadreObl" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemPadreObl DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemIcoSVG" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemIcoSVG DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemBienTitDef" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemBienTitDef DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemBienTextDef" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemBienTextDef DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MItemHelp" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MItemHelp DESC" ;
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
                  return conditional_P02FS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Number) dynConstraints[35]).shortValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Number) dynConstraints[38]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
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
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               return;
      }
   }

}

