package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatebancos extends GXProcedure
{
   public updatebancos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatebancos.class ), "" );
   }

   public updatebancos( int remoteHandle ,
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
      updatebancos.this.AV14ClientePadre = aP0;
      updatebancos.this.AV13CliCod = aP1;
      updatebancos.this.AV16CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV22padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV14ClientePadre), AV16CliRelSec, GXv_dtime1) ;
      updatebancos.this.AV22padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV14ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV16CliRelSec, 6, 0))) ;
      AV35GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV16CliRelSec) ,
                                           Integer.valueOf(A1978BanRelSec) ,
                                           Long.valueOf(AV14ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01WT2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV14ClientePadre), Integer.valueOf(AV16CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1978BanRelSec = P01WT2_A1978BanRelSec[0] ;
         A3CliCod = P01WT2_A3CliCod[0] ;
         A7BanCod = P01WT2_A7BanCod[0] ;
         A116BanCUIT = P01WT2_A116BanCUIT[0] ;
         n116BanCUIT = P01WT2_n116BanCUIT[0] ;
         A117BanDescrip = P01WT2_A117BanDescrip[0] ;
         A118BanHabilitado = P01WT2_A118BanHabilitado[0] ;
         A2024BancoOld = P01WT2_A2024BancoOld[0] ;
         AV35GXLvl4 = (byte)(1) ;
         AV23importar = false ;
         AV26liberacionPendiente = false ;
         if ( ! (0==AV16CliRelSec) )
         {
            AV23importar = true ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "bancod ", "")+GXutil.trim( A7BanCod)+httpContext.getMessage( " BanRelSec ", "")+GXutil.trim( GXutil.str( A1978BanRelSec, 6, 0))) ;
            if ( (0==A1978BanRelSec) )
            {
               AV23importar = true ;
            }
            else
            {
               GXv_dtime1[0] = AV24CliRelease ;
               GXv_boolean2[0] = AV25CliReHabilitado ;
               new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A1978BanRelSec, GXv_dtime1, GXv_boolean2) ;
               updatebancos.this.AV24CliRelease = GXv_dtime1[0] ;
               updatebancos.this.AV25CliReHabilitado = GXv_boolean2[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV25CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV24CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
               if ( ( AV25CliReHabilitado ) && (( AV24CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV24CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
               {
                  AV23importar = true ;
               }
               else
               {
                  GXv_boolean2[0] = AV30alguienYaActualizo ;
                  new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1978BanRelSec, GXv_boolean2) ;
                  updatebancos.this.AV30alguienYaActualizo = GXv_boolean2[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV30alguienYaActualizo))) ;
                  if ( AV30alguienYaActualizo )
                  {
                     AV23importar = true ;
                  }
                  else
                  {
                     AV26liberacionPendiente = true ;
                  }
               }
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV23importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV26liberacionPendiente))) ;
         if ( AV23importar )
         {
            AV10BanCod = A7BanCod ;
            AV8BanCUIT = A116BanCUIT ;
            AV11BanDescrip = A117BanDescrip ;
            AV12BanHabilitado = A118BanHabilitado ;
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
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "vengo", "")) ;
            if ( AV26liberacionPendiente )
            {
               if ( ! (GXutil.strcmp("", A2024BancoOld)==0) )
               {
                  AV10BanCod = A7BanCod ;
                  AV29banco_old.fromJSonString(GXutil.trim( A2024BancoOld), null);
                  AV8BanCUIT = AV29banco_old.getgxTv_Sdtbanco_old_Bancuit() ;
                  AV11BanDescrip = AV29banco_old.getgxTv_Sdtbanco_old_Bandescrip() ;
                  AV12BanHabilitado = AV29banco_old.getgxTv_Sdtbanco_old_Banhabilitado() ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&BanDescrip old ", "")+GXutil.trim( AV11BanDescrip)) ;
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
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, "4") ;
      AV36GXLvl67 = (byte)(0) ;
      /* Using cursor P01WT3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Long.valueOf(AV14ClientePadre), AV10BanCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1980BancodPadre = P01WT3_A1980BancodPadre[0] ;
         A1979BanRelSecCli = P01WT3_A1979BanRelSecCli[0] ;
         A3CliCod = P01WT3_A3CliCod[0] ;
         A1978BanRelSec = P01WT3_A1978BanRelSec[0] ;
         A117BanDescrip = P01WT3_A117BanDescrip[0] ;
         A118BanHabilitado = P01WT3_A118BanHabilitado[0] ;
         A116BanCUIT = P01WT3_A116BanCUIT[0] ;
         n116BanCUIT = P01WT3_n116BanCUIT[0] ;
         A679BanDescripSinAc = P01WT3_A679BanDescripSinAc[0] ;
         A7BanCod = P01WT3_A7BanCod[0] ;
         AV36GXLvl67 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, "5") ;
         if ( ! (0==AV16CliRelSec) )
         {
            GXv_dtime1[0] = AV19hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1978BanRelSec, GXv_dtime1) ;
            updatebancos.this.AV19hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, "6") ;
            if ( AV22padreReleaseDateTime.after( AV19hijoReleaseDateTime ) )
            {
               A117BanDescrip = AV11BanDescrip ;
               A118BanHabilitado = AV12BanHabilitado ;
               A116BanCUIT = AV8BanCUIT ;
               n116BanCUIT = false ;
               GXt_char3 = A679BanDescripSinAc ;
               GXv_char4[0] = GXt_char3 ;
               new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char4) ;
               updatebancos.this.GXt_char3 = GXv_char4[0] ;
               A679BanDescripSinAc = GXt_char3 ;
               A1978BanRelSec = AV16CliRelSec ;
               A1979BanRelSecCli = (int)(AV14ClientePadre) ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01WT4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A1979BanRelSecCli), Integer.valueOf(A1978BanRelSec), A117BanDescrip, Boolean.valueOf(A118BanHabilitado), Boolean.valueOf(n116BanCUIT), A116BanCUIT, A679BanDescripSinAc, Integer.valueOf(A3CliCod), A7BanCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
         if (true) break;
         /* Using cursor P01WT5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1979BanRelSecCli), Integer.valueOf(A1978BanRelSec), A117BanDescrip, Boolean.valueOf(A118BanHabilitado), Boolean.valueOf(n116BanCUIT), A116BanCUIT, A679BanDescripSinAc, Integer.valueOf(A3CliCod), A7BanCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV36GXLvl67 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV26liberacionPendiente))) ;
         /* Execute user subroutine: 'GET NUEVO ID' */
         S121 ();
         if (returnInSub) return;
         new web.newbanco(remoteHandle, context).execute( AV13CliCod, AV21nuevoBanCod, AV11BanDescrip, AV8BanCUIT, AV12BanHabilitado, (int)(AV14ClientePadre), AV10BanCod, AV16CliRelSec) ;
      }
   }

   public void S121( )
   {
      /* 'GET NUEVO ID' Routine */
      returnInSub = false ;
      AV9auxBanCod = AV10BanCod ;
      AV20i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV37GXLvl102 = (byte)(0) ;
         /* Using cursor P01WT6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV13CliCod), AV9auxBanCod});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A7BanCod = P01WT6_A7BanCod[0] ;
            A3CliCod = P01WT6_A3CliCod[0] ;
            AV37GXLvl102 = (byte)(1) ;
            AV20i = (short)(AV20i+1) ;
            AV9auxBanCod = GXutil.trim( AV10BanCod) + "_" + GXutil.trim( GXutil.str( AV20i, 4, 0)) ;
            if ( GXutil.len( GXutil.trim( AV9auxBanCod)) > 6 )
            {
               GXt_char3 = AV9auxBanCod ;
               GXv_char4[0] = GXt_char3 ;
               new web.codigoaleatorio(remoteHandle, context).execute( (short)(6), GXv_char4) ;
               updatebancos.this.GXt_char3 = GXv_char4[0] ;
               AV9auxBanCod = GXt_char3 ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         if ( AV37GXLvl102 == 0 )
         {
            AV21nuevoBanCod = AV9auxBanCod ;
         }
         if ( ! (GXutil.strcmp("", AV21nuevoBanCod)==0) )
         {
            if (true) break;
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatebancos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV34Pgmname = "" ;
      scmdbuf = "" ;
      P01WT2_A1978BanRelSec = new int[1] ;
      P01WT2_A3CliCod = new int[1] ;
      P01WT2_A7BanCod = new String[] {""} ;
      P01WT2_A116BanCUIT = new String[] {""} ;
      P01WT2_n116BanCUIT = new boolean[] {false} ;
      P01WT2_A117BanDescrip = new String[] {""} ;
      P01WT2_A118BanHabilitado = new boolean[] {false} ;
      P01WT2_A2024BancoOld = new String[] {""} ;
      A7BanCod = "" ;
      A116BanCUIT = "" ;
      A117BanDescrip = "" ;
      A2024BancoOld = "" ;
      AV24CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV10BanCod = "" ;
      AV8BanCUIT = "" ;
      AV11BanDescrip = "" ;
      AV29banco_old = new web.Sdtbanco_old(remoteHandle, context);
      A679BanDescripSinAc = "" ;
      P01WT3_A1980BancodPadre = new String[] {""} ;
      P01WT3_A1979BanRelSecCli = new int[1] ;
      P01WT3_A3CliCod = new int[1] ;
      P01WT3_A1978BanRelSec = new int[1] ;
      P01WT3_A117BanDescrip = new String[] {""} ;
      P01WT3_A118BanHabilitado = new boolean[] {false} ;
      P01WT3_A116BanCUIT = new String[] {""} ;
      P01WT3_n116BanCUIT = new boolean[] {false} ;
      P01WT3_A679BanDescripSinAc = new String[] {""} ;
      P01WT3_A7BanCod = new String[] {""} ;
      A1980BancodPadre = "" ;
      AV19hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV21nuevoBanCod = "" ;
      AV9auxBanCod = "" ;
      P01WT6_A7BanCod = new String[] {""} ;
      P01WT6_A3CliCod = new int[1] ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatebancos__default(),
         new Object[] {
             new Object[] {
            P01WT2_A1978BanRelSec, P01WT2_A3CliCod, P01WT2_A7BanCod, P01WT2_A116BanCUIT, P01WT2_n116BanCUIT, P01WT2_A117BanDescrip, P01WT2_A118BanHabilitado, P01WT2_A2024BancoOld
            }
            , new Object[] {
            P01WT3_A1980BancodPadre, P01WT3_A1979BanRelSecCli, P01WT3_A3CliCod, P01WT3_A1978BanRelSec, P01WT3_A117BanDescrip, P01WT3_A118BanHabilitado, P01WT3_A116BanCUIT, P01WT3_n116BanCUIT, P01WT3_A679BanDescripSinAc, P01WT3_A7BanCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01WT6_A7BanCod, P01WT6_A3CliCod
            }
         }
      );
      AV34Pgmname = "updateBancos" ;
      /* GeneXus formulas. */
      AV34Pgmname = "updateBancos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV35GXLvl4 ;
   private byte AV36GXLvl67 ;
   private byte AV37GXLvl102 ;
   private short AV20i ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV16CliRelSec ;
   private int A1978BanRelSec ;
   private int A3CliCod ;
   private int A1979BanRelSecCli ;
   private long AV14ClientePadre ;
   private String AV34Pgmname ;
   private String scmdbuf ;
   private String A7BanCod ;
   private String A116BanCUIT ;
   private String AV10BanCod ;
   private String AV8BanCUIT ;
   private String A1980BancodPadre ;
   private String AV21nuevoBanCod ;
   private String AV9auxBanCod ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private java.util.Date AV22padreReleaseDateTime ;
   private java.util.Date AV24CliRelease ;
   private java.util.Date AV19hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean n116BanCUIT ;
   private boolean A118BanHabilitado ;
   private boolean AV23importar ;
   private boolean AV26liberacionPendiente ;
   private boolean AV25CliReHabilitado ;
   private boolean AV30alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean AV12BanHabilitado ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String A2024BancoOld ;
   private String A117BanDescrip ;
   private String AV11BanDescrip ;
   private String A679BanDescripSinAc ;
   private IDataStoreProvider pr_default ;
   private int[] P01WT2_A1978BanRelSec ;
   private int[] P01WT2_A3CliCod ;
   private String[] P01WT2_A7BanCod ;
   private String[] P01WT2_A116BanCUIT ;
   private boolean[] P01WT2_n116BanCUIT ;
   private String[] P01WT2_A117BanDescrip ;
   private boolean[] P01WT2_A118BanHabilitado ;
   private String[] P01WT2_A2024BancoOld ;
   private String[] P01WT3_A1980BancodPadre ;
   private int[] P01WT3_A1979BanRelSecCli ;
   private int[] P01WT3_A3CliCod ;
   private int[] P01WT3_A1978BanRelSec ;
   private String[] P01WT3_A117BanDescrip ;
   private boolean[] P01WT3_A118BanHabilitado ;
   private String[] P01WT3_A116BanCUIT ;
   private boolean[] P01WT3_n116BanCUIT ;
   private String[] P01WT3_A679BanDescripSinAc ;
   private String[] P01WT3_A7BanCod ;
   private String[] P01WT6_A7BanCod ;
   private int[] P01WT6_A3CliCod ;
   private web.Sdtbanco_old AV29banco_old ;
}

