package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptowwexport extends GXProcedure
{
   public conceptowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptowwexport.class ), "" );
   }

   public conceptowwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      conceptowwexport.this.aP1 = new String[] {""};
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
      conceptowwexport.this.aP0 = aP0;
      conceptowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV83CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV83CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto", GXv_boolean4) ;
      conceptowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV146Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ConceptoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV147GXV1 = 1 ;
         while ( AV147GXV1 <= AV38TFConCodigo_Sels.size() )
         {
            AV39TFConCodigo_Sel = (String)AV38TFConCodigo_Sels.elementAt(-1+AV147GXV1) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFConCodigo_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV147GXV1 = (int)(AV147GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFConCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFConCodigo, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV42TFConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV148GXV2 = 1 ;
         while ( AV148GXV2 <= AV42TFConDescrip_Sels.size() )
         {
            AV43TFConDescrip_Sel = (String)AV42TFConDescrip_Sels.elementAt(-1+AV148GXV2) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFConDescrip_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV148GXV2 = (int)(AV148GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFConDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFConDescrip, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV45TFTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV149GXV3 = 1 ;
         while ( AV149GXV3 <= AV45TFTipoConCod_Sels.size() )
         {
            AV46TFTipoConCod_Sel = (String)AV45TFTipoConCod_Sels.elementAt(-1+AV149GXV3) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV46TFTipoConCod_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV149GXV3 = (int)(AV149GXV3+1) ;
         }
      }
      if ( ! ( ( AV49TFConClasifAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV150GXV4 = 1 ;
         while ( AV150GXV4 <= AV49TFConClasifAux_Sels.size() )
         {
            AV50TFConClasifAux_Sel = (String)AV49TFConClasifAux_Sels.elementAt(-1+AV150GXV4) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFConClasifAux_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV150GXV4 = (int)(AV150GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV48TFConClasifAux)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFConClasifAux, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV53TFConTipoLiqAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV151GXV5 = 1 ;
         while ( AV151GXV5 <= AV53TFConTipoLiqAux_Sels.size() )
         {
            AV54TFConTipoLiqAux_Sel = (String)AV53TFConTipoLiqAux_Sels.elementAt(-1+AV151GXV5) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFConTipoLiqAux_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV151GXV5 = (int)(AV151GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFConTipoLiqAux)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFConTipoLiqAux, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV90TFConceptoConveCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV152GXV6 = 1 ;
         while ( AV152GXV6 <= AV90TFConceptoConveCodigo_Sels.size() )
         {
            AV91TFConceptoConveCodigo_Sel = (String)AV90TFConceptoConveCodigo_Sels.elementAt(-1+AV152GXV6) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV138TFConceptoConveCodigo_SelDsc = AV91TFConceptoConveCodigo_Sel ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+AV138TFConceptoConveCodigo_SelDsc );
            AV82i = (long)(AV82i+1) ;
            AV152GXV6 = (int)(AV152GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV89TFConceptoConveCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV89TFConceptoConveCodigo, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV60TFConVigencia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Aplicación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV153GXV7 = 1 ;
         while ( AV153GXV7 <= AV60TFConVigencia_Sels.size() )
         {
            AV61TFConVigencia_Sel = ((Number) AV60TFConVigencia_Sels.elementAt(-1+AV153GXV7)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainvigenciaconcepto.getDescription(httpContext,(byte)AV61TFConVigencia_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV153GXV7 = (int)(AV153GXV7+1) ;
         }
      }
      if ( ! ( (0==AV65TFConVariable_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Rem. Var.", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV65TFConVariable_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV65TFConVariable_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV66TFConFormula)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Fórmula", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         GXt_char8 = "" ;
         GXv_char9[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV66TFConFormula, 1, 1000), GXv_char9) ;
         conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
      }
      if ( ! ( (0==AV67TFConHabilitado_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Habilitado", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV67TFConHabilitado_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV67TFConHabilitado_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV70TFConObservacion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV154GXV8 = 1 ;
         while ( AV154GXV8 <= AV70TFConObservacion_Sels.size() )
         {
            AV71TFConObservacion_Sel = (String)AV70TFConObservacion_Sels.elementAt(-1+AV154GXV8) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV71TFConObservacion_Sel, 1, 1000), GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV154GXV8 = (int)(AV154GXV8+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV69TFConObservacion)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV69TFConObservacion, 1, 1000), GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV73TFAplIIGG_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tratamiento IIGG", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV155GXV9 = 1 ;
         while ( AV155GXV9 <= AV73TFAplIIGG_Sels.size() )
         {
            AV74TFAplIIGG_Sel = ((Number) AV73TFAplIIGG_Sels.elementAt(-1+AV155GXV9)).shortValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( DecimalUtil.doubleToDec(AV74TFAplIIGG_Sel), "ZZZ9") );
            AV82i = (long)(AV82i+1) ;
            AV155GXV9 = (int)(AV155GXV9+1) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV75TFConFchModFor) && GXutil.dateCompare(GXutil.nullDate(), AV76TFConFchModFor_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de Modificación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( AV75TFConFchModFor );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( AV76TFConFchModFor_To );
      }
      if ( ! ( (0==AV78TFConRecalcular_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Recalcula Retroactivo en ganancias", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV78TFConRecalcular_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV78TFConRecalcular_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV63TFConCondicion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Condición para liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV156GXV10 = 1 ;
         while ( AV156GXV10 <= AV63TFConCondicion_Sels.size() )
         {
            AV64TFConCondicion_Sel = (String)AV63TFConCondicion_Sels.elementAt(-1+AV156GXV10) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV64TFConCondicion_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV156GXV10 = (int)(AV156GXV10+1) ;
         }
      }
      if ( ! ( ( AV86TFConSacDeven_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo devengamiento", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV157GXV11 = 1 ;
         while ( AV157GXV11 <= AV86TFConSacDeven_Sels.size() )
         {
            AV87TFConSacDeven_Sel = ((Number) AV86TFConSacDeven_Sels.elementAt(-1+AV157GXV11)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainsac_devengamiento.getDescription(httpContext,(byte)AV87TFConSacDeven_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV157GXV11 = (int)(AV157GXV11+1) ;
         }
      }
      if ( ! ( ( AV94TFConCodAfip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto AFIP", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV158GXV12 = 1 ;
         while ( AV158GXV12 <= AV94TFConCodAfip_Sels.size() )
         {
            AV95TFConCodAfip_Sel = (String)AV94TFConCodAfip_Sels.elementAt(-1+AV158GXV12) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV95TFConCodAfip_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV158GXV12 = (int)(AV158GXV12+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV93TFConCodAfip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto AFIP", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV93TFConCodAfip, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV99TFConBasePres_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para presentismo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV159GXV13 = 1 ;
         while ( AV159GXV13 <= AV99TFConBasePres_Sels.size() )
         {
            AV100TFConBasePres_Sel = ((Number) AV99TFConBasePres_Sels.elementAt(-1+AV159GXV13)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV100TFConBasePres_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV159GXV13 = (int)(AV159GXV13+1) ;
         }
      }
      if ( ! ( ( AV102TFConBaseAnt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para antiguedad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV160GXV14 = 1 ;
         while ( AV160GXV14 <= AV102TFConBaseAnt_Sels.size() )
         {
            AV103TFConBaseAnt_Sel = ((Number) AV102TFConBaseAnt_Sels.elementAt(-1+AV160GXV14)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV103TFConBaseAnt_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV160GXV14 = (int)(AV160GXV14+1) ;
         }
      }
      if ( ! ( ( AV105TFConBaseFer_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV161GXV15 = 1 ;
         while ( AV161GXV15 <= AV105TFConBaseFer_Sels.size() )
         {
            AV106TFConBaseFer_Sel = ((Number) AV105TFConBaseFer_Sels.elementAt(-1+AV161GXV15)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV106TFConBaseFer_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV161GXV15 = (int)(AV161GXV15+1) ;
         }
      }
      if ( ! ( ( AV108TFConBaseFerProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV162GXV16 = 1 ;
         while ( AV162GXV16 <= AV108TFConBaseFerProm_Sels.size() )
         {
            AV109TFConBaseFerProm_Sel = ((Number) AV108TFConBaseFerProm_Sels.elementAt(-1+AV162GXV16)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV109TFConBaseFerProm_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV162GXV16 = (int)(AV162GXV16+1) ;
         }
      }
      if ( ! ( ( AV111TFConBaseHorExt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV163GXV17 = 1 ;
         while ( AV163GXV17 <= AV111TFConBaseHorExt_Sels.size() )
         {
            AV112TFConBaseHorExt_Sel = ((Number) AV111TFConBaseHorExt_Sels.elementAt(-1+AV163GXV17)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV112TFConBaseHorExt_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV163GXV17 = (int)(AV163GXV17+1) ;
         }
      }
      if ( ! ( ( AV114TFConBaseHorExtProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV164GXV18 = 1 ;
         while ( AV164GXV18 <= AV114TFConBaseHorExtProm_Sels.size() )
         {
            AV115TFConBaseHorExtProm_Sel = ((Number) AV114TFConBaseHorExtProm_Sels.elementAt(-1+AV164GXV18)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV115TFConBaseHorExtProm_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV164GXV18 = (int)(AV164GXV18+1) ;
         }
      }
      if ( ! ( ( AV117TFConBaseLic_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV165GXV19 = 1 ;
         while ( AV165GXV19 <= AV117TFConBaseLic_Sels.size() )
         {
            AV118TFConBaseLic_Sel = ((Number) AV117TFConBaseLic_Sels.elementAt(-1+AV165GXV19)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV118TFConBaseLic_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV165GXV19 = (int)(AV165GXV19+1) ;
         }
      }
      if ( ! ( ( AV120TFConBaseLicProm_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV166GXV20 = 1 ;
         while ( AV166GXV20 <= AV120TFConBaseLicProm_Sels.size() )
         {
            AV121TFConBaseLicProm_Sel = ((Number) AV120TFConBaseLicProm_Sels.elementAt(-1+AV166GXV20)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)AV121TFConBaseLicProm_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV166GXV20 = (int)(AV166GXV20+1) ;
         }
      }
      if ( ! ( ( AV123TFConBaseOSDif_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Base de cálculo para obra social diferencial", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV167GXV21 = 1 ;
         while ( AV167GXV21 <= AV123TFConBaseOSDif_Sels.size() )
         {
            AV124TFConBaseOSDif_Sel = ((Number) AV123TFConBaseOSDif_Sels.elementAt(-1+AV167GXV21)).byteValue() ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaines_base_osdif.getDescription(httpContext,(byte)AV124TFConBaseOSDif_Sel), "") );
            AV82i = (long)(AV82i+1) ;
            AV167GXV21 = (int)(AV167GXV21+1) ;
         }
      }
      if ( ! ( ( AV141TFConRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Release", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV82i = 1 ;
         AV168GXV22 = 1 ;
         while ( AV168GXV22 <= AV141TFConRelRef_Sels.size() )
         {
            AV142TFConRelRef_Sel = (String)AV141TFConRelRef_Sels.elementAt(-1+AV168GXV22) ;
            if ( AV82i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV142TFConRelRef_Sel, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV82i = (long)(AV82i+1) ;
            AV168GXV22 = (int)(AV168GXV22+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV140TFConRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Release", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV140TFConRelRef, GXv_char9) ;
            conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV20Session.getValue("ConceptoWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV143IsAuthorizedConRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV169GXV23 = 1 ;
      while ( AV169GXV23 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV169GXV23));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV169GXV23 = (int)(AV169GXV23+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV171Conceptowwds_1_tfconcodigo = AV37TFConCodigo ;
      AV172Conceptowwds_2_tfconcodigo_sels = AV38TFConCodigo_Sels ;
      AV173Conceptowwds_3_tfcondescrip = AV41TFConDescrip ;
      AV174Conceptowwds_4_tfcondescrip_sels = AV42TFConDescrip_Sels ;
      AV175Conceptowwds_5_tftipoconcod_sels = AV45TFTipoConCod_Sels ;
      AV176Conceptowwds_6_tfconclasifaux = AV48TFConClasifAux ;
      AV177Conceptowwds_7_tfconclasifaux_sels = AV49TFConClasifAux_Sels ;
      AV178Conceptowwds_8_tfcontipoliqaux = AV52TFConTipoLiqAux ;
      AV179Conceptowwds_9_tfcontipoliqaux_sels = AV53TFConTipoLiqAux_Sels ;
      AV180Conceptowwds_10_tfconceptoconvecodigo = AV89TFConceptoConveCodigo ;
      AV181Conceptowwds_11_tfconceptoconvecodigo_sels = AV90TFConceptoConveCodigo_Sels ;
      AV182Conceptowwds_12_tfconvigencia_sels = AV60TFConVigencia_Sels ;
      AV183Conceptowwds_13_tfconvariable_sel = AV65TFConVariable_Sel ;
      AV184Conceptowwds_14_tfconformula = AV66TFConFormula ;
      AV185Conceptowwds_15_tfconhabilitado_sel = AV67TFConHabilitado_Sel ;
      AV186Conceptowwds_16_tfconobservacion = AV69TFConObservacion ;
      AV187Conceptowwds_17_tfconobservacion_sels = AV70TFConObservacion_Sels ;
      AV188Conceptowwds_18_tfapliigg_sels = AV73TFAplIIGG_Sels ;
      AV189Conceptowwds_19_tfconfchmodfor = AV75TFConFchModFor ;
      AV190Conceptowwds_20_tfconfchmodfor_to = AV76TFConFchModFor_To ;
      AV191Conceptowwds_21_tfconrecalcular_sel = AV78TFConRecalcular_Sel ;
      AV192Conceptowwds_22_tfconcondicion_sels = AV63TFConCondicion_Sels ;
      AV193Conceptowwds_23_tfconsacdeven_sels = AV86TFConSacDeven_Sels ;
      AV194Conceptowwds_24_tfconcodafip = AV93TFConCodAfip ;
      AV195Conceptowwds_25_tfconcodafip_sels = AV94TFConCodAfip_Sels ;
      AV196Conceptowwds_26_tfconbasepres_sels = AV99TFConBasePres_Sels ;
      AV197Conceptowwds_27_tfconbaseant_sels = AV102TFConBaseAnt_Sels ;
      AV198Conceptowwds_28_tfconbasefer_sels = AV105TFConBaseFer_Sels ;
      AV199Conceptowwds_29_tfconbaseferprom_sels = AV108TFConBaseFerProm_Sels ;
      AV200Conceptowwds_30_tfconbasehorext_sels = AV111TFConBaseHorExt_Sels ;
      AV201Conceptowwds_31_tfconbasehorextprom_sels = AV114TFConBaseHorExtProm_Sels ;
      AV202Conceptowwds_32_tfconbaselic_sels = AV117TFConBaseLic_Sels ;
      AV203Conceptowwds_33_tfconbaselicprom_sels = AV120TFConBaseLicProm_Sels ;
      AV204Conceptowwds_34_tfconbaseosdif_sels = AV123TFConBaseOSDif_Sels ;
      AV205Conceptowwds_35_tfconrelref = AV140TFConRelRef ;
      AV206Conceptowwds_36_tfconrelref_sels = AV141TFConRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV172Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV174Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV175Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV177Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV179Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV181Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV182Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV187Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV188Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV192Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV193Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV195Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV196Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV197Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV198Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV199Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV200Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV201Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV202Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV203Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV204Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV206Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV172Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV171Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV174Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV173Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV175Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV176Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV179Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV178Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV181Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV180Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV182Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV183Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV185Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV187Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV186Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV188Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV189Conceptowwds_19_tfconfchmodfor ,
                                           AV190Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV191Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV192Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV193Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV195Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV194Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV196Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV197Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV198Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV199Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV200Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV201Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV202Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV203Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV204Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV206Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV205Conceptowwds_35_tfconrelref ,
                                           AV66TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV83CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV171Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV171Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV173Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV173Conceptowwds_3_tfcondescrip), "%", "") ;
      lV176Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV176Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV178Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV178Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV180Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV180Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV186Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV186Conceptowwds_16_tfconobservacion), "%", "") ;
      lV194Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV194Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV205Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV205Conceptowwds_35_tfconrelref), "%", "") ;
      lV66TFConFormula = GXutil.concat( GXutil.rtrim( AV66TFConFormula), "%", "") ;
      /* Using cursor P01802 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV83CliCod), lV171Conceptowwds_1_tfconcodigo, lV173Conceptowwds_3_tfcondescrip, lV176Conceptowwds_6_tfconclasifaux, lV178Conceptowwds_8_tfcontipoliqaux, lV180Conceptowwds_10_tfconceptoconvecodigo, lV186Conceptowwds_16_tfconobservacion, AV189Conceptowwds_19_tfconfchmodfor, AV190Conceptowwds_20_tfconfchmodfor_to, lV194Conceptowwds_24_tfconcodafip, lV205Conceptowwds_35_tfconrelref, lV66TFConFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1644ConceptoPais = P01802_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P01802_n1644ConceptoPais[0] ;
         A148ConFormula = P01802_A148ConFormula[0] ;
         n148ConFormula = P01802_n148ConFormula[0] ;
         A3CliCod = P01802_A3CliCod[0] ;
         A160ConveDescri = P01802_A160ConveDescri[0] ;
         n160ConveDescri = P01802_n160ConveDescri[0] ;
         A2013ConRelRef = P01802_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P01802_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P01802_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P01802_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P01802_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P01802_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P01802_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P01802_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P01802_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P01802_A1800ConBasePres[0] ;
         A1648ConCodAfip = P01802_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P01802_A1539ConSacDeven[0] ;
         A953ConCondicion = P01802_A953ConCondicion[0] ;
         n953ConCondicion = P01802_n953ConCondicion[0] ;
         A762ConRecalcular = P01802_A762ConRecalcular[0] ;
         A145ConFchModFor = P01802_A145ConFchModFor[0] ;
         n145ConFchModFor = P01802_n145ConFchModFor[0] ;
         A1112AplIIGG = P01802_A1112AplIIGG[0] ;
         n1112AplIIGG = P01802_n1112AplIIGG[0] ;
         A153ConObservacion = P01802_A153ConObservacion[0] ;
         A150ConHabilitado = P01802_A150ConHabilitado[0] ;
         A159ConVariable = P01802_A159ConVariable[0] ;
         A162ConVigencia = P01802_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P01802_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01802_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P01802_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P01802_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P01802_A970ConClasifAux[0] ;
         n970ConClasifAux = P01802_n970ConClasifAux[0] ;
         A37TipoConCod = P01802_A37TipoConCod[0] ;
         A41ConDescrip = P01802_A41ConDescrip[0] ;
         A26ConCodigo = P01802_A26ConCodigo[0] ;
         A156ConUsuModFor = P01802_A156ConUsuModFor[0] ;
         n156ConUsuModFor = P01802_n156ConUsuModFor[0] ;
         A895ConTipoOrden = P01802_A895ConTipoOrden[0] ;
         A160ConveDescri = P01802_A160ConveDescri[0] ;
         n160ConveDescri = P01802_n160ConveDescri[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV207GXV24 = 1 ;
         while ( AV207GXV24 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV207GXV24));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A26ConCodigo, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A41ConDescrip, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)A37TipoConCod), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConClasifAux") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A970ConClasifAux, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTipoLiqAux") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A503ConTipoLiqAux, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConceptoConveCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A160ConveDescri, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConVigencia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainvigenciaconcepto.getDescription(httpContext,(byte)A162ConVigencia), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConVariable") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A159ConVariable) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&ConFormula") == 0 )
               {
                  GXv_char9[0] = AV24ConFormula ;
                  new web.getformulaabr(remoteHandle, context).execute( A3CliCod, A26ConCodigo, GXv_char9) ;
                  conceptowwexport.this.AV24ConFormula = GXv_char9[0] ;
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV24ConFormula, 1, 1000), GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConHabilitado") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A150ConHabilitado) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConObservacion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A153ConObservacion, 1, 1000), GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGG") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1112AplIIGG );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConUsuModFor") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A156ConUsuModFor, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConFchModFor") == 0 )
               {
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( A145ConFchModFor );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRecalcular") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A762ConRecalcular) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCondicion") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)A953ConCondicion), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConSacDeven") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainsac_devengamiento.getDescription(httpContext,(byte)A1539ConSacDeven), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodAfip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1648ConCodAfip, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBasePres") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1800ConBasePres), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1801ConBaseAnt), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseFer") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1621ConBaseFer), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseFerProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1798ConBaseFerProm), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseHorExt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1622ConBaseHorExt), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseHorExtProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1799ConBaseHorExtProm), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseLic") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1620ConBaseLic), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseLicProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base.getDescription(httpContext,(byte)A1797ConBaseLicProm), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConBaseOSDif") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaines_base_osdif.getDescription(httpContext,(byte)A1827ConBaseOSDif), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2013ConRelRef, GXv_char9) ;
                  conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV207GXV24 = (int)(AV207GXV24+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV143IsAuthorizedConRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV83CliCod, GXv_boolean4) ;
      conceptowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV143IsAuthorizedConRelRef = (boolean)((!GXt_boolean3)) ;
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodigo", "", "Código", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConDescrip", "", "Descripción", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TipoConCod", "", "Tipo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConClasifAux", "", "Clasificación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTipoLiqAux", "", "Tipo de Liquidación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConceptoConveCodigo", "", "Convenio", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConVigencia", "", "Aplicación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConVariable", "", "Rem. Var.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ConFormula", "", "Fórmula", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConHabilitado", "", "Habilitado", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConObservacion", "", "Observación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGG", "", "Tratamiento IIGG", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConUsuModFor", "", "Usuario de Modificación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConFchModFor", "", "Fecha de Modificación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRecalcular", "", "Recalcula Retroactivo en ganancias", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCondicion", "", "Condición para liquidación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConSacDeven", "", "Tipo devengamiento", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodAfip", "", "Concepto AFIP", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBasePres", "", "Base de cálculo para presentismo", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseAnt", "", "Base de cálculo para antiguedad", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseFer", "", "Base de cálculo para feriados de remuneración actual", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseFerProm", "", "Base de cálculo para feriados de remuneración promedio variable", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseHorExt", "", "Base de cálculo para horas extras de remuneración actual", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseHorExtProm", "", "Base de cálculo para horas extras de remuneración promedio variable", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseLic", "", "Base de cálculo para licencias de remuneraciòn actual", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseLicProm", "", "Base de cálculo para licencias de remuneración promedio variable", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConBaseOSDif", "", "Base de cálculo para obra social diferencial", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV83CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConRelRef", "", "Release", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV29UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConceptoWWColumnsSelector", GXv_char9) ;
      conceptowwexport.this.GXt_char8 = GXv_char9[0] ;
      AV29UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ConceptoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV208GXV25 = 1 ;
      while ( AV208GXV25 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV208GXV25));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV37TFConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV36TFConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFConCodigo_Sels.fromJSonString(AV36TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV41TFConDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV40TFConDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFConDescrip_Sels.fromJSonString(AV40TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV44TFTipoConCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFTipoConCod_Sels.fromJSonString(AV44TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV48TFConClasifAux = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV47TFConClasifAux_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFConClasifAux_Sels.fromJSonString(AV47TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX") == 0 )
         {
            AV52TFConTipoLiqAux = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX_SEL") == 0 )
         {
            AV51TFConTipoLiqAux_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFConTipoLiqAux_Sels.fromJSonString(AV51TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO") == 0 )
         {
            AV89TFConceptoConveCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO_SEL") == 0 )
         {
            AV88TFConceptoConveCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV90TFConceptoConveCodigo_Sels.fromJSonString(AV88TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVIGENCIA_SEL") == 0 )
         {
            AV59TFConVigencia_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFConVigencia_Sels.fromJSonString(AV59TFConVigencia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVARIABLE_SEL") == 0 )
         {
            AV65TFConVariable_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA") == 0 )
         {
            AV66TFConFormula = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONHABILITADO_SEL") == 0 )
         {
            AV67TFConHabilitado_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION") == 0 )
         {
            AV69TFConObservacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION_SEL") == 0 )
         {
            AV68TFConObservacion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV70TFConObservacion_Sels.fromJSonString(AV68TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG_SEL") == 0 )
         {
            AV72TFAplIIGG_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV73TFAplIIGG_Sels.fromJSonString(AV72TFAplIIGG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFCHMODFOR") == 0 )
         {
            AV75TFConFchModFor = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV76TFConFchModFor_To = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRECALCULAR_SEL") == 0 )
         {
            AV78TFConRecalcular_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV62TFConCondicion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFConCondicion_Sels.fromJSonString(AV62TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSACDEVEN_SEL") == 0 )
         {
            AV85TFConSacDeven_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV86TFConSacDeven_Sels.fromJSonString(AV85TFConSacDeven_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP") == 0 )
         {
            AV93TFConCodAfip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP_SEL") == 0 )
         {
            AV92TFConCodAfip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV94TFConCodAfip_Sels.fromJSonString(AV92TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEPRES_SEL") == 0 )
         {
            AV98TFConBasePres_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV99TFConBasePres_Sels.fromJSonString(AV98TFConBasePres_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEANT_SEL") == 0 )
         {
            AV101TFConBaseAnt_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV102TFConBaseAnt_Sels.fromJSonString(AV101TFConBaseAnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFER_SEL") == 0 )
         {
            AV104TFConBaseFer_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV105TFConBaseFer_Sels.fromJSonString(AV104TFConBaseFer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFERPROM_SEL") == 0 )
         {
            AV107TFConBaseFerProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV108TFConBaseFerProm_Sels.fromJSonString(AV107TFConBaseFerProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXT_SEL") == 0 )
         {
            AV110TFConBaseHorExt_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV111TFConBaseHorExt_Sels.fromJSonString(AV110TFConBaseHorExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXTPROM_SEL") == 0 )
         {
            AV113TFConBaseHorExtProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV114TFConBaseHorExtProm_Sels.fromJSonString(AV113TFConBaseHorExtProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELIC_SEL") == 0 )
         {
            AV116TFConBaseLic_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV117TFConBaseLic_Sels.fromJSonString(AV116TFConBaseLic_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELICPROM_SEL") == 0 )
         {
            AV119TFConBaseLicProm_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV120TFConBaseLicProm_Sels.fromJSonString(AV119TFConBaseLicProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEOSDIF_SEL") == 0 )
         {
            AV122TFConBaseOSDif_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV123TFConBaseOSDif_Sels.fromJSonString(AV122TFConBaseOSDif_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF") == 0 )
         {
            AV140TFConRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF_SEL") == 0 )
         {
            AV139TFConRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV141TFConRelRef_Sels.fromJSonString(AV139TFConRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV137MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV208GXV25 = (int)(AV208GXV25+1) ;
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
      this.aP0[0] = conceptowwexport.this.AV12Filename;
      this.aP1[0] = conceptowwexport.this.AV13ErrorMessage;
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
      AV146Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFConCodigo_Sel = "" ;
      AV37TFConCodigo = "" ;
      AV42TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFConDescrip_Sel = "" ;
      AV41TFConDescrip = "" ;
      AV45TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFTipoConCod_Sel = "" ;
      AV49TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFConClasifAux_Sel = "" ;
      AV48TFConClasifAux = "" ;
      AV53TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFConTipoLiqAux_Sel = "" ;
      AV52TFConTipoLiqAux = "" ;
      AV90TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91TFConceptoConveCodigo_Sel = "" ;
      AV138TFConceptoConveCodigo_SelDsc = "" ;
      AV89TFConceptoConveCodigo = "" ;
      AV60TFConVigencia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV66TFConFormula = "" ;
      AV70TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71TFConObservacion_Sel = "" ;
      AV69TFConObservacion = "" ;
      AV73TFAplIIGG_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV75TFConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      AV76TFConFchModFor_To = GXutil.resetTime( GXutil.nullDate() );
      AV63TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFConCondicion_Sel = "" ;
      AV86TFConSacDeven_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV94TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV95TFConCodAfip_Sel = "" ;
      AV93TFConCodAfip = "" ;
      AV99TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV102TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV105TFConBaseFer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV108TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV111TFConBaseHorExt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV114TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV117TFConBaseLic_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV120TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV123TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV141TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV142TFConRelRef_Sel = "" ;
      AV140TFConRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A970ConClasifAux = "" ;
      A503ConTipoLiqAux = "" ;
      A160ConveDescri = "" ;
      A153ConObservacion = "" ;
      A156ConUsuModFor = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A953ConCondicion = "" ;
      A1648ConCodAfip = "" ;
      A2013ConRelRef = "" ;
      AV171Conceptowwds_1_tfconcodigo = "" ;
      AV172Conceptowwds_2_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV173Conceptowwds_3_tfcondescrip = "" ;
      AV174Conceptowwds_4_tfcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV175Conceptowwds_5_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV176Conceptowwds_6_tfconclasifaux = "" ;
      AV177Conceptowwds_7_tfconclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV178Conceptowwds_8_tfcontipoliqaux = "" ;
      AV179Conceptowwds_9_tfcontipoliqaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV180Conceptowwds_10_tfconceptoconvecodigo = "" ;
      AV181Conceptowwds_11_tfconceptoconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV182Conceptowwds_12_tfconvigencia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV184Conceptowwds_14_tfconformula = "" ;
      AV186Conceptowwds_16_tfconobservacion = "" ;
      AV187Conceptowwds_17_tfconobservacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV188Conceptowwds_18_tfapliigg_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV189Conceptowwds_19_tfconfchmodfor = GXutil.resetTime( GXutil.nullDate() );
      AV190Conceptowwds_20_tfconfchmodfor_to = GXutil.resetTime( GXutil.nullDate() );
      AV192Conceptowwds_22_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV193Conceptowwds_23_tfconsacdeven_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV194Conceptowwds_24_tfconcodafip = "" ;
      AV195Conceptowwds_25_tfconcodafip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV196Conceptowwds_26_tfconbasepres_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV197Conceptowwds_27_tfconbaseant_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV198Conceptowwds_28_tfconbasefer_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV199Conceptowwds_29_tfconbaseferprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV200Conceptowwds_30_tfconbasehorext_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV201Conceptowwds_31_tfconbasehorextprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV202Conceptowwds_32_tfconbaselic_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV203Conceptowwds_33_tfconbaselicprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV204Conceptowwds_34_tfconbaseosdif_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV205Conceptowwds_35_tfconrelref = "" ;
      AV206Conceptowwds_36_tfconrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV171Conceptowwds_1_tfconcodigo = "" ;
      lV173Conceptowwds_3_tfcondescrip = "" ;
      lV176Conceptowwds_6_tfconclasifaux = "" ;
      lV178Conceptowwds_8_tfcontipoliqaux = "" ;
      lV180Conceptowwds_10_tfconceptoconvecodigo = "" ;
      lV186Conceptowwds_16_tfconobservacion = "" ;
      lV194Conceptowwds_24_tfconcodafip = "" ;
      lV205Conceptowwds_35_tfconrelref = "" ;
      lV66TFConFormula = "" ;
      A1645ConceptoConveCodigo = "" ;
      A148ConFormula = "" ;
      P01802_A1644ConceptoPais = new short[1] ;
      P01802_n1644ConceptoPais = new boolean[] {false} ;
      P01802_A148ConFormula = new String[] {""} ;
      P01802_n148ConFormula = new boolean[] {false} ;
      P01802_A3CliCod = new int[1] ;
      P01802_A160ConveDescri = new String[] {""} ;
      P01802_n160ConveDescri = new boolean[] {false} ;
      P01802_A2013ConRelRef = new String[] {""} ;
      P01802_A1827ConBaseOSDif = new byte[1] ;
      P01802_A1797ConBaseLicProm = new byte[1] ;
      P01802_A1620ConBaseLic = new byte[1] ;
      P01802_A1799ConBaseHorExtProm = new byte[1] ;
      P01802_A1622ConBaseHorExt = new byte[1] ;
      P01802_A1798ConBaseFerProm = new byte[1] ;
      P01802_A1621ConBaseFer = new byte[1] ;
      P01802_A1801ConBaseAnt = new byte[1] ;
      P01802_A1800ConBasePres = new byte[1] ;
      P01802_A1648ConCodAfip = new String[] {""} ;
      P01802_A1539ConSacDeven = new byte[1] ;
      P01802_A953ConCondicion = new String[] {""} ;
      P01802_n953ConCondicion = new boolean[] {false} ;
      P01802_A762ConRecalcular = new boolean[] {false} ;
      P01802_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P01802_n145ConFchModFor = new boolean[] {false} ;
      P01802_A1112AplIIGG = new short[1] ;
      P01802_n1112AplIIGG = new boolean[] {false} ;
      P01802_A153ConObservacion = new String[] {""} ;
      P01802_A150ConHabilitado = new boolean[] {false} ;
      P01802_A159ConVariable = new boolean[] {false} ;
      P01802_A162ConVigencia = new byte[1] ;
      P01802_A1645ConceptoConveCodigo = new String[] {""} ;
      P01802_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01802_A503ConTipoLiqAux = new String[] {""} ;
      P01802_n503ConTipoLiqAux = new boolean[] {false} ;
      P01802_A970ConClasifAux = new String[] {""} ;
      P01802_n970ConClasifAux = new boolean[] {false} ;
      P01802_A37TipoConCod = new String[] {""} ;
      P01802_A41ConDescrip = new String[] {""} ;
      P01802_A26ConCodigo = new String[] {""} ;
      P01802_A156ConUsuModFor = new String[] {""} ;
      P01802_n156ConUsuModFor = new boolean[] {false} ;
      P01802_A895ConTipoOrden = new short[1] ;
      AV24ConFormula = "" ;
      GXv_boolean4 = new boolean[1] ;
      AV29UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFConCodigo_SelsJson = "" ;
      AV40TFConDescrip_SelsJson = "" ;
      AV44TFTipoConCod_SelsJson = "" ;
      AV47TFConClasifAux_SelsJson = "" ;
      AV51TFConTipoLiqAux_SelsJson = "" ;
      AV88TFConceptoConveCodigo_SelsJson = "" ;
      AV59TFConVigencia_SelsJson = "" ;
      AV68TFConObservacion_SelsJson = "" ;
      AV72TFAplIIGG_SelsJson = "" ;
      AV62TFConCondicion_SelsJson = "" ;
      AV85TFConSacDeven_SelsJson = "" ;
      AV92TFConCodAfip_SelsJson = "" ;
      AV98TFConBasePres_SelsJson = "" ;
      AV101TFConBaseAnt_SelsJson = "" ;
      AV104TFConBaseFer_SelsJson = "" ;
      AV107TFConBaseFerProm_SelsJson = "" ;
      AV110TFConBaseHorExt_SelsJson = "" ;
      AV113TFConBaseHorExtProm_SelsJson = "" ;
      AV116TFConBaseLic_SelsJson = "" ;
      AV119TFConBaseLicProm_SelsJson = "" ;
      AV122TFConBaseOSDif_SelsJson = "" ;
      AV139TFConRelRef_SelsJson = "" ;
      AV137MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptowwexport__default(),
         new Object[] {
             new Object[] {
            P01802_A1644ConceptoPais, P01802_n1644ConceptoPais, P01802_A148ConFormula, P01802_n148ConFormula, P01802_A3CliCod, P01802_A160ConveDescri, P01802_n160ConveDescri, P01802_A2013ConRelRef, P01802_A1827ConBaseOSDif, P01802_A1797ConBaseLicProm,
            P01802_A1620ConBaseLic, P01802_A1799ConBaseHorExtProm, P01802_A1622ConBaseHorExt, P01802_A1798ConBaseFerProm, P01802_A1621ConBaseFer, P01802_A1801ConBaseAnt, P01802_A1800ConBasePres, P01802_A1648ConCodAfip, P01802_A1539ConSacDeven, P01802_A953ConCondicion,
            P01802_n953ConCondicion, P01802_A762ConRecalcular, P01802_A145ConFchModFor, P01802_n145ConFchModFor, P01802_A1112AplIIGG, P01802_n1112AplIIGG, P01802_A153ConObservacion, P01802_A150ConHabilitado, P01802_A159ConVariable, P01802_A162ConVigencia,
            P01802_A1645ConceptoConveCodigo, P01802_n1645ConceptoConveCodigo, P01802_A503ConTipoLiqAux, P01802_n503ConTipoLiqAux, P01802_A970ConClasifAux, P01802_n970ConClasifAux, P01802_A37TipoConCod, P01802_A41ConDescrip, P01802_A26ConCodigo, P01802_A156ConUsuModFor,
            P01802_n156ConUsuModFor, P01802_A895ConTipoOrden
            }
         }
      );
      AV146Pgmname = "ConceptoWWExport" ;
      /* GeneXus formulas. */
      AV146Pgmname = "ConceptoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV61TFConVigencia_Sel ;
   private byte AV65TFConVariable_Sel ;
   private byte AV67TFConHabilitado_Sel ;
   private byte AV78TFConRecalcular_Sel ;
   private byte AV87TFConSacDeven_Sel ;
   private byte AV100TFConBasePres_Sel ;
   private byte AV103TFConBaseAnt_Sel ;
   private byte AV106TFConBaseFer_Sel ;
   private byte AV109TFConBaseFerProm_Sel ;
   private byte AV112TFConBaseHorExt_Sel ;
   private byte AV115TFConBaseHorExtProm_Sel ;
   private byte AV118TFConBaseLic_Sel ;
   private byte AV121TFConBaseLicProm_Sel ;
   private byte AV124TFConBaseOSDif_Sel ;
   private byte A162ConVigencia ;
   private byte A1539ConSacDeven ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A1827ConBaseOSDif ;
   private byte AV183Conceptowwds_13_tfconvariable_sel ;
   private byte AV185Conceptowwds_15_tfconhabilitado_sel ;
   private byte AV191Conceptowwds_21_tfconrecalcular_sel ;
   private short AV74TFAplIIGG_Sel ;
   private short GXv_int7[] ;
   private short A1112AplIIGG ;
   private short AV18OrderedBy ;
   private short A1644ConceptoPais ;
   private short A895ConTipoOrden ;
   private short Gx_err ;
   private int AV83CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV147GXV1 ;
   private int AV148GXV2 ;
   private int AV149GXV3 ;
   private int AV150GXV4 ;
   private int AV151GXV5 ;
   private int AV152GXV6 ;
   private int AV153GXV7 ;
   private int AV154GXV8 ;
   private int AV155GXV9 ;
   private int AV156GXV10 ;
   private int AV157GXV11 ;
   private int AV158GXV12 ;
   private int AV159GXV13 ;
   private int AV160GXV14 ;
   private int AV161GXV15 ;
   private int AV162GXV16 ;
   private int AV163GXV17 ;
   private int AV164GXV18 ;
   private int AV165GXV19 ;
   private int AV166GXV20 ;
   private int AV167GXV21 ;
   private int AV168GXV22 ;
   private int AV169GXV23 ;
   private int A3CliCod ;
   private int AV172Conceptowwds_2_tfconcodigo_sels_size ;
   private int AV174Conceptowwds_4_tfcondescrip_sels_size ;
   private int AV175Conceptowwds_5_tftipoconcod_sels_size ;
   private int AV177Conceptowwds_7_tfconclasifaux_sels_size ;
   private int AV179Conceptowwds_9_tfcontipoliqaux_sels_size ;
   private int AV181Conceptowwds_11_tfconceptoconvecodigo_sels_size ;
   private int AV182Conceptowwds_12_tfconvigencia_sels_size ;
   private int AV187Conceptowwds_17_tfconobservacion_sels_size ;
   private int AV188Conceptowwds_18_tfapliigg_sels_size ;
   private int AV192Conceptowwds_22_tfconcondicion_sels_size ;
   private int AV193Conceptowwds_23_tfconsacdeven_sels_size ;
   private int AV195Conceptowwds_25_tfconcodafip_sels_size ;
   private int AV196Conceptowwds_26_tfconbasepres_sels_size ;
   private int AV197Conceptowwds_27_tfconbaseant_sels_size ;
   private int AV198Conceptowwds_28_tfconbasefer_sels_size ;
   private int AV199Conceptowwds_29_tfconbaseferprom_sels_size ;
   private int AV200Conceptowwds_30_tfconbasehorext_sels_size ;
   private int AV201Conceptowwds_31_tfconbasehorextprom_sels_size ;
   private int AV202Conceptowwds_32_tfconbaselic_sels_size ;
   private int AV203Conceptowwds_33_tfconbaselicprom_sels_size ;
   private int AV204Conceptowwds_34_tfconbaseosdif_sels_size ;
   private int AV206Conceptowwds_36_tfconrelref_sels_size ;
   private int AV207GXV24 ;
   private int AV208GXV25 ;
   private long AV82i ;
   private long AV33VisibleColumnCount ;
   private String AV146Pgmname ;
   private String AV39TFConCodigo_Sel ;
   private String AV37TFConCodigo ;
   private String AV46TFTipoConCod_Sel ;
   private String AV91TFConceptoConveCodigo_Sel ;
   private String AV64TFConCondicion_Sel ;
   private String AV95TFConCodAfip_Sel ;
   private String AV93TFConCodAfip ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A156ConUsuModFor ;
   private String A953ConCondicion ;
   private String A1648ConCodAfip ;
   private String AV171Conceptowwds_1_tfconcodigo ;
   private String AV194Conceptowwds_24_tfconcodafip ;
   private String scmdbuf ;
   private String lV171Conceptowwds_1_tfconcodigo ;
   private String lV194Conceptowwds_24_tfconcodafip ;
   private String A1645ConceptoConveCodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private java.util.Date AV75TFConFchModFor ;
   private java.util.Date AV76TFConFchModFor_To ;
   private java.util.Date A145ConFchModFor ;
   private java.util.Date AV189Conceptowwds_19_tfconfchmodfor ;
   private java.util.Date AV190Conceptowwds_20_tfconfchmodfor_to ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV143IsAuthorizedConRelRef ;
   private boolean A159ConVariable ;
   private boolean A150ConHabilitado ;
   private boolean A762ConRecalcular ;
   private boolean AV19OrderedDsc ;
   private boolean n1644ConceptoPais ;
   private boolean n148ConFormula ;
   private boolean n160ConveDescri ;
   private boolean n953ConCondicion ;
   private boolean n145ConFchModFor ;
   private boolean n1112AplIIGG ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n503ConTipoLiqAux ;
   private boolean n970ConClasifAux ;
   private boolean n156ConUsuModFor ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV28ColumnsSelectorXML ;
   private String A153ConObservacion ;
   private String A148ConFormula ;
   private String AV24ConFormula ;
   private String AV29UserCustomValue ;
   private String AV36TFConCodigo_SelsJson ;
   private String AV40TFConDescrip_SelsJson ;
   private String AV44TFTipoConCod_SelsJson ;
   private String AV47TFConClasifAux_SelsJson ;
   private String AV51TFConTipoLiqAux_SelsJson ;
   private String AV88TFConceptoConveCodigo_SelsJson ;
   private String AV59TFConVigencia_SelsJson ;
   private String AV68TFConObservacion_SelsJson ;
   private String AV72TFAplIIGG_SelsJson ;
   private String AV62TFConCondicion_SelsJson ;
   private String AV85TFConSacDeven_SelsJson ;
   private String AV92TFConCodAfip_SelsJson ;
   private String AV98TFConBasePres_SelsJson ;
   private String AV101TFConBaseAnt_SelsJson ;
   private String AV104TFConBaseFer_SelsJson ;
   private String AV107TFConBaseFerProm_SelsJson ;
   private String AV110TFConBaseHorExt_SelsJson ;
   private String AV113TFConBaseHorExtProm_SelsJson ;
   private String AV116TFConBaseLic_SelsJson ;
   private String AV119TFConBaseLicProm_SelsJson ;
   private String AV122TFConBaseOSDif_SelsJson ;
   private String AV139TFConRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV43TFConDescrip_Sel ;
   private String AV41TFConDescrip ;
   private String AV50TFConClasifAux_Sel ;
   private String AV48TFConClasifAux ;
   private String AV54TFConTipoLiqAux_Sel ;
   private String AV52TFConTipoLiqAux ;
   private String AV138TFConceptoConveCodigo_SelDsc ;
   private String AV89TFConceptoConveCodigo ;
   private String AV66TFConFormula ;
   private String AV71TFConObservacion_Sel ;
   private String AV69TFConObservacion ;
   private String AV142TFConRelRef_Sel ;
   private String AV140TFConRelRef ;
   private String A41ConDescrip ;
   private String A970ConClasifAux ;
   private String A503ConTipoLiqAux ;
   private String A160ConveDescri ;
   private String A2013ConRelRef ;
   private String AV173Conceptowwds_3_tfcondescrip ;
   private String AV176Conceptowwds_6_tfconclasifaux ;
   private String AV178Conceptowwds_8_tfcontipoliqaux ;
   private String AV180Conceptowwds_10_tfconceptoconvecodigo ;
   private String AV184Conceptowwds_14_tfconformula ;
   private String AV186Conceptowwds_16_tfconobservacion ;
   private String AV205Conceptowwds_35_tfconrelref ;
   private String lV173Conceptowwds_3_tfcondescrip ;
   private String lV176Conceptowwds_6_tfconclasifaux ;
   private String lV178Conceptowwds_8_tfcontipoliqaux ;
   private String lV180Conceptowwds_10_tfconceptoconvecodigo ;
   private String lV186Conceptowwds_16_tfconobservacion ;
   private String lV205Conceptowwds_35_tfconrelref ;
   private String lV66TFConFormula ;
   private String AV137MenuOpcCod ;
   private GXSimpleCollection<Byte> AV60TFConVigencia_Sels ;
   private GXSimpleCollection<Byte> AV86TFConSacDeven_Sels ;
   private GXSimpleCollection<Byte> AV99TFConBasePres_Sels ;
   private GXSimpleCollection<Byte> AV102TFConBaseAnt_Sels ;
   private GXSimpleCollection<Byte> AV105TFConBaseFer_Sels ;
   private GXSimpleCollection<Byte> AV108TFConBaseFerProm_Sels ;
   private GXSimpleCollection<Byte> AV111TFConBaseHorExt_Sels ;
   private GXSimpleCollection<Byte> AV114TFConBaseHorExtProm_Sels ;
   private GXSimpleCollection<Byte> AV117TFConBaseLic_Sels ;
   private GXSimpleCollection<Byte> AV120TFConBaseLicProm_Sels ;
   private GXSimpleCollection<Byte> AV123TFConBaseOSDif_Sels ;
   private GXSimpleCollection<Short> AV73TFAplIIGG_Sels ;
   private GXSimpleCollection<Byte> AV182Conceptowwds_12_tfconvigencia_sels ;
   private GXSimpleCollection<Byte> AV193Conceptowwds_23_tfconsacdeven_sels ;
   private GXSimpleCollection<Byte> AV196Conceptowwds_26_tfconbasepres_sels ;
   private GXSimpleCollection<Byte> AV197Conceptowwds_27_tfconbaseant_sels ;
   private GXSimpleCollection<Byte> AV198Conceptowwds_28_tfconbasefer_sels ;
   private GXSimpleCollection<Byte> AV199Conceptowwds_29_tfconbaseferprom_sels ;
   private GXSimpleCollection<Byte> AV200Conceptowwds_30_tfconbasehorext_sels ;
   private GXSimpleCollection<Byte> AV201Conceptowwds_31_tfconbasehorextprom_sels ;
   private GXSimpleCollection<Byte> AV202Conceptowwds_32_tfconbaselic_sels ;
   private GXSimpleCollection<Byte> AV203Conceptowwds_33_tfconbaselicprom_sels ;
   private GXSimpleCollection<Byte> AV204Conceptowwds_34_tfconbaseosdif_sels ;
   private GXSimpleCollection<Short> AV188Conceptowwds_18_tfapliigg_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV38TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV45TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV90TFConceptoConveCodigo_Sels ;
   private GXSimpleCollection<String> AV63TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV94TFConCodAfip_Sels ;
   private GXSimpleCollection<String> AV42TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV49TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV53TFConTipoLiqAux_Sels ;
   private GXSimpleCollection<String> AV70TFConObservacion_Sels ;
   private GXSimpleCollection<String> AV141TFConRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01802_A1644ConceptoPais ;
   private boolean[] P01802_n1644ConceptoPais ;
   private String[] P01802_A148ConFormula ;
   private boolean[] P01802_n148ConFormula ;
   private int[] P01802_A3CliCod ;
   private String[] P01802_A160ConveDescri ;
   private boolean[] P01802_n160ConveDescri ;
   private String[] P01802_A2013ConRelRef ;
   private byte[] P01802_A1827ConBaseOSDif ;
   private byte[] P01802_A1797ConBaseLicProm ;
   private byte[] P01802_A1620ConBaseLic ;
   private byte[] P01802_A1799ConBaseHorExtProm ;
   private byte[] P01802_A1622ConBaseHorExt ;
   private byte[] P01802_A1798ConBaseFerProm ;
   private byte[] P01802_A1621ConBaseFer ;
   private byte[] P01802_A1801ConBaseAnt ;
   private byte[] P01802_A1800ConBasePres ;
   private String[] P01802_A1648ConCodAfip ;
   private byte[] P01802_A1539ConSacDeven ;
   private String[] P01802_A953ConCondicion ;
   private boolean[] P01802_n953ConCondicion ;
   private boolean[] P01802_A762ConRecalcular ;
   private java.util.Date[] P01802_A145ConFchModFor ;
   private boolean[] P01802_n145ConFchModFor ;
   private short[] P01802_A1112AplIIGG ;
   private boolean[] P01802_n1112AplIIGG ;
   private String[] P01802_A153ConObservacion ;
   private boolean[] P01802_A150ConHabilitado ;
   private boolean[] P01802_A159ConVariable ;
   private byte[] P01802_A162ConVigencia ;
   private String[] P01802_A1645ConceptoConveCodigo ;
   private boolean[] P01802_n1645ConceptoConveCodigo ;
   private String[] P01802_A503ConTipoLiqAux ;
   private boolean[] P01802_n503ConTipoLiqAux ;
   private String[] P01802_A970ConClasifAux ;
   private boolean[] P01802_n970ConClasifAux ;
   private String[] P01802_A37TipoConCod ;
   private String[] P01802_A41ConDescrip ;
   private String[] P01802_A26ConCodigo ;
   private String[] P01802_A156ConUsuModFor ;
   private boolean[] P01802_n156ConUsuModFor ;
   private short[] P01802_A895ConTipoOrden ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV172Conceptowwds_2_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV175Conceptowwds_5_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV181Conceptowwds_11_tfconceptoconvecodigo_sels ;
   private GXSimpleCollection<String> AV192Conceptowwds_22_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV195Conceptowwds_25_tfconcodafip_sels ;
   private GXSimpleCollection<String> AV174Conceptowwds_4_tfcondescrip_sels ;
   private GXSimpleCollection<String> AV177Conceptowwds_7_tfconclasifaux_sels ;
   private GXSimpleCollection<String> AV179Conceptowwds_9_tfcontipoliqaux_sels ;
   private GXSimpleCollection<String> AV187Conceptowwds_17_tfconobservacion_sels ;
   private GXSimpleCollection<String> AV206Conceptowwds_36_tfconrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class conceptowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01802( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV172Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV174Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV175Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV177Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV179Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV181Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV187Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV188Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV192Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV193Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV195Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV196Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV197Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV198Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV199Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV200Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV201Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV202Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV203Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV204Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV206Conceptowwds_36_tfconrelref_sels ,
                                          int AV172Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV171Conceptowwds_1_tfconcodigo ,
                                          int AV174Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV173Conceptowwds_3_tfcondescrip ,
                                          int AV175Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV177Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV176Conceptowwds_6_tfconclasifaux ,
                                          int AV179Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV178Conceptowwds_8_tfcontipoliqaux ,
                                          int AV181Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV180Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV182Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV183Conceptowwds_13_tfconvariable_sel ,
                                          byte AV185Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV187Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV186Conceptowwds_16_tfconobservacion ,
                                          int AV188Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV189Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV190Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV191Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV192Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV193Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV195Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV194Conceptowwds_24_tfconcodafip ,
                                          int AV196Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV197Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV198Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV199Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV200Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV201Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV202Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV203Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV204Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV206Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV205Conceptowwds_35_tfconrelref ,
                                          String AV66TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV83CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[12];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.ConFormula, T1.CliCod, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic, T1.ConBaseHorExtProm," ;
      scmdbuf += " T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular, T1.ConFchModFor," ;
      scmdbuf += " T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux, T1.ConClasifAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo, T1.ConUsuModFor, T1.ConTipoOrden FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo" ;
      scmdbuf += " = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV172Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV171Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV172Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV172Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV174Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV173Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV174Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV175Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV177Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV176Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV177Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV179Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV178Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV179Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV181Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV180Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV181Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV182Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV183Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV183Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV185Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV185Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV187Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV186Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV187Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV187Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV188Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV188Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV189Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV190Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( AV191Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV191Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV192Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV192Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV193Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV193Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV195Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV194Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( AV195Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV195Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV196Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV196Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV197Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV197Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV198Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV198Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV199Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV199Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV200Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV200Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV201Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV201Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV202Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV202Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV203Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV203Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV204Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV204Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV206Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV205Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( AV206Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV206Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV66TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.ConTipoOrden, T1.ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoConCod" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoConCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConClasifAux" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConClasifAux DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConTipoLiqAux" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConTipoLiqAux DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConceptoConveCodigo" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConceptoConveCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConFchModFor" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConFchModFor DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConRecalcular" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConRecalcular DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConCondicion" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConCondicion DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConSacDeven" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConSacDeven DESC" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConCodAfip" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConCodAfip DESC" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBasePres" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBasePres DESC" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseAnt" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseAnt DESC" ;
      }
      else if ( ( AV18OrderedBy == 15 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseFer" ;
      }
      else if ( ( AV18OrderedBy == 15 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseFer DESC" ;
      }
      else if ( ( AV18OrderedBy == 16 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseFerProm" ;
      }
      else if ( ( AV18OrderedBy == 16 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseFerProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 17 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseHorExt" ;
      }
      else if ( ( AV18OrderedBy == 17 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseHorExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 18 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseHorExtProm" ;
      }
      else if ( ( AV18OrderedBy == 18 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseHorExtProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 19 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseLic" ;
      }
      else if ( ( AV18OrderedBy == 19 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseLic DESC" ;
      }
      else if ( ( AV18OrderedBy == 20 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseLicProm" ;
      }
      else if ( ( AV18OrderedBy == 20 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseLicProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 21 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConBaseOSDif" ;
      }
      else if ( ( AV18OrderedBy == 21 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConBaseOSDif DESC" ;
      }
      else if ( ( AV18OrderedBy == 22 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConRelRef" ;
      }
      else if ( ( AV18OrderedBy == 22 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConRelRef DESC" ;
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
                  return conditional_P01802(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).shortValue() , ((Boolean) dynConstraints[87]).booleanValue() , ((Number) dynConstraints[88]).intValue() , ((Number) dynConstraints[89]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01802", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((byte[]) buf[8])[0] = rslt.getByte(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((String[]) buf[17])[0] = rslt.getString(15, 6);
               ((byte[]) buf[18])[0] = rslt.getByte(16);
               ((String[]) buf[19])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(18);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((String[]) buf[30])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               ((String[]) buf[39])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((short[]) buf[41])[0] = rslt.getShort(32);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

