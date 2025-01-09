package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacion_export3export extends GXProcedure
{
   public liquidacion_export3export( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_export3export.class ), "" );
   }

   public liquidacion_export3export( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacion_export3export.this.aP1 = new String[] {""};
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
      liquidacion_export3export.this.aP0 = aP0;
      liquidacion_export3export.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
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
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "liquidacion_export3Export-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFLegId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "ID", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV132GXV1 = 1 ;
         while ( AV132GXV1 <= AV38TFLegId_Sels.size() )
         {
            AV39TFLegId_Sel = (String)AV38TFLegId_Sels.elementAt(-1+AV132GXV1) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFLegId_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV132GXV1 = (int)(AV132GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFLegId)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "ID", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFLegId, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV111TFLegNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Apellido y nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV133GXV2 = 1 ;
         while ( AV133GXV2 <= AV111TFLegNomApe_Sels.size() )
         {
            AV112TFLegNomApe_Sel = (String)AV111TFLegNomApe_Sels.elementAt(-1+AV133GXV2) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV112TFLegNomApe_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV133GXV2 = (int)(AV133GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV110TFLegNomApe)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Apellido y nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV110TFLegNomApe, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV42TFLiqNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Liq. nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV134GXV3 = 1 ;
         while ( AV134GXV3 <= AV42TFLiqNombre_Sels.size() )
         {
            AV43TFLiqNombre_Sel = (String)AV42TFLiqNombre_Sels.elementAt(-1+AV134GXV3) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFLiqNombre_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV134GXV3 = (int)(AV134GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFLiqNombre)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Liq. nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFLiqNombre, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV46TFSecDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Area", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV135GXV4 = 1 ;
         while ( AV135GXV4 <= AV46TFSecDescrip_Sels.size() )
         {
            AV47TFSecDescrip_Sel = (String)AV46TFSecDescrip_Sels.elementAt(-1+AV135GXV4) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFSecDescrip_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV135GXV4 = (int)(AV135GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFSecDescrip)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Area", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFSecDescrip, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV122TFLegOsoDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Obra social desc.", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV136GXV5 = 1 ;
         while ( AV136GXV5 <= AV122TFLegOsoDes_Sels.size() )
         {
            AV123TFLegOsoDes_Sel = (String)AV122TFLegOsoDes_Sels.elementAt(-1+AV136GXV5) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV123TFLegOsoDes_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV136GXV5 = (int)(AV136GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV121TFLegOsoDes)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Obra social desc.", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV121TFLegOsoDes, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV56TFLegCuentaBanc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Cuenta banco", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV137GXV6 = 1 ;
         while ( AV137GXV6 <= AV56TFLegCuentaBanc_Sels.size() )
         {
            AV57TFLegCuentaBanc_Sel = (String)AV56TFLegCuentaBanc_Sels.elementAt(-1+AV137GXV6) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFLegCuentaBanc_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV137GXV6 = (int)(AV137GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFLegCuentaBanc)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Cuenta banco", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFLegCuentaBanc, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV125TFLegModTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Relación", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV138GXV7 = 1 ;
         while ( AV138GXV7 <= AV125TFLegModTra_Sels.size() )
         {
            AV126TFLegModTra_Sel = (String)AV125TFLegModTra_Sels.elementAt(-1+AV138GXV7) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV126TFLegModTra_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV138GXV7 = (int)(AV138GXV7+1) ;
         }
      }
      if ( ! ( ( AV59TFLegClase_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV139GXV8 = 1 ;
         while ( AV139GXV8 <= AV59TFLegClase_Sels.size() )
         {
            AV60TFLegClase_Sel = ((Number) AV59TFLegClase_Sels.elementAt(-1+AV139GXV8)).byteValue() ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV60TFLegClase_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV139GXV8 = (int)(AV139GXV8+1) ;
         }
      }
      if ( ! ( ( AV128TFLegTipoTarifa_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de tarifa", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV140GXV9 = 1 ;
         while ( AV140GXV9 <= AV128TFLegTipoTarifa_Sels.size() )
         {
            AV129TFLegTipoTarifa_Sel = (String)AV128TFLegTipoTarifa_Sels.elementAt(-1+AV140GXV9) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV129TFLegTipoTarifa_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV140GXV9 = (int)(AV140GXV9+1) ;
         }
      }
      if ( ! ( ( AV67TFLiqDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Observación liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV141GXV10 = 1 ;
         while ( AV141GXV10 <= AV67TFLiqDescrip_Sels.size() )
         {
            AV68TFLiqDescrip_Sel = (String)AV67TFLiqDescrip_Sels.elementAt(-1+AV141GXV10) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68TFLiqDescrip_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV141GXV10 = (int)(AV141GXV10+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV66TFLiqDescrip)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Observación liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFLiqDescrip, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV71TFLiqFecha_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV142GXV11 = 1 ;
         while ( AV142GXV11 <= AV71TFLiqFecha_Sels.size() )
         {
            AV72TFLiqFecha_Sel = (java.util.Date)AV71TFLiqFecha_Sels.elementAt(-1+AV142GXV11) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( AV72TFLiqFecha_Sel, "99/99/9999") );
            AV106i = (long)(AV106i+1) ;
            AV142GXV11 = (int)(AV142GXV11+1) ;
         }
      }
      else
      {
         if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV70TFLiqFecha)) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha liq.", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_dtime6 = GXutil.resetTime( AV70TFLiqFecha );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         }
      }
      if ( ! ( ( AV75TFLiqPerSinDia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV143GXV12 = 1 ;
         while ( AV143GXV12 <= AV75TFLiqPerSinDia_Sels.size() )
         {
            AV76TFLiqPerSinDia_Sel = (String)AV75TFLiqPerSinDia_Sels.elementAt(-1+AV143GXV12) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFLiqPerSinDia_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV143GXV12 = (int)(AV143GXV12+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV74TFLiqPerSinDia)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV74TFLiqPerSinDia, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV79TFTliqDesc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV144GXV13 = 1 ;
         while ( AV144GXV13 <= AV79TFTliqDesc_Sels.size() )
         {
            AV80TFTliqDesc_Sel = (String)AV79TFTliqDesc_Sels.elementAt(-1+AV144GXV13) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV80TFTliqDesc_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV144GXV13 = (int)(AV144GXV13+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV78TFTliqDesc)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo liq.", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV78TFTliqDesc, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV83TFLiqFecPago_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV145GXV14 = 1 ;
         while ( AV145GXV14 <= AV83TFLiqFecPago_Sels.size() )
         {
            AV84TFLiqFecPago_Sel = (java.util.Date)AV83TFLiqFecPago_Sels.elementAt(-1+AV145GXV14) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( AV84TFLiqFecPago_Sel, "99/99/9999") );
            AV106i = (long)(AV106i+1) ;
            AV145GXV14 = (int)(AV145GXV14+1) ;
         }
      }
      else
      {
         if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV82TFLiqFecPago)) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha pago", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_dtime6 = GXutil.resetTime( AV82TFLiqFecPago );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         }
      }
      if ( ! ( ( AV87TFDConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto cod.", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV146GXV15 = 1 ;
         while ( AV146GXV15 <= AV87TFDConCodigo_Sels.size() )
         {
            AV88TFDConCodigo_Sel = (String)AV87TFDConCodigo_Sels.elementAt(-1+AV146GXV15) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV88TFDConCodigo_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV146GXV15 = (int)(AV146GXV15+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV86TFDConCodigo)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto cod.", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV86TFDConCodigo, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV91TFDConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto desc.", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV147GXV16 = 1 ;
         while ( AV147GXV16 <= AV91TFDConDescrip_Sels.size() )
         {
            AV92TFDConDescrip_Sel = (String)AV91TFDConDescrip_Sels.elementAt(-1+AV147GXV16) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV92TFDConDescrip_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV147GXV16 = (int)(AV147GXV16+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV90TFDConDescrip)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto desc.", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV90TFDConDescrip, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV94TFDTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de concepto", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV148GXV17 = 1 ;
         while ( AV148GXV17 <= AV94TFDTipoConCod_Sels.size() )
         {
            AV95TFDTipoConCod_Sel = (String)AV94TFDTipoConCod_Sels.elementAt(-1+AV148GXV17) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV95TFDTipoConCod_Sel), "") );
            AV106i = (long)(AV106i+1) ;
            AV148GXV17 = (int)(AV148GXV17+1) ;
         }
      }
      if ( ! ( ( AV98TFConClasifAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV149GXV18 = 1 ;
         while ( AV149GXV18 <= AV98TFConClasifAux_Sels.size() )
         {
            AV99TFConClasifAux_Sel = (String)AV98TFConClasifAux_Sels.elementAt(-1+AV149GXV18) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV99TFConClasifAux_Sel, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV149GXV18 = (int)(AV149GXV18+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV97TFConClasifAux)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV97TFConClasifAux, GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100TFLiqDCanti)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101TFLiqDCanti_To)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV100TFLiqDCanti)) );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV101TFLiqDCanti_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104TFLiqDImpCalcu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105TFLiqDImpCalcu_To)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Importe original", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV104TFLiqDImpCalcu)) );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV105TFLiqDImpCalcu_To)) );
      }
      if ( ! ( ( AV117TFLiqDLogRecal_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Log", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV106i = 1 ;
         AV150GXV19 = 1 ;
         while ( AV150GXV19 <= AV117TFLiqDLogRecal_Sels.size() )
         {
            AV118TFLiqDLogRecal_Sel = (String)AV117TFLiqDLogRecal_Sels.elementAt(-1+AV150GXV19) ;
            if ( AV106i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV118TFLiqDLogRecal_Sel, 1, 1000), GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV106i = (long)(AV106i+1) ;
            AV150GXV19 = (int)(AV150GXV19+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV116TFLiqDLogRecal)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Log", "")) ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV116TFLiqDLogRecal, 1, 1000), GXv_char5) ;
            liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqDImpReCalcu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqDImpReCalcu_To)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Importe", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV102TFLiqDImpReCalcu)) );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         liquidacion_export3export.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV103TFLiqDImpReCalcu_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("liquidacion_export3ColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("liquidacion_export3ColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+38)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV151GXV20 = 1 ;
      while ( AV151GXV20 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV151GXV20));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV151GXV20 = (int)(AV151GXV20+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV38TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV111TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV42TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV46TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV122TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV56TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV125TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV59TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV128TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV67TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV71TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV75TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV79TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV83TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV87TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV91TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV94TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV117TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV38TFLegId_Sels.size()) ,
                                           AV37TFLegId ,
                                           Integer.valueOf(AV111TFLegNomApe_Sels.size()) ,
                                           AV110TFLegNomApe ,
                                           Integer.valueOf(AV42TFLiqNombre_Sels.size()) ,
                                           AV41TFLiqNombre ,
                                           Integer.valueOf(AV46TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV122TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV56TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV125TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV59TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV128TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV67TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV71TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV75TFLiqPerSinDia_Sels.size()) ,
                                           AV74TFLiqPerSinDia ,
                                           Integer.valueOf(AV79TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV83TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV87TFDConCodigo_Sels.size()) ,
                                           AV86TFDConCodigo ,
                                           Integer.valueOf(AV91TFDConDescrip_Sels.size()) ,
                                           AV90TFDConDescrip ,
                                           Integer.valueOf(AV94TFDTipoConCod_Sels.size()) ,
                                           AV100TFLiqDCanti ,
                                           AV101TFLiqDCanti_To ,
                                           AV104TFLiqDImpCalcu ,
                                           AV105TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV117TFLiqDLogRecal_Sels.size()) ,
                                           AV116TFLiqDLogRecal ,
                                           AV102TFLiqDImpReCalcu ,
                                           AV103TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           Integer.valueOf(AV107CliCod) ,
                                           Short.valueOf(AV108EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV37TFLegId = GXutil.padr( GXutil.rtrim( AV37TFLegId), 20, "%") ;
      lV110TFLegNomApe = GXutil.concat( GXutil.rtrim( AV110TFLegNomApe), "%", "") ;
      lV41TFLiqNombre = GXutil.concat( GXutil.rtrim( AV41TFLiqNombre), "%", "") ;
      lV74TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV74TFLiqPerSinDia), 20, "%") ;
      lV86TFDConCodigo = GXutil.padr( GXutil.rtrim( AV86TFDConCodigo), 10, "%") ;
      lV90TFDConDescrip = GXutil.concat( GXutil.rtrim( AV90TFDConDescrip), "%", "") ;
      lV116TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV116TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01MA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV107CliCod), Short.valueOf(AV108EmpCod), lV37TFLegId, lV110TFLegNomApe, lV41TFLiqNombre, lV74TFLiqPerSinDia, lV86TFDConCodigo, lV90TFDConDescrip, AV100TFLiqDCanti, AV101TFLiqDCanti_To, AV104TFLiqDImpCalcu, AV105TFLiqDImpCalcu_To, lV116TFLiqDLogRecal, AV102TFLiqDImpReCalcu, AV103TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20ZonCod = P01MA2_A20ZonCod[0] ;
         n20ZonCod = P01MA2_n20ZonCod[0] ;
         A1583LegMegCodigo = P01MA2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P01MA2_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = P01MA2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01MA2_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01MA2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01MA2_n1579LegSecCodigo[0] ;
         A1582LegBanCod = P01MA2_A1582LegBanCod[0] ;
         n1582LegBanCod = P01MA2_n1582LegBanCod[0] ;
         A32TLiqCod = P01MA2_A32TLiqCod[0] ;
         n32TLiqCod = P01MA2_n32TLiqCod[0] ;
         A1EmpCod = P01MA2_A1EmpCod[0] ;
         A3CliCod = P01MA2_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01MA2_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01MA2_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01MA2_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01MA2_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01MA2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01MA2_n269LiqDCanti[0] ;
         A464DTipoConCod = P01MA2_A464DTipoConCod[0] ;
         A393DConDescrip = P01MA2_A393DConDescrip[0] ;
         A394DConCodigo = P01MA2_A394DConCodigo[0] ;
         A280LiqFecPago = P01MA2_A280LiqFecPago[0] ;
         A340TliqDesc = P01MA2_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01MA2_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01MA2_A98LiqFecha[0] ;
         A271LiqDescrip = P01MA2_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01MA2_A2417LegTipoTarifa[0] ;
         A235LegClase = P01MA2_A235LegClase[0] ;
         A2404LegModTra = P01MA2_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01MA2_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01MA2_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01MA2_A2225LegOsoDes[0] ;
         A329SecDescrip = P01MA2_A329SecDescrip[0] ;
         n329SecDescrip = P01MA2_n329SecDescrip[0] ;
         A874LiqNombre = P01MA2_A874LiqNombre[0] ;
         A591LegNomApe = P01MA2_A591LegNomApe[0] ;
         A93LegId = P01MA2_A93LegId[0] ;
         n93LegId = P01MA2_n93LegId[0] ;
         A239LegCUIL = P01MA2_A239LegCUIL[0] ;
         A342ZonDescrip = P01MA2_A342ZonDescrip[0] ;
         A248LegFormaPago = P01MA2_A248LegFormaPago[0] ;
         A15LegActCodigo = P01MA2_A15LegActCodigo[0] ;
         n15LegActCodigo = P01MA2_n15LegActCodigo[0] ;
         A2226LegOsoAfipCod = P01MA2_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = P01MA2_n2226LegOsoAfipCod[0] ;
         A910LegSinCod = P01MA2_A910LegSinCod[0] ;
         n910LegSinCod = P01MA2_n910LegSinCod[0] ;
         A245LegFecIngreso = P01MA2_A245LegFecIngreso[0] ;
         A244LegFecEgreso = P01MA2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P01MA2_n244LegFecEgreso[0] ;
         A300MegDescrip = P01MA2_A300MegDescrip[0] ;
         n300MegDescrip = P01MA2_n300MegDescrip[0] ;
         A234LegCBU = P01MA2_A234LegCBU[0] ;
         n234LegCBU = P01MA2_n234LegCBU[0] ;
         A2224LegBanDes = P01MA2_A2224LegBanDes[0] ;
         A232LegBanTipCuen = P01MA2_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = P01MA2_n232LegBanTipCuen[0] ;
         A231LegBanSuc = P01MA2_A231LegBanSuc[0] ;
         n231LegBanSuc = P01MA2_n231LegBanSuc[0] ;
         A236LegCodPos = P01MA2_A236LegCodPos[0] ;
         A263LegSexo = P01MA2_A263LegSexo[0] ;
         n263LegSexo = P01MA2_n263LegSexo[0] ;
         A246LegFecNac = P01MA2_A246LegFecNac[0] ;
         A262LegSCVO = P01MA2_A262LegSCVO[0] ;
         A876LiqDReFormulaHTML = P01MA2_A876LiqDReFormulaHTML[0] ;
         n876LiqDReFormulaHTML = P01MA2_n876LiqDReFormulaHTML[0] ;
         A508LiqDFormulaHTML = P01MA2_A508LiqDFormulaHTML[0] ;
         n508LiqDFormulaHTML = P01MA2_n508LiqDFormulaHTML[0] ;
         A270LiqDErrorDesc = P01MA2_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01MA2_n270LiqDErrorDesc[0] ;
         A6LegNumero = P01MA2_A6LegNumero[0] ;
         A31LiqNro = P01MA2_A31LiqNro[0] ;
         A81LiqDSecuencial = P01MA2_A81LiqDSecuencial[0] ;
         A20ZonCod = P01MA2_A20ZonCod[0] ;
         n20ZonCod = P01MA2_n20ZonCod[0] ;
         A1583LegMegCodigo = P01MA2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P01MA2_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = P01MA2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01MA2_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01MA2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01MA2_n1579LegSecCodigo[0] ;
         A1582LegBanCod = P01MA2_A1582LegBanCod[0] ;
         n1582LegBanCod = P01MA2_n1582LegBanCod[0] ;
         A2417LegTipoTarifa = P01MA2_A2417LegTipoTarifa[0] ;
         A235LegClase = P01MA2_A235LegClase[0] ;
         A2404LegModTra = P01MA2_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01MA2_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01MA2_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01MA2_A591LegNomApe[0] ;
         A93LegId = P01MA2_A93LegId[0] ;
         n93LegId = P01MA2_n93LegId[0] ;
         A239LegCUIL = P01MA2_A239LegCUIL[0] ;
         A248LegFormaPago = P01MA2_A248LegFormaPago[0] ;
         A15LegActCodigo = P01MA2_A15LegActCodigo[0] ;
         n15LegActCodigo = P01MA2_n15LegActCodigo[0] ;
         A910LegSinCod = P01MA2_A910LegSinCod[0] ;
         n910LegSinCod = P01MA2_n910LegSinCod[0] ;
         A245LegFecIngreso = P01MA2_A245LegFecIngreso[0] ;
         A244LegFecEgreso = P01MA2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P01MA2_n244LegFecEgreso[0] ;
         A234LegCBU = P01MA2_A234LegCBU[0] ;
         n234LegCBU = P01MA2_n234LegCBU[0] ;
         A232LegBanTipCuen = P01MA2_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = P01MA2_n232LegBanTipCuen[0] ;
         A231LegBanSuc = P01MA2_A231LegBanSuc[0] ;
         n231LegBanSuc = P01MA2_n231LegBanSuc[0] ;
         A236LegCodPos = P01MA2_A236LegCodPos[0] ;
         A263LegSexo = P01MA2_A263LegSexo[0] ;
         n263LegSexo = P01MA2_n263LegSexo[0] ;
         A246LegFecNac = P01MA2_A246LegFecNac[0] ;
         A262LegSCVO = P01MA2_A262LegSCVO[0] ;
         A342ZonDescrip = P01MA2_A342ZonDescrip[0] ;
         A300MegDescrip = P01MA2_A300MegDescrip[0] ;
         n300MegDescrip = P01MA2_n300MegDescrip[0] ;
         A2225LegOsoDes = P01MA2_A2225LegOsoDes[0] ;
         A2226LegOsoAfipCod = P01MA2_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = P01MA2_n2226LegOsoAfipCod[0] ;
         A329SecDescrip = P01MA2_A329SecDescrip[0] ;
         n329SecDescrip = P01MA2_n329SecDescrip[0] ;
         A2224LegBanDes = P01MA2_A2224LegBanDes[0] ;
         A32TLiqCod = P01MA2_A32TLiqCod[0] ;
         n32TLiqCod = P01MA2_n32TLiqCod[0] ;
         A280LiqFecPago = P01MA2_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01MA2_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01MA2_A98LiqFecha[0] ;
         A271LiqDescrip = P01MA2_A271LiqDescrip[0] ;
         A874LiqNombre = P01MA2_A874LiqNombre[0] ;
         A340TliqDesc = P01MA2_A340TliqDesc[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV153GXV21 = 1 ;
         while ( AV153GXV21 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV153GXV21));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegId") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A93LegId, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegNomApe") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A591LegNomApe, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCUIL") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A239LegCUIL );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNombre") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A874LiqNombre, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SecDescrip") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ZonDescrip") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A342ZonDescrip, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegFormaPago") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainformadepago.getDescription(httpContext,(byte)A248LegFormaPago), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegActCodigo") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A15LegActCodigo, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegOsoDes") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2225LegOsoDes, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegOsoAfipCod") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2226LegOsoAfipCod, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegSinCod") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A910LegSinCod, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegFecIngreso") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A245LegFecIngreso );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegFecEgreso") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A244LegFecEgreso );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegDescrip") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A300MegDescrip, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCBU") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A234LegCBU, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegBanDes") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2224LegBanDes, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegBanTipCuen") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipocuentabanco.getDescription(httpContext,(String)A232LegBanTipCuen), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegBanSuc") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A231LegBanSuc, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuentaBanc") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A238LegCuentaBanc, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegModTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)A2404LegModTra), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegClase") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A235LegClase), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegTipoTarifa") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)A2417LegTipoTarifa), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCodPos") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A236LegCodPos, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegSexo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A263LegSexo );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegFecNac") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A246LegFecNac );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegSCVO") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A262LegSCVO) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNro") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A31LiqNro );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDescrip") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A271LiqDescrip, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecha") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A98LiqFecha );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqPerSinDia") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A513LiqPerSinDia, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TliqDesc") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A340TliqDesc, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecPago") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A280LiqFecPago );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DConCodigo") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A394DConCodigo, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DConDescrip") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A393DConDescrip, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DTipoConCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)A464DTipoConCod), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDCanti") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A269LiqDCanti)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDImpCalcu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A275LiqDImpCalcu)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDReFormulaHTML") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A876LiqDReFormulaHTML, 1, 1000), GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDFormulaHTML") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A508LiqDFormulaHTML, 1, 1000), GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDLogRecal") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1072LiqDLogRecal, 1, 1000), GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDErrorDesc") == 0 )
               {
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A270LiqDErrorDesc, GXv_char5) ;
                  liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char4 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDImpReCalcu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A764LiqDImpReCalcu)) );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV153GXV21 = (int)(AV153GXV21+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegId", "", "ID", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegNomApe", "", "Apellido y nombre", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegCUIL", "", "CUIL", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqNombre", "", "Liq. nombre", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "&ConveDescri", "", "Convenio", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "&CatDescrip", "", "Categoría", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "SecDescrip", "", "Area", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ZonDescrip", "", "Zona", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegFormaPago", "", "Forma de pago", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegActCodigo", "", "Actividad", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegOsoDes", "", "Obra social desc.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegOsoAfipCod", "", "Obra social cod.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegSinCod", "", "Sindicato cod.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegFecIngreso", "", "Fecha Ing.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegFecEgreso", "", "Fecha Egr.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "MegDescrip", "", "Motivo de egreso", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegCBU", "", "CBU", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegBanDes", "", "Banco", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegBanTipCuen", "", "Tipo de cuenta", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegBanSuc", "", "Sucursal", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegCuentaBanc", "", "Cuenta banco", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegModTra", "", "Relación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegClase", "", "Frecuencia de pago", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegTipoTarifa", "", "Tipo de tarifa", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegCodPos", "", "Cod. pos.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegSexo", "", "Género", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegFecNac", "", "Fecha nac.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LegSCVO", "", "Seguro Colectivo Vida Obligatorio", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqNro", "", "Nro. liquidación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDescrip", "", "Observación liquidación", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqFecha", "", "Fecha liq.", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqPerSinDia", "", "Periodo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "TliqDesc", "", "Tipo liq.", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqFecPago", "", "Fecha pago", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "DConCodigo", "", "Concepto cod.", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "DConDescrip", "", "Concepto desc.", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "DTipoConCod", "", "Tipo de concepto", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "&ConClasifAux", "", "Clasificación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDCanti", "", "Cantidad", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDImpCalcu", "", "Importe original", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDReFormulaHTML", "", "Fórmula", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDFormulaHTML", "", "Fórmula original", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDLogRecal", "", "Log", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDErrorDesc", "", "Error", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "LiqDImpReCalcu", "", "Importe", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV29UserCustomValue ;
      GXv_char5[0] = GXt_char4 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "liquidacion_export3ColumnsSelector", GXv_char5) ;
      liquidacion_export3export.this.GXt_char4 = GXv_char5[0] ;
      AV29UserCustomValue = GXt_char4 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector7[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, GXv_SdtWWPColumnsSelector8) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector7[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("liquidacion_export3GridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "liquidacion_export3GridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("liquidacion_export3GridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV154GXV22 = 1 ;
      while ( AV154GXV22 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV154GXV22));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV37TFLegId = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV36TFLegId_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFLegId_Sels.fromJSonString(AV36TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV110TFLegNomApe = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV109TFLegNomApe_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV111TFLegNomApe_Sels.fromJSonString(AV109TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV41TFLiqNombre = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV40TFLiqNombre_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFLiqNombre_Sels.fromJSonString(AV40TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV45TFSecDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV44TFSecDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFSecDescrip_Sels.fromJSonString(AV44TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES") == 0 )
         {
            AV121TFLegOsoDes = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES_SEL") == 0 )
         {
            AV120TFLegOsoDes_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV122TFLegOsoDes_Sels.fromJSonString(AV120TFLegOsoDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC") == 0 )
         {
            AV55TFLegCuentaBanc = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC_SEL") == 0 )
         {
            AV54TFLegCuentaBanc_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFLegCuentaBanc_Sels.fromJSonString(AV54TFLegCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGMODTRA_SEL") == 0 )
         {
            AV124TFLegModTra_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV125TFLegModTra_Sels.fromJSonString(AV124TFLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCLASE_SEL") == 0 )
         {
            AV58TFLegClase_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFLegClase_Sels.fromJSonString(AV58TFLegClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGTIPOTARIFA_SEL") == 0 )
         {
            AV127TFLegTipoTarifa_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV128TFLegTipoTarifa_Sels.fromJSonString(AV127TFLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV66TFLiqDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV65TFLiqDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFLiqDescrip_Sels.fromJSonString(AV65TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV70TFLiqFecha = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA_SEL") == 0 )
         {
            AV69TFLiqFecha_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV71TFLiqFecha_Sels.fromJSonString(AV69TFLiqFecha_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA") == 0 )
         {
            AV74TFLiqPerSinDia = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA_SEL") == 0 )
         {
            AV73TFLiqPerSinDia_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV75TFLiqPerSinDia_Sels.fromJSonString(AV73TFLiqPerSinDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC") == 0 )
         {
            AV78TFTliqDesc = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC_SEL") == 0 )
         {
            AV77TFTliqDesc_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV79TFTliqDesc_Sels.fromJSonString(AV77TFTliqDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV82TFLiqFecPago = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO_SEL") == 0 )
         {
            AV81TFLiqFecPago_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV83TFLiqFecPago_Sels.fromJSonString(AV81TFLiqFecPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV86TFDConCodigo = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV85TFDConCodigo_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV87TFDConCodigo_Sels.fromJSonString(AV85TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV90TFDConDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV89TFDConDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV91TFDConDescrip_Sels.fromJSonString(AV89TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV93TFDTipoConCod_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV94TFDTipoConCod_Sels.fromJSonString(AV93TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV97TFConClasifAux = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV96TFConClasifAux_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV98TFConClasifAux_Sels.fromJSonString(AV96TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCANTI") == 0 )
         {
            AV100TFLiqDCanti = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV101TFLiqDCanti_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPCALCU") == 0 )
         {
            AV104TFLiqDImpCalcu = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV105TFLiqDImpCalcu_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL") == 0 )
         {
            AV116TFLiqDLogRecal = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL_SEL") == 0 )
         {
            AV115TFLiqDLogRecal_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV117TFLiqDLogRecal_Sels.fromJSonString(AV115TFLiqDLogRecal_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV102TFLiqDImpReCalcu = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV103TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV119MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV154GXV22 = (int)(AV154GXV22+1) ;
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
      this.aP0[0] = liquidacion_export3export.this.AV12Filename;
      this.aP1[0] = liquidacion_export3export.this.AV13ErrorMessage;
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
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFLegId_Sel = "" ;
      AV37TFLegId = "" ;
      AV111TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV112TFLegNomApe_Sel = "" ;
      AV110TFLegNomApe = "" ;
      AV42TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFLiqNombre_Sel = "" ;
      AV41TFLiqNombre = "" ;
      AV46TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFSecDescrip_Sel = "" ;
      AV45TFSecDescrip = "" ;
      AV122TFLegOsoDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123TFLegOsoDes_Sel = "" ;
      AV121TFLegOsoDes = "" ;
      AV56TFLegCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFLegCuentaBanc_Sel = "" ;
      AV55TFLegCuentaBanc = "" ;
      AV125TFLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV126TFLegModTra_Sel = "" ;
      AV59TFLegClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV128TFLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV129TFLegTipoTarifa_Sel = "" ;
      AV67TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFLiqDescrip_Sel = "" ;
      AV66TFLiqDescrip = "" ;
      AV71TFLiqFecha_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV72TFLiqFecha_Sel = GXutil.nullDate() ;
      AV70TFLiqFecha = GXutil.nullDate() ;
      AV75TFLiqPerSinDia_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFLiqPerSinDia_Sel = "" ;
      AV74TFLiqPerSinDia = "" ;
      AV79TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFTliqDesc_Sel = "" ;
      AV78TFTliqDesc = "" ;
      AV83TFLiqFecPago_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV84TFLiqFecPago_Sel = GXutil.nullDate() ;
      AV82TFLiqFecPago = GXutil.nullDate() ;
      AV87TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88TFDConCodigo_Sel = "" ;
      AV86TFDConCodigo = "" ;
      AV91TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92TFDConDescrip_Sel = "" ;
      AV90TFDConDescrip = "" ;
      AV94TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV95TFDTipoConCod_Sel = "" ;
      AV98TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV99TFConClasifAux_Sel = "" ;
      AV97TFConClasifAux = "" ;
      AV100TFLiqDCanti = DecimalUtil.ZERO ;
      AV101TFLiqDCanti_To = DecimalUtil.ZERO ;
      AV104TFLiqDImpCalcu = DecimalUtil.ZERO ;
      AV105TFLiqDImpCalcu_To = DecimalUtil.ZERO ;
      AV117TFLiqDLogRecal_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV118TFLiqDLogRecal_Sel = "" ;
      AV116TFLiqDLogRecal = "" ;
      AV102TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV103TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      GXv_exceldoc2 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int3 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV37TFLegId = "" ;
      lV110TFLegNomApe = "" ;
      lV41TFLiqNombre = "" ;
      lV74TFLiqPerSinDia = "" ;
      lV86TFDConCodigo = "" ;
      lV90TFDConDescrip = "" ;
      lV116TFLiqDLogRecal = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A874LiqNombre = "" ;
      A329SecDescrip = "" ;
      A2225LegOsoDes = "" ;
      A238LegCuentaBanc = "" ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A513LiqPerSinDia = "" ;
      A340TliqDesc = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A464DTipoConCod = "" ;
      A1072LiqDLogRecal = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P01MA2_A20ZonCod = new String[] {""} ;
      P01MA2_n20ZonCod = new boolean[] {false} ;
      P01MA2_A1583LegMegCodigo = new String[] {""} ;
      P01MA2_n1583LegMegCodigo = new boolean[] {false} ;
      P01MA2_A1580LegOsoCod = new String[] {""} ;
      P01MA2_n1580LegOsoCod = new boolean[] {false} ;
      P01MA2_A1579LegSecCodigo = new String[] {""} ;
      P01MA2_n1579LegSecCodigo = new boolean[] {false} ;
      P01MA2_A1582LegBanCod = new String[] {""} ;
      P01MA2_n1582LegBanCod = new boolean[] {false} ;
      P01MA2_A32TLiqCod = new String[] {""} ;
      P01MA2_n32TLiqCod = new boolean[] {false} ;
      P01MA2_A1EmpCod = new short[1] ;
      P01MA2_A3CliCod = new int[1] ;
      P01MA2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01MA2_A1072LiqDLogRecal = new String[] {""} ;
      P01MA2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01MA2_n275LiqDImpCalcu = new boolean[] {false} ;
      P01MA2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01MA2_n269LiqDCanti = new boolean[] {false} ;
      P01MA2_A464DTipoConCod = new String[] {""} ;
      P01MA2_A393DConDescrip = new String[] {""} ;
      P01MA2_A394DConCodigo = new String[] {""} ;
      P01MA2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01MA2_A340TliqDesc = new String[] {""} ;
      P01MA2_A513LiqPerSinDia = new String[] {""} ;
      P01MA2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01MA2_A271LiqDescrip = new String[] {""} ;
      P01MA2_A2417LegTipoTarifa = new String[] {""} ;
      P01MA2_A235LegClase = new byte[1] ;
      P01MA2_A2404LegModTra = new String[] {""} ;
      P01MA2_A238LegCuentaBanc = new String[] {""} ;
      P01MA2_n238LegCuentaBanc = new boolean[] {false} ;
      P01MA2_A2225LegOsoDes = new String[] {""} ;
      P01MA2_A329SecDescrip = new String[] {""} ;
      P01MA2_n329SecDescrip = new boolean[] {false} ;
      P01MA2_A874LiqNombre = new String[] {""} ;
      P01MA2_A591LegNomApe = new String[] {""} ;
      P01MA2_A93LegId = new String[] {""} ;
      P01MA2_n93LegId = new boolean[] {false} ;
      P01MA2_A239LegCUIL = new long[1] ;
      P01MA2_A342ZonDescrip = new String[] {""} ;
      P01MA2_A248LegFormaPago = new byte[1] ;
      P01MA2_A15LegActCodigo = new String[] {""} ;
      P01MA2_n15LegActCodigo = new boolean[] {false} ;
      P01MA2_A2226LegOsoAfipCod = new String[] {""} ;
      P01MA2_n2226LegOsoAfipCod = new boolean[] {false} ;
      P01MA2_A910LegSinCod = new String[] {""} ;
      P01MA2_n910LegSinCod = new boolean[] {false} ;
      P01MA2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01MA2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01MA2_n244LegFecEgreso = new boolean[] {false} ;
      P01MA2_A300MegDescrip = new String[] {""} ;
      P01MA2_n300MegDescrip = new boolean[] {false} ;
      P01MA2_A234LegCBU = new String[] {""} ;
      P01MA2_n234LegCBU = new boolean[] {false} ;
      P01MA2_A2224LegBanDes = new String[] {""} ;
      P01MA2_A232LegBanTipCuen = new String[] {""} ;
      P01MA2_n232LegBanTipCuen = new boolean[] {false} ;
      P01MA2_A231LegBanSuc = new String[] {""} ;
      P01MA2_n231LegBanSuc = new boolean[] {false} ;
      P01MA2_A236LegCodPos = new String[] {""} ;
      P01MA2_A263LegSexo = new byte[1] ;
      P01MA2_n263LegSexo = new boolean[] {false} ;
      P01MA2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P01MA2_A262LegSCVO = new boolean[] {false} ;
      P01MA2_A876LiqDReFormulaHTML = new String[] {""} ;
      P01MA2_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P01MA2_A508LiqDFormulaHTML = new String[] {""} ;
      P01MA2_n508LiqDFormulaHTML = new boolean[] {false} ;
      P01MA2_A270LiqDErrorDesc = new String[] {""} ;
      P01MA2_n270LiqDErrorDesc = new boolean[] {false} ;
      P01MA2_A6LegNumero = new int[1] ;
      P01MA2_A31LiqNro = new int[1] ;
      P01MA2_A81LiqDSecuencial = new int[1] ;
      A20ZonCod = "" ;
      A1583LegMegCodigo = "" ;
      A1580LegOsoCod = "" ;
      A1579LegSecCodigo = "" ;
      A1582LegBanCod = "" ;
      A32TLiqCod = "" ;
      A342ZonDescrip = "" ;
      A15LegActCodigo = "" ;
      A2226LegOsoAfipCod = "" ;
      A910LegSinCod = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A300MegDescrip = "" ;
      A234LegCBU = "" ;
      A2224LegBanDes = "" ;
      A232LegBanTipCuen = "" ;
      A231LegBanSuc = "" ;
      A236LegCodPos = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A876LiqDReFormulaHTML = "" ;
      A508LiqDFormulaHTML = "" ;
      A270LiqDErrorDesc = "" ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV29UserCustomValue = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector7 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFLegId_SelsJson = "" ;
      AV109TFLegNomApe_SelsJson = "" ;
      AV40TFLiqNombre_SelsJson = "" ;
      AV44TFSecDescrip_SelsJson = "" ;
      AV120TFLegOsoDes_SelsJson = "" ;
      AV54TFLegCuentaBanc_SelsJson = "" ;
      AV124TFLegModTra_SelsJson = "" ;
      AV58TFLegClase_SelsJson = "" ;
      AV127TFLegTipoTarifa_SelsJson = "" ;
      AV65TFLiqDescrip_SelsJson = "" ;
      AV69TFLiqFecha_SelsJson = "" ;
      AV73TFLiqPerSinDia_SelsJson = "" ;
      AV77TFTliqDesc_SelsJson = "" ;
      AV81TFLiqFecPago_SelsJson = "" ;
      AV85TFDConCodigo_SelsJson = "" ;
      AV89TFDConDescrip_SelsJson = "" ;
      AV93TFDTipoConCod_SelsJson = "" ;
      AV96TFConClasifAux_SelsJson = "" ;
      AV115TFLiqDLogRecal_SelsJson = "" ;
      AV119MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion_export3export__default(),
         new Object[] {
             new Object[] {
            P01MA2_A20ZonCod, P01MA2_n20ZonCod, P01MA2_A1583LegMegCodigo, P01MA2_n1583LegMegCodigo, P01MA2_A1580LegOsoCod, P01MA2_n1580LegOsoCod, P01MA2_A1579LegSecCodigo, P01MA2_n1579LegSecCodigo, P01MA2_A1582LegBanCod, P01MA2_n1582LegBanCod,
            P01MA2_A32TLiqCod, P01MA2_n32TLiqCod, P01MA2_A1EmpCod, P01MA2_A3CliCod, P01MA2_A764LiqDImpReCalcu, P01MA2_A1072LiqDLogRecal, P01MA2_A275LiqDImpCalcu, P01MA2_n275LiqDImpCalcu, P01MA2_A269LiqDCanti, P01MA2_n269LiqDCanti,
            P01MA2_A464DTipoConCod, P01MA2_A393DConDescrip, P01MA2_A394DConCodigo, P01MA2_A280LiqFecPago, P01MA2_A340TliqDesc, P01MA2_A513LiqPerSinDia, P01MA2_A98LiqFecha, P01MA2_A271LiqDescrip, P01MA2_A2417LegTipoTarifa, P01MA2_A235LegClase,
            P01MA2_A2404LegModTra, P01MA2_A238LegCuentaBanc, P01MA2_n238LegCuentaBanc, P01MA2_A2225LegOsoDes, P01MA2_A329SecDescrip, P01MA2_n329SecDescrip, P01MA2_A874LiqNombre, P01MA2_A591LegNomApe, P01MA2_A93LegId, P01MA2_n93LegId,
            P01MA2_A239LegCUIL, P01MA2_A342ZonDescrip, P01MA2_A248LegFormaPago, P01MA2_A15LegActCodigo, P01MA2_n15LegActCodigo, P01MA2_A2226LegOsoAfipCod, P01MA2_n2226LegOsoAfipCod, P01MA2_A910LegSinCod, P01MA2_n910LegSinCod, P01MA2_A245LegFecIngreso,
            P01MA2_A244LegFecEgreso, P01MA2_n244LegFecEgreso, P01MA2_A300MegDescrip, P01MA2_n300MegDescrip, P01MA2_A234LegCBU, P01MA2_n234LegCBU, P01MA2_A2224LegBanDes, P01MA2_A232LegBanTipCuen, P01MA2_n232LegBanTipCuen, P01MA2_A231LegBanSuc,
            P01MA2_n231LegBanSuc, P01MA2_A236LegCodPos, P01MA2_A263LegSexo, P01MA2_n263LegSexo, P01MA2_A246LegFecNac, P01MA2_A262LegSCVO, P01MA2_A876LiqDReFormulaHTML, P01MA2_n876LiqDReFormulaHTML, P01MA2_A508LiqDFormulaHTML, P01MA2_n508LiqDFormulaHTML,
            P01MA2_A270LiqDErrorDesc, P01MA2_n270LiqDErrorDesc, P01MA2_A6LegNumero, P01MA2_A31LiqNro, P01MA2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV60TFLegClase_Sel ;
   private byte A235LegClase ;
   private byte A248LegFormaPago ;
   private byte A263LegSexo ;
   private short GXv_int3[] ;
   private short AV19OrderedBy ;
   private short AV108EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV132GXV1 ;
   private int AV133GXV2 ;
   private int AV134GXV3 ;
   private int AV135GXV4 ;
   private int AV136GXV5 ;
   private int AV137GXV6 ;
   private int AV138GXV7 ;
   private int AV139GXV8 ;
   private int AV140GXV9 ;
   private int AV141GXV10 ;
   private int AV142GXV11 ;
   private int AV143GXV12 ;
   private int AV144GXV13 ;
   private int AV145GXV14 ;
   private int AV146GXV15 ;
   private int AV147GXV16 ;
   private int AV148GXV17 ;
   private int AV149GXV18 ;
   private int AV150GXV19 ;
   private int AV151GXV20 ;
   private int AV38TFLegId_Sels_size ;
   private int AV111TFLegNomApe_Sels_size ;
   private int AV42TFLiqNombre_Sels_size ;
   private int AV46TFSecDescrip_Sels_size ;
   private int AV122TFLegOsoDes_Sels_size ;
   private int AV56TFLegCuentaBanc_Sels_size ;
   private int AV125TFLegModTra_Sels_size ;
   private int AV59TFLegClase_Sels_size ;
   private int AV128TFLegTipoTarifa_Sels_size ;
   private int AV67TFLiqDescrip_Sels_size ;
   private int AV71TFLiqFecha_Sels_size ;
   private int AV75TFLiqPerSinDia_Sels_size ;
   private int AV79TFTliqDesc_Sels_size ;
   private int AV83TFLiqFecPago_Sels_size ;
   private int AV87TFDConCodigo_Sels_size ;
   private int AV91TFDConDescrip_Sels_size ;
   private int AV94TFDTipoConCod_Sels_size ;
   private int AV117TFLiqDLogRecal_Sels_size ;
   private int AV107CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private int AV153GXV21 ;
   private int AV154GXV22 ;
   private long AV106i ;
   private long AV33VisibleColumnCount ;
   private long A239LegCUIL ;
   private java.math.BigDecimal AV100TFLiqDCanti ;
   private java.math.BigDecimal AV101TFLiqDCanti_To ;
   private java.math.BigDecimal AV104TFLiqDImpCalcu ;
   private java.math.BigDecimal AV105TFLiqDImpCalcu_To ;
   private java.math.BigDecimal AV102TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV103TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV39TFLegId_Sel ;
   private String AV37TFLegId ;
   private String AV126TFLegModTra_Sel ;
   private String AV129TFLegTipoTarifa_Sel ;
   private String AV76TFLiqPerSinDia_Sel ;
   private String AV74TFLiqPerSinDia ;
   private String AV88TFDConCodigo_Sel ;
   private String AV86TFDConCodigo ;
   private String AV95TFDTipoConCod_Sel ;
   private String scmdbuf ;
   private String lV37TFLegId ;
   private String lV74TFLiqPerSinDia ;
   private String lV86TFDConCodigo ;
   private String A93LegId ;
   private String A2404LegModTra ;
   private String A2417LegTipoTarifa ;
   private String A513LiqPerSinDia ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A20ZonCod ;
   private String A1583LegMegCodigo ;
   private String A1580LegOsoCod ;
   private String A1579LegSecCodigo ;
   private String A1582LegBanCod ;
   private String A32TLiqCod ;
   private String A15LegActCodigo ;
   private String A2226LegOsoAfipCod ;
   private String A910LegSinCod ;
   private String A232LegBanTipCuen ;
   private String A236LegCodPos ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date AV72TFLiqFecha_Sel ;
   private java.util.Date AV70TFLiqFecha ;
   private java.util.Date AV84TFLiqFecPago_Sel ;
   private java.util.Date AV82TFLiqFecPago ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A246LegFecNac ;
   private boolean returnInSub ;
   private boolean AV20OrderedDsc ;
   private boolean n20ZonCod ;
   private boolean n1583LegMegCodigo ;
   private boolean n1580LegOsoCod ;
   private boolean n1579LegSecCodigo ;
   private boolean n1582LegBanCod ;
   private boolean n32TLiqCod ;
   private boolean n275LiqDImpCalcu ;
   private boolean n269LiqDCanti ;
   private boolean n238LegCuentaBanc ;
   private boolean n329SecDescrip ;
   private boolean n93LegId ;
   private boolean n15LegActCodigo ;
   private boolean n2226LegOsoAfipCod ;
   private boolean n910LegSinCod ;
   private boolean n244LegFecEgreso ;
   private boolean n300MegDescrip ;
   private boolean n234LegCBU ;
   private boolean n232LegBanTipCuen ;
   private boolean n231LegBanSuc ;
   private boolean n263LegSexo ;
   private boolean A262LegSCVO ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n270LiqDErrorDesc ;
   private String AV28ColumnsSelectorXML ;
   private String A1072LiqDLogRecal ;
   private String A876LiqDReFormulaHTML ;
   private String A508LiqDFormulaHTML ;
   private String AV29UserCustomValue ;
   private String AV36TFLegId_SelsJson ;
   private String AV109TFLegNomApe_SelsJson ;
   private String AV40TFLiqNombre_SelsJson ;
   private String AV44TFSecDescrip_SelsJson ;
   private String AV120TFLegOsoDes_SelsJson ;
   private String AV54TFLegCuentaBanc_SelsJson ;
   private String AV124TFLegModTra_SelsJson ;
   private String AV58TFLegClase_SelsJson ;
   private String AV127TFLegTipoTarifa_SelsJson ;
   private String AV65TFLiqDescrip_SelsJson ;
   private String AV69TFLiqFecha_SelsJson ;
   private String AV73TFLiqPerSinDia_SelsJson ;
   private String AV77TFTliqDesc_SelsJson ;
   private String AV81TFLiqFecPago_SelsJson ;
   private String AV85TFDConCodigo_SelsJson ;
   private String AV89TFDConDescrip_SelsJson ;
   private String AV93TFDTipoConCod_SelsJson ;
   private String AV96TFConClasifAux_SelsJson ;
   private String AV115TFLiqDLogRecal_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV112TFLegNomApe_Sel ;
   private String AV110TFLegNomApe ;
   private String AV43TFLiqNombre_Sel ;
   private String AV41TFLiqNombre ;
   private String AV47TFSecDescrip_Sel ;
   private String AV45TFSecDescrip ;
   private String AV123TFLegOsoDes_Sel ;
   private String AV121TFLegOsoDes ;
   private String AV57TFLegCuentaBanc_Sel ;
   private String AV55TFLegCuentaBanc ;
   private String AV68TFLiqDescrip_Sel ;
   private String AV66TFLiqDescrip ;
   private String AV80TFTliqDesc_Sel ;
   private String AV78TFTliqDesc ;
   private String AV92TFDConDescrip_Sel ;
   private String AV90TFDConDescrip ;
   private String AV99TFConClasifAux_Sel ;
   private String AV97TFConClasifAux ;
   private String AV118TFLiqDLogRecal_Sel ;
   private String AV116TFLiqDLogRecal ;
   private String lV110TFLegNomApe ;
   private String lV41TFLiqNombre ;
   private String lV90TFDConDescrip ;
   private String lV116TFLiqDLogRecal ;
   private String A591LegNomApe ;
   private String A874LiqNombre ;
   private String A329SecDescrip ;
   private String A2225LegOsoDes ;
   private String A238LegCuentaBanc ;
   private String A271LiqDescrip ;
   private String A340TliqDesc ;
   private String A393DConDescrip ;
   private String A342ZonDescrip ;
   private String A300MegDescrip ;
   private String A234LegCBU ;
   private String A2224LegBanDes ;
   private String A231LegBanSuc ;
   private String A270LiqDErrorDesc ;
   private String AV119MenuOpcCod ;
   private GXSimpleCollection<Byte> AV59TFLegClase_Sels ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV38TFLegId_Sels ;
   private GXSimpleCollection<String> AV125TFLegModTra_Sels ;
   private GXSimpleCollection<String> AV128TFLegTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV75TFLiqPerSinDia_Sels ;
   private GXSimpleCollection<String> AV87TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV94TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV111TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV42TFLiqNombre_Sels ;
   private GXSimpleCollection<String> AV46TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV122TFLegOsoDes_Sels ;
   private GXSimpleCollection<String> AV56TFLegCuentaBanc_Sels ;
   private GXSimpleCollection<String> AV67TFLiqDescrip_Sels ;
   private GXSimpleCollection<String> AV79TFTliqDesc_Sels ;
   private GXSimpleCollection<String> AV91TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV98TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV117TFLiqDLogRecal_Sels ;
   private GXSimpleCollection<java.util.Date> AV71TFLiqFecha_Sels ;
   private GXSimpleCollection<java.util.Date> AV83TFLiqFecPago_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MA2_A20ZonCod ;
   private boolean[] P01MA2_n20ZonCod ;
   private String[] P01MA2_A1583LegMegCodigo ;
   private boolean[] P01MA2_n1583LegMegCodigo ;
   private String[] P01MA2_A1580LegOsoCod ;
   private boolean[] P01MA2_n1580LegOsoCod ;
   private String[] P01MA2_A1579LegSecCodigo ;
   private boolean[] P01MA2_n1579LegSecCodigo ;
   private String[] P01MA2_A1582LegBanCod ;
   private boolean[] P01MA2_n1582LegBanCod ;
   private String[] P01MA2_A32TLiqCod ;
   private boolean[] P01MA2_n32TLiqCod ;
   private short[] P01MA2_A1EmpCod ;
   private int[] P01MA2_A3CliCod ;
   private java.math.BigDecimal[] P01MA2_A764LiqDImpReCalcu ;
   private String[] P01MA2_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01MA2_A275LiqDImpCalcu ;
   private boolean[] P01MA2_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01MA2_A269LiqDCanti ;
   private boolean[] P01MA2_n269LiqDCanti ;
   private String[] P01MA2_A464DTipoConCod ;
   private String[] P01MA2_A393DConDescrip ;
   private String[] P01MA2_A394DConCodigo ;
   private java.util.Date[] P01MA2_A280LiqFecPago ;
   private String[] P01MA2_A340TliqDesc ;
   private String[] P01MA2_A513LiqPerSinDia ;
   private java.util.Date[] P01MA2_A98LiqFecha ;
   private String[] P01MA2_A271LiqDescrip ;
   private String[] P01MA2_A2417LegTipoTarifa ;
   private byte[] P01MA2_A235LegClase ;
   private String[] P01MA2_A2404LegModTra ;
   private String[] P01MA2_A238LegCuentaBanc ;
   private boolean[] P01MA2_n238LegCuentaBanc ;
   private String[] P01MA2_A2225LegOsoDes ;
   private String[] P01MA2_A329SecDescrip ;
   private boolean[] P01MA2_n329SecDescrip ;
   private String[] P01MA2_A874LiqNombre ;
   private String[] P01MA2_A591LegNomApe ;
   private String[] P01MA2_A93LegId ;
   private boolean[] P01MA2_n93LegId ;
   private long[] P01MA2_A239LegCUIL ;
   private String[] P01MA2_A342ZonDescrip ;
   private byte[] P01MA2_A248LegFormaPago ;
   private String[] P01MA2_A15LegActCodigo ;
   private boolean[] P01MA2_n15LegActCodigo ;
   private String[] P01MA2_A2226LegOsoAfipCod ;
   private boolean[] P01MA2_n2226LegOsoAfipCod ;
   private String[] P01MA2_A910LegSinCod ;
   private boolean[] P01MA2_n910LegSinCod ;
   private java.util.Date[] P01MA2_A245LegFecIngreso ;
   private java.util.Date[] P01MA2_A244LegFecEgreso ;
   private boolean[] P01MA2_n244LegFecEgreso ;
   private String[] P01MA2_A300MegDescrip ;
   private boolean[] P01MA2_n300MegDescrip ;
   private String[] P01MA2_A234LegCBU ;
   private boolean[] P01MA2_n234LegCBU ;
   private String[] P01MA2_A2224LegBanDes ;
   private String[] P01MA2_A232LegBanTipCuen ;
   private boolean[] P01MA2_n232LegBanTipCuen ;
   private String[] P01MA2_A231LegBanSuc ;
   private boolean[] P01MA2_n231LegBanSuc ;
   private String[] P01MA2_A236LegCodPos ;
   private byte[] P01MA2_A263LegSexo ;
   private boolean[] P01MA2_n263LegSexo ;
   private java.util.Date[] P01MA2_A246LegFecNac ;
   private boolean[] P01MA2_A262LegSCVO ;
   private String[] P01MA2_A876LiqDReFormulaHTML ;
   private boolean[] P01MA2_n876LiqDReFormulaHTML ;
   private String[] P01MA2_A508LiqDFormulaHTML ;
   private boolean[] P01MA2_n508LiqDFormulaHTML ;
   private String[] P01MA2_A270LiqDErrorDesc ;
   private boolean[] P01MA2_n270LiqDErrorDesc ;
   private int[] P01MA2_A6LegNumero ;
   private int[] P01MA2_A31LiqNro ;
   private int[] P01MA2_A81LiqDSecuencial ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class liquidacion_export3export__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01MA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV38TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV111TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV42TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV46TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV122TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV56TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV125TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV59TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV128TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV67TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV71TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV75TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV79TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV83TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV87TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV91TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV94TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV117TFLiqDLogRecal_Sels ,
                                          int AV38TFLegId_Sels_size ,
                                          String AV37TFLegId ,
                                          int AV111TFLegNomApe_Sels_size ,
                                          String AV110TFLegNomApe ,
                                          int AV42TFLiqNombre_Sels_size ,
                                          String AV41TFLiqNombre ,
                                          int AV46TFSecDescrip_Sels_size ,
                                          int AV122TFLegOsoDes_Sels_size ,
                                          int AV56TFLegCuentaBanc_Sels_size ,
                                          int AV125TFLegModTra_Sels_size ,
                                          int AV59TFLegClase_Sels_size ,
                                          int AV128TFLegTipoTarifa_Sels_size ,
                                          int AV67TFLiqDescrip_Sels_size ,
                                          int AV71TFLiqFecha_Sels_size ,
                                          int AV75TFLiqPerSinDia_Sels_size ,
                                          String AV74TFLiqPerSinDia ,
                                          int AV79TFTliqDesc_Sels_size ,
                                          int AV83TFLiqFecPago_Sels_size ,
                                          int AV87TFDConCodigo_Sels_size ,
                                          String AV86TFDConCodigo ,
                                          int AV91TFDConDescrip_Sels_size ,
                                          String AV90TFDConDescrip ,
                                          int AV94TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV100TFLiqDCanti ,
                                          java.math.BigDecimal AV101TFLiqDCanti_To ,
                                          java.math.BigDecimal AV104TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV105TFLiqDImpCalcu_To ,
                                          int AV117TFLiqDLogRecal_Sels_size ,
                                          String AV116TFLiqDLogRecal ,
                                          java.math.BigDecimal AV102TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV103TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          int AV107CliCod ,
                                          short AV108EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[15];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T2.ZonCod, T2.LegMegCodigo AS LegMegCodigo, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T2.LegBanCod AS LegBanCod, T8.TLiqCod, T1.EmpCod," ;
      scmdbuf += " T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal, T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T8.LiqFecPago, T9.TliqDesc, T8.LiqPerSinDia," ;
      scmdbuf += " T8.LiqFecha, T8.LiqDescrip, T2.LegTipoTarifa, T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T5.OsoDescrip AS LegOsoDes, T6.SecDescrip, T8.LiqNombre, T2.LegNomApe," ;
      scmdbuf += " T2.LegId, T2.LegCUIL, T3.ZonDescrip, T2.LegFormaPago, T2.LegActCodigo, T5.OsoC3992 AS LegOsoAfipCod, T2.LegSinCod, T2.LegFecIngreso, T2.LegFecEgreso, T4.MegDescrip," ;
      scmdbuf += " T2.LegCBU, T7.BanDescrip AS LegBanDes, T2.LegBanTipCuen, T2.LegBanSuc, T2.LegCodPos, T2.LegSexo, T2.LegFecNac, T2.LegSCVO, T1.LiqDReFormulaHTML, T1.LiqDFormulaHTML," ;
      scmdbuf += " T1.LiqDErrorDesc, T1.LegNumero, T1.LiqNro, T1.LiqDSecuencial FROM ((((((((LiquidacionDetalle T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod" ;
      scmdbuf += " AND T2.LegNumero = T1.LegNumero) LEFT JOIN Zona T3 ON T3.ZonCod = T2.ZonCod) LEFT JOIN MotivoEgreso T4 ON T4.CliCod = T1.CliCod AND T4.MegCodigo = T2.LegMegCodigo)" ;
      scmdbuf += " LEFT JOIN ObraSocial T5 ON T5.CliCod = T1.CliCod AND T5.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T6 ON T6.CliCod = T1.CliCod AND T6.SecCodigo = T2.LegSecCodigo)" ;
      scmdbuf += " LEFT JOIN Banco T7 ON T7.CliCod = T1.CliCod AND T7.BanCod = T2.LegBanCod) INNER JOIN Liquidacion T8 ON T8.CliCod = T1.CliCod AND T8.EmpCod = T1.EmpCod AND T8.LiqNro" ;
      scmdbuf += " = T1.LiqNro) LEFT JOIN TipoLiquidacion T9 ON T9.CliCod = T1.CliCod AND T9.TLiqCod = T8.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV38TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      if ( AV38TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV111TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      if ( AV111TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV42TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV41TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T8.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int9[4] = (byte)(1) ;
      }
      if ( AV42TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV42TFLiqNombre_Sels, "T8.LiqNombre IN (", ")")+")");
      }
      if ( AV46TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46TFSecDescrip_Sels, "T6.SecDescrip IN (", ")")+")");
      }
      if ( AV122TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV122TFLegOsoDes_Sels, "T5.OsoDescrip IN (", ")")+")");
      }
      if ( AV56TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV125TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV125TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV59TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV128TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV67TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFLiqDescrip_Sels, "T8.LiqDescrip IN (", ")")+")");
      }
      if ( AV71TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLiqFecha_Sels, "T8.LiqFecha IN (", ")")+")");
      }
      if ( ( AV75TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T8.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int9[5] = (byte)(1) ;
      }
      if ( AV75TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75TFLiqPerSinDia_Sels, "T8.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV79TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTliqDesc_Sels, "T9.TliqDesc IN (", ")")+")");
      }
      if ( AV83TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83TFLiqFecPago_Sels, "T8.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV87TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV86TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( AV87TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV91TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      if ( AV91TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV94TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int9[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int9[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int9[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int9[11] = (byte)(1) ;
      }
      if ( ( AV117TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV116TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int9[12] = (byte)(1) ;
      }
      if ( AV117TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int9[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int9[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV19OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.DConCodigo" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.DConDescrip" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.DConDescrip DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegNomApe" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T2.LegNomApe DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegId" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T2.LegId DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.LegModTra" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.LegModTra DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.LegTipoTarifa" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.LegTipoTarifa DESC" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T8.LiqPerSinDia" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T8.LiqPerSinDia DESC" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqDLogRecal" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqDLogRecal DESC" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqDImpReCalcu" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqDImpReCalcu DESC" ;
      }
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
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
                  return conditional_P01MA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).shortValue() , ((Boolean) dynConstraints[71]).booleanValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(5, 6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((int[]) buf[13])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(13, 20);
               ((String[]) buf[21])[0] = rslt.getVarchar(14);
               ((String[]) buf[22])[0] = rslt.getString(15, 10);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(16);
               ((String[]) buf[24])[0] = rslt.getVarchar(17);
               ((String[]) buf[25])[0] = rslt.getString(18, 20);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(19);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getString(21, 1);
               ((byte[]) buf[29])[0] = rslt.getByte(22);
               ((String[]) buf[30])[0] = rslt.getString(23, 1);
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getVarchar(25);
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((String[]) buf[37])[0] = rslt.getVarchar(28);
               ((String[]) buf[38])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((long[]) buf[40])[0] = rslt.getLong(30);
               ((String[]) buf[41])[0] = rslt.getVarchar(31);
               ((byte[]) buf[42])[0] = rslt.getByte(32);
               ((String[]) buf[43])[0] = rslt.getString(33, 8);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((String[]) buf[45])[0] = rslt.getString(34, 20);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((String[]) buf[47])[0] = rslt.getString(35, 20);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[49])[0] = rslt.getGXDate(36);
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(37);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(40);
               ((String[]) buf[57])[0] = rslt.getString(41, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getVarchar(42);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((String[]) buf[61])[0] = rslt.getString(43, 20);
               ((byte[]) buf[62])[0] = rslt.getByte(44);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(45);
               ((boolean[]) buf[65])[0] = rslt.getBoolean(46);
               ((String[]) buf[66])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((String[]) buf[68])[0] = rslt.getLongVarchar(48);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[71])[0] = rslt.wasNull();
               ((int[]) buf[72])[0] = rslt.getInt(50);
               ((int[]) buf[73])[0] = rslt.getInt(51);
               ((int[]) buf[74])[0] = rslt.getInt(52);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
      }
   }

}