final  class updatebancos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01WT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV16CliRelSec ,
                                          int A1978BanRelSec ,
                                          long AV14ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[2];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT BanRelSec, CliCod, BanCod, BanCUIT, BanDescrip, BanHabilitado, BancoOld FROM Banco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV16CliRelSec) )
      {
         addWhere(sWhereString, "(BanRelSec = ?)");
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
                  return conditional_P01WT2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01WT3", "SELECT BancodPadre, BanRelSecCli, CliCod, BanRelSec, BanDescrip, BanHabilitado, BanCUIT, BanDescripSinAc, BanCod FROM Banco WHERE (CliCod = ?) AND (BanRelSecCli = ?) AND (BancodPadre = ( ?)) ORDER BY CliCod  LIMIT 1 FOR UPDATE OF Banco",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WT4", "SAVEPOINT gxupdate;UPDATE Banco SET BanRelSecCli=?, BanRelSec=?, BanDescrip=?, BanHabilitado=?, BanCUIT=?, BanDescripSinAc=?  WHERE CliCod = ? AND BanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01WT5", "SAVEPOINT gxupdate;UPDATE Banco SET BanRelSecCli=?, BanRelSec=?, BanDescrip=?, BanHabilitado=?, BanCUIT=?, BanDescripSinAc=?  WHERE CliCod = ? AND BanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01WT6", "SELECT BanCod, CliCod FROM Banco WHERE CliCod = ? and BanCod = ( ?) ORDER BY CliCod, BanCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((String[]) buf[3])[0] = rslt.getString(4, 13);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
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
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 13);
               }
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setString(8, (String)parms[8], 6);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 13);
               }
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setString(8, (String)parms[8], 6);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

