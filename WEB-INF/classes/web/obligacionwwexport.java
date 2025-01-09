package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obligacionwwexport extends GXProcedure
{
   public obligacionwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacionwwexport.class ), "" );
   }

   public obligacionwwexport( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      obligacionwwexport.this.aP1 = new String[] {""};
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
      obligacionwwexport.this.aP0 = aP0;
      obligacionwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion", GXv_boolean2) ;
      obligacionwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV80Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ObligacionWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFOblSecuencial) && (0==AV36TFOblSecuencial_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nro.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFOblSecuencial );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFOblSecuencial_To );
      }
      if ( ! ( ( AV39TFLegIdNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV81GXV1 = 1 ;
         while ( AV81GXV1 <= AV39TFLegIdNomApe_Sels.size() )
         {
            AV40TFLegIdNomApe_Sel = (String)AV39TFLegIdNomApe_Sels.elementAt(-1+AV81GXV1) ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFLegIdNomApe_Sel, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV75i = (long)(AV75i+1) ;
            AV81GXV1 = (int)(AV81GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFLegIdNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFLegIdNomApe, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV41TFTipoOblSec) && (0==AV42TFTipoOblSec_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obligación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFTipoOblSec );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFTipoOblSec_To );
      }
      if ( ! ( ( AV45TFTipoOblDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obligación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV82GXV2 = 1 ;
         while ( AV82GXV2 <= AV45TFTipoOblDescrip_Sels.size() )
         {
            AV46TFTipoOblDescrip_Sel = (String)AV45TFTipoOblDescrip_Sels.elementAt(-1+AV82GXV2) ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFTipoOblDescrip_Sel, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV75i = (long)(AV75i+1) ;
            AV82GXV2 = (int)(AV82GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFTipoOblDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obligación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFTipoOblDescrip, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV49TFOblConcepto_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV83GXV3 = 1 ;
         while ( AV83GXV3 <= AV49TFOblConcepto_Sels.size() )
         {
            AV50TFOblConcepto_Sel = (String)AV49TFOblConcepto_Sels.elementAt(-1+AV83GXV3) ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFOblConcepto_Sel, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV75i = (long)(AV75i+1) ;
            AV83GXV3 = (int)(AV83GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV48TFOblConcepto)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFOblConcepto, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV52TFOblEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV84GXV4 = 1 ;
         while ( AV84GXV4 <= AV52TFOblEstado_Sels.size() )
         {
            AV53TFOblEstado_Sel = ((Number) AV52TFOblEstado_Sels.elementAt(-1+AV84GXV4)).byteValue() ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainestado_obligacion.getDescription(httpContext,(byte)AV53TFOblEstado_Sel), "") );
            AV75i = (long)(AV75i+1) ;
            AV84GXV4 = (int)(AV84GXV4+1) ;
         }
      }
      if ( ! ( ( AV56TFOblObs_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV85GXV5 = 1 ;
         while ( AV85GXV5 <= AV56TFOblObs_Sels.size() )
         {
            AV57TFOblObs_Sel = (String)AV56TFOblObs_Sels.elementAt(-1+AV85GXV5) ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV57TFOblObs_Sel, 1, 1000), GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV75i = (long)(AV75i+1) ;
            AV85GXV5 = (int)(AV85GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFOblObs)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observaciones", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV55TFOblObs, 1, 1000), GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV59TFOblOriPer_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV86GXV6 = 1 ;
         while ( AV86GXV6 <= AV59TFOblOriPer_Sels.size() )
         {
            AV60TFOblOriPer_Sel = ((Number) AV59TFOblOriPer_Sels.elementAt(-1+AV86GXV6)).byteValue() ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)AV60TFOblOriPer_Sel), "") );
            AV75i = (long)(AV75i+1) ;
            AV86GXV6 = (int)(AV86GXV6+1) ;
         }
      }
      if ( ! ( ( AV63TFOblConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen concepto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV75i = 1 ;
         AV87GXV7 = 1 ;
         while ( AV87GXV7 <= AV63TFOblConCodigo_Sels.size() )
         {
            AV64TFOblConCodigo_Sel = (String)AV63TFOblConCodigo_Sels.elementAt(-1+AV87GXV7) ;
            if ( AV75i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFOblConCodigo_Sel, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV75i = (long)(AV75i+1) ;
            AV87GXV7 = (int)(AV87GXV7+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV62TFOblConCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen concepto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFOblConCodigo, GXv_char7) ;
            obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFOblTotal)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFOblTotal_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Total", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV65TFOblTotal)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV66TFOblTotal_To)) );
      }
      if ( ! ( (0==AV67TFOblCanCuo) && (0==AV68TFOblCanCuo_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de cuotas", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV67TFOblCanCuo );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV68TFOblCanCuo_To );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFOblImpFij)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFOblImpFij_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Importe de cuota fija", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV69TFOblImpFij)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV70TFOblImpFij_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFOblPorc)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFOblPorc_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Porcentaje", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV71TFOblPorc)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV72TFOblPorc_To)) );
      }
      if ( ! ( (0==AV73TFOblNoRemu_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "No remunerativos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV73TFOblNoRemu_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV73TFOblNoRemu_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV74TFOblDescu_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Retenciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         obligacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV74TFOblDescu_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV74TFOblDescu_Sel == 2 )
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
      if ( GXutil.strcmp(AV20Session.getValue("ObligacionWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ObligacionWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV88GXV8 = 1 ;
      while ( AV88GXV8 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV88GXV8));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV88GXV8 = (int)(AV88GXV8+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV90Obligacionwwds_1_tfoblsecuencial = AV35TFOblSecuencial ;
      AV91Obligacionwwds_2_tfoblsecuencial_to = AV36TFOblSecuencial_To ;
      AV92Obligacionwwds_3_tflegidnomape = AV38TFLegIdNomApe ;
      AV93Obligacionwwds_4_tflegidnomape_sels = AV39TFLegIdNomApe_Sels ;
      AV94Obligacionwwds_5_tftipooblsec = AV41TFTipoOblSec ;
      AV95Obligacionwwds_6_tftipooblsec_to = AV42TFTipoOblSec_To ;
      AV96Obligacionwwds_7_tftipoobldescrip = AV44TFTipoOblDescrip ;
      AV97Obligacionwwds_8_tftipoobldescrip_sels = AV45TFTipoOblDescrip_Sels ;
      AV98Obligacionwwds_9_tfoblconcepto = AV48TFOblConcepto ;
      AV99Obligacionwwds_10_tfoblconcepto_sels = AV49TFOblConcepto_Sels ;
      AV100Obligacionwwds_11_tfoblestado_sels = AV52TFOblEstado_Sels ;
      AV101Obligacionwwds_12_tfoblobs = AV55TFOblObs ;
      AV102Obligacionwwds_13_tfoblobs_sels = AV56TFOblObs_Sels ;
      AV103Obligacionwwds_14_tfobloriper_sels = AV59TFOblOriPer_Sels ;
      AV104Obligacionwwds_15_tfoblconcodigo = AV62TFOblConCodigo ;
      AV105Obligacionwwds_16_tfoblconcodigo_sels = AV63TFOblConCodigo_Sels ;
      AV106Obligacionwwds_17_tfobltotal = AV65TFOblTotal ;
      AV107Obligacionwwds_18_tfobltotal_to = AV66TFOblTotal_To ;
      AV108Obligacionwwds_19_tfoblcancuo = AV67TFOblCanCuo ;
      AV109Obligacionwwds_20_tfoblcancuo_to = AV68TFOblCanCuo_To ;
      AV110Obligacionwwds_21_tfoblimpfij = AV69TFOblImpFij ;
      AV111Obligacionwwds_22_tfoblimpfij_to = AV70TFOblImpFij_To ;
      AV112Obligacionwwds_23_tfoblporc = AV71TFOblPorc ;
      AV113Obligacionwwds_24_tfoblporc_to = AV72TFOblPorc_To ;
      AV114Obligacionwwds_25_tfoblnoremu_sel = AV73TFOblNoRemu_Sel ;
      AV115Obligacionwwds_26_tfobldescu_sel = AV74TFOblDescu_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV93Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV97Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV99Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV100Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV102Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV103Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV105Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV90Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV91Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV93Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV92Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV94Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV95Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV97Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV96Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV99Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV98Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV100Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV102Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV101Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV103Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV105Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV104Obligacionwwds_15_tfoblconcodigo ,
                                           AV106Obligacionwwds_17_tfobltotal ,
                                           AV107Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV108Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV109Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV110Obligacionwwds_21_tfoblimpfij ,
                                           AV111Obligacionwwds_22_tfoblimpfij_to ,
                                           AV112Obligacionwwds_23_tfoblporc ,
                                           AV113Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV114Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV115Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV76CliCod) ,
                                           Short.valueOf(AV77EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV92Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV92Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV96Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV96Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV98Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV98Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV101Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV101Obligacionwwds_12_tfoblobs), "%", "") ;
      lV104Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV104Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P02FC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV76CliCod), Short.valueOf(AV77EmpCod), Short.valueOf(AV90Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV91Obligacionwwds_2_tfoblsecuencial_to), lV92Obligacionwwds_3_tflegidnomape, Short.valueOf(AV94Obligacionwwds_5_tftipooblsec), Short.valueOf(AV95Obligacionwwds_6_tftipooblsec_to), lV96Obligacionwwds_7_tftipoobldescrip, lV98Obligacionwwds_9_tfoblconcepto, lV101Obligacionwwds_12_tfoblobs, lV104Obligacionwwds_15_tfoblconcodigo, AV106Obligacionwwds_17_tfobltotal, AV107Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV108Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV109Obligacionwwds_20_tfoblcancuo_to), AV110Obligacionwwds_21_tfoblimpfij, AV111Obligacionwwds_22_tfoblimpfij_to, AV112Obligacionwwds_23_tfoblporc, AV113Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02FC2_A6LegNumero[0] ;
         A1EmpCod = P02FC2_A1EmpCod[0] ;
         A3CliCod = P02FC2_A3CliCod[0] ;
         A1182OblDescu = P02FC2_A1182OblDescu[0] ;
         A1181OblNoRemu = P02FC2_A1181OblNoRemu[0] ;
         A1179OblPorc = P02FC2_A1179OblPorc[0] ;
         A1178OblImpFij = P02FC2_A1178OblImpFij[0] ;
         A1177OblCanCuo = P02FC2_A1177OblCanCuo[0] ;
         A1176OblTotal = P02FC2_A1176OblTotal[0] ;
         A1169OblConCodigo = P02FC2_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P02FC2_n1169OblConCodigo[0] ;
         A1175OblOriPer = P02FC2_A1175OblOriPer[0] ;
         A1174OblObs = P02FC2_A1174OblObs[0] ;
         A1173OblEstado = P02FC2_A1173OblEstado[0] ;
         A2343OblConcepto = P02FC2_A2343OblConcepto[0] ;
         A1165TipoOblDescrip = P02FC2_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P02FC2_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P02FC2_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P02FC2_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P02FC2_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P02FC2_A1165TipoOblDescrip[0] ;
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
         AV32VisibleColumnCount = 0 ;
         AV116GXV9 = 1 ;
         while ( AV116GXV9 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV116GXV9));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblSecuencial") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1172OblSecuencial );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegIdNomApe") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A250LegIdNomApe, GXv_char7) ;
                  obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblSec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1163TipoOblSec );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoOblDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1165TipoOblDescrip, GXv_char7) ;
                  obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblConcepto") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2343OblConcepto, GXv_char7) ;
                  obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblEstado") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainestado_obligacion.getDescription(httpContext,(byte)A1173OblEstado), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblObs") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1174OblObs, 1, 1000), GXv_char7) ;
                  obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblOriPer") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)A1175OblOriPer), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblConCodigo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1169OblConCodigo, GXv_char7) ;
                  obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblTotal") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1176OblTotal)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblCanCuo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1177OblCanCuo );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblImpFij") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1178OblImpFij)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblPorc") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1179OblPorc)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblNoRemu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1181OblNoRemu) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OblDescu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1182OblDescu) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV116GXV9 = (int)(AV116GXV9+1) ;
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblSecuencial", "", "Nro.", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegIdNomApe", "", "Legajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoOblSec", "", "Obligación", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoOblDescrip", "", "Obligación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblConcepto", "", "Concepto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblObs", "", "Observaciones", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblOriPer", "", "Origen Periodo", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblConCodigo", "", "Origen concepto", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblTotal", "", "Total", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblCanCuo", "", "Cantidad de cuotas", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblImpFij", "", "Importe de cuota fija", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblPorc", "", "Porcentaje", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblNoRemu", "", "No remunerativos", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "OblDescu", "", "Retenciones", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ObligacionWWColumnsSelector", GXv_char7) ;
      obligacionwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ObligacionWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ObligacionWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ObligacionWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV117GXV10 = 1 ;
      while ( AV117GXV10 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV117GXV10));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLSECUENCIAL") == 0 )
         {
            AV35TFOblSecuencial = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFOblSecuencial_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV38TFLegIdNomApe = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV37TFLegIdNomApe_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFLegIdNomApe_Sels.fromJSonString(AV37TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLSEC") == 0 )
         {
            AV41TFTipoOblSec = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFTipoOblSec_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP") == 0 )
         {
            AV44TFTipoOblDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP_SEL") == 0 )
         {
            AV43TFTipoOblDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFTipoOblDescrip_Sels.fromJSonString(AV43TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO") == 0 )
         {
            AV48TFOblConcepto = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO_SEL") == 0 )
         {
            AV47TFOblConcepto_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFOblConcepto_Sels.fromJSonString(AV47TFOblConcepto_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLESTADO_SEL") == 0 )
         {
            AV51TFOblEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFOblEstado_Sels.fromJSonString(AV51TFOblEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS") == 0 )
         {
            AV55TFOblObs = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS_SEL") == 0 )
         {
            AV54TFOblObs_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFOblObs_Sels.fromJSonString(AV54TFOblObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLORIPER_SEL") == 0 )
         {
            AV58TFOblOriPer_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFOblOriPer_Sels.fromJSonString(AV58TFOblOriPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO") == 0 )
         {
            AV62TFOblConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO_SEL") == 0 )
         {
            AV61TFOblConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFOblConCodigo_Sels.fromJSonString(AV61TFOblConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLTOTAL") == 0 )
         {
            AV65TFOblTotal = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV66TFOblTotal_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCANCUO") == 0 )
         {
            AV67TFOblCanCuo = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV68TFOblCanCuo_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLIMPFIJ") == 0 )
         {
            AV69TFOblImpFij = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV70TFOblImpFij_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLPORC") == 0 )
         {
            AV71TFOblPorc = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV72TFOblPorc_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLNOREMU_SEL") == 0 )
         {
            AV73TFOblNoRemu_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLDESCU_SEL") == 0 )
         {
            AV74TFOblDescu_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV117GXV10 = (int)(AV117GXV10+1) ;
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
      this.aP0[0] = obligacionwwexport.this.AV12Filename;
      this.aP1[0] = obligacionwwexport.this.AV13ErrorMessage;
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
      AV80Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFLegIdNomApe_Sel = "" ;
      AV38TFLegIdNomApe = "" ;
      AV45TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFTipoOblDescrip_Sel = "" ;
      AV44TFTipoOblDescrip = "" ;
      AV49TFOblConcepto_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFOblConcepto_Sel = "" ;
      AV48TFOblConcepto = "" ;
      AV52TFOblEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV56TFOblObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFOblObs_Sel = "" ;
      AV55TFOblObs = "" ;
      AV59TFOblOriPer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV63TFOblConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFOblConCodigo_Sel = "" ;
      AV62TFOblConCodigo = "" ;
      AV65TFOblTotal = DecimalUtil.ZERO ;
      AV66TFOblTotal_To = DecimalUtil.ZERO ;
      AV69TFOblImpFij = DecimalUtil.ZERO ;
      AV70TFOblImpFij_To = DecimalUtil.ZERO ;
      AV71TFOblPorc = DecimalUtil.ZERO ;
      AV72TFOblPorc_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A250LegIdNomApe = "" ;
      A1165TipoOblDescrip = "" ;
      A2343OblConcepto = "" ;
      A1174OblObs = "" ;
      A1169OblConCodigo = "" ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      AV92Obligacionwwds_3_tflegidnomape = "" ;
      AV93Obligacionwwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Obligacionwwds_7_tftipoobldescrip = "" ;
      AV97Obligacionwwds_8_tftipoobldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Obligacionwwds_9_tfoblconcepto = "" ;
      AV99Obligacionwwds_10_tfoblconcepto_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Obligacionwwds_11_tfoblestado_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV101Obligacionwwds_12_tfoblobs = "" ;
      AV102Obligacionwwds_13_tfoblobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV103Obligacionwwds_14_tfobloriper_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV104Obligacionwwds_15_tfoblconcodigo = "" ;
      AV105Obligacionwwds_16_tfoblconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV106Obligacionwwds_17_tfobltotal = DecimalUtil.ZERO ;
      AV107Obligacionwwds_18_tfobltotal_to = DecimalUtil.ZERO ;
      AV110Obligacionwwds_21_tfoblimpfij = DecimalUtil.ZERO ;
      AV111Obligacionwwds_22_tfoblimpfij_to = DecimalUtil.ZERO ;
      AV112Obligacionwwds_23_tfoblporc = DecimalUtil.ZERO ;
      AV113Obligacionwwds_24_tfoblporc_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV92Obligacionwwds_3_tflegidnomape = "" ;
      lV96Obligacionwwds_7_tftipoobldescrip = "" ;
      lV98Obligacionwwds_9_tfoblconcepto = "" ;
      lV101Obligacionwwds_12_tfoblobs = "" ;
      lV104Obligacionwwds_15_tfoblconcodigo = "" ;
      P02FC2_A6LegNumero = new int[1] ;
      P02FC2_A1EmpCod = new short[1] ;
      P02FC2_A3CliCod = new int[1] ;
      P02FC2_A1182OblDescu = new boolean[] {false} ;
      P02FC2_A1181OblNoRemu = new boolean[] {false} ;
      P02FC2_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FC2_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FC2_A1177OblCanCuo = new short[1] ;
      P02FC2_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FC2_A1169OblConCodigo = new String[] {""} ;
      P02FC2_n1169OblConCodigo = new boolean[] {false} ;
      P02FC2_A1175OblOriPer = new byte[1] ;
      P02FC2_A1174OblObs = new String[] {""} ;
      P02FC2_A1173OblEstado = new byte[1] ;
      P02FC2_A2343OblConcepto = new String[] {""} ;
      P02FC2_A1165TipoOblDescrip = new String[] {""} ;
      P02FC2_A1163TipoOblSec = new short[1] ;
      P02FC2_A250LegIdNomApe = new String[] {""} ;
      P02FC2_A1172OblSecuencial = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFLegIdNomApe_SelsJson = "" ;
      AV43TFTipoOblDescrip_SelsJson = "" ;
      AV47TFOblConcepto_SelsJson = "" ;
      AV51TFOblEstado_SelsJson = "" ;
      AV54TFOblObs_SelsJson = "" ;
      AV58TFOblOriPer_SelsJson = "" ;
      AV61TFOblConCodigo_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacionwwexport__default(),
         new Object[] {
             new Object[] {
            P02FC2_A6LegNumero, P02FC2_A1EmpCod, P02FC2_A3CliCod, P02FC2_A1182OblDescu, P02FC2_A1181OblNoRemu, P02FC2_A1179OblPorc, P02FC2_A1178OblImpFij, P02FC2_A1177OblCanCuo, P02FC2_A1176OblTotal, P02FC2_A1169OblConCodigo,
            P02FC2_n1169OblConCodigo, P02FC2_A1175OblOriPer, P02FC2_A1174OblObs, P02FC2_A1173OblEstado, P02FC2_A2343OblConcepto, P02FC2_A1165TipoOblDescrip, P02FC2_A1163TipoOblSec, P02FC2_A250LegIdNomApe, P02FC2_A1172OblSecuencial
            }
         }
      );
      AV80Pgmname = "ObligacionWWExport" ;
      /* GeneXus formulas. */
      AV80Pgmname = "ObligacionWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV53TFOblEstado_Sel ;
   private byte AV60TFOblOriPer_Sel ;
   private byte AV73TFOblNoRemu_Sel ;
   private byte AV74TFOblDescu_Sel ;
   private byte A1173OblEstado ;
   private byte A1175OblOriPer ;
   private byte AV114Obligacionwwds_25_tfoblnoremu_sel ;
   private byte AV115Obligacionwwds_26_tfobldescu_sel ;
   private short AV35TFOblSecuencial ;
   private short AV36TFOblSecuencial_To ;
   private short AV41TFTipoOblSec ;
   private short AV42TFTipoOblSec_To ;
   private short AV67TFOblCanCuo ;
   private short AV68TFOblCanCuo_To ;
   private short GXv_int5[] ;
   private short A1172OblSecuencial ;
   private short A1163TipoOblSec ;
   private short A1177OblCanCuo ;
   private short AV90Obligacionwwds_1_tfoblsecuencial ;
   private short AV91Obligacionwwds_2_tfoblsecuencial_to ;
   private short AV94Obligacionwwds_5_tftipooblsec ;
   private short AV95Obligacionwwds_6_tftipooblsec_to ;
   private short AV108Obligacionwwds_19_tfoblcancuo ;
   private short AV109Obligacionwwds_20_tfoblcancuo_to ;
   private short AV18OrderedBy ;
   private short AV77EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV81GXV1 ;
   private int AV82GXV2 ;
   private int AV83GXV3 ;
   private int AV84GXV4 ;
   private int AV85GXV5 ;
   private int AV86GXV6 ;
   private int AV87GXV7 ;
   private int AV88GXV8 ;
   private int AV93Obligacionwwds_4_tflegidnomape_sels_size ;
   private int AV97Obligacionwwds_8_tftipoobldescrip_sels_size ;
   private int AV99Obligacionwwds_10_tfoblconcepto_sels_size ;
   private int AV100Obligacionwwds_11_tfoblestado_sels_size ;
   private int AV102Obligacionwwds_13_tfoblobs_sels_size ;
   private int AV103Obligacionwwds_14_tfobloriper_sels_size ;
   private int AV105Obligacionwwds_16_tfoblconcodigo_sels_size ;
   private int AV76CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV116GXV9 ;
   private int AV117GXV10 ;
   private long AV75i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV65TFOblTotal ;
   private java.math.BigDecimal AV66TFOblTotal_To ;
   private java.math.BigDecimal AV69TFOblImpFij ;
   private java.math.BigDecimal AV70TFOblImpFij_To ;
   private java.math.BigDecimal AV71TFOblPorc ;
   private java.math.BigDecimal AV72TFOblPorc_To ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private java.math.BigDecimal AV106Obligacionwwds_17_tfobltotal ;
   private java.math.BigDecimal AV107Obligacionwwds_18_tfobltotal_to ;
   private java.math.BigDecimal AV110Obligacionwwds_21_tfoblimpfij ;
   private java.math.BigDecimal AV111Obligacionwwds_22_tfoblimpfij_to ;
   private java.math.BigDecimal AV112Obligacionwwds_23_tfoblporc ;
   private java.math.BigDecimal AV113Obligacionwwds_24_tfoblporc_to ;
   private String AV80Pgmname ;
   private String AV50TFOblConcepto_Sel ;
   private String AV48TFOblConcepto ;
   private String AV64TFOblConCodigo_Sel ;
   private String AV62TFOblConCodigo ;
   private String A2343OblConcepto ;
   private String A1169OblConCodigo ;
   private String AV98Obligacionwwds_9_tfoblconcepto ;
   private String AV104Obligacionwwds_15_tfoblconcodigo ;
   private String scmdbuf ;
   private String lV98Obligacionwwds_9_tfoblconcepto ;
   private String lV104Obligacionwwds_15_tfoblconcodigo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean AV19OrderedDsc ;
   private boolean n1169OblConCodigo ;
   private String AV27ColumnsSelectorXML ;
   private String A1174OblObs ;
   private String AV28UserCustomValue ;
   private String AV37TFLegIdNomApe_SelsJson ;
   private String AV43TFTipoOblDescrip_SelsJson ;
   private String AV47TFOblConcepto_SelsJson ;
   private String AV51TFOblEstado_SelsJson ;
   private String AV54TFOblObs_SelsJson ;
   private String AV58TFOblOriPer_SelsJson ;
   private String AV61TFOblConCodigo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFLegIdNomApe_Sel ;
   private String AV38TFLegIdNomApe ;
   private String AV46TFTipoOblDescrip_Sel ;
   private String AV44TFTipoOblDescrip ;
   private String AV57TFOblObs_Sel ;
   private String AV55TFOblObs ;
   private String A250LegIdNomApe ;
   private String A1165TipoOblDescrip ;
   private String AV92Obligacionwwds_3_tflegidnomape ;
   private String AV96Obligacionwwds_7_tftipoobldescrip ;
   private String AV101Obligacionwwds_12_tfoblobs ;
   private String lV92Obligacionwwds_3_tflegidnomape ;
   private String lV96Obligacionwwds_7_tftipoobldescrip ;
   private String lV101Obligacionwwds_12_tfoblobs ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV52TFOblEstado_Sels ;
   private GXSimpleCollection<Byte> AV59TFOblOriPer_Sels ;
   private GXSimpleCollection<Byte> AV100Obligacionwwds_11_tfoblestado_sels ;
   private GXSimpleCollection<Byte> AV103Obligacionwwds_14_tfobloriper_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV49TFOblConcepto_Sels ;
   private GXSimpleCollection<String> AV63TFOblConCodigo_Sels ;
   private GXSimpleCollection<String> AV39TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV45TFTipoOblDescrip_Sels ;
   private GXSimpleCollection<String> AV56TFOblObs_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FC2_A6LegNumero ;
   private short[] P02FC2_A1EmpCod ;
   private int[] P02FC2_A3CliCod ;
   private boolean[] P02FC2_A1182OblDescu ;
   private boolean[] P02FC2_A1181OblNoRemu ;
   private java.math.BigDecimal[] P02FC2_A1179OblPorc ;
   private java.math.BigDecimal[] P02FC2_A1178OblImpFij ;
   private short[] P02FC2_A1177OblCanCuo ;
   private java.math.BigDecimal[] P02FC2_A1176OblTotal ;
   private String[] P02FC2_A1169OblConCodigo ;
   private boolean[] P02FC2_n1169OblConCodigo ;
   private byte[] P02FC2_A1175OblOriPer ;
   private String[] P02FC2_A1174OblObs ;
   private byte[] P02FC2_A1173OblEstado ;
   private String[] P02FC2_A2343OblConcepto ;
   private String[] P02FC2_A1165TipoOblDescrip ;
   private short[] P02FC2_A1163TipoOblSec ;
   private String[] P02FC2_A250LegIdNomApe ;
   private short[] P02FC2_A1172OblSecuencial ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV99Obligacionwwds_10_tfoblconcepto_sels ;
   private GXSimpleCollection<String> AV105Obligacionwwds_16_tfoblconcodigo_sels ;
   private GXSimpleCollection<String> AV93Obligacionwwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV97Obligacionwwds_8_tftipoobldescrip_sels ;
   private GXSimpleCollection<String> AV102Obligacionwwds_13_tfoblobs_sels ;
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

final  class obligacionwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV93Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV97Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV99Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV100Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV102Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV103Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV105Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV90Obligacionwwds_1_tfoblsecuencial ,
                                          short AV91Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV93Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV92Obligacionwwds_3_tflegidnomape ,
                                          short AV94Obligacionwwds_5_tftipooblsec ,
                                          short AV95Obligacionwwds_6_tftipooblsec_to ,
                                          int AV97Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV96Obligacionwwds_7_tftipoobldescrip ,
                                          int AV99Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV98Obligacionwwds_9_tfoblconcepto ,
                                          int AV100Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV102Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV101Obligacionwwds_12_tfoblobs ,
                                          int AV103Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV105Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV104Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV106Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV107Obligacionwwds_18_tfobltotal_to ,
                                          short AV108Obligacionwwds_19_tfoblcancuo ,
                                          short AV109Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV110Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV111Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV112Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV113Obligacionwwds_24_tfoblporc_to ,
                                          byte AV114Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV115Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV76CliCod ,
                                          short AV77EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[19];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer, T1.OblObs," ;
      scmdbuf += " T1.OblEstado, T1.OblConcepto, T3.TipoOblDescrip, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV90Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV91Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV93Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV93Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV94Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV95Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV97Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV97Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV99Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( AV99Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV100Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV102Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( AV102Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV103Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV105Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV105Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV108Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV109Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV113Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV114Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV114Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV115Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV115Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblSecuencial" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblSecuencial DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.TipoOblSec" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.TipoOblSec DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.TipoOblDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.TipoOblDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblConcepto" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblConcepto DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblEstado" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblEstado DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblObs" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblObs DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblOriPer" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblOriPer DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblTotal" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblTotal DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblCanCuo" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblCanCuo DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblImpFij" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblImpFij DESC" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblPorc" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblPorc DESC" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblNoRemu" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblNoRemu DESC" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.OblDescu" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.OblDescu DESC" ;
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
                  return conditional_P02FC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).shortValue() , ((Boolean) dynConstraints[49]).booleanValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).shortValue() , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
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
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
      }
   }

}

