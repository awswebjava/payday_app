package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_ParValLista_sdt_ParValListaItem extends GxUserType
{
   public Sdtsdt_ParValLista_sdt_ParValListaItem( )
   {
      this(  new ModelContext(Sdtsdt_ParValLista_sdt_ParValListaItem.class));
   }

   public Sdtsdt_ParValLista_sdt_ParValListaItem( ModelContext context )
   {
      super( context, "Sdtsdt_ParValLista_sdt_ParValListaItem");
   }

   public Sdtsdt_ParValLista_sdt_ParValListaItem( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_ParValLista_sdt_ParValListaItem");
   }

   public Sdtsdt_ParValLista_sdt_ParValListaItem( StructSdtsdt_ParValLista_sdt_ParValListaItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "valor") )
            {
               gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "descripcion") )
            {
               gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParGrp") )
            {
               gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documentation") )
            {
               gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_ParValLista.sdt_ParValListaItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("valor", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("descripcion", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParGrp", GXutil.trim( GXutil.str( gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("documentation", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("valor", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor, false, false);
      AddObjectProperty("descripcion", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion, false, false);
      AddObjectProperty("CalParGrp", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp, false, false);
      AddObjectProperty("detail", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail, false, false);
      AddObjectProperty("documentation", gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation, false, false);
   }

   public String getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor ;
   }

   public void setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor = value ;
   }

   public String getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion ;
   }

   public void setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion = value ;
   }

   public byte getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp ;
   }

   public void setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp( byte value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp = value ;
   }

   public String getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail ;
   }

   public void setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail = value ;
   }

   public String getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation ;
   }

   public void setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( String value )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N = (byte)(1) ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail = "" ;
      gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N ;
   }

   public web.Sdtsdt_ParValLista_sdt_ParValListaItem Clone( )
   {
      return (web.Sdtsdt_ParValLista_sdt_ParValListaItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_ParValLista_sdt_ParValListaItem struct )
   {
      setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor(struct.getValor());
      setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion(struct.getDescripcion());
      setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp(struct.getCalpargrp());
      setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail(struct.getDetail());
      setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation(struct.getDocumentation());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_ParValLista_sdt_ParValListaItem getStruct( )
   {
      web.StructSdtsdt_ParValLista_sdt_ParValListaItem struct = new web.StructSdtsdt_ParValLista_sdt_ParValListaItem ();
      struct.setValor(getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor());
      struct.setDescripcion(getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion());
      struct.setCalpargrp(getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp());
      struct.setDetail(getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail());
      struct.setDocumentation(getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_N ;
   protected byte gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail ;
   protected String gxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation ;
}

