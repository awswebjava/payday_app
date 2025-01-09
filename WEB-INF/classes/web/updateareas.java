package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateareas extends GXProcedure
{
   public updateareas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateareas.class ), "" );
   }

   public updateareas( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updateareas.this.AV14ClientePadre = aP0;
      updateareas.this.AV13CliCod = aP1;
      updateareas.this.AV18CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV27padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV14ClientePadre), AV18CliRelSec, GXv_dtime1) ;
      updateareas.this.AV27padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV14ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV18CliRelSec, 6, 0))) ;
      AV35GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV18CliRelSec) ,
                                           Integer.valueOf(A1984SecRelSec) ,
                                           Long.valueOf(AV14ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P02962 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV14ClientePadre), Integer.valueOf(AV18CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1984SecRelSec = P02962_A1984SecRelSec[0] ;
         A3CliCod = P02962_A3CliCod[0] ;
         A13SecCodigo = P02962_A13SecCodigo[0] ;
         A329SecDescrip = P02962_A329SecDescrip[0] ;
         A330SecHabilitada = P02962_A330SecHabilitada[0] ;
         A2308SecApoOpc = P02962_A2308SecApoOpc[0] ;
         A2033SecOld = P02962_A2033SecOld[0] ;
         AV35GXLvl4 = (byte)(1) ;
         AV24importar = false ;
         AV25liberacionPendiente = false ;
         if ( ! (0==AV18CliRelSec) )
         {
            AV24importar = true ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "SecCodigo ", "")+GXutil.trim( A13SecCodigo)+httpContext.getMessage( " SecRelSec ", "")+GXutil.trim( GXutil.str( A1984SecRelSec, 6, 0))) ;
            if ( (0==A1984SecRelSec) )
            {
               AV24importar = true ;
            }
            else
            {
               GXv_dtime1[0] = AV17CliRelease ;
               GXv_boolean2[0] = AV16CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A1984SecRelSec, GXv_dtime1, GXv_boolean2) ;
               updateareas.this.AV17CliRelease = GXv_dtime1[0] ;
               updateareas.this.AV16CliReHabilitado = GXv_boolean2[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV16CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV17CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV16CliReHabilitado ) && (( AV17CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV17CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV24importar = true ;
               }
               else
               {
                  GXv_boolean2[0] = AV8alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1984SecRelSec, GXv_boolean2) ;
                  updateareas.this.AV8alguienYaActualizo = GXv_boolean2[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV8alguienYaActualizo))) ;
                  if ( AV8alguienYaActualizo )
                  {
                     AV24importar = true ;
                  }
                  else
                  {
                     AV25liberacionPendiente = true ;
                  }
               }
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV24importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV25liberacionPendiente))) ;
         if ( AV24importar )
         {
            AV29SecCodigo = A13SecCodigo ;
            AV30SecDescrip = A329SecDescrip ;
            AV31SecHabilitada = A330SecHabilitada ;
            AV28SecApoOpc = A2308SecApoOpc ;
            /* Execute user subroutine: 'HIJO' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "vengo", "")) ;
            if ( AV25liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2033SecOld)==0) )
               {
                  AV29SecCodigo = A13SecCodigo ;
                  AV10area_old.fromJSonString(GXutil.trim( A2033SecOld), null);
                  AV30SecDescrip = AV10area_old.getgxTv_Sdtarea_old_Secdescrip() ;
                  AV31SecHabilitada = AV10area_old.getgxTv_Sdtarea_old_Sechabilitada() ;
                  AV28SecApoOpc = AV10area_old.getgxTv_Sdtarea_old_Secapoopc() ;
                  /* Execute user subroutine: 'HIJO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV35GXLvl4 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "4 &SecCodigo ", "")+AV29SecCodigo) ;
      AV36GXLvl68 = (byte)(0) ;
      /* Using cursor P02963 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Long.valueOf(AV14ClientePadre), AV29SecCodigo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1986SecPadre = P02963_A1986SecPadre[0] ;
         A1985SecRelSecCli = P02963_A1985SecRelSecCli[0] ;
         A3CliCod = P02963_A3CliCod[0] ;
         A1984SecRelSec = P02963_A1984SecRelSec[0] ;
         A329SecDescrip = P02963_A329SecDescrip[0] ;
         A330SecHabilitada = P02963_A330SecHabilitada[0] ;
         A2308SecApoOpc = P02963_A2308SecApoOpc[0] ;
         A675SecDescripSinAc = P02963_A675SecDescripSinAc[0] ;
         A13SecCodigo = P02963_A13SecCodigo[0] ;
         AV36GXLvl68 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, "5") ;
         if ( ! (0==AV18CliRelSec) )
         {
            GXv_dtime1[0] = AV22hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1984SecRelSec, GXv_dtime1) ;
            updateareas.this.AV22hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, "6") ;
            if ( AV27padreReleaseDateTime.after( AV22hijoReleaseDateTime ) )
            {
               A329SecDescrip = AV30SecDescrip ;
               A330SecHabilitada = AV31SecHabilitada ;
               A2308SecApoOpc = AV28SecApoOpc ;
               GXt_char3 = A675SecDescripSinAc ;
               GXv_char4[0] = GXt_char3 ;
               new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char4) ;
               updateareas.this.GXt_char3 = GXv_char4[0] ;
               A675SecDescripSinAc = GXt_char3 ;
               A1984SecRelSec = AV18CliRelSec ;
               A1985SecRelSecCli = (int)(AV14ClientePadre) ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P02964 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A1985SecRelSecCli), Integer.valueOf(A1984SecRelSec), A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Boolean.valueOf(A2308SecApoOpc), A675SecDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
         if (true) break;
         /* Using cursor P02965 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1985SecRelSecCli), Integer.valueOf(A1984SecRelSec), A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Boolean.valueOf(A2308SecApoOpc), A675SecDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV36GXLvl68 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV34Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV25liberacionPendiente))) ;
         /* Execute user subroutine: 'GET NUEVO ID' */
         S121 ();
         if (returnInSub) return;
         new web.newarea(remoteHandle, context).execute( AV13CliCod, AV26nuevoSecCodigo, AV30SecDescrip, AV28SecApoOpc, AV31SecHabilitada, AV18CliRelSec, (int)(AV14ClientePadre), AV29SecCodigo) ;
      }
   }

   public void S121( )
   {
      /* 'GET NUEVO ID' Routine */
      returnInSub = false ;
      AV12auxSecCodigo = AV29SecCodigo ;
      AV23i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV37GXLvl103 = (byte)(0) ;
         /* Using cursor P02966 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV13CliCod), AV12auxSecCodigo});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A13SecCodigo = P02966_A13SecCodigo[0] ;
            A3CliCod = P02966_A3CliCod[0] ;
            AV37GXLvl103 = (byte)(1) ;
            AV23i = (short)(AV23i+1) ;
            AV12auxSecCodigo = GXutil.trim( AV29SecCodigo) + "_" + GXutil.trim( GXutil.str( AV23i, 4, 0)) ;
            if ( GXutil.len( GXutil.trim( AV12auxSecCodigo)) > 6 )
            {
               GXt_char3 = AV12auxSecCodigo ;
               GXv_char4[0] = GXt_char3 ;
               new web.codigoaleatorio(remoteHandle, context).execute( (short)(6), GXv_char4) ;
               updateareas.this.GXt_char3 = GXv_char4[0] ;
               AV12auxSecCodigo = GXt_char3 ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         if ( AV37GXLvl103 == 0 )
         {
            AV26nuevoSecCodigo = AV12auxSecCodigo ;
         }
         if ( ! (GXutil.strcmp("", AV26nuevoSecCodigo)==0) )
         {
            if (true) break;
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateareas");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV34Pgmname = "" ;
      scmdbuf = "" ;
      P02962_A1984SecRelSec = new int[1] ;
      P02962_A3CliCod = new int[1] ;
      P02962_A13SecCodigo = new String[] {""} ;
      P02962_A329SecDescrip = new String[] {""} ;
      P02962_A330SecHabilitada = new boolean[] {false} ;
      P02962_A2308SecApoOpc = new boolean[] {false} ;
      P02962_A2033SecOld = new String[] {""} ;
      A13SecCodigo = "" ;
      A329SecDescrip = "" ;
      A2033SecOld = "" ;
      AV17CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV29SecCodigo = "" ;
      AV30SecDescrip = "" ;
      AV10area_old = new web.Sdtarea_old(remoteHandle, context);
      A675SecDescripSinAc = "" ;
      P02963_A1986SecPadre = new String[] {""} ;
      P02963_A1985SecRelSecCli = new int[1] ;
      P02963_A3CliCod = new int[1] ;
      P02963_A1984SecRelSec = new int[1] ;
      P02963_A329SecDescrip = new String[] {""} ;
      P02963_A330SecHabilitada = new boolean[] {false} ;
      P02963_A2308SecApoOpc = new boolean[] {false} ;
      P02963_A675SecDescripSinAc = new String[] {""} ;
      P02963_A13SecCodigo = new String[] {""} ;
      A1986SecPadre = "" ;
      AV22hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV26nuevoSecCodigo = "" ;
      AV12auxSecCodigo = "" ;
      P02966_A13SecCodigo = new String[] {""} ;
      P02966_A3CliCod = new int[1] ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateareas__default(),
         new Object[] {
             new Object[] {
            P02962_A1984SecRelSec, P02962_A3CliCod, P02962_A13SecCodigo, P02962_A329SecDescrip, P02962_A330SecHabilitada, P02962_A2308SecApoOpc, P02962_A2033SecOld
            }
            , new Object[] {
            P02963_A1986SecPadre, P02963_A1985SecRelSecCli, P02963_A3CliCod, P02963_A1984SecRelSec, P02963_A329SecDescrip, P02963_A330SecHabilitada, P02963_A2308SecApoOpc, P02963_A675SecDescripSinAc, P02963_A13SecCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P02966_A13SecCodigo, P02966_A3CliCod
            }
         }
      );
      AV34Pgmname = "updateAreas" ;
      /* GeneXus formulas. */
      AV34Pgmname = "updateAreas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV35GXLvl4 ;
   private byte AV36GXLvl68 ;
   private byte AV37GXLvl103 ;
   private short AV23i ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV18CliRelSec ;
   private int A1984SecRelSec ;
   private int A3CliCod ;
   private int A1985SecRelSecCli ;
   private long AV14ClientePadre ;
   private String AV34Pgmname ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String AV29SecCodigo ;
   private String A1986SecPadre ;
   private String AV26nuevoSecCodigo ;
   private String AV12auxSecCodigo ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private java.util.Date AV27padreReleaseDateTime ;
   private java.util.Date AV17CliRelease ;
   private java.util.Date AV22hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean A330SecHabilitada ;
   private boolean A2308SecApoOpc ;
   private boolean AV24importar ;
   private boolean AV25liberacionPendiente ;
   private boolean AV16CliReHabilitado ;
   private boolean AV8alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean AV31SecHabilitada ;
   private boolean AV28SecApoOpc ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String A2033SecOld ;
   private String A329SecDescrip ;
   private String AV30SecDescrip ;
   private String A675SecDescripSinAc ;
   private IDataStoreProvider pr_default ;
   private int[] P02962_A1984SecRelSec ;
   private int[] P02962_A3CliCod ;
   private String[] P02962_A13SecCodigo ;
   private String[] P02962_A329SecDescrip ;
   private boolean[] P02962_A330SecHabilitada ;
   private boolean[] P02962_A2308SecApoOpc ;
   private String[] P02962_A2033SecOld ;
   private String[] P02963_A1986SecPadre ;
   private int[] P02963_A1985SecRelSecCli ;
   private int[] P02963_A3CliCod ;
   private int[] P02963_A1984SecRelSec ;
   private String[] P02963_A329SecDescrip ;
   private boolean[] P02963_A330SecHabilitada ;
   private boolean[] P02963_A2308SecApoOpc ;
   private String[] P02963_A675SecDescripSinAc ;
   private String[] P02963_A13SecCodigo ;
   private String[] P02966_A13SecCodigo ;
   private int[] P02966_A3CliCod ;
   private web.Sdtarea_old AV10area_old ;
}

