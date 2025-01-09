package web ;
import com.genexus.*;

public final  class StructSdtferiados_feriadosItem implements Cloneable, java.io.Serializable
{
   public StructSdtferiados_feriadosItem( )
   {
      this( -1, new ModelContext( StructSdtferiados_feriadosItem.class ));
   }

   public StructSdtferiados_feriadosItem( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_Sdtferiados_feriadosItem_Motivo = "" ;
      gxTv_Sdtferiados_feriadosItem_Tipo = "" ;
      gxTv_Sdtferiados_feriadosItem_Info = "" ;
      gxTv_Sdtferiados_feriadosItem_Dia = new java.math.BigDecimal(0) ;
      gxTv_Sdtferiados_feriadosItem_Mes = new java.math.BigDecimal(0) ;
      gxTv_Sdtferiados_feriadosItem_Id = "" ;
      gxTv_Sdtferiados_feriadosItem_Original = "" ;
      gxTv_Sdtferiados_feriadosItem_Religion = "" ;
      gxTv_Sdtferiados_feriadosItem_Origen = "" ;
      gxTv_Sdtferiados_feriadosItem_Convenio = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getMotivo( )
   {
      return gxTv_Sdtferiados_feriadosItem_Motivo ;
   }

   public void setMotivo( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Motivo = value ;
   }

   public String getTipo( )
   {
      return gxTv_Sdtferiados_feriadosItem_Tipo ;
   }

   public void setTipo( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Tipo = value ;
   }

   public String getInfo( )
   {
      return gxTv_Sdtferiados_feriadosItem_Info ;
   }

   public void setInfo( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Info = value ;
   }

   public java.math.BigDecimal getDia( )
   {
      return gxTv_Sdtferiados_feriadosItem_Dia ;
   }

   public void setDia( java.math.BigDecimal value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Dia = value ;
   }

   public java.math.BigDecimal getMes( )
   {
      return gxTv_Sdtferiados_feriadosItem_Mes ;
   }

   public void setMes( java.math.BigDecimal value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Mes = value ;
   }

   public String getId( )
   {
      return gxTv_Sdtferiados_feriadosItem_Id ;
   }

   public void setId( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Id = value ;
   }

   public String getOriginal( )
   {
      return gxTv_Sdtferiados_feriadosItem_Original ;
   }

   public void setOriginal( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Original = value ;
   }

   public String getReligion( )
   {
      return gxTv_Sdtferiados_feriadosItem_Religion ;
   }

   public void setReligion( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Religion = value ;
   }

   public String getOrigen( )
   {
      return gxTv_Sdtferiados_feriadosItem_Origen ;
   }

   public void setOrigen( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Origen = value ;
   }

   public String getConvenio( )
   {
      return gxTv_Sdtferiados_feriadosItem_Convenio ;
   }

   public void setConvenio( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Convenio = value ;
   }

   protected byte gxTv_Sdtferiados_feriadosItem_N ;
   protected String gxTv_Sdtferiados_feriadosItem_Motivo ;
   protected String gxTv_Sdtferiados_feriadosItem_Tipo ;
   protected String gxTv_Sdtferiados_feriadosItem_Info ;
   protected String gxTv_Sdtferiados_feriadosItem_Id ;
   protected String gxTv_Sdtferiados_feriadosItem_Original ;
   protected String gxTv_Sdtferiados_feriadosItem_Religion ;
   protected String gxTv_Sdtferiados_feriadosItem_Origen ;
   protected String gxTv_Sdtferiados_feriadosItem_Convenio ;
   protected java.math.BigDecimal gxTv_Sdtferiados_feriadosItem_Dia ;
   protected java.math.BigDecimal gxTv_Sdtferiados_feriadosItem_Mes ;
}

