package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_aplicacion_gananciaswwexport extends GXProcedure
{
   public tipo_aplicacion_gananciaswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_aplicacion_gananciaswwexport.class ), "" );
   }

   public tipo_aplicacion_gananciaswwexport( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      tipo_aplicacion_gananciaswwexport.this.aP1 = new String[] {""};
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
      tipo_aplicacion_gananciaswwexport.this.aP0 = aP0;
      tipo_aplicacion_gananciaswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV66CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciaswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV66CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias", GXv_boolean4) ;
      tipo_aplicacion_gananciaswwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV80Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "tipo_aplicacion_gananciasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFAplIIGG) && (0==AV36TFAplIIGG_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Nro.", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFAplIIGG );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFAplIIGG_To );
      }
      if ( ! ( ( AV39TFAplIIGGNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV81GXV1 = 1 ;
         while ( AV81GXV1 <= AV39TFAplIIGGNom_Sels.size() )
         {
            AV40TFAplIIGGNom_Sel = (String)AV39TFAplIIGGNom_Sels.elementAt(-1+AV81GXV1) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFAplIIGGNom_Sel, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV65i = (long)(AV65i+1) ;
            AV81GXV1 = (int)(AV81GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFAplIIGGNom)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFAplIIGGNom, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV42TFAplIIGGTrat_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tratamiento específico", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV82GXV2 = 1 ;
         while ( AV82GXV2 <= AV42TFAplIIGGTrat_Sels.size() )
         {
            AV43TFAplIIGGTrat_Sel = ((Number) AV42TFAplIIGGTrat_Sels.elementAt(-1+AV82GXV2)).byteValue() ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainapliiggtratamiento.getDescription(httpContext,(byte)AV43TFAplIIGGTrat_Sel), "") );
            AV65i = (long)(AV65i+1) ;
            AV82GXV2 = (int)(AV82GXV2+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFAplIIGGPropor)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFAplIIGGPropor_To)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Proporción del tope (1 =100%)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV44TFAplIIGGPropor)) );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV45TFAplIIGGPropor_To)) );
      }
      if ( ! ( ( AV47TFAplIIGGTopeTip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de tope", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV83GXV3 = 1 ;
         while ( AV83GXV3 <= AV47TFAplIIGGTopeTip_Sels.size() )
         {
            AV48TFAplIIGGTopeTip_Sel = ((Number) AV47TFAplIIGGTopeTip_Sels.elementAt(-1+AV83GXV3)).byteValue() ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipotope.getDescription(httpContext,(byte)AV48TFAplIIGGTopeTip_Sel), "") );
            AV65i = (long)(AV65i+1) ;
            AV83GXV3 = (int)(AV83GXV3+1) ;
         }
      }
      if ( ! ( ( AV51TFAplIIGGTopeCon_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto para tope", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV84GXV4 = 1 ;
         while ( AV84GXV4 <= AV51TFAplIIGGTopeCon_Sels.size() )
         {
            AV52TFAplIIGGTopeCon_Sel = (String)AV51TFAplIIGGTopeCon_Sels.elementAt(-1+AV84GXV4) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFAplIIGGTopeCon_Sel, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV65i = (long)(AV65i+1) ;
            AV84GXV4 = (int)(AV84GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFAplIIGGTopeCon)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto para tope", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFAplIIGGTopeCon, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFAplIIGGTopeFij)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFAplIIGGTopeFij_To)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tope fijo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFAplIIGGTopeFij)) );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV54TFAplIIGGTopeFij_To)) );
      }
      if ( ! ( ( AV57TFAplIIGGExenCon_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto exento agrupador para F1357", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV85GXV5 = 1 ;
         while ( AV85GXV5 <= AV57TFAplIIGGExenCon_Sels.size() )
         {
            AV58TFAplIIGGExenCon_Sel = (String)AV57TFAplIIGGExenCon_Sels.elementAt(-1+AV85GXV5) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFAplIIGGExenCon_Sel, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV65i = (long)(AV65i+1) ;
            AV85GXV5 = (int)(AV85GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFAplIIGGExenCon)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto exento agrupador para F1357", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFAplIIGGExenCon, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV69TFAplIIGGPrrtear_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de cuota", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV86GXV6 = 1 ;
         while ( AV86GXV6 <= AV69TFAplIIGGPrrtear_Sels.size() )
         {
            AV70TFAplIIGGPrrtear_Sel = (String)AV69TFAplIIGGPrrtear_Sels.elementAt(-1+AV86GXV6) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_cuota.getDescription(httpContext,(String)AV70TFAplIIGGPrrtear_Sel), "") );
            AV65i = (long)(AV65i+1) ;
            AV86GXV6 = (int)(AV86GXV6+1) ;
         }
      }
      if ( ! ( ( AV63TFAplIIGGCondicion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Condición a cumplir para exención", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV87GXV7 = 1 ;
         while ( AV87GXV7 <= AV63TFAplIIGGCondicion_Sels.size() )
         {
            AV64TFAplIIGGCondicion_Sel = (String)AV63TFAplIIGGCondicion_Sels.elementAt(-1+AV87GXV7) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFAplIIGGCondicion_Sel, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV65i = (long)(AV65i+1) ;
            AV87GXV7 = (int)(AV87GXV7+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV62TFAplIIGGCondicion)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Condición a cumplir para exención", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFAplIIGGCondicion, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV76TFAplIIGGRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV65i = 1 ;
         AV88GXV8 = 1 ;
         while ( AV88GXV8 <= AV76TFAplIIGGRelRef_Sels.size() )
         {
            AV77TFAplIIGGRelRef_Sel = (String)AV76TFAplIIGGRelRef_Sels.elementAt(-1+AV88GXV8) ;
            if ( AV65i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV77TFAplIIGGRelRef_Sel, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV65i = (long)(AV65i+1) ;
            AV88GXV8 = (int)(AV88GXV8+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV75TFAplIIGGRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            tipo_aplicacion_gananciaswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV75TFAplIIGGRelRef, GXv_char9) ;
            tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("tipo_aplicacion_gananciasWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("tipo_aplicacion_gananciasWWColumnsSelector") ;
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
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "AplIIGGTopeVar" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Variable para tope", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV72IsAuthorizedAplIIGGRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV89GXV9 = 1 ;
      while ( AV89GXV9 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV89GXV9));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV89GXV9 = (int)(AV89GXV9+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV35TFAplIIGG ;
      AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV36TFAplIIGG_To ;
      AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV38TFAplIIGGNom ;
      AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV39TFAplIIGGNom_Sels ;
      AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV42TFAplIIGGTrat_Sels ;
      AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV44TFAplIIGGPropor ;
      AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV45TFAplIIGGPropor_To ;
      AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV47TFAplIIGGTopeTip_Sels ;
      AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV50TFAplIIGGTopeCon ;
      AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV51TFAplIIGGTopeCon_Sels ;
      AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV53TFAplIIGGTopeFij ;
      AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV54TFAplIIGGTopeFij_To ;
      AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV56TFAplIIGGExenCon ;
      AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV57TFAplIIGGExenCon_Sels ;
      AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV69TFAplIIGGPrrtear_Sels ;
      AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV62TFAplIIGGCondicion ;
      AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV63TFAplIIGGCondicion_Sels ;
      AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV75TFAplIIGGRelRef ;
      AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV76TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV66CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P01K22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV66CliCod), Short.valueOf(AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01K22_A3CliCod[0] ;
         A2020AplIIGGRelRef = P01K22_A2020AplIIGGRelRef[0] ;
         A1124AplIIGGCondicion = P01K22_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P01K22_n1124AplIIGGCondicion[0] ;
         A1121AplIIGGPrrtear = P01K22_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P01K22_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P01K22_n1117AplIIGGExenCon[0] ;
         A1119AplIIGGTopeFij = P01K22_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P01K22_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P01K22_n1111AplIIGGTopeCon[0] ;
         A1115AplIIGGTopeTip = P01K22_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P01K22_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P01K22_A1120AplIIGGTrat[0] ;
         A1113AplIIGGNom = P01K22_A1113AplIIGGNom[0] ;
         A1112AplIIGG = P01K22_A1112AplIIGG[0] ;
         A1109AplIIGGTopeVar = P01K22_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = P01K22_n1109AplIIGGTopeVar[0] ;
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
         AV110GXV10 = 1 ;
         while ( AV110GXV10 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV110GXV10));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGG") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1112AplIIGG );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGNom") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1113AplIIGGNom, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGTrat") == 0 )
               {
                  if ( ! (0==A1120AplIIGGTrat) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainapliiggtratamiento.getDescription(httpContext,(byte)A1120AplIIGGTrat), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGPropor") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1114AplIIGGPropor)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGTopeTip") == 0 )
               {
                  if ( ! (0==A1115AplIIGGTopeTip) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipotope.getDescription(httpContext,(byte)A1115AplIIGGTopeTip), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGTopeVar") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1109AplIIGGTopeVar, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGTopeCon") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1111AplIIGGTopeCon, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGTopeFij") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1119AplIIGGTopeFij)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGExenCon") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1117AplIIGGExenCon, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGPrrtear") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_cuota.getDescription(httpContext,(String)A1121AplIIGGPrrtear), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGCondicion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1124AplIIGGCondicion, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "AplIIGGRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2020AplIIGGRelRef, GXv_char9) ;
                  tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV110GXV10 = (int)(AV110GXV10+1) ;
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
      GXt_boolean3 = AV72IsAuthorizedAplIIGGRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV66CliCod, GXv_boolean4) ;
      tipo_aplicacion_gananciaswwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV72IsAuthorizedAplIIGGRelRef = (boolean)((!GXt_boolean3)) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGG", "", "Nro.", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGNom", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGTrat", "", "Tratamiento específico", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGPropor", "", "Proporción del tope (1 =100%)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGTopeTip", "", "Tipo de tope", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&OpeCliDescrip", "", "Variable para tope", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGTopeCon", "", "Concepto para tope", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGTopeFij", "", "Tope fijo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGExenCon", "", "Concepto exento agrupador para F1357", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGPrrtear", "", "Tipo de cuota", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGCondicion", "", "Condición a cumplir para exención", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV66CliCod) )
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
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "AplIIGGRelRef", "", "Liberación", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "tipo_aplicacion_gananciasWWColumnsSelector", GXv_char9) ;
      tipo_aplicacion_gananciaswwexport.this.GXt_char8 = GXv_char9[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("tipo_aplicacion_gananciasWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "tipo_aplicacion_gananciasWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("tipo_aplicacion_gananciasWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV111GXV11 = 1 ;
      while ( AV111GXV11 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV111GXV11));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG") == 0 )
         {
            AV35TFAplIIGG = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFAplIIGG_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM") == 0 )
         {
            AV38TFAplIIGGNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM_SEL") == 0 )
         {
            AV37TFAplIIGGNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFAplIIGGNom_Sels.fromJSonString(AV37TFAplIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTRAT_SEL") == 0 )
         {
            AV41TFAplIIGGTrat_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFAplIIGGTrat_Sels.fromJSonString(AV41TFAplIIGGTrat_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPROPOR") == 0 )
         {
            AV44TFAplIIGGPropor = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV45TFAplIIGGPropor_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPETIP_SEL") == 0 )
         {
            AV46TFAplIIGGTopeTip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFAplIIGGTopeTip_Sels.fromJSonString(AV46TFAplIIGGTopeTip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON") == 0 )
         {
            AV50TFAplIIGGTopeCon = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON_SEL") == 0 )
         {
            AV49TFAplIIGGTopeCon_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFAplIIGGTopeCon_Sels.fromJSonString(AV49TFAplIIGGTopeCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPEFIJ") == 0 )
         {
            AV53TFAplIIGGTopeFij = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV54TFAplIIGGTopeFij_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON") == 0 )
         {
            AV56TFAplIIGGExenCon = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON_SEL") == 0 )
         {
            AV55TFAplIIGGExenCon_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFAplIIGGExenCon_Sels.fromJSonString(AV55TFAplIIGGExenCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPRRTEAR_SEL") == 0 )
         {
            AV68TFAplIIGGPrrtear_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV69TFAplIIGGPrrtear_Sels.fromJSonString(AV68TFAplIIGGPrrtear_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION") == 0 )
         {
            AV62TFAplIIGGCondicion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION_SEL") == 0 )
         {
            AV61TFAplIIGGCondicion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFAplIIGGCondicion_Sels.fromJSonString(AV61TFAplIIGGCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF") == 0 )
         {
            AV75TFAplIIGGRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF_SEL") == 0 )
         {
            AV74TFAplIIGGRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV76TFAplIIGGRelRef_Sels.fromJSonString(AV74TFAplIIGGRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV71MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV111GXV11 = (int)(AV111GXV11+1) ;
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
      this.aP0[0] = tipo_aplicacion_gananciaswwexport.this.AV12Filename;
      this.aP1[0] = tipo_aplicacion_gananciaswwexport.this.AV13ErrorMessage;
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
      AV80Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFAplIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFAplIIGGNom_Sel = "" ;
      AV38TFAplIIGGNom = "" ;
      AV42TFAplIIGGTrat_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV44TFAplIIGGPropor = DecimalUtil.ZERO ;
      AV45TFAplIIGGPropor_To = DecimalUtil.ZERO ;
      AV47TFAplIIGGTopeTip_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV51TFAplIIGGTopeCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFAplIIGGTopeCon_Sel = "" ;
      AV50TFAplIIGGTopeCon = "" ;
      AV53TFAplIIGGTopeFij = DecimalUtil.ZERO ;
      AV54TFAplIIGGTopeFij_To = DecimalUtil.ZERO ;
      AV57TFAplIIGGExenCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFAplIIGGExenCon_Sel = "" ;
      AV56TFAplIIGGExenCon = "" ;
      AV69TFAplIIGGPrrtear_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70TFAplIIGGPrrtear_Sel = "" ;
      AV63TFAplIIGGCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFAplIIGGCondicion_Sel = "" ;
      AV62TFAplIIGGCondicion = "" ;
      AV76TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77TFAplIIGGRelRef_Sel = "" ;
      AV75TFAplIIGGRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1109AplIIGGTopeVar = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      A1117AplIIGGExenCon = "" ;
      A1121AplIIGGPrrtear = "" ;
      A1124AplIIGGCondicion = "" ;
      A2020AplIIGGRelRef = "" ;
      AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = DecimalUtil.ZERO ;
      AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = DecimalUtil.ZERO ;
      AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = DecimalUtil.ZERO ;
      AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = DecimalUtil.ZERO ;
      AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      lV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      lV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      lV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      lV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      P01K22_A3CliCod = new int[1] ;
      P01K22_A2020AplIIGGRelRef = new String[] {""} ;
      P01K22_A1124AplIIGGCondicion = new String[] {""} ;
      P01K22_n1124AplIIGGCondicion = new boolean[] {false} ;
      P01K22_A1121AplIIGGPrrtear = new String[] {""} ;
      P01K22_A1117AplIIGGExenCon = new String[] {""} ;
      P01K22_n1117AplIIGGExenCon = new boolean[] {false} ;
      P01K22_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01K22_A1111AplIIGGTopeCon = new String[] {""} ;
      P01K22_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P01K22_A1115AplIIGGTopeTip = new byte[1] ;
      P01K22_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01K22_A1120AplIIGGTrat = new byte[1] ;
      P01K22_A1113AplIIGGNom = new String[] {""} ;
      P01K22_A1112AplIIGG = new short[1] ;
      P01K22_A1109AplIIGGTopeVar = new String[] {""} ;
      P01K22_n1109AplIIGGTopeVar = new boolean[] {false} ;
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFAplIIGGNom_SelsJson = "" ;
      AV41TFAplIIGGTrat_SelsJson = "" ;
      AV46TFAplIIGGTopeTip_SelsJson = "" ;
      AV49TFAplIIGGTopeCon_SelsJson = "" ;
      AV55TFAplIIGGExenCon_SelsJson = "" ;
      AV68TFAplIIGGPrrtear_SelsJson = "" ;
      AV61TFAplIIGGCondicion_SelsJson = "" ;
      AV74TFAplIIGGRelRef_SelsJson = "" ;
      AV71MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_aplicacion_gananciaswwexport__default(),
         new Object[] {
             new Object[] {
            P01K22_A3CliCod, P01K22_A2020AplIIGGRelRef, P01K22_A1124AplIIGGCondicion, P01K22_n1124AplIIGGCondicion, P01K22_A1121AplIIGGPrrtear, P01K22_A1117AplIIGGExenCon, P01K22_n1117AplIIGGExenCon, P01K22_A1119AplIIGGTopeFij, P01K22_A1111AplIIGGTopeCon, P01K22_n1111AplIIGGTopeCon,
            P01K22_A1115AplIIGGTopeTip, P01K22_A1114AplIIGGPropor, P01K22_A1120AplIIGGTrat, P01K22_A1113AplIIGGNom, P01K22_A1112AplIIGG, P01K22_A1109AplIIGGTopeVar, P01K22_n1109AplIIGGTopeVar
            }
         }
      );
      AV80Pgmname = "tipo_aplicacion_gananciasWWExport" ;
      /* GeneXus formulas. */
      AV80Pgmname = "tipo_aplicacion_gananciasWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFAplIIGGTrat_Sel ;
   private byte AV48TFAplIIGGTopeTip_Sel ;
   private byte A1120AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private short AV35TFAplIIGG ;
   private short AV36TFAplIIGG_To ;
   private short GXv_int7[] ;
   private short A1112AplIIGG ;
   private short AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg ;
   private short AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV66CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
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
   private int AV89GXV9 ;
   private int A3CliCod ;
   private int AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ;
   private int AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ;
   private int AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ;
   private int AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ;
   private int AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ;
   private int AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ;
   private int AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ;
   private int AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ;
   private int AV110GXV10 ;
   private int AV111GXV11 ;
   private long AV65i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV44TFAplIIGGPropor ;
   private java.math.BigDecimal AV45TFAplIIGGPropor_To ;
   private java.math.BigDecimal AV53TFAplIIGGTopeFij ;
   private java.math.BigDecimal AV54TFAplIIGGTopeFij_To ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private java.math.BigDecimal AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ;
   private java.math.BigDecimal AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ;
   private java.math.BigDecimal AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ;
   private java.math.BigDecimal AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ;
   private String AV80Pgmname ;
   private String AV52TFAplIIGGTopeCon_Sel ;
   private String AV50TFAplIIGGTopeCon ;
   private String AV58TFAplIIGGExenCon_Sel ;
   private String AV56TFAplIIGGExenCon ;
   private String AV70TFAplIIGGPrrtear_Sel ;
   private String AV64TFAplIIGGCondicion_Sel ;
   private String AV62TFAplIIGGCondicion ;
   private String A1109AplIIGGTopeVar ;
   private String A1111AplIIGGTopeCon ;
   private String A1117AplIIGGExenCon ;
   private String A1121AplIIGGPrrtear ;
   private String A1124AplIIGGCondicion ;
   private String AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String scmdbuf ;
   private String lV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String lV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String lV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV72IsAuthorizedAplIIGGRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFAplIIGGNom_SelsJson ;
   private String AV41TFAplIIGGTrat_SelsJson ;
   private String AV46TFAplIIGGTopeTip_SelsJson ;
   private String AV49TFAplIIGGTopeCon_SelsJson ;
   private String AV55TFAplIIGGExenCon_SelsJson ;
   private String AV68TFAplIIGGPrrtear_SelsJson ;
   private String AV61TFAplIIGGCondicion_SelsJson ;
   private String AV74TFAplIIGGRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFAplIIGGNom_Sel ;
   private String AV38TFAplIIGGNom ;
   private String AV77TFAplIIGGRelRef_Sel ;
   private String AV75TFAplIIGGRelRef ;
   private String A1113AplIIGGNom ;
   private String A2020AplIIGGRelRef ;
   private String AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String lV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String lV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String AV71MenuOpcCod ;
   private GXSimpleCollection<Byte> AV42TFAplIIGGTrat_Sels ;
   private GXSimpleCollection<Byte> AV47TFAplIIGGTopeTip_Sels ;
   private GXSimpleCollection<Byte> AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ;
   private GXSimpleCollection<Byte> AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV51TFAplIIGGTopeCon_Sels ;
   private GXSimpleCollection<String> AV57TFAplIIGGExenCon_Sels ;
   private GXSimpleCollection<String> AV69TFAplIIGGPrrtear_Sels ;
   private GXSimpleCollection<String> AV63TFAplIIGGCondicion_Sels ;
   private GXSimpleCollection<String> AV39TFAplIIGGNom_Sels ;
   private GXSimpleCollection<String> AV76TFAplIIGGRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01K22_A3CliCod ;
   private String[] P01K22_A2020AplIIGGRelRef ;
   private String[] P01K22_A1124AplIIGGCondicion ;
   private boolean[] P01K22_n1124AplIIGGCondicion ;
   private String[] P01K22_A1121AplIIGGPrrtear ;
   private String[] P01K22_A1117AplIIGGExenCon ;
   private boolean[] P01K22_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] P01K22_A1119AplIIGGTopeFij ;
   private String[] P01K22_A1111AplIIGGTopeCon ;
   private boolean[] P01K22_n1111AplIIGGTopeCon ;
   private byte[] P01K22_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P01K22_A1114AplIIGGPropor ;
   private byte[] P01K22_A1120AplIIGGTrat ;
   private String[] P01K22_A1113AplIIGGNom ;
   private short[] P01K22_A1112AplIIGG ;
   private String[] P01K22_A1109AplIIGGTopeVar ;
   private boolean[] P01K22_n1109AplIIGGTopeVar ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ;
   private GXSimpleCollection<String> AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ;
   private GXSimpleCollection<String> AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ;
   private GXSimpleCollection<String> AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ;
   private GXSimpleCollection<String> AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ;
   private GXSimpleCollection<String> AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ;
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

final  class tipo_aplicacion_gananciaswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV66CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[12];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      scmdbuf += " AplIIGG, AplIIGGTopeVar FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV91Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ! (0==AV92Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ( AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV96Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV97Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ( AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV108Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV109Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGG" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGG DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGNom" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGTrat" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGTrat DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGPropor" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGPropor DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGTopeTip" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGTopeTip DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGTopeCon" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGTopeCon DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGTopeFij" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGTopeFij DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGExenCon" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGExenCon DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGPrrtear" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGPrrtear DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGCondicion" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGCondicion DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY AplIIGGRelRef" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY AplIIGGRelRef DESC" ;
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
                  return conditional_P01K22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((String[]) buf[15])[0] = rslt.getString(13, 40);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
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
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
      }
   }

}

