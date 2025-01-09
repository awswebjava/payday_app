package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajoexcel extends GXProcedure
{
   public importarlegajoexcel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajoexcel.class ), "" );
   }

   public importarlegajoexcel( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      importarlegajoexcel.this.AV18CliCod = aP0;
      importarlegajoexcel.this.AV8EmpCod = aP1;
      importarlegajoexcel.this.AV38FilePath = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, "1") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, "1") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, "2") ;
      AV47Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      GXt_boolean1 = AV57IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean2) ;
      importarlegajoexcel.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV57IsAuthorized = GXt_boolean1 ;
      if ( ! AV57IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV76Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV57IsAuthorized )
      {
         AV43IsOk = true ;
         /* Execute user subroutine: 'INITIALIZE PARAMETERS' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'LOAD EXTRA PARMETERS' */
         S311 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV27DoDelete )
         {
            /* Execute user subroutine: 'GET ALL RECORDS' */
            S221 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Execute user subroutine: 'PROCESS FILE' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV43IsOk || ! AV53StopOnError )
         {
            /* Execute user subroutine: 'DELETE REMAINING RECORDS' */
            S291 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "está ok ", "")+GXutil.trim( GXutil.booltostr( AV43IsOk))) ;
         if ( AV43IsOk )
         {
            /* Execute user subroutine: 'ADD SUCCESS MESSAGES' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'COMMIT UPDATES' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         AV43IsOk = false ;
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NotAuthorized", (byte)(1), httpContext.getMessage( "WWP_NotAuthorizedTitle", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "is ok ", "")+GXutil.trim( GXutil.booltostr( AV43IsOk))) ;
      if ( ! AV43IsOk )
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "importarlegajoexcel");
         AV58error = httpContext.getMessage( "IMPORTARLEGAJO_EXCEL Error ", "") ;
         AV77GXV1 = 1 ;
         while ( AV77GXV1 <= AV47Messages.size() )
         {
            AV59message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV47Messages.elementAt(-1+AV77GXV1));
            AV58error += GXutil.trim( AV59message.getgxTv_SdtMessages_Message_Description()) + ". " ;
            AV77GXV1 = (int)(AV77GXV1+1) ;
         }
         AV50NotificationInfo.setgxTv_SdtNotificationInfo_Id( AV58error );
         AV50NotificationInfo.setgxTv_SdtNotificationInfo_Message( httpContext.getMessage( "Error", "") );
         AV52ServerSocket.notify(AV50NotificationInfo);
      }
      else
      {
         AV50NotificationInfo.setgxTv_SdtNotificationInfo_Id( httpContext.getMessage( "IMPORTARLEGAJO_EXCEL OK", "") );
         AV50NotificationInfo.setgxTv_SdtNotificationInfo_Message( httpContext.getMessage( "OK", "") );
         AV52ServerSocket.notify(AV50NotificationInfo);
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'INITIALIZE PARAMETERS' Routine */
      returnInSub = false ;
      AV53StopOnError = false ;
      AV27DoDelete = true ;
      AV29DoUpdate = true ;
      AV28DoInsert = true ;
      AV33ErrorIfKeyColumnNotFound = true ;
      AV34ErrorIfUnmachingColumns = true ;
   }

   public void S121( )
   {
      /* 'ADD SUCCESS MESSAGES' Routine */
      returnInSub = false ;
      if ( AV17AddedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_AddedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records added.", ""), GXutil.trim( GXutil.str( AV17AddedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV56UpdatedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_UpdatedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records updated.", ""), GXutil.trim( GXutil.str( AV56UpdatedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV25DeletedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DeletedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records deleted.", ""), GXutil.trim( GXutil.str( AV25DeletedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV17AddedRecords + AV56UpdatedRecords + AV25DeletedRecords == 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoRecordsModified", (byte)(2), httpContext.getMessage( "No record was modified.", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "success", "")) ;
   }

   public void S131( )
   {
      /* 'COMMIT UPDATES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "antes de commit", "")) ;
      Application.commitDataStores(context, remoteHandle, pr_default, "importarlegajoexcel");
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "despues de commit", "")) ;
   }

   public void S141( )
   {
      /* 'PROCESS FILE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OPENDOCUMENT' */
      S151 ();
      if (returnInSub) return;
      AV45LineNumber = 1 ;
      AV45LineNumber = (long)(AV45LineNumber+2) ;
      AV24ContinueReading = true ;
      AV23ColumnTitlesFound = false ;
      while ( AV24ContinueReading )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&ColumnTitlesFound ", "")+GXutil.trim( GXutil.booltostr( AV23ColumnTitlesFound))+httpContext.getMessage( " &LineNumber ", "")+GXutil.trim( GXutil.str( AV45LineNumber, 10, 0))) ;
         if ( ! AV23ColumnTitlesFound )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "noooo encontro columna", "")) ;
            if ( GXutil.strcmp(AV35ExcelDocument.Cells((int)(AV45LineNumber), 1, 1, 1).getText(), "") != 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "tiene texto", "")) ;
               /* Execute user subroutine: 'GET TITLES POSITIONS' */
               S161 ();
               if (returnInSub) return;
               AV23ColumnTitlesFound = true ;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "nooo tiene texto", "")) ;
               if ( AV45LineNumber > 50 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "mas de 50", "")) ;
                  if ( GXutil.strcmp(AV35ExcelDocument.Cells(1, 1, 1, 1).getText(), "") != 0 )
                  {
                     AV45LineNumber = 0 ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "tiene textitoooo", "")) ;
                  }
                  else
                  {
                     GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
                     new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_TitlesNotFound", (byte)(1), httpContext.getMessage( "No se encontró título de columna.", ""), GXv_objcol_SdtMessages_Message3) ;
                     AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
                     AV24ContinueReading = false ;
                  }
               }
            }
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "siiii encontró columna", "")) ;
            AV51RowHasData = false ;
            AV20ColIndex = (short)(1) ;
            while ( AV20ColIndex <= 1 )
            {
               if ( GXutil.strcmp(AV35ExcelDocument.Cells((int)(AV45LineNumber), AV20ColIndex, 1, 1).getText(), "") != 0 )
               {
                  AV51RowHasData = true ;
                  if (true) break;
               }
               AV20ColIndex = (short)(AV20ColIndex+1) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&RowHasData ", "")+GXutil.trim( GXutil.booltostr( AV51RowHasData))) ;
            if ( AV51RowHasData )
            {
               /* Execute user subroutine: 'PROCESS LINE' */
               S171 ();
               if (returnInSub) return;
            }
            else
            {
               AV24ContinueReading = false ;
            }
         }
         AV45LineNumber = (long)(AV45LineNumber+1) ;
      }
      if ( ! AV70algunaLineaHay )
      {
         AV43IsOk = false ;
         AV59message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV59message.setgxTv_SdtMessages_Message_Id( httpContext.getMessage( "vacio", "") );
         AV59message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "El excel no contiene datos de legajos", "") );
         AV59message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV47Messages.add(AV59message, 0);
      }
      else
      {
         /* Execute user subroutine: 'FAMILIA' */
         S181 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'CLOSEDOCUMENT' */
      S191 ();
      if (returnInSub) return;
   }

   public void S181( )
   {
      /* 'FAMILIA' Routine */
      returnInSub = false ;
      AV45LineNumber = 3 ;
      AV35ExcelDocument.SelectSheet(httpContext.getMessage( "Familia", ""));
      AV24ContinueReading = true ;
      AV23ColumnTitlesFound = false ;
      while ( AV24ContinueReading )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-&ColumnTitlesFound ", "")+GXutil.trim( GXutil.booltostr( AV23ColumnTitlesFound))+httpContext.getMessage( " &LineNumber ", "")+GXutil.trim( GXutil.str( AV45LineNumber, 10, 0))) ;
         if ( ! AV23ColumnTitlesFound )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-(no) encontro columna", "")) ;
            if ( GXutil.strcmp(AV35ExcelDocument.Cells((int)(AV45LineNumber), 1, 1, 1).getText(), "") != 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-tiene texto 1", "")) ;
               /* Execute user subroutine: 'GET TITLES POSITIONS FAMILIA' */
               S201 ();
               if (returnInSub) return;
               AV23ColumnTitlesFound = true ;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-nooo tiene texto", "")) ;
               if ( AV45LineNumber > 50 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "mas de 50", "")) ;
                  if ( GXutil.strcmp(AV35ExcelDocument.Cells(1, 1, 1, 1).getText(), "") != 0 )
                  {
                     AV45LineNumber = 0 ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-tiene textitoooo", "")) ;
                  }
                  else
                  {
                     GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
                     new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_TitlesNotFound", (byte)(1), httpContext.getMessage( "No se encontró título de columna.", ""), GXv_objcol_SdtMessages_Message3) ;
                     AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
                     AV24ContinueReading = false ;
                  }
               }
            }
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-(si) encontró columna", "")) ;
            AV51RowHasData = false ;
            AV20ColIndex = (short)(1) ;
            while ( AV20ColIndex <= 1 )
            {
               if ( GXutil.strcmp(AV35ExcelDocument.Cells((int)(AV45LineNumber), AV20ColIndex, 1, 1).getText(), "") != 0 )
               {
                  AV51RowHasData = true ;
                  if (true) break;
               }
               AV20ColIndex = (short)(AV20ColIndex+1) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "-&RowHasData ", "")+GXutil.trim( GXutil.booltostr( AV51RowHasData))) ;
            if ( AV51RowHasData )
            {
               /* Execute user subroutine: 'PROCESS LINE FAMILIA' */
               S211 ();
               if (returnInSub) return;
            }
            else
            {
               AV24ContinueReading = false ;
            }
         }
         AV45LineNumber = (long)(AV45LineNumber+1) ;
      }
   }

   public void S221( )
   {
      /* 'GET ALL RECORDS' Routine */
      returnInSub = false ;
      AV19CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      AV32EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV49MigrLegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      /* Using cursor P01YX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01YX2_A1EmpCod[0] ;
         A3CliCod = P01YX2_A3CliCod[0] ;
         A87MigrLegNumero = P01YX2_A87MigrLegNumero[0] ;
         AV19CliCods.add((int)(A3CliCod), 0);
         AV32EmpCods.add((short)(A1EmpCod), 0);
         AV49MigrLegNumeros.add((int)(A87MigrLegNumero), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S161( )
   {
      /* 'GET TITLES POSITIONS' Routine */
      returnInSub = false ;
      AV67charExtra = "?" ;
      AV55TitleNames = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55TitleNames.add(httpContext.getMessage( "Modificar", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "ID/Código", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "CUIL", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Apellido", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Nombres", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Relación laboral", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Tipo de tarifa", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Frecuencia de pago", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Fecha de nacimiento", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Fecha de ingreso", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Género", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Domicilio", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Código Postal", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Teléfono", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Email", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Estado civil", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Área", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Sueldo fuera de convenio", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Sindicato", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Convenio", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Categoría", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Banco", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Obra social", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "CBU", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Zona", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Modalidad", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Horas normales semanales", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Actividad", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Condición", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Actividad laboral", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Puesto desempeñado", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Observaciones", ""), 0);
      GXv_char4[0] = AV26DiscardedColumns ;
      GXv_objcol_int5[0] = AV54TitleIndexes ;
      GXv_int6[0] = AV21ColumnsCount ;
      GXv_int7[0] = AV22ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV55TitleNames, AV35ExcelDocument, AV45LineNumber, GXv_char4, GXv_objcol_int5, GXv_int6, GXv_int7) ;
      importarlegajoexcel.this.AV26DiscardedColumns = GXv_char4[0] ;
      AV54TitleIndexes = GXv_objcol_int5[0] ;
      importarlegajoexcel.this.AV21ColumnsCount = GXv_int6[0] ;
      importarlegajoexcel.this.AV22ColumnsFound = GXv_int7[0] ;
      if ( ! (GXutil.strcmp("", AV26DiscardedColumns)==0) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DiscardedColumns", (byte)((AV34ErrorIfUnmachingColumns ? 1 : 0)), GXutil.format( httpContext.getMessage( "Las siguientes columnas no coinciden con ningún título a importar: %1.", ""), AV26DiscardedColumns, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         if ( AV34ErrorIfUnmachingColumns )
         {
            AV43IsOk = false ;
         }
      }
      if ( AV43IsOk && ( AV22ColumnsFound == 0 ) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoColumnFound", (byte)(1), httpContext.getMessage( "No se encontró título de columnas.", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV43IsOk = false ;
      }
      AV53StopOnError = (boolean)(AV53StopOnError||!AV43IsOk) ;
      AV24ContinueReading = AV43IsOk ;
   }

   public void S201( )
   {
      /* 'GET TITLES POSITIONS FAMILIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "Get titles positions familia 1", "")) ;
      AV67charExtra = "?" ;
      AV55TitleNames = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55TitleNames.add(httpContext.getMessage( "ID/Código", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Parentesco", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Nro. Doc.", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Nombre y apellido", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Fecha de nacimiento", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Deduce ganancias", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Adherente a la obra social", ""), 0);
      AV55TitleNames.add(httpContext.getMessage( "Discapacidad", ""), 0);
      GXv_char4[0] = AV26DiscardedColumns ;
      GXv_objcol_int5[0] = AV54TitleIndexes ;
      GXv_int7[0] = AV21ColumnsCount ;
      GXv_int6[0] = AV22ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV55TitleNames, AV35ExcelDocument, AV45LineNumber, GXv_char4, GXv_objcol_int5, GXv_int7, GXv_int6) ;
      importarlegajoexcel.this.AV26DiscardedColumns = GXv_char4[0] ;
      AV54TitleIndexes = GXv_objcol_int5[0] ;
      importarlegajoexcel.this.AV21ColumnsCount = GXv_int7[0] ;
      importarlegajoexcel.this.AV22ColumnsFound = GXv_int6[0] ;
      if ( ! (GXutil.strcmp("", AV26DiscardedColumns)==0) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DiscardedColumns", (byte)((AV34ErrorIfUnmachingColumns ? 1 : 0)), GXutil.format( httpContext.getMessage( "Las siguientes columnas no coinciden con ninguna columna a importar: %1.", ""), AV26DiscardedColumns, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         if ( AV34ErrorIfUnmachingColumns )
         {
            AV43IsOk = false ;
         }
      }
      if ( AV43IsOk && ( AV22ColumnsFound == 0 ) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoColumnFound", (byte)(1), httpContext.getMessage( "No se encontró título de columnas.", ""), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV43IsOk = false ;
      }
      AV53StopOnError = (boolean)(AV53StopOnError||!AV43IsOk) ;
      AV24ContinueReading = AV43IsOk ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "Get titles positions familia 2 &ContinueReading ", "")+GXutil.trim( GXutil.booltostr( AV24ContinueReading))+httpContext.getMessage( " &IsOk ", "")+GXutil.trim( GXutil.booltostr( AV43IsOk))) ;
   }

   public void S171( )
   {
      /* 'PROCESS LINE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "process line", "")) ;
      AV42IsLineOk = true ;
      AV40importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      /* Execute user subroutine: 'LOAD KEY' */
      S231 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'FIND RECORD' */
      S241 ();
      if (returnInSub) return;
      if ( (0==AV41Index) )
      {
         if ( AV28DoInsert )
         {
            AV17AddedRecords = (long)(AV17AddedRecords+1) ;
         }
         else
         {
            GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV45LineNumber, 10, 0)), "WWP_Import_RecordNotFound", httpContext.getMessage( "No se encontró registro", "")) ;
            AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV42IsLineOk = false ;
         }
      }
      else
      {
         if ( AV29DoUpdate )
         {
            AV56UpdatedRecords = (long)(AV56UpdatedRecords+1) ;
            if ( AV27DoDelete )
            {
               /* Execute user subroutine: 'REMOVE RECORD FROM REMAININGS' */
               S251 ();
               if (returnInSub) return;
               AV40importacion_legajo.Load(AV18CliCod, AV8EmpCod, AV48MigrLegNumero);
            }
            if ( ! AV40importacion_legajo.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV45LineNumber, 10, 0)), AV40importacion_legajo.GetMessages()) ;
               AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
               AV42IsLineOk = false ;
            }
         }
         else
         {
            GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV45LineNumber, 10, 0)), "WWP_Import_RecordFound_NoUpdate", httpContext.getMessage( "Se encontró registro equivalente y actualización no permitida.", "")) ;
            AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV42IsLineOk = false ;
         }
      }
      if ( AV42IsLineOk )
      {
         /* Execute user subroutine: 'SET RECORD VALUES' */
         S261 ();
         if (returnInSub) return;
         if ( AV42IsLineOk )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 1", "")) ;
            AV40importacion_legajo.Save();
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 2", "")) ;
            if ( ! AV40importacion_legajo.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV45LineNumber, 10, 0)), AV40importacion_legajo.GetMessages()) ;
               AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
               AV42IsLineOk = false ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 3", "")) ;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 4", "")) ;
               AV65itemSdtMigrLeg = (web.Sdtsdt_migrleg_sdt_migrlegItem)new web.Sdtsdt_migrleg_sdt_migrlegItem(remoteHandle, context);
               AV65itemSdtMigrLeg.setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero( AV40importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnumero() );
               AV65itemSdtMigrLeg.setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid( AV40importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegid() );
               AV64sdt_migrleg.add(AV65itemSdtMigrLeg, 0);
            }
         }
      }
      AV43IsOk = (boolean)(AV43IsOk&&AV42IsLineOk) ;
      AV24ContinueReading = (boolean)((!AV53StopOnError||AV43IsOk)) ;
   }

   public void S211( )
   {
      /* 'PROCESS LINE FAMILIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "process line familia", "")) ;
      AV42IsLineOk = true ;
      AV60importacion_legajo_familia = (web.Sdtimportacion_legajo_Familia)new web.Sdtimportacion_legajo_Familia( remoteHandle, context);
      /* Execute user subroutine: 'LOAD KEY FAMILIA' */
      S271 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SET RECORD VALUES FAMILIA' */
      S281 ();
      if (returnInSub) return;
      AV63auxMigrLegNumero = 0 ;
      AV79GXV2 = 1 ;
      while ( AV79GXV2 <= AV64sdt_migrleg.size() )
      {
         AV65itemSdtMigrLeg = (web.Sdtsdt_migrleg_sdt_migrlegItem)((web.Sdtsdt_migrleg_sdt_migrlegItem)AV64sdt_migrleg.elementAt(-1+AV79GXV2));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&itemSdtMigrLeg ", "")+GXutil.trim( AV65itemSdtMigrLeg.getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid())+httpContext.getMessage( " &LegIdAux.Trim() ", "")+GXutil.trim( GXutil.trim( AV62LegIdAux))) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV65itemSdtMigrLeg.getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid())), GXutil.upper( GXutil.trim( AV62LegIdAux))) == 0 )
         {
            AV63auxMigrLegNumero = AV65itemSdtMigrLeg.getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero() ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "encuentra ", "")+GXutil.trim( GXutil.str( AV63auxMigrLegNumero, 8, 0))) ;
            if (true) break;
         }
         AV79GXV2 = (int)(AV79GXV2+1) ;
      }
      if ( (0==AV63auxMigrLegNumero) )
      {
         AV47Messages.clear();
         AV59message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV59message.setgxTv_SdtMessages_Message_Id( httpContext.getMessage( "No se pudo relacionar registro de familia con legajo", "") );
         AV59message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "No se pudo relacionar registro de familia con legajo ", "")+GXutil.trim( AV62LegIdAux)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))+httpContext.getMessage( " &&EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0)) );
         AV47Messages.add(AV59message, 0);
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, "", AV47Messages) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV42IsLineOk = false ;
         AV43IsOk = false ;
         AV24ContinueReading = false ;
      }
      else
      {
         AV40importacion_legajo.Load(AV18CliCod, AV8EmpCod, AV63auxMigrLegNumero);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 5", "")) ;
         AV40importacion_legajo.getgxTv_Sdtimportacion_legajo_Familia().add(AV60importacion_legajo_familia, 0);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 6", "")) ;
         AV40importacion_legajo.Save();
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 7", "")) ;
         if ( ! AV40importacion_legajo.Success() )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 8", "")) ;
            GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV45LineNumber, 10, 0)), AV40importacion_legajo.GetMessages()) ;
            AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV42IsLineOk = false ;
         }
      }
      AV43IsOk = (boolean)(AV43IsOk&&AV42IsLineOk) ;
      AV24ContinueReading = (boolean)((!AV53StopOnError||AV43IsOk)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "save 9", "")) ;
   }

   public void S261( )
   {
      /* 'SET RECORD VALUES' Routine */
      returnInSub = false ;
      AV70algunaLineaHay = true ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "Set record values", "")) ;
      AV73s = (short)(2) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodtra( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclase( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getDate() );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getDate() );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegsexo( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegdomici( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcodpos( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtelefono( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegemail( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegarea( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&importacion_legajo.MigrLegNombre ", "")+AV40importacion_legajo.getgxTv_Sdtimportacion_legajo_Migrlegnombre()) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&ExcelDocument.Cells(&LineNumber, &TitleIndexes.item(&s)).text ", "")+AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText()) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&ExcelDocument.Cells(&LineNumber, &TitleIndexes.item(&s)).number ", "")+GXutil.str( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getNumber(), 10, 2)) ;
         AV72MigrLegBasicoStr = AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText() ;
         AV71MigrLegBasico = CommonUtil.decimalVal( AV72MigrLegBasicoStr, ".") ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbasico( AV71MigrLegBasico );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegsindicato( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegconvenio( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcategoria( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbanco( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcbu( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegzona( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrleghorsem( DecimalUtil.doubleToDec(AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getNumber()) );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegactividad( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcondicion( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegpueafip( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV73s)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobs( GXt_char8 );
      }
      AV73s = (short)(AV73s+1) ;
      AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrvalcadasave( true );
   }

   public void S281( )
   {
      /* 'SET RECORD VALUES FAMILIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "Set record values familia", "")) ;
      GXt_char8 = AV62LegIdAux ;
      GXv_char4[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+1)).shortValue(), 1, 1).getText(), GXv_char4) ;
      importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
      AV62LegIdAux = GXt_char8 ;
      AV66f = (short)(2) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamparen( GXt_char8 );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnrodoc( GXt_char8 );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamnomape( GXt_char8 );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamfecnac( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getDate() );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         AV68palabra = AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText() ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV68palabra)), "100%") == 0 )
         {
            AV69porUnaje = DecimalUtil.doubleToDec(1) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV68palabra)), "50%") == 0 )
         {
            AV69porUnaje = DecimalUtil.stringToDec("0.5") ;
         }
         else
         {
            AV69porUnaje = DecimalUtil.ZERO ;
         }
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdedgan( AV69porUnaje );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamadh( GXt_char8 );
      }
      AV66f = (short)(AV66f+1) ;
      if ( ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV35ExcelDocument.Cells((int)(AV45LineNumber), ((Number) AV54TitleIndexes.elementAt(-1+AV66f)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importarlegajoexcel.this.GXt_char8 = GXv_char4[0] ;
         AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamdiscap( GXt_char8 );
      }
   }

   public void S251( )
   {
      /* 'REMOVE RECORD FROM REMAININGS' Routine */
      returnInSub = false ;
      AV19CliCods.removeItem((int)(AV41Index));
      AV32EmpCods.removeItem((int)(AV41Index));
      AV49MigrLegNumeros.removeItem((int)(AV41Index));
   }

   public void S231( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
      AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Clicod( AV18CliCod );
      AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Empcod( AV8EmpCod );
      GXv_int9[0] = AV48MigrLegNumero ;
      new web.obtieneultimolegajomigracion(remoteHandle, context).execute( AV18CliCod, AV8EmpCod, GXv_int9) ;
      importarlegajoexcel.this.AV48MigrLegNumero = GXv_int9[0] ;
      AV48MigrLegNumero = (int)(AV48MigrLegNumero+1) ;
      AV40importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnumero( AV48MigrLegNumero );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV48MigrLegNumero, 8, 0))) ;
   }

   public void S271( )
   {
      /* 'LOAD KEY FAMILIA' Routine */
      returnInSub = false ;
      AV61MigrLegFamSec = (short)(AV61MigrLegFamSec+1) ;
      AV60importacion_legajo_familia.setgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec( AV61MigrLegFamSec );
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&&MigrLegFamSec ", "")+GXutil.trim( GXutil.str( AV61MigrLegFamSec, 4, 0))) ;
   }

   public void S241( )
   {
      /* 'FIND RECORD' Routine */
      returnInSub = false ;
      if ( AV27DoDelete )
      {
         AV41Index = 0 ;
         AV39i = 1 ;
         while ( AV39i <= AV19CliCods.size() )
         {
            if ( ( ((Number) AV19CliCods.elementAt(-1+(int)(AV39i))).intValue() == AV18CliCod ) && ( ((Number) AV32EmpCods.elementAt(-1+(int)(AV39i))).shortValue() == AV8EmpCod ) && ( ((Number) AV49MigrLegNumeros.elementAt(-1+(int)(AV39i))).intValue() == AV48MigrLegNumero ) )
            {
               AV41Index = AV39i ;
               if (true) break;
            }
            AV39i = (long)(AV39i+1) ;
         }
      }
      else
      {
         AV40importacion_legajo.Load(AV18CliCod, AV8EmpCod, AV48MigrLegNumero);
         if ( AV40importacion_legajo.Success() )
         {
            AV41Index = 1 ;
         }
         else
         {
            AV41Index = 0 ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV76Pgmname, httpContext.getMessage( "&index ", "")+GXutil.trim( GXutil.str( AV41Index, 10, 0))) ;
   }

   public void S291( )
   {
      /* 'DELETE REMAINING RECORDS' Routine */
      returnInSub = false ;
      AV25DeletedRecords = AV19CliCods.size() ;
      AV39i = 1 ;
      while ( AV39i <= AV19CliCods.size() )
      {
         AV48MigrLegNumero = ((Number) AV49MigrLegNumeros.elementAt(-1+(int)(AV39i))).intValue() ;
         AV40importacion_legajo.Load(AV18CliCod, AV8EmpCod, AV48MigrLegNumero);
         if ( AV40importacion_legajo.Success() )
         {
            AV40importacion_legajo.Delete();
         }
         if ( ! AV40importacion_legajo.Success() )
         {
            GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.format( httpContext.getMessage( "(Deleting %1)", ""), httpContext.getMessage( "Cli Cod", "")+": "+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))+", "+httpContext.getMessage( "Empresa", "")+": "+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+", "+httpContext.getMessage( "Migr Leg Numero", "")+": "+GXutil.trim( GXutil.str( AV48MigrLegNumero, 8, 0)), "", "", "", "", "", "", "", ""), AV40importacion_legajo.GetMessages()) ;
            AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV43IsOk = false ;
            if ( AV53StopOnError )
            {
               if (true) break;
            }
         }
         AV39i = (long)(AV39i+1) ;
      }
   }

   public void S151( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV35ExcelDocument.Open(AV38FilePath);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S301 ();
      if (returnInSub) return;
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV35ExcelDocument.Close();
   }

   public void S301( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV35ExcelDocument.getErrCode() != 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV47Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( httpContext.getMessage( "WWP_ErrorExcelDocument", ""), (byte)(1), AV35ExcelDocument.getErrDescription(), GXv_objcol_SdtMessages_Message3) ;
         AV47Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV35ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S311( )
   {
      /* 'LOAD EXTRA PARMETERS' Routine */
      returnInSub = false ;
      AV36ExtraParms.fromJSonString(AV37ExtraParmsJson, null);
      if ( AV36ExtraParms.size() == 1 )
      {
         AV46MenuOpcCod = (String)AV36ExtraParms.elementAt(-1+1) ;
      }
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      AV35ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV76Pgmname = "" ;
      AV47Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV58error = "" ;
      AV59message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV50NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV52ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      AV35ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV32EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV49MigrLegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      scmdbuf = "" ;
      P01YX2_A1EmpCod = new short[1] ;
      P01YX2_A3CliCod = new int[1] ;
      P01YX2_A87MigrLegNumero = new int[1] ;
      AV67charExtra = "" ;
      AV55TitleNames = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26DiscardedColumns = "" ;
      AV54TitleIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int5 = new GXSimpleCollection[1] ;
      GXv_int7 = new short[1] ;
      GXv_int6 = new short[1] ;
      AV40importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      AV65itemSdtMigrLeg = new web.Sdtsdt_migrleg_sdt_migrlegItem(remoteHandle, context);
      AV64sdt_migrleg = new GXBaseCollection<web.Sdtsdt_migrleg_sdt_migrlegItem>(web.Sdtsdt_migrleg_sdt_migrlegItem.class, "sdt_migrlegItem", "PayDay", remoteHandle);
      AV60importacion_legajo_familia = new web.Sdtimportacion_legajo_Familia(remoteHandle);
      AV62LegIdAux = "" ;
      AV72MigrLegBasicoStr = "" ;
      AV71MigrLegBasico = DecimalUtil.ZERO ;
      AV68palabra = "" ;
      AV69porUnaje = DecimalUtil.ZERO ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_int9 = new int[1] ;
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      AV36ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37ExtraParmsJson = "" ;
      AV46MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajoexcel__default(),
         new Object[] {
             new Object[] {
            P01YX2_A1EmpCod, P01YX2_A3CliCod, P01YX2_A87MigrLegNumero
            }
         }
      );
      AV76Pgmname = "importarLegajoExcel" ;
      /* GeneXus formulas. */
      AV76Pgmname = "importarLegajoExcel" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV20ColIndex ;
   private short A1EmpCod ;
   private short AV21ColumnsCount ;
   private short AV22ColumnsFound ;
   private short GXv_int7[] ;
   private short GXv_int6[] ;
   private short AV73s ;
   private short AV66f ;
   private short AV61MigrLegFamSec ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV77GXV1 ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int AV48MigrLegNumero ;
   private int AV63auxMigrLegNumero ;
   private int AV79GXV2 ;
   private int GXv_int9[] ;
   private long AV17AddedRecords ;
   private long AV56UpdatedRecords ;
   private long AV25DeletedRecords ;
   private long AV45LineNumber ;
   private long AV41Index ;
   private long AV39i ;
   private java.math.BigDecimal AV71MigrLegBasico ;
   private java.math.BigDecimal AV69porUnaje ;
   private String AV76Pgmname ;
   private String scmdbuf ;
   private String AV67charExtra ;
   private String AV62LegIdAux ;
   private String AV72MigrLegBasicoStr ;
   private String AV68palabra ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private boolean AV57IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean AV43IsOk ;
   private boolean returnInSub ;
   private boolean AV27DoDelete ;
   private boolean AV53StopOnError ;
   private boolean AV29DoUpdate ;
   private boolean AV28DoInsert ;
   private boolean AV33ErrorIfKeyColumnNotFound ;
   private boolean AV34ErrorIfUnmachingColumns ;
   private boolean AV24ContinueReading ;
   private boolean AV23ColumnTitlesFound ;
   private boolean AV51RowHasData ;
   private boolean AV70algunaLineaHay ;
   private boolean AV42IsLineOk ;
   private String AV38FilePath ;
   private String AV58error ;
   private String AV26DiscardedColumns ;
   private String AV37ExtraParmsJson ;
   private String AV46MenuOpcCod ;
   private GXSimpleCollection<Short> AV32EmpCods ;
   private GXSimpleCollection<Short> AV54TitleIndexes ;
   private GXSimpleCollection<Short> GXv_objcol_int5[] ;
   private GXSimpleCollection<Integer> AV19CliCods ;
   private GXSimpleCollection<Integer> AV49MigrLegNumeros ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV50NotificationInfo ;
   private IDataStoreProvider pr_default ;
   private short[] P01YX2_A1EmpCod ;
   private int[] P01YX2_A3CliCod ;
   private int[] P01YX2_A87MigrLegNumero ;
   private com.genexus.gxoffice.ExcelDoc AV35ExcelDocument ;
   private GXSimpleCollection<String> AV55TitleNames ;
   private GXSimpleCollection<String> AV36ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV47Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private GXBaseCollection<web.Sdtsdt_migrleg_sdt_migrlegItem> AV64sdt_migrleg ;
   private com.genexus.SdtMessages_Message AV59message ;
   private web.Sdtimportacion_legajo AV40importacion_legajo ;
   private web.Sdtimportacion_legajo_Familia AV60importacion_legajo_familia ;
   private com.genexuscore.genexus.server.SdtSocket AV52ServerSocket ;
   private web.Sdtsdt_migrleg_sdt_migrlegItem AV65itemSdtMigrLeg ;
}

final  class importarlegajoexcel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YX2", "SELECT EmpCod, CliCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

