package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_control_parametros_sdt_control_parametrosItem extends GxUserType
{
   public Sdtsdt_control_parametros_sdt_control_parametrosItem( )
   {
      this(  new ModelContext(Sdtsdt_control_parametros_sdt_control_parametrosItem.class));
   }

   public Sdtsdt_control_parametros_sdt_control_parametrosItem( ModelContext context )
   {
      super( context, "Sdtsdt_control_parametros_sdt_control_parametrosItem");
   }

   public Sdtsdt_control_parametros_sdt_control_parametrosItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_control_parametros_sdt_control_parametrosItem");
   }

   public Sdtsdt_control_parametros_sdt_control_parametrosItem( StructSdtsdt_control_parametros_sdt_control_parametrosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParPalabra") )
            {
               gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParGrp") )
            {
               gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParValLista") )
            {
               gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista = oReader.getValue() ;
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
         sName = "sdt_control_parametros.sdt_control_parametrosItem" ;
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
      oWriter.writeElement("CalParPalabra", gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParGrp", GXutil.trim( GXutil.str( gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParValLista", gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista);
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
      AddObjectProperty("CalParPalabra", gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra, false, false);
      AddObjectProperty("CalParGrp", gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp, false, false);
      AddObjectProperty("CalParValLista", gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista, false, false);
   }

   public String getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra ;
   }

   public void setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra( String value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra = value ;
   }

   public byte getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp ;
   }

   public void setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp( byte value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp = value ;
   }

   public String getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista ;
   }

   public void setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista( String value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra = "" ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N ;
   }

   public web.Sdtsdt_control_parametros_sdt_control_parametrosItem Clone( )
   {
      return (web.Sdtsdt_control_parametros_sdt_control_parametrosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_control_parametros_sdt_control_parametrosItem struct )
   {
      setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra(struct.getCalparpalabra());
      setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp(struct.getCalpargrp());
      setgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista(struct.getCalparvallista());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_control_parametros_sdt_control_parametrosItem getStruct( )
   {
      web.StructSdtsdt_control_parametros_sdt_control_parametrosItem struct = new web.StructSdtsdt_control_parametros_sdt_control_parametrosItem ();
      struct.setCalparpalabra(getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra());
      struct.setCalpargrp(getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp());
      struct.setCalparvallista(getgxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N ;
   protected byte gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista ;
}

