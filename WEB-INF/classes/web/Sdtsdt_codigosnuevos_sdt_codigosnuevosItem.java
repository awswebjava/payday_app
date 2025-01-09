package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_codigosnuevos_sdt_codigosnuevosItem extends GxUserType
{
   public Sdtsdt_codigosnuevos_sdt_codigosnuevosItem( )
   {
      this(  new ModelContext(Sdtsdt_codigosnuevos_sdt_codigosnuevosItem.class));
   }

   public Sdtsdt_codigosnuevos_sdt_codigosnuevosItem( ModelContext context )
   {
      super( context, "Sdtsdt_codigosnuevos_sdt_codigosnuevosItem");
   }

   public Sdtsdt_codigosnuevos_sdt_codigosnuevosItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_codigosnuevos_sdt_codigosnuevosItem");
   }

   public Sdtsdt_codigosnuevos_sdt_codigosnuevosItem( StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodOld") )
            {
               gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo = oReader.getValue() ;
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
         sName = "sdt_codigosnuevos.sdt_codigosnuevosItem" ;
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
      oWriter.writeElement("ConCodOld", gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodigo", gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("ConCodOld", gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold, false, false);
      AddObjectProperty("ConCodigo", gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo, false, false);
   }

   public String getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold( )
   {
      return gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold ;
   }

   public void setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold( String value )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold = value ;
   }

   public String getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo( )
   {
      return gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo ;
   }

   public void setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo( String value )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold = "" ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N ;
   }

   public web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem Clone( )
   {
      return (web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem struct )
   {
      setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold(struct.getConcodold());
      setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo(struct.getConcodigo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem getStruct( )
   {
      web.StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem struct = new web.StructSdtsdt_codigosnuevos_sdt_codigosnuevosItem ();
      struct.setConcodold(getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold());
      struct.setConcodigo(getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold ;
   protected String gxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

