package web ;
import com.genexus.*;

public final  class StructSdtsdt_ParValLista_sdt_ParValListaItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_ParValLista_sdt_ParValListaItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_ParValLista_sdt_ParValListaItem.class ));
   }

   public StructSdtsdt_ParValLista_sdt_ParValListaItem( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation = "" ;
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

   public String getValor( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor ;
   }

   public void setValor( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion = value ;
   }

   public byte getCalpargrp( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp ;
   }

   public void setCalpargrp( byte value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp = value ;
   }

   public String getDetail( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail ;
   }

   public void setDetail( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail = value ;
   }

   public String getDocumentation( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation ;
   }

   public void setDocumentation( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation = value ;
   }

   protected byte gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp ;
   protected byte gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation ;
}

