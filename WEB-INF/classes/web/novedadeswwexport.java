package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeswwexport extends GXProcedure
{
   public novedadeswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeswwexport.class ), "" );
   }

   public novedadeswwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      novedadeswwexport.this.aP1 = new String[] {""};
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
      novedadeswwexport.this.aP0 = aP0;
      novedadeswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV61CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      novedadeswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV61CliCod = GXt_int1 ;
      GXt_int3 = AV62EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      novedadeswwexport.this.GXt_int3 = GXv_int4[0] ;
      AV62EmpCod = GXt_int3 ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades", GXv_boolean6) ;
      novedadeswwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV100Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
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
      AV12Filename = "NovedadesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (false==AV83VerLiquidadas) ) )
      {
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( GXutil.booltostr( AV83VerLiquidadas) );
      }
      if ( ! ( ( AV65TFLegId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo Id.", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV101GXV1 = 1 ;
         while ( AV101GXV1 <= AV65TFLegId_Sels.size() )
         {
            AV66TFLegId_Sel = (String)AV65TFLegId_Sels.elementAt(-1+AV101GXV1) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFLegId_Sel, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV60i = (long)(AV60i+1) ;
            AV101GXV1 = (int)(AV101GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV64TFLegId)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo Id.", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFLegId, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV69TFLegNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV102GXV2 = 1 ;
         while ( AV102GXV2 <= AV69TFLegNomApe_Sels.size() )
         {
            AV70TFLegNomApe_Sel = (String)AV69TFLegNomApe_Sels.elementAt(-1+AV102GXV2) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV70TFLegNomApe_Sel, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV60i = (long)(AV60i+1) ;
            AV102GXV2 = (int)(AV102GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV68TFLegNomApe)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68TFLegNomApe, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV41TFConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV103GXV3 = 1 ;
         while ( AV103GXV3 <= AV41TFConCodigo_Sels.size() )
         {
            AV42TFConCodigo_Sel = (String)AV41TFConCodigo_Sels.elementAt(-1+AV103GXV3) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFConCodigo_Sel, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV60i = (long)(AV60i+1) ;
            AV103GXV3 = (int)(AV103GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFConCodigo)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConCodigo, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV45TFConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV104GXV4 = 1 ;
         while ( AV104GXV4 <= AV45TFConDescrip_Sels.size() )
         {
            AV46TFConDescrip_Sel = (String)AV45TFConDescrip_Sels.elementAt(-1+AV104GXV4) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFConDescrip_Sel, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV60i = (long)(AV60i+1) ;
            AV104GXV4 = (int)(AV104GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFConDescrip)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFConDescrip, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV48TFTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV105GXV5 = 1 ;
         while ( AV105GXV5 <= AV48TFTipoConCod_Sels.size() )
         {
            AV49TFTipoConCod_Sel = (String)AV48TFTipoConCod_Sels.elementAt(-1+AV105GXV5) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV49TFTipoConCod_Sel), "") );
            AV60i = (long)(AV60i+1) ;
            AV105GXV5 = (int)(AV105GXV5+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFAgeCanti)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFAgeCanti_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFAgeCanti)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFAgeCanti_To)) );
      }
      if ( ! ( ( AV96TFAgePerDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV106GXV6 = 1 ;
         while ( AV106GXV6 <= AV96TFAgePerDescrip_Sels.size() )
         {
            AV97TFAgePerDescrip_Sel = (String)AV96TFAgePerDescrip_Sels.elementAt(-1+AV106GXV6) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV97TFAgePerDescrip_Sel, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV60i = (long)(AV60i+1) ;
            AV106GXV6 = (int)(AV106GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV95TFAgePerDescrip)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char10[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV95TFAgePerDescrip, GXv_char10) ;
            novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV85TFAgeFecDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV107GXV7 = 1 ;
         while ( AV107GXV7 <= AV85TFAgeFecDes_Sels.size() )
         {
            AV86TFAgeFecDes_Sel = (java.util.Date)AV85TFAgeFecDes_Sels.elementAt(-1+AV107GXV7) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( AV86TFAgeFecDes_Sel, "99/99/9999") );
            AV60i = (long)(AV60i+1) ;
            AV107GXV7 = (int)(AV107GXV7+1) ;
         }
      }
      else
      {
         if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56TFAgeFecDes)) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Desde", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_dtime11 = GXutil.resetTime( AV56TFAgeFecDes );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime11 );
         }
      }
      if ( ! ( ( AV88TFAgeFecHas_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Hasta", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV60i = 1 ;
         AV108GXV8 = 1 ;
         while ( AV108GXV8 <= AV88TFAgeFecHas_Sels.size() )
         {
            AV89TFAgeFecHas_Sel = (java.util.Date)AV88TFAgeFecHas_Sels.elementAt(-1+AV108GXV8) ;
            if ( AV60i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( AV89TFAgeFecHas_Sel, "99/99/9999") );
            AV60i = (long)(AV60i+1) ;
            AV108GXV8 = (int)(AV108GXV8+1) ;
         }
      }
      else
      {
         if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV58TFAgeFecHas)) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Hasta", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_dtime11 = GXutil.resetTime( AV58TFAgeFecHas );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime11 );
         }
      }
      if ( ! ( (0==AV81TFAgeLiqNro) && (0==AV82TFAgeLiqNro_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Nro. Liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV81TFAgeLiqNro );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         novedadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV82TFAgeLiqNro_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("NovedadesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("NovedadesWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "AgeImporte" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Importe", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV109GXV9 = 1 ;
      while ( AV109GXV9 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV109GXV9));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV109GXV9 = (int)(AV109GXV9+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV65TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV69TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV41TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV45TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV48TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV96TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV85TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV88TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV83VerLiquidadas) ,
                                           Integer.valueOf(AV65TFLegId_Sels.size()) ,
                                           AV64TFLegId ,
                                           Integer.valueOf(AV69TFLegNomApe_Sels.size()) ,
                                           AV68TFLegNomApe ,
                                           Integer.valueOf(AV41TFConCodigo_Sels.size()) ,
                                           AV40TFConCodigo ,
                                           Integer.valueOf(AV45TFConDescrip_Sels.size()) ,
                                           AV44TFConDescrip ,
                                           Integer.valueOf(AV48TFTipoConCod_Sels.size()) ,
                                           AV50TFAgeCanti ,
                                           AV51TFAgeCanti_To ,
                                           Integer.valueOf(AV96TFAgePerDescrip_Sels.size()) ,
                                           AV95TFAgePerDescrip ,
                                           Integer.valueOf(AV85TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV88TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV81TFAgeLiqNro) ,
                                           Integer.valueOf(AV82TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV61CliCod) ,
                                           Short.valueOf(AV62EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV64TFLegId = GXutil.padr( GXutil.rtrim( AV64TFLegId), 20, "%") ;
      lV68TFLegNomApe = GXutil.concat( GXutil.rtrim( AV68TFLegNomApe), "%", "") ;
      lV40TFConCodigo = GXutil.padr( GXutil.rtrim( AV40TFConCodigo), 10, "%") ;
      lV44TFConDescrip = GXutil.concat( GXutil.rtrim( AV44TFConDescrip), "%", "") ;
      lV95TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV95TFAgePerDescrip), "%", "") ;
      /* Using cursor P00L42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV61CliCod), Short.valueOf(AV62EmpCod), lV64TFLegId, lV68TFLegNomApe, lV40TFConCodigo, lV44TFConDescrip, AV50TFAgeCanti, AV51TFAgeCanti_To, lV95TFAgePerDescrip, Integer.valueOf(AV81TFAgeLiqNro), Integer.valueOf(AV82TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00L42_A6LegNumero[0] ;
         A1EmpCod = P00L42_A1EmpCod[0] ;
         A3CliCod = P00L42_A3CliCod[0] ;
         A112AgeFecHas = P00L42_A112AgeFecHas[0] ;
         n112AgeFecHas = P00L42_n112AgeFecHas[0] ;
         A111AgeFecDes = P00L42_A111AgeFecDes[0] ;
         n111AgeFecDes = P00L42_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P00L42_A2159AgePerDescrip[0] ;
         A110AgeCanti = P00L42_A110AgeCanti[0] ;
         n110AgeCanti = P00L42_n110AgeCanti[0] ;
         A37TipoConCod = P00L42_A37TipoConCod[0] ;
         A41ConDescrip = P00L42_A41ConDescrip[0] ;
         A26ConCodigo = P00L42_A26ConCodigo[0] ;
         A591LegNomApe = P00L42_A591LegNomApe[0] ;
         A93LegId = P00L42_A93LegId[0] ;
         n93LegId = P00L42_n93LegId[0] ;
         A1254AgeLiqNro = P00L42_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P00L42_n1254AgeLiqNro[0] ;
         A113AgeImporte = P00L42_A113AgeImporte[0] ;
         n113AgeImporte = P00L42_n113AgeImporte[0] ;
         A239LegCUIL = P00L42_A239LegCUIL[0] ;
         A25AgeOrden = P00L42_A25AgeOrden[0] ;
         A591LegNomApe = P00L42_A591LegNomApe[0] ;
         A93LegId = P00L42_A93LegId[0] ;
         n93LegId = P00L42_n93LegId[0] ;
         A239LegCUIL = P00L42_A239LegCUIL[0] ;
         A37TipoConCod = P00L42_A37TipoConCod[0] ;
         A41ConDescrip = P00L42_A41ConDescrip[0] ;
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
         AV111GXV10 = 1 ;
         while ( AV111GXV10 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV111GXV10));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCUIL") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A239LegCUIL );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegId") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char10[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A93LegId, GXv_char10) ;
                  novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodigo") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char10[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A26ConCodigo, GXv_char10) ;
                  novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AgeCanti") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A110AgeCanti)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AgeImporte") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A113AgeImporte)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AgeFecDes") == 0 )
               {
                  GXt_dtime11 = GXutil.resetTime( A111AgeFecDes );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime11 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AgeFecHas") == 0 )
               {
                  GXt_dtime11 = GXutil.resetTime( A112AgeFecHas );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime11 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV111GXV10 = (int)(AV111GXV10+1) ;
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
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "LegCUIL", "", "CUIL", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "LegId", "", "Legajo Id.", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "LegNomApe", "", "Legajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "ConCodigo", "", "Concepto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "ConDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "TipoConCod", "", "Tipo", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgeCanti", "", "Cantidad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgePrevis", "", "Importe", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgePerDescrip", "", "Periodo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgeFecDes", "", "Desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgeFecHas", "", "Hasta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "AgeLiqNro", "", "Nro. Liq.", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      if ( (0==A1254AgeLiqNro) )
      {
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&ModificarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      if ( (0==A1254AgeLiqNro) )
      {
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "&EliminarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
      GXt_char9 = AV28UserCustomValue ;
      GXv_char10[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "NovedadesWWColumnsSelector", GXv_char10) ;
      novedadeswwexport.this.GXt_char9 = GXv_char10[0] ;
      AV28UserCustomValue = GXt_char9 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector12[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector12, GXv_SdtWWPColumnsSelector13) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector12[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("NovedadesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "NovedadesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("NovedadesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV112GXV11 = 1 ;
      while ( AV112GXV11 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV112GXV11));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "VERLIQUIDADAS") == 0 )
         {
            AV83VerLiquidadas = GXutil.boolval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV64TFLegId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV63TFLegId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV65TFLegId_Sels.fromJSonString(AV63TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV68TFLegNomApe = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV67TFLegNomApe_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV69TFLegNomApe_Sels.fromJSonString(AV67TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV40TFConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV39TFConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFConCodigo_Sels.fromJSonString(AV39TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV44TFConDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV43TFConDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFConDescrip_Sels.fromJSonString(AV43TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV47TFTipoConCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFTipoConCod_Sels.fromJSonString(AV47TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGECANTI") == 0 )
         {
            AV50TFAgeCanti = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV51TFAgeCanti_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP") == 0 )
         {
            AV95TFAgePerDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP_SEL") == 0 )
         {
            AV94TFAgePerDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV96TFAgePerDescrip_Sels.fromJSonString(AV94TFAgePerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES") == 0 )
         {
            AV56TFAgeFecDes = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES_SEL") == 0 )
         {
            AV84TFAgeFecDes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV85TFAgeFecDes_Sels.fromJSonString(AV84TFAgeFecDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS") == 0 )
         {
            AV58TFAgeFecHas = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS_SEL") == 0 )
         {
            AV87TFAgeFecHas_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV88TFAgeFecHas_Sels.fromJSonString(AV87TFAgeFecHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGELIQNRO") == 0 )
         {
            AV81TFAgeLiqNro = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV82TFAgeLiqNro_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV93MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV112GXV11 = (int)(AV112GXV11+1) ;
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
      this.aP0[0] = novedadeswwexport.this.AV12Filename;
      this.aP1[0] = novedadeswwexport.this.AV13ErrorMessage;
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
      GXv_boolean6 = new boolean[1] ;
      AV100Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV65TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66TFLegId_Sel = "" ;
      AV64TFLegId = "" ;
      AV69TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70TFLegNomApe_Sel = "" ;
      AV68TFLegNomApe = "" ;
      AV41TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFConCodigo_Sel = "" ;
      AV40TFConCodigo = "" ;
      AV45TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFConDescrip_Sel = "" ;
      AV44TFConDescrip = "" ;
      AV48TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFTipoConCod_Sel = "" ;
      AV50TFAgeCanti = DecimalUtil.ZERO ;
      AV51TFAgeCanti_To = DecimalUtil.ZERO ;
      AV96TFAgePerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97TFAgePerDescrip_Sel = "" ;
      AV95TFAgePerDescrip = "" ;
      AV85TFAgeFecDes_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV86TFAgeFecDes_Sel = GXutil.nullDate() ;
      AV56TFAgeFecDes = GXutil.nullDate() ;
      AV88TFAgeFecHas_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV89TFAgeFecHas_Sel = GXutil.nullDate() ;
      AV58TFAgeFecHas = GXutil.nullDate() ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV64TFLegId = "" ;
      lV68TFLegNomApe = "" ;
      lV40TFConCodigo = "" ;
      lV44TFConDescrip = "" ;
      lV95TFAgePerDescrip = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A2159AgePerDescrip = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      A110AgeCanti = DecimalUtil.ZERO ;
      P00L42_A6LegNumero = new int[1] ;
      P00L42_A1EmpCod = new short[1] ;
      P00L42_A3CliCod = new int[1] ;
      P00L42_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P00L42_n112AgeFecHas = new boolean[] {false} ;
      P00L42_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P00L42_n111AgeFecDes = new boolean[] {false} ;
      P00L42_A2159AgePerDescrip = new String[] {""} ;
      P00L42_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00L42_n110AgeCanti = new boolean[] {false} ;
      P00L42_A37TipoConCod = new String[] {""} ;
      P00L42_A41ConDescrip = new String[] {""} ;
      P00L42_A26ConCodigo = new String[] {""} ;
      P00L42_A591LegNomApe = new String[] {""} ;
      P00L42_A93LegId = new String[] {""} ;
      P00L42_n93LegId = new boolean[] {false} ;
      P00L42_A1254AgeLiqNro = new int[1] ;
      P00L42_n1254AgeLiqNro = new boolean[] {false} ;
      P00L42_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00L42_n113AgeImporte = new boolean[] {false} ;
      P00L42_A239LegCUIL = new long[1] ;
      P00L42_A25AgeOrden = new short[1] ;
      A113AgeImporte = DecimalUtil.ZERO ;
      GXt_dtime11 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char10 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV63TFLegId_SelsJson = "" ;
      AV67TFLegNomApe_SelsJson = "" ;
      AV39TFConCodigo_SelsJson = "" ;
      AV43TFConDescrip_SelsJson = "" ;
      AV47TFTipoConCod_SelsJson = "" ;
      AV94TFAgePerDescrip_SelsJson = "" ;
      AV84TFAgeFecDes_SelsJson = "" ;
      AV87TFAgeFecHas_SelsJson = "" ;
      AV93MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeswwexport__default(),
         new Object[] {
             new Object[] {
            P00L42_A6LegNumero, P00L42_A1EmpCod, P00L42_A3CliCod, P00L42_A112AgeFecHas, P00L42_n112AgeFecHas, P00L42_A111AgeFecDes, P00L42_n111AgeFecDes, P00L42_A2159AgePerDescrip, P00L42_A110AgeCanti, P00L42_n110AgeCanti,
            P00L42_A37TipoConCod, P00L42_A41ConDescrip, P00L42_A26ConCodigo, P00L42_A591LegNomApe, P00L42_A93LegId, P00L42_n93LegId, P00L42_A1254AgeLiqNro, P00L42_n1254AgeLiqNro, P00L42_A113AgeImporte, P00L42_n113AgeImporte,
            P00L42_A239LegCUIL, P00L42_A25AgeOrden
            }
         }
      );
      AV100Pgmname = "NovedadesWWExport" ;
      /* GeneXus formulas. */
      AV100Pgmname = "NovedadesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV62EmpCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short AV18OrderedBy ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV61CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV101GXV1 ;
   private int AV102GXV2 ;
   private int AV103GXV3 ;
   private int AV104GXV4 ;
   private int AV105GXV5 ;
   private int AV106GXV6 ;
   private int AV107GXV7 ;
   private int AV108GXV8 ;
   private int AV81TFAgeLiqNro ;
   private int AV82TFAgeLiqNro_To ;
   private int A1254AgeLiqNro ;
   private int AV109GXV9 ;
   private int AV65TFLegId_Sels_size ;
   private int AV69TFLegNomApe_Sels_size ;
   private int AV41TFConCodigo_Sels_size ;
   private int AV45TFConDescrip_Sels_size ;
   private int AV48TFTipoConCod_Sels_size ;
   private int AV96TFAgePerDescrip_Sels_size ;
   private int AV85TFAgeFecDes_Sels_size ;
   private int AV88TFAgeFecHas_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV111GXV10 ;
   private int AV112GXV11 ;
   private long AV60i ;
   private long AV32VisibleColumnCount ;
   private long A239LegCUIL ;
   private java.math.BigDecimal AV50TFAgeCanti ;
   private java.math.BigDecimal AV51TFAgeCanti_To ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A113AgeImporte ;
   private String AV100Pgmname ;
   private String AV66TFLegId_Sel ;
   private String AV64TFLegId ;
   private String AV42TFConCodigo_Sel ;
   private String AV40TFConCodigo ;
   private String AV49TFTipoConCod_Sel ;
   private String scmdbuf ;
   private String lV64TFLegId ;
   private String lV40TFConCodigo ;
   private String A93LegId ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String GXt_char9 ;
   private String GXv_char10[] ;
   private java.util.Date GXt_dtime11 ;
   private java.util.Date AV86TFAgeFecDes_Sel ;
   private java.util.Date AV56TFAgeFecDes ;
   private java.util.Date AV89TFAgeFecHas_Sel ;
   private java.util.Date AV58TFAgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV83VerLiquidadas ;
   private boolean AV19OrderedDsc ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n93LegId ;
   private boolean n1254AgeLiqNro ;
   private boolean n113AgeImporte ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV63TFLegId_SelsJson ;
   private String AV67TFLegNomApe_SelsJson ;
   private String AV39TFConCodigo_SelsJson ;
   private String AV43TFConDescrip_SelsJson ;
   private String AV47TFTipoConCod_SelsJson ;
   private String AV94TFAgePerDescrip_SelsJson ;
   private String AV84TFAgeFecDes_SelsJson ;
   private String AV87TFAgeFecHas_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV70TFLegNomApe_Sel ;
   private String AV68TFLegNomApe ;
   private String AV46TFConDescrip_Sel ;
   private String AV44TFConDescrip ;
   private String AV97TFAgePerDescrip_Sel ;
   private String AV95TFAgePerDescrip ;
   private String lV68TFLegNomApe ;
   private String lV44TFConDescrip ;
   private String lV95TFAgePerDescrip ;
   private String A591LegNomApe ;
   private String A41ConDescrip ;
   private String A2159AgePerDescrip ;
   private String AV93MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV65TFLegId_Sels ;
   private GXSimpleCollection<String> AV41TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV48TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV69TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV45TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV96TFAgePerDescrip_Sels ;
   private GXSimpleCollection<java.util.Date> AV85TFAgeFecDes_Sels ;
   private GXSimpleCollection<java.util.Date> AV88TFAgeFecHas_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00L42_A6LegNumero ;
   private short[] P00L42_A1EmpCod ;
   private int[] P00L42_A3CliCod ;
   private java.util.Date[] P00L42_A112AgeFecHas ;
   private boolean[] P00L42_n112AgeFecHas ;
   private java.util.Date[] P00L42_A111AgeFecDes ;
   private boolean[] P00L42_n111AgeFecDes ;
   private String[] P00L42_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P00L42_A110AgeCanti ;
   private boolean[] P00L42_n110AgeCanti ;
   private String[] P00L42_A37TipoConCod ;
   private String[] P00L42_A41ConDescrip ;
   private String[] P00L42_A26ConCodigo ;
   private String[] P00L42_A591LegNomApe ;
   private String[] P00L42_A93LegId ;
   private boolean[] P00L42_n93LegId ;
   private int[] P00L42_A1254AgeLiqNro ;
   private boolean[] P00L42_n1254AgeLiqNro ;
   private java.math.BigDecimal[] P00L42_A113AgeImporte ;
   private boolean[] P00L42_n113AgeImporte ;
   private long[] P00L42_A239LegCUIL ;
   private short[] P00L42_A25AgeOrden ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class novedadeswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00L42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV65TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV69TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV41TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV45TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV48TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV96TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV85TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV88TFAgeFecHas_Sels ,
                                          boolean AV83VerLiquidadas ,
                                          int AV65TFLegId_Sels_size ,
                                          String AV64TFLegId ,
                                          int AV69TFLegNomApe_Sels_size ,
                                          String AV68TFLegNomApe ,
                                          int AV41TFConCodigo_Sels_size ,
                                          String AV40TFConCodigo ,
                                          int AV45TFConDescrip_Sels_size ,
                                          String AV44TFConDescrip ,
                                          int AV48TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV50TFAgeCanti ,
                                          java.math.BigDecimal AV51TFAgeCanti_To ,
                                          int AV96TFAgePerDescrip_Sels_size ,
                                          String AV95TFAgePerDescrip ,
                                          int AV85TFAgeFecDes_Sels_size ,
                                          int AV88TFAgeFecHas_Sels_size ,
                                          int AV81TFAgeLiqNro ,
                                          int AV82TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV61CliCod ,
                                          short AV62EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[11];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeImporte, T2.LegCUIL, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero" ;
      scmdbuf += " = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! AV83VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV65TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV65TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV69TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV69TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV41TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV41TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV45TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV45TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV48TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ( AV96TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV95TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV96TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV85TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV88TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV81TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! (0==AV82TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.AgeFecDes DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.LegCUIL" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.LegCUIL DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.LegId" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.LegId DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.ConDescrip" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.ConDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.TipoConCod" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.TipoConCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.AgeCanti" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.AgeCanti DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.AgePerDescrip" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.AgePerDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.AgeFecDes" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.AgeFecDes DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.AgeFecHas" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.AgeFecHas DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.AgeLiqNro" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.AgeLiqNro DESC" ;
      }
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P00L42(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00L42", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(14,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((long[]) buf[20])[0] = rslt.getLong(15);
               ((short[]) buf[21])[0] = rslt.getShort(16);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
      }
   }

}

