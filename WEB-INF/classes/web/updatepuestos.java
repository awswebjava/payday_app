package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatepuestos extends GXProcedure
{
   public updatepuestos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatepuestos.class ), "" );
   }

   public updatepuestos( int remoteHandle ,
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
      updatepuestos.this.AV13ClientePadre = aP0;
      updatepuestos.this.AV12CliCod = aP1;
      updatepuestos.this.AV15CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV21padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV13ClientePadre), AV15CliRelSec, GXv_dtime1) ;
      updatepuestos.this.AV21padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV13ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV15CliRelSec, 6, 0))) ;
      AV41GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV15CliRelSec) ,
                                           Integer.valueOf(A1987PuestoRelSec) ,
                                           Long.valueOf(AV13ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P02972 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV13ClientePadre), Integer.valueOf(AV15CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1987PuestoRelSec = P02972_A1987PuestoRelSec[0] ;
         A3CliCod = P02972_A3CliCod[0] ;
         A1240PuestoCodigo = P02972_A1240PuestoCodigo[0] ;
         A13SecCodigo = P02972_A13SecCodigo[0] ;
         A1241PuestoDescrip = P02972_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = P02972_A1255PuestoHorasExt[0] ;
         A2034PuestoOld = P02972_A2034PuestoOld[0] ;
         AV41GXLvl4 = (byte)(1) ;
         AV22importar = false ;
         AV25liberacionPendiente = false ;
         if ( ! (0==AV15CliRelSec) )
         {
            AV22importar = true ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "PuestoCodigo ", "")+GXutil.trim( A1240PuestoCodigo)+httpContext.getMessage( " PuestoRelSec ", "")+GXutil.trim( GXutil.str( A1987PuestoRelSec, 6, 0))) ;
            if ( (0==A1987PuestoRelSec) )
            {
               AV22importar = true ;
            }
            else
            {
               GXv_dtime1[0] = AV23CliRelease ;
               GXv_boolean2[0] = AV24CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A1987PuestoRelSec, GXv_dtime1, GXv_boolean2) ;
               updatepuestos.this.AV23CliRelease = GXv_dtime1[0] ;
               updatepuestos.this.AV24CliReHabilitado = GXv_boolean2[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV24CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV23CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV24CliReHabilitado ) && (( AV23CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV23CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV22importar = true ;
               }
               else
               {
                  GXv_boolean2[0] = AV29alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1987PuestoRelSec, GXv_boolean2) ;
                  updatepuestos.this.AV29alguienYaActualizo = GXv_boolean2[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV29alguienYaActualizo))) ;
                  if ( AV29alguienYaActualizo )
                  {
                     AV22importar = true ;
                  }
                  else
                  {
                     AV25liberacionPendiente = true ;
                  }
               }
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV22importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV25liberacionPendiente))) ;
         if ( AV22importar )
         {
            AV32SecCodigo = A13SecCodigo ;
            AV36PuestoCodigo = A1240PuestoCodigo ;
            AV33PuestoDescrip = A1241PuestoDescrip ;
            AV34PuestoHorasExt = A1255PuestoHorasExt ;
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
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "vengo", "")) ;
            if ( AV25liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2034PuestoOld)==0) )
               {
                  AV32SecCodigo = A13SecCodigo ;
                  AV36PuestoCodigo = A1240PuestoCodigo ;
                  AV35puesto_old.fromJSonString(GXutil.trim( A2034PuestoOld), null);
                  AV33PuestoDescrip = AV35puesto_old.getgxTv_Sdtpuesto_old_Puestodescrip() ;
                  AV34PuestoHorasExt = AV35puesto_old.getgxTv_Sdtpuesto_old_Puestohorasext() ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&PuestoDescrip old ", "")+GXutil.trim( AV33PuestoDescrip)) ;
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
      if ( AV41GXLvl4 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "4") ;
      AV42GXLvl66 = (byte)(0) ;
      /* Using cursor P02973 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod), AV32SecCodigo, Long.valueOf(AV13ClientePadre), AV36PuestoCodigo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1989PuestoPadre = P02973_A1989PuestoPadre[0] ;
         A1988PuestoRelSecCli = P02973_A1988PuestoRelSecCli[0] ;
         A13SecCodigo = P02973_A13SecCodigo[0] ;
         A3CliCod = P02973_A3CliCod[0] ;
         A1987PuestoRelSec = P02973_A1987PuestoRelSec[0] ;
         A1241PuestoDescrip = P02973_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = P02973_A1255PuestoHorasExt[0] ;
         A1242PuestoDescripSinAc = P02973_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = P02973_A1240PuestoCodigo[0] ;
         AV42GXLvl66 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "5") ;
         if ( ! (0==AV15CliRelSec) )
         {
            GXv_dtime1[0] = AV18hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1987PuestoRelSec, GXv_dtime1) ;
            updatepuestos.this.AV18hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "6") ;
            if ( AV21padreReleaseDateTime.after( AV18hijoReleaseDateTime ) )
            {
               A1241PuestoDescrip = AV33PuestoDescrip ;
               A1255PuestoHorasExt = AV34PuestoHorasExt ;
               GXt_char3 = A1242PuestoDescripSinAc ;
               GXv_char4[0] = GXt_char3 ;
               new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char4) ;
               updatepuestos.this.GXt_char3 = GXv_char4[0] ;
               A1242PuestoDescripSinAc = GXt_char3 ;
               A1987PuestoRelSec = AV15CliRelSec ;
               A1988PuestoRelSecCli = (int)(AV13ClientePadre) ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P02974 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A1988PuestoRelSecCli), Integer.valueOf(A1987PuestoRelSec), A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), A1242PuestoDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         if (true) break;
         /* Using cursor P02975 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1988PuestoRelSecCli), Integer.valueOf(A1987PuestoRelSec), A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), A1242PuestoDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV42GXLvl66 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV25liberacionPendiente))) ;
         /* Execute user subroutine: 'GET NUEVO ID' */
         S121 ();
         if (returnInSub) return;
         new web.newpuesto(remoteHandle, context).execute( AV12CliCod, AV32SecCodigo, AV36PuestoCodigo, AV33PuestoDescrip, "", AV34PuestoHorasExt, AV15CliRelSec, (int)(AV13ClientePadre), AV36PuestoCodigo) ;
      }
   }

   public void S121( )
   {
      /* 'GET NUEVO ID' Routine */
      returnInSub = false ;
      AV37auxPuestoCodigo = AV36PuestoCodigo ;
      AV19i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV43GXLvl101 = (byte)(0) ;
         /* Using cursor P02976 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV12CliCod), AV32SecCodigo, AV37auxPuestoCodigo});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A1240PuestoCodigo = P02976_A1240PuestoCodigo[0] ;
            A13SecCodigo = P02976_A13SecCodigo[0] ;
            A3CliCod = P02976_A3CliCod[0] ;
            AV43GXLvl101 = (byte)(1) ;
            AV19i = (short)(AV19i+1) ;
            AV37auxPuestoCodigo = GXutil.trim( AV36PuestoCodigo) + "_" + GXutil.trim( GXutil.str( AV19i, 4, 0)) ;
            if ( GXutil.len( GXutil.trim( AV37auxPuestoCodigo)) > 6 )
            {
               GXt_char3 = AV37auxPuestoCodigo ;
               GXv_char4[0] = GXt_char3 ;
               new web.codigoaleatorio(remoteHandle, context).execute( (short)(6), GXv_char4) ;
               updatepuestos.this.GXt_char3 = GXv_char4[0] ;
               AV37auxPuestoCodigo = GXt_char3 ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         if ( AV43GXLvl101 == 0 )
         {
            AV31nuevoPuestoCodigo = AV37auxPuestoCodigo ;
         }
         if ( ! (GXutil.strcmp("", AV31nuevoPuestoCodigo)==0) )
         {
            if (true) break;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV19i, 4, 0))) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatepuestos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV40Pgmname = "" ;
      scmdbuf = "" ;
      P02972_A1987PuestoRelSec = new int[1] ;
      P02972_A3CliCod = new int[1] ;
      P02972_A1240PuestoCodigo = new String[] {""} ;
      P02972_A13SecCodigo = new String[] {""} ;
      P02972_A1241PuestoDescrip = new String[] {""} ;
      P02972_A1255PuestoHorasExt = new boolean[] {false} ;
      P02972_A2034PuestoOld = new String[] {""} ;
      A1240PuestoCodigo = "" ;
      A13SecCodigo = "" ;
      A1241PuestoDescrip = "" ;
      A2034PuestoOld = "" ;
      AV23CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV32SecCodigo = "" ;
      AV36PuestoCodigo = "" ;
      AV33PuestoDescrip = "" ;
      AV35puesto_old = new web.Sdtpuesto_old(remoteHandle, context);
      A1242PuestoDescripSinAc = "" ;
      P02973_A1989PuestoPadre = new String[] {""} ;
      P02973_A1988PuestoRelSecCli = new int[1] ;
      P02973_A13SecCodigo = new String[] {""} ;
      P02973_A3CliCod = new int[1] ;
      P02973_A1987PuestoRelSec = new int[1] ;
      P02973_A1241PuestoDescrip = new String[] {""} ;
      P02973_A1255PuestoHorasExt = new boolean[] {false} ;
      P02973_A1242PuestoDescripSinAc = new String[] {""} ;
      P02973_A1240PuestoCodigo = new String[] {""} ;
      A1989PuestoPadre = "" ;
      AV18hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV37auxPuestoCodigo = "" ;
      P02976_A1240PuestoCodigo = new String[] {""} ;
      P02976_A13SecCodigo = new String[] {""} ;
      P02976_A3CliCod = new int[1] ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV31nuevoPuestoCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatepuestos__default(),
         new Object[] {
             new Object[] {
            P02972_A1987PuestoRelSec, P02972_A3CliCod, P02972_A1240PuestoCodigo, P02972_A13SecCodigo, P02972_A1241PuestoDescrip, P02972_A1255PuestoHorasExt, P02972_A2034PuestoOld
            }
            , new Object[] {
            P02973_A1989PuestoPadre, P02973_A1988PuestoRelSecCli, P02973_A13SecCodigo, P02973_A3CliCod, P02973_A1987PuestoRelSec, P02973_A1241PuestoDescrip, P02973_A1255PuestoHorasExt, P02973_A1242PuestoDescripSinAc, P02973_A1240PuestoCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P02976_A1240PuestoCodigo, P02976_A13SecCodigo, P02976_A3CliCod
            }
         }
      );
      AV40Pgmname = "updatePuestos" ;
      /* GeneXus formulas. */
      AV40Pgmname = "updatePuestos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV41GXLvl4 ;
   private byte AV42GXLvl66 ;
   private byte AV43GXLvl101 ;
   private short AV19i ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15CliRelSec ;
   private int A1987PuestoRelSec ;
   private int A3CliCod ;
   private int A1988PuestoRelSecCli ;
   private long AV13ClientePadre ;
   private String AV40Pgmname ;
   private String scmdbuf ;
   private String A1240PuestoCodigo ;
   private String A13SecCodigo ;
   private String AV32SecCodigo ;
   private String AV36PuestoCodigo ;
   private String A1989PuestoPadre ;
   private String AV37auxPuestoCodigo ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String AV31nuevoPuestoCodigo ;
   private java.util.Date AV21padreReleaseDateTime ;
   private java.util.Date AV23CliRelease ;
   private java.util.Date AV18hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean A1255PuestoHorasExt ;
   private boolean AV22importar ;
   private boolean AV25liberacionPendiente ;
   private boolean AV24CliReHabilitado ;
   private boolean AV29alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean AV34PuestoHorasExt ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String A2034PuestoOld ;
   private String A1241PuestoDescrip ;
   private String AV33PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private IDataStoreProvider pr_default ;
   private int[] P02972_A1987PuestoRelSec ;
   private int[] P02972_A3CliCod ;
   private String[] P02972_A1240PuestoCodigo ;
   private String[] P02972_A13SecCodigo ;
   private String[] P02972_A1241PuestoDescrip ;
   private boolean[] P02972_A1255PuestoHorasExt ;
   private String[] P02972_A2034PuestoOld ;
   private String[] P02973_A1989PuestoPadre ;
   private int[] P02973_A1988PuestoRelSecCli ;
   private String[] P02973_A13SecCodigo ;
   private int[] P02973_A3CliCod ;
   private int[] P02973_A1987PuestoRelSec ;
   private String[] P02973_A1241PuestoDescrip ;
   private boolean[] P02973_A1255PuestoHorasExt ;
   private String[] P02973_A1242PuestoDescripSinAc ;
   private String[] P02973_A1240PuestoCodigo ;
   private String[] P02976_A1240PuestoCodigo ;
   private String[] P02976_A13SecCodigo ;
   private int[] P02976_A3CliCod ;
   private web.Sdtpuesto_old AV35puesto_old ;
}

