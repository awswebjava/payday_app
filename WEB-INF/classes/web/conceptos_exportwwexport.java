package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptos_exportwwexport extends GXProcedure
{
   public conceptos_exportwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptos_exportwwexport.class ), "" );
   }

   public conceptos_exportwwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      conceptos_exportwwexport.this.aP1 = new String[] {""};
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
      conceptos_exportwwexport.this.aP0 = aP0;
      conceptos_exportwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV107CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptos_exportwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV107CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export", GXv_boolean4) ;
      conceptos_exportwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV192Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Conceptos_exportWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFCliCod) && (0==AV36TFCliCod_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFCliCod );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFCliCod_To );
      }
      if ( ! ( ( AV39TFConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV193GXV1 = 1 ;
         while ( AV193GXV1 <= AV39TFConCodigo_Sels.size() )
         {
            AV40TFConCodigo_Sel = (String)AV39TFConCodigo_Sels.elementAt(-1+AV193GXV1) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConCodigo_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV193GXV1 = (int)(AV193GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFConCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConCodigo, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV43TFConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV194GXV2 = 1 ;
         while ( AV194GXV2 <= AV43TFConDescrip_Sels.size() )
         {
            AV44TFConDescrip_Sel = (String)AV43TFConDescrip_Sels.elementAt(-1+AV194GXV2) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFConDescrip_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV194GXV2 = (int)(AV194GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFConDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFConDescrip, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV45TFConOrden) && (0==AV46TFConOrden_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Orden", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV45TFConOrden );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV46TFConOrden_To );
      }
      if ( ! ( (0==AV50TFConLiqBasica) && (0==AV51TFConLiqBasica_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Basica (borrar)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV50TFConLiqBasica );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV51TFConLiqBasica_To );
      }
      if ( ! ( ( AV54TFConFormula_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Formula", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV195GXV3 = 1 ;
         while ( AV195GXV3 <= AV54TFConFormula_Sels.size() )
         {
            AV55TFConFormula_Sel = (String)AV54TFConFormula_Sels.elementAt(-1+AV195GXV3) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV55TFConFormula_Sel, 1, 1000), GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV195GXV3 = (int)(AV195GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV53TFConFormula)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Formula", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV53TFConFormula, 1, 1000), GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV58TFConObservacion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Observacion", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV196GXV4 = 1 ;
         while ( AV196GXV4 <= AV58TFConObservacion_Sels.size() )
         {
            AV59TFConObservacion_Sel = (String)AV58TFConObservacion_Sels.elementAt(-1+AV196GXV4) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV59TFConObservacion_Sel, 1, 1000), GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV196GXV4 = (int)(AV196GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFConObservacion)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Observacion", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV57TFConObservacion, 1, 1000), GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV60TFConVariable_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Remuneración variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV60TFConVariable_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV60TFConVariable_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV61TFConForEditable_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Editable (borrar)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV61TFConForEditable_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV61TFConForEditable_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV63TFTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV197GXV5 = 1 ;
         while ( AV197GXV5 <= AV63TFTipoConCod_Sels.size() )
         {
            AV64TFTipoConCod_Sel = (String)AV63TFTipoConCod_Sels.elementAt(-1+AV197GXV5) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFTipoConCod_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV197GXV5 = (int)(AV197GXV5+1) ;
         }
      }
      if ( ! ( ( AV67TFSubTipoConCod1_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV198GXV6 = 1 ;
         while ( AV198GXV6 <= AV67TFSubTipoConCod1_Sels.size() )
         {
            AV68TFSubTipoConCod1_Sel = (String)AV67TFSubTipoConCod1_Sels.elementAt(-1+AV198GXV6) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68TFSubTipoConCod1_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV198GXV6 = (int)(AV198GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV66TFSubTipoConCod1)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFSubTipoConCod1, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV71TFSubTipoConCod2_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Sub clasif.", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV199GXV7 = 1 ;
         while ( AV199GXV7 <= AV71TFSubTipoConCod2_Sels.size() )
         {
            AV72TFSubTipoConCod2_Sel = (String)AV71TFSubTipoConCod2_Sels.elementAt(-1+AV199GXV7) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV72TFSubTipoConCod2_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV199GXV7 = (int)(AV199GXV7+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV70TFSubTipoConCod2)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Sub clasif.", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV70TFSubTipoConCod2, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV75TFConTipoLiqAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liq Aux", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV200GXV8 = 1 ;
         while ( AV200GXV8 <= AV75TFConTipoLiqAux_Sels.size() )
         {
            AV76TFConTipoLiqAux_Sel = (String)AV75TFConTipoLiqAux_Sels.elementAt(-1+AV200GXV8) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFConTipoLiqAux_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV200GXV8 = (int)(AV200GXV8+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV74TFConTipoLiqAux)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liq Aux", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV74TFConTipoLiqAux, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV79TFConClasifAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV201GXV9 = 1 ;
         while ( AV201GXV9 <= AV79TFConClasifAux_Sels.size() )
         {
            AV80TFConClasifAux_Sel = (String)AV79TFConClasifAux_Sels.elementAt(-1+AV201GXV9) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV80TFConClasifAux_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV201GXV9 = (int)(AV201GXV9+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV78TFConClasifAux)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV78TFConClasifAux, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV81TFConOrdEjec) && (0==AV82TFConOrdEjec_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Ord Ejec", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV81TFConOrdEjec );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV82TFConOrdEjec_To );
      }
      if ( ! ( (0==AV87TFConRecalcular_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Recalcular por impuesto a las ganancias", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV87TFConRecalcular_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV87TFConRecalcular_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV90TFConRangoCant_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Rango de valores para cantidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV202GXV10 = 1 ;
         while ( AV202GXV10 <= AV90TFConRangoCant_Sels.size() )
         {
            AV91TFConRangoCant_Sel = (String)AV90TFConRangoCant_Sels.elementAt(-1+AV202GXV10) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV91TFConRangoCant_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV202GXV10 = (int)(AV202GXV10+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV89TFConRangoCant)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Rango de valores para cantidad", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV89TFConRangoCant, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV93TFConCondicion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Condición para liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV203GXV11 = 1 ;
         while ( AV203GXV11 <= AV93TFConCondicion_Sels.size() )
         {
            AV94TFConCondicion_Sel = (String)AV93TFConCondicion_Sels.elementAt(-1+AV203GXV11) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV94TFConCondicion_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV203GXV11 = (int)(AV203GXV11+1) ;
         }
      }
      if ( ! ( ( AV97TFConCondCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código relacionado a la condición", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV204GXV12 = 1 ;
         while ( AV204GXV12 <= AV97TFConCondCodigo_Sels.size() )
         {
            AV98TFConCondCodigo_Sel = (String)AV97TFConCondCodigo_Sels.elementAt(-1+AV204GXV12) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV98TFConCondCodigo_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV204GXV12 = (int)(AV204GXV12+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV96TFConCondCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código relacionado a la condición", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV96TFConCondCodigo, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV99TFConMostrarPos_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV99TFConMostrarPos_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV99TFConMostrarPos_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV101TFConAdelDescu_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Adelanto/Descuento", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV205GXV13 = 1 ;
         while ( AV205GXV13 <= AV101TFConAdelDescu_Sels.size() )
         {
            AV102TFConAdelDescu_Sel = ((Number) AV101TFConAdelDescu_Sels.elementAt(-1+AV205GXV13)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainadelantodescuento.getDescription(httpContext,(byte)AV102TFConAdelDescu_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV205GXV13 = (int)(AV205GXV13+1) ;
         }
      }
      if ( ! ( (0==AV103TFAplIIGG) && (0==AV104TFAplIIGG_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tratamiento IIGG Nro", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV103TFAplIIGG );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV104TFAplIIGG_To );
      }
      if ( ! ( (0==AV105TFConSegunPla_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV105TFConSegunPla_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV105TFConSegunPla_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV113TFConCodAfip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto AFIP", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV206GXV14 = 1 ;
         while ( AV206GXV14 <= AV113TFConCodAfip_Sels.size() )
         {
            AV114TFConCodAfip_Sel = (String)AV113TFConCodAfip_Sels.elementAt(-1+AV206GXV14) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV114TFConCodAfip_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV206GXV14 = (int)(AV206GXV14+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV112TFConCodAfip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto AFIP", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV112TFConCodAfip, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV115TFConSIPAApo) && (0==AV116TFConSIPAApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "SIPAApo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV115TFConSIPAApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV116TFConSIPAApo_To );
      }
      if ( ! ( (0==AV117TFConSIPACont) && (0==AV118TFConSIPACont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "SIPACont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV117TFConSIPACont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV118TFConSIPACont_To );
      }
      if ( ! ( (0==AV119TFConINSSJyPApo) && (0==AV120TFConINSSJyPApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "INSSJy PApo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV119TFConINSSJyPApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV120TFConINSSJyPApo_To );
      }
      if ( ! ( (0==AV121TFConINSSJyPCont) && (0==AV122TFConINSSJyPCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "INSSJy PCont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV121TFConINSSJyPCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV122TFConINSSJyPCont_To );
      }
      if ( ! ( (0==AV123TFConObraSocApo) && (0==AV124TFConObraSocApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Soc Apo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV123TFConObraSocApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV124TFConObraSocApo_To );
      }
      if ( ! ( (0==AV125TFConObraSocCont) && (0==AV126TFConObraSocCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Soc Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV125TFConObraSocCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV126TFConObraSocCont_To );
      }
      if ( ! ( (0==AV127TFConFonSolRedApo) && (0==AV128TFConFonSolRedApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Red Apo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV127TFConFonSolRedApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV128TFConFonSolRedApo_To );
      }
      if ( ! ( (0==AV129TFConFonSolRedCont) && (0==AV130TFConFonSolRedCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Red Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV129TFConFonSolRedCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV130TFConFonSolRedCont_To );
      }
      if ( ! ( (0==AV131TFConRenateaApo) && (0==AV132TFConRenateaApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Renatea Apo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV131TFConRenateaApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV132TFConRenateaApo_To );
      }
      if ( ! ( (0==AV133TFConRenateaCont) && (0==AV134TFConRenateaCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Renatea Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV133TFConRenateaCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV134TFConRenateaCont_To );
      }
      if ( ! ( (0==AV135TFConAsigFamCont) && (0==AV136TFConAsigFamCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Fam Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV135TFConAsigFamCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV136TFConAsigFamCont_To );
      }
      if ( ! ( (0==AV137TFConFonNacEmpCont) && (0==AV138TFConFonNacEmpCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Emp Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV137TFConFonNacEmpCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV138TFConFonNacEmpCont_To );
      }
      if ( ! ( (0==AV139TFConLeyRieTrabCont) && (0==AV140TFConLeyRieTrabCont_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Trab Cont", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV139TFConLeyRieTrabCont );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV140TFConLeyRieTrabCont_To );
      }
      if ( ! ( (0==AV141TFConRegDifApo) && (0==AV142TFConRegDifApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Dif Apo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV141TFConRegDifApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV142TFConRegDifApo_To );
      }
      if ( ! ( (0==AV143TFConRegEspApo) && (0==AV144TFConRegEspApo_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Esp Apo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV143TFConRegEspApo );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV144TFConRegEspApo_To );
      }
      if ( ! ( (0==AV148TFConceptoPais) && (0==AV149TFConceptoPais_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Pais", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV148TFConceptoPais );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV149TFConceptoPais_To );
      }
      if ( ! ( ( AV152TFConceptoConveCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV207GXV15 = 1 ;
         while ( AV207GXV15 <= AV152TFConceptoConveCodigo_Sels.size() )
         {
            AV153TFConceptoConveCodigo_Sel = (String)AV152TFConceptoConveCodigo_Sels.elementAt(-1+AV207GXV15) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV153TFConceptoConveCodigo_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV207GXV15 = (int)(AV207GXV15+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV151TFConceptoConveCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV151TFConceptoConveCodigo, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV164TFConBaseLicProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV208GXV16 = 1 ;
         while ( AV208GXV16 <= AV164TFConBaseLicProm_Sels.size() )
         {
            AV165TFConBaseLicProm_Sel = ((Number) AV164TFConBaseLicProm_Sels.elementAt(-1+AV208GXV16)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV165TFConBaseLicProm_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV208GXV16 = (int)(AV208GXV16+1) ;
         }
      }
      if ( ! ( ( AV167TFConBaseFerProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV209GXV17 = 1 ;
         while ( AV209GXV17 <= AV167TFConBaseFerProm_Sels.size() )
         {
            AV168TFConBaseFerProm_Sel = ((Number) AV167TFConBaseFerProm_Sels.elementAt(-1+AV209GXV17)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV168TFConBaseFerProm_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV209GXV17 = (int)(AV209GXV17+1) ;
         }
      }
      if ( ! ( ( AV170TFConBaseHorExtProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV210GXV18 = 1 ;
         while ( AV210GXV18 <= AV170TFConBaseHorExtProm_Sels.size() )
         {
            AV171TFConBaseHorExtProm_Sel = ((Number) AV170TFConBaseHorExtProm_Sels.elementAt(-1+AV210GXV18)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV171TFConBaseHorExtProm_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV210GXV18 = (int)(AV210GXV18+1) ;
         }
      }
      if ( ! ( ( AV173TFConBasePres_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para presentismo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV211GXV19 = 1 ;
         while ( AV211GXV19 <= AV173TFConBasePres_Sels.size() )
         {
            AV174TFConBasePres_Sel = ((Number) AV173TFConBasePres_Sels.elementAt(-1+AV211GXV19)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV174TFConBasePres_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV211GXV19 = (int)(AV211GXV19+1) ;
         }
      }
      if ( ! ( ( AV176TFConBaseAnt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para antiguedad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV212GXV20 = 1 ;
         while ( AV212GXV20 <= AV176TFConBaseAnt_Sels.size() )
         {
            AV177TFConBaseAnt_Sel = ((Number) AV176TFConBaseAnt_Sels.elementAt(-1+AV212GXV20)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV177TFConBaseAnt_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV212GXV20 = (int)(AV212GXV20+1) ;
         }
      }
      if ( ! ( ( AV179TFConBaseOSDif_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para obra social diferencial", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV213GXV21 = 1 ;
         while ( AV213GXV21 <= AV179TFConBaseOSDif_Sels.size() )
         {
            AV180TFConBaseOSDif_Sel = ((Number) AV179TFConBaseOSDif_Sels.elementAt(-1+AV213GXV21)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base_osdif.getDescription(httpContext,(byte)AV180TFConBaseOSDif_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV213GXV21 = (int)(AV213GXV21+1) ;
         }
      }
      if ( ! ( (0==AV181TFConErrorSiCero_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Dar error si el concepto se calcula en cero", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV181TFConErrorSiCero_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV181TFConErrorSiCero_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV182TFCliPadre) && (0==AV183TFCliPadre_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Padre", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV182TFCliPadre );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV183TFCliPadre_To );
      }
      if ( ! ( ( AV186TFConPadre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Padre", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV106i = 1 ;
         AV214GXV22 = 1 ;
         while ( AV214GXV22 <= AV186TFConPadre_Sels.size() )
         {
            AV187TFConPadre_Sel = (String)AV186TFConPadre_Sels.elementAt(-1+AV214GXV22) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV187TFConPadre_Sel, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV106i = (long)(AV106i+1) ;
            AV214GXV22 = (int)(AV214GXV22+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV185TFConPadre)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Padre", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV185TFConPadre, GXv_char9) ;
            conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV188TFConPueNov_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Se puede ingresar como novedad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptos_exportwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV188TFConPueNov_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV188TFConPueNov_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Conceptos_exportWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Conceptos_exportWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV215GXV23 = 1 ;
      while ( AV215GXV23 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV215GXV23));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV215GXV23 = (int)(AV215GXV23+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV217Conceptos_exportwwds_1_tfclicod = AV35TFCliCod ;
      AV218Conceptos_exportwwds_2_tfclicod_to = AV36TFCliCod_To ;
      AV219Conceptos_exportwwds_3_tfconcodigo = AV38TFConCodigo ;
      AV220Conceptos_exportwwds_4_tfconcodigo_sels = AV39TFConCodigo_Sels ;
      AV221Conceptos_exportwwds_5_tfcondescrip = AV42TFConDescrip ;
      AV222Conceptos_exportwwds_6_tfcondescrip_sels = AV43TFConDescrip_Sels ;
      AV223Conceptos_exportwwds_7_tfconorden = AV45TFConOrden ;
      AV224Conceptos_exportwwds_8_tfconorden_to = AV46TFConOrden_To ;
      AV225Conceptos_exportwwds_9_tfconliqbasica = AV50TFConLiqBasica ;
      AV226Conceptos_exportwwds_10_tfconliqbasica_to = AV51TFConLiqBasica_To ;
      AV227Conceptos_exportwwds_11_tfconformula = AV53TFConFormula ;
      AV228Conceptos_exportwwds_12_tfconformula_sels = AV54TFConFormula_Sels ;
      AV229Conceptos_exportwwds_13_tfconobservacion = AV57TFConObservacion ;
      AV230Conceptos_exportwwds_14_tfconobservacion_sels = AV58TFConObservacion_Sels ;
      AV231Conceptos_exportwwds_15_tfconvariable_sel = AV60TFConVariable_Sel ;
      AV232Conceptos_exportwwds_16_tfconforeditable_sel = AV61TFConForEditable_Sel ;
      AV233Conceptos_exportwwds_17_tftipoconcod_sels = AV63TFTipoConCod_Sels ;
      AV234Conceptos_exportwwds_18_tfsubtipoconcod1 = AV66TFSubTipoConCod1 ;
      AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV67TFSubTipoConCod1_Sels ;
      AV236Conceptos_exportwwds_20_tfsubtipoconcod2 = AV70TFSubTipoConCod2 ;
      AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV71TFSubTipoConCod2_Sels ;
      AV238Conceptos_exportwwds_22_tfcontipoliqaux = AV74TFConTipoLiqAux ;
      AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV75TFConTipoLiqAux_Sels ;
      AV240Conceptos_exportwwds_24_tfconclasifaux = AV78TFConClasifAux ;
      AV241Conceptos_exportwwds_25_tfconclasifaux_sels = AV79TFConClasifAux_Sels ;
      AV242Conceptos_exportwwds_26_tfconordejec = AV81TFConOrdEjec ;
      AV243Conceptos_exportwwds_27_tfconordejec_to = AV82TFConOrdEjec_To ;
      AV244Conceptos_exportwwds_28_tfconrecalcular_sel = AV87TFConRecalcular_Sel ;
      AV245Conceptos_exportwwds_29_tfconrangocant = AV89TFConRangoCant ;
      AV246Conceptos_exportwwds_30_tfconrangocant_sels = AV90TFConRangoCant_Sels ;
      AV247Conceptos_exportwwds_31_tfconcondicion_sels = AV93TFConCondicion_Sels ;
      AV248Conceptos_exportwwds_32_tfconcondcodigo = AV96TFConCondCodigo ;
      AV249Conceptos_exportwwds_33_tfconcondcodigo_sels = AV97TFConCondCodigo_Sels ;
      AV250Conceptos_exportwwds_34_tfconmostrarpos_sel = AV99TFConMostrarPos_Sel ;
      AV251Conceptos_exportwwds_35_tfconadeldescu_sels = AV101TFConAdelDescu_Sels ;
      AV252Conceptos_exportwwds_36_tfapliigg = AV103TFAplIIGG ;
      AV253Conceptos_exportwwds_37_tfapliigg_to = AV104TFAplIIGG_To ;
      AV254Conceptos_exportwwds_38_tfconsegunpla_sel = AV105TFConSegunPla_Sel ;
      AV255Conceptos_exportwwds_39_tfconcodafip = AV112TFConCodAfip ;
      AV256Conceptos_exportwwds_40_tfconcodafip_sels = AV113TFConCodAfip_Sels ;
      AV257Conceptos_exportwwds_41_tfconsipaapo = AV115TFConSIPAApo ;
      AV258Conceptos_exportwwds_42_tfconsipaapo_to = AV116TFConSIPAApo_To ;
      AV259Conceptos_exportwwds_43_tfconsipacont = AV117TFConSIPACont ;
      AV260Conceptos_exportwwds_44_tfconsipacont_to = AV118TFConSIPACont_To ;
      AV261Conceptos_exportwwds_45_tfconinssjypapo = AV119TFConINSSJyPApo ;
      AV262Conceptos_exportwwds_46_tfconinssjypapo_to = AV120TFConINSSJyPApo_To ;
      AV263Conceptos_exportwwds_47_tfconinssjypcont = AV121TFConINSSJyPCont ;
      AV264Conceptos_exportwwds_48_tfconinssjypcont_to = AV122TFConINSSJyPCont_To ;
      AV265Conceptos_exportwwds_49_tfconobrasocapo = AV123TFConObraSocApo ;
      AV266Conceptos_exportwwds_50_tfconobrasocapo_to = AV124TFConObraSocApo_To ;
      AV267Conceptos_exportwwds_51_tfconobrasoccont = AV125TFConObraSocCont ;
      AV268Conceptos_exportwwds_52_tfconobrasoccont_to = AV126TFConObraSocCont_To ;
      AV269Conceptos_exportwwds_53_tfconfonsolredapo = AV127TFConFonSolRedApo ;
      AV270Conceptos_exportwwds_54_tfconfonsolredapo_to = AV128TFConFonSolRedApo_To ;
      AV271Conceptos_exportwwds_55_tfconfonsolredcont = AV129TFConFonSolRedCont ;
      AV272Conceptos_exportwwds_56_tfconfonsolredcont_to = AV130TFConFonSolRedCont_To ;
      AV273Conceptos_exportwwds_57_tfconrenateaapo = AV131TFConRenateaApo ;
      AV274Conceptos_exportwwds_58_tfconrenateaapo_to = AV132TFConRenateaApo_To ;
      AV275Conceptos_exportwwds_59_tfconrenateacont = AV133TFConRenateaCont ;
      AV276Conceptos_exportwwds_60_tfconrenateacont_to = AV134TFConRenateaCont_To ;
      AV277Conceptos_exportwwds_61_tfconasigfamcont = AV135TFConAsigFamCont ;
      AV278Conceptos_exportwwds_62_tfconasigfamcont_to = AV136TFConAsigFamCont_To ;
      AV279Conceptos_exportwwds_63_tfconfonnacempcont = AV137TFConFonNacEmpCont ;
      AV280Conceptos_exportwwds_64_tfconfonnacempcont_to = AV138TFConFonNacEmpCont_To ;
      AV281Conceptos_exportwwds_65_tfconleyrietrabcont = AV139TFConLeyRieTrabCont ;
      AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV140TFConLeyRieTrabCont_To ;
      AV283Conceptos_exportwwds_67_tfconregdifapo = AV141TFConRegDifApo ;
      AV284Conceptos_exportwwds_68_tfconregdifapo_to = AV142TFConRegDifApo_To ;
      AV285Conceptos_exportwwds_69_tfconregespapo = AV143TFConRegEspApo ;
      AV286Conceptos_exportwwds_70_tfconregespapo_to = AV144TFConRegEspApo_To ;
      AV287Conceptos_exportwwds_71_tfconceptopais = AV148TFConceptoPais ;
      AV288Conceptos_exportwwds_72_tfconceptopais_to = AV149TFConceptoPais_To ;
      AV289Conceptos_exportwwds_73_tfconceptoconvecodigo = AV151TFConceptoConveCodigo ;
      AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV152TFConceptoConveCodigo_Sels ;
      AV291Conceptos_exportwwds_75_tfconbaselicprom_sels = AV164TFConBaseLicProm_Sels ;
      AV292Conceptos_exportwwds_76_tfconbaseferprom_sels = AV167TFConBaseFerProm_Sels ;
      AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV170TFConBaseHorExtProm_Sels ;
      AV294Conceptos_exportwwds_78_tfconbasepres_sels = AV173TFConBasePres_Sels ;
      AV295Conceptos_exportwwds_79_tfconbaseant_sels = AV176TFConBaseAnt_Sels ;
      AV296Conceptos_exportwwds_80_tfconbaseosdif_sels = AV179TFConBaseOSDif_Sels ;
      AV297Conceptos_exportwwds_81_tfconerrorsicero_sel = AV181TFConErrorSiCero_Sel ;
      AV298Conceptos_exportwwds_82_tfclipadre = AV182TFCliPadre ;
      AV299Conceptos_exportwwds_83_tfclipadre_to = AV183TFCliPadre_To ;
      AV300Conceptos_exportwwds_84_tfconpadre = AV185TFConPadre ;
      AV301Conceptos_exportwwds_85_tfconpadre_sels = AV186TFConPadre_Sels ;
      AV302Conceptos_exportwwds_86_tfconpuenov_sel = AV188TFConPueNov_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV220Conceptos_exportwwds_4_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV222Conceptos_exportwwds_6_tfcondescrip_sels ,
                                           A148ConFormula ,
                                           AV228Conceptos_exportwwds_12_tfconformula_sels ,
                                           A153ConObservacion ,
                                           AV230Conceptos_exportwwds_14_tfconobservacion_sels ,
                                           A37TipoConCod ,
                                           AV233Conceptos_exportwwds_17_tftipoconcod_sels ,
                                           A38SubTipoConCod1 ,
                                           AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                           A39SubTipoConCod2 ,
                                           AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                           A503ConTipoLiqAux ,
                                           AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                           A970ConClasifAux ,
                                           AV241Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                           A1018ConRangoCant ,
                                           AV246Conceptos_exportwwds_30_tfconrangocant_sels ,
                                           A953ConCondicion ,
                                           AV247Conceptos_exportwwds_31_tfconcondicion_sels ,
                                           A954ConCondCodigo ,
                                           AV249Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                           Byte.valueOf(A1077ConAdelDescu) ,
                                           AV251Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                           A1648ConCodAfip ,
                                           AV256Conceptos_exportwwds_40_tfconcodafip_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV291Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV292Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV294Conceptos_exportwwds_78_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV295Conceptos_exportwwds_79_tfconbaseant_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV296Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                           A921ConPadre ,
                                           AV301Conceptos_exportwwds_85_tfconpadre_sels ,
                                           Integer.valueOf(AV217Conceptos_exportwwds_1_tfclicod) ,
                                           Integer.valueOf(AV218Conceptos_exportwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV220Conceptos_exportwwds_4_tfconcodigo_sels.size()) ,
                                           AV219Conceptos_exportwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV222Conceptos_exportwwds_6_tfcondescrip_sels.size()) ,
                                           AV221Conceptos_exportwwds_5_tfcondescrip ,
                                           Integer.valueOf(AV223Conceptos_exportwwds_7_tfconorden) ,
                                           Integer.valueOf(AV224Conceptos_exportwwds_8_tfconorden_to) ,
                                           Byte.valueOf(AV225Conceptos_exportwwds_9_tfconliqbasica) ,
                                           Byte.valueOf(AV226Conceptos_exportwwds_10_tfconliqbasica_to) ,
                                           Integer.valueOf(AV228Conceptos_exportwwds_12_tfconformula_sels.size()) ,
                                           AV227Conceptos_exportwwds_11_tfconformula ,
                                           Integer.valueOf(AV230Conceptos_exportwwds_14_tfconobservacion_sels.size()) ,
                                           AV229Conceptos_exportwwds_13_tfconobservacion ,
                                           Byte.valueOf(AV231Conceptos_exportwwds_15_tfconvariable_sel) ,
                                           Byte.valueOf(AV232Conceptos_exportwwds_16_tfconforeditable_sel) ,
                                           Integer.valueOf(AV233Conceptos_exportwwds_17_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels.size()) ,
                                           AV234Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                           Integer.valueOf(AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels.size()) ,
                                           AV236Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                           Integer.valueOf(AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels.size()) ,
                                           AV238Conceptos_exportwwds_22_tfcontipoliqaux ,
                                           Integer.valueOf(AV241Conceptos_exportwwds_25_tfconclasifaux_sels.size()) ,
                                           AV240Conceptos_exportwwds_24_tfconclasifaux ,
                                           Long.valueOf(AV242Conceptos_exportwwds_26_tfconordejec) ,
                                           Long.valueOf(AV243Conceptos_exportwwds_27_tfconordejec_to) ,
                                           Byte.valueOf(AV244Conceptos_exportwwds_28_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV246Conceptos_exportwwds_30_tfconrangocant_sels.size()) ,
                                           AV245Conceptos_exportwwds_29_tfconrangocant ,
                                           Integer.valueOf(AV247Conceptos_exportwwds_31_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV249Conceptos_exportwwds_33_tfconcondcodigo_sels.size()) ,
                                           AV248Conceptos_exportwwds_32_tfconcondcodigo ,
                                           Byte.valueOf(AV250Conceptos_exportwwds_34_tfconmostrarpos_sel) ,
                                           Integer.valueOf(AV251Conceptos_exportwwds_35_tfconadeldescu_sels.size()) ,
                                           Short.valueOf(AV252Conceptos_exportwwds_36_tfapliigg) ,
                                           Short.valueOf(AV253Conceptos_exportwwds_37_tfapliigg_to) ,
                                           Byte.valueOf(AV254Conceptos_exportwwds_38_tfconsegunpla_sel) ,
                                           Integer.valueOf(AV256Conceptos_exportwwds_40_tfconcodafip_sels.size()) ,
                                           AV255Conceptos_exportwwds_39_tfconcodafip ,
                                           Byte.valueOf(AV257Conceptos_exportwwds_41_tfconsipaapo) ,
                                           Byte.valueOf(AV258Conceptos_exportwwds_42_tfconsipaapo_to) ,
                                           Byte.valueOf(AV259Conceptos_exportwwds_43_tfconsipacont) ,
                                           Byte.valueOf(AV260Conceptos_exportwwds_44_tfconsipacont_to) ,
                                           Byte.valueOf(AV261Conceptos_exportwwds_45_tfconinssjypapo) ,
                                           Byte.valueOf(AV262Conceptos_exportwwds_46_tfconinssjypapo_to) ,
                                           Byte.valueOf(AV263Conceptos_exportwwds_47_tfconinssjypcont) ,
                                           Byte.valueOf(AV264Conceptos_exportwwds_48_tfconinssjypcont_to) ,
                                           Byte.valueOf(AV265Conceptos_exportwwds_49_tfconobrasocapo) ,
                                           Byte.valueOf(AV266Conceptos_exportwwds_50_tfconobrasocapo_to) ,
                                           Byte.valueOf(AV267Conceptos_exportwwds_51_tfconobrasoccont) ,
                                           Byte.valueOf(AV268Conceptos_exportwwds_52_tfconobrasoccont_to) ,
                                           Byte.valueOf(AV269Conceptos_exportwwds_53_tfconfonsolredapo) ,
                                           Byte.valueOf(AV270Conceptos_exportwwds_54_tfconfonsolredapo_to) ,
                                           Byte.valueOf(AV271Conceptos_exportwwds_55_tfconfonsolredcont) ,
                                           Byte.valueOf(AV272Conceptos_exportwwds_56_tfconfonsolredcont_to) ,
                                           Byte.valueOf(AV273Conceptos_exportwwds_57_tfconrenateaapo) ,
                                           Byte.valueOf(AV274Conceptos_exportwwds_58_tfconrenateaapo_to) ,
                                           Byte.valueOf(AV275Conceptos_exportwwds_59_tfconrenateacont) ,
                                           Byte.valueOf(AV276Conceptos_exportwwds_60_tfconrenateacont_to) ,
                                           Byte.valueOf(AV277Conceptos_exportwwds_61_tfconasigfamcont) ,
                                           Byte.valueOf(AV278Conceptos_exportwwds_62_tfconasigfamcont_to) ,
                                           Byte.valueOf(AV279Conceptos_exportwwds_63_tfconfonnacempcont) ,
                                           Byte.valueOf(AV280Conceptos_exportwwds_64_tfconfonnacempcont_to) ,
                                           Byte.valueOf(AV281Conceptos_exportwwds_65_tfconleyrietrabcont) ,
                                           Byte.valueOf(AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to) ,
                                           Byte.valueOf(AV283Conceptos_exportwwds_67_tfconregdifapo) ,
                                           Byte.valueOf(AV284Conceptos_exportwwds_68_tfconregdifapo_to) ,
                                           Byte.valueOf(AV285Conceptos_exportwwds_69_tfconregespapo) ,
                                           Byte.valueOf(AV286Conceptos_exportwwds_70_tfconregespapo_to) ,
                                           Short.valueOf(AV287Conceptos_exportwwds_71_tfconceptopais) ,
                                           Short.valueOf(AV288Conceptos_exportwwds_72_tfconceptopais_to) ,
                                           Integer.valueOf(AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels.size()) ,
                                           AV289Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV291Conceptos_exportwwds_75_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV292Conceptos_exportwwds_76_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV294Conceptos_exportwwds_78_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV295Conceptos_exportwwds_79_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV296Conceptos_exportwwds_80_tfconbaseosdif_sels.size()) ,
                                           Byte.valueOf(AV297Conceptos_exportwwds_81_tfconerrorsicero_sel) ,
                                           Integer.valueOf(AV298Conceptos_exportwwds_82_tfclipadre) ,
                                           Integer.valueOf(AV299Conceptos_exportwwds_83_tfclipadre_to) ,
                                           Integer.valueOf(AV301Conceptos_exportwwds_85_tfconpadre_sels.size()) ,
                                           AV300Conceptos_exportwwds_84_tfconpadre ,
                                           Byte.valueOf(AV302Conceptos_exportwwds_86_tfconpuenov_sel) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(A40ConOrden) ,
                                           Byte.valueOf(A1488ConLiqBasica) ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A146ConForEditable) ,
                                           Long.valueOf(A510ConOrdEjec) ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           Boolean.valueOf(A1068ConMostrarPos) ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           Boolean.valueOf(A1194ConSegunPla) ,
                                           Byte.valueOf(A1472ConSIPAApo) ,
                                           Byte.valueOf(A1473ConSIPACont) ,
                                           Byte.valueOf(A1474ConINSSJyPApo) ,
                                           Byte.valueOf(A1475ConINSSJyPCont) ,
                                           Byte.valueOf(A1476ConObraSocApo) ,
                                           Byte.valueOf(A1477ConObraSocCont) ,
                                           Byte.valueOf(A1478ConFonSolRedApo) ,
                                           Byte.valueOf(A1479ConFonSolRedCont) ,
                                           Byte.valueOf(A1480ConRenateaApo) ,
                                           Byte.valueOf(A1481ConRenateaCont) ,
                                           Byte.valueOf(A1482ConAsigFamCont) ,
                                           Byte.valueOf(A1483ConFonNacEmpCont) ,
                                           Byte.valueOf(A1484ConLeyRieTrabCont) ,
                                           Byte.valueOf(A1485ConRegDifApo) ,
                                           Byte.valueOf(A1486ConRegEspApo) ,
                                           Short.valueOf(A1644ConceptoPais) ,
                                           Boolean.valueOf(A1821ConErrorSiCero) ,
                                           Integer.valueOf(A1822CliPadre) ,
                                           Boolean.valueOf(A1826ConPueNov) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV107CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV219Conceptos_exportwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV219Conceptos_exportwwds_3_tfconcodigo), 10, "%") ;
      lV221Conceptos_exportwwds_5_tfcondescrip = GXutil.concat( GXutil.rtrim( AV221Conceptos_exportwwds_5_tfcondescrip), "%", "") ;
      lV227Conceptos_exportwwds_11_tfconformula = GXutil.concat( GXutil.rtrim( AV227Conceptos_exportwwds_11_tfconformula), "%", "") ;
      lV229Conceptos_exportwwds_13_tfconobservacion = GXutil.concat( GXutil.rtrim( AV229Conceptos_exportwwds_13_tfconobservacion), "%", "") ;
      lV234Conceptos_exportwwds_18_tfsubtipoconcod1 = GXutil.padr( GXutil.rtrim( AV234Conceptos_exportwwds_18_tfsubtipoconcod1), 20, "%") ;
      lV236Conceptos_exportwwds_20_tfsubtipoconcod2 = GXutil.padr( GXutil.rtrim( AV236Conceptos_exportwwds_20_tfsubtipoconcod2), 20, "%") ;
      lV238Conceptos_exportwwds_22_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV238Conceptos_exportwwds_22_tfcontipoliqaux), "%", "") ;
      lV240Conceptos_exportwwds_24_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV240Conceptos_exportwwds_24_tfconclasifaux), "%", "") ;
      lV245Conceptos_exportwwds_29_tfconrangocant = GXutil.concat( GXutil.rtrim( AV245Conceptos_exportwwds_29_tfconrangocant), "%", "") ;
      lV248Conceptos_exportwwds_32_tfconcondcodigo = GXutil.padr( GXutil.rtrim( AV248Conceptos_exportwwds_32_tfconcondcodigo), 20, "%") ;
      lV255Conceptos_exportwwds_39_tfconcodafip = GXutil.padr( GXutil.rtrim( AV255Conceptos_exportwwds_39_tfconcodafip), 6, "%") ;
      lV289Conceptos_exportwwds_73_tfconceptoconvecodigo = GXutil.padr( GXutil.rtrim( AV289Conceptos_exportwwds_73_tfconceptoconvecodigo), 20, "%") ;
      lV300Conceptos_exportwwds_84_tfconpadre = GXutil.padr( GXutil.rtrim( AV300Conceptos_exportwwds_84_tfconpadre), 10, "%") ;
      /* Using cursor P01KK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV107CliCod), Integer.valueOf(AV217Conceptos_exportwwds_1_tfclicod), Integer.valueOf(AV218Conceptos_exportwwds_2_tfclicod_to), lV219Conceptos_exportwwds_3_tfconcodigo, lV221Conceptos_exportwwds_5_tfcondescrip, Integer.valueOf(AV223Conceptos_exportwwds_7_tfconorden), Integer.valueOf(AV224Conceptos_exportwwds_8_tfconorden_to), Byte.valueOf(AV225Conceptos_exportwwds_9_tfconliqbasica), Byte.valueOf(AV226Conceptos_exportwwds_10_tfconliqbasica_to), lV227Conceptos_exportwwds_11_tfconformula, lV229Conceptos_exportwwds_13_tfconobservacion, lV234Conceptos_exportwwds_18_tfsubtipoconcod1, lV236Conceptos_exportwwds_20_tfsubtipoconcod2, lV238Conceptos_exportwwds_22_tfcontipoliqaux, lV240Conceptos_exportwwds_24_tfconclasifaux, Long.valueOf(AV242Conceptos_exportwwds_26_tfconordejec), Long.valueOf(AV243Conceptos_exportwwds_27_tfconordejec_to), lV245Conceptos_exportwwds_29_tfconrangocant, lV248Conceptos_exportwwds_32_tfconcondcodigo, Short.valueOf(AV252Conceptos_exportwwds_36_tfapliigg), Short.valueOf(AV253Conceptos_exportwwds_37_tfapliigg_to), lV255Conceptos_exportwwds_39_tfconcodafip, Byte.valueOf(AV257Conceptos_exportwwds_41_tfconsipaapo), Byte.valueOf(AV258Conceptos_exportwwds_42_tfconsipaapo_to), Byte.valueOf(AV259Conceptos_exportwwds_43_tfconsipacont), Byte.valueOf(AV260Conceptos_exportwwds_44_tfconsipacont_to), Byte.valueOf(AV261Conceptos_exportwwds_45_tfconinssjypapo), Byte.valueOf(AV262Conceptos_exportwwds_46_tfconinssjypapo_to), Byte.valueOf(AV263Conceptos_exportwwds_47_tfconinssjypcont), Byte.valueOf(AV264Conceptos_exportwwds_48_tfconinssjypcont_to), Byte.valueOf(AV265Conceptos_exportwwds_49_tfconobrasocapo), Byte.valueOf(AV266Conceptos_exportwwds_50_tfconobrasocapo_to), Byte.valueOf(AV267Conceptos_exportwwds_51_tfconobrasoccont), Byte.valueOf(AV268Conceptos_exportwwds_52_tfconobrasoccont_to), Byte.valueOf(AV269Conceptos_exportwwds_53_tfconfonsolredapo), Byte.valueOf(AV270Conceptos_exportwwds_54_tfconfonsolredapo_to), Byte.valueOf(AV271Conceptos_exportwwds_55_tfconfonsolredcont), Byte.valueOf(AV272Conceptos_exportwwds_56_tfconfonsolredcont_to), Byte.valueOf(AV273Conceptos_exportwwds_57_tfconrenateaapo), Byte.valueOf(AV274Conceptos_exportwwds_58_tfconrenateaapo_to), Byte.valueOf(AV275Conceptos_exportwwds_59_tfconrenateacont), Byte.valueOf(AV276Conceptos_exportwwds_60_tfconrenateacont_to), Byte.valueOf(AV277Conceptos_exportwwds_61_tfconasigfamcont), Byte.valueOf(AV278Conceptos_exportwwds_62_tfconasigfamcont_to), Byte.valueOf(AV279Conceptos_exportwwds_63_tfconfonnacempcont), Byte.valueOf(AV280Conceptos_exportwwds_64_tfconfonnacempcont_to), Byte.valueOf(AV281Conceptos_exportwwds_65_tfconleyrietrabcont), Byte.valueOf(AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to), Byte.valueOf(AV283Conceptos_exportwwds_67_tfconregdifapo), Byte.valueOf(AV284Conceptos_exportwwds_68_tfconregdifapo_to), Byte.valueOf(AV285Conceptos_exportwwds_69_tfconregespapo), Byte.valueOf(AV286Conceptos_exportwwds_70_tfconregespapo_to), Short.valueOf(AV287Conceptos_exportwwds_71_tfconceptopais), Short.valueOf(AV288Conceptos_exportwwds_72_tfconceptopais_to), lV289Conceptos_exportwwds_73_tfconceptoconvecodigo, Integer.valueOf(AV298Conceptos_exportwwds_82_tfclipadre), Integer.valueOf(AV299Conceptos_exportwwds_83_tfclipadre_to), lV300Conceptos_exportwwds_84_tfconpadre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1826ConPueNov = P01KK2_A1826ConPueNov[0] ;
         A921ConPadre = P01KK2_A921ConPadre[0] ;
         n921ConPadre = P01KK2_n921ConPadre[0] ;
         A1822CliPadre = P01KK2_A1822CliPadre[0] ;
         n1822CliPadre = P01KK2_n1822CliPadre[0] ;
         A1821ConErrorSiCero = P01KK2_A1821ConErrorSiCero[0] ;
         A1827ConBaseOSDif = P01KK2_A1827ConBaseOSDif[0] ;
         A1801ConBaseAnt = P01KK2_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P01KK2_A1800ConBasePres[0] ;
         A1799ConBaseHorExtProm = P01KK2_A1799ConBaseHorExtProm[0] ;
         A1798ConBaseFerProm = P01KK2_A1798ConBaseFerProm[0] ;
         A1797ConBaseLicProm = P01KK2_A1797ConBaseLicProm[0] ;
         A1645ConceptoConveCodigo = P01KK2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01KK2_n1645ConceptoConveCodigo[0] ;
         A1644ConceptoPais = P01KK2_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P01KK2_n1644ConceptoPais[0] ;
         A1486ConRegEspApo = P01KK2_A1486ConRegEspApo[0] ;
         A1485ConRegDifApo = P01KK2_A1485ConRegDifApo[0] ;
         A1484ConLeyRieTrabCont = P01KK2_A1484ConLeyRieTrabCont[0] ;
         A1483ConFonNacEmpCont = P01KK2_A1483ConFonNacEmpCont[0] ;
         A1482ConAsigFamCont = P01KK2_A1482ConAsigFamCont[0] ;
         A1481ConRenateaCont = P01KK2_A1481ConRenateaCont[0] ;
         A1480ConRenateaApo = P01KK2_A1480ConRenateaApo[0] ;
         A1479ConFonSolRedCont = P01KK2_A1479ConFonSolRedCont[0] ;
         A1478ConFonSolRedApo = P01KK2_A1478ConFonSolRedApo[0] ;
         A1477ConObraSocCont = P01KK2_A1477ConObraSocCont[0] ;
         A1476ConObraSocApo = P01KK2_A1476ConObraSocApo[0] ;
         A1475ConINSSJyPCont = P01KK2_A1475ConINSSJyPCont[0] ;
         A1474ConINSSJyPApo = P01KK2_A1474ConINSSJyPApo[0] ;
         A1473ConSIPACont = P01KK2_A1473ConSIPACont[0] ;
         A1472ConSIPAApo = P01KK2_A1472ConSIPAApo[0] ;
         A1648ConCodAfip = P01KK2_A1648ConCodAfip[0] ;
         A1194ConSegunPla = P01KK2_A1194ConSegunPla[0] ;
         A1112AplIIGG = P01KK2_A1112AplIIGG[0] ;
         n1112AplIIGG = P01KK2_n1112AplIIGG[0] ;
         A1077ConAdelDescu = P01KK2_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = P01KK2_n1077ConAdelDescu[0] ;
         A1068ConMostrarPos = P01KK2_A1068ConMostrarPos[0] ;
         A954ConCondCodigo = P01KK2_A954ConCondCodigo[0] ;
         A953ConCondicion = P01KK2_A953ConCondicion[0] ;
         n953ConCondicion = P01KK2_n953ConCondicion[0] ;
         A1018ConRangoCant = P01KK2_A1018ConRangoCant[0] ;
         A762ConRecalcular = P01KK2_A762ConRecalcular[0] ;
         A510ConOrdEjec = P01KK2_A510ConOrdEjec[0] ;
         A970ConClasifAux = P01KK2_A970ConClasifAux[0] ;
         n970ConClasifAux = P01KK2_n970ConClasifAux[0] ;
         A503ConTipoLiqAux = P01KK2_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P01KK2_n503ConTipoLiqAux[0] ;
         A39SubTipoConCod2 = P01KK2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P01KK2_n39SubTipoConCod2[0] ;
         A38SubTipoConCod1 = P01KK2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P01KK2_n38SubTipoConCod1[0] ;
         A37TipoConCod = P01KK2_A37TipoConCod[0] ;
         A146ConForEditable = P01KK2_A146ConForEditable[0] ;
         n146ConForEditable = P01KK2_n146ConForEditable[0] ;
         A159ConVariable = P01KK2_A159ConVariable[0] ;
         A153ConObservacion = P01KK2_A153ConObservacion[0] ;
         A148ConFormula = P01KK2_A148ConFormula[0] ;
         n148ConFormula = P01KK2_n148ConFormula[0] ;
         A1488ConLiqBasica = P01KK2_A1488ConLiqBasica[0] ;
         A40ConOrden = P01KK2_A40ConOrden[0] ;
         A41ConDescrip = P01KK2_A41ConDescrip[0] ;
         A26ConCodigo = P01KK2_A26ConCodigo[0] ;
         A3CliCod = P01KK2_A3CliCod[0] ;
         A1622ConBaseHorExt = P01KK2_A1622ConBaseHorExt[0] ;
         A1621ConBaseFer = P01KK2_A1621ConBaseFer[0] ;
         A1620ConBaseLic = P01KK2_A1620ConBaseLic[0] ;
         A1539ConSacDeven = P01KK2_A1539ConSacDeven[0] ;
         A162ConVigencia = P01KK2_A162ConVigencia[0] ;
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
         AV303GXV24 = 1 ;
         while ( AV303GXV24 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV303GXV24));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A26ConCodigo, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A41ConDescrip, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConOrden") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A40ConOrden );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConVigencia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A162ConVigencia );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConLiqBasica") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1488ConLiqBasica );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConFormula") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A148ConFormula, 1, 1000), GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConObservacion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A153ConObservacion, 1, 1000), GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConVariable") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A159ConVariable) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConForEditable") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A146ConForEditable) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConCod") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A37TipoConCod, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SubTipoConCod1") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A38SubTipoConCod1, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SubTipoConCod2") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A39SubTipoConCod2, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTipoLiqAux") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A503ConTipoLiqAux, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConClasifAux") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A970ConClasifAux, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConOrdEjec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A510ConOrdEjec );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRecalcular") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A762ConRecalcular) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRangoCant") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1018ConRangoCant, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCondicion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A953ConCondicion, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCondCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A954ConCondCodigo, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConMostrarPos") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1068ConMostrarPos) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConAdelDescu") == 0 )
               {
                  if ( ! (0==A1077ConAdelDescu) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainadelantodescuento.getDescription(httpContext,(byte)A1077ConAdelDescu), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGG") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1112AplIIGG );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConSegunPla") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1194ConSegunPla) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodAfip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1648ConCodAfip, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConSIPAApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1472ConSIPAApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConSIPACont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1473ConSIPACont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConINSSJyPApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1474ConINSSJyPApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConINSSJyPCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1475ConINSSJyPCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConObraSocApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1476ConObraSocApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConObraSocCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1477ConObraSocCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConFonSolRedApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1478ConFonSolRedApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConFonSolRedCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1479ConFonSolRedCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRenateaApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1480ConRenateaApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRenateaCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1481ConRenateaCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConAsigFamCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1482ConAsigFamCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConFonNacEmpCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1483ConFonNacEmpCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConLeyRieTrabCont") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1484ConLeyRieTrabCont );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRegDifApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1485ConRegDifApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRegEspApo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1486ConRegEspApo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConSacDeven") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1539ConSacDeven );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConceptoPais") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1644ConceptoPais );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConceptoConveCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1645ConceptoConveCodigo, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseLic") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1620ConBaseLic );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseLicProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1797ConBaseLicProm), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseFer") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1621ConBaseFer );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseFerProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1798ConBaseFerProm), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseHorExt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1622ConBaseHorExt );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseHorExtProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1799ConBaseHorExtProm), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBasePres") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1800ConBasePres), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1801ConBaseAnt), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseOSDif") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base_osdif.getDescription(httpContext,(byte)A1827ConBaseOSDif), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConErrorSiCero") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1821ConErrorSiCero) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliPadre") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1822CliPadre );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConPadre") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A921ConPadre, GXv_char9) ;
                  conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConPueNov") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1826ConPueNov) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV303GXV24 = (int)(AV303GXV24+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CliCod", "", "Cod", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConOrden", "", "Orden", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConVigencia", "", "Vigencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConLiqBasica", "", "Basica (borrar)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConFormula", "", "Formula", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConObservacion", "", "Observacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConVariable", "", "Remuneración variable", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConForEditable", "", "Editable (borrar)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoConCod", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SubTipoConCod1", "", "Clasificación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SubTipoConCod2", "", "Sub clasif.", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTipoLiqAux", "", "Liq Aux", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConClasifAux", "", "Clasificación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConOrdEjec", "", "Ord Ejec", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRecalcular", "", "Recalcular por impuesto a las ganancias", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRangoCant", "", "Rango de valores para cantidad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCondicion", "", "Condición para liquidación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCondCodigo", "", "Código relacionado a la condición", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConMostrarPos", "", "Mostrar en recibo solo si es mayor a cero", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConAdelDescu", "", "Adelanto/Descuento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGG", "", "Tratamiento IIGG Nro", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConSegunPla", "", "Si no se cumple la condición, liquidar en segundo plano a posteriori", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodAfip", "", "Concepto AFIP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConSIPAApo", "", "SIPAApo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConSIPACont", "", "SIPACont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConINSSJyPApo", "", "INSSJy PApo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConINSSJyPCont", "", "INSSJy PCont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConObraSocApo", "", "Soc Apo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConObraSocCont", "", "Soc Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConFonSolRedApo", "", "Red Apo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConFonSolRedCont", "", "Red Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRenateaApo", "", "Renatea Apo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRenateaCont", "", "Renatea Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConAsigFamCont", "", "Fam Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConFonNacEmpCont", "", "Emp Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConLeyRieTrabCont", "", "Trab Cont", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRegDifApo", "", "Dif Apo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRegEspApo", "", "Esp Apo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConSacDeven", "", "Tipo devengamiento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConceptoPais", "", "Pais", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConceptoConveCodigo", "", "Convenio", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseLic", "", "Base de cálculo para licencias de remuneraciòn actual", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseLicProm", "", "Base de cálculo para licencias de remuneración promedio variable", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseFer", "", "Base de cálculo para feriados de remuneración actual", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseFerProm", "", "Base de cálculo para feriados de remuneración promedio variable", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseHorExt", "", "Base de cálculo para horas extras de remuneración actual", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseHorExtProm", "", "Base de cálculo para horas extras de remuneración promedio variable", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBasePres", "", "Base de cálculo para presentismo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseAnt", "", "Base de cálculo para antiguedad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseOSDif", "", "Base de cálculo para obra social diferencial", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConErrorSiCero", "", "Dar error si el concepto se calcula en cero", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CliPadre", "", "Padre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConPadre", "", "Padre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConPueNov", "", "Se puede ingresar como novedad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Conceptos_exportWWColumnsSelector", GXv_char9) ;
      conceptos_exportwwexport.this.GXt_char8 = GXv_char9[0] ;
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

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("Conceptos_exportWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Conceptos_exportWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Conceptos_exportWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV304GXV25 = 1 ;
      while ( AV304GXV25 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV304GXV25));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV35TFCliCod = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFCliCod_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV38TFConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV37TFConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFConCodigo_Sels.fromJSonString(AV37TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV42TFConDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV41TFConDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFConDescrip_Sels.fromJSonString(AV41TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONORDEN") == 0 )
         {
            AV45TFConOrden = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV46TFConOrden_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONLIQBASICA") == 0 )
         {
            AV50TFConLiqBasica = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFConLiqBasica_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA") == 0 )
         {
            AV53TFConFormula = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA_SEL") == 0 )
         {
            AV52TFConFormula_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFConFormula_Sels.fromJSonString(AV52TFConFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION") == 0 )
         {
            AV57TFConObservacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION_SEL") == 0 )
         {
            AV56TFConObservacion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFConObservacion_Sels.fromJSonString(AV56TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVARIABLE_SEL") == 0 )
         {
            AV60TFConVariable_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFOREDITABLE_SEL") == 0 )
         {
            AV61TFConForEditable_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV62TFTipoConCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFTipoConCod_Sels.fromJSonString(AV62TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD1") == 0 )
         {
            AV66TFSubTipoConCod1 = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD1_SEL") == 0 )
         {
            AV65TFSubTipoConCod1_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFSubTipoConCod1_Sels.fromJSonString(AV65TFSubTipoConCod1_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD2") == 0 )
         {
            AV70TFSubTipoConCod2 = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD2_SEL") == 0 )
         {
            AV69TFSubTipoConCod2_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV71TFSubTipoConCod2_Sels.fromJSonString(AV69TFSubTipoConCod2_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX") == 0 )
         {
            AV74TFConTipoLiqAux = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX_SEL") == 0 )
         {
            AV73TFConTipoLiqAux_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV75TFConTipoLiqAux_Sels.fromJSonString(AV73TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV78TFConClasifAux = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV77TFConClasifAux_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV79TFConClasifAux_Sels.fromJSonString(AV77TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONORDEJEC") == 0 )
         {
            AV81TFConOrdEjec = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV82TFConOrdEjec_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRECALCULAR_SEL") == 0 )
         {
            AV87TFConRecalcular_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRANGOCANT") == 0 )
         {
            AV89TFConRangoCant = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRANGOCANT_SEL") == 0 )
         {
            AV88TFConRangoCant_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV90TFConRangoCant_Sels.fromJSonString(AV88TFConRangoCant_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV92TFConCondicion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV93TFConCondicion_Sels.fromJSonString(AV92TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDCODIGO") == 0 )
         {
            AV96TFConCondCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDCODIGO_SEL") == 0 )
         {
            AV95TFConCondCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV97TFConCondCodigo_Sels.fromJSonString(AV95TFConCondCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMOSTRARPOS_SEL") == 0 )
         {
            AV99TFConMostrarPos_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONADELDESCU_SEL") == 0 )
         {
            AV100TFConAdelDescu_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV101TFConAdelDescu_Sels.fromJSonString(AV100TFConAdelDescu_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG") == 0 )
         {
            AV103TFAplIIGG = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV104TFAplIIGG_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSEGUNPLA_SEL") == 0 )
         {
            AV105TFConSegunPla_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP") == 0 )
         {
            AV112TFConCodAfip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP_SEL") == 0 )
         {
            AV111TFConCodAfip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV113TFConCodAfip_Sels.fromJSonString(AV111TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSIPAAPO") == 0 )
         {
            AV115TFConSIPAApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV116TFConSIPAApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSIPACONT") == 0 )
         {
            AV117TFConSIPACont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV118TFConSIPACont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONINSSJYPAPO") == 0 )
         {
            AV119TFConINSSJyPApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV120TFConINSSJyPApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONINSSJYPCONT") == 0 )
         {
            AV121TFConINSSJyPCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV122TFConINSSJyPCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBRASOCAPO") == 0 )
         {
            AV123TFConObraSocApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV124TFConObraSocApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBRASOCCONT") == 0 )
         {
            AV125TFConObraSocCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV126TFConObraSocCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONSOLREDAPO") == 0 )
         {
            AV127TFConFonSolRedApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV128TFConFonSolRedApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONSOLREDCONT") == 0 )
         {
            AV129TFConFonSolRedCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV130TFConFonSolRedCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRENATEAAPO") == 0 )
         {
            AV131TFConRenateaApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV132TFConRenateaApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRENATEACONT") == 0 )
         {
            AV133TFConRenateaCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV134TFConRenateaCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONASIGFAMCONT") == 0 )
         {
            AV135TFConAsigFamCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV136TFConAsigFamCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONNACEMPCONT") == 0 )
         {
            AV137TFConFonNacEmpCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV138TFConFonNacEmpCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONLEYRIETRABCONT") == 0 )
         {
            AV139TFConLeyRieTrabCont = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV140TFConLeyRieTrabCont_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONREGDIFAPO") == 0 )
         {
            AV141TFConRegDifApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV142TFConRegDifApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONREGESPAPO") == 0 )
         {
            AV143TFConRegEspApo = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV144TFConRegEspApo_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOPAIS") == 0 )
         {
            AV148TFConceptoPais = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV149TFConceptoPais_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO") == 0 )
         {
            AV151TFConceptoConveCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO_SEL") == 0 )
         {
            AV150TFConceptoConveCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV152TFConceptoConveCodigo_Sels.fromJSonString(AV150TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELICPROM_SEL") == 0 )
         {
            AV163TFConBaseLicProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV164TFConBaseLicProm_Sels.fromJSonString(AV163TFConBaseLicProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFERPROM_SEL") == 0 )
         {
            AV166TFConBaseFerProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV167TFConBaseFerProm_Sels.fromJSonString(AV166TFConBaseFerProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXTPROM_SEL") == 0 )
         {
            AV169TFConBaseHorExtProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV170TFConBaseHorExtProm_Sels.fromJSonString(AV169TFConBaseHorExtProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEPRES_SEL") == 0 )
         {
            AV172TFConBasePres_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV173TFConBasePres_Sels.fromJSonString(AV172TFConBasePres_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEANT_SEL") == 0 )
         {
            AV175TFConBaseAnt_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV176TFConBaseAnt_Sels.fromJSonString(AV175TFConBaseAnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEOSDIF_SEL") == 0 )
         {
            AV178TFConBaseOSDif_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV179TFConBaseOSDif_Sels.fromJSonString(AV178TFConBaseOSDif_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONERRORSICERO_SEL") == 0 )
         {
            AV181TFConErrorSiCero_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIPADRE") == 0 )
         {
            AV182TFCliPadre = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV183TFCliPadre_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPADRE") == 0 )
         {
            AV185TFConPadre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPADRE_SEL") == 0 )
         {
            AV184TFConPadre_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV186TFConPadre_Sels.fromJSonString(AV184TFConPadre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPUENOV_SEL") == 0 )
         {
            AV188TFConPueNov_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV189MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV304GXV25 = (int)(AV304GXV25+1) ;
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
      this.aP0[0] = conceptos_exportwwexport.this.AV12Filename;
      this.aP1[0] = conceptos_exportwwexport.this.AV13ErrorMessage;
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
      AV192Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFConCodigo_Sel = "" ;
      AV38TFConCodigo = "" ;
      AV43TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFConDescrip_Sel = "" ;
      AV42TFConDescrip = "" ;
      AV54TFConFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFConFormula_Sel = "" ;
      AV53TFConFormula = "" ;
      AV58TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFConObservacion_Sel = "" ;
      AV57TFConObservacion = "" ;
      AV63TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFTipoConCod_Sel = "" ;
      AV67TFSubTipoConCod1_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFSubTipoConCod1_Sel = "" ;
      AV66TFSubTipoConCod1 = "" ;
      AV71TFSubTipoConCod2_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72TFSubTipoConCod2_Sel = "" ;
      AV70TFSubTipoConCod2 = "" ;
      AV75TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFConTipoLiqAux_Sel = "" ;
      AV74TFConTipoLiqAux = "" ;
      AV79TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFConClasifAux_Sel = "" ;
      AV78TFConClasifAux = "" ;
      AV90TFConRangoCant_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91TFConRangoCant_Sel = "" ;
      AV89TFConRangoCant = "" ;
      AV93TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94TFConCondicion_Sel = "" ;
      AV97TFConCondCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98TFConCondCodigo_Sel = "" ;
      AV96TFConCondCodigo = "" ;
      AV101TFConAdelDescu_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV113TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114TFConCodAfip_Sel = "" ;
      AV112TFConCodAfip = "" ;
      AV152TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV153TFConceptoConveCodigo_Sel = "" ;
      AV151TFConceptoConveCodigo = "" ;
      AV164TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV167TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV170TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV173TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV176TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV179TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV186TFConPadre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV187TFConPadre_Sel = "" ;
      AV185TFConPadre = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A148ConFormula = "" ;
      A153ConObservacion = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A503ConTipoLiqAux = "" ;
      A970ConClasifAux = "" ;
      A1018ConRangoCant = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      A1648ConCodAfip = "" ;
      A1645ConceptoConveCodigo = "" ;
      A921ConPadre = "" ;
      AV219Conceptos_exportwwds_3_tfconcodigo = "" ;
      AV220Conceptos_exportwwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV221Conceptos_exportwwds_5_tfcondescrip = "" ;
      AV222Conceptos_exportwwds_6_tfcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV227Conceptos_exportwwds_11_tfconformula = "" ;
      AV228Conceptos_exportwwds_12_tfconformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV229Conceptos_exportwwds_13_tfconobservacion = "" ;
      AV230Conceptos_exportwwds_14_tfconobservacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV233Conceptos_exportwwds_17_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV234Conceptos_exportwwds_18_tfsubtipoconcod1 = "" ;
      AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV236Conceptos_exportwwds_20_tfsubtipoconcod2 = "" ;
      AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV238Conceptos_exportwwds_22_tfcontipoliqaux = "" ;
      AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV240Conceptos_exportwwds_24_tfconclasifaux = "" ;
      AV241Conceptos_exportwwds_25_tfconclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV245Conceptos_exportwwds_29_tfconrangocant = "" ;
      AV246Conceptos_exportwwds_30_tfconrangocant_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV247Conceptos_exportwwds_31_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV248Conceptos_exportwwds_32_tfconcondcodigo = "" ;
      AV249Conceptos_exportwwds_33_tfconcondcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV251Conceptos_exportwwds_35_tfconadeldescu_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV255Conceptos_exportwwds_39_tfconcodafip = "" ;
      AV256Conceptos_exportwwds_40_tfconcodafip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV289Conceptos_exportwwds_73_tfconceptoconvecodigo = "" ;
      AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV291Conceptos_exportwwds_75_tfconbaselicprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV292Conceptos_exportwwds_76_tfconbaseferprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV294Conceptos_exportwwds_78_tfconbasepres_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV295Conceptos_exportwwds_79_tfconbaseant_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV296Conceptos_exportwwds_80_tfconbaseosdif_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV300Conceptos_exportwwds_84_tfconpadre = "" ;
      AV301Conceptos_exportwwds_85_tfconpadre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV219Conceptos_exportwwds_3_tfconcodigo = "" ;
      lV221Conceptos_exportwwds_5_tfcondescrip = "" ;
      lV227Conceptos_exportwwds_11_tfconformula = "" ;
      lV229Conceptos_exportwwds_13_tfconobservacion = "" ;
      lV234Conceptos_exportwwds_18_tfsubtipoconcod1 = "" ;
      lV236Conceptos_exportwwds_20_tfsubtipoconcod2 = "" ;
      lV238Conceptos_exportwwds_22_tfcontipoliqaux = "" ;
      lV240Conceptos_exportwwds_24_tfconclasifaux = "" ;
      lV245Conceptos_exportwwds_29_tfconrangocant = "" ;
      lV248Conceptos_exportwwds_32_tfconcondcodigo = "" ;
      lV255Conceptos_exportwwds_39_tfconcodafip = "" ;
      lV289Conceptos_exportwwds_73_tfconceptoconvecodigo = "" ;
      lV300Conceptos_exportwwds_84_tfconpadre = "" ;
      P01KK2_A1826ConPueNov = new boolean[] {false} ;
      P01KK2_A921ConPadre = new String[] {""} ;
      P01KK2_n921ConPadre = new boolean[] {false} ;
      P01KK2_A1822CliPadre = new int[1] ;
      P01KK2_n1822CliPadre = new boolean[] {false} ;
      P01KK2_A1821ConErrorSiCero = new boolean[] {false} ;
      P01KK2_A1827ConBaseOSDif = new byte[1] ;
      P01KK2_A1801ConBaseAnt = new byte[1] ;
      P01KK2_A1800ConBasePres = new byte[1] ;
      P01KK2_A1799ConBaseHorExtProm = new byte[1] ;
      P01KK2_A1798ConBaseFerProm = new byte[1] ;
      P01KK2_A1797ConBaseLicProm = new byte[1] ;
      P01KK2_A1645ConceptoConveCodigo = new String[] {""} ;
      P01KK2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01KK2_A1644ConceptoPais = new short[1] ;
      P01KK2_n1644ConceptoPais = new boolean[] {false} ;
      P01KK2_A1486ConRegEspApo = new byte[1] ;
      P01KK2_A1485ConRegDifApo = new byte[1] ;
      P01KK2_A1484ConLeyRieTrabCont = new byte[1] ;
      P01KK2_A1483ConFonNacEmpCont = new byte[1] ;
      P01KK2_A1482ConAsigFamCont = new byte[1] ;
      P01KK2_A1481ConRenateaCont = new byte[1] ;
      P01KK2_A1480ConRenateaApo = new byte[1] ;
      P01KK2_A1479ConFonSolRedCont = new byte[1] ;
      P01KK2_A1478ConFonSolRedApo = new byte[1] ;
      P01KK2_A1477ConObraSocCont = new byte[1] ;
      P01KK2_A1476ConObraSocApo = new byte[1] ;
      P01KK2_A1475ConINSSJyPCont = new byte[1] ;
      P01KK2_A1474ConINSSJyPApo = new byte[1] ;
      P01KK2_A1473ConSIPACont = new byte[1] ;
      P01KK2_A1472ConSIPAApo = new byte[1] ;
      P01KK2_A1648ConCodAfip = new String[] {""} ;
      P01KK2_A1194ConSegunPla = new boolean[] {false} ;
      P01KK2_A1112AplIIGG = new short[1] ;
      P01KK2_n1112AplIIGG = new boolean[] {false} ;
      P01KK2_A1077ConAdelDescu = new byte[1] ;
      P01KK2_n1077ConAdelDescu = new boolean[] {false} ;
      P01KK2_A1068ConMostrarPos = new boolean[] {false} ;
      P01KK2_A954ConCondCodigo = new String[] {""} ;
      P01KK2_A953ConCondicion = new String[] {""} ;
      P01KK2_n953ConCondicion = new boolean[] {false} ;
      P01KK2_A1018ConRangoCant = new String[] {""} ;
      P01KK2_A762ConRecalcular = new boolean[] {false} ;
      P01KK2_A510ConOrdEjec = new long[1] ;
      P01KK2_A970ConClasifAux = new String[] {""} ;
      P01KK2_n970ConClasifAux = new boolean[] {false} ;
      P01KK2_A503ConTipoLiqAux = new String[] {""} ;
      P01KK2_n503ConTipoLiqAux = new boolean[] {false} ;
      P01KK2_A39SubTipoConCod2 = new String[] {""} ;
      P01KK2_n39SubTipoConCod2 = new boolean[] {false} ;
      P01KK2_A38SubTipoConCod1 = new String[] {""} ;
      P01KK2_n38SubTipoConCod1 = new boolean[] {false} ;
      P01KK2_A37TipoConCod = new String[] {""} ;
      P01KK2_A146ConForEditable = new boolean[] {false} ;
      P01KK2_n146ConForEditable = new boolean[] {false} ;
      P01KK2_A159ConVariable = new boolean[] {false} ;
      P01KK2_A153ConObservacion = new String[] {""} ;
      P01KK2_A148ConFormula = new String[] {""} ;
      P01KK2_n148ConFormula = new boolean[] {false} ;
      P01KK2_A1488ConLiqBasica = new byte[1] ;
      P01KK2_A40ConOrden = new int[1] ;
      P01KK2_A41ConDescrip = new String[] {""} ;
      P01KK2_A26ConCodigo = new String[] {""} ;
      P01KK2_A3CliCod = new int[1] ;
      P01KK2_A1622ConBaseHorExt = new byte[1] ;
      P01KK2_A1621ConBaseFer = new byte[1] ;
      P01KK2_A1620ConBaseLic = new byte[1] ;
      P01KK2_A1539ConSacDeven = new byte[1] ;
      P01KK2_A162ConVigencia = new byte[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFConCodigo_SelsJson = "" ;
      AV41TFConDescrip_SelsJson = "" ;
      AV52TFConFormula_SelsJson = "" ;
      AV56TFConObservacion_SelsJson = "" ;
      AV62TFTipoConCod_SelsJson = "" ;
      AV65TFSubTipoConCod1_SelsJson = "" ;
      AV69TFSubTipoConCod2_SelsJson = "" ;
      AV73TFConTipoLiqAux_SelsJson = "" ;
      AV77TFConClasifAux_SelsJson = "" ;
      AV88TFConRangoCant_SelsJson = "" ;
      AV92TFConCondicion_SelsJson = "" ;
      AV95TFConCondCodigo_SelsJson = "" ;
      AV100TFConAdelDescu_SelsJson = "" ;
      AV111TFConCodAfip_SelsJson = "" ;
      AV150TFConceptoConveCodigo_SelsJson = "" ;
      AV163TFConBaseLicProm_SelsJson = "" ;
      AV166TFConBaseFerProm_SelsJson = "" ;
      AV169TFConBaseHorExtProm_SelsJson = "" ;
      AV172TFConBasePres_SelsJson = "" ;
      AV175TFConBaseAnt_SelsJson = "" ;
      AV178TFConBaseOSDif_SelsJson = "" ;
      AV184TFConPadre_SelsJson = "" ;
      AV189MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptos_exportwwexport__default(),
         new Object[] {
             new Object[] {
            P01KK2_A1826ConPueNov, P01KK2_A921ConPadre, P01KK2_n921ConPadre, P01KK2_A1822CliPadre, P01KK2_n1822CliPadre, P01KK2_A1821ConErrorSiCero, P01KK2_A1827ConBaseOSDif, P01KK2_A1801ConBaseAnt, P01KK2_A1800ConBasePres, P01KK2_A1799ConBaseHorExtProm,
            P01KK2_A1798ConBaseFerProm, P01KK2_A1797ConBaseLicProm, P01KK2_A1645ConceptoConveCodigo, P01KK2_n1645ConceptoConveCodigo, P01KK2_A1644ConceptoPais, P01KK2_n1644ConceptoPais, P01KK2_A1486ConRegEspApo, P01KK2_A1485ConRegDifApo, P01KK2_A1484ConLeyRieTrabCont, P01KK2_A1483ConFonNacEmpCont,
            P01KK2_A1482ConAsigFamCont, P01KK2_A1481ConRenateaCont, P01KK2_A1480ConRenateaApo, P01KK2_A1479ConFonSolRedCont, P01KK2_A1478ConFonSolRedApo, P01KK2_A1477ConObraSocCont, P01KK2_A1476ConObraSocApo, P01KK2_A1475ConINSSJyPCont, P01KK2_A1474ConINSSJyPApo, P01KK2_A1473ConSIPACont,
            P01KK2_A1472ConSIPAApo, P01KK2_A1648ConCodAfip, P01KK2_A1194ConSegunPla, P01KK2_A1112AplIIGG, P01KK2_n1112AplIIGG, P01KK2_A1077ConAdelDescu, P01KK2_n1077ConAdelDescu, P01KK2_A1068ConMostrarPos, P01KK2_A954ConCondCodigo, P01KK2_A953ConCondicion,
            P01KK2_n953ConCondicion, P01KK2_A1018ConRangoCant, P01KK2_A762ConRecalcular, P01KK2_A510ConOrdEjec, P01KK2_A970ConClasifAux, P01KK2_n970ConClasifAux, P01KK2_A503ConTipoLiqAux, P01KK2_n503ConTipoLiqAux, P01KK2_A39SubTipoConCod2, P01KK2_n39SubTipoConCod2,
            P01KK2_A38SubTipoConCod1, P01KK2_n38SubTipoConCod1, P01KK2_A37TipoConCod, P01KK2_A146ConForEditable, P01KK2_n146ConForEditable, P01KK2_A159ConVariable, P01KK2_A153ConObservacion, P01KK2_A148ConFormula, P01KK2_n148ConFormula, P01KK2_A1488ConLiqBasica,
            P01KK2_A40ConOrden, P01KK2_A41ConDescrip, P01KK2_A26ConCodigo, P01KK2_A3CliCod, P01KK2_A1622ConBaseHorExt, P01KK2_A1621ConBaseFer, P01KK2_A1620ConBaseLic, P01KK2_A1539ConSacDeven, P01KK2_A162ConVigencia
            }
         }
      );
      AV192Pgmname = "Conceptos_exportWWExport" ;
      /* GeneXus formulas. */
      AV192Pgmname = "Conceptos_exportWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV50TFConLiqBasica ;
   private byte AV51TFConLiqBasica_To ;
   private byte AV60TFConVariable_Sel ;
   private byte AV61TFConForEditable_Sel ;
   private byte AV87TFConRecalcular_Sel ;
   private byte AV99TFConMostrarPos_Sel ;
   private byte AV102TFConAdelDescu_Sel ;
   private byte AV105TFConSegunPla_Sel ;
   private byte AV115TFConSIPAApo ;
   private byte AV116TFConSIPAApo_To ;
   private byte AV117TFConSIPACont ;
   private byte AV118TFConSIPACont_To ;
   private byte AV119TFConINSSJyPApo ;
   private byte AV120TFConINSSJyPApo_To ;
   private byte AV121TFConINSSJyPCont ;
   private byte AV122TFConINSSJyPCont_To ;
   private byte AV123TFConObraSocApo ;
   private byte AV124TFConObraSocApo_To ;
   private byte AV125TFConObraSocCont ;
   private byte AV126TFConObraSocCont_To ;
   private byte AV127TFConFonSolRedApo ;
   private byte AV128TFConFonSolRedApo_To ;
   private byte AV129TFConFonSolRedCont ;
   private byte AV130TFConFonSolRedCont_To ;
   private byte AV131TFConRenateaApo ;
   private byte AV132TFConRenateaApo_To ;
   private byte AV133TFConRenateaCont ;
   private byte AV134TFConRenateaCont_To ;
   private byte AV135TFConAsigFamCont ;
   private byte AV136TFConAsigFamCont_To ;
   private byte AV137TFConFonNacEmpCont ;
   private byte AV138TFConFonNacEmpCont_To ;
   private byte AV139TFConLeyRieTrabCont ;
   private byte AV140TFConLeyRieTrabCont_To ;
   private byte AV141TFConRegDifApo ;
   private byte AV142TFConRegDifApo_To ;
   private byte AV143TFConRegEspApo ;
   private byte AV144TFConRegEspApo_To ;
   private byte AV165TFConBaseLicProm_Sel ;
   private byte AV168TFConBaseFerProm_Sel ;
   private byte AV171TFConBaseHorExtProm_Sel ;
   private byte AV174TFConBasePres_Sel ;
   private byte AV177TFConBaseAnt_Sel ;
   private byte AV180TFConBaseOSDif_Sel ;
   private byte AV181TFConErrorSiCero_Sel ;
   private byte AV188TFConPueNov_Sel ;
   private byte A162ConVigencia ;
   private byte A1488ConLiqBasica ;
   private byte A1077ConAdelDescu ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private byte A1539ConSacDeven ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1827ConBaseOSDif ;
   private byte AV225Conceptos_exportwwds_9_tfconliqbasica ;
   private byte AV226Conceptos_exportwwds_10_tfconliqbasica_to ;
   private byte AV231Conceptos_exportwwds_15_tfconvariable_sel ;
   private byte AV232Conceptos_exportwwds_16_tfconforeditable_sel ;
   private byte AV244Conceptos_exportwwds_28_tfconrecalcular_sel ;
   private byte AV250Conceptos_exportwwds_34_tfconmostrarpos_sel ;
   private byte AV254Conceptos_exportwwds_38_tfconsegunpla_sel ;
   private byte AV257Conceptos_exportwwds_41_tfconsipaapo ;
   private byte AV258Conceptos_exportwwds_42_tfconsipaapo_to ;
   private byte AV259Conceptos_exportwwds_43_tfconsipacont ;
   private byte AV260Conceptos_exportwwds_44_tfconsipacont_to ;
   private byte AV261Conceptos_exportwwds_45_tfconinssjypapo ;
   private byte AV262Conceptos_exportwwds_46_tfconinssjypapo_to ;
   private byte AV263Conceptos_exportwwds_47_tfconinssjypcont ;
   private byte AV264Conceptos_exportwwds_48_tfconinssjypcont_to ;
   private byte AV265Conceptos_exportwwds_49_tfconobrasocapo ;
   private byte AV266Conceptos_exportwwds_50_tfconobrasocapo_to ;
   private byte AV267Conceptos_exportwwds_51_tfconobrasoccont ;
   private byte AV268Conceptos_exportwwds_52_tfconobrasoccont_to ;
   private byte AV269Conceptos_exportwwds_53_tfconfonsolredapo ;
   private byte AV270Conceptos_exportwwds_54_tfconfonsolredapo_to ;
   private byte AV271Conceptos_exportwwds_55_tfconfonsolredcont ;
   private byte AV272Conceptos_exportwwds_56_tfconfonsolredcont_to ;
   private byte AV273Conceptos_exportwwds_57_tfconrenateaapo ;
   private byte AV274Conceptos_exportwwds_58_tfconrenateaapo_to ;
   private byte AV275Conceptos_exportwwds_59_tfconrenateacont ;
   private byte AV276Conceptos_exportwwds_60_tfconrenateacont_to ;
   private byte AV277Conceptos_exportwwds_61_tfconasigfamcont ;
   private byte AV278Conceptos_exportwwds_62_tfconasigfamcont_to ;
   private byte AV279Conceptos_exportwwds_63_tfconfonnacempcont ;
   private byte AV280Conceptos_exportwwds_64_tfconfonnacempcont_to ;
   private byte AV281Conceptos_exportwwds_65_tfconleyrietrabcont ;
   private byte AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to ;
   private byte AV283Conceptos_exportwwds_67_tfconregdifapo ;
   private byte AV284Conceptos_exportwwds_68_tfconregdifapo_to ;
   private byte AV285Conceptos_exportwwds_69_tfconregespapo ;
   private byte AV286Conceptos_exportwwds_70_tfconregespapo_to ;
   private byte AV297Conceptos_exportwwds_81_tfconerrorsicero_sel ;
   private byte AV302Conceptos_exportwwds_86_tfconpuenov_sel ;
   private short AV103TFAplIIGG ;
   private short AV104TFAplIIGG_To ;
   private short AV148TFConceptoPais ;
   private short AV149TFConceptoPais_To ;
   private short GXv_int7[] ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short AV252Conceptos_exportwwds_36_tfapliigg ;
   private short AV253Conceptos_exportwwds_37_tfapliigg_to ;
   private short AV287Conceptos_exportwwds_71_tfconceptopais ;
   private short AV288Conceptos_exportwwds_72_tfconceptopais_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV107CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFCliCod ;
   private int AV36TFCliCod_To ;
   private int AV193GXV1 ;
   private int AV194GXV2 ;
   private int AV45TFConOrden ;
   private int AV46TFConOrden_To ;
   private int AV195GXV3 ;
   private int AV196GXV4 ;
   private int AV197GXV5 ;
   private int AV198GXV6 ;
   private int AV199GXV7 ;
   private int AV200GXV8 ;
   private int AV201GXV9 ;
   private int AV202GXV10 ;
   private int AV203GXV11 ;
   private int AV204GXV12 ;
   private int AV205GXV13 ;
   private int AV206GXV14 ;
   private int AV207GXV15 ;
   private int AV208GXV16 ;
   private int AV209GXV17 ;
   private int AV210GXV18 ;
   private int AV211GXV19 ;
   private int AV212GXV20 ;
   private int AV213GXV21 ;
   private int AV182TFCliPadre ;
   private int AV183TFCliPadre_To ;
   private int AV214GXV22 ;
   private int AV215GXV23 ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private int A1822CliPadre ;
   private int AV217Conceptos_exportwwds_1_tfclicod ;
   private int AV218Conceptos_exportwwds_2_tfclicod_to ;
   private int AV223Conceptos_exportwwds_7_tfconorden ;
   private int AV224Conceptos_exportwwds_8_tfconorden_to ;
   private int AV298Conceptos_exportwwds_82_tfclipadre ;
   private int AV299Conceptos_exportwwds_83_tfclipadre_to ;
   private int AV220Conceptos_exportwwds_4_tfconcodigo_sels_size ;
   private int AV222Conceptos_exportwwds_6_tfcondescrip_sels_size ;
   private int AV228Conceptos_exportwwds_12_tfconformula_sels_size ;
   private int AV230Conceptos_exportwwds_14_tfconobservacion_sels_size ;
   private int AV233Conceptos_exportwwds_17_tftipoconcod_sels_size ;
   private int AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size ;
   private int AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size ;
   private int AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels_size ;
   private int AV241Conceptos_exportwwds_25_tfconclasifaux_sels_size ;
   private int AV246Conceptos_exportwwds_30_tfconrangocant_sels_size ;
   private int AV247Conceptos_exportwwds_31_tfconcondicion_sels_size ;
   private int AV249Conceptos_exportwwds_33_tfconcondcodigo_sels_size ;
   private int AV251Conceptos_exportwwds_35_tfconadeldescu_sels_size ;
   private int AV256Conceptos_exportwwds_40_tfconcodafip_sels_size ;
   private int AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size ;
   private int AV291Conceptos_exportwwds_75_tfconbaselicprom_sels_size ;
   private int AV292Conceptos_exportwwds_76_tfconbaseferprom_sels_size ;
   private int AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels_size ;
   private int AV294Conceptos_exportwwds_78_tfconbasepres_sels_size ;
   private int AV295Conceptos_exportwwds_79_tfconbaseant_sels_size ;
   private int AV296Conceptos_exportwwds_80_tfconbaseosdif_sels_size ;
   private int AV301Conceptos_exportwwds_85_tfconpadre_sels_size ;
   private int AV303GXV24 ;
   private int AV304GXV25 ;
   private long AV106i ;
   private long AV81TFConOrdEjec ;
   private long AV82TFConOrdEjec_To ;
   private long AV32VisibleColumnCount ;
   private long A510ConOrdEjec ;
   private long AV242Conceptos_exportwwds_26_tfconordejec ;
   private long AV243Conceptos_exportwwds_27_tfconordejec_to ;
   private String AV192Pgmname ;
   private String AV40TFConCodigo_Sel ;
   private String AV38TFConCodigo ;
   private String AV64TFTipoConCod_Sel ;
   private String AV68TFSubTipoConCod1_Sel ;
   private String AV66TFSubTipoConCod1 ;
   private String AV72TFSubTipoConCod2_Sel ;
   private String AV70TFSubTipoConCod2 ;
   private String AV94TFConCondicion_Sel ;
   private String AV98TFConCondCodigo_Sel ;
   private String AV96TFConCondCodigo ;
   private String AV114TFConCodAfip_Sel ;
   private String AV112TFConCodAfip ;
   private String AV153TFConceptoConveCodigo_Sel ;
   private String AV151TFConceptoConveCodigo ;
   private String AV187TFConPadre_Sel ;
   private String AV185TFConPadre ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String A1648ConCodAfip ;
   private String A1645ConceptoConveCodigo ;
   private String A921ConPadre ;
   private String AV219Conceptos_exportwwds_3_tfconcodigo ;
   private String AV234Conceptos_exportwwds_18_tfsubtipoconcod1 ;
   private String AV236Conceptos_exportwwds_20_tfsubtipoconcod2 ;
   private String AV248Conceptos_exportwwds_32_tfconcondcodigo ;
   private String AV255Conceptos_exportwwds_39_tfconcodafip ;
   private String AV289Conceptos_exportwwds_73_tfconceptoconvecodigo ;
   private String AV300Conceptos_exportwwds_84_tfconpadre ;
   private String scmdbuf ;
   private String lV219Conceptos_exportwwds_3_tfconcodigo ;
   private String lV234Conceptos_exportwwds_18_tfsubtipoconcod1 ;
   private String lV236Conceptos_exportwwds_20_tfsubtipoconcod2 ;
   private String lV248Conceptos_exportwwds_32_tfconcondcodigo ;
   private String lV255Conceptos_exportwwds_39_tfconcodafip ;
   private String lV289Conceptos_exportwwds_73_tfconceptoconvecodigo ;
   private String lV300Conceptos_exportwwds_84_tfconpadre ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A159ConVariable ;
   private boolean A146ConForEditable ;
   private boolean A762ConRecalcular ;
   private boolean A1068ConMostrarPos ;
   private boolean A1194ConSegunPla ;
   private boolean A1821ConErrorSiCero ;
   private boolean A1826ConPueNov ;
   private boolean AV19OrderedDsc ;
   private boolean n921ConPadre ;
   private boolean n1822CliPadre ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1644ConceptoPais ;
   private boolean n1112AplIIGG ;
   private boolean n1077ConAdelDescu ;
   private boolean n953ConCondicion ;
   private boolean n970ConClasifAux ;
   private boolean n503ConTipoLiqAux ;
   private boolean n39SubTipoConCod2 ;
   private boolean n38SubTipoConCod1 ;
   private boolean n146ConForEditable ;
   private boolean n148ConFormula ;
   private String AV27ColumnsSelectorXML ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String AV28UserCustomValue ;
   private String AV37TFConCodigo_SelsJson ;
   private String AV41TFConDescrip_SelsJson ;
   private String AV52TFConFormula_SelsJson ;
   private String AV56TFConObservacion_SelsJson ;
   private String AV62TFTipoConCod_SelsJson ;
   private String AV65TFSubTipoConCod1_SelsJson ;
   private String AV69TFSubTipoConCod2_SelsJson ;
   private String AV73TFConTipoLiqAux_SelsJson ;
   private String AV77TFConClasifAux_SelsJson ;
   private String AV88TFConRangoCant_SelsJson ;
   private String AV92TFConCondicion_SelsJson ;
   private String AV95TFConCondCodigo_SelsJson ;
   private String AV100TFConAdelDescu_SelsJson ;
   private String AV111TFConCodAfip_SelsJson ;
   private String AV150TFConceptoConveCodigo_SelsJson ;
   private String AV163TFConBaseLicProm_SelsJson ;
   private String AV166TFConBaseFerProm_SelsJson ;
   private String AV169TFConBaseHorExtProm_SelsJson ;
   private String AV172TFConBasePres_SelsJson ;
   private String AV175TFConBaseAnt_SelsJson ;
   private String AV178TFConBaseOSDif_SelsJson ;
   private String AV184TFConPadre_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV44TFConDescrip_Sel ;
   private String AV42TFConDescrip ;
   private String AV55TFConFormula_Sel ;
   private String AV53TFConFormula ;
   private String AV59TFConObservacion_Sel ;
   private String AV57TFConObservacion ;
   private String AV76TFConTipoLiqAux_Sel ;
   private String AV74TFConTipoLiqAux ;
   private String AV80TFConClasifAux_Sel ;
   private String AV78TFConClasifAux ;
   private String AV91TFConRangoCant_Sel ;
   private String AV89TFConRangoCant ;
   private String A41ConDescrip ;
   private String A503ConTipoLiqAux ;
   private String A970ConClasifAux ;
   private String A1018ConRangoCant ;
   private String AV221Conceptos_exportwwds_5_tfcondescrip ;
   private String AV227Conceptos_exportwwds_11_tfconformula ;
   private String AV229Conceptos_exportwwds_13_tfconobservacion ;
   private String AV238Conceptos_exportwwds_22_tfcontipoliqaux ;
   private String AV240Conceptos_exportwwds_24_tfconclasifaux ;
   private String AV245Conceptos_exportwwds_29_tfconrangocant ;
   private String lV221Conceptos_exportwwds_5_tfcondescrip ;
   private String lV227Conceptos_exportwwds_11_tfconformula ;
   private String lV229Conceptos_exportwwds_13_tfconobservacion ;
   private String lV238Conceptos_exportwwds_22_tfcontipoliqaux ;
   private String lV240Conceptos_exportwwds_24_tfconclasifaux ;
   private String lV245Conceptos_exportwwds_29_tfconrangocant ;
   private String AV189MenuOpcCod ;
   private GXSimpleCollection<Byte> AV101TFConAdelDescu_Sels ;
   private GXSimpleCollection<Byte> AV164TFConBaseLicProm_Sels ;
   private GXSimpleCollection<Byte> AV167TFConBaseFerProm_Sels ;
   private GXSimpleCollection<Byte> AV170TFConBaseHorExtProm_Sels ;
   private GXSimpleCollection<Byte> AV173TFConBasePres_Sels ;
   private GXSimpleCollection<Byte> AV176TFConBaseAnt_Sels ;
   private GXSimpleCollection<Byte> AV179TFConBaseOSDif_Sels ;
   private GXSimpleCollection<Byte> AV251Conceptos_exportwwds_35_tfconadeldescu_sels ;
   private GXSimpleCollection<Byte> AV291Conceptos_exportwwds_75_tfconbaselicprom_sels ;
   private GXSimpleCollection<Byte> AV292Conceptos_exportwwds_76_tfconbaseferprom_sels ;
   private GXSimpleCollection<Byte> AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels ;
   private GXSimpleCollection<Byte> AV294Conceptos_exportwwds_78_tfconbasepres_sels ;
   private GXSimpleCollection<Byte> AV295Conceptos_exportwwds_79_tfconbaseant_sels ;
   private GXSimpleCollection<Byte> AV296Conceptos_exportwwds_80_tfconbaseosdif_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV39TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV63TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV67TFSubTipoConCod1_Sels ;
   private GXSimpleCollection<String> AV71TFSubTipoConCod2_Sels ;
   private GXSimpleCollection<String> AV93TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV97TFConCondCodigo_Sels ;
   private GXSimpleCollection<String> AV113TFConCodAfip_Sels ;
   private GXSimpleCollection<String> AV152TFConceptoConveCodigo_Sels ;
   private GXSimpleCollection<String> AV186TFConPadre_Sels ;
   private GXSimpleCollection<String> AV43TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV54TFConFormula_Sels ;
   private GXSimpleCollection<String> AV58TFConObservacion_Sels ;
   private GXSimpleCollection<String> AV75TFConTipoLiqAux_Sels ;
   private GXSimpleCollection<String> AV79TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV90TFConRangoCant_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01KK2_A1826ConPueNov ;
   private String[] P01KK2_A921ConPadre ;
   private boolean[] P01KK2_n921ConPadre ;
   private int[] P01KK2_A1822CliPadre ;
   private boolean[] P01KK2_n1822CliPadre ;
   private boolean[] P01KK2_A1821ConErrorSiCero ;
   private byte[] P01KK2_A1827ConBaseOSDif ;
   private byte[] P01KK2_A1801ConBaseAnt ;
   private byte[] P01KK2_A1800ConBasePres ;
   private byte[] P01KK2_A1799ConBaseHorExtProm ;
   private byte[] P01KK2_A1798ConBaseFerProm ;
   private byte[] P01KK2_A1797ConBaseLicProm ;
   private String[] P01KK2_A1645ConceptoConveCodigo ;
   private boolean[] P01KK2_n1645ConceptoConveCodigo ;
   private short[] P01KK2_A1644ConceptoPais ;
   private boolean[] P01KK2_n1644ConceptoPais ;
   private byte[] P01KK2_A1486ConRegEspApo ;
   private byte[] P01KK2_A1485ConRegDifApo ;
   private byte[] P01KK2_A1484ConLeyRieTrabCont ;
   private byte[] P01KK2_A1483ConFonNacEmpCont ;
   private byte[] P01KK2_A1482ConAsigFamCont ;
   private byte[] P01KK2_A1481ConRenateaCont ;
   private byte[] P01KK2_A1480ConRenateaApo ;
   private byte[] P01KK2_A1479ConFonSolRedCont ;
   private byte[] P01KK2_A1478ConFonSolRedApo ;
   private byte[] P01KK2_A1477ConObraSocCont ;
   private byte[] P01KK2_A1476ConObraSocApo ;
   private byte[] P01KK2_A1475ConINSSJyPCont ;
   private byte[] P01KK2_A1474ConINSSJyPApo ;
   private byte[] P01KK2_A1473ConSIPACont ;
   private byte[] P01KK2_A1472ConSIPAApo ;
   private String[] P01KK2_A1648ConCodAfip ;
   private boolean[] P01KK2_A1194ConSegunPla ;
   private short[] P01KK2_A1112AplIIGG ;
   private boolean[] P01KK2_n1112AplIIGG ;
   private byte[] P01KK2_A1077ConAdelDescu ;
   private boolean[] P01KK2_n1077ConAdelDescu ;
   private boolean[] P01KK2_A1068ConMostrarPos ;
   private String[] P01KK2_A954ConCondCodigo ;
   private String[] P01KK2_A953ConCondicion ;
   private boolean[] P01KK2_n953ConCondicion ;
   private String[] P01KK2_A1018ConRangoCant ;
   private boolean[] P01KK2_A762ConRecalcular ;
   private long[] P01KK2_A510ConOrdEjec ;
   private String[] P01KK2_A970ConClasifAux ;
   private boolean[] P01KK2_n970ConClasifAux ;
   private String[] P01KK2_A503ConTipoLiqAux ;
   private boolean[] P01KK2_n503ConTipoLiqAux ;
   private String[] P01KK2_A39SubTipoConCod2 ;
   private boolean[] P01KK2_n39SubTipoConCod2 ;
   private String[] P01KK2_A38SubTipoConCod1 ;
   private boolean[] P01KK2_n38SubTipoConCod1 ;
   private String[] P01KK2_A37TipoConCod ;
   private boolean[] P01KK2_A146ConForEditable ;
   private boolean[] P01KK2_n146ConForEditable ;
   private boolean[] P01KK2_A159ConVariable ;
   private String[] P01KK2_A153ConObservacion ;
   private String[] P01KK2_A148ConFormula ;
   private boolean[] P01KK2_n148ConFormula ;
   private byte[] P01KK2_A1488ConLiqBasica ;
   private int[] P01KK2_A40ConOrden ;
   private String[] P01KK2_A41ConDescrip ;
   private String[] P01KK2_A26ConCodigo ;
   private int[] P01KK2_A3CliCod ;
   private byte[] P01KK2_A1622ConBaseHorExt ;
   private byte[] P01KK2_A1621ConBaseFer ;
   private byte[] P01KK2_A1620ConBaseLic ;
   private byte[] P01KK2_A1539ConSacDeven ;
   private byte[] P01KK2_A162ConVigencia ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV220Conceptos_exportwwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV233Conceptos_exportwwds_17_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels ;
   private GXSimpleCollection<String> AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels ;
   private GXSimpleCollection<String> AV247Conceptos_exportwwds_31_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV249Conceptos_exportwwds_33_tfconcondcodigo_sels ;
   private GXSimpleCollection<String> AV256Conceptos_exportwwds_40_tfconcodafip_sels ;
   private GXSimpleCollection<String> AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ;
   private GXSimpleCollection<String> AV301Conceptos_exportwwds_85_tfconpadre_sels ;
   private GXSimpleCollection<String> AV222Conceptos_exportwwds_6_tfcondescrip_sels ;
   private GXSimpleCollection<String> AV228Conceptos_exportwwds_12_tfconformula_sels ;
   private GXSimpleCollection<String> AV230Conceptos_exportwwds_14_tfconobservacion_sels ;
   private GXSimpleCollection<String> AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels ;
   private GXSimpleCollection<String> AV241Conceptos_exportwwds_25_tfconclasifaux_sels ;
   private GXSimpleCollection<String> AV246Conceptos_exportwwds_30_tfconrangocant_sels ;
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

final  class conceptos_exportwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV220Conceptos_exportwwds_4_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV222Conceptos_exportwwds_6_tfcondescrip_sels ,
                                          String A148ConFormula ,
                                          GXSimpleCollection<String> AV228Conceptos_exportwwds_12_tfconformula_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV230Conceptos_exportwwds_14_tfconobservacion_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV233Conceptos_exportwwds_17_tftipoconcod_sels ,
                                          String A38SubTipoConCod1 ,
                                          GXSimpleCollection<String> AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                          String A39SubTipoConCod2 ,
                                          GXSimpleCollection<String> AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV241Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                          String A1018ConRangoCant ,
                                          GXSimpleCollection<String> AV246Conceptos_exportwwds_30_tfconrangocant_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV247Conceptos_exportwwds_31_tfconcondicion_sels ,
                                          String A954ConCondCodigo ,
                                          GXSimpleCollection<String> AV249Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                          byte A1077ConAdelDescu ,
                                          GXSimpleCollection<Byte> AV251Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV256Conceptos_exportwwds_40_tfconcodafip_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV291Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV292Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV294Conceptos_exportwwds_78_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV295Conceptos_exportwwds_79_tfconbaseant_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV296Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                          String A921ConPadre ,
                                          GXSimpleCollection<String> AV301Conceptos_exportwwds_85_tfconpadre_sels ,
                                          int AV217Conceptos_exportwwds_1_tfclicod ,
                                          int AV218Conceptos_exportwwds_2_tfclicod_to ,
                                          int AV220Conceptos_exportwwds_4_tfconcodigo_sels_size ,
                                          String AV219Conceptos_exportwwds_3_tfconcodigo ,
                                          int AV222Conceptos_exportwwds_6_tfcondescrip_sels_size ,
                                          String AV221Conceptos_exportwwds_5_tfcondescrip ,
                                          int AV223Conceptos_exportwwds_7_tfconorden ,
                                          int AV224Conceptos_exportwwds_8_tfconorden_to ,
                                          byte AV225Conceptos_exportwwds_9_tfconliqbasica ,
                                          byte AV226Conceptos_exportwwds_10_tfconliqbasica_to ,
                                          int AV228Conceptos_exportwwds_12_tfconformula_sels_size ,
                                          String AV227Conceptos_exportwwds_11_tfconformula ,
                                          int AV230Conceptos_exportwwds_14_tfconobservacion_sels_size ,
                                          String AV229Conceptos_exportwwds_13_tfconobservacion ,
                                          byte AV231Conceptos_exportwwds_15_tfconvariable_sel ,
                                          byte AV232Conceptos_exportwwds_16_tfconforeditable_sel ,
                                          int AV233Conceptos_exportwwds_17_tftipoconcod_sels_size ,
                                          int AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size ,
                                          String AV234Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                          int AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size ,
                                          String AV236Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                          int AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels_size ,
                                          String AV238Conceptos_exportwwds_22_tfcontipoliqaux ,
                                          int AV241Conceptos_exportwwds_25_tfconclasifaux_sels_size ,
                                          String AV240Conceptos_exportwwds_24_tfconclasifaux ,
                                          long AV242Conceptos_exportwwds_26_tfconordejec ,
                                          long AV243Conceptos_exportwwds_27_tfconordejec_to ,
                                          byte AV244Conceptos_exportwwds_28_tfconrecalcular_sel ,
                                          int AV246Conceptos_exportwwds_30_tfconrangocant_sels_size ,
                                          String AV245Conceptos_exportwwds_29_tfconrangocant ,
                                          int AV247Conceptos_exportwwds_31_tfconcondicion_sels_size ,
                                          int AV249Conceptos_exportwwds_33_tfconcondcodigo_sels_size ,
                                          String AV248Conceptos_exportwwds_32_tfconcondcodigo ,
                                          byte AV250Conceptos_exportwwds_34_tfconmostrarpos_sel ,
                                          int AV251Conceptos_exportwwds_35_tfconadeldescu_sels_size ,
                                          short AV252Conceptos_exportwwds_36_tfapliigg ,
                                          short AV253Conceptos_exportwwds_37_tfapliigg_to ,
                                          byte AV254Conceptos_exportwwds_38_tfconsegunpla_sel ,
                                          int AV256Conceptos_exportwwds_40_tfconcodafip_sels_size ,
                                          String AV255Conceptos_exportwwds_39_tfconcodafip ,
                                          byte AV257Conceptos_exportwwds_41_tfconsipaapo ,
                                          byte AV258Conceptos_exportwwds_42_tfconsipaapo_to ,
                                          byte AV259Conceptos_exportwwds_43_tfconsipacont ,
                                          byte AV260Conceptos_exportwwds_44_tfconsipacont_to ,
                                          byte AV261Conceptos_exportwwds_45_tfconinssjypapo ,
                                          byte AV262Conceptos_exportwwds_46_tfconinssjypapo_to ,
                                          byte AV263Conceptos_exportwwds_47_tfconinssjypcont ,
                                          byte AV264Conceptos_exportwwds_48_tfconinssjypcont_to ,
                                          byte AV265Conceptos_exportwwds_49_tfconobrasocapo ,
                                          byte AV266Conceptos_exportwwds_50_tfconobrasocapo_to ,
                                          byte AV267Conceptos_exportwwds_51_tfconobrasoccont ,
                                          byte AV268Conceptos_exportwwds_52_tfconobrasoccont_to ,
                                          byte AV269Conceptos_exportwwds_53_tfconfonsolredapo ,
                                          byte AV270Conceptos_exportwwds_54_tfconfonsolredapo_to ,
                                          byte AV271Conceptos_exportwwds_55_tfconfonsolredcont ,
                                          byte AV272Conceptos_exportwwds_56_tfconfonsolredcont_to ,
                                          byte AV273Conceptos_exportwwds_57_tfconrenateaapo ,
                                          byte AV274Conceptos_exportwwds_58_tfconrenateaapo_to ,
                                          byte AV275Conceptos_exportwwds_59_tfconrenateacont ,
                                          byte AV276Conceptos_exportwwds_60_tfconrenateacont_to ,
                                          byte AV277Conceptos_exportwwds_61_tfconasigfamcont ,
                                          byte AV278Conceptos_exportwwds_62_tfconasigfamcont_to ,
                                          byte AV279Conceptos_exportwwds_63_tfconfonnacempcont ,
                                          byte AV280Conceptos_exportwwds_64_tfconfonnacempcont_to ,
                                          byte AV281Conceptos_exportwwds_65_tfconleyrietrabcont ,
                                          byte AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to ,
                                          byte AV283Conceptos_exportwwds_67_tfconregdifapo ,
                                          byte AV284Conceptos_exportwwds_68_tfconregdifapo_to ,
                                          byte AV285Conceptos_exportwwds_69_tfconregespapo ,
                                          byte AV286Conceptos_exportwwds_70_tfconregespapo_to ,
                                          short AV287Conceptos_exportwwds_71_tfconceptopais ,
                                          short AV288Conceptos_exportwwds_72_tfconceptopais_to ,
                                          int AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size ,
                                          String AV289Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                          int AV291Conceptos_exportwwds_75_tfconbaselicprom_sels_size ,
                                          int AV292Conceptos_exportwwds_76_tfconbaseferprom_sels_size ,
                                          int AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels_size ,
                                          int AV294Conceptos_exportwwds_78_tfconbasepres_sels_size ,
                                          int AV295Conceptos_exportwwds_79_tfconbaseant_sels_size ,
                                          int AV296Conceptos_exportwwds_80_tfconbaseosdif_sels_size ,
                                          byte AV297Conceptos_exportwwds_81_tfconerrorsicero_sel ,
                                          int AV298Conceptos_exportwwds_82_tfclipadre ,
                                          int AV299Conceptos_exportwwds_83_tfclipadre_to ,
                                          int AV301Conceptos_exportwwds_85_tfconpadre_sels_size ,
                                          String AV300Conceptos_exportwwds_84_tfconpadre ,
                                          byte AV302Conceptos_exportwwds_86_tfconpuenov_sel ,
                                          int A3CliCod ,
                                          int A40ConOrden ,
                                          byte A1488ConLiqBasica ,
                                          boolean A159ConVariable ,
                                          boolean A146ConForEditable ,
                                          long A510ConOrdEjec ,
                                          boolean A762ConRecalcular ,
                                          boolean A1068ConMostrarPos ,
                                          short A1112AplIIGG ,
                                          boolean A1194ConSegunPla ,
                                          byte A1472ConSIPAApo ,
                                          byte A1473ConSIPACont ,
                                          byte A1474ConINSSJyPApo ,
                                          byte A1475ConINSSJyPCont ,
                                          byte A1476ConObraSocApo ,
                                          byte A1477ConObraSocCont ,
                                          byte A1478ConFonSolRedApo ,
                                          byte A1479ConFonSolRedCont ,
                                          byte A1480ConRenateaApo ,
                                          byte A1481ConRenateaCont ,
                                          byte A1482ConAsigFamCont ,
                                          byte A1483ConFonNacEmpCont ,
                                          byte A1484ConLeyRieTrabCont ,
                                          byte A1485ConRegDifApo ,
                                          byte A1486ConRegEspApo ,
                                          short A1644ConceptoPais ,
                                          boolean A1821ConErrorSiCero ,
                                          int A1822CliPadre ,
                                          boolean A1826ConPueNov ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV107CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[58];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT ConPueNov, ConPadre, CliPadre, ConErrorSiCero, ConBaseOSDif, ConBaseAnt, ConBasePres, ConBaseHorExtProm, ConBaseFerProm, ConBaseLicProm, ConceptoConveCodigo," ;
      scmdbuf += " ConceptoPais, ConRegEspApo, ConRegDifApo, ConLeyRieTrabCont, ConFonNacEmpCont, ConAsigFamCont, ConRenateaCont, ConRenateaApo, ConFonSolRedCont, ConFonSolRedApo," ;
      scmdbuf += " ConObraSocCont, ConObraSocApo, ConINSSJyPCont, ConINSSJyPApo, ConSIPACont, ConSIPAApo, ConCodAfip, ConSegunPla, AplIIGG, ConAdelDescu, ConMostrarPos, ConCondCodigo," ;
      scmdbuf += " ConCondicion, ConRangoCant, ConRecalcular, ConOrdEjec, ConClasifAux, ConTipoLiqAux, SubTipoConCod2, SubTipoConCod1, TipoConCod, ConForEditable, ConVariable, ConObservacion," ;
      scmdbuf += " ConFormula, ConLiqBasica, ConOrden, ConDescrip, ConCodigo, CliCod, ConBaseHorExt, ConBaseFer, ConBaseLic, ConSacDeven, ConVigencia FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV217Conceptos_exportwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ! (0==AV218Conceptos_exportwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ( AV220Conceptos_exportwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV219Conceptos_exportwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV220Conceptos_exportwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV220Conceptos_exportwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV222Conceptos_exportwwds_6_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV221Conceptos_exportwwds_5_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV222Conceptos_exportwwds_6_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV222Conceptos_exportwwds_6_tfcondescrip_sels, "ConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV223Conceptos_exportwwds_7_tfconorden) )
      {
         addWhere(sWhereString, "(ConOrden >= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! (0==AV224Conceptos_exportwwds_8_tfconorden_to) )
      {
         addWhere(sWhereString, "(ConOrden <= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! (0==AV225Conceptos_exportwwds_9_tfconliqbasica) )
      {
         addWhere(sWhereString, "(ConLiqBasica >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (0==AV226Conceptos_exportwwds_10_tfconliqbasica_to) )
      {
         addWhere(sWhereString, "(ConLiqBasica <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ( AV228Conceptos_exportwwds_12_tfconformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV227Conceptos_exportwwds_11_tfconformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConFormula) like LOWER(?))");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( AV228Conceptos_exportwwds_12_tfconformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV228Conceptos_exportwwds_12_tfconformula_sels, "ConFormula IN (", ")")+")");
      }
      if ( ( AV230Conceptos_exportwwds_14_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV229Conceptos_exportwwds_13_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( AV230Conceptos_exportwwds_14_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV230Conceptos_exportwwds_14_tfconobservacion_sels, "ConObservacion IN (", ")")+")");
      }
      if ( AV231Conceptos_exportwwds_15_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(ConVariable = TRUE)");
      }
      if ( AV231Conceptos_exportwwds_15_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(ConVariable = FALSE)");
      }
      if ( AV232Conceptos_exportwwds_16_tfconforeditable_sel == 1 )
      {
         addWhere(sWhereString, "(ConForEditable = TRUE)");
      }
      if ( AV232Conceptos_exportwwds_16_tfconforeditable_sel == 2 )
      {
         addWhere(sWhereString, "(ConForEditable = FALSE)");
      }
      if ( AV233Conceptos_exportwwds_17_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV233Conceptos_exportwwds_17_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV234Conceptos_exportwwds_18_tfsubtipoconcod1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod1) like LOWER(?))");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV235Conceptos_exportwwds_19_tfsubtipoconcod1_sels, "SubTipoConCod1 IN (", ")")+")");
      }
      if ( ( AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV236Conceptos_exportwwds_20_tfsubtipoconcod2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod2) like LOWER(?))");
      }
      else
      {
         GXv_int12[12] = (byte)(1) ;
      }
      if ( AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV237Conceptos_exportwwds_21_tfsubtipoconcod2_sels, "SubTipoConCod2 IN (", ")")+")");
      }
      if ( ( AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV238Conceptos_exportwwds_22_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int12[13] = (byte)(1) ;
      }
      if ( AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV239Conceptos_exportwwds_23_tfcontipoliqaux_sels, "ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV241Conceptos_exportwwds_25_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV240Conceptos_exportwwds_24_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int12[14] = (byte)(1) ;
      }
      if ( AV241Conceptos_exportwwds_25_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV241Conceptos_exportwwds_25_tfconclasifaux_sels, "ConClasifAux IN (", ")")+")");
      }
      if ( ! (0==AV242Conceptos_exportwwds_26_tfconordejec) )
      {
         addWhere(sWhereString, "(ConOrdEjec >= ?)");
      }
      else
      {
         GXv_int12[15] = (byte)(1) ;
      }
      if ( ! (0==AV243Conceptos_exportwwds_27_tfconordejec_to) )
      {
         addWhere(sWhereString, "(ConOrdEjec <= ?)");
      }
      else
      {
         GXv_int12[16] = (byte)(1) ;
      }
      if ( AV244Conceptos_exportwwds_28_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(ConRecalcular = TRUE)");
      }
      if ( AV244Conceptos_exportwwds_28_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(ConRecalcular = FALSE)");
      }
      if ( ( AV246Conceptos_exportwwds_30_tfconrangocant_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV245Conceptos_exportwwds_29_tfconrangocant)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConRangoCant) like LOWER(?))");
      }
      else
      {
         GXv_int12[17] = (byte)(1) ;
      }
      if ( AV246Conceptos_exportwwds_30_tfconrangocant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV246Conceptos_exportwwds_30_tfconrangocant_sels, "ConRangoCant IN (", ")")+")");
      }
      if ( AV247Conceptos_exportwwds_31_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV247Conceptos_exportwwds_31_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ( AV249Conceptos_exportwwds_33_tfconcondcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV248Conceptos_exportwwds_32_tfconcondcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCondCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[18] = (byte)(1) ;
      }
      if ( AV249Conceptos_exportwwds_33_tfconcondcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV249Conceptos_exportwwds_33_tfconcondcodigo_sels, "ConCondCodigo IN (", ")")+")");
      }
      if ( AV250Conceptos_exportwwds_34_tfconmostrarpos_sel == 1 )
      {
         addWhere(sWhereString, "(ConMostrarPos = TRUE)");
      }
      if ( AV250Conceptos_exportwwds_34_tfconmostrarpos_sel == 2 )
      {
         addWhere(sWhereString, "(ConMostrarPos = FALSE)");
      }
      if ( AV251Conceptos_exportwwds_35_tfconadeldescu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV251Conceptos_exportwwds_35_tfconadeldescu_sels, "ConAdelDescu IN (", ")")+")");
      }
      if ( ! (0==AV252Conceptos_exportwwds_36_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int12[19] = (byte)(1) ;
      }
      if ( ! (0==AV253Conceptos_exportwwds_37_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int12[20] = (byte)(1) ;
      }
      if ( AV254Conceptos_exportwwds_38_tfconsegunpla_sel == 1 )
      {
         addWhere(sWhereString, "(ConSegunPla = TRUE)");
      }
      if ( AV254Conceptos_exportwwds_38_tfconsegunpla_sel == 2 )
      {
         addWhere(sWhereString, "(ConSegunPla = FALSE)");
      }
      if ( ( AV256Conceptos_exportwwds_40_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV255Conceptos_exportwwds_39_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int12[21] = (byte)(1) ;
      }
      if ( AV256Conceptos_exportwwds_40_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV256Conceptos_exportwwds_40_tfconcodafip_sels, "ConCodAfip IN (", ")")+")");
      }
      if ( ! (0==AV257Conceptos_exportwwds_41_tfconsipaapo) )
      {
         addWhere(sWhereString, "(ConSIPAApo >= ?)");
      }
      else
      {
         GXv_int12[22] = (byte)(1) ;
      }
      if ( ! (0==AV258Conceptos_exportwwds_42_tfconsipaapo_to) )
      {
         addWhere(sWhereString, "(ConSIPAApo <= ?)");
      }
      else
      {
         GXv_int12[23] = (byte)(1) ;
      }
      if ( ! (0==AV259Conceptos_exportwwds_43_tfconsipacont) )
      {
         addWhere(sWhereString, "(ConSIPACont >= ?)");
      }
      else
      {
         GXv_int12[24] = (byte)(1) ;
      }
      if ( ! (0==AV260Conceptos_exportwwds_44_tfconsipacont_to) )
      {
         addWhere(sWhereString, "(ConSIPACont <= ?)");
      }
      else
      {
         GXv_int12[25] = (byte)(1) ;
      }
      if ( ! (0==AV261Conceptos_exportwwds_45_tfconinssjypapo) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo >= ?)");
      }
      else
      {
         GXv_int12[26] = (byte)(1) ;
      }
      if ( ! (0==AV262Conceptos_exportwwds_46_tfconinssjypapo_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo <= ?)");
      }
      else
      {
         GXv_int12[27] = (byte)(1) ;
      }
      if ( ! (0==AV263Conceptos_exportwwds_47_tfconinssjypcont) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont >= ?)");
      }
      else
      {
         GXv_int12[28] = (byte)(1) ;
      }
      if ( ! (0==AV264Conceptos_exportwwds_48_tfconinssjypcont_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont <= ?)");
      }
      else
      {
         GXv_int12[29] = (byte)(1) ;
      }
      if ( ! (0==AV265Conceptos_exportwwds_49_tfconobrasocapo) )
      {
         addWhere(sWhereString, "(ConObraSocApo >= ?)");
      }
      else
      {
         GXv_int12[30] = (byte)(1) ;
      }
      if ( ! (0==AV266Conceptos_exportwwds_50_tfconobrasocapo_to) )
      {
         addWhere(sWhereString, "(ConObraSocApo <= ?)");
      }
      else
      {
         GXv_int12[31] = (byte)(1) ;
      }
      if ( ! (0==AV267Conceptos_exportwwds_51_tfconobrasoccont) )
      {
         addWhere(sWhereString, "(ConObraSocCont >= ?)");
      }
      else
      {
         GXv_int12[32] = (byte)(1) ;
      }
      if ( ! (0==AV268Conceptos_exportwwds_52_tfconobrasoccont_to) )
      {
         addWhere(sWhereString, "(ConObraSocCont <= ?)");
      }
      else
      {
         GXv_int12[33] = (byte)(1) ;
      }
      if ( ! (0==AV269Conceptos_exportwwds_53_tfconfonsolredapo) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo >= ?)");
      }
      else
      {
         GXv_int12[34] = (byte)(1) ;
      }
      if ( ! (0==AV270Conceptos_exportwwds_54_tfconfonsolredapo_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo <= ?)");
      }
      else
      {
         GXv_int12[35] = (byte)(1) ;
      }
      if ( ! (0==AV271Conceptos_exportwwds_55_tfconfonsolredcont) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont >= ?)");
      }
      else
      {
         GXv_int12[36] = (byte)(1) ;
      }
      if ( ! (0==AV272Conceptos_exportwwds_56_tfconfonsolredcont_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont <= ?)");
      }
      else
      {
         GXv_int12[37] = (byte)(1) ;
      }
      if ( ! (0==AV273Conceptos_exportwwds_57_tfconrenateaapo) )
      {
         addWhere(sWhereString, "(ConRenateaApo >= ?)");
      }
      else
      {
         GXv_int12[38] = (byte)(1) ;
      }
      if ( ! (0==AV274Conceptos_exportwwds_58_tfconrenateaapo_to) )
      {
         addWhere(sWhereString, "(ConRenateaApo <= ?)");
      }
      else
      {
         GXv_int12[39] = (byte)(1) ;
      }
      if ( ! (0==AV275Conceptos_exportwwds_59_tfconrenateacont) )
      {
         addWhere(sWhereString, "(ConRenateaCont >= ?)");
      }
      else
      {
         GXv_int12[40] = (byte)(1) ;
      }
      if ( ! (0==AV276Conceptos_exportwwds_60_tfconrenateacont_to) )
      {
         addWhere(sWhereString, "(ConRenateaCont <= ?)");
      }
      else
      {
         GXv_int12[41] = (byte)(1) ;
      }
      if ( ! (0==AV277Conceptos_exportwwds_61_tfconasigfamcont) )
      {
         addWhere(sWhereString, "(ConAsigFamCont >= ?)");
      }
      else
      {
         GXv_int12[42] = (byte)(1) ;
      }
      if ( ! (0==AV278Conceptos_exportwwds_62_tfconasigfamcont_to) )
      {
         addWhere(sWhereString, "(ConAsigFamCont <= ?)");
      }
      else
      {
         GXv_int12[43] = (byte)(1) ;
      }
      if ( ! (0==AV279Conceptos_exportwwds_63_tfconfonnacempcont) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont >= ?)");
      }
      else
      {
         GXv_int12[44] = (byte)(1) ;
      }
      if ( ! (0==AV280Conceptos_exportwwds_64_tfconfonnacempcont_to) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont <= ?)");
      }
      else
      {
         GXv_int12[45] = (byte)(1) ;
      }
      if ( ! (0==AV281Conceptos_exportwwds_65_tfconleyrietrabcont) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont >= ?)");
      }
      else
      {
         GXv_int12[46] = (byte)(1) ;
      }
      if ( ! (0==AV282Conceptos_exportwwds_66_tfconleyrietrabcont_to) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont <= ?)");
      }
      else
      {
         GXv_int12[47] = (byte)(1) ;
      }
      if ( ! (0==AV283Conceptos_exportwwds_67_tfconregdifapo) )
      {
         addWhere(sWhereString, "(ConRegDifApo >= ?)");
      }
      else
      {
         GXv_int12[48] = (byte)(1) ;
      }
      if ( ! (0==AV284Conceptos_exportwwds_68_tfconregdifapo_to) )
      {
         addWhere(sWhereString, "(ConRegDifApo <= ?)");
      }
      else
      {
         GXv_int12[49] = (byte)(1) ;
      }
      if ( ! (0==AV285Conceptos_exportwwds_69_tfconregespapo) )
      {
         addWhere(sWhereString, "(ConRegEspApo >= ?)");
      }
      else
      {
         GXv_int12[50] = (byte)(1) ;
      }
      if ( ! (0==AV286Conceptos_exportwwds_70_tfconregespapo_to) )
      {
         addWhere(sWhereString, "(ConRegEspApo <= ?)");
      }
      else
      {
         GXv_int12[51] = (byte)(1) ;
      }
      if ( ! (0==AV287Conceptos_exportwwds_71_tfconceptopais) )
      {
         addWhere(sWhereString, "(ConceptoPais >= ?)");
      }
      else
      {
         GXv_int12[52] = (byte)(1) ;
      }
      if ( ! (0==AV288Conceptos_exportwwds_72_tfconceptopais_to) )
      {
         addWhere(sWhereString, "(ConceptoPais <= ?)");
      }
      else
      {
         GXv_int12[53] = (byte)(1) ;
      }
      if ( ( AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV289Conceptos_exportwwds_73_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConceptoConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[54] = (byte)(1) ;
      }
      if ( AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV290Conceptos_exportwwds_74_tfconceptoconvecodigo_sels, "ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV291Conceptos_exportwwds_75_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV291Conceptos_exportwwds_75_tfconbaselicprom_sels, "ConBaseLicProm IN (", ")")+")");
      }
      if ( AV292Conceptos_exportwwds_76_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV292Conceptos_exportwwds_76_tfconbaseferprom_sels, "ConBaseFerProm IN (", ")")+")");
      }
      if ( AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV293Conceptos_exportwwds_77_tfconbasehorextprom_sels, "ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV294Conceptos_exportwwds_78_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV294Conceptos_exportwwds_78_tfconbasepres_sels, "ConBasePres IN (", ")")+")");
      }
      if ( AV295Conceptos_exportwwds_79_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV295Conceptos_exportwwds_79_tfconbaseant_sels, "ConBaseAnt IN (", ")")+")");
      }
      if ( AV296Conceptos_exportwwds_80_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV296Conceptos_exportwwds_80_tfconbaseosdif_sels, "ConBaseOSDif IN (", ")")+")");
      }
      if ( AV297Conceptos_exportwwds_81_tfconerrorsicero_sel == 1 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = TRUE)");
      }
      if ( AV297Conceptos_exportwwds_81_tfconerrorsicero_sel == 2 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = FALSE)");
      }
      if ( ! (0==AV298Conceptos_exportwwds_82_tfclipadre) )
      {
         addWhere(sWhereString, "(CliPadre >= ?)");
      }
      else
      {
         GXv_int12[55] = (byte)(1) ;
      }
      if ( ! (0==AV299Conceptos_exportwwds_83_tfclipadre_to) )
      {
         addWhere(sWhereString, "(CliPadre <= ?)");
      }
      else
      {
         GXv_int12[56] = (byte)(1) ;
      }
      if ( ( AV301Conceptos_exportwwds_85_tfconpadre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV300Conceptos_exportwwds_84_tfconpadre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConPadre) like LOWER(?))");
      }
      else
      {
         GXv_int12[57] = (byte)(1) ;
      }
      if ( AV301Conceptos_exportwwds_85_tfconpadre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV301Conceptos_exportwwds_85_tfconpadre_sels, "ConPadre IN (", ")")+")");
      }
      if ( AV302Conceptos_exportwwds_86_tfconpuenov_sel == 1 )
      {
         addWhere(sWhereString, "(ConPueNov = TRUE)");
      }
      if ( AV302Conceptos_exportwwds_86_tfconpuenov_sel == 2 )
      {
         addWhere(sWhereString, "(ConPueNov = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConOrden" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConOrden DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConVigencia" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConVigencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConLiqBasica" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConLiqBasica DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConFormula" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConFormula DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConObservacion" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConObservacion DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConVariable" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConVariable DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConForEditable" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConForEditable DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConCod" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SubTipoConCod1" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SubTipoConCod1 DESC" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SubTipoConCod2" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SubTipoConCod2 DESC" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTipoLiqAux" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTipoLiqAux DESC" ;
      }
      else if ( ( AV18OrderedBy == 15 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConClasifAux" ;
      }
      else if ( ( AV18OrderedBy == 15 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConClasifAux DESC" ;
      }
      else if ( ( AV18OrderedBy == 16 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConOrdEjec" ;
      }
      else if ( ( AV18OrderedBy == 16 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConOrdEjec DESC" ;
      }
      else if ( ( AV18OrderedBy == 17 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRecalcular" ;
      }
      else if ( ( AV18OrderedBy == 17 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRecalcular DESC" ;
      }
      else if ( ( AV18OrderedBy == 18 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRangoCant" ;
      }
      else if ( ( AV18OrderedBy == 18 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRangoCant DESC" ;
      }
      else if ( ( AV18OrderedBy == 19 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCondicion" ;
      }
      else if ( ( AV18OrderedBy == 19 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCondicion DESC" ;
      }
      else if ( ( AV18OrderedBy == 20 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCondCodigo" ;
      }
      else if ( ( AV18OrderedBy == 20 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCondCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 21 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConMostrarPos" ;
      }
      else if ( ( AV18OrderedBy == 21 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConMostrarPos DESC" ;
      }
      else if ( ( AV18OrderedBy == 22 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConAdelDescu" ;
      }
      else if ( ( AV18OrderedBy == 22 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConAdelDescu DESC" ;
      }
      else if ( ( AV18OrderedBy == 23 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGG" ;
      }
      else if ( ( AV18OrderedBy == 23 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGG DESC" ;
      }
      else if ( ( AV18OrderedBy == 24 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConSegunPla" ;
      }
      else if ( ( AV18OrderedBy == 24 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConSegunPla DESC" ;
      }
      else if ( ( AV18OrderedBy == 25 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCodAfip" ;
      }
      else if ( ( AV18OrderedBy == 25 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCodAfip DESC" ;
      }
      else if ( ( AV18OrderedBy == 26 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConSIPAApo" ;
      }
      else if ( ( AV18OrderedBy == 26 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConSIPAApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 27 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConSIPACont" ;
      }
      else if ( ( AV18OrderedBy == 27 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConSIPACont DESC" ;
      }
      else if ( ( AV18OrderedBy == 28 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConINSSJyPApo" ;
      }
      else if ( ( AV18OrderedBy == 28 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConINSSJyPApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 29 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConINSSJyPCont" ;
      }
      else if ( ( AV18OrderedBy == 29 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConINSSJyPCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 30 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConObraSocApo" ;
      }
      else if ( ( AV18OrderedBy == 30 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConObraSocApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 31 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConObraSocCont" ;
      }
      else if ( ( AV18OrderedBy == 31 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConObraSocCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 32 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConFonSolRedApo" ;
      }
      else if ( ( AV18OrderedBy == 32 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConFonSolRedApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 33 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConFonSolRedCont" ;
      }
      else if ( ( AV18OrderedBy == 33 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConFonSolRedCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 34 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRenateaApo" ;
      }
      else if ( ( AV18OrderedBy == 34 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRenateaApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 35 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRenateaCont" ;
      }
      else if ( ( AV18OrderedBy == 35 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRenateaCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 36 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConAsigFamCont" ;
      }
      else if ( ( AV18OrderedBy == 36 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConAsigFamCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 37 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConFonNacEmpCont" ;
      }
      else if ( ( AV18OrderedBy == 37 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConFonNacEmpCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 38 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConLeyRieTrabCont" ;
      }
      else if ( ( AV18OrderedBy == 38 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConLeyRieTrabCont DESC" ;
      }
      else if ( ( AV18OrderedBy == 39 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRegDifApo" ;
      }
      else if ( ( AV18OrderedBy == 39 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRegDifApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 40 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConRegEspApo" ;
      }
      else if ( ( AV18OrderedBy == 40 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConRegEspApo DESC" ;
      }
      else if ( ( AV18OrderedBy == 41 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConSacDeven" ;
      }
      else if ( ( AV18OrderedBy == 41 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConSacDeven DESC" ;
      }
      else if ( ( AV18OrderedBy == 42 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConceptoPais" ;
      }
      else if ( ( AV18OrderedBy == 42 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConceptoPais DESC" ;
      }
      else if ( ( AV18OrderedBy == 43 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConceptoConveCodigo" ;
      }
      else if ( ( AV18OrderedBy == 43 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConceptoConveCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 44 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseLic" ;
      }
      else if ( ( AV18OrderedBy == 44 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseLic DESC" ;
      }
      else if ( ( AV18OrderedBy == 45 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseLicProm" ;
      }
      else if ( ( AV18OrderedBy == 45 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseLicProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 46 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseFer" ;
      }
      else if ( ( AV18OrderedBy == 46 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseFer DESC" ;
      }
      else if ( ( AV18OrderedBy == 47 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseFerProm" ;
      }
      else if ( ( AV18OrderedBy == 47 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseFerProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 48 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseHorExt" ;
      }
      else if ( ( AV18OrderedBy == 48 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseHorExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 49 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseHorExtProm" ;
      }
      else if ( ( AV18OrderedBy == 49 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseHorExtProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 50 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBasePres" ;
      }
      else if ( ( AV18OrderedBy == 50 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBasePres DESC" ;
      }
      else if ( ( AV18OrderedBy == 51 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseAnt" ;
      }
      else if ( ( AV18OrderedBy == 51 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseAnt DESC" ;
      }
      else if ( ( AV18OrderedBy == 52 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConBaseOSDif" ;
      }
      else if ( ( AV18OrderedBy == 52 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConBaseOSDif DESC" ;
      }
      else if ( ( AV18OrderedBy == 53 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConErrorSiCero" ;
      }
      else if ( ( AV18OrderedBy == 53 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConErrorSiCero DESC" ;
      }
      else if ( ( AV18OrderedBy == 54 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliPadre" ;
      }
      else if ( ( AV18OrderedBy == 54 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliPadre DESC" ;
      }
      else if ( ( AV18OrderedBy == 55 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConPadre" ;
      }
      else if ( ( AV18OrderedBy == 55 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConPadre DESC" ;
      }
      else if ( ( AV18OrderedBy == 56 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConPueNov" ;
      }
      else if ( ( AV18OrderedBy == 56 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConPueNov DESC" ;
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
                  return conditional_P01KK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).byteValue() , ((Number) dynConstraints[53]).byteValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).byteValue() , ((Number) dynConstraints[59]).byteValue() , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).longValue() , ((Number) dynConstraints[70]).longValue() , ((Number) dynConstraints[71]).byteValue() , ((Number) dynConstraints[72]).intValue() , (String)dynConstraints[73] , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).byteValue() , ((Number) dynConstraints[78]).intValue() , ((Number) dynConstraints[79]).shortValue() , ((Number) dynConstraints[80]).shortValue() , ((Number) dynConstraints[81]).byteValue() , ((Number) dynConstraints[82]).intValue() , (String)dynConstraints[83] , ((Number) dynConstraints[84]).byteValue() , ((Number) dynConstraints[85]).byteValue() , ((Number) dynConstraints[86]).byteValue() , ((Number) dynConstraints[87]).byteValue() , ((Number) dynConstraints[88]).byteValue() , ((Number) dynConstraints[89]).byteValue() , ((Number) dynConstraints[90]).byteValue() , ((Number) dynConstraints[91]).byteValue() , ((Number) dynConstraints[92]).byteValue() , ((Number) dynConstraints[93]).byteValue() , ((Number) dynConstraints[94]).byteValue() , ((Number) dynConstraints[95]).byteValue() , ((Number) dynConstraints[96]).byteValue() , ((Number) dynConstraints[97]).byteValue() , ((Number) dynConstraints[98]).byteValue() , ((Number) dynConstraints[99]).byteValue() , ((Number) dynConstraints[100]).byteValue() , ((Number) dynConstraints[101]).byteValue() , ((Number) dynConstraints[102]).byteValue() , ((Number) dynConstraints[103]).byteValue() , ((Number) dynConstraints[104]).byteValue() , ((Number) dynConstraints[105]).byteValue() , ((Number) dynConstraints[106]).byteValue() , ((Number) dynConstraints[107]).byteValue() , ((Number) dynConstraints[108]).byteValue() , ((Number) dynConstraints[109]).byteValue() , ((Number) dynConstraints[110]).byteValue() , ((Number) dynConstraints[111]).byteValue() , ((Number) dynConstraints[112]).byteValue() , ((Number) dynConstraints[113]).byteValue() , ((Number) dynConstraints[114]).shortValue() , ((Number) dynConstraints[115]).shortValue() , ((Number) dynConstraints[116]).intValue() , (String)dynConstraints[117] , ((Number) dynConstraints[118]).intValue() , ((Number) dynConstraints[119]).intValue() , ((Number) dynConstraints[120]).intValue() , ((Number) dynConstraints[121]).intValue() , ((Number) dynConstraints[122]).intValue() , ((Number) dynConstraints[123]).intValue() , ((Number) dynConstraints[124]).byteValue() , ((Number) dynConstraints[125]).intValue() , ((Number) dynConstraints[126]).intValue() , ((Number) dynConstraints[127]).intValue() , (String)dynConstraints[128] , ((Number) dynConstraints[129]).byteValue() , ((Number) dynConstraints[130]).intValue() , ((Number) dynConstraints[131]).intValue() , ((Number) dynConstraints[132]).byteValue() , ((Boolean) dynConstraints[133]).booleanValue() , ((Boolean) dynConstraints[134]).booleanValue() , ((Number) dynConstraints[135]).longValue() , ((Boolean) dynConstraints[136]).booleanValue() , ((Boolean) dynConstraints[137]).booleanValue() , ((Number) dynConstraints[138]).shortValue() , ((Boolean) dynConstraints[139]).booleanValue() , ((Number) dynConstraints[140]).byteValue() , ((Number) dynConstraints[141]).byteValue() , ((Number) dynConstraints[142]).byteValue() , ((Number) dynConstraints[143]).byteValue() , ((Number) dynConstraints[144]).byteValue() , ((Number) dynConstraints[145]).byteValue() , ((Number) dynConstraints[146]).byteValue() , ((Number) dynConstraints[147]).byteValue() , ((Number) dynConstraints[148]).byteValue() , ((Number) dynConstraints[149]).byteValue() , ((Number) dynConstraints[150]).byteValue() , ((Number) dynConstraints[151]).byteValue() , ((Number) dynConstraints[152]).byteValue() , ((Number) dynConstraints[153]).byteValue() , ((Number) dynConstraints[154]).byteValue() , ((Number) dynConstraints[155]).shortValue() , ((Boolean) dynConstraints[156]).booleanValue() , ((Number) dynConstraints[157]).intValue() , ((Boolean) dynConstraints[158]).booleanValue() , ((Number) dynConstraints[159]).shortValue() , ((Boolean) dynConstraints[160]).booleanValue() , ((Number) dynConstraints[161]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(4);
               ((byte[]) buf[6])[0] = rslt.getByte(5);
               ((byte[]) buf[7])[0] = rslt.getByte(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((byte[]) buf[10])[0] = rslt.getByte(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((byte[]) buf[17])[0] = rslt.getByte(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((byte[]) buf[19])[0] = rslt.getByte(16);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((byte[]) buf[21])[0] = rslt.getByte(18);
               ((byte[]) buf[22])[0] = rslt.getByte(19);
               ((byte[]) buf[23])[0] = rslt.getByte(20);
               ((byte[]) buf[24])[0] = rslt.getByte(21);
               ((byte[]) buf[25])[0] = rslt.getByte(22);
               ((byte[]) buf[26])[0] = rslt.getByte(23);
               ((byte[]) buf[27])[0] = rslt.getByte(24);
               ((byte[]) buf[28])[0] = rslt.getByte(25);
               ((byte[]) buf[29])[0] = rslt.getByte(26);
               ((byte[]) buf[30])[0] = rslt.getByte(27);
               ((String[]) buf[31])[0] = rslt.getString(28, 6);
               ((boolean[]) buf[32])[0] = rslt.getBoolean(29);
               ((short[]) buf[33])[0] = rslt.getShort(30);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((byte[]) buf[35])[0] = rslt.getByte(31);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((boolean[]) buf[37])[0] = rslt.getBoolean(32);
               ((String[]) buf[38])[0] = rslt.getString(33, 20);
               ((String[]) buf[39])[0] = rslt.getString(34, 20);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getVarchar(35);
               ((boolean[]) buf[42])[0] = rslt.getBoolean(36);
               ((long[]) buf[43])[0] = rslt.getLong(37);
               ((String[]) buf[44])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getString(40, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(41, 20);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(43);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((boolean[]) buf[55])[0] = rslt.getBoolean(44);
               ((String[]) buf[56])[0] = rslt.getLongVarchar(45);
               ((String[]) buf[57])[0] = rslt.getLongVarchar(46);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((byte[]) buf[59])[0] = rslt.getByte(47);
               ((int[]) buf[60])[0] = rslt.getInt(48);
               ((String[]) buf[61])[0] = rslt.getVarchar(49);
               ((String[]) buf[62])[0] = rslt.getString(50, 10);
               ((int[]) buf[63])[0] = rslt.getInt(51);
               ((byte[]) buf[64])[0] = rslt.getByte(52);
               ((byte[]) buf[65])[0] = rslt.getByte(53);
               ((byte[]) buf[66])[0] = rslt.getByte(54);
               ((byte[]) buf[67])[0] = rslt.getByte(55);
               ((byte[]) buf[68])[0] = rslt.getByte(56);
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
                  stmt.setInt(sIdx, ((Number) parms[58]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[59]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[60]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[61], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[64]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[65]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[66]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 20);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[70], 20);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 80);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[73]).longValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[74]).longValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 400);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 20);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[77]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[78]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[79], 6);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[80]).byteValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[81]).byteValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[82]).byteValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[83]).byteValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[84]).byteValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[85]).byteValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[86]).byteValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[87]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[88]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[89]).byteValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[90]).byteValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[91]).byteValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[92]).byteValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[93]).byteValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[94]).byteValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[95]).byteValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[96]).byteValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[97]).byteValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[98]).byteValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[99]).byteValue());
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[100]).byteValue());
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[101]).byteValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[102]).byteValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[103]).byteValue());
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[104]).byteValue());
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[105]).byteValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[106]).byteValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[107]).byteValue());
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[108]).byteValue());
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[109]).byteValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[112], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[114]).intValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[115], 10);
               }
               return;
      }
   }

}