final  class updateareas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02962( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV18CliRelSec ,
                                          int A1984SecRelSec ,
                                          long AV14ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[2];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT SecRelSec, CliCod, SecCodigo, SecDescrip, SecHabilitada, SecApoOpc, SecOld FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV18CliRelSec) )
      {
         addWhere(sWhereString, "(SecRelSec = ?)");
      }
      else
      {
         GXv_int5[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P02962(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02962", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02963", "SELECT SecPadre, SecRelSecCli, CliCod, SecRelSec, SecDescrip, SecHabilitada, SecApoOpc, SecDescripSinAc, SecCodigo FROM Seccion WHERE (CliCod = ?) AND (SecRelSecCli = ?) AND (SecPadre = ( ?)) ORDER BY CliCod  LIMIT 1 FOR UPDATE OF Seccion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02964", "SAVEPOINT gxupdate;UPDATE Seccion SET SecRelSecCli=?, SecRelSec=?, SecDescrip=?, SecHabilitada=?, SecApoOpc=?, SecDescripSinAc=?  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02965", "SAVEPOINT gxupdate;UPDATE Seccion SET SecRelSecCli=?, SecRelSec=?, SecDescrip=?, SecHabilitada=?, SecApoOpc=?, SecDescripSinAc=?  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02966", "SELECT SecCodigo, CliCod FROM Seccion WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