final  class updatepuestos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02972( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV15CliRelSec ,
                                          int A1987PuestoRelSec ,
                                          long AV13ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[2];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT PuestoRelSec, CliCod, PuestoCodigo, SecCodigo, PuestoDescrip, PuestoHorasExt, PuestoOld FROM Puesto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV15CliRelSec) )
      {
         addWhere(sWhereString, "(PuestoRelSec = ?)");
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
                  return conditional_P02972(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02972", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02973", "SELECT PuestoPadre, PuestoRelSecCli, SecCodigo, CliCod, PuestoRelSec, PuestoDescrip, PuestoHorasExt, PuestoDescripSinAc, PuestoCodigo FROM Puesto WHERE (CliCod = ? and SecCodigo = ( ?)) AND (PuestoRelSecCli = ?) AND (PuestoPadre = ( ?)) ORDER BY CliCod, SecCodigo  LIMIT 1 FOR UPDATE OF Puesto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02974", "SAVEPOINT gxupdate;UPDATE Puesto SET PuestoRelSecCli=?, PuestoRelSec=?, PuestoDescrip=?, PuestoHorasExt=?, PuestoDescripSinAc=?  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02975", "SAVEPOINT gxupdate;UPDATE Puesto SET PuestoRelSecCli=?, PuestoRelSec=?, PuestoDescrip=?, PuestoHorasExt=?, PuestoDescripSinAc=?  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02976", "SELECT PuestoCodigo, SecCodigo, CliCod FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) and PuestoCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

