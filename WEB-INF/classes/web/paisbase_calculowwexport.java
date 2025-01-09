package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisbase_calculowwexport extends GXProcedure
{
   public paisbase_calculowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_calculowwexport.class ), "" );
   }

   public paisbase_calculowwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      paisbase_calculowwexport.this.aP1 = new String[] {""};
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
      paisbase_calculowwexport.this.aP0 = aP0;
      paisbase_calculowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo", GXv_boolean2) ;
      paisbase_calculowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV85Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Paisbase_calculoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFPaiBasePlus)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFPaiBasePlus_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Porcentaje para plus", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV38TFPaiBasePlus)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV39TFPaiBasePlus_To)) );
      }
      if ( ! ( (0==AV40TFPaiLicDLim) && (0==AV41TFPaiLicDLim_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFPaiLicDLim );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFPaiLicDLim_To );
      }
      if ( ! ( (0==AV42TFPaiLicDSeman) && (0==AV43TFPaiLicDSeman_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV42TFPaiLicDSeman );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV43TFPaiLicDSeman_To );
      }
      if ( ! ( (0==AV44TFPaiLicDMes) && (0==AV45TFPaiLicDMes_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV44TFPaiLicDMes );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV45TFPaiLicDMes_To );
      }
      if ( ! ( (0==AV46TFPaiLicDSemes) && (0==AV47TFPaiLicDSemes_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV46TFPaiLicDSemes );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV47TFPaiLicDSemes_To );
      }
      if ( ! ( (0==AV48TFPaiLicDAnual) && (0==AV49TFPaiLicDAnual_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV48TFPaiLicDAnual );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV49TFPaiLicDAnual_To );
      }
      if ( ! ( (0==AV50TFPaiLicAdju_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV50TFPaiLicAdju_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV50TFPaiLicAdju_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV51TFPaiLicAdjuObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV51TFPaiLicAdjuObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV51TFPaiLicAdjuObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV52TFPaiLicNecAut_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Necesita autorización", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV52TFPaiLicNecAut_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV52TFPaiLicNecAut_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV53TFPaiLicIngMot_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV53TFPaiLicIngMot_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV53TFPaiLicIngMot_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV54TFPaiLicMotObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV54TFPaiLicMotObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV54TFPaiLicMotObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV55TFPaiBasePromCnt1) && (0==AV56TFPaiBasePromCnt1_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días/meses a promediar", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV55TFPaiBasePromCnt1 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV56TFPaiBasePromCnt1_To );
      }
      if ( ! ( (0==AV57TFPaiBasePromCnt2) && (0==AV58TFPaiBasePromCnt2_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "segunda alternativa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV57TFPaiBasePromCnt2 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV58TFPaiBasePromCnt2_To );
      }
      if ( ! ( ( AV60TFPaiBasePromTCnt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Días o Meses", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV86GXV1 = 1 ;
         while ( AV86GXV1 <= AV60TFPaiBasePromTCnt_Sels.size() )
         {
            AV61TFPaiBasePromTCnt_Sel = (String)AV60TFPaiBasePromTCnt_Sels.elementAt(-1+AV86GXV1) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)AV61TFPaiBasePromTCnt_Sel), "") );
            AV62i = (long)(AV62i+1) ;
            AV86GXV1 = (int)(AV86GXV1+1) ;
         }
      }
      if ( ! ( ( AV81TFPaiBaseRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV87GXV2 = 1 ;
         while ( AV87GXV2 <= AV81TFPaiBaseRelRef_Sels.size() )
         {
            AV82TFPaiBaseRelRef_Sel = (String)AV81TFPaiBaseRelRef_Sels.elementAt(-1+AV87GXV2) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV82TFPaiBaseRelRef_Sel, GXv_char7) ;
            paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV62i = (long)(AV62i+1) ;
            AV87GXV2 = (int)(AV87GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV80TFPaiBaseRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paisbase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV80TFPaiBaseRelRef, GXv_char7) ;
            paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV35VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("Paisbase_calculoWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV21Session.getValue("Paisbase_calculoWWColumnsSelector") ;
         AV27ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV66IsAuthorizedPaiLicDLim&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV68IsAuthorizedPaiLicDSeman&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV69IsAuthorizedPaiLicDMes&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV70IsAuthorizedPaiLicDSemes&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV71IsAuthorizedPaiLicDAnual&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV72IsAuthorizedPaiLicAdju&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV73IsAuthorizedPaiLicAdjuObl&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV74IsAuthorizedPaiLicNecAut&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV75IsAuthorizedPaiLicIngMot&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV76IsAuthorizedPaiLicMotObl&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV78IsAuthorizedPaiBaseRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV88GXV3 = 1 ;
      while ( AV88GXV3 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV88GXV3));
         if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setColor( 11 );
            AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
         }
         AV88GXV3 = (int)(AV88GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV90Paisbase_calculowwds_1_paibaseclaseleg = AV17PaiBaseClaseLeg ;
      AV91Paisbase_calculowwds_2_paibasetipo = AV18PaiBaseTipo ;
      AV92Paisbase_calculowwds_3_tfpaibaseplus = AV38TFPaiBasePlus ;
      AV93Paisbase_calculowwds_4_tfpaibaseplus_to = AV39TFPaiBasePlus_To ;
      AV94Paisbase_calculowwds_5_tfpailicdlim = AV40TFPaiLicDLim ;
      AV95Paisbase_calculowwds_6_tfpailicdlim_to = AV41TFPaiLicDLim_To ;
      AV96Paisbase_calculowwds_7_tfpailicdseman = AV42TFPaiLicDSeman ;
      AV97Paisbase_calculowwds_8_tfpailicdseman_to = AV43TFPaiLicDSeman_To ;
      AV98Paisbase_calculowwds_9_tfpailicdmes = AV44TFPaiLicDMes ;
      AV99Paisbase_calculowwds_10_tfpailicdmes_to = AV45TFPaiLicDMes_To ;
      AV100Paisbase_calculowwds_11_tfpailicdsemes = AV46TFPaiLicDSemes ;
      AV101Paisbase_calculowwds_12_tfpailicdsemes_to = AV47TFPaiLicDSemes_To ;
      AV102Paisbase_calculowwds_13_tfpailicdanual = AV48TFPaiLicDAnual ;
      AV103Paisbase_calculowwds_14_tfpailicdanual_to = AV49TFPaiLicDAnual_To ;
      AV104Paisbase_calculowwds_15_tfpailicadju_sel = AV50TFPaiLicAdju_Sel ;
      AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel = AV51TFPaiLicAdjuObl_Sel ;
      AV106Paisbase_calculowwds_17_tfpailicnecaut_sel = AV52TFPaiLicNecAut_Sel ;
      AV107Paisbase_calculowwds_18_tfpailicingmot_sel = AV53TFPaiLicIngMot_Sel ;
      AV108Paisbase_calculowwds_19_tfpailicmotobl_sel = AV54TFPaiLicMotObl_Sel ;
      AV109Paisbase_calculowwds_20_tfpaibasepromcnt1 = AV55TFPaiBasePromCnt1 ;
      AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to = AV56TFPaiBasePromCnt1_To ;
      AV111Paisbase_calculowwds_22_tfpaibasepromcnt2 = AV57TFPaiBasePromCnt2 ;
      AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to = AV58TFPaiBasePromCnt2_To ;
      AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels = AV60TFPaiBasePromTCnt_Sels ;
      AV114Paisbase_calculowwds_25_tfpaibaserelref = AV80TFPaiBaseRelRef ;
      AV115Paisbase_calculowwds_26_tfpaibaserelref_sels = AV81TFPaiBaseRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1453PaiBasePromTCnt ,
                                           AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ,
                                           A2054PaiBaseRelRef ,
                                           AV115Paisbase_calculowwds_26_tfpaibaserelref_sels ,
                                           AV92Paisbase_calculowwds_3_tfpaibaseplus ,
                                           AV93Paisbase_calculowwds_4_tfpaibaseplus_to ,
                                           Short.valueOf(AV94Paisbase_calculowwds_5_tfpailicdlim) ,
                                           Short.valueOf(AV95Paisbase_calculowwds_6_tfpailicdlim_to) ,
                                           Byte.valueOf(AV96Paisbase_calculowwds_7_tfpailicdseman) ,
                                           Byte.valueOf(AV97Paisbase_calculowwds_8_tfpailicdseman_to) ,
                                           Byte.valueOf(AV98Paisbase_calculowwds_9_tfpailicdmes) ,
                                           Byte.valueOf(AV99Paisbase_calculowwds_10_tfpailicdmes_to) ,
                                           Short.valueOf(AV100Paisbase_calculowwds_11_tfpailicdsemes) ,
                                           Short.valueOf(AV101Paisbase_calculowwds_12_tfpailicdsemes_to) ,
                                           Short.valueOf(AV102Paisbase_calculowwds_13_tfpailicdanual) ,
                                           Short.valueOf(AV103Paisbase_calculowwds_14_tfpailicdanual_to) ,
                                           Byte.valueOf(AV104Paisbase_calculowwds_15_tfpailicadju_sel) ,
                                           Byte.valueOf(AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel) ,
                                           Byte.valueOf(AV106Paisbase_calculowwds_17_tfpailicnecaut_sel) ,
                                           Byte.valueOf(AV107Paisbase_calculowwds_18_tfpailicingmot_sel) ,
                                           Byte.valueOf(AV108Paisbase_calculowwds_19_tfpailicmotobl_sel) ,
                                           Short.valueOf(AV109Paisbase_calculowwds_20_tfpaibasepromcnt1) ,
                                           Short.valueOf(AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to) ,
                                           Short.valueOf(AV111Paisbase_calculowwds_22_tfpaibasepromcnt2) ,
                                           Short.valueOf(AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to) ,
                                           Integer.valueOf(AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels.size()) ,
                                           Integer.valueOf(AV115Paisbase_calculowwds_26_tfpaibaserelref_sels.size()) ,
                                           AV114Paisbase_calculowwds_25_tfpaibaserelref ,
                                           Short.valueOf(AV65PaiCod) ,
                                           A1444PaiBasePlus ,
                                           Short.valueOf(A1629PaiLicDLim) ,
                                           Byte.valueOf(A1630PaiLicDSeman) ,
                                           Byte.valueOf(A1631PaiLicDMes) ,
                                           Short.valueOf(A1632PaiLicDSemes) ,
                                           Short.valueOf(A1633PaiLicDAnual) ,
                                           Boolean.valueOf(A1634PaiLicAdju) ,
                                           Boolean.valueOf(A1635PaiLicAdjuObl) ,
                                           Boolean.valueOf(A1636PaiLicNecAut) ,
                                           Boolean.valueOf(A1637PaiLicIngMot) ,
                                           Boolean.valueOf(A1638PaiLicMotObl) ,
                                           Short.valueOf(A1451PaiBasePromCnt1) ,
                                           Short.valueOf(A1452PaiBasePromCnt2) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           Byte.valueOf(A1440PaiBaseClaseLeg) ,
                                           Byte.valueOf(AV90Paisbase_calculowwds_1_paibaseclaseleg) ,
                                           A1441PaiBaseTipo ,
                                           AV91Paisbase_calculowwds_2_paibasetipo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV114Paisbase_calculowwds_25_tfpaibaserelref = GXutil.concat( GXutil.rtrim( AV114Paisbase_calculowwds_25_tfpaibaserelref), "%", "") ;
      /* Using cursor P01ID2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV90Paisbase_calculowwds_1_paibaseclaseleg), AV91Paisbase_calculowwds_2_paibasetipo, AV92Paisbase_calculowwds_3_tfpaibaseplus, AV93Paisbase_calculowwds_4_tfpaibaseplus_to, Short.valueOf(AV94Paisbase_calculowwds_5_tfpailicdlim), Short.valueOf(AV95Paisbase_calculowwds_6_tfpailicdlim_to), Byte.valueOf(AV96Paisbase_calculowwds_7_tfpailicdseman), Byte.valueOf(AV97Paisbase_calculowwds_8_tfpailicdseman_to), Byte.valueOf(AV98Paisbase_calculowwds_9_tfpailicdmes), Byte.valueOf(AV99Paisbase_calculowwds_10_tfpailicdmes_to), Short.valueOf(AV100Paisbase_calculowwds_11_tfpailicdsemes), Short.valueOf(AV101Paisbase_calculowwds_12_tfpailicdsemes_to), Short.valueOf(AV102Paisbase_calculowwds_13_tfpailicdanual), Short.valueOf(AV103Paisbase_calculowwds_14_tfpailicdanual_to), Short.valueOf(AV109Paisbase_calculowwds_20_tfpaibasepromcnt1), Short.valueOf(AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to), Short.valueOf(AV111Paisbase_calculowwds_22_tfpaibasepromcnt2), Short.valueOf(AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to), lV114Paisbase_calculowwds_25_tfpaibaserelref, Short.valueOf(AV65PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01ID2_A46PaiCod[0] ;
         A2054PaiBaseRelRef = P01ID2_A2054PaiBaseRelRef[0] ;
         A1453PaiBasePromTCnt = P01ID2_A1453PaiBasePromTCnt[0] ;
         A1452PaiBasePromCnt2 = P01ID2_A1452PaiBasePromCnt2[0] ;
         A1451PaiBasePromCnt1 = P01ID2_A1451PaiBasePromCnt1[0] ;
         A1638PaiLicMotObl = P01ID2_A1638PaiLicMotObl[0] ;
         A1637PaiLicIngMot = P01ID2_A1637PaiLicIngMot[0] ;
         A1636PaiLicNecAut = P01ID2_A1636PaiLicNecAut[0] ;
         A1635PaiLicAdjuObl = P01ID2_A1635PaiLicAdjuObl[0] ;
         A1634PaiLicAdju = P01ID2_A1634PaiLicAdju[0] ;
         A1633PaiLicDAnual = P01ID2_A1633PaiLicDAnual[0] ;
         A1632PaiLicDSemes = P01ID2_A1632PaiLicDSemes[0] ;
         A1631PaiLicDMes = P01ID2_A1631PaiLicDMes[0] ;
         A1630PaiLicDSeman = P01ID2_A1630PaiLicDSeman[0] ;
         A1629PaiLicDLim = P01ID2_A1629PaiLicDLim[0] ;
         A1444PaiBasePlus = P01ID2_A1444PaiBasePlus[0] ;
         A1441PaiBaseTipo = P01ID2_A1441PaiBaseTipo[0] ;
         A1440PaiBaseClaseLeg = P01ID2_A1440PaiBaseClaseLeg[0] ;
         A1442PaiBaseCod1 = P01ID2_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = P01ID2_A1443PaiBaseCod2[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV35VisibleColumnCount = 0 ;
         AV116GXV4 = 1 ;
         while ( AV116GXV4 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV116GXV4));
            if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&PaiBaseC1Txt") == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV85Pgmname, httpContext.getMessage( "PaiBaseCod1 ", "")+A1442PaiBaseCod1) ;
                  GXt_char6 = AV25PaiBaseC1Txt ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
                  paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV25PaiBaseC1Txt = GXt_char6 ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV25PaiBaseC1Txt, GXv_char7) ;
                  paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&PaiBaseC2Txt") == 0 )
               {
                  GXt_char6 = AV26PaiBaseC2Txt ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
                  paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV26PaiBaseC2Txt = GXt_char6 ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV26PaiBaseC2Txt, GXv_char7) ;
                  paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiBasePlus") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1444PaiBasePlus)) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicDLim") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1629PaiLicDLim );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicDSeman") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1630PaiLicDSeman );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicDMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1631PaiLicDMes );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicDSemes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1632PaiLicDSemes );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicDAnual") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1633PaiLicDAnual );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicAdju") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1634PaiLicAdju) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicAdjuObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1635PaiLicAdjuObl) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicNecAut") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1636PaiLicNecAut) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicIngMot") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1637PaiLicIngMot) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiLicMotObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1638PaiLicMotObl) );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiBasePromCnt1") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1451PaiBasePromCnt1 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiBasePromCnt2") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1452PaiBasePromCnt2 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiBasePromTCnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)A1453PaiBasePromTCnt), "") );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiBaseRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2054PaiBaseRelRef, GXv_char7) ;
                  paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
            }
            AV116GXV4 = (int)(AV116GXV4+1) ;
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
      AV66IsAuthorizedPaiLicDLim = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV68IsAuthorizedPaiLicDSeman = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV69IsAuthorizedPaiLicDMes = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV70IsAuthorizedPaiLicDSemes = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV71IsAuthorizedPaiLicDAnual = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV72IsAuthorizedPaiLicAdju = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV73IsAuthorizedPaiLicAdjuObl = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV74IsAuthorizedPaiLicNecAut = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV75IsAuthorizedPaiLicIngMot = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      AV76IsAuthorizedPaiLicMotObl = (boolean)(((GXutil.strcmp(AV18PaiBaseTipo, "licencia")==0))) ;
      GXt_boolean1 = AV78IsAuthorizedPaiBaseRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV63CliCod, GXv_boolean2) ;
      paisbase_calculowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV78IsAuthorizedPaiBaseRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV27ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&PaiBaseC1Txt", "", "Código 1", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&PaiBaseC2Txt", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiBasePlus", "", "Porcentaje para plus", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicDLim", "", "Cantidad de días permitidos por licencia", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicDSeman", "", "Cantidad de días permitidos por semana", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicDMes", "", "Cantidad de días permitidos por mes", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicDSemes", "", "Cantidad de días permitidos por semestre", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicDAnual", "", "Cantidad de días permitidos por año", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicAdju", "", "Permite adjuntar documento", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicAdjuObl", "", "Obliga a adjuntar documento", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicNecAut", "", "Necesita autorización", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicIngMot", "", "Permite ingresar motivo", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18PaiBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiLicMotObl", "", "Obliga a ingresar motivo", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiBasePromCnt1", "", "Cantidad de días/meses a promediar", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiBasePromCnt2", "", "segunda alternativa", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiBasePromTCnt", "", "Días o Meses", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV63CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiBaseRelRef", "", "Liberación", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Paisbase_calculoWWColumnsSelector", GXv_char7) ;
      paisbase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV28ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV28ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("Paisbase_calculoWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Paisbase_calculoWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("Paisbase_calculoWWGridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV117GXV5 = 1 ;
      while ( AV117GXV5 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV117GXV5));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPLUS") == 0 )
         {
            AV38TFPaiBasePlus = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV39TFPaiBasePlus_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDLIM") == 0 )
         {
            AV40TFPaiLicDLim = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFPaiLicDLim_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDSEMAN") == 0 )
         {
            AV42TFPaiLicDSeman = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV43TFPaiLicDSeman_To = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDMES") == 0 )
         {
            AV44TFPaiLicDMes = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV45TFPaiLicDMes_To = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDSEMES") == 0 )
         {
            AV46TFPaiLicDSemes = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV47TFPaiLicDSemes_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDANUAL") == 0 )
         {
            AV48TFPaiLicDAnual = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV49TFPaiLicDAnual_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICADJU_SEL") == 0 )
         {
            AV50TFPaiLicAdju_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICADJUOBL_SEL") == 0 )
         {
            AV51TFPaiLicAdjuObl_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICNECAUT_SEL") == 0 )
         {
            AV52TFPaiLicNecAut_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICINGMOT_SEL") == 0 )
         {
            AV53TFPaiLicIngMot_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICMOTOBL_SEL") == 0 )
         {
            AV54TFPaiLicMotObl_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMCNT1") == 0 )
         {
            AV55TFPaiBasePromCnt1 = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFPaiBasePromCnt1_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMCNT2") == 0 )
         {
            AV57TFPaiBasePromCnt2 = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV58TFPaiBasePromCnt2_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMTCNT_SEL") == 0 )
         {
            AV59TFPaiBasePromTCnt_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFPaiBasePromTCnt_Sels.fromJSonString(AV59TFPaiBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASERELREF") == 0 )
         {
            AV80TFPaiBaseRelRef = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASERELREF_SEL") == 0 )
         {
            AV79TFPaiBaseRelRef_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV81TFPaiBaseRelRef_Sels.fromJSonString(AV79TFPaiBaseRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV77MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PAIBASECLASELEG") == 0 )
         {
            AV17PaiBaseClaseLeg = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PAIBASETIPO") == 0 )
         {
            AV18PaiBaseTipo = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV117GXV5 = (int)(AV117GXV5+1) ;
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
      this.aP0[0] = paisbase_calculowwexport.this.AV12Filename;
      this.aP1[0] = paisbase_calculowwexport.this.AV13ErrorMessage;
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
      AV85Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFPaiBasePlus = DecimalUtil.ZERO ;
      AV39TFPaiBasePlus_To = DecimalUtil.ZERO ;
      AV60TFPaiBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61TFPaiBasePromTCnt_Sel = "" ;
      AV81TFPaiBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82TFPaiBaseRelRef_Sel = "" ;
      AV80TFPaiBaseRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV27ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1442PaiBaseCod1 = "" ;
      A1441PaiBaseTipo = "" ;
      A1443PaiBaseCod2 = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1453PaiBasePromTCnt = "" ;
      A2054PaiBaseRelRef = "" ;
      AV91Paisbase_calculowwds_2_paibasetipo = "" ;
      AV18PaiBaseTipo = "" ;
      AV92Paisbase_calculowwds_3_tfpaibaseplus = DecimalUtil.ZERO ;
      AV93Paisbase_calculowwds_4_tfpaibaseplus_to = DecimalUtil.ZERO ;
      AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114Paisbase_calculowwds_25_tfpaibaserelref = "" ;
      AV115Paisbase_calculowwds_26_tfpaibaserelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV114Paisbase_calculowwds_25_tfpaibaserelref = "" ;
      P01ID2_A46PaiCod = new short[1] ;
      P01ID2_A2054PaiBaseRelRef = new String[] {""} ;
      P01ID2_A1453PaiBasePromTCnt = new String[] {""} ;
      P01ID2_A1452PaiBasePromCnt2 = new short[1] ;
      P01ID2_A1451PaiBasePromCnt1 = new short[1] ;
      P01ID2_A1638PaiLicMotObl = new boolean[] {false} ;
      P01ID2_A1637PaiLicIngMot = new boolean[] {false} ;
      P01ID2_A1636PaiLicNecAut = new boolean[] {false} ;
      P01ID2_A1635PaiLicAdjuObl = new boolean[] {false} ;
      P01ID2_A1634PaiLicAdju = new boolean[] {false} ;
      P01ID2_A1633PaiLicDAnual = new short[1] ;
      P01ID2_A1632PaiLicDSemes = new short[1] ;
      P01ID2_A1631PaiLicDMes = new byte[1] ;
      P01ID2_A1630PaiLicDSeman = new byte[1] ;
      P01ID2_A1629PaiLicDLim = new short[1] ;
      P01ID2_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ID2_A1441PaiBaseTipo = new String[] {""} ;
      P01ID2_A1440PaiBaseClaseLeg = new byte[1] ;
      P01ID2_A1442PaiBaseCod1 = new String[] {""} ;
      P01ID2_A1443PaiBaseCod2 = new String[] {""} ;
      AV25PaiBaseC1Txt = "" ;
      AV26PaiBaseC2Txt = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV28ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV59TFPaiBasePromTCnt_SelsJson = "" ;
      AV79TFPaiBaseRelRef_SelsJson = "" ;
      AV77MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisbase_calculowwexport__default(),
         new Object[] {
             new Object[] {
            P01ID2_A46PaiCod, P01ID2_A2054PaiBaseRelRef, P01ID2_A1453PaiBasePromTCnt, P01ID2_A1452PaiBasePromCnt2, P01ID2_A1451PaiBasePromCnt1, P01ID2_A1638PaiLicMotObl, P01ID2_A1637PaiLicIngMot, P01ID2_A1636PaiLicNecAut, P01ID2_A1635PaiLicAdjuObl, P01ID2_A1634PaiLicAdju,
            P01ID2_A1633PaiLicDAnual, P01ID2_A1632PaiLicDSemes, P01ID2_A1631PaiLicDMes, P01ID2_A1630PaiLicDSeman, P01ID2_A1629PaiLicDLim, P01ID2_A1444PaiBasePlus, P01ID2_A1441PaiBaseTipo, P01ID2_A1440PaiBaseClaseLeg, P01ID2_A1442PaiBaseCod1, P01ID2_A1443PaiBaseCod2
            }
         }
      );
      AV85Pgmname = "Paisbase_calculoWWExport" ;
      /* GeneXus formulas. */
      AV85Pgmname = "Paisbase_calculoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV42TFPaiLicDSeman ;
   private byte AV43TFPaiLicDSeman_To ;
   private byte AV44TFPaiLicDMes ;
   private byte AV45TFPaiLicDMes_To ;
   private byte AV50TFPaiLicAdju_Sel ;
   private byte AV51TFPaiLicAdjuObl_Sel ;
   private byte AV52TFPaiLicNecAut_Sel ;
   private byte AV53TFPaiLicIngMot_Sel ;
   private byte AV54TFPaiLicMotObl_Sel ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte AV90Paisbase_calculowwds_1_paibaseclaseleg ;
   private byte AV17PaiBaseClaseLeg ;
   private byte AV96Paisbase_calculowwds_7_tfpailicdseman ;
   private byte AV97Paisbase_calculowwds_8_tfpailicdseman_to ;
   private byte AV98Paisbase_calculowwds_9_tfpailicdmes ;
   private byte AV99Paisbase_calculowwds_10_tfpailicdmes_to ;
   private byte AV104Paisbase_calculowwds_15_tfpailicadju_sel ;
   private byte AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel ;
   private byte AV106Paisbase_calculowwds_17_tfpailicnecaut_sel ;
   private byte AV107Paisbase_calculowwds_18_tfpailicingmot_sel ;
   private byte AV108Paisbase_calculowwds_19_tfpailicmotobl_sel ;
   private byte A1440PaiBaseClaseLeg ;
   private short AV40TFPaiLicDLim ;
   private short AV41TFPaiLicDLim_To ;
   private short AV46TFPaiLicDSemes ;
   private short AV47TFPaiLicDSemes_To ;
   private short AV48TFPaiLicDAnual ;
   private short AV49TFPaiLicDAnual_To ;
   private short AV55TFPaiBasePromCnt1 ;
   private short AV56TFPaiBasePromCnt1_To ;
   private short AV57TFPaiBasePromCnt2 ;
   private short AV58TFPaiBasePromCnt2_To ;
   private short GXv_int5[] ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short AV94Paisbase_calculowwds_5_tfpailicdlim ;
   private short AV95Paisbase_calculowwds_6_tfpailicdlim_to ;
   private short AV100Paisbase_calculowwds_11_tfpailicdsemes ;
   private short AV101Paisbase_calculowwds_12_tfpailicdsemes_to ;
   private short AV102Paisbase_calculowwds_13_tfpailicdanual ;
   private short AV103Paisbase_calculowwds_14_tfpailicdanual_to ;
   private short AV109Paisbase_calculowwds_20_tfpaibasepromcnt1 ;
   private short AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to ;
   private short AV111Paisbase_calculowwds_22_tfpaibasepromcnt2 ;
   private short AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to ;
   private short AV65PaiCod ;
   private short A46PaiCod ;
   private short AV19OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV86GXV1 ;
   private int AV87GXV2 ;
   private int AV88GXV3 ;
   private int AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size ;
   private int AV115Paisbase_calculowwds_26_tfpaibaserelref_sels_size ;
   private int AV116GXV4 ;
   private int AV63CliCod ;
   private int AV117GXV5 ;
   private long AV62i ;
   private long AV35VisibleColumnCount ;
   private java.math.BigDecimal AV38TFPaiBasePlus ;
   private java.math.BigDecimal AV39TFPaiBasePlus_To ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private java.math.BigDecimal AV92Paisbase_calculowwds_3_tfpaibaseplus ;
   private java.math.BigDecimal AV93Paisbase_calculowwds_4_tfpaibaseplus_to ;
   private String AV85Pgmname ;
   private String AV61TFPaiBasePromTCnt_Sel ;
   private String A1442PaiBaseCod1 ;
   private String A1441PaiBaseTipo ;
   private String A1443PaiBaseCod2 ;
   private String A1453PaiBasePromTCnt ;
   private String AV91Paisbase_calculowwds_2_paibasetipo ;
   private String AV18PaiBaseTipo ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV66IsAuthorizedPaiLicDLim ;
   private boolean AV68IsAuthorizedPaiLicDSeman ;
   private boolean AV69IsAuthorizedPaiLicDMes ;
   private boolean AV70IsAuthorizedPaiLicDSemes ;
   private boolean AV71IsAuthorizedPaiLicDAnual ;
   private boolean AV72IsAuthorizedPaiLicAdju ;
   private boolean AV73IsAuthorizedPaiLicAdjuObl ;
   private boolean AV74IsAuthorizedPaiLicNecAut ;
   private boolean AV75IsAuthorizedPaiLicIngMot ;
   private boolean AV76IsAuthorizedPaiLicMotObl ;
   private boolean AV78IsAuthorizedPaiBaseRelRef ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
   private boolean AV20OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV30ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV59TFPaiBasePromTCnt_SelsJson ;
   private String AV79TFPaiBaseRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV82TFPaiBaseRelRef_Sel ;
   private String AV80TFPaiBaseRelRef ;
   private String A2054PaiBaseRelRef ;
   private String AV114Paisbase_calculowwds_25_tfpaibaserelref ;
   private String lV114Paisbase_calculowwds_25_tfpaibaserelref ;
   private String AV25PaiBaseC1Txt ;
   private String AV26PaiBaseC2Txt ;
   private String AV77MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV60TFPaiBasePromTCnt_Sels ;
   private GXSimpleCollection<String> AV81TFPaiBaseRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01ID2_A46PaiCod ;
   private String[] P01ID2_A2054PaiBaseRelRef ;
   private String[] P01ID2_A1453PaiBasePromTCnt ;
   private short[] P01ID2_A1452PaiBasePromCnt2 ;
   private short[] P01ID2_A1451PaiBasePromCnt1 ;
   private boolean[] P01ID2_A1638PaiLicMotObl ;
   private boolean[] P01ID2_A1637PaiLicIngMot ;
   private boolean[] P01ID2_A1636PaiLicNecAut ;
   private boolean[] P01ID2_A1635PaiLicAdjuObl ;
   private boolean[] P01ID2_A1634PaiLicAdju ;
   private short[] P01ID2_A1633PaiLicDAnual ;
   private short[] P01ID2_A1632PaiLicDSemes ;
   private byte[] P01ID2_A1631PaiLicDMes ;
   private byte[] P01ID2_A1630PaiLicDSeman ;
   private short[] P01ID2_A1629PaiLicDLim ;
   private java.math.BigDecimal[] P01ID2_A1444PaiBasePlus ;
   private String[] P01ID2_A1441PaiBaseTipo ;
   private byte[] P01ID2_A1440PaiBaseClaseLeg ;
   private String[] P01ID2_A1442PaiBaseCod1 ;
   private String[] P01ID2_A1443PaiBaseCod2 ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ;
   private GXSimpleCollection<String> AV115Paisbase_calculowwds_26_tfpaibaserelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV29ColumnsSelector_Column ;
}

final  class paisbase_calculowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ID2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1453PaiBasePromTCnt ,
                                          GXSimpleCollection<String> AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ,
                                          String A2054PaiBaseRelRef ,
                                          GXSimpleCollection<String> AV115Paisbase_calculowwds_26_tfpaibaserelref_sels ,
                                          java.math.BigDecimal AV92Paisbase_calculowwds_3_tfpaibaseplus ,
                                          java.math.BigDecimal AV93Paisbase_calculowwds_4_tfpaibaseplus_to ,
                                          short AV94Paisbase_calculowwds_5_tfpailicdlim ,
                                          short AV95Paisbase_calculowwds_6_tfpailicdlim_to ,
                                          byte AV96Paisbase_calculowwds_7_tfpailicdseman ,
                                          byte AV97Paisbase_calculowwds_8_tfpailicdseman_to ,
                                          byte AV98Paisbase_calculowwds_9_tfpailicdmes ,
                                          byte AV99Paisbase_calculowwds_10_tfpailicdmes_to ,
                                          short AV100Paisbase_calculowwds_11_tfpailicdsemes ,
                                          short AV101Paisbase_calculowwds_12_tfpailicdsemes_to ,
                                          short AV102Paisbase_calculowwds_13_tfpailicdanual ,
                                          short AV103Paisbase_calculowwds_14_tfpailicdanual_to ,
                                          byte AV104Paisbase_calculowwds_15_tfpailicadju_sel ,
                                          byte AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel ,
                                          byte AV106Paisbase_calculowwds_17_tfpailicnecaut_sel ,
                                          byte AV107Paisbase_calculowwds_18_tfpailicingmot_sel ,
                                          byte AV108Paisbase_calculowwds_19_tfpailicmotobl_sel ,
                                          short AV109Paisbase_calculowwds_20_tfpaibasepromcnt1 ,
                                          short AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to ,
                                          short AV111Paisbase_calculowwds_22_tfpaibasepromcnt2 ,
                                          short AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to ,
                                          int AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size ,
                                          int AV115Paisbase_calculowwds_26_tfpaibaserelref_sels_size ,
                                          String AV114Paisbase_calculowwds_25_tfpaibaserelref ,
                                          short AV65PaiCod ,
                                          java.math.BigDecimal A1444PaiBasePlus ,
                                          short A1629PaiLicDLim ,
                                          byte A1630PaiLicDSeman ,
                                          byte A1631PaiLicDMes ,
                                          short A1632PaiLicDSemes ,
                                          short A1633PaiLicDAnual ,
                                          boolean A1634PaiLicAdju ,
                                          boolean A1635PaiLicAdjuObl ,
                                          boolean A1636PaiLicNecAut ,
                                          boolean A1637PaiLicIngMot ,
                                          boolean A1638PaiLicMotObl ,
                                          short A1451PaiBasePromCnt1 ,
                                          short A1452PaiBasePromCnt2 ,
                                          short A46PaiCod ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          byte A1440PaiBaseClaseLeg ,
                                          byte AV90Paisbase_calculowwds_1_paibaseclaseleg ,
                                          String A1441PaiBaseTipo ,
                                          String AV91Paisbase_calculowwds_2_paibasetipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[20];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, PaiBaseRelRef, PaiBasePromTCnt, PaiBasePromCnt2, PaiBasePromCnt1, PaiLicMotObl, PaiLicIngMot, PaiLicNecAut, PaiLicAdjuObl, PaiLicAdju, PaiLicDAnual," ;
      scmdbuf += " PaiLicDSemes, PaiLicDMes, PaiLicDSeman, PaiLicDLim, PaiBasePlus, PaiBaseTipo, PaiBaseClaseLeg, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo" ;
      addWhere(sWhereString, "(PaiBaseClaseLeg = ?)");
      addWhere(sWhereString, "(PaiBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Paisbase_calculowwds_3_tfpaibaseplus)==0) )
      {
         addWhere(sWhereString, "(PaiBasePlus >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Paisbase_calculowwds_4_tfpaibaseplus_to)==0) )
      {
         addWhere(sWhereString, "(PaiBasePlus <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV94Paisbase_calculowwds_5_tfpailicdlim) )
      {
         addWhere(sWhereString, "(PaiLicDLim >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV95Paisbase_calculowwds_6_tfpailicdlim_to) )
      {
         addWhere(sWhereString, "(PaiLicDLim <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV96Paisbase_calculowwds_7_tfpailicdseman) )
      {
         addWhere(sWhereString, "(PaiLicDSeman >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV97Paisbase_calculowwds_8_tfpailicdseman_to) )
      {
         addWhere(sWhereString, "(PaiLicDSeman <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV98Paisbase_calculowwds_9_tfpailicdmes) )
      {
         addWhere(sWhereString, "(PaiLicDMes >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV99Paisbase_calculowwds_10_tfpailicdmes_to) )
      {
         addWhere(sWhereString, "(PaiLicDMes <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV100Paisbase_calculowwds_11_tfpailicdsemes) )
      {
         addWhere(sWhereString, "(PaiLicDSemes >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV101Paisbase_calculowwds_12_tfpailicdsemes_to) )
      {
         addWhere(sWhereString, "(PaiLicDSemes <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV102Paisbase_calculowwds_13_tfpailicdanual) )
      {
         addWhere(sWhereString, "(PaiLicDAnual >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV103Paisbase_calculowwds_14_tfpailicdanual_to) )
      {
         addWhere(sWhereString, "(PaiLicDAnual <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV104Paisbase_calculowwds_15_tfpailicadju_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicAdju = TRUE)");
      }
      if ( AV104Paisbase_calculowwds_15_tfpailicadju_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicAdju = FALSE)");
      }
      if ( AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicAdjuObl = TRUE)");
      }
      if ( AV105Paisbase_calculowwds_16_tfpailicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicAdjuObl = FALSE)");
      }
      if ( AV106Paisbase_calculowwds_17_tfpailicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicNecAut = TRUE)");
      }
      if ( AV106Paisbase_calculowwds_17_tfpailicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicNecAut = FALSE)");
      }
      if ( AV107Paisbase_calculowwds_18_tfpailicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicIngMot = TRUE)");
      }
      if ( AV107Paisbase_calculowwds_18_tfpailicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicIngMot = FALSE)");
      }
      if ( AV108Paisbase_calculowwds_19_tfpailicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicMotObl = TRUE)");
      }
      if ( AV108Paisbase_calculowwds_19_tfpailicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicMotObl = FALSE)");
      }
      if ( ! (0==AV109Paisbase_calculowwds_20_tfpaibasepromcnt1) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV110Paisbase_calculowwds_21_tfpaibasepromcnt1_to) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV111Paisbase_calculowwds_22_tfpaibasepromcnt2) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV112Paisbase_calculowwds_23_tfpaibasepromcnt2_to) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Paisbase_calculowwds_24_tfpaibasepromtcnt_sels, "PaiBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV115Paisbase_calculowwds_26_tfpaibaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Paisbase_calculowwds_25_tfpaibaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV115Paisbase_calculowwds_26_tfpaibaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Paisbase_calculowwds_26_tfpaibaserelref_sels, "PaiBaseRelRef IN (", ")")+")");
      }
      if ( ! (0==AV65PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV19OrderedBy == 1 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBasePlus" ;
      }
      else if ( ( AV19OrderedBy == 1 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBasePlus DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicDLim" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicDLim DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicDSeman" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicDSeman DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicDMes" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicDMes DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicDSemes" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicDSemes DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicDAnual" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicDAnual DESC" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicAdju" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicAdju DESC" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicAdjuObl" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicAdjuObl DESC" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicNecAut" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicNecAut DESC" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicIngMot" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicIngMot DESC" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiLicMotObl" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiLicMotObl DESC" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBasePromCnt1" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBasePromCnt1 DESC" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBasePromCnt2" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBasePromCnt2 DESC" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBasePromTCnt" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBasePromTCnt DESC" ;
      }
      else if ( ( AV19OrderedBy == 15 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBaseRelRef" ;
      }
      else if ( ( AV19OrderedBy == 15 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBaseRelRef DESC" ;
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
                  return conditional_P01ID2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).shortValue() , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).byteValue() , ((Number) dynConstraints[46]).byteValue() , (String)dynConstraints[47] , (String)dynConstraints[48] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ID2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,4);
               ((String[]) buf[16])[0] = rslt.getString(17, 20);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
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
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 40);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               return;
      }
   }

}

